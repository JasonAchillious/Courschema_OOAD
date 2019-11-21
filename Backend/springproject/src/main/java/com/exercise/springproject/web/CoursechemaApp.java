package com.exercise.springproject.web;

import com.exercise.springproject.domain.courschemas;
import com.exercise.springproject.domain.student;
import com.exercise.springproject.domain.collections;
import com.exercise.springproject.service.CollectionsService;
import com.exercise.springproject.service.CourschemasService;
import com.exercise.springproject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/exer")
public class CoursechemaApp {
    @Autowired
    private StudentService studentService; //

    @Autowired
    private CollectionsService collectionsService;

    @Autowired
    private CourschemasService courschemasService;

    @GetMapping("/record")
    public List<student> findAll(){
        System.out.println(studentService.getClass().getName());
        return studentService.findAll();
    }
    @GetMapping("/recordCollections")
    public List<collections> findAllCollections(){
        return collectionsService.findAll();
    }

    @GetMapping("/recordCourschemas")
    public List<courschemas> findAllCourschemas(){

        return courschemasService.findAll();
    }

    @PostMapping("/record")
    public student addOne(student student){
        return studentService.save(student);
    }

    @PostMapping("/recordCollections")
    public collections addOne(collections collections){
        return collectionsService.save(collections);
    }

    @PostMapping("/recordCourschemas")
    public courschemas addOne(courschemas courschemas){
        return courschemasService.save(courschemas);
    }
    @PutMapping("/record")
    public student update(@RequestParam int id,
                          @RequestParam String name,
                          @RequestParam int department,
                          @RequestParam int major,
                          @RequestParam int beginYear,
                          @RequestParam int englishLevel){
        student student = new student();
        student.setId(id);
        student.setName(name);
        student.setEnglishLevel(englishLevel);
        student.setMajor(major);
        student.setBeginYear(beginYear);
        student.setDepartment(department);
        return studentService.save(student);
    }

    @PutMapping("/recordCollections")
    public collections update(@RequestParam int id,
                              @RequestParam int courschema){
        collections collections = new collections();
        collections.setId(id);
        collections.setCourschema(courschema);

        return collectionsService.save(collections);
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

    @DeleteMapping("record/{id}")
    public void deleteOne(@PathVariable int id){
        studentService.deleteById(id);
    }

    @DeleteMapping("recordCollections/{id}")
    public void deleteOneCollection(@PathVariable int id, int courschema){
        collectionsService.deleteCollectionsById(id, courschema);
    }

    @DeleteMapping("recordCourschemas/{courschema}")
    public void deleteCourschema(@PathVariable int courschema){
        courschemasService.deleteCourschema(courschema);
    }

    @PostMapping("find")
    public student findStudentByName(@RequestParam String name){
        return studentService.findStudentByName(name);
    }

    @PostMapping("findid")
    public student findStudentById(@RequestParam int id){
        return studentService.findStudentByid_student(id);
    }
    @PostMapping("findCollections")
    public List<Integer> findCollectionsByid(@RequestParam int id){
        return collectionsService.findCollectionsByid(id);
    }

    @PostMapping("findCourschemas")
    public courschemas findCourschema(@RequestParam int courschema){
        return courschemasService.findCourschema(courschema);
    }

    @PostMapping("findCol_schema")
    public List<courschemas> findCol_schema(@RequestParam int id){
        List<Integer> schemas = findCollectionsByid(id);
        LinkedList<courschemas> schema_names = new LinkedList<courschemas>();
        for(int i:schemas){
            schema_names.add(findCourschema(i));
        }
        return schema_names;
    }

}