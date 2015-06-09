package com.liangfeizc.databindingsamples.attributesetters;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.liangfeizc.databindingsamples.R;
import com.liangfeizc.databindingsamples.databinding.ActivityAttributeSettersBinding;
import com.squareup.picasso.Picasso;

public class AttributeSettersActivity extends AppCompatActivity {
    private static final String TAG = "AttributeSetters";
    public static final String IMG_URL = "http://tvfan.kyodo.co.jp/wp-content/uploads/2015/01/15027b37a4104edd85fb5b79a6c9e3ac-344x516.jpg";
    public View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(
                    getApplicationContext(),
                    "User view is clicked",
                    Toast.LENGTH_LONG).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityAttributeSettersBinding binding =
                DataBindingUtil.setContentView(this, R.layout.activity_attribute_setters);

        binding.setActivity(this);
        binding.setImageUrl(IMG_URL);
    }

    @BindingAdapter({"bind:imageUrl", "bind:error"})
    public static void loadImage(ImageView view, String url, Drawable error) {
        Picasso.with(view.getContext()).load(url).error(error).into(view);
    }
}

