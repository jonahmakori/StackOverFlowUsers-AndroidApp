package com.ricardosalguero.stackoverflowusers.ui.userlist;

import com.ricardosalguero.stackoverflowusers.model.User;

import org.json.JSONArray;

import java.util.List;

public class UserListContract {

    interface View {
        void showUsers(List<User> list);
    }

    interface Actions {
        void parseJson(JSONArray json);
    }
}
