package com.bytedance.sdk.component.cw.xt.j.up;

import com.bytedance.sdk.component.cw.j.kt;
import com.bytedance.sdk.component.cw.j.mi;
import com.bytedance.sdk.component.cw.xt.j.up.r;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: D:\Downloads\app\classes4.dex */
final class tl implements Closeable {

    /* renamed from: j, reason: collision with root package name */
    static final Logger f26293j = Logger.getLogger(up.class.getName());
    private final com.bytedance.sdk.component.cw.j.up cw;

    /* renamed from: r, reason: collision with root package name */
    private final j f26294r;
    private final boolean up;
    final r.j xt;

    static final class j implements mi {
        int cw;

        /* renamed from: j, reason: collision with root package name */
        int f26295j;

        /* renamed from: m, reason: collision with root package name */
        private final com.bytedance.sdk.component.cw.j.up f26296m;

        /* renamed from: r, reason: collision with root package name */
        int f26297r;
        short up;
        byte xt;

        @Override // com.bytedance.sdk.component.cw.j.mi
        public long j(com.bytedance.sdk.component.cw.j.cw cwVar, long j6) throws IOException {
            while (true) {
                int i6 = this.f26297r;
                if (i6 != 0) {
                    long j7 = this.f26296m.j(cwVar, Math.min(j6, i6));
                    if (j7 == -1) {
                        return -1L;
                    }
                    this.f26297r = (int) (this.f26297r - j7);
                    return j7;
                }
                this.f26296m.tl(this.up);
                this.up = (short) 0;
                if ((this.xt & 4) != 0) {
                    return -1L;
                }
                xt();
            }
        }

        private void xt() throws IOException {
            int i6 = this.cw;
            int j6 = tl.j(this.f26296m);
            this.f26297r = j6;
            this.f26295j = j6;
            byte tl = (byte) (this.f26296m.tl() & 255);
            this.xt = (byte) (this.f26296m.tl() & 255);
            Logger logger = tl.f26293j;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(up.j(true, this.cw, this.f26295j, tl, this.xt));
            }
            int oq = this.f26296m.oq() & Integer.MAX_VALUE;
            this.cw = oq;
            if (tl != 9) {
                throw up.xt("%s != TYPE_CONTINUATION", Byte.valueOf(tl));
            }
            if (oq != i6) {
                throw up.xt("TYPE_CONTINUATION streamId changed", new Object[0]);
            }
        }

        j(com.bytedance.sdk.component.cw.j.up upVar) {
            this.f26296m = upVar;
        }

        @Override // com.bytedance.sdk.component.cw.j.mi
        public kt j() {
            return this.f26296m.j();
        }

