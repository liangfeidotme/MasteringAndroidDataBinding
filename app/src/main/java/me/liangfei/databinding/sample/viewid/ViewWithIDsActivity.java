package me.liangfei.databinding.sample.viewid;

import androidx.databinding.DataBindingUtil;
import me.liangfei.databinding.R;
import me.liangfei.databinding.sample.BaseActivity;
import me.liangfei.databinding.databinding.ActivityViewWithIdsBinding;

import android.os.Bundle;
import android.view.View;

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
