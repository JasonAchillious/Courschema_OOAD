package com.exercise.springproject.domain;

import jxl.write.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.sql.Time;

@Entity
public class question {
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String releaseTime;
    private String qContent;
    private int createrid;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int questionid;
    private byte hasAnswer;
    private int answerId;

    public byte getHasAnswer() {
        return hasAnswer;
    }

    public void setHasAnswer(byte hasAnswer) {
        this.hasAnswer = hasAnswer;
    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public void setqContent(String qContent) {
        this.qContent = qContent;
    }

    public void setCreaterid(int c_id) {
        this.createrid = c_id;
    }

//    public void setQuestionid(int questionid) {
//        this.questionid = questionid;
//    }

    public String getqContent(){
        return this.qContent;
    }

    public int getCreaterid() {
        return createrid;
    }

    public int getQuestionid() {
        return questionid;
    }

    public String getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(String releaseTime) {
        this.releaseTime = releaseTime;
    }
}
