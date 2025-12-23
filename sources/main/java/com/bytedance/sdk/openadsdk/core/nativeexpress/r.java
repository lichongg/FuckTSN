package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.text.TextUtils;
import com.bykv.vk.openvk.component.video.api.up.j;
import com.bytedance.sdk.component.adexpress.j.xt.ae;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.s;
import com.bytedance.sdk.openadsdk.core.tj.h;
import com.bytedance.sdk.openadsdk.core.tj.ln;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.tj.nd;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\Downloads\app\classes4.dex */
public class r {
    private List<n> ae;
    private Context cw;

    /* renamed from: j, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.i.cw.cw.xt f29696j;

    /* renamed from: m, reason: collision with root package name */
    private List<n> f29697m;

    /* renamed from: r, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.tj.j.xt.j.m f29698r;
    private j tl;
    private final AtomicBoolean up = new AtomicBoolean(false);

    /* renamed from: g, reason: collision with root package name */
    private int f29695g = 5;
    private ScheduledFuture<?> oq = null;
    private ScheduledFuture<?> qv = null;
    private AtomicBoolean vl = new AtomicBoolean(false);
    private final com.bytedance.sdk.openadsdk.core.s xt = com.bytedance.sdk.openadsdk.core.v.j();

    public interface j {
        void j();

        void j(List<n> list);
    }

    public static class xt implements j {

