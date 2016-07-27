package com.jd.hackason.controller;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.jd.hackason.bean.ProComment;
import com.jd.hackason.dto.ProCommentDto;
import com.jd.hackason.service.IProCommentService;

@RestController
@RequestMapping("procomment")
public class ProCommentController {
	@Resource
	private IProCommentService iProCommentService;

	@RequestMapping(value = "/select.action", method = RequestMethod.GET, produces = "application/json", consumes = "application/json")
	public ResponseEntity<Object> login(@ModelAttribute ProCommentDto proCommentDto) throws Exception {
		List<ProComment> lists = iProCommentService.select(proCommentDto);
		System.out.println(lists);
		return new ResponseEntity<Object>(lists, HttpStatus.OK);

	}
}
