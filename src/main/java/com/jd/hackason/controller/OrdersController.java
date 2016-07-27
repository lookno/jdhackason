package com.jd.hackason.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;


import com.jd.hackason.bean.DispatchComment;
import com.jd.hackason.bean.ProComment;

import com.jd.hackason.dto.StarAndLabelDto;
import com.jd.hackason.service.IDispatchCommentService;
import com.jd.hackason.service.IProCommentService;
import com.jd.hackason.service.IPro_com_labelService;


@RestController
@RequestMapping("/orders")
public class OrdersController {
	@Resource
	private IProCommentService iproCommentService;
	@Resource
	private IDispatchCommentService idispatchCommentService;
	@Resource
	private IPro_com_labelService ipro_com_labelService;
	@RequestMapping(value = "/submit_comment.action", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public ResponseEntity<Object> submit_comment(@RequestBody StarAndLabelDto starAndLabelDto) throws Exception {
		ProComment proComment=new ProComment();
		DispatchComment dis=new DispatchComment();
		proComment.setPro_id(1);
		proComment.setUser_id(1);
		proComment.setOrder_id(1);
		proComment.setStar(starAndLabelDto.getStar());
		Calendar calendar=Calendar.getInstance();
		Date date=new Date();
		calendar.setTime(date);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = format.format(calendar.getTime());
		proComment.setDt(time);
		iproCommentService.insert(proComment);
		
		dis.setUser_id(1);
		dis.setOrder_id(1);
		dis.setDt(time);
		dis.setPack_star(proComment.getStar());
		dis.setExpress_star(proComment.getStar());
		dis.setAttitude_star(proComment.getStar());
		
		idispatchCommentService.insert(dis);
		ipro_com_labelService.update_table(starAndLabelDto.getLabel_names());
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
