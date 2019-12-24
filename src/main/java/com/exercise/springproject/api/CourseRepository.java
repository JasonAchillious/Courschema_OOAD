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

}
