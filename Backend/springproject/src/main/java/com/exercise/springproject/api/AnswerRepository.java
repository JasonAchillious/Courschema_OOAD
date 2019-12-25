package com.exercise.springproject.api;

import com.exercise.springproject.domain.answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface AnswerRepository extends JpaRepository<answer, Integer> {
    @Query(value = "select p from answer p where p.questionid=?1")
    public List<answer> findAnswerByQuestionid(int id);

    @Query(value = "select p from answer p where p.ansid=?1")
    public answer findAnswerByAnswerId(int id);

    @Modifying
    @Transactional
    @Query(value = "delete from answer where questionid=?1")
    public void deleteByAnswerByQuestion(int id);
}
