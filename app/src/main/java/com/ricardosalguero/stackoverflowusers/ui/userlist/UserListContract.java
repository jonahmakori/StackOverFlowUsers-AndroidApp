package com.ricardosalguero.stackoverflowusers.ui.userlist;

import com.ricardosalguero.stackoverflowusers.model.User;


import java.util.List;

public class UserListContract {

    interface View {
        void showUsers(List<User> list);
    }

    interface Actions {
        void getUsers();
    }
}
