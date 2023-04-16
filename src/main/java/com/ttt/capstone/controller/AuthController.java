package com.ttt.capstone.controller;


import com.ttt.capstone.domian.MemberUser;
import com.ttt.capstone.exception.InvalidRequest;
import com.ttt.capstone.exception.InvalidSigninInformation;
import com.ttt.capstone.repository.UserRepository;
import com.ttt.capstone.request.Login;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@Slf4j
public class AuthController {

    private final UserRepository userRepository;

    @PostMapping("/auth/login")
    public MemberUser login(@RequestBody Login login){
        log.info(">>>{}", login);
        // json 아이디/비밀번호 받고

        // DB에서 조회
        MemberUser user = userRepository.findByEmailAndPassword(login.getEmail(), login.getPassword())
                .orElseThrow(InvalidSigninInformation::new);
        // 토큰을 응요
        return user;
    }
}
