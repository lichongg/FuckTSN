package com.bytedance.sdk.component.cw.xt.j.up;

import com.bytedance.sdk.component.cw.j.mi;
import com.bytedance.sdk.component.cw.j.w;
import com.bytedance.sdk.component.cw.xt.h;
import com.bytedance.sdk.component.cw.xt.kt;
import com.bytedance.sdk.component.cw.xt.p;
import com.bytedance.sdk.component.cw.xt.s;
import com.bytedance.sdk.component.cw.xt.v;
import com.bytedance.sdk.component.cw.xt.w;
import com.bytedance.sdk.component.cw.xt.x;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\Downloads\app\classes4.dex */
public final class m implements com.bytedance.sdk.component.cw.xt.j.cw.cw {
    private static final com.bytedance.sdk.component.cw.j.m ae;
    private static final com.bytedance.sdk.component.cw.j.m cw;

    /* renamed from: g, reason: collision with root package name */
    private static final com.bytedance.sdk.component.cw.j.m f26274g;

    /* renamed from: m, reason: collision with root package name */
    private static final com.bytedance.sdk.component.cw.j.m f26275m;
    private static final List<com.bytedance.sdk.component.cw.j.m> oq;
    private static final List<com.bytedance.sdk.component.cw.j.m> qv;

    /* renamed from: r, reason: collision with root package name */
    private static final com.bytedance.sdk.component.cw.j.m f26276r;
    private static final com.bytedance.sdk.component.cw.j.m tl;
    private static final com.bytedance.sdk.component.cw.j.m up;
    private static final com.bytedance.sdk.component.cw.j.m xt;
    private g az;

    /* renamed from: j, reason: collision with root package name */
    final com.bytedance.sdk.component.cw.xt.j.xt.ae f26277j;
    private final kt.j jy;
    private final v vl;
    private final ae ws;

    class j extends com.bytedance.sdk.component.cw.j.tl {

        /* renamed from: j, reason: collision with root package name */
        boolean f26278j;
        long xt;

        @Override // com.bytedance.sdk.component.cw.j.tl, com.bytedance.sdk.component.cw.j.mi
        public long j(com.bytedance.sdk.component.cw.j.cw cwVar, long j6) throws IOException {
            try {
                long j7 = xt().j(cwVar, j6);
                if (j7 <= 0) {
                    return j7;
                }
                this.xt += j7;
                return j7;
            } catch (IOException e6) {
                j(e6);
                throw e6;
            }
        }

        j(mi miVar) {
            super(miVar);
            this.f26278j = false;
            this.xt = 0L;
        }

        @Override // com.bytedance.sdk.component.cw.j.tl, com.bytedance.sdk.component.cw.j.mi, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            super.close();
            j(null);
        }

