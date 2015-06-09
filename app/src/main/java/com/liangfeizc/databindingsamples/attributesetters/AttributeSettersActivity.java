package com.liangfeizc.databindingsamples.attributesetters;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.liangfeizc.databindingsamples.R;
import com.liangfeizc.databindingsamples.databinding.ActivityAttributeSettersBinding;

public class AttributeSettersActivity extends AppCompatActivity {
    public View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(
                    getApplicationContext(),
                    "User view is clicked",
                    Toast.LENGTH_LONG).show();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityAttributeSettersBinding binding =
                DataBindingUtil.setContentView(this, R.layout.activity_attribute_setters);

        binding.setActivity(this);
    }
}
