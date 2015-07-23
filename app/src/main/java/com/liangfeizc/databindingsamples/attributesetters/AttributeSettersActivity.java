package com.liangfeizc.databindingsamples.attributesetters;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.liangfeizc.databindingsamples.BaseActivity;
import com.liangfeizc.databindingsamples.R;
import com.liangfeizc.databindingsamples.basic.User;
import com.liangfeizc.databindingsamples.databinding.ActivityAttributeSettersBinding;
import com.squareup.picasso.Picasso;

public class AttributeSettersActivity extends BaseActivity {
    private ActivityAttributeSettersBinding binding;
    private static final String TAG = "AttributeSetters";
    public static final String IMG_URL = "https://avatars2.githubusercontent.com/u/8111106?v=3&s=460";
            //"http://tvfan.kyodo.co.jp/wp-content/uploads/2015/01/15027b37a4104edd85fb5b79a6c9e3ac-344x516.jpg";
    public static final String NAMESPACE = "AttributeSettersActivity";
    public View.OnClickListener clickListener,firstClickListener,secondClickListener;
    private static boolean ifFirst = true;
    private User user = new User("Jue","Huang",24);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_attribute_setters);
        initListener();
        binding.setActivity(this);
        binding.setImageUrl(IMG_URL);
        binding.setUser(user);

    }

    private void initListener() {
        firstClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(
                        getApplicationContext(),
                        "User view is clicked-first",
                        Toast.LENGTH_SHORT).show();
                changeListener();

            }
        };

        secondClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(
                        getApplicationContext(),
                        "User view is clicked-second",
                        Toast.LENGTH_SHORT).show();
                changeListener();
            }
        };

        clickListener = firstClickListener;
    }

    private void changeListener() {
        ifFirst = !ifFirst;
        clickListener = (ifFirst)? firstClickListener: secondClickListener;
        //如果没有binding的setActivity，则无法刷新clicklistener
        binding.setActivity(this);
    }

    //这个函数可以写在任何一个class当中，所有imageview满足以下三个入参的都会运行该函数
    @BindingAdapter({"bind:imageUrl", "bind:error","bind:namespace"})
    public static void loadImage(ImageView view, String url, Drawable error,String namespace) {
        if (namespace.equals(NAMESPACE)){
            Picasso.with(view.getContext()).load(url).error(error).into(view);
            Toast.makeText(view.getContext(), "loading:"+namespace, Toast.LENGTH_SHORT).show();
        }

    }
}

