package com.bytedance.msdk.xt;

import android.text.TextUtils;
import com.bytedance.msdk.tl.rn;

/* loaded from: D:\Downloads\app\classes3.dex */
public class xt {

    /* renamed from: j, reason: collision with root package name */
    public static final String f25363j = rn.r();
    public static boolean xt = true;

    public static String cw() {
        if (!TextUtils.isEmpty(xt())) {
            String[] split = xt().split("\\.");
            if (split.length >= 4) {
                return split[0] + "." + split[1] + "." + split[2];
            }
            return "";
        }
        return "";
    }

    public static int j() {
        return Integer.parseInt(xt().replace(".", ""));
    }

    public static String r() {
        return com.bytedance.sdk.gromore.init.j.r();
    }

    public static String xt() {
        return com.bytedance.sdk.gromore.init.j.cw();
    }
}
