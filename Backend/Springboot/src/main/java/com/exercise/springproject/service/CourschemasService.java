package com.exercise.springproject.service;

import com.exercise.springproject.domain.courschemas;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface CourschemasService {
    public List<courschemas> findAll();
    public courschemas save(courschemas student);
    public void deleteCourschema(int courschema);
    public courschemas findCourschema(int courschema);
}
