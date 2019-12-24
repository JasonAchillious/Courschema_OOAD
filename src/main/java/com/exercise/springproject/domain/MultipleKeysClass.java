package com.exercise.springproject.domain;

import java.io.Serializable;

public class MultipleKeysClass implements Serializable {
    private int idCourse;
    private int courschema;

    public MultipleKeysClass() {
    }

    public MultipleKeysClass(Integer course, Integer schema) {
        this.idCourse = course;
        this.courschema = schema;
    }

    public Integer getIdCourse(){
        return this.idCourse;
    }
    public void setIdCourse(int c){
        this.idCourse = c;
    }

    public Integer getCourschema(){
        return this.courschema;
    }
    public void setCourschema(int cou){
        this.idCourse = cou;
    }
}
