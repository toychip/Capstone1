package com.ttt.capstone.controller;


import com.ttt.capstone.request.Login;
import com.ttt.capstone.response.SessionResponse;
import com.ttt.capstone.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class AuthController {

    private final AuthService authService;

    @PostMapping("/auth/login")
    public SessionResponse login(@RequestBody Login login){
        String accessToken = authService.signin(login);
        return new SessionResponse(accessToken);
    }
}
