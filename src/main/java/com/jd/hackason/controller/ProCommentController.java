package com.jd.hackason.controller;

import java.io.IOException;
import java.io.StringReader;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.json.JSONArray;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.wltea.analyzer.lucene.IKAnalyzer;

import com.jd.hackason.bean.DispatchComment;
import com.jd.hackason.bean.ProComment;
import com.jd.hackason.bean.Pro_com_label;
import com.jd.hackason.dto.DetailJudge;
import com.jd.hackason.dto.ProCommentDto;
import com.jd.hackason.dto.StarAndLabelDto;
import com.jd.hackason.service.IDispatchCommentService;
import com.jd.hackason.service.IProCommentService;
import com.jd.hackason.service.IPro_com_labelService;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;

@RestController
@RequestMapping("/procomment")
public class ProCommentController {
	public static final String SENTIMENT_URL = "http://api.bosonnlp.com/sentiment/analysis";
	@Resource
	private IProCommentService iProCommentService;
	@Resource
	private IDispatchCommentService idispatchCommentService;
	@Resource
	private IPro_com_labelService ipro_com_labelService;

	@RequestMapping(value = "/select.action", method = RequestMethod.GET, produces = "application/json", consumes = "application/json")
	public ResponseEntity<Object> select(@ModelAttribute ProCommentDto proCommentDto) throws Exception {
		List<ProComment> lists = iProCommentService.select(proCommentDto);
		System.out.println(lists);
		return new ResponseEntity<Object>(lists, HttpStatus.OK);
	}

	@RequestMapping(value = "/label.action", method = RequestMethod.GET, produces = "application/json", consumes = "application/json")
	public ResponseEntity<Object> getLabelInfo(@RequestParam int pro_id) throws Exception {
		List<Pro_com_label> lists = ipro_com_labelService.getLabelInfo(pro_id);
		System.out.println(lists);
		return new ResponseEntity<Object>(lists, HttpStatus.OK);
	}

	@RequestMapping(value = "/label.action", method = RequestMethod.GET, produces = "application/json", consumes = "application/json")
	public ResponseEntity<Object> getDisplayNum(@RequestParam int pro_id) throws Exception {
		List<Integer> lists = new ArrayList<>();
		lists.add(iProCommentService.getNum(pro_id));
		lists.add(iProCommentService.getPicInfo(pro_id));
		lists.add(iProCommentService.getGoodInfo(pro_id));
		lists.add(iProCommentService.getMidInfo(pro_id));
		lists.add(iProCommentService.getBadInfo(pro_id));
		lists.add(iProCommentService.getAddContentInfo(pro_id));

		return new ResponseEntity<Object>(lists, HttpStatus.OK);
	}

	@RequestMapping(value = "/getRate.action", method = RequestMethod.GET, produces = "application/json", consumes = "application/json")
	public ResponseEntity<Object> getRate(@RequestParam int pro_id) throws Exception {
		List<Double> lists = new ArrayList<>();
		int sum = iProCommentService.getNum(pro_id);
		lists.add((double) iProCommentService.getGoodInfo(pro_id) / (double) sum);
		lists.add((double) iProCommentService.getMidInfo(pro_id) / (double) sum);
		lists.add((double) iProCommentService.getBadInfo(pro_id) / (double) sum);
		return new ResponseEntity<Object>(lists, HttpStatus.OK);
	}

	@RequestMapping(value = "/add.action", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public ResponseEntity<Object> add(@RequestBody DetailJudge detailJudge) throws Exception {
		String comm = detailJudge.getContent();
		if (!filt(comm)) {
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
		DispatchComment dispatchComment = new DispatchComment();
		dispatchComment.setPack_star(detailJudge.getPack_star());
		dispatchComment.setExpress_star(detailJudge.getExpress_star());
		dispatchComment.setAttitude_star(detailJudge.getAttitude_star());
		dispatchComment.setUser_id(1);
		dispatchComment.setOrder_id(1);
		Calendar calendar = Calendar.getInstance();
		Date date = new Date();
		calendar.setTime(date);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = format.format(calendar.getTime());
		dispatchComment.setDt(time);
		idispatchCommentService.insert(dispatchComment);
		ProComment proComment = new ProComment();
		proComment.setPro_id(1);
		proComment.setUser_id(1);
		proComment.setOrder_id(1);
		proComment.setStar(detailJudge.getStar());
		proComment.setContent(detailJudge.getContent());
		proComment.setImage(detailJudge.getImge());
		proComment.setDt(time);
		iProCommentService.insert(proComment);
		ConnectMysql.addSen();

		ipro_com_labelService.update_table(detailJudge.getLabel_names());
		return new ResponseEntity<Object>(iProCommentService.avarageOfSen(), HttpStatus.OK);
	}

	public boolean filt(String text) throws IOException {

		String keywords = "习近平";
		Analyzer anal = new IKAnalyzer(true);
		StringReader reader = new StringReader(text);
		TokenStream ts = anal.tokenStream("", reader);
		CharTermAttribute term = ts.getAttribute(CharTermAttribute.class);
		ArrayList<String> words = new ArrayList<>();
		while (ts.incrementToken()) {
			words.add(term.toString());
		}
		reader.close();
		if (words.contains(keywords)) {
			return false;
		}
		return true;

	}
}
