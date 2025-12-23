package com.beizi.fusion.tool;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class am {
    @SuppressLint({"NewApi"})
    public static void a(View view, String str, int i6, String str2, int i7) {
        view.setBackground(a(str, i6, str2, i7));
    }

    private static Drawable a(String str, int i6, String str2, int i7) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        if (!TextUtils.isEmpty(str) && str.startsWith("#")) {
            gradientDrawable.setColor(Color.parseColor(str));
        } else {
            gradientDrawable.setColor(Color.parseColor("#00000000"));
        }
        if (i7 > 0) {
            gradientDrawable.setCornerRadius(i7);
        }
        if (i6 > 0 && !TextUtils.isEmpty(str2) && str2.startsWith("#")) {
            gradientDrawable.setStroke(i6, Color.parseColor(str2));
        }
        return gradientDrawable;
    }
}
