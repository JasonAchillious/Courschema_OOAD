package com.exercise.springproject.api;

import com.exercise.springproject.domain.answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AnswerRepository extends JpaRepository<answer, Integer> {
    @Query("select p from answer p where p.questionid=?1")
    public List<answer> findAnswerByQuestionid(int id);

    @Query("select p from answer p where p.stuid=?1")
    public List<answer> findAnswerByStuid(int id);
}
