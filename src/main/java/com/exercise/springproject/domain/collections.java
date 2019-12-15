package com.exercise.springproject.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;

@Entity
@IdClass(collections.class)
public class collections implements Serializable {
    @Id
    private int id;
    private int courschema;

    public void setId(int id){this.id = id;}

    public int getId(){
        return this.id;
    }

    public void setCourschema(int courschema) {
        this.courschema = courschema;
    }

    public int getCourschema(){
        return this.courschema;
    }

}


