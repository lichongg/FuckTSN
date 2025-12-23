package com.bytedance.sdk.gromore.j.j.j;

import android.app.Activity;
import androidx.annotation.Nullable;
import com.bytedance.msdk.api.r.ae;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt extends com.bytedance.sdk.openadsdk.mediation.ad.j.xt.xt.cw {

    /* renamed from: j, reason: collision with root package name */
    private com.bytedance.msdk.api.r.xt f27456j;

    public xt(Activity activity, Map<String, Object> map, com.bytedance.msdk.api.r.j.j.cw cwVar) {
        if (cwVar == null || activity == null) {
            return;
        }
        if (map != null) {
            this.f27456j = cwVar.j(activity, map);
        } else {
            this.f27456j = cwVar.j(activity);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.j.xt.xt.cw
    public void j() {
        com.bytedance.msdk.api.r.xt xtVar = this.f27456j;
        if (xtVar != null) {
            xtVar.j();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.j.xt.xt.cw
    public void j(final com.bytedance.sdk.openadsdk.mediation.ad.j.xt.j.j jVar) {
        com.bytedance.msdk.api.r.xt xtVar = this.f27456j;
        if (xtVar != null) {
            xtVar.j(new ae() { // from class: com.bytedance.sdk.gromore.j.j.j.xt.1
                @Override // com.bytedance.msdk.api.r.ae
                public void j(int i6, @Nullable String str) {
                    com.bytedance.sdk.openadsdk.mediation.ad.j.xt.j.j jVar2 = jVar;
                    if (jVar2 != null) {
                        jVar2.j(i6, str);
                    }
                }

                @Override // com.bytedance.msdk.api.r.ae
                public void xt() {
                    com.bytedance.sdk.openadsdk.mediation.ad.j.xt.j.j jVar2 = jVar;
                    if (jVar2 != null) {
                        jVar2.xt();
                    }
                }

                @Override // com.bytedance.msdk.api.r.ae
                public void j() {
                    com.bytedance.sdk.openadsdk.mediation.ad.j.xt.j.j jVar2 = jVar;
                    if (jVar2 != null) {
                        jVar2.j();
                    }
                }
            });
        }
    }

    public xt(com.bytedance.msdk.api.r.xt xtVar) {
        this.f27456j = xtVar;
    }
}
