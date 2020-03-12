package com.example.class09;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("register.php")
    Call<Student> performRegistration(@Field("name") String Name,
                                      @Field("number") String Number,
                                      @Field("password") String Password);

    @GET("login.php")
    Call<Student> login(@Query("number")String Number,
                        @Query("password")String password);

}
