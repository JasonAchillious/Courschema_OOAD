package com.exercise.springproject.service;

import com.exercise.springproject.api.StudentRepository;
import com.exercise.springproject.domain.student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public student save(student student) {
        return studentRepository.save(student);
    }

    @Override
    public student findStudentByName(String name) {
        return studentRepository.findStudentByName(name);
    }

    @Override
    public student findStudentByid_student(int id){
        return studentRepository.findStudentByid_student(id);
    }



    @Override
    public void deleteById(int id) {
        studentRepository.deleteById(id);
    }

    //@Override
    //public List<Student> findByIdAndName(int id, String name) {
      //  return studentRepository.findByIdAndName(id, name);
    //}

    //@Override
   // public List<Student> findByNameAndAndEnglishLevel(String name, int englishlevel){
      //  return studentRepository.findByNameAndAndEnglishLevel(name, englishlevel);
   // }

}
