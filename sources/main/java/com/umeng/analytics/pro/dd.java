package com.umeng.analytics.pro;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class dd extends de {

    /* renamed from: a, reason: collision with root package name */
    private byte[] f41210a;

    /* renamed from: b, reason: collision with root package name */
    private int f41211b;

    /* renamed from: c, reason: collision with root package name */
    private int f41212c;

    public dd() {
    }

    @Override // com.umeng.analytics.pro.de
    public boolean a() {
        return true;
    }

    @Override // com.umeng.analytics.pro.de
    public void b() throws df {
    }

    @Override // com.umeng.analytics.pro.de
    public void c() {
    }

    public void e() {
        this.f41210a = null;
    }

    public dd(byte[] bArr) {
        a(bArr);
    }

    public void a(byte[] bArr) {
        c(bArr, 0, bArr.length);
    }

    @Override // com.umeng.analytics.pro.de
    public void b(byte[] bArr, int i6, int i7) throws df {
        throw new UnsupportedOperationException("No writing allowed!");
    }

    public void c(byte[] bArr, int i6, int i7) {
        this.f41210a = bArr;
        this.f41211b = i6;
        this.f41212c = i6 + i7;
    }

    @Override // com.umeng.analytics.pro.de
    public byte[] f() {
        return this.f41210a;
    }

    @Override // com.umeng.analytics.pro.de
    public int g() {
        return this.f41211b;
    }

    @Override // com.umeng.analytics.pro.de
    public int h() {
        return this.f41212c - this.f41211b;
    }

    @Override // com.umeng.analytics.pro.de
    public int a(byte[] bArr, int i6, int i7) throws df {
        int h6 = h();
        if (i7 > h6) {
            i7 = h6;
        }
        if (i7 > 0) {
            System.arraycopy(this.f41210a, this.f41211b, bArr, i6, i7);
            a(i7);
        }
        return i7;
    }

    public dd(byte[] bArr, int i6, int i7) {
        c(bArr, i6, i7);
    }

    @Override // com.umeng.analytics.pro.de
    public void a(int i6) {
        this.f41211b += i6;
    }
}
