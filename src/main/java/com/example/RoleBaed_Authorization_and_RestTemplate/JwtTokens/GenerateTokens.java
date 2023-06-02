package com.example.RoleBaed_Authorization_and_RestTemplate.JwtTokens;

import com.example.RoleBaed_Authorization_and_RestTemplate.DtoClass.LoginDto;
import com.example.RoleBaed_Authorization_and_RestTemplate.GlobalException.IllegalException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class GenerateTokens {
    private final  static String privateKey = "this is private";
    Long duration = 5+5L;
    Long takenTime = System.currentTimeMillis();
    Long ExpiredTime = duration + takenTime * 1000L;
    Date expiredAt = new Date(ExpiredTime);
    Date issuedAt = new Date(takenTime);
    public String generateToken(LoginDto loginDto){
        Claims claims = Jwts.claims().setIssuedAt(issuedAt).setExpiration(expiredAt).setIssuer(loginDto.getRole());
        return Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512,privateKey).compact();
    }
    public Claims verifyToken(String authorization) throws Exception {
        try {
            Claims claims = Jwts.parser().setSigningKey(privateKey).parseClaimsJws(authorization).getBody();
            return claims;
        }catch (IllegalException e){
            throw new IllegalException("Unadsdkl;nnd");
        }
    }
}
