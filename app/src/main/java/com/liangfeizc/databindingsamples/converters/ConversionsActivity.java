package com.liangfeizc.databindingsamples.converters;

import android.database.Observable;
import android.databinding.BindingConversion;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableBoolean;
import android.databinding.layouts.DataBindingInfo;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.liangfeizc.databindingsamples.BaseActivity;
import com.liangfeizc.databindingsamples.R;
import com.liangfeizc.databindingsamples.databinding.ActivityConversionsBinding;

public class ConversionsActivity extends BaseActivity {

    private ObservableBoolean mIsError = new ObservableBoolean();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityConversionsBinding binding =
                DataBindingUtil.setContentView(this, R.layout.activity_conversions);

        mIsError.set(true);
        binding.setIsError(mIsError);
    }

    public void toggleIsError(View view) {
        mIsError.set(!mIsError.get());
    }

    @BindingConversion
    public static ColorDrawable convertColorToDrawable(int color) {
        return new ColorDrawable(color);
    }

    /** !!! Binding conversion should be forbidden, otherwise it will conflict with
     *  {@code android:visiblity} attribute.
     */
    /*
    @BindingConversion
    public static int convertColorToString(int color) {
        switch (color) {
            case Color.RED:
                return R.string.red;
            case Color.WHITE:
                return R.string.white;
        }
        return R.string.app_name;
    }*/
}
