package com.ttt.capstone.controller;


import com.ttt.capstone.request.Login;
import com.ttt.capstone.response.SessionResponse;
import com.ttt.capstone.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;

@RestController
@RequiredArgsConstructor
@Slf4j
public class AuthController {

    private final AuthService authService;

    @PostMapping("/auth/login")
    public ResponseEntity<Object> login(@RequestBody Login login){
        String accessToken = authService.signin(login);
//        return new SessionResponse(accessToken);
        ResponseCookie cookie = ResponseCookie.from("SESSION", accessToken)
                .domain("localhost")    // todo 서버 환경에 따른 분리 필요
                .path("/")
                .httpOnly(true)
                .secure(false)
                .maxAge(Duration.ofDays(30))   // 한 달
                .sameSite("Strict")
                .build();
        log.info(">>>>>>>>>>>>> cookie={}", cookie.toString());
        return ResponseEntity.ok()
                .header(HttpHeaders.SET_COOKIE, cookie.toString())
                .build();
    }
}
