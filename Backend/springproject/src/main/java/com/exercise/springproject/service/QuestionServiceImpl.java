package com.exercise.springproject.service;

import com.exercise.springproject.api.QuestionRepository;
import com.exercise.springproject.domain.question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService{
    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public List<question> findAll() {
        return questionRepository.findAll();
    }

    @Override
    public question save(question question) {
        return questionRepository.save(question);
    }

    @Override
    public void deleteById(int id) {
         questionRepository.deleteById(id);
    }

    @Override
    public List<question> findQuestionByCreater(int creater) {
        return questionRepository.findQuestionByCreater(creater);
    }

    @Override
    public question findQuestionById(int id) {
        return questionRepository.findQuestionById(id);
    }

    @Override
    public void update(int id, int adminid, String content, String time) {
        questionRepository.update(id, adminid, content, time);
    }

    @Override
    public void deleteQuestionByAnswer(int aId) {
         questionRepository.deleteQuestionByAnswer(aId);
    }
}
