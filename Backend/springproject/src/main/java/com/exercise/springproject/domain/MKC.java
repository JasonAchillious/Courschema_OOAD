package com.exercise.springproject.domain;

import java.io.Serializable;

public class MKC implements Serializable {
    private int id_student;
    private int id_course;

    public MKC() {
    }

    public MKC(Integer idcourse, Integer idstudent) {
        this.id_course = idcourse;
        this.id_student = idstudent;
    }

    public Integer getId_course(){
        return this.id_course;
    }
    public void setId_course(int c){
        this.id_course = c;
    }

    public Integer getId_student(){
        return this.id_student;
    }
    public void setId_student(int cou){
        this.id_student = cou;
    }
}
