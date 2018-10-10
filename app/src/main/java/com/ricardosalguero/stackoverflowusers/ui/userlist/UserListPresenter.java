package com.ricardosalguero.stackoverflowusers.ui.userlist;

import android.content.Context;
import android.widget.Toast;

import com.ricardosalguero.stackoverflowusers.model.StackOverFlowResponse;
import com.ricardosalguero.stackoverflowusers.model.User;
import com.ricardosalguero.stackoverflowusers.rest.APIClient;
import com.ricardosalguero.stackoverflowusers.rest.UserEndPoints;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserListPresenter implements UserListContract.Actions {

    private final UserListContract.View view;
    private Context context;

    public UserListPresenter(UserListContract.View view, Context context){
        this.view = view;
        this.context = context;
        getUsers();
    }

    @Override
    public void getUsers(){
        UserEndPoints apiService = APIClient.getStackOverFLowClient().create(UserEndPoints.class);
        Call<StackOverFlowResponse> call = apiService.getUsers();
        call.enqueue(new Callback<StackOverFlowResponse>() {
            @Override
            public void onResponse(Call<StackOverFlowResponse> call, Response<StackOverFlowResponse> response) {
                List<User> list = response.body().getUsers();
                view.showUsers(list);
            }

            @Override
            public void onFailure(Call<StackOverFlowResponse> call, Throwable t) {
                t.printStackTrace();
                Toast.makeText(context, "Error retrieving users.", Toast.LENGTH_LONG).show();
            }
        });
    }

}
