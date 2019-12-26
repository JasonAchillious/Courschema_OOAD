package com.exercise.springproject.api;

import com.exercise.springproject.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Integer>{
    @Query("select p from Course p where p.idCourse=?1")
    public Course findCourseById(int idCourse);

    @Query("select p from Course p where p.department=?1")
    public List<Course> findCourseByDepartment(int idDepartment);

    /*
    @Query("select p from Course p")
    public List<Course> findAll();
     */

    @Modifying
    @Transactional
    @Query("delete from Course p where p.idCourse=?1")
    public void deleteCourseById(int idCourse);

    @Modifying
    @Transactional
    @Query("update Course set chineseName=?2, BianHao=?3, intro=?4, credit=?5, summer=?6, spring=?7, autumn=?8, xianxiu=?9, englishName=?10, nian=?11, department_name=?12, department=?13, weektime=?14, experiment=?15 where idCourse=?1")
    public void editCourse(int id, String c_name, String code, String intro, Double credit, Byte summer, Byte spring, Byte autumn,
                           String xianxiu, String e_name, int n, String depart, int did, int weektime, int experiment);


}
