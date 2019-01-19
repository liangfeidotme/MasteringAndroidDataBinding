package me.liangfei.databinding.sample;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import me.liangfei.databinding.R;
import me.liangfei.databinding.sample.attributesetter.AttributeSettersActivity;
import me.liangfei.databinding.sample.basic.BasicActivity;
import me.liangfei.databinding.sample.collection.CollectionActivity;
import me.liangfei.databinding.sample.converter.ConversionsActivity;
import me.liangfei.databinding.sample.custombinding.CustomBindingActivity;
import me.liangfei.databinding.sample.dynamic.DynamicActivity;
import me.liangfei.databinding.sample.include.IncludeActivity;
import me.liangfei.databinding.sample.observable.ObservableActivity;
import me.liangfei.databinding.sample.resource.ResourceActivity;
import me.liangfei.databinding.sample.viewid.ViewWithIDsActivity;
import me.liangfei.databinding.sample.viewstub.ViewStubActivity;

import android.view.View;

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
