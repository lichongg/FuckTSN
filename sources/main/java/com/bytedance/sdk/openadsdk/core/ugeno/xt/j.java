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
public class j extends com.bytedance.adsdk.ugeno.up.cw.xt implements f {
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
        this.qv.j(new f.j() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.xt.j.1
            @Override // com.bytedance.sdk.component.utils.f.j
            public void j(int i6) {
                if (((com.bytedance.adsdk.ugeno.up.cw.xt) j.this).f23743j == null || i6 != 1) {
                    return;
                }
                ((com.bytedance.adsdk.ugeno.up.cw.xt) j.this).f23743j.j(((com.bytedance.adsdk.ugeno.up.cw.xt) j.this).xt, ((com.bytedance.adsdk.ugeno.up.cw.xt) j.this).f23744m, ((com.bytedance.adsdk.ugeno.up.cw.xt) j.this).cw.xt());
            }
        });
    }

    @Override // com.bytedance.adsdk.ugeno.cw.f
    public void up() {
        com.bytedance.sdk.component.utils.f fVar = this.qv;
        if (fVar != null) {
            fVar.xt(g());
        }
    }

    public j(Context context) {
        super(context);
        this.qv = new com.bytedance.sdk.component.utils.f(context, 1, oq.i().up());
    }

    @Override // com.bytedance.adsdk.ugeno.cw.f
    public void j(JSONObject jSONObject) {
    }

    @Override // com.bytedance.adsdk.ugeno.up.cw.xt
    public boolean j(Object... objArr) {
        Map<String, Object> xt;
        this.xt.j(this);
        if (this.qv == null) {
            this.qv = new com.bytedance.sdk.component.utils.f(this.oq, 1, oq.i().up());
        }
        ws uf = this.xt.uf();
        if (uf == null || (xt = uf.xt()) == null) {
            return false;
        }
        Object obj = xt.get("shake_value");
        if (obj instanceof Integer) {
            this.qv.j(((Integer) obj).floatValue());
        }
        Object obj2 = xt.get("calculation_method");
        if (obj2 instanceof Integer) {
            this.qv.up(((Integer) obj2).intValue());
        }
        Object obj3 = xt.get("shake_interact_conf");
        if (obj3 instanceof JSONObject) {
            this.qv.cw((JSONObject) obj3);
        }
        Object obj4 = xt.get("rotation_angle");
        if (obj4 instanceof Integer) {
            this.qv.xt(((Integer) obj4).floatValue());
        }
        Object obj5 = xt.get("twist_config");
        if (obj5 instanceof JSONObject) {
            this.qv.j((JSONObject) obj5);
        }
        Object obj6 = xt.get("twist_interact_conf");
        if (obj6 instanceof JSONObject) {
            this.qv.xt((JSONObject) obj6);
        }
        Object obj7 = xt.get("calculation_method_twist");
        if (!(obj7 instanceof Integer)) {
            return false;
        }
        this.qv.m(((Integer) obj7).intValue());
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
