package com.liangfeizc.databindingsamples.observable;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.liangfeizc.databindingsamples.R;
import com.liangfeizc.databindingsamples.databinding.ActivityObservableBinding;

public class ObservableActivity extends AppCompatActivity {

    private ObservableUser user = new ObservableUser();
    private PlainUser plainUser = new PlainUser();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityObservableBinding binding = DataBindingUtil.setContentView(
                this, R.layout.activity_observable);

        setMyName(null);

        binding.setUser(user);
        binding.setPlainUser(plainUser);
    }

    public void setOtherName(View view) {
        user.setFirstName("zhu");
        user.setLastName("chen");

        plainUser.firstName.set("zhu");
        plainUser.lastName.set("chen");
        plainUser.age.set(27);
    }

    public void setMyName(View view) {
        user.setFirstName("liang");
        user.setLastName("fei");

        plainUser.firstName.set("liang");
        plainUser.lastName.set("fei");
        plainUser.age.set(27);
    }
}
