package me.liangfei.databinding.sample.resource;

import androidx.databinding.DataBindingUtil;
import me.liangfei.databinding.R;
import me.liangfei.databinding.sample.BaseActivity;

import android.os.Bundle;

import me.liangfei.databinding.databinding.ResourceBinding;

public class ResourceActivity extends BaseActivity {

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
