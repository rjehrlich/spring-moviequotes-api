package com.moviequote.project.service;

import com.moviequote.project.model.User;
import org.springframework.security.core.userdetails.UserDetails;

public class MyUserDetails implements UserDetails {
    public MyUserDetails(User user) {
    }
}
