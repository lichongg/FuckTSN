package com.bytedance.sdk.openadsdk.core.ugeno;

import android.content.Context;
import com.bytedance.adsdk.ugeno.cw.xt.r;
import com.bytedance.sdk.component.utils.f;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class m implements r.j {

    /* renamed from: j, reason: collision with root package name */
    private f f30757j;
    private com.bytedance.adsdk.ugeno.xt.cw xt;

    @Override // com.bytedance.adsdk.ugeno.cw.xt.r.j
    public void j() {
        f fVar = this.f30757j;
        if (fVar != null) {
            fVar.j(cw());
        }
    }

    private int cw() {
        JSONObject oq;
        com.bytedance.adsdk.ugeno.xt.cw cwVar = this.xt;
        if (cwVar == null || (oq = cwVar.oq()) == null) {
            return 0;
        }
        return oq.optInt("meta_hashcode", 0);
    }

    @Override // com.bytedance.adsdk.ugeno.cw.xt.r.j
    public void xt() {
        f fVar = this.f30757j;
        if (fVar != null) {
            fVar.xt(cw());
        }
    }

    public m(Context context, com.bytedance.adsdk.ugeno.xt.cw cwVar) {
        this.f30757j = new f(context, 1, com.bytedance.sdk.openadsdk.core.oq.i().up());
        this.xt = cwVar;
    }

    @Override // com.bytedance.adsdk.ugeno.cw.xt.r.j
    public void j(float f6) {
        f fVar = this.f30757j;
        if (fVar != null) {
            fVar.j(f6);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.cw.xt.r.j
    public void j(final r.xt xtVar) {
        f fVar = this.f30757j;
        if (fVar != null) {
            fVar.j(new f.j() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.m.1
                @Override // com.bytedance.sdk.component.utils.f.j
                public void j(int i6) {
                    r.xt xtVar2 = xtVar;
                    if (xtVar2 != null) {
                        xtVar2.j(i6);
                    }
                }
            });
        }
    }
}
