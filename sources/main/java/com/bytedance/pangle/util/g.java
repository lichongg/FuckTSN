package com.bytedance.pangle.util;

import android.os.Build;
import android.text.TextUtils;

/* loaded from: D:\Downloads\app\classes4.dex */
public class g {
    public static boolean cw() {
        return false;
    }

    public static boolean j() {
        return true;
    }

    public static boolean ae() {
        return Build.VERSION.SDK_INT <= 25;
    }

    public static boolean av() {
        int i6;
        int i7 = Build.VERSION.SDK_INT;
        if (i7 >= 29) {
            return true;
        }
        if (i7 != 28) {
            return false;
        }
        i6 = Build.VERSION.PREVIEW_SDK_INT;
        return i6 > 0;
    }

    public static boolean az() {
        int i6;
        int i7 = Build.VERSION.SDK_INT;
        if (i7 >= 28) {
            return true;
        }
        if (i7 != 27) {
            return false;
        }
        i6 = Build.VERSION.PREVIEW_SDK_INT;
        return i6 > 0;
    }

    public static boolean g() {
        int i6 = Build.VERSION.SDK_INT;
        return i6 >= 29 && i6 <= 30;
    }

    public static boolean i() {
        return Build.VERSION.SDK_INT == 29;
    }

    public static boolean jy() {
        int i6 = Build.VERSION.SDK_INT;
        return i6 >= 24 && i6 <= 28;
    }

    public static boolean kt() {
        return TextUtils.equals(Build.BRAND.toLowerCase(), "huawei");
    }

    public static boolean m() {
        return Build.VERSION.SDK_INT < 23;
    }

    public static boolean mi() {
        int i6;
        int i7 = Build.VERSION.SDK_INT;
        if (i7 >= 31) {
            return true;
        }
        if (i7 != 30) {
            return false;
        }
        i6 = Build.VERSION.PREVIEW_SDK_INT;
        return i6 > 0;
    }

    public static boolean oq() {
        return Build.VERSION.SDK_INT >= 23;
    }

    public static boolean qv() {
        return Build.VERSION.SDK_INT > 23;
    }

    public static boolean r() {
        return Build.VERSION.SDK_INT <= 28;
    }

    public static boolean tj() {
        return TextUtils.equals(Build.BRAND.toLowerCase(), "samsung");
    }

    public static boolean tl() {
        int i6 = Build.VERSION.SDK_INT;
        return i6 >= 26 && i6 <= 28;
    }

    public static boolean up() {
        return Build.VERSION.SDK_INT <= 23;
    }

    public static boolean vl() {
        int i6 = Build.VERSION.SDK_INT;
        return i6 >= 24 && i6 <= 25;
    }

    public static boolean w() {
        int i6;
        int i7 = Build.VERSION.SDK_INT;
        if (i7 >= 30) {
            return true;
        }
        if (i7 != 29) {
            return false;
        }
        i6 = Build.VERSION.PREVIEW_SDK_INT;
        return i6 > 0;
    }

    public static boolean ws() {
        return Build.VERSION.SDK_INT >= 26;
    }

    public static boolean xt() {
        return Build.VERSION.SDK_INT > 22;
    }
}
