package com.exercise.springproject.web;

import com.exercise.springproject.domain.courschemas;
import com.exercise.springproject.service.CourschemasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@Controller
@RestController
@RequestMapping("/exer")
public class CourschemasController {
    @Autowired
    private CourschemasService courschemasService;

    @GetMapping("/recordCourschemas")
    public List<courschemas> findAllCourschemas(){
        return courschemasService.findAll();
    }


    @PostMapping("/recordCourschemas")
    public courschemas addOne(courschemas courschemas){
        return courschemasService.save(courschemas);
    }

    @PutMapping("/recordCourschemas")
    public courschemas update(@RequestParam int courschema,
                              @RequestParam int Foreign,
                              @RequestParam int one_plus3,
                              @RequestParam int major_elec_art,
                              @RequestParam int altered_course1,
                              @RequestParam int altered_course2,
                              @RequestParam int Major,
                              @RequestParam int Year,
                              @RequestParam int Department,
                              @RequestParam int major_elec,
                              @RequestParam int HU_elec,
                              @RequestParam int SS_elec,
                              @RequestParam int AR_elec,
                              @RequestParam int political,
                              @RequestParam String ChineseName){
        courschemas courschemas = new courschemas();
        courschemas.setCourschema(courschema);
        courschemas.setAltered_course1(altered_course1);
        courschemas.setAltered_course2(altered_course2);
        courschemas.setAR_elec(AR_elec);
        courschemas.setChineseName(ChineseName);
        courschemas.setDepartment(Department);
        courschemas.setForeign(Foreign);
        courschemas.setHU_elec(HU_elec);
        courschemas.setMajor(Major);
        courschemas.setMajor_elec(major_elec);
        courschemas.setMajor_elec_alt(major_elec_art);
        courschemas.setOne_plus3(one_plus3);
        courschemas.setPolitical(political);
        courschemas.setSS_elec(SS_elec);
        courschemas.setYear(Year);

        return courschemasService.save(courschemas);
    }

    @DeleteMapping("recordCourschemas/{courschema}")
    public void deleteCourschema(@PathVariable int courschema){
        courschemasService.deleteCourschema(courschema);
    }

    @PostMapping("findCourschemas")
    public courschemas findCourschema(@RequestParam int courschema){
        return courschemasService.findCourschema(courschema);
    }


}
