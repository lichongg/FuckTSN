package com.huawei.hms.scankit.p;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
final class l {

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f34501a;

    /* renamed from: b, reason: collision with root package name */
    private int f34502b = 0;

    private void a(int i6, boolean z5) {
        if (!w7.a(this.f34501a, i6)) {
            throw new ArrayIndexOutOfBoundsException();
        }
        this.f34501a[i6] = z5 ? (byte) 1 : (byte) 0;
    }

    l(int i6) {
        this.f34501a = new byte[i6];
    }

    void a(boolean z5, int i6) {
        for (int i7 = 0; i7 < i6; i7++) {
            int i8 = this.f34502b;
            this.f34502b = i8 + 1;
            a(i8, z5);
        }
    }

    byte[] a(int i6) {
        int length = this.f34501a.length * i6;
        byte[] bArr = new byte[length];
        for (int i7 = 0; i7 < length; i7++) {
            bArr[i7] = this.f34501a[i7 / i6];
        }
        return bArr;
    }
}
