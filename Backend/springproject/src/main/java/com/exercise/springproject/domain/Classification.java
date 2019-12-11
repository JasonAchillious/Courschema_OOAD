package com.exercise.springproject.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Classification", schema = "mydb")
@IdClass(ClassificationPK.class)
public class Classification {
    private int idCourse;
    private int courschema;
    private Byte compulsory;
    private Byte ru_xi;
    private Byte tongshi;
    private Byte political;

    @Id
    @Column(name="political")
    public Byte getPolitical(){
        return political;
    }
    public void setPolitical(Byte p){
        this.political = p;
    }
    @Id
    @Column(name = "id_course")
    public int getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(int idCourse) {
        this.idCourse = idCourse;
    }

    @Id
    @Column(name = "Courschema")
    public int getCourschema() {
        return courschema;
    }

    public void setCourschema(int courschema) {
        this.courschema = courschema;
    }

    @Basic
    @Column(name = "Compulsory")
    public Byte getCompulsory() {
        return compulsory;
    }

    public void setCompulsory(Byte compulsory) {
        this.compulsory = compulsory;
    }

    @Basic
    @Column(name = "ru_xi")
    public Byte getRu_xi() {
        return ru_xi;
    }

    public void setRu_xi(Byte ru_xi) {
        this.ru_xi = ru_xi;
    }

    @Basic
    @Column(name = "tongshi")
    public Byte getTongshi() {
        return tongshi;
    }

    public void setTongshi(Byte tongshi) {
        this.tongshi = tongshi;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Classification that = (Classification) o;
        return idCourse == that.idCourse &&
                courschema == that.courschema &&
                Objects.equals(compulsory, that.compulsory) &&
                Objects.equals(ru_xi, that.ru_xi);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCourse, courschema, compulsory, ru_xi);
    }
}
