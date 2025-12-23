package com.bytedance.sdk.component.cw.xt.j.xt;

import com.bytedance.sdk.component.cw.j.vl;
import com.bytedance.sdk.component.cw.xt.av;
import com.bytedance.sdk.component.cw.xt.g;
import com.bytedance.sdk.component.cw.xt.i;
import com.bytedance.sdk.component.cw.xt.j.up.ae;
import com.bytedance.sdk.component.cw.xt.kt;
import com.bytedance.sdk.component.cw.xt.la;
import com.bytedance.sdk.component.cw.xt.mi;
import com.bytedance.sdk.component.cw.xt.oq;
import com.bytedance.sdk.component.cw.xt.p;
import com.bytedance.sdk.component.cw.xt.qv;
import com.bytedance.sdk.component.cw.xt.s;
import com.bytedance.sdk.component.cw.xt.v;
import com.bytedance.sdk.component.cw.xt.x;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;

/* loaded from: D:\Downloads\app\classes4.dex */
public final class cw extends ae.xt implements g {
    private final oq ae;
    private com.bytedance.sdk.component.cw.j.r az;

    /* renamed from: g, reason: collision with root package name */
    private Socket f26310g;

    /* renamed from: j, reason: collision with root package name */
    public boolean f26311j;
    private com.bytedance.sdk.component.cw.xt.j.up.ae jy;
    private Socket oq;
    private i qv;
    private final la tl;
    private x vl;
    private com.bytedance.sdk.component.cw.j.up ws;
    public int xt;
    public int cw = 1;

