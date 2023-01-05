package com.example.dosenklp1.network;

import com.example.dosenklp1.models.ChangePasswordResponse;
import com.example.dosenklp1.models.DetailLogbookResponse;
import com.example.dosenklp1.models.DetailTaResponse;
import com.example.dosenklp1.models.InputNilaiResponse;
import com.example.dosenklp1.models.LoginResponse;
import com.example.dosenklp1.models.LogoutResponse;
import com.example.dosenklp1.models.MahasiswaBimbinganResponse;
import com.example.dosenklp1.models.PembatalanTAResponse;
import com.example.dosenklp1.models.ProfileResponse;
import com.example.dosenklp1.models.UpdateProfileResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;

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

    @GET("api/thesis/advisors")
    Call<MahasiswaBimbinganResponse> mahasiswa(
            @Header("Authorization") String token
    );

    @GET("api/theses/{id}")
    Call<DetailTaResponse> theses(
            @Path("id") Integer idTheses,
            @Header("Authorization") String token
    );

    @GET("api/theses/200/logbooks/{id}")
    Call<DetailLogbookResponse> theses(
            @Header("Authorization") String token
    );

    @FormUrlEncoded
    @PATCH("api/thesis/grades/{id}")
    Call<InputNilaiResponse> grade(
            @Path("id") Integer idTheses,
            @Header("Authorization") String token,
            @Field("grade") String grade
    );

    @POST("/api/theses/277/trials")
    Call<PembatalanTAResponse> status(
            int idThesis, String s, @Header("Authorization") String token
    );
}
