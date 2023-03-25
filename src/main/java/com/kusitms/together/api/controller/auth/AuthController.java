package com.kusitms.together.api.controller.auth;

import com.kusitms.together.api.dto.auth.request.SignUpRequestDto;
import com.kusitms.together.api.dto.auth.response.SignUpResponseDto;
import com.kusitms.together.api.service.auth.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/sign-up")
    public ResponseEntity<SignUpResponseDto> signUp(@RequestBody SignUpRequestDto signUpRequestDto) {
        return ResponseEntity.ok(authService.signUp(signUpRequestDto));
    }
}
