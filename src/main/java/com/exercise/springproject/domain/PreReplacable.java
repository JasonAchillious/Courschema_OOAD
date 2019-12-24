package com.exercise.springproject.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "PreReplacable", schema = "mydb", catalog = "")
@IdClass(PreReplacablePK.class)
public class PreReplacable {
    private int idPreCourse;
    private int alternative;
    private Integer id;

    @Id
    @Column(name = "idPreCourse")
    public int getIdPreCourse() {
        return idPreCourse;
    }

    public void setIdPreCourse(int idPreCourse) {
        this.idPreCourse = idPreCourse;
    }

    @Id
    @Column(name = "alternative")
    public int getAlternative() {
        return alternative;
    }

    public void setAlternative(int alternative) {
        this.alternative = alternative;
    }

    @Basic
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PreReplacable that = (PreReplacable) o;
        return idPreCourse == that.idPreCourse &&
                alternative == that.alternative &&
                Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPreCourse, alternative, id);
    }
}
