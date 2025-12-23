package com.bytedance.sdk.openadsdk.core.live.j;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.sdk.component.oq.g;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.core.oq;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.tj.i;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.tencent.open.SocialConstants;
import com.umeng.socialize.common.SocializeConstants;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import xyz.adscope.amps.common.AMPSConstants;

/* loaded from: D:\Downloads\app\classes4.dex */
public class up extends j {
    @Override // com.bytedance.sdk.openadsdk.core.live.j.r
    public int j(com.bytedance.sdk.openadsdk.core.live.xt.xt xtVar, boolean z5) {
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.j.j
    protected boolean x_() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.j.r
    public int xt(Context context, n nVar, Map<String, Object> map) {
        return -1;
    }

    private String xt(n nVar, Map<String, Object> map) {
        if (nVar == null) {
            return "";
        }
        try {
            Uri j6 = com.bytedance.sdk.openadsdk.core.live.cw.j(Uri.parse("sslocal://webcast_room"), j(nVar, map));
            vl.j("TTLiveSDkBridge", "link: " + j6.toString());
            return j6.toString();
        } catch (Throwable th) {
            vl.j(th);
            vl.r("TTLiveSDkBridge", "link: null");
            return "";
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.j.r
    public String ae() {
        Object apply;
        if (this.f29472j == null) {
            return null;
        }
        try {
            apply = this.f29472j.apply(com.bytedance.sdk.openadsdk.i.r.j().j(3).j(Object.class).j(0, 4).xt());
            if (apply instanceof String) {
                return (String) apply;
            }
            return null;
        } catch (Throwable th) {
            vl.xt("TTLiveSDkBridge", th);
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.j.r
    public int b_(n nVar) {
        Object apply;
        if (this.f29472j != null) {
            long xt = xt(nVar);
            if (xt == 0) {
                return 1;
            }
            try {
                Bundle bundle = new Bundle();
                bundle.putLong("room_id", xt);
                apply = this.f29472j.apply(com.bytedance.sdk.openadsdk.i.r.j().j(3).j(Object.class).j(0, 2).j(1, bundle).xt());
                if (apply instanceof Integer) {
                    return ((Integer) apply).intValue();
                }
            } catch (Throwable th) {
                vl.xt("TTLiveSDkBridge", th);
            }
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.j.r
    public void j(com.bytedance.sdk.openadsdk.av.r rVar) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.j.r
    public JSONObject tl() {
        return this.cw;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.j.r
    public int up() {
        Object apply;
        boolean z5 = false;
        if (this.f29472j != null) {
            try {
                apply = this.f29472j.apply(com.bytedance.sdk.openadsdk.i.r.j().j(3).j(Object.class).j(0, 3).xt());
                if (apply instanceof Boolean) {
                    z5 = ((Boolean) apply).booleanValue();
                }
            } catch (Throwable th) {
                vl.xt("TTLiveSDkBridge", th);
            }
        }
        return z5 ? 2 : 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.j.r
    public void j(String str, boolean z5) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.j.r
    public boolean m() {
        if (xt() == 2) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0098  */
    @Override // com.bytedance.sdk.openadsdk.core.live.j.r
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int j(android.content.Context r10, com.bytedance.sdk.openadsdk.core.tj.n r11, java.util.Map<java.lang.String, java.lang.Object> r12) {
        /*
            r9 = this;
            r0 = -1
            if (r10 == 0) goto Lb2
            if (r11 != 0) goto L7
            goto Lb2
        L7:
            boolean r1 = r9.a_(r11)
            java.lang.String r2 = "TTLiveSDkBridge"
            if (r1 != 0) goto L15
            java.lang.String r10 = "mata has not le property"
            com.bytedance.sdk.component.utils.vl.j(r2, r10)
            return r0
        L15:
            if (r12 == 0) goto L21
            java.lang.String r0 = "event_tag"
            java.lang.Object r0 = r12.get(r0)
            java.lang.String r0 = (java.lang.String) r0
        L1f:
            r5 = r0
            goto L24
        L21:
            java.lang.String r0 = ""
            goto L1f
        L24:
            int r6 = r11.ww()
            boolean r0 = r9.m()
            r1 = 1
            if (r0 != 0) goto L3d
            r10 = 7
            if (r6 != r10) goto L34
            r8 = 1
            goto L36
        L34:
            r10 = 2
            r8 = 2
        L36:
            r7 = 1
            r3 = r9
            r4 = r11
            r3.j(r4, r5, r6, r7, r8)
            return r1
        L3d:
            r3 = r9
            r4 = r11
            java.util.function.Function<android.util.SparseArray<java.lang.Object>, java.lang.Object> r11 = r3.f29472j
            if (r11 == 0) goto Lac
            java.util.function.Function<android.util.SparseArray<java.lang.Object>, java.lang.Object> r11 = r3.f29472j
            com.bytedance.sdk.openadsdk.i.r r0 = com.bytedance.sdk.openadsdk.i.r.j()
            r1 = 0
            com.bytedance.sdk.openadsdk.i.r r0 = r0.j(r1)
            java.lang.Class<java.lang.Integer> r7 = java.lang.Integer.class
            com.bytedance.sdk.openadsdk.i.r r0 = r0.j(r7)
            java.lang.String r12 = r9.xt(r4, r12)
            com.bytedance.sdk.openadsdk.i.r r12 = r0.j(r1, r12)
            android.util.SparseArray r12 = r12.xt()
            java.lang.Object r11 = com.bytedance.msdk.core.ae.a.a(r11, r12)
            if (r11 == 0) goto L6d
            java.lang.Integer r11 = (java.lang.Integer) r11
            int r11 = r11.intValue()
            goto L6e
        L6d:
            r11 = 0
        L6e:
            if (r11 != 0) goto L91
            boolean r12 = r9.j(r4, r1)
            if (r12 == 0) goto L93
            int r12 = r9.cw(r4)
            if (r12 != 0) goto L8f
            com.bytedance.sdk.openadsdk.core.live.cw.j r0 = new com.bytedance.sdk.openadsdk.core.live.cw.j     // Catch: java.lang.Exception -> L89
            r0.<init>()     // Catch: java.lang.Exception -> L89
            com.bytedance.sdk.openadsdk.core.live.cw.j r0 = r0.j(r5)     // Catch: java.lang.Exception -> L89
            r0.j(r10, r4)     // Catch: java.lang.Exception -> L89
            goto L8f
        L89:
            r0 = move-exception
            r10 = r0
            com.bytedance.sdk.component.utils.vl.j(r10)
            goto L91
        L8f:
            r1 = r12
            goto L93
        L91:
            r10 = 3
            r1 = 3
        L93:
            if (r11 != 0) goto L98
            java.lang.String r10 = "le openliv succ"
            goto La6
        L98:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r12 = "callR: "
            r10.<init>(r12)
            r10.append(r11)
            java.lang.String r10 = r10.toString()
        La6:
            com.bytedance.sdk.component.utils.vl.j(r2, r10)
            r8 = r1
            r1 = r11
            goto Lad
        Lac:
            r8 = 1
        Lad:
            r7 = r6
            r3.j(r4, r5, r6, r7, r8)
            return r1
        Lb2:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.live.j.up.j(android.content.Context, com.bytedance.sdk.openadsdk.core.tj.n, java.util.Map):int");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xt(String str, n nVar, long j6) {
        try {
            if (this.f29472j == null) {
                return;
            }
            Map<String, String> j7 = j(nVar, (Map<String, Object>) null);
            Map<String, String> j8 = com.bytedance.sdk.openadsdk.core.video.cw.j.j(v.getContext());
            j8.put("room_id", j7.get("room_id"));
            j8.put("anchor_id", j7.get("owner_open_id"));
            j8.put("enter_from_merge", j7.get("enter_from_merge"));
            j8.put("enter_method", j7.get("enter_method"));
            j8.put("action_type", AMPSConstants.FrequencyEventType.FREQUENCY_EVENT_TYPE_CLICK);
            j8.put("request_id", j7.get("request_id"));
            StringBuilder sb = new StringBuilder();
            sb.append(j6);
            j8.put("duration", sb.toString());
            j8.put("is_other_channel", "union_ad");
            j8.put("IESLiveEffectAdTrackExtraServiceKey", j7.get("IESLiveEffectAdTrackExtraServiceKey"));
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry<String, String> entry : j8.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            this.f29472j.apply(com.bytedance.sdk.openadsdk.i.r.j().j(4).j(Void.class).j(0, str).j(1, jSONObject).xt());
        } catch (Throwable th) {
            if (vl.cw()) {
                vl.cw("TTInnerLiveHelper", "Throwable : ", th);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.j.r
    public void r() {
    }

    public Map<String, String> j(n nVar, Map<String, Object> map) {
        Object apply;
        Object apply2;
        HashMap hashMap = new HashMap();
        if (nVar != null) {
            hashMap.put("room_id", nVar.re());
            if (this.f29472j != null) {
                int tl = uf.tl(nVar);
                apply = this.f29472j.apply(com.bytedance.sdk.openadsdk.i.r.j().j(1).j(String.class).j(0, Integer.valueOf(tl)).xt());
                apply2 = this.f29472j.apply(com.bytedance.sdk.openadsdk.i.r.j().j(2).j(String.class).j(0, Integer.valueOf(tl)).j(1, Boolean.valueOf(com.bytedance.sdk.openadsdk.core.video.cw.j.j(nVar))).xt());
                hashMap.put("enter_from_merge", (String) apply);
                hashMap.put("enter_method", (String) apply2);
            }
            hashMap.put("host", "aweme");
            hashMap.put("is_other_channel", "union_ad");
            String j6 = j(nVar, nVar.kb(), map);
            if (!TextUtils.isEmpty(j6)) {
                hashMap.put("ecom_live_params", j6);
            }
            i m111if = nVar.m111if();
            if (m111if != null && !TextUtils.isEmpty(m111if.xt())) {
                try {
                    Uri parse = Uri.parse(m111if.xt());
                    JSONObject jSONObject = new JSONObject(parse.getQueryParameter("ad_data_params"));
                    String optString = jSONObject.optString(MediationConstant.EXTRA_LOG_EXTRA);
                    JSONObject jSONObject2 = new JSONObject();
                    if (!TextUtils.isEmpty(optString)) {
                        JSONObject jSONObject3 = new JSONObject(optString);
                        jSONObject3.put("ad_event_aid", jSONObject.optString(CommonNetImpl.AID));
                        jSONObject3.put("ad_event_source", com.bytedance.sdk.openadsdk.core.live.cw.j(parse, SocialConstants.PARAM_SOURCE));
                        jSONObject3.put("ad_event_gd_label", com.bytedance.sdk.openadsdk.core.live.cw.j(parse, "gd_label"));
                        jSONObject3.put("ad_event_union_user_id", com.bytedance.sdk.openadsdk.core.live.cw.j(parse, "union_user_id"));
                        jSONObject3.put("ad_event_app_siteid", oq.i().f());
                        jSONObject3.put("ad_event_live_type", "1");
                        hashMap.put(MediationConstant.EXTRA_LOG_EXTRA, jSONObject3.toString());
                        jSONObject2.put(MediationConstant.EXTRA_LOG_EXTRA, jSONObject3.toString());
                    }
                    String optString2 = jSONObject.optString("cid");
                    jSONObject2.put("creativeID", optString2);
                    hashMap.put("creative_id", optString2);
                    hashMap.put("IESLiveEffectAdTrackExtraServiceKey", jSONObject2.toString());
                    String j7 = com.bytedance.sdk.openadsdk.core.live.cw.j(parse, "owner_open_id");
                    if (TextUtils.isEmpty(j7)) {
                        j7 = com.bytedance.sdk.openadsdk.core.live.cw.j(parse, SocializeConstants.TENCENT_UID);
                    }
                    hashMap.put("owner_open_id", j7);
                    String j8 = com.bytedance.sdk.openadsdk.core.live.cw.j(parse, "pangle_live_room_data");
                    if (!TextUtils.isEmpty(j8)) {
                        hashMap.put("pangle_live_room_data", j8);
                    }
                    hashMap.put("request_id", com.bytedance.sdk.openadsdk.core.live.cw.j(parse, "request_id"));
                    return hashMap;
                } catch (Exception e6) {
                    vl.j(e6);
                }
            }
        }
        return hashMap;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.j.r
    public int xt() {
        Object apply;
        if (this.f29472j != null) {
            try {
                apply = this.f29472j.apply(com.bytedance.sdk.openadsdk.i.r.j().j(3).j(Object.class).j(0, 1).xt());
                if (apply instanceof Integer) {
                    return ((Integer) apply).intValue();
                }
            } catch (Throwable th) {
                vl.xt("TTLiveSDkBridge", th);
            }
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.j.r
    public boolean j(n nVar) {
        return a_(nVar) && this.f29472j != null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.j.j, com.bytedance.sdk.openadsdk.core.live.j.r
    public void j(final String str, final n nVar, final long j6) {
        com.bytedance.sdk.openadsdk.l.ae.xt(new g("csj_live_log_event_v2") { // from class: com.bytedance.sdk.openadsdk.core.live.j.up.1
            @Override // java.lang.Runnable
            public void run() {
                up.this.xt(str, nVar, j6);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.j.r
    public int j(n nVar, cw cwVar, String str) {
        Object apply;
        if (nVar == null || TextUtils.isEmpty(nVar.qb()) || this.f29472j == null) {
            return -1;
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putString("schema", nVar.qb());
            apply = this.f29472j.apply(com.bytedance.sdk.openadsdk.i.r.j().j(3).j(Object.class).j(0, 5).j(1, bundle).xt());
        } catch (Throwable unused) {
        }
        if (apply == null) {
            return 4;
        }
        if (apply instanceof Integer) {
            return ((Integer) apply).intValue();
        }
        return -1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.j.r
    public int j(String str) {
        Object apply;
        try {
            Bundle bundle = new Bundle();
            bundle.putString("schema", str);
            apply = this.f29472j.apply(com.bytedance.sdk.openadsdk.i.r.j().j(3).j(Object.class).j(0, 6).j(1, bundle).xt());
            if (apply instanceof Integer) {
                return ((Integer) apply).intValue();
            }
        } catch (Throwable unused) {
        }
        return 0;
    }
}
