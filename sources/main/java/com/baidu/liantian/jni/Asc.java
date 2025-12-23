package com.baidu.liantian.jni;

import com.baidu.liantian.b.e;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class Asc {
    public static native String fai(String str, String str2, String str3);

    public native byte[] ac(byte[] bArr, byte[] bArr2);

    public native byte[] ar(byte[] bArr, byte[] bArr2);

    public native byte[] dc(byte[] bArr, byte[] bArr2);

    public native int df(String str, String str2, byte[] bArr);

    public native byte[] dr(byte[] bArr, byte[] bArr2);

    static {
        try {
            System.loadLibrary("liantian");
        } catch (Throwable unused) {
            e.a();
        }
    }
}
