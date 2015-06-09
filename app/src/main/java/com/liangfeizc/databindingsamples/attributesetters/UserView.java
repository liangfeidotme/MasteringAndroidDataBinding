package com.liangfeizc.databindingsamples.attributesetters;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.liangfeizc.databindingsamples.R;

/**
 * Created by rufi on 6/9/15.
 */
public class UserView extends LinearLayout {
    private TextView mFirstNameView;
    private TextView mLastNameView;
    private TextView mAgeView;

    private int mAge;

    public UserView(Context context) {
        this(context, null);
    }

    public UserView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public UserView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.UserView);

        try {
            mAge = a.getInteger(R.styleable.UserView_age, 0);
        } finally {
            a.recycle();
        }

        init();
    }

    private void init() {
        setOrientation(VERTICAL);
        mFirstNameView = new TextView(getContext());
        mLastNameView = new TextView(getContext());
        mAgeView = new TextView(getContext());

        setAge(mAge);

        addView(mFirstNameView);
        addView(mLastNameView);
        addView(mAgeView);
    }

    public void setFirstName(final String firstName) {
        mFirstNameView.setText(firstName);
    }

    public void setLastName(final String lastName) {
        mLastNameView.setText(lastName);
    }

    public void setAge(int age) {
        mAgeView.setText(String.valueOf(age));
    }

    public void setClickListener(View.OnClickListener listener) {

    }
}
