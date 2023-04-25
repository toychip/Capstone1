package com.ttt.capstone.service;

import com.ttt.capstone.domian.Member;
import com.ttt.capstone.domian.Session;
import com.ttt.capstone.exception.AlreadyExistsEmailException;
import com.ttt.capstone.exception.InvalidRequest;
import com.ttt.capstone.exception.InvalidSigninInformation;
import com.ttt.capstone.repository.MemberRepository;
import com.ttt.capstone.request.Login;
import com.ttt.capstone.request.Signup;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final MemberRepository memberRepository;

    @Transactional
    public Long signin(Login login){
//        Member member = memberRepository.findByEmailAndPassword(login.getEmail(), login.getPassword())
//                .orElseThrow(InvalidSigninInformation::new);
//        Session session = member.addSession();  // jwt를 쓰면서 필요가 없어짐
//        return session.getAccessToken();
        Member member = memberRepository.findByEmail(login.getEmail())
                .orElseThrow(InvalidSigninInformation::new);

        SCryptPasswordEncoder encoder = new SCryptPasswordEncoder(
                16,
                8,
                1,
                32,
                64);
        var matches = encoder.matches(login.getPassword(), member.getPassword());
        if (!matches){
            throw new InvalidSigninInformation();
        }

        return member.getId();
    }

    public void signup(Signup signup) {
        Optional<Member> memberOptional = memberRepository.findByEmail(signup.getEmail());
        if (memberOptional.isPresent()) {
            throw new AlreadyExistsEmailException();
        }

        SCryptPasswordEncoder encoder = new SCryptPasswordEncoder(
                16,
                8,
                1,
                32,
                64);

        String encryptedPassword = encoder.encode(signup.getPassword());



        var member = Member.builder()
                .name(signup.getName())
                .password(encryptedPassword)
                .email(signup.getEmail())
                .build();
        memberRepository.save(member);
    }
}
