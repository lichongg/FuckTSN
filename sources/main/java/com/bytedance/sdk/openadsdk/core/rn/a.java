package com.bytedance.sdk.openadsdk.core.rn;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.i.cw.cw.xt;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class a {
    public static com.bytedance.sdk.openadsdk.i.cw.cw.xt j(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            xt.j jVar = new xt.j();
            jVar.j(jSONObject.optString("mAdId", ""));
            jVar.xt(jSONObject.optString("mCreativeId", ""));
            jVar.cw(jSONObject.optString("mExt", ""));
            jVar.r(jSONObject.optString("mCodeId", ""));
            jVar.g(jSONObject.optString("mUserData"));
            jVar.j(jSONObject.optBoolean("mIsAutoPlay", true));
            int optInt = jSONObject.optInt("mImgAcceptedWidth", 640);
            jVar.xt(jSONObject.optInt("mImgAcceptedHeight", 320));
            jVar.j(optInt);
            double optDouble = jSONObject.optDouble("mExpressViewAcceptedWidth", 0.0d);
            double optDouble2 = jSONObject.optDouble("mExpressViewAcceptedHeight", 0.0d);
            jVar.xt(Double.valueOf(optDouble).floatValue());
            jVar.j(Double.valueOf(optDouble2).floatValue());
            jVar.xt(jSONObject.optBoolean("mSupportDeepLink", true));
            jVar.cw(jSONObject.optInt("mAdCount", 1));
            jVar.up(jSONObject.optString("mMediaExtra", ""));
            jVar.m(jSONObject.optString("mUserID", ""));
            jVar.r(jSONObject.optInt("mOrientation", 2));
            jVar.up(jSONObject.optInt("mNativeAdType"));
            jVar.j(uf.qv(jSONObject.optString("mExternalABVid", "")));
            jVar.m(jSONObject.optInt("mAdLoadSeq", 0));
            jVar.ae(jSONObject.optString("mPrimeRit", ""));
            jVar.tl(jSONObject.optString("mBidAdm"));
            jVar.tl(jSONObject.optInt("mRewardAmount", 0));
            jVar.oq(jSONObject.optString("mRewardName", ""));
            return jVar.j();
        } catch (Exception unused) {
            return null;
        }
    }

    public static final xt.j xt(com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar) {
        return new xt.j(xtVar);
    }

    public static JSONObject j(com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mAdId", xtVar.j());
            jSONObject.put("mCreativeId", xtVar.xt());
            jSONObject.put("mExt", xtVar.cw());
            jSONObject.put("mCodeId", str);
            jSONObject.put("mUserData", xtVar.f());
            jSONObject.put("mIsAutoPlay", xtVar.up());
            jSONObject.put("mImgAcceptedWidth", xtVar.m());
            jSONObject.put("mImgAcceptedHeight", xtVar.ae());
            jSONObject.put("mExpressViewAcceptedWidth", xtVar.tl());
            jSONObject.put("mExpressViewAcceptedHeight", xtVar.g());
            jSONObject.put("mSupportDeepLink", xtVar.oq());
            jSONObject.put("mSupportRenderControl", xtVar.qv());
            if (com.bytedance.sdk.openadsdk.core.h.xt >= 5900) {
                jSONObject.put("mSupportIconStyle", xtVar.s());
            }
            jSONObject.put("mAdCount", xtVar.vl());
            jSONObject.put("mMediaExtra", xtVar.jy());
            jSONObject.put("mUserID", xtVar.ws());
            jSONObject.put("mOrientation", xtVar.az());
            jSONObject.put("mNativeAdType", xtVar.av());
            jSONObject.put("mExternalABVid", uf.j(xtVar.i()));
            jSONObject.put("mAdLoadSeq", xtVar.w());
            jSONObject.put("mPrimeRit", xtVar.mi());
            jSONObject.put("mBidAdm", xtVar.tj());
            jSONObject.put("mRewardAmount", xtVar.ch());
            jSONObject.put("mRewardName", xtVar.x());
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public static JSONObject j(com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar) {
        return j(xtVar, xtVar.r());
    }

    public static com.bytedance.sdk.openadsdk.i.cw.cw.xt j(int i6, String str, float f6, float f7) {
        return j().r(str).ae(i6).xt(f7).j(f6).j();
    }

    public static com.bytedance.sdk.openadsdk.i.cw.cw.xt j(int i6) {
        return j().ae(i6).j();
    }

    public static com.bytedance.sdk.openadsdk.i.cw.cw.xt j(int i6, PluginValueSet pluginValueSet) {
        com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar = new com.bytedance.sdk.openadsdk.i.cw.cw.xt(pluginValueSet != null ? pluginValueSet.sparseArray() : new SparseArray<>());
        xt.j jVar = new xt.j(xtVar);
        float tl = xtVar.tl();
        float g6 = xtVar.g();
        if (tl <= 0.0f) {
            tl = ed.r(com.bytedance.sdk.openadsdk.core.v.getContext(), xtVar.m());
            g6 = ed.r(com.bytedance.sdk.openadsdk.core.v.getContext(), xtVar.ae());
        }
        if (tl > 0.0f || g6 > 0.0f) {
            int r5 = (int) (ed.r(com.bytedance.sdk.openadsdk.core.v.getContext(), ed.up(com.bytedance.sdk.openadsdk.core.v.getContext())) * 1.3d);
            int r6 = (int) (ed.r(com.bytedance.sdk.openadsdk.core.v.getContext(), ed.r(com.bytedance.sdk.openadsdk.core.v.getContext())) * 1.3d);
            int max = Math.max(r5, r6);
            int min = Math.min(r5, r6);
            if (tl > g6) {
                if (r6 > 0) {
                    float f6 = max;
                    if (tl > f6) {
                        g6 = min;
                        tl = f6;
                    }
                }
            } else if (r5 > 0) {
                float f7 = max;
                if (g6 > f7) {
                    tl = min;
                    g6 = f7;
                }
            }
        }
        jVar.j(tl).xt(g6);
        return new com.bytedance.sdk.openadsdk.core.tj.cw(xt(jVar.j()).ae(i6).j());
    }

    private static final xt.j j() {
        return new xt.j().cw(1).xt(320).j(640).xt(true).m("defaultUser").r(2).j(true);
    }

    public static boolean j(JSONObject jSONObject, String str, boolean z5) {
        if (jSONObject.has(str)) {
            return jSONObject.optBoolean(str, z5);
        }
        return ((Boolean) com.bytedance.sdk.openadsdk.core.v.xt().j(str, (String) Boolean.valueOf(z5))).booleanValue();
    }

    public static long j(JSONObject jSONObject, String str, long j6) {
        if (jSONObject.has(str)) {
            return jSONObject.optLong(str, j6);
        }
        return ((Long) com.bytedance.sdk.openadsdk.core.v.xt().j(str, (String) Long.valueOf(j6))).longValue();
    }

    public static int j(JSONObject jSONObject, String str, int i6) {
        if (jSONObject.has(str)) {
            return jSONObject.optInt(str, i6);
        }
        return ((Integer) com.bytedance.sdk.openadsdk.core.v.xt().j(str, (String) Integer.valueOf(i6))).intValue();
    }
}
