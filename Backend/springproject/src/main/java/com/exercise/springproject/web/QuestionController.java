package com.exercise.springproject.web;

import com.exercise.springproject.domain.Admin;
import com.exercise.springproject.domain.answer;
import com.exercise.springproject.domain.question;
import com.exercise.springproject.domain.student;
import com.exercise.springproject.service.AdminService;
import com.exercise.springproject.service.AnswerService;
import com.exercise.springproject.service.QuestionService;
import com.exercise.springproject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.*;

@Controller
@RestController

public class QuestionController {
    @Autowired
    private QuestionService questionService;
    @Autowired
    private AnswerService answerService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private AdminService adminService;


    @GetMapping("/QandA_student/getQuestions")
    @ResponseBody
    public List<Map> getQuestions(){
        List<question> search = questionService.findAll();
        List<Map> reply = new ArrayList<Map>();
        for(question q : search){
            Map<String, Object> now = new HashMap<>();
            int questionUserID = q.getCreaterid();
            //默认是student
            student s = studentService.findStudentByid_student(questionUserID);
            now.put("questionUserId", questionUserID);
            now.put("questionUserName", s.getName());
            now.put("releaseDate", q.getReleaseTime());
            now.put("questionId", q.getQuestionid());
            now.put("questionContent", q.getqContent());
            if(q.getHasAnswer()==(byte)1) {
                now.put("hasAnswer", true);
                int ansId = q.getAnswerId();
                answer a = answerService.findAnswerByAnswerId(ansId);
                now.put("answerUserId",a.getAdminid());
                //默认是管理员
                System.out.println(a.getAdminid());
                Admin admin = adminService.findAdminByIdAdmin(a.getAdminid());
                now.put("answerUserName",admin.getName());
                now.put("answerDate", a.getAnswerDate());
                now.put("answerContent", a.getContent());
            }
            else{
                now.put("hasAnswer", false);
            }
            reply.add(now);
        }
        return reply;
    }

