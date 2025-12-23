package com.ss.android.socialbase.downloader.downloader;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.work.WorkRequest;
import com.acse.ottn.l3;
import com.ss.android.socialbase.downloader.downloader.f;
import com.ss.android.socialbase.downloader.impls.DownloadHandleService;
import com.ss.android.socialbase.downloader.r.la;
import com.ss.android.socialbase.downloader.r.n;
import com.ss.android.socialbase.downloader.r.wq;
import com.stub.StubApp;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import okhttp3.Dispatcher;
import okhttp3.Dns;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes6.dex */
public class cw {

    /* renamed from: a, reason: collision with root package name */
    private static volatile w f38733a;
    private static volatile i ae;
    private static volatile ExecutorService av;
    private static volatile ExecutorService az;

    /* renamed from: b, reason: collision with root package name */
    private static final List<Object> f38734b;
    private static volatile DownloadReceiver ch;
    private static volatile jy cw;

    /* renamed from: e, reason: collision with root package name */
    private static int f38736e;

    /* renamed from: f, reason: collision with root package name */
    private static volatile ExecutorService f38737f;

    /* renamed from: g, reason: collision with root package name */
    private static volatile j f38738g;
    private static int gx;
    private static int hh;
    private static final List<com.ss.android.socialbase.downloader.r.vl> hl;

    /* renamed from: i, reason: collision with root package name */
    private static volatile ExecutorService f38740i;

    /* renamed from: j, reason: collision with root package name */
    private static volatile Context f38741j;
    private static volatile com.ss.android.socialbase.downloader.g.tl jy;
    private static volatile ExecutorService kt;

    /* renamed from: l, reason: collision with root package name */
    private static volatile com.ss.android.socialbase.downloader.tl.xt f38742l;

    /* renamed from: m, reason: collision with root package name */
    private static volatile com.ss.android.socialbase.downloader.impls.j f38743m;
    private static volatile ExecutorService mi;

    /* renamed from: n, reason: collision with root package name */
    private static final int f38744n;
    private static final int nd;
    private static final int ol;
    private static volatile com.ss.android.socialbase.downloader.g.oq oq;

    /* renamed from: p, reason: collision with root package name */
    private static volatile la f38745p;

    /* renamed from: q, reason: collision with root package name */
    private static boolean f38746q;
    private static boolean qb;
    private static volatile com.ss.android.socialbase.downloader.g.tl qv;

    /* renamed from: r, reason: collision with root package name */
    private static volatile oq f38747r;
    private static final int rh;
    private static volatile com.ss.android.socialbase.downloader.g.m rn;

    /* renamed from: s, reason: collision with root package name */
    private static volatile kt f38748s;
    private static com.ss.android.socialbase.downloader.tl.cw sm;
    private static volatile ExecutorService tj;
    private static volatile i tl;
    private static volatile f uf;
    private static volatile wq up;

    /* renamed from: v, reason: collision with root package name */
    private static volatile ScheduledExecutorService f38749v;
    private static volatile com.ss.android.socialbase.downloader.g.oq vl;

    /* renamed from: w, reason: collision with root package name */
    private static volatile ExecutorService f38750w;
    private static volatile com.ss.android.socialbase.downloader.g.m wq;
    private static volatile ws ws;

    /* renamed from: x, reason: collision with root package name */
    private static volatile g f38751x;
    private static volatile boolean xq;
    private static volatile vl xt;
    private static mi ya;

    /* renamed from: z, reason: collision with root package name */
    private static boolean f38752z;

    /* renamed from: h, reason: collision with root package name */
    private static volatile List<n> f38739h = new ArrayList();
    private static volatile boolean la = false;
    private static volatile OkHttpClient gq = null;
    private static final List<com.ss.android.socialbase.downloader.r.ws> ed = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private static boolean f38735c = false;

    public interface j {

        /* renamed from: com.ss.android.socialbase.downloader.downloader.cw$j$j, reason: collision with other inner class name */
        public interface InterfaceC0780j {
            void j();
        }

        i j();

        tj j(InterfaceC0780j interfaceC0780j);

        az xt();
    }

