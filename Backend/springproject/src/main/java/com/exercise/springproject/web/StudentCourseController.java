package com.exercise.springproject.web;

import com.exercise.springproject.domain.Course;
import com.exercise.springproject.domain.StudentCourse;
import com.exercise.springproject.service.CourseService;
import com.exercise.springproject.service.StudentCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RestController
public class StudentCourseController {
    @Autowired
    private StudentCourseService studentCourseService;
    @Autowired
    private CourseService courseService;

    @PostMapping("student_course")
    @ResponseBody
    public List<Map> findCourse(@RequestBody Integer ids){
        List<StudentCourse> search =  studentCourseService.findCourseByid_student(ids);
        List<Map> reply = new ArrayList<>();
        for(StudentCourse sc: search){
            Map<String, Object> tmp = new HashMap<>();
            int id = sc.getId_course();
            Course c = courseService.findCourseById(id);
            tmp.put("id_course", sc.getId_course());
            tmp.put("ChineseName", c.getChineseName());
        }
        return reply;
    }
}
