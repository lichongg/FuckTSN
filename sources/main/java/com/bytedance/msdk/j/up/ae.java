package com.bytedance.msdk.j.up;

import android.content.Context;
import android.util.DisplayMetrics;

/* loaded from: D:\Downloads\app\classes3.dex */
public class ae {
    private static float cw = -1.0f;

    /* renamed from: j, reason: collision with root package name */
    private static float f25141j = -1.0f;

    /* renamed from: r, reason: collision with root package name */
    private static int f25142r = -1;
    private static int up = -1;
    private static int xt = -1;

    public static void j(Context context) {
        Context context2 = context == null ? com.bytedance.msdk.core.xt.getContext() : context;
        if (context2 == null) {
            return;
        }
        DisplayMetrics displayMetrics = context2.getResources().getDisplayMetrics();
        f25141j = displayMetrics.density;
        xt = displayMetrics.densityDpi;
        cw = displayMetrics.scaledDensity;
        f25142r = displayMetrics.widthPixels;
        up = displayMetrics.heightPixels;
        if (context == null || context.getResources() == null || context.getResources().getConfiguration() == null) {
            return;
        }
        if (context.getResources().getConfiguration().orientation == 1) {
            int i6 = f25142r;
            int i7 = up;
            if (i6 > i7) {
                f25142r = i7;
                up = i6;
                return;
            }
            return;
        }
        int i8 = f25142r;
        int i9 = up;
        if (i8 < i9) {
            f25142r = i9;
            up = i8;
        }
    }

    public static int xt(Context context) {
        j(context);
        return f25142r;
    }

    static {
        j(com.bytedance.msdk.core.xt.getContext());
    }

    public static int cw(Context context) {
        j(context);
        return up;
    }

    public static float r(Context context) {
        j(context);
        return f25141j;
    }

    public static int up(Context context) {
        j(context);
        return xt;
    }

    public static int xt(Context context, float f6) {
        return (int) ((f6 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int j(Context context, float f6) {
        j(context);
        float r5 = r(context);
        if (r5 <= 0.0f) {
            r5 = 1.0f;
        }
        return (int) ((f6 / r5) + 0.5f);
    }
}
