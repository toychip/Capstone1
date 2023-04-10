package com.ttt.capstone.repository;

import com.ttt.capstone.domian.Post;
import com.ttt.capstone.request.PostSearch;

import java.util.List;

public interface PostRepositoryCustom {

    List<Post> getList(PostSearch postSearch);
}
