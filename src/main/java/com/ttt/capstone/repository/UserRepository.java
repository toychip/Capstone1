package com.ttt.capstone.repository;

import com.ttt.capstone.domian.MemberUser;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository <MemberUser, Long> {

    Optional<MemberUser> findByEmailAndPassword(String email, String paassword);
}
