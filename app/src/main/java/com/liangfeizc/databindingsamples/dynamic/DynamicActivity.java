package com.liangfeizc.databindingsamples.dynamic;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.liangfeizc.databindingsamples.R;
import com.liangfeizc.databindingsamples.databinding.ActivityDynamicBinding;

public class DynamicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityDynamicBinding binding = DataBindingUtil.setContentView(
                this, R.layout.activity_dynamic);
    }
}

