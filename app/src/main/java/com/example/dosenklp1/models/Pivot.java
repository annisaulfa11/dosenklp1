package com.example.dosenklp1.models;

import com.google.gson.annotations.SerializedName;

public class Pivot{

    @SerializedName("thesis_id")
    private int thesisId;

    @SerializedName("updated_at")
    private String updatedAt;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("id")
    private int id;

    @SerializedName("position")
    private int position;

    @SerializedName("lecturer_id")
    private int lecturerId;

    @SerializedName("created_by")
    private int createdBy;

    @SerializedName("status")
    private int status;

    public void setThesisId(int thesisId){
        this.thesisId = thesisId;
    }

    public int getThesisId(){
        return thesisId;
    }

    public void setUpdatedAt(String updatedAt){
        this.updatedAt = updatedAt;
    }

    public String getUpdatedAt(){
        return updatedAt;
    }

    public void setCreatedAt(String createdAt){
        this.createdAt = createdAt;
    }

    public String getCreatedAt(){
        return createdAt;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public void setPosition(int position){
        this.position = position;
    }

    public int getPosition(){
        return position;
    }

    public void setLecturerId(int lecturerId){
        this.lecturerId = lecturerId;
    }

    public int getLecturerId(){
        return lecturerId;
    }

    public void setCreatedBy(int createdBy){
        this.createdBy = createdBy;
    }

    public int getCreatedBy(){
        return createdBy;
    }

    public void setStatus(int status){
        this.status = status;
    }

    public int getStatus(){
        return status;
    }
}