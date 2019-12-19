package com.exercise.springproject.service;

import com.exercise.springproject.api.Login_userRepository;
import com.exercise.springproject.domain.Login_user;
import com.exercise.springproject.domain.collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Login_userServiceImpl implements Login_userService{
    @Autowired
    private Login_userRepository login_userRepository;

    @Override
    public List<Login_user> findAll() {
        return login_userRepository.findAll();
    }

    @Override
    public Login_user save(Login_user login_user) {
        return login_userRepository.save(login_user);
    }

    @Override
    public Login_user findLogin_userById(int id){
        return login_userRepository.findLogin_userById(id);
    }

    @Override
    public void deleteLogin_userById(int id) {
        login_userRepository.deleteById(id);
    }
}
