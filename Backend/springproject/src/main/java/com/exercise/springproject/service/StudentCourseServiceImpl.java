package com.exercise.springproject.service;

import com.exercise.springproject.api.StudentCourseRepository;
import com.exercise.springproject.domain.StudentCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentCourseServiceImpl implements StudentCourseService {
    @Autowired
    private StudentCourseRepository studentCourseRepository;

    @Override
    public List<StudentCourse> findCourseByid_student(int ids) {
        return studentCourseRepository.findCourseByid_student(ids);
    }
}
