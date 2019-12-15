package com.exercise.springproject.web;

import com.exercise.springproject.domain.*;
import com.exercise.springproject.service.ClassificationService;
import com.exercise.springproject.service.CourschemasService;
import com.exercise.springproject.service.CourseService;
import com.exercise.springproject.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cla")
public class ClassificationController {
    @Autowired
    private ClassificationService classificationService;
    @Autowired
    private CourschemasService courschemasService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private DepartmentService departmentService;

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

    @PostMapping("findPoliticalCourse")
    public List<Integer> findPoliticalCourse(@RequestParam int courschema){
        return classificationService.findPoliticalCourse(courschema);
    }

    @PostMapping(value = "/showClassification")
    @ResponseBody
    public SchemaEdit handle(@RequestBody Map<String,Integer> mapid){
        int schema_id = mapid.get("id");

        SchemaEdit reply = new SchemaEdit();
        List<Map> tongshi = new ArrayList<Map>();
        List<Integer> t = findTonCourse(schema_id);
        for(int tmp: t){
            Map<String, Object> temp = new HashMap<>();
            Course now = courseService.findCourseById(tmp);
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
            int de = now.getDepartment();
            Department department = departmentService.findDepartmentById(de);
            temp.put("department", department.getChineseName());
            tongshi.add(temp);
        }
        reply.setTongshi(tongshi);

        List<Map> Ruxi = new ArrayList<Map>();
        List<Integer> r = findRuxiCourse(schema_id);
        for(int tmp: r){
            Map<String, Object> temp = new HashMap<>();
            Course now = courseService.findCourseById(tmp);
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
            int de = now.getDepartment();
            Department department = departmentService.findDepartmentById(de);
            temp.put("department", department.getChineseName());
            Ruxi.add(temp);
        }
        reply.setRuxi(Ruxi);

        List<Map> Bixiu = new ArrayList<Map>();
        List<Integer> b = findComCourse(schema_id);
        for(int tmp: b){
            Map<String, Object> temp = new HashMap<>();
            Course now = courseService.findCourseById(tmp);
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
            int de = now.getDepartment();
            Department department = departmentService.findDepartmentById(de);
            temp.put("department", department.getChineseName());
            Bixiu.add(temp);
        }
        reply.setBixiu(Bixiu);

        List<Map> Xuanxiu = new ArrayList<Map>();
        List<Integer> x = findXuanXiuCourse(schema_id);
        for(int tmp: x){
            Map<String, Object> temp = new HashMap<>();
            Course now = courseService.findCourseById(tmp);
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
            int de = now.getDepartment();
            Department department = departmentService.findDepartmentById(de);
            temp.put("department", department.getChineseName());
            Xuanxiu.add(temp);
        }

        reply.setXuanxiu(Xuanxiu);

        reply.setId(schema_id);

        List<Map> political = new ArrayList<Map>();
        List<Integer> p = findPoliticalCourse(schema_id);
        for(int tmp: p){
            Map<String, Object> temp = new HashMap<>();
            Course now = courseService.findCourseById(tmp);
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
            int de = now.getDepartment();
            Department department = departmentService.findDepartmentById(de);
            temp.put("department", department.getChineseName());
            political.add(temp);
        }
        reply.setPolitical(political);

        return reply;
    }

    @PostMapping(value = "/editClassification")
    @ResponseBody
    public String handleedit(@RequestBody SchemaEdit newEdit){
        //save newEdit to database
        //maybe first delete from database, then add
        int schemaId = newEdit.getId();
        for(int now: findComCourse(schemaId)){
            //old compulsorys
            classificationService.deleteCourseClass(now, schemaId);
        }
        for(Map c: newEdit.getBixiu()){
            Classification cla = new Classification();
            cla.setCompulsory((byte)1);
            cla.setCourschema(schemaId);
            cla.setIdCourse((Integer) c.get("idCourse"));
            cla.setRu_xi((byte)0);
            cla.setTongshi((byte)0);
            classificationService.save(cla);
        }
        for(int now: findRuxiCourse(schemaId)){
            //old ruxi
            System.out.println(now);
            classificationService.deleteCourseClass(now, schemaId);
        }
        for(Map m: newEdit.getRuxi()){
            Classification cla = new Classification();
            cla.setCompulsory((byte)0);
            cla.setCourschema(schemaId);
            cla.setIdCourse((Integer) m.get("idCourse"));
            cla.setRu_xi((byte)1);
            cla.setTongshi((byte)0);
            classificationService.save(cla);
        }
        for(int now: findTonCourse(schemaId)){
            //old tongshi
            classificationService.deleteCourseClass(now, schemaId);
        }
        for(Map m: newEdit.getTongshi()){
            Classification cla = new Classification();
            cla.setCompulsory((byte)0);
            cla.setCourschema(schemaId);
            cla.setIdCourse((Integer) m.get("idCourse"));
            cla.setRu_xi((byte)0);
            cla.setTongshi((byte)1);
            classificationService.save(cla);
        }
        for(int now: findXuanXiuCourse(schemaId)){
            //old xuanxiu
            classificationService.deleteCourseClass(now, schemaId);
        }
        for(Map m: newEdit.getXuanxiu()){
            Classification cla = new Classification();
            cla.setCompulsory((byte)0);
            cla.setCourschema(schemaId);
            cla.setIdCourse((Integer) m.get("idCourse"));
            cla.setRu_xi((byte)0);
            cla.setTongshi((byte)1);
            classificationService.save(cla);
        }
        for(int now: findPoliticalCourse(schemaId)){
            //old xuanxiu
            classificationService.deleteCourseClass(now, schemaId);
        }
        for(Map m: newEdit.getPolitical()){
            Classification cla = new Classification();
            cla.setCompulsory((byte)0);
            cla.setCourschema(schemaId);
            cla.setIdCourse((Integer) m.get("idCourse"));
            cla.setRu_xi((byte)0);
            cla.setTongshi((byte)0);
            cla.setPolitical((byte)1);
            classificationService.save(cla);
        }

        return "success";
    }
}
