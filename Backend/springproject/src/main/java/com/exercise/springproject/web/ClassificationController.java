package com.exercise.springproject.web;

import com.exercise.springproject.domain.Classification;
import com.exercise.springproject.domain.SchemaEdit;
import com.exercise.springproject.domain.courschemas;
import com.exercise.springproject.service.ClassificationService;
import com.exercise.springproject.service.CourschemasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/cla")
public class ClassificationController {
    @Autowired
    private ClassificationService classificationService;
    @Autowired
    private CourschemasService courschemasService;

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

    @PostMapping("findXuanXiuCourse")
    public List<Integer> findXuanXiuCourse(@RequestParam int courschema){
        return classificationService.findTypeXuanXiuCourse(courschema);
    }


    @PostMapping(value = "/showClassification")
    @ResponseBody
    public SchemaEdit handle(@RequestBody Integer schema_id){
        SchemaEdit reply = new SchemaEdit();
        reply.setTongshi(findTonCourse(schema_id));
        reply.setRuxi(findRuxiCourse(schema_id));
        reply.setBixiu(findComCourse(schema_id));
        reply.setXuanxiu(findXuanXiuCourse(schema_id));
        courschemas schema = courschemasService.findCourschema(schema_id);
        reply.setXuanxiu_credit(schema.getMajor_elec());
        reply.setRenwen_credit(schema.getHU_elec());
        reply.setSheke_credit(schema.getAR_elec());
        reply.setXuanxiu(null);
        return reply;
    }

    @PostMapping(value = "/editClassification")
    @ResponseBody
    public void handleedit(@RequestBody Integer schema_id,
                           @RequestBody SchemaEdit newEdit){
        //save newEdit to database
        //maybe first delete from database, then add
        courschemas editting = courschemasService.findCourschema(schema_id);
        editting.setHU_elec(newEdit.getRenwen_credit());
        editting.setAR_elec(newEdit.getSheke_credit());
        editting.setMajor_elec(newEdit.getXuanxiu_credit());
        for(int now: findComCourse(schema_id)){
            //old compulsorys
            classificationService.deleteCourseClass(now, schema_id);
        }
        for(int now: newEdit.getBixiu()){
            Classification cla = new Classification();
            cla.setCompulsory((byte)1);
            cla.setCourschema(schema_id);
            cla.setIdCourse(now);
            cla.setRu_xi((byte)0);
            cla.setTongshi((byte)0);
            classificationService.save(cla);
        }
        for(int now: findRuxiCourse(schema_id)){
            //old ruxi
            classificationService.deleteCourseClass(now, schema_id);
        }
        for(int now: newEdit.getRuxi()){
            Classification cla = new Classification();
            cla.setCompulsory((byte)0);
            cla.setCourschema(schema_id);
            cla.setIdCourse(now);
            cla.setRu_xi((byte)1);
            cla.setTongshi((byte)0);
            classificationService.save(cla);
        }
        for(int now: findTonCourse(schema_id)){
            //old tongshi
            classificationService.deleteCourseClass(now, schema_id);
        }
        for(int now: newEdit.getTongshi()){
            Classification cla = new Classification();
            cla.setCompulsory((byte)0);
            cla.setCourschema(schema_id);
            cla.setIdCourse(now);
            cla.setRu_xi((byte)0);
            cla.setTongshi((byte)1);
            classificationService.save(cla);
        }
        for(int now: findXuanXiuCourse(schema_id)){
            //old xuanxiu
            classificationService.deleteCourseClass(now, schema_id);
        }
        for(int now: newEdit.getXuanxiu()){
            Classification cla = new Classification();
            cla.setCompulsory((byte)0);
            cla.setCourschema(schema_id);
            cla.setIdCourse(now);
            cla.setRu_xi((byte)0);
            cla.setTongshi((byte)1);
            classificationService.save(cla);
        }


    }
}
