package com.bytedance.sdk.component.cw.xt.j.r;

import android.support.v4.media.session.PlaybackStateCompat;
import com.bytedance.sdk.component.cw.j.g;
import com.bytedance.sdk.component.cw.j.kt;
import com.bytedance.sdk.component.cw.j.vl;
import com.bytedance.sdk.component.cw.j.w;
import com.bytedance.sdk.component.cw.xt.h;
import com.bytedance.sdk.component.cw.xt.j.cw.qv;
import com.bytedance.sdk.component.cw.xt.j.cw.tl;
import com.bytedance.sdk.component.cw.xt.j.xt.ae;
import com.bytedance.sdk.component.cw.xt.mi;
import com.bytedance.sdk.component.cw.xt.p;
import com.bytedance.sdk.component.cw.xt.s;
import com.bytedance.sdk.component.cw.xt.v;
import com.bytedance.sdk.component.cw.xt.w;
import io.netty.handler.codec.http.HttpHeaders;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\Downloads\app\classes4.dex */
public final class j implements com.bytedance.sdk.component.cw.xt.j.cw.cw {
    final com.bytedance.sdk.component.cw.j.up cw;

    /* renamed from: j, reason: collision with root package name */
    final v f26214j;

    /* renamed from: r, reason: collision with root package name */
    final com.bytedance.sdk.component.cw.j.r f26216r;
    final ae xt;
    int up = 0;

    /* renamed from: m, reason: collision with root package name */
    private long f26215m = PlaybackStateCompat.ACTION_SET_REPEAT_MODE;

    /* renamed from: com.bytedance.sdk.component.cw.xt.j.r.j$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private class cw extends AbstractC0407j {
        private long ae;

        /* renamed from: m, reason: collision with root package name */
        private final mi f26217m;
        private boolean tl;

        cw(mi miVar) {
            super(j.this, null);
            this.ae = -1L;
            this.tl = true;
            this.f26217m = miVar;
        }

