package com.exercise.springproject.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.exercise.springproject.domain.student;
import java.util.*;

@Controller
public class send_data {
    @RequestMapping("/test111")
    @ResponseBody
    public List<student> getStudents() {
        List<student> stus = new ArrayList<>();
        stus.add(new student(10,"send",1, 3, "2"));
        return stus;
    }
}