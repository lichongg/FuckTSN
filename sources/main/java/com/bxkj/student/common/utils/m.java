package com.bxkj.student.common.utils;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.stub.StubApp;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    private static String f17815a = "com.ads.demo.UiUtil";

    public static void g(View view) {
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view);
            }
        }
    }

    public static int a(Context context, float dpValue) {
        return (int) ((dpValue * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static float b(Context context) {
        return f(context, context.getResources().getDisplayMetrics().heightPixels);
    }

    public static int c(Context context) {
        return StubApp.getOrigApplicationContext(context.getApplicationContext()).getResources().getDisplayMetrics().heightPixels;
    }

    public static float d(Context context) {
        float f6 = context.getResources().getDisplayMetrics().density;
        float f7 = context.getResources().getDisplayMetrics().widthPixels;
        if (f6 <= 0.0f) {
            f6 = 1.0f;
        }
        return (f7 / f6) + 0.5f;
    }

    public static int e(Context context) {
        return StubApp.getOrigApplicationContext(context.getApplicationContext()).getResources().getDisplayMetrics().widthPixels;
    }

    public static int f(Context context, float pxValue) {
        return (int) ((pxValue / context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
