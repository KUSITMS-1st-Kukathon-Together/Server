package com.kusitms.together.api.service.auth;

import com.kusitms.together.api.domain.member.Member;
import com.kusitms.together.api.domain.member.MemberRepository;
import com.kusitms.together.api.domain.member.Role;
import com.kusitms.together.api.dto.auth.request.SignUpRequestDto;
import com.kusitms.together.api.dto.auth.response.SignUpResponseDto;
import com.kusitms.together.filter.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthService {

    private final JwtUtil jwtUtil;

    private final PasswordEncoder passwordEncoder;

    private final MemberRepository memberRepository;

    public SignUpResponseDto signUp(SignUpRequestDto signUpRequestDto) {
        Member newMember = Member.builder()
                .loginId(signUpRequestDto.getLoginId())
                .password(passwordEncoder.encode(signUpRequestDto.getPassword()))
                .nickname(signUpRequestDto.getNickname())
                .location(signUpRequestDto.getLocation())
                .role(Role.ROLE_USER)
                .build();

        memberRepository.save(newMember);

        return new SignUpResponseDto("success", jwtUtil.generateToken(newMember.getId(), newMember.getLoginId(), newMember.getRole()));
    }
}
