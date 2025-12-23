package com.bytedance.sdk.component.cw.j;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* loaded from: D:\Downloads\app\classes4.dex */
public final class qv implements mi {
    private int cw;

    /* renamed from: j, reason: collision with root package name */
    private final up f26103j;

    /* renamed from: r, reason: collision with root package name */
    private boolean f26104r;
    private final Inflater xt;

    @Override // com.bytedance.sdk.component.cw.j.mi
    public long j(cw cwVar, long j6) throws IOException {
        boolean xt;
        if (j6 < 0) {
            throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j6)));
        }
        if (this.f26104r) {
            throw new IllegalStateException("closed");
        }
        if (j6 == 0) {
            return 0L;
        }
        do {
            xt = xt();
            try {
                az up = cwVar.up(1);
                int inflate = this.xt.inflate(up.f26084j, up.cw, (int) Math.min(j6, 8192 - up.cw));
                if (inflate > 0) {
                    up.cw += inflate;
                    long j7 = inflate;
                    cwVar.xt += j7;
                    return j7;
                }
                if (!this.xt.finished() && !this.xt.needsDictionary()) {
                }
                cw();
                if (up.xt != up.cw) {
                    return -1L;
                }
                cwVar.f26087j = up.xt();
                av.j(up);
                return -1L;
            } catch (DataFormatException e6) {
                throw new IOException(e6);
            }
        } while (!xt);
        throw new EOFException("source exhausted prematurely");
    }

    private void cw() throws IOException {
        int i6 = this.cw;
        if (i6 == 0) {
            return;
        }
        int remaining = i6 - this.xt.getRemaining();
        this.cw -= remaining;
        this.f26103j.tl(remaining);
    }

    @Override // com.bytedance.sdk.component.cw.j.mi, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f26104r) {
            return;
        }
        this.xt.end();
        this.f26104r = true;
        this.f26103j.close();
    }

    public final boolean xt() throws IOException {
        if (!this.xt.needsInput()) {
            return false;
        }
        cw();
        if (this.xt.getRemaining() != 0) {
            throw new IllegalStateException("?");
        }
        if (this.f26103j.up()) {
            return true;
        }
        az azVar = this.f26103j.cw().f26087j;
        int i6 = azVar.cw;
        int i7 = azVar.xt;
        int i8 = i6 - i7;
        this.cw = i8;
        this.xt.setInput(azVar.f26084j, i7, i8);
        return false;
    }

    qv(up upVar, Inflater inflater) {
        if (upVar != null) {
            if (inflater != null) {
                this.f26103j = upVar;
                this.xt = inflater;
                return;
            }
            throw new IllegalArgumentException("inflater == null");
        }
        throw new IllegalArgumentException("source == null");
    }

    @Override // com.bytedance.sdk.component.cw.j.mi
    public kt j() {
        return this.f26103j.j();
    }
}
