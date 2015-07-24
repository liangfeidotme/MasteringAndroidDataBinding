package com.liangfeizc.databindingsamples;

import android.content.Intent;
import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.style.DynamicDrawableSpan;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.liangfeizc.databindingsamples.attributesetters.AttributeSettersActivity;
import com.liangfeizc.databindingsamples.basic.BasicActivity;
import com.liangfeizc.databindingsamples.collections.CollectionActivity;
import com.liangfeizc.databindingsamples.converters.ConversionsActivity;
import com.liangfeizc.databindingsamples.custombindings.CustomBindingActivity;
import com.liangfeizc.databindingsamples.dynamic.DynamicActivity;
import com.liangfeizc.databindingsamples.includes.IncludeActivity;
import com.liangfeizc.databindingsamples.observable.ObservableActivity;
import com.liangfeizc.databindingsamples.resources.ResourceActivity;
import com.liangfeizc.databindingsamples.viewids.ViewWithIDsActivity;
import com.liangfeizc.databindingsamples.viewstub.ViewStubActivity;
import com.squareup.picasso.Picasso;

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
