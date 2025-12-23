package com.bytedance.sdk.openadsdk.core.g.j.j.j;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.component.utils.kt;
import com.bytedance.sdk.component.utils.ws;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.oq;
import com.bytedance.sdk.openadsdk.core.qv.g;
import com.bytedance.sdk.openadsdk.core.rn.la;
import com.bytedance.sdk.openadsdk.core.s;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.tj.tj;
import com.bytedance.sdk.openadsdk.core.v;
import com.ss.android.j.j.cw.e;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class j implements com.bytedance.sdk.openadsdk.core.g.j.j.j {
    protected String cw;

    /* renamed from: j, reason: collision with root package name */
    protected n f28976j;
    private com.bytedance.sdk.openadsdk.core.g.j.j.j jy;

    /* renamed from: m, reason: collision with root package name */
    protected boolean f28977m;
    private tj oq;

    /* renamed from: r, reason: collision with root package name */
    protected com.bytedance.sdk.openadsdk.core.qv.cw.cw.cw f28978r;
    protected e tl;
    protected String up;
    private volatile boolean vl;
    protected Context xt;
    protected volatile boolean ae = false;
    private int qv = 0;

    /* renamed from: g, reason: collision with root package name */
    protected Function<SparseArray<Object>, Object> f28975g = oq.i().gx();

    public static int cw(Map<String, Object> map) {
        if (map == null) {
            return 0;
        }
        Object obj = map.get("download_manager_hash_code");
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        return 0;
    }

    abstract boolean cw(int i6);

    abstract com.bytedance.sdk.openadsdk.core.qv.j.up j(Map<String, Object> map, la<String, Object> laVar);

    abstract com.bytedance.sdk.openadsdk.core.qv.j.xt r(Map<String, Object> map);

    abstract void xt(boolean z5, int i6);

    public boolean xt(Map<String, Object> map) {
        if (this.f28976j.er() || TextUtils.isEmpty(this.up)) {
            return false;
        }
        if (ws.cw(this.xt) != 0) {
            up(map);
            return true;
        }
        try {
            Context context = this.xt;
            a.j(context, kt.j(context, "tt_no_network"), 0);
        } catch (Exception unused) {
        }
        return true;
    }

    private void ae(Map<String, Object> map) {
        if (this.f28975g != null) {
            int cw = cw(map);
            if (map != null) {
                map.put("hashCode", Integer.valueOf(cw));
            }
            this.f28975g.apply(com.bytedance.sdk.openadsdk.i.r.j().j(16).j(Void.class).j(0, map).xt());
        }
    }

    private boolean m(Map<String, Object> map) {
        Object apply;
        if (this.f28975g == null) {
            return true;
        }
        tj tjVar = this.oq;
        if (tjVar != null && tjVar.up() == 1) {
            return true;
        }
        tj tjVar2 = this.oq;
        if (tjVar2 != null && tjVar2.cw()) {
            return true;
        }
        apply = this.f28975g.apply(com.bytedance.sdk.openadsdk.i.r.j().j(6).j(Boolean.class).j(0, new la().j("hashCode", Integer.valueOf(cw(map))).j("downloadUrl", this.up)).xt());
        if (apply == null || !((Boolean) apply).booleanValue()) {
            return true;
        }
        com.bytedance.sdk.openadsdk.l.ae.j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.g.j.j.j.j.1
            @Override // java.lang.Runnable
            public void run() {
                a.j(j.this.xt, "应用正在下载...", 0);
            }
        });
        return false;
    }

    private void up(Map<String, Object> map) {
        int cw = cw(map);
        j(this.vl, cw);
        if (this.xt != null && !TextUtils.isEmpty(this.up) && m(map)) {
            this.f28978r.j(xt(cw), this.f28976j);
            la<String, Object> j6 = new la().j("downloadUrl", this.up);
            j6.put("is_feed_register_direct_download", map.get("is_feed_register_direct_download"));
            j6.put("download_manager_hash_code", map.get("download_manager_hash_code"));
            com.bytedance.sdk.openadsdk.core.qv.j.xt r5 = r(j6);
            if (r5 != null && !j((com.bytedance.sdk.openadsdk.core.tj.r) null, r5, j6)) {
                j(true, cw);
                j(j6, r5);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.g.j.j.j
    public boolean j(Map<String, Object> map) {
        if (j()) {
            return xt(map);
        }
        return false;
    }

    protected boolean j() {
        return (this.f28976j == null || this.xt == null || this.f28975g == null || TextUtils.isEmpty(this.up) || TextUtils.isEmpty(this.cw) || this.f28978r == null) ? false : true;
    }

    private void xt(com.bytedance.sdk.openadsdk.core.qv.j.xt xtVar, Map<String, Object> map) {
        if (this.f28975g == null) {
            return;
        }
        la<String, Object> j6 = new la().j("itemClickListener", null).j("downloadButtonClickListener", com.bytedance.sdk.openadsdk.i.cw.r.j(xtVar)).j("hashCode", Integer.valueOf(cw(map))).j(map);
        j6.put("itemClickListener", com.bytedance.sdk.openadsdk.i.cw.r.j(j(map, j6)));
        this.f28975g.apply(com.bytedance.sdk.openadsdk.i.r.j().j(17).j(Void.class).j(0, j6).xt());
    }

    boolean j(com.bytedance.sdk.openadsdk.core.tj.r rVar, final com.bytedance.sdk.openadsdk.core.qv.j.xt xtVar, final Map<String, Object> map) {
        boolean j6 = com.bytedance.sdk.openadsdk.core.g.j.r.j.j(map);
        final int cw = cw(map);
        if (!this.f28978r.r(j6)) {
            return false;
        }
        com.bytedance.sdk.openadsdk.core.g.j.j.j jVar = this.jy;
        if (jVar != null && jVar.j(new HashMap())) {
            return true;
        }
        this.f28978r.j(rVar, this.cw, this.up, new com.bytedance.sdk.openadsdk.core.qv.cw.j.xt() { // from class: com.bytedance.sdk.openadsdk.core.g.j.j.j.j.2
            @Override // com.bytedance.sdk.openadsdk.core.qv.cw.j.xt
            public void j() {
                if (!j.this.cw(cw)) {
                    j.this.j(xtVar, map);
                } else {
                    j.this.j(true, cw);
                    j.this.j((Map<String, Object>) map, xtVar);
                }
            }
        });
        return true;
    }

    protected com.bytedance.sdk.openadsdk.core.qv.cw.cw.j xt(int i6) {
        if (cw(i6)) {
            return new com.bytedance.sdk.openadsdk.core.qv.cw.cw.up();
        }
        if (this.ae) {
            return new com.bytedance.sdk.openadsdk.core.qv.cw.cw.r();
        }
        return new com.bytedance.sdk.openadsdk.core.qv.cw.cw.xt();
    }

    public void j(boolean z5, int i6) {
        if (h.xt >= 5400 && cw(i6)) {
            xt(z5, i6);
        }
    }

    public void xt(boolean z5) {
        this.f28977m = z5;
    }

    private com.bytedance.sdk.openadsdk.core.qv.j.xt xt(final com.bytedance.sdk.openadsdk.core.tj.r rVar, final Map<String, Object> map) {
        return new com.bytedance.sdk.openadsdk.core.qv.j.xt() { // from class: com.bytedance.sdk.openadsdk.core.g.j.j.j.j.5
            @Override // w2.h
            public void j() {
            }

            @Override // w2.h
            public void j(boolean z5) {
                if (z5 && j.this.j(rVar, (com.bytedance.sdk.openadsdk.core.qv.j.xt) null, map)) {
                    return;
                }
                j.this.j((com.bytedance.sdk.openadsdk.core.qv.j.xt) null, map);
            }
        };
    }

    public void j(boolean z5) {
        this.ae = z5;
    }

    public void j(e eVar) {
        this.tl = eVar;
    }

    public void j(tj tjVar) {
        this.oq = tjVar;
    }

    public void j(int i6) {
        this.qv = i6;
    }

    public void j(com.bytedance.sdk.openadsdk.core.g.j.j.j jVar) {
        this.jy = jVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(final Map<String, Object> map, final com.bytedance.sdk.openadsdk.core.qv.j.xt xtVar) {
        g.j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.g.j.j.j.j.3
            @Override // java.lang.Runnable
            public void run() {
                j.this.j(xtVar, map);
            }
        }, this.f28976j);
        this.vl = false;
    }

    void j(com.bytedance.sdk.openadsdk.core.qv.j.xt xtVar, Map<String, Object> map) {
        try {
            if (xtVar == null) {
                ae(map);
                this.vl = false;
            } else {
                xt(xtVar, map);
                this.vl = false;
            }
        } catch (Throwable unused) {
        }
    }

    void j(final Map<String, Object> map, final boolean z5) {
        int i6 = this.qv;
        if (i6 == 1) {
            com.bytedance.sdk.openadsdk.core.qv.cw.oq.j(v.getContext());
            return;
        }
        if (i6 == 2) {
            com.bytedance.sdk.component.oq.ae.xt(new com.bytedance.sdk.component.oq.g("tt_download_check") { // from class: com.bytedance.sdk.openadsdk.core.g.j.j.j.j.4
                @Override // java.lang.Runnable
                public void run() {
                    s<com.bytedance.sdk.openadsdk.core.jy.j> j6 = v.j();
                    j jVar = j.this;
                    com.bytedance.sdk.openadsdk.core.tj.r j7 = j6.j(jVar.f28976j, jVar.up);
                    if (j7 != null && j7.up()) {
                        if (z5) {
                            j.this.j(j7, (Map<String, Object>) map);
                            return;
                        } else {
                            j.this.j((com.bytedance.sdk.openadsdk.core.qv.j.xt) null, map);
                            return;
                        }
                    }
                    com.bytedance.sdk.openadsdk.core.qv.cw.oq.j(v.getContext());
                }
            });
        } else if (z5) {
            j((com.bytedance.sdk.openadsdk.core.tj.r) null, map);
        } else {
            j((com.bytedance.sdk.openadsdk.core.qv.j.xt) null, map);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(com.bytedance.sdk.openadsdk.core.tj.r rVar, Map<String, Object> map) {
        j(xt(rVar, map), map);
    }
}
