package com.liangfeizc.databindingsamples;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.liangfeizc.databindingsamples.basic.BasicActivity;
import com.liangfeizc.databindingsamples.collections.CollectionActivity;
import com.liangfeizc.databindingsamples.custombindings.CustomBindingActivity;
import com.liangfeizc.databindingsamples.includes.IncludeActivity;
import com.liangfeizc.databindingsamples.resources.ResourceActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openBasic(View view) {
        startActivity(new Intent(this, BasicActivity.class));
    }

    public void openCustomBinding(View view) {
        startActivity(new Intent(this, CustomBindingActivity.class));
    }

    public void openIncludes(View view) {
        startActivity(new Intent(this, IncludeActivity.class));
    }

    public void openCollections(View view) {
        startActivity(new Intent(this, CollectionActivity.class));
    }

    public void openResources(View view) {
        startActivity(new Intent(this, ResourceActivity.class));
    }
}
