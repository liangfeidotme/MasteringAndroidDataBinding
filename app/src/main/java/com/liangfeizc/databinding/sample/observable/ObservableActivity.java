package com.liangfeizc.databinding.sample.observable;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayMap;
import android.os.Bundle;
import android.view.View;

import com.liangfeizc.databinding.R;
import com.liangfeizc.databinding.sample.BaseActivity;
import com.liangfeizc.databinding.databinding.ActivityObservableBinding;
import com.liangfeizc.databinding.model.ObservableUser;
import com.liangfeizc.databinding.model.PlainUser;

public class ObservableActivity extends BaseActivity {

    private ObservableUser user = new ObservableUser();
    private PlainUser plainUser = new PlainUser();
    private ObservableArrayMap<String, Object> mapUser = new ObservableArrayMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityObservableBinding binding = DataBindingUtil.setContentView(
                this, R.layout.activity_observable);

        setMyName(null);

        binding.setUser(user);
        binding.setPlainUser(plainUser);
        binding.setMapUser(mapUser);
    }

    public void setOtherName(View view) {
        user.setFirstName("zhu");
        user.setLastName("chen");

        plainUser.firstName.set("zhu");
        plainUser.lastName.set("chen");
        plainUser.age.set(27);

        mapUser.put("firstName", "zhu");
        mapUser.put("lastName", "chen");
        mapUser.put("age", 27);
    }

    public void setMyName(View view) {
        user.setFirstName("liang");
        user.setLastName("fei");

        plainUser.firstName.set("liang");
        plainUser.lastName.set("fei");
        plainUser.age.set(27);

        mapUser.put("firstName", "liang");
        mapUser.put("lastName", "fei");
        mapUser.put("age", 27);
    }
}
