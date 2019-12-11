package com.exercise.springproject.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class question {
    private String qContent;
    private int createrid;
    @Id
    private int questionid;

    public void setqContent(String qContent) {
        this.qContent = qContent;
    }

    public void setCreaterid(int c_id) {
        this.createrid = c_id;
    }

    public void setQuestionid(int questionid) {
        this.questionid = questionid;
    }

    public String getqContent(){
        return this.qContent;
    }

    public int getCreaterid() {
        return createrid;
    }

    public int getQuestionid() {
        return questionid;
    }
}
