package com.exercise.springproject.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class student {
    private int Department;
    private int Major;
    @Id
    private int id_student;
    @NotNull
    private String name;
    private int BeginYear;
    private int EnglishLevel;
    private String password;

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(int id){this.id_student = id;}

    public void setName(String name) {
        this.name = name;
    }

    public void setEnglishLevel(int EnglishLevel) {
        this.EnglishLevel = EnglishLevel;
    }

    public void setMajor(int major) {
        this.Major = major;
    }

    public void setBeginYear(int beginYear) {
        this.BeginYear = beginYear;
    }

    public void setDepartment(int department) {
        this.Department = department;
    }

    public int getId(){
        return this.id_student;
    }

    public String getName(){
        return this.name;
    }

    public String getPassword() {
        return password;
    }

    public int getDepartment(){
        return this.Department;
    }

    public int getMajor(){
        return this.Major;
    }

    public int getBeginYear(){
        return this.BeginYear;
    }

    public int getEnglishLevel(){
        return this.EnglishLevel;
    }

    public student(){

    }
    public student(int i, String n, int q, int w, String e){
        this.id_student = i;
        this.name = n;
        this.BeginYear = q;
        this.EnglishLevel = w;
        this.password = "123456";
    }
}

