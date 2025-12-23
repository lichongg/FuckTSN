package com.bytedance.sdk.component.cw.xt.j.j;

import com.bytedance.sdk.component.cw.j.ae;
import com.bytedance.sdk.component.cw.j.w;
import java.io.IOException;

/* loaded from: D:\Downloads\app\classes4.dex */
class up extends ae {

    /* renamed from: j, reason: collision with root package name */
    private boolean f26212j;

    @Override // com.bytedance.sdk.component.cw.j.ae, com.bytedance.sdk.component.cw.j.w
    public void a_(com.bytedance.sdk.component.cw.j.cw cwVar, long j6) throws IOException {
        if (this.f26212j) {
            cwVar.tl(j6);
            return;
        }
        try {
            super.a_(cwVar, j6);
        } catch (IOException e6) {
            this.f26212j = true;
            j(e6);
        }
    }

    @Override // com.bytedance.sdk.component.cw.j.ae, com.bytedance.sdk.component.cw.j.w, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f26212j) {
            return;
        }
        try {
            super.close();
        } catch (IOException e6) {
            this.f26212j = true;
            j(e6);
        }
    }

    @Override // com.bytedance.sdk.component.cw.j.ae, com.bytedance.sdk.component.cw.j.w, java.io.Flushable
    public void flush() throws IOException {
        if (this.f26212j) {
            return;
        }
        try {
            super.flush();
        } catch (IOException e6) {
            this.f26212j = true;
            j(e6);
        }
    }

    up(w wVar) {
        super(wVar);
    }

    protected void j(IOException iOException) {
    }
}
