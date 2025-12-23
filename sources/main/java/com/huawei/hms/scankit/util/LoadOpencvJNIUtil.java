package com.huawei.hms.scankit.util;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class LoadOpencvJNIUtil {
    private static final String TAG = "LoadOpencvJNIUtil";

    public static byte[] QRCornerDetect(byte[] bArr, int i6, int i7, float[] fArr) {
        if (bArr != null) {
            return OpencvJNI.QRCornerDetect(bArr, i6, i7, fArr);
        }
        return null;
    }

    public static float[] QuadFitting(float[] fArr, int i6, float[] fArr2) {
        if (fArr2 != null) {
            return OpencvJNI.QuadFitting(fArr, i6, fArr2);
        }
        return null;
    }

    public static byte[] adaptivebinary(byte[] bArr, int i6, int i7, int i8, boolean z5) {
        if (bArr == null || i6 < i8 || i7 < i8) {
            return null;
        }
        return OpencvJNI.adaptiveBinary(bArr, i6, i7, i8, z5);
    }

    public static byte[] imageResize(byte[] bArr, int i6, int i7, int i8, int i9) {
        if (bArr != null) {
            return OpencvJNI.imageResize(bArr, i6, i7, i8, i9);
        }
        return null;
    }

    public static byte[] imageRotate(byte[] bArr, int i6, int i7, int i8, int i9, float f6, double d6) {
        if (bArr != null) {
            return OpencvJNI.imageRotate(bArr, i6, i7, i8, i9, f6, d6);
        }
        return null;
    }

    public static float[] multiBarcodeDetect(byte[] bArr, int i6, int i7, int i8, boolean z5) {
        if (bArr != null) {
            return OpencvJNI.multiBarcodeDetect(bArr, i6, i7, i8, z5);
        }
        return null;
    }

    public static byte[] removeMoirePattern(byte[] bArr, int i6, int i7) {
        if (bArr != null) {
            return OpencvJNI.removeMoirePattern(bArr, i6, i7);
        }
        return null;
    }

    public static void setModel(byte[] bArr, int i6, byte[] bArr2, int i7, byte[] bArr3, int i8) {
        if (bArr != null) {
            OpencvJNI.setModel(bArr, i6, bArr2, i7, bArr3, i8);
        }
    }

    public static byte[] sharpen(byte[] bArr, int i6, int i7) {
        if (bArr != null) {
            return OpencvJNI.sharpen(bArr, i6, i7);
        }
        return null;
    }
}
