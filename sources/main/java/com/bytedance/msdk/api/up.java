package com.bytedance.msdk.api;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

/* loaded from: D:\Downloads\app\classes3.dex */
public class up {
    public static int j(Context context, float f6) {
        if (context == null) {
            return 0;
        }
        return (int) ((f6 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static void j(View view) {
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view);
            }
        }
    }

    public static int xt(Context context, float f6) {
        if (context == null) {
            return 0;
        }
        float f7 = context.getResources().getDisplayMetrics().density;
        if (f7 <= 0.0f) {
            f7 = 1.0f;
        }
        return (int) ((f6 / f7) + 0.5f);
    }

    public static int cw(Context context, float f6) {
        return (int) ((f6 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
