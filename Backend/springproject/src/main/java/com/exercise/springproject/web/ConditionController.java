package com.exercise.springproject.web;

import com.exercise.springproject.domain.Xianxiu_condition;
import com.exercise.springproject.domain.courschemas;
import com.exercise.springproject.domain.graduate_condition;
import com.exercise.springproject.service.GraduateService;
import com.exercise.springproject.service.XianxiuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
public class ConditionController {
    @Autowired
    private GraduateService graduateService;
    @Autowired
    private XianxiuService xianxiuService;

    @GetMapping("/ByCourseGraduationCondition")
    public List<graduate_condition> findGraduationConditionByCourse(int idCourse){
        return graduateService.findgraduate_conditionByIdCourse(idCourse);
    }

    @GetMapping("/BySchemaGraduationCondition")
    public List<graduate_condition> findGraduationConditionBySchema(int schema){
        return graduateService.findgraduate_conditionByCourschema(schema);
    }

    @GetMapping("/SpecificGraduationCondition")
    public graduate_condition findGraduationCondition(int course, int schema){
        return graduateService.findgraduate_conditionByIdCourseAndCourschema(course, schema);
    }

    @GetMapping("/ByCourseXianxiuCondition")
    public List<Xianxiu_condition> findXianxiuConditionByCourse(int idCourse){
        return xianxiuService.findXianxiu_conditionByIdCourse(idCourse);
    }

    @GetMapping("/BySchemaXianxiuCondition")
    public List<Xianxiu_condition> findXianxiuConditionBySchema(int schema){
        return xianxiuService.findXianxiu_conditionByCourschema(schema);
    }

    @GetMapping("/SpecificXianxiuCondition")
    public Xianxiu_condition findXianxiuCondition(int course, int schema){
        return xianxiuService.findXianxiu_conditionByIdCourseAndCourschema(course, schema);
    }

    @PostMapping("/recordGraduateCondition")
    public graduate_condition addOne(graduate_condition gra){
        return graduateService.save(gra);
    }

    @PutMapping("/recordGraduateCondition")
    public graduate_condition updateGraduate(@RequestParam int course_id,
                              @RequestParam int courschema,
                              @RequestParam String conditionString){
        graduate_condition gra = new graduate_condition();
        gra.setIdCourse(course_id);
        gra.setCourschema(courschema);
        gra.setConditionString(conditionString);
        return graduateService.save(gra);
    }

    @PostMapping("/recordXianxiuCondition")
    public Xianxiu_condition addOne(Xianxiu_condition xian){
        return xianxiuService.save(xian);
    }

    @PutMapping("/recordXianxiuCondition")
    public Xianxiu_condition updateXianxiu(@RequestParam int course_id,
                                     @RequestParam int courschema,
                                     @RequestParam String conditionString){
        Xianxiu_condition xian = new Xianxiu_condition();
        xian.setIdCourse(course_id);
        xian.setCourschema(courschema);
        xian.setConditionString(conditionString);
        return xianxiuService.save(xian);
    }



}
