package com.bytedance.embedapplog.util;

import com.bytedance.embedapplog.uc;
import com.bytedance.sdk.openadsdk.l.m;

/* loaded from: D:\Downloads\app\classes3.dex */
public class TTEncryptUtils {
    private static native byte[] ttEncrypt(byte[] bArr, int i6);

    static {
        try {
            m.j("tobEmbedEncrypt");
        } catch (UnsatisfiedLinkError e6) {
            uc.xt(e6);
        }
    }

    public static byte[] a(byte[] bArr, int i6) {
        try {
            return ttEncrypt(bArr, i6);
        } catch (Throwable unused) {
            return null;
        }
    }
}
