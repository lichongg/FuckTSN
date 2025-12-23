package com.bytedance.sdk.openadsdk.core.tj;

import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class ed {
    private String ae;
    private int cw;

    /* renamed from: g, reason: collision with root package name */
    private int f30259g;

    /* renamed from: j, reason: collision with root package name */
    private int f30260j;
    private boolean jy;

    /* renamed from: m, reason: collision with root package name */
    private String f30261m;
    private int oq;
    private int qv;

    /* renamed from: r, reason: collision with root package name */
    private int f30262r;
    private String tl;
    private String up;
    private int vl;
    private String xt;

    public boolean j() {
        return this.jy;
    }

    private static ed ws(n nVar) {
        if (nVar == null) {
            return null;
        }
        return nVar.xg();
    }

    public void j(JSONObject jSONObject) {
        if (this.jy) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("live_show_time", this.f30260j);
                jSONObject2.put("live_author_nickname", this.xt);
                jSONObject2.put("live_author_follower_count", this.cw);
                jSONObject2.put("live_watch_count", this.f30262r);
                jSONObject2.put("live_description", this.up);
                jSONObject2.put("live_feed_url", this.f30261m);
                jSONObject2.put("live_cover_image_url", this.ae);
                jSONObject2.put("live_avatar_url", this.tl);
                jSONObject2.put("live_cover_width", this.qv);
                jSONObject2.put("live_cover_height", this.vl);
                jSONObject2.put("live_avatar_width", this.f30259g);
                jSONObject2.put("live_avatar_height", this.oq);
                jSONObject.put("live_ad", jSONObject2);
            } catch (Exception unused) {
            }
        }
    }

    public ed(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("live_ad")) != null) {
            this.jy = true;
            j(optJSONObject.optInt("live_show_time", 60));
            this.xt = optJSONObject.optString("live_author_nickname");
            this.cw = optJSONObject.optInt("live_author_follower_count", -1);
            this.f30262r = optJSONObject.optInt("live_watch_count", -1);
            this.up = optJSONObject.optString("live_description");
            this.f30261m = optJSONObject.optString("live_feed_url");
            this.ae = optJSONObject.optString("live_cover_image_url");
            this.tl = optJSONObject.optString("live_avatar_url");
            this.f30259g = optJSONObject.optInt("live_avatar_width");
            this.oq = optJSONObject.optInt("live_avatar_height");
            this.qv = optJSONObject.optInt("live_cover_width");
            this.vl = optJSONObject.optInt("live_cover_height");
        }
    }

    public static String ae(n nVar) {
        ed ws = ws(nVar);
        if (ws == null) {
            return "";
        }
        return ws.f30261m;
    }

    public static String cw(n nVar) {
        ed ws = ws(nVar);
        if (ws == null) {
            return "";
        }
        return ws.xt;
    }

    public static String g(n nVar) {
        ed ws = ws(nVar);
        if (ws == null) {
            return "";
        }
        return ws.tl;
    }

    public static int jy(n nVar) {
        ed ws = ws(nVar);
        if (ws == null) {
            return 0;
        }
        return ws.vl;
    }

    public static String m(n nVar) {
        ed ws = ws(nVar);
        if (ws == null) {
            return "";
        }
        return ws.up;
    }

    public static int oq(n nVar) {
        ed ws = ws(nVar);
        if (ws == null) {
            return 0;
        }
        return ws.f30259g;
    }

    public static int qv(n nVar) {
        ed ws = ws(nVar);
        if (ws == null) {
            return 0;
        }
        return ws.oq;
    }

    public static int r(n nVar) {
        ed ws = ws(nVar);
        if (ws == null) {
            return 0;
        }
        return ws.cw;
    }

    public static String tl(n nVar) {
        ed ws = ws(nVar);
        if (ws == null) {
            return "";
        }
        return ws.ae;
    }

    public static int up(n nVar) {
        ed ws = ws(nVar);
        if (ws == null) {
            return 0;
        }
        return ws.f30262r;
    }

    public static int vl(n nVar) {
        ed ws = ws(nVar);
        if (ws == null) {
            return 0;
        }
        return ws.qv;
    }

    public static int xt(n nVar) {
        ed ws = ws(nVar);
        if (ws == null) {
            return 0;
        }
        return ws.f30260j;
    }

    public static boolean j(n nVar) {
        ed ws = ws(nVar);
        if (ws == null) {
            return false;
        }
        return ws.jy;
    }

    public void j(int i6) {
        if (i6 <= 0 || i6 > 300) {
            i6 = 60;
        }
        this.f30260j = i6;
    }
}
