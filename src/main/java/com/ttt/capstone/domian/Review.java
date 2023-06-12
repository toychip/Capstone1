package com.ttt.capstone.domian;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;


@Entity
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Lob    // Long text
    private String content;

    private String writtenBy;
    private LocalDateTime writtenDateTime;

    @ElementCollection
    private List<String> imageUrls; // 새로운 필드 추가

    @Builder
    public Review(String title, String content, Member member, String writtenBy, List<String> imageUrls) {
        this.title = title;
        this.content = content;
        this.member = member;
        this.writtenBy = writtenBy;
        this.writtenDateTime = LocalDateTime.now();
        this.imageUrls = imageUrls;
    }


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    public void mappingUser(Member member) {
        this.member = member;
        member.mappingReview(this);
    }
}
