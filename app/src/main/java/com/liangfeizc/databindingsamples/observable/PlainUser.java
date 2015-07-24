package com.liangfeizc.databindingsamples.observable;

import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;

/**
 * Created by rufi on 6/3/15.
 */
public class PlainUser {
    public ObservableField<String> firstName = new ObservableField<>();
    public ObservableField<String> lastName = new ObservableField<>();
    public ObservableInt age = new ObservableInt();
}
