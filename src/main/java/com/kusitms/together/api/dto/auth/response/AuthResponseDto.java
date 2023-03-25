package com.kusitms.together.api.dto.auth.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AuthResponseDto {
    private String message;
    private String token;

    public AuthResponseDto(String message, String token) {
        this.message = message;
        this.token = token;
    }

}
