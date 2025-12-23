package com.bytedance.sdk.openadsdk.core.g.j.xt;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.xt;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.tencent.open.SocialConstants;
import com.umeng.analytics.pro.d;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import xyz.adscope.amps.common.AMPSConstants;

@com.bytedance.sdk.component.qv.xt.xt(j = "SINGLETON")
/* loaded from: D:\Downloads\app\classes4.dex */
public class oq implements com.bytedance.sdk.component.qv.j.j.cw {

    @com.bytedance.sdk.component.qv.xt.j(j = "convert_from_landing_page")
    private boolean ae;

    @com.bytedance.sdk.component.qv.xt.j(j = "url")
    private String cw;

    /* renamed from: j, reason: collision with root package name */
    @com.bytedance.sdk.component.qv.xt.j(j = "material_meta")
    private n f29063j;

    /* renamed from: m, reason: collision with root package name */
    @com.bytedance.sdk.component.qv.xt.j(j = "is_open_web_page")
    private boolean f29064m;

    /* renamed from: r, reason: collision with root package name */
    @com.bytedance.sdk.component.qv.xt.j(j = "interaction_type")
    private int f29065r;

    @com.bytedance.sdk.component.qv.xt.j(j = "pip_controller")
    private com.bytedance.sdk.openadsdk.core.video.xt.xt tl;

    @com.bytedance.sdk.component.qv.xt.j(j = "activity_type")
    private int up;

    @com.bytedance.sdk.component.qv.xt.j(j = d.X)
    private Context xt;

    @Override // com.bytedance.sdk.component.qv.j.j.cw
    public boolean j(Map<String, Object> map, final Map<String, Object> map2, final com.bytedance.sdk.component.qv.j.j jVar) {
        if (this.f29064m) {
            return true;
        }
        if (this.ae) {
            jVar.xt(map2);
            return true;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(SocializeProtocolConstants.PROTOCOL_KEY_EXTEND, this.f29063j.os());
            jSONObject.putOpt("live_interaction_type", Integer.valueOf(this.f29063j.ww()));
            jSONObject.putOpt("req_id", this.f29063j.ej());
            jSONObject.putOpt("uchain", Boolean.TRUE);
        } catch (JSONException unused) {
        }
        com.bytedance.sdk.openadsdk.core.kt.ws.j().j("landing_page", AMPSConstants.AdType.AD_TYPE_NATIVE, 0, jSONObject);
        if (this.f29065r == 2) {
            boolean j6 = j();
            if (j6) {
                jVar.j(map2);
            } else {
                jVar.xt(map2);
            }
            return j6;
        }
        com.bytedance.sdk.openadsdk.core.video.xt.xt xtVar = this.tl;
        if (xtVar != null && new com.bytedance.sdk.openadsdk.core.g.j.j.xt.xt(xtVar).j(new HashMap())) {
            jVar.j(map2);
            return true;
        }
        Intent intent = new Intent(this.xt, (Class<?>) uf.m(this.up));
        if (!(this.xt instanceof Activity)) {
            intent.addFlags(268435456);
        }
        intent.putExtra("is_outer_click", true);
        n nVar = this.f29063j;
        if (nVar != null) {
            intent.putExtra("has_phone_num_status", nVar.cw());
        }
        if (map == null) {
            com.bytedance.sdk.component.utils.vl.r("UChain_LP", "param == null");
            jVar.xt(map2);
        }
        map.putAll(map2);
        map.remove(d.X);
        map.remove("activity_type");
        Object remove = map.remove(SocialConstants.PARAM_SOURCE);
        uf.j(map, this.f29063j);
        int i6 = -1;
        if (remove != null && !TextUtils.isEmpty(remove.toString())) {
            try {
                i6 = Integer.parseInt(remove.toString());
            } catch (Exception unused2) {
            }
        }
        intent.putExtra(SocialConstants.PARAM_SOURCE, i6);
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            Object value = entry.getValue();
            if (value != null) {
                intent.putExtra(entry.getKey(), value.toString());
            }
        }
        com.bytedance.sdk.component.utils.xt.j(this.xt, intent, new xt.j() { // from class: com.bytedance.sdk.openadsdk.core.g.j.xt.oq.1
            @Override // com.bytedance.sdk.component.utils.xt.j
            public void j() {
                jVar.j(map2);
                map2.put("is_open_web_page", Boolean.TRUE);
            }

            @Override // com.bytedance.sdk.component.utils.xt.j
            public void j(Throwable th) {
                jVar.xt(map2);
            }
        });
        return true;
    }

    private boolean j() {
        if (!com.bytedance.sdk.component.utils.ws.j(this.cw)) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        try {
            intent.setData(Uri.parse(this.cw));
            if (!(this.xt instanceof Activity)) {
                intent.addFlags(268435456);
            }
            com.bytedance.sdk.component.utils.xt.j(this.xt, intent, null);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
