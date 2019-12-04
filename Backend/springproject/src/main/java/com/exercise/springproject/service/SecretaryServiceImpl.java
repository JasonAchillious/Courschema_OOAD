package com.exercise.springproject.service;


import com.exercise.springproject.domain.secretary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SecretaryServiceImpl implements  SecretaryService{
    @Autowired
    private SecretaryService secretaryService;

    @Override
    public secretary findsecreatryById(int id) {
        return secretaryService.findsecreatryById(id);
    }
}
