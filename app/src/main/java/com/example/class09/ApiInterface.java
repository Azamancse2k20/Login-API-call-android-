package com.example.class09;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.POST;

public interface ApiInterface {

    @POST("register.php")
    Call<Student> performRegistration(@Field("name") String Name,
                                      @Field("number") String Number,
                                      @Field("password") String Password);


}
