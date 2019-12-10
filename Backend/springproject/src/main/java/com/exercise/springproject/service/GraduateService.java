package com.exercise.springproject.service;

import com.exercise.springproject.api.GraduationRepository;
import com.exercise.springproject.domain.Xianxiu_condition;
import com.exercise.springproject.domain.graduate_condition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GraduateService {
    public List<graduate_condition> findgraduate_conditionByIdCourse(int idcourse);
    public List<graduate_condition> findgraduate_conditionByCourschema(int idschema);
    public graduate_condition findgraduate_conditionByIdCourseAndCourschema(int idCourse, int idschema);
    public graduate_condition save(graduate_condition con);
    public void deletegraduate_condition(int course, int courschema);
}
