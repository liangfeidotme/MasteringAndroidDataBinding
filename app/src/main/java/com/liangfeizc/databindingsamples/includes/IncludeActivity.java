package com.liangfeizc.databindingsamples.includes;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.liangfeizc.databindingsamples.BaseActivity;
import com.liangfeizc.databindingsamples.R;
import com.liangfeizc.databindingsamples.basic.User;
import com.liangfeizc.databindingsamples.custombindings.Contact;
import com.liangfeizc.databindingsamples.databinding.ActivityIncludeBinding;

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

