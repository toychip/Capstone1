package com.ttt.capstone.config.security;


import com.ttt.capstone.domian.Member;
import com.ttt.capstone.domian.Role;
import com.ttt.capstone.exception.AlreadyExistsEmailException;
import com.ttt.capstone.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final MemberRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {   // 회원가입

        Optional<Member> memberOptional = repository.findByEmail(request.getEmail());
        if (memberOptional.isPresent()) {
            throw new AlreadyExistsEmailException();
        }

        var user = Member.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .phoneNumber(request.getPhoneNumber())
                .role(Role.USER)
                .build();
        repository.save(user);
        var jwtToken = jwtService.generateToken(user);
        AuthenticationResponse response = AuthenticationResponse.builder()
                .token(jwtToken)
                .build();

        response.setRedirectUrl("/");
        return response;
    }

    public AuthenticationResponse registerBusiness(RegisterRequest request) {   // 회원가입 - 사장님

        Optional<Member> memberOptional = repository.findByEmail(request.getEmail());
        if (memberOptional.isPresent()) {
            throw new AlreadyExistsEmailException();
        }

        var user = Member.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .phoneNumber(request.getPhoneNumber())
                .role(Role.CEO)
                .build();
        repository.save(user);
        var jwtToken = jwtService.generateToken(user);
        AuthenticationResponse response = AuthenticationResponse.builder()
                .token(jwtToken)
                .build();

        response.setRedirectUrl("/");
        return response;
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) { // 로그인

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = repository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        AuthenticationResponse response = AuthenticationResponse.builder()
                .token(jwtToken)
                .build();

        response.setRedirectUrl("/");
        return response;
    }
}
