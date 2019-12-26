package com.exercise.springproject.service;

import com.exercise.springproject.domain.StudentCourse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentCourseService {
    public List<StudentCourse> findCourseByid_student(int ids);
}