    public static com.ss.android.socialbase.downloader.g.oq ae() {
        if (vl == null) {
            synchronized (cw.class) {
                try {
                    if (vl == null) {
                        vl = new com.ss.android.socialbase.downloader.impls.ae();
                    }
                } finally {
                }
            }
        }
        return vl;
    }

    private static void cw(tl tlVar) {
        if (tlVar != null) {
            if (tlVar.getContext() != null) {
                j(tlVar.getContext());
            }
            if (tlVar.j() != null) {
                j(tlVar.j());
            }
            if (tlVar.xt() != null) {
                j(tlVar.xt());
            }
            if (tlVar.av() != null) {
                j(tlVar.av());
            }
            if (tlVar.x() != null) {
                j(tlVar.x());
            }
            if (tlVar.az() != 0) {
                xt(tlVar.az());
            }
            if (tlVar.cw() != null) {
                j(tlVar.cw());
            }
            if (tlVar.r() != null) {
                j(tlVar.r());
            }
            if (tlVar.up() != null) {
                j(tlVar.up());
            }
            if (tlVar.m() != null) {
                cw(tlVar.m());
            }
            if (tlVar.ae() != null) {
                r(tlVar.ae());
            }
            if (tlVar.tl() != null) {
                up(tlVar.tl());
            }
            if (tlVar.g() != null) {
                m(tlVar.g());
            }
            if (tlVar.oq() != null) {
                ae(tlVar.oq());
            }
            if (tlVar.qv() != null) {
                tl(tlVar.qv());
            }
            if (tlVar.vl() != null) {
                j(tlVar.vl());
            }
            if (tlVar.jy() != null) {
                xt(tlVar.jy());
            }
            if (!tlVar.ws().isEmpty()) {
                j(tlVar.ws());
            }
            if (tlVar.kt() != null) {
                f38733a = tlVar.kt();
            }
            if (tlVar.w() > 1024) {
                hh = tlVar.w();
            }
            if (tlVar.i() != null) {
                j(tlVar.i());
            }
            if (tlVar.mi()) {
                la = true;
            }
            if (tlVar.tj() != 0) {
                f38736e = tlVar.tj();
            }
            if (tlVar.ch() != null) {
                j(tlVar.ch());
            }
            if (tlVar.a() != null) {
                rn = tlVar.a();
            }
            if (tlVar.f() != null) {
                f f6 = tlVar.f();
                uf = f6;
                if (f6.j()) {
                    j(uf.xt());
                    j(uf.cw());
                } else {
                    j(ae());
                    j(tl());
                }
            }
            xt(tlVar.v());
            if (tlVar.s() != null) {
                j(tlVar.s());
            }
        }
    }

    public static void j(mi miVar) {
    }

    public static com.ss.android.socialbase.downloader.tl.xt m() {
        return f38742l;
    }

    public static List<n> r() {
        List<n> list;
        synchronized (f38739h) {
            list = f38739h;
        }
        return list;
    }

    public static com.ss.android.socialbase.downloader.g.tl tl() {
        if (jy == null) {
            synchronized (cw.class) {
                try {
                    if (jy == null) {
                        jy = new com.ss.android.socialbase.downloader.impls.m();
                    }
                } finally {
                }
            }
        }
        return jy;
    }

    public static com.ss.android.socialbase.downloader.g.tl up() {
        return qv;
    }

