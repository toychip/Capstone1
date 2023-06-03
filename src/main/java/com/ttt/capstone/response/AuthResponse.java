package com.ttt.capstone.response;

import lombok.*;

@Builder @AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class AuthResponse {
    private String email;
    private String name;
    private String phoneNumber;

}
