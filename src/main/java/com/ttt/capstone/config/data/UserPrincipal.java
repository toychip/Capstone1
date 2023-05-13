package com.ttt.capstone.config.data;

import com.ttt.capstone.domian.Member;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class UserPrincipal extends User {

    private final Long userId;

    public UserPrincipal(Member user){
        super(user.getEmail(), user.getPassword(), List.of(new SimpleGrantedAuthority("ADMIN")));
        this.userId = user.getId();
    }

    public Long getUserId() {
        return userId;
    }
}
