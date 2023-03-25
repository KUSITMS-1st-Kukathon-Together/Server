package com.kusitms.together.api.domain.member;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.ArrayList;
import java.util.Collection;

@Getter
public class MemberAccount extends User {
    private final Long memberId;
    private final String loginId;
    private final Role role;

    public MemberAccount(Long memberId, String loginId, Role role) {
        super(loginId, "-", new ArrayList<Role>(){{add(role);}});
        this.memberId = memberId;
        this.loginId = loginId;
        this.role = role;
    }
}
