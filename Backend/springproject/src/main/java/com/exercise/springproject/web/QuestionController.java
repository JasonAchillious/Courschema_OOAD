package com.exercise.springproject.web;

import com.exercise.springproject.domain.question;
import com.exercise.springproject.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/question")

public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @GetMapping("/record")
    public List<question> findAllQuestions(){
        //tested
        return questionService.findAll();
    }
    @PostMapping("/record")
    public question addOne(question question){
        return questionService.save(question);
    }

    @PutMapping("/record")
    public question update(@RequestParam String q_content,
            @RequestParam int createrId,
            @RequestParam int questionId){
        question question = new question();
        question.setCreaterid(createrId);
        question.setqContent(q_content);
        question.setQuestionid(questionId);
        return questionService.save(question);
    }

    @DeleteMapping("record/{id}")
    public void deleteOneCollection(int questionId){
        questionService.deleteById(questionId);
    }


    @PostMapping("findQuestion")
    public List<question> findQuestionByCreater(@RequestParam int createrId){
        return questionService.findQuestionByCreater(createrId);
    }

}
