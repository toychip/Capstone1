package com.ttt.capstone.domian;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


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

    @Builder
    public Review(String title, String content, Member member, String writtenBy) {
        this.title = title;
        this.content = content;
        this.member = member;
        this.writtenBy = writtenBy;
        this.writtenDateTime = LocalDateTime.now();
    }

    public ReviewEditor.ReviewEditorBuilder toEditor(){
        return ReviewEditor.builder()
                .title(title)
                .content(content);
    }

    public void edit(ReviewEditor reviewEditor, Member member, String writtenBy) {
        title = reviewEditor.getTitle();
        content = reviewEditor.getContent();
        this.member = member;
        this.writtenBy = writtenBy;
        this.writtenDateTime = LocalDateTime.now();
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    public void mappingUser(Member member) {
        this.member = member;
        member.mappingReview(this);
    }

}
