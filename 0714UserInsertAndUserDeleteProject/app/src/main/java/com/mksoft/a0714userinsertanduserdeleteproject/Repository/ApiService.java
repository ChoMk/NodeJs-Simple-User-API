package com.mksoft.a0714userinsertanduserdeleteproject.Repository;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiService {
    @POST("/users/")
    Call<String> postUser(
            @Body UserData userData);
    @GET("/users/{userID}")
    Call<UserData> getUser(
            @Path("userID") String userID);
    @DELETE("/users/{userID}")
    Call<String> deleteUser(
            @Path("userID") String userID);
    @GET("/users/")
    Call<List<UserData>> getUsers();

}
