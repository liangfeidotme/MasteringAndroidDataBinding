package com.liangfeizc.databindingsamples.dynamic;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.liangfeizc.databindingsamples.R;
import com.liangfeizc.databindingsamples.basic.User;
import com.liangfeizc.databindingsamples.databinding.UserItemBinding;
import com.liangfeizc.databindingsamples.utils.RandomNames;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rufi on 6/5/15.
 */
public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserHolder> {
    private static final int USER_COUNT = 10;

    @NonNull
    private List<User> mUsers;

    public UserAdapter() {
        mUsers = new ArrayList<>(10);
        for (int i = 0; i < USER_COUNT; i ++) {
            User user = new User(RandomNames.nextFirstName(), RandomNames.nextLastName());
            mUsers.add(user);
        }
    }

    public static class UserHolder extends RecyclerView.ViewHolder {
        private UserItemBinding mBinding;

        public UserHolder(View itemView) {
            super(itemView);
            mBinding = UserItemBinding.bind(itemView);
        }

        public void bind(@NonNull User user) {
            mBinding.setUser(user);
        }
    }

    @Override
    public UserHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.user_item, viewGroup, false);
        return new UserHolder(itemView);
    }

    @Override
    public void onBindViewHolder(UserHolder holder, int position) {
        holder.bind(mUsers.get(position));
    }

    @Override
    public int getItemCount() {
        return mUsers.size();
    }
}

