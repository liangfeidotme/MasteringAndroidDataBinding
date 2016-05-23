package com.liangfeizc.databinding.sample.include;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import com.liangfeizc.databinding.R;
import com.liangfeizc.databinding.databinding.ActivityIncludeBinding;
import com.liangfeizc.databinding.model.User;
import com.liangfeizc.databinding.sample.BaseActivity;

public class IncludeActivity extends BaseActivity {

    private ActivityIncludeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(
                this, R.layout.activity_include);

        //in order to get the etName, you must define an id for the include tag.
        binding.layoutInput.etName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                User user = new User(s.toString(), "Liang");

                binding.setUser(user);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}

