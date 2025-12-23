package com.bytedance.adsdk.ugeno.cw;

import android.text.TextUtils;
import com.umeng.analytics.pro.d;
import com.umeng.socialize.common.SocializeConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class g {
    private boolean ae;
    private String cw;

    /* renamed from: g, reason: collision with root package name */
    private float f23588g;

    /* renamed from: j, reason: collision with root package name */
    private JSONObject f23589j;

    /* renamed from: m, reason: collision with root package name */
    private JSONObject f23590m;

    /* renamed from: r, reason: collision with root package name */
    private JSONObject f23591r;
    private float tl;
    private String up;
    private JSONObject xt;

    public static class j {
        private String ae;
        private JSONObject cw;

        /* renamed from: g, reason: collision with root package name */
        private boolean f23592g;

        /* renamed from: j, reason: collision with root package name */
        private String f23593j;

        /* renamed from: m, reason: collision with root package name */
        private j f23594m;
        private boolean oq;

        /* renamed from: r, reason: collision with root package name */
        private JSONObject f23595r;
        private String tl;
        private LinkedList<j> up;
        private String xt;

        public JSONObject m() {
            return this.f23595r;
        }

        public JSONObject r() {
            return this.cw;
        }

        public String toString() {
            return "UGNode{id='" + this.f23593j + "', name='" + this.xt + "'}";
        }

        public List<j> up() {
            return this.up;
        }

        public String cw() {
            return this.xt;
        }

        public String xt() {
            return this.ae;
        }

        public String j() {
            return this.f23593j;
        }

        public void xt(boolean z5) {
            this.oq = z5;
        }

        public void j(String str) {
            this.xt = str;
        }

        public void xt(j jVar) {
            if (this.up == null) {
                this.up = new LinkedList<>();
            }
            this.up.addLast(jVar);
        }

        public void j(boolean z5) {
            this.f23592g = z5;
        }

        public void j(j jVar) {
            if (this.up == null) {
                this.up = new LinkedList<>();
            }
            this.up.add(jVar);
        }

        public void j(int i6, j jVar) {
            if (this.up == null) {
                this.up = new LinkedList<>();
            }
            this.up.add(i6, jVar);
        }
    }

    public g(JSONObject jSONObject, JSONObject jSONObject2) {
        this(jSONObject, jSONObject2, null);
    }

    public List<j> cw() {
        if (this.xt == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> keys = this.xt.keys();
        while (keys.hasNext()) {
            j j6 = j(this.xt.optJSONObject(keys.next()), (j) null);
            if (j6 != null) {
                arrayList.add(j6);
            }
        }
        return arrayList;
    }

    public j j() {
        return up();
    }

    public boolean r() {
        return this.ae;
    }

    public String xt() {
        return this.cw;
    }

    public g(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        if (jSONObject != null) {
            if (jSONObject.has("body")) {
                this.f23589j = jSONObject.optJSONObject("body");
            } else {
                this.f23589j = jSONObject.optJSONObject("main_template");
            }
            this.xt = jSONObject.optJSONObject("sub_templates");
            JSONObject optJSONObject = jSONObject.has("meta") ? jSONObject.optJSONObject("meta") : jSONObject.optJSONObject("template_info");
            if (optJSONObject != null) {
                if (jSONObject.has("body")) {
                    this.ae = true;
                    String optString = optJSONObject.optString("version");
                    this.cw = optString;
                    if (TextUtils.isEmpty(optString)) {
                        this.cw = SocializeConstants.PROTOCOL_VERSON;
                    }
                } else {
                    this.cw = optJSONObject.optString("sdk_version");
                }
                if (optJSONObject.has("adType")) {
                    this.up = optJSONObject.optString("adType");
                }
            } else if (jSONObject.has("body")) {
                this.cw = SocializeConstants.PROTOCOL_VERSON;
                this.ae = true;
            }
            this.f23591r = jSONObject2;
            this.f23590m = jSONObject3;
        }
    }

    public static boolean r(j jVar) {
        return (jVar == null || jVar.cw == null) ? false : true;
    }

    private j up() {
        if (!r()) {
            return j(this.f23589j, (j) null);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("flexDirection", "row");
            jSONObject.put("justifyContent", "flex_start");
            jSONObject.put("alignItems", "flex_start");
            jSONObject.put("clickable", false);
            jSONObject.put("width", "match_parent");
            jSONObject.put("height", "wrap_content");
            float f6 = this.tl;
            if (f6 > 0.0f) {
                jSONObject.put("width", f6);
            }
            float f7 = this.f23588g;
            if (f7 > 0.0f) {
                jSONObject.put("height", f7);
            }
            String optString = this.f23591r.optString("xSize");
            if (!TextUtils.isEmpty(optString)) {
                JSONObject jSONObject2 = new JSONObject(optString);
                if (jSONObject2.optInt("width") > 0) {
                    jSONObject.put("width", jSONObject2.optInt("width"));
                }
                if (jSONObject2.optInt("height") > 0) {
                    jSONObject.put("height", jSONObject2.optInt("height"));
                }
            }
        } catch (JSONException unused) {
        }
        j jVar = new j();
        jVar.xt = "View";
        jVar.f23593j = "virtualNode";
        jVar.cw = jSONObject;
        jVar.f23594m = null;
        jVar.ae = this.cw;
        jVar.tl = this.up;
        jVar.j(j(this.f23589j, jVar));
        return jVar;
    }

    public void j(float f6, float f7) {
        this.tl = f6;
        this.f23588g = f7;
    }

    public boolean xt(j jVar) {
        JSONObject r5;
        if (jVar == null || (r5 = jVar.r()) == null) {
            return false;
        }
        return TextUtils.equals(r5.optString("height"), "match_parent");
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0106  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.bytedance.adsdk.ugeno.cw.g.j j(org.json.JSONObject r12, com.bytedance.adsdk.ugeno.cw.g.j r13) {
        /*
            Method dump skipped, instructions count: 273
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ugeno.cw.g.j(org.json.JSONObject, com.bytedance.adsdk.ugeno.cw.g$j):com.bytedance.adsdk.ugeno.cw.g$j");
    }

    public boolean cw(j jVar) {
        JSONObject r5;
        if (jVar == null || (r5 = jVar.r()) == null) {
            return false;
        }
        return TextUtils.equals(r5.optString("position"), "absolute");
    }

    public boolean j(j jVar) {
        JSONObject r5;
        if (jVar == null || (r5 = jVar.r()) == null) {
            return false;
        }
        return TextUtils.equals(r5.optString("width"), "match_parent");
    }

    private void j(JSONObject jSONObject, JSONObject jSONObject2) {
        if (this.f23590m == null || jSONObject2 == null) {
            return;
        }
        try {
            String optString = this.f23590m.optString(jSONObject2.optString("targetId"));
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            JSONObject jSONObject3 = new JSONObject(optString);
            JSONObject optJSONObject = jSONObject2.optJSONObject("targetProps");
            if (optJSONObject != null) {
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    Object opt = optJSONObject.opt(next);
                    if (TextUtils.equals(next, d.ax) && jSONObject3.has(d.ax)) {
                        if (opt instanceof JSONArray) {
                            com.bytedance.adsdk.ugeno.m.xt.j(jSONObject3.optJSONArray(d.ax), (JSONArray) opt);
                        }
                    } else {
                        jSONObject3.put(next, opt);
                    }
                }
                JSONArray optJSONArray = jSONObject.optJSONArray("children");
                if (optJSONArray == null) {
                    optJSONArray = new JSONArray();
                }
                optJSONArray.put(jSONObject3);
                if (jSONObject.has("children")) {
                    return;
                }
                jSONObject.put("children", optJSONArray);
            }
        } catch (JSONException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
        }
    }
}
