package com.digitel.restFull.ws.configuration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtUtil {
	
	//metodo para crear el jwt y enviarlo al cliente en el header de la respuesta
	static void addAuthentication(HttpServletResponse res, String username) {
		
		String token = Jwts.builder().setSubject(username)
		
		//se asigna un tiempo de espera en el minuterode expiracion
		//hash con el que se firma la clave
		
		.signWith(SignatureAlgorithm.HS512, "C@lt0").compact();
		
		//se agrega el encabezado del token
		res.addHeader("Authorization","Bearer" + token);
		
	}
	
	//metodo para validar el token enviado por el usuario
	static Authentication getAuthentication(HttpServletRequest request) {
		
		//se obtiene el token que viene en el encabezado de la peticion
		String token = request.getHeader("Authorization");
		
		//si hay un token presente entonces se valida
		if(token != null) {
			
			String user = Jwts.parser()
					.setSigningKey("C@lt0")
					.parseClaimsJws(token.replace("Bearer", ""))//este es el metodo que la valida
					.getBody()
					.getSubject();
			
			return user != null?
					new UsernamePasswordAuthenticationToken(user, null, emptyList()):
						null;
			
		}
		
		return null;
		
	}


}
