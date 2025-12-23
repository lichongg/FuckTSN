package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.commonsdk.framework.UMModuleRegister;

/* loaded from: D:\Downloads\app\classes4.dex */
public final class h {
    public static boolean ae = false;
    public static String cw = "7.0.1.2";

    /* renamed from: j, reason: collision with root package name */
    public static boolean f29116j = false;

    /* renamed from: m, reason: collision with root package name */
    public static String f29117m = "main";

    /* renamed from: r, reason: collision with root package name */
    public static int f29118r = 999;
    public static String tl = "6.6.0.0";
    public static boolean up = true;
    public static int xt = 7012;

    public static boolean j() {
        return true;
    }

    public static boolean xt() {
        return false;
    }

    public static String j(Context context) {
        return "";
    }

    public static boolean m() {
        return TextUtils.equals(UMModuleRegister.INNER, f29117m);
    }

    public static String up() {
        StringBuilder sb = new StringBuilder();
        sb.append(f29117m);
        sb.append(j() ? "_plugin" : "");
        sb.append(ae ? "_open" : "_close");
        return sb.toString();
    }

    public static boolean cw() {
        return com.bytedance.sdk.openadsdk.l.m.xt();
    }

    public static boolean r() {
        return com.bytedance.sdk.component.vl.xt.xt.kt();
    }
}
