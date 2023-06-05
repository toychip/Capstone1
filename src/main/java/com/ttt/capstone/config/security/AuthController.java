package com.ttt.capstone.config.security;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class AuthController {

//    private final AuthService authService;
    private final AuthenticationService service;


    @PostMapping("/auth/signup") // 회원가입
    public ResponseEntity<AuthenticationResponse> joinGuest(
            @RequestBody RegisterRequest request){

        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/auth/signup-business") // 회원가입 - 사업자
    public ResponseEntity<AuthenticationResponse> joinBusiness(
            @RequestBody RegisterRequest request){

        return ResponseEntity.ok(service.registerBusiness(request));
    }

    @PostMapping("/auth/login") // 로그인
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request){
        try {
            return ResponseEntity.ok(service.authenticate(request));
        } catch (AuthenticationException e) {
            AuthenticationResponse response = new AuthenticationResponse();
            response.setRedirectUrl("/auth/login");
            // 로그인 실패시 401 Unauthorized 상태 코드를 반환
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }
}
