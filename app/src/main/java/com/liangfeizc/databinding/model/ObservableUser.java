package com.liangfeizc.databinding.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.liangfeizc.databinding.BR;

/**
 * Created by liangfeizc on 6/3/15.
 */
public class ObservableUser extends BaseObservable {
    private String mFirstName;
    private String mLastName;

    @Bindable
    public String getFirstName() {
        return mFirstName;
    }

    @Bindable
    public String getLastName() {
        return mLastName;
    }

    public void setFirstName(String firstName) {
        mFirstName = firstName;
        notifyPropertyChanged(BR.firstName);
    }

    public void setLastName(String lastName) {
        mLastName = lastName;
        notifyPropertyChanged(BR.lastName);
    }
}
