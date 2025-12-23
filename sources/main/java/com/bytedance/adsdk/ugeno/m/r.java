package com.bytedance.adsdk.ugeno.m;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import xyz.adscope.common.v2.dev.info.ResIdentify;

/* loaded from: D:\Downloads\app\classes3.dex */
public final class r {

    @SuppressLint({"StaticFieldLeak"})
    private static Context cw;

    /* renamed from: j, reason: collision with root package name */
    private static String f23710j;
    private static Resources xt;

    private static String j(Context context) {
        if (f23710j == null) {
            f23710j = context.getPackageName();
        }
        return f23710j;
    }

    public static int cw(Context context, String str) {
        return j(context, str, "id");
    }

    public static int xt(Context context, String str) {
        return j(context, str, ResIdentify.RES_TYPE_DRAWABLE);
    }

    private static int j(Context context, String str, String str2) {
        if (xt == null) {
            xt = context.getResources();
        }
        return xt.getIdentifier(str, str2, j(context));
    }

    public static int j(Context context, String str) {
        return j(context, str, ResIdentify.RES_TYPE_RAW);
    }
}