        private void j(IOException iOException) {
            if (this.f26278j) {
                return;
            }
            this.f26278j = true;
            m mVar = m.this;
            mVar.f26277j.j(false, (com.bytedance.sdk.component.cw.xt.j.cw.cw) mVar, this.xt, iOException);
        }
    }

    @Override // com.bytedance.sdk.component.cw.xt.j.cw.cw
    public w j(s sVar, long j6) {
        return this.az.tl();
    }

    @Override // com.bytedance.sdk.component.cw.xt.j.cw.cw
    public void xt() throws IOException {
        this.az.tl().close();
    }

    static {
        com.bytedance.sdk.component.cw.j.m j6 = com.bytedance.sdk.component.cw.j.m.j("connection");
        xt = j6;
        com.bytedance.sdk.component.cw.j.m j7 = com.bytedance.sdk.component.cw.j.m.j("host");
        cw = j7;
        com.bytedance.sdk.component.cw.j.m j8 = com.bytedance.sdk.component.cw.j.m.j("keep-alive");
        f26276r = j8;
        com.bytedance.sdk.component.cw.j.m j9 = com.bytedance.sdk.component.cw.j.m.j("proxy-connection");
        up = j9;
        com.bytedance.sdk.component.cw.j.m j10 = com.bytedance.sdk.component.cw.j.m.j("transfer-encoding");
        f26275m = j10;
        com.bytedance.sdk.component.cw.j.m j11 = com.bytedance.sdk.component.cw.j.m.j("te");
        ae = j11;
        com.bytedance.sdk.component.cw.j.m j12 = com.bytedance.sdk.component.cw.j.m.j("encoding");
        tl = j12;
        com.bytedance.sdk.component.cw.j.m j13 = com.bytedance.sdk.component.cw.j.m.j("upgrade");
        f26274g = j13;
        oq = com.bytedance.sdk.component.cw.xt.j.cw.j(j6, j7, j8, j9, j11, j10, j12, j13, cw.cw, cw.f26262r, cw.up, cw.f26261m);
        qv = com.bytedance.sdk.component.cw.xt.j.cw.j(j6, j7, j8, j9, j11, j10, j12, j13);
    }

    public static List<cw> xt(s sVar) {
        com.bytedance.sdk.component.cw.xt.w cw2 = sVar.cw();
        ArrayList arrayList = new ArrayList(cw2.j() + 4);
        arrayList.add(new cw(cw.cw, sVar.xt()));
        arrayList.add(new cw(cw.f26262r, com.bytedance.sdk.component.cw.xt.j.cw.g.j(sVar.j())));
        String j6 = sVar.j("Host");
        if (j6 != null) {
            arrayList.add(new cw(cw.f26261m, j6));
        }
        arrayList.add(new cw(cw.up, sVar.j().cw()));
        int j7 = cw2.j();
        for (int i6 = 0; i6 < j7; i6++) {
            com.bytedance.sdk.component.cw.j.m j8 = com.bytedance.sdk.component.cw.j.m.j(cw2.j(i6).toLowerCase(Locale.US));
            if (!oq.contains(j8)) {
                arrayList.add(new cw(j8, cw2.xt(i6)));
            }
        }
        return arrayList;
    }

    @Override // com.bytedance.sdk.component.cw.xt.j.cw.cw
    public void cw() {
        g gVar = this.az;
        if (gVar != null) {
            gVar.xt(xt.CANCEL);
        }
    }

    @Override // com.bytedance.sdk.component.cw.xt.j.cw.cw
    public void j(s sVar) throws IOException {
        if (this.az != null) {
            return;
        }
        g j6 = this.ws.j(xt(sVar), sVar.r() != null);
        this.az = j6;
        com.bytedance.sdk.component.cw.j.kt up2 = j6.up();
        long cw2 = this.jy.cw();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        up2.j(cw2, timeUnit);
        this.az.m().j(this.jy.r(), timeUnit);
    }

    public m(v vVar, kt.j jVar, com.bytedance.sdk.component.cw.xt.j.xt.ae aeVar, ae aeVar2) {
        this.vl = vVar;
        this.jy = jVar;
        this.f26277j = aeVar;
        this.ws = aeVar2;
    }

    @Override // com.bytedance.sdk.component.cw.xt.j.cw.cw
    public void j() throws IOException {
        this.ws.xt();
    }

    @Override // com.bytedance.sdk.component.cw.xt.j.cw.cw
    public p.j j(boolean z5) throws IOException {
        p.j j6 = j(this.az.r());
        if (z5 && com.bytedance.sdk.component.cw.xt.j.j.f26187j.j(j6) == 100) {
            return null;
        }
        return j6;
    }

    public static p.j j(List<cw> list) throws IOException {
        w.j jVar = new w.j();
        int size = list.size();
        com.bytedance.sdk.component.cw.xt.j.cw.qv qvVar = null;
        for (int i6 = 0; i6 < size; i6++) {
            cw cwVar = list.get(i6);
            if (cwVar == null) {
                if (qvVar != null && qvVar.xt == 100) {
                    jVar = new w.j();
                    qvVar = null;
                }
            } else {
                com.bytedance.sdk.component.cw.j.m mVar = cwVar.ae;
                String j6 = cwVar.tl.j();
                if (mVar.equals(cw.xt)) {
                    qvVar = com.bytedance.sdk.component.cw.xt.j.cw.qv.j("HTTP/1.1 ".concat(String.valueOf(j6)));
                } else if (!qv.contains(mVar)) {
                    com.bytedance.sdk.component.cw.xt.j.j.f26187j.j(jVar, mVar.j(), j6);
                }
            }
        }
        if (qvVar != null) {
            return new p.j().j(x.HTTP_2).j(qvVar.xt).j(qvVar.cw).j(jVar.j());
        }
        throw new ProtocolException("Expected ':status' header not present");
    }

    @Override // com.bytedance.sdk.component.cw.xt.j.cw.cw
    public h j(p pVar) throws IOException {
        return new com.bytedance.sdk.component.cw.xt.j.cw.tl(pVar.j("Content-Type"), com.bytedance.sdk.component.cw.xt.j.cw.up.j(pVar), com.bytedance.sdk.component.cw.j.vl.j(new j(this.az.ae())));
    }
}
