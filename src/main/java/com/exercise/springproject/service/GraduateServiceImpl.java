package com.exercise.springproject.service;

import com.exercise.springproject.api.GraduationRepository;
import com.exercise.springproject.domain.Xianxiu_condition;
import com.exercise.springproject.domain.graduate_condition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GraduateServiceImpl implements GraduateService{
    @Autowired
    private GraduationRepository graduationRepository;

    @Override
    public List<graduate_condition> findgraduate_conditionByIdCourse(int idcourse) {
        return graduationRepository.findgraduate_conditionByIdCourse(idcourse);
    }

    @Override
    public List<graduate_condition> findgraduate_conditionByCourschema(int idschema) {
        return graduationRepository.findgraduate_conditionByCourschema(idschema);
    }

    @Override
    public graduate_condition findgraduate_conditionByIdCourseAndCourschema(int idCourse, int idschema) {
        return graduationRepository.findgraduate_conditionByIdCourseAndCourschema(idCourse, idschema);
    }

    @Override
    public graduate_condition save(graduate_condition con) {
        return graduationRepository.save(con);
    }

    @Override
    public void deletegraduate_condition(int course, int courschema) {
        graduationRepository.deletegraduate_condition(course, courschema);
    }
}
