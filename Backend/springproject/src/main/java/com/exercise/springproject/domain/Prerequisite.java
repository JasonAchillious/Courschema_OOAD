package com.exercise.springproject.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Prerequisite", schema = "mydb", catalog = "")
@IdClass(PrerequisitePK.class)
public class Prerequisite {
    private int course;
    private int idPreCourse;
    private Integer id;

    @Id
    @Column(name = "Course")
    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    @Id
    @Column(name = "idPreCourse")
    public int getIdPreCourse() {
        return idPreCourse;
    }

    public void setIdPreCourse(int idPreCourse) {
        this.idPreCourse = idPreCourse;
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
        Prerequisite that = (Prerequisite) o;
        return course == that.course &&
                idPreCourse == that.idPreCourse &&
                Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(course, idPreCourse, id);
    }
}
