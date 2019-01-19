package me.liangfei.databinding.sample.basic;

import androidx.databinding.DataBindingUtil;
import me.liangfei.databinding.R;
import me.liangfei.databinding.model.User;
import me.liangfei.databinding.sample.BaseActivity;

import android.os.Bundle;

import me.liangfei.databinding.databinding.ActivityBasicBinding;

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

