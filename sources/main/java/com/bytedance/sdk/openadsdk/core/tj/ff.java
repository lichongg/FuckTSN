package com.bytedance.sdk.openadsdk.core.tj;

import android.graphics.Color;
import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class ff {
    private int ae;
    private int az;

    /* renamed from: j, reason: collision with root package name */
    private int f30265j;
    private int jy;

    /* renamed from: m, reason: collision with root package name */
    private int f30266m;
    private xt qv;

    /* renamed from: r, reason: collision with root package name */
    private int f30267r;
    private int tl;
    private int up;
    private xt vl;
    private j ws;
    private String xt;
    private boolean cw = false;

    /* renamed from: g, reason: collision with root package name */
    private String f30264g = "#008DEA";
    private String oq = "点击查看";

    public class j {
        int cw;

        /* renamed from: j, reason: collision with root package name */
        int f30268j;

        /* renamed from: r, reason: collision with root package name */
        int f30269r;
        int xt;

        public j(JSONObject jSONObject, int i6) {
            this.f30268j = 30;
            this.xt = 30;
            this.cw = 150;
            this.f30269r = 40;
            if (jSONObject == null) {
                if (i6 == 2) {
                    this.cw = 40;
                    this.f30269r = 20;
                    return;
                }
                return;
            }
            int optInt = jSONObject.optInt("left_margin", 30);
            this.f30268j = optInt;
            if (optInt < 0 || optInt > ff.this.i()) {
                this.f30268j = 30;
            }
            int optInt2 = jSONObject.optInt("right_margin", 30);
            this.xt = optInt2;
            if (optInt2 < 0 || optInt2 > ff.this.i()) {
                this.xt = 30;
            }
            if (i6 == 2) {
                int optInt3 = jSONObject.optInt("top_margin", 40);
                this.cw = optInt3;
                if (optInt3 < 0 || optInt3 > ff.this.av()) {
                    this.cw = 40;
                }
                int optInt4 = jSONObject.optInt("bottom_margin", 20);
                this.f30269r = optInt4;
                if (optInt4 < 0 || optInt4 > ff.this.av()) {
                    this.f30269r = 20;
                    return;
                }
                return;
            }
            int optInt5 = jSONObject.optInt("top_margin", 150);
            this.cw = optInt5;
            if (optInt5 < 0 || optInt5 > ff.this.av()) {
                this.cw = 150;
            }
            int optInt6 = jSONObject.optInt("bottom_margin", 40);
            this.f30269r = optInt6;
            if (optInt6 < 0 || optInt6 > ff.this.av()) {
                this.f30269r = 40;
            }
        }

        public int cw() {
            return this.cw;
        }

        public int j() {
            return this.f30268j;
        }

        public int r() {
            return this.f30269r;
        }

        public JSONObject up() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("left_margin", 30);
                jSONObject.put("right_margin", 30);
                jSONObject.put("top_margin", 150);
                jSONObject.put("bottom_margin", 40);
            } catch (Exception unused) {
            }
            return jSONObject;
        }

        public int xt() {
            return this.xt;
        }
    }

    public class xt {

        /* renamed from: j, reason: collision with root package name */
        int f30270j;

        public xt(JSONObject jSONObject, int i6) {
            this.f30270j = 14;
            if (jSONObject == null) {
                return;
            }
            this.f30270j = jSONObject.optInt("font_size", i6);
        }

        public JSONObject j() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("font_size", this.f30270j);
            } catch (Exception unused) {
            }
            return jSONObject;
        }

        public int xt() {
            return this.f30270j;
        }
    }

    public int ae() {
        return this.tl;
    }

    public boolean cw() {
        return this.cw;
    }

    public int m() {
        return this.ae;
    }

    public int r() {
        return this.up;
    }

    public int tl() {
        return this.az;
    }

    public int up() {
        return this.f30266m;
    }

    public void ae(int i6) {
        this.f30267r = i6;
    }

    public int az() {
        return this.jy;
    }

    public void cw(int i6) {
        this.f30266m = i6;
    }

    public int g() {
        if (this.f30267r == 4 && !com.bytedance.sdk.openadsdk.core.oq.i().j(com.bytedance.sdk.openadsdk.core.v.getContext())) {
            this.f30267r = 0;
        } else if (this.f30267r == 7 && !com.bytedance.sdk.openadsdk.core.oq.i().xt(com.bytedance.sdk.openadsdk.core.v.getContext())) {
            this.f30267r = 0;
        }
        return this.f30267r;
    }

    public int j() {
        return this.f30265j;
    }

    public xt jy() {
        return this.vl;
    }

    public void m(int i6) {
        this.az = i6;
    }

    public String oq() {
        return this.f30264g;
    }

    public String qv() {
        return this.oq;
    }

    public void r(int i6) {
        this.ae = i6;
    }

    public void tl(int i6) {
        if (i6 <= 0 || i6 >= av()) {
            this.jy = 5;
        } else {
            this.jy = i6;
        }
    }

    public void up(int i6) {
        this.tl = i6;
    }

    public xt vl() {
        return this.qv;
    }

    public j ws() {
        return this.ws;
    }

    public String xt() {
        if (this.f30267r == 4 && !com.bytedance.sdk.openadsdk.core.oq.i().j(com.bytedance.sdk.openadsdk.core.v.getContext())) {
            this.xt = "点击跳转至详情页或第三方应用";
        } else if (this.f30267r == 7 && !com.bytedance.sdk.openadsdk.core.oq.i().xt(com.bytedance.sdk.openadsdk.core.v.getContext())) {
            this.xt = "点击跳转至详情页或第三方应用";
        }
        return this.xt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int av() {
        return com.bytedance.sdk.openadsdk.core.rn.ed.r(com.bytedance.sdk.openadsdk.core.v.getContext(), com.bytedance.sdk.openadsdk.core.rn.ed.up(com.bytedance.sdk.openadsdk.core.v.getContext()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int i() {
        return com.bytedance.sdk.openadsdk.core.rn.ed.r(com.bytedance.sdk.openadsdk.core.v.getContext(), com.bytedance.sdk.openadsdk.core.rn.ed.r(com.bytedance.sdk.openadsdk.core.v.getContext()));
    }

    public void cw(String str) {
        if (TextUtils.isEmpty(str)) {
            int i6 = this.f30267r;
            if (i6 == 7) {
                this.oq = "扭动手机";
                return;
            } else if (i6 == 5) {
                this.oq = "向上滑动";
                return;
            } else {
                if (i6 == 4) {
                    this.oq = "摇一摇";
                    return;
                }
                return;
            }
        }
        this.oq = str;
    }

    public void j(int i6) {
        this.f30265j = i6;
    }

    public void j(String str) {
        if (TextUtils.isEmpty(str)) {
            this.cw = true;
            int i6 = this.f30267r;
            if (i6 == 3) {
                this.xt = "跳转至详情页或第三方应用";
                return;
            }
            if (i6 == 4) {
                this.xt = "前往详情页或第三方应用";
                return;
            } else if (i6 != 5 && i6 != 7) {
                this.xt = "点击跳转至详情页或第三方应用";
                return;
            } else {
                this.xt = "前往详情页或第三方应用";
                return;
            }
        }
        this.xt = str;
    }

    public void xt(int i6) {
        this.up = i6;
    }

    public void xt(String str) {
        try {
            Color.parseColor(str);
            this.f30264g = str;
        } catch (Throwable unused) {
            this.f30264g = "#008DEA";
        }
    }

    public void xt(JSONObject jSONObject) {
        this.vl = new xt(jSONObject, 20);
    }

    public void j(JSONObject jSONObject) {
        this.qv = new xt(jSONObject, 14);
    }

    public void j(JSONObject jSONObject, int i6) {
        this.ws = new j(jSONObject, i6);
    }
}
