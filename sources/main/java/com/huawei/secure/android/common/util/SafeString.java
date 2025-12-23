package com.huawei.secure.android.common.util;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class SafeString {

    /* renamed from: a, reason: collision with root package name */
    private static final String f35253a = "SafeString";

    /* renamed from: b, reason: collision with root package name */
    private static final String f35254b = "";

    public static String substring(String str, int i6) {
        if (str != null && str.length() >= i6 && i6 >= 0) {
            try {
                return str.substring(i6);
            } catch (Exception e6) {
                e6.getMessage();
            }
        }
        return "";
    }

    public static String replace(String str, CharSequence charSequence, CharSequence charSequence2) {
        if (str != null && charSequence != null && charSequence2 != null) {
            try {
                return str.replace(charSequence, charSequence2);
            } catch (Exception e6) {
                e6.getMessage();
            }
        }
        return str;
    }

    public static String substring(String str, int i6, int i7) {
        if (str != null && i6 >= 0 && i7 <= str.length() && i7 >= i6) {
            try {
                return str.substring(i6, i7);
            } catch (Exception e6) {
                e6.getMessage();
            }
        }
        return "";
    }
}
