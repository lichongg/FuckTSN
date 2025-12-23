package com.huawei.hms.scankit.util;

import com.huawei.hms.scankit.p.m1;
import com.huawei.hms.scankit.p.o4;
import com.huawei.hms.scankit.p.r3;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class OpencvJNI {
    public static native byte[] QRCornerDetect(byte[] bArr, int i6, int i7, float[] fArr);

    public static native float[] QuadFitting(float[] fArr, int i6, float[] fArr2);

    public static native byte[] adaptiveBinary(byte[] bArr, int i6, int i7, int i8, boolean z5);

    public static native byte[] imageResize(byte[] bArr, int i6, int i7, int i8, int i9);

    public static native byte[] imageRotate(byte[] bArr, int i6, int i7, int i8, int i9, float f6, double d6);

    public static native float[] multiBarcodeDetect(byte[] bArr, int i6, int i7, int i8, boolean z5);

    public static native byte[] removeMoirePattern(byte[] bArr, int i6, int i7);

    public static native void setModel(byte[] bArr, int i6, byte[] bArr2, int i7, byte[] bArr3, int i8);

    public static native byte[] sharpen(byte[] bArr, int i6, int i7);

    public static void init() {
        o4.d("OpencvJNI", "init()");
        o4.d("OpencvJNI", "start load method");
        try {
            System.loadLibrary("scannative");
            r3.A = true;
        } catch (UnsatisfiedLinkError e6) {
            o4.b("OpencvJNI", e6.getMessage());
            m1.a(false);
        }
    }
}
