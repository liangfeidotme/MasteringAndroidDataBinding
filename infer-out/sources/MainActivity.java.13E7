package com.liangfeizc.databinding.sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.liangfeizc.databinding.R;
import com.liangfeizc.databinding.sample.attributesetters.AttributeSettersActivity;
import com.liangfeizc.databinding.sample.basic.BasicActivity;
import com.liangfeizc.databinding.sample.collections.CollectionActivity;
import com.liangfeizc.databinding.sample.converters.ConversionsActivity;
import com.liangfeizc.databinding.sample.custombindings.CustomBindingActivity;
import com.liangfeizc.databinding.sample.dynamic.DynamicActivity;
import com.liangfeizc.databinding.sample.includes.IncludeActivity;
import com.liangfeizc.databinding.sample.observable.ObservableActivity;
import com.liangfeizc.databinding.sample.resources.ResourceActivity;
import com.liangfeizc.databinding.sample.viewids.ViewWithIDsActivity;
import com.liangfeizc.databinding.sample.viewstub.ViewStubActivity;

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

    public void openObservable(View view) {
        startActivity(new Intent(this, ObservableActivity.class));
    }

    public void openViewWithIDs(View view) {
        startActivity(new Intent(this, ViewWithIDsActivity.class));
    }

    public void openViewStub(View view) {
        startActivity(new Intent(this, ViewStubActivity.class));
    }

    public void openDynamicVariables(View view) {
        startActivity(new Intent(this, DynamicActivity.class));
    }

    public void openAttributeSetters(View view) {
        startActivity(new Intent(this, AttributeSettersActivity.class));
    }

    public void openConverters(View view) {
        startActivity(new Intent(this, ConversionsActivity.class));
    }
}
