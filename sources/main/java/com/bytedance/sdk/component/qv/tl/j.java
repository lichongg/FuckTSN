package com.bytedance.sdk.component.qv.tl;

import android.text.TextUtils;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {
    public static String j(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            StringBuilder sb = new StringBuilder();
            int length = str.length();
            for (int i6 = 0; i6 < length; i6++) {
                char charAt = str.charAt(i6);
                if (charAt >= 'A' && charAt <= 'Z') {
                    if (sb.length() > 0) {
                        sb.append('_');
                    }
                    sb.append((char) (charAt + ' '));
                }
                sb.append(charAt);
            }
            return sb.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String j(String str, boolean z5) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (z5) {
            str = str.substring(1);
        }
        return j(str);
    }
}
