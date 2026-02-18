package com.example.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.crypto.SecretKey;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtParserBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtGenerator {
    private static final String Key = "9h8RaqnnrJUcWQKHOf5j2qUGCk0FhP4S222x48f8wZE5DsWqWg2mzAsLsR1kLZLMUJeLtpcK0MsPnlwI0iFsFw==";

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        List<String> roles = new ArrayList<>();
        
        for (GrantedAuthority authority : userDetails.getAuthorities()) {
            roles.add(authority.getAuthority());
        }
        claims.put("roles", roles);

        String token = Jwts.builder()
            .claims(claims)
          
            .subject(userDetails.getUsername()) 
            .issuedAt(new Date(System.currentTimeMillis()))
            .expiration(new Date(System.currentTimeMillis() + 5*60*1000))
            .signWith(genratekey(), Jwts.SIG.HS512)
            .compact();
        return token;
    }

    public SecretKey genratekey() {
        return Keys.hmacShaKeyFor(Key.getBytes());
    }
    
    public Claims getAllInforomTheToken(String token) {
        JwtParserBuilder parser = Jwts.parser();
        Jws<Claims> signedClaims = parser.verifyWith(genratekey()).build().parseSignedClaims(token);
        return signedClaims.getPayload();
    }
    
    public boolean isExpired(String token) {
        Claims payload = getAllInforomTheToken(token);
        Date expiration = payload.getExpiration();
        return expiration.before(new Date());
    }

    public String getUsername(String token) {
        Claims payload = getAllInforomTheToken(token);
        return payload.getSubject();
    }
 
    // FIX: JSON से आने वाले roles हमेशा String List होते हैं, उन्हें सीधे GrantedAuthority में कास्ट नहीं किया जा सकता
    public List<String> getAllRoles(String token){
        Claims payload = getAllInforomTheToken(token);
        return (List<String>) payload.get("roles");
    }
}