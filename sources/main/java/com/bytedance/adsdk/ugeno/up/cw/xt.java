package com.bytedance.adsdk.ugeno.up.cw;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.up.m;
import com.bytedance.adsdk.ugeno.up.oq;
import com.bytedance.adsdk.ugeno.up.qv;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class xt {
    protected String ae;
    protected com.bytedance.adsdk.ugeno.up.m cw;

    /* renamed from: g, reason: collision with root package name */
    protected String f23742g;

    /* renamed from: j, reason: collision with root package name */
    protected qv f23743j;

    /* renamed from: m, reason: collision with root package name */
    protected String f23744m;
    protected Context oq;

    /* renamed from: r, reason: collision with root package name */
    protected m.j f23745r;
    protected String tl;
    protected Map<String, String> up;
    protected com.bytedance.adsdk.ugeno.xt.cw xt;

    public static class j {
        public static xt j(Context context, com.bytedance.adsdk.ugeno.xt.cw cwVar, JSONObject jSONObject, JSONObject jSONObject2) {
            com.bytedance.adsdk.ugeno.up.m j6;
            m.j j7;
            if (cwVar == null || jSONObject == null || (j6 = com.bytedance.adsdk.ugeno.up.m.j(jSONObject, jSONObject2)) == null || (j7 = j6.j()) == null) {
                return null;
            }
            String j8 = j7.j();
            if (TextUtils.equals(j8, "custom")) {
                cw cwVar2 = new cw(context);
                cwVar2.j(cwVar);
                cwVar2.j(j6);
                cwVar2.m();
                return cwVar2;
            }
            com.bytedance.adsdk.ugeno.up.ae j9 = (TextUtils.isEmpty(j8) || TextUtils.equals(j8, "global")) ? oq.j(j7.xt()) : oq.j(j7.up());
            if (j9 == null) {
                return null;
            }
            xt j10 = j9.j(context);
            j10.j(cwVar);
            j10.j(j6);
            j10.m();
            return j10;
        }
    }

    public void j(com.bytedance.adsdk.ugeno.xt.cw cwVar) {
        this.xt = cwVar;
    }

    public abstract boolean j(Object... objArr);

    public String ae() {
        return this.f23744m;
    }

    public void j(com.bytedance.adsdk.ugeno.up.m mVar) {
        this.cw = mVar;
    }

    public void m() {
        this.f23745r = this.cw.j();
        com.bytedance.adsdk.ugeno.up.m mVar = this.cw;
        if (mVar == null) {
            return;
        }
        m.j j6 = mVar.j();
        this.f23745r = j6;
        if (j6 == null) {
            return;
        }
        this.up = j6.cw();
        this.f23744m = this.f23745r.xt();
        this.ae = this.f23745r.j();
        this.tl = this.f23745r.r();
        this.f23742g = this.f23745r.up();
    }

    public String tl() {
        return this.tl;
    }

    public xt(Context context) {
        this.oq = context;
    }

    public void j(qv qvVar) {
        this.f23743j = qvVar;
    }
}
