package com.bytedance.sdk.component.cw.xt.j.cw;

import com.bytedance.sdk.component.cw.j.w;
import com.bytedance.sdk.component.cw.xt.kt;
import com.bytedance.sdk.component.cw.xt.l;
import com.bytedance.sdk.component.cw.xt.p;
import com.bytedance.sdk.component.cw.xt.s;
import java.io.IOException;
import java.net.ProtocolException;

/* loaded from: D:\Downloads\app\classes4.dex */
public final class xt implements kt {

    /* renamed from: j, reason: collision with root package name */
    private final boolean f26179j;

    static final class j extends com.bytedance.sdk.component.cw.j.ae {

        /* renamed from: j, reason: collision with root package name */
        long f26180j;

        j(w wVar) {
            super(wVar);
        }

        @Override // com.bytedance.sdk.component.cw.j.ae, com.bytedance.sdk.component.cw.j.w
        public void a_(com.bytedance.sdk.component.cw.j.cw cwVar, long j6) throws IOException {
            super.a_(cwVar, j6);
            this.f26180j += j6;
        }
    }

    @Override // com.bytedance.sdk.component.cw.xt.kt
    public p j(kt.j jVar) throws IOException {
        l lVar;
        ae aeVar = (ae) jVar;
        cw ae = aeVar.ae();
        com.bytedance.sdk.component.cw.xt.j.xt.ae m6 = aeVar.m();
        com.bytedance.sdk.component.cw.xt.j.xt.cw cwVar = (com.bytedance.sdk.component.cw.xt.j.xt.cw) aeVar.up();
        s j6 = aeVar.j();
        long currentTimeMillis = System.currentTimeMillis();
        if (j6 != null && (lVar = j6.f26363m) != null) {
            lVar.j(currentTimeMillis);
        }
        aeVar.call();
        ae.j(j6);
        aeVar.call();
        p.j jVar2 = null;
        if (m.cw(j6.xt()) && j6.r() != null) {
            if ("100-continue".equalsIgnoreCase(j6.j("Expect"))) {
                ae.j();
                aeVar.call();
                jVar2 = ae.j(true);
            }
            if (jVar2 == null) {
                aeVar.call();
                com.bytedance.sdk.component.cw.j.r j7 = com.bytedance.sdk.component.cw.j.vl.j(new j(ae.j(j6, j6.r().xt())));
                j6.r().j(j7);
                j7.close();
                aeVar.call();
            } else if (!cwVar.up()) {
                m6.r();
            }
        }
        ae.xt();
        if (jVar2 == null) {
            aeVar.call();
            jVar2 = ae.j(false);
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        l lVar2 = j6.f26363m;
        if (lVar2 != null) {
            lVar2.xt(currentTimeMillis2);
        }
        p j8 = jVar2.j(j6).j(m6.xt().r()).j(currentTimeMillis).xt(currentTimeMillis2).j();
        aeVar.call();
        int cw = j8.cw();
        p j9 = (this.f26179j && cw == 101) ? j8.g().j(com.bytedance.sdk.component.cw.xt.j.cw.cw).j() : j8.g().j(ae.j(j8)).j();
        if ("close".equalsIgnoreCase(j9.j().j("Connection")) || "close".equalsIgnoreCase(j9.j("Connection"))) {
            m6.r();
        }
        if ((cw != 204 && cw != 205) || j9.tl().xt() <= 0) {
            return j9;
        }
        throw new ProtocolException("HTTP " + cw + " had non-zero Content-Length: " + j9.tl().xt());
    }

    public xt(boolean z5) {
        this.f26179j = z5;
    }
}
