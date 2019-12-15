package com.exercise.springproject.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "Year", schema = "mydb", catalog = "")
public class Year {
    private int idYear;

    @Id
    @Column(name = "idYear")
    public int getIdYear() {
        return idYear;
    }

    public void setIdYear(int idYear) {
        this.idYear = idYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Year that = (Year) o;
        return idYear == that.idYear;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idYear);
    }
}
