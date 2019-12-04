package com.exercise.springproject.service;

import com.exercise.springproject.api.MajorRepository;
import com.exercise.springproject.domain.Major;
import org.springframework.beans.factory.annotation.Autowired;

public class MajorServiceImpl implements MajorService {
    @Autowired
    private MajorRepository majorRepository;
    @Override
    public Major findMajorById(int idMajor) {
        return majorRepository.findMajorById(idMajor);
    }
}
