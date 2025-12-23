package com.bytedance.sdk.component.cw.xt.j.j;

import com.bytedance.sdk.component.cw.j.mi;
import com.bytedance.sdk.component.cw.j.vl;
import com.bytedance.sdk.component.cw.j.w;
import com.bytedance.sdk.component.cw.xt.h;
import com.bytedance.sdk.component.cw.xt.j.cw.tl;
import com.bytedance.sdk.component.cw.xt.j.j.cw;
import com.bytedance.sdk.component.cw.xt.kt;
import com.bytedance.sdk.component.cw.xt.p;
import com.bytedance.sdk.component.cw.xt.s;
import com.bytedance.sdk.component.cw.xt.w;
import com.bytedance.sdk.component.cw.xt.x;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\Downloads\app\classes4.dex */
public final class j implements kt {

    /* renamed from: j, reason: collision with root package name */
    final m f26193j;

    @Override // com.bytedance.sdk.component.cw.xt.kt
    public p j(kt.j jVar) throws IOException {
        m mVar = this.f26193j;
        p j6 = mVar != null ? mVar.j(jVar.j()) : null;
        cw j7 = new cw.j(System.currentTimeMillis(), jVar.j(), j6).j();
        s sVar = j7.f26188j;
        p pVar = j7.xt;
        if (j6 != null && pVar == null) {
            com.bytedance.sdk.component.cw.xt.j.cw.j(j6.tl());
        }
        if (sVar == null && pVar == null) {
            return new p.j().j(jVar.j()).j(x.HTTP_1_1).j(504).j("Unsatisfiable Request (only-if-cached)").j(com.bytedance.sdk.component.cw.xt.j.cw.cw).j(-1L).xt(System.currentTimeMillis()).j();
        }
        if (sVar == null) {
            return pVar.g().xt(j(pVar)).j();
        }
        try {
            p j8 = jVar.j(sVar);
            if (j8 == null && j6 != null) {
            }
            if (pVar != null) {
                if (j8.cw() == 304) {
                    p j9 = pVar.g().j(j(pVar.ae(), j8.ae())).j(j8.jy()).xt(j8.ws()).xt(j(pVar)).j(j(j8)).j();
                    j8.tl().close();
                    this.f26193j.update(pVar, j9);
                    return j9;
                }
                com.bytedance.sdk.component.cw.xt.j.cw.j(pVar.tl());
            }
            p j10 = j8.g().xt(j(pVar)).j(j(j8)).j();
            if (this.f26193j != null) {
                if (com.bytedance.sdk.component.cw.xt.j.cw.up.cw(j10) && cw.j(j10, sVar)) {
                    return j(this.f26193j.j(j10), j10);
                }
                com.bytedance.sdk.component.cw.xt.j.cw.m.j(sVar.xt());
            }
            return j10;
        } finally {
            if (j6 != null) {
                com.bytedance.sdk.component.cw.xt.j.cw.j(j6.tl());
            }
        }
    }

    public j(m mVar) {
        this.f26193j = mVar;
    }

    private static p j(p pVar) {
        return (pVar == null || pVar.tl() == null) ? pVar : pVar.g().j((h) null).j();
    }

    private p j(final xt xtVar, p pVar) throws IOException {
        w j6;
        if (xtVar == null || (j6 = xtVar.j()) == null) {
            return pVar;
        }
        final com.bytedance.sdk.component.cw.j.up cw = pVar.tl().cw();
        final com.bytedance.sdk.component.cw.j.r j7 = vl.j(j6);
        return pVar.g().j(new tl(pVar.j("Content-Type"), pVar.tl().xt(), vl.j(new mi() { // from class: com.bytedance.sdk.component.cw.xt.j.j.j.1

            /* renamed from: j, reason: collision with root package name */
            boolean f26194j;

            @Override // com.bytedance.sdk.component.cw.j.mi
            public long j(com.bytedance.sdk.component.cw.j.cw cwVar, long j8) throws IOException {
                try {
                    long j9 = cw.j(cwVar, j8);
                    if (j9 != -1) {
                        cwVar.j(j7.cw(), cwVar.xt() - j9, j9);
                        j7.tj();
                        return j9;
                    }
                    if (!this.f26194j) {
                        this.f26194j = true;
                        j7.close();
                    }
                    return -1L;
                } catch (IOException e6) {
                    if (this.f26194j) {
                        throw e6;
                    }
                    this.f26194j = true;
                    throw e6;
                }
            }

            @Override // com.bytedance.sdk.component.cw.j.mi, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                if (!this.f26194j && !com.bytedance.sdk.component.cw.xt.j.cw.j(this, 100, TimeUnit.MILLISECONDS)) {
                    this.f26194j = true;
                }
                cw.close();
            }

            @Override // com.bytedance.sdk.component.cw.j.mi
            public com.bytedance.sdk.component.cw.j.kt j() {
                return cw.j();
            }
        }))).j();
    }

    private static com.bytedance.sdk.component.cw.xt.w j(com.bytedance.sdk.component.cw.xt.w wVar, com.bytedance.sdk.component.cw.xt.w wVar2) {
        w.j jVar = new w.j();
        int j6 = wVar.j();
        for (int i6 = 0; i6 < j6; i6++) {
            String j7 = wVar.j(i6);
            String xt = wVar.xt(i6);
            if ((!"Warning".equalsIgnoreCase(j7) || !xt.startsWith("1")) && (!j(j7) || wVar2.j(j7) == null)) {
                com.bytedance.sdk.component.cw.xt.j.j.f26187j.j(jVar, j7, xt);
            }
        }
        int j8 = wVar2.j();
        for (int i7 = 0; i7 < j8; i7++) {
            String j9 = wVar2.j(i7);
            if (!"Content-Length".equalsIgnoreCase(j9) && j(j9)) {
                com.bytedance.sdk.component.cw.xt.j.j.f26187j.j(jVar, j9, wVar2.xt(i7));
            }
        }
        return jVar.j();
    }

    static boolean j(String str) {
        return ("Connection".equalsIgnoreCase(str) || "Keep-Alive".equalsIgnoreCase(str) || "Proxy-Authenticate".equalsIgnoreCase(str) || "Proxy-Authorization".equalsIgnoreCase(str) || "TE".equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || "Transfer-Encoding".equalsIgnoreCase(str) || "Upgrade".equalsIgnoreCase(str)) ? false : true;
    }
}
