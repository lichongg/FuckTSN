package com.bytedance.sdk.component.cw.j;

import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: D:\Downloads\app\classes4.dex */
final class jy implements r {
    boolean cw;

    /* renamed from: j, reason: collision with root package name */
    public final cw f26096j = new cw();
    public final w xt;

    @Override // com.bytedance.sdk.component.cw.j.r, com.bytedance.sdk.component.cw.j.up
    public cw cw() {
        return this.f26096j;
    }

    @Override // com.bytedance.sdk.component.cw.j.r
    public r xt(m mVar) throws IOException {
        if (this.cw) {
            throw new IllegalStateException("closed");
        }
        this.f26096j.xt(mVar);
        return tj();
    }

    @Override // com.bytedance.sdk.component.cw.j.w
    public void a_(cw cwVar, long j6) throws IOException {
        if (this.cw) {
            throw new IllegalStateException("closed");
        }
        this.f26096j.a_(cwVar, j6);
        tj();
    }

    @Override // com.bytedance.sdk.component.cw.j.r
    public r ae(int i6) throws IOException {
        if (this.cw) {
            throw new IllegalStateException("closed");
        }
        this.f26096j.ae(i6);
        return tj();
    }

    @Override // com.bytedance.sdk.component.cw.j.w, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.cw) {
            return;
        }
        try {
            cw cwVar = this.f26096j;
            long j6 = cwVar.xt;
            if (j6 > 0) {
                this.xt.a_(cwVar, j6);
            }
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            this.xt.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        this.cw = true;
        if (th != null) {
            tj.j(th);
        }
    }

    @Override // com.bytedance.sdk.component.cw.j.r
    public r cw(byte[] bArr) throws IOException {
        if (this.cw) {
            throw new IllegalStateException("closed");
        }
        this.f26096j.cw(bArr);
        return tj();
    }

    @Override // com.bytedance.sdk.component.cw.j.r, com.bytedance.sdk.component.cw.j.w, java.io.Flushable
    public void flush() throws IOException {
        if (this.cw) {
            throw new IllegalStateException("closed");
        }
        cw cwVar = this.f26096j;
        long j6 = cwVar.xt;
        if (j6 > 0) {
            this.xt.a_(cwVar, j6);
        }
        this.xt.flush();
    }

    @Override // com.bytedance.sdk.component.cw.j.r
    public r g(int i6) throws IOException {
        if (this.cw) {
            throw new IllegalStateException("closed");
        }
        this.f26096j.g(i6);
        return tj();
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.cw;
    }

    @Override // com.bytedance.sdk.component.cw.j.w
    public kt j() {
        return this.xt.j();
    }

    @Override // com.bytedance.sdk.component.cw.j.r
    public r qv(long j6) throws IOException {
        if (this.cw) {
            throw new IllegalStateException("closed");
        }
        this.f26096j.qv(j6);
        return tj();
    }

    @Override // com.bytedance.sdk.component.cw.j.r
    public r tj() throws IOException {
        if (this.cw) {
            throw new IllegalStateException("closed");
        }
        long ae = this.f26096j.ae();
        if (ae > 0) {
            this.xt.a_(this.f26096j, ae);
        }
        return this;
    }

    @Override // com.bytedance.sdk.component.cw.j.r
    public r tl(int i6) throws IOException {
        if (this.cw) {
            throw new IllegalStateException("closed");
        }
        this.f26096j.tl(i6);
        return tj();
    }

    public String toString() {
        return "buffer(" + this.xt + ")";
    }

    @Override // com.bytedance.sdk.component.cw.j.r
    public r vl(long j6) throws IOException {
        if (this.cw) {
            throw new IllegalStateException("closed");
        }
        this.f26096j.vl(j6);
        return tj();
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (this.cw) {
            throw new IllegalStateException("closed");
        }
        int write = this.f26096j.write(byteBuffer);
        tj();
        return write;
    }

    jy(w wVar) {
        if (wVar != null) {
            this.xt = wVar;
            return;
        }
        throw new NullPointerException("sink == null");
    }

    @Override // com.bytedance.sdk.component.cw.j.r
    public r xt(String str) throws IOException {
        if (!this.cw) {
            this.f26096j.xt(str);
            return tj();
        }
        throw new IllegalStateException("closed");
    }

    @Override // com.bytedance.sdk.component.cw.j.r
    public r cw(byte[] bArr, int i6, int i7) throws IOException {
        if (!this.cw) {
            this.f26096j.cw(bArr, i6, i7);
            return tj();
        }
        throw new IllegalStateException("closed");
    }
}
