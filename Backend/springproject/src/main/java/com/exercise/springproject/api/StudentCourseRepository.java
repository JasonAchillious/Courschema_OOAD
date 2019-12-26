package com.exercise.springproject.api;

import com.exercise.springproject.domain.StudentCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface StudentCourseRepository extends JpaRepository<StudentCourse, Integer> {
    @Query("select p from StudentCourse p where p.idstudent=?1")
    public List<StudentCourse> findCourseByid_student(int id);
}
