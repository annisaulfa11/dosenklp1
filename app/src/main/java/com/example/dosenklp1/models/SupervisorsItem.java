package com.example.dosenklp1.models;

import com.google.gson.annotations.SerializedName;

public class SupervisorsItem{

    @SerializedName("birthday")
    private String birthday;

    @SerializedName("address")
    private Object address;

    @SerializedName("gender")
    private int gender;

    @SerializedName("department_id")
    private int departmentId;

    @SerializedName("npwp")
    private Object npwp;

    @SerializedName("photo")
    private Object photo;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("association_type")
    private int associationType;

    @SerializedName("religion")
    private int religion;

    @SerializedName("nik")
    private String nik;

    @SerializedName("marital_status")
    private int maritalStatus;

    @SerializedName("nip")
    private String nip;

    @SerializedName("karpeg")
    private Object karpeg;

    @SerializedName("birthplace")
    private String birthplace;

    @SerializedName("updated_at")
    private String updatedAt;

    @SerializedName("phone")
    private String phone;

    @SerializedName("nidn")
    private String nidn;

    @SerializedName("name")
    private String name;

    @SerializedName("pivot")
    private Pivot pivot;

    @SerializedName("id")
    private int id;

    @SerializedName("status")
    private int status;

    public void setBirthday(String birthday){
        this.birthday = birthday;
    }

    public String getBirthday(){
        return birthday;
    }

    public void setAddress(Object address){
        this.address = address;
    }

    public Object getAddress(){
        return address;
    }

    public void setGender(int gender){
        this.gender = gender;
    }

    public int getGender(){
        return gender;
    }

    public void setDepartmentId(int departmentId){
        this.departmentId = departmentId;
    }

    public int getDepartmentId(){
        return departmentId;
    }

    public void setNpwp(Object npwp){
        this.npwp = npwp;
    }

    public Object getNpwp(){
        return npwp;
    }

    public void setPhoto(Object photo){
        this.photo = photo;
    }

    public Object getPhoto(){
        return photo;
    }

    public void setCreatedAt(String createdAt){
        this.createdAt = createdAt;
    }

    public String getCreatedAt(){
        return createdAt;
    }

    public void setAssociationType(int associationType){
        this.associationType = associationType;
    }

    public int getAssociationType(){
        return associationType;
    }

    public void setReligion(int religion){
        this.religion = religion;
    }

    public int getReligion(){
        return religion;
    }

    public void setNik(String nik){
        this.nik = nik;
    }

    public String getNik(){
        return nik;
    }

    public void setMaritalStatus(int maritalStatus){
        this.maritalStatus = maritalStatus;
    }

    public int getMaritalStatus(){
        return maritalStatus;
    }

    public void setNip(String nip){
        this.nip = nip;
    }

    public String getNip(){
        return nip;
    }

    public void setKarpeg(Object karpeg){
        this.karpeg = karpeg;
    }

    public Object getKarpeg(){
        return karpeg;
    }

    public void setBirthplace(String birthplace){
        this.birthplace = birthplace;
    }

    public String getBirthplace(){
        return birthplace;
    }

    public void setUpdatedAt(String updatedAt){
        this.updatedAt = updatedAt;
    }

    public String getUpdatedAt(){
        return updatedAt;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    public String getPhone(){
        return phone;
    }

    public void setNidn(String nidn){
        this.nidn = nidn;
    }

    public String getNidn(){
        return nidn;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setPivot(Pivot pivot){
        this.pivot = pivot;
    }

    public Pivot getPivot(){
        return pivot;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public void setStatus(int status){
        this.status = status;
    }

    public int getStatus(){
        return status;
    }
}