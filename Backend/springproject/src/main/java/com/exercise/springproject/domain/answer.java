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
    private int questionid;
    private int adminid;
    private String answerDate;

    public String getAnswerDate() {
        return answerDate;
    }

    public void setAnswerDate(String answerDate) {
        this.answerDate = answerDate;
    }

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public void setAnsid(int ansid) {
        this.ansid = ansid;
    }

    public int getAnsid() {
        return ansid;
    }
}
