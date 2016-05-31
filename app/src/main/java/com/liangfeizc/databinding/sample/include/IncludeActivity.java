package com.liangfeizc.databinding.sample.include;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import com.liangfeizc.databinding.R;
import com.liangfeizc.databinding.databinding.ActivityIncludeBinding;
import com.liangfeizc.databinding.listener.OkListener;
import com.liangfeizc.databinding.model.User;
import com.liangfeizc.databinding.sample.BaseActivity;

public class IncludeActivity extends BaseActivity implements OkListener {

    private ActivityIncludeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(
                this, R.layout.activity_include);

        binding.setListener(this);
        binding.setOkText("to toast");

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

    @Override
    public void onClickOk(View view) {
        Toast.makeText(this, "the btn clicked!", Toast.LENGTH_SHORT).show();
    }
}

