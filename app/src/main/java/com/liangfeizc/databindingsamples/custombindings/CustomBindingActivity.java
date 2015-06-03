package com.liangfeizc.databindingsamples.custombindings;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.liangfeizc.databindingsamples.ContactBinding;
import com.liangfeizc.databindingsamples.R;

public class CustomBindingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ContactBinding binding = DataBindingUtil.setContentView(
                this, R.layout.activity_custom_binding);

        Contact contact = new Contact("111", "Japan");
        binding.setContact(contact);
    }
}
