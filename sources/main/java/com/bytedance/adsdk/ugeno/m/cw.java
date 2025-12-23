package com.bytedance.adsdk.ugeno.m;

import com.bytedance.sdk.component.utils.vl;

/* loaded from: D:\Downloads\app\classes3.dex */
public final class cw {
    public static float j(String str, float f6) {
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException e6) {
            vl.j(e6);
            return f6;
        }
    }

    public static int j(String str, int i6) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e6) {
            vl.j(e6);
            return i6;
        }
    }

    public static long j(String str, long j6) {
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException e6) {
            vl.j(e6);
            return j6;
        }
    }

    public static double j(String str, double d6) {
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException e6) {
            vl.j(e6);
            return d6;
        }
    }

    public static boolean j(String str, boolean z5) {
        try {
            return Boolean.parseBoolean(str);
        } catch (NumberFormatException e6) {
            vl.j(e6);
            return z5;
        }
    }
}
