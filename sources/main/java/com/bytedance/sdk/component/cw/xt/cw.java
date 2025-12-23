package com.bytedance.sdk.component.cw.xt;

import cn.jpush.android.local.JPushConstants;
import com.bytedance.sdk.component.cw.xt.j.j.r;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.util.List;

/* loaded from: D:\Downloads\app\classes4.dex */
public final class cw implements Closeable, Flushable {

    /* renamed from: j, reason: collision with root package name */
    final com.bytedance.sdk.component.cw.xt.j.j.m f26126j;
    final com.bytedance.sdk.component.cw.xt.j.j.r xt;

    private static class j extends h {
        private final String cw;

        /* renamed from: j, reason: collision with root package name */
        final r.cw f26127j;

        /* renamed from: r, reason: collision with root package name */
        private final String f26128r;
        private final com.bytedance.sdk.component.cw.j.up xt;

        @Override // com.bytedance.sdk.component.cw.xt.h
        public com.bytedance.sdk.component.cw.j.up cw() {
            return this.xt;
        }

        @Override // com.bytedance.sdk.component.cw.xt.h
        public tj j() {
            String str = this.cw;
            if (str != null) {
                return tj.j(str);
            }
            return null;
        }

        @Override // com.bytedance.sdk.component.cw.xt.h
        public long xt() {
            try {
                String str = this.f26128r;
                if (str != null) {
                    return Long.parseLong(str);
                }
                return -1L;
            } catch (NumberFormatException unused) {
                return -1L;
            }
        }
    }

    private static final class xt {

        /* renamed from: j, reason: collision with root package name */
        private static final String f26129j = com.bytedance.sdk.component.cw.xt.j.ae.up.xt().cw() + "-Sent-Millis";
        private static final String xt = com.bytedance.sdk.component.cw.xt.j.ae.up.xt().cw() + "-Received-Millis";
        private final int ae;
        private final String cw;

        /* renamed from: g, reason: collision with root package name */
        private final w f26130g;

        /* renamed from: m, reason: collision with root package name */
        private final x f26131m;
        private final i oq;
        private final long qv;

        /* renamed from: r, reason: collision with root package name */
        private final w f26132r;
        private final String tl;
        private final String up;
        private final long vl;

        public void j(r.j jVar) throws IOException {
            com.bytedance.sdk.component.cw.j.r j6 = com.bytedance.sdk.component.cw.j.vl.j(jVar.j(0));
            j6.xt(this.cw).g(10);
            j6.xt(this.up).g(10);
            j6.vl(this.f26132r.j()).g(10);
            int j7 = this.f26132r.j();
            for (int i6 = 0; i6 < j7; i6++) {
                j6.xt(this.f26132r.j(i6)).xt(": ").xt(this.f26132r.xt(i6)).g(10);
            }
            j6.xt(new com.bytedance.sdk.component.cw.xt.j.cw.qv(this.f26131m, this.ae, this.tl).toString()).g(10);
            j6.vl(this.f26130g.j() + 2).g(10);
            int j8 = this.f26130g.j();
            for (int i7 = 0; i7 < j8; i7++) {
                j6.xt(this.f26130g.j(i7)).xt(": ").xt(this.f26130g.xt(i7)).g(10);
            }
            j6.xt(f26129j).xt(": ").vl(this.qv).g(10);
            j6.xt(xt).xt(": ").vl(this.vl).g(10);
            if (j()) {
                j6.g(10);
                j6.xt(this.oq.xt().j()).g(10);
                j(j6, this.oq.cw());
                j(j6, this.oq.r());
                j6.xt(this.oq.j().j()).g(10);
            }
            j6.close();
        }

        xt(p pVar) {
            this.cw = pVar.j().j().toString();
            this.f26132r = com.bytedance.sdk.component.cw.xt.j.cw.up.xt(pVar);
            this.up = pVar.j().xt();
            this.f26131m = pVar.xt();
            this.ae = pVar.cw();
            this.tl = pVar.up();
            this.f26130g = pVar.ae();
            this.oq = pVar.m();
            this.qv = pVar.jy();
            this.vl = pVar.ws();
        }

        private boolean j() {
            return this.cw.startsWith(JPushConstants.HTTPS_PRE);
        }

        private void j(com.bytedance.sdk.component.cw.j.r rVar, List<Certificate> list) throws IOException {
            try {
                rVar.vl(list.size()).g(10);
                int size = list.size();
                for (int i6 = 0; i6 < size; i6++) {
                    rVar.xt(com.bytedance.sdk.component.cw.j.m.j(list.get(i6).getEncoded()).xt()).g(10);
                }
            } catch (CertificateEncodingException e6) {
                throw new IOException(e6.getMessage());
            }
        }
    }

    private void j(r.j jVar) {
        if (jVar != null) {
            try {
                jVar.cw();
            } catch (IOException unused) {
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.xt.close();
    }

    public void delete() throws IOException {
        this.xt.delete();
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        this.xt.flush();
    }

    void update(p pVar, p pVar2) {
        r.j jVar;
        xt xtVar = new xt(pVar2);
        try {
            jVar = ((j) pVar.tl()).f26127j.j();
            if (jVar != null) {
                try {
                    xtVar.j(jVar);
                    jVar.xt();
                } catch (IOException unused) {
                    j(jVar);
                }
            }
        } catch (IOException unused2) {
            jVar = null;
        }
    }
}
