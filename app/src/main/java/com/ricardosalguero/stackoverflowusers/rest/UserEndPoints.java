package com.ricardosalguero.stackoverflowusers.rest;

import com.ricardosalguero.stackoverflowusers.model.StackOverFlowResponse;
import com.ricardosalguero.stackoverflowusers.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UserEndPoints {
    @GET("2.2/users?site=stackoverflow")
    Call<StackOverFlowResponse> getUsers();
}
