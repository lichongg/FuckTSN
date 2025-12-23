package com.bytedance.sdk.component.cw.j;

import com.bykv.vk.component.ttvideo.player.C;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import kotlin.text.v0;
import okhttp3.internal.connection.RealConnection;

/* loaded from: D:\Downloads\app\classes4.dex */
public final class cw implements r, up, Cloneable, ByteChannel {
    private static final byte[] cw = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};

    /* renamed from: j, reason: collision with root package name */
    az f26087j;
    long xt;

    @Override // com.bytedance.sdk.component.cw.j.r, com.bytedance.sdk.component.cw.j.up
    public cw cw() {
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof cw)) {
            return false;
        }
        cw cwVar = (cw) obj;
        long j6 = this.xt;
        if (j6 != cwVar.xt) {
            return false;
        }
        long j7 = 0;
        if (j6 == 0) {
            return true;
        }
        az azVar = this.f26087j;
        az azVar2 = cwVar.f26087j;
        int i6 = azVar.xt;
        int i7 = azVar2.xt;
        while (j7 < this.xt) {
            long min = Math.min(azVar.cw - i6, azVar2.cw - i7);
            int i8 = 0;
            while (i8 < min) {
                int i9 = i6 + 1;
                int i10 = i7 + 1;
                if (azVar.f26084j[i6] != azVar2.f26084j[i7]) {
                    return false;
                }
                i8++;
                i6 = i9;
                i7 = i10;
            }
            if (i6 == azVar.cw) {
                azVar = azVar.f26085m;
                i6 = azVar.xt;
            }
            if (i7 == azVar2.cw) {
                azVar2 = azVar2.f26085m;
                i7 = azVar2.xt;
            }
            j7 += min;
        }
        return true;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    @Override // com.bytedance.sdk.component.cw.j.up
    public void j(long j6) throws EOFException {
        if (this.xt < j6) {
            throw new EOFException();
        }
    }

    @Override // com.bytedance.sdk.component.cw.j.up
    public InputStream m() {
        return new InputStream() { // from class: com.bytedance.sdk.component.cw.j.cw.1
            @Override // java.io.InputStream
            public int read() {
                cw cwVar = cw.this;
                if (cwVar.xt > 0) {
                    return cwVar.tl() & 255;
                }
                return -1;
            }

            @Override // java.io.InputStream
            public int available() {
                return (int) Math.min(cw.this.xt, 2147483647L);
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i6, int i7) {
                return cw.this.j(bArr, i6, i7);
            }

            public String toString() {
                return cw.this + ".inputStream()";
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }
        };
    }

    @Override // com.bytedance.sdk.component.cw.j.up
    public int oq() {
        long j6 = this.xt;
        if (j6 < 4) {
            throw new IllegalStateException("size < 4: " + this.xt);
        }
        az azVar = this.f26087j;
        int i6 = azVar.xt;
        int i7 = azVar.cw;
        if (i7 - i6 < 4) {
            return ((tl() & 255) << 24) | ((tl() & 255) << 16) | ((tl() & 255) << 8) | (tl() & 255);
        }
        byte[] bArr = azVar.f26084j;
        int i8 = i6 + 3;
        int i9 = ((bArr[i6 + 1] & 255) << 16) | ((bArr[i6] & 255) << 24) | ((bArr[i6 + 2] & 255) << 8);
        int i10 = i6 + 4;
        int i11 = (bArr[i8] & 255) | i9;
        this.xt = j6 - 4;
        if (i10 != i7) {
            azVar.xt = i10;
            return i11;
        }
        this.f26087j = azVar.xt();
        av.j(azVar);
        return i11;
    }

    @Override // com.bytedance.sdk.component.cw.j.r
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public cw tj() {
        return this;
    }

    @Override // com.bytedance.sdk.component.cw.j.up
    public boolean up() {
        return this.xt == 0;
    }

    @Override // com.bytedance.sdk.component.cw.j.w
    public void a_(cw cwVar, long j6) {
        az azVar;
        if (cwVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (cwVar == this) {
            throw new IllegalArgumentException("source == this");
        }
        tj.j(cwVar.xt, 0L, j6);
        while (j6 > 0 && (azVar = cwVar.f26087j) != null) {
            if (j6 < azVar.cw - azVar.xt) {
                az azVar2 = this.f26087j;
                az azVar3 = azVar2 != null ? azVar2.ae : null;
                if (azVar3 != null && azVar3.up) {
                    if ((azVar3.cw + j6) - (azVar3.f26086r ? 0 : azVar3.xt) <= 8192) {
                        azVar.j(azVar3, (int) j6);
                        cwVar.xt -= j6;
                        this.xt += j6;
                        return;
                    }
                }
                cwVar.f26087j = azVar.j((int) j6);
            }
            az azVar4 = cwVar.f26087j;
            long j7 = azVar4.cw - azVar4.xt;
            cwVar.f26087j = azVar4.xt();
            az azVar5 = this.f26087j;
            if (azVar5 == null) {
                this.f26087j = azVar4;
                azVar4.ae = azVar4;
                azVar4.f26085m = azVar4;
            } else {
                azVar5.ae.j(azVar4).cw();
            }
            cwVar.xt -= j7;
            this.xt += j7;
            j6 -= j7;
        }
    }

    public final long ae() {
        long j6 = this.xt;
        if (j6 == 0) {
            return 0L;
        }
        az azVar = this.f26087j.ae;
        return (azVar.cw >= 8192 || !azVar.up) ? j6 : j6 - (r3 - azVar.xt);
    }

    public String az() {
        try {
            return j(this.xt, tj.f26105j);
        } catch (EOFException e6) {
            throw new AssertionError(e6);
        }
    }

    @Override // com.bytedance.sdk.component.cw.j.up
    public short g() {
        long j6 = this.xt;
        if (j6 < 2) {
            throw new IllegalStateException("size < 2: " + this.xt);
        }
        az azVar = this.f26087j;
        int i6 = azVar.xt;
        int i7 = azVar.cw;
        if (i7 - i6 < 2) {
            return (short) (((tl() & 255) << 8) | (tl() & 255));
        }
        byte[] bArr = azVar.f26084j;
        int i8 = i6 + 1;
        int i9 = (bArr[i6] & 255) << 8;
        int i10 = i6 + 2;
        int i11 = (bArr[i8] & 255) | i9;
        this.xt = j6 - 2;
        if (i10 == i7) {
            this.f26087j = azVar.xt();
            av.j(azVar);
        } else {
            azVar.xt = i10;
        }
        return (short) i11;
    }

    public int hashCode() {
        az azVar = this.f26087j;
        if (azVar == null) {
            return 0;
        }
        int i6 = 1;
        do {
            int i7 = azVar.cw;
            for (int i8 = azVar.xt; i8 < i7; i8++) {
                i6 = (i6 * 31) + azVar.f26084j[i8];
            }
            azVar = azVar.f26085m;
        } while (azVar != this.f26087j);
        return i6;
    }

    @Override // com.bytedance.sdk.component.cw.j.up
    public byte[] i() throws EOFException {
        return ae(this.xt);
    }

    public final cw j(cw cwVar, long j6, long j7) {
        if (cwVar == null) {
            throw new IllegalArgumentException("out == null");
        }
        long j8 = j6;
        tj.j(this.xt, j8, j7);
        if (j7 != 0) {
            cwVar.xt += j7;
            az azVar = this.f26087j;
            while (true) {
                int i6 = azVar.cw;
                int i7 = azVar.xt;
                if (j8 < i6 - i7) {
                    break;
                }
                j8 -= i6 - i7;
                azVar = azVar.f26085m;
            }
            az azVar2 = azVar;
            long j9 = j7;
            while (j9 > 0) {
                az j10 = azVar2.j();
                int i8 = (int) (j10.xt + j8);
                j10.xt = i8;
                j10.cw = Math.min(i8 + ((int) j9), j10.cw);
                az azVar3 = cwVar.f26087j;
                if (azVar3 == null) {
                    j10.ae = j10;
                    j10.f26085m = j10;
                    cwVar.f26087j = j10;
                } else {
                    azVar3.ae.j(j10);
                }
                j9 -= j10.cw - j10.xt;
                azVar2 = azVar2.f26085m;
                j8 = 0;
            }
        }
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x009c A[EDGE_INSN: B:40:0x009c->B:37:0x009c BREAK  A[LOOP:0: B:4:0x000b->B:39:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0094  */
    @Override // com.bytedance.sdk.component.cw.j.up
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long jy() {
        /*
            r15 = this;
            long r0 = r15.xt
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto La3
            r0 = 0
            r4 = r2
            r1 = 0
        Lb:
            com.bytedance.sdk.component.cw.j.az r6 = r15.f26087j
            byte[] r7 = r6.f26084j
            int r8 = r6.xt
            int r9 = r6.cw
        L13:
            if (r8 >= r9) goto L88
            r10 = r7[r8]
            r11 = 48
            if (r10 < r11) goto L22
            r11 = 57
            if (r10 > r11) goto L22
            int r11 = r10 + (-48)
            goto L37
        L22:
            r11 = 97
            if (r10 < r11) goto L2d
            r11 = 102(0x66, float:1.43E-43)
            if (r10 > r11) goto L2d
            int r11 = r10 + (-87)
            goto L37
        L2d:
            r11 = 65
            if (r10 < r11) goto L6c
            r11 = 70
            if (r10 > r11) goto L6c
            int r11 = r10 + (-55)
        L37:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r14 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r14 != 0) goto L47
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r0 = r0 + 1
            goto L13
        L47:
            com.bytedance.sdk.component.cw.j.cw r0 = new com.bytedance.sdk.component.cw.j.cw
            r0.<init>()
            com.bytedance.sdk.component.cw.j.cw r0 = r0.qv(r4)
            com.bytedance.sdk.component.cw.j.cw r0 = r0.g(r10)
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Number too large: "
            r2.<init>(r3)
            java.lang.String r0 = r0.az()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L6c:
            if (r0 == 0) goto L70
            r1 = 1
            goto L88
        L70:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Expected leading [0-9a-fA-F] character but was 0x"
            r1.<init>(r2)
            java.lang.String r2 = java.lang.Integer.toHexString(r10)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L88:
            if (r8 != r9) goto L94
            com.bytedance.sdk.component.cw.j.az r7 = r6.xt()
            r15.f26087j = r7
            com.bytedance.sdk.component.cw.j.av.j(r6)
            goto L96
        L94:
            r6.xt = r8
        L96:
            if (r1 != 0) goto L9c
            com.bytedance.sdk.component.cw.j.az r6 = r15.f26087j
            if (r6 != 0) goto Lb
        L9c:
            long r1 = r15.xt
            long r6 = (long) r0
            long r1 = r1 - r6
            r15.xt = r1
            return r4
        La3:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "size == 0"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.cw.j.cw.jy():long");
    }

    public final m kt() {
        long j6 = this.xt;
        if (j6 <= 2147483647L) {
            return m((int) j6);
        }
        throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.xt);
    }

    String m(long j6) throws EOFException {
        if (j6 > 0) {
            long j7 = j6 - 1;
            if (xt(j7) == 13) {
                String r5 = r(j7);
                tl(2L);
                return r5;
            }
        }
        String r6 = r(j6);
        tl(1L);
        return r6;
    }

    /* renamed from: mi, reason: merged with bridge method [inline-methods] */
    public cw clone() {
        cw cwVar = new cw();
        if (this.xt == 0) {
            return cwVar;
        }
        az j6 = this.f26087j.j();
        cwVar.f26087j = j6;
        j6.ae = j6;
        j6.f26085m = j6;
        az azVar = this.f26087j;
        while (true) {
            azVar = azVar.f26085m;
            if (azVar == this.f26087j) {
                cwVar.xt = this.xt;
                return cwVar;
            }
            cwVar.f26087j.ae.j(azVar.j());
        }
    }

    @Override // com.bytedance.sdk.component.cw.j.up
    public short qv() {
        return tj.j(g());
    }

    public String r(long j6) throws EOFException {
        return j(j6, tj.f26105j);
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        az azVar = this.f26087j;
        if (azVar == null) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), azVar.cw - azVar.xt);
        byteBuffer.put(azVar.f26084j, azVar.xt, min);
        int i6 = azVar.xt + min;
        azVar.xt = i6;
        this.xt -= min;
        if (i6 == azVar.cw) {
            this.f26087j = azVar.xt();
            av.j(azVar);
        }
        return min;
    }

    @Override // com.bytedance.sdk.component.cw.j.up
    public byte tl() {
        long j6 = this.xt;
        if (j6 == 0) {
            throw new IllegalStateException("size == 0");
        }
        az azVar = this.f26087j;
        int i6 = azVar.xt;
        int i7 = azVar.cw;
        int i8 = i6 + 1;
        byte b6 = azVar.f26084j[i6];
        this.xt = j6 - 1;
        if (i8 != i7) {
            azVar.xt = i8;
            return b6;
        }
        this.f26087j = azVar.xt();
        av.j(azVar);
        return b6;
    }

    @Override // com.bytedance.sdk.component.cw.j.up
    public String up(long j6) throws EOFException {
        if (j6 < 0) {
            throw new IllegalArgumentException("limit < 0: ".concat(String.valueOf(j6)));
        }
        long j7 = j6 != Long.MAX_VALUE ? j6 + 1 : Long.MAX_VALUE;
        long j8 = j((byte) 10, 0L, j7);
        if (j8 != -1) {
            return m(j8);
        }
        if (j7 < xt() && xt(j7 - 1) == 13 && xt(j7) == 10) {
            return m(j7);
        }
        cw cwVar = new cw();
        j(cwVar, 0L, Math.min(32L, xt()));
        throw new EOFException("\\n not found: limit=" + Math.min(xt(), j6) + " content=" + cwVar.ws().up() + v0.F);
    }

    @Override // com.bytedance.sdk.component.cw.j.up
    public int vl() {
        return tj.j(oq());
    }

    public final void w() {
        try {
            tl(this.xt);
        } catch (EOFException e6) {
            throw new AssertionError(e6);
        }
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("source == null");
        }
        int remaining = byteBuffer.remaining();
        int i6 = remaining;
        while (i6 > 0) {
            az up = up(1);
            int min = Math.min(i6, 8192 - up.cw);
            byteBuffer.get(up.f26084j, up.cw, min);
            i6 -= min;
            up.cw += min;
        }
        this.xt += remaining;
        return remaining;
    }

    public m ws() throws EOFException {
        return new m(i());
    }

    @Override // com.bytedance.sdk.component.cw.j.r
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public cw ae(int i6) {
        az up = up(4);
        byte[] bArr = up.f26084j;
        int i7 = up.cw;
        bArr[i7] = (byte) ((i6 >>> 24) & 255);
        bArr[i7 + 1] = (byte) ((i6 >>> 16) & 255);
        bArr[i7 + 2] = (byte) ((i6 >>> 8) & 255);
        bArr[i7 + 3] = (byte) (i6 & 255);
        up.cw = i7 + 4;
        this.xt += 4;
        return this;
    }

    public String toString() {
        return kt().toString();
    }

    public final long xt() {
        return this.xt;
    }

    @Override // com.bytedance.sdk.component.cw.j.up
    public m cw(long j6) throws EOFException {
        return new m(ae(j6));
    }

    public final byte xt(long j6) {
        int i6;
        long j7 = j6;
        tj.j(this.xt, j7, 1L);
        long j8 = this.xt;
        if (j8 - j7 > j7) {
            az azVar = this.f26087j;
            while (true) {
                int i7 = azVar.cw;
                int i8 = azVar.xt;
                long j9 = i7 - i8;
                if (j7 < j9) {
                    return azVar.f26084j[i8 + ((int) j7)];
                }
                j7 -= j9;
                azVar = azVar.f26085m;
            }
        } else {
            long j10 = j7 - j8;
            try {
                az azVar2 = this.f26087j;
                do {
                    azVar2 = azVar2.ae;
                    int i9 = azVar2.cw;
                    i6 = azVar2.xt;
                    j10 += i9 - i6;
                } while (j10 < 0);
                return azVar2.f26084j[i6 + ((int) j10)];
            } catch (NullPointerException unused) {
                return (byte) 0;
            }
        }
    }

    @Override // com.bytedance.sdk.component.cw.j.up
    public String av() throws EOFException {
        return up(Long.MAX_VALUE);
    }

    @Override // com.bytedance.sdk.component.cw.j.r
    /* renamed from: cw, reason: merged with bridge method [inline-methods] */
    public cw tl(int i6) {
        az up = up(2);
        byte[] bArr = up.f26084j;
        int i7 = up.cw;
        bArr[i7] = (byte) ((i6 >>> 8) & 255);
        bArr[i7 + 1] = (byte) (i6 & 255);
        up.cw = i7 + 2;
        this.xt += 2;
        return this;
    }

    @Override // com.bytedance.sdk.component.cw.j.up
    public byte[] ae(long j6) throws EOFException {
        tj.j(this.xt, 0L, j6);
        if (j6 <= 2147483647L) {
            byte[] bArr = new byte[(int) j6];
            j(bArr);
            return bArr;
        }
        throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: ".concat(String.valueOf(j6)));
    }

    public final m m(int i6) {
        if (i6 == 0) {
            return m.xt;
        }
        return new i(this, i6);
    }

    az up(int i6) {
        if (i6 > 0 && i6 <= 8192) {
            az azVar = this.f26087j;
            if (azVar == null) {
                az j6 = av.j();
                this.f26087j = j6;
                j6.ae = j6;
                j6.f26085m = j6;
                return j6;
            }
            az azVar2 = azVar.ae;
            return (azVar2.cw + i6 > 8192 || !azVar2.up) ? azVar2.j(av.j()) : azVar2;
        }
        throw new IllegalArgumentException();
    }

    @Override // com.bytedance.sdk.component.cw.j.up
    public void tl(long j6) throws EOFException {
        az azVar;
        while (j6 > 0 && (azVar = this.f26087j) != null) {
            int min = (int) Math.min(j6, azVar.cw - azVar.xt);
            long j7 = min;
            this.xt -= j7;
            j6 -= j7;
            az azVar2 = this.f26087j;
            int i6 = azVar2.xt + min;
            azVar2.xt = i6;
            if (i6 == azVar2.cw) {
                this.f26087j = azVar2.xt();
                av.j(azVar2);
            }
        }
    }

    @Override // com.bytedance.sdk.component.cw.j.r
    /* renamed from: xt, reason: merged with bridge method [inline-methods] */
    public cw cw(byte[] bArr) {
        if (bArr != null) {
            return cw(bArr, 0, bArr.length);
        }
        throw new IllegalArgumentException("source == null");
    }

    @Override // com.bytedance.sdk.component.cw.j.r
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public cw vl(long j6) {
        boolean z5;
        if (j6 == 0) {
            return g(48);
        }
        int i6 = 1;
        if (j6 < 0) {
            j6 = -j6;
            if (j6 < 0) {
                return xt("-9223372036854775808");
            }
            z5 = true;
        } else {
            z5 = false;
        }
        if (j6 >= 100000000) {
            i6 = j6 < 1000000000000L ? j6 < RealConnection.IDLE_CONNECTION_HEALTHY_NS ? j6 < C.NANOS_PER_SECOND ? 9 : 10 : j6 < 100000000000L ? 11 : 12 : j6 < 1000000000000000L ? j6 < 10000000000000L ? 13 : j6 < 100000000000000L ? 14 : 15 : j6 < 100000000000000000L ? j6 < 10000000000000000L ? 16 : 17 : j6 < 1000000000000000000L ? 18 : 19;
        } else if (j6 >= 10000) {
            i6 = j6 < C.MICROS_PER_SECOND ? j6 < 100000 ? 5 : 6 : j6 < 10000000 ? 7 : 8;
        } else if (j6 >= 100) {
            i6 = j6 < 1000 ? 3 : 4;
        } else if (j6 >= 10) {
            i6 = 2;
        }
        if (z5) {
            i6++;
        }
        az up = up(i6);
        byte[] bArr = up.f26084j;
        int i7 = up.cw + i6;
        while (j6 != 0) {
            i7--;
            bArr[i7] = cw[(int) (j6 % 10)];
            j6 /= 10;
        }
        if (z5) {
            bArr[i7 - 1] = 45;
        }
        up.cw += i6;
        this.xt += i6;
        return this;
    }

    @Override // com.bytedance.sdk.component.cw.j.up
    public String j(Charset charset) {
        try {
            return j(this.xt, charset);
        } catch (EOFException e6) {
            throw new AssertionError(e6);
        }
    }

    @Override // com.bytedance.sdk.component.cw.j.r
    /* renamed from: xt, reason: merged with bridge method [inline-methods] */
    public cw cw(byte[] bArr, int i6, int i7) {
        if (bArr != null) {
            long j6 = i7;
            tj.j(bArr.length, i6, j6);
            int i8 = i7 + i6;
            while (i6 < i8) {
                az up = up(1);
                int min = Math.min(i8 - i6, 8192 - up.cw);
                System.arraycopy(bArr, i6, up.f26084j, up.cw, min);
                i6 += min;
                up.cw += min;
            }
            this.xt += j6;
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    @Override // com.bytedance.sdk.component.cw.j.r
    /* renamed from: oq, reason: merged with bridge method [inline-methods] */
    public cw qv(long j6) {
        if (j6 == 0) {
            return g(48);
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j6)) / 4) + 1;
        az up = up(numberOfTrailingZeros);
        byte[] bArr = up.f26084j;
        int i6 = up.cw;
        for (int i7 = (i6 + numberOfTrailingZeros) - 1; i7 >= i6; i7--) {
            bArr[i7] = cw[(int) (15 & j6)];
            j6 >>>= 4;
        }
        up.cw += numberOfTrailingZeros;
        this.xt += numberOfTrailingZeros;
        return this;
    }

    public String j(long j6, Charset charset) throws EOFException {
        tj.j(this.xt, 0L, j6);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        if (j6 > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: ".concat(String.valueOf(j6)));
        }
        if (j6 == 0) {
            return "";
        }
        az azVar = this.f26087j;
        int i6 = azVar.xt;
        if (i6 + j6 > azVar.cw) {
            return new String(ae(j6), charset);
        }
        String str = new String(azVar.f26084j, i6, (int) j6, charset);
        int i7 = (int) (azVar.xt + j6);
        azVar.xt = i7;
        this.xt -= j6;
        if (i7 == azVar.cw) {
            this.f26087j = azVar.xt();
            av.j(azVar);
        }
        return str;
    }

    @Override // com.bytedance.sdk.component.cw.j.w, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // com.bytedance.sdk.component.cw.j.r, com.bytedance.sdk.component.cw.j.w, java.io.Flushable
    public void flush() {
    }

    @Override // com.bytedance.sdk.component.cw.j.r
    /* renamed from: xt, reason: merged with bridge method [inline-methods] */
    public cw g(int i6) {
        az up = up(1);
        byte[] bArr = up.f26084j;
        int i7 = up.cw;
        up.cw = i7 + 1;
        bArr[i7] = (byte) i6;
        this.xt++;
        return this;
    }

    @Override // com.bytedance.sdk.component.cw.j.up
    public void j(byte[] bArr) throws EOFException {
        int i6 = 0;
        while (i6 < bArr.length) {
            int j6 = j(bArr, i6, bArr.length - i6);
            if (j6 == -1) {
                throw new EOFException();
            }
            i6 += j6;
        }
    }

    public int j(byte[] bArr, int i6, int i7) {
        tj.j(bArr.length, i6, i7);
        az azVar = this.f26087j;
        if (azVar == null) {
            return -1;
        }
        int min = Math.min(i7, azVar.cw - azVar.xt);
        System.arraycopy(azVar.f26084j, azVar.xt, bArr, i6, min);
        int i8 = azVar.xt + min;
        azVar.xt = i8;
        this.xt -= min;
        if (i8 == azVar.cw) {
            this.f26087j = azVar.xt();
            av.j(azVar);
        }
        return min;
    }

    @Override // com.bytedance.sdk.component.cw.j.r
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public cw xt(m mVar) {
        if (mVar != null) {
            mVar.j(this);
            return this;
        }
        throw new IllegalArgumentException("byteString == null");
    }

    @Override // com.bytedance.sdk.component.cw.j.r
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public cw xt(String str) {
        return j(str, 0, str.length());
    }

    public cw j(String str, int i6, int i7) {
        char charAt;
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i6 < 0) {
            throw new IllegalArgumentException("beginIndex < 0: ".concat(String.valueOf(i6)));
        }
        if (i7 >= i6) {
            if (i7 > str.length()) {
                throw new IllegalArgumentException("endIndex > string.length: " + i7 + " > " + str.length());
            }
            while (i6 < i7) {
                char charAt2 = str.charAt(i6);
                if (charAt2 < 128) {
                    az up = up(1);
                    byte[] bArr = up.f26084j;
                    int i8 = up.cw - i6;
                    int min = Math.min(i7, 8192 - i8);
                    int i9 = i6 + 1;
                    bArr[i6 + i8] = (byte) charAt2;
                    while (true) {
                        i6 = i9;
                        if (i6 >= min || (charAt = str.charAt(i6)) >= 128) {
                            break;
                        }
                        i9 = i6 + 1;
                        bArr[i6 + i8] = (byte) charAt;
                    }
                    int i10 = up.cw;
                    int i11 = (i8 + i6) - i10;
                    up.cw = i10 + i11;
                    this.xt += i11;
                } else {
                    if (charAt2 < 2048) {
                        g((charAt2 >> 6) | 192);
                        g((charAt2 & '?') | 128);
                    } else if (charAt2 >= 55296 && charAt2 <= 57343) {
                        int i12 = i6 + 1;
                        char charAt3 = i12 < i7 ? str.charAt(i12) : (char) 0;
                        if (charAt2 <= 56319 && charAt3 >= 56320 && charAt3 <= 57343) {
                            int i13 = (((charAt2 & 10239) << 10) | (9215 & charAt3)) + 65536;
                            g((i13 >> 18) | 240);
                            g(((i13 >> 12) & 63) | 128);
                            g(((i13 >> 6) & 63) | 128);
                            g((i13 & 63) | 128);
                            i6 += 2;
                        } else {
                            g(63);
                            i6 = i12;
                        }
                    } else {
                        g((charAt2 >> '\f') | 224);
                        g(((charAt2 >> 6) & 63) | 128);
                        g((charAt2 & '?') | 128);
                    }
                    i6++;
                }
            }
            return this;
        }
        throw new IllegalArgumentException("endIndex < beginIndex: " + i7 + " < " + i6);
    }

    public cw j(int i6) {
        if (i6 < 128) {
            g(i6);
            return this;
        }
        if (i6 < 2048) {
            g((i6 >> 6) | 192);
            g((i6 & 63) | 128);
            return this;
        }
        if (i6 < 65536) {
            if (i6 >= 55296 && i6 <= 57343) {
                g(63);
                return this;
            }
            g((i6 >> 12) | 224);
            g(((i6 >> 6) & 63) | 128);
            g((i6 & 63) | 128);
            return this;
        }
        if (i6 <= 1114111) {
            g((i6 >> 18) | 240);
            g(((i6 >> 12) & 63) | 128);
            g(((i6 >> 6) & 63) | 128);
            g((i6 & 63) | 128);
            return this;
        }
        throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i6));
    }

    public cw j(String str, int i6, int i7, Charset charset) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i6 < 0) {
            throw new IllegalAccessError("beginIndex < 0: ".concat(String.valueOf(i6)));
        }
        if (i7 >= i6) {
            if (i7 > str.length()) {
                throw new IllegalArgumentException("endIndex > string.length: " + i7 + " > " + str.length());
            }
            if (charset != null) {
                if (charset.equals(tj.f26105j)) {
                    return j(str, i6, i7);
                }
                byte[] bytes = str.substring(i6, i7).getBytes(charset);
                return cw(bytes, 0, bytes.length);
            }
            throw new IllegalArgumentException("charset == null");
        }
        throw new IllegalArgumentException("endIndex < beginIndex: " + i7 + " < " + i6);
    }

    public long j(mi miVar) throws IOException {
        if (miVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j6 = 0;
        while (true) {
            long j7 = miVar.j(this, 8192L);
            if (j7 == -1) {
                return j6;
            }
            j6 += j7;
        }
    }

    @Override // com.bytedance.sdk.component.cw.j.mi
    public long j(cw cwVar, long j6) {
        if (cwVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        if (j6 >= 0) {
            long j7 = this.xt;
            if (j7 == 0) {
                return -1L;
            }
            if (j6 > j7) {
                j6 = j7;
            }
            cwVar.a_(this, j6);
            return j6;
        }
        throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j6)));
    }

    @Override // com.bytedance.sdk.component.cw.j.up
    public long j(byte b6) {
        return j(b6, 0L, Long.MAX_VALUE);
    }

    public long j(byte b6, long j6, long j7) {
        az azVar;
        long j8 = 0;
        if (j6 >= 0 && j7 >= j6) {
            long j9 = this.xt;
            long j10 = j7 > j9 ? j9 : j7;
            if (j6 == j10 || (azVar = this.f26087j) == null) {
                return -1L;
            }
            if (j9 - j6 < j6) {
                while (j9 > j6) {
                    azVar = azVar.ae;
                    j9 -= azVar.cw - azVar.xt;
                }
            } else {
                while (true) {
                    long j11 = (azVar.cw - azVar.xt) + j8;
                    if (j11 >= j6) {
                        break;
                    }
                    azVar = azVar.f26085m;
                    j8 = j11;
                }
                j9 = j8;
            }
            long j12 = j6;
            while (j9 < j10) {
                byte[] bArr = azVar.f26084j;
                int min = (int) Math.min(azVar.cw, (azVar.xt + j10) - j9);
                for (int i6 = (int) ((azVar.xt + j12) - j9); i6 < min; i6++) {
                    if (bArr[i6] == b6) {
                        return (i6 - azVar.xt) + j9;
                    }
                }
                j9 += azVar.cw - azVar.xt;
                azVar = azVar.f26085m;
                j12 = j9;
            }
            return -1L;
        }
        throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", Long.valueOf(this.xt), Long.valueOf(j6), Long.valueOf(j7)));
    }

    @Override // com.bytedance.sdk.component.cw.j.up
    public boolean j(long j6, m mVar) {
        return j(j6, mVar, 0, mVar.ae());
    }

    public boolean j(long j6, m mVar, int i6, int i7) {
        if (j6 < 0 || i6 < 0 || i7 < 0 || this.xt - j6 < i7 || mVar.ae() - i6 < i7) {
            return false;
        }
        for (int i8 = 0; i8 < i7; i8++) {
            if (xt(i8 + j6) != mVar.j(i6 + i8)) {
                return false;
            }
        }
        return true;
    }

    @Override // com.bytedance.sdk.component.cw.j.w
    public kt j() {
        return kt.cw;
    }
}
