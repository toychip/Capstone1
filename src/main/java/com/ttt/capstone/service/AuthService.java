package com.ttt.capstone.service;

import com.ttt.capstone.crypt.PasswordEncoder;
import com.ttt.capstone.domian.Member;
import com.ttt.capstone.exception.AlreadyExistsEmailException;
import com.ttt.capstone.repository.MemberRepository;
import com.ttt.capstone.request.Signup;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final MemberRepository memberRepository;
    /*
    private final PasswordEncoder passwordEncoder;
    @Transactional
    public Long signin(Login login){
        Member member = memberRepository.findByEmail(login.getEmail())
                .orElseThrow(InvalidSigninInformation::new);

//        PasswordEncoder encoder = new PasswordEncoder();

        var matches = passwordEncoder.matches(login.getPassword(), member.getPassword());
        if (!matches){
            throw new InvalidSigninInformation();
        }
        return member.getId();
    }

     */

    public void signup(Signup signup) {
        Optional<Member> memberOptional = memberRepository.findByEmail(signup.getEmail());
        if (memberOptional.isPresent()) {
            throw new AlreadyExistsEmailException();
        }

        PasswordEncoder encoder = new PasswordEncoder();
        String encryptedPassword = encoder.encrypt(signup.getPassword());

        var member = Member.builder()
                .name(signup.getName())
                .password(encryptedPassword)
                .email(signup.getEmail())
                .build();
        memberRepository.save(member);
    }
}
