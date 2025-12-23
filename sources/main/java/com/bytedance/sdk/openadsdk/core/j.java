package com.bytedance.sdk.openadsdk.core;

import android.text.TextUtils;
import android.util.Pair;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.core.tj.ff;
import com.bytedance.sdk.openadsdk.core.tj.hl;
import com.bytedance.sdk.openadsdk.core.tj.ln;
import com.bytedance.sdk.openadsdk.core.tj.nd;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import com.umeng.analytics.pro.bi;
import com.umeng.socialize.common.SocializeConstants;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {
    public static Pair<com.bytedance.sdk.openadsdk.core.tj.j, ArrayList<Integer>> j(JSONObject jSONObject, com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, nd ndVar, long j6) {
        if (jSONObject == null) {
            return null;
        }
        try {
            com.bytedance.sdk.openadsdk.core.tj.j jVar = new com.bytedance.sdk.openadsdk.core.tj.j();
            jVar.j(jSONObject.optString("request_id"));
            jVar.j(jSONObject.optInt("ret"));
            jVar.xt(jSONObject.optString(CrashHianalyticsData.MESSAGE));
            String optString = jSONObject.optString("auction_price");
            com.bytedance.sdk.openadsdk.core.rn.oq.xt(jSONObject.optString("client_ipv4", ""));
            boolean optBoolean = jSONObject.optBoolean("need_get_materials");
            if (jVar.j() != 0) {
                return null;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("creatives");
            ArrayList arrayList = new ArrayList();
            if (optJSONArray != null) {
                for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                    com.bytedance.sdk.openadsdk.core.tj.n j7 = j(optJSONArray.optJSONObject(i6), xtVar, ndVar);
                    int j8 = j(j7, xtVar != null ? xtVar.kt() : 0);
                    boolean gq = j7.gq();
                    String wq = j7.wq();
                    if (j8 != 200 && ((!optBoolean && !gq) || TextUtils.isEmpty(wq))) {
                        arrayList.add(Integer.valueOf(j8));
                    }
                    j7.l(optString);
                    j7.cw(j6);
                    j7.m(optBoolean);
                    jVar.j(j7);
                }
            }
            return new Pair<>(jVar, arrayList);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.vl.j(th);
            return null;
        }
    }

    public static com.bytedance.sdk.openadsdk.core.tj.up xt(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.bytedance.sdk.openadsdk.core.tj.up upVar = new com.bytedance.sdk.openadsdk.core.tj.up();
        upVar.cw(jSONObject.optString("app_name"));
        upVar.r(jSONObject.optString(bi.f40972o));
        upVar.xt(jSONObject.optString("download_url"));
        upVar.j(jSONObject.optInt("score", 4));
        upVar.xt(jSONObject.optInt("comment_num", 0));
        upVar.cw(jSONObject.optInt("app_size", 0));
        upVar.j(jSONObject.optString("quick_app_url", ""));
        return upVar;
    }

    private static Map<String, Object> ae(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (!TextUtils.isEmpty(next)) {
                hashMap.put(next, jSONObject.opt(next));
            }
        }
        return hashMap;
    }

    public static com.bytedance.sdk.openadsdk.core.tj.ch cw(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.bytedance.sdk.openadsdk.core.tj.ch chVar = new com.bytedance.sdk.openadsdk.core.tj.ch();
        chVar.cw(jSONObject.optString("ugen_dialog_md5"));
        chVar.xt(jSONObject.optString("ugen_dialog_url"));
        chVar.j(jSONObject.optString("dialog_style"));
        return chVar;
    }

    private static com.bytedance.sdk.openadsdk.core.tj.f m(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.bytedance.sdk.openadsdk.core.tj.f fVar = new com.bytedance.sdk.openadsdk.core.tj.f();
        fVar.j(jSONObject.optInt("ah", 1));
        fVar.xt(jSONObject.optInt(CommonNetImpl.AM, 1));
        return fVar;
    }

    public static com.bytedance.sdk.openadsdk.core.tj.s r(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.bytedance.sdk.openadsdk.core.tj.s sVar = new com.bytedance.sdk.openadsdk.core.tj.s();
        sVar.r(jSONObject.optString("bg_url"));
        sVar.cw(jSONObject.optString("title"));
        sVar.j(jSONObject.optString("reward_image_url"));
        sVar.xt(jSONObject.optString("reward_title"));
        sVar.up(jSONObject.optString(MediaFormat.KEY_SUBTITLE));
        return sVar;
    }

    public static com.bytedance.sdk.openadsdk.core.tj.m up(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.bytedance.sdk.openadsdk.core.tj.m mVar = new com.bytedance.sdk.openadsdk.core.tj.m();
        mVar.r(jSONObject.optString("developer_name"));
        mVar.xt(jSONObject.optString("app_version"));
        JSONArray optJSONArray = jSONObject.optJSONArray("permissions");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            mVar.xt(optJSONArray);
            for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i6);
                if (optJSONObject != null) {
                    mVar.j(optJSONObject.optString("permission_name"), optJSONObject.optString("permission_desc"));
                }
            }
        }
        mVar.j(jSONObject.optString("permissions_url"));
        mVar.j(jSONObject.optInt("score", 0));
        mVar.j(jSONObject.optJSONArray("creative_tags"));
        mVar.up(jSONObject.optString("privacy_policy_url"));
        mVar.m(jSONObject.optString("desc_url"));
        mVar.ae(jSONObject.optString("reg_number"));
        mVar.tl(jSONObject.optString("reg_url"));
        mVar.oq(jSONObject.optString("app_name"));
        mVar.g(jSONObject.optString(bi.f40972o));
        return mVar;
    }

    private static int xt(com.bytedance.sdk.openadsdk.core.tj.n nVar, int i6) {
        if (i6 != 3 && i6 != 4 && i6 != 0) {
            if (!com.bytedance.sdk.openadsdk.core.tj.ed.j(nVar)) {
                return TTAdConstant.LIVE_AD_CODE;
            }
            if (TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.tj.ed.ae(nVar))) {
                return TTAdConstant.LIVE_FEED_URL_CODE;
            }
        }
        return 200;
    }

    public static com.bytedance.sdk.openadsdk.core.tj.n j(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            return j(jSONObject, null, null);
        } catch (OutOfMemoryError unused) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x05de  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0631  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0665  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x06d8  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x07ab  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x082f  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0852  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x08a3  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x08b1  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x052e  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x056e  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0599  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.bytedance.sdk.openadsdk.core.tj.n j(org.json.JSONObject r17, com.bytedance.sdk.openadsdk.i.cw.cw.xt r18, com.bytedance.sdk.openadsdk.core.tj.nd r19) {
        /*
            Method dump skipped, instructions count: 2375
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.j.j(org.json.JSONObject, com.bytedance.sdk.openadsdk.i.cw.cw.xt, com.bytedance.sdk.openadsdk.core.tj.nd):com.bytedance.sdk.openadsdk.core.tj.n");
    }

    private static com.bytedance.sdk.openadsdk.core.ugeno.m.j j(JSONObject jSONObject, com.bytedance.sdk.openadsdk.core.tj.n nVar) {
        com.bytedance.sdk.openadsdk.core.ugeno.m.j jVar = new com.bytedance.sdk.openadsdk.core.ugeno.m.j();
        jVar.j(jSONObject.optString("id"));
        jVar.xt(jSONObject.optString(TKDownloadReason.KSAD_TK_MD5));
        jVar.cw(jSONObject.optString("url"));
        jVar.j(jSONObject.optInt("scene"));
        return jVar;
    }

    private static void j(com.bytedance.sdk.openadsdk.core.tj.n nVar, JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.core.tj.i m111if;
        if (nVar == null || jSONObject == null) {
            return;
        }
        if ((com.bytedance.sdk.openadsdk.core.tj.ed.j(nVar) || hl.j(nVar)) && (m111if = nVar.m111if()) != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("reward_live_deep_link_params");
            com.bytedance.sdk.openadsdk.core.tj.uf ufVar = new com.bytedance.sdk.openadsdk.core.tj.uf();
            if (optJSONObject != null) {
                ufVar.j(optJSONObject.optString("reward_live_deep_link_user_id"));
                ufVar.up(optJSONObject.optString("reward_live_deep_link_request_id"));
                ufVar.xt(optJSONObject.optString("reward_live_deep_link_room_id"));
                ufVar.cw(optJSONObject.optString("reawrd_live_short_touch_params"));
                ufVar.r(optJSONObject.optString("reawrd_live_extra_pangle_scheme_params"));
                ufVar.j(optJSONObject.optLong("reward_live_last_time"));
                nVar.j(ufVar);
            } else {
                Map<String, String> j6 = com.bytedance.sdk.openadsdk.core.rn.c.j(m111if.xt());
                if (j6 == null || j6.size() <= 0) {
                    return;
                }
                ufVar.j(j6.get(SocializeConstants.TENCENT_UID));
                ufVar.up(j6.get("request_id"));
                ufVar.xt(j6.get("room_id"));
                ufVar.cw(j6.get("live_short_touch_params"));
                ufVar.r(j6.get("extra_pangle_scheme_params"));
                nVar.j(ufVar);
            }
            nVar.oq(jSONObject.optBoolean("not_valid_download_url", false));
        }
    }

    private static ff j(JSONObject jSONObject, int i6) {
        if (jSONObject == null) {
            return null;
        }
        ff ffVar = new ff();
        double optDouble = jSONObject.optDouble("splash_clickarea", 1.0d);
        ffVar.j((int) ((optDouble == 1.0d || optDouble == 2.0d) ? optDouble : 1.0d));
        ffVar.ae(jSONObject.optInt("splash_style_id", 0));
        ffVar.j(jSONObject.optString("splash_clicktext", ""));
        ffVar.xt(jSONObject.optInt("area_height", 50));
        ffVar.cw(jSONObject.optInt("area_width", org.apache.commons.net.telnet.f.f51105u));
        if (i6 == 2) {
            ffVar.r(jSONObject.optInt("area_blank_height", 32));
        } else {
            ffVar.r(jSONObject.optInt("area_blank_height", 82));
        }
        ffVar.up(jSONObject.optInt("half_blank_height", 56));
        ffVar.xt(jSONObject.optString("btn_background_dest_color", "#008DEA"));
        ffVar.cw(jSONObject.optString("top_splash_clicktext"));
        ffVar.j(jSONObject.optJSONObject("text_config"));
        ffVar.xt(jSONObject.optJSONObject("top_text_config"));
        ffVar.tl(jSONObject.optInt("sliding_distance", 5));
        ffVar.j(jSONObject.optJSONObject("slide_area"), i6);
        ffVar.m(jSONObject.optInt("splash_load_time_optimization"));
        return ffVar;
    }

    public static int j(com.bytedance.sdk.openadsdk.core.tj.n nVar, int i6) {
        if (TextUtils.isEmpty(nVar.fs()) || nVar.fs().length() <= 1) {
            return 401;
        }
        int j6 = j(nVar.m111if());
        if (j6 != 200) {
            return j6;
        }
        int j7 = j(nVar);
        if (j7 != 200) {
            return j7;
        }
        int jl = nVar.jl();
        if (jl == 2 || jl == 3) {
            if (TextUtils.isEmpty(nVar.yb())) {
                return 405;
            }
        } else if (jl != 4) {
            if (jl == 5 && TextUtils.isEmpty(nVar.ym())) {
                return TTAdConstant.INTERACTION_TYPE_CODE;
            }
        } else {
            j7 = j(nVar.by());
            if (j7 != 200) {
                return j7;
            }
        }
        int ve = nVar.ve();
        if (ve != 2 && ve != 3 && ve != 4) {
            if (ve == 5 || ve == 15) {
                return ln.g(nVar);
            }
            if (ve != 16) {
                return ve != 166 ? j7 : xt(nVar, i6);
            }
        }
        return j(nVar.fp());
    }

    private static int j(com.bytedance.sdk.openadsdk.core.tj.n nVar) {
        if (nVar.ve() != 166 || !com.bytedance.sdk.openadsdk.core.tj.ed.j(nVar) || h.r()) {
            return 200;
        }
        com.bytedance.sdk.component.utils.vl.cw("穿山甲sdk没有集成点播/直播aar，不支持直播物料");
        return 404;
    }

    private static int j(com.bytedance.sdk.openadsdk.core.tj.i iVar) {
        if (iVar == null) {
            return 200;
        }
        if (!TextUtils.isEmpty(iVar.xt()) && !TextUtils.isEmpty(iVar.r())) {
            return (iVar.up() == 1 || iVar.up() == 2) ? 200 : 403;
        }
        if (TextUtils.isEmpty(iVar.xt())) {
            return 402;
        }
        return TTAdConstant.DEEPLINK_FALL_BACK_CODE;
    }

    private static int j(com.bytedance.sdk.openadsdk.core.tj.up upVar) {
        if (upVar == null) {
            return 406;
        }
        return TextUtils.isEmpty(upVar.xt()) ? 407 : 200;
    }

    private static int j(List<com.bytedance.sdk.openadsdk.core.tj.h> list) {
        if (list == null) {
            return TTAdConstant.IMAGE_LIST_CODE;
        }
        if (list.size() <= 0) {
            return TTAdConstant.IMAGE_LIST_SIZE_CODE;
        }
        for (com.bytedance.sdk.openadsdk.core.tj.h hVar : list) {
            if (hVar == null) {
                return 411;
            }
            if (TextUtils.isEmpty(hVar.j())) {
                return 412;
            }
        }
        return 200;
    }
}
