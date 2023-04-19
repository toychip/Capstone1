package com.ttt.capstone.request;


import lombok.*;
//import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Login {

    @NotBlank(message = "이메일을 입력해주세요")
    private String email;

    @NotBlank(message = "비밀번호를 입력해주세요")
    private String password;


    @Builder
    public Login(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
