package com.exercise.springproject.domain;

import java.util.List;

public class SchemaEdit {
    private List<Integer> tongshi;
    private List<Integer> ruxi;
    private List<Integer> bixiu;
    private List<Integer> xuanxiu;
    private int xuanxiu_credit;
    private int renwen_credit;
    private int sheke_credit;

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

    public int getRenwen_credit() {
        return renwen_credit;
    }

    public int getSheke_credit() {
        return sheke_credit;
    }

    public int getXuanxiu_credit() {
        return xuanxiu_credit;
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

    public void setRenwen_credit(int renwen_credit) {
        this.renwen_credit = renwen_credit;
    }

    public void setSheke_credit(int sheke_credit) {
        this.sheke_credit = sheke_credit;
    }

    public void setXuanxiu_credit(int xuan){
        this.xuanxiu_credit = xuan;
    }
}
