package com.bytedance.sdk.component.j;

import android.text.TextUtils;

/* loaded from: D:\Downloads\app\classes4.dex */
class x {

    /* renamed from: j, reason: collision with root package name */
    private static boolean f26512j;

    static String j(Throwable th) {
        StringBuilder sb = new StringBuilder("{\"code\":");
        sb.append(th instanceof w ? ((w) th).f26511j : 0);
        sb.append("}");
        return sb.toString();
    }

    static String j(String str) {
        if (TextUtils.isEmpty(str)) {
            return "{\"code\":1}";
        }
        String substring = f26512j ? str.substring(1, str.length() - 1) : "";
        String str2 = "{\"code\":1,\"__data\":" + str;
        if (substring.isEmpty()) {
            return str2 + "}";
        }
        return str2 + "," + substring + "}";
    }

    static String j() {
        return "";
    }

    static void j(boolean z5) {
        f26512j = z5;
    }
}
