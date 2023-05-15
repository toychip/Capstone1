package com.ttt.capstone.service;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SmallNameResponse {
    private Long number;
    private String name;
    private String localAddress;
    private String roadAddress;
    private int newPostalCode;
    private String smallName;

    public SmallNameResponse(Long number, String name, String localAddress, String roadAddress, int newPostalCode, String smallName) {
        this.number = number;
        this.name = name;
        this.localAddress = localAddress;
        this.roadAddress = roadAddress;
        this.newPostalCode = newPostalCode;
        this.smallName = smallName;
    }
}
