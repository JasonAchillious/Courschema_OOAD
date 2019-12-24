package com.exercise.springproject.service;

import com.exercise.springproject.api.MajorRepository;
import com.exercise.springproject.domain.Major;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MajorServiceImpl implements MajorService {
    @Autowired
    private MajorRepository majorRepository;
    @Override
    public Major findMajorById(int idMajor) {
        return majorRepository.findMajorById(idMajor);
    }

    @Override
    public Major findMajorByCname(String chineseName){
        return majorRepository.findMajorByCname(chineseName);
    }

    @Override
    public List<Major> findMajorByDepartment(int idDepartment) {
        return majorRepository.findMajorByDepartment(idDepartment);
    }

    @Override
    public Major findMajorByEname(String englishName) {
        return majorRepository.findMajorByEname(englishName);
    }

    @Override
    public List<Major> findAll() {
        return majorRepository.findAll();
    }

    @Override
    public Major save(Major major) {
        return majorRepository.save(major);
    }
}
