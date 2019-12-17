package com.exercise.springproject.api;

import com.exercise.springproject.domain.Login_user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface Login_userRepository extends JpaRepository<Login_user, Integer> {
    @Query("select p from Login_user p where p.id=?1")
    public Login_user findLogin_userById(int id);

}
