package com.exercise.springproject.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class SchemaCoursePK implements Serializable {
    private int course;
    private int schema;

    @Column(name = "Course")
    @Id
    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    @Column(name = "Schema")
    @Id
    public int getSchema() {
        return schema;
    }

    public void setSchema(int schema) {
        this.schema = schema;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SchemaCoursePK that = (SchemaCoursePK) o;
        return course == that.course &&
                schema == that.schema;
    }

    @Override
    public int hashCode() {
        return Objects.hash(course, schema);
    }
}
