package com.liangfeizc.databinding.sample.dynamic;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.liangfeizc.databinding.R;
import com.liangfeizc.databinding.sample.BaseActivity;
import com.liangfeizc.databinding.databinding.ActivityDynamicBinding;

public class DynamicActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityDynamicBinding binding = DataBindingUtil.setContentView(
                this, R.layout.activity_dynamic);

        binding.recyclerView.setHasFixedSize(true);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setAdapter(new UserAdapter());
    }
}
