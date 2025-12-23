package com.amap.api.col.p0003l;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.amap.api.col.p0003l.Cif;
import com.amap.api.col.p0003l.g4;
import com.amap.api.col.p0003l.r6;
import com.amap.api.services.core.AMapException;
import com.huawei.hms.framework.common.ContainerUtils;
import com.umeng.analytics.pro.o;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.SoftReference;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLKeyException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSession;
import org.apache.http.conn.ConnectTimeoutException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class w6 {

    /* renamed from: t, reason: collision with root package name */
    private static SoftReference<SSLContext> f7534t;

    /* renamed from: u, reason: collision with root package name */
    private static SoftReference<x6> f7535u;

    /* renamed from: a, reason: collision with root package name */
    private boolean f7536a;

    /* renamed from: b, reason: collision with root package name */
    private SSLContext f7537b;

    /* renamed from: c, reason: collision with root package name */
    private Proxy f7538c;

    /* renamed from: g, reason: collision with root package name */
    private String f7542g;

    /* renamed from: h, reason: collision with root package name */
    private r6.a f7543h;

    /* renamed from: i, reason: collision with root package name */
    private d f7544i;

    /* renamed from: k, reason: collision with root package name */
    private boolean f7546k;

    /* renamed from: l, reason: collision with root package name */
    private String f7547l;

    /* renamed from: m, reason: collision with root package name */
    private String f7548m;

    /* renamed from: d, reason: collision with root package name */
    private volatile boolean f7539d = false;

    /* renamed from: e, reason: collision with root package name */
    private long f7540e = -1;

    /* renamed from: f, reason: collision with root package name */
    private long f7541f = 0;

    /* renamed from: j, reason: collision with root package name */
    private String f7545j = "";

    /* renamed from: n, reason: collision with root package name */
    private boolean f7549n = false;

    /* renamed from: o, reason: collision with root package name */
    private boolean f7550o = false;

    /* renamed from: p, reason: collision with root package name */
    private String f7551p = "";

    /* renamed from: q, reason: collision with root package name */
    private String f7552q = "";

    /* renamed from: r, reason: collision with root package name */
    private String f7553r = "";

    /* renamed from: s, reason: collision with root package name */
    private f f7554s = new f();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a implements Cloneable, Comparable {

        /* renamed from: a, reason: collision with root package name */
        public int f7555a;

        /* renamed from: b, reason: collision with root package name */
        public String f7556b;

        /* renamed from: c, reason: collision with root package name */
        public String f7557c;

        /* renamed from: d, reason: collision with root package name */
        public String f7558d;

        /* renamed from: e, reason: collision with root package name */
        public String f7559e;

        /* renamed from: f, reason: collision with root package name */
        public int f7560f;

        /* renamed from: g, reason: collision with root package name */
        public int f7561g;

        /* renamed from: h, reason: collision with root package name */
        public int f7562h;

        /* renamed from: i, reason: collision with root package name */
        public long f7563i;

        /* renamed from: j, reason: collision with root package name */
        public volatile AtomicInteger f7564j = new AtomicInteger(1);

        public final String b() {
            String str;
            String str2;
            String str3;
            String str4;
            try {
                String str5 = this.f7560f + "#";
                if (TextUtils.isEmpty(this.f7559e)) {
                    str = str5 + "-#";
                } else {
                    str = str5 + this.f7559e + "#";
                }
                String str6 = (str + this.f7562h + "#") + this.f7564j + "#";
                if (TextUtils.isEmpty(this.f7556b)) {
                    str2 = str6 + "-#";
                } else {
                    str2 = str6 + this.f7556b + "#";
                }
                if (this.f7560f == 1) {
                    str3 = str2 + this.f7558d + "#";
                } else {
                    str3 = str2 + "-#";
                }
                if (this.f7560f == 1) {
                    str4 = str3 + this.f7563i + "#";
                } else {
                    str4 = str3 + "-#";
                }
                String f6 = j4.f(n6.a(((str4 + this.f7557c + "#") + this.f7561g).getBytes(), "YXBtX25ldHdvcmtf".getBytes()));
                w6.s();
                return f6;
            } catch (Exception unused) {
                return null;
            }
        }

        @Override // java.lang.Comparable
        public final int compareTo(Object obj) {
            return this.f7555a - ((a) obj).f7555a;
        }

        public a(c cVar) {
            this.f7556b = cVar.f7569c;
            this.f7557c = cVar.f7571e;
            this.f7559e = cVar.f7570d;
            this.f7560f = cVar.f7579m;
            this.f7561g = cVar.f7580n;
            this.f7562h = cVar.f7568b.a();
            this.f7558d = cVar.f7567a;
            this.f7563i = cVar.f7572f;
            if (this.f7560f == 10) {
                this.f7555a = 0;
            }
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final a clone() {
            try {
                return (a) super.clone();
            } catch (CloneNotSupportedException unused) {
                return null;
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class c implements Cloneable {

        /* renamed from: a, reason: collision with root package name */
        public String f7567a = "";

        /* renamed from: b, reason: collision with root package name */
        public Cif.b f7568b = Cif.b.FIRST_NONDEGRADE;

        /* renamed from: c, reason: collision with root package name */
        public String f7569c = "";

        /* renamed from: d, reason: collision with root package name */
        public String f7570d = "";

        /* renamed from: e, reason: collision with root package name */
        public String f7571e = "";

        /* renamed from: f, reason: collision with root package name */
        public long f7572f = 0;

        /* renamed from: g, reason: collision with root package name */
        public long f7573g = 0;

        /* renamed from: h, reason: collision with root package name */
        public long f7574h = 0;

        /* renamed from: i, reason: collision with root package name */
        public long f7575i = 0;

        /* renamed from: j, reason: collision with root package name */
        public long f7576j = 0;

        /* renamed from: k, reason: collision with root package name */
        public String f7577k = "-";

        /* renamed from: l, reason: collision with root package name */
        public String f7578l = "-";

        /* renamed from: m, reason: collision with root package name */
        public int f7579m = 0;

        /* renamed from: n, reason: collision with root package name */
        public int f7580n = 0;

        protected final String b() {
            String str;
            String str2;
            if (TextUtils.isEmpty(this.f7569c)) {
                str = "-#";
            } else {
                str = this.f7569c + "#";
            }
            if (TextUtils.isEmpty(this.f7570d)) {
                str2 = str + "-#";
            } else {
                str2 = str + this.f7570d + "#";
            }
            String f6 = j4.f(n6.a(((((str2 + this.f7568b.a() + "#") + this.f7574h + "#") + this.f7576j + "#") + this.f7572f).getBytes(), "YXBtX25ldHdvcmtf".getBytes()));
            w6.s();
            return f6;
        }

        public final String toString() {
            return "RequestInfo{csid='" + this.f7567a + "', degradeType=" + this.f7568b + ", serverIp='" + this.f7569c + "', path='" + this.f7570d + "', hostname='" + this.f7571e + "', totalTime=" + this.f7572f + ", DNSTime=" + this.f7573g + ", connectionTime=" + this.f7574h + ", writeTime=" + this.f7575i + ", readTime=" + this.f7576j + ", serverTime='" + this.f7577k + "', datasize='" + this.f7578l + "', errorcode=" + this.f7579m + ", errorcodeSub=" + this.f7580n + '}';
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final c clone() {
            try {
                return (c) super.clone();
            } catch (CloneNotSupportedException unused) {
                return null;
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class e implements HostnameVerifier {

        /* renamed from: a, reason: collision with root package name */
        private String f7583a;

        /* renamed from: b, reason: collision with root package name */
        private String f7584b;

        private e() {
        }

        /* synthetic */ e(byte b6) {
            this();
        }

        public final String a() {
            return this.f7584b;
        }

        public final void b(String str) {
            String[] split;
            if (TextUtils.isEmpty(this.f7583a) || !str.contains(":") || (split = str.split(":")) == null || split.length <= 0) {
                this.f7583a = str;
            } else {
                this.f7583a = split[0];
            }
        }

        public final void c(String str) {
            this.f7584b = str;
        }

        @Override // javax.net.ssl.HostnameVerifier
        public final boolean verify(String str, SSLSession sSLSession) {
            HostnameVerifier defaultHostnameVerifier = HttpsURLConnection.getDefaultHostnameVerifier();
            if (!TextUtils.isEmpty(this.f7583a)) {
                return this.f7583a.equals(str);
            }
            if (!TextUtils.isEmpty(this.f7584b)) {
                return defaultHostnameVerifier.verify(this.f7584b, sSLSession);
            }
            return defaultHostnameVerifier.verify(str, sSLSession);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class f {

        /* renamed from: a, reason: collision with root package name */
        long f7585a = 0;

        /* renamed from: b, reason: collision with root package name */
        long f7586b = 0;

        /* renamed from: c, reason: collision with root package name */
        c f7587c = new c();

        /* renamed from: d, reason: collision with root package name */
        a f7588d;

        /* renamed from: e, reason: collision with root package name */
        c f7589e;

        /* renamed from: f, reason: collision with root package name */
        String f7590f;

        /* renamed from: g, reason: collision with root package name */
        URL f7591g;

        f() {
        }

        public final void a() {
            this.f7587c.f7574h = SystemClock.elapsedRealtime() - this.f7586b;
        }

        public final void b(int i6) {
            "----errorcode-----".concat(String.valueOf(i6));
            w6.s();
            try {
                this.f7587c.f7572f = SystemClock.elapsedRealtime() - this.f7585a;
                c cVar = this.f7587c;
                cVar.f7579m = i6;
                if (cVar.f7568b.e()) {
                    g4.u(false, this.f7587c.f7571e);
                }
                boolean v5 = w6.this.v(this.f7587c.f7571e);
                if (v5) {
                    if (w6.this.f7550o && !TextUtils.isEmpty(w6.this.f7548m) && this.f7587c.f7568b.b()) {
                        g4.L();
                    }
                    if (this.f7587c.f7568b.c()) {
                        g4.u(this.f7587c.f7568b.c(), this.f7587c.f7571e);
                    }
                    g4.J(this.f7589e);
                    g4.t(false, this.f7588d);
                    g4.E(this.f7587c);
                }
                g4.s(this.f7591g.toString(), this.f7587c.f7568b.c(), true, v5);
                this.f7587c.toString();
                w6.s();
            } catch (Throwable unused) {
            }
        }

        public final void c(long j6) {
            this.f7587c.f7578l = new DecimalFormat("0.00").format(j6 / 1024.0f);
        }

        public final void d(Cif cif, URL url) {
            this.f7591g = url;
            this.f7587c.f7570d = url.getPath();
            this.f7587c.f7571e = url.getHost();
            if (!TextUtils.isEmpty(w6.this.f7548m) && cif.getDegradeType().b()) {
                c cVar = this.f7587c;
                cVar.f7569c = cVar.f7571e.replace("[", "").replace("]", "");
                this.f7587c.f7571e = w6.this.f7548m;
            }
            if (cif.getDegradeType().b()) {
                cif.setNon_degrade_final_Host(this.f7587c.f7571e);
            }
            if (cif.getDegradeType().d()) {
                this.f7590f = cif.getNon_degrade_final_Host();
            }
        }

        public final void e(z6 z6Var) {
            c clone;
            try {
                this.f7587c.f7572f = SystemClock.elapsedRealtime() - this.f7585a;
                if (z6Var != null) {
                    z6Var.f7805f = this.f7587c.f7568b.c();
                }
                if (this.f7587c.f7568b.b()) {
                    c cVar = this.f7587c;
                    if (cVar.f7572f > 10000) {
                        g4.u(false, cVar.f7571e);
                    }
                }
                if (this.f7587c.f7568b.d()) {
                    g4.u(false, this.f7590f);
                }
                boolean v5 = w6.this.v(this.f7587c.f7571e);
                if (v5) {
                    g4.J(this.f7587c);
                    g4.t(true, this.f7588d);
                    c cVar2 = this.f7587c;
                    if (cVar2.f7572f > g4.f6305s && (clone = cVar2.clone()) != null) {
                        clone.f7579m = 1;
                        g4.E(clone);
                        clone.toString();
                        w6.s();
                    }
                }
                g4.s(this.f7591g.toString(), this.f7587c.f7568b.c(), false, v5);
                this.f7587c.toString();
                w6.s();
            } catch (Throwable unused) {
            }
        }

        public final void f() {
            this.f7587c.f7575i = SystemClock.elapsedRealtime() - this.f7586b;
        }

        public final void g(int i6) {
            this.f7587c.f7580n = i6;
        }

        public final void h() {
            this.f7587c.f7576j = SystemClock.elapsedRealtime() - this.f7586b;
        }

        public final void i() {
            c clone = this.f7587c.clone();
            if (this.f7587c.f7572f > g4.f6305s) {
                clone.f7579m = 1;
            }
            g4.o(clone);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0022 A[Catch: all -> 0x000c, TryCatch #0 {all -> 0x000c, blocks: (B:3:0x0001, B:5:0x0005, B:8:0x001e, B:10:0x0022, B:12:0x002e, B:18:0x000e), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002e A[Catch: all -> 0x000c, TRY_LEAVE, TryCatch #0 {all -> 0x000c, blocks: (B:3:0x0001, B:5:0x0005, B:8:0x001e, B:10:0x0022, B:12:0x002e, B:18:0x000e), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.amap.api.col.p0003l.x6 w() {
        /*
            r5 = this;
            r0 = 0
            java.lang.ref.SoftReference<com.amap.api.col.3l.x6> r1 = com.amap.api.col.p0003l.w6.f7535u     // Catch: java.lang.Throwable -> Lc
            if (r1 == 0) goto Le
            java.lang.Object r1 = r1.get()     // Catch: java.lang.Throwable -> Lc
            if (r1 != 0) goto L1e
            goto Le
        Lc:
            r1 = move-exception
            goto L38
        Le:
            java.lang.ref.SoftReference r1 = new java.lang.ref.SoftReference     // Catch: java.lang.Throwable -> Lc
            com.amap.api.col.3l.x6 r2 = new com.amap.api.col.3l.x6     // Catch: java.lang.Throwable -> Lc
            android.content.Context r3 = com.amap.api.col.p0003l.g4.f6293g     // Catch: java.lang.Throwable -> Lc
            javax.net.ssl.SSLContext r4 = r5.f7537b     // Catch: java.lang.Throwable -> Lc
            r2.<init>(r3, r4)     // Catch: java.lang.Throwable -> Lc
            r1.<init>(r2)     // Catch: java.lang.Throwable -> Lc
            com.amap.api.col.p0003l.w6.f7535u = r1     // Catch: java.lang.Throwable -> Lc
        L1e:
            java.lang.ref.SoftReference<javax.net.ssl.SSLContext> r1 = com.amap.api.col.p0003l.w6.f7534t     // Catch: java.lang.Throwable -> Lc
            if (r1 == 0) goto L2b
            java.lang.ref.SoftReference<com.amap.api.col.3l.x6> r1 = com.amap.api.col.p0003l.w6.f7535u     // Catch: java.lang.Throwable -> Lc
            java.lang.Object r1 = r1.get()     // Catch: java.lang.Throwable -> Lc
            com.amap.api.col.3l.x6 r1 = (com.amap.api.col.p0003l.x6) r1     // Catch: java.lang.Throwable -> Lc
            goto L2c
        L2b:
            r1 = r0
        L2c:
            if (r1 != 0) goto L37
            com.amap.api.col.3l.x6 r1 = new com.amap.api.col.3l.x6     // Catch: java.lang.Throwable -> Lc
            android.content.Context r2 = com.amap.api.col.p0003l.g4.f6293g     // Catch: java.lang.Throwable -> Lc
            javax.net.ssl.SSLContext r3 = r5.f7537b     // Catch: java.lang.Throwable -> Lc
            r1.<init>(r2, r3)     // Catch: java.lang.Throwable -> Lc
        L37:
            return r1
        L38:
            java.lang.String r2 = "ht"
            java.lang.String r3 = "gsf"
            com.amap.api.col.p0003l.v5.p(r1, r2, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003l.w6.w():com.amap.api.col.3l.x6");
    }

    final void k() {
        this.f7539d = true;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public HttpURLConnection f7565a;

        /* renamed from: b, reason: collision with root package name */
        public int f7566b = this.f7566b;

        /* renamed from: b, reason: collision with root package name */
        public int f7566b = this.f7566b;

        public b(HttpURLConnection httpURLConnection) {
            this.f7565a = httpURLConnection;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class d {

        /* renamed from: a, reason: collision with root package name */
        private Vector<e> f7581a;

        /* renamed from: b, reason: collision with root package name */
        private volatile e f7582b;

        private d() {
            this.f7581a = new Vector<>();
            this.f7582b = new e((byte) 0);
        }

        public final e a(String str) {
            if (TextUtils.isEmpty(str)) {
                return this.f7582b;
            }
            byte b6 = 0;
            for (int i6 = 0; i6 < this.f7581a.size(); i6++) {
                e eVar = this.f7581a.get(i6);
                if (eVar != null && eVar.a().equals(str)) {
                    return eVar;
                }
            }
            e eVar2 = new e(b6);
            eVar2.c(str);
            this.f7581a.add(eVar2);
            return eVar2;
        }

        /* synthetic */ d(byte b6) {
            this();
        }
    }

    private static int a(Exception exc) {
        if (exc instanceof SSLHandshakeException) {
            return o.a.f41398e;
        }
        if (exc instanceof SSLKeyException) {
            return o.a.f41399f;
        }
        if (exc instanceof SSLProtocolException) {
            return o.a.f41400g;
        }
        if (exc instanceof SSLPeerUnverifiedException) {
            return o.a.f41401h;
        }
        if (exc instanceof ConnectException) {
            return 6101;
        }
        if (exc instanceof SocketException) {
            return 6102;
        }
        return exc instanceof ConnectTimeoutException ? AMapException.CODE_AMAP_NEARBY_KEY_NOT_BIND : exc instanceof SocketTimeoutException ? 2102 : 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0273  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0282  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01e5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0201 A[Catch: all -> 0x01f0, TRY_LEAVE, TryCatch #1 {all -> 0x01f0, blocks: (B:107:0x01e5, B:109:0x01e9, B:112:0x01fd, B:114:0x0201, B:133:0x01f2), top: B:106:0x01e5 }] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x020b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0140 A[Catch: all -> 0x00f5, TryCatch #2 {all -> 0x00f5, blocks: (B:30:0x00c8, B:33:0x00e0, B:35:0x00e3, B:37:0x00e7, B:39:0x00ed, B:42:0x00f9, B:45:0x0105, B:47:0x0108, B:51:0x010e, B:52:0x013a, B:54:0x0140, B:56:0x014a, B:57:0x015b, B:59:0x0183, B:61:0x01a4, B:62:0x01a7, B:49:0x0124, B:67:0x0128, B:69:0x012b, B:73:0x0131, B:71:0x0136), top: B:29:0x00c8 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0183 A[Catch: all -> 0x00f5, TryCatch #2 {all -> 0x00f5, blocks: (B:30:0x00c8, B:33:0x00e0, B:35:0x00e3, B:37:0x00e7, B:39:0x00ed, B:42:0x00f9, B:45:0x0105, B:47:0x0108, B:51:0x010e, B:52:0x013a, B:54:0x0140, B:56:0x014a, B:57:0x015b, B:59:0x0183, B:61:0x01a4, B:62:0x01a7, B:49:0x0124, B:67:0x0128, B:69:0x012b, B:73:0x0131, B:71:0x0136), top: B:29:0x00c8 }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x024f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.amap.api.col.3l.w6.b b(com.amap.api.col.p0003l.Cif r17, boolean r18, boolean r19) throws java.io.IOException, com.amap.api.col.p0003l.fk {
        /*
            Method dump skipped, instructions count: 656
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003l.w6.b(com.amap.api.col.3l.if, boolean, boolean):com.amap.api.col.3l.w6$b");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0235 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:111:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:112:0x022b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0221 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0217 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0197 A[Catch: all -> 0x0035, IOException -> 0x003c, SocketTimeoutException -> 0x0042, ConnectTimeoutException -> 0x0048, TRY_ENTER, TryCatch #20 {SocketTimeoutException -> 0x0042, ConnectTimeoutException -> 0x0048, IOException -> 0x003c, all -> 0x0035, blocks: (B:3:0x0009, B:5:0x001d, B:7:0x0027, B:9:0x002d, B:10:0x004e, B:32:0x00c5, B:148:0x0197, B:149:0x01e3), top: B:2:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00c5 A[Catch: all -> 0x0035, IOException -> 0x003c, SocketTimeoutException -> 0x0042, ConnectTimeoutException -> 0x0048, TRY_ENTER, TRY_LEAVE, TryCatch #20 {SocketTimeoutException -> 0x0042, ConnectTimeoutException -> 0x0048, IOException -> 0x003c, all -> 0x0035, blocks: (B:3:0x0009, B:5:0x001d, B:7:0x0027, B:9:0x002d, B:10:0x004e, B:32:0x00c5, B:148:0x0197, B:149:0x01e3), top: B:2:0x0009 }] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.amap.api.col.p0003l.z6 c(com.amap.api.col.3l.w6.b r17, boolean r18) throws com.amap.api.col.p0003l.fk, java.io.IOException {
        /*
            Method dump skipped, instructions count: 574
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003l.w6.c(com.amap.api.col.3l.w6$b, boolean):com.amap.api.col.3l.z6");
    }

    private static String f(String str, String str2) {
        Context context = g4.f6293g;
        return String.format("platform=Android&sdkversion=%s&product=%s&manufacture=%s&abitype=%s", str, str2, Build.MANUFACTURER, context != null ? q4.d(context) : "");
    }

    private static String h(HttpURLConnection httpURLConnection) {
        List<String> list;
        if (httpURLConnection == null) {
            return "";
        }
        try {
            Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
            if (headerFields != null && (list = headerFields.get("gsid")) != null && list.size() > 0) {
                return list.get(0);
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    static String i(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (value == null) {
                value = "";
            }
            if (sb.length() > 0) {
                sb.append(ContainerUtils.FIELD_DELIMITER);
            }
            sb.append(URLEncoder.encode(key));
            sb.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb.append(URLEncoder.encode(value));
        }
        return sb.toString();
    }

    private void n(Map<String, String> map, HttpURLConnection httpURLConnection, boolean z5) {
        c T;
        if (map != null) {
            try {
                for (String str : map.keySet()) {
                    httpURLConnection.addRequestProperty(str, map.get(str));
                }
            } catch (Throwable th) {
                r5.e(th, "ht", "adh");
                return;
            }
        }
        HashMap<String, String> hashMap = r6.f7186d;
        if (hashMap != null) {
            for (String str2 : hashMap.keySet()) {
                httpURLConnection.addRequestProperty(str2, r6.f7186d.get(str2));
            }
        }
        String str3 = "";
        if (z5 && !this.f7547l.contains("/v3/iasdkauth") && !TextUtils.isEmpty(this.f7545j) && g4.N(this.f7545j)) {
            this.f7549n = true;
            g4.h R = g4.R(this.f7545j);
            httpURLConnection.addRequestProperty("lct", String.valueOf(R.f6347a));
            httpURLConnection.addRequestProperty("lct-info", R.f6348b);
            httpURLConnection.addRequestProperty("aks", g4.H(g4.f(this.f7545j)));
            httpURLConnection.addRequestProperty("lct-args", f(g4.A(this.f7545j) != null ? g4.A(this.f7545j).e() : "", this.f7545j));
        }
        httpURLConnection.addRequestProperty("csid", this.f7542g);
        if (v(this.f7554s.f7587c.f7571e)) {
            f fVar = this.f7554s;
            if (!TextUtils.isEmpty(fVar.f7587c.f7569c)) {
                str3 = j4.f(n6.a(fVar.f7587c.f7569c.getBytes(), "YXBtX25ldHdvcmtf".getBytes()));
                String str4 = fVar.f7587c.f7569c;
            }
            if (!TextUtils.isEmpty(str3)) {
                httpURLConnection.addRequestProperty("sip", str3);
            }
            if (g4.f6312z && (T = g4.T()) != null) {
                httpURLConnection.addRequestProperty("nls", T.b());
                this.f7554s.f7589e = T;
            }
            a S = g4.S();
            if (S != null) {
                httpURLConnection.addRequestProperty("nlf", S.b());
                this.f7554s.f7588d = S;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0038, code lost:
    
        if ("1".equals(r1[1]) != false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean p(java.util.Map<java.lang.String, java.util.List<java.lang.String>> r7, boolean r8) {
        /*
            r6 = this;
            java.lang.String r0 = "lct"
            java.lang.String r1 = "#"
            r2 = 0
            java.lang.String r3 = "sc"
            java.lang.Object r3 = r7.get(r3)     // Catch: java.lang.Throwable -> L5c
            java.util.List r3 = (java.util.List) r3     // Catch: java.lang.Throwable -> L5c
            if (r3 == 0) goto L5c
            int r4 = r3.size()     // Catch: java.lang.Throwable -> L5c
            if (r4 <= 0) goto L5c
            java.lang.Object r3 = r3.get(r2)     // Catch: java.lang.Throwable -> L5c
            java.lang.String r3 = (java.lang.String) r3     // Catch: java.lang.Throwable -> L5c
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Throwable -> L5c
            if (r4 != 0) goto L5c
            boolean r4 = r3.contains(r1)     // Catch: java.lang.Throwable -> L5c
            r5 = 1
            if (r4 != 0) goto L29
            goto L3a
        L29:
            java.lang.String[] r1 = r3.split(r1)     // Catch: java.lang.Throwable -> L5c
            int r3 = r1.length     // Catch: java.lang.Throwable -> L5c
            if (r3 <= r5) goto L5c
            java.lang.String r3 = "1"
            r1 = r1[r5]     // Catch: java.lang.Throwable -> L5c
            boolean r1 = r3.equals(r1)     // Catch: java.lang.Throwable -> L5c
            if (r1 == 0) goto L5c
        L3a:
            if (r8 == 0) goto L5b
            boolean r8 = r7.containsKey(r0)     // Catch: java.lang.Throwable -> L5c
            if (r8 == 0) goto L5a
            java.lang.Object r7 = r7.get(r0)     // Catch: java.lang.Throwable -> L5c
            java.util.List r7 = (java.util.List) r7     // Catch: java.lang.Throwable -> L5c
            if (r7 == 0) goto L5a
            int r8 = r7.size()     // Catch: java.lang.Throwable -> L5c
            if (r8 <= 0) goto L5a
            long r7 = com.amap.api.col.p0003l.g4.a(r7)     // Catch: java.lang.Throwable -> L5c
            java.lang.String r0 = r6.f7545j     // Catch: java.lang.Throwable -> L5c
            boolean r2 = com.amap.api.col.p0003l.g4.w(r0, r7)     // Catch: java.lang.Throwable -> L5c
        L5a:
            return r2
        L5b:
            return r5
        L5c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003l.w6.p(java.util.Map, boolean):boolean");
    }

    private static String r(Map<String, List<String>> map) {
        try {
            List<String> list = map.get("sc");
            if (list == null || list.size() <= 0) {
                return "";
            }
            String str = list.get(0);
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            if (!str.contains("#")) {
                return str;
            }
            String[] split = str.split("#");
            return split.length > 1 ? split[0] : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean v(String str) {
        if (this.f7546k) {
            return true;
        }
        return (!TextUtils.isEmpty(this.f7548m) && (this.f7548m.contains("rest") || this.f7548m.contains("apilocate"))) || y(str);
    }

    private static boolean y(String str) {
        return str.contains("rest") || str.contains("apilocate");
    }

    private void z(Cif cif) throws fk {
        this.f7544i = new d((byte) 0);
        this.f7550o = cif.isIPV6Request();
        this.f7538c = cif.getProxy();
        this.f7543h = cif.getUrlConnectionImpl();
        this.f7546k = cif.isBinary();
        this.f7545j = cif.parseSdkNameFromRequest();
        this.f7536a = k4.a().e(cif.isHttps());
        String b6 = cif.getDegradeType().b() ? cif.b() : cif.a();
        this.f7547l = b6;
        String e6 = e(b6);
        this.f7547l = e6;
        String a6 = v6.a(e6, this.f7545j);
        this.f7547l = a6;
        "restrictionURLTest: ".concat(String.valueOf(a6));
        if (b7.b().c(a6)) {
            "restriction hit: ".concat(String.valueOf(a6));
            throw new fk("限制访问的接口");
        }
        this.f7548m = cif.getIPDNSName();
        if ("loc".equals(this.f7545j)) {
            String a7 = cif.a();
            String b7 = cif.b();
            if (!TextUtils.isEmpty(a7)) {
                try {
                    this.f7552q = new URL(a7).getHost();
                } catch (Exception unused) {
                }
            }
            if (TextUtils.isEmpty(b7)) {
                return;
            }
            try {
                if (TextUtils.isEmpty(this.f7548m)) {
                    this.f7551p = new URL(b7).getHost();
                } else {
                    this.f7551p = this.f7548m;
                }
            } catch (Exception unused2) {
            }
        }
    }

    final Map<String, String> j(Cif cif) throws fk {
        String headerFieldKey;
        HttpURLConnection httpURLConnection = null;
        try {
            try {
                z(cif);
                this.f7547l = g(this.f7547l, cif.getParams());
                HttpURLConnection httpURLConnection2 = b(cif, false, false).f7565a;
                try {
                    this.f7554s.f7586b = SystemClock.elapsedRealtime();
                    httpURLConnection2.connect();
                    this.f7554s.a();
                    int responseCode = httpURLConnection2.getResponseCode();
                    if (responseCode >= 400) {
                        this.f7554s.g(responseCode);
                        this.f7554s.b(10);
                        fk fkVar = new fk("http读取header失败");
                        fkVar.a(responseCode);
                        throw fkVar;
                    }
                    HashMap hashMap = new HashMap();
                    for (int i6 = 0; i6 < 50 && (headerFieldKey = httpURLConnection2.getHeaderFieldKey(i6)) != null; i6++) {
                        hashMap.put(headerFieldKey.toLowerCase(), httpURLConnection2.getHeaderField(headerFieldKey));
                    }
                    this.f7554s.e(null);
                    try {
                        httpURLConnection2.disconnect();
                    } catch (Throwable th) {
                        r5.e(th, "hth", "mgr");
                    }
                    this.f7554s.i();
                    return hashMap;
                } catch (fk e6) {
                    e = e6;
                    this.f7554s.b(e.g());
                    throw e;
                } catch (SocketException e7) {
                    e = e7;
                    this.f7554s.g(a(e));
                    this.f7554s.b(6);
                    throw new fk(com.amap.api.maps.AMapException.ERROR_SOCKET);
                } catch (SocketTimeoutException e8) {
                    e = e8;
                    this.f7554s.g(a(e));
                    this.f7554s.b(2);
                    throw new fk("socket 连接超时 - SocketTimeoutException");
                } catch (UnknownHostException unused) {
                    this.f7554s.b(9);
                    throw new fk("未知主机 - UnKnowHostException");
                } catch (SSLException e9) {
                    e = e9;
                    e.printStackTrace();
                    this.f7554s.g(a(e));
                    this.f7554s.b(4);
                    throw new fk("IO 操作异常 - IOException");
                } catch (ConnectTimeoutException e10) {
                    e = e10;
                    e.printStackTrace();
                    this.f7554s.g(a(e));
                    this.f7554s.b(2);
                    throw new fk("IO 操作异常 - IOException");
                } catch (InterruptedIOException unused2) {
                    this.f7554s.g(7101);
                    this.f7554s.b(7);
                    throw new fk(com.amap.api.maps.AMapException.ERROR_UNKNOWN);
                } catch (ConnectException e11) {
                    e = e11;
                    this.f7554s.g(a(e));
                    this.f7554s.b(6);
                    throw new fk(com.amap.api.maps.AMapException.ERROR_CONNECTION);
                } catch (MalformedURLException unused3) {
                    this.f7554s.b(8);
                    throw new fk("url异常 - MalformedURLException");
                } catch (IOException unused4) {
                    this.f7554s.b(7);
                    throw new fk("IO 操作异常 - IOException");
                } catch (Throwable th2) {
                    th = th2;
                    this.f7554s.b(9);
                    th.printStackTrace();
                    throw new fk(com.amap.api.maps.AMapException.ERROR_UNKNOWN);
                }
            } catch (fk e12) {
                e = e12;
            } catch (ConnectException e13) {
                e = e13;
            } catch (MalformedURLException unused5) {
            } catch (SocketException e14) {
                e = e14;
            } catch (SocketTimeoutException e15) {
                e = e15;
            } catch (ConnectTimeoutException e16) {
                e = e16;
            } catch (InterruptedIOException unused6) {
            } catch (UnknownHostException unused7) {
            } catch (SSLException e17) {
                e = e17;
            } catch (IOException unused8) {
            } catch (Throwable th3) {
                th = th3;
            }
        } finally {
            if (0 != 0) {
                try {
                    httpURLConnection.disconnect();
                } catch (Throwable th4) {
                    r5.e(th4, "hth", "mgr");
                }
            }
            this.f7554s.i();
        }
    }

    final void l(long j6) {
        this.f7541f = j6;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(22:6|7|8|(3:393|394|(18:396|11|12|13|14|(4:331|332|333|334)(1:16)|17|18|19|(1:21)(1:308)|22|(1:24)|25|(3:27|28|29)(11:240|241|242|243|(6:250|(1:255)|280|281|279|244)|256|(1:258)(1:275)|259|(2:267|268)|261|262)|33|34|31|32))|10|11|12|13|14|(0)(0)|17|18|19|(0)(0)|22|(0)|25|(0)(0)|33|34|31|32) */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x03ec, code lost:
    
        if (r13 != null) goto L440;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x03bd, code lost:
    
        if (r13 != null) goto L440;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x038e, code lost:
    
        if (r13 != null) goto L440;
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x0412, code lost:
    
        if (r13 != null) goto L440;
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x049d, code lost:
    
        if (r13 != null) goto L440;
     */
    /* JADX WARN: Code restructure failed: missing block: B:191:0x046b, code lost:
    
        if (r13 != null) goto L440;
     */
    /* JADX WARN: Code restructure failed: missing block: B:209:0x0361, code lost:
    
        if (r13 != null) goto L440;
     */
    /* JADX WARN: Code restructure failed: missing block: B:227:0x030e, code lost:
    
        if (r13 != null) goto L440;
     */
    /* JADX WARN: Code restructure failed: missing block: B:263:0x0221, code lost:
    
        if (r13 == null) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:277:0x01d6, code lost:
    
        r21.onDownload(r12, r19.f7541f);
     */
    /* JADX WARN: Code restructure failed: missing block: B:309:0x022a, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0168, code lost:
    
        if (r13 == null) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:310:0x022b, code lost:
    
        r8 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:311:0x0257, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:312:0x0258, code lost:
    
        r8 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:313:0x0248, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:314:0x0249, code lost:
    
        r8 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:315:0x023e, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:316:0x023f, code lost:
    
        r8 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:317:0x0239, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:318:0x023a, code lost:
    
        r8 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:319:0x024d, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:320:0x024e, code lost:
    
        r8 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:321:0x0234, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:322:0x0235, code lost:
    
        r8 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:323:0x0243, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:324:0x0244, code lost:
    
        r8 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:325:0x0252, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:326:0x0253, code lost:
    
        r8 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:327:0x022f, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:328:0x0230, code lost:
    
        r8 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:329:0x0225, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:330:0x0226, code lost:
    
        r8 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x016e, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:370:0x0262, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:371:0x0263, code lost:
    
        r8 = null;
        r13 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:372:0x0298, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:373:0x0299, code lost:
    
        r8 = null;
        r13 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:374:0x0286, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:375:0x0287, code lost:
    
        r8 = null;
        r13 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:376:0x027a, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:377:0x027b, code lost:
    
        r8 = null;
        r13 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:378:0x0274, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:379:0x0275, code lost:
    
        r8 = null;
        r13 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x016f, code lost:
    
        com.amap.api.col.p0003l.r5.e(r0, "ht", "mdr");
     */
    /* JADX WARN: Code restructure failed: missing block: B:380:0x028c, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:381:0x028d, code lost:
    
        r8 = null;
        r13 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:382:0x026e, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:383:0x026f, code lost:
    
        r8 = null;
        r13 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:384:0x0280, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:385:0x0281, code lost:
    
        r8 = null;
        r13 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:386:0x0292, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:387:0x0293, code lost:
    
        r8 = null;
        r13 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:388:0x0268, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:389:0x0269, code lost:
    
        r8 = null;
        r13 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:390:0x025c, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:391:0x025d, code lost:
    
        r8 = null;
        r13 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x033b, code lost:
    
        if (r13 != null) goto L440;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x04cc, code lost:
    
        if (r13 != null) goto L440;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0439, code lost:
    
        if (r13 != null) goto L440;
     */
    /* JADX WARN: Removed duplicated region for block: B:102:0x03e4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:107:0x03d5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:120:0x03b5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:125:0x03a6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0386 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0377 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:156:0x040a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:161:0x03fb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0495 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0486 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0463 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0454 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:210:0x0359 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:215:0x034a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x0306 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:233:0x02f7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:240:0x0178 A[Catch: all -> 0x0225, fk -> 0x022a, IOException -> 0x022f, InterruptedIOException -> 0x0234, SocketTimeoutException -> 0x0239, SocketException -> 0x023e, UnknownHostException -> 0x0243, MalformedURLException -> 0x0248, ConnectTimeoutException -> 0x024d, SSLException -> 0x0252, ConnectException -> 0x0257, TRY_ENTER, TRY_LEAVE, TryCatch #44 {fk -> 0x022a, ConnectException -> 0x0257, MalformedURLException -> 0x0248, SocketException -> 0x023e, SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x024d, InterruptedIOException -> 0x0234, UnknownHostException -> 0x0243, SSLException -> 0x0252, IOException -> 0x022f, all -> 0x0225, blocks: (B:18:0x0118, B:240:0x0178), top: B:17:0x0118 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0130 A[Catch: all -> 0x00bf, fk -> 0x00c3, IOException -> 0x00c7, InterruptedIOException -> 0x00cb, SocketTimeoutException -> 0x00cf, SocketException -> 0x00d3, UnknownHostException -> 0x00d7, MalformedURLException -> 0x00db, ConnectTimeoutException -> 0x00df, SSLException -> 0x00e3, ConnectException -> 0x00e7, TRY_ENTER, TRY_LEAVE, TryCatch #41 {fk -> 0x00c3, ConnectException -> 0x00e7, MalformedURLException -> 0x00db, SocketException -> 0x00d3, SocketTimeoutException -> 0x00cf, InterruptedIOException -> 0x00cb, UnknownHostException -> 0x00d7, SSLException -> 0x00e3, ConnectTimeoutException -> 0x00df, IOException -> 0x00c7, all -> 0x00bf, blocks: (B:334:0x00b0, B:27:0x0130), top: B:333:0x00b0 }] */
    /* JADX WARN: Removed duplicated region for block: B:308:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:331:0x009f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0333 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0324 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x04c4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x04b5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0431 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0422 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final void m(com.amap.api.col.p0003l.Cif r20, com.amap.api.col.3l.u6.a r21) {
        /*
            Method dump skipped, instructions count: 1273
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003l.w6.m(com.amap.api.col.3l.if, com.amap.api.col.3l.u6$a):void");
    }

    final z6 q(Cif cif) throws fk {
        HttpURLConnection httpURLConnection = null;
        try {
            try {
                try {
                    try {
                        try {
                            try {
                                try {
                                    z(cif);
                                    String g6 = g(this.f7547l, cif.getParams());
                                    this.f7547l = g6;
                                    z6 o5 = v6.o(g6, this.f7545j);
                                    if (o5 != null) {
                                        this.f7554s.i();
                                        return o5;
                                    }
                                    b b6 = b(cif, false, true);
                                    httpURLConnection = b6.f7565a;
                                    this.f7554s.f7586b = SystemClock.elapsedRealtime();
                                    httpURLConnection.connect();
                                    this.f7554s.a();
                                    z6 c6 = c(b6, cif.isIgnoreGZip());
                                    this.f7554s.e(c6);
                                    try {
                                        httpURLConnection.disconnect();
                                    } catch (Throwable th) {
                                        r5.e(th, "ht", "mgr");
                                    }
                                    this.f7554s.i();
                                    return c6;
                                } catch (MalformedURLException unused) {
                                    this.f7554s.b(8);
                                    throw new fk("url异常 - MalformedURLException");
                                } catch (UnknownHostException unused2) {
                                    this.f7554s.b(9);
                                    throw new fk("未知主机 - UnKnowHostException");
                                }
                            } catch (ConnectException e6) {
                                this.f7554s.g(a(e6));
                                this.f7554s.b(6);
                                throw new fk(com.amap.api.maps.AMapException.ERROR_CONNECTION);
                            } catch (SocketException e7) {
                                this.f7554s.g(a(e7));
                                this.f7554s.b(6);
                                throw new fk(com.amap.api.maps.AMapException.ERROR_SOCKET);
                            }
                        } catch (fk e8) {
                            if (!e8.i() && e8.g() != 10) {
                                this.f7554s.b(e8.f());
                            }
                            throw e8;
                        } catch (InterruptedIOException unused3) {
                            this.f7554s.g(7101);
                            this.f7554s.b(7);
                            throw new fk(com.amap.api.maps.AMapException.ERROR_UNKNOWN);
                        }
                    } catch (SocketTimeoutException e9) {
                        this.f7554s.g(a(e9));
                        this.f7554s.b(2);
                        throw new fk("socket 连接超时 - SocketTimeoutException");
                    } catch (ConnectTimeoutException e10) {
                        e10.printStackTrace();
                        this.f7554s.g(a(e10));
                        this.f7554s.b(2);
                        throw new fk("IO 操作异常 - IOException");
                    }
                } catch (SSLException e11) {
                    e11.printStackTrace();
                    this.f7554s.g(a(e11));
                    this.f7554s.b(4);
                    throw new fk("IO 操作异常 - IOException");
                } catch (IOException unused4) {
                    this.f7554s.b(7);
                    throw new fk("IO 操作异常 - IOException");
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
                this.f7554s.b(9);
                throw new fk(com.amap.api.maps.AMapException.ERROR_UNKNOWN);
            }
        } catch (Throwable th3) {
            if (httpURLConnection != null) {
                try {
                    httpURLConnection.disconnect();
                } catch (Throwable th4) {
                    r5.e(th4, "ht", "mgr");
                }
            }
            this.f7554s.i();
            throw th3;
        }
    }

    final void t(long j6) {
        this.f7540e = j6;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(15:8|9|10|11|(8:13|(1:15)|(9:19|20|21|22|23|24|25|(1:27)|28)|44|45|46|47|48)|52|(1:(1:55)(1:56))|57|(1:59)|(10:17|19|20|21|22|23|24|25|(0)|28)|44|45|46|47|48) */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00d4, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00d5, code lost:
    
        com.amap.api.col.p0003l.r5.e(r0, "ht", "mPt");
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00a3 A[Catch: all -> 0x0040, fk -> 0x0044, IOException -> 0x0048, SocketTimeoutException -> 0x004c, SocketException -> 0x0050, UnknownHostException -> 0x0054, MalformedURLException -> 0x0058, ConnectTimeoutException -> 0x005c, ConnectException -> 0x0060, SSLException -> 0x0064, InterruptedIOException -> 0x00de, TryCatch #10 {fk -> 0x0044, InterruptedIOException -> 0x00de, ConnectException -> 0x0060, MalformedURLException -> 0x0058, SocketException -> 0x0050, SocketTimeoutException -> 0x004c, UnknownHostException -> 0x0054, SSLException -> 0x0064, ConnectTimeoutException -> 0x005c, IOException -> 0x0048, all -> 0x0040, blocks: (B:11:0x0026, B:13:0x003c, B:17:0x0087, B:25:0x009e, B:27:0x00a3, B:28:0x00a6, B:33:0x00b5, B:35:0x00ba, B:36:0x00bd, B:37:0x00c2, B:44:0x00c3, B:52:0x0068, B:55:0x0072, B:57:0x0077, B:59:0x0081), top: B:10:0x0026 }] */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r7v13, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v17 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final com.amap.api.col.p0003l.z6 x(com.amap.api.col.p0003l.Cif r15) throws com.amap.api.col.p0003l.fk {
        /*
            Method dump skipped, instructions count: 501
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003l.w6.x(com.amap.api.col.3l.if):com.amap.api.col.3l.z6");
    }

    w6() {
        g4.O();
        try {
            this.f7542g = UUID.randomUUID().toString().replaceAll("-", "").toLowerCase();
        } catch (Throwable th) {
            r5.e(th, "ht", "ic");
        }
    }

    private static String e(String str) {
        URL url;
        int i6;
        n.b a6 = n.a.a();
        if (a6 != null) {
            URL url2 = null;
            try {
                url = new URL(str);
            } catch (Exception e6) {
                e6.printStackTrace();
                url = null;
            }
            if (url != null) {
                String a7 = a6.a(url.getHost(), url.getPath());
                if (!TextUtils.isEmpty(a7)) {
                    String[] split = a7.split(":");
                    int i7 = 0;
                    if (split.length == 2) {
                        try {
                            i6 = Integer.parseInt(split[1]);
                        } catch (Exception e7) {
                            e7.printStackTrace();
                            i6 = 0;
                        }
                        i7 = i6;
                        a7 = split[0];
                    }
                    try {
                        String protocol = url.getProtocol();
                        if (i7 == 0) {
                            i7 = url.getPort();
                        }
                        url2 = new URL(protocol, a7, i7, url.getFile().toString());
                    } catch (Exception e8) {
                        e8.printStackTrace();
                    }
                    if (url2 != null) {
                        return url2.toString();
                    }
                }
            }
        }
        return str;
    }

    private static String g(String str, Map<String, String> map) {
        if (!TextUtils.isEmpty(str)) {
            HashMap<String, String> hashMap = r6.f7187e;
            if (hashMap != null) {
                if (map != null) {
                    map.putAll(hashMap);
                } else {
                    map = hashMap;
                }
            }
            if (map != null && map.size() > 0) {
                int indexOf = str.indexOf("?");
                if (indexOf >= 0) {
                    HashMap hashMap2 = new HashMap();
                    String substring = str.substring(indexOf);
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        String key = entry.getKey();
                        String value = entry.getValue();
                        if (value == null) {
                            value = "";
                        }
                        if (!substring.matches(".*[\\?\\&]" + URLEncoder.encode(key) + "=.*")) {
                            hashMap2.put(key, value);
                        }
                    }
                    map = hashMap2;
                }
                if (map.size() == 0) {
                    return str;
                }
                String i6 = i(map);
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(str);
                if (indexOf >= 0) {
                    if (!str.endsWith("?") && !str.endsWith(ContainerUtils.FIELD_DELIMITER)) {
                        stringBuffer.append(ContainerUtils.FIELD_DELIMITER);
                    }
                } else {
                    stringBuffer.append("?");
                }
                if (i6 != null) {
                    stringBuffer.append(i6);
                }
                return stringBuffer.toString();
            }
            return str;
        }
        return str;
    }

    public static void s() {
    }
}
