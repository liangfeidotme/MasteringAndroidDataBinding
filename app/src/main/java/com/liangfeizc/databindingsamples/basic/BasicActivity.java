package com.liangfeizc.databindingsamples.basic;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.liangfeizc.databindingsamples.BaseActivity;
import com.liangfeizc.databindingsamples.R;
import com.liangfeizc.databindingsamples.databinding.ActivityBasicBinding;

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

