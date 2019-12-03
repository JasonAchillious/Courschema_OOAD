package com.exercise.springproject.api;

import com.exercise.springproject.domain.courschemas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface CourschemasRepository extends JpaRepository<courschemas, Integer> {
    @Query("select p from courschemas p where p.courschema=?1")
    public courschemas findCourschema(int courschema);

    @Query("select p from courschemas p where p.ChineseName=?1")
    public courschemas findCourschema(String chinese_name);

    @Query("delete from courschemas where courschema=?1")
    public void deleteCourschema(int courschema);
}


