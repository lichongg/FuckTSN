package com.huawei.hms.feature.dynamic.f;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final char[] f33242a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: b, reason: collision with root package name */
    public static final char[] f33243b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static char[] a(byte[] bArr) {
        return a(bArr, false);
    }

    public static char[] a(byte[] bArr, boolean z5) {
        return a(bArr, z5 ? f33243b : f33242a);
    }

    public static String b(byte[] bArr, boolean z5) {
        return new String(a(bArr, z5));
    }

    public static char[] a(byte[] bArr, char[] cArr) {
        char[] cArr2 = new char[bArr.length << 1];
        int i6 = 0;
        for (byte b6 : bArr) {
            int i7 = i6 + 1;
            cArr2[i6] = cArr[(b6 & 240) >>> 4];
            i6 += 2;
            cArr2[i7] = cArr[b6 & 15];
        }
        return cArr2;
    }
}
