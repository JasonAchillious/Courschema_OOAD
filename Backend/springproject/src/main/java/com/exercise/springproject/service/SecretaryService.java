package com.exercise.springproject.service;

import com.exercise.springproject.domain.secretary;
import org.springframework.stereotype.Service;

@Service
public interface SecretaryService {
    public secretary findSecretaryById(int id);
}
