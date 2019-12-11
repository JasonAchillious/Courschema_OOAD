package com.exercise.springproject.service;

import com.exercise.springproject.domain.Classification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClassificationService {
    public Classification save(Classification collections);
    public void deleteCourseClass(int idCourse, int courschema);
    public Classification findCourseClass(int idCourse, int courschema);
    List<Classification> findAll();
    public List<Integer> findSchemaCourse(int courschema);
    public List<Integer> findTypeComCourse(int courschema);
    public List<Integer> findTypeRuxiCourse(int courschema);
    public List<Integer> findTypeTonCourse(int courschema);
    public List<Integer> findTypeXuanXiuCourse(int courschema);
    public List<Integer> findPoliticalCourse( int courschema);
}
