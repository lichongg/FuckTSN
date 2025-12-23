package com.bytedance.sdk.component.xt.j.xt;

/* loaded from: D:\Downloads\app\classes4.dex */
final class m {
    m ae;
    int cw;

    /* renamed from: j, reason: collision with root package name */
    final byte[] f27322j;

    /* renamed from: m, reason: collision with root package name */
    m f27323m;

    /* renamed from: r, reason: collision with root package name */
    boolean f27324r;
    boolean up;
    int xt;

    m() {
        this.f27322j = new byte[8192];
        this.up = true;
        this.f27324r = false;
    }

    final m j() {
        this.f27324r = true;
        return new m(this.f27322j, this.xt, this.cw, true, false);
    }

    public final m xt() {
        m mVar = this.f27323m;
        m mVar2 = mVar != this ? mVar : null;
        m mVar3 = this.ae;
        if (mVar3 != null) {
            mVar3.f27323m = mVar;
        }
        m mVar4 = this.f27323m;
        if (mVar4 != null) {
            mVar4.ae = mVar3;
        }
        this.f27323m = null;
        this.ae = null;
        return mVar2;
    }

    public final m j(m mVar) {
        mVar.ae = this;
        mVar.f27323m = this.f27323m;
        this.f27323m.ae = mVar;
        this.f27323m = mVar;
        return mVar;
    }

    m(byte[] bArr, int i6, int i7, boolean z5, boolean z6) {
        this.f27322j = bArr;
        this.xt = i6;
        this.cw = i7;
        this.f27324r = z5;
        this.up = z6;
    }
}
