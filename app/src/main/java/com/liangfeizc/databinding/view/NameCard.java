package com.liangfeizc.databinding.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.liangfeizc.databinding.R;


/**
 * Created by rufi on 6/9/15.
 */
public class NameCard extends LinearLayout {
    private int mAge;

    private TextView mFirstName;
    private TextView mLastName;

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
        inflate(getContext(), R.layout.name_card, this);
        mFirstName = (TextView) findViewById(R.id.first_name);
        mLastName = (TextView) findViewById(R.id.last_name);
    }

    public void setFirstName(@NonNull final String firstName) {
        mFirstName.setText(firstName);
    }

    public void setLastName(@NonNull final String lastName) {
        mLastName.setText(lastName);
    }

    public void setAge(@IntRange(from=1) int age) {
        mAge = age;
    }
}
