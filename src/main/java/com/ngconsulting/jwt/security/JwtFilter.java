package com.ngconsulting.jwt.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class JwtFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException{
	 HttpServletRequest serveletRequest = (HttpServletRequest) request;
	 String authorization = serveletRequest.getHeader("Authorization");
	 if(authorization != null){
		 JwtAuthToken jwtAuthToken = new JwtAuthToken(authorization.replaceAll("Bearer", ""));
		 SecurityContextHolder.getContext().setAuthentication(jwtAuthToken);
	 }
	 chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
