package com.liangfeizc.databindingsamples.observable;

import android.databinding.ObservableField;

/**
 * Created by rufi on 6/3/15.
 */
public class PlainUser {
    public final ObservableField<String> firstName = new ObservableField<>();
    public final ObservableField<String> lastName = new ObservableField<>();
    public final ObservableField<Integer> age = new ObservableField<>();
}
