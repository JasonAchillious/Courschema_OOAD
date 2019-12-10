package com.exercise.springproject.api;


import com.exercise.springproject.domain.MultipleKeysClass;
import com.exercise.springproject.domain.Xianxiu_condition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.IdClass;
import java.util.List;

public interface XianXiuRepository extends JpaRepository<Xianxiu_condition, Integer> {
    @Query("select p from Xianxiu_condition p where p.idCourse=?1")
    public List<Xianxiu_condition> findXianxiu_conditionByIdCourse(int idCourse);

    @Query("select p from Xianxiu_condition p where p.courschema=?1")
    public List<Xianxiu_condition> findXianxiu_conditionByCourschema(int schema);

    @Query("select p from Xianxiu_condition p where p.idCourse=?1 and p.courschema=?2")
    public Xianxiu_condition findXianxiu_conditionByIdCourseAndCourschema(int course, int schema);


}
