package com.bytedance.sdk.component.adexpress.r;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;

/* loaded from: D:\Downloads\app\classes4.dex */
public class r {
    public static Drawable j(Context context, com.bytedance.sdk.component.adexpress.dynamic.cw.ae aeVar) {
        if (context == null || aeVar == null) {
            return null;
        }
        return j(context, (int) tl.j(context, aeVar.i()), aeVar.av(), aeVar.l());
    }

    public static Drawable j(Context context, int i6, int i7, int i8) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        if (context != null) {
            gradientDrawable.setStroke(i6, i7);
        }
        gradientDrawable.setColor(i8);
        return gradientDrawable;
    }
}
