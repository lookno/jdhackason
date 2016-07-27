package com.jd.hackason.filter;

import org.springframework.stereotype.Component;

import com.jd.hackason.service.ITokenService;
import com.jd.hackason.service.IUserService;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.annotation.Resource;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class SecurityFilter implements Filter {
	@Resource
	private ITokenService iTokenService;
	@Resource
	private IUserService iUserService;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest hRequest = (HttpServletRequest) request;
		HttpServletResponse hresponse = (HttpServletResponse) response;
		String uri = hRequest.getRequestURI();
		System.out.println(uri);
		if (uri.startsWith("/user/login.action")) {
			chain.doFilter(request, hresponse);
			return;
		} else {
			String token = hRequest.getHeader("HTTP_TOKEN");
			if (token == null) {
				hresponse.setContentType("application/json");
				hresponse.getWriter().write("{\"msg\":\"请登录\"}");
				return;
			}

		}

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