        /* renamed from: j, reason: collision with root package name */
        private final j f29705j;

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.r.j
        public void j(final List<n> list) {
            com.bytedance.sdk.openadsdk.l.ae.j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.r.xt.1
                @Override // java.lang.Runnable
                public void run() {
                    xt.this.f29705j.j(list);
                }
            });
        }

        public xt(j jVar) {
            this.f29705j = jVar;
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.r.j
        public void j() {
            com.bytedance.sdk.openadsdk.l.ae.j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.r.xt.2
                @Override // java.lang.Runnable
                public void run() {
                    xt.this.f29705j.j();
                }
            });
        }
    }

    private r(Context context) {
        if (context != null) {
            this.cw = StubApp.getOrigApplicationContext(context.getApplicationContext());
        } else {
            this.cw = com.bytedance.sdk.openadsdk.core.v.getContext();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(long j6) {
        List<com.bytedance.sdk.openadsdk.i.cw.xt.ws> j7 = j();
        if (!j7.isEmpty()) {
            com.bytedance.sdk.openadsdk.core.jy.cw.xt(this.ae.get(0), uf.xt(this.f29696j.kt()), j6);
            this.f29698r.j(j7);
        } else {
            this.f29698r.j(104, com.bytedance.sdk.openadsdk.core.g.j(104));
            j(104);
        }
        xt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void up(final long j6) {
        com.bytedance.sdk.openadsdk.core.ugeno.oq.j(this.ae, new av() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.r.5
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.av
            public void j() {
                r.this.cw(j6);
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.av
            public void xt() {
                r.this.cw(j6);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cw(final long j6) {
        if (this.vl.get()) {
            return;
        }
        this.vl.set(true);
        com.bytedance.sdk.openadsdk.l.ae.xt(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.r.4
            @Override // java.lang.Runnable
            public void run() {
                r.this.r(j6);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xt(final long j6) {
        com.bytedance.sdk.openadsdk.core.vl.j.j(this.ae, new ae.j() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.r.3
            @Override // com.bytedance.sdk.component.adexpress.j.xt.ae.j
            public void j() {
                r.this.cw(j6);
            }

            @Override // com.bytedance.sdk.component.adexpress.j.xt.ae.j
            public void xt() {
                r.this.cw(j6);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xt() {
        List<n> list = this.f29697m;
        if (list != null) {
            list.clear();
        }
        List<n> list2 = this.ae;
        if (list2 != null) {
            list2.clear();
        }
        j(true);
        xt(true);
    }

    public static r j(Context context) {
        return new r(context);
    }

    public void j(com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, int i6, com.bytedance.sdk.openadsdk.tj.j.xt.j.m mVar, int i7) {
        j(xtVar, i6, mVar, null, i7);
    }

    public void j(com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, int i6, com.bytedance.sdk.openadsdk.tj.j.xt.j.m mVar, j jVar, int i7) {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.up.get()) {
            com.bytedance.sdk.component.utils.vl.r("ExpressAdLoadManager", "express ad is loading...");
            return;
        }
        this.f29695g = i6;
        this.up.set(true);
        this.f29696j = xtVar;
        this.f29698r = mVar;
        this.tl = jVar;
        j(xtVar, currentTimeMillis);
    }

    private void xt(boolean z5) {
        try {
            ScheduledFuture<?> scheduledFuture = this.qv;
            if (scheduledFuture == null || scheduledFuture.isCancelled()) {
                return;
            }
            this.qv.cancel(z5);
        } catch (Throwable unused) {
        }
    }

    private void j(final com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, final long j6) {
        if (xtVar == null) {
            return;
        }
        nd ndVar = new nd();
        ndVar.f30364m = 2;
        Object obj = this.f29698r;
        if (obj != null && (obj instanceof com.bytedance.sdk.openadsdk.core.j.xt)) {
            ndVar.tl = ((com.bytedance.sdk.openadsdk.core.j.xt) obj).xt();
        }
        this.xt.j(xtVar, ndVar, this.f29695g, new s.xt() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.r.1
            @Override // com.bytedance.sdk.openadsdk.core.s.xt
            public void j(int i6, String str, com.bytedance.sdk.openadsdk.core.tj.xt xtVar2) {
                r.this.j(i6, str);
                xtVar2.j(i6);
                com.bytedance.sdk.openadsdk.core.tj.xt.j(xtVar2);
            }

            @Override // com.bytedance.sdk.openadsdk.core.s.xt
            public void j(com.bytedance.sdk.openadsdk.core.tj.j jVar, com.bytedance.sdk.openadsdk.core.tj.xt xtVar2) {
                if (jVar.xt() == null || jVar.xt().isEmpty()) {
                    r.this.j(-3, com.bytedance.sdk.openadsdk.core.g.j(-3));
                    xtVar2.j(-3);
                    com.bytedance.sdk.openadsdk.core.tj.xt.j(xtVar2);
                } else {
                    r.this.f29697m = new CopyOnWriteArrayList(jVar.xt());
                    r.this.ae = new CopyOnWriteArrayList(jVar.xt());
                    r.this.j(xtVar);
                    r.this.j(j6);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar) {
        if (this.f29697m == null) {
            return;
        }
        String up = (xtVar == null || !(xtVar.kt() == 3 || xtVar.kt() == 4)) ? null : com.bytedance.sdk.openadsdk.l.g.up();
        for (n nVar : this.f29697m) {
            com.bytedance.sdk.openadsdk.core.video.cw.j.xt(nVar);
            if (nVar.sj() && nVar.fp() != null && !nVar.fp().isEmpty()) {
                for (h hVar : nVar.fp()) {
                    if (!TextUtils.isEmpty(hVar.j())) {
                        com.bytedance.sdk.openadsdk.core.v.up.j().cw().j(new com.bytedance.sdk.openadsdk.ws.xt(hVar.j(), hVar.ae()), com.bytedance.sdk.openadsdk.core.v.j.j.xt(), hVar.xt(), hVar.cw(), up);
                    }
                }
            }
            if (!TextUtils.isEmpty(ln.j(nVar))) {
                if (com.bytedance.sdk.openadsdk.core.v.xt().r(String.valueOf(uf.g(nVar))) && com.bytedance.sdk.openadsdk.core.v.xt().yu()) {
                    com.bykv.vk.openvk.component.video.api.cw.r j6 = ln.j(4, nVar);
                    j6.j("material_meta", nVar);
                    j6.j("ad_slot", Integer.valueOf(xtVar != null ? xtVar.kt() : 0));
                    com.bytedance.sdk.openadsdk.core.video.r.xt.j(j6, (j.InterfaceC0307j) null);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(final long j6) {
        this.vl.set(false);
        if (this.up.getAndSet(false)) {
            com.bytedance.sdk.openadsdk.l.ae.xt(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.r.2
                @Override // java.lang.Runnable
                public void run() {
                    if (r.this.ae == null || r.this.ae.size() <= 0) {
                        if (r.this.f29698r != null) {
                            r.this.f29698r.j(108, com.bytedance.sdk.openadsdk.core.g.j(108));
                            r.this.j(108);
                        }
                        if (r.this.tl != null) {
                            r.this.tl.j();
                        }
                        r.this.xt();
                        return;
                    }
                    if (r.this.f29698r != null) {
                        r rVar = r.this;
                        if (rVar.j((List<n>) rVar.ae)) {
                            r.this.up(j6);
                        } else {
                            r.this.xt(j6);
                        }
                    }
                    if (r.this.tl != null) {
                        r.this.tl.j(r.this.ae);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean j(List<n> list) {
        if (list != null && list.size() != 0) {
            Iterator<n> it = list.iterator();
            while (it.hasNext()) {
                if (com.bytedance.sdk.openadsdk.core.ugeno.oq.g(it.next())) {
                    return true;
                }
            }
        }
        return false;
    }

    private List<com.bytedance.sdk.openadsdk.i.cw.xt.ws> j() {
        if (this.f29695g != 5) {
            ArrayList arrayList = new ArrayList(this.ae.size());
            Iterator<n> it = this.ae.iterator();
            while (it.hasNext()) {
                com.bytedance.sdk.openadsdk.i.cw.xt.ws j6 = j(it.next());
                if (j6 != null) {
                    arrayList.add(j6);
                }
            }
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        for (n nVar : this.ae) {
            if (nVar != null) {
                arrayList2.add(nVar);
            }
        }
        ArrayList arrayList3 = new ArrayList(arrayList2.size());
        if (arrayList2.size() > 0) {
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                com.bytedance.sdk.openadsdk.i.cw.xt.ws j7 = j((n) it2.next());
                if (j7 != null) {
                    arrayList3.add(j7);
                }
            }
            arrayList2.clear();
        }
        return arrayList3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(final int i6) {
        com.bytedance.sdk.openadsdk.core.kt.ws.j().up(new com.bytedance.sdk.openadsdk.vl.j.j() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.r.6
            @Override // com.bytedance.sdk.openadsdk.vl.j.j
            public com.bytedance.sdk.openadsdk.core.kt.j.j j() throws Exception {
                com.bytedance.sdk.openadsdk.core.kt.j.xt m6 = com.bytedance.sdk.openadsdk.core.kt.j.xt.xt().j(r.this.f29695g).cw(r.this.f29696j.r()).m((r.this.f29697m == null || r.this.f29697m.size() <= 0) ? "" : uf.jy((n) r.this.f29697m.get(0)));
                m6.xt(i6).ae(com.bytedance.sdk.openadsdk.core.g.j(i6));
                return m6;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(int i6, String str) {
        if (this.up.getAndSet(false)) {
            com.bytedance.sdk.openadsdk.tj.j.xt.j.m mVar = this.f29698r;
            if (mVar != null) {
                mVar.j(i6, str);
            }
            j jVar = this.tl;
            if (jVar != null) {
                jVar.j();
            }
            xt();
        }
    }

    private com.bytedance.sdk.openadsdk.i.cw.xt.ws j(n nVar) {
        if (this.cw == null) {
            return null;
        }
        boolean z5 = ln.ws(nVar) != null;
        int i6 = this.f29695g;
        if (i6 == 1) {
            if (z5) {
                return new com.bytedance.sdk.openadsdk.core.bannerexpress.cw(this.cw, nVar, this.f29696j);
            }
            return new com.bytedance.sdk.openadsdk.core.bannerexpress.xt(this.cw, nVar, this.f29696j);
        }
        if (i6 == 5) {
            if (z5) {
                return new ch(this.cw, nVar, this.f29696j);
            }
            return new v(this.cw, nVar, this.f29696j);
        }
        if (i6 != 9) {
            com.bytedance.sdk.component.utils.vl.xt("ExpressAdLoadManager", "not support adslog:" + this.f29695g);
            return null;
        }
        return new x(this.cw, nVar, this.f29696j);
    }

    private void j(boolean z5) {
        try {
            ScheduledFuture<?> scheduledFuture = this.oq;
            if (scheduledFuture == null || scheduledFuture.isCancelled()) {
                return;
            }
            com.bytedance.sdk.component.utils.vl.r("ExpressAdLoadManager", "CheckValidFutureTask-->cancel......success=".concat(String.valueOf(this.oq.cancel(z5))));
        } catch (Throwable unused) {
        }
    }
}
