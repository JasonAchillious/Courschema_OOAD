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

    @PostMapping("/update")
    @ResponseBody
    public question update(@RequestBody String content,
            @RequestBody int createrId,
            @RequestBody int questionId){
        System.out.println(content);
        System.out.println(createrId);
        System.out.println(questionId);
        question question = new question();
        question.setCreaterid(createrId);
        question.setqContent(content);
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
