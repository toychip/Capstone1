package com.ttt.capstone.repository;

import com.ttt.capstone.domian.Post;

import java.util.List;

public interface PostRepositoryCustom {

    List<Post> getList(int page);
}
