package com.exercise.springproject.service;

import com.exercise.springproject.domain.student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    public List<student> findAll();
    public student save(student student);
    public void deleteById(int id);
    public student findStudentByName(String name);
    public student findStudentByid_student(int id);

   // public List<Student> findByIdAndName(int id, String name);
    //public List<Student> findByNameAndAndEnglishLevel(String name, int englishlevel);
}


