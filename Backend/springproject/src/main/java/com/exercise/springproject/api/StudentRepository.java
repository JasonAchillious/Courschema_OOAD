package com.exercise.springproject.api;

import com.exercise.springproject.domain.student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface StudentRepository extends JpaRepository<student, Integer> {
    public student findStudentByName(String name);
    @Query("select p from student p where p.id_student=?1")
    public student findStudentByid_student(int id);

    //public Student findUserByNameAndPassword(String name, String password);
    //List<Student> findById(long id);
   // @Query("select p from Student p where p.id_student=?1 and p.name=?2")
    //List<Student> findByIdAndAndName(int id, String name);

   // @Query("select p from Student p where p.name=?1 and p.englishLevel=?2")
   // List<Student> findByNameAndAndEnglishLevel(String name, int englishlevel);
}


