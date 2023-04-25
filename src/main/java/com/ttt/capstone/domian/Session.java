// Spring Security 적용할것이므로 주석처리

/*

package com.ttt.capstone.domian;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    private String accessToken;

    @ManyToOne
    private Member member;

    @Builder
    public Session( Member member) {
        this.accessToken = UUID.randomUUID().toString();
        this.member = member;
    }
}
*/
