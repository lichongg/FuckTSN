package com.bytedance.sdk.component.xt.j.j.j;

import com.bytedance.sdk.component.cw.xt.h;
import com.bytedance.sdk.component.cw.xt.tj;
import com.bytedance.sdk.component.xt.j.i;
import java.io.InputStream;

/* loaded from: D:\Downloads\app\classes4.dex */
public class oq extends i {

    /* renamed from: j, reason: collision with root package name */
    h f27276j;

    @Override // com.bytedance.sdk.component.xt.j.i, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        h hVar = this.f27276j;
        if (hVar != null) {
            hVar.close();
        }
    }

    @Override // com.bytedance.sdk.component.xt.j.i
    public InputStream cw() {
        h hVar = this.f27276j;
        if (hVar != null) {
            return hVar.r();
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.xt.j.i
    public long j() {
        h hVar = this.f27276j;
        if (hVar != null) {
            return hVar.xt();
        }
        return -1L;
    }

    @Override // com.bytedance.sdk.component.xt.j.i
    public byte[] r() {
        try {
            return this.f27276j.up();
        } catch (Exception unused) {
            return new byte[0];
        }
    }

    @Override // com.bytedance.sdk.component.xt.j.i
    public com.bytedance.sdk.component.xt.j.oq up() {
        tj j6;
        h hVar = this.f27276j;
        if (hVar == null || (j6 = hVar.j()) == null) {
            return null;
        }
        return new com.bytedance.sdk.component.xt.j.oq(j6.toString(), j6.j(), j6.xt(), j6.cw() != null ? j6.cw().name() : null);
    }

    @Override // com.bytedance.sdk.component.xt.j.i
    public String xt() {
        try {
            return this.f27276j.m();
        } catch (Exception unused) {
            return "";
        }
    }

    oq(h hVar) {
        this.f27276j = hVar;
    }
}
