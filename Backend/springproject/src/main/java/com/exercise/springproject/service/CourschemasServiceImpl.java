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
    public void deleteCourschema(int courschema) {
        courschemasRepository.deleteCourschema(courschema);
    }
}
