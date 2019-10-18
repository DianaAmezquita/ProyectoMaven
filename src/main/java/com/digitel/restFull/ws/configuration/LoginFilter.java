package com.digitel.restFull.ws.configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;

public class LoginFilter extends AbstractAuthenticationProcessingFilter{

	public LoginFilter(String url, AuthenticationManager authManager) {
		
		super(new AntPathRequestMatcher(url));
		setAuthenticationManager(authManager);
		
	}
	
	@Override
	public Authentication attemptAuthentication(
			HttpServletRequest req, 
			HttpServletResponse res) 
					throws AuthenticationException, 
					IOException, ServletException{
		
		InputStream body = req.getInputStream();
		
		Usuario user = new ObjectMapper().readValue(body, Usuario.class);
		
		return getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(
				user.getUsuario(),
				user.getContrasena(),
				Collections.emptyList()
				)
		);
	}
	
	@Override
	public void successfulAuthentication(
			
			HttpServletRequest req,
			HttpServletResponse res, FilterChain chain,
			Authentication auth) throws IOException, ServletException{
		
		JwtUtil.addAuthentication(res,auth.getName());
	}

}
