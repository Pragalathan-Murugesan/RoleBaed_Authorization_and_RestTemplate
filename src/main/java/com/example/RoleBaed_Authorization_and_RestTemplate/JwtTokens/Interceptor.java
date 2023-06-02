package com.example.RoleBaed_Authorization_and_RestTemplate.JwtTokens;

import com.example.RoleBaed_Authorization_and_RestTemplate.GlobalException.IllegalException;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class Interceptor implements HandlerInterceptor {
    @Autowired
    private GenerateTokens generateTokens;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String jwt = null;
        String token  = request.getHeader("Authorization");
        if (token != null && token.startsWith("Bearer")) {
            jwt = token.substring(7,token.length());
        }
        if(!(request.getRequestURI().contains("/login/role/api/add") || request.getRequestURI().contains("/login/role/api/login"))) {
            Claims claims = null;
//            try {
               claims =generateTokens.verifyToken(jwt);
            if (claims.getIssuer().equals("Admin")) {
                if (!request.getRequestURI().contains("/login/role/api/admin/getall/{role}")) {
                    throw new NullPointerException();
                }
                } else if (claims.getIssuer().equals("User")) {
                if (!request.getRequestURI().contains("/login/role/api/user/api/users/{role}")){
                    throw new IllegalArgumentException();
                }
            }
                }
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
