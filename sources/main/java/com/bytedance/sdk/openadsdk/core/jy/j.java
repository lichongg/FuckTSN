package com.bytedance.sdk.openadsdk.core.jy;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.component.utils.ws;
import com.bytedance.sdk.openadsdk.core.oq;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j implements com.bytedance.sdk.component.tl.xt.r.j.xt {
    private static final AtomicLong cw = new AtomicLong(0);
    private String ae;

    /* renamed from: g, reason: collision with root package name */
    private String f29245g;

    /* renamed from: j, reason: collision with root package name */
    public final String f29246j;
    private long jy;

    /* renamed from: m, reason: collision with root package name */
    private String f29247m;
    private com.bytedance.sdk.openadsdk.m.j.j oq;
    private String qv;

    /* renamed from: r, reason: collision with root package name */
    private JSONObject f29248r;
    private String tl;
    private String up;
    private long vl;
    private AtomicBoolean ws = new AtomicBoolean(false);
    protected final JSONObject xt;

    /* renamed from: com.bytedance.sdk.openadsdk.core.jy.j$j, reason: collision with other inner class name */
    public static final class C0460j {
        private String ae;
        private String cw;

        /* renamed from: g, reason: collision with root package name */
        private com.bytedance.sdk.openadsdk.m.j.xt f29249g;

        /* renamed from: j, reason: collision with root package name */
        private String f29250j;

        /* renamed from: m, reason: collision with root package name */
        private String f29251m;
        private com.bytedance.sdk.openadsdk.m.j.j oq;

        /* renamed from: r, reason: collision with root package name */
        private String f29252r;
        private JSONObject tl;
        private String up;
        private String xt;

        public C0460j cw(String str) {
            this.f29252r = str;
            return this;
        }

        public C0460j m(String str) {
            this.ae = str;
            return this;
        }

        public C0460j r(String str) {
            this.up = str;
            return this;
        }

        public C0460j up(String str) {
            this.f29251m = str;
            return this;
        }

        public C0460j xt(String str) {
            this.cw = str;
            return this;
        }

        public C0460j j(String str) {
            this.xt = str;
            return this;
        }

        public C0460j j(JSONObject jSONObject) {
            if (jSONObject == null) {
                return this;
            }
            this.tl = jSONObject;
            return this;
        }

        public void j(com.bytedance.sdk.openadsdk.m.j.j jVar) {
            if (com.bytedance.sdk.openadsdk.core.kt.up.j(this.cw, 1.0d)) {
                this.oq = jVar;
                j jVar2 = new j(this);
                try {
                    com.bytedance.sdk.openadsdk.m.j.xt xtVar = this.f29249g;
                    if (xtVar != null) {
                        xtVar.j(jVar2.xt);
                    } else {
                        new com.bytedance.sdk.openadsdk.m.j.cw().j(jVar2.xt);
                    }
                } catch (Throwable th) {
                    vl.xt("AdEvent", th);
                }
                com.bytedance.sdk.openadsdk.core.kt.xt.j(jVar2, this.cw);
            }
        }
    }

    @Override // com.bytedance.sdk.component.tl.xt.r.j.xt
    public long j() {
        return this.jy;
    }

    private void ae() {
        this.vl = cw.incrementAndGet();
    }

    private void tl() throws JSONException {
        this.xt.putOpt(CommonNetImpl.TAG, this.up);
        this.xt.putOpt("label", this.f29247m);
        this.xt.putOpt("category", this.ae);
        if (!TextUtils.isEmpty(this.tl)) {
            try {
                this.xt.putOpt("value", Long.valueOf(Long.parseLong(this.tl)));
            } catch (NumberFormatException unused) {
                this.xt.putOpt("value", 0L);
            }
        }
        if (!TextUtils.isEmpty(this.f29245g)) {
            this.xt.putOpt("ext_value", this.f29245g);
        }
        if (!TextUtils.isEmpty(this.qv)) {
            this.xt.putOpt(MediationConstant.EXTRA_LOG_EXTRA, this.qv);
        }
        if (!TextUtils.equals(this.f29247m, "pangle_live_sdk_monitor")) {
            this.xt.putOpt("is_ad_event", "1");
        }
        this.xt.putOpt("nt", Integer.valueOf(ws.cw(v.getContext())));
        this.xt.putOpt("tob_ab_sdk_version", oq.i().hh());
        Iterator<String> keys = this.f29248r.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            this.xt.putOpt(next, this.f29248r.opt(next));
        }
    }

    public String cw() {
        if (!TextUtils.isEmpty(this.f29247m)) {
            return this.f29247m;
        }
        JSONObject jSONObject = this.xt;
        return jSONObject != null ? jSONObject.optString("label") : "";
    }

    @Override // com.bytedance.sdk.component.tl.xt.r.j.xt
    public JSONObject j(String str) {
        JSONObject jSONObject;
        JSONObject up = up();
        try {
            String optString = up.optString("ad_extra_data");
            if (TextUtils.isEmpty(optString)) {
                jSONObject = new JSONObject();
                if (v.xt().tj() && !TextUtils.isEmpty(str)) {
                    jSONObject.put("will_save_labels", str);
                }
            } else {
                JSONObject jSONObject2 = new JSONObject(optString);
                if (v.xt().tj() && TextUtils.isEmpty(jSONObject2.optString("will_save_labels")) && !TextUtils.isEmpty(str)) {
                    jSONObject2.put("will_save_labels", str);
                }
                jSONObject = jSONObject2;
            }
            String ae = com.bytedance.sdk.openadsdk.core.live.xt.j().ae();
            if (ae != null) {
                jSONObject.putOpt("live_plugin_version", ae.replaceAll("\\.", ""));
            }
            if (oq.i().ae()) {
                jSONObject.putOpt("first_of_two", 1);
            }
            up.put("ad_extra_data", jSONObject.toString());
            return up;
        } catch (Exception e6) {
            vl.j(e6);
            return up;
        }
    }

    public boolean m() {
        JSONObject jSONObject = this.xt;
        if (jSONObject == null) {
            return false;
        }
        String optString = jSONObject.optString("label");
        if (!TextUtils.isEmpty(optString)) {
            return xt.f29319j.contains(optString);
        }
        if (TextUtils.isEmpty(this.f29247m)) {
            return false;
        }
        return xt.f29319j.contains(this.f29247m);
    }

    public String r() {
        return this.f29246j;
    }

    public JSONObject up() {
        if (this.ws.get()) {
            return this.xt;
        }
        try {
            tl();
            com.bytedance.sdk.openadsdk.m.j.j jVar = this.oq;
            if (jVar != null) {
                jVar.j(this.xt);
            }
            j(this.xt);
            this.ws.set(true);
        } catch (Throwable th) {
            vl.xt("AdEvent", th);
        }
        return this.xt;
    }

    @Override // com.bytedance.sdk.component.tl.xt.r.j.xt
    public long xt() {
        return this.vl;
    }

    j(C0460j c0460j) {
        String str;
        JSONObject jSONObject;
        this.f29248r = new JSONObject();
        if (!TextUtils.isEmpty(c0460j.f29250j)) {
            str = c0460j.f29250j;
        } else {
            str = UUID.randomUUID().toString();
        }
        this.f29246j = str;
        this.oq = c0460j.oq;
        this.qv = c0460j.up;
        this.up = c0460j.xt;
        this.f29247m = c0460j.cw;
        if (TextUtils.isEmpty(c0460j.f29252r)) {
            this.ae = "app_union";
        } else {
            this.ae = c0460j.f29252r;
        }
        this.tl = c0460j.f29251m;
        this.f29245g = c0460j.ae;
        if (c0460j.tl != null) {
            jSONObject = c0460j.tl;
        } else {
            jSONObject = new JSONObject();
        }
        this.f29248r = c0460j.tl = jSONObject;
        this.jy = System.currentTimeMillis();
        this.xt = new JSONObject();
        try {
            ae();
        } catch (Exception e6) {
            vl.j(e6);
        }
    }

    private void j(JSONObject jSONObject) {
        try {
            if (this.vl != 0) {
                String optString = jSONObject.optString("ad_extra_data");
                if (!TextUtils.isEmpty(optString)) {
                    JSONObject jSONObject2 = new JSONObject(optString);
                    if (jSONObject2.optInt("sdk_event_index") == 0) {
                        jSONObject2.put("sdk_event_index", this.vl);
                    }
                    if (jSONObject2.optInt("sdk_event_self_count") == 0) {
                        jSONObject2.put("sdk_event_self_count", com.bytedance.sdk.component.tl.xt.cw.j.j(this.f29247m));
                    }
                    jSONObject2.put("create_ts", System.currentTimeMillis());
                    jSONObject2.put("csj_type", oq.i().nd() ? 1 : 0);
                    jSONObject2.put("sdk_boost_type", com.bytedance.sdk.openadsdk.core.r.j.r());
                    jSONObject2.put("sdk_session_id", com.bytedance.sdk.openadsdk.core.kt.xt.f29419j);
                    if (!TextUtils.isEmpty(uf.f30156g)) {
                        jSONObject2.put("wrong_stats_url", uf.f30156g);
                    }
                    if (!TextUtils.isEmpty(uf.oq)) {
                        jSONObject2.put("wrong_applog_url", uf.oq);
                    }
                    com.bytedance.sdk.openadsdk.core.uf.j.j().j(jSONObject2);
                    jSONObject.put("ad_extra_data", jSONObject2.toString());
                    return;
                }
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("sdk_event_index", this.vl);
                jSONObject3.put("sdk_event_self_count", com.bytedance.sdk.component.tl.xt.cw.j.j(this.f29247m));
                jSONObject3.put("sdk_session_id", com.bytedance.sdk.openadsdk.core.kt.xt.f29419j);
                jSONObject3.put("csj_type", oq.i().nd() ? 1 : 0);
                jSONObject3.put("sdk_boost_type", com.bytedance.sdk.openadsdk.core.r.j.r());
                jSONObject3.put("create_ts", System.currentTimeMillis());
                if (!TextUtils.isEmpty(uf.f30156g)) {
                    jSONObject3.put("wrong_stats_url", uf.f30156g);
                }
                if (!TextUtils.isEmpty(uf.oq)) {
                    jSONObject3.put("wrong_applog_url", uf.oq);
                }
                com.bytedance.sdk.openadsdk.core.uf.j.j().j(jSONObject3);
                jSONObject.put("ad_extra_data", jSONObject3.toString());
            }
        } catch (Exception unused) {
        }
    }
}
