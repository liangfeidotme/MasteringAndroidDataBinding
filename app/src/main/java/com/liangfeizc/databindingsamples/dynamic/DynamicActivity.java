package com.liangfeizc.databindingsamples.dynamic;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.liangfeizc.databindingsamples.BaseActivity;
import com.liangfeizc.databindingsamples.R;
import com.liangfeizc.databindingsamples.basic.User;
import com.liangfeizc.databindingsamples.databinding.ActivityDynamicBinding;
import com.liangfeizc.databindingsamples.observable.ObservableUser;

import java.util.ArrayList;
import java.util.List;

public class DynamicActivity extends BaseActivity {
    /**
     * 可以选择使用普通user模式（需要set）；或者用观察者ObservableUser模式（不需要set，自动刷新view)
     */
    private static final boolean IF_OBSERVABLE = true;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<User> users;
    private List<ObservableUser> observableUsers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityDynamicBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_dynamic);

        mRecyclerView = binding.recyclerView;

        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        initData();

        mRecyclerView.setAdapter(mAdapter);
    }

    private void initData() {
        if (IF_OBSERVABLE){
            initObservableUserData();
        }
        else {
            initUserData();
        }
    }

    private void initObservableUserData() {
        observableUsers = new ArrayList<>(10);
        for (int i = 0; i < 10;i ++) {
            ObservableUser user = new ObservableUser("liang", "fei");
            observableUsers.add(user);
        }
        mAdapter = new ObservableAdapter(observableUsers);
    }

    private void initUserData() {
        users = new ArrayList<>(10);
        for (int i = 0; i < 10;i ++) {
            User user = new User("liang", "fei");
            users.add(user);
        }
        mAdapter = new MyAdapter(users);
    }

    public void changeList(View v){
        if (IF_OBSERVABLE) {
            observableUsers.get(3).setLastName("Huang");
            observableUsers.get(3).setFirstName("Jue");
            //对于ObservableUser如果数据改变，则view自动刷新
        }
        else{
            users.get(3).setLastName("Huang");
            users.get(3).setFirstName("Jue");
            //对于普通user必须用notify才可以刷新view
            mAdapter.notifyDataSetChanged();
        }

    }

}

