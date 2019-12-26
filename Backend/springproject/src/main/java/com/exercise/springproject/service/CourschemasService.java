package com.exercise.springproject.service;

import com.exercise.springproject.domain.courschemas;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface CourschemasService {
    public List<courschemas> findAll();
    public courschemas save(courschemas student);
    public void deleteCourschema(int courschema);
    public courschemas findCourschema(int courschema);
    public courschemas findCourschemaName(String chinese_name);
    public List<courschemas> findcourschemasBymajor(int major);
    public courschemas findcourschemasByYear(int year);
    public courschemas findcourschemasByDepartment(int de);
    public courschemas findcourschemasById(int id);
    public void editSchema(int schemaid, int AR_elec, String ChineseName, String depart, int departid, int WaiGuo,
                           int HU_elec, String major, int mid, int Major_elec,
               int One_plus3, int SS_elec, int Nian, String Intro);
}