    /* renamed from: r, reason: collision with root package name */
    public final List<Reference<ae>> f26312r = new ArrayList();
    public long up = Long.MAX_VALUE;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00c5 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Type inference failed for: r1v15, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v2, types: [javax.net.ssl.SSLSocketFactory] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void j(int r11, int r12, int r13, boolean r14, com.bytedance.sdk.component.cw.xt.up r15, com.bytedance.sdk.component.cw.xt.av r16) {
        /*
            Method dump skipped, instructions count: 273
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.cw.xt.j.xt.cw.j(int, int, int, boolean, com.bytedance.sdk.component.cw.xt.up, com.bytedance.sdk.component.cw.xt.av):void");
    }

    private s m() {
        return new s.j().j(this.tl.j().j()).j("Host", com.bytedance.sdk.component.cw.xt.j.cw.j(this.tl.j().j(), true)).j("Proxy-Connection", "Keep-Alive").j("User-Agent", com.bytedance.sdk.component.cw.xt.j.r.j()).j();
    }

    public Socket cw() {
        return this.oq;
    }

    public i r() {
        return this.qv;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Connection{");
        sb.append(this.tl.j().j().ae());
        sb.append(":");
        sb.append(this.tl.j().j().tl());
        sb.append(", proxy=");
        sb.append(this.tl.xt());
        sb.append(" hostAddress=");
        sb.append(this.tl.cw());
        sb.append(" cipherSuite=");
        i iVar = this.qv;
        sb.append(iVar != null ? iVar.xt() : "none");
        sb.append(" protocol=");
        sb.append(this.vl);
        sb.append('}');
        return sb.toString();
    }

    public boolean up() {
        return this.jy != null;
    }

    public void xt() {
        com.bytedance.sdk.component.cw.xt.j.cw.j(this.f26310g);
    }

    public cw(oq oqVar, la laVar) {
        this.ae = oqVar;
        this.tl = laVar;
    }

    private void j(int i6, int i7, int i8, com.bytedance.sdk.component.cw.xt.up upVar, av avVar) throws IOException {
        s m6 = m();
        mi j6 = m6.j();
        for (int i9 = 0; i9 < 21; i9++) {
            j(i6, i7, upVar, avVar);
            m6 = j(i7, i8, m6, j6);
            if (m6 == null) {
                return;
            }
            com.bytedance.sdk.component.cw.xt.j.cw.j(this.f26310g);
            this.f26310g = null;
            this.az = null;
            this.ws = null;
        }
    }

    private void j(int i6, int i7, com.bytedance.sdk.component.cw.xt.up upVar, av avVar) throws IOException {
        Proxy xt = this.tl.xt();
        Socket createSocket = (xt.type() == Proxy.Type.DIRECT || xt.type() == Proxy.Type.HTTP) ? this.tl.j().cw().createSocket() : new Socket(xt);
        this.f26310g = createSocket;
        createSocket.setSoTimeout(i7);
        try {
            com.bytedance.sdk.component.cw.xt.j.ae.up.xt().j(this.f26310g, this.tl.cw(), i6);
            try {
                this.ws = vl.j(vl.xt(this.f26310g));
                this.az = vl.j(vl.j(this.f26310g));
            } catch (NullPointerException e6) {
                if ("throw with null exception".equals(e6.getMessage())) {
                    throw new IOException(e6);
                }
            }
        } catch (ConnectException e7) {
            ConnectException connectException = new ConnectException("Failed to connect to " + this.tl.cw());
            connectException.initCause(e7);
            throw connectException;
        }
    }

    private void j(xt xtVar, com.bytedance.sdk.component.cw.xt.up upVar, av avVar) throws IOException {
        if (this.tl.j().g() == null) {
            this.vl = x.HTTP_1_1;
            this.oq = this.f26310g;
            return;
        }
        j(xtVar);
        try {
            if (this.vl == x.HTTP_2) {
                this.oq.setSoTimeout(0);
                com.bytedance.sdk.component.cw.xt.j.up.ae j6 = new ae.j(true).j(this.oq, this.tl.j().j().ae(), this.ws, this.az).j(this).j();
                this.jy = j6;
                j6.cw();
            }
        } catch (Throwable unused) {
        }
    }

    private void j(xt xtVar) throws IOException {
        com.bytedance.sdk.component.cw.xt.j j6 = this.tl.j();
        SSLSocket sSLSocket = null;
        try {
            try {
                SSLSocket sSLSocket2 = (SSLSocket) j6.g().createSocket(this.f26310g, j6.j().ae(), j6.j().tl(), true);
                try {
                    qv j7 = xtVar.j(sSLSocket2);
                    if (j7.r()) {
                        com.bytedance.sdk.component.cw.xt.j.ae.up.xt().j(sSLSocket2, j6.j().ae(), j6.up());
                    }
                    try {
                        sSLSocket2.startHandshake();
                    } catch (Throwable unused) {
                    }
                    i j8 = i.j(sSLSocket2.getSession());
                    if (j6.oq().verify(j6.j().ae(), sSLSocket2.getSession())) {
                        j6.qv().j(j6.j().ae(), j8.cw());
                        String j9 = j7.r() ? com.bytedance.sdk.component.cw.xt.j.ae.up.xt().j(sSLSocket2) : null;
                        this.oq = sSLSocket2;
                        this.ws = vl.j(vl.xt(sSLSocket2));
                        this.az = vl.j(vl.j(this.oq));
                        this.qv = j8;
                        this.vl = j9 != null ? x.j(j9) : x.HTTP_1_1;
                        com.bytedance.sdk.component.cw.xt.j.ae.up.xt().xt(sSLSocket2);
                        return;
                    }
                    X509Certificate x509Certificate = (X509Certificate) j8.cw().get(0);
                    throw new SSLPeerUnverifiedException("Hostname " + j6.j().ae() + " not verified:\n    certificate: " + com.bytedance.sdk.component.cw.xt.ae.j((Certificate) x509Certificate) + "\n    DN: " + x509Certificate.getSubjectDN().getName() + "\n    subjectAltNames: " + com.bytedance.sdk.component.cw.xt.j.g.up.j(x509Certificate));
                } catch (AssertionError e6) {
                    e = e6;
                    if (!com.bytedance.sdk.component.cw.xt.j.cw.j(e)) {
                        throw e;
                    }
                    throw new IOException(e);
                } catch (Throwable th) {
                    th = th;
                    sSLSocket = sSLSocket2;
                    if (sSLSocket != null) {
                        com.bytedance.sdk.component.cw.xt.j.ae.up.xt().xt(sSLSocket);
                    }
                    com.bytedance.sdk.component.cw.xt.j.cw.j((Socket) sSLSocket);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (AssertionError e7) {
            e = e7;
        }
    }

    private s j(int i6, int i7, s sVar, mi miVar) throws IOException {
        String str = "CONNECT " + com.bytedance.sdk.component.cw.xt.j.cw.j(miVar, true) + " HTTP/1.1";
        while (true) {
            com.bytedance.sdk.component.cw.xt.j.r.j jVar = new com.bytedance.sdk.component.cw.xt.j.r.j(null, null, this.ws, this.az);
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            this.ws.j().j(i6, timeUnit);
            this.az.j().j(i7, timeUnit);
            jVar.j(sVar.cw(), str);
            jVar.xt();
            p j6 = jVar.j(false).j(sVar).j();
            long j7 = com.bytedance.sdk.component.cw.xt.j.cw.up.j(j6);
            if (j7 == -1) {
                j7 = 0;
            }
            com.bytedance.sdk.component.cw.j.mi xt = jVar.xt(j7);
            com.bytedance.sdk.component.cw.xt.j.cw.xt(xt, Integer.MAX_VALUE, timeUnit);
            xt.close();
            int cw = j6.cw();
            if (cw == 200) {
                if (this.ws.cw().up() && this.az.cw().up()) {
                    return null;
                }
                throw new IOException("TLS tunnel buffered too many bytes!");
            }
            if (cw == 407) {
                s j8 = this.tl.j().r().j(this.tl, j6);
                if (j8 != null) {
                    if ("close".equalsIgnoreCase(j6.j("Connection"))) {
                        return j8;
                    }
                    sVar = j8;
                } else {
                    throw new IOException("Failed to authenticate with proxy");
                }
            } else {
                throw new IOException("Unexpected response code for CONNECT: " + j6.cw());
            }
        }
    }

    public boolean j(com.bytedance.sdk.component.cw.xt.j jVar, la laVar) {
        if (this.f26312r.size() >= this.cw || this.f26311j || !com.bytedance.sdk.component.cw.xt.j.j.f26187j.j(this.tl.j(), jVar)) {
            return false;
        }
        if (jVar.j().ae().equals(j().j().j().ae())) {
            return true;
        }
        if (this.jy == null || laVar == null) {
            return false;
        }
        Proxy.Type type = laVar.xt().type();
        Proxy.Type type2 = Proxy.Type.DIRECT;
        if (type != type2 || this.tl.xt().type() != type2 || !this.tl.cw().equals(laVar.cw()) || laVar.j().oq() != com.bytedance.sdk.component.cw.xt.j.g.up.f26185j || !j(jVar.j())) {
            return false;
        }
        try {
            jVar.qv().j(jVar.j().ae(), r().cw());
            return true;
        } catch (SSLPeerUnverifiedException unused) {
            return false;
        }
    }

    public boolean j(mi miVar) {
        if (miVar.tl() != this.tl.j().j().tl()) {
            return false;
        }
        if (miVar.ae().equals(this.tl.j().j().ae())) {
            return true;
        }
        return this.qv != null && com.bytedance.sdk.component.cw.xt.j.g.up.f26185j.j(miVar.ae(), (X509Certificate) this.qv.cw().get(0));
    }

    public com.bytedance.sdk.component.cw.xt.j.cw.cw j(v vVar, kt.j jVar, ae aeVar) throws SocketException {
        if (this.jy != null) {
            return new com.bytedance.sdk.component.cw.xt.j.up.m(vVar, jVar, aeVar, this.jy);
        }
        this.oq.setSoTimeout(jVar.cw());
        com.bytedance.sdk.component.cw.j.kt j6 = this.ws.j();
        long cw = jVar.cw();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        j6.j(cw, timeUnit);
        this.az.j().j(jVar.r(), timeUnit);
        return new com.bytedance.sdk.component.cw.xt.j.r.j(vVar, aeVar, this.ws, this.az);
    }

    @Override // com.bytedance.sdk.component.cw.xt.g
    public la j() {
        return this.tl;
    }

    public boolean j(boolean z5) {
        if (this.oq.isClosed() || this.oq.isInputShutdown() || this.oq.isOutputShutdown()) {
            return false;
        }
        com.bytedance.sdk.component.cw.xt.j.up.ae aeVar = this.jy;
        if (aeVar != null) {
            return !aeVar.r();
        }
        if (z5) {
            try {
                int soTimeout = this.oq.getSoTimeout();
                try {
                    this.oq.setSoTimeout(1);
                    return !this.ws.up();
                } finally {
                    this.oq.setSoTimeout(soTimeout);
                }
            } catch (SocketTimeoutException unused) {
            } catch (IOException unused2) {
                return false;
            }
        }
        return true;
    }

    @Override // com.bytedance.sdk.component.cw.xt.j.up.ae.xt
    public void j(com.bytedance.sdk.component.cw.xt.j.up.g gVar) throws IOException {
        gVar.j(com.bytedance.sdk.component.cw.xt.j.up.xt.REFUSED_STREAM);
    }

    @Override // com.bytedance.sdk.component.cw.xt.j.up.ae.xt
    public void j(com.bytedance.sdk.component.cw.xt.j.up.ae aeVar) {
        synchronized (this.ae) {
            this.cw = aeVar.j();
        }
    }
}