    static synchronized void xt(tl tlVar) {
        synchronized (cw.class) {
            cw(tlVar);
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors() + 1;
        f38744n = availableProcessors;
        nd = (Runtime.getRuntime().availableProcessors() * 2) + 1;
        rh = availableProcessors;
        ol = availableProcessors;
        hh = 8192;
        hl = new ArrayList();
        f38734b = new ArrayList();
        f38746q = true;
        qb = false;
        xq = false;
    }

    public static List<com.ss.android.socialbase.downloader.r.ws> a() {
        return ed;
    }

    public static ExecutorService av() {
        if (tj == null) {
            synchronized (cw.class) {
                try {
                    if (tj == null) {
                        int i6 = nd;
                        com.bytedance.sdk.component.oq.r.r rVar = new com.bytedance.sdk.component.oq.r.r(i6, i6, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.ss.android.socialbase.downloader.ws.j("DownloadThreadPool-chunk-fixed", true));
                        try {
                            rVar.allowCoreThreadTimeOut(true);
                        } catch (Throwable th) {
                            com.bytedance.sdk.component.utils.vl.j(th);
                        }
                        tj = rVar;
                    }
                } finally {
                }
            }
        }
        return tj;
    }

    public static ExecutorService az() {
        if (f38740i == null) {
            synchronized (cw.class) {
                try {
                    if (f38740i == null) {
                        int i6 = rh;
                        com.bytedance.sdk.component.oq.r.r rVar = new com.bytedance.sdk.component.oq.r.r(i6, i6, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.ss.android.socialbase.downloader.ws.j("DownloadThreadPool-mix-fixed", true));
                        try {
                            rVar.allowCoreThreadTimeOut(true);
                        } catch (Throwable th) {
                            com.bytedance.sdk.component.utils.vl.j(th);
                        }
                        f38740i = rVar;
                    }
                } finally {
                }
            }
        }
        return f38740i;
    }

    public static j b() {
        return f38738g;
    }

    public static g c() {
        if (f38751x == null) {
            synchronized (cw.class) {
                try {
                    if (f38751x == null) {
                        f38751x = new com.ss.android.socialbase.downloader.impls.xt();
                    }
                } finally {
                }
            }
        }
        return f38751x;
    }

    public static i ch() {
        if (ae == null) {
            synchronized (cw.class) {
                try {
                    if (ae == null) {
                        ae = new com.ss.android.socialbase.downloader.impls.tl();
                    }
                } finally {
                }
            }
        }
        return ae;
    }

    private static void e() {
        if (ch == null) {
            ch = new DownloadReceiver();
        }
        if (f38735c) {
            return;
        }
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            f38741j.registerReceiver(ch, intentFilter);
            f38735c = true;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.vl.j(th);
        }
    }

    public static wq ed() {
        return up;
    }

    public static com.ss.android.socialbase.downloader.g.m f() {
        if (wq == null) {
            synchronized (cw.class) {
                try {
                    if (wq == null) {
                        wq = new com.ss.android.socialbase.downloader.g.m() { // from class: com.ss.android.socialbase.downloader.downloader.cw.2
                            @Override // com.ss.android.socialbase.downloader.g.m
                            public List<InetAddress> j(String str) throws UnknownHostException {
                                return Dns.SYSTEM.lookup(str);
                            }
                        };
                    }
                } finally {
                }
            }
        }
        return wq;
    }

    public static void gq() {
        if (TextUtils.isEmpty(com.ss.android.socialbase.downloader.xt.up.cw)) {
            com.ss.android.socialbase.downloader.xt.up.cw = "oppo";
            com.ss.android.socialbase.downloader.xt.up.xt = "oppo".toUpperCase();
        }
    }

    public static kt gx() {
        if (f38748s == null) {
            synchronized (cw.class) {
                try {
                    if (f38748s == null) {
                        f38748s = new com.ss.android.socialbase.downloader.impls.oq();
                    }
                } finally {
                }
            }
        }
        return f38748s;
    }

    public static int h() {
        return f38736e;
    }

    public static mi hh() {
        return ya;
    }

    public static boolean hl() {
        StringBuilder sb = new StringBuilder("supportMultiProc::=");
        sb.append(f38738g != null);
        com.ss.android.socialbase.downloader.m.j.j("wjd", sb.toString());
        return f38738g != null;
    }

    public static ExecutorService i() {
        if (kt == null) {
            synchronized (cw.class) {
                try {
                    if (kt == null) {
                        int i6 = ol;
                        com.bytedance.sdk.component.oq.r.r rVar = new com.bytedance.sdk.component.oq.r.r(i6, i6, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.ss.android.socialbase.downloader.ws.j("DownloadThreadPool-db-fixed", true));
                        try {
                            rVar.allowCoreThreadTimeOut(true);
                        } catch (Throwable th) {
                            com.bytedance.sdk.component.utils.vl.j(th);
                        }
                        kt = rVar;
                    }
                } finally {
                }
            }
        }
        return kt;
    }

