package com.ttt.capstone.repository;

import com.ttt.capstone.domian.Post;
import com.ttt.capstone.request.PostSearchRequest;

import java.util.List;

public interface PostRepositoryCustom {

    List<Post> getList(PostSearchRequest postSearchRequest);
    List<Post> search(PostSearchRequest postSearchRequest);

}
