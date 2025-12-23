package com.bytedance.sdk.openadsdk.core.tj;

import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class a {
    private xt cw;

    /* renamed from: j, reason: collision with root package name */
    private boolean f30208j;

    /* renamed from: r, reason: collision with root package name */
    private int f30209r;
    private j xt;

    public static class j {
        private int ae;
        private String cw;

        /* renamed from: g, reason: collision with root package name */
        private String f30210g;

        /* renamed from: j, reason: collision with root package name */
        private int f30211j;

        /* renamed from: m, reason: collision with root package name */
        private int f30212m;

        /* renamed from: r, reason: collision with root package name */
        private String f30213r;
        private int tl;
        private int up;
        private int xt;

        public int j() {
            return this.f30211j;
        }

        public boolean ae() {
            return !TextUtils.isEmpty(this.f30213r);
        }

        public int cw() {
            return this.xt;
        }

        public boolean j(int i6, int i7) {
            int r5 = com.bytedance.sdk.openadsdk.core.rn.ed.r(com.bytedance.sdk.openadsdk.core.v.getContext(), i6);
            int r6 = com.bytedance.sdk.openadsdk.core.rn.ed.r(com.bytedance.sdk.openadsdk.core.v.getContext(), i7);
            int i8 = this.ae;
            if (i8 != 0 && r5 < i8) {
                return false;
            }
            int i9 = this.f30212m;
            if (i9 == 0 || r6 >= i9) {
                return r5 == 0 || r6 == 0 || ((float) r6) / ((float) r5) >= ((float) this.tl);
            }
            return false;
        }

        public boolean m() {
            return this.up == 1;
        }

        public String r() {
            return this.cw;
        }

        public String up() {
            return this.f30213r;
        }

        public String xt() {
            return this.f30210g;
        }

        public j(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.xt = jSONObject.optInt("displayAreaAndroid");
            this.cw = jSONObject.optString("ugen_md5");
            this.f30213r = jSONObject.optString("ugen_url");
            this.up = jSONObject.optInt("need_backup_convert_area", 0);
            this.f30212m = jSONObject.optInt("min_height", 0);
            this.ae = jSONObject.optInt("min_width", 0);
            this.tl = jSONObject.optInt("min_ratio", 0);
            this.f30210g = jSONObject.optString("ugen_id");
            this.f30211j = jSONObject.optInt("render_sequence", 2);
        }
    }

    public static class xt {

        /* renamed from: j, reason: collision with root package name */
        j f30214j;
        j xt;

        public static class j {

            /* renamed from: j, reason: collision with root package name */
            String f30215j;
            int xt;

            public boolean j() {
                return !TextUtils.isEmpty(this.f30215j);
            }

            public j(JSONObject jSONObject) {
                if (jSONObject == null) {
                    return;
                }
                this.f30215j = jSONObject.optString("entry");
                this.xt = jSONObject.optInt("displayAreaAndroid");
            }
        }

        public boolean j() {
            j jVar = this.xt;
            if (jVar != null && jVar.j()) {
                return true;
            }
            j jVar2 = this.f30214j;
            return jVar2 != null && jVar2.j();
        }

        public int xt() {
            j jVar = this.f30214j;
            if (jVar != null) {
                return jVar.xt;
            }
            j jVar2 = this.xt;
            if (jVar2 != null) {
                return jVar2.xt;
            }
            return 0;
        }

        public xt(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.f30214j = new j(jSONObject.optJSONObject("vertical"));
            this.xt = new j(jSONObject.optJSONObject("horizontal"));
        }

        public String j(boolean z5) {
            j jVar;
            if (z5 && (jVar = this.f30214j) != null && jVar.j()) {
                return this.f30214j.f30215j;
            }
            j jVar2 = this.xt;
            if (jVar2 != null && jVar2.j()) {
                return this.xt.f30215j;
            }
            j jVar3 = this.f30214j;
            if (jVar3 != null && jVar3.j()) {
                return this.f30214j.f30215j;
            }
            return "";
        }
    }

    public static String cw(n nVar) {
        a jv;
        j jVar;
        if (nVar == null || (jv = nVar.jv()) == null || (jVar = jv.xt) == null) {
            return null;
        }
        return jVar.xt();
    }

    public static boolean j(n nVar) {
        a jv;
        j jVar;
        return (nVar == null || (jv = nVar.jv()) == null || (jVar = jv.xt) == null || !jVar.ae()) ? false : true;
    }

    public static j m(n nVar) {
        a jv;
        if (nVar == null || (jv = nVar.jv()) == null) {
            return null;
        }
        return jv.xt;
    }

    public static xt up(n nVar) {
        a jv;
        if (nVar == null || (jv = nVar.jv()) == null) {
            return null;
        }
        return jv.cw;
    }

    public static boolean xt(n nVar) {
        a jv;
        xt xtVar;
        return (nVar == null || (jv = nVar.jv()) == null || !jv.f30208j || (xtVar = jv.cw) == null || !xtVar.j()) ? false : true;
    }

    public static int r(n nVar) {
        if (nVar == null) {
            return 0;
        }
        return nVar.jv().f30209r;
    }

    public a(JSONObject jSONObject) {
        this.f30208j = false;
        if (jSONObject == null) {
            return;
        }
        this.f30208j = jSONObject.optBoolean("use_interact_webview", false);
        JSONObject optJSONObject = jSONObject.optJSONObject("easy_playable_client");
        if (optJSONObject != null) {
            this.xt = new j(optJSONObject.optJSONObject("components"));
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("easy_playable");
        if (optJSONObject2 != null) {
            this.cw = new xt(optJSONObject2.optJSONObject("components"));
        }
        this.f30209r = jSONObject.optInt("style_category");
    }

    public static boolean j() {
        int i6 = com.bytedance.sdk.openadsdk.core.h.xt;
        return (i6 >= 6322 && i6 < 6400) || i6 >= 6406;
    }
}
