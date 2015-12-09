package com.liangfeizc.databinding.sample;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;

import com.liangfeizc.databinding.R;
import com.liangfeizc.databinding.databinding.ActivityViewdataBindingBinding;
import com.liangfeizc.databinding.model.User;

/**
 * Created by Administrator on 2015/12/9.
 */
public class ViewDataBindingActivity extends BaseActivity{

    public static final String TAG = ViewDataBindingActivity.class.getSimpleName();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActivityViewdataBindingBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_viewdata_binding);
        final User user = new User("google", "github");
        binding.setUser(user);

        binding.editText.setText(user.getFirstName());
        binding.editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                user.setFirstName(s.toString().trim());

                Log.i(TAG, "has pending bindings:" + binding.hasPendingBindings());

                // Refresh ui
                binding.invalidateAll();
            }
        });
    }
}