    @PostMapping("QandA_student/askQuestion")
    @ResponseBody
    public Map askQuestions(@RequestBody Map<String, Object> json_map){
        int id = (int) json_map.get("studentId");
        String ques = (String) json_map.get("questionAsk");
        question now = new question();
        now.setCreaterid(id);
        now.setqContent(ques);
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(sdf.format(date));
        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(date));
        now.setReleaseTime(sdf.format(date));
        Map<String, Object> tmp = new HashMap<>();
        try {
            questionService.save(now);
            tmp.put("state","success");
        }
        catch (Exception e){
            tmp.put("state","fail");
        }
        int questionUserID = now.getCreaterid();
        //默认是student
        student s = studentService.findStudentByid_student(questionUserID);
        tmp.put("questionUserId", questionUserID);
        tmp.put("questionUserName", s.getName());
        tmp.put("releaseDate", now.getReleaseTime());
        tmp.put("questionId", now.getQuestionid());
        tmp.put("questionContent", now.getqContent());
        if(now.getHasAnswer()==(byte)1) {
            int ansId = now.getAnswerId();
            answer a = answerService.findAnswerByAnswerId(ansId);
            tmp.put("hasAnswer", true);
            tmp.put("answerUserId",a.getAdminid());
            //默认是管理员
            Admin admin = adminService.findAdminByIdAdmin(a.getAdminid());
            tmp.put("answerUserName",admin.getName());
            tmp.put("answerdate", a.getAnswerDate());
            tmp.put("answerContent", a.getContent());
        }
        else{
            tmp.put("hasAnswer", false);
        }
        return tmp;
    }

    @PostMapping("/QandA_getInfo")
    @ResponseBody
    public Map getinfo(@RequestBody Map<String, Object> json){
        Map<String,Object> ans = new HashMap<>();
        int id = (int) json.get("userId");
        ans.put("userId", id);
        List<Map> reply = new ArrayList<Map>();
        List<question> search = questionService.findAll();
        for(question q : search){
            Map<String, Object> now = new HashMap<>();
            int questionUserID = q.getCreaterid();
            //默认是student
            student s = studentService.findStudentByid_student(questionUserID);
            now.put("questionUserId", questionUserID);
            now.put("questionUserName", s.getName());
            now.put("releaseDate", q.getReleaseTime());
            now.put("questionId", q.getQuestionid());
            now.put("questionContent", q.getqContent());
            if(q.getHasAnswer()==(byte)1) {
                now.put("hasAnswer", true);
                int ansId = q.getAnswerId();
                answer a = answerService.findAnswerByAnswerId(ansId);
                now.put("answerUserId",a.getAdminid());
                //默认是管理员
                System.out.println(a.getAdminid());
                Admin admin = adminService.findAdminByIdAdmin(a.getAdminid());
                now.put("answerUserName",admin.getName());
                now.put("answerDate", a.getAnswerDate());
                now.put("answerContent", a.getContent());
            }
            else{
                now.put("hasAnswer", false);
            }
            reply.add(now);
        }
        ans.put("questions", reply);
        return ans;

    }

    @PostMapping("/QandA_admin/addAnswer")
    @ResponseBody
    public Map addQuestion(@RequestBody Map json) {
        System.out.println(json.get("adminId"));
        int id = (int) json.get("adminId");
        int qId = (int) json.get("questionId");
        String c = (String) json.get("answerContent");
        answer now = new answer();
        question qnow = questionService.findQuestionById(qId);
        now.setQuestionid(qId);
        now.setAdminid(id);
        now.setContent(c);
        System.out.println("ansid: ");
        System.out.println(now.getAnsid());
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(sdf.format(date));
        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        now.setAnswerDate(sdf.format(date));
        answerService.save(now);
        questionService.deleteById(qId);
        qnow.setHasAnswer((byte)1);
        qnow.setAnswerId(now.getAnsid());
        questionService.save(qnow);
        List<question> question = questionService.findAll();
        List<Map> array = new ArrayList();
        for(question q: question){
            Map<String, Object> tmp = new HashMap<>();
            int questionUserID = q.getCreaterid();
            //默认是student
            student s = studentService.findStudentByid_student(questionUserID);
            tmp.put("questionUserId", questionUserID);
            tmp.put("questionUserName", s.getName());
            tmp.put("releaseDate", q.getReleaseTime());
            tmp.put("questionId", q.getQuestionid());
            tmp.put("questionContent", q.getqContent());
            if(q.getHasAnswer()==(byte)1) {
                tmp.put("hasAnswer", true);
                int ansId = q.getAnswerId();
                answer a = answerService.findAnswerByAnswerId(ansId);
                tmp.put("answerUserId",a.getAdminid());
                //默认是管理员
                Admin admin = adminService.findAdminByIdAdmin(a.getAdminid());
                tmp.put("answerUserName",admin.getName());
                tmp.put("answerdate", a.getAnswerDate());
                tmp.put("answerContent", a.getContent());
            }
            else{
                tmp.put("hasAnswer", false);
            }

            array.add(tmp);
        }
        Map<String, Object> reply = new HashMap<>();
        reply.put("state", "success");
        reply.put("questions", array);
        return reply;

    }
    @PostMapping("/QandA_admin/updateAnswer")
    @ResponseBody
    public Map updateQuestion(@RequestBody Map json){
        int id = (int) json.get("adminId");
        int qId = (int) json.get("questionId");
        String  c = (String) json.get("answerContent");
        //question update: answer 的内容时间改掉
        question qnow = questionService.findQuestionById(qId);
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        questionService.update(qnow.getAnswerId(), id, c, sdf.format(date));
        System.out.println("debug");
        System.out.println(qnow.getAnswerId());
        System.out.println(id);
        System.out.println(c);
        System.out.println(sdf.format(date));
        Map<String, Object> reply = new HashMap<>();
        try{
            reply.put("state", "success");
        }
        catch (Exception e){
            reply.put("state", "fail");
        }
        List<question> question = questionService.findAll();
        List<Map> array = new ArrayList();
        for(question q: question){
            Map<String, Object> tmp = new HashMap<>();
            int questionUserID = q.getCreaterid();
            //默认是student
            student s = studentService.findStudentByid_student(questionUserID);
            tmp.put("questionUserId", questionUserID);
            tmp.put("questionUserName", s.getName());
            tmp.put("releaseDate", q.getReleaseTime());
            tmp.put("questionId", q.getQuestionid());
            tmp.put("questionContent", q.getqContent());
            if(q.getHasAnswer()==(byte)1) {
                tmp.put("hasAnswer", true);
                int ansId = q.getAnswerId();
                answer a = answerService.findAnswerByAnswerId(ansId);
                tmp.put("answerUserId",a.getAdminid());
                //默认是管理员
                Admin admin = adminService.findAdminByIdAdmin(a.getAdminid());
                tmp.put("answerUserName",admin.getName());
                tmp.put("answerdate", a.getAnswerDate());
                tmp.put("answerContent", a.getContent());
            }
            else{
                tmp.put("hasAnswer", false);
            }

            array.add(tmp);
        }
        reply.put("questions", array);
        return reply;

    }

    @PostMapping("/QandA_student/deleteQuestion")
    @ResponseBody
    public Map<String, Object> deleteQ(@RequestBody Map<String, Object> json){
        //删answer with this question id
        //删question
        int qId = (int) json.get("questionID");
        Map<String, Object> reply = new HashMap<>();
        try {
            answerService.deleteByAnswerByQuestion(qId);
            questionService.deleteById(qId);
            reply.put("state", "success");
        }catch(Exception e){
            reply.put("state", "fail");
        }
        List<question> question = questionService.findAll();
        List<Map> array = new ArrayList();
        for(question q: question){
            Map<String, Object> tmp = new HashMap<>();
            int questionUserID = q.getCreaterid();
            //默认是student
            student s = studentService.findStudentByid_student(questionUserID);
            tmp.put("questionUserId", questionUserID);
            tmp.put("questionUserName", s.getName());
            tmp.put("releaseDate", q.getReleaseTime());
            tmp.put("questionId", q.getQuestionid());
            tmp.put("questionContent", q.getqContent());
            if(q.getHasAnswer()==(byte)1) {
                tmp.put("hasAnswer", true);
                int ansId = q.getAnswerId();
                answer a = answerService.findAnswerByAnswerId(ansId);
                tmp.put("answerUserId",a.getAdminid());
                //默认是管理员
                Admin admin = adminService.findAdminByIdAdmin(a.getAdminid());
                tmp.put("answerUserName",admin.getName());
                tmp.put("answerdate", a.getAnswerDate());
                tmp.put("answerContent", a.getContent());
            }
            else{
                tmp.put("hasAnswer", false);
            }
            array.add(tmp);
        }
        reply.put("questions", array);
        return reply;

    }


    @PostMapping("/QandA_admin/deleteAnswer")
    @ResponseBody
    public Map<String, Object> deleteA(@RequestBody Map<String, Object> json){
        //有此answer的question先改
        //再删除answer
        int qId = (int) json.get("questionID");
        System.out.println((int) json.get("questionID"));
        int aId = questionService.findQuestionById(qId).getAnswerId();
        Map<String, Object> reply = new HashMap<>();
        try {
            questionService.deleteQuestionByAnswer(aId);
            reply.put("state", "success");
        }catch(Exception e){
            reply.put("state", "fail");
        }
        answerService.deleteById(aId);
        List<question> question = questionService.findAll();
        List<Map> array = new ArrayList();
        for(question q: question){
            Map<String, Object> tmp = new HashMap<>();
            int questionUserID = q.getCreaterid();
            //默认是student
            student s = studentService.findStudentByid_student(questionUserID);
            tmp.put("questionUserId", questionUserID);
            tmp.put("questionUserName", s.getName());
            tmp.put("releaseDate", q.getReleaseTime());
            tmp.put("questionId", q.getQuestionid());
            tmp.put("questionContent", q.getqContent());
            if(q.getHasAnswer()==(byte)1) {
                tmp.put("hasAnswer", true);
                int ansId = q.getAnswerId();
                answer a = answerService.findAnswerByAnswerId(ansId);
                tmp.put("answerUserId",a.getAdminid());
                //默认是管理员
                Admin admin = adminService.findAdminByIdAdmin(a.getAdminid());
                tmp.put("answerUserName",admin.getName());
                tmp.put("answerdate", a.getAnswerDate());
                tmp.put("answerContent", a.getContent());
            }
            else{
                tmp.put("hasAnswer", false);
            }
            array.add(tmp);
        }
        reply.put("questions", array);
        return reply;

    }

    @GetMapping("/record")
    public List<question> findAllQuestions(){
        //tested
        return questionService.findAll();
    }


//    @PostMapping("/update")
//    @ResponseBody
//    public question update(@RequestParam String content,
//                           @RequestParam int createrId,
//                           @RequestParam int questionId){
//        System.out.println(content);
//        System.out.println(createrId);
//        System.out.println(questionId);
//        question question = new question();
//        question.setCreaterid(createrId);
//        question.setqContent(content);
//        question.setQuestionid(questionId);
//        return questionService.save(question);
//    }
    //form data

    @DeleteMapping("record/{id}")
    public void deleteOneCollection(int questionId){
        questionService.deleteById(questionId);
    }


    @PostMapping("findQuestion")
    public List<question> findQuestionByCreater(@RequestParam int createrId){
        return questionService.findQuestionByCreater(createrId);
    }

}
