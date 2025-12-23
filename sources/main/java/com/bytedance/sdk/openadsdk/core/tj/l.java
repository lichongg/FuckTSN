package com.bytedance.sdk.openadsdk.core.tj;

import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class l {
    private int cw;

    /* renamed from: j, reason: collision with root package name */
    private int f30316j;

    /* renamed from: r, reason: collision with root package name */
    private boolean f30317r;
    private long xt;

    public static l j(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        l lVar = new l();
        lVar.f30316j = jSONObject.optInt("refresh_control", 0);
        lVar.xt = jSONObject.optLong("refresh_imp_max_time", 0L);
        lVar.cw = jSONObject.optInt("refresh_num", 0);
        lVar.f30317r = jSONObject.optBoolean("is_force_show_skip", false);
        return lVar;
    }

    public void xt(JSONObject jSONObject) {
        try {
            jSONObject.put("refresh_control", this.f30316j);
            jSONObject.put("refresh_imp_max_time", this.xt);
            jSONObject.put("refresh_num", this.cw);
            jSONObject.put("is_force_show_skip", this.f30317r);
        } catch (JSONException unused) {
        }
    }

    public int cw() {
        return this.cw;
    }

    public boolean r() {
        return this.f30317r;
    }

    public long xt() {
        return this.xt;
    }

    public static boolean j(n nVar) {
        l ng;
        return (nVar == null || (ng = nVar.ng()) == null || ng.j() != 1) ? false : true;
    }

    public static boolean xt(n nVar) {
        return com.bytedance.sdk.openadsdk.core.v.xt().av(String.valueOf(com.bytedance.sdk.openadsdk.core.rn.uf.g(nVar))) && j(nVar) && !com.bytedance.sdk.openadsdk.core.ws.r.j(String.valueOf(com.bytedance.sdk.openadsdk.core.rn.uf.g(nVar)));
    }

    public int j() {
        return this.f30316j;
    }

    public void j(boolean z5) {
        this.f30317r = z5;
    }

    public static boolean j(List<n> list) {
        Iterator<n> it = list.iterator();
        boolean z5 = false;
        boolean z6 = false;
        while (it.hasNext()) {
            if (it.next().uo() == 100.0f) {
                z5 = true;
            } else {
                z6 = true;
            }
        }
        return (z5 && z6) ? false : true;
    }
}
