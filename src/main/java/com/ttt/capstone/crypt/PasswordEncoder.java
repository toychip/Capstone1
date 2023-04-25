package com.ttt.capstone.crypt;

import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.stereotype.Component;

//@Profile("default")
//@Component
public class PasswordEncoder {    // 비밀번호 암호화 운영 서버일 때

    private static SCryptPasswordEncoder encoder = new SCryptPasswordEncoder(
            16,
            8,
            1,
            32,
            64);

    public String encrypt(String rawPassword){
        return encoder.encode(rawPassword);
    }
    public boolean matches(String rawPassword, String encrpytedPassword){
        return encoder.matches(rawPassword, encrpytedPassword);
    }
}
