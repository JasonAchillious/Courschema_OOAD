package com.exercise.springproject.service;

import com.exercise.springproject.api.AnswerRepository;
import com.exercise.springproject.domain.answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {
    @Autowired
    private AnswerRepository answerRepository;
    @Override
    public List<answer> findAll() {
        return answerRepository.findAll();
    }

    @Override
    public answer save(answer answer) {
        return answerRepository.save(answer);
    }

    @Override
    public void deleteById(int id) {
        answerRepository.deleteById(id);
    }

    @Override
    public List<answer> findAnswerByQuestionid(int questionId) {
        return answerRepository.findAnswerByQuestionid(questionId);
    }

    @Override
    public List<answer> findAnswerByStuid(int stuId) {
        return answerRepository.findAnswerByStuid(stuId);
    }
}
