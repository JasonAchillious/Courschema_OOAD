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
@RequestMapping("/exex")
public class CoursechemaApp {
    @Autowired
    private StudentService studentService; //



    @GetMapping("/record")
    public List<student> findAll(){
        System.out.println(studentService.getClass().getName());
        return studentService.findAll();
    }


    @PostMapping("/record")
    public student addOne(student student){
        //tested id_student should be stumitted as id
        return studentService.save(student);
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




    @DeleteMapping("record/{id}")
    public void deleteOne(@PathVariable int id){
        studentService.deleteById(id);
    }




    @PostMapping("find")
    public student findStudentByName(@RequestParam String name){
        return studentService.findStudentByName(name);
    }

    @PostMapping("findid")
    public student findStudentById(@RequestParam int id){
        return studentService.findStudentByid_student(id);
    }




}