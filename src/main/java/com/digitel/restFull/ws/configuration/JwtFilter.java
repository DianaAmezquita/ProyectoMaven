package com.digitel.restFull.ws.configuration;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

//las peticiones que no sean login pasan por este filtro
//el cual se encarga de pasar el request anuestra clase de utilidades jwtutil
//para validar el token



public class JwtFilter extends GenericFilterBean{
	
	@Override
	public void doFilter(ServletRequest request,ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		
		Authentication authentication = JwtUtil.getAuthentication((HttpServletRequest)request);
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		filterChain.doFilter(request, response);
		
	}

}
