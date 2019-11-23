package com.exercise.springproject.domain;

import javax.persistence.*;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class answer {
    @Id
    private int ansid;
    @NotNull
    private String content;
    private boolean identity;
    private int questionid;
    private int stuid;
    private int adminid;

    public int getQuestionid() {
        return questionid;
    }

    public void setQuestionid(int questionid) {
        this.questionid = questionid;
    }

    public int getAdminid() {
        return adminid;
    }

    public void setAdminid(int adminid) {
        this.adminid = adminid;
    }

    public void setIdentity(boolean identity) {
        this.identity = identity;
    }

    public boolean isIdentity() {
        return identity;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getStuid() {
        return stuid;
    }

    public void setStuid(int stuid) {
        this.stuid = stuid;
    }

    public void setAnsid(int ansid) {
        this.ansid = ansid;
    }

    public int getAnsid() {
        return ansid;
    }
}
