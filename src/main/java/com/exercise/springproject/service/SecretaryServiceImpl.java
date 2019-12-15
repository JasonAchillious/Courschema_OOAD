package com.exercise.springproject.service;


import com.exercise.springproject.api.SecretaryRepository;
import com.exercise.springproject.domain.Major;
import com.exercise.springproject.domain.secretary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SecretaryServiceImpl implements  SecretaryService{
    @Autowired
    private SecretaryRepository secretaryRepository;

    @Override
    public secretary findSecretaryById(int id) {
        return secretaryRepository.findSecretaryById(id);
    }

    @Override
    public secretary findsecretaryByDepartment(int de) {
        return secretaryRepository.findsecretaryByDepartment(de);
    }

}
