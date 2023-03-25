package com.kusitms.together.api.controller.util;

import com.kusitms.together.api.domain.member.MemberAccount;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/")
public class HealthCheckController {

    @GetMapping("/health")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("Health Check Success");
    }

    @GetMapping("/info")
    public ResponseEntity<MemberAccount> myInfo(@AuthenticationPrincipal MemberAccount memberAccount) {
        return ResponseEntity.ok(memberAccount);
    }
}
