package com.bytedance.sdk.openadsdk.core.qv.cw;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.qv.r.cw;
import com.bytedance.sdk.openadsdk.core.rn.la;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.tj.i;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.tj.tj;
import com.bytedance.sdk.openadsdk.core.v;
import com.huawei.hms.mlsdk.common.MLApplicationSetting;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class g extends tl {
    private WeakReference<Context> cw;

    /* renamed from: g, reason: collision with root package name */
    private volatile com.bytedance.sdk.openadsdk.core.qv.cw.cw.cw f29899g;

    /* renamed from: m, reason: collision with root package name */
    private String f29900m;
    private volatile boolean oq;

    /* renamed from: r, reason: collision with root package name */
    private String f29901r;
    private final n up;
    private int tl = 0;
    private boolean qv = false;
    private Function<SparseArray<Object>, Object> ae = com.bytedance.sdk.openadsdk.core.oq.i().gx();

    private synchronized void g() {
        try {
            if (this.ae == null) {
                return;
            }
            if (h.xt >= 6400 && !h.m()) {
                com.bytedance.sdk.openadsdk.core.qv.cw.xt.xt.j((com.bytedance.sdk.openadsdk.core.qv.j.r) null, ae());
            }
            if (qv()) {
                this.ae.apply(com.bytedance.sdk.openadsdk.i.r.j().j(2).j(Boolean.class).j(0, new la().j("hashCode", Integer.valueOf(ae()))).xt());
            } else {
                this.ae.apply(com.bytedance.sdk.openadsdk.i.r.j().j(4).j(Void.class).j(0, new la().j("hashCode", Integer.valueOf(ae()))).xt());
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private Map<String, Object> mi() {
        long longValue = Double.valueOf(this.up.fs()).longValue();
        return qv() ? new la().j("userAgent", null).j("isDisableDialog", Boolean.TRUE).j("downloadStatusChangeListener", null).j("action_type_button", 2).j("id", Long.valueOf(longValue)).j("hashCode", Integer.valueOf(ae())) : new la().j("downloadUrl", this.f29901r).j("hashCode", Integer.valueOf(ae())).j("id", Long.valueOf(longValue)).j("action_type_button", 2);
    }

    private synchronized void oq() {
        Object apply;
        if (this.ae == null) {
            return;
        }
        if (!qv()) {
            this.ae.apply(com.bytedance.sdk.openadsdk.i.r.j().j(5).j(Void.class).j(0, new la().j("hashCode", Integer.valueOf(ae()))).xt());
            return;
        }
        la laVar = new la();
        laVar.j("hashCode", Integer.valueOf(ae()));
        apply = this.ae.apply(com.bytedance.sdk.openadsdk.i.r.j().j(19).j(Boolean.class).j(0, laVar).xt());
        if (apply != null && ((Boolean) apply).booleanValue()) {
            this.ae.apply(com.bytedance.sdk.openadsdk.i.r.j().j(14).j(Boolean.class).j(0, new la().j("hashCode", Integer.valueOf(ae()))).xt());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.qv.xt.cw
    public void j(int i6, cw.j jVar) {
    }

    private boolean av() {
        if (this.ae == null || tj.mi(this.up) == 1 || tj.oq(this.up) || !i()) {
            return true;
        }
        com.bytedance.sdk.openadsdk.l.ae.j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.qv.cw.g.3
            @Override // java.lang.Runnable
            public void run() {
                a.j(g.this.getContext(), "应用正在下载...", 0);
            }
        });
        return false;
    }

    private boolean az() {
        n nVar = this.up;
        if (nVar != null && nVar.m111if() != null) {
            String xt = this.up.m111if().xt();
            if (TextUtils.isEmpty(xt)) {
                return false;
            }
            i.j((String) null);
            Uri parse = Uri.parse(xt);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(parse);
            if (uf.j(getContext(), intent)) {
                if (!(getContext() instanceof Activity)) {
                    intent.addFlags(268435456);
                }
                try {
                    getContext().startActivity(intent);
                    return true;
                } catch (Throwable unused) {
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Context getContext() {
        try {
            WeakReference<Context> weakReference = this.cw;
            if (weakReference == null) {
                return v.getContext();
            }
            Context context = weakReference.get();
            return context == null ? v.getContext() : context;
        } catch (Throwable unused) {
            return v.getContext();
        }
    }

    private boolean i() {
        Object apply;
        if (this.ae == null) {
            return false;
        }
        apply = this.ae.apply(com.bytedance.sdk.openadsdk.i.r.j().j(6).j(Boolean.class).j(0, new la().j("downloadUrl", this.f29901r).j("hashCode", Integer.valueOf(ae()))).xt());
        return apply != null && ((Boolean) apply).booleanValue();
    }

    private void kt() {
        if (h.xt >= 5400 && cw() && !this.oq) {
            com.bytedance.sdk.openadsdk.core.qv.cw.xt.xt.j(false, (com.bytedance.sdk.openadsdk.core.qv.j.r) null, ae());
        }
    }

    private boolean qv() {
        n nVar = this.up;
        if (nVar != null) {
            return tj.j(nVar);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.bytedance.sdk.openadsdk.core.qv.cw.cw.j tl() {
        return cw() ? new com.bytedance.sdk.openadsdk.core.qv.cw.cw.up() : new com.bytedance.sdk.openadsdk.core.qv.cw.cw.r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean vl() {
        int i6 = this.tl;
        if (i6 != 1) {
            if (i6 != 2) {
                return false;
            }
            com.bytedance.sdk.component.oq.ae.xt(new com.bytedance.sdk.component.oq.g("tt_download_check") { // from class: com.bytedance.sdk.openadsdk.core.qv.cw.g.1
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.core.tj.r j6 = v.j().j(g.this.up, g.this.f29901r);
                    if (j6 != null && j6.up()) {
                        String m6 = j6.m();
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject = new JSONObject(m6);
                        } catch (JSONException unused) {
                        }
                        com.bytedance.sdk.openadsdk.core.tj.m up = com.bytedance.sdk.openadsdk.core.j.up(jSONObject);
                        com.bytedance.sdk.openadsdk.core.tj.m et = g.this.up.et();
                        if (et == null) {
                            g.this.up.j(up);
                        } else {
                            et.oq(up.ws());
                            et.xt(up.up());
                            et.r(up.ae());
                            et.xt(up.vl());
                            et.up(up.tl());
                            et.g(up.jy());
                            et.cw(up.m());
                            et.m(up.g());
                            et.ae(up.oq());
                            et.tl(up.qv());
                            up = et;
                        }
                        if (!g.this.jy()) {
                            g.this.j(up.m(), up.ws(), up.jy());
                            g.this.j(j6);
                            return;
                        }
                        return;
                    }
                    oq.j(v.getContext());
                }
            });
            return true;
        }
        if (jy()) {
            return true;
        }
        oq.j(v.getContext());
        return true;
    }

    private boolean ws() {
        n nVar = this.up;
        com.bytedance.sdk.openadsdk.core.tj.m et = nVar != null ? nVar.et() : null;
        String jy = et != null ? et.jy() : "";
        Intent xt = TextUtils.isEmpty(jy) ? null : uf.xt(getContext(), jy);
        if (xt == null || !uf.cw(getContext(), jy)) {
            return false;
        }
        try {
            getContext().startActivity(xt);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.qv.xt.cw
    public boolean cw() {
        Function<SparseArray<Object>, Object> function = this.ae;
        return function != null && com.bytedance.sdk.openadsdk.core.qv.cw.xt.xt.j(function, ae()) == 2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.qv.xt.cw
    public void j(Activity activity) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.qv.cw.tl
    public com.bytedance.sdk.openadsdk.core.qv.cw.cw.cw m() {
        if (this.f29899g == null) {
            synchronized (this) {
                try {
                    if (this.f29899g == null) {
                        this.f29899g = new com.bytedance.sdk.openadsdk.core.qv.cw.cw.cw(getContext(), this.up);
                    }
                } finally {
                }
            }
        }
        return this.f29899g;
    }

    @Override // com.bytedance.sdk.openadsdk.core.qv.xt.cw
    public void r(boolean z5) {
        this.qv = z5;
    }

    @Override // com.bytedance.sdk.openadsdk.core.qv.xt.cw
    public Map<String, Object> up() {
        return new HashMap();
    }

    @Override // com.bytedance.sdk.openadsdk.core.qv.xt.cw
    public void xt() {
        g();
        WeakReference<Context> weakReference = this.cw;
        if (weakReference != null) {
            weakReference.clear();
            this.cw = null;
        }
        this.f29899g = null;
    }

    public g(Context context, String str, n nVar, String str2, boolean z5) {
        this.cw = new WeakReference<>(context);
        this.up = nVar;
        this.f29900m = str2;
        this.f29901r = str;
        j(z5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean jy() {
        if (!az() && !ws()) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        final Map<String, Object> mi = mi();
        if (!cw()) {
            j(16, mi);
        } else {
            com.bytedance.sdk.openadsdk.core.qv.cw.xt.xt.j(mi, new com.bytedance.sdk.openadsdk.core.qv.j.xt() { // from class: com.bytedance.sdk.openadsdk.core.qv.cw.g.4
                @Override // w2.h
                public void j(boolean z5) {
                }

                @Override // w2.h
                public void j() {
                    if (mi == null) {
                        return;
                    }
                    com.bytedance.sdk.openadsdk.core.qv.cw.xt.xt.j(0, g.this.ae());
                    g.this.m().j(g.this.tl());
                    mi.remove("downloadButtonClickListener");
                    if (g.this.vl()) {
                        return;
                    }
                    g.this.j((com.bytedance.sdk.openadsdk.core.tj.r) null);
                }
            });
            j(mi);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.qv.xt.cw
    public void j(com.bytedance.sdk.openadsdk.core.qv.xt.j jVar) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.qv.xt.cw
    public void r() {
        Function<SparseArray<Object>, Object> function = this.ae;
        if (function != null) {
            function.apply(com.bytedance.sdk.openadsdk.i.r.j().j(8).j(Void.class).j(0, new la().j("force", Boolean.TRUE).j("hashCode", Integer.valueOf(ae()))).xt());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.qv.xt.cw
    public void cw(boolean z5) {
        if (h.xt >= 5400 && z5) {
            this.oq = z5;
            if (cw()) {
                com.bytedance.sdk.openadsdk.core.qv.cw.xt.xt.j(true, com.bytedance.sdk.openadsdk.core.qv.cw.xt.xt.j(this.up, this.qv), ae());
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.qv.xt.cw
    public void j(com.bytedance.sdk.openadsdk.core.qv.xt.j jVar, boolean z5) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.qv.xt.cw
    public void j(n nVar, boolean z5) {
    }

    private boolean xt(com.bytedance.sdk.openadsdk.core.tj.r rVar) {
        com.bytedance.sdk.openadsdk.core.qv.cw.cw.cw m6 = m();
        if (!m6.r(false) || i()) {
            return false;
        }
        if (j(getContext(), this.up, this.f29900m)) {
            return true;
        }
        m6.j(rVar, this.f29900m, this.f29901r, new com.bytedance.sdk.openadsdk.core.qv.cw.j.xt() { // from class: com.bytedance.sdk.openadsdk.core.qv.cw.g.2
            @Override // com.bytedance.sdk.openadsdk.core.qv.cw.j.xt
            public void j() {
                g.this.w();
                g.this.cw(true);
            }
        });
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.qv.xt.cw
    public void j(boolean z5) {
        com.bytedance.sdk.openadsdk.core.qv.cw.xt.xt.j(this.f29901r, this.f29900m, this.up, (JSONObject) null, ae());
        com.bytedance.sdk.openadsdk.core.qv.cw.xt.xt.j(this.up, ae(), z5);
        com.bytedance.sdk.openadsdk.core.qv.cw.xt.xt.j(this.f29900m, ae());
        oq();
    }

    @Override // com.bytedance.sdk.openadsdk.core.qv.xt.cw
    public void j() {
        oq();
    }

    @Override // com.bytedance.sdk.openadsdk.core.qv.xt.cw
    public void j(JSONObject jSONObject, boolean z5) {
        m().j(tl());
        if (av()) {
            if (cw() || !vl()) {
                j((com.bytedance.sdk.openadsdk.core.tj.r) null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(String str, String str2, String str3) {
        if (this.ae == null) {
            return;
        }
        this.ae.apply(com.bytedance.sdk.openadsdk.i.r.j().j(24).j(Boolean.class).j(0, new la().j("appIcon", str).j("appName", str2).j("hashCode", Integer.valueOf(ae())).j(MLApplicationSetting.BundleKeyConstants.AppInfo.PACKAGE_NAME, str3)).xt());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(com.bytedance.sdk.openadsdk.core.tj.r rVar) {
        kt();
        if (xt(rVar)) {
            return;
        }
        w();
    }

    private void j(final Map<String, Object> map) {
        com.bytedance.sdk.openadsdk.core.qv.g.j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.qv.cw.g.5
            @Override // java.lang.Runnable
            public void run() {
                g.this.j(17, (Map<String, Object>) map);
            }
        }, this.up);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(final int i6, final Map<String, Object> map) {
        try {
            if (this.ae == null) {
                return;
            }
            if (qv()) {
                this.ae.apply(com.bytedance.sdk.openadsdk.i.r.j().j(13).j(Void.class).j(0, map).xt());
                this.oq = false;
            } else {
                map.put("itemClickListener", com.bytedance.sdk.openadsdk.i.cw.r.j(new com.bytedance.sdk.openadsdk.core.qv.j.up() { // from class: com.bytedance.sdk.openadsdk.core.qv.cw.g.6
                    @Override // com.bytedance.sdk.openadsdk.core.qv.j.up
                    public void onItemClick() {
                        com.bytedance.sdk.openadsdk.core.qv.cw.xt.xt.xt(1, g.this.ae());
                        map.remove("itemClickListener");
                        g.this.ae.apply(com.bytedance.sdk.openadsdk.i.r.j().j(i6).j(Void.class).j(0, map).xt());
                    }
                }));
                this.ae.apply(com.bytedance.sdk.openadsdk.i.r.j().j(i6).j(Void.class).j(0, map).xt());
                this.oq = false;
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.qv.xt.cw
    public void j(int i6) {
        this.tl = i6;
    }
}
