package com.exercise.springproject.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class courschemas {
    private int WaiGuo;
    private int one_plus3;
    private int major_elec_alt;
    //private int altered_course1;
    //private int altered_course2;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int courschema;
    @NotNull
    private int Major;//
    private int nian;
    private int Department;
    private int major_elec;
    private int HU_elec;
    private int SS_elec;
    private int AR_elec;
    private int political;
    private String ChineseName;
    private String Intro;
    private String department_name;
    private String major_name;

    public String getIntro() {
        return Intro;
    }

    public void setIntro(String intro) {
        Intro = intro;
    }

    public int getWaiGuo() {
        return WaiGuo;
    }

    public void setWaiGuo(int waiGuo) {
        WaiGuo = waiGuo;
    }

    public int getOne_plus3() {
        return one_plus3;
    }

    public void setOne_plus3(int one_plus3) {
        this.one_plus3 = one_plus3;
    }

    public int getMajor_elec_alt() {
        return major_elec_alt;
    }

    public void setMajor_elec_alt(int major_elec_alt) {
        this.major_elec_alt = major_elec_alt;
    }

//    public int getAltered_course1() {
//        return altered_course1;
//    }
//
//    public void setAltered_course1(int altered_course1) {
//        this.altered_course1 = altered_course1;
//    }
//
//    public int getAltered_course2() {
//        return altered_course2;
//    }
//
//    public void setAltered_course2(int altered_course2) {
//        this.altered_course2 = altered_course2;
//    }

    public int getCourschema() {
        return courschema;
    }

   // public void setCourschema(int courschema) {
   //     this.courschema = courschema;
   // }

    public int getMajor() {
        return Major;
    }

    public void setMajor(int major) {
        Major = major;
    }

    public int getNian() {
        return nian;
    }

    public void setNian(int nian) {
        this.nian = nian;
    }

    public int getDepartment() {
        return Department;
    }

    public void setDepartment(int Department) {
        this.Department = Department;
    }

    public int getMajor_elec() {
        return major_elec;
    }

    public void setMajor_elec(int major_elec) {
        this.major_elec = major_elec;
    }

    public int getHU_elec() {
        return HU_elec;
    }

    public void setHU_elec(int HU_elec) {
        this.HU_elec = HU_elec;
    }

    public int getSS_elec() {
        return SS_elec;
    }

    public void setSS_elec(int SS_elec) {
        this.SS_elec = SS_elec;
    }

    public int getAR_elec() {
        return AR_elec;
    }

    public void setAR_elec(int AR_elec) {
        this.AR_elec = AR_elec;
    }

    public int getPolitical() {
        return political;
    }

    public void setPolitical(int political) {
        this.political = political;
    }

    public String getChineseName() {
        return ChineseName;
    }

    public void setChineseName(String ChineseName) {
        this.ChineseName = ChineseName;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public String getMajor_name() {
        return major_name;
    }

    public void setMajor_name(String major_name) {
        this.major_name = major_name;
    }
}


