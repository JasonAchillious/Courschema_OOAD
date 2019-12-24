package com.exercise.springproject.service;

import com.exercise.springproject.domain.Major;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MajorService {
    public Major findMajorById(int idMajor);

    public Major findMajorByCname(String chineseName);

    public List<Major> findMajorByDepartment(int idDepartment);

    public Major findMajorByEname(String englishName);

    List<Major> findAll();

    Major save(Major major);
}
