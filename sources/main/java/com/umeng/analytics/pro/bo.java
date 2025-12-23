package com.umeng.analytics.pro;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class bo {
    public static final boolean a(int i6, int i7) {
        return (i6 & (1 << i7)) != 0;
    }

    public static final int b(int i6, int i7) {
        return i6 & (~(1 << i7));
    }

    public static final boolean a(long j6, int i6) {
        return (j6 & (1 << i6)) != 0;
    }

    public static final long b(long j6, int i6) {
        return j6 & (~(1 << i6));
    }

    public static final void a(int i6, byte[] bArr) {
        a(i6, bArr, 0);
    }

    public static final byte b(byte b6, int i6) {
        return (byte) b((int) b6, i6);
    }

    public static final void a(int i6, byte[] bArr, int i7) {
        bArr[i7] = (byte) ((i6 >> 24) & 255);
        bArr[i7 + 1] = (byte) ((i6 >> 16) & 255);
        bArr[i7 + 2] = (byte) ((i6 >> 8) & 255);
        bArr[i7 + 3] = (byte) (i6 & 255);
    }

    public static final short b(short s5, int i6) {
        return (short) b((int) s5, i6);
    }

    public static final int a(byte[] bArr) {
        return a(bArr, 0);
    }

    public static final int a(byte[] bArr, int i6) {
        return (bArr[i6 + 3] & 255) | ((bArr[i6] & 255) << 24) | ((bArr[i6 + 1] & 255) << 16) | ((bArr[i6 + 2] & 255) << 8);
    }

    public static final boolean a(byte b6, int i6) {
        return a((int) b6, i6);
    }

    public static final boolean a(short s5, int i6) {
        return a((int) s5, i6);
    }

    public static final byte a(byte b6, int i6, boolean z5) {
        return (byte) a((int) b6, i6, z5);
    }

    public static final short a(short s5, int i6, boolean z5) {
        return (short) a((int) s5, i6, z5);
    }

    public static final int a(int i6, int i7, boolean z5) {
        return z5 ? i6 | (1 << i7) : b(i6, i7);
    }

    public static final long a(long j6, int i6, boolean z5) {
        return z5 ? j6 | (1 << i6) : b(j6, i6);
    }
}
