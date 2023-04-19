package com.ttt.capstone.service;

import com.ttt.capstone.domian.Member;
import com.ttt.capstone.domian.Session;
import com.ttt.capstone.exception.InvalidSigninInformation;
import com.ttt.capstone.repository.MemberRepository;
import com.ttt.capstone.request.Login;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final MemberRepository memberRepository;

    @Transactional
    public String signin(Login login){
        Member member = memberRepository.findByEmailAndPassword(login.getEmail(), login.getPassword())
                .orElseThrow(InvalidSigninInformation::new);
        Session session = member.addSession();

        return session.getAccessToken();
    }
}
