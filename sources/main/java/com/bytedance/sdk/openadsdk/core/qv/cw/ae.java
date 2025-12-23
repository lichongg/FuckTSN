package com.bytedance.sdk.openadsdk.core.qv.cw;

import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.rn.la;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.tencent.open.SocialConstants;
import com.umeng.analytics.pro.d;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class ae extends up {
    private Map<String, Object> ch;

    /* renamed from: s, reason: collision with root package name */
    private final com.bytedance.sdk.openadsdk.core.qv.j.cw f29881s;

    @Override // com.bytedance.sdk.openadsdk.core.qv.cw.up
    public synchronized void av() {
        i();
        this.oq.set(true);
        if (this.f29919f != null) {
            this.f29919f.apply(com.bytedance.sdk.openadsdk.i.r.j().j(5).j(Void.class).j(0, new la().j("hashCode", Integer.valueOf(ae())).j("downloadStatusChangeListener", com.bytedance.sdk.openadsdk.i.cw.r.j(this.f29881s))).xt());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.qv.cw.up
    public boolean az() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.qv.cw.up
    public boolean cw(JSONObject jSONObject, boolean z5) {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.qv.cw.up, com.bytedance.sdk.component.utils.l.j
    public void j(Message message) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.qv.cw.up
    public boolean m() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.qv.cw.up
    protected synchronized void qv() {
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

    private void i() {
        com.bytedance.sdk.openadsdk.core.tj.up by = this.up.by();
        if (by != null) {
            this.ch.put("download_url", by.xt());
        }
        this.ch.put("download_status_listener", this.f29881s);
        this.ch.put("event_tag", this.f29922m);
        this.ch.put("dialog_to_landing_page_convert", new com.bytedance.sdk.openadsdk.core.g.j.j.j() { // from class: com.bytedance.sdk.openadsdk.core.qv.cw.ae.2
            @Override // com.bytedance.sdk.openadsdk.core.g.j.j.j
            public boolean j(Map<String, Object> map) {
                ae aeVar = ae.this;
                Context context = aeVar.getContext();
                ae aeVar2 = ae.this;
                return aeVar.j(context, aeVar2.up, aeVar2.f29922m);
            }
        });
        this.ch.put("download_popup_manager", tl());
        this.ch.put("download_manager_hash_code", Integer.valueOf(hashCode()));
    }

    @Override // com.bytedance.sdk.openadsdk.core.qv.cw.up, com.bytedance.sdk.openadsdk.core.qv.xt.cw
    public boolean cw() {
        Function<SparseArray<Object>, Object> function = this.f29919f;
        return function != null && com.bytedance.sdk.openadsdk.core.qv.cw.xt.xt.j(function, ae()) == 2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.qv.cw.up, com.bytedance.sdk.openadsdk.core.qv.xt.cw
    public void j(n nVar, boolean z5) {
        if (getContext() == null) {
            return;
        }
        j(uf.mi(nVar), z5);
    }

    @Override // com.bytedance.sdk.openadsdk.core.qv.cw.up
    public void m(boolean z5) {
        this.ch.put("convert_from_landing_page", Boolean.valueOf(z5));
    }

    @Override // com.bytedance.sdk.openadsdk.core.qv.cw.up
    public void tl(boolean z5) {
        com.bytedance.sdk.openadsdk.core.qv.cw.xt.xt.j(this.f29922m, this.up, (JSONObject) null, ae());
        com.bytedance.sdk.openadsdk.core.qv.cw.xt.xt.j(this.up, ae(), z5);
        this.ch = new HashMap();
    }

    @Override // com.bytedance.sdk.openadsdk.core.qv.cw.up, com.bytedance.sdk.openadsdk.core.qv.xt.cw
    public Map<String, Object> up() {
        return this.ch;
    }

    public ae(Context context, n nVar, String str, boolean z5) {
        super(context, nVar, str, z5);
        this.f29881s = new com.bytedance.sdk.openadsdk.core.qv.j.cw() { // from class: com.bytedance.sdk.openadsdk.core.qv.cw.ae.1
            @Override // com.ss.android.j.j.cw.e
            public void j() {
                ae.this.ae.set(1);
                if (com.bytedance.sdk.openadsdk.core.multipro.xt.cw()) {
                    ae.this.j("onIdle", 0L, 0L, (String) null, (String) null);
                    return;
                }
                com.bytedance.sdk.openadsdk.core.qv.xt.up upVar = ae.this.vl;
                if (upVar != null) {
                    upVar.j();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.qv.j.cw
            public void onDownloadActive(long j6, long j7, String str2) {
                n nVar2;
                ae.this.ae.set(3);
                ae.this.tl.set(false);
                if (com.bytedance.sdk.openadsdk.core.multipro.xt.cw()) {
                    ae aeVar = ae.this;
                    aeVar.j("onDownloadActive", j6, j7, str2, aeVar.f29923r.cw());
                    return;
                }
                ae aeVar2 = ae.this;
                com.bytedance.sdk.openadsdk.core.qv.xt.up upVar = aeVar2.vl;
                if (upVar != null) {
                    upVar.j(j6, j7, str2, aeVar2.f29923r.cw());
                }
                com.bytedance.sdk.openadsdk.core.qv.xt.up upVar2 = ae.this.vl;
                if (upVar2 == null || upVar2.cw() || (nVar2 = ae.this.up) == null) {
                    return;
                }
                com.bytedance.sdk.openadsdk.core.f.j.xt(nVar2.hm());
            }

            @Override // com.bytedance.sdk.openadsdk.core.qv.j.cw
            public void onDownloadFailed(long j6, long j7, String str2) {
                ae.this.ae.set(5);
                if (com.bytedance.sdk.openadsdk.core.multipro.xt.cw()) {
                    ae aeVar = ae.this;
                    aeVar.j("onDownloadFailed", j6, j7, str2, aeVar.f29923r.cw());
                    return;
                }
                ae aeVar2 = ae.this;
                com.bytedance.sdk.openadsdk.core.qv.xt.up upVar = aeVar2.vl;
                if (upVar != null) {
                    upVar.cw(j6, j7, str2, aeVar2.f29923r.cw());
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.qv.j.cw
            public void onDownloadFinished(long j6, long j7, String str2) {
                ae.this.ae.set(6);
                if (com.bytedance.sdk.openadsdk.core.multipro.xt.cw()) {
                    ae aeVar = ae.this;
                    aeVar.j("onDownloadFinished", j6, j7, str2, aeVar.f29923r.cw());
                    return;
                }
                ae aeVar2 = ae.this;
                com.bytedance.sdk.openadsdk.core.qv.xt.up upVar = aeVar2.vl;
                if (upVar != null) {
                    upVar.j(j6, str2, aeVar2.f29923r.cw());
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.qv.j.cw
            public void onDownloadPaused(long j6, long j7, String str2) {
                ae.this.ae.set(4);
                ae.this.tl.set(false);
                if (com.bytedance.sdk.openadsdk.core.multipro.xt.cw()) {
                    ae aeVar = ae.this;
                    aeVar.j("onDownloadPaused", j6, j7, str2, aeVar.f29923r.cw());
                    return;
                }
                ae aeVar2 = ae.this;
                com.bytedance.sdk.openadsdk.core.qv.xt.up upVar = aeVar2.vl;
                if (upVar != null) {
                    upVar.xt(j6, j7, str2, aeVar2.f29923r.cw());
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.qv.j.cw
            public void onDownloadStart() {
                ae.this.ae.set(2);
                if (com.bytedance.sdk.openadsdk.core.multipro.xt.cw()) {
                    ae.this.j("onIdle", 0L, 0L, (String) null, (String) null);
                    return;
                }
                com.bytedance.sdk.openadsdk.core.qv.xt.up upVar = ae.this.vl;
                if (upVar != null) {
                    upVar.j();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.qv.j.cw
            public void onInstalled(long j6, long j7, String str2) {
                ae.this.ae.set(7);
                ae.this.tl.set(true);
                if (TextUtils.isEmpty(str2)) {
                    str2 = "";
                }
                String str3 = str2;
                if (com.bytedance.sdk.openadsdk.core.multipro.xt.cw()) {
                    ae aeVar = ae.this;
                    aeVar.j("onInstalled", j6, j7, str3, aeVar.f29923r.cw());
                    return;
                }
                ae aeVar2 = ae.this;
                com.bytedance.sdk.openadsdk.core.qv.xt.up upVar = aeVar2.vl;
                if (upVar != null) {
                    upVar.j(str3, aeVar2.f29923r.cw());
                }
            }
        };
    }

    @Override // com.bytedance.sdk.openadsdk.core.qv.xt.cw
    public void cw(boolean z5) {
        this.ch.put("is_open_oppo_market_auto_download", Boolean.valueOf(z5));
    }

    @Override // com.bytedance.sdk.openadsdk.core.qv.cw.up, com.bytedance.sdk.openadsdk.core.qv.xt.cw
    public void j(int i6) {
        this.ch.put("need_check_compliance", Integer.valueOf(i6));
    }

    @Override // com.bytedance.sdk.openadsdk.core.qv.xt.cw
    public void j(JSONObject jSONObject, boolean z5) {
        uf.a();
        HashMap hashMap = new HashMap();
        hashMap.put("material_meta", this.up);
        hashMap.put(d.X, getContext());
        hashMap.put("is_market_covert", Boolean.valueOf(cw()));
        com.bytedance.sdk.openadsdk.core.tj.up by = this.up.by();
        if (by != null) {
            hashMap.put("download_url", by.xt());
        }
        Map<String, Object> map = this.ch;
        if (map != null) {
            hashMap.putAll(map);
        }
        hashMap.put("download_status_listener", this.f29881s);
        hashMap.put("event_tag", this.f29922m);
        hashMap.put(SocialConstants.PARAM_SOURCE, Integer.valueOf(uf.xt(this.f29922m)));
        hashMap.put("dialog_to_landing_page_convert", new com.bytedance.sdk.openadsdk.core.g.j.j.j() { // from class: com.bytedance.sdk.openadsdk.core.qv.cw.ae.3
            @Override // com.bytedance.sdk.openadsdk.core.g.j.j.j
            public boolean j(Map<String, Object> map2) {
                ae aeVar = ae.this;
                Context context = aeVar.getContext();
                ae aeVar2 = ae.this;
                return aeVar.j(context, aeVar2.up, aeVar2.f29922m);
            }
        });
        hashMap.put("download_popup_manager", tl());
        hashMap.putAll(com.bytedance.sdk.component.qv.up.j.j().j(this.up.hashCode() + this.up.ej()));
        hashMap.put("convert_from_downloader", Boolean.TRUE);
        hashMap.put("download_manager_hash_code", Integer.valueOf(ae()));
        hashMap.put("is_feed_register_direct_download", Boolean.valueOf(z5));
        HashMap hashMap2 = new HashMap();
        hashMap.put("download_manager_hash_code", Integer.valueOf(ae()));
        com.bytedance.sdk.openadsdk.core.g.j.r.j.j(this.up, hashMap2, "clickEvent", hashMap, this.f29922m, new HashMap());
    }

    @Override // com.bytedance.sdk.openadsdk.core.qv.cw.up, com.bytedance.sdk.openadsdk.core.qv.xt.cw
    public void r(boolean z5) {
        this.f29927x = z5;
        this.ch.put("is_click_button", Boolean.valueOf(z5));
    }
}
