package com.ricardosalguero.stackoverflowusers.ui.userlist;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ricardosalguero.stackoverflowusers.R;
import com.ricardosalguero.stackoverflowusers.model.User;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.UserViewHolder>{

    private List<User> userList;
    private Context context;
    private View view;

    public UserListAdapter(Context context, List<User> list){
        this.context = context;
        this.userList = list;
    }

    public void setUserList(List<User> list){
        this.userList = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.custom_row_user_list, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        final User user = userList.get(position);
        holder.usernameTextView.setText(user.getUserName());
        holder.locationTextView.setText(user.getLocation());

        Iterator<Map.Entry<String, Integer>> iterator = user.getBadges().entrySet().iterator();
        Map.Entry<String, Integer> entry = iterator.next();
        holder.silverBadgeTextView.setText(Integer.toString(entry.getValue()));
        entry = iterator.next();
        holder.bronzeBadgeTextView.setText(Integer.toString(entry.getValue()));
        entry = iterator.next();
        holder.goldBadgeTextView.setText(Integer.toString(entry.getValue()));


        Glide.with(context)
                .load(user.getGravatarUrl())
                .into(holder.gravatarImageView);
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.gravatarImageView)
        ImageView gravatarImageView;
        @BindView(R.id.usernameTextView)
        TextView usernameTextView;
        @BindView(R.id.locationTextView)
        TextView locationTextView;
        @BindView(R.id.goldBadgeImageView)
        ImageView goldBadgeImageView;
        @BindView(R.id.goldBadgeTextView)
        TextView goldBadgeTextView;
        @BindView(R.id.silverBadgeImageView)
        ImageView silverBadgeImageView;
        @BindView(R.id.silverBadgeTextView)
        TextView silverBadgeTextView;
        @BindView(R.id.bronzeBadgeImageView)
        ImageView bronzeBadgeImageView;
        @BindView(R.id.bronzeBadgeTextView)
        TextView bronzeBadgeTextView;

        public UserViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
