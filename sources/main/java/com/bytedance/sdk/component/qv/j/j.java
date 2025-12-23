package com.bytedance.sdk.component.qv.j;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.component.qv.r.r;
import com.bytedance.sdk.component.qv.r.up;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {
    private r ae;
    private com.bytedance.sdk.component.qv.cw.j cw;

    /* renamed from: g, reason: collision with root package name */
    private Map<String, Object> f26733g;

    /* renamed from: j, reason: collision with root package name */
    private JSONObject f26734j;

    /* renamed from: m, reason: collision with root package name */
    private r f26735m;
    private int oq = 1;
    private com.bytedance.sdk.component.qv.r.xt qv;

    /* renamed from: r, reason: collision with root package name */
    private String f26736r;
    private String tl;
    private String up;
    private Map<String, Object> xt;

    public j(com.bytedance.sdk.component.qv.cw.j jVar, JSONObject jSONObject, Map<String, Object> map) {
        this.cw = jVar;
        this.f26734j = jSONObject;
        this.xt = map;
    }

    public Map<String, Object> j() {
        return this.xt;
    }

    public Map<String, Object> xt() {
        return this.f26733g;
    }

    private void tl() {
        if (this.oq != 2) {
            com.bytedance.sdk.component.qv.cw.j jVar = this.cw;
            if (jVar == null) {
                return;
            } else {
                this.tl = jVar.xt();
            }
        }
        if (!TextUtils.isEmpty(this.tl)) {
            this.f26736r = Uri.parse(this.tl).getHost();
        }
        if (!TextUtils.isEmpty(this.f26736r)) {
            String str = this.f26736r.split("/")[0];
            this.f26736r = str;
            int indexOf = str.indexOf(":");
            if (indexOf == -1) {
                indexOf = this.f26736r.length();
            }
            this.f26736r = this.f26736r.substring(0, indexOf);
        }
        xt(this.tl);
    }

    private void xt(String str) {
        JSONObject j6 = com.bytedance.sdk.component.qv.tl.xt.j(str);
        if (j6 == null) {
            return;
        }
        Iterator<String> keys = j6.keys();
        this.f26733g = new HashMap();
        while (keys.hasNext()) {
            String next = keys.next();
            if (!TextUtils.isEmpty(next)) {
                Object opt = j6.opt(next);
                if (opt instanceof String) {
                    opt = j((String) opt, this.f26734j);
                }
                this.f26733g.put(next, opt);
            }
        }
    }

    public com.bytedance.sdk.component.qv.cw.j ae() {
        return this.cw;
    }

    public JSONObject cw() {
        return this.f26734j;
    }

    public void j(String str) {
        this.up = str;
    }

    public String r() {
        return this.up;
    }

    public r up() {
        return this.f26735m;
    }

    public void j(r rVar) {
        if (rVar instanceof xt) {
            this.f26735m = rVar;
        } else {
            this.ae = rVar;
        }
    }

    public void m() {
        tl();
        com.bytedance.sdk.component.qv.r.xt xtVar = this.qv;
        if (xtVar != null) {
            xtVar.j();
        } else {
            com.bytedance.sdk.component.qv.ae.j.j().j(this.f26736r, this, new com.bytedance.sdk.component.qv.r.j() { // from class: com.bytedance.sdk.component.qv.j.j.1
            });
        }
    }

    public j(StringBuilder sb, JSONObject jSONObject, Map<String, Object> map) {
        this.f26734j = jSONObject;
        this.xt = map;
    }

    private static Object j(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str) || jSONObject == null) {
            return str;
        }
        try {
            return (str.startsWith("${") && str.endsWith("}")) ? com.bytedance.adsdk.xt.xt.j.j(str.substring(2, str.length() - 1)).j(jSONObject) : str;
        } catch (Throwable unused) {
            return str;
        }
    }

    public void j(com.bytedance.sdk.component.qv.r.xt xtVar) {
        this.qv = xtVar;
    }

    public void j(Map<String, Object> map) {
        up xt;
        up xt2;
        r rVar = this.f26735m;
        if (rVar != null && (xt2 = rVar.xt()) != null) {
            xt2.j(this, map);
        }
        r rVar2 = this.ae;
        if (rVar2 == null || (xt = rVar2.xt()) == null) {
            return;
        }
        xt.j(this, map);
    }

    public void xt(Map<String, Object> map) {
        up xt;
        up xt2;
        r rVar = this.f26735m;
        if (rVar != null && (xt2 = rVar.xt()) != null) {
            xt2.xt(this, this.xt);
        }
        r rVar2 = this.ae;
        if (rVar2 == null || (xt = rVar2.xt()) == null) {
            return;
        }
        xt.xt(this, map);
    }
}
