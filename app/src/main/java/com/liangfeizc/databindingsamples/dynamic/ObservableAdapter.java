package com.liangfeizc.databindingsamples.dynamic;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.liangfeizc.databindingsamples.BR;
import com.liangfeizc.databindingsamples.R;
import com.liangfeizc.databindingsamples.observable.ObservableUser;

import java.util.List;

/**
 * Created by rufi on 6/5/15.
 */
public class ObservableAdapter extends RecyclerView.Adapter<ObservableAdapter.BindingHolder> {
    private List<ObservableUser> users;

    public ObservableAdapter(List<ObservableUser> mUsers) {
        users = mUsers;
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
                R.layout.list_item_observable,
                viewGroup,
                false);

        BindingHolder holder = new BindingHolder(binding.getRoot());
        holder.setBinding(binding);

        return holder;
    }

    @Override
    public void onBindViewHolder(BindingHolder holder, int position) {
        ObservableUser user = users.get(position);
        holder.getBinding().setVariable(BR.user, user);

        //holder.getBinding().executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return users.size();
    }


}

