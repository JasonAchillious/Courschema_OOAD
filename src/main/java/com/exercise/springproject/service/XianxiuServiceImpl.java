package com.exercise.springproject.service;

import com.exercise.springproject.api.XianXiuRepository;
import com.exercise.springproject.domain.Xianxiu_condition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class XianxiuServiceImpl implements XianxiuService{
    @Autowired
    private XianXiuRepository xianXiuRepository;

    @Override
    public List<Xianxiu_condition> findXianxiu_conditionByIdCourse(int idCourse) {
        return xianXiuRepository.findXianxiu_conditionByIdCourse(idCourse);
    }

    @Override
    public List<Xianxiu_condition> findXianxiu_conditionByCourschema(int schema) {
        return xianXiuRepository.findXianxiu_conditionByCourschema(schema);
    }

    @Override
    public Xianxiu_condition findXianxiu_conditionByIdCourseAndCourschema(int course, int schema) {
        return xianXiuRepository.findXianxiu_conditionByIdCourseAndCourschema(course, schema);
    }

    @Override
    public Xianxiu_condition save(Xianxiu_condition con) {
        return xianXiuRepository.save(con);
    }

    @Override
    public void deleteXianxiuCondition(int course, int courschema) {
        xianXiuRepository.deleteXianxiu_condition(course, courschema);
    }
}
