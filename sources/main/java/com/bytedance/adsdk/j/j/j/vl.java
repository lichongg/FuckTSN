package com.bytedance.adsdk.j.j.j;

import java.io.IOException;

/* loaded from: D:\Downloads\app\classes3.dex */
class vl extends up {

    /* renamed from: j, reason: collision with root package name */
    static final int f23166j = up.j("IHDR");
    int cw;
    byte[] tl = new byte[5];
    int xt;

    vl() {
    }

    @Override // com.bytedance.adsdk.j.j.j.up
    void j(com.bytedance.adsdk.j.j.xt.j jVar) throws IOException {
        this.xt = jVar.xt();
        this.cw = jVar.xt();
        byte[] bArr = this.tl;
        jVar.j(bArr, 0, bArr.length);
    }
}
