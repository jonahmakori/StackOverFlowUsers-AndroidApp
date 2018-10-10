package com.ricardosalguero.stackoverflowusers.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class StackOverFlowResponse {
    @SerializedName("items")
    private List<User> users;

    public void setUsers(List<User> users){ this.users = users;}
    public List<User> getUsers(){ return users;}
}
