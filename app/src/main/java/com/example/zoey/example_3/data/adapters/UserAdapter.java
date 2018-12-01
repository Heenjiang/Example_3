package com.example.zoey.example_3.data.adapters;

import android.icu.lang.UScript;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.zoey.example_3.R;
import com.example.zoey.example_3.data.models.User;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    private String TAG = "mylog";
    private List<User> userList;

    public UserAdapter(List<User> userList) {
        this.userList = userList;

    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Log.d(TAG, "onCreateViewHolder: " + i);
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_users, viewGroup, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder userViewHolder, int i) {
        Log.d(TAG, "onBindViewHolder: " + i);
        User user = userList.get(i);
        userViewHolder.mUsername.setText(user.getUserName());
        userViewHolder.mAge.setText(user.getAge() + "");
        userViewHolder.mEmail.setText(user.getEmail());
    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: ");
        return userList.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {
        private TextView mUsername;
        private TextView mAge;
        private TextView mEmail;
        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            mUsername = itemView.findViewById(R.id.username_text_view);
            mAge = itemView.findViewById(R.id.age_text_view);
            mEmail = itemView.findViewById(R.id.email_text_view);

        }
    }
}
