package com.example.test.Controler;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.test.JwtGenerator;
import com.example.test.payload.JwtAuthRequest;

@RestController
@RequestMapping("/test")
public class MyControler {
    
	@Autowired
	private  AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtGenerator jwtGenerator;
	
	@GetMapping("/index")
	public String index() {
		return "index";
	}
	
	@GetMapping("/member")
	public String member() {
		return "member";
	}

	@GetMapping("/admin")
	public String admin() {
		return "admin";
	}
	
	@PostMapping	("/login")      //TOKAN GANRATE........
	public String login(@RequestBody JwtAuthRequest jwtAuthRequest) {
		
		//AuthanticationManager
		
		UsernamePasswordAuthenticationToken auth=new UsernamePasswordAuthenticationToken
				(jwtAuthRequest.getUsername(), jwtAuthRequest.getPassword());
		
		org.springframework.security.core.Authentication getAuth=authenticationManager.authenticate(auth);
		UserDetails ud = (UserDetails) getAuth.getPrincipal();
		            
		// GANRATE MY  TOKAN
		
		String token=jwtGenerator.generateToken(ud);
		
		
		
		return token;
	}
	

}