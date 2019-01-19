package me.liangfei.databinding.sample.custombinding;

import androidx.databinding.DataBindingUtil;
import me.liangfei.databinding.R;
import me.liangfei.databinding.model.Contact;
import me.liangfei.databinding.sample.BaseActivity;

import android.os.Bundle;

import me.liangfei.databinding.ContractBinding;

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
