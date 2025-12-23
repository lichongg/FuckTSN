package com.huawei.secure.android.common.util;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private static final String f35275a = "SafeStringBuffer";

    /* renamed from: b, reason: collision with root package name */
    private static final String f35276b = "";

    public static String a(StringBuffer stringBuffer, int i6) {
        if (stringBuffer != null && stringBuffer.length() >= i6 && i6 >= 0) {
            try {
                return stringBuffer.substring(i6);
            } catch (Exception e6) {
                e6.getMessage();
            }
        }
        return "";
    }

    public static String b(StringBuffer stringBuffer, int i6, int i7) {
        if (stringBuffer != null && i6 >= 0 && i7 <= stringBuffer.length() && i7 >= i6) {
            try {
                return stringBuffer.substring(i6, i7);
            } catch (Exception e6) {
                e6.getMessage();
            }
        }
        return "";
    }
}
