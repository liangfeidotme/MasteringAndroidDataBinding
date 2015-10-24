package com.liangfeizc.databinding.utils;

import android.content.Context;

/**
 * Created by liangfeizc on 7/31/15.
 */
public class ScreenUtils {
    public static float dp2px(final Context context, final float dpValue) {
        return dpValue * context.getResources().getDisplayMetrics().density;
    }
}
