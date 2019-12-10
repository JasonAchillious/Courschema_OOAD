package com.exercise.springproject.service;

import com.exercise.springproject.domain.Course;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseService {
    public Course save(Course collections);
    public void deleteCourseById(int idCourse);
    public Course findCourseById(int idCourse);
    List<Course> findAll();
    public List<Course> findCourseByDepartment(int idDepartment);
}
