package com.ttt.capstone.repository;

import com.ttt.capstone.domian.Post;
import com.ttt.capstone.domian.Review;
import com.ttt.capstone.request.SearchRequest;

import java.util.List;

public interface ReviewRepositoryCustom {

    List<Review> getList(SearchRequest searchRequest);
    List<Review> search(SearchRequest searchRequest);

}
