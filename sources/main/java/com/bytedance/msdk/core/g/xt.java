package com.bytedance.msdk.core.g;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.vl;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class xt extends j {

    /* renamed from: r, reason: collision with root package name */
    private static volatile xt f24467r;
    protected final Map<String, String> cw;

    protected void j(String str, int i6, double d6) {
        if (!com.bytedance.msdk.core.xt.xt().hl() || TextUtils.isEmpty(str)) {
            return;
        }
        j(3, str, i6, d6);
    }

    private xt() {
        super("label_v_v_s_3");
        this.cw = new ConcurrentHashMap();
        xt();
    }

    public static xt r() {
        if (f24467r == null) {
            synchronized (xt.class) {
                try {
                    if (f24467r == null) {
                        f24467r = new xt();
                    }
                } finally {
                }
            }
        }
        return f24467r;
    }

    protected void cw(String str, JSONObject jSONObject, Map<String, Object> map) {
        if (!com.bytedance.msdk.core.xt.xt().hl() || TextUtils.isEmpty(str) || jSONObject == null) {
            return;
        }
        try {
            jSONObject.putOpt("rule_id", map.get("rule_id"));
        } catch (JSONException e6) {
            vl.j(e6);
        }
    }

    @Override // com.bytedance.msdk.core.g.j
    protected boolean xt(String str, JSONObject jSONObject, Map<String, Object> map) {
        try {
            Object obj = map.get("user_label_value");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject.put(str, jSONObject2);
            jSONObject2.putOpt("label_info", j(obj != null ? (com.bytedance.msdk.core.oq.cw) obj : null));
            jSONObject2.putOpt("ecpm_ttl", Integer.valueOf(com.bytedance.msdk.core.xt.xt().b()));
            jSONObject2.putOpt("rule_id", map.get("rule_id"));
            jSONObject2.putOpt("group_type", map.get("group_type"));
            jSONObject2.putOpt("rule_in_use", map.get("rule_in_use"));
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.putOpt("ecpm", map.get("ecpm"));
            jSONObject3.putOpt("timestamp", String.valueOf(System.currentTimeMillis()));
            jSONObject2.putOpt("ecpm_info", jSONObject3);
            jSONObject2.putOpt("refresh_time", map.get("refresh_time"));
            return true;
        } catch (JSONException e6) {
            vl.j(e6);
            return false;
        }
    }

    @Override // com.bytedance.msdk.core.g.j
    protected void j(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        com.bytedance.msdk.j.up.cw.xt("DynamicLabelValueManagerAbs", "readCacheFromSp-SP_NAME_V3，cpmKey:" + str + "，type_value_timestamp:" + str2);
        if (str.startsWith("cpm_key_")) {
            this.cw.put(str, str2);
        }
    }

    @Override // com.bytedance.msdk.core.g.j
    protected Map<String, String> j() {
        return this.cw;
    }

    @Override // com.bytedance.msdk.core.g.j
    protected void j(String str, int i6, String str2) {
        if (i6 == 3) {
            this.cw.put(str, str2);
        }
    }

    @Override // com.bytedance.msdk.core.g.j
    protected JSONObject j(com.bytedance.msdk.core.oq.cw cwVar) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("label_name", cwVar != null ? cwVar.j() : "-1");
            jSONObject.putOpt("label_id", cwVar != null ? Integer.valueOf(cwVar.cw()) : "-1");
            jSONObject.putOpt("label_version", cwVar != null ? cwVar.r() : "-1");
            return jSONObject;
        } catch (JSONException e6) {
            vl.j(e6);
            return null;
        }
    }
}
