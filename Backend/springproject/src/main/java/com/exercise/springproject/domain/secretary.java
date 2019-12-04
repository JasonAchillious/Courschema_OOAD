package com.exercise.springproject.domain;

import javax.persistence.*;

@Entity
@Table(name = "secretary", schema = "mydb", catalog = "")
public class secretary {
    private int id;
    private String name;
    private int major;
    private String password;

    @Id
    @Column(name = "Id")
    public int getId() {
        return id;
    }

    public void setId(int idSecretary) {
        this.id = idSecretary;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
