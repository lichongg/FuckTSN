package com.bytedance.sdk.component.cw.j;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

/* loaded from: D:\Downloads\app\classes4.dex */
public final class oq implements mi {
    private final Inflater cw;

    /* renamed from: r, reason: collision with root package name */
    private final qv f26102r;
    private final up xt;

    /* renamed from: j, reason: collision with root package name */
    private int f26101j = 0;
    private final CRC32 up = new CRC32();

    @Override // com.bytedance.sdk.component.cw.j.mi
    public long j(cw cwVar, long j6) throws IOException {
        oq oqVar;
        if (j6 < 0) {
            throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j6)));
        }
        if (j6 == 0) {
            return 0L;
        }
        if (this.f26101j == 0) {
            xt();
            this.f26101j = 1;
        }
        if (this.f26101j == 1) {
            long j7 = cwVar.xt;
            long j8 = this.f26102r.j(cwVar, j6);
            if (j8 != -1) {
                j(cwVar, j7, j8);
                return j8;
            }
            oqVar = this;
            oqVar.f26101j = 2;
        } else {
            oqVar = this;
        }
        if (oqVar.f26101j == 2) {
            cw();
            oqVar.f26101j = 3;
            if (!oqVar.xt.up()) {
                throw new IOException("gzip finished without exhausting source");
            }
        }
        return -1L;
    }

    private void cw() throws IOException {
        j("CRC", this.xt.vl(), (int) this.up.getValue());
        j("ISIZE", this.xt.vl(), (int) this.cw.getBytesWritten());
    }

    private void xt() throws IOException {
        this.xt.j(10L);
        byte xt = this.xt.cw().xt(3L);
        boolean z5 = ((xt >> 1) & 1) == 1;
        if (z5) {
            j(this.xt.cw(), 0L, 10L);
        }
        j("ID1ID2", 8075, this.xt.g());
        this.xt.tl(8L);
        if (((xt >> 2) & 1) == 1) {
            this.xt.j(2L);
            if (z5) {
                j(this.xt.cw(), 0L, 2L);
            }
            long qv = this.xt.cw().qv();
            this.xt.j(qv);
            if (z5) {
                j(this.xt.cw(), 0L, qv);
            }
            this.xt.tl(qv);
        }
        if (((xt >> 3) & 1) == 1) {
            long j6 = this.xt.j((byte) 0);
            if (j6 == -1) {
                throw new EOFException();
            }
            if (z5) {
                j(this.xt.cw(), 0L, j6 + 1);
            }
            this.xt.tl(j6 + 1);
        }
        if (((xt >> 4) & 1) == 1) {
            long j7 = this.xt.j((byte) 0);
            if (j7 == -1) {
                throw new EOFException();
            }
            if (z5) {
                j(this.xt.cw(), 0L, j7 + 1);
            }
            this.xt.tl(j7 + 1);
        }
        if (z5) {
            j("FHCRC", this.xt.qv(), (short) this.up.getValue());
            this.up.reset();
        }
    }

    @Override // com.bytedance.sdk.component.cw.j.mi, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f26102r.close();
    }

    public oq(mi miVar) {
        if (miVar != null) {
            Inflater inflater = new Inflater(true);
            this.cw = inflater;
            up j6 = vl.j(miVar);
            this.xt = j6;
            this.f26102r = new qv(j6, inflater);
            return;
        }
        throw new IllegalArgumentException("source == null");
    }

    @Override // com.bytedance.sdk.component.cw.j.mi
    public kt j() {
        return this.xt.j();
    }

    private void j(cw cwVar, long j6, long j7) {
        az azVar = cwVar.f26087j;
        while (true) {
            int i6 = azVar.cw;
            int i7 = azVar.xt;
            if (j6 < i6 - i7) {
                break;
            }
            j6 -= i6 - i7;
            azVar = azVar.f26085m;
        }
        while (j7 > 0) {
            int min = (int) Math.min(azVar.cw - r7, j7);
            this.up.update(azVar.f26084j, (int) (azVar.xt + j6), min);
            j7 -= min;
            azVar = azVar.f26085m;
            j6 = 0;
        }
    }

    private void j(String str, int i6, int i7) throws IOException {
        if (i7 != i6) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", str, Integer.valueOf(i7), Integer.valueOf(i6)));
        }
    }
}
