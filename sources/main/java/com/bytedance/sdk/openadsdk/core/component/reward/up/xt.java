package com.bytedance.sdk.openadsdk.core.component.reward.up;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.kt;
import com.bytedance.sdk.openadsdk.core.rn.ed;

/* loaded from: D:\Downloads\app\classes4.dex */
public final class xt {
    public static float[] j(Context context, float f6, int i6) {
        float min;
        float max;
        float r5 = ed.r(context, ed.g(context));
        float r6 = ed.r(context, ed.oq(context));
        if (i6 == 2) {
            min = Math.max(r5, r6);
            max = Math.min(r5, r6);
        } else {
            min = Math.min(r5, r6);
            max = Math.max(r5, r6);
        }
        int r7 = ed.r(context, ed.qv(context));
        if (ed.xt() || f6 != 100.0f) {
            if (i6 != 2) {
                max -= r7;
            } else {
                if ("SM-A207F".equals(kt.v())) {
                    r7 *= 2;
                }
                min -= r7;
            }
        }
        return new float[]{min, max};
    }

    public static int[] j(Context context, float f6, float f7, int i6) {
        int i7;
        float[] j6 = j(context, f6, i6);
        float f8 = j6[0];
        float f9 = j6[1];
        int min = (int) (Math.min(f8, f9) * f7);
        if (i6 != 2) {
            float f10 = min;
            i7 = (int) Math.max((f9 - (((f8 - f10) - f10) / f6)) / 2.0f, 0.0f);
        } else {
            float f11 = min;
            min = (int) Math.max((f8 - (((f9 - f11) - f11) * f6)) / 2.0f, 0.0f);
            i7 = min;
        }
        return new int[]{min, i7, min, i7};
    }
}
