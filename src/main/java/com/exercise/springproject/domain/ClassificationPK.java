package com.exercise.springproject.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class ClassificationPK implements Serializable {
    private int idCourse;
    private int courschema;

    @Column(name = "idCourse")
    @Id
    public int getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(int idCourse) {
        this.idCourse = idCourse;
    }

    @Column(name = "Courschema")
    @Id
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
        ClassificationPK that = (ClassificationPK) o;
        return idCourse == that.idCourse &&
                courschema == that.courschema;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCourse, courschema);
    }
}
