package com.exercise.springproject.service;

import com.exercise.springproject.domain.major;
import org.springframework.stereotype.Service;

@Service
public interface MajorService {
    public major findmajorById(int id);
}
