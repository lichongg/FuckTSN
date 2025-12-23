package com.bytedance.sdk.component.cw.xt.j.up;

import com.bytedance.sdk.component.cw.xt.j.up.r;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: D:\Downloads\app\classes4.dex */
final class oq implements Closeable {
    private static final Logger xt = Logger.getLogger(up.class.getName());
    private boolean ae;
    private final com.bytedance.sdk.component.cw.j.r cw;

    /* renamed from: j, reason: collision with root package name */
    final r.xt f26279j;

    /* renamed from: m, reason: collision with root package name */
    private int f26280m;

    /* renamed from: r, reason: collision with root package name */
    private final boolean f26281r;
    private final com.bytedance.sdk.component.cw.j.cw up;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.ae = true;
        this.cw.close();
    }

    public synchronized void j() throws IOException {
        try {
            if (this.ae) {
                throw new IOException("closed");
            }
            if (this.f26281r) {
                Logger logger = xt;
                if (logger.isLoggable(Level.FINE)) {
                    logger.fine(com.bytedance.sdk.component.cw.xt.j.cw.j(">> CONNECTION %s", up.f26298j.up()));
                }
                this.cw.cw(up.f26298j.tl());
                this.cw.flush();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void xt() throws IOException {
        if (this.ae) {
            throw new IOException("closed");
        }
        this.cw.flush();
    }

    public int cw() {
        return this.f26280m;
    }

    oq(com.bytedance.sdk.component.cw.j.r rVar, boolean z5) {
        this.cw = rVar;
        this.f26281r = z5;
        com.bytedance.sdk.component.cw.j.cw cwVar = new com.bytedance.sdk.component.cw.j.cw();
        this.up = cwVar;
        this.f26279j = new r.xt(cwVar);
        this.f26280m = 16384;
    }

    public synchronized void xt(ws wsVar) throws IOException {
        try {
            if (!this.ae) {
                int i6 = 0;
                j(0, wsVar.xt() * 6, (byte) 4, (byte) 0);
                while (i6 < 10) {
                    if (wsVar.j(i6)) {
                        this.cw.tl(i6 == 4 ? 3 : i6 == 7 ? 4 : i6);
                        this.cw.ae(wsVar.xt(i6));
                    }
                    i6++;
                }
                this.cw.flush();
            } else {
                throw new IOException("closed");
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void j(ws wsVar) throws IOException {
        try {
            if (!this.ae) {
                this.f26280m = wsVar.r(this.f26280m);
                if (wsVar.cw() != -1) {
                    this.f26279j.j(wsVar.cw());
                }
                j(0, 0, (byte) 4, (byte) 1);
                this.cw.flush();
            } else {
                throw new IOException("closed");
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private void xt(int i6, long j6) throws IOException {
        while (j6 > 0) {
            int min = (int) Math.min(this.f26280m, j6);
            long j7 = min;
            j6 -= j7;
            j(i6, min, (byte) 9, j6 == 0 ? (byte) 4 : (byte) 0);
            this.cw.a_(this.up, j7);
        }
    }

    public synchronized void j(int i6, int i7, List<cw> list) throws IOException {
        if (!this.ae) {
            this.f26279j.j(list);
            long xt2 = this.up.xt();
            int min = (int) Math.min(this.f26280m - 4, xt2);
            long j6 = min;
            j(i6, min + 4, (byte) 5, xt2 == j6 ? (byte) 4 : (byte) 0);
            this.cw.ae(i7 & Integer.MAX_VALUE);
            this.cw.a_(this.up, j6);
            if (xt2 > j6) {
                xt(i6, xt2 - j6);
            }
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void j(boolean z5, int i6, int i7, List<cw> list) throws IOException {
        if (!this.ae) {
            j(z5, i6, list);
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void j(int i6, xt xtVar) throws IOException {
        if (!this.ae) {
            if (xtVar.ae != -1) {
                j(i6, 4, (byte) 3, (byte) 0);
                this.cw.ae(xtVar.ae);
                this.cw.flush();
            } else {
                throw new IllegalArgumentException();
            }
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void j(boolean z5, int i6, com.bytedance.sdk.component.cw.j.cw cwVar, int i7) throws IOException {
        if (!this.ae) {
            j(i6, z5 ? (byte) 1 : (byte) 0, cwVar, i7);
        } else {
            throw new IOException("closed");
        }
    }

    void j(int i6, byte b6, com.bytedance.sdk.component.cw.j.cw cwVar, int i7) throws IOException {
        j(i6, i7, (byte) 0, b6);
        if (i7 > 0) {
            this.cw.a_(cwVar, i7);
        }
    }

    public synchronized void j(boolean z5, int i6, int i7) throws IOException {
        if (!this.ae) {
            j(0, 8, (byte) 6, z5 ? (byte) 1 : (byte) 0);
            this.cw.ae(i6);
            this.cw.ae(i7);
            this.cw.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void j(int i6, xt xtVar, byte[] bArr) throws IOException {
        try {
            if (!this.ae) {
                if (xtVar.ae != -1) {
                    j(0, bArr.length + 8, (byte) 7, (byte) 0);
                    this.cw.ae(i6);
                    this.cw.ae(xtVar.ae);
                    if (bArr.length > 0) {
                        this.cw.cw(bArr);
                    }
                    this.cw.flush();
                } else {
                    throw up.j("errorCode.httpCode == -1", new Object[0]);
                }
            } else {
                throw new IOException("closed");
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void j(int i6, long j6) throws IOException {
        if (this.ae) {
            throw new IOException("closed");
        }
        if (j6 != 0 && j6 <= 2147483647L) {
            j(i6, 4, (byte) 8, (byte) 0);
            this.cw.ae((int) j6);
            this.cw.flush();
        } else {
            throw up.j("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j6));
        }
    }

    public void j(int i6, int i7, byte b6, byte b7) throws IOException {
        Logger logger = xt;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(up.j(false, i6, i7, b6, b7));
        }
        int i8 = this.f26280m;
        if (i7 > i8) {
            throw up.j("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(i8), Integer.valueOf(i7));
        }
        if ((Integer.MIN_VALUE & i6) != 0) {
            throw up.j("reserved bit set: %s", Integer.valueOf(i6));
        }
        j(this.cw, i7);
        this.cw.g(b6 & 255);
        this.cw.g(b7 & 255);
        this.cw.ae(i6 & Integer.MAX_VALUE);
    }

    private static void j(com.bytedance.sdk.component.cw.j.r rVar, int i6) throws IOException {
        rVar.g((i6 >>> 16) & 255);
        rVar.g((i6 >>> 8) & 255);
        rVar.g(i6 & 255);
    }

    void j(boolean z5, int i6, List<cw> list) throws IOException {
        if (!this.ae) {
            this.f26279j.j(list);
            long xt2 = this.up.xt();
            int min = (int) Math.min(this.f26280m, xt2);
            long j6 = min;
            byte b6 = xt2 == j6 ? (byte) 4 : (byte) 0;
            if (z5) {
                b6 = (byte) (b6 | 1);
            }
            j(i6, min, (byte) 1, b6);
            this.cw.a_(this.up, j6);
            if (xt2 > j6) {
                xt(i6, xt2 - j6);
                return;
            }
            return;
        }
        throw new IOException("closed");
    }
}
