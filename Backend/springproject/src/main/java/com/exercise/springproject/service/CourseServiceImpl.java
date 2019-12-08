package com.exercise.springproject.service;

import com.exercise.springproject.api.CourseRepository;
import com.exercise.springproject.domain.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{
    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public Course save(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course findCourseById(int idCourse){
        System.out.println("courseId" + idCourse);
        return courseRepository.findCourseById(idCourse);
    }

    @Override
    public void deleteCourseById(int idCourse) {
        courseRepository.deleteCourseById(idCourse);
    }

    @Override
    public List<Course> findCourseByDepartment(int idDepartment){
        return courseRepository.findCourseByDepartment(idDepartment);
    }
}
