package com.exercise.springproject.api;

import com.exercise.springproject.domain.secretary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SecretaryRepository extends JpaRepository<secretary, Integer> {
    public secretary findSecretaryById(int Id);
    @Query("select p from secretary p where p.department=?1")
    public secretary findsecretaryByDepartment(int de);
}
