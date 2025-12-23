package com.bytedance.sdk.openadsdk.core.ugeno.express;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.adsdk.ugeno.cw.kt;
import com.bytedance.adsdk.ugeno.cw.w;
import com.bytedance.adsdk.ugeno.cw.ws;
import com.bytedance.adsdk.ugeno.up.m;
import com.bytedance.adsdk.ugeno.up.xt.j;
import com.bytedance.sdk.component.adexpress.xt.ae;
import com.bytedance.sdk.component.adexpress.xt.tl;
import com.bytedance.sdk.openadsdk.core.nativeexpress.qv;
import com.bytedance.sdk.openadsdk.core.rn.gq;
import com.bytedance.sdk.openadsdk.core.tj.hh;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.tj.rr;
import com.bytedance.sdk.openadsdk.core.tj.x;
import com.umeng.analytics.pro.bi;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class m extends r implements j {

    /* renamed from: f, reason: collision with root package name */
    private com.bytedance.adsdk.ugeno.xt.cw f30696f;
    private com.bytedance.adsdk.ugeno.xt.cw kt;
    private com.bytedance.adsdk.ugeno.xt.cw mi;
    private com.bytedance.adsdk.ugeno.xt.cw tj;

    /* renamed from: v, reason: collision with root package name */
    private com.bytedance.adsdk.ugeno.xt.cw f30697v;

    /* renamed from: x, reason: collision with root package name */
    private qv f30698x;

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.express.r, com.bytedance.sdk.component.adexpress.dynamic.r
    public void j(CharSequence charSequence, int i6, int i7, boolean z5) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.express.r
    protected void xt(ae aeVar) {
        ws();
        this.f30704j.j((w) this);
        this.f30704j.j((kt) this);
        rr ae = hh.ae(this.f30705m);
        try {
            if (ae != null) {
                this.cw = this.f30704j.j(this.f30706r, this.up, ae.up());
            } else {
                this.cw = this.f30704j.j(this.f30706r, this.up, (JSONObject) null);
            }
            if (this.f30704j.j()) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("component_not_exist", new JSONArray((Collection) this.f30704j.xt()));
                this.ae.rn().j(jSONObject);
                aeVar.j(MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_END_TIME, "ugen unknown component");
                return;
            }
            com.bytedance.adsdk.ugeno.xt.cw<View> cwVar = this.cw;
            if (cwVar != null) {
                com.bytedance.adsdk.ugeno.xt.cw<View> up = cwVar.up("RVCountdown");
                this.mi = up;
                if (up == null) {
                    this.mi = this.cw.up("FVCountdown");
                }
                com.bytedance.adsdk.ugeno.xt.cw<View> up2 = this.cw.up("RVSkip");
                this.tj = up2;
                if (up2 == null) {
                    this.tj = this.cw.up("FVSkip");
                }
                this.kt = this.cw.up("CycleCountDownView");
                this.f30696f = this.cw.up("RewardClickCountdown");
                this.f30697v = this.cw.up("CycleSkip");
                if (this.f30707w == null) {
                    this.f30707w = new com.bytedance.sdk.openadsdk.core.ugeno.oq.j(this.ae.up());
                }
                this.f30707w.j(this.f30704j, this.cw);
                this.f30707w.j(this.mi, this.tj, this.kt, this.f30696f, this.f30697v);
            }
            this.ae.rn().xt();
            this.ae.rn().cw();
        } catch (NoClassDefFoundError unused) {
            if (aeVar != null) {
                aeVar.j(140, "ugen no class def found error");
            }
        } catch (UnsatisfiedLinkError unused2) {
            if (aeVar != null) {
                aeVar.j(MediaPlayer.MEDIA_PLAYER_OPTION_RENDER_DEVICE, "ugen yoga so load fail");
            }
        } catch (Throwable unused3) {
            if (aeVar != null) {
                aeVar.j(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_CODEC_ID, "ugen other fail");
            }
        }
    }

    private void ws() {
        ws wsVar = new ws();
        HashMap hashMap = new HashMap();
        hashMap.put("shake_value", Integer.valueOf(this.ae.w()));
        hashMap.put("calculation_method", Integer.valueOf(this.ae.x()));
        hashMap.put("rotation_angle", Integer.valueOf(this.ae.kt()));
        hashMap.put("calculation_method_twist", Integer.valueOf(this.ae.ch()));
        hashMap.put("twist_config", this.ae.tj());
        hashMap.put("image_info", this.ae.ws());
        hashMap.put("cache_dir", this.ae.i());
        hashMap.put("shake_interact_conf", this.ae.f());
        hashMap.put("twist_interact_conf", this.ae.v());
        wsVar.j(hashMap);
        wsVar.j(this.xt);
        wsVar.j(this.f30706r);
        wsVar.xt(this.up);
        this.f30704j.j(bi.az, wsVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.express.r
    protected JSONObject oq() {
        return this.ae.up();
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.express.r
    protected com.bytedance.adsdk.ugeno.xt.cw up() {
        com.bytedance.adsdk.ugeno.xt.cw<View> cwVar = this.cw;
        if (cwVar == null) {
            return null;
        }
        return cwVar.up("VideoV3");
    }

    public m(Context context, n nVar, xt xtVar, ViewGroup viewGroup) {
        super(context, nVar, xtVar, viewGroup);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.express.r
    protected JSONObject j() {
        return this.ae.up().optJSONObject("xTemplate");
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.express.r, com.bytedance.adsdk.ugeno.cw.w
    public void j(final com.bytedance.adsdk.ugeno.xt.cw cwVar, final String str, final m.j jVar) {
        if (jVar == null) {
            return;
        }
        if (!TextUtils.equals(str, "shake") && !TextUtils.equals(str, "twist")) {
            xt(cwVar, str, jVar);
            return;
        }
        WeakReference<ViewGroup> weakReference = this.jy;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        gq.j(this.jy, new com.bytedance.sdk.openadsdk.core.xt.cw() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.express.m.1
            @Override // com.bytedance.sdk.openadsdk.core.xt.cw
            public void j() {
                WeakReference<ViewGroup> weakReference2 = m.this.jy;
                if (weakReference2 == null || weakReference2.get() == null || !gq.j(m.this.jy.get())) {
                    return;
                }
                m.this.xt(cwVar, str, jVar);
            }
        });
    }

    public void j(String str, Map<String, String> map) {
        if (this.cw == null) {
            return;
        }
        m.j jVar = new m.j();
        jVar.j("custom");
        jVar.xt("emit");
        HashMap hashMap = new HashMap();
        if (map != null) {
            hashMap.putAll(map);
        }
        hashMap.put(CommonNetImpl.NAME, str);
        jVar.j(hashMap);
        j.C0324j.j(this.cw, "jsb", jVar).j();
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.express.j
    public void j(qv qvVar) {
        this.f30698x = qvVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xt(com.bytedance.adsdk.ugeno.xt.cw cwVar, String str, m.j jVar) {
        int i6;
        CharSequence text;
        Object orDefault;
        Object orDefault2;
        String xt = jVar.xt();
        if (com.bytedance.sdk.openadsdk.core.ugeno.express.j.j.f30695j.contains(xt)) {
            com.bytedance.sdk.openadsdk.core.ugeno.express.j.j.j(this.f30698x, this.f30705m, xt, jVar);
            return;
        }
        xt.getClass();
        i6 = 3;
        switch (xt) {
            case "openAppPermission":
                i6 = 10;
                break;
            case "openCommonUrl":
                i6 = 13;
                break;
            case "openPrivacy":
                i6 = 7;
                break;
            case "resumeVideo":
                qv qvVar = this.f30698x;
                if (qvVar != null) {
                    qvVar.j(3);
                    return;
                }
                return;
            case "pauseVideo":
                qv qvVar2 = this.f30698x;
                if (qvVar2 != null) {
                    qvVar2.j(2);
                    return;
                }
                return;
            case "skip":
                i6 = 6;
                break;
            case "close":
                i6 = 8;
                break;
            case "openAppFunction":
                i6 = 12;
                break;
            case "videoControl":
                i6 = 4;
                break;
            case "convert":
                i6 = 2;
                break;
            case "muteVideo":
                i6 = 5;
                break;
            case "openAppPolicy":
                i6 = 9;
                break;
            case "dislike":
                break;
            default:
                i6 = 0;
                break;
        }
        x.j j6 = new x.j().r(this.vl.ws()).cw(this.vl.az()).xt(this.vl.av()).j(this.vl.i()).j(cwVar.la()).xt(this.vl.vl()).j(this.vl.jy());
        JSONObject jSONObject = new JSONObject();
        if (TextUtils.equals(str, "shake") || TextUtils.equals(str, "twist")) {
            try {
                jSONObject.put("convertActionType", 1);
            } catch (Throwable unused) {
            }
        }
        try {
            orDefault = jVar.cw().getOrDefault("webUrl", "");
            String j7 = com.bytedance.adsdk.ugeno.r.xt.j((String) orDefault, oq());
            orDefault2 = jVar.cw().getOrDefault("webTitle", "");
            String j8 = com.bytedance.adsdk.ugeno.r.xt.j((String) orDefault2, oq());
            jSONObject.put("openCommonWebUrl", j7);
            jSONObject.put("openCommonWebTitle", j8);
        } catch (JSONException unused2) {
        }
        View g6 = cwVar.g();
        try {
            if ((g6 instanceof TextView) && (text = ((TextView) g6).getText()) != null && text.toString().contains("下载")) {
                jSONObject.put("is_compliant_download", true);
            }
        } catch (JSONException unused3) {
        }
        j6.j(jSONObject);
        x j9 = j6.j();
        tl tlVar = this.f30702g;
        if (tlVar != null) {
            tlVar.j(g6, i6, j9);
        }
    }
}
