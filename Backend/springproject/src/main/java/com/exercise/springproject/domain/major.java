package com.exercise.springproject.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "major", schema = "mydb", catalog = "")
public class major {
    private int id_major;
    private String chineseName;
    private String englishName;

    @Id
    @Column(name = "id_major")
    public int getId_major() {
        return id_major;
    }

    public void setId_major(int idMajor) {
        this.id_major = idMajor;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        major that = (major) o;
        return id_major == that.id_major &&
                Objects.equals(chineseName, that.chineseName) &&
                Objects.equals(englishName, that.englishName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_major, chineseName, englishName);
    }
}
