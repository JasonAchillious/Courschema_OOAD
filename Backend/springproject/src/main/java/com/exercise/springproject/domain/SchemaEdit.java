package com.exercise.springproject.domain;

import java.util.List;

public class SchemaEdit {
    private int id;
    private List<Integer> tongshi;
    private List<Integer> ruxi;
    private List<Integer> bixiu;
    private List<Integer> xuanxiu;
    private List<Integer> political;

    public int getId(){
        return id;
    }
    public List<Integer> getBixiu() {
        return bixiu;
    }

    public List<Integer> getRuxi() {
        return ruxi;
    }

    public List<Integer> getXuanxiu() {
        return xuanxiu;
    }

    public List<Integer> getTongshi() {
        return tongshi;
    }

    public List<Integer> getPolitical(){ return political;}

    public void setPolitical(List<Integer> p){ this.political = p;}

    public void setId(int i){
        this.id = i;
    }
    public void setBixiu(List<Integer> bixiu) {
        this.bixiu = bixiu;
    }

    public void setRuxi(List<Integer> ruxi) {
        this.ruxi = ruxi;
    }

    public void setTongshi(List<Integer> tongshi) {
        this.tongshi = tongshi;
    }

    public void setXuanxiu(List<Integer> xuanxiu) {
        this.xuanxiu = xuanxiu;
    }

}
