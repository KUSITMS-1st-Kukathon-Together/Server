package com.kusitms.together.api.dto.auth.request;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SignUpRequestDto {
    private String loginId;
    private String password;
    private String nickname;
    private String location;

    @Builder
    public SignUpRequestDto(String loginId, String password, String nickname, String location) {
        this.loginId = loginId;
        this.password = password;
        this.nickname = nickname;
        this.location = location;
    }
}
