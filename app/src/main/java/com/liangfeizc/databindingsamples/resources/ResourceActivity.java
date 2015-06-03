package com.liangfeizc.databindingsamples.resources;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.liangfeizc.databindingsamples.R;
import com.liangfeizc.databindingsamples.basic.User;
import com.liangfeizc.databindingsamples.databinding.ResourceBinding;

public class ResourceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ResourceBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_resource);

        binding.setLarge(true);

        binding.setFirstName("liang");
        binding.setLastName("fei");

        binding.setBananaCount(2);
        binding.setOrangeCount(10);
    }
}
