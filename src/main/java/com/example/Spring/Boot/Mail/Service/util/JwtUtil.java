package com.example.Spring.Boot.Mail.Service.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

@Log4j2
@Component
public class JwtUtil {

	@Value("${account.service.jwtSecret}")
	private String jwtSecret;

	@Value("${account.service.jwtExpirationMs}")
	private int jwtExpirationMs;

	public String parseJwt(HttpServletRequest request) {
		String headerAuth = request.getHeader("Authorization");

		if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer ")) {
			return headerAuth.substring(7, headerAuth.length());
		}

		return null;
	}

	public Jws<Claims> parseJwtClaims(String jwt) {
		return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(jwt);
	}
}
