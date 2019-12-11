package com.exercise.springproject.service;

import com.exercise.springproject.api.CourschemasRepository;
import com.exercise.springproject.domain.courschemas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourschemasServiceImpl implements CourschemasService {
    @Autowired
    private CourschemasRepository courschemasRepository;

    @Override
    public List<courschemas> findAll() {
        return courschemasRepository.findAll();
    }

    @Override
    public courschemas save(courschemas courschemas) {
        return courschemasRepository.save(courschemas);
    }

    @Override
    public courschemas findCourschema(int courschema){
        return courschemasRepository.findCourschema(courschema);
    }

    @Override
    public courschemas findCourschemaName(String chinese_name){
        return courschemasRepository.findCourschema(chinese_name);
    }

    @Override
    public List<courschemas> findcourschemasBymajor(int major) {
        return courschemasRepository.findcourschemasBymajor(major);
    }

    @Override
    public courschemas findcourschemasByYear(int year) {
        return courschemasRepository.findcourschemasByYear(year);
    }

    @Override
    public courschemas findcourschemasByDepartment(int de) {
        return courschemasRepository.findcourschemasByDepartment(de);
    }

    @Override
    public courschemas findcourschemasById(int id) {
        return courschemasRepository.findcourschemasById(id);
    }

    @Override
    public void deleteCourschema(int courschema) {
        courschemasRepository.deleteCourschema(courschema);
    }
}
