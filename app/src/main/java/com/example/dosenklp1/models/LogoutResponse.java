package com.example.dosenklp1.models;

import com.google.gson.annotations.SerializedName;

public class LogoutResponse{

    @SerializedName("message")
    private String message;

    public String getMessage(){
        return message;
    }
}