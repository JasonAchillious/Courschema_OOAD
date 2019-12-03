package com.exercise.springproject.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "GraduReplacable", schema = "mydb", catalog = "")
@IdClass(GraduReplacablePK.class)
public class GraduReplacable {
    private int idCourse;
    private int replace;
    private Integer type;
    private int courschema;

    @Id
    @Column(name = "idCourse")
    public int getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(int idCourse) {
        this.idCourse = idCourse;
    }

    @Id
    @Column(name = "replace")
    public int getReplace() {
        return replace;
    }

    public void setReplace(int replace) {
        this.replace = replace;
    }

    @Basic
    @Column(name = "type")
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Id
    @Column(name = "courschema")
    public int getCourschema() {
        return courschema;
    }

    public void setCourschema(int courschema) {
        this.courschema = courschema;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GraduReplacable that = (GraduReplacable) o;
        return idCourse == that.idCourse &&
                replace == that.replace &&
                courschema == that.courschema &&
                Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCourse, replace, type, courschema);
    }
}
