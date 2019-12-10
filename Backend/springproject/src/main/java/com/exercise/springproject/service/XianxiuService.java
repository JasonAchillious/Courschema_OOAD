package com.exercise.springproject.service;

import com.exercise.springproject.domain.Xianxiu_condition;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface XianxiuService {
    public List<Xianxiu_condition> findXianxiu_conditionByIdCourse(int idCourse);
    public List<Xianxiu_condition> findXianxiu_conditionByCourschema(int schema);
    public Xianxiu_condition findXianxiu_conditionByIdCourseAndCourschema(int course, int schema);
}
