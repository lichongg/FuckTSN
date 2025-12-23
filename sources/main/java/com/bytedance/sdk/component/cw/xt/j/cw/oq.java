package com.bytedance.sdk.component.cw.xt.j.cw;

import com.bytedance.sdk.component.cw.xt.a;
import com.bytedance.sdk.component.cw.xt.kt;
import com.bytedance.sdk.component.cw.xt.la;
import com.bytedance.sdk.component.cw.xt.mi;
import com.bytedance.sdk.component.cw.xt.p;
import com.bytedance.sdk.component.cw.xt.s;
import com.bytedance.sdk.component.cw.xt.v;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: D:\Downloads\app\classes4.dex */
public final class oq implements kt {
    private com.bytedance.sdk.component.cw.xt.j.xt.ae cw;

    /* renamed from: j, reason: collision with root package name */
    private final v f26173j;

    /* renamed from: r, reason: collision with root package name */
    private Object f26174r;
    private volatile boolean up;
    private final boolean xt;

    public void j() {
        this.up = true;
        com.bytedance.sdk.component.cw.xt.j.xt.ae aeVar = this.cw;
        if (aeVar != null) {
            aeVar.up();
        }
    }

    public boolean xt() {
        return this.up;
    }

    public oq(v vVar, boolean z5) {
        this.f26173j = vVar;
        this.xt = z5;
    }

    public void j(Object obj) {
        this.f26174r = obj;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x006b  */
    @Override // com.bytedance.sdk.component.cw.xt.kt
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.bytedance.sdk.component.cw.xt.p j(com.bytedance.sdk.component.cw.xt.kt.j r21) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 595
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.cw.xt.j.cw.oq.j(com.bytedance.sdk.component.cw.xt.kt$j):com.bytedance.sdk.component.cw.xt.p");
    }

    private com.bytedance.sdk.component.cw.xt.j j(mi miVar) {
        SSLSocketFactory sSLSocketFactory;
        HostnameVerifier hostnameVerifier;
        com.bytedance.sdk.component.cw.xt.ae aeVar;
        if (miVar.r()) {
            sSLSocketFactory = this.f26173j.oq();
            hostnameVerifier = this.f26173j.qv();
            aeVar = this.f26173j.vl();
        } else {
            sSLSocketFactory = null;
            hostnameVerifier = null;
            aeVar = null;
        }
        return new com.bytedance.sdk.component.cw.xt.j(miVar.ae(), miVar.tl(), this.f26173j.tl(), this.f26173j.g(), sSLSocketFactory, hostnameVerifier, aeVar, this.f26173j.ws(), this.f26173j.r(), this.f26173j.kt(), this.f26173j.tj(), this.f26173j.up());
    }

    private boolean j(IOException iOException, boolean z5, s sVar) {
        this.cw.j(iOException);
        if (this.f26173j.w()) {
            return !(z5 && (sVar.r() instanceof vl)) && j(iOException, z5) && this.cw.m();
        }
        return false;
    }

    private boolean j(IOException iOException, boolean z5) {
        if (iOException instanceof ProtocolException) {
            return false;
        }
        return iOException instanceof InterruptedIOException ? (iOException instanceof SocketTimeoutException) && !z5 : (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) ? false : true;
    }

    private s j(p pVar) throws IOException {
        String j6;
        mi cw;
        Proxy r5;
        if (pVar != null) {
            com.bytedance.sdk.component.cw.xt.j.xt.cw xt = this.cw.xt();
            la j7 = xt != null ? xt.j() : null;
            int cw2 = pVar.cw();
            String xt2 = pVar.j().xt();
            if (cw2 == 307 || cw2 == 308) {
                if (!xt2.equals("GET") && !xt2.equals("HEAD")) {
                    return null;
                }
            } else {
                if (cw2 == 401) {
                    return this.f26173j.jy().j(j7, pVar);
                }
                if (cw2 == 407) {
                    if (j7 != null) {
                        r5 = j7.xt();
                    } else {
                        r5 = this.f26173j.r();
                    }
                    if (r5.type() == Proxy.Type.HTTP) {
                        return this.f26173j.ws().j(j7, pVar);
                    }
                    throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                }
                if (cw2 == 408) {
                    if (!this.f26173j.w() || (pVar.j().r() instanceof vl)) {
                        return null;
                    }
                    if (pVar.qv() == null || pVar.qv().cw() != 408) {
                        return pVar.j();
                    }
                    return null;
                }
                switch (cw2) {
                    case 300:
                    case 301:
                    case 302:
                    case 303:
                        break;
                    default:
                        return null;
                }
            }
            if (!this.f26173j.i() || (j6 = pVar.j("Location")) == null || (cw = pVar.j().j().cw(j6)) == null) {
                return null;
            }
            if (!cw.cw().equals(pVar.j().j().cw()) && !this.f26173j.av()) {
                return null;
            }
            s.j m6 = pVar.j().m();
            if (m.cw(xt2)) {
                boolean r6 = m.r(xt2);
                if (m.up(xt2)) {
                    m6.j("GET", (a) null);
                } else {
                    m6.j(xt2, r6 ? pVar.j().r() : null);
                }
                if (!r6) {
                    m6.xt("Transfer-Encoding");
                    m6.xt("Content-Length");
                    m6.xt("Content-Type");
                }
            }
            if (!j(pVar, cw)) {
                m6.xt("Authorization");
            }
            return m6.j(cw).j();
        }
        throw new IllegalStateException();
    }

    private boolean j(p pVar, mi miVar) {
        mi j6 = pVar.j().j();
        return j6.ae().equals(miVar.ae()) && j6.tl() == miVar.tl() && j6.cw().equals(miVar.cw());
    }
}
