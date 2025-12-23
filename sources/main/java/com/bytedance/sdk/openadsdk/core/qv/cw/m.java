package com.bytedance.sdk.openadsdk.core.qv.cw;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.core.ed;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.rn.la;
import com.bytedance.sdk.openadsdk.core.s;
import com.bytedance.sdk.openadsdk.core.tj;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.v;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class m extends up {
    private final com.bytedance.sdk.openadsdk.core.qv.j.cw ch;

    private void xt(com.bytedance.sdk.openadsdk.core.qv.j.xt xtVar, Map<String, Object> map) {
        if (this.f29919f == null) {
            return;
        }
        final la<String, Object> j6 = new la().j("itemClickListener", null).j("downloadButtonClickListener", com.bytedance.sdk.openadsdk.i.cw.r.j(xtVar)).j("hashCode", Integer.valueOf(ae())).j(map);
        j6.put("itemClickListener", com.bytedance.sdk.openadsdk.i.cw.r.j(new com.bytedance.sdk.openadsdk.core.qv.j.up() { // from class: com.bytedance.sdk.openadsdk.core.qv.cw.m.4
            @Override // com.bytedance.sdk.openadsdk.core.qv.j.up
            public void onItemClick() {
                if (m.this.f29921i || m.this.up.mz()) {
                    com.bytedance.sdk.openadsdk.core.qv.cw.xt.xt.xt(1, m.this.ae());
                    j6.remove("itemClickListener");
                    m.this.f29919f.apply(com.bytedance.sdk.openadsdk.i.r.j().j(17).j(Void.class).j(0, j6).xt());
                } else {
                    Context context = m.this.getContext();
                    String yb = m.this.up.yb();
                    m mVar = m.this;
                    ed.j(context, yb, mVar.up, mVar.f29922m);
                }
            }
        }));
        this.f29919f.apply(com.bytedance.sdk.openadsdk.i.r.j().j(17).j(Void.class).j(0, j6).xt());
    }

    @Override // com.bytedance.sdk.openadsdk.core.qv.cw.up
    public synchronized void av() {
        if (this.f29923r == null) {
            return;
        }
        this.oq.set(true);
        if (this.f29919f != null) {
            this.f29919f.apply(com.bytedance.sdk.openadsdk.i.r.j().j(5).j(Void.class).j(0, new la().j("hashCode", Integer.valueOf(ae())).j("downloadStatusChangeListener", com.bytedance.sdk.openadsdk.i.cw.r.j(this.ch))).xt());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.qv.cw.up, com.bytedance.sdk.openadsdk.core.qv.xt.cw
    public boolean cw() {
        Function<SparseArray<Object>, Object> function = this.f29919f;
        return function != null && com.bytedance.sdk.openadsdk.core.qv.cw.xt.xt.j(function, ae()) == 2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.qv.cw.up
    public synchronized void qv() {
        try {
            if (this.f29923r == null) {
                return;
            }
            if (this.f29919f != null && h.xt >= 6400 && !h.m()) {
                com.bytedance.sdk.openadsdk.core.qv.cw.xt.xt.j((com.bytedance.sdk.openadsdk.core.qv.j.r) null, ae());
            }
            AtomicBoolean atomicBoolean = this.oq;
            if (atomicBoolean != null && atomicBoolean.get()) {
                this.oq.set(false);
                if (this.f29919f != null) {
                    this.f29919f.apply(com.bytedance.sdk.openadsdk.i.r.j().j(4).j(Void.class).j(0, new la().j("hashCode", Integer.valueOf(ae()))).xt());
                }
            }
            oq();
        } catch (Throwable th) {
            throw th;
        }
    }

    private void i() {
        if (h.xt >= 5400 && cw() && !this.f29925v) {
            com.bytedance.sdk.openadsdk.core.qv.cw.xt.xt.j(false, (com.bytedance.sdk.openadsdk.core.qv.j.r) null, ae());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.qv.xt.cw
    public void r() {
        if (this.f29923r == null) {
            return;
        }
        this.oq.set(false);
        Function<SparseArray<Object>, Object> function = this.f29919f;
        if (function != null) {
            function.apply(com.bytedance.sdk.openadsdk.i.r.j().j(8).j(Void.class).j(0, new la().j("force", Boolean.TRUE).j("hashCode", Integer.valueOf(ae()))).xt());
        }
        av();
    }

    @Override // com.bytedance.sdk.openadsdk.core.qv.cw.up
    public void tl(boolean z5) {
        com.bytedance.sdk.openadsdk.core.qv.cw.xt.xt.j(this.f29922m, this.up, (JSONObject) null, ae());
        com.bytedance.sdk.openadsdk.core.qv.cw.xt.xt.j(this.up, ae(), z5);
        com.bytedance.sdk.openadsdk.core.qv.cw.xt.xt.j(this.f29922m, ae());
    }

    public m(Context context, n nVar, String str, boolean z5) {
        super(context, nVar, str, z5);
        this.ch = new com.bytedance.sdk.openadsdk.core.qv.j.cw() { // from class: com.bytedance.sdk.openadsdk.core.qv.cw.m.1
            @Override // com.ss.android.j.j.cw.e
            public void j() {
                m.this.ae.set(1);
                if (com.bytedance.sdk.openadsdk.core.multipro.xt.cw()) {
                    m.this.j("onIdle", 0L, 0L, (String) null, (String) null);
                    return;
                }
                com.bytedance.sdk.openadsdk.core.qv.xt.up upVar = m.this.vl;
                if (upVar != null) {
                    upVar.j();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.qv.j.cw
            public void onDownloadActive(long j6, long j7, String str2) {
                n nVar2;
                m.this.ae.set(3);
                m.this.tl.set(false);
                if (com.bytedance.sdk.openadsdk.core.multipro.xt.cw()) {
                    m mVar = m.this;
                    mVar.j("onDownloadActive", j6, j7, str2, mVar.f29923r.cw());
                    return;
                }
                m mVar2 = m.this;
                com.bytedance.sdk.openadsdk.core.qv.xt.up upVar = mVar2.vl;
                if (upVar != null) {
                    upVar.j(j6, j7, str2, mVar2.f29923r.cw());
                }
                com.bytedance.sdk.openadsdk.core.qv.xt.up upVar2 = m.this.vl;
                if (upVar2 == null || upVar2.cw() || (nVar2 = m.this.up) == null) {
                    return;
                }
                com.bytedance.sdk.openadsdk.core.f.j.xt(nVar2.hm());
            }

            @Override // com.bytedance.sdk.openadsdk.core.qv.j.cw
            public void onDownloadFailed(long j6, long j7, String str2) {
                m.this.ae.set(5);
                if (com.bytedance.sdk.openadsdk.core.multipro.xt.cw()) {
                    m mVar = m.this;
                    mVar.j("onDownloadFailed", j6, j7, str2, mVar.f29923r.cw());
                    return;
                }
                m mVar2 = m.this;
                com.bytedance.sdk.openadsdk.core.qv.xt.up upVar = mVar2.vl;
                if (upVar != null) {
                    upVar.cw(j6, j7, str2, mVar2.f29923r.cw());
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.qv.j.cw
            public void onDownloadFinished(long j6, long j7, String str2) {
                m.this.ae.set(6);
                if (com.bytedance.sdk.openadsdk.core.multipro.xt.cw()) {
                    m mVar = m.this;
                    mVar.j("onDownloadFinished", j6, j7, str2, mVar.f29923r.cw());
                    return;
                }
                m mVar2 = m.this;
                com.bytedance.sdk.openadsdk.core.qv.xt.up upVar = mVar2.vl;
                if (upVar != null) {
                    upVar.j(j6, str2, mVar2.f29923r.cw());
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.qv.j.cw
            public void onDownloadPaused(long j6, long j7, String str2) {
                m.this.ae.set(4);
                m.this.tl.set(false);
                if (com.bytedance.sdk.openadsdk.core.multipro.xt.cw()) {
                    m mVar = m.this;
                    mVar.j("onDownloadPaused", j6, j7, str2, mVar.f29923r.cw());
                    return;
                }
                m mVar2 = m.this;
                com.bytedance.sdk.openadsdk.core.qv.xt.up upVar = mVar2.vl;
                if (upVar != null) {
                    upVar.xt(j6, j7, str2, mVar2.f29923r.cw());
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.qv.j.cw
            public void onDownloadStart() {
                m.this.ae.set(2);
                if (com.bytedance.sdk.openadsdk.core.multipro.xt.cw()) {
                    m.this.j("onIdle", 0L, 0L, (String) null, (String) null);
                    return;
                }
                com.bytedance.sdk.openadsdk.core.qv.xt.up upVar = m.this.vl;
                if (upVar != null) {
                    upVar.j();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.qv.j.cw
            public void onInstalled(long j6, long j7, String str2) {
                m.this.ae.set(7);
                m.this.tl.set(true);
                if (TextUtils.isEmpty(str2)) {
                    str2 = "";
                }
                String str3 = str2;
                if (com.bytedance.sdk.openadsdk.core.multipro.xt.cw()) {
                    m mVar = m.this;
                    mVar.j("onInstalled", j6, j7, str3, mVar.f29923r.cw());
                    return;
                }
                m mVar2 = m.this;
                com.bytedance.sdk.openadsdk.core.qv.xt.up upVar = mVar2.vl;
                if (upVar != null) {
                    upVar.j(str3, mVar2.f29923r.cw());
                }
            }
        };
    }

    private void m(JSONObject jSONObject, final boolean z5) {
        i();
        if (getContext() != null && this.f29923r != null && jy()) {
            String str = this.f29922m;
            com.bytedance.sdk.openadsdk.core.qv.cw.xt.xt.j(str, str, jSONObject, ae());
            final la<String, Object> j6 = new la().j("downloadUrl", this.f29923r.xt()).j("hashCode", Integer.valueOf(ae())).j("action_type_button", 2);
            n nVar = this.up;
            if (nVar != null && !TextUtils.isEmpty(nVar.fs())) {
                j6.j("id", Long.valueOf(Double.valueOf(this.up.fs()).longValue()));
            }
            if (cw()) {
                com.bytedance.sdk.openadsdk.core.qv.j.xt xtVar = new com.bytedance.sdk.openadsdk.core.qv.j.xt() { // from class: com.bytedance.sdk.openadsdk.core.qv.cw.m.2
                    @Override // w2.h
                    public void j(boolean z6) {
                    }

                    @Override // w2.h
                    public void j() {
                        if (j6 == null) {
                            return;
                        }
                        com.bytedance.sdk.openadsdk.core.qv.cw.xt.xt.j(0, m.this.ae());
                        m.this.tl().j(m.this.ws());
                        j6.remove("downloadButtonClickListener");
                        if (m.this.j((com.bytedance.sdk.openadsdk.core.tj.r) null, (com.bytedance.sdk.openadsdk.core.qv.j.xt) null, j6, z5)) {
                            return;
                        }
                        m.this.xt(j6);
                    }
                };
                com.bytedance.sdk.openadsdk.core.qv.cw.xt.xt.j(j6, xtVar);
                if (!j((com.bytedance.sdk.openadsdk.core.tj.r) null, xtVar, j6, z5)) {
                    cw(true);
                    j(j6, xtVar);
                    return;
                }
                return;
            }
            j(j6, z5);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.qv.xt.cw
    public void cw(boolean z5) {
        if (h.xt >= 5400 && z5) {
            this.f29925v = true;
            if (cw()) {
                try {
                    com.bytedance.sdk.openadsdk.core.qv.cw.xt.xt.j(true, com.bytedance.sdk.openadsdk.core.qv.cw.xt.xt.j(this.up, this.f29927x), ae());
                } catch (Throwable th) {
                    vl.cw("xgcdl", "throwable", th);
                }
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.qv.xt.cw
    public void j(JSONObject jSONObject, boolean z5) {
        m(jSONObject, z5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(final Map<String, Object> map, final com.bytedance.sdk.openadsdk.core.qv.j.xt xtVar) {
        com.bytedance.sdk.openadsdk.core.qv.g.j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.qv.cw.m.3
            @Override // java.lang.Runnable
            public void run() {
                m.this.j(xtVar, (Map<String, Object>) map);
            }
        }, this.up);
        this.f29925v = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xt(final Map<String, Object> map) {
        int i6 = this.tj;
        if (i6 == 1) {
            return;
        }
        if (i6 == 2) {
            com.bytedance.sdk.component.oq.ae.xt(new com.bytedance.sdk.component.oq.g("tt_market_download_check") { // from class: com.bytedance.sdk.openadsdk.core.qv.cw.m.6
                @Override // java.lang.Runnable
                public void run() {
                    s<com.bytedance.sdk.openadsdk.core.jy.j> j6 = v.j();
                    m mVar = m.this;
                    com.bytedance.sdk.openadsdk.core.tj.r j7 = j6.j(mVar.up, mVar.f29923r.xt());
                    if (j7 != null && j7.up()) {
                        tj.m().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.qv.cw.m.6.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AnonymousClass6 anonymousClass6 = AnonymousClass6.this;
                                m.this.j((com.bytedance.sdk.openadsdk.core.qv.j.xt) null, (Map<String, Object>) map);
                            }
                        });
                    }
                }
            });
        } else {
            j((com.bytedance.sdk.openadsdk.core.qv.j.xt) null, map);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(com.bytedance.sdk.openadsdk.core.qv.j.xt xtVar, Map<String, Object> map) {
        try {
            if (xtVar == null) {
                j(map);
                this.f29925v = false;
            } else {
                xt(xtVar, map);
                this.f29925v = false;
            }
        } catch (Throwable unused) {
        }
    }

    private void j(final Map<String, Object> map, final boolean z5) {
        int i6 = this.tj;
        if (i6 == 1) {
            oq.j(v.getContext());
        } else if (i6 != 2) {
            j((com.bytedance.sdk.openadsdk.core.tj.r) null, map, z5);
        } else {
            com.bytedance.sdk.component.oq.ae.xt(new com.bytedance.sdk.component.oq.g("tt_download_check") { // from class: com.bytedance.sdk.openadsdk.core.qv.cw.m.5
                @Override // java.lang.Runnable
                public void run() {
                    s<com.bytedance.sdk.openadsdk.core.jy.j> j6 = v.j();
                    m mVar = m.this;
                    com.bytedance.sdk.openadsdk.core.tj.r j7 = j6.j(mVar.up, mVar.f29923r.xt());
                    if (j7 != null && j7.up()) {
                        m.this.j(j7, (Map<String, Object>) map, z5);
                    } else {
                        oq.j(v.getContext());
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(final com.bytedance.sdk.openadsdk.core.tj.r rVar, final Map<String, Object> map, final boolean z5) {
        j(new com.bytedance.sdk.openadsdk.core.qv.j.xt() { // from class: com.bytedance.sdk.openadsdk.core.qv.cw.m.7
            @Override // w2.h
            public void j() {
            }

            @Override // w2.h
            public void j(boolean z6) {
                if (z6 && m.this.j(rVar, (com.bytedance.sdk.openadsdk.core.qv.j.xt) null, (Map<String, Object>) map, z5)) {
                    return;
                }
                m.this.j((com.bytedance.sdk.openadsdk.core.qv.j.xt) null, (Map<String, Object>) map);
            }
        }, map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean j(com.bytedance.sdk.openadsdk.core.tj.r rVar, final com.bytedance.sdk.openadsdk.core.qv.j.xt xtVar, final Map<String, Object> map, boolean z5) {
        com.bytedance.sdk.openadsdk.core.qv.cw.cw.cw tl = tl();
        if (!tl.r(z5)) {
            return false;
        }
        if (j(getContext(), this.up, this.f29922m)) {
            return true;
        }
        tl.j(rVar, this.f29922m, this.f29923r.xt(), new com.bytedance.sdk.openadsdk.core.qv.cw.j.xt() { // from class: com.bytedance.sdk.openadsdk.core.qv.cw.m.8
            @Override // com.bytedance.sdk.openadsdk.core.qv.cw.j.xt
            public void j() {
                if (!m.this.cw()) {
                    m.this.j(xtVar, (Map<String, Object>) map);
                } else {
                    m.this.cw(true);
                    m.this.j((Map<String, Object>) map, xtVar);
                }
            }
        });
        return true;
    }
}
