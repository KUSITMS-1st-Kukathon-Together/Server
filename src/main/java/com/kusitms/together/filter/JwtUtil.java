package com.kusitms.together.filter;

import com.kusitms.together.api.domain.member.Role;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Component
public class JwtUtil {
    public static final int EXPIRATION_TIME = 864000000;

    public static final String TOKEN_PREFIX = "Bearer ";

    public static final String HEADER_STRING = "Authorization";

    public static final String SECRET = "LWp2dC10dXRvcalhbk1zZWAyZXQtc2lsdmVyb";

    // jwt 토큰 생성
    public String generateToken(Long memberId, String loginId, Role role) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + EXPIRATION_TIME);
        Claims claims = Jwts.claims()
                .setSubject(loginId) // 사용자
                .setIssuedAt(new Date()) // 현재 시간 기반으로 생성
                .setExpiration(expiryDate) // 만료 시간 세팅
                ;
        claims.put("member_id", memberId);
        claims.put("login_id", loginId);
        claims.put("role", role);


        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, SECRET) // 사용할 암호화 알고리즘, signature에 들어갈 secret 값 세팅
                .compact();
    }

    public String resolveToken(HttpServletRequest request) {
        String bearerToken = request.getHeader(HEADER_STRING);
        if(StringUtils.hasText(bearerToken) && bearerToken.startsWith(TOKEN_PREFIX)) {
            return bearerToken.substring(7);
        }
        return null;
    }

}
