package com.exercise.springproject.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class PrerequisitePK implements Serializable {
    private int course;
    private int idPreCourse;

    @Column(name = "Course")
    @Id
    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    @Column(name = "idPreCourse")
    @Id
    public int getIdPreCourse() {
        return idPreCourse;
    }

    public void setIdPreCourse(int idPreCourse) {
        this.idPreCourse = idPreCourse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrerequisitePK that = (PrerequisitePK) o;
        return course == that.course &&
                idPreCourse == that.idPreCourse;
    }

    @Override
    public int hashCode() {
        return Objects.hash(course, idPreCourse);
    }
}
