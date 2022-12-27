package com.example.dosenklp1.network;

import com.example.dosenklp1.models.ChangePasswordResponse;
import com.example.dosenklp1.models.LoginResponse;
import com.example.dosenklp1.models.LogoutResponse;
import com.example.dosenklp1.models.ProfileResponse;
import com.example.dosenklp1.models.UpdateProfileResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface StoryEndPoint {
    @FormUrlEncoded
    @POST("api/login")
    Call<LoginResponse> login(
            @Field("username") String username,
            @Field("password") String password
    );

    @POST("api/logout")
    Call<LogoutResponse> logout(
            @Header("Authorization") String token
    );

    @GET("api/me")
    Call<ProfileResponse> profile(
            @Header("Authorization") String token
    );

    @FormUrlEncoded
    @POST("api/me/update")
    Call<UpdateProfileResponse> updateProfile(
            @Header("Authorization") String token,
            @Field("email") String email,
            @Field("name") String name
    );

    @FormUrlEncoded
    @POST("api/password")
    Call<ChangePasswordResponse> changePassword(
            @Header("Authorization") String token,
            @Field("old_password") String oldPass,
            @Field("new_password") String newPass,
            @Field("confirm_password") String confPass
    );


}
