package com.bytedance.sdk.component.adexpress.r;

import android.graphics.drawable.GradientDrawable;

/* loaded from: D:\Downloads\app\classes4.dex */
public class g {
    public static GradientDrawable j(int i6, Integer num, int[] iArr, int[] iArr2, Integer num2, Integer num3) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(i6);
        if (num != null) {
            gradientDrawable.setColor(num.intValue());
        }
        int length = iArr != null ? iArr.length : 0;
        if (length == 1) {
            gradientDrawable.setCornerRadius(iArr[0]);
        } else if (length == 4) {
            int i7 = iArr[0];
            int i8 = iArr[1];
            int i9 = iArr[2];
            int i10 = iArr[3];
            gradientDrawable.setCornerRadii(new float[]{i7, i7, i8, i8, i9, i9, i10, i10});
        }
        if (iArr2 != null && iArr2.length == 2) {
            gradientDrawable.setSize(iArr2[0], iArr2[1]);
        }
        if (num2 != null && num3 != null) {
            gradientDrawable.setStroke(num2.intValue(), num3.intValue());
        }
        return gradientDrawable;
    }
}
