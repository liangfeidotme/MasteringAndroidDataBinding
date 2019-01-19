package me.liangfei.databinding.sample.viewstub;

import androidx.databinding.DataBindingUtil;
import me.liangfei.databinding.R;
import me.liangfei.databinding.model.User;
import me.liangfei.databinding.sample.BaseActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;

import me.liangfei.databinding.databinding.ActivityViewStubBinding;
import me.liangfei.databinding.databinding.ViewStubBinding;


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