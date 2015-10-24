package com.liangfeizc.databinding.sample.viewstub;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;

import com.liangfeizc.databinding.R;
import com.liangfeizc.databinding.sample.BaseActivity;
import com.liangfeizc.databinding.databinding.ActivityViewStubBinding;
import com.liangfeizc.databinding.databinding.ViewStubBinding;
import com.liangfeizc.databinding.model.User;

public class ViewStubActivity extends BaseActivity {
    private ActivityViewStubBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_view_stub);
        mBinding.viewStub.setOnInflateListener(new ViewStub.OnInflateListener() {
            @Override
            public void onInflate(ViewStub stub, View inflated) {
                ViewStubBinding binding = DataBindingUtil.bind(inflated);
                User user = new User("liang", "fei");
                binding.setUser(user);
            }
        });

    }


    /**
     * Don't panic for red error reporting. Just ignore it and run the app. Surprise never ends.
     */
    public void inflateViewStub(View view) {
        if (!mBinding.viewStub.isInflated()) {
            mBinding.viewStub.getViewStub().inflate();
        }
    }
}