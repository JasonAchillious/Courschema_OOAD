package com.exercise.springproject.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
public class Login_user{
    @Id
    private int id;
    @NotNull
    private int time;

    public void setId(int id){this.id = id;}

    public int getId(){
        return this.id;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}

