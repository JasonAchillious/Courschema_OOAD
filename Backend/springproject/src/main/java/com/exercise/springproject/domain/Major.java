package com.exercise.springproject.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Major", schema = "mydb", catalog = "")
public class Major {
    private int idMajor;
    private String chineseName;
    private String englishName;
    private  int Department;

    @Id
    @Column(name = "idMajor")
    public int getIdMajor() {
        return idMajor;
    }

    public void setIdMajor(int idMajor) {
        this.idMajor = idMajor;
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
    @Column(name = "EnglishName")
    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    @Basic
    @Column(name = "Department")
    public int getDepartment() {
        return Department;
    }

    public void setDepartment(int idDepartment) {
        this.Department = idDepartment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Major that = (Major) o;
        return idMajor == that.idMajor &&
                Objects.equals(chineseName, that.chineseName) &&
                Objects.equals(englishName, that.englishName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMajor, chineseName, englishName);
    }
}
