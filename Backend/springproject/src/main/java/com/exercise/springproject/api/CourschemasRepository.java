package com.exercise.springproject.api;

import com.exercise.springproject.domain.courschemas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;


public interface CourschemasRepository extends JpaRepository<courschemas, Integer> {
    @Query("select p from courschemas p where p.courschema=?1")
    public courschemas findCourschema(int courschema);

    @Query("select p from courschemas p where p.ChineseName=?1")
    public courschemas findCourschema(String chinese_name);

    @Query("select p from courschemas p where p.Major=?1")
    public List<courschemas> findcourschemasBymajor(int major);

    @Query("select p from courschemas p where p.nian=?1")
    public courschemas findcourschemasByYear(int year);

    @Query("select p from courschemas p where p.Department=?1")
    public courschemas findcourschemasByDepartment(int de);

    @Modifying
    @Transactional
    @Query("delete from courschemas where courschema=?1")
    public void deleteCourschema(int courschema);

    @Query("select p from courschemas p where p.courschema=?1")
    public courschemas findcourschemasById(int id);

    @Modifying
    @Transactional
    @Query("update courschemas set AR_elec=?2, ChineseName=?3, department_name=?4, Department=?5, WaiGuo=?6, HU_elec=?7, major_name=?8, Major=?9, major_elec=?10, one_plus3=?11, SS_elec=?12, nian=?13, Intro=?14 where courschema=?1 ")
    public void editSchema(int schemaid, int AR_elec, String ChineseName, String depart, int departid, int WaiGuo, int HU_elec, String major, int mid, int Major_elec, int One_plus3, int SS_elec, int Nian, String Intro);

}


