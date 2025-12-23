package com.huawei.secure.android.common.util;

import android.text.TextUtils;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    private static final String f35277a = "SafeStringBuilder";

    /* renamed from: b, reason: collision with root package name */
    private static final String f35278b = "";

    public static String a(StringBuilder sb, int i6) {
        if (!TextUtils.isEmpty(sb) && sb.length() >= i6 && i6 >= 0) {
            try {
                return sb.substring(i6);
            } catch (Exception e6) {
                e6.getMessage();
            }
        }
        return "";
    }

    public static String b(StringBuilder sb, int i6, int i7) {
        if (!TextUtils.isEmpty(sb) && i6 >= 0 && i7 <= sb.length() && i7 >= i6) {
            try {
                return sb.substring(i6, i7);
            } catch (Exception e6) {
                e6.getMessage();
            }
        }
        return "";
    }
}
