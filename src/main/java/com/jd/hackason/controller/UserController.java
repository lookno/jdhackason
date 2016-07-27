package com.jd.hackason.controller;

import javax.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.jd.hackason.bean.User;
import com.jd.hackason.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Resource
	private IUserService iUserService;

	@RequestMapping(value = "/login.action", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public ResponseEntity<Object> login(@RequestBody User user) throws Exception {
		System.out.println();
		User u = iUserService.login(user);
		System.out.println(u);
		return new ResponseEntity<Object>(u, HttpStatus.OK);

		/*
		 * Map<String, Object> map = new HashMap<>(); map.put("pos", "3");
		 * map.put("msg", "用户类型错误"); return new ResponseEntity<Object>(map,
		 * HttpStatus.BAD_REQUEST);
		 */
	}

	@RequestMapping(value = "/test", method = RequestMethod.GET, produces = "application/json", consumes = "application/json")
	public ResponseEntity<Object> test() throws Exception {
		System.out.println(123456);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
