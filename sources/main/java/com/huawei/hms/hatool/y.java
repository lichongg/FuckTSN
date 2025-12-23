package com.huawei.hms.hatool;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class y {

    /* renamed from: a, reason: collision with root package name */
    private byte[] f33681a;

    /* renamed from: b, reason: collision with root package name */
    private int f33682b = 0;

    public void a(byte[] bArr, int i6) {
        if (i6 <= 0) {
            return;
        }
        byte[] bArr2 = this.f33681a;
        int length = bArr2.length;
        int i7 = this.f33682b;
        if (length - i7 >= i6) {
            System.arraycopy(bArr, 0, bArr2, i7, i6);
        } else {
            byte[] bArr3 = new byte[(bArr2.length + i6) << 1];
            System.arraycopy(bArr2, 0, bArr3, 0, i7);
            System.arraycopy(bArr, 0, bArr3, this.f33682b, i6);
            this.f33681a = bArr3;
        }
        this.f33682b += i6;
    }

    public byte[] b() {
        int i6 = this.f33682b;
        if (i6 <= 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[i6];
        System.arraycopy(this.f33681a, 0, bArr, 0, i6);
        return bArr;
    }

    public int c() {
        return this.f33682b;
    }

    public y(int i6) {
        this.f33681a = null;
        this.f33681a = new byte[i6];
    }
}
