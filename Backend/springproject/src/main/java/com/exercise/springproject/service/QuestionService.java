package com.exercise.springproject.service;

import com.exercise.springproject.domain.question;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QuestionService {
    public List<question> findAll();
    public question save(question question);
    public void deleteById(int id);
    public List<question> findQuestionByCreater(int creater);
    public question findQuestionById(int id);
    public void update(int id, int adminid, String content, String time);
    public void deleteQuestionByAnswer(int aId);
}
