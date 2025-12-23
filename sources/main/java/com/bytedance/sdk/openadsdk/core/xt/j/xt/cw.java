package com.bytedance.sdk.openadsdk.core.xt.j.xt;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.core.s;
import com.bytedance.sdk.openadsdk.core.tj;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.tj.ws;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.l.ae;
import com.stub.StubApp;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw {
    private String cw;

    /* renamed from: j, reason: collision with root package name */
    private final n f31336j;

    /* renamed from: r, reason: collision with root package name */
    private final AtomicBoolean f31337r = new AtomicBoolean(true);
    private xt up;
    private final Context xt;

    public interface j {
        void j();
    }

    public interface xt {
        void j();

        void j(String str, boolean z5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cw(ws wsVar) {
        if (this.f31337r.getAndSet(false)) {
            xt(wsVar);
        }
    }

    private void xt(final ws wsVar) {
        if (wsVar == null) {
            return;
        }
        try {
            v.j().j(wsVar.xt(), new s.cw<com.bytedance.sdk.component.g.xt>() { // from class: com.bytedance.sdk.openadsdk.core.xt.j.xt.cw.3
                @Override // com.bytedance.sdk.openadsdk.core.s.cw
                public void j(int i6, String str) {
                    cw.this.j();
                    cw.this.cw(wsVar);
                }

                @Override // com.bytedance.sdk.openadsdk.core.s.cw
                public void j(com.bytedance.sdk.component.g.xt xtVar) {
                    if (xtVar == null || !xtVar.tl() || TextUtils.isEmpty(xtVar.r())) {
                        cw.this.j();
                        cw.this.cw(wsVar);
                    } else {
                        try {
                            cw.this.j(new JSONObject(xtVar.r()));
                        } catch (Throwable unused) {
                        }
                    }
                }
            });
        } catch (Throwable th) {
            vl.j(th);
        }
    }

    public cw(n nVar, Context context) {
        this.f31336j = nVar;
        this.xt = context;
    }

    public cw j(String str) {
        this.cw = str;
        return this;
    }

    private void xt(JSONObject jSONObject) {
        boolean optBoolean = jSONObject.optBoolean("is_apply_coupon");
        String optString = jSONObject.optString("error_type");
        if (optBoolean && "success".equals(optString)) {
            com.bytedance.sdk.openadsdk.core.jy.cw.xt(this.f31336j, this.cw, 1);
        } else if (optBoolean && "has_applied".equals(optString)) {
            com.bytedance.sdk.openadsdk.core.jy.cw.xt(this.f31336j, this.cw, 2);
        } else if (!optBoolean) {
            com.bytedance.sdk.openadsdk.core.jy.cw.xt(this.f31336j, this.cw, 3);
        }
        if (this.up != null) {
            if (optBoolean && "success".equals(optString)) {
                this.up.j();
            } else {
                this.up.j(optString, optBoolean);
            }
        }
    }

    public void j(xt xtVar) {
        this.up = xtVar;
    }

    public static boolean j(n nVar, boolean z5) {
        ws ml = nVar != null ? nVar.ml() : null;
        return ml != null && ml.j(z5);
    }

    public int j(final j jVar) {
        n nVar = this.f31336j;
        ws ml = nVar != null ? nVar.ml() : null;
        j(ml);
        xt(ml);
        tj.m().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.xt.j.xt.cw.1
            @Override // java.lang.Runnable
            public void run() {
                j jVar2 = jVar;
                if (jVar2 != null) {
                    jVar2.j();
                }
            }
        }, 500L);
        return 1;
    }

    private void j(ws wsVar) {
        if (wsVar == null || TextUtils.isEmpty(wsVar.r())) {
            return;
        }
        final String r5 = wsVar.r();
        ae.j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.xt.j.xt.cw.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    a.xt(StubApp.getOrigApplicationContext(cw.this.xt.getApplicationContext()), r5, 0, 17, 0, 0);
                } catch (Throwable th) {
                    vl.j(th);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        com.bytedance.sdk.openadsdk.core.jy.cw.xt(this.f31336j, this.cw, 4);
        xt xtVar = this.up;
        if (xtVar != null) {
            xtVar.j("net_fail", false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(JSONObject jSONObject) {
        try {
            if (jSONObject.has("is_apply_coupon")) {
                xt(jSONObject);
            }
        } catch (Throwable unused) {
            j();
        }
    }
}
