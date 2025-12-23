package com.bytedance.sdk.openadsdk.core.nativeexpress.xt;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import com.baidu.idl.face.platform.FaceEnvironment;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.core.rn;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.tj.e;
import com.bytedance.sdk.openadsdk.core.tj.ed;
import com.bytedance.sdk.openadsdk.core.tj.h;
import com.bytedance.sdk.openadsdk.core.tj.hh;
import com.bytedance.sdk.openadsdk.core.tj.hl;
import com.bytedance.sdk.openadsdk.core.tj.kt;
import com.bytedance.sdk.openadsdk.core.tj.ln;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.tj.rr;
import com.bytedance.sdk.openadsdk.core.tj.tj;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.tencent.connect.common.Constants;
import com.tencent.open.SocialConstants;
import com.umeng.analytics.pro.bi;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt {
    public static boolean cw(n nVar) {
        return nVar != null && tj.vl(nVar) == 2;
    }

    public static JSONObject j(float f6, float f7, boolean z5) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("width", f6);
            jSONObject.put("height", f7);
            if (z5) {
                jSONObject.put("isLandscape", true);
            }
            return jSONObject;
        } catch (Exception e6) {
            vl.j(e6);
            return null;
        }
    }

    public static Map<String, String> up(n nVar) {
        HashMap hashMap = null;
        if (nVar == null) {
            return null;
        }
        List<h> fp = nVar.fp();
        if (fp != null && fp.size() > 0) {
            hashMap = new HashMap();
            for (h hVar : fp) {
                if (hVar != null) {
                    hashMap.put(hVar.j(), hVar.ae());
                }
            }
        }
        return hashMap;
    }

    private static JSONObject ae(n nVar) {
        JSONObject jSONObject = new JSONObject();
        if (nVar != null && com.bytedance.sdk.openadsdk.core.video.cw.j.j(nVar)) {
            try {
                jSONObject.put("live_show_time", ed.xt(nVar));
                jSONObject.put("live_author_nickname", ed.cw(nVar));
                if (ed.r(nVar) > 0) {
                    jSONObject.put("live_author_follower_count", ed.r(nVar));
                }
                if (ed.up(nVar) > 0) {
                    jSONObject.put("live_watch_count", ed.up(nVar));
                }
                jSONObject.put("live_description", ed.m(nVar));
                jSONObject.put("live_feed_url", ed.ae(nVar));
                jSONObject.put("live_cover_image_url", ed.tl(nVar));
                jSONObject.put("live_avatar_url", ed.g(nVar));
                jSONObject.put("live_cover_image_width", ed.vl(nVar));
                jSONObject.put("live_cover_image_height", ed.jy(nVar));
                jSONObject.put("live_avatar_width", ed.oq(nVar));
                jSONObject.put("live_avatar_height", ed.qv(nVar));
            } catch (Exception unused) {
            }
        }
        return jSONObject;
    }

    private static JSONObject m(n nVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            String fs = nVar.fs();
            if (!TextUtils.isEmpty(fs)) {
                jSONObject.put("cid", fs);
            }
            String os = nVar.os();
            if (!TextUtils.isEmpty(os)) {
                jSONObject.put(MediationConstant.EXTRA_LOG_EXTRA, os);
            }
            String av = uf.av(nVar);
            if (!TextUtils.isEmpty(av)) {
                jSONObject.put("download_url", av);
            }
            if (kt.qv(nVar)) {
                jSONObject.put("voice_btn_position", kt.az(nVar));
            }
            return jSONObject;
        } catch (JSONException e6) {
            vl.j(e6);
            return jSONObject;
        }
    }

    public static JSONObject xt(n nVar) {
        int[] up;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("button_text", nVar.sf());
            if (nVar.ig() != null) {
                jSONObject.put("icon", nVar.ig().j());
            }
            JSONArray jSONArray = new JSONArray();
            if (nVar.fp() != null) {
                for (int i6 = 0; i6 < nVar.fp().size(); i6++) {
                    h hVar = nVar.fp().get(i6);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("height", hVar.cw());
                    jSONObject2.put("width", hVar.xt());
                    jSONObject2.put("url", hVar.j());
                    jSONObject2.put("image_key", hVar.ae());
                    jSONArray.put(jSONObject2);
                }
            }
            jSONObject.put(SocializeProtocolConstants.IMAGE, jSONArray);
            jSONObject.put("image_mode", nVar.ve());
            jSONObject.put("interaction_type", nVar.jl());
            jSONObject.put("is_compliance_template", cw(nVar));
            jSONObject.put("title", nVar.hw());
            jSONObject.put(SocialConstants.PARAM_COMMENT, nVar.zk());
            jSONObject.put(SocialConstants.PARAM_SOURCE, nVar.rs());
            if (nVar.by() != null) {
                jSONObject.put("comment_num", nVar.by().m());
                jSONObject.put("score", nVar.by().up());
                jSONObject.put("app_size", nVar.by().ae());
                jSONObject.put(Constants.JumpUrlConstants.SRC_TYPE_APP, nVar.by().tl());
            }
            if (ln.ws(nVar) != null) {
                JSONObject mi = ln.jy(nVar).mi();
                if (nVar.to() == 2 && ln.m(nVar) > 60.0d) {
                    mi.put("video_duration", 60);
                }
                if (com.bytedance.sdk.openadsdk.up.j.j(nVar) && (up = ln.up(nVar)) != null && up.length >= 2 && !com.bytedance.sdk.openadsdk.up.j.ae(nVar)) {
                    mi.put("cover_width", up[0]);
                    mi.put("cover_height", up[1]);
                }
                jSONObject.put("video", mi);
            }
            if (e.i(nVar)) {
                jSONObject.put("reward_full_play_time", e.az(nVar));
                jSONObject.put("reward_full_time_type", 1);
            }
            jSONObject.put("reward_need_click", e.s(nVar));
            if (hh.m(nVar) != null) {
                jSONObject.put("dynamic_creative", hh.m(nVar).ae());
            }
            jSONObject.put("live_ad", ae(nVar));
            j(nVar, jSONObject);
            if (com.bytedance.sdk.openadsdk.core.live.xt.j().xt(nVar)) {
                jSONObject.put("live_interaction_type", 2);
            } else {
                jSONObject.put("live_interaction_type", 1);
            }
            jSONObject.put("adx_name", nVar.ek());
            jSONObject.put("can_show_interactive", nVar.fw());
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String r(n nVar) {
        if (hh.m(nVar) == null) {
            return null;
        }
        return hh.m(nVar).xt();
    }

    public static JSONObject j(View view) {
        JSONObject jSONObject = new JSONObject();
        if (view == null) {
            return null;
        }
        try {
            int width = view.getWidth();
            int height = view.getHeight();
            Context context = v.getContext();
            jSONObject.put("width", com.bytedance.sdk.openadsdk.core.rn.ed.r(context, width) * 1.0f);
            jSONObject.put("height", com.bytedance.sdk.openadsdk.core.rn.ed.r(context, height) * 1.0f);
            return jSONObject;
        } catch (Exception e6) {
            vl.j(e6);
            return null;
        }
    }

    public static JSONObject j(n nVar) {
        rr ae = hh.ae(nVar);
        if (ae == null) {
            return null;
        }
        String r5 = ae.r();
        try {
            if (!TextUtils.isEmpty(r5)) {
                return new JSONObject(r5);
            }
            String j6 = com.bytedance.sdk.openadsdk.core.nativeexpress.j.xt.j().j(bi.az, ae.j(), ae.xt());
            if (!TextUtils.isEmpty(j6)) {
                return new JSONObject(j6);
            }
            vl.r("TemplateUtils", "template is null");
            return null;
        } catch (Exception e6) {
            vl.j(e6);
            return null;
        }
    }

    public static JSONObject j(n nVar, JSONObject jSONObject, JSONObject jSONObject2, boolean z5) {
        JSONObject tv2 = nVar.tv();
        try {
            tv2.put("xSetting", rn.j(nVar, (AtomicBoolean) null));
            tv2.put("xAdInfo", m(nVar));
            JSONObject jSONObject3 = new JSONObject();
            rn.cw(jSONObject3);
            jSONObject3.put("platform", FaceEnvironment.OS);
            tv2.put("xAppInfo", jSONObject3);
            tv2.put("xCreative", xt(nVar));
            if (jSONObject2 != null) {
                tv2.put("xTemplate", jSONObject2);
            }
            if (jSONObject != null) {
                tv2.put("xSize", jSONObject);
            }
            JSONObject jSONObject4 = new JSONObject();
            JSONObject jSONObject5 = new JSONObject();
            Context context = v.getContext();
            jSONObject5.put("width", com.bytedance.sdk.openadsdk.core.rn.ed.r(context, com.bytedance.sdk.openadsdk.core.rn.ed.r(context)));
            jSONObject5.put("height", com.bytedance.sdk.openadsdk.core.rn.ed.r(context, com.bytedance.sdk.openadsdk.core.rn.ed.up(context)));
            jSONObject4.put("screen_size", jSONObject5);
            jSONObject4.put("content_size", jSONObject);
            jSONObject4.put("platform", FaceEnvironment.OS);
            tv2.put("xEnvInfo", jSONObject4);
            tv2.put("gesture_through_enable", z5 && v.xt().xw());
            return tv2;
        } catch (Exception e6) {
            vl.j(e6);
            return tv2;
        }
    }

    public static JSONObject j(float f6, float f7, boolean z5, n nVar) {
        String str;
        String str2;
        com.bytedance.sdk.component.adexpress.j.cw.xt j6;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("platform", FaceEnvironment.OS);
            JSONObject jSONObject2 = new JSONObject();
            if (v.xt().gs()) {
                float f8 = v.getContext().getResources().getDisplayMetrics().density;
                float f9 = Resources.getSystem().getDisplayMetrics().density;
                jSONObject2.put("width", com.bytedance.sdk.openadsdk.core.rn.ed.xt(f9, com.bytedance.sdk.openadsdk.core.rn.ed.j(f8, f6)));
                jSONObject2.put("height", com.bytedance.sdk.openadsdk.core.rn.ed.xt(f9, com.bytedance.sdk.openadsdk.core.rn.ed.j(f8, f7)));
            } else {
                jSONObject2.put("width", f6);
                jSONObject2.put("height", f7);
            }
            if (z5) {
                jSONObject2.put("isLandscape", true);
            }
            jSONObject.put("AdSize", jSONObject2);
            jSONObject.put("creative", xt(nVar));
            if (hh.m(nVar) != null) {
                str = hh.m(nVar).up();
                str2 = hh.m(nVar).m();
            } else {
                str = null;
                str2 = null;
            }
            if (TextUtils.isEmpty(str)) {
                str = (hh.m(nVar) == null || (j6 = com.bytedance.sdk.component.adexpress.j.xt.xt.j(hh.m(nVar).xt())) == null) ? null : j6.up();
            }
            jSONObject.put("template_Plugin", str);
            jSONObject.put("diff_template_Plugin", str2);
            jSONObject.put("dynamic_configs", nVar.sz());
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    public static JSONObject j(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject2 == null) {
            return jSONObject;
        }
        JSONObject jSONObject3 = new JSONObject();
        if (jSONObject == null) {
            return jSONObject3;
        }
        try {
            JSONArray optJSONArray = jSONObject2.optJSONArray("keys");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                    String optString = optJSONArray.optString(i6);
                    if (jSONObject.has(optString)) {
                        jSONObject3.put(optString, jSONObject.opt(optString));
                    }
                }
                jSONObject3.put("xSetting", jSONObject.opt("xSetting"));
                jSONObject3.put("xAdInfo", jSONObject.opt("xAdInfo"));
                jSONObject3.put("xAppInfo", jSONObject.opt("xAppInfo"));
                jSONObject3.put("xSize", jSONObject.opt("xSize"));
                jSONObject3.put("xTemplate", jSONObject.opt("xTemplate"));
                return jSONObject3;
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private static void j(n nVar, JSONObject jSONObject) {
        if (uf.tl(nVar) == 7 && hl.j(nVar)) {
            nVar.zd().j(jSONObject);
        }
    }

    public static String j(n nVar, String str) {
        List<h> fp;
        if (nVar != null && (fp = nVar.fp()) != null && fp.size() > 0) {
            for (h hVar : fp) {
                if (hVar != null && TextUtils.equals(str, hVar.j())) {
                    return hVar.ae();
                }
            }
        }
        return null;
    }
}
