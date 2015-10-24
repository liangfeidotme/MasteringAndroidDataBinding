package com.liangfeizc.databinding.sample.basic;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.liangfeizc.databinding.R;
import com.liangfeizc.databinding.sample.BaseActivity;
import com.liangfeizc.databinding.databinding.ActivityBasicBinding;
import com.liangfeizc.databinding.model.User;

public class BasicActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityBasicBinding binding = DataBindingUtil.setContentView(
                this, R.layout.activity_basic);
        User user = new User("fei", "Liang", 27);
        binding.setUser(user);
    }
}

