package com.liangfeizc.databindingsamples.dynamic;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.liangfeizc.databindingsamples.BR;
import com.liangfeizc.databindingsamples.R;
import com.liangfeizc.databindingsamples.basic.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rufi on 6/5/15.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.BindingHolder> {
    private List<User> users;

    public MyAdapter() {
        users = new ArrayList<>(10);
        for (int i = 0; i < 10;i ++) {
            User user = new User("liang", "fei");
        }
    }
    public static class BindingHolder extends RecyclerView.ViewHolder {
        private ViewDataBinding binding;

        public BindingHolder(View itemView) {
            super(itemView);
        }

        public ViewDataBinding getBinding() {
            return binding;
        }

        public void setBinding(ViewDataBinding binding) {
            this.binding = binding;
        }
    }

    @Override
    public BindingHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        ViewDataBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(viewGroup.getContext()),
                R.layout.list_item,
                viewGroup,
                false);

        BindingHolder holder = new BindingHolder(binding.getRoot());
        holder.setBinding(binding);

        return holder;
    }

    @Override
    public void onBindViewHolder(BindingHolder holder, int position) {
        User user = users.get(position);
        holder.getBinding().setVariable(BR.user, user);
        holder.getBinding().executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return users.size();
    }
}

