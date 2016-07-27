package com.jd.hackason.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.jd.hackason.bean.User;
import com.jd.hackason.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Resource
	private IUserService iUserService;
	@RequestMapping(value = "/login.action", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public ResponseEntity<Object> login(@RequestBody User user) throws Exception {
		int u = iUserService.login(user);
		Map<String,Object> m=new HashMap<String,Object>();
		if(u==1) {
			m.put("success", 200);
			ServletRequestAttributes attrs=(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
			HttpSession session=attrs.getRequest().getSession();
			session.setAttribute("user", user.getName());
		}
		else m.put("success", 400);
		return new ResponseEntity<Object>(m,HttpStatus.OK);

	}

	@RequestMapping(value = "/test", method = RequestMethod.GET, produces = "application/json", consumes = "application/json")
	public ResponseEntity<Object> test() throws Exception {
		System.out.println(123456);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
