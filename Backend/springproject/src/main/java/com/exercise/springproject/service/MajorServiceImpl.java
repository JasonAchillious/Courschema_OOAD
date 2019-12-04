package com.exercise.springproject.service;

import com.exercise.springproject.api.MajorRepository;
import com.exercise.springproject.domain.major;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MajorServiceImpl implements MajorService {
    @Autowired
    private MajorRepository majorRepository;
    @Override
    public major findmajorById(int idMajor) {
        return majorRepository.findmajorById(idMajor);
    }
}
