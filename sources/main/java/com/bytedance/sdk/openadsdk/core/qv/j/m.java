package com.bytedance.sdk.openadsdk.core.qv.j;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.rn.la;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.tj.tj;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadEventModel;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.function.Function;
import org.json.JSONException;
import org.json.JSONObject;
import xyz.adscope.amps.common.AMPSConstants;

/* loaded from: D:\Downloads\app\classes4.dex */
public class m {
    private static final String TAG = "pl_LibEventLogger";

    public static class j extends com.bytedance.sdk.component.oq.g {
        private Function<SparseArray<Object>, Object> mBridge;
        private boolean mCheckTag;
        private com.bytedance.sdk.openadsdk.core.qv.cw.xt.j mEventExtra;
        private TTDownloadEventModel mEventModel;
        private n mMeta;

        private j(TTDownloadEventModel tTDownloadEventModel, boolean z5) {
            super("LogTask");
            JSONObject extJson;
            JSONObject materialMeta;
            n nVar;
            this.mEventModel = tTDownloadEventModel;
            this.mCheckTag = z5;
            this.mBridge = com.bytedance.sdk.openadsdk.core.oq.i().gx();
            TTDownloadEventModel tTDownloadEventModel2 = this.mEventModel;
            if (tTDownloadEventModel2 == null || tTDownloadEventModel2.getExtJson() == null || (extJson = this.mEventModel.getExtJson()) == null) {
                return;
            }
            String optString = extJson.optString("ad_extra_data");
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            try {
                JSONObject optJSONObject = new JSONObject(optString).optJSONObject(oq.EXTRA_DOWN_INFO_KEY);
                com.bytedance.sdk.openadsdk.core.qv.cw.xt.j j6 = com.bytedance.sdk.openadsdk.core.qv.cw.xt.j.j(optJSONObject);
                this.mEventExtra = j6;
                if (j6 == null) {
                    return;
                }
                j6.j(tTDownloadEventModel.getTag());
                this.mEventExtra.xt(this.mEventModel.getLabel());
                this.mMeta = this.mEventExtra.f29940j;
                if (h.xt >= 4400 && (materialMeta = tTDownloadEventModel.getMaterialMeta()) != null && (nVar = this.mMeta) != null && !equalExt(materialMeta, nVar.ot())) {
                    this.mMeta.tj(materialMeta.toString());
                    this.mMeta.kt(String.valueOf(materialMeta.optLong("creative_id")));
                    JSONObject tv2 = this.mMeta.tv();
                    optJSONObject.put("material_meta", tv2);
                    com.bytedance.sdk.openadsdk.core.qv.cw.xt.j j7 = com.bytedance.sdk.openadsdk.core.qv.cw.xt.j.j(optJSONObject);
                    if (j7 == null) {
                        return;
                    }
                    this.mEventExtra = j7;
                    j7.xt(tTDownloadEventModel.getLabel());
                    this.mEventModel = TTDownloadEventModel.builder().setTag(tTDownloadEventModel.getTag()).setLabel(tTDownloadEventModel.getLabel()).setMaterialMeta(tv2).setExtJson(extJson);
                    this.mMeta = this.mEventExtra.f29940j;
                }
            } catch (Exception unused) {
            }
        }

        public static j build(TTDownloadEventModel tTDownloadEventModel, boolean z5) {
            return new j(tTDownloadEventModel, z5);
        }

        private boolean checkTag(String str) {
            return this.mCheckTag || m.checkTag(str);
        }

        private boolean equalExt(JSONObject jSONObject, JSONObject jSONObject2) {
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
                TTDownloadEventModel tTDownloadEventModel = this.mEventModel;
                if (tTDownloadEventModel == null) {
                    return;
                }
                String tag = tTDownloadEventModel.getTag();
                vl.j(m.TAG, "label: " + this.mEventModel.getLabel() + " tag: " + tag);
                com.bytedance.sdk.openadsdk.core.qv.cw.xt.j jVar = this.mEventExtra;
                if (jVar != null && !TextUtils.isEmpty(jVar.xt)) {
                    tag = this.mEventExtra.xt;
                }
                if (this.mBridge != null) {
                    apply = this.mBridge.apply(com.bytedance.sdk.openadsdk.i.r.j().j(2).j(Boolean.class).j(0, new la().j("tagIntercept", tag).j("label", this.mEventModel.getLabel()).j("meta", this.mMeta.tv().toString())).xt());
                    if (apply != null && ((Boolean) apply).booleanValue()) {
                        return;
                    }
                }
                if (this.mEventExtra != null && this.mMeta != null && !TextUtils.isEmpty(this.mEventModel.getTag()) && !TextUtils.isEmpty(this.mEventModel.getLabel())) {
                    JSONObject libAdExtraData = m.getLibAdExtraData(this.mEventModel.getExtJson());
                    String str = this.mEventExtra.xt;
                    if (checkTag(this.mEventModel.getTag()) && !AMPSConstants.FrequencyEventType.FREQUENCY_EVENT_TYPE_CLICK.equals(this.mEventModel.getLabel())) {
                        libAdExtraData.remove(oq.EXTRA_DOWN_INFO_KEY);
                        libAdExtraData.putOpt("obm_convert", tj.cw(this.mMeta));
                        com.bytedance.sdk.openadsdk.core.jy.cw.xt(this.mMeta, str, this.mEventModel.getLabel(), libAdExtraData);
                    }
                }
            } catch (Throwable unused) {
            }
        }

        private Context getContext() {
            return v.getContext();
        }
    }

    public static JSONObject getLibAdExtraData(JSONObject jSONObject) {
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
            vl.j(e6);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean checkTag(String str) {
        if (!TextUtils.isEmpty(str)) {
            if ("embeded_ad".equals(str) || "draw_ad".equals(str) || "draw_ad_landingpage".equals(str) || "banner_ad".equals(str) || "banner_call".equals(str) || "banner_ad_landingpage".equals(str) || "feed_call".equals(str) || "embeded_ad_landingpage".equals(str) || "interaction".equals(str) || "interaction_call".equals(str) || "interaction_landingpage".equals(str) || "slide_banner_ad".equals(str) || "splash_ad".equals(str) || "fullscreen_interstitial_ad".equals(str) || "splash_ad_landingpage".equals(str) || "rewarded_video".equals(str) || "rewarded_video_landingpage".equals(str) || "openad_sdk_download_complete_tag".equals(str) || "fullscreen_interstitial_ad_landingpage".equals(str) || "stream".equals(str)) {
                return true;
            }
            return false;
        }
        return false;
    }

    public static boolean isOpenSdkEvent(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.contains(oq.EXTRA_DOWN_INFO_KEY);
    }
}
