package com.liangfeizc.databindingsamples.includes;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.liangfeizc.databindingsamples.R;
import com.liangfeizc.databindingsamples.basic.User;
import com.liangfeizc.databindingsamples.custombindings.Contact;
import com.liangfeizc.databindingsamples.databinding.ActivityIncludeBinding;

public class IncludeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityIncludeBinding binding = DataBindingUtil.setContentView(
                this, R.layout.activity_include);
        User user = new User("liang", "fei");
        Contact contact = new Contact("123456", "China");

        binding.setUser(user);
        binding.setContact(contact);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_include, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
