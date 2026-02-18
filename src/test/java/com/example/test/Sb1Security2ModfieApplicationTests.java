package com.example.test;

import java.util.Base64;

import javax.crypto.SecretKey;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import io.jsonwebtoken.Jwts;

@SpringBootTest
class Sb1Security2ModfieApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void keytest() {
	 
		SecretKey secretKey = Jwts.SIG.HS512.key().build(); //STAMP
		String finalkey = Base64.getEncoder().encodeToString(secretKey.getEncoded());
		System.out.println("***********************"+finalkey+"************************************");
		
		
	}
	
}
