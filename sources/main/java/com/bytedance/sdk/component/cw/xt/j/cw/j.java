package com.bytedance.sdk.component.cw.xt.j.cw;

import com.bytedance.sdk.component.cw.xt.a;
import com.bytedance.sdk.component.cw.xt.jy;
import com.bytedance.sdk.component.cw.xt.kt;
import com.bytedance.sdk.component.cw.xt.p;
import com.bytedance.sdk.component.cw.xt.s;
import com.bytedance.sdk.component.cw.xt.tj;
import io.netty.handler.codec.http.HttpHeaders;
import java.io.IOException;
import java.util.List;

/* loaded from: D:\Downloads\app\classes4.dex */
public final class j implements kt {

    /* renamed from: j, reason: collision with root package name */
    private final jy f26172j;

    @Override // com.bytedance.sdk.component.cw.xt.kt
    public p j(kt.j jVar) throws IOException {
        s j6 = jVar.j();
        s.j m6 = j6.m();
        a r5 = j6.r();
        if (r5 != null) {
            tj j7 = r5.j();
            if (j7 != null) {
                m6.j("Content-Type", j7.toString());
            }
            long xt = r5.xt();
            if (xt != -1) {
                m6.j("Content-Length", Long.toString(xt));
                m6.xt("Transfer-Encoding");
            } else {
                m6.j("Transfer-Encoding", HttpHeaders.Values.CHUNKED);
                m6.xt("Content-Length");
            }
        }
        boolean z5 = false;
        if (j6.j("Host") == null) {
            m6.j("Host", com.bytedance.sdk.component.cw.xt.j.cw.j(j6.j(), false));
        }
        if (j6.j("Connection") == null) {
            m6.j("Connection", "Keep-Alive");
        }
        if (j6.j("Accept-Encoding") == null && j6.j("Range") == null) {
            m6.j("Accept-Encoding", "gzip");
            z5 = true;
        }
        List<com.bytedance.sdk.component.cw.xt.vl> j8 = this.f26172j.j(j6.j());
        if (!j8.isEmpty()) {
            m6.j("Cookie", j(j8));
        }
        if (j6.j("User-Agent") == null) {
            m6.j("User-Agent", com.bytedance.sdk.component.cw.xt.j.r.j());
        }
        p j9 = jVar.j(m6.j());
        up.j(this.f26172j, j6.j(), j9.ae());
        p.j j10 = j9.g().j(j6);
        if (z5 && "gzip".equalsIgnoreCase(j9.j("Content-Encoding")) && up.cw(j9)) {
            com.bytedance.sdk.component.cw.j.oq oqVar = new com.bytedance.sdk.component.cw.j.oq(j9.tl().cw());
            j10.j(j9.ae().xt().xt("Content-Encoding").xt("Content-Length").j());
            j10.j(new tl(j9.j("Content-Type"), -1L, com.bytedance.sdk.component.cw.j.vl.j(oqVar)));
        }
        return j10.j();
    }

    public j(jy jyVar) {
        this.f26172j = jyVar;
    }

    private String j(List<com.bytedance.sdk.component.cw.xt.vl> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i6 = 0; i6 < size; i6++) {
            if (i6 > 0) {
                sb.append("; ");
            }
            com.bytedance.sdk.component.cw.xt.vl vlVar = list.get(i6);
            sb.append(vlVar.j());
            sb.append('=');
            sb.append(vlVar.xt());
        }
        return sb.toString();
    }
}
