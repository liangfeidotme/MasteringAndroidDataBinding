package com.liangfeizc.databinding.sample.converter;

import android.databinding.BindingAdapter;
import android.databinding.BindingConversion;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableBoolean;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.liangfeizc.databinding.R;
import com.liangfeizc.databinding.databinding.ActivityConversionsBinding;
import com.liangfeizc.databinding.sample.BaseActivity;
import com.liangfeizc.databinding.utils.ScreenUtils;

public class ConversionsActivity extends BaseActivity {

    private boolean mIsError;
    private ObservableBoolean mIsErrorObservable = new ObservableBoolean();
    private ActivityConversionsBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_conversions);

        mIsError = true;
        mBinding.setIsError(mIsError);
        mBinding.setHeight(ScreenUtils.dp2px(this, 100));

        mIsErrorObservable.set(true);
        mBinding.setIsErrorObservable(mIsErrorObservable);
    }

    public void toggleIsError(View view) {
        mIsError = !mIsError;
        mBinding.setIsError(mIsError);
    }

    public void toggleIsErrorObservable(View view) {
         mIsErrorObservable.set(!mIsErrorObservable.get());
    }

    @BindingConversion
    public static ColorDrawable convertColorToDrawable(int color) {
        return new ColorDrawable(color);
    }

    @BindingAdapter("bind:layout_height")
    public static void setLayoutHeight(View view, float height) {
        ViewGroup.LayoutParams params = view.getLayoutParams();
        params.height = (int) height;
        view.setLayoutParams(params);
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
