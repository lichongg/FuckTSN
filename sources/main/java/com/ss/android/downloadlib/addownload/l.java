package com.ss.android.downloadlib.addownload;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bytedance.sdk.component.oq.r.xt;
import com.bytedance.sdk.component.utils.vl;
import com.ss.android.downloadlib.a;
import com.ss.android.downloadlib.addownload.j;
import com.ss.android.downloadlib.addownload.k;
import com.ss.android.downloadlib.addownload.o;
import com.ss.android.downloadlib.b;
import com.ss.android.j.j.cw.a;
import com.ss.android.socialbase.appdownloader.DownloadHandlerService;
import com.ss.android.socialbase.downloader.ae.cw;
import com.ss.android.socialbase.downloader.downloader.ae;
import com.ss.android.socialbase.downloader.downloader.r;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
import w2.t;

/* loaded from: D:\Downloads\app\classes6.dex */
public class l implements com.ss.android.downloadlib.addownload.a, a.p.InterfaceC0739a {

    /* renamed from: u, reason: collision with root package name */
    private static final String f37847u = "l";

    /* renamed from: a, reason: collision with root package name */
    private final a.p f37848a;

    /* renamed from: b, reason: collision with root package name */
    private com.ss.android.downloadlib.addownload.k f37849b;

    /* renamed from: c, reason: collision with root package name */
    private com.ss.android.downloadlib.addownload.j f37850c;

    /* renamed from: d, reason: collision with root package name */
    private WeakReference<Context> f37851d;

    /* renamed from: e, reason: collision with root package name */
    private final Map<Integer, Object> f37852e;

    /* renamed from: f, reason: collision with root package name */
    private com.ss.android.j.j.up.e f37853f;

    /* renamed from: g, reason: collision with root package name */
    private cw f37854g;

    /* renamed from: h, reason: collision with root package name */
    private j f37855h;

    /* renamed from: i, reason: collision with root package name */
    private final com.ss.android.socialbase.downloader.r.a f37856i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f37857j;

    /* renamed from: k, reason: collision with root package name */
    private long f37858k;

    /* renamed from: l, reason: collision with root package name */
    private String f37859l;

    /* renamed from: m, reason: collision with root package name */
    private long f37860m;

    /* renamed from: n, reason: collision with root package name */
    private com.ss.android.j.j.cw.b f37861n;

    /* renamed from: o, reason: collision with root package name */
    private com.ss.android.j.j.cw.g f37862o;

    /* renamed from: p, reason: collision with root package name */
    private com.ss.android.j.j.cw.c f37863p;

    /* renamed from: q, reason: collision with root package name */
    private SoftReference<w2.d> f37864q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f37865r;

    /* renamed from: s, reason: collision with root package name */
    private final boolean f37866s;

    /* renamed from: t, reason: collision with root package name */
    private SoftReference<w2.h> f37867t;

    class a implements com.ss.android.downloadlib.addownload.compliance.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f37868a;

