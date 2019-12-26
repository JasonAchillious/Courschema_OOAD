package com.exercise.springproject.service;

import com.exercise.springproject.domain.Xianxiu_condition;
import com.exercise.springproject.domain.courschemas;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface XianxiuService {
    public List<Xianxiu_condition> findXianxiu_conditionByIdCourse(int idCourse);
    public List<Xianxiu_condition> findXianxiu_conditionByCourschema(int schema);
    public Xianxiu_condition findXianxiu_conditionByIdCourseAndCourschema(int course, int schema);
    public Xianxiu_condition save(Xianxiu_condition con);
    public void deleteXianxiuCondition(int course, int courschema);
    public void deleteXianxiuConditionByCourseid(int idCourse);
}
