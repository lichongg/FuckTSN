package com.bytedance.sdk.component.adexpress.r;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw {
    public static boolean j(Context context) {
        return context != null && TextUtils.getLayoutDirectionFromLocale(context.getResources().getConfiguration().locale) == 1 && (context.getApplicationInfo().flags & 4194304) == 4194304;
    }
}
