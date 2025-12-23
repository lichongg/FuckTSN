package com.beizi.ad.internal.h;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class n {
    @SuppressLint({"NewApi"})
    public static void a(View view, String str, int i6, String str2, int i7) {
        view.setBackground(a(str, i6, str2, i7));
    }

    @SuppressLint({"NewApi"})
    public static void a(View view, String str, int i6, String str2, float[] fArr) {
        view.setBackground(a(str, i6, str2, fArr));
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

    private static Drawable a(String str, int i6, String str2, float[] fArr) {
        float[] fArr2 = new float[fArr.length];
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        if (!TextUtils.isEmpty(str) && str.startsWith("#")) {
            gradientDrawable.setColor(Color.parseColor(str));
        } else {
            gradientDrawable.setColor(Color.parseColor("#00000000"));
        }
        for (int i7 = 0; i7 < fArr.length; i7++) {
            float f6 = fArr[i7];
            if (f6 >= 0.0f) {
                fArr2[i7] = f6;
            } else {
                fArr2[i7] = 0.0f;
            }
        }
        gradientDrawable.setCornerRadii(fArr2);
        if (i6 > 0 && !TextUtils.isEmpty(str2) && str2.startsWith("#")) {
            gradientDrawable.setStroke(i6, Color.parseColor(str2));
        }
        return gradientDrawable;
    }
}
