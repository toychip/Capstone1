package com.ttt.capstone.service;

import com.ttt.capstone.domian.*;
import com.ttt.capstone.exception.PostNotFound;
import com.ttt.capstone.repository.MemberRepository;
import com.ttt.capstone.repository.ReviewRepository;
import com.ttt.capstone.request.*;
import com.ttt.capstone.response.AuthResponse;
import com.ttt.capstone.response.ReviewResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;
    private final S3Uploader s3Uploader;
    public void write(ReviewCreateRequest reviewCreateRequest){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();  // 현재 사용자의 email 얻기
        Member member = memberRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException(username + "을 찾을 수 없습니다."));

        List<String> imageUrls = null;
        try {
            imageUrls = s3Uploader.uploadMultipleFiles(reviewCreateRequest.getImages(), "review-images");
        } catch (IOException e) {
            e.printStackTrace();
        }

        Review review = Review.builder()
                .title(reviewCreateRequest.getTitle())
                .content(reviewCreateRequest.getContent())
                .member(member)
                .writtenBy(member.getName())
                .imageUrls(imageUrls) // imageUrls 필드에 S3에 업로드된 이미지들의 URL들을 설정합니다.
                .build();
        reviewRepository.save(review);
    }
    public ReviewResponse get(Long id) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(PostNotFound::new);
        return ReviewResponse.builder()
                .id(review.getId())
                .title(review.getTitle())
                .content(review.getContent())
                .writtenBy(review.getWrittenBy())
                .writtenDateTime(review.getWrittenDateTime())
                .imageUrls(review.getImageUrls())
                .build();
    }

    public List<ReviewResponse> search(SearchRequest searchRequest) {
        return reviewRepository.search(searchRequest).stream()
                .map(ReviewResponse::new)
                .collect(Collectors.toList());
    }

    public List<ReviewResponse> getList(SearchRequest searchRequest) {
//        Pageable pageable = PageRequest.of(page,10, Sort.by(Sort.Direction.DESC, "id"));
        return reviewRepository.getList(searchRequest).stream()
                .map(ReviewResponse::new)
                .collect(Collectors.toList());}

    public void delete(Long id) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(PostNotFound::new);
        // -> 존재하는 경우
        Member currentMember = getCurrentMember();
        if (!review.getMember().getId().equals(currentMember.getId())) {
            throw new AccessDeniedException("게시물을 삭제할 권한이 없습니다.");
        }
        reviewRepository.delete(review);}

    private Member getCurrentMember() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName(); // 현재 사용자의 email 얻기
        return memberRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException(username + "을 찾을 수 없습니다."));
    }

    public AuthResponse getCurrentMemberInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName(); // 현재 사용자의 email 얻기
        Member member = memberRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException(username + "을 찾을 수 없습니다."));
        return new AuthResponse(member.getEmail(), member.getName(), member.getPhoneNumber());
    }

}
