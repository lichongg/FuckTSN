package com.bytedance.sdk.component.tl.xt.j.j;

import android.text.TextUtils;
import android.util.Base64;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw {
    public static String j(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return Base64.encodeToString(str.getBytes(), 10);
    }

    public static String xt(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return new String(Base64.decode(str, 10));
    }
}
