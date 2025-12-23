package com.bytedance.sdk.openadsdk.core.qv.r;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.rn.la;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.tj.tj;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.function.Function;
import org.json.JSONException;
import org.json.JSONObject;
import xyz.adscope.amps.common.AMPSConstants;

/* loaded from: D:\Downloads\app\classes4.dex */
public class g {

    public static class j extends com.bytedance.sdk.component.oq.g {
        private n cw;

        /* renamed from: j, reason: collision with root package name */
        private tl f29973j;

        /* renamed from: r, reason: collision with root package name */
        private boolean f29974r;
        private Function<SparseArray<Object>, Object> up;
        private com.bytedance.sdk.openadsdk.core.qv.cw.xt.j xt;

        public static j j(tl tlVar, boolean z5) {
            return new j(tlVar, z5);
        }

        private j(tl tlVar, boolean z5) {
            super("LogTask");
            JSONObject r5;
            JSONObject up;
            n nVar;
            this.f29973j = tlVar;
            this.f29974r = z5;
            this.up = com.bytedance.sdk.openadsdk.core.oq.i().gx();
            tl tlVar2 = this.f29973j;
            if (tlVar2 == null || tlVar2.r() == null || (r5 = this.f29973j.r()) == null) {
                return;
            }
            String optString = r5.optString("ad_extra_data");
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            try {
                JSONObject optJSONObject = new JSONObject(optString).optJSONObject(com.bytedance.sdk.openadsdk.core.qv.j.oq.EXTRA_DOWN_INFO_KEY);
                com.bytedance.sdk.openadsdk.core.qv.cw.xt.j j6 = com.bytedance.sdk.openadsdk.core.qv.cw.xt.j.j(optJSONObject);
                this.xt = j6;
                if (j6 == null) {
                    return;
                }
                j6.j(tlVar.xt());
                this.xt.xt(this.f29973j.cw());
                this.cw = this.xt.f29940j;
                if (h.xt >= 4400 && (up = tlVar.up()) != null && (nVar = this.cw) != null && !j(up, nVar.ot())) {
                    this.cw.tj(up.toString());
                    this.cw.kt(String.valueOf(up.optLong("creative_id")));
                    JSONObject tv2 = this.cw.tv();
                    optJSONObject.put("material_meta", tv2);
                    com.bytedance.sdk.openadsdk.core.qv.cw.xt.j j7 = com.bytedance.sdk.openadsdk.core.qv.cw.xt.j.j(optJSONObject);
                    if (j7 == null) {
                        return;
                    }
                    this.xt = j7;
                    j7.xt(tlVar.cw());
                    this.f29973j = tl.j().j(tlVar.xt()).xt(tlVar.cw()).j(tv2).xt(r5);
                    this.cw = this.xt.f29940j;
                }
            } catch (Exception unused) {
            }
        }

        private boolean j(JSONObject jSONObject, JSONObject jSONObject2) {
            if (jSONObject != null && jSONObject2 != null) {
                long optLong = jSONObject.optLong(MediationConstant.EXTRA_ADID);
                long optLong2 = jSONObject2.optLong(MediationConstant.EXTRA_ADID);
                String optString = jSONObject.optString("req_id");
                String optString2 = jSONObject2.optString("req_id");
                long optLong3 = jSONObject.optLong("creative_id");
                long optLong4 = jSONObject2.optLong("creative_id");
                String optString3 = jSONObject.optString("origin_req_id");
                String optString4 = jSONObject2.optString("origin_req_id");
                if (optLong != 0 && optLong == optLong2 && optLong3 != 0 && optLong3 == optLong4) {
                    return (TextUtils.isEmpty(optString3) || TextUtils.isEmpty(optString4)) ? TextUtils.equals(optString, optString2) : TextUtils.equals(optString3, optString4);
                }
            }
            return false;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object apply;
            try {
                tl tlVar = this.f29973j;
                if (tlVar == null) {
                    return;
                }
                String xt = tlVar.xt();
                com.bytedance.sdk.component.utils.vl.j("pl_LibEventLogger", "label: " + this.f29973j.cw() + " tag: " + xt);
                com.bytedance.sdk.openadsdk.core.qv.cw.xt.j jVar = this.xt;
                if (jVar != null && !TextUtils.isEmpty(jVar.xt)) {
                    xt = this.xt.xt;
                }
                if (this.up != null) {
                    apply = this.up.apply(com.bytedance.sdk.openadsdk.i.r.j().j(2).j(Boolean.class).j(0, new la().j("tagIntercept", xt).j("label", this.f29973j.cw()).j("meta", this.cw.tv().toString())).xt());
                    if (apply != null && ((Boolean) apply).booleanValue()) {
                        return;
                    }
                }
                if (this.xt != null && this.cw != null && !TextUtils.isEmpty(this.f29973j.xt()) && !TextUtils.isEmpty(this.f29973j.cw())) {
                    JSONObject j6 = g.j(this.f29973j.r());
                    String str = this.xt.xt;
                    if (j(this.f29973j.xt()) && !AMPSConstants.FrequencyEventType.FREQUENCY_EVENT_TYPE_CLICK.equals(this.f29973j.cw())) {
                        j6.remove(com.bytedance.sdk.openadsdk.core.qv.j.oq.EXTRA_DOWN_INFO_KEY);
                        j6.putOpt("obm_convert", tj.cw(this.cw));
                        com.bytedance.sdk.openadsdk.core.jy.cw.xt(this.cw, str, this.f29973j.cw(), j6);
                    }
                }
            } catch (Throwable unused) {
            }
        }

        private Context getContext() {
            return v.getContext();
        }

        private boolean j(String str) {
            return this.f29974r || g.cw(str);
        }
    }

    public static JSONObject j(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("ad_extra_data");
        if (TextUtils.isEmpty(optString)) {
            return null;
        }
        try {
            return new JSONObject(optString);
        } catch (JSONException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean cw(String str) {
        if (!TextUtils.isEmpty(str)) {
            if ("embeded_ad".equals(str) || "draw_ad".equals(str) || "draw_ad_landingpage".equals(str) || "banner_ad".equals(str) || "banner_call".equals(str) || "banner_ad_landingpage".equals(str) || "feed_call".equals(str) || "embeded_ad_landingpage".equals(str) || "interaction".equals(str) || "interaction_call".equals(str) || "interaction_landingpage".equals(str) || "slide_banner_ad".equals(str) || "splash_ad".equals(str) || "fullscreen_interstitial_ad".equals(str) || "splash_ad_landingpage".equals(str) || "rewarded_video".equals(str) || "rewarded_video_landingpage".equals(str) || "openad_sdk_download_complete_tag".equals(str) || "fullscreen_interstitial_ad_landingpage".equals(str) || "stream".equals(str)) {
                return true;
            }
            return false;
        }
        return false;
    }

    public static boolean j(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.contains(com.bytedance.sdk.openadsdk.core.qv.j.oq.EXTRA_DOWN_INFO_KEY);
    }
}
