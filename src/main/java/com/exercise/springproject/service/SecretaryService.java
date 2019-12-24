package com.exercise.springproject.service;

import com.exercise.springproject.domain.Major;
import com.exercise.springproject.domain.secretary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SecretaryService {
    public secretary findSecretaryById(int id);

    public secretary findsecretaryByDepartment(int de);


}
