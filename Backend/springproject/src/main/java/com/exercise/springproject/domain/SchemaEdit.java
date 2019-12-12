package com.exercise.springproject.domain;

import java.util.List;
import java.util.Map;

public class SchemaEdit {
    private Map idMap;
    private List<Map> tongshi;
    private List<Map> ruxi;
    private List<Map> bixiu;
    private List<Map> xuanxiu;
    private List<Map> political;

    public Map getIdMap(){
        return idMap;
    }
    public List<Map> getBixiu() {
        return bixiu;
    }

    public List<Map> getRuxi() {
        return ruxi;
    }

    public List<Map> getXuanxiu() {
        return xuanxiu;
    }

    public List<Map> getTongshi() {
        return tongshi;
    }

    public List<Map> getPolitical(){ return political;}

    public void setPolitical(List<Map> p){ this.political = p;}

    public void setIdMap(Map i){
        this.idMap = i;
    }
    public void setBixiu(List<Map> bixiu) {
        this.bixiu = bixiu;
    }

    public void setRuxi(List<Map> ruxi) {
        this.ruxi = ruxi;
    }

    public void setTongshi(List<Map> tongshi) {
        this.tongshi = tongshi;
    }

    public void setXuanxiu(List<Map> xuanxiu) {
        this.xuanxiu = xuanxiu;
    }

}
