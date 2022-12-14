package com.sistema.examanes.sistema.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class TokenUtils {

//  private static final String ACCESS_TOKEN_SECRET = "secretetoke12345";
  private static final String ACCESS_TOKEN_SECRET = "asdfSFS34wfsdfsdfSDSD32dfsddDDerQSNCK34SOWEK5354fdgdf4";
  private static final Long ACCESS_TOKEN_VALIDITY_SECONDS = 2_592_000L;

  public static String createToken(String nombre, String email) {
    long expirationTime = ACCESS_TOKEN_VALIDITY_SECONDS * 1_000;
    Date expirationDate = new Date(System.currentTimeMillis() + expirationTime);
    Map<String, Object> extra = new HashMap<>();
    extra.put("nombre", nombre);
    return Jwts.builder()
        .setSubject(email)
        .setExpiration(expirationDate)
        .addClaims(extra)
        .signWith(Keys.hmacShaKeyFor(ACCESS_TOKEN_SECRET.getBytes())).compact();

  }
  public static UsernamePasswordAuthenticationToken getAuthenticationToken(String token)
  {
    try {
      Claims claims = Jwts.parserBuilder()
          .setSigningKey(ACCESS_TOKEN_SECRET.getBytes())
          .build()
          .parseClaimsJws(token)
          .getBody();
      String email = claims.getSubject();
      return new UsernamePasswordAuthenticationToken(email, null, Collections.emptyList());
    }
    catch (JwtException e){
      return null;
    }
  }
}
