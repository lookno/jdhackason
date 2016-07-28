package com.jd.hackason.controller;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import org.json.JSONArray;
import java.sql.*;
import java.util.ArrayList;

public class ConnectMysql {

	public static final String SENTIMENT_URL = "http://api.bosonnlp.com/sentiment/analysis";

	public static void addSen() {

		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://172.16.28.253:3306/jdstar";
		String user = "root";
		String password = "yongsheng";
		Double averScore = 0.0;
		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, user, password);
			if (!conn.isClosed())
				System.out.println("Succeeded connecting to the Database!");

			// 读取pro_comment表content和id字段
			Statement statement = conn.createStatement();
			String query = "select * from pro_comment order by id desc";
			ResultSet rs = statement.executeQuery(query);
			// ArrayList<String> comment = new ArrayList<String>();
			// ArrayList<Integer> ids = new ArrayList<Integer>();
			
			String comment = null;
			int id = 0;
			while (rs.next()) {
				comment = rs.getString("content");
				id = rs.getInt("id");
			}

			HttpResponse<JsonNode> jsonResponse = Unirest.post(SENTIMENT_URL).header("Accept", "application/json")
					.header("X-Token", "fxy59Ea3.8745.bbKk5ZUkXTNp").body(comment).asJson();

			
			JSONArray commentScore = jsonResponse.getBody().getArray();
			
//			
//			for (int i = 0; i < commentScore.length(); i++) {
//				averScore = averScore + (double) commentScore.getJSONArray(i).get(0);
//			}
//			averScore = averScore / commentScore.length();
//			System.out.println(averScore);

			// sen字段写入数据库
			Statement insert = conn.createStatement();
//			for (int i = 0; i < commentScore.length(); i++) {
//				insert.executeUpdate(
//						"UPDATE pro_comment SET sen = " + commentScore.getJSONArray(i).get(0) + "where id = " + i + "");
//							}
			
			insert.executeUpdate("update pro_comment set sen="+commentScore.get(0)+" where id = "+id+"");
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