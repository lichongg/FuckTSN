package com.bytedance.sdk.component.cw.xt;

import android.os.Bundle;
import com.bytedance.sdk.component.cw.xt.av;
import com.bytedance.sdk.component.cw.xt.p;
import com.bytedance.sdk.component.cw.xt.w;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import org.apache.commons.net.imap.b;

/* loaded from: D:\Downloads\app\classes4.dex */
public class v implements Cloneable {

    /* renamed from: j, reason: collision with root package name */
    static final List<x> f26377j = com.bytedance.sdk.component.cw.xt.j.cw.j(x.HTTP_2, x.HTTP_1_1);
    static final List<qv> xt = com.bytedance.sdk.component.cw.xt.j.cw.j(qv.f26350j, qv.cw);

    /* renamed from: a, reason: collision with root package name */
    final int f26378a;
    final List<kt> ae;
    final com.bytedance.sdk.component.cw.xt.j.g.cw av;
    final SSLSocketFactory az;
    final boolean ch;
    final ws cw;

    /* renamed from: f, reason: collision with root package name */
    final az f26379f;

    /* renamed from: g, reason: collision with root package name */
    final av.j f26380g;

    /* renamed from: h, reason: collision with root package name */
    public Set<String> f26381h;

    /* renamed from: i, reason: collision with root package name */
    final HostnameVerifier f26382i;
    final com.bytedance.sdk.component.cw.xt.j.j.m jy;
    final xt kt;

    /* renamed from: l, reason: collision with root package name */
    final int f26383l;

    /* renamed from: m, reason: collision with root package name */
    final List<qv> f26384m;
    final xt mi;
    final ProxySelector oq;

    /* renamed from: p, reason: collision with root package name */
    final int f26385p;
    final jy qv;

    /* renamed from: r, reason: collision with root package name */
    final Proxy f26386r;

    /* renamed from: s, reason: collision with root package name */
    final int f26387s;
    final oq tj;
    final List<kt> tl;
    final List<x> up;

    /* renamed from: v, reason: collision with root package name */
    final boolean f26388v;
    final cw vl;

    /* renamed from: w, reason: collision with root package name */
    final ae f26389w;
    final SocketFactory ws;

    /* renamed from: x, reason: collision with root package name */
    final boolean f26390x;

    public static final class j {

        /* renamed from: a, reason: collision with root package name */
        int f26391a;
        av.j ae;
        ae av;
        HostnameVerifier az;
        public int ch;
        public List<x> cw;

        /* renamed from: f, reason: collision with root package name */
        boolean f26392f;

        /* renamed from: g, reason: collision with root package name */
        jy f26393g;
        public TimeUnit gq;

        /* renamed from: h, reason: collision with root package name */
        public TimeUnit f26394h;

        /* renamed from: i, reason: collision with root package name */
        xt f26395i;

        /* renamed from: j, reason: collision with root package name */
        ws f26396j;
        SSLSocketFactory jy;
        az kt;

        /* renamed from: l, reason: collision with root package name */
        public Bundle f26397l;
        public TimeUnit la;

        /* renamed from: m, reason: collision with root package name */
        final List<kt> f26398m;
        oq mi;
        cw oq;

        /* renamed from: p, reason: collision with root package name */
        public Set<String> f26399p;
        com.bytedance.sdk.component.cw.xt.j.j.m qv;

        /* renamed from: r, reason: collision with root package name */
        List<qv> f26400r;

        /* renamed from: s, reason: collision with root package name */
        public int f26401s;
        boolean tj;
        ProxySelector tl;
        public final List<kt> up;

        /* renamed from: v, reason: collision with root package name */
        boolean f26402v;
        SocketFactory vl;

        /* renamed from: w, reason: collision with root package name */
        xt f26403w;
        com.bytedance.sdk.component.cw.xt.j.g.cw ws;

        /* renamed from: x, reason: collision with root package name */
        public int f26404x;
        Proxy xt;

        public j() {
            this("");
        }

        public j j(long j6, TimeUnit timeUnit) {
            this.f26404x = com.bytedance.sdk.component.cw.xt.j.cw.j("timeout", j6, timeUnit);
            return this;
        }