        private void xt() throws IOException {
            if (this.ae != -1) {
                j.this.cw.av();
            }
            try {
                this.ae = j.this.cw.jy();
                String trim = j.this.cw.av().trim();
                if (this.ae < 0 || !(trim.isEmpty() || trim.startsWith(";"))) {
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.ae + trim + "\"");
                }
                if (this.ae == 0) {
                    this.tl = false;
                    com.bytedance.sdk.component.cw.xt.j.cw.up.j(j.this.f26214j.m(), this.f26217m, j.this.r());
                    j(true, (IOException) null);
                }
            } catch (NumberFormatException e6) {
                throw new ProtocolException(e6.getMessage());
            }
        }

        @Override // com.bytedance.sdk.component.cw.j.mi, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.xt) {
                return;
            }
            if (this.tl && !com.bytedance.sdk.component.cw.xt.j.cw.j(this, 100, TimeUnit.MILLISECONDS)) {
                j(false, (IOException) null);
            }
            this.xt = true;
        }

        @Override // com.bytedance.sdk.component.cw.xt.j.r.j.AbstractC0407j, com.bytedance.sdk.component.cw.j.mi
        public long j(com.bytedance.sdk.component.cw.j.cw cwVar, long j6) throws IOException {
            if (j6 < 0) {
                throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j6)));
            }
            if (this.xt) {
                throw new IllegalStateException("closed");
            }
            if (!this.tl) {
                return -1L;
            }
            long j7 = this.ae;
            if (j7 == 0 || j7 == -1) {
                xt();
                if (!this.tl) {
                    return -1L;
                }
            }
            long j8 = super.j(cwVar, Math.min(j6, this.ae));
            if (j8 != -1) {
                this.ae -= j8;
                return j8;
            }
            ProtocolException protocolException = new ProtocolException("unexpected end of stream");
            j(false, (IOException) protocolException);
            throw protocolException;
        }
    }

    /* renamed from: com.bytedance.sdk.component.cw.xt.j.r.j$j, reason: collision with other inner class name */
    private abstract class AbstractC0407j implements com.bytedance.sdk.component.cw.j.mi {
        protected long cw;

        /* renamed from: j, reason: collision with root package name */
        protected final g f26218j;
        protected boolean xt;

        private AbstractC0407j() {
            this.f26218j = new g(j.this.cw.j());
            this.cw = 0L;
        }

        @Override // com.bytedance.sdk.component.cw.j.mi
        public kt j() {
            return this.f26218j;
        }

        @Override // com.bytedance.sdk.component.cw.j.mi
        public long j(com.bytedance.sdk.component.cw.j.cw cwVar, long j6) throws IOException {
            try {
                long j7 = j.this.cw.j(cwVar, j6);
                if (j7 <= 0) {
                    return j7;
                }
                this.cw += j7;
                return j7;
            } catch (IOException e6) {
                j(false, e6);
                throw e6;
            }
        }

        /* synthetic */ AbstractC0407j(j jVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        protected final void j(boolean z5, IOException iOException) throws IOException {
            j jVar = j.this;
            int i6 = jVar.up;
            if (i6 == 6) {
                return;
            }
            if (i6 == 5) {
                jVar.j(this.f26218j);
                j jVar2 = j.this;
                jVar2.up = 6;
                ae aeVar = jVar2.xt;
                if (aeVar != null) {
                    aeVar.j(!z5, jVar2, this.cw, iOException);
                    return;
                }
                return;
            }
            throw new IllegalStateException("state: " + j.this.up);
        }
    }

    private class m extends AbstractC0407j {

        /* renamed from: m, reason: collision with root package name */
        private boolean f26220m;

        m() {
            super(j.this, null);
        }

        @Override // com.bytedance.sdk.component.cw.j.mi, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.xt) {
                return;
            }
            if (!this.f26220m) {
                j(false, (IOException) null);
            }
            this.xt = true;
        }

        @Override // com.bytedance.sdk.component.cw.xt.j.r.j.AbstractC0407j, com.bytedance.sdk.component.cw.j.mi
        public long j(com.bytedance.sdk.component.cw.j.cw cwVar, long j6) throws IOException {
            if (j6 < 0) {
                throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j6)));
            }
            if (this.xt) {
                throw new IllegalStateException("closed");
            }
            if (this.f26220m) {
                return -1L;
            }
            long j7 = super.j(cwVar, j6);
            if (j7 != -1) {
                return j7;
            }
            this.f26220m = true;
            j(true, (IOException) null);
            return -1L;
        }
    }

    private final class r implements w {
        private boolean cw;

        /* renamed from: r, reason: collision with root package name */
        private long f26222r;
        private final g xt;

        r(long j6) {
            this.xt = new g(j.this.f26216r.j());
            this.f26222r = j6;
        }

        @Override // com.bytedance.sdk.component.cw.j.w
        public void a_(com.bytedance.sdk.component.cw.j.cw cwVar, long j6) throws IOException {
            if (this.cw) {
                throw new IllegalStateException("closed");
            }
            com.bytedance.sdk.component.cw.xt.j.cw.j(cwVar.xt(), 0L, j6);
            if (j6 <= this.f26222r) {
                j.this.f26216r.a_(cwVar, j6);
                this.f26222r -= j6;
            } else {
                throw new ProtocolException("expected " + this.f26222r + " bytes but received " + j6);
            }
        }

        @Override // com.bytedance.sdk.component.cw.j.w, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.cw) {
                return;
            }
            this.cw = true;
            if (this.f26222r > 0) {
                throw new ProtocolException("unexpected end of stream");
            }
            j.this.j(this.xt);
            j.this.up = 3;
        }

        @Override // com.bytedance.sdk.component.cw.j.w, java.io.Flushable
        public void flush() throws IOException {
            if (this.cw) {
                return;
            }
            j.this.f26216r.flush();
        }

        @Override // com.bytedance.sdk.component.cw.j.w
        public kt j() {
            return this.xt;
        }
    }

    private class up extends AbstractC0407j {

        /* renamed from: m, reason: collision with root package name */
        private long f26223m;

        up(long j6) throws IOException {
            super(j.this, null);
            this.f26223m = j6;
            if (j6 == 0) {
                j(true, (IOException) null);
            }
        }

        @Override // com.bytedance.sdk.component.cw.j.mi, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.xt) {
                return;
            }
            if (this.f26223m != 0 && !com.bytedance.sdk.component.cw.xt.j.cw.j(this, 100, TimeUnit.MILLISECONDS)) {
                j(false, (IOException) null);
            }
            this.xt = true;
        }

        @Override // com.bytedance.sdk.component.cw.xt.j.r.j.AbstractC0407j, com.bytedance.sdk.component.cw.j.mi
        public long j(com.bytedance.sdk.component.cw.j.cw cwVar, long j6) throws IOException {
            if (j6 < 0) {
                throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j6)));
            }
            if (this.xt) {
                throw new IllegalStateException("closed");
            }
            long j7 = this.f26223m;
            if (j7 == 0) {
                return -1L;
            }
            long j8 = super.j(cwVar, Math.min(j7, j6));
            if (j8 == -1) {
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                j(false, (IOException) protocolException);
                throw protocolException;
            }
            long j9 = this.f26223m - j8;
            this.f26223m = j9;
            if (j9 == 0) {
                j(true, (IOException) null);
            }
            return j8;
        }
    }

    private final class xt implements w {
        private boolean cw;
        private final g xt;

        @Override // com.bytedance.sdk.component.cw.j.w, java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() throws IOException {
            if (this.cw) {
                return;
            }
            this.cw = true;
            j.this.f26216r.xt("0\r\n\r\n");
            j.this.j(this.xt);
            j.this.up = 3;
        }

        @Override // com.bytedance.sdk.component.cw.j.w, java.io.Flushable
        public synchronized void flush() throws IOException {
            if (this.cw) {
                return;
            }
            j.this.f26216r.flush();
        }

        xt() {
            this.xt = new g(j.this.f26216r.j());
        }

        @Override // com.bytedance.sdk.component.cw.j.w
        public void a_(com.bytedance.sdk.component.cw.j.cw cwVar, long j6) throws IOException {
            if (this.cw) {
                throw new IllegalStateException("closed");
            }
            if (j6 == 0) {
                return;
            }
            j.this.f26216r.qv(j6);
            j.this.f26216r.xt(org.apache.commons.net.g.f50795q);
            j.this.f26216r.a_(cwVar, j6);
            j.this.f26216r.xt(org.apache.commons.net.g.f50795q);
        }

        @Override // com.bytedance.sdk.component.cw.j.w
        public kt j() {
            return this.xt;
        }
    }

    @Override // com.bytedance.sdk.component.cw.xt.j.cw.cw
    public w j(s sVar, long j6) {
        if (HttpHeaders.Values.CHUNKED.equalsIgnoreCase(sVar.j("Transfer-Encoding"))) {
            return up();
        }
        if (j6 != -1) {
            return j(j6);
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    @Override // com.bytedance.sdk.component.cw.xt.j.cw.cw
    public void xt() throws IOException {
        this.f26216r.flush();
    }

    private String ae() throws IOException {
        String up2 = this.cw.up(this.f26215m);
        this.f26215m -= up2.length();
        return up2;
    }

    @Override // com.bytedance.sdk.component.cw.xt.j.cw.cw
    public void cw() {
        com.bytedance.sdk.component.cw.xt.j.xt.cw xt2 = this.xt.xt();
        if (xt2 != null) {
            xt2.xt();
        }
    }

    public com.bytedance.sdk.component.cw.j.mi m() throws IOException {
        if (this.up != 4) {
            throw new IllegalStateException("state: " + this.up);
        }
        ae aeVar = this.xt;
        if (aeVar == null) {
            throw new IllegalStateException("streamAllocation == null");
        }
        this.up = 5;
        aeVar.r();
        return new m();
    }

    public com.bytedance.sdk.component.cw.xt.w r() throws IOException {
        w.j jVar = new w.j();
        while (true) {
            String ae = ae();
            if (ae.length() == 0) {
                return jVar.j();
            }
            com.bytedance.sdk.component.cw.xt.j.j.f26187j.j(jVar, ae);
        }
    }

    public com.bytedance.sdk.component.cw.j.w up() {
        if (this.up == 1) {
            this.up = 2;
            return new xt();
        }
        throw new IllegalStateException("state: " + this.up);
    }

    public com.bytedance.sdk.component.cw.j.mi xt(long j6) throws IOException {
        if (this.up == 4) {
            this.up = 5;
            return new up(j6);
        }
        throw new IllegalStateException("state: " + this.up);
    }

    public j(v vVar, ae aeVar, com.bytedance.sdk.component.cw.j.up upVar, com.bytedance.sdk.component.cw.j.r rVar) {
        this.f26214j = vVar;
        this.xt = aeVar;
        this.cw = upVar;
        this.f26216r = rVar;
    }

    @Override // com.bytedance.sdk.component.cw.xt.j.cw.cw
    public void j(s sVar) throws IOException {
        j(sVar.cw(), com.bytedance.sdk.component.cw.xt.j.cw.g.j(sVar, this.xt.xt().j().xt().type()));
    }

    @Override // com.bytedance.sdk.component.cw.xt.j.cw.cw
    public h j(p pVar) throws IOException {
        String j6 = pVar.j("Content-Type");
        if (!com.bytedance.sdk.component.cw.xt.j.cw.up.cw(pVar)) {
            return new tl(j6, 0L, vl.j(xt(0L)));
        }
        if (HttpHeaders.Values.CHUNKED.equalsIgnoreCase(pVar.j("Transfer-Encoding"))) {
            return new tl(j6, -1L, vl.j(j(pVar.j().j())));
        }
        long j7 = com.bytedance.sdk.component.cw.xt.j.cw.up.j(pVar);
        if (j7 != -1) {
            return new tl(j6, j7, vl.j(xt(j7)));
        }
        return new tl(j6, -1L, vl.j(m()));
    }

    @Override // com.bytedance.sdk.component.cw.xt.j.cw.cw
    public void j() throws IOException {
        this.f26216r.flush();
    }

    public void j(com.bytedance.sdk.component.cw.xt.w wVar, String str) throws IOException {
        if (this.up == 0) {
            this.f26216r.xt(str).xt(org.apache.commons.net.g.f50795q);
            int j6 = wVar.j();
            for (int i6 = 0; i6 < j6; i6++) {
                this.f26216r.xt(wVar.j(i6)).xt(": ").xt(wVar.xt(i6)).xt(org.apache.commons.net.g.f50795q);
            }
            this.f26216r.xt(org.apache.commons.net.g.f50795q);
            this.up = 1;
            return;
        }
        throw new IllegalStateException("state: " + this.up);
    }

    @Override // com.bytedance.sdk.component.cw.xt.j.cw.cw
    public p.j j(boolean z5) throws IOException {
        int i6 = this.up;
        if (i6 != 1 && i6 != 3) {
            throw new IllegalStateException("state: " + this.up);
        }
        try {
            qv j6 = qv.j(ae());
            p.j j7 = new p.j().j(j6.f26175j).j(j6.xt).j(j6.cw).j(r());
            if (z5 && j6.xt == 100) {
                return null;
            }
            this.up = 4;
            return j7;
        } catch (EOFException e6) {
            IOException iOException = new IOException("unexpected end of stream on " + this.xt);
            iOException.initCause(e6);
            throw iOException;
        }
    }

    public com.bytedance.sdk.component.cw.j.w j(long j6) {
        if (this.up == 1) {
            this.up = 2;
            return new r(j6);
        }
        throw new IllegalStateException("state: " + this.up);
    }

    public com.bytedance.sdk.component.cw.j.mi j(mi miVar) throws IOException {
        if (this.up == 4) {
            this.up = 5;
            return new cw(miVar);
        }
        throw new IllegalStateException("state: " + this.up);
    }

    void j(g gVar) {
        kt j6 = gVar.j();
        gVar.j(kt.cw);
        j6.m();
        j6.up();
    }
}
