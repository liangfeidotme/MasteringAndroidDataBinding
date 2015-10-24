package com.liangfeizc.databinding.model;

import android.databinding.ObservableField;
import android.databinding.ObservableInt;

/**
 * Created by rufi on 6/3/15.
 */
public class PlainUser {
    public final ObservableField<String> firstName = new ObservableField<>();
    public final ObservableField<String> lastName = new ObservableField<>();
    public final ObservableInt age = new ObservableInt();
}