        public j(String str) {
            this.up = new ArrayList();
            this.f26398m = new ArrayList();
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            this.f26394h = timeUnit;
            this.la = timeUnit;
            this.gq = timeUnit;
            this.f26396j = new ws(str);
            this.cw = v.f26377j;
            this.f26400r = v.xt;
            this.ae = av.j(av.f26119j);
            this.tl = ProxySelector.getDefault();
            this.f26393g = jy.f26322j;
            this.vl = SocketFactory.getDefault();
            this.az = com.bytedance.sdk.component.cw.xt.j.g.up.f26185j;
            this.av = ae.f26115j;
            xt xtVar = xt.f26417j;
            this.f26395i = xtVar;
            this.f26403w = xtVar;
            this.mi = new oq();
            this.kt = az.f26121j;
            this.tj = true;
            this.f26392f = true;
            this.f26402v = true;
            this.f26404x = 10000;
            this.ch = 10000;
            this.f26401s = 10000;
            this.f26391a = 0;
        }

        public j cw(long j6, TimeUnit timeUnit) {
            this.f26401s = com.bytedance.sdk.component.cw.xt.j.cw.j("timeout", j6, timeUnit);
            return this;
        }

        public j j(kt ktVar) {
            if (ktVar == null) {
                throw new IllegalArgumentException("interceptor == null");
            }
            this.up.add(ktVar);
            return this;
        }

        public j xt(long j6, TimeUnit timeUnit) {
            this.ch = com.bytedance.sdk.component.cw.xt.j.cw.j("timeout", j6, timeUnit);
            return this;
        }

        public j j(av avVar) {
            if (avVar != null) {
                this.ae = av.j(avVar);
                return this;
            }
            throw new NullPointerException("eventListener == null");
        }

        public j j(Set<String> set) {
            this.f26399p = set;
            return this;
        }

        public v j() {
            return new v(this);
        }
    }

    static {
        com.bytedance.sdk.component.cw.xt.j.j.f26187j = new com.bytedance.sdk.component.cw.xt.j.j() { // from class: com.bytedance.sdk.component.cw.xt.v.1
            @Override // com.bytedance.sdk.component.cw.xt.j.j
            public void j(w.j jVar, String str) {
                jVar.j(str);
            }

            @Override // com.bytedance.sdk.component.cw.xt.j.j
            public void j(w.j jVar, String str, String str2) {
                jVar.xt(str, str2);
            }

            @Override // com.bytedance.sdk.component.cw.xt.j.j
            public boolean j(oq oqVar, com.bytedance.sdk.component.cw.xt.j.xt.cw cwVar) {
                return oqVar.xt(cwVar);
            }

            @Override // com.bytedance.sdk.component.cw.xt.j.j
            public void xt(oq oqVar, com.bytedance.sdk.component.cw.xt.j.xt.cw cwVar) {
                oqVar.j(cwVar);
            }

            @Override // com.bytedance.sdk.component.cw.xt.j.j
            public com.bytedance.sdk.component.cw.xt.j.xt.cw j(oq oqVar, com.bytedance.sdk.component.cw.xt.j jVar, com.bytedance.sdk.component.cw.xt.j.xt.ae aeVar, la laVar) {
                return oqVar.j(jVar, aeVar, laVar);
            }

            @Override // com.bytedance.sdk.component.cw.xt.j.j
            public boolean j(com.bytedance.sdk.component.cw.xt.j jVar, com.bytedance.sdk.component.cw.xt.j jVar2) {
                return jVar.j(jVar2);
            }

            @Override // com.bytedance.sdk.component.cw.xt.j.j
            public Socket j(oq oqVar, com.bytedance.sdk.component.cw.xt.j jVar, com.bytedance.sdk.component.cw.xt.j.xt.ae aeVar) {
                return oqVar.j(jVar, aeVar);
            }

            @Override // com.bytedance.sdk.component.cw.xt.j.j
            public com.bytedance.sdk.component.cw.xt.j.xt.r j(oq oqVar) {
                return oqVar.f26339j;
            }

            @Override // com.bytedance.sdk.component.cw.xt.j.j
            public int j(p.j jVar) {
                return jVar.cw;
            }

            @Override // com.bytedance.sdk.component.cw.xt.j.j
            public void j(qv qvVar, SSLSocket sSLSocket, boolean z5) {
                qvVar.j(sSLSocket, z5);
            }
        };
    }

    public v() {
        this(new j());
    }

