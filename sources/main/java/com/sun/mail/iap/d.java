package com.sun.mail.iap;

import java.io.ByteArrayInputStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private byte[] f39177a;

    /* renamed from: b, reason: collision with root package name */
    private int f39178b;

    /* renamed from: c, reason: collision with root package name */
    private int f39179c;

    public d(byte[] bArr, int i6, int i7) {
        this.f39177a = bArr;
        this.f39178b = i6;
        this.f39179c = i7;
    }

    public byte[] a() {
        return this.f39177a;
    }

    public int b() {
        return this.f39179c;
    }

    public byte[] c() {
        int i6 = this.f39179c;
        byte[] bArr = new byte[i6];
        System.arraycopy(this.f39177a, this.f39178b, bArr, 0, i6);
        return bArr;
    }

    public int d() {
        return this.f39178b;
    }

    public void e(int i6) {
        byte[] bArr = this.f39177a;
        byte[] bArr2 = new byte[bArr.length + i6];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        this.f39177a = bArr2;
    }

    public void f(int i6) {
        this.f39179c = i6;
    }

    public ByteArrayInputStream g() {
        return new ByteArrayInputStream(this.f39177a, this.f39178b, this.f39179c);
    }

    public d(int i6) {
        this(new byte[i6], 0, i6);
    }
}
