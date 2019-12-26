package com.exercise.springproject.web;

import com.exercise.springproject.domain.StudentCourse;
import com.exercise.springproject.service.StudentCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RestController
public class StudentCourseController {
    @Autowired
    private StudentCourseService studentCourseService;

    @PostMapping("student_course")
    @ResponseBody
    public List<StudentCourse> findCourse(@RequestBody Integer ids){
        List<StudentCourse> reply = studentCourseService.findCourseByid_student(ids);
        return reply;
    }
}
