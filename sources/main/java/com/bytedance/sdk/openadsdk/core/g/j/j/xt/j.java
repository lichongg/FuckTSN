package com.bytedance.sdk.openadsdk.core.g.j.j.xt;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.ws;
import com.bytedance.sdk.component.utils.xt;
import com.bytedance.sdk.openadsdk.core.activity.base.TTNativePageActivity;
import com.bytedance.sdk.openadsdk.core.activity.base.TTVideoScrollWebPageActivity;
import com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity;
import com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.multipro.xt.j;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.ugeno.oq;
import com.bytedance.sdk.openadsdk.i.cw.xt.g;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.tencent.open.SocialConstants;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import xyz.adscope.amps.common.AMPSConstants;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j implements com.bytedance.sdk.openadsdk.core.g.j.j.j {
    private String ae;
    private n cw;

    /* renamed from: m, reason: collision with root package name */
    private boolean f29004m;
    private String oq;
    private com.bytedance.sdk.openadsdk.core.video.xt.xt qv;

    /* renamed from: r, reason: collision with root package name */
    private Object f29005r;
    private int tl;
    private Map<String, Object> up;
    private Context xt;

    /* renamed from: j, reason: collision with root package name */
    private boolean f29003j = false;

    /* renamed from: g, reason: collision with root package name */
    private boolean f29002g = false;

    public void cw(boolean z5) {
        this.f29002g = z5;
    }

    public void j(com.bytedance.sdk.openadsdk.core.video.xt.xt xtVar) {
        this.qv = xtVar;
    }

    public void xt(boolean z5) {
        this.f29004m = z5;
    }

    private com.bytedance.sdk.openadsdk.core.multipro.xt.j cw() {
        Object obj;
        if (!n.xt(this.cw) || (obj = this.f29005r) == null) {
            return null;
        }
        com.bytedance.sdk.openadsdk.core.multipro.xt.j la = obj instanceof j.InterfaceC0466j ? ((j.InterfaceC0466j) obj).la() : null;
        if (la != null) {
            this.up.put("multi_process_data", la.j().toString());
        }
        Object obj2 = this.f29005r;
        if (!(obj2 instanceof com.bytedance.sdk.openadsdk.core.nativeexpress.xt)) {
            return la;
        }
        com.bytedance.sdk.openadsdk.core.multipro.xt.j qv = ((com.bytedance.sdk.openadsdk.core.nativeexpress.xt) obj2).qv();
        if (qv != null) {
            this.up.put("multi_process_data", qv.j().toString());
        }
        return qv;
    }

    public void j(boolean z5) {
        this.f29003j = z5;
    }

    public void xt(Map<String, Object> map) {
        this.up = map;
    }

    public j(n nVar, Context context, String str, int i6) {
        this.cw = nVar;
        this.xt = context;
        this.ae = str;
        this.tl = i6;
    }

    private boolean xt(String str) {
        if (!ws.j(str)) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        try {
            intent.setData(Uri.parse(str));
            if (!(this.xt instanceof Activity)) {
                intent.addFlags(268435456);
            }
            com.bytedance.sdk.component.utils.xt.j(this.xt, intent, null);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public Class<?> j() {
        boolean z5 = this.f29003j;
        this.f29003j = false;
        if (this.f29005r instanceof g) {
            return oq.m(this.cw) ? TTNativePageActivity.class : TTWebPageActivity.class;
        }
        if (!n.xt(this.cw) || z5 || j(this.f29005r) || !uf.up(this.cw)) {
            return oq.m(this.cw) ? TTNativePageActivity.class : TTWebPageActivity.class;
        }
        if (oq.m(this.cw)) {
            return TTNativePageActivity.class;
        }
        n nVar = this.cw;
        return (nVar == null || !nVar.g()) ? xt(TTVideoWebPageActivity.class) : TTWebPageActivity.class;
    }

    private void xt() {
        if (this.f29002g && this.cw != null) {
            if (this.up == null) {
                this.up = new HashMap();
            }
            if (TextUtils.isEmpty(this.oq)) {
                this.oq = this.cw.yb();
            }
            this.up.put("url", this.oq);
            this.up.put("gecko_id", this.cw.el());
            this.up.put("web_title", this.cw.hw());
            this.up.put("sdk_version", Integer.valueOf(h.xt));
            this.up.put("adid", this.cw.fs());
            this.up.put(MediationConstant.EXTRA_LOG_EXTRA, this.cw.os());
            this.up.put("icon_url", this.cw.ig() == null ? null : this.cw.ig().j());
            this.up.put("event_tag", this.ae);
            this.up.put(SocialConstants.PARAM_SOURCE, Integer.valueOf(this.tl));
            this.up.put("is_outer_click", Boolean.TRUE);
            uf.j(this.up, this.cw);
        }
    }

    private static boolean j(Object obj) {
        if (obj == null || !(obj instanceof j.InterfaceC0466j)) {
            return false;
        }
        try {
            return ((j.InterfaceC0466j) obj).p();
        } catch (Throwable unused) {
            return false;
        }
    }

    public boolean j(Class cls) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(SocializeProtocolConstants.PROTOCOL_KEY_EXTEND, this.cw.os());
            jSONObject.putOpt("live_interaction_type", Integer.valueOf(this.cw.ww()));
            jSONObject.putOpt("req_id", this.cw.ej());
            Boolean bool = Boolean.TRUE;
            jSONObject.putOpt("uchain", bool);
            jSONObject.putOpt("uchain_old", bool);
            jSONObject.putOpt("interaction_type", Integer.valueOf(this.cw.jl()));
        } catch (JSONException unused) {
        }
        com.bytedance.sdk.openadsdk.core.kt.ws.j().j("landing_page", AMPSConstants.AdType.AD_TYPE_NATIVE, 0, jSONObject);
        if (this.cw.jl() == 2) {
            return xt(this.cw.yb());
        }
        com.bytedance.sdk.openadsdk.core.video.xt.xt xtVar = this.qv;
        if (xtVar != null && new xt(xtVar).j(new HashMap())) {
            return true;
        }
        Intent intent = new Intent(this.xt, (Class<?>) cls);
        if (!(this.xt instanceof Activity)) {
            intent.addFlags(268435456);
        }
        intent.putExtra("is_outer_click", true);
        intent.putExtra("has_phone_num_status", this.cw.cw());
        xt();
        if (this.up == null) {
            this.up = new HashMap();
        }
        for (Map.Entry<String, Object> entry : this.up.entrySet()) {
            Object value = entry.getValue();
            if (value != null) {
                intent.putExtra(entry.getKey(), value.toString());
            }
        }
        com.bytedance.sdk.component.utils.xt.j(this.xt, intent, new xt.j() { // from class: com.bytedance.sdk.openadsdk.core.g.j.j.xt.j.1
            @Override // com.bytedance.sdk.component.utils.xt.j
            public void j() {
            }

            @Override // com.bytedance.sdk.component.utils.xt.j
            public void j(Throwable th) {
            }
        });
        return true;
    }

    private Class xt(Class cls) {
        int i6;
        com.bytedance.sdk.openadsdk.core.multipro.xt.j cw = cw();
        if (cw != null) {
            this.up.put("video_is_auto_play", Boolean.valueOf(cw.f29583r));
        }
        if (TTVideoWebPageActivity.class.equals(cls) && (cw != null || this.f29004m)) {
            try {
                if (cw != null) {
                    i6 = (int) ((cw.ae / cw.up) * 100.0f);
                } else {
                    com.bytedance.sdk.openadsdk.core.multipro.xt.j jVar = new com.bytedance.sdk.openadsdk.core.multipro.xt.j();
                    jVar.ae = 100L;
                    jVar.f29581j = true;
                    jVar.f29583r = uf.tj(this.cw);
                    this.up.put("multi_process_data", jVar.j().toString());
                    i6 = 100;
                }
                if (this.cw.o() == 0) {
                    return TTVideoScrollWebPageActivity.class;
                }
                if (this.cw.o() > 0 && i6 > this.cw.o()) {
                    if (uf.tj(this.cw)) {
                        return TTVideoScrollWebPageActivity.class;
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return cls;
    }

    public void j(String str) {
        this.oq = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.g.j.j.j
    public boolean j(Map<String, Object> map) {
        if (this.cw == null) {
            return false;
        }
        return j((Class) j());
    }
}
