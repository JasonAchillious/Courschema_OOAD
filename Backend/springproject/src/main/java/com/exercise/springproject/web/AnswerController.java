package com.exercise.springproject.web;

import com.exercise.springproject.domain.answer;
import com.exercise.springproject.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/ans")

public class AnswerController {
    @Autowired
    private AnswerService answerService;

    @GetMapping("/all")
    public List<answer> findAllAnswer(){
        //tested
        return answerService.findAll();
    }

    @PostMapping("/record")
    public answer addOne(answer answer){
        return answerService.save(answer);
    }

    @PutMapping("/record")
    public answer update(  @RequestParam int stuId,
                           @RequestParam String content,
                           @RequestParam int questionId,
                         @RequestParam boolean identity,
                         @RequestParam int adminId,
                         @RequestParam int ansId){
        answer answer = new answer();
        answer.setAdminid(adminId);
        answer.setContent(content);
        answer.setIdentity(identity);
        answer.setStuid(stuId);
        answer.setAnsid(ansId);
        answer.setQuestionid(questionId);
        return answerService.save(answer);
    }

    @DeleteMapping("record/{id}")
    public void deleteOneAnswer(int ansId){
        answerService.deleteById(ansId);
    }


    @PostMapping("findAnswerByQuestionId")
    public List<answer> findAnswerByQuestionid(@RequestParam int questionId){
        return answerService.findAnswerByQuestionid(questionId);
    }

    @PostMapping("findAnswerByStuId")
    public List<answer> findAnswerByStuid(@RequestParam int stuId){
        return answerService.findAnswerByStuid(stuId);
    }

}
