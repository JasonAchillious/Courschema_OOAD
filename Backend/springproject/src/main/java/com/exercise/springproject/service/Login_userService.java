package com.exercise.springproject.service;


import com.exercise.springproject.domain.Login_user;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface Login_userService {
    public Login_user save(Login_user login_user);
    public void deleteLogin_userById(int id);
    public Login_user findLogin_userById(int id);
    public List<Login_user> findAll();
}
