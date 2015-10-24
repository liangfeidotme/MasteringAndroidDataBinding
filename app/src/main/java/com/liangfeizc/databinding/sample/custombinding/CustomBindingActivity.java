package com.liangfeizc.databinding.sample.custombinding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.liangfeizc.databinding.ContractBinding;
import com.liangfeizc.databinding.R;
import com.liangfeizc.databinding.sample.BaseActivity;
import com.liangfeizc.databinding.model.Contact;

public class CustomBindingActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ContractBinding binding = DataBindingUtil.setContentView(
                this, R.layout.activity_custom_binding);

        Contact contact = new Contact("111", "Japan");
        binding.setContact(contact);
    }
}
