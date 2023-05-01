package com.moviequote.project.repository;

import com.moviequote.project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // to register
        //return if the user exists in the db or not
    boolean existsByEmailAddress(String emailAddress);

    // to login
        //if I am able to successfully logged in, need a new User object
    User findUserByEmailAddress(String emailAddress);
}
