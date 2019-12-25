package com.exercise.springproject.api;

import com.exercise.springproject.domain.question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface QuestionRepository extends JpaRepository<question, Integer> {
    @Query("select p from question p where p.createrid=?1")
    List<question> findQuestionByCreater(int creater);
    @Query(value = "select p from question p where p.questionid=?1")
    question findQuestionById(int id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE answer SET adminid=?2, content=?3, answerDate=?4 WHERE ansid=?1")
    void update(int id, int adminid, String c, String time);
}
