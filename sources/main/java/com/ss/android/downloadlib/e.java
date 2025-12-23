package com.ss.android.downloadlib;

import android.content.SharedPreferences;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import com.bytedance.sdk.component.oq.r.up;
import com.bytedance.sdk.openadsdk.ats.cw;
import com.ss.android.downloadlib.a;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.downloadlib.addownload.m;
import com.ss.android.downloadlib.addownload.o;
import com.ss.android.downloadlib.j;
import com.ss.android.socialbase.downloader.downloader.ae;
import com.ss.android.socialbase.downloader.downloader.vl;
import com.ss.android.socialbase.downloader.impls.r;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\Downloads\app\classes6.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private ExecutorService f38053a;

    /* renamed from: b, reason: collision with root package name */
    private ExecutorService f38054b;

    /* renamed from: c, reason: collision with root package name */
    private ScheduledExecutorService f38055c;

    /* renamed from: d, reason: collision with root package name */
    private ExecutorService f38056d;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            vl x5;
            synchronized (e.class) {
                try {
                    String[] strArr = {"sp_ad_download_event", "sp_download_finish_cache", "sp_delay_operation_info", "sp_ttdownloader_md5", "sp_name_installed_app", "misc_config", "sp_ad_install_back_dialog", "sp_ttdownloader_clean", "sp_order_download", "sp_a_b_c", "sp_ah_config", "sp_download_info", "sp_appdownloader"};
                    for (int i6 = 0; i6 < 13; i6++) {
                        SharedPreferences j6 = cw.j(m.getContext(), strArr[i6], 0);
                        if (j6 != null) {
                            j6.edit().clear().apply();
                        }
                    }
                    x5 = com.ss.android.socialbase.downloader.downloader.cw.x();
                } catch (Throwable unused) {
                }
                if (x5 instanceof r) {
                    SparseArray<com.ss.android.socialbase.downloader.ae.cw> j7 = ((r) x5).j().j();
                    for (int size = j7.size() - 1; size >= 0; size--) {
                        com.ss.android.socialbase.downloader.ae.cw cwVar = j7.get(j7.keyAt(size));
                        if (cwVar != null) {
                            ae.xt(m.getContext()).oq(cwVar.ae());
                        }
                    }
                }
            }
        }
    }

    private static class b {

        /* renamed from: a, reason: collision with root package name */
        private static e f38058a = new e(null);
    }

    public class c implements x2.j {

        /* renamed from: b, reason: collision with root package name */
        private static volatile c f38059b;

        /* renamed from: a, reason: collision with root package name */
        private List<x2.j> f38060a;

        class a implements x2.i {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f38061a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ com.ss.android.socialbase.downloader.ae.cw f38062b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ x2.i f38063c;

            a(int i6, com.ss.android.socialbase.downloader.ae.cw cwVar, x2.i iVar) {
                this.f38061a = i6;
                this.f38062b = cwVar;
                this.f38063c = iVar;
            }

            @Override // x2.i
            public void j() {
                c.this.d(this.f38062b, this.f38061a + 1, this.f38063c);
            }
        }

        public static c b() {
            if (f38059b == null) {
                synchronized (c.class) {
                    try {
                        if (f38059b == null) {
                            f38059b = new c();
                        }
                    } finally {
                    }
                }
            }
            return f38059b;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(com.ss.android.socialbase.downloader.ae.cw cwVar, int i6, x2.i iVar) {
            if (i6 == this.f38060a.size() || i6 < 0) {
                iVar.j();
            } else {
                this.f38060a.get(i6).a(cwVar, new a(i6, cwVar, iVar));
            }
        }

        @Override // x2.j
        public void a(com.ss.android.socialbase.downloader.ae.cw cwVar, x2.i iVar) {
            if (cwVar != null && this.f38060a.size() != 0) {
                d(cwVar, 0, iVar);
            } else if (iVar != null) {
                iVar.j();
            }
        }

        private c() {
            ArrayList arrayList = new ArrayList();
            this.f38060a = arrayList;
            arrayList.add(new C0756e());
            this.f38060a.add(new d());
        }
    }

    public class d implements x2.j {

        class a implements com.ss.android.downloadlib.guide.install.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ x2.i f38065a;

            a(x2.i iVar) {
                this.f38065a = iVar;
            }

            @Override // com.ss.android.downloadlib.guide.install.a
            public void j() {
                this.f38065a.j();
            }
        }

        class b implements com.ss.android.downloadlib.guide.install.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ com.ss.android.socialbase.downloader.ae.cw f38067a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ com.ss.android.downloadlib.guide.install.a f38068b;

            b(com.ss.android.socialbase.downloader.ae.cw cwVar, com.ss.android.downloadlib.guide.install.a aVar) {
                this.f38067a = cwVar;
                this.f38068b = aVar;
            }

            @Override // com.ss.android.downloadlib.guide.install.a
            public void j() {
                d.this.d(this.f38067a, this.f38068b);
            }
        }

        class c implements com.ss.android.downloadlib.guide.install.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ com.ss.android.downloadlib.guide.install.a f38070a;

            c(com.ss.android.downloadlib.guide.install.a aVar) {
                this.f38070a = aVar;
            }

            @Override // com.ss.android.downloadlib.guide.install.a
            public void j() {
                this.f38070a.j();
            }
        }

        @Override // x2.j
        public void a(com.ss.android.socialbase.downloader.ae.cw cwVar, x2.i iVar) {
            c(cwVar, new a(iVar));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(com.ss.android.socialbase.downloader.ae.cw cwVar, @NonNull com.ss.android.downloadlib.guide.install.a aVar) {
            com.ss.android.xt.j.xt.b f6 = o.f.c().f(cwVar);
            boolean f7 = j.h.f(f6);
            boolean m6 = j.h.m(f6);
            if (f7 && m6) {
                j.e.a(f6, new c(aVar));
            } else {
                aVar.j();
            }
        }

        public void c(com.ss.android.socialbase.downloader.ae.cw cwVar, @NonNull com.ss.android.downloadlib.guide.install.a aVar) {
            com.ss.android.xt.j.xt.b f6 = o.f.c().f(cwVar);
            if (f6 != null && j.f.a(f6)) {
                TTDelegateActivity.j(f6, new b(cwVar, aVar));
            } else {
                d(cwVar, aVar);
            }
        }
    }

    /* renamed from: com.ss.android.downloadlib.e$e, reason: collision with other inner class name */
    public class C0756e implements x2.j {
        @Override // x2.j
        public void a(com.ss.android.socialbase.downloader.ae.cw cwVar, x2.i iVar) {
            com.ss.android.xt.j.xt.b f6;
            if (cwVar != null && (f6 = o.f.c().f(cwVar)) != null) {
                cwVar.cw(f6.t0());
            }
            if (iVar != null) {
                iVar.j();
            }
        }
    }

    /* synthetic */ e(a aVar) {
        this();
    }

    public void d(Runnable runnable) {
        f(runnable, false);
    }

    public void k(Runnable runnable) {
        l(runnable, false);
    }

    private e() {
    }

    public ExecutorService a() {
        if (this.f38054b == null) {
            synchronized (e.class) {
                try {
                    if (this.f38054b == null) {
                        this.f38054b = new com.bytedance.sdk.component.oq.r.r(0, Integer.MAX_VALUE, 30L, TimeUnit.SECONDS, new SynchronousQueue(), new com.ss.android.socialbase.downloader.ws.j(g.class.getName() + "-IOThreadPool"));
                    }
                } finally {
                }
            }
        }
        return this.f38054b;
    }

    public void b(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        i().execute(runnable);
    }

    public void f(Runnable runnable, boolean z5) {
        if (runnable == null) {
            return;
        }
        if (!z5 || a.h.K()) {
            j().execute(runnable);
        } else {
            runnable.run();
        }
    }

    public void g() {
        d(new a());
    }

    public ScheduledExecutorService h() {
        if (this.f38055c == null) {
            synchronized (e.class) {
                try {
                    if (this.f38055c == null) {
                        this.f38055c = new up(0, new com.ss.android.socialbase.downloader.ws.j(g.class.getName() + "-ScheduledThreadPool"));
                    }
                } finally {
                }
            }
        }
        return this.f38055c;
    }

    public ExecutorService i() {
        if (this.f38056d == null) {
            synchronized (e.class) {
                try {
                    if (this.f38056d == null) {
                        this.f38056d = new com.bytedance.sdk.component.oq.r.r(5, Integer.MAX_VALUE, 30L, TimeUnit.SECONDS, new SynchronousQueue(), new com.ss.android.socialbase.downloader.ws.j(g.class.getName() + "-InstallFinishCheckCPUThreadPool"));
                    }
                } finally {
                }
            }
        }
        return this.f38056d;
    }

    public ExecutorService j() {
        if (this.f38053a == null) {
            synchronized (e.class) {
                try {
                    if (this.f38053a == null) {
                        this.f38053a = new com.bytedance.sdk.component.oq.r.r(0, Integer.MAX_VALUE, 30L, TimeUnit.SECONDS, new SynchronousQueue(), new com.ss.android.socialbase.downloader.ws.j(g.class.getName() + "-CPUThreadPool"));
                    }
                } finally {
                }
            }
        }
        return this.f38053a;
    }

    public void l(Runnable runnable, boolean z5) {
        if (runnable == null) {
            return;
        }
        if (!z5 || a.h.K()) {
            a().execute(runnable);
        } else {
            runnable.run();
        }
    }

    public static e c() {
        return b.f38058a;
    }

    public void e(Runnable runnable, long j6) {
        try {
            h().schedule(runnable, j6, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.vl.j(th);
        }
    }
}
