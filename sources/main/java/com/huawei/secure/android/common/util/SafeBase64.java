package com.huawei.secure.android.common.util;

import android.util.Base64;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class SafeBase64 {

    /* renamed from: a, reason: collision with root package name */
    private static final String f35252a = "SafeBase64";

    public static byte[] decode(byte[] bArr, int i6) {
        try {
            return Base64.decode(bArr, i6);
        } catch (Exception e6) {
            e6.getMessage();
            return new byte[0];
        }
    }

    public static byte[] encode(byte[] bArr, int i6) {
        try {
            return Base64.encode(bArr, i6);
        } catch (Exception e6) {
            e6.getMessage();
            return new byte[0];
        }
    }

    public static String encodeToString(byte[] bArr, int i6) {
        try {
            return Base64.encodeToString(bArr, i6);
        } catch (Exception e6) {
            e6.getMessage();
            return "";
        }
    }

    private SafeBase64() {
    }

    public static String encodeToString(byte[] bArr, int i6, int i7, int i8) {
        try {
            return Base64.encodeToString(bArr, i6, i7, i8);
        } catch (Exception e6) {
            e6.getMessage();
            return "";
        }
    }

    public static byte[] decode(byte[] bArr, int i6, int i7, int i8) {
        try {
            return Base64.decode(bArr, i6, i7, i8);
        } catch (Exception e6) {
            e6.getMessage();
            return new byte[0];
        }
    }

    public static byte[] encode(byte[] bArr, int i6, int i7, int i8) {
        try {
            return Base64.encode(bArr, i6, i7, i8);
        } catch (Exception e6) {
            e6.getMessage();
            return new byte[0];
        }
    }

    public static byte[] decode(String str, int i6) {
        try {
            return Base64.decode(str, i6);
        } catch (Exception e6) {
            e6.getMessage();
            return new byte[0];
        }
    }
}
