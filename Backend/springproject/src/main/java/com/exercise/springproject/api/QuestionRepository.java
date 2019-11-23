package com.exercise.springproject.api;

import com.exercise.springproject.domain.question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionRepository extends JpaRepository<question, Integer> {
    @Query("select p from question p where p.createrid=?1")
    List<question> findQuestionByCreater(int creater);
}
