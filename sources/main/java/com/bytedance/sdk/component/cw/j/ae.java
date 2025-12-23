package com.bytedance.sdk.component.cw.j;

import java.io.IOException;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class ae implements w {

    /* renamed from: j, reason: collision with root package name */
    private final w f26082j;

    @Override // com.bytedance.sdk.component.cw.j.w
    public void a_(cw cwVar, long j6) throws IOException {
        this.f26082j.a_(cwVar, j6);
    }

    @Override // com.bytedance.sdk.component.cw.j.w, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f26082j.close();
    }

    @Override // com.bytedance.sdk.component.cw.j.w, java.io.Flushable
    public void flush() throws IOException {
        this.f26082j.flush();
    }

    @Override // com.bytedance.sdk.component.cw.j.w
    public kt j() {
        return this.f26082j.j();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.f26082j.toString() + ")";
    }

    public ae(w wVar) {
        if (wVar != null) {
            this.f26082j = wVar;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }
}
