package com.exercise.springproject.service;

import com.exercise.springproject.domain.answer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AnswerService {
    public List<answer> findAll();
    public answer save(answer question);
    public void deleteById(int id);
    public List<answer> findAnswerByQuestionid(int questionId);
    public List<answer> findAnswerByStuid(int stuId);
}
