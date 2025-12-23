package com.bytedance.sdk.openadsdk.core.tj;

import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class kt {
    private boolean ae;
    private int cw;

    /* renamed from: g, reason: collision with root package name */
    private String f30312g;

    /* renamed from: j, reason: collision with root package name */
    private String f30313j;

    /* renamed from: m, reason: collision with root package name */
    private int f30314m;
    private int oq;

    /* renamed from: r, reason: collision with root package name */
    private int f30315r;
    private String tl;
    private int up;
    private int xt;

    public void j(JSONObject jSONObject) {
        try {
            jSONObject.put("reward_browse_type", this.xt);
        } catch (Exception e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("direct_landing_url", this.f30313j);
            jSONObject2.put("display_duration", this.cw);
            jSONObject2.put("close_time", this.f30315r);
            jSONObject2.put("page_type", this.up);
            jSONObject2.put("show_type", this.f30314m);
            jSONObject2.put("close_btn_position", this.oq);
            jSONObject2.put("is_landing_with_sound", this.ae);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("ugen_url", this.tl);
            jSONObject3.put("ugen_md5", this.f30312g);
            jSONObject2.put("reward_browse_banner", jSONObject3);
            jSONObject.put("direct_landing_page_info", jSONObject2);
        } catch (Exception e7) {
            com.bytedance.sdk.component.utils.vl.j(e7);
        }
    }

    private static kt av(n nVar) {
        if (nVar == null) {
            return null;
        }
        return nVar.sm();
    }

    public kt(JSONObject jSONObject) {
        this.xt = 0;
        if (jSONObject != null) {
            int optInt = jSONObject.optInt("reward_browse_type", 0);
            this.xt = optInt;
            if (optInt < 0 || optInt > 3) {
                this.xt = 0;
            }
            if (this.xt == 2) {
                this.xt = 3;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("direct_landing_page_info");
            if (optJSONObject != null) {
                this.f30313j = optJSONObject.optString("direct_landing_url");
                this.cw = optJSONObject.optInt("display_duration", 0);
                this.f30315r = optJSONObject.optInt("close_time", 0);
                this.up = optJSONObject.optInt("page_type");
                this.f30314m = optJSONObject.optInt("show_type");
                this.ae = optJSONObject.optBoolean("is_landing_with_sound", false);
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("reward_browse_banner");
                if (optJSONObject2 != null) {
                    this.tl = optJSONObject2.optString("ugen_url");
                    this.f30312g = optJSONObject2.optString("ugen_md5");
                }
                this.oq = optJSONObject.optInt("close_btn_position");
            }
        }
    }

    public static boolean ae(n nVar) {
        kt av = av(nVar);
        if (av == null) {
            return false;
        }
        return av.ae;
    }

    public static int az(n nVar) {
        kt av = av(nVar);
        if (av == null) {
            return 0;
        }
        return av.oq;
    }

    public static boolean cw(n nVar) {
        kt av = av(nVar);
        if (av == null || av.xt != 1 || av.up != 1) {
            return false;
        }
        return true;
    }

    public static int g(n nVar) {
        int i6;
        kt av = av(nVar);
        if (av == null || (i6 = av.cw) < 0) {
            return 0;
        }
        return i6;
    }

    public static boolean jy(n nVar) {
        kt av = av(nVar);
        if (av == null || av.oq != 1) {
            return false;
        }
        return true;
    }

    public static String m(n nVar) {
        kt av = av(nVar);
        if (av == null) {
            return "";
        }
        return av.f30313j;
    }

    public static int oq(n nVar) {
        int i6;
        kt av = av(nVar);
        if (av == null || (i6 = av.f30315r) < 0) {
            return 0;
        }
        return i6;
    }

    public static boolean qv(n nVar) {
        if (av(nVar) == null || tl(nVar) != 3 || !j(nVar)) {
            return false;
        }
        return true;
    }

    public static boolean r(n nVar) {
        kt av = av(nVar);
        if (av == null || !j(nVar) || av.xt != 1 || av.up != 2) {
            return false;
        }
        return true;
    }

    public static int tl(n nVar) {
        kt av = av(nVar);
        if (av == null) {
            return 0;
        }
        return av.xt;
    }

    public static boolean up(n nVar) {
        kt av = av(nVar);
        if (av == null || av.f30314m != 3) {
            return false;
        }
        return true;
    }

    public static com.bytedance.sdk.openadsdk.core.ugeno.m.j vl(n nVar) {
        kt av = av(nVar);
        if (av == null || TextUtils.isEmpty(av.tl)) {
            return null;
        }
        com.bytedance.sdk.openadsdk.core.ugeno.m.j jVar = new com.bytedance.sdk.openadsdk.core.ugeno.m.j();
        jVar.cw(av.tl);
        jVar.xt(av.f30312g);
        jVar.j(av.tl);
        return jVar;
    }

    public static boolean ws(n nVar) {
        kt av = av(nVar);
        if (av == null || av.oq != 2) {
            return false;
        }
        return true;
    }

    public static boolean xt(n nVar) {
        if (j(nVar)) {
            return ae(nVar);
        }
        return false;
    }

    public static boolean j(n nVar) {
        kt av = av(nVar);
        return (av == null || tl(nVar) == 0 || TextUtils.isEmpty(av.f30313j)) ? false : true;
    }
}
