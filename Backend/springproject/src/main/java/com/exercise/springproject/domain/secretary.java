package com.exercise.springproject.domain;

import javax.persistence.*;

@Entity
@Table(name = "secretary", schema = "mydb", catalog = "")
public class secretary {
    private int id;
    private String name;
    private int department;
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

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int major) {
        this.department = major;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
