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
    public void editCourse(int id, String c_name, String code, String intro, Double credit, Byte summer, Byte spring, Byte autumn,
            String xianxiu, String e_name, int n, String depart, int did, int weektime, int experiment);
}