    private SSLSocketFactory j(X509TrustManager x509TrustManager) {
        try {
            SSLContext sSLContext = SSLContext.getInstance(b.Q);
            sSLContext.init(null, new TrustManager[]{x509TrustManager}, null);
            return sSLContext.getSocketFactory();
        } catch (GeneralSecurityException e6) {
            throw com.bytedance.sdk.component.cw.xt.j.cw.j("No System TLS", (Exception) e6);
        }
    }

    v(j jVar) {
        boolean z5;
        this.cw = jVar.f26396j;
        this.f26386r = jVar.xt;
        this.up = jVar.cw;
        List<qv> list = jVar.f26400r;
        this.f26384m = list;
        this.ae = com.bytedance.sdk.component.cw.xt.j.cw.j(jVar.up);
        this.tl = com.bytedance.sdk.component.cw.xt.j.cw.j(jVar.f26398m);
        this.f26380g = jVar.ae;
        this.oq = jVar.tl;
        this.qv = jVar.f26393g;
        this.vl = jVar.oq;
        this.jy = jVar.qv;
        this.ws = jVar.vl;
        this.f26381h = jVar.f26399p;
        Iterator<qv> it = list.iterator();
        loop0: while (true) {
            while (it.hasNext()) {
                z5 = z5 || it.next().j();
            }
        }
        SSLSocketFactory sSLSocketFactory = jVar.jy;
        if (sSLSocketFactory == null && z5) {
            X509TrustManager ch = ch();
            this.az = j(ch);
            this.av = com.bytedance.sdk.component.cw.xt.j.g.cw.j(ch);
        } else {
            this.az = sSLSocketFactory;
            this.av = jVar.ws;
        }
        this.f26382i = jVar.az;
        this.f26389w = jVar.av.j(this.av);
        this.mi = jVar.f26395i;
        this.kt = jVar.f26403w;
        oq oqVar = jVar.mi;
        this.tj = oqVar;
        if (oqVar != null) {
            oqVar.j(jVar.f26397l);
        }
        this.f26379f = jVar.kt;
        this.f26388v = jVar.tj;
        this.f26390x = jVar.f26392f;
        this.ch = jVar.f26402v;
        this.f26387s = jVar.f26404x;
        this.f26378a = jVar.ch;
        this.f26383l = jVar.f26401s;
        this.f26385p = jVar.f26391a;
        if (this.ae.contains(null)) {
            throw new IllegalStateException("Null interceptor: " + this.ae);
        }
        if (this.tl.contains(null)) {
            throw new IllegalStateException("Null network interceptor: " + this.tl);
        }
    }

    com.bytedance.sdk.component.cw.xt.j.j.m ae() {
        cw cwVar = this.vl;
        return cwVar != null ? cwVar.f26126j : this.jy;
    }

    public boolean av() {
        return this.f26388v;
    }

    public oq az() {
        return this.tj;
    }

    public int cw() {
        return this.f26383l;
    }

    public List<kt> f() {
        return this.ae;
    }

    public SocketFactory g() {
        return this.ws;
    }

    public boolean i() {
        return this.f26390x;
    }

    public xt jy() {
        return this.kt;
    }

    public List<x> kt() {
        return this.up;
    }

    public jy m() {
        return this.qv;
    }

    public ws mi() {
        return this.cw;
    }

    public SSLSocketFactory oq() {
        return this.az;
    }

    public HostnameVerifier qv() {
        return this.f26382i;
    }

    public Proxy r() {
        return this.f26386r;
    }

    public List<qv> tj() {
        return this.f26384m;
    }

    public az tl() {
        return this.f26379f;
    }

    public ProxySelector up() {
        return this.oq;
    }

    public List<kt> v() {
        return this.tl;
    }

    public ae vl() {
        return this.f26389w;
    }

    public boolean w() {
        return this.ch;
    }

    public xt ws() {
        return this.mi;
    }

    public av.j x() {
        return this.f26380g;
    }

    public int xt() {
        return this.f26378a;
    }

    private X509TrustManager ch() {
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init((KeyStore) null);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            if (trustManagers.length == 1) {
                TrustManager trustManager = trustManagers[0];
                if (trustManager instanceof X509TrustManager) {
                    return (X509TrustManager) trustManager;
                }
            }
            throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
        } catch (GeneralSecurityException e6) {
            throw com.bytedance.sdk.component.cw.xt.j.cw.j("No System TLS", (Exception) e6);
        }
    }

    public int j() {
        return this.f26387s;
    }

    public up j(s sVar) {
        return ch.j(this, sVar, false);
    }
}
