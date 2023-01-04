package com.example.dosenklp1.models;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class MahasiswaBimbinganResponse {

    @SerializedName("count")
    private int count;

    @SerializedName("theses")
    private List<ThesesItem> theses;

    @SerializedName("status")
    private String status;

    public void setCount(int count){
        this.count = count;
    }

    public int getCount(){
        return count;
    }

    public void setTheses(List<ThesesItem> theses){
        this.theses = theses;
    }

    public List<ThesesItem> getTheses(){
        return theses;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public String getStatus(){
        return status;
    }
}