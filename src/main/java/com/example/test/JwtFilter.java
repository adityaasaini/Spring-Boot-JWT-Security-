package com.example.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class JwtFilter extends OncePerRequestFilter {

	@Autowired
	private JwtGenerator jwtGenerator;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		String authHeader=request.getHeader("Authorization");
		
		if(authHeader != null && authHeader.startsWith("Bearer ")) { 
			//TOKEN PARSENT; // TOKEN CHAKING HERE.....
			String token=authHeader.substring(7);	
			//IS TOKEN XPIRE	
			if(! jwtGenerator.isExpired(token)) {
				//TOKEN IS ALIVE
				String username = jwtGenerator.getUsername(token);
				List<String> allRoles = jwtGenerator.getAllRoles(token);
				ArrayList<SimpleGrantedAuthority> arrayList = new ArrayList<SimpleGrantedAuthority>();
				
				if (allRoles != null) {
					for(String role : allRoles) {   
					    arrayList.add(new SimpleGrantedAuthority(role));
					}
				}
				UsernamePasswordAuthenticationToken up =
						new UsernamePasswordAuthenticationToken(username, null, arrayList);
				SecurityContextHolder.getContext().setAuthentication(up);
			}
			}
		filterChain.doFilter(request, response);
			
		}
	}