package com.bytedance.sdk.component.adexpress.dynamic.r;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.bytedance.sdk.component.adexpress.dynamic.r.up;
import com.bytedance.sdk.component.adexpress.xt.jy;
import com.bytedance.sdk.component.utils.vl;
import com.tencent.open.SocialConstants;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class m {
    private static HashMap<String, String> ae;
    private com.bytedance.sdk.component.adexpress.dynamic.cw.cw cw;

    /* renamed from: j, reason: collision with root package name */
    private JSONObject f25790j;

    /* renamed from: m, reason: collision with root package name */
    private com.bytedance.sdk.component.adexpress.dynamic.cw.r f25791m;

    /* renamed from: r, reason: collision with root package name */
    private j f25792r;
    private cw up;
    private JSONObject xt;

    static class j {
        boolean cw;

        /* renamed from: j, reason: collision with root package name */
        float f25793j;
        float xt;

        public static j j(JSONObject jSONObject) {
            j jVar = new j();
            if (jSONObject != null) {
                jVar.f25793j = (float) jSONObject.optDouble("width");
                jVar.xt = (float) jSONObject.optDouble("height");
                jVar.cw = jSONObject.optBoolean("isLandscape");
            }
            return jVar;
        }
    }

    public com.bytedance.sdk.component.adexpress.dynamic.cw.tl j(double d6, int i6, double d7, String str, jy jyVar) {
        JSONObject jSONObject;
        this.cw.j();
        try {
            jSONObject = new JSONObject(this.f25791m.xt);
        } catch (JSONException e6) {
            vl.j(e6);
            jSONObject = null;
        }
        com.bytedance.sdk.component.adexpress.dynamic.cw.tl j6 = j(r.j(this.f25790j, jSONObject), (com.bytedance.sdk.component.adexpress.dynamic.cw.tl) null);
        j(j6);
        up upVar = new up(d6, i6, d7, str, jyVar);
        up.j jVar = new up.j();
        j jVar2 = this.f25792r;
        jVar.f25797j = jVar2.f25793j;
        jVar.xt = jVar2.xt;
        jVar.cw = 0.0f;
        upVar.j(jVar);
        upVar.j(j6, 0.0f, 0.0f);
        upVar.j();
        com.bytedance.sdk.component.adexpress.dynamic.cw.xt xtVar = upVar.f25795j;
        if (xtVar.f25643r == 65536.0f) {
            return null;
        }
        return xtVar.f25642m;
    }

    static {
        HashMap<String, String> hashMap = new HashMap<>();
        ae = hashMap;
        hashMap.put(MediaFormat.KEY_SUBTITLE, SocialConstants.PARAM_COMMENT);
        ae.put(SocialConstants.PARAM_SOURCE, "source|app.app_name");
        ae.put("screenshot", "dynamic_creative.screenshot");
    }

    private void xt(com.bytedance.sdk.component.adexpress.dynamic.cw.tl tlVar) {
        com.bytedance.sdk.component.adexpress.dynamic.cw.cw cwVar;
        Object j6;
        Object j7;
        Object j8;
        Object j9;
        if (tlVar == null || (cwVar = this.cw) == null || (j6 = cwVar.j("image.0.url")) == null) {
            return;
        }
        String valueOf = String.valueOf(j6);
        if (TextUtils.isEmpty(valueOf) || (j7 = this.cw.j("title")) == null) {
            return;
        }
        String valueOf2 = String.valueOf(j7);
        if (TextUtils.isEmpty(valueOf2) || (j8 = this.cw.j(SocialConstants.PARAM_COMMENT)) == null) {
            return;
        }
        String valueOf3 = String.valueOf(j8);
        if (TextUtils.isEmpty(valueOf3) || (j9 = this.cw.j("icon")) == null) {
            return;
        }
        String valueOf4 = String.valueOf(j9);
        if (TextUtils.isEmpty(valueOf4)) {
            return;
        }
        Object j10 = this.cw.j("app.app_name");
        Object j11 = this.cw.j(SocialConstants.PARAM_SOURCE);
        if (j10 == null && j11 == null) {
            return;
        }
        if (j10 == null) {
            j10 = j11;
        }
        String valueOf5 = String.valueOf(j10);
        if (TextUtils.isEmpty(valueOf5)) {
            return;
        }
        tlVar.j("imageUrl", valueOf);
        tlVar.j("title", valueOf2);
        tlVar.j(SocialConstants.PARAM_COMMENT, valueOf3);
        tlVar.j("icon", valueOf4);
        tlVar.j("app_name", valueOf5);
        tlVar.j(true);
    }

    public m(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4) {
        this.f25790j = jSONObject;
        this.xt = jSONObject2;
        this.cw = new com.bytedance.sdk.component.adexpress.dynamic.cw.cw(jSONObject2);
        this.f25792r = j.j(jSONObject3);
        this.f25791m = com.bytedance.sdk.component.adexpress.dynamic.cw.r.j(jSONObject4);
    }

    private void j(com.bytedance.sdk.component.adexpress.dynamic.cw.tl tlVar) {
        int j6;
        if (tlVar == null) {
            return;
        }
        if (com.bytedance.sdk.component.adexpress.j.j.j.j().cw() != null) {
            j6 = com.bytedance.sdk.component.adexpress.j.j.j.j().cw().az();
        } else {
            j6 = com.bytedance.sdk.component.adexpress.r.tl.j(com.bytedance.sdk.component.adexpress.r.getContext());
        }
        int xt = com.bytedance.sdk.component.adexpress.r.tl.xt(com.bytedance.sdk.component.adexpress.r.getContext(), j6);
        j jVar = this.f25792r;
        float min = jVar.cw ? jVar.f25793j : Math.min(jVar.f25793j, xt);
        if (this.f25792r.xt == 0.0f) {
            tlVar.up(min);
            tlVar.oq().up().oq("auto");
            tlVar.m(0.0f);
        } else {
            tlVar.up(min);
            int xt2 = com.bytedance.sdk.component.adexpress.r.tl.xt(com.bytedance.sdk.component.adexpress.r.getContext(), com.bytedance.sdk.component.adexpress.r.tl.cw(com.bytedance.sdk.component.adexpress.r.getContext()));
            j jVar2 = this.f25792r;
            tlVar.m(jVar2.cw ? jVar2.xt : Math.min(jVar2.xt, xt2));
            tlVar.oq().up().oq("fixed");
        }
    }

    public com.bytedance.sdk.component.adexpress.dynamic.cw.tl j(JSONObject jSONObject, com.bytedance.sdk.component.adexpress.dynamic.cw.tl tlVar) {
        int length;
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("type");
        if (TextUtils.equals(optString, "custom-component-vessel")) {
            int optInt = jSONObject.optInt("componentId");
            if (this.f25791m != null) {
                cw cwVar = new cw();
                this.up = cwVar;
                JSONObject j6 = cwVar.j(this.f25791m.f25630j, optInt, jSONObject);
                if (j6 != null) {
                    jSONObject = j6;
                }
            }
        }
        com.bytedance.sdk.component.adexpress.dynamic.cw.tl j7 = j(jSONObject);
        j7.j(tlVar);
        JSONArray optJSONArray = jSONObject.optJSONArray("children");
        if (optJSONArray == null) {
            j7.j((List<com.bytedance.sdk.component.adexpress.dynamic.cw.tl>) null);
            return j7;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
            JSONArray optJSONArray2 = optJSONArray.optJSONArray(i6);
            if (optJSONArray2 != null) {
                ArrayList arrayList3 = new ArrayList();
                if (TextUtils.equals(optString, "tag-group")) {
                    length = j7.oq().up().st();
                } else {
                    length = optJSONArray2.length();
                }
                for (int i7 = 0; i7 < length; i7++) {
                    com.bytedance.sdk.component.adexpress.dynamic.cw.tl j8 = j(optJSONArray2.optJSONObject(i7), j7);
                    if (com.bytedance.sdk.component.adexpress.r.j() && "skip-with-time".equals(j7.oq().getType()) && !"transparent".equals(j7.v()) && !TextUtils.isEmpty(j7.v())) {
                        j8.cw(j7.v());
                    }
                    arrayList.add(j8);
                    arrayList3.add(j8);
                }
                arrayList2.add(arrayList3);
            }
        }
        if (arrayList.size() > 0) {
            j7.j(arrayList);
        }
        if (arrayList2.size() > 0) {
            j7.xt(arrayList2);
        }
        return j7;
    }

    public com.bytedance.sdk.component.adexpress.dynamic.cw.tl j(JSONObject jSONObject) {
        String j6;
        JSONObject jSONObject2;
        String optString = jSONObject.optString("type");
        String optString2 = jSONObject.optString("id");
        JSONObject optJSONObject = jSONObject.optJSONObject("values");
        g.j(optString, optJSONObject);
        JSONObject j7 = g.j(optString, g.j(jSONObject.optJSONArray("sceneValues")), optJSONObject);
        com.bytedance.sdk.component.adexpress.dynamic.cw.tl tlVar = new com.bytedance.sdk.component.adexpress.dynamic.cw.tl();
        if (TextUtils.isEmpty(optString2)) {
            tlVar.xt(String.valueOf(tlVar.hashCode()));
        } else {
            tlVar.xt(optString2);
        }
        if (optJSONObject != null) {
            xt(tlVar);
            tlVar.cw((float) optJSONObject.optDouble("x"));
            tlVar.r((float) optJSONObject.optDouble("y"));
            tlVar.up((float) optJSONObject.optDouble("width"));
            tlVar.m((float) optJSONObject.optDouble("height"));
            tlVar.ae(optJSONObject.optInt("remainWidth"));
            com.bytedance.sdk.component.adexpress.dynamic.cw.up upVar = new com.bytedance.sdk.component.adexpress.dynamic.cw.up();
            upVar.j(optString);
            upVar.xt(optJSONObject.optString("data"));
            upVar.cw(optJSONObject.optString("filterData"));
            upVar.r(optJSONObject.optString("dataExtraInfo"));
            com.bytedance.sdk.component.adexpress.dynamic.cw.m j8 = com.bytedance.sdk.component.adexpress.dynamic.cw.m.j(optJSONObject);
            upVar.j(j8);
            com.bytedance.sdk.component.adexpress.dynamic.cw.m j9 = com.bytedance.sdk.component.adexpress.dynamic.cw.m.j(j7);
            if (j9 == null) {
                upVar.xt(j8);
            } else {
                upVar.xt(j9);
            }
            j(j8);
            j(j9);
            if (TextUtils.equals(optString, "video-image-budget") && (jSONObject2 = this.xt) != null) {
                j(upVar, jSONObject2.optInt("image_mode"));
            }
            String type = upVar.getType();
            com.bytedance.sdk.component.adexpress.dynamic.cw.m up = upVar.up();
            if (ae.containsKey(type) && !up.qb()) {
                up.kt(ae.get(type));
            }
            if (up.qb()) {
                j6 = upVar.xt();
            } else {
                j6 = j(upVar.xt());
            }
            if (com.bytedance.sdk.component.adexpress.r.j()) {
                if (TextUtils.equals(type, "star") || TextUtils.equals(type, "text_star")) {
                    j6 = j("dynamic_creative.score_exact_i18n|");
                }
                if (TextUtils.equals(type, "score-count") || TextUtils.equals(type, "score-count-type-1") || TextUtils.equals(type, "score-count-type-2")) {
                    j6 = j("dynamic_creative.comment_num_i18n|");
                }
                if ("root".equals(type) && j8.tk()) {
                    j6 = j("image.0.url");
                }
            }
            if (!TextUtils.isEmpty(j()) && (TextUtils.equals("logo-union", optString) || TextUtils.equals("logo", optString))) {
                upVar.xt(j6 + "adx:" + j());
            } else {
                upVar.xt(j6);
            }
            upVar.cw(j(upVar.cw()));
            tlVar.j(upVar);
        }
        return tlVar;
    }

    private void j(com.bytedance.sdk.component.adexpress.dynamic.cw.up upVar, int i6) {
        int lastIndexOf;
        if (i6 != 5 && i6 != 15 && i6 != 50 && i6 != 154) {
            upVar.j(SocializeProtocolConstants.IMAGE);
            String j6 = g.j(SocializeProtocolConstants.IMAGE);
            com.bytedance.sdk.component.adexpress.dynamic.cw.m up = upVar.up();
            up.kt(j6);
            upVar.ae().kt(j6);
            String j7 = g.j(SocializeProtocolConstants.IMAGE, "clickArea");
            if (!TextUtils.isEmpty(j7)) {
                up.az(j7);
                upVar.ae().az(j7);
            }
            JSONObject om = up.om();
            if (om != null) {
                up.v(om.optString("imageLottieTosPath"));
                up.vl(om.optBoolean("animationsLoop"));
                up.s(om.optInt("lottieAppNameMaxLength"));
                up.l(om.optInt("lottieAdDescMaxLength"));
                up.a(om.optInt("lottieAdTitleMaxLength"));
            }
            upVar.xt(j6);
            if (j6 != null && (lastIndexOf = j6.lastIndexOf(".")) > 0) {
                String substring = j6.substring(0, lastIndexOf);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("width", j(substring + ".width"));
                    jSONObject.put("height", j(substring + ".height"));
                } catch (JSONException e6) {
                    vl.j(e6);
                }
                upVar.r(jSONObject.toString());
            }
            up.rs();
            return;
        }
        upVar.j("video");
        String j8 = g.j("video");
        upVar.up().kt(j8);
        String j9 = g.j("video", "clickArea");
        if (!TextUtils.isEmpty(j9)) {
            upVar.up().az(j9);
            upVar.ae().az(j9);
        }
        upVar.ae().kt(j8);
        upVar.xt(j8);
        upVar.up().qg();
    }

    private String j(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        for (String str2 : str.split("\\|")) {
            if (this.cw.xt(str2)) {
                String valueOf = String.valueOf(this.cw.j(str2));
                if (!TextUtils.isEmpty(valueOf)) {
                    return valueOf;
                }
            }
        }
        return "";
    }

    private String j() {
        com.bytedance.sdk.component.adexpress.dynamic.cw.cw cwVar = this.cw;
        if (cwVar == null) {
            return "";
        }
        return String.valueOf(cwVar.j("adx_name"));
    }

    private void j(com.bytedance.sdk.component.adexpress.dynamic.cw.m mVar) {
        if (mVar == null) {
            return;
        }
        String p5 = mVar.p();
        if (com.bytedance.sdk.component.adexpress.r.j()) {
            String r5 = com.bytedance.sdk.component.adexpress.r.tl.r(com.bytedance.sdk.component.adexpress.r.getContext());
            if ("zh".equals(r5)) {
                r5 = "cn";
            }
            if (!TextUtils.isEmpty(r5) && mVar.m() != null) {
                String optString = mVar.m().optString(r5);
                if (!TextUtils.isEmpty(optString)) {
                    p5 = optString;
                }
            }
        }
        if (TextUtils.isEmpty(p5)) {
            return;
        }
        int indexOf = p5.indexOf("{{");
        int indexOf2 = p5.indexOf("}}");
        if (indexOf >= 0 && indexOf2 >= 0 && indexOf2 >= indexOf) {
            String j6 = j(p5.substring(indexOf + 2, indexOf2));
            StringBuilder sb = new StringBuilder(p5.substring(0, indexOf));
            if (!TextUtils.isEmpty(j6)) {
                sb.append(j6);
            }
            sb.append(p5.substring(indexOf2 + 2));
            mVar.vl(sb.toString());
            return;
        }
        mVar.vl(p5);
    }
}
