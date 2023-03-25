package com.kusitms.together.api.dto.auth.response;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SignUpResponseDto {
    private String message;
    private String token;

    public SignUpResponseDto(String message, String token) {
        this.message = message;
        this.token = token;
    }

}
