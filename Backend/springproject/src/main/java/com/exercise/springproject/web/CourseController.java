package com.exercise.springproject.web;

import com.exercise.springproject.domain.*;
import com.exercise.springproject.service.CourseService;
import com.exercise.springproject.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class CourseController {
    @Autowired
    private CourseService courseService;
    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/recordCourse")
    public List<Course> findAllCourse(){
        return courseService.findAll();
    }

    @GetMapping("/allcourse")
    @ResponseBody
    public List<Map> allcourse(){
        List<Course> tmp =  courseService.findAll();
        List<Map> reply = new LinkedList<>();
        for(Course now: tmp){
            Map<String, Object> temp = new HashMap<String,Object>();
            temp.put("chineseName",now.getChineseName());
            temp.put("idCourse", now.getIdCourse());
            temp.put("BianHao", now.getBianHao());
            temp.put("intro",now.getIntro());
            temp.put("credit", now.getCredit());
            temp.put("spring", now.getSpring());
            temp.put("autumn", now.getAutumn());
            temp.put("summer", now.getSummer());
            temp.put("englishName", now.getEnglishName());
            temp.put("year", now.getNian());
            temp.put("department", now.getDepartment_name());
            reply.add(temp);
        }
        return reply;
    }

    @PostMapping("/saveCourse")
    @ResponseBody
    public Course savecourse(Map<String, Object> json_map){
            Course newcourse = new Course();
            newcourse.setChineseName((String) json_map.get("chineseName"));
            newcourse.setBianHao((String) json_map.get("code"));
            newcourse.setIntro((String) json_map.get("intro"));
            newcourse.setCredit((Double) json_map.get("credit"));
            newcourse.setSummer((Byte) json_map.get("summer"));
            newcourse.setSpring((Byte) json_map.get("spring"));
            newcourse.setAutumn((Byte) json_map.get("autumn"));
            newcourse.setEnglishName((String) json_map.get("englishName"));
            newcourse.setNian((int) json_map.get("year"));
           // temp.put("idCourse", now.getIdCourse());
            String depart = (String) json_map.get("department");
            Department de = departmentService.findDepartmentByName(depart);
            newcourse.setDepartment(de.getIdDepartment());

            return courseService.save(newcourse);
    }

//    @PostMapping(value="/saveCourschemas")
//    @ResponseBody
//    public Course saveCourse(@RequestParam Map<String, Object> json){
//        Course course = new Course();
//        course.setAutumn((Byte) json.get("autumn"));
//        course.setChineseName((String) json.get("ChineseName"));
//        course.setCode((String)json.get("code"));
//        course.setCredit((Double) json.get("credit"));
//        course.setEnglishName((String)json.get("EnglighName"));
//        course.setIdCourse((int)json.get("idCourse"));
//        course.setIntro((String)json.get("intro"));
//        course.setYear((int)json.get("year"));
//        course.setSpring((Byte)json.get("spring"));
//        course.setSummer((Byte)json.get("summer"));
//        course.setDepartment((int)json.get("department"));
//        return courseService.save(course);
//    }

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
        course.setBianHao(code);
        course.setCredit(credit);
        course.setEnglishName(englishName);
        course.setIntro(intro);
        course.setSpring(spring);
        course.setSummer(summer);
        course.setNian(year);

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


    @PostMapping("/coursebydepart")
    @ResponseBody
    public List<Course> coursebyDepart(@RequestBody Integer id){
        return courseService.findCourseByDepartment(id);
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
        reply.put("AdviceTerm:", ans.getNian());
        //reply.put("courseLang", ans.);
        String term = "";
        if(ans.getAutumn()==1){
            term.concat(" autumn");
        }
        if(ans.getSpring()==1){
            term.concat(" spring");
        }
        if(ans.getSummer()==1){
            term.concat(" spring");
        }
        reply.put("SetTerm", term);
        //reply.put("preCourse", s.getEnglishLevel());
        //reply.put("institute", );
        //reply.put("introduction",ans.getIntro());
        return reply;
    }

}
