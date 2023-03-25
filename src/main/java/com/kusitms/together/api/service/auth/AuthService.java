package com.kusitms.together.api.service.auth;

import com.kusitms.together.api.domain.member.Member;
import com.kusitms.together.api.domain.member.MemberRepository;
import com.kusitms.together.api.domain.member.Role;
import com.kusitms.together.api.dto.auth.request.LoginRequestDto;
import com.kusitms.together.api.dto.auth.request.SignUpRequestDto;
import com.kusitms.together.api.dto.auth.response.AuthResponseDto;
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

    public AuthResponseDto signUp(SignUpRequestDto signUpRequestDto) {
        Member newMember = Member.builder()
                .loginId(signUpRequestDto.getLoginId())
                .password(passwordEncoder.encode(signUpRequestDto.getPassword()))
                .nickname(signUpRequestDto.getNickname())
                .location(signUpRequestDto.getLocation())
                .role(Role.ROLE_USER)
                .build();

        memberRepository.save(newMember);

        return new AuthResponseDto("success", jwtUtil.generateToken(newMember.getId(), newMember.getLoginId(), newMember.getRole()));
    }

    public AuthResponseDto login(LoginRequestDto loginRequestDto) {
        Member member = memberRepository.findByLoginId(loginRequestDto.getLoginId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 아이디입니다."));

        if (!passwordEncoder.matches(loginRequestDto.getPassword(), member.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        return new AuthResponseDto("success", jwtUtil.generateToken(member.getId(), member.getLoginId(), member.getRole()));
    }

    public String verify(String loginId) {
        if (memberRepository.existsByLoginId(loginId)) {
            return "false";
        }

        return "true";
    }
}
