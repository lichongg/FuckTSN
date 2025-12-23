package com.ss.android.downloadlib;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import com.ss.android.downloadlib.addownload.m;
import com.ss.android.downloadlib.addownload.n;
import com.ss.android.downloadlib.addownload.o;
import com.ss.android.downloadlib.b;
import com.ss.android.downloadlib.e;
import com.ss.android.socialbase.downloader.downloader.ae;
import com.ss.android.socialbase.downloader.downloader.cw;
import w2.l;

/* loaded from: D:\Downloads\app\classes6.dex */
public class g {

    /* renamed from: f, reason: collision with root package name */
    private static volatile g f38079f;

    /* renamed from: a, reason: collision with root package name */
    private final s2.a f38080a;

    /* renamed from: b, reason: collision with root package name */
    private final com.ss.android.downloadlib.c f38081b;

    /* renamed from: c, reason: collision with root package name */
    private final z2.a f38082c;

    /* renamed from: d, reason: collision with root package name */
    private z2.b f38083d;

    /* renamed from: e, reason: collision with root package name */
    private long f38084e;

    static class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f38085a;

        a(Context context) {
            this.f38085a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            g unused = g.f38079f = new g(this.f38085a, null);
        }
    }

    class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f38086a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f38087b;

        b(String str, int i6) {
            this.f38086a = str;
            this.f38087b = i6;
        }

        @Override // java.lang.Runnable
        public void run() {
            g.this.q().l(this.f38086a, this.f38087b);
        }
    }

    class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f38089a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f38090b;

        c(String str, boolean z5) {
            this.f38089a = str;
            this.f38090b = z5;
        }

        @Override // java.lang.Runnable
        public void run() {
            g.this.q().p(this.f38089a, this.f38090b);
        }
    }

    class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f38092a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f38093b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.ss.android.j.j.cw.e f38094c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.ss.android.j.j.cw.b f38095d;

        d(Context context, int i6, com.ss.android.j.j.cw.e eVar, com.ss.android.j.j.cw.b bVar) {
            this.f38092a = context;
            this.f38093b = i6;
            this.f38094c = eVar;
            this.f38095d = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            g.this.q().f(this.f38092a, this.f38093b, this.f38094c, this.f38095d);
        }
    }

    class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f38097a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f38098b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f38099c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.ss.android.j.j.cw.g f38100d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.ss.android.j.j.cw.c f38101e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ w2.d f38102f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ w2.h f38103g;

        e(String str, long j6, int i6, com.ss.android.j.j.cw.g gVar, com.ss.android.j.j.cw.c cVar, w2.d dVar, w2.h hVar) {
            this.f38097a = str;
            this.f38098b = j6;
            this.f38099c = i6;
            this.f38100d = gVar;
            this.f38101e = cVar;
            this.f38102f = dVar;
            this.f38103g = hVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            g.this.q().n(this.f38097a, this.f38098b, this.f38099c, this.f38100d, this.f38101e, this.f38102f, this.f38103g);
        }
    }

    class f implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f38105a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f38106b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f38107c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.ss.android.j.j.cw.g f38108d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.ss.android.j.j.cw.c f38109e;

        f(String str, long j6, int i6, com.ss.android.j.j.cw.g gVar, com.ss.android.j.j.cw.c cVar) {
            this.f38105a = str;
            this.f38106b = j6;
            this.f38107c = i6;
            this.f38108d = gVar;
            this.f38109e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            g.this.q().m(this.f38105a, this.f38106b, this.f38107c, this.f38108d, this.f38109e);
        }
    }

    /* renamed from: com.ss.android.downloadlib.g$g, reason: collision with other inner class name */
    class RunnableC0757g implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f38111a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f38112b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f38113c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.ss.android.j.j.cw.g f38114d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.ss.android.j.j.cw.c f38115e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ w2.h f38116f;

        RunnableC0757g(String str, long j6, int i6, com.ss.android.j.j.cw.g gVar, com.ss.android.j.j.cw.c cVar, w2.h hVar) {
            this.f38111a = str;
            this.f38112b = j6;
            this.f38113c = i6;
            this.f38114d = gVar;
            this.f38115e = cVar;
            this.f38116f = hVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            g.this.q().o(this.f38111a, this.f38112b, this.f38113c, this.f38114d, this.f38115e, this.f38116f);
        }
    }

    /* synthetic */ g(Context context, a aVar) {
        this(context);
    }

    private g(Context context) {
        this.f38081b = com.ss.android.downloadlib.c.d();
        this.f38080a = new com.ss.android.downloadlib.a();
        this.f38084e = System.currentTimeMillis();
        v(context);
        this.f38082c = com.ss.android.downloadlib.d.d();
    }

    public static g c(Context context) {
        if (f38079f == null) {
            synchronized (g.class) {
                try {
                    if (f38079f == null) {
                        com.ss.android.downloadlib.up.b.c(new a(context));
                    }
                } finally {
                }
            }
        }
        return f38079f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.ss.android.downloadlib.c q() {
        return this.f38081b;
    }

    public s2.a f() {
        return this.f38080a;
    }

    @MainThread
    public void h(Context context, int i6, com.ss.android.j.j.cw.e eVar, com.ss.android.j.j.cw.b bVar) {
        com.ss.android.downloadlib.up.b.c(new d(context, i6, eVar, bVar));
    }

    @MainThread
    public void i(String str, int i6) {
        com.ss.android.downloadlib.up.b.c(new b(str, i6));
    }

    @MainThread
    public void j(String str, long j6, int i6, com.ss.android.j.j.cw.g gVar, com.ss.android.j.j.cw.c cVar) {
        com.ss.android.downloadlib.up.b.c(new f(str, j6, i6, gVar, cVar));
    }

    @MainThread
    public void k(String str, long j6, int i6, com.ss.android.j.j.cw.g gVar, com.ss.android.j.j.cw.c cVar, w2.d dVar, w2.h hVar) {
        com.ss.android.downloadlib.up.b.c(new e(str, j6, i6, gVar, cVar, dVar, hVar));
    }

    @MainThread
    public void l(String str, long j6, int i6, com.ss.android.j.j.cw.g gVar, com.ss.android.j.j.cw.c cVar, w2.h hVar) {
        com.ss.android.downloadlib.up.b.c(new RunnableC0757g(str, j6, i6, gVar, cVar, hVar));
    }

    @MainThread
    public void m(String str, boolean z5) {
        com.ss.android.downloadlib.up.b.c(new c(str, z5));
    }

    public z2.a p() {
        return this.f38082c;
    }

    public z2.b r() {
        if (this.f38083d == null) {
            this.f38083d = j.j();
        }
        return this.f38083d;
    }

    public long s() {
        return this.f38084e;
    }

    private void v(Context context) {
        m.i(context);
        ae.xt(m.getContext());
        o.f.c().v();
        com.ss.android.socialbase.appdownloader.f.L().s(m.getContext(), "misc_config", new b.d(), new b.g(context), new com.ss.android.downloadlib.b());
        b.h hVar = new b.h();
        com.ss.android.socialbase.appdownloader.f.L().E(hVar);
        ae.xt(context).j(hVar);
        com.ss.android.socialbase.appdownloader.f.L().w(new n());
        cw.j(new b.j());
        com.ss.android.socialbase.appdownloader.f.L().D(e.c.b());
    }

    public void a() {
        com.ss.android.downloadlib.e.c().g();
    }

    public void b() {
        this.f38084e = System.currentTimeMillis();
    }

    public com.ss.android.socialbase.downloader.ae.cw e(String str, String str2, boolean z5) {
        if (TextUtils.isEmpty(str2) && z5) {
            return u(str);
        }
        return ae.xt(m.getContext()).xt(str, str2);
    }

    public s2.a g(String str) {
        l b6 = h.a().b();
        if (b6 != null && b6.j(str)) {
            return b6.xt(str);
        }
        return this.f38080a;
    }

    public void n(t2.a aVar) {
        q().q(aVar);
    }

    public String o() {
        return m.I();
    }

    public com.ss.android.socialbase.downloader.ae.cw u(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return com.ss.android.socialbase.appdownloader.f.L().j(m.getContext(), str);
    }
}
