package com.ttt.capstone.service;

import com.ttt.capstone.domian.Member;
import com.ttt.capstone.exception.AlreadyExistsEmailException;
import com.ttt.capstone.repository.MemberRepository;
import com.ttt.capstone.request.Login;
import com.ttt.capstone.request.Signup;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AuthServiceTest {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private AuthService authService;

    @AfterEach
    void clean(){
        memberRepository.deleteAll();
    }

    @Test
    @DisplayName("회원가입 성공")
    void test1(){
        //given
        Signup signup = Signup.builder()
                .email("toytoy@naver.com")
                .password("1234")
                .name("임준형")
                .build();
        //when
        authService.signup(signup);
        //then
        assertEquals(1, memberRepository.count());
        Member member = memberRepository.findAll().iterator().next();
        assertEquals("toytoy@naver.com", member.getEmail());
        assertNotNull(member.getPassword());
        assertNotEquals("1234", member.getPassword());
        assertEquals("임준형", member.getName());
    }

    @Test
    @DisplayName("회원가입시 중복된 이메일")
    void test2(){
        //given
        Member prevMember = Member.builder()
                .email("toytoy@naver.com")
                .password("1234")
                .name("누구")
                .build();
        memberRepository.save(prevMember);

        Signup signup = Signup.builder()
                .email("toytoy@naver.com")
                .password("1234")
                .name("임준형")
                .build();
        //expected
        assertThrows(AlreadyExistsEmailException.class, () -> authService.signup(signup));
        //then

    }

    @Test
    @DisplayName("암호화 후 로그인 성공")
    void test3(){
        //given
        Signup signup = Signup.builder()
                .email("toytoy@naver.com")
                .password("1234")
                .name("임준형")
                .build();
        authService.signup(signup);


        Login login = Login.builder()
                .email("toytoy@naver.com")
                .password("1234")
                .build();

        //when
        authService.signin(login);

        //then

    }
}