package com.exercise.springproject.service;

import com.exercise.springproject.domain.Major;
import org.springframework.stereotype.Service;

@Service
public interface MajorService {
    public Major findMajorById(int idMajor);
}
