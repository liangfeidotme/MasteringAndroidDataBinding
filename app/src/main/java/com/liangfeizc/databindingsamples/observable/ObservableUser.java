package com.liangfeizc.databindingsamples.observable;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.liangfeizc.databindingsamples.BR;

/**
 * Created by rufi on 6/3/15.
 */
public class ObservableUser extends BaseObservable {
    private String firstName;
    private String lastName;

    public ObservableUser() {
    }

    public ObservableUser(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        notifyPropertyChanged(BR.firstName);
        notifyPropertyChanged(BR.lastName);
    }

    @Bindable
    public String getFirstName() {
        return firstName;
    }

    @Bindable
    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        notifyPropertyChanged(BR.firstName);
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        notifyPropertyChanged(BR.lastName);
    }
}
