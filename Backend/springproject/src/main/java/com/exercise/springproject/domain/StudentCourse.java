package com.exercise.springproject.domain;

import javax.persistence.*;

@Entity
@Table(name = "student_course", schema = "mydb", catalog = "")
@IdClass(MKC.class)
public class StudentCourse {
    private int id_student;
    private int id_course;

    @Id
    @Column(name = "id_student")
    public int getId_student(){
        return id_student;
    }

    public void setId_student(int idstudent) {
        this.id_student = idstudent;
    }

    @Id
    @Column(name = "id_course")
    public int getId_course(){
        return id_course;
    }

    public void setId_course(int idcourse) {
        this.id_course = idcourse;
    }

}
