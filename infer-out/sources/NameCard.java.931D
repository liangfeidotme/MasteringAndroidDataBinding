package com.liangfeizc.databinding.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.databinding.DataBindingUtil;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.LinearLayout;

import com.liangfeizc.databinding.R;
import com.liangfeizc.databinding.databinding.NameCardBinding;


/**
 * Created by rufi on 6/9/15.
 */
public class NameCard extends LinearLayout {
    private NameCardBinding mBinding;

    private int mAge;

    public NameCard(Context context) {
        this(context, null);
    }

    public NameCard(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public NameCard(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.NameCard);

        try {
            mAge = a.getInteger(R.styleable.NameCard_age, 0);
        } finally {
            a.recycle();
        }

        init();
    }

    private void init() {
        setGravity(Gravity.CENTER);
        setOrientation(VERTICAL);

        mBinding = DataBindingUtil.bind(inflate(getContext(), R.layout.name_card, this));
    }

    public void setFirstName(@NonNull final String firstName) {
        mBinding.setFirstName(firstName);
    }

    public void setLastName(@NonNull final String lastName) {
        mBinding.setLastName(lastName);
    }

    public void setAge(@IntRange(from=1) int age) {
        mAge = age;
    }
}
