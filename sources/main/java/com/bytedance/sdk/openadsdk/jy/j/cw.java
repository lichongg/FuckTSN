package com.bytedance.sdk.openadsdk.jy.j;

import android.content.Context;
import android.net.Uri;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.component.xt.j.oq;
import com.bytedance.sdk.openadsdk.core.kt.ws;
import com.bytedance.sdk.openadsdk.jy.j.j;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw extends j {
    private String tl;

    @Override // com.bytedance.sdk.openadsdk.jy.j.j
    public void j(Context context, String str, com.bytedance.sdk.openadsdk.jy.xt xtVar, WebResourceResponse webResourceResponse, oq oqVar, Map<String, Object> map) {
    }

    public JSONObject up() {
        int i6;
        JSONArray optJSONArray;
        try {
            i6 = this.f31529j.xt().get();
            optJSONArray = this.f31530m.optJSONArray(this.tl);
        } catch (Exception e6) {
            vl.j(e6);
        }
        if (optJSONArray == null) {
            return null;
        }
        int length = optJSONArray.length();
        for (int i7 = 0; i7 < length; i7++) {
            JSONObject jSONObject = optJSONArray.getJSONObject(i7);
            int optInt = jSONObject.optInt("jump_number", -1);
            if (optInt != -1 && optInt == i6) {
                return jSONObject;
            }
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.jy.j.j
    public void cw() {
        this.f31529j.j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.jy.j.cw.1
            @Override // java.lang.Runnable
            public void run() {
                cw.this.r();
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.jy.j.j
    public void j(String str, String str2) {
    }

    public void r() {
        JSONObject jSONObject = this.f31530m;
        if (jSONObject == null) {
            return;
        }
        ws.j().cw(jSONObject.toString(), this.f31530m.optString("req_id"));
    }

    public cw(com.bytedance.sdk.openadsdk.jy.j jVar, String str, String str2, JSONObject jSONObject, String str3, String str4) {
        super(jVar, str, str2, jSONObject, str3, str4);
        this.tl = "inspect_data";
    }

    @Override // com.bytedance.sdk.openadsdk.jy.j.j
    protected void j(JSONObject jSONObject, String str, oq oqVar, String str2, String str3, Map<String, String> map, Map<String, Object> map2) {
    }

    @Override // com.bytedance.sdk.openadsdk.jy.j.j
    public boolean j(WebView webView) {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.jy.j.j
    public boolean j(oq oqVar) {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.jy.j.j
    public void j() {
        try {
            this.f31530m.putOpt("req_id", this.cw);
            this.f31530m.put(this.tl, new JSONArray());
        } catch (Exception e6) {
            vl.j(e6);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.jy.j.j
    public void j(String str) {
        int i6 = this.f31529j.xt().get();
        JSONArray optJSONArray = this.f31530m.optJSONArray(this.tl);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("jump_number", i6);
            jSONObject.put("jump_url", str);
            optJSONArray.put(jSONObject);
            this.f31530m.put("inspect_data", optJSONArray);
        } catch (Exception e6) {
            vl.j(e6);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.jy.j.j
    public void j(com.bytedance.sdk.openadsdk.jy.xt xtVar, WebResourceResponse webResourceResponse, oq oqVar, j.InterfaceC0502j interfaceC0502j) {
        Uri j6 = xtVar.j();
        if (j6 != null) {
            try {
                String uri = j6.toString();
                String str = "unknown";
                if (oqVar != null && oqVar.xt() != null) {
                    str = oqVar.xt().trim().toLowerCase();
                }
                JSONObject up = up();
                if (up == null) {
                    vl.r("weblp", "error pageCountJson is null");
                } else {
                    JSONArray optJSONArray = up.optJSONArray(str);
                    if (optJSONArray == null) {
                        optJSONArray = new JSONArray();
                    }
                    optJSONArray.put(uri);
                    up.putOpt(str, optJSONArray);
                }
            } catch (Exception e6) {
                vl.j(e6);
                vl.cw("weblp", "error", e6);
            }
        }
        interfaceC0502j.j(false, null);
    }

    @Override // com.bytedance.sdk.openadsdk.jy.j.j
    public void xt(Context context, String str, com.bytedance.sdk.openadsdk.jy.xt xtVar, WebResourceResponse webResourceResponse, oq oqVar, Map<String, Object> map) {
    }
}
