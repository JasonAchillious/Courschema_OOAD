package com.exercise.springproject.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Xianxiu_condition", schema = "mydb", catalog = "")
@IdClass(MultipleKeysClass.class)
public class Xianxiu_condition implements Serializable {
    @Id
    private int idCourse;
    @Id
    private int courschema;
    private String conditionString;

    @Id
    @Column(name = "id_course")
    public int getIdCourse(){
        return idCourse;
    }

    public void setIdCourse(int idCourse) {
        this.idCourse = idCourse;
    }

    @Id
    @Column(name = "courschema")
    public int getCourschema(){
        return courschema;
    }

    public void setCourschema(int cours) {
        this.courschema = cours;
    }

    @Column(name = "conditionString")
    public String getConditionString(){
        return conditionString;
    }

    public void setConditionString(String con) {
        this.conditionString = con;
    }
}
