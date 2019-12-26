package com.exercise.springproject.api;

import com.exercise.springproject.domain.graduate_condition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface GraduationRepository extends JpaRepository<graduate_condition, Integer> {
    @Query("select p from graduate_condition p where p.idCourse=?1")
    public List<graduate_condition> findgraduate_conditionByIdCourse(int idCourse);

    @Query("select p from graduate_condition p where p.courschema=?1")
    public List<graduate_condition> findgraduate_conditionByCourschema(int idschema);

    @Query("select p from graduate_condition p where p.idCourse=?1 and p.courschema=?2")
    public graduate_condition findgraduate_conditionByIdCourseAndCourschema(int idCourse, int idschema);

    @Modifying
    @Transactional
    @Query("delete from graduate_condition where idCourse=?1 and courschema=?2")
    public void deletegraduate_condition(int course, int courschema);

    @Modifying
    @Transactional
    @Query("delete from graduate_condition where idCourse=?1")
    public void deletegraduate_conditionByCourseid(int courseid);
}
