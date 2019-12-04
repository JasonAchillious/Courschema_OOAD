package com.exercise.springproject.api;

import com.exercise.springproject.domain.secretary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SecretaryRepository extends JpaRepository<secretary, Integer> {
    public secretary findSecretaryById(int Id);
}
