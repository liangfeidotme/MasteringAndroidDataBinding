package me.liangfei.databinding.model;

import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;

/**
 * Created by rufi on 6/3/15.
 */
public class PlainUser {
    public final ObservableField<String> firstName = new ObservableField<>();
    public final ObservableField<String> lastName = new ObservableField<>();
    public final ObservableInt age = new ObservableInt();
}
