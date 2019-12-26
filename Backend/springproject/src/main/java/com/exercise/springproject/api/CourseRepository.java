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
    @Query("update Course set chineseName=?2, BianHao=?3, intro=?3, credit=?4, summer=?5, spring=?6, autumn=?7, xianxiu=?8, englishName=?9, nian=?10, department_name=?11, department=?12, weektime=?13, experiment=?14 where idCourse=?1")
    public void editCourse(int id,String c_name, String code, String intro, Double credit, Byte summer, Byte spring, Byte autumn,
                           String xianxiu, String e_name, int n, String depart, int did, int weektime, int experiment);


}
