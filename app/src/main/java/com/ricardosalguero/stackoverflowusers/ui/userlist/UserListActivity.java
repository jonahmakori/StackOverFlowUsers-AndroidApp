package com.ricardosalguero.stackoverflowusers.ui.userlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ricardosalguero.stackoverflowusers.R;
import com.ricardosalguero.stackoverflowusers.model.User;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.supercharge.shimmerlayout.ShimmerLayout;

public class UserListActivity extends AppCompatActivity implements UserListContract.View {

    private UserListPresenter userListPresenter;
    private UserListAdapter userListAdapter;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.shimmer_view_container)
    ShimmerLayout shimmerViewContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userlist);
        ButterKnife.bind(this);
        shimmerViewContainer.startShimmerAnimation();

        List<User> list = new ArrayList<>();
        userListAdapter = new UserListAdapter(this, list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(userListAdapter);
        userListPresenter = new UserListPresenter(this, this);
    }

    @Override
    public void showUsers(List<User> list) {
        shimmerViewContainer.stopShimmerAnimation();
        userListAdapter.setUserList(list);
    }
}