        @Override // com.ss.android.downloadlib.addownload.compliance.d
        public void j(String str) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("download_miui_new_market", 1);
                jSONObject.putOpt("download_miui_market_deeplink", str);
                if (a.m.B(l.this.getContext(), l.this.f37849b.f37837b, str, jSONObject, true, this.f37868a)) {
                    jSONObject.putOpt("download_miui_jump_market_success", 1);
                    com.ss.android.downloadlib.addownload.compliance.c.a().d(0, l.this.f37849b.f37837b, jSONObject);
                    return;
                }
                jSONObject.putOpt("download_miui_jump_market_success", 0);
                com.ss.android.downloadlib.addownload.compliance.c.a().d(1, l.this.f37849b.f37837b, jSONObject);
                int i6 = this.f37868a;
                if (i6 == 1) {
                    com.ss.android.socialbase.downloader.m.j.j(l.f37847u, "miui new rollback fail: handleDownload id:" + l.this.f37860m + ",tryPerformButtonClick:", null);
                    l.this.n(true);
                    return;
                }
                if (i6 != 2) {
                    return;
                }
                com.ss.android.socialbase.downloader.m.j.j(l.f37847u, "miui new rollback fail: handleDownload id:" + l.this.f37860m + ",tryPerformButtonClick:", null);
                l.this.X(true);
            } catch (Exception e6) {
                com.ss.android.downloadlib.up.a.a().j(e6, "generate miui new market param error");
            }
        }

        a(int i6) {
            this.f37868a = i6;
        }

        @Override // com.ss.android.downloadlib.addownload.compliance.d
        public void j() {
            int i6 = this.f37868a;
            if (i6 == 1) {
                com.ss.android.socialbase.downloader.m.j.j(l.f37847u, "miui new get miui deeplink fail: handleDownload id:" + l.this.f37860m + ",tryPerformButtonClick:", null);
                l.this.n(true);
                return;
            }
            if (i6 != 2) {
                return;
            }
            com.ss.android.socialbase.downloader.m.j.j(l.f37847u, "miui new get miui deeplink fail: handleDownload id:" + l.this.f37860m + ",tryPerformButtonClick:", null);
            l.this.X(true);
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator<com.ss.android.j.j.cw.e> it = com.ss.android.downloadlib.addownload.k.g(l.this.f37852e).iterator();
            while (it.hasNext()) {
                it.next().onInstalled(l.this.s());
            }
        }
    }

    class c implements k {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f37871a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f37872b;

        c(int i6, int i7) {
            this.f37871a = i6;
            this.f37872b = i7;
        }

        @Override // com.ss.android.downloadlib.addownload.l.k
        public void j() {
            if (l.this.f37850c.o()) {
                return;
            }
            l lVar = l.this;
            lVar.A(this.f37871a, this.f37872b, lVar.f37854g);
        }
    }

    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            m.d().j(13, m.getContext(), l.this.f37861n, "已恢复下载", null, 0);
        }
    }

    class e implements com.ss.android.downloadlib.addownload.j.a {
        e() {
        }

        @Override // com.ss.android.downloadlib.addownload.j.a
        public void delete() {
            l.this.j(true);
        }
    }

    class f implements j.o {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f37876a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f37877b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.ss.android.xt.j.xt.b f37878c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f37879d;

        f(int i6, boolean z5, com.ss.android.xt.j.xt.b bVar, int i7) {
            this.f37876a = i6;
            this.f37877b = z5;
            this.f37878c = bVar;
            this.f37879d = i7;
        }

        @Override // com.ss.android.downloadlib.addownload.j.o
        public void a(com.ss.android.xt.j.xt.b bVar) {
            if (l.this.f37854g == null && com.ss.android.socialbase.downloader.jy.j.cw().j("fix_handle_pause")) {
                l.this.f37854g = ae.xt(m.getContext()).tl(this.f37876a);
            }
            l.this.f37849b.n(l.this.f37854g, this.f37877b);
            if (l.this.f37854g != null && com.ss.android.socialbase.downloader.az.m.xt(m.getContext()) && l.this.f37854g.qb()) {
                l.this.f37854g.k();
                com.ss.android.downloadlib.r.b.a().m("cancel_pause_reserve_wifi_cancel_on_wifi", this.f37878c);
            } else {
                com.ss.android.downloadlib.addownload.i.b().d(l.this.f37861n, l.this.f37854g);
                bVar.m0(System.currentTimeMillis());
                l lVar = l.this;
                lVar.A(this.f37876a, this.f37879d, lVar.f37854g);
            }
        }
    }

    class g implements j.o {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f37881a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f37882b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.ss.android.xt.j.xt.b f37883c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f37884d;

        g(int i6, boolean z5, com.ss.android.xt.j.xt.b bVar, int i7) {
            this.f37881a = i6;
            this.f37882b = z5;
            this.f37883c = bVar;
            this.f37884d = i7;
        }

        @Override // com.ss.android.downloadlib.addownload.j.o
        public void a(com.ss.android.xt.j.xt.b bVar) {
            if (l.this.f37854g == null && com.ss.android.socialbase.downloader.jy.j.cw().j("fix_handle_pause")) {
                l.this.f37854g = ae.xt(m.getContext()).tl(this.f37881a);
            }
            l.this.f37849b.n(l.this.f37854g, this.f37882b);
            if (l.this.f37854g != null && com.ss.android.socialbase.downloader.az.m.xt(m.getContext()) && l.this.f37854g.qb()) {
                l.this.f37854g.k();
                com.ss.android.downloadlib.r.b.a().w("pause_reserve_wifi_cancel_on_wifi", this.f37883c);
            } else {
                com.ss.android.downloadlib.addownload.i.b().d(l.this.f37861n, l.this.f37854g);
                bVar.m0(System.currentTimeMillis());
                l lVar = l.this;
                lVar.A(this.f37881a, this.f37884d, lVar.f37854g);
            }
        }
    }

    class h implements t {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f37886a;

        @Override // w2.t
        public void j() {
            a.k.d(l.f37847u, "pBCD start download", null);
            l.this.i(this.f37886a);
        }

        h(boolean z5) {
            this.f37886a = z5;
        }

        @Override // w2.t
        public void j(String str) {
            a.k.d(l.f37847u, "pBCD onDenied", null);
        }
    }

    class i implements k {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f37888a;

        i(boolean z5) {
            this.f37888a = z5;
        }

        @Override // com.ss.android.downloadlib.addownload.l.k
        public void j() {
            if (l.this.f37850c.o()) {
                return;
            }
            l.this.P(this.f37888a);
        }
    }

    private class j extends xt<String, Void, cw> {
        private j() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public cw doInBackground(String... strArr) {
            cw cwVar = null;
            if (strArr != null && (strArr.length <= 0 || !TextUtils.isEmpty(strArr[0]))) {
                String str = (strArr.length < 3 || TextUtils.isEmpty(strArr[2])) ? "" : strArr[2];
                String str2 = strArr[0];
                if (l.this.f37861n != null && !TextUtils.isEmpty(l.this.f37861n.az())) {
                    cwVar = !TextUtils.isEmpty(str) ? ae.xt(m.getContext()).tl(ae.xt(m.getContext()).j(str, l.this.f37861n.az())) : ae.xt(m.getContext()).xt(str2, l.this.f37861n.az());
                }
                if (cwVar == null) {
                    return !TextUtils.isEmpty(str) ? com.ss.android.socialbase.appdownloader.f.L().j(m.getContext(), str) : com.ss.android.socialbase.appdownloader.f.L().j(m.getContext(), str2);
                }
            }
            return cwVar;
        }

        /* synthetic */ j(l lVar, a aVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(cw cwVar) {
            super.onPostExecute(cwVar);
            if (!isCancelled() && l.this.f37861n != null) {
                try {
                    o.c m6 = a.h.m(l.this.f37861n.s(), l.this.f37861n.f(), l.this.f37861n.v());
                    o.h.a().b(l.this.f37861n.f(), m6.c(), o.f.c().f(cwVar));
                    boolean b6 = m6.b();
                    if (cwVar == null || cwVar.ae() == 0 || (!b6 && ae.xt(m.getContext()).j(cwVar))) {
                        if (cwVar != null && ae.xt(m.getContext()).j(cwVar)) {
                            com.ss.android.socialbase.downloader.notification.xt.j().m(cwVar.ae());
                            l.this.f37854g = null;
                        }
                        if (l.this.f37854g != null) {
                            ae.xt(m.getContext()).qv(l.this.f37854g.ae());
                            if (l.this.f37866s) {
                                ae.xt(l.this.getContext()).j(l.this.f37854g.ae(), l.this.f37856i, false);
                            } else {
                                ae.xt(l.this.getContext()).j(l.this.f37854g.ae(), l.this.f37856i);
                            }
                        }
                        if (b6) {
                            l lVar = l.this;
                            lVar.f37854g = new cw.j(lVar.f37861n.j()).j();
                            l.this.f37854g.r(-3);
                            l.this.f37849b.m(l.this.f37854g, l.this.s(), com.ss.android.downloadlib.addownload.k.g(l.this.f37852e), b6);
                        } else {
                            Iterator<com.ss.android.j.j.cw.e> it = com.ss.android.downloadlib.addownload.k.g(l.this.f37852e).iterator();
                            while (it.hasNext()) {
                                it.next().j();
                            }
                            l.this.f37854g = null;
                        }
                        l.this.f37849b.a(l.this.f37854g);
                    }
                    ae.xt(m.getContext()).qv(cwVar.ae());
                    if (l.this.f37854g == null || l.this.f37854g.i() != -4) {
                        l.this.f37854g = cwVar;
                        if (l.this.f37866s) {
                            ae.xt(m.getContext()).j(l.this.f37854g.ae(), l.this.f37856i, false);
                        } else {
                            ae.xt(m.getContext()).j(l.this.f37854g.ae(), l.this.f37856i);
                        }
                    } else {
                        l.this.f37854g = null;
                    }
                    l.this.f37849b.m(l.this.f37854g, l.this.s(), com.ss.android.downloadlib.addownload.k.g(l.this.f37852e), b6);
                    l.this.f37849b.a(l.this.f37854g);
                } catch (Exception e6) {
                    vl.j(e6);
                }
            }
        }
    }

    interface k {
        void j();
    }

    /* renamed from: com.ss.android.downloadlib.addownload.l$l, reason: collision with other inner class name */
    interface InterfaceC0749l {
        void j(long j6);
    }

    @Override // com.ss.android.downloadlib.addownload.a
    public void j() {
        this.f37857j = true;
        o.f.c().j(this.f37860m, T());
        o.f.c().i(this.f37860m, F());
        this.f37849b.i(this.f37860m);
        k();
        if (m.f().optInt("enable_empty_listener", 1) == 1 && this.f37852e.get(Integer.MIN_VALUE) == null) {
            f(Integer.MIN_VALUE, new w2.i());
        }
    }

    @NonNull
    private com.ss.android.j.j.cw.c F() {
        if (this.f37863p == null) {
            this.f37863p = new com.ss.android.j.j.cw.d();
        }
        return this.f37863p;
    }

    private void I(boolean z5) {
        com.ss.android.j.j.cw.b bVar;
        com.ss.android.j.j.cw.c cVar;
        com.ss.android.j.j.cw.c cVar2;
        String str = f37847u;
        a.k.d(str, "pBCD", null);
        if (l()) {
            o.i r5 = o.f.c().r(this.f37860m);
            if (this.f37865r) {
                if (!q()) {
                    E(z5, true);
                    return;
                } else {
                    if (N(false) && (cVar2 = r5.f37963d) != null && cVar2.jy()) {
                        E(z5, true);
                        return;
                    }
                    return;
                }
            }
            if (this.f37861n.x() && (cVar = r5.f37963d) != null && cVar.vl() && r5.f37961b != null && com.ss.android.downloadlib.addownload.compliance.f.a().g(r5.f37961b) && com.ss.android.downloadlib.addownload.compliance.f.a().f(r5)) {
                return;
            }
            E(z5, true);
            return;
        }
        a.k.d(str, "pBCD continue download, status:" + this.f37854g.i(), null);
        cw cwVar = this.f37854g;
        if (cwVar != null && (bVar = this.f37861n) != null) {
            cwVar.r(bVar.jy());
        }
        int i6 = this.f37854g.i();
        int ae = this.f37854g.ae();
        com.ss.android.xt.j.xt.b f6 = o.f.c().f(this.f37854g);
        if (i6 == -2 || i6 == -1) {
            this.f37849b.n(this.f37854g, z5);
            if (f6 != null) {
                f6.C0(System.currentTimeMillis());
                f6.z(this.f37854g.uq());
            }
            this.f37854g.up(false);
            this.f37850c.j(new o.i(this.f37860m, this.f37861n, T(), F()));
            this.f37850c.g(ae, this.f37854g.uq(), this.f37854g.ka(), new c(ae, i6));
            if (i6 == -2 && a.n.k(f6).j("show_pause_continue_toast", 0) == 1) {
                com.ss.android.downloadlib.c.d().s().postDelayed(new d(), 500L);
                return;
            }
            return;
        }
        if (!com.ss.android.downloadlib.addownload.b.d(i6)) {
            this.f37849b.n(this.f37854g, z5);
            A(ae, i6, this.f37854g);
        } else if (this.f37861n.b()) {
            this.f37850c.n(true);
            b.i.c().l(o.f.c().q(this.f37860m));
            if (a.n.k(f6).j("cancel_pause_optimise_switch", 0) == 1) {
                j.n.a().b(f6, i6, new f(ae, z5, f6, i6), new e());
            } else {
                j.m.a().b(f6, i6, new g(ae, z5, f6, i6));
            }
        }
    }

    private void L() {
        SoftReference<w2.d> softReference = this.f37864q;
        if (softReference != null && softReference.get() != null) {
            this.f37864q.get().onItemClick(this.f37861n, T(), F());
            this.f37864q = null;
        } else {
            m.K();
            getContext();
            F();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(boolean z5) {
        Iterator<com.ss.android.j.j.cw.e> it = com.ss.android.downloadlib.addownload.k.g(this.f37852e).iterator();
        while (it.hasNext()) {
            it.next().onDownloadStart(this.f37861n, F());
        }
        int c6 = this.f37849b.c(m.getContext(), this.f37856i);
        String str = f37847u;
        a.k.d(str, "beginDown id:" + c6, null);
        if (c6 == 0) {
            cw j6 = new cw.j(this.f37861n.j()).j();
            j6.r(-1);
            D(j6);
            com.ss.android.downloadlib.r.b.a().e(this.f37860m, new com.ss.android.socialbase.downloader.up.j(2, "start download failed, id=0"));
            com.ss.android.downloadlib.up.a.a().f("beginDown");
        } else if (this.f37854g != null && !com.ss.android.socialbase.downloader.jy.j.cw().j("fix_click_start")) {
            this.f37849b.n(this.f37854g, false);
        } else if (z5) {
            this.f37849b.h();
        }
        if (this.f37849b.s(o())) {
            a.k.d(str, "beginDown IC id:" + c6, null);
            L();
        }
    }

    private void R(boolean z5) {
        if (a.n.x(this.f37861n).xt("notification_opt_2") == 1 && this.f37854g != null) {
            com.ss.android.socialbase.downloader.notification.xt.j().m(this.f37854g.ae());
        }
        I(z5);
    }

    @NonNull
    private com.ss.android.j.j.cw.g T() {
        com.ss.android.j.j.cw.g gVar = this.f37862o;
        return gVar == null ? new a.b().g() : gVar;
    }

    private void U() {
        String str = f37847u;
        a.k.d(str, "pICD", null);
        if (this.f37849b.w(this.f37854g)) {
            a.k.d(str, "pICD BC", null);
            I(false);
        } else {
            a.k.d(str, "pICD IC", null);
            L();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Context getContext() {
        WeakReference<Context> weakReference = this.f37851d;
        return (weakReference == null || weakReference.get() == null) ? m.getContext() : this.f37851d.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(boolean z5) {
        this.f37850c.j(new o.i(this.f37860m, this.f37861n, T(), F()));
        this.f37850c.g(0, 0L, 0L, new i(z5));
    }

    private void k() {
        j jVar = this.f37855h;
        if (jVar != null && jVar.getStatus() != AsyncTask.Status.FINISHED) {
            this.f37855h.cancel(true);
        }
        this.f37855h = new j(this, null);
        if (TextUtils.isEmpty(this.f37859l)) {
            a.q.a(this.f37855h, this.f37861n.j(), this.f37861n.s());
        } else {
            a.q.a(this.f37855h, this.f37861n.j(), this.f37861n.s(), this.f37859l);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.ss.android.j.j.up.e s() {
        if (this.f37853f == null) {
            this.f37853f = new com.ss.android.j.j.up.e();
        }
        return this.f37853f;
    }

    public void E(boolean z5, boolean z6) {
        if (z5) {
            com.ss.android.downloadlib.r.b.a().c(this.f37860m, 2);
        }
        if (a.h.v()) {
            if (!a.j.f("android.permission.READ_MEDIA_IMAGES") && !a.j.f("android.permission.READ_MEDIA_AUDIO") && !a.j.f("android.permission.READ_MEDIA_VIDEO") && !F().ws()) {
                this.f37861n.j(this.f37849b.z());
            }
        } else if (!a.j.f(com.kuaishou.weapon.p0.g.f36050j) && !F().ws()) {
            this.f37861n.j(this.f37849b.z());
        }
        if (a.n.c(this.f37861n) != 0) {
            i(z6);
        } else {
            a.k.d(f37847u, "pBCD not start", null);
            this.f37849b.o(new h(z6));
        }
    }

    public void H() {
        this.f37848a.post(new b());
    }

    public boolean N(boolean z5) {
        SoftReference<w2.h> softReference = this.f37867t;
        if (softReference == null || softReference.get() == null) {
            com.ss.android.downloadlib.up.a.a().f("mDownloadButtonClickListener has recycled");
            return false;
        }
        try {
            if (z5) {
                this.f37867t.get().j();
            } else {
                this.f37867t.get().j(true);
            }
            this.f37867t = null;
            return true;
        } catch (Exception unused) {
            com.ss.android.downloadlib.up.a.a().f("mDownloadButtonClickListener has recycled");
            return false;
        }
    }

    @Override // com.ss.android.downloadlib.addownload.a
    public com.ss.android.downloadlib.addownload.a a(w2.h hVar) {
        if (hVar == null) {
            this.f37867t = null;
            return this;
        }
        this.f37867t = new SoftReference<>(hVar);
        return this;
    }

    @Override // com.ss.android.downloadlib.addownload.a
    public com.ss.android.downloadlib.addownload.a d(w2.d dVar) {
        if (dVar == null) {
            this.f37864q = null;
            return this;
        }
        this.f37864q = new SoftReference<>(dVar);
        return this;
    }

    public void h() {
        if (this.f37852e.size() == 0) {
            return;
        }
        Iterator<com.ss.android.j.j.cw.e> it = com.ss.android.downloadlib.addownload.k.g(this.f37852e).iterator();
        while (it.hasNext()) {
            it.next().j();
        }
        cw cwVar = this.f37854g;
        if (cwVar != null) {
            cwVar.r(-4);
        }
    }

    public void n(boolean z5) {
        if (z5) {
            com.ss.android.downloadlib.r.b.a().c(this.f37860m, 1);
        }
        U();
    }

    public boolean o() {
        cw cwVar = this.f37854g;
        return (cwVar == null || cwVar.i() == 0) ? false : true;
    }

    public boolean q() {
        SoftReference<w2.h> softReference = this.f37867t;
        if (softReference == null) {
            return false;
        }
        return com.ss.android.downloadlib.addownload.d.h(this.f37861n, softReference.get());
    }

    @Override // com.ss.android.downloadlib.addownload.a
    public long r() {
        return this.f37858k;
    }

    @Override // com.ss.android.downloadlib.addownload.a
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public l f(int i6, com.ss.android.j.j.cw.e eVar) {
        if (eVar != null) {
            if (m.f().optInt("back_use_softref_listener") == 1) {
                this.f37852e.put(Integer.valueOf(i6), eVar);
                return this;
            }
            if (m.f().optInt("use_weakref_listener") == 1) {
                this.f37852e.put(Integer.valueOf(i6), new WeakReference(eVar));
                return this;
            }
            this.f37852e.put(Integer.valueOf(i6), new SoftReference(eVar));
        }
        return this;
    }

    @Override // com.ss.android.downloadlib.addownload.a
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public l xt(Context context) {
        if (context != null) {
            this.f37851d = new WeakReference<>(context);
        }
        m.L(context);
        return this;
    }

    @Override // com.ss.android.downloadlib.addownload.a
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public l b(com.ss.android.j.j.cw.b bVar) {
        if (bVar != null) {
            if (bVar.x()) {
                if (bVar.r() <= 0 || TextUtils.isEmpty(bVar.ch())) {
                    com.ss.android.downloadlib.up.a.a().c("setDownloadModel ad error");
                }
            } else if (bVar.r() == 0 && (bVar instanceof com.ss.android.xt.j.j.a)) {
                com.ss.android.downloadlib.up.a.a().d(false, "setDownloadModel id=0");
                if (com.ss.android.socialbase.downloader.jy.j.cw().j("fix_model_id")) {
                    ((com.ss.android.xt.j.j.a) bVar).f(bVar.j().hashCode());
                }
            }
            o.f.c().k(bVar);
            this.f37860m = bVar.r();
            this.f37861n = bVar;
            if (com.ss.android.downloadlib.addownload.d.g(bVar)) {
                ((com.ss.android.xt.j.j.a) bVar).G(3L);
                com.ss.android.xt.j.xt.b q5 = o.f.c().q(this.f37860m);
                if (q5 != null && q5.vl() != 3) {
                    q5.H0(3L);
                    o.d.c().d(q5);
                }
            }
        }
        return this;
    }

    @Override // com.ss.android.downloadlib.addownload.a
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public l e(com.ss.android.j.j.cw.c cVar) {
        JSONObject h6;
        this.f37863p = cVar;
        if (a.n.x(this.f37861n).xt("force_auto_open") == 1) {
            F().xt(1);
        }
        if (com.ss.android.socialbase.downloader.jy.j.cw().j("fix_show_dialog") && (h6 = this.f37861n.h()) != null && h6.optInt("subprocess") > 0) {
            F().xt(false);
        }
        o.f.c().i(this.f37860m, F());
        return this;
    }

    @Override // com.ss.android.downloadlib.addownload.a
    public boolean xt() {
        return this.f37857j;
    }

    @Override // com.ss.android.downloadlib.addownload.a
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public l c(com.ss.android.j.j.cw.g gVar) {
        this.f37862o = gVar;
        this.f37865r = T().qv() == 0;
        o.f.c().j(this.f37860m, T());
        return this;
    }

    public l() {
        a.p pVar = new a.p(Looper.getMainLooper(), this);
        this.f37848a = pVar;
        this.f37852e = new ConcurrentHashMap();
        this.f37856i = new k.d(pVar);
        this.f37860m = -1L;
        this.f37861n = null;
        this.f37862o = null;
        this.f37863p = null;
        this.f37849b = new com.ss.android.downloadlib.addownload.k(this);
        this.f37850c = new com.ss.android.downloadlib.addownload.j(pVar);
        this.f37866s = com.ss.android.socialbase.downloader.jy.j.cw().j("ttdownloader_callback_twice");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(int i6, int i7, @NonNull cw cwVar) {
        if (com.ss.android.socialbase.downloader.jy.j.cw().j("fix_click_start")) {
            if (i7 != -3 && !r.j().up(i6)) {
                E(false, false);
                return;
            } else {
                com.ss.android.socialbase.appdownloader.f.L().r(m.getContext(), i6, i7);
                return;
            }
        }
        com.ss.android.socialbase.appdownloader.f.L().r(m.getContext(), i6, i7);
    }

    private void D(cw cwVar) {
        Message obtain = Message.obtain();
        obtain.what = 3;
        obtain.obj = cwVar;
        this.f37848a.sendMessage(obtain);
    }

    private boolean l() {
        if (com.ss.android.socialbase.downloader.jy.j.cw().j("fix_click_start")) {
            cw cwVar = this.f37854g;
            if (cwVar == null) {
                return true;
            }
            if ((cwVar.i() == -3 && this.f37854g.uq() <= 0) || this.f37854g.i() == 0 || this.f37854g.i() == -4) {
                return true;
            }
            if (!com.ss.android.socialbase.downloader.az.m.j(this.f37854g.i(), this.f37854g.qv(), this.f37854g.tl())) {
                return false;
            }
            return true;
        }
        cw cwVar2 = this.f37854g;
        if (cwVar2 == null) {
            return true;
        }
        if ((cwVar2.i() == -3 || ae.xt(m.getContext()).r(this.f37854g.ae())) && this.f37854g.i() != 0) {
            return false;
        }
        return true;
    }

    private boolean p(int i6) {
        int i7;
        if (!S()) {
            return false;
        }
        String a6 = this.f37861n.gq().a();
        if (i6 != 1) {
            if (i6 != 2) {
                i7 = -1;
            } else {
                i7 = 4;
            }
        } else {
            i7 = 5;
        }
        com.ss.android.j.j.cw.b bVar = this.f37861n;
        if (bVar instanceof com.ss.android.xt.j.j.a) {
            ((com.ss.android.xt.j.j.a) bVar).e(3);
        }
        boolean a7 = a.f.a(m.getContext(), a6);
        if (a7) {
            com.ss.android.downloadlib.r.b.a().c(this.f37860m, i6);
            Message obtain = Message.obtain();
            obtain.what = i7;
            obtain.obj = Long.valueOf(this.f37861n.r());
            com.ss.android.downloadlib.addownload.c.a().c(this, i7, this.f37861n);
            return a7;
        }
        com.ss.android.downloadlib.r.b.a().f(this.f37860m, false, 0);
        return a7;
    }

    public boolean S() {
        if (m.f().optInt("quick_app_enable_switch", 0) != 0 || this.f37861n.gq() == null || TextUtils.isEmpty(this.f37861n.gq().a()) || !com.ss.android.downloadlib.addownload.c.e(this.f37854g) || !a.h.x(getContext(), new Intent("android.intent.action.VIEW", Uri.parse(this.f37861n.gq().a())))) {
            return false;
        }
        return true;
    }

    public void X(boolean z5) {
        R(z5);
    }

    @Override // com.ss.android.downloadlib.addownload.a
    public void tl() {
        o.f.c().p(this.f37860m);
    }

    @Override // com.ss.android.downloadlib.addownload.a
    public void xt(int i6) {
        if (i6 != 1 && i6 != 2) {
            throw new IllegalArgumentException("error actionType");
        }
        this.f37849b.i(this.f37860m);
        if (!o.f.c().r(this.f37860m).a()) {
            com.ss.android.downloadlib.up.a.a().c("handleDownload ModelBox !isStrictValid");
        }
        if (this.f37849b.q(i6, this.f37861n)) {
            com.ss.android.downloadlib.addownload.compliance.c.a().g(this.f37849b.f37837b, new a(i6));
            return;
        }
        if (this.f37849b.r(getContext(), i6, this.f37865r)) {
            return;
        }
        boolean p5 = p(i6);
        if (i6 == 1) {
            if (p5) {
                return;
            }
            a.k.d(f37847u, "handleDownload id:" + this.f37860m + ",pIC:", null);
            n(true);
            return;
        }
        if (i6 == 2 && !p5) {
            a.k.d(f37847u, "handleDownload id:" + this.f37860m + ",pBC:", null);
            X(true);
        }
    }

    @Override // com.ss.android.downloadlib.addownload.a
    public boolean j(int i6) {
        if (i6 == 0) {
            this.f37852e.clear();
        } else {
            this.f37852e.remove(Integer.valueOf(i6));
        }
        if (this.f37852e.isEmpty()) {
            this.f37857j = false;
            this.f37858k = System.currentTimeMillis();
            if (this.f37854g != null) {
                ae.xt(m.getContext()).qv(this.f37854g.ae());
            }
            j jVar = this.f37855h;
            if (jVar != null && jVar.getStatus() != AsyncTask.Status.FINISHED) {
                this.f37855h.cancel(true);
            }
            this.f37849b.l(this.f37854g);
            String str = f37847u;
            StringBuilder sb = new StringBuilder("onUnbind removeCallbacksAndMessages, downloadUrl:");
            cw cwVar = this.f37854g;
            sb.append(cwVar == null ? "" : cwVar.oq());
            a.k.d(str, sb.toString(), null);
            this.f37848a.removeCallbacksAndMessages(null);
            this.f37853f = null;
            this.f37854g = null;
            return true;
        }
        if (this.f37852e.size() == 1 && this.f37852e.containsKey(Integer.MIN_VALUE)) {
            this.f37849b.B(this.f37854g);
        }
        return false;
    }

    @Override // com.ss.android.downloadlib.addownload.a
    public void j(boolean z5) {
        if (this.f37854g != null) {
            if (z5) {
                x2.m d6 = com.ss.android.socialbase.appdownloader.f.L().d();
                if (d6 != null) {
                    d6.j(this.f37854g);
                }
                ae.xt(com.ss.android.socialbase.downloader.downloader.cw.nd()).j(this.f37854g.ae(), true);
                return;
            }
            Intent intent = new Intent(m.getContext(), (Class<?>) DownloadHandlerService.class);
            intent.setAction("android.ss.intent.action.DOWNLOAD_DELETE");
            intent.putExtra("extra_click_download_ids", this.f37854g.ae());
            m.getContext().startService(intent);
        }
    }

    @Override // com.ss.android.downloadlib.addownload.a
    public com.ss.android.downloadlib.addownload.a j(long j6) {
        if (j6 != 0) {
            com.ss.android.j.j.cw.b d6 = o.f.c().d(j6);
            if (d6 != null) {
                this.f37861n = d6;
                this.f37860m = j6;
                this.f37849b.i(j6);
            }
            return this;
        }
        com.ss.android.downloadlib.up.a.a().d(false, "setModelId");
        return this;
    }

    @Override // com.ss.android.downloadlib.a.p.InterfaceC0739a
    public void j(Message message) {
        if (message != null && this.f37857j && message.what == 3) {
            this.f37854g = (cw) message.obj;
            this.f37849b.k(message, s(), this.f37852e);
        }
    }

    @Override // com.ss.android.downloadlib.addownload.a
    public com.ss.android.downloadlib.addownload.a j(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f37859l = str;
        }
        return this;
    }
}
