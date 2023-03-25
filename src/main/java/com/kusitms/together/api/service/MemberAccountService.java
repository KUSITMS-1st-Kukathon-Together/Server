package com.kusitms.together.api.service;

import com.kusitms.together.api.domain.member.MemberAccount;
import com.kusitms.together.api.domain.member.Role;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MemberAccountService implements UserDetailsService {

    private final String jwtSecret = "LWp2dC10dXRvcalhbk1zZWAyZXQtc2lsdmVyb";

    @Override
    public UserDetails loadUserByUsername(String token) throws UsernameNotFoundException {
        Jws<Claims> claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
        Long userId = claims.getBody().get("member_id", Long.class);
        String studentId = claims.getBody().get("login_id", String.class);
        Role role = Role.valueOf(claims.getBody().get("role", String.class));

        return new MemberAccount(userId, studentId, role);
    }
}
