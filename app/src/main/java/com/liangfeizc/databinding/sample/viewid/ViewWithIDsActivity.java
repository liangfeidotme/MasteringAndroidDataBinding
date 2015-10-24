package com.liangfeizc.databinding.sample.viewid;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import com.liangfeizc.databinding.R;
import com.liangfeizc.databinding.sample.BaseActivity;
import com.liangfeizc.databinding.databinding.ActivityViewWithIdsBinding;

public class ViewWithIDsActivity extends BaseActivity {

    ActivityViewWithIdsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_view_with_ids);
    }

    public void showMyName(View view) {
        binding.firstName.setText("liang");
        binding.lastName.setText("fei");
    }
}