    static synchronized void j(tl tlVar) {
        synchronized (cw.class) {
            if (xq) {
                com.ss.android.socialbase.downloader.m.j.up("DownloadComponentManager", "component has init");
                return;
            }
            boolean z5 = la;
            cw(tlVar);
            if (xt == null) {
                xt = new com.ss.android.socialbase.downloader.impls.r();
            }
            if (ae == null) {
                ae = new com.ss.android.socialbase.downloader.impls.tl();
            }
            if (tl == null && f38738g != null) {
                tl = f38738g.j();
            }
            if (cw == null) {
                cw = new com.ss.android.socialbase.downloader.impls.g();
            }
            if (f38743m == null) {
                f38743m = new com.ss.android.socialbase.downloader.impls.up();
            }
            if (f38747r == null) {
                f38747r = new com.ss.android.socialbase.downloader.impls.cw();
            }
            if (f38751x == null) {
                f38751x = new com.ss.android.socialbase.downloader.impls.xt();
            }
            if (f38748s == null) {
                f38748s = new com.ss.android.socialbase.downloader.impls.oq();
            }
            int i6 = gx;
            if (i6 <= 0 || i6 > f38744n) {
                gx = f38744n;
            }
            e();
            if (la && !z5 && !com.ss.android.socialbase.downloader.az.m.cw()) {
                com.ss.android.socialbase.downloader.impls.vl.j(true).startService();
            } else if (com.ss.android.socialbase.downloader.az.m.r()) {
                ExecutorService vl2 = vl();
                if (vl2 != null) {
                    vl2.execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.cw.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Context nd2 = cw.nd();
                            if (nd2 != null) {
                                com.ss.android.socialbase.downloader.az.m.r(nd2);
                            }
                        }
                    });
                }
            } else {
                Context nd2 = nd();
                if (nd2 != null) {
                    com.ss.android.socialbase.downloader.az.m.r(nd2);
                }
            }
            gq();
            xq = true;
        }
    }

    public static ExecutorService jy() {
        return f38750w != null ? f38750w : az();
    }

    public static OkHttpClient.Builder kt() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        builder.connectTimeout(WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS, timeUnit).readTimeout(WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS, timeUnit).writeTimeout(WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS, timeUnit).retryOnConnectionFailure(true).followRedirects(true).protocols(Collections.singletonList(Protocol.HTTP_1_1));
        if (f38737f != null) {
            builder.dispatcher(new Dispatcher(f38737f));
        }
        return builder;
    }

    public static jy l() {
        if (cw == null) {
            synchronized (cw.class) {
                try {
                    if (cw == null) {
                        cw = new com.ss.android.socialbase.downloader.impls.g();
                    }
                } finally {
                }
            }
        }
        return cw;
    }

    @NonNull
    public static JSONObject la() {
        return (f38745p == null || f38745p.j() == null) ? com.ss.android.socialbase.downloader.xt.up.f39039g : f38745p.j();
    }

    private static void m(ExecutorService executorService) {
        if (executorService != null) {
            f38750w = executorService;
        }
    }

    public static ScheduledExecutorService mi() {
        if (f38749v == null) {
            synchronized (cw.class) {
                try {
                    if (f38749v == null) {
                        f38749v = new com.bytedance.sdk.component.oq.r.up(1, new com.ss.android.socialbase.downloader.ws.j("DownloadThreadPool-Schedule", true));
                    }
                } finally {
                }
            }
        }
        return f38749v;
    }

    public static f n() {
        if (uf == null) {
            synchronized (cw.class) {
                try {
                    if (uf == null) {
                        uf = new f.j();
                    }
                } finally {
                }
            }
        }
        return uf;
    }

    public static synchronized Context nd() {
        Context context;
        synchronized (cw.class) {
            context = f38741j;
        }
        return context;
    }

    @NonNull
    public static com.ss.android.socialbase.downloader.tl.cw ol() {
        if (sm == null) {
            sm = new com.ss.android.socialbase.downloader.tl.cw() { // from class: com.ss.android.socialbase.downloader.downloader.cw.3
                @Override // com.ss.android.socialbase.downloader.tl.cw
                public void j(int i6, String str, JSONObject jSONObject) {
                }

                @Override // com.ss.android.socialbase.downloader.tl.cw
                public void xt(int i6, String str, JSONObject jSONObject) {
                }
            };
        }
        return sm;
    }

    public static synchronized w oq() {
        w wVar;
        synchronized (cw.class) {
            wVar = f38733a;
        }
        return wVar;
    }

    public static com.ss.android.socialbase.downloader.impls.j p() {
        if (f38743m == null) {
            synchronized (cw.class) {
                try {
                    if (f38743m == null) {
                        f38743m = new com.ss.android.socialbase.downloader.impls.up();
                    }
                } finally {
                }
            }
        }
        return f38743m;
    }

    public static ExecutorService qv() {
        if (az == null) {
            synchronized (cw.class) {
                try {
                    if (az == null) {
                        int i6 = f38744n;
                        com.bytedance.sdk.component.oq.r.r rVar = new com.bytedance.sdk.component.oq.r.r(i6, i6, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.ss.android.socialbase.downloader.ws.j("DownloadThreadPool-cpu-fixed", true));
                        try {
                            rVar.allowCoreThreadTimeOut(true);
                        } catch (Throwable th) {
                            com.bytedance.sdk.component.utils.vl.j(th);
                        }
                        az = rVar;
                    }
                } finally {
                }
            }
        }
        return az;
    }

    public static synchronized boolean rh() {
        boolean z5;
        synchronized (cw.class) {
            z5 = f38752z;
        }
        return z5;
    }

    public static boolean rn() {
        return f38746q;
    }

    public static i s() {
        if (tl == null) {
            synchronized (cw.class) {
                try {
                    if (tl == null) {
                        tl = f38738g.j();
                    }
                } finally {
                }
            }
        }
        return tl;
    }

    public static com.ss.android.socialbase.downloader.g.m tj() {
        return rn;
    }

    public static oq uf() {
        if (f38747r == null) {
            synchronized (cw.class) {
                try {
                    if (f38747r == null) {
                        f38747r = new com.ss.android.socialbase.downloader.impls.cw();
                    }
                } finally {
                }
            }
        }
        return f38747r;
    }

    private static void up(ExecutorService executorService) {
        if (executorService != null) {
            f38740i = executorService;
        }
    }

    public static synchronized ws v() {
        ws wsVar;
        synchronized (cw.class) {
            wsVar = ws;
        }
        return wsVar;
    }

    public static ExecutorService vl() {
        return av != null ? av : qv();
    }

    public static OkHttpClient w() {
        if (gq == null) {
            synchronized (cw.class) {
                try {
                    if (gq == null) {
                        gq = kt().build();
                    }
                } finally {
                }
            }
        }
        return gq;
    }

    public static synchronized int wq() {
        int i6;
        synchronized (cw.class) {
            i6 = hh;
        }
        return i6;
    }

    public static ExecutorService ws() {
        return mi != null ? mi : az();
    }

    public static vl x() {
        if (xt == null) {
            synchronized (cw.class) {
                try {
                    if (xt == null) {
                        xt = new com.ss.android.socialbase.downloader.impls.r();
                    }
                } finally {
                }
            }
        }
        return xt;
    }

    public static boolean z() {
        return xq;
    }

    private cw() {
    }

    public static boolean g() {
        if (com.ss.android.socialbase.downloader.jy.j.cw().j("switch_not_auto_boot_service", qb ? 1 : 0) > 0) {
            return true;
        }
        return false;
    }

    public static synchronized boolean xt() {
        boolean z5;
        synchronized (cw.class) {
            z5 = la;
        }
        return z5;
    }

    private static void r(ExecutorService executorService) {
        if (executorService != null) {
            av = executorService;
        }
    }

    public static void xt(com.ss.android.socialbase.downloader.ae.r rVar, int i6) {
        List<Object> list = f38734b;
        synchronized (list) {
            try {
                Iterator<Object> it = list.iterator();
                while (it.hasNext()) {
                    it.next();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static void ae(ExecutorService executorService) {
        if (executorService != null) {
            mi = executorService;
        }
    }

    private static void tl(ExecutorService executorService) {
        if (executorService != null) {
            kt = executorService;
        }
    }

    private static com.ss.android.socialbase.downloader.g.ae xt(String str, List<com.ss.android.socialbase.downloader.ae.up> list, int i6, boolean z5, com.ss.android.socialbase.downloader.ae.cw cwVar) throws com.ss.android.socialbase.downloader.up.j, IOException {
        Throwable th;
        IOException iOException;
        com.ss.android.socialbase.downloader.g.tl up2 = i6 == 1 ? up() : tl();
        if (up2 != null) {
            long j6 = 0;
            try {
                if (z5) {
                    try {
                        j6 = System.currentTimeMillis();
                    } catch (IOException e6) {
                        throw e6;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                iOException = null;
            }
            try {
                com.ss.android.socialbase.downloader.g.ae j7 = up2.j(str, list);
                if (z5) {
                    com.ss.android.socialbase.downloader.tl.j.j(j7, str, null, System.currentTimeMillis() - j6, "head", i6, null, cwVar);
                }
                return j7;
            } catch (Throwable th3) {
                th = th3;
                iOException = null;
                if (!z5) {
                    throw th;
                }
                com.ss.android.socialbase.downloader.tl.j.j(null, str, null, System.currentTimeMillis() - j6, "head", i6, iOException, cwVar);
                throw th;
            }
        }
        throw new com.ss.android.socialbase.downloader.up.j(1022, new IOException("httpService not exist, netLib = " + i6));
    }

    public static void xt(ExecutorService executorService) {
        if (executorService != null) {
            f38737f = executorService;
        }
    }

    public static void xt(Runnable runnable) {
        xt(runnable, false);
    }

    public static void xt(Runnable runnable, boolean z5) {
        if (runnable == null) {
            return;
        }
        if (z5 && !com.ss.android.socialbase.downloader.az.m.r()) {
            runnable.run();
        } else {
            vl().execute(runnable);
        }
    }

    private static void xt(int i6) {
        if (i6 > 0) {
            gx = i6;
        }
    }

    private static void xt(boolean z5) {
        f38746q = z5;
    }

    public static synchronized void j() {
        synchronized (cw.class) {
            if (la) {
                return;
            }
            la = true;
            try {
                Intent intent = new Intent(nd(), (Class<?>) DownloadHandleService.class);
                intent.setAction("com.ss.android.downloader.action.MULTI_PROCESS_NOTIFY");
                nd().startService(intent);
                if (!com.ss.android.socialbase.downloader.az.m.cw()) {
                    com.ss.android.socialbase.downloader.impls.vl.j(true).startService();
                }
            } catch (Throwable th) {
                la = false;
                com.bytedance.sdk.component.utils.vl.j(th);
            }
        }
    }

    public static void j(n nVar) {
        if (nVar == null) {
            return;
        }
        synchronized (f38739h) {
            f38739h.add(nVar);
        }
    }

    public static void j(com.ss.android.socialbase.downloader.r.vl vlVar) {
        List<com.ss.android.socialbase.downloader.r.vl> list = hl;
        synchronized (list) {
            if (vlVar != null) {
                try {
                    if (!list.contains(vlVar)) {
                        list.add(vlVar);
                    }
                } finally {
                }
            }
        }
    }

    public static void j(com.ss.android.socialbase.downloader.xt.r rVar) {
        List<com.ss.android.socialbase.downloader.r.vl> list = hl;
        synchronized (list) {
            try {
                for (com.ss.android.socialbase.downloader.r.vl vlVar : list) {
                    if (vlVar != null && rVar != com.ss.android.socialbase.downloader.xt.r.SYNC_START && rVar == com.ss.android.socialbase.downloader.xt.r.SYNC_SUCCESS) {
                        vlVar.j();
                    }
                }
                if (rVar == com.ss.android.socialbase.downloader.xt.r.SYNC_SUCCESS) {
                    hl.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static com.ss.android.socialbase.downloader.g.oq cw() {
        return oq;
    }

    private static void cw(ExecutorService executorService) {
        if (executorService != null) {
            az = executorService;
        }
    }

    public static void cw(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (!com.ss.android.socialbase.downloader.az.m.r()) {
            runnable.run();
        } else {
            i().execute(runnable);
        }
    }

    public static void j(com.ss.android.socialbase.downloader.ae.r rVar, int i6) {
        List<Object> list = f38734b;
        synchronized (list) {
            try {
                Iterator<Object> it = list.iterator();
                while (it.hasNext()) {
                    it.next();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static com.ss.android.socialbase.downloader.g.g j(boolean z5, int i6, String str, List<com.ss.android.socialbase.downloader.ae.up> list) throws Exception {
        return j(z5, i6, str, null, list, 0, false, null);
    }

    public static com.ss.android.socialbase.downloader.g.g j(boolean z5, int i6, String str, String str2, List<com.ss.android.socialbase.downloader.ae.up> list, int i7, boolean z6, com.ss.android.socialbase.downloader.ae.cw cwVar) throws Exception {
        List<com.ss.android.socialbase.downloader.ae.up> list2;
        int i8;
        com.ss.android.socialbase.downloader.g.g j6;
        if (!TextUtils.isEmpty(str2)) {
            List<com.ss.android.socialbase.downloader.ae.up> arrayList = list == null ? new ArrayList<>() : list;
            arrayList.add(new com.ss.android.socialbase.downloader.ae.up("ss_d_request_host_ip_114", str2));
            list2 = arrayList;
            i8 = 1;
        } else if (z5) {
            list2 = list;
            i8 = i7;
        } else {
            i8 = 2;
            list2 = list;
        }
        Exception e6 = null;
        for (int i9 : j(i8)) {
            try {
                j6 = j(i6, str, str2, list2, i9, z6, cwVar);
            } catch (Exception e7) {
                e6 = e7;
                if (!cwVar.ki()) {
                    continue;
                } else if (!com.ss.android.socialbase.downloader.az.m.ae(e6)) {
                    continue;
                } else if (com.ss.android.socialbase.downloader.az.m.cw(list2)) {
                    com.ss.android.socialbase.downloader.m.j.j("dcach::http exception 304, throw excepiton, not retry " + e6);
                    throw e6;
                }
            }
            if (j6 != null) {
                return j6;
            }
        }
        if (e6 == null) {
            return null;
        }
        throw e6;
    }

    private static com.ss.android.socialbase.downloader.g.g j(int i6, String str, String str2, List<com.ss.android.socialbase.downloader.ae.up> list, int i7, boolean z5, com.ss.android.socialbase.downloader.ae.cw cwVar) throws com.ss.android.socialbase.downloader.up.j, IOException {
        Throwable th;
        IOException iOException;
        com.ss.android.socialbase.downloader.g.oq cw2 = i7 == 1 ? cw() : ae();
        if (cw2 != null) {
            long j6 = 0;
            try {
                if (z5) {
                    try {
                        j6 = System.currentTimeMillis();
                    } catch (IOException e6) {
                        throw e6;
                    }
                }
                iOException = null;
            } catch (Throwable th2) {
                th = th2;
                iOException = null;
            }
            try {
                com.ss.android.socialbase.downloader.g.g j7 = cw2.j(i6, str, list);
                if (z5) {
                    com.ss.android.socialbase.downloader.tl.j.j(j7, str, str2, System.currentTimeMillis() - j6, l3.f4736f, i7, null, cwVar);
                }
                return j7;
            } catch (Throwable th3) {
                th = th3;
                if (!z5) {
                    throw th;
                }
                com.ss.android.socialbase.downloader.tl.j.j(null, str, str2, System.currentTimeMillis() - j6, l3.f4736f, i7, iOException, cwVar);
                throw th;
            }
        }
        throw new com.ss.android.socialbase.downloader.up.j(1022, new IOException("httpService not exist, netLib = " + i7));
    }

    public static com.ss.android.socialbase.downloader.g.ae j(String str, List<com.ss.android.socialbase.downloader.ae.up> list) throws Exception {
        return j(str, list, 0, false, null);
    }

    public static com.ss.android.socialbase.downloader.g.ae j(String str, List<com.ss.android.socialbase.downloader.ae.up> list, int i6, boolean z5, com.ss.android.socialbase.downloader.ae.cw cwVar) throws Exception {
        com.ss.android.socialbase.downloader.g.ae xt2;
        Exception e6 = null;
        for (int i7 : j(i6)) {
            try {
                xt2 = xt(str, list, i7, z5, cwVar);
            } catch (Exception e7) {
                e6 = e7;
            }
            if (xt2 != null) {
                return xt2;
            }
        }
        if (e6 == null) {
            return null;
        }
        throw e6;
    }

    private static int[] j(int i6) {
        if (i6 == 1) {
            return new int[]{0};
        }
        if (i6 == 2) {
            return new int[]{1};
        }
        if (i6 != 3) {
            return new int[]{1, 0};
        }
        return new int[]{0, 1};
    }

    public static synchronized void j(ws wsVar) {
        synchronized (cw.class) {
            if (wsVar != null) {
                ws = wsVar;
                if (xt instanceof com.ss.android.socialbase.downloader.impls.r) {
                    ((com.ss.android.socialbase.downloader.impls.r) xt).tl();
                }
            }
        }
    }

    public static void j(ExecutorService executorService) {
        if (executorService != null) {
            tj = executorService;
        }
    }

    private static void j(List<com.ss.android.socialbase.downloader.r.ws> list) {
        List<com.ss.android.socialbase.downloader.r.ws> list2 = ed;
        if (list2.isEmpty()) {
            synchronized (list2) {
                list2.addAll(list);
            }
        }
    }

    public static void j(boolean z5) {
        qb = z5;
    }

    public static void j(Runnable runnable) {
        j(runnable, false);
    }

    public static void j(Runnable runnable, boolean z5) {
        if (runnable == null) {
            return;
        }
        if (z5 && !com.ss.android.socialbase.downloader.az.m.r()) {
            runnable.run();
        } else {
            qv().execute(runnable);
        }
    }

    public static Future j(Runnable runnable, long j6, TimeUnit timeUnit) {
        if (runnable == null) {
            return null;
        }
        return mi().schedule(runnable, j6, timeUnit);
    }

    public static void j(com.ss.android.socialbase.downloader.g.oq oqVar) {
        if (oqVar != null) {
            oq = oqVar;
        }
        f38752z = oq != null;
    }

    public static void j(com.ss.android.socialbase.downloader.g.tl tlVar) {
        if (tlVar != null) {
            qv = tlVar;
        }
    }

    private static void j(vl vlVar) {
        if (vlVar != null) {
            xt = vlVar;
        }
    }

    private static void j(jy jyVar) {
        if (jyVar != null) {
            cw = jyVar;
        }
    }

    private static void j(com.ss.android.socialbase.downloader.tl.xt xtVar) {
        if (xtVar != null) {
            f38742l = xtVar;
        }
    }

    public static void j(la laVar) {
        f38745p = laVar;
        com.ss.android.socialbase.downloader.jy.j.j();
    }

    private static void j(oq oqVar) {
        if (oqVar != null) {
            f38747r = oqVar;
        }
    }

    public static void j(wq wqVar) {
        if (wqVar != null) {
            up = wqVar;
        }
    }

    private static void j(g gVar) {
        if (gVar != null) {
            f38751x = gVar;
        }
    }

    public static synchronized void j(Context context) {
        synchronized (cw.class) {
            if (context != null) {
                if (f38741j == null) {
                    f38741j = StubApp.getOrigApplicationContext(context.getApplicationContext());
                    com.ss.android.socialbase.downloader.j.j.j().j(f38741j);
                }
            }
        }
    }

    public static int j(com.ss.android.socialbase.downloader.ae.cw cwVar) {
        if (cwVar == null) {
            return 0;
        }
        String s5 = cwVar.s();
        if (TextUtils.isEmpty(s5)) {
            s5 = cwVar.oq();
        }
        return j(s5, cwVar.qv());
    }

    public static int j(String str, String str2) {
        jy l6 = l();
        if (l6 == null) {
            return 0;
        }
        return l6.j(str, str2);
    }

    public static void j(com.ss.android.socialbase.downloader.tl.cw cwVar) {
        sm = cwVar;
    }

    public static void j(j jVar) {
        com.ss.android.socialbase.downloader.m.j.j("wjd", "setIndependentServiceCreator::creator=" + jVar);
        f38738g = jVar;
    }
}
