package com.bytedance.sdk.openadsdk.core.tj;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class tj {
    private int ae;
    private int av;
    private int az;
    private int cw;

    /* renamed from: g, reason: collision with root package name */
    private int f30443g;

    /* renamed from: i, reason: collision with root package name */
    private int f30444i;

    /* renamed from: j, reason: collision with root package name */
    private int f30445j;
    private int jy;
    private String kt;

    /* renamed from: m, reason: collision with root package name */
    private int f30446m;
    private int mi;
    private int oq;
    private int qv;

    /* renamed from: r, reason: collision with root package name */
    private int f30447r;
    private String tj;
    private int tl;
    private int up;
    private int vl;

    /* renamed from: w, reason: collision with root package name */
    private int f30448w;
    private int ws;
    private int xt;

    public static String cw(n nVar) {
        tj f6 = f(nVar);
        if (f6 == null) {
            return "close_obm";
        }
        int r5 = f6.r();
        String vm = nVar.vm();
        if (r5 == 1 && vm != null) {
            return "open";
        }
        return "close_" + r5 + "_" + vm;
    }

    public static boolean j(n nVar) {
        tj f6 = f(nVar);
        return f6 != null && f6.av == 1;
    }

    public static int r(n nVar) {
        tj f6 = f(nVar);
        if (f6 == null) {
            return 1;
        }
        return f6.f30446m;
    }

    public static int up(n nVar) {
        tj f6 = f(nVar);
        if (f6 == null) {
            return 0;
        }
        return f6.ae;
    }

    public static int xt(n nVar) {
        tj f6 = f(nVar);
        if (f6 == null) {
            return 0;
        }
        return f6.r();
    }

    private static tj f(n nVar) {
        if (nVar == null) {
            return null;
        }
        return nVar.fx();
    }

    public tj(JSONObject jSONObject) {
        this.f30445j = 0;
        this.xt = 1;
        this.cw = 1;
        this.f30447r = 1;
        this.up = 1;
        this.f30446m = 1;
        this.ae = 0;
        this.tl = 0;
        this.f30443g = 0;
        this.oq = 300;
        this.qv = -1;
        this.vl = 1;
        this.jy = 1;
        this.ws = 31457280;
        this.az = 0;
        this.av = 0;
        this.f30444i = 0;
        this.f30448w = 0;
        this.mi = 0;
        if (jSONObject == null) {
            return;
        }
        this.f30446m = jSONObject.optInt("auto_open", 1);
        this.ae = jSONObject.optInt("download_mode", 0);
        this.tl = jSONObject.optInt("auto_control", 0);
        this.f30443g = jSONObject.optInt("auto_control_choose", 0);
        this.oq = jSONObject.optInt("auto_control_time", 300);
        this.qv = jSONObject.optInt("download_type", -1);
        this.vl = jSONObject.optInt("if_suspend_download", 1);
        this.f30445j = jSONObject.optInt("if_send_click", 0);
        this.xt = jSONObject.optInt("dl_popup", 1);
        this.cw = jSONObject.optInt("market_popup", 1);
        this.f30447r = jSONObject.optInt("if_pop_lp", 1);
        this.up = jSONObject.optInt("pop_up_style_id", 1);
        this.jy = jSONObject.optInt("dl_network", 1);
        this.ws = jSONObject.optInt("dl_size", 31457280);
        this.az = jSONObject.optInt("if_toast_market", 0);
        this.av = jSONObject.optInt("enable_download_opt", 0);
        if (com.bytedance.sdk.openadsdk.core.multipro.xt.cw()) {
            this.f30444i = 0;
        } else {
            this.f30444i = jSONObject.optInt("dl_suspend_popup", 0);
        }
        this.f30448w = jSONObject.optInt("is_use_obm_convert", 0);
        this.mi = jSONObject.optInt("enable_notification", 0);
        this.kt = jSONObject.optString("ugen_url");
        String optString = jSONObject.optString("ugen_md5");
        this.tj = optString;
        com.bytedance.sdk.openadsdk.core.ugeno.oq.j(this.kt, optString);
    }

    public static boolean ae(n nVar) {
        tj f6 = f(nVar);
        if (f6 == null || f6.tl != 1) {
            return false;
        }
        return true;
    }

    public static int av(n nVar) {
        tj f6 = f(nVar);
        if (f6 == null) {
            return 31457280;
        }
        return f6.ws * 1048576;
    }

    public static int az(n nVar) {
        tj f6 = f(nVar);
        if (f6 == null) {
            return 1;
        }
        return f6.jy;
    }

    public static int g(n nVar) {
        tj f6 = f(nVar);
        if (f6 == null) {
            return 300;
        }
        return f6.oq;
    }

    public static boolean i(n nVar) {
        tj f6 = f(nVar);
        if (f6 != null && f6.az == 1) {
            return true;
        }
        return false;
    }

    public static int jy(n nVar) {
        tj f6 = f(nVar);
        if (f6 == null) {
            return 1;
        }
        return f6.cw;
    }

    public static String kt(n nVar) {
        tj f6 = f(nVar);
        if (f6 == null) {
            return "";
        }
        return f6.kt;
    }

    public static int m(n nVar) {
        tj f6 = f(nVar);
        if (f6 == null) {
            return -1;
        }
        return f6.qv;
    }

    public static int mi(n nVar) {
        tj f6 = f(nVar);
        if (f6 == null) {
            return 0;
        }
        return f6.f30444i;
    }

    public static boolean oq(n nVar) {
        tj f6 = f(nVar);
        if (f6 == null || f6.vl != 1) {
            return false;
        }
        return true;
    }

    public static int qv(n nVar) {
        tj f6 = f(nVar);
        if (f6 == null) {
            return 0;
        }
        return f6.f30445j;
    }

    public static String tj(n nVar) {
        tj f6 = f(nVar);
        if (f6 == null) {
            return "";
        }
        return f6.tj;
    }

    public static boolean tl(n nVar) {
        tj f6 = f(nVar);
        if (f6 == null || f6.f30443g != 1) {
            return false;
        }
        return true;
    }

    public static int vl(n nVar) {
        tj f6 = f(nVar);
        if (f6 == null) {
            return 1;
        }
        return f6.xt;
    }

    public static int w(n nVar) {
        tj f6 = f(nVar);
        if (f6 == null) {
            return 1;
        }
        return f6.up;
    }

    public static int ws(n nVar) {
        tj f6 = f(nVar);
        if (f6 == null) {
            return 1;
        }
        return f6.f30447r;
    }

    public int j() {
        return this.xt;
    }

    public int r() {
        return this.f30448w;
    }

    public int up() {
        return this.f30444i;
    }

    public int xt() {
        return this.ae;
    }

    public void j(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("auto_open", this.f30446m);
            jSONObject2.put("download_mode", this.ae);
            jSONObject2.put("download_type", this.qv);
            jSONObject2.put("auto_control", this.tl);
            jSONObject2.put("auto_control_choose", this.f30443g);
            jSONObject2.put("auto_control_time", this.oq);
            jSONObject2.put("if_suspend_download", this.vl);
            jSONObject2.put("if_send_click", this.f30445j);
            jSONObject2.put("dl_popup", this.xt);
            jSONObject2.put("market_popup", this.cw);
            jSONObject2.put("if_pop_lp", this.f30447r);
            jSONObject2.put("pop_up_style_id", this.up);
            jSONObject2.put("dl_network", this.jy);
            jSONObject2.put("dl_size", this.ws);
            jSONObject2.put("if_toast_market", this.az);
            jSONObject2.put("enable_download_opt", this.av);
            jSONObject2.put("dl_suspend_popup", this.f30444i);
            jSONObject2.put("is_use_obm_convert", this.f30448w);
            jSONObject2.put("ugen_url", this.kt);
            jSONObject2.put("ugen_md5", this.tj);
            jSONObject2.put("enable_notification", this.mi);
            jSONObject.put("download_conf", jSONObject2);
        } catch (JSONException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
        }
    }

    public boolean cw() {
        return this.vl == 1;
    }
}
