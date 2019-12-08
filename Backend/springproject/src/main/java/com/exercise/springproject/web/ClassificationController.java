package com.exercise.springproject.web;

import com.exercise.springproject.domain.Classification;
import com.exercise.springproject.domain.SchemaEdit;
import com.exercise.springproject.domain.courschemas;
import com.exercise.springproject.service.ClassificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/class")
public class ClassificationController {
    @Autowired
    private ClassificationService classificationService;

    @GetMapping("/recordClassification")
    public List<Classification> findAllClassification(){
        return classificationService.findAll();
    }

    @PostMapping("/recordClassification")
    public Classification addOne(Classification classification){
        return classificationService.save(classification);
    }

    @PutMapping("/recordClassification")
    public Classification update(@RequestParam int idCourse,
                              @RequestParam int courschema,
                                 @RequestParam Byte compusory,
                                 @RequestParam byte ruXi){
        Classification classification = new Classification();
        classification.setIdCourse(idCourse);
        classification.setCompulsory(compusory);
        classification.setRu_xi(ruXi);
        classification.setCourschema(courschema);

        return classificationService.save(classification);
    }

    @DeleteMapping("recordClassification/{classification}")
    public void deleteCourseClass(@PathVariable int idCourse, @PathVariable int courschema){
        classificationService.deleteCourseClass(idCourse, courschema);
    }

    @PostMapping("findCourschemas")
    public Classification findCourschema(@RequestParam int idCourse,
                                         @RequestParam int courschema){
        return classificationService.findCourseClass(idCourse, courschema);
    }

    @PostMapping("findSchemaCourse")
    public List<Integer> findSchemaCourse(@RequestParam int courschema){
        return classificationService.findSchemaCourse(courschema);
    }

    @PostMapping("findComCourse")
    public List<Integer> findComCourse(@RequestParam int courschema){
        return classificationService.findTypeComCourse(courschema);
    }

    @PostMapping("findRuxiCourse")
    public List<Integer> findRuxiCourse(@RequestParam int courschema){
        return classificationService.findTypeRuxiCourse(courschema);
    }

    @PostMapping("findTonCourse")
    public List<Integer> findTonCourse(@RequestParam int courschema){
        return classificationService.findTypeTonCourse(courschema);
    }


    @PostMapping(value = "/show_schema")
    @ResponseBody
    public SchemaEdit handle(@RequestBody Integer schema_id){
        SchemaEdit reply = new SchemaEdit();
        reply.setTongshi(findTonCourse(schema_id));
        reply.setRuxi(findRuxiCourse(schema_id));
        reply.setBixiu(findComCourse(schema_id));
        //reply.setXuanxiu();


        return reply;
    }

}
