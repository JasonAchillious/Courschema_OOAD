package com.exercise.springproject.domain;

import javax.persistence.*;

@Entity
@Table(name = "student_course", schema = "mydb", catalog = "")
@IdClass(MultipleKeysClass.class)
public class StudentCourse {
    private int idstudent;
    private int idcourse;

    @Id
    @Column(name = "id_student")
    public int getIdstudent(){
        return idstudent;
    }

    public void setIdstudnet(int idstudent) {
        this.idstudent = idstudent;
    }

    @Id
    @Column(name = "id_course")
    public int getIdcourse(){
        return idstudent;
    }

    public void setIdcourse(int idcourse) {
        this.idcourse = idcourse;
    }
}
