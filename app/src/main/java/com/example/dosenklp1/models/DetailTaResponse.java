package com.example.dosenklp1.models;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class DetailTaResponse{

    @SerializedName("student")
    private Student student;

    @SerializedName("student_id")
    private int studentId;

    @SerializedName("grade_by")
    private Object gradeBy;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("abstract")
    private String jsonMemberAbstract;

    @SerializedName("title")
    private String title;

    @SerializedName("start_at")
    private String startAt;

    @SerializedName("created_by")
    private int createdBy;

    @SerializedName("updated_at")
    private String updatedAt;

    @SerializedName("trials")
    private List<TrialsItem> trials;

    @SerializedName("seminars")
    private List<SeminarsItem> seminars;

    @SerializedName("grade")
    private Object grade;

    @SerializedName("id")
    private int id;

    @SerializedName("topic_id")
    private int topicId;

    @SerializedName("status")
    private int status;

    @SerializedName("supervisors")
    private List<SupervisorsItem> supervisors;

    public void setStudent(Student student){
        this.student = student;
    }

    public Student getStudent(){
        return student;
    }

    public void setStudentId(int studentId){
        this.studentId = studentId;
    }

    public int getStudentId(){
        return studentId;
    }

    public void setGradeBy(Object gradeBy){
        this.gradeBy = gradeBy;
    }

    public Object getGradeBy(){
        return gradeBy;
    }

    public void setCreatedAt(String createdAt){
        this.createdAt = createdAt;
    }

    public String getCreatedAt(){
        return createdAt;
    }

    public void setJsonMemberAbstract(String jsonMemberAbstract){
        this.jsonMemberAbstract = jsonMemberAbstract;
    }

    public String getJsonMemberAbstract(){
        return jsonMemberAbstract;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getTitle(){
        return title;
    }

    public void setStartAt(String startAt){
        this.startAt = startAt;
    }

    public String getStartAt(){
        return startAt;
    }

    public void setCreatedBy(int createdBy){
        this.createdBy = createdBy;
    }

    public int getCreatedBy(){
        return createdBy;
    }

    public void setUpdatedAt(String updatedAt){
        this.updatedAt = updatedAt;
    }

    public String getUpdatedAt(){
        return updatedAt;
    }

    public void setTrials(List<TrialsItem> trials){
        this.trials = trials;
    }

    public List<TrialsItem> getTrials(){
        return trials;
    }

    public void setSeminars(List<SeminarsItem> seminars){
        this.seminars = seminars;
    }

    public List<SeminarsItem> getSeminars(){
        return seminars;
    }

    public void setGrade(Object grade){
        this.grade = grade;
    }

    public Object getGrade(){
        return grade;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public void setTopicId(int topicId){
        this.topicId = topicId;
    }

    public int getTopicId(){
        return topicId;
    }

    public void setStatus(int status){
        this.status = status;
    }

    public int getStatus(){
        return status;
    }

    public void setSupervisors(List<SupervisorsItem> supervisors){
        this.supervisors = supervisors;
    }

    public List<SupervisorsItem> getSupervisors(){
        return supervisors;
    }
}