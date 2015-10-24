package com.liangfeizc.databinding.sample.include;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.liangfeizc.databinding.R;
import com.liangfeizc.databinding.sample.BaseActivity;
import com.liangfeizc.databinding.databinding.ActivityIncludeBinding;
import com.liangfeizc.databinding.model.Contact;
import com.liangfeizc.databinding.model.User;

public class IncludeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityIncludeBinding binding = DataBindingUtil.setContentView(
                this, R.layout.activity_include);
        User user = new User("liang", "fei");
        Contact contact = new Contact("123456", "China");

        binding.setUser(user);
        binding.setContact(contact);
    }
}