        @Override // com.bytedance.sdk.component.cw.j.mi, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }
    }

    interface xt {
        void j(int i6, int i7, List<cw> list) throws IOException;

        void j(int i6, long j6);

        void j(int i6, com.bytedance.sdk.component.cw.xt.j.up.xt xtVar);

        void j(int i6, com.bytedance.sdk.component.cw.xt.j.up.xt xtVar, com.bytedance.sdk.component.cw.j.m mVar);

        void j(boolean z5, int i6, int i7);

        void j(boolean z5, int i6, int i7, List<cw> list);

        void j(boolean z5, int i6, com.bytedance.sdk.component.cw.j.up upVar, int i7) throws IOException;

        void j(boolean z5, ws wsVar);
    }

    private void cw(xt xtVar, int i6, byte b6, int i7) throws IOException {
        if (i6 != 5) {
            throw up.xt("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i6));
        }
        if (i7 == 0) {
            throw up.xt("TYPE_PRIORITY streamId == 0", new Object[0]);
        }
        j(xtVar, i7);
    }

    private void g(xt xtVar, int i6, byte b6, int i7) throws IOException {
        if (i6 != 4) {
            throw up.xt("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i6));
        }
        long oq = this.cw.oq() & 2147483647L;
        if (oq == 0) {
            throw up.xt("windowSizeIncrement was 0", Long.valueOf(oq));
        }
        xtVar.j(i7, oq);
    }

    private void m(xt xtVar, int i6, byte b6, int i7) throws IOException {
        if (i7 == 0) {
            throw up.xt("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
        }
        short tl = (b6 & 8) != 0 ? (short) (this.cw.tl() & 255) : (short) 0;
        xtVar.j(i7, this.cw.oq() & Integer.MAX_VALUE, j(j(i6 - 4, b6, tl), tl, b6, i7));
    }

    private void r(xt xtVar, int i6, byte b6, int i7) throws IOException {
        if (i6 != 4) {
            throw up.xt("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i6));
        }
        if (i7 == 0) {
            throw up.xt("TYPE_RST_STREAM streamId == 0", new Object[0]);
        }
        int oq = this.cw.oq();
        com.bytedance.sdk.component.cw.xt.j.up.xt j6 = com.bytedance.sdk.component.cw.xt.j.up.xt.j(oq);
        if (j6 == null) {
            throw up.xt("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(oq));
        }
        xtVar.j(i7, j6);
    }

    private void tl(xt xtVar, int i6, byte b6, int i7) throws IOException {
        if (i6 < 8) {
            throw up.xt("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i6));
        }
        if (i7 != 0) {
            throw up.xt("TYPE_GOAWAY streamId != 0", new Object[0]);
        }
        int oq = this.cw.oq();
        int oq2 = this.cw.oq();
        int i8 = i6 - 8;
        com.bytedance.sdk.component.cw.xt.j.up.xt j6 = com.bytedance.sdk.component.cw.xt.j.up.xt.j(oq2);
        if (j6 == null) {
            throw up.xt("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(oq2));
        }
        com.bytedance.sdk.component.cw.j.m mVar = com.bytedance.sdk.component.cw.j.m.xt;
        if (i8 > 0) {
            mVar = this.cw.cw(i8);
        }
        xtVar.j(oq, j6, mVar);
    }

    private void up(xt xtVar, int i6, byte b6, int i7) throws IOException {
        if (i7 != 0) {
            throw up.xt("TYPE_SETTINGS streamId != 0", new Object[0]);
        }
        if ((b6 & 1) != 0) {
            if (i6 != 0) {
                throw up.xt("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
            }
            return;
        }
        if (i6 % 6 != 0) {
            throw up.xt("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i6));
        }
        ws wsVar = new ws();
        for (int i8 = 0; i8 < i6; i8 += 6) {
            short g6 = this.cw.g();
            int oq = this.cw.oq();
            if (g6 != 2) {
                if (g6 == 3) {
                    g6 = 4;
                } else if (g6 == 4) {
                    if (oq < 0) {
                        throw up.xt("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                    }
                    g6 = 7;
                } else if (g6 == 5 && (oq < 16384 || oq > 16777215)) {
                    throw up.xt("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(oq));
                }
            } else if (oq != 0 && oq != 1) {
                throw up.xt("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
            }
            wsVar.j(g6, oq);
        }
        xtVar.j(false, wsVar);
    }

    private void xt(xt xtVar, int i6, byte b6, int i7) throws IOException {
        if (i7 == 0) {
            throw up.xt("PROTOCOL_ERROR: TYPE_DATA streamId == 0", new Object[0]);
        }
        boolean z5 = (b6 & 1) != 0;
        if ((b6 & 32) != 0) {
            throw up.xt("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
        }
        short tl = (b6 & 8) != 0 ? (short) (this.cw.tl() & 255) : (short) 0;
        xtVar.j(z5, i7, this.cw, j(i6, b6, tl));
        this.cw.tl(tl);
    }

    public void j(xt xtVar) throws IOException {
        if (this.up) {
            if (!j(true, xtVar)) {
                throw up.xt("Required SETTINGS preface not received", new Object[0]);
            }
            return;
        }
        com.bytedance.sdk.component.cw.j.up upVar = this.cw;
        com.bytedance.sdk.component.cw.j.m mVar = up.f26298j;
        com.bytedance.sdk.component.cw.j.m cw = upVar.cw(mVar.ae());
        Logger logger = f26293j;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(com.bytedance.sdk.component.cw.xt.j.cw.j("<< CONNECTION %s", cw.up()));
        }
        if (!mVar.equals(cw)) {
            throw up.xt("Expected a connection header but was %s", cw.j());
        }
    }

    private void ae(xt xtVar, int i6, byte b6, int i7) throws IOException {
        if (i6 != 8) {
            throw up.xt("TYPE_PING length != 8: %s", Integer.valueOf(i6));
        }
        if (i7 != 0) {
            throw up.xt("TYPE_PING streamId != 0", new Object[0]);
        }
        xtVar.j((b6 & 1) != 0, this.cw.oq(), this.cw.oq());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.cw.close();
    }

    tl(com.bytedance.sdk.component.cw.j.up upVar, boolean z5) {
        this.cw = upVar;
        this.up = z5;
        j jVar = new j(upVar);
        this.f26294r = jVar;
        this.xt = new r.j(4096, jVar);
    }

    public boolean j(boolean z5, xt xtVar) throws IOException {
        try {
            this.cw.j(9L);
            int j6 = j(this.cw);
            if (j6 < 0 || j6 > 16384) {
                throw up.xt("FRAME_SIZE_ERROR: %s", Integer.valueOf(j6));
            }
            byte tl = (byte) (this.cw.tl() & 255);
            if (z5 && tl != 4) {
                throw up.xt("Expected a SETTINGS frame but was %s", Byte.valueOf(tl));
            }
            byte tl2 = (byte) (this.cw.tl() & 255);
            int oq = this.cw.oq() & Integer.MAX_VALUE;
            Logger logger = f26293j;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(up.j(true, oq, j6, tl, tl2));
            }
            switch (tl) {
                case 0:
                    xt(xtVar, j6, tl2, oq);
                    return true;
                case 1:
                    j(xtVar, j6, tl2, oq);
                    return true;
                case 2:
                    cw(xtVar, j6, tl2, oq);
                    return true;
                case 3:
                    r(xtVar, j6, tl2, oq);
                    return true;
                case 4:
                    up(xtVar, j6, tl2, oq);
                    return true;
                case 5:
                    m(xtVar, j6, tl2, oq);
                    return true;
                case 6:
                    ae(xtVar, j6, tl2, oq);
                    return true;
                case 7:
                    tl(xtVar, j6, tl2, oq);
                    return true;
                case 8:
                    g(xtVar, j6, tl2, oq);
                    return true;
                default:
                    this.cw.tl(j6);
                    return true;
            }
        } catch (IOException unused) {
            return false;
        }
    }

    private void j(xt xtVar, int i6, byte b6, int i7) throws IOException {
        if (i7 != 0) {
            boolean z5 = (b6 & 1) != 0;
            short tl = (b6 & 8) != 0 ? (short) (this.cw.tl() & 255) : (short) 0;
            if ((b6 & 32) != 0) {
                j(xtVar, i7);
                i6 -= 5;
            }
            xtVar.j(z5, i7, -1, j(j(i6, b6, tl), tl, b6, i7));
            return;
        }
        throw up.xt("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
    }

    private List<cw> j(int i6, short s5, byte b6, int i7) throws IOException {
        j jVar = this.f26294r;
        jVar.f26297r = i6;
        jVar.f26295j = i6;
        jVar.up = s5;
        jVar.xt = b6;
        jVar.cw = i7;
        this.xt.j();
        return this.xt.xt();
    }

    private void j(xt xtVar, int i6) throws IOException {
        this.cw.oq();
        this.cw.tl();
    }

    static int j(com.bytedance.sdk.component.cw.j.up upVar) throws IOException {
        return (upVar.tl() & 255) | ((upVar.tl() & 255) << 16) | ((upVar.tl() & 255) << 8);
    }

    static int j(int i6, byte b6, short s5) throws IOException {
        if ((b6 & 8) != 0) {
            i6--;
        }
        if (s5 <= i6) {
            return (short) (i6 - s5);
        }
        throw up.xt("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s5), Integer.valueOf(i6));
    }
}
