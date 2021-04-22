
package com.farm.config;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.farm.entities.User;
import com.farm.exception.FarmAuthenticationExceptionHandler;
import com.farm.services.UserService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;


@Component
public class FarmJwtTokenUtil {

	@Value("${com.apptimus.jwt.secret}")
	private String jwtSecret;

	@Value("${com.apptimus.jwt.expire.milliseconds}")
	private Long tokenValidity;

	@Autowired
	private UserService userService;

	public User getUser(final String token) {
		try {
			Claims body = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
			User user = userService.getOneById(Integer.parseInt(body.getSubject().toString()));
			if(user.getToken() != null && user.getToken().equals(token)) {
				return user;
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage() + " => " + e);
		}
		return null;
	}

	public String generateToken(User user) {
		System.out.println(user);
		Claims claims = Jwts.claims().setSubject(user.getId().toString());

		long nowMillis = System.currentTimeMillis();
		long expMillis = nowMillis + tokenValidity;
		Date exp = new Date(expMillis);
	
		return Jwts.builder().setClaims(claims).setIssuedAt(new Date(nowMillis)).setExpiration(exp)
				.signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
	}

	public void validateToken(final String token) {
		try {
			Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
		} catch (SignatureException ex) {
			throw new FarmAuthenticationExceptionHandler("Invalid JWT signature");
		} catch (MalformedJwtException ex) {
			throw new FarmAuthenticationExceptionHandler("Invalid JWT token");
		} catch (ExpiredJwtException ex) {
			throw new FarmAuthenticationExceptionHandler("Expired JWT token");
		} catch (UnsupportedJwtException ex) {
			throw new FarmAuthenticationExceptionHandler("Unsupported JWT token");
		} catch (IllegalArgumentException ex) {
			throw new FarmAuthenticationExceptionHandler("JWT claims string is empty.");
		}
	}
	
	public boolean validateTokenBoolean(final String token) {
		try {
			Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
			return true;
		} catch (SignatureException ex) {
			return false;
		} catch (MalformedJwtException ex) {
			return false;
		} catch (ExpiredJwtException ex) {
			return false;
		} catch (UnsupportedJwtException ex) {
			return false;
		} catch (IllegalArgumentException ex) {
			return false;
		}
	}

}
