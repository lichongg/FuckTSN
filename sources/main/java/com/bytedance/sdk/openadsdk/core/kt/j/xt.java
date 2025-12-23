package com.bytedance.sdk.openadsdk.core.kt.j;

import android.os.Build;
import android.text.TextUtils;
import cn.jpush.android.api.JThirdPlatFormInterface;
import com.baidu.mobads.sdk.internal.bn;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.component.utils.ws;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.kt;
import com.bytedance.sdk.openadsdk.core.kt.j.xt;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.core.oq;
import com.bytedance.sdk.openadsdk.core.rn.f;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.v;
import com.umeng.analytics.pro.au;
import com.umeng.analytics.pro.bi;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt<T extends xt> implements j {
    private String az;
    private String cw;

    /* renamed from: j, reason: collision with root package name */
    private String f29340j;
    private String jy;
    private String oq;
    private String qv;
    private String tl;
    private String up;
    private String vl;
    private String ws;
    private String xt;

    /* renamed from: r, reason: collision with root package name */
    private String f29342r = h.cw;

    /* renamed from: m, reason: collision with root package name */
    private long f29341m = System.currentTimeMillis() / 1000;
    private int ae = 0;

    /* renamed from: g, reason: collision with root package name */
    private int f29339g = 0;

    public static xt<xt> xt() {
        return new xt<>();
    }

    public String ae() {
        return this.ws;
    }

    public String cw() {
        return this.jy;
    }

    public long g() {
        return this.f29341m;
    }

    @Override // com.bytedance.sdk.openadsdk.core.kt.j.j
    public JSONObject j() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(getType())) {
                jSONObject.put("type", getType());
            }
            if (!TextUtils.isEmpty(r())) {
                jSONObject.put("rit", r());
            }
            if (!TextUtils.isEmpty(up())) {
                jSONObject.put("creative_id", up());
            }
            if (!TextUtils.isEmpty(m())) {
                jSONObject.put("ad_sdk_version", m());
            }
            if (TextUtils.isEmpty(tl())) {
                jSONObject.put("app_version", uf.qv());
            } else {
                jSONObject.put("app_version", tl());
            }
            if (g() > 0) {
                jSONObject.put("timestamp", g());
            }
            if (oq() > 0) {
                jSONObject.put("adtype", oq());
            }
            if (!TextUtils.isEmpty(qv())) {
                jSONObject.put("req_id", qv());
            }
            jSONObject.put("error_code", vl());
            if (!TextUtils.isEmpty(jy())) {
                jSONObject.put("error_msg", jy());
            }
            if (!TextUtils.isEmpty(ws())) {
                jSONObject.put(JThirdPlatFormInterface.KEY_EXTRA, ws());
            }
            if (!TextUtils.isEmpty(az())) {
                jSONObject.put("image_url", az());
            }
            if (!TextUtils.isEmpty(cw())) {
                jSONObject.put("event_extra", cw());
            }
            if (!TextUtils.isEmpty(ae())) {
                jSONObject.put("duration", ae());
            }
            if (!TextUtils.isEmpty(oq.i().f())) {
                jSONObject.put("appid", oq.i().f());
            }
            if (!TextUtils.isEmpty(av())) {
                jSONObject.put("ad_info", av());
            }
            jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, "7.0.1.2");
            jSONObject.put("is_plugin", h.j());
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            jSONObject.put("conn_type", ws.xt(v.getContext()));
        } catch (Exception e6) {
            vl.j(e6);
        }
        try {
            jSONObject.put("device_info", i());
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    public String m() {
        return this.f29342r;
    }

    public String r() {
        return this.xt;
    }

    public String tl() {
        return this.up;
    }

    public String up() {
        return this.cw;
    }

    private JSONObject i() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("os", 1);
            com.bytedance.sdk.openadsdk.av.xt.xt(jSONObject);
            jSONObject.put("oaid", f.j(false));
            jSONObject.put(bn.f10753i, kt.v());
            jSONObject.put(SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID, kt.m());
            jSONObject.put("vendor", Build.MANUFACTURER);
            jSONObject.put(bi.f40972o, uf.g());
            jSONObject.put(au.f40899d, uf.ae());
            jSONObject.put("applog_did", m.j().cw());
            jSONObject.put(IjkMediaPlayer.OnNativeInvokeListener.ARG_IP, com.bytedance.sdk.openadsdk.core.rn.oq.m());
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public T ae(String str) {
        this.oq = str;
        return w();
    }

    public String av() {
        return this.az;
    }

    public String az() {
        return this.vl;
    }

    public T cw(String str) {
        this.xt = str;
        return w();
    }

    public T g(String str) {
        this.az = str;
        return w();
    }

    public String getType() {
        return this.f29340j;
    }

    public String jy() {
        return this.oq;
    }

    public T m(String str) {
        this.tl = str;
        return w();
    }

    public int oq() {
        return this.ae;
    }

    public String qv() {
        return this.tl;
    }

    public T r(String str) {
        this.cw = str;
        return w();
    }

    public T tl(String str) {
        this.qv = str;
        return w();
    }

    public T up(String str) {
        this.ws = str;
        return w();
    }

    public int vl() {
        return this.f29339g;
    }

    public String ws() {
        return this.qv;
    }

    public T xt(String str) {
        this.jy = str;
        return w();
    }

    public T xt(int i6) {
        this.f29339g = i6;
        return w();
    }

    private T w() {
        return this;
    }

    public T j(String str) {
        this.f29340j = str;
        return w();
    }

    public T j(long j6) {
        this.f29341m = j6;
        return w();
    }

    public T j(int i6) {
        this.ae = i6;
        return w();
    }
}
