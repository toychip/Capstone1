package com.ttt.capstone.repository;

import com.ttt.capstone.domian.Post;
import com.ttt.capstone.request.SearchRequest;

import java.util.List;

public interface ReviewRepositoryCustom {

    List<Post> getList(SearchRequest searchRequest);
    List<Post> search(SearchRequest searchRequest);

}
