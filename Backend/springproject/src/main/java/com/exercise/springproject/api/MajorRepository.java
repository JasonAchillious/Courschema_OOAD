package com.exercise.springproject.api;


import com.exercise.springproject.domain.major;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MajorRepository extends JpaRepository<major, Integer> {
    @Query("select p from major p where p.id_major=?1")
    public major findmajorById(int id);
}
