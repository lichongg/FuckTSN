package com.bytedance.sdk.component.xt.j.j.j;

import com.bytedance.sdk.component.cw.xt.p;
import com.bytedance.sdk.component.xt.j.av;
import com.bytedance.sdk.component.xt.j.i;
import com.bytedance.sdk.component.xt.j.jy;
import com.bytedance.sdk.component.xt.j.qv;

/* loaded from: D:\Downloads\app\classes4.dex */
public class g extends av {

    /* renamed from: j, reason: collision with root package name */
    public p f27275j;

    @Override // com.bytedance.sdk.component.xt.j.av
    public long j() {
        return this.f27275j.ws();
    }

    @Override // com.bytedance.sdk.component.xt.j.av
    public com.bytedance.sdk.component.xt.j.m ae() {
        return new com.bytedance.sdk.component.xt.j.m(this.f27275j.ae().f26409j);
    }

    @Override // com.bytedance.sdk.component.xt.j.av, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f27275j.close();
    }

    @Override // com.bytedance.sdk.component.xt.j.av
    public int cw() {
        p pVar = this.f27275j;
        if (pVar != null) {
            return pVar.cw();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.component.xt.j.av
    public qv g() {
        p pVar = this.f27275j;
        if (pVar == null) {
            return null;
        }
        return new qv(pVar.az());
    }

    @Override // com.bytedance.sdk.component.xt.j.av
    public String j(String str) {
        return this.f27275j.j(str);
    }

    @Override // com.bytedance.sdk.component.xt.j.av
    public i m() {
        return new oq(this.f27275j.tl());
    }

    @Override // com.bytedance.sdk.component.xt.j.av
    public boolean r() {
        return this.f27275j.r();
    }

    @Override // com.bytedance.sdk.component.xt.j.av
    public jy tl() {
        try {
            return jy.j(this.f27275j.xt().toString());
        } catch (Exception unused) {
            return jy.HTTP_1_1;
        }
    }

    public String toString() {
        return this.f27275j.toString();
    }

    @Override // com.bytedance.sdk.component.xt.j.av
    public String up() {
        return this.f27275j.up();
    }

    @Override // com.bytedance.sdk.component.xt.j.av
    public long xt() {
        return this.f27275j.jy();
    }

    public g(p pVar) {
        this.f27275j = pVar;
    }

    @Override // com.bytedance.sdk.component.xt.j.av
    public String j(String str, String str2) {
        return this.f27275j.j(str, str2);
    }
}
