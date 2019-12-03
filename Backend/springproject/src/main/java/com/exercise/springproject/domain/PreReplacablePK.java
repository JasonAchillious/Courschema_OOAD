package com.exercise.springproject.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class PreReplacablePK implements Serializable {
    private int idPreCourse;
    private int alternative;

    @Column(name = "idPreCourse")
    @Id
    public int getIdPreCourse() {
        return idPreCourse;
    }

    public void setIdPreCourse(int idPreCourse) {
        this.idPreCourse = idPreCourse;
    }

    @Column(name = "alternative")
    @Id
    public int getAlternative() {
        return alternative;
    }

    public void setAlternative(int alternative) {
        this.alternative = alternative;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PreReplacablePK that = (PreReplacablePK) o;
        return idPreCourse == that.idPreCourse &&
                alternative == that.alternative;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPreCourse, alternative);
    }
}
