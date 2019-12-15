package com.exercise.springproject.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Schema_Course", schema = "mydb", catalog = "")
@IdClass(SchemaCoursePK.class)
public class SchemaCourse {
    private int course;
    private int schema;

    @Id
    @Column(name = "Course")
    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    @Id
    @Column(name = "Schema")
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
        SchemaCourse that = (SchemaCourse) o;
        return course == that.course &&
                schema == that.schema;
    }

    @Override
    public int hashCode() {
        return Objects.hash(course, schema);
    }
}
