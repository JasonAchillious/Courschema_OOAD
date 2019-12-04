package com.exercise.springproject.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "secretary", schema = "mydb", catalog = "")
public class secretary {
    private int idSecretary;
    private String name;
    private int major;

    @Id
    @Column(name = "id_secretary")
    public int getIdAdmin() {
        return idSecretary;
    }

    public void setIdAdmin(int idSecretary) {
        this.idSecretary = idSecretary;
    }

    @Basic
    @Column(name = "Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMajor() {
        return major;
    }

    public void setMajor(int major) {
        this.major = major;
    }

}
