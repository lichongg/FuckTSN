package com.bytedance.sdk.openadsdk.core.ugeno.xt;

import android.content.Context;
import com.bytedance.adsdk.ugeno.cw.f;
import com.bytedance.adsdk.ugeno.cw.tj;
import com.bytedance.adsdk.ugeno.cw.ws;
import com.bytedance.sdk.component.utils.f;
import com.bytedance.sdk.openadsdk.core.oq;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt extends com.bytedance.adsdk.ugeno.up.cw.xt implements f {
    private com.bytedance.sdk.component.utils.f qv;

    @Override // com.bytedance.adsdk.ugeno.cw.f
    public void cw() {
    }

    @Override // com.bytedance.adsdk.ugeno.cw.f
    public void j() {
    }

    @Override // com.bytedance.adsdk.ugeno.cw.f
    public void xt() {
    }

    private int g() {
        JSONObject j6;
        com.bytedance.adsdk.ugeno.xt.cw cwVar = this.xt;
        if (cwVar == null) {
            return 0;
        }
        JSONObject oq = cwVar.oq();
        if (oq != null) {
            return oq.optInt("meta_hashcode", 0);
        }
        ws uf = this.xt.uf();
        if (uf == null || (j6 = uf.j()) == null) {
            return 0;
        }
        return j6.optInt("meta_hashcode", 0);
    }

    @Override // com.bytedance.adsdk.ugeno.cw.f
    public void j(tj tjVar) {
    }

    @Override // com.bytedance.adsdk.ugeno.cw.f
    public void r() {
        if (this.qv == null || !this.xt.g().isShown()) {
            return;
        }
        this.qv.j(g());
    }

    @Override // com.bytedance.adsdk.ugeno.cw.f
    public void up() {
        com.bytedance.sdk.component.utils.f fVar = this.qv;
        if (fVar != null) {
            fVar.xt(g());
        }
    }

    public xt(Context context) {
        super(context);
        this.qv = new com.bytedance.sdk.component.utils.f(context, 2, oq.i().up());
    }

    @Override // com.bytedance.adsdk.ugeno.cw.f
    public void j(JSONObject jSONObject) {
    }

    @Override // com.bytedance.adsdk.ugeno.up.cw.xt
    public boolean j(Object... objArr) {
        this.xt.j(this);
        if (this.qv == null) {
            this.qv = new com.bytedance.sdk.component.utils.f(this.oq, 2, oq.i().up());
        }
        ws uf = this.xt.uf();
        if (uf == null) {
            return false;
        }
        Map<String, Object> xt = uf.xt();
        if (xt != null) {
            Object obj = xt.get("rotation_angle");
            if (obj instanceof Integer) {
                this.qv.xt(((Integer) obj).floatValue());
            }
            Object obj2 = xt.get("calculation_method_twist");
            if (obj2 instanceof Integer) {
                this.qv.m(((Integer) obj2).intValue());
            }
            Object obj3 = xt.get("twist_config");
            if (obj3 instanceof JSONObject) {
                this.qv.j((JSONObject) obj3);
            }
            Object obj4 = xt.get("twist_interact_conf");
            if (obj4 instanceof JSONObject) {
                this.qv.xt((JSONObject) obj4);
            }
        }
        this.qv.j(new f.j() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.xt.xt.1
            @Override // com.bytedance.sdk.component.utils.f.j
            public void j(int i6) {
                if (((com.bytedance.adsdk.ugeno.up.cw.xt) xt.this).f23743j == null || i6 != 2) {
                    return;
                }
                ((com.bytedance.adsdk.ugeno.up.cw.xt) xt.this).f23743j.j(((com.bytedance.adsdk.ugeno.up.cw.xt) xt.this).xt, ((com.bytedance.adsdk.ugeno.up.cw.xt) xt.this).f23744m, ((com.bytedance.adsdk.ugeno.up.cw.xt) xt.this).cw.xt());
            }
        });
        return false;
    }

    @Override // com.bytedance.adsdk.ugeno.cw.f
    public void j(boolean z5) {
        com.bytedance.sdk.component.utils.f fVar = this.qv;
        if (fVar != null) {
            if (z5) {
                fVar.j(g());
            } else {
                fVar.xt(g());
            }
        }
    }
}
