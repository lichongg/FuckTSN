package com.bytedance.sdk.component.cw.j;

import java.io.IOException;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class tl implements mi {

    /* renamed from: j, reason: collision with root package name */
    private final mi f26106j;

    @Override // com.bytedance.sdk.component.cw.j.mi
    public long j(cw cwVar, long j6) throws IOException {
        return this.f26106j.j(cwVar, j6);
    }

    @Override // com.bytedance.sdk.component.cw.j.mi, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f26106j.close();
    }

    @Override // com.bytedance.sdk.component.cw.j.mi
    public kt j() {
        return this.f26106j.j();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.f26106j.toString() + ")";
    }

    public final mi xt() {
        return this.f26106j;
    }

    public tl(mi miVar) {
        if (miVar != null) {
            this.f26106j = miVar;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }
}
