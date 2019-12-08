package com.exercise.springproject.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Course", schema = "mydb", catalog = "")
public class Course {
    private int idCourse;
    private String code;
    private String chineseName;
    private String intro;
    private double credit;
    private byte spring;
    private byte autumn;
    private byte summer;
    private String englishName;
    private int year;
    private int department;

    @Id
    @Column(name = "id_course")
    public int getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(int idCourse) {
        this.idCourse = idCourse;
    }

    @Basic
    @Column(name = "Code")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "ChineseName")
    public String getChineseName() {
        return chineseName;
    }

    public void setChineseName(String chineseName) {
        this.chineseName = chineseName;
    }

    @Basic
    @Column(name = "Intro")
    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    @Basic
    @Column(name = "Credit")
    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    @Basic
    @Column(name = "Spring")
    public byte getSpring() {
        return spring;
    }

    public void setSpring(byte spring) {
        this.spring = spring;
    }

    @Basic
    @Column(name = "Autumn")
    public byte getAutumn() {
        return autumn;
    }

    public void setAutumn(byte autumn) {
        this.autumn = autumn;
    }

    @Basic
    @Column(name = "Summer")
    public byte getSummer() {
        return summer;
    }

    public void setSummer(byte summer) {
        this.summer = summer;
    }

    @Basic
    @Column(name = "EnglishName")
    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    @Basic
    @Column(name = "year")
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Basic
    @Column(name = "Department")
    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course that = (Course) o;
        return idCourse == that.idCourse &&
                spring == that.spring &&
                autumn == that.autumn &&
                summer == that.summer &&
                Objects.equals(code, that.code) &&
                Objects.equals(chineseName, that.chineseName) &&
                Objects.equals(intro, that.intro) &&
                Objects.equals(credit, that.credit) &&
                Objects.equals(englishName, that.englishName) &&
                Objects.equals(year, that.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCourse, code, chineseName, intro, credit, spring, autumn, summer, englishName, year);
    }
}
