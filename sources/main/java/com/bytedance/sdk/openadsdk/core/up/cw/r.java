package com.bytedance.sdk.openadsdk.core.up.cw;

import android.text.TextUtils;
import com.bytedance.sdk.component.oq.g;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.tj.tl;
import com.bytedance.sdk.openadsdk.l.ae;
import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\Downloads\app\classes4.dex */
public class r implements com.bytedance.sdk.openadsdk.core.up.cw.j {
    static ReferenceQueue<Object> xt = new ReferenceQueue<>();
    private int cw;

    /* renamed from: j, reason: collision with root package name */
    Map<Object, j> f30847j = new ConcurrentHashMap();

    @Override // com.bytedance.sdk.openadsdk.core.up.cw.j
    public boolean j(String str) {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.up.cw.j
    public void xt(final com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, final n nVar) {
        if (TextUtils.isEmpty(xtVar.tj())) {
            if (nVar.xj() <= 0) {
                nVar.up((System.currentTimeMillis() + 10500000) / 1000);
            }
            ae.r(new g("PreloadStrategyRecovery-onNetworkResponse") { // from class: com.bytedance.sdk.openadsdk.core.up.cw.r.2
                @Override // java.lang.Runnable
                public void run() {
                    int i6;
                    System.currentTimeMillis();
                    tl.j j6 = com.bytedance.sdk.openadsdk.core.up.up.xt.j(r.this.cw);
                    if (j6 != null) {
                        i6 = j6.g();
                    } else {
                        i6 = 0;
                    }
                    if ((i6 & 1) == 1) {
                        com.bytedance.sdk.openadsdk.core.up.r.r.j(r.this.cw).j(xtVar, nVar, false);
                        System.currentTimeMillis();
                    }
                }
            });
        }
    }

    private static class j {

        /* renamed from: j, reason: collision with root package name */
        String f30855j;
        String xt;

        public j(String str, String str2) {
            this.f30855j = str;
            this.xt = str2;
        }
    }

    public r(int i6) {
        this.cw = i6;
    }

    @Override // com.bytedance.sdk.openadsdk.core.up.cw.j
    public void cw(final com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, final n nVar) {
        if (!TextUtils.isEmpty(xtVar.tj())) {
            return;
        }
        if (nVar.xj() <= 0) {
            nVar.up((System.currentTimeMillis() + 10500000) / 1000);
        }
        ae.r(new g("PreloadStrategyRecovery-onNetworkResponse") { // from class: com.bytedance.sdk.openadsdk.core.up.cw.r.3
            @Override // java.lang.Runnable
            public void run() {
                System.currentTimeMillis();
                com.bytedance.sdk.openadsdk.core.up.r.r.j(r.this.cw).j(xtVar.r(), nVar.kj(), false);
                System.currentTimeMillis();
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.up.cw.j
    public void j(final com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, final n nVar) {
        if (TextUtils.isEmpty(xtVar.tj())) {
            if (nVar.xj() <= 0) {
                nVar.up((System.currentTimeMillis() + 10500000) / 1000);
            }
            ae.r(new g("PreloadStrategyRecovery-onNetworkResponse") { // from class: com.bytedance.sdk.openadsdk.core.up.cw.r.1
                @Override // java.lang.Runnable
                public void run() {
                    System.currentTimeMillis();
                    com.bytedance.sdk.openadsdk.core.up.r.r.j(r.this.cw).j(xtVar, nVar, false);
                    System.currentTimeMillis();
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.up.cw.j
    public void xt(String str) {
        System.currentTimeMillis();
        for (Reference<? extends Object> poll = xt.poll(); poll != null; poll = xt.poll()) {
            j jVar = this.f30847j.get(poll);
            if (jVar != null) {
                com.bytedance.sdk.openadsdk.core.up.r.r.j(this.cw).j(jVar.f30855j, jVar.xt, false);
            }
        }
        com.bytedance.sdk.openadsdk.core.up.r.r.j(this.cw).xt(str);
        System.currentTimeMillis();
        com.bytedance.sdk.openadsdk.core.up.r.r.j(this.cw).cw(str);
        System.currentTimeMillis();
    }

    @Override // com.bytedance.sdk.openadsdk.core.up.cw.j
    public n j(String str, long j6) {
        tl.j j7 = com.bytedance.sdk.openadsdk.core.up.up.xt.j(this.cw);
        System.currentTimeMillis();
        n j8 = com.bytedance.sdk.openadsdk.core.up.r.r.j(this.cw).j(str, true, j6);
        if (j8 != null && j7 != null) {
            try {
                if (j7.j(j8)) {
                    com.bytedance.sdk.openadsdk.core.up.r.r.j(this.cw).j(str, j8.kj());
                }
            } catch (Exception unused) {
                vl.xt("PreloadStrategyRecovery", "deleteCacheMeta error");
            }
        }
        System.currentTimeMillis();
        return j8;
    }

    @Override // com.bytedance.sdk.openadsdk.core.up.cw.j
    public void j(final com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, final n nVar, final Object obj, final boolean z5) {
        final String r5 = xtVar.r();
        ae.r(new g("PreloadStrategyRecovery-onLoad") { // from class: com.bytedance.sdk.openadsdk.core.up.cw.r.4
            @Override // java.lang.Runnable
            public void run() {
                tl.j j6 = com.bytedance.sdk.openadsdk.core.up.up.xt.j(r.this.cw);
                if (j6 != null) {
                    try {
                        if (j6.j(nVar)) {
                            return;
                        }
                    } catch (Exception unused) {
                        vl.xt("PreloadStrategyRecovery", "isDisableSdkBidding error");
                    }
                }
                System.currentTimeMillis();
                if (nVar.id() != 0) {
                    r.this.f30847j.put(new PhantomReference(obj, r.xt), new j(r5, nVar.kj()));
                }
                if (z5) {
                    return;
                }
                if (((j6 != null ? j6.g() : 0) & 2) == 2) {
                    com.bytedance.sdk.openadsdk.core.up.r.r.j(r.this.cw).j(xtVar, nVar, true);
                    System.currentTimeMillis();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.up.cw.j
    public void j(final String str, final n nVar) {
        ae.r(new g("PreloadStrategyRecovery-onShow") { // from class: com.bytedance.sdk.openadsdk.core.up.cw.r.5
            @Override // java.lang.Runnable
            public void run() {
                System.currentTimeMillis();
                com.bytedance.sdk.openadsdk.core.up.r.r.j(r.this.cw).j(str, nVar.kj());
                System.currentTimeMillis();
            }
        });
        tl.j j6 = com.bytedance.sdk.openadsdk.core.up.up.xt.j(this.cw);
        if (j6 != null) {
            com.bytedance.sdk.openadsdk.core.up.xt.j(str, j6.qv()).xt(j6.qv());
        }
    }
}
