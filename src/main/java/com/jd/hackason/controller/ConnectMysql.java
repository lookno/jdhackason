package com.jd.hackason.controller;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import org.json.JSONArray;
import java.sql.*;

public class ConnectMysql {

	public static final String SENTIMENT_URL = "http://api.bosonnlp.com/sentiment/analysis";

	public static void addSen() {

		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://172.16.28.253:3306/jdstar";
		String user = "root";
		String password = "yongsheng";
		String body = new JSONArray(new String[] { "他是个傻逼" }).toString();
		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, user, password);
			if (!conn.isClosed())
				System.out.println("Succeeded connecting to the Database!");

			// 读取pro_comment表content和id字段
			Statement statement = conn.createStatement();
			String query = "select * from pro_comment order by id desc limit 1";
			ResultSet rs = statement.executeQuery(query);
			String commentTmp = null;
			int id = 0;
			while (rs.next()) {
				commentTmp = rs.getString("content");
				id = rs.getInt("id");
			}
			System.out.println(commentTmp);

			String comment = new JSONArray(new String[] { commentTmp }).toString();
			HttpResponse<JsonNode> jsonResponse = Unirest.post(SENTIMENT_URL).header("Accept", "application/json")
					.header("X-Token", "fxy59Ea3.8745.bbKk5ZUkXTNp").body(comment).asJson();
			System.out.println(jsonResponse.getBody());

			JSONArray commentScore = jsonResponse.getBody().getArray();
			Double score = (double) commentScore.getJSONArray(0).get(0);
			// sen字段写入数据库
			Statement insert = conn.createStatement();
			for (int i = 0; i < commentScore.length(); i++) {
				insert.executeUpdate("UPDATE pro_comment SET sen = " + score + "where id = " + id + "");
			}
			rs.close();
			conn.close();

		} catch (ClassNotFoundException e) {
			System.out.println("Sorry,can`t find the Driver!");
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}