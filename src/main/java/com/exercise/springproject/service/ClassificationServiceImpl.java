package com.exercise.springproject.service;

import com.exercise.springproject.api.ClassificationRepository;
import com.exercise.springproject.domain.Classification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClassificationServiceImpl implements ClassificationService{
    @Autowired
    private ClassificationRepository classificationRepository;

    @Override
    public Classification save(Classification classification) {
        return classificationRepository.save(classification);
    }

    @Override
    public void deleteCourseClass(int idCourse, int courschema) {
        classificationRepository.deleteCourseClass(idCourse, courschema);
    }

    @Override
    public Classification findCourseClass(int idCourse, int courschema) {
        return classificationRepository.findCourseClass(idCourse, courschema);
    }

    @Override
    public List<Classification> findAll() {
        return classificationRepository.findAll();
    }

    @Override
    public List<Integer> findSchemaCourse(int courschema){
        return classificationRepository.findSchemaCourse(courschema);
    }

    @Override
    public List<Integer> findTypeComCourse(int courschema){
        return classificationRepository.findTypeComCourse(courschema);
    }

    @Override
    public List<Integer> findTypeRuxiCourse(int courschema){
        return classificationRepository.findTypeRuxiCourse(courschema);
    }

    @Override
    public List<Integer> findTypeTonCourse(int courschema){
        return classificationRepository.findTypeTonCourse(courschema);
    }

    @Override
    public List<Integer> findTypeXuanXiuCourse(int courschema) {
        return classificationRepository.findTypeXuanXiuCourse(courschema);
    }

    @Override
    public List<Integer> findPoliticalCourse(int courschema) {
        return classificationRepository.findPoliticalCourse(courschema);
    }
}
