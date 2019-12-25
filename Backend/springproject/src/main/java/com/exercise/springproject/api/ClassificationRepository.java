package com.exercise.springproject.api;

import com.exercise.springproject.domain.Classification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface ClassificationRepository extends JpaRepository<Classification, Integer> {

    @Query(value = "select p from Classification p where p.idCourse=?1 and p.courschema=?2")
    public Classification findCourseClass(int idCourse, int courschema);

    @Modifying
    @Transactional
    @Query(value = "delete from Classification where idCourse=?1 and courschema=?2")
    void deleteCourseClass(int idCourse, int courschema);

    @Query(value = "select p.idCourse from Classification p where p.courschema=?1")
    public List<Integer> findSchemaCourse(int courschema);

    @Query(value = "select p.idCourse from Classification p where p.courschema=?1 and p.compulsory=1")
    public List<Integer> findTypeComCourse(int courschema);

    @Query(value = "select p.idCourse from Classification p where p.courschema=?1 and p.ru_xi=1")
    public List<Integer> findTypeRuxiCourse(int courschema);

    @Query(value = "select p.idCourse from Classification p where p.courschema=?1 and p.tongshi=1")
    public List<Integer> findTypeTonCourse(int courschema);

    @Query(value = "select p.idCourse from Classification p where p.courschema=?1 and p.tongshi=0 and p.compulsory=0 and p.ru_xi=0")
    public List<Integer> findTypeXuanXiuCourse(int courschema);

    @Query(value = "select p.idCourse from Classification p where p.courschema=?1 and p.political=1")
    public List<Integer> findPoliticalCourse(int courschema);
}
