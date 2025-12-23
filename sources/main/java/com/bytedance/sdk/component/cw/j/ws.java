package com.bytedance.sdk.component.cw.j;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import kotlin.text.v0;

/* loaded from: D:\Downloads\app\classes4.dex */
final class ws implements up {
    boolean cw;

    /* renamed from: j, reason: collision with root package name */
    public final cw f26110j = new cw();
    public final mi xt;

    @Override // com.bytedance.sdk.component.cw.j.up
    public cw cw() {
        return this.f26110j;
    }

    @Override // com.bytedance.sdk.component.cw.j.mi
    public long j(cw cwVar, long j6) throws IOException {
        if (cwVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        if (j6 < 0) {
            throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j6)));
        }
        if (this.cw) {
            throw new IllegalStateException("closed");
        }
        cw cwVar2 = this.f26110j;
        if (cwVar2.xt == 0 && this.xt.j(cwVar2, 8192L) == -1) {
            return -1L;
        }
        return this.f26110j.j(cwVar, Math.min(j6, this.f26110j.xt));
    }

    @Override // com.bytedance.sdk.component.cw.j.up
    public byte tl() throws IOException {
        j(1L);
        return this.f26110j.tl();
    }

    @Override // com.bytedance.sdk.component.cw.j.up
    public boolean up() throws IOException {
        if (this.cw) {
            throw new IllegalStateException("closed");
        }
        return this.f26110j.up() && this.xt.j(this.f26110j, 8192L) == -1;
    }

    @Override // com.bytedance.sdk.component.cw.j.mi, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.cw) {
            return;
        }
        this.cw = true;
        this.xt.close();
        this.f26110j.w();
    }

    @Override // com.bytedance.sdk.component.cw.j.up
    public m cw(long j6) throws IOException {
        j(j6);
        return this.f26110j.cw(j6);
    }

    @Override // com.bytedance.sdk.component.cw.j.up
    public short g() throws IOException {
        j(2L);
        return this.f26110j.g();
    }

    @Override // com.bytedance.sdk.component.cw.j.up
    public byte[] i() throws IOException {
        this.f26110j.j(this.xt);
        return this.f26110j.i();
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.cw;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0032, code lost:
    
        if (r1 == 0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0049, code lost:
    
        throw new java.lang.NumberFormatException(java.lang.String.format("Expected leading [0-9a-fA-F] character but was %#x", java.lang.Byte.valueOf(r3)));
     */
    @Override // com.bytedance.sdk.component.cw.j.up
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long jy() throws java.io.IOException {
        /*
            r6 = this;
            r0 = 1
            r6.j(r0)
            r0 = 0
            r1 = 0
        L7:
            int r2 = r1 + 1
            long r3 = (long) r2
            boolean r3 = r6.xt(r3)
            if (r3 == 0) goto L4a
            com.bytedance.sdk.component.cw.j.cw r3 = r6.f26110j
            long r4 = (long) r1
            byte r3 = r3.xt(r4)
            r4 = 48
            if (r3 < r4) goto L1f
            r4 = 57
            if (r3 <= r4) goto L30
        L1f:
            r4 = 97
            if (r3 < r4) goto L27
            r4 = 102(0x66, float:1.43E-43)
            if (r3 <= r4) goto L30
        L27:
            r4 = 65
            if (r3 < r4) goto L32
            r4 = 70
            if (r3 <= r4) goto L30
            goto L32
        L30:
            r1 = r2
            goto L7
        L32:
            if (r1 == 0) goto L35
            goto L4a
        L35:
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.Byte r2 = java.lang.Byte.valueOf(r3)
            r3 = 1
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r3[r0] = r2
            java.lang.String r0 = "Expected leading [0-9a-fA-F] character but was %#x"
            java.lang.String r0 = java.lang.String.format(r0, r3)
            r1.<init>(r0)
            throw r1
        L4a:
            com.bytedance.sdk.component.cw.j.cw r0 = r6.f26110j
            long r0 = r0.jy()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.cw.j.ws.jy():long");
    }

    @Override // com.bytedance.sdk.component.cw.j.up
    public InputStream m() {
        return new InputStream() { // from class: com.bytedance.sdk.component.cw.j.ws.1
            @Override // java.io.InputStream
            public int read() throws IOException {
                ws wsVar = ws.this;
                if (wsVar.cw) {
                    throw new IOException("closed");
                }
                cw cwVar = wsVar.f26110j;
                if (cwVar.xt == 0 && wsVar.xt.j(cwVar, 8192L) == -1) {
                    return -1;
                }
                return ws.this.f26110j.tl() & 255;
            }

            @Override // java.io.InputStream
            public int available() throws IOException {
                ws wsVar = ws.this;
                if (wsVar.cw) {
                    throw new IOException("closed");
                }
                return (int) Math.min(wsVar.f26110j.xt, 2147483647L);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                ws.this.close();
            }

            public String toString() {
                return ws.this + ".inputStream()";
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i6, int i7) throws IOException {
                if (!ws.this.cw) {
                    tj.j(bArr.length, i6, i7);
                    ws wsVar = ws.this;
                    cw cwVar = wsVar.f26110j;
                    if (cwVar.xt == 0 && wsVar.xt.j(cwVar, 8192L) == -1) {
                        return -1;
                    }
                    return ws.this.f26110j.j(bArr, i6, i7);
                }
                throw new IOException("closed");
            }
        };
    }

    @Override // com.bytedance.sdk.component.cw.j.up
    public int oq() throws IOException {
        j(4L);
        return this.f26110j.oq();
    }

    @Override // com.bytedance.sdk.component.cw.j.up
    public short qv() throws IOException {
        j(2L);
        return this.f26110j.qv();
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        cw cwVar = this.f26110j;
        if (cwVar.xt == 0 && this.xt.j(cwVar, 8192L) == -1) {
            return -1;
        }
        return this.f26110j.read(byteBuffer);
    }

    public String toString() {
        return "buffer(" + this.xt + ")";
    }

    @Override // com.bytedance.sdk.component.cw.j.up
    public int vl() throws IOException {
        j(4L);
        return this.f26110j.vl();
    }

    public boolean xt(long j6) throws IOException {
        cw cwVar;
        if (j6 < 0) {
            throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j6)));
        }
        if (this.cw) {
            throw new IllegalStateException("closed");
        }
        do {
            cwVar = this.f26110j;
            if (cwVar.xt >= j6) {
                return true;
            }
        } while (this.xt.j(cwVar, 8192L) != -1);
        return false;
    }

    ws(mi miVar) {
        if (miVar != null) {
            this.xt = miVar;
            return;
        }
        throw new NullPointerException("source == null");
    }

    @Override // com.bytedance.sdk.component.cw.j.up
    public byte[] ae(long j6) throws IOException {
        j(j6);
        return this.f26110j.ae(j6);
    }

    @Override // com.bytedance.sdk.component.cw.j.up
    public void tl(long j6) throws IOException {
        if (this.cw) {
            throw new IllegalStateException("closed");
        }
        while (j6 > 0) {
            cw cwVar = this.f26110j;
            if (cwVar.xt == 0 && this.xt.j(cwVar, 8192L) == -1) {
                throw new EOFException();
            }
            long min = Math.min(j6, this.f26110j.xt());
            this.f26110j.tl(min);
            j6 -= min;
        }
    }

    @Override // com.bytedance.sdk.component.cw.j.up
    public String up(long j6) throws IOException {
        if (j6 >= 0) {
            long j7 = j6 == Long.MAX_VALUE ? Long.MAX_VALUE : j6 + 1;
            long j8 = j((byte) 10, 0L, j7);
            if (j8 != -1) {
                return this.f26110j.m(j8);
            }
            if (j7 < Long.MAX_VALUE && xt(j7) && this.f26110j.xt(j7 - 1) == 13 && xt(1 + j7) && this.f26110j.xt(j7) == 10) {
                return this.f26110j.m(j7);
            }
            cw cwVar = new cw();
            cw cwVar2 = this.f26110j;
            cwVar2.j(cwVar, 0L, Math.min(32L, cwVar2.xt()));
            throw new EOFException("\\n not found: limit=" + Math.min(this.f26110j.xt(), j6) + " content=" + cwVar.ws().up() + v0.F);
        }
        throw new IllegalArgumentException("limit < 0: ".concat(String.valueOf(j6)));
    }

    @Override // com.bytedance.sdk.component.cw.j.up
    public String av() throws IOException {
        return up(Long.MAX_VALUE);
    }

    @Override // com.bytedance.sdk.component.cw.j.up
    public void j(long j6) throws IOException {
        if (!xt(j6)) {
            throw new EOFException();
        }
    }

    @Override // com.bytedance.sdk.component.cw.j.up
    public void j(byte[] bArr) throws IOException {
        try {
            j(bArr.length);
            this.f26110j.j(bArr);
        } catch (EOFException e6) {
            int i6 = 0;
            while (true) {
                cw cwVar = this.f26110j;
                long j6 = cwVar.xt;
                if (j6 > 0) {
                    int j7 = cwVar.j(bArr, i6, (int) j6);
                    if (j7 == -1) {
                        throw new AssertionError();
                    }
                    i6 += j7;
                } else {
                    throw e6;
                }
            }
        }
    }

    @Override // com.bytedance.sdk.component.cw.j.up
    public String j(Charset charset) throws IOException {
        if (charset != null) {
            this.f26110j.j(this.xt);
            return this.f26110j.j(charset);
        }
        throw new IllegalArgumentException("charset == null");
    }

    @Override // com.bytedance.sdk.component.cw.j.up
    public long j(byte b6) throws IOException {
        return j(b6, 0L, Long.MAX_VALUE);
    }

    public long j(byte b6, long j6, long j7) throws IOException {
        if (this.cw) {
            throw new IllegalStateException("closed");
        }
        if (j6 < 0 || j7 < j6) {
            throw new IllegalArgumentException(String.format("fromIndex=%s toIndex=%s", Long.valueOf(j6), Long.valueOf(j7)));
        }
        long j8 = j6;
        while (j8 < j7) {
            byte b7 = b6;
            long j9 = j7;
            long j10 = this.f26110j.j(b7, j8, j9);
            if (j10 == -1) {
                cw cwVar = this.f26110j;
                long j11 = cwVar.xt;
                if (j11 >= j9 || this.xt.j(cwVar, 8192L) == -1) {
                    break;
                }
                j8 = Math.max(j8, j11);
                b6 = b7;
                j7 = j9;
            } else {
                return j10;
            }
        }
        return -1L;
    }

    @Override // com.bytedance.sdk.component.cw.j.up
    public boolean j(long j6, m mVar) throws IOException {
        return j(j6, mVar, 0, mVar.ae());
    }

    public boolean j(long j6, m mVar, int i6, int i7) throws IOException {
        if (!this.cw) {
            if (j6 < 0 || i6 < 0 || i7 < 0 || mVar.ae() - i6 < i7) {
                return false;
            }
            for (int i8 = 0; i8 < i7; i8++) {
                long j7 = i8 + j6;
                if (!xt(1 + j7) || this.f26110j.xt(j7) != mVar.j(i6 + i8)) {
                    return false;
                }
            }
            return true;
        }
        throw new IllegalStateException("closed");
    }

    @Override // com.bytedance.sdk.component.cw.j.mi
    public kt j() {
        return this.xt.j();
    }
}
