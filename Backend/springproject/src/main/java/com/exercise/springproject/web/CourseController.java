package com.exercise.springproject.web;

import com.exercise.springproject.domain.*;
import com.exercise.springproject.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/recordCourse")
    public List<Course> findAllCourse(){
        return courseService.findAll();
    }

    @PostMapping("/recordClassification")
    public Course addOne(Course course){
        return courseService.save(course);
    }

    @PutMapping("/recordClassification")
    public Course update(@RequestParam int idCourse,
                                 @RequestParam int courschema,
                                 @RequestParam String code,
                                 @RequestParam String chineseName,
                         @RequestParam String intro,
                         @RequestParam double credit,
                         @RequestParam byte spring,
                         @RequestParam byte autumn,
                         @RequestParam byte summer,
                         @RequestParam String englishName,
                         @RequestParam int year){
        Course course = new Course();
        course.setIdCourse(idCourse);
        course.setAutumn(autumn);
        course.setChineseName(chineseName);
        course.setCode(code);
        course.setCredit(credit);
        course.setEnglishName(englishName);
        course.setIntro(intro);
        course.setSpring(spring);
        course.setSummer(summer);
        course.setYear(year);

        return courseService.save(course);
    }

    @PostMapping("findCourse")
    public Course findCourseById(@RequestParam int idCourse){
        return courseService.findCourseById(idCourse);
    }

    @PostMapping("findCourseCname")
    public String findCourseCnameById(@RequestParam int idCourse){
        return courseService.findCourseById(idCourse).getChineseName();
    }
    
    @PostMapping("findCourseDepartment")
    public List<Course> findCourseDepartment(@RequestParam int idDepartment){
        return courseService.findCourseByDepartment(idDepartment);
    }

    @PostMapping(value = "/show_course")
    @ResponseBody
    public Map handle(@RequestBody Integer courseID){
        Map <String,Object> reply = new HashMap<String,Object>();
        //Class t = json_map.get("id").getClass();
        // System.out.println(t.getName());
        Course ans = courseService.findCourseById(courseID);

        reply.put("courseID", courseID);
        reply.put("courseName", ans.getChineseName());
        reply.put("courseScore", ans.getCredit());
        //reply.put("experimentScore", ans.);
       // reply.put("weekLearningTime", ans.);
        reply.put("AdviceTerm:", ans.getYear());
        //reply.put("courseLang", ans.);
        String term = "";
        if(ans.getAutumn()==1){
            term.concat("autumn");
        }
        if(ans.getSpring()==1){
            term.concat(", spring");
        }
        if(ans.getSummer()==1){
            term.concat(", spring");
        }
        reply.put("SetTerm", term);
        //reply.put("preCourse", s.getEnglishLevel());
        //reply.put("institute", );
        //reply.put("introduction",ans.getIntro());
        return reply;
    }

}
