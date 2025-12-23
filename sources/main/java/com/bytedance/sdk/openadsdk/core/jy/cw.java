package com.bytedance.sdk.openadsdk.core.jy;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.idl.face.platform.common.ConstantHelper;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.component.utils.ws;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.core.ch.qv;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.jy.j;
import com.bytedance.sdk.openadsdk.core.kt;
import com.bytedance.sdk.openadsdk.core.nativeexpress.g;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.rn.ch;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.core.rn.oq;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.rn.v;
import com.bytedance.sdk.openadsdk.core.tj;
import com.bytedance.sdk.openadsdk.core.tj.hl;
import com.bytedance.sdk.openadsdk.core.tj.i;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.tj.qb;
import com.bytedance.sdk.openadsdk.core.tj.xp;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.tencent.open.SocialConstants;
import com.umeng.analytics.pro.d;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import v0.a;
import xyz.adscope.amps.common.AMPSConstants;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw {

    /* renamed from: j, reason: collision with root package name */
    public static int f29199j;

    public static void cw(n nVar, String str, String str2, Map<String, Object> map) {
        j(nVar, str, str2, map);
    }

    public static void j(n nVar) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void up(n nVar, String str, JSONObject jSONObject) throws JSONException {
        com.bytedance.sdk.openadsdk.i.cw.cw.xt rr;
        if (h.m() && (rr = nVar.rr()) != null) {
            String jy = rr.jy();
            if (TextUtils.isEmpty(jy)) {
                return;
            }
            jSONObject.putOpt("media_extra", jy);
        }
    }

    public static void xt(final n nVar, final String str, final Map<String, Object> map, final Double d6) {
        if (nVar == null) {
            return;
        }
        p.xt();
        final float floatValue = Double.valueOf((System.currentTimeMillis() / 1000) - uf.vl(nVar)).floatValue();
        final String j6 = v.j(str, oq.xt(), uf.g(nVar), com.bytedance.sdk.openadsdk.core.multipro.xt.cw());
        f29199j++;
        j(nVar, str, AMPSConstants.FrequencyEventType.FREQUENCY_EVENT_TYPE_SHOW, new com.bytedance.sdk.openadsdk.m.j.j() { // from class: com.bytedance.sdk.openadsdk.core.jy.cw.35
            @Override // com.bytedance.sdk.openadsdk.m.j.j
            public void j(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(ConstantHelper.LOG_DE, com.bytedance.sdk.openadsdk.core.cw.j.j(com.bytedance.sdk.openadsdk.core.v.getContext(), g.j(str)).toString());
                jSONObject2.put("is_cache", nVar.vr() ? 1 : 0);
                jSONObject2.put("cache_type", nVar.pm());
                jSONObject2.put("correct_action_code", nVar.xc());
                jSONObject2.put("correct_result_code", nVar.lc());
                Map map2 = map;
                if (map2 != null) {
                    if (!map2.containsKey("show_send_type")) {
                        map.put("show_send_type", 0);
                    }
                    for (Map.Entry entry : map.entrySet()) {
                        jSONObject2.put((String) entry.getKey(), entry.getValue());
                    }
                }
                jSONObject2.put("start2req_time", SystemClock.elapsedRealtime() - tj.up);
                jSONObject2.put("start_type", !tj.xt.get() ? 1 : 0);
                jSONObject2.put("show_count", cw.f29199j);
                String m6 = com.bytedance.sdk.openadsdk.core.oq.i().m();
                if (!TextUtils.isEmpty(m6)) {
                    jSONObject2.put("can_use_sensor", m6);
                }
                if (!com.bytedance.sdk.openadsdk.core.oq.i().qv()) {
                    jSONObject2.put("mcod", "0");
                }
                if (!com.bytedance.sdk.openadsdk.core.oq.i().tl()) {
                    jSONObject2.put("od", "0");
                }
                jSONObject2.put("is_shake_ads", com.bytedance.sdk.openadsdk.core.oq.i().mi());
                jSONObject2.put("direction", com.bytedance.sdk.openadsdk.core.a.j.j().m());
                cw.up(nVar, str, jSONObject2);
                String str2 = j6;
                if (str2 != null) {
                    ed.j(jSONObject2, str2);
                }
                jSONObject2.put("live_sdk_status", com.bytedance.sdk.openadsdk.core.live.xt.j().cw());
                com.bytedance.sdk.openadsdk.up.j.j(jSONObject2, nVar);
                jSONObject2.put("shakeLiSize", com.bytedance.sdk.component.utils.tj.j(com.bytedance.sdk.openadsdk.core.v.getContext()).j());
                cw.j(jSONObject2);
                qv.j(nVar);
                jSONObject.put("ad_extra_data", jSONObject2.toString());
                float f6 = floatValue;
                if (f6 <= 0.0f) {
                    f6 = 0.0f;
                }
                jSONObject.putOpt("show_time", Float.valueOf(f6));
                String ua = nVar.ua();
                if (!TextUtils.isEmpty(ua)) {
                    try {
                        double parseDouble = Double.parseDouble(ua);
                        if (parseDouble <= 0.0d) {
                            jSONObject.put("ttdsp_price", 0);
                            return;
                        } else {
                            if (h.xt < 4400) {
                                parseDouble *= 100000.0d;
                            }
                            jSONObject.put("ttdsp_price", parseDouble);
                        }
                    } catch (Throwable th) {
                        jSONObject.put("ttdsp_price", 0);
                        vl.j(th);
                    }
                }
                j(nVar, d6, jSONObject);
            }

            public void j(n nVar2, Double d7, JSONObject jSONObject) {
                Object obj;
                Object obj2;
                try {
                    Map<String, Object> lg = nVar2.lg();
                    if (lg == null || (obj = lg.get("sdk_bidding_type")) == null || Integer.parseInt(obj.toString()) != 2) {
                        return;
                    }
                    if (d7 != null) {
                        jSONObject.put("ttdsp_price", d7);
                    } else if (nVar2.mm() && (obj2 = lg.get("price")) != null) {
                        jSONObject.put("ttdsp_price", Double.parseDouble(obj2.toString()));
                    }
                } catch (Throwable unused) {
                }
            }
        });
        String cw = kt.cw();
        List<String> dj = nVar.dj();
        if (!TextUtils.isEmpty(cw)) {
            HashMap hashMap = new HashMap();
            hashMap.put(CommonNetImpl.AID, nVar.so());
            hashMap.put("cid", nVar.fs());
            hashMap.put("req_id", nVar.ej());
            hashMap.put("customer_id", uf.qv(nVar));
            com.bytedance.sdk.openadsdk.core.kt.xt.j(cw, dj, true, hashMap, j(nVar, str, AMPSConstants.FrequencyEventType.FREQUENCY_EVENT_TYPE_SHOW));
        } else if (dj != null && dj.size() != 0) {
            j(nVar, dj, str, "no did", AMPSConstants.FrequencyEventType.FREQUENCY_EVENT_TYPE_SHOW);
        }
        if (f29199j % 5 == 0 && com.bytedance.sdk.openadsdk.j.j.j.j() != null) {
            com.bytedance.sdk.openadsdk.j.j.j.j().xt("AdShow" + System.currentTimeMillis());
        }
        if (com.bytedance.sdk.openadsdk.core.live.xt.j().j(nVar)) {
            com.bytedance.sdk.openadsdk.core.live.xt.j().j(a.f54679a, nVar, 0L);
        } else if (com.bytedance.sdk.openadsdk.core.video.cw.j.j(nVar)) {
            com.bytedance.sdk.openadsdk.core.video.cw.j.j(a.f54679a, nVar, 0L);
        }
        uf.cw();
        com.bytedance.sdk.openadsdk.av.xt.cw();
        com.bytedance.sdk.openadsdk.core.live.xt.j().r();
        com.bytedance.sdk.openadsdk.core.oq.i().r().r();
        v.j(f29199j, 1);
        com.bytedance.sdk.openadsdk.core.r.j().cw(nVar.fj());
        com.bytedance.sdk.openadsdk.core.qv.j.j(nVar);
    }

    public static void cw(final n nVar, String str, String str2, final long j6, final JSONObject jSONObject) {
        if (nVar == null) {
            return;
        }
        j(nVar, str, str2, new com.bytedance.sdk.openadsdk.m.j.j() { // from class: com.bytedance.sdk.openadsdk.core.jy.cw.11
            @Override // com.bytedance.sdk.openadsdk.m.j.j
            public void j(JSONObject jSONObject2) throws JSONException {
                jSONObject2.put("duration", j6);
                com.bytedance.sdk.openadsdk.up.j.j(jSONObject, nVar);
                jSONObject2.put("ad_extra_data", jSONObject.toString());
            }
        });
    }

    public static void j(String str, String str2, String str3, String str4, com.bytedance.sdk.openadsdk.m.j.j jVar) {
        new j.C0460j().up(str3).r(str4).j(str).xt(str2).j(jVar);
    }

    public static void r(n nVar, String str, String str2, Map<String, Object> map) {
        j(nVar, str, str2, map);
    }

    public static void ae(n nVar, String str, String str2, Map<String, Object> map) {
        j(nVar, str, str2, map);
    }

    public static void cw(n nVar, String str, String str2) {
        j(nVar, str, str2, (com.bytedance.sdk.openadsdk.m.j.j) null);
    }

    public static void m(n nVar, String str, String str2, Map<String, Object> map) {
        j(nVar, str, str2, map);
    }

    public static void r(n nVar, String str, final long j6) {
        j(nVar, str, "render_live_picture_success", new com.bytedance.sdk.openadsdk.m.j.j() { // from class: com.bytedance.sdk.openadsdk.core.jy.cw.20
            @Override // com.bytedance.sdk.openadsdk.m.j.j
            public void j(JSONObject jSONObject) throws JSONException {
                jSONObject.put("duration", j6);
                jSONObject.putOpt("ad_extra_data", new JSONObject().toString());
            }
        });
    }

    public static void tl(n nVar, String str, String str2, Map<String, Object> map) {
        xp al = nVar.al();
        if (map == null) {
            map = new HashMap<>();
        }
        if (al != null) {
            map.put("wc_type", Integer.valueOf(al.up()));
        }
        map.put("rom_new_version", ch.az());
        map.put("is_background", Boolean.valueOf(com.bytedance.sdk.openadsdk.core.oq.i().j()));
        map.put("interaction_type", Integer.valueOf(nVar.jl()));
        j(nVar, str, str2, map);
    }

    public static void cw(n nVar, String str, String str2, JSONObject jSONObject) {
        if (nVar == null) {
            return;
        }
        new j.C0460j().up(nVar.fs()).r(nVar.os()).j(str).xt(str2).j(jSONObject).j((com.bytedance.sdk.openadsdk.m.j.j) null);
    }

    public static void up(n nVar, String str, String str2, Map<String, Object> map) {
        j(nVar, str, str2, map);
    }

    public static void j(n nVar, String str, String str2, com.bytedance.sdk.openadsdk.m.j.j jVar) {
        if (nVar == null) {
            return;
        }
        new j.C0460j().up(nVar.fs()).r(nVar.os()).j(str).xt(str2).j(jVar);
    }

    public static void cw(final n nVar, String str, final long j6) {
        j(nVar, str, "load", new com.bytedance.sdk.openadsdk.m.j.j() { // from class: com.bytedance.sdk.openadsdk.core.jy.cw.19
            @Override // com.bytedance.sdk.openadsdk.m.j.j
            public void j(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("render_type", "h5");
                jSONObject2.putOpt("render_type_2", 0);
                com.bytedance.sdk.openadsdk.up.j.j(jSONObject2, n.this);
                jSONObject.putOpt("ad_extra_data", jSONObject2);
                jSONObject.put("duration", Math.min(j6, TTAdConstant.AD_MAX_EVENT_TIME));
            }
        });
    }

    public static void cw(n nVar, String str, final JSONObject jSONObject) {
        if (nVar == null || jSONObject == null) {
            return;
        }
        j(nVar, str, "splash_ad_showstat", new com.bytedance.sdk.openadsdk.m.j.j() { // from class: com.bytedance.sdk.openadsdk.core.jy.cw.34
            @Override // com.bytedance.sdk.openadsdk.m.j.j
            public void j(JSONObject jSONObject2) throws JSONException {
                jSONObject2.put("ad_extra_data", jSONObject.toString());
            }
        });
    }

    public static void j(n nVar, String str, String str2, JSONObject jSONObject, com.bytedance.sdk.openadsdk.m.j.j jVar) {
        if (nVar == null) {
            return;
        }
        new j.C0460j().up(nVar.fs()).r(nVar.os()).j(str).xt(str2).j(jSONObject).j(jVar);
    }

    public static void j(final n nVar, String str, String str2, final JSONObject jSONObject) {
        j(nVar, str, str2, new com.bytedance.sdk.openadsdk.m.j.j() { // from class: com.bytedance.sdk.openadsdk.core.jy.cw.1
            @Override // com.bytedance.sdk.openadsdk.m.j.j
            public void j(JSONObject jSONObject2) throws JSONException {
                JSONObject jSONObject3 = jSONObject;
                if (jSONObject3 != null) {
                    com.bytedance.sdk.openadsdk.up.j.j(jSONObject3, nVar);
                    jSONObject2.put("ad_extra_data", jSONObject.toString());
                }
            }
        });
    }

    public static void j(final n nVar, String str, String str2, final Map<String, Object> map) {
        j(nVar, str, str2, new com.bytedance.sdk.openadsdk.m.j.j() { // from class: com.bytedance.sdk.openadsdk.core.jy.cw.12
            @Override // com.bytedance.sdk.openadsdk.m.j.j
            public void j(JSONObject jSONObject) throws JSONException {
                if (map != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    for (Map.Entry entry : map.entrySet()) {
                        jSONObject2.put((String) entry.getKey(), entry.getValue());
                    }
                    com.bytedance.sdk.openadsdk.up.j.j(jSONObject2, nVar);
                    jSONObject.put("ad_extra_data", jSONObject2.toString());
                }
            }
        });
    }

    public static void j(final n nVar, final String str, final Map<String, Object> map) {
        com.bytedance.sdk.openadsdk.l.ae.j((Runnable) new com.bytedance.sdk.component.oq.g("repost_show_check") { // from class: com.bytedance.sdk.openadsdk.core.jy.cw.22
            @Override // java.lang.Runnable
            public void run() {
                if (nVar == null) {
                    return;
                }
                final float floatValue = Double.valueOf((System.currentTimeMillis() / 1000) - uf.vl(nVar)).floatValue();
                cw.j(nVar, str, "show_check", new com.bytedance.sdk.openadsdk.m.j.j() { // from class: com.bytedance.sdk.openadsdk.core.jy.cw.22.1
                    @Override // com.bytedance.sdk.openadsdk.m.j.j
                    public void j(JSONObject jSONObject) throws JSONException {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put(ConstantHelper.LOG_DE, com.bytedance.sdk.openadsdk.core.cw.j.j(com.bytedance.sdk.openadsdk.core.v.getContext(), g.j(str)).toString());
                        jSONObject2.put("is_cache", nVar.vr() ? 1 : 0);
                        jSONObject2.put("cache_type", nVar.pm());
                        jSONObject2.put("correct_action_code", nVar.xc());
                        jSONObject2.put("correct_result_code", nVar.lc());
                        Map map2 = map;
                        if (map2 != null) {
                            for (Map.Entry entry : map2.entrySet()) {
                                jSONObject2.put((String) entry.getKey(), entry.getValue());
                            }
                        }
                        jSONObject2.put("start2req_time", SystemClock.elapsedRealtime() - tj.up);
                        jSONObject2.put("start_type", !tj.xt.get() ? 1 : 0);
                        jSONObject2.put("show_count", cw.f29199j);
                        jSONObject2.put("can_use_sensor", com.bytedance.sdk.openadsdk.core.oq.i().m());
                        jSONObject2.put("is_shake_ads", com.bytedance.sdk.openadsdk.core.oq.i().mi());
                        jSONObject2.put("direction", com.bytedance.sdk.openadsdk.core.a.j.j().m());
                        AnonymousClass22 anonymousClass22 = AnonymousClass22.this;
                        cw.up(nVar, str, jSONObject2);
                        com.bytedance.sdk.openadsdk.up.j.j(jSONObject2, nVar);
                        jSONObject.put("ad_extra_data", jSONObject2.toString());
                        float f6 = floatValue;
                        if (f6 <= 0.0f) {
                            f6 = 0.0f;
                        }
                        jSONObject.putOpt("show_time", Float.valueOf(f6));
                    }
                });
            }
        });
    }

    public static void j(final n nVar, final String str, final Map<String, Object> map, final Double d6) {
        com.bytedance.sdk.openadsdk.l.ae.j(new com.bytedance.sdk.component.oq.g("report_show") { // from class: com.bytedance.sdk.openadsdk.core.jy.cw.33
            @Override // java.lang.Runnable
            public void run() {
                cw.xt(nVar, str, (Map<String, Object>) map, d6);
            }
        });
    }

    private static void j(n nVar, List<String> list, String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("track_type", str3);
            jSONObject.put("error_msg", str2);
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            int size = list.size();
            for (int i6 = 0; i6 < size; i6++) {
                sb.append(list.get(i6));
                if (i6 == size - 1) {
                    sb.append("]");
                } else {
                    sb.append(",");
                }
            }
            jSONObject.put("url", sb.toString());
            jSONObject.put("urls_size", size);
        } catch (Exception unused) {
        }
        j(str, nVar.fs(), nVar.os(), jSONObject);
    }

    public static void xt(n nVar, String str, String str2, Map<String, Object> map) {
        j(nVar, str, str2, map);
    }

    public static void xt(n nVar, String str) {
        if (nVar != null) {
            com.bytedance.sdk.openadsdk.core.dislike.cw.cw cwVar = new com.bytedance.sdk.openadsdk.core.dislike.cw.cw();
            cwVar.j("0:00");
            cwVar.xt(str);
            j(nVar.gs(), cwVar);
        }
    }

    public static void xt(n nVar, String str, String str2, final long j6) {
        if (nVar == null) {
            return;
        }
        j(nVar, str, str2, new com.bytedance.sdk.openadsdk.m.j.j() { // from class: com.bytedance.sdk.openadsdk.core.jy.cw.9
            @Override // com.bytedance.sdk.openadsdk.m.j.j
            public void j(JSONObject jSONObject) throws JSONException {
                jSONObject.put("timestamp", j6);
            }
        });
    }

    public static void j(final n nVar, final String str, final long j6) {
        j(nVar, str, "download_creative_duration", new com.bytedance.sdk.openadsdk.m.j.j() { // from class: com.bytedance.sdk.openadsdk.core.jy.cw.36
            @Override // com.bytedance.sdk.openadsdk.m.j.j
            public void j(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(ConstantHelper.LOG_DE, com.bytedance.sdk.openadsdk.core.cw.j.j(com.bytedance.sdk.openadsdk.core.v.getContext(), g.j(str)).toString());
                jSONObject2.put("download_creative_duration", j6);
                com.bytedance.sdk.openadsdk.up.j.j(jSONObject2, nVar);
                jSONObject.put("ad_extra_data", jSONObject2.toString());
            }
        });
    }

    public static void xt(final n nVar, String str, String str2, final long j6, final JSONObject jSONObject) {
        if (nVar == null || jSONObject == null) {
            return;
        }
        j(nVar, str, str2, new com.bytedance.sdk.openadsdk.m.j.j() { // from class: com.bytedance.sdk.openadsdk.core.jy.cw.10
            @Override // com.bytedance.sdk.openadsdk.m.j.j
            public void j(JSONObject jSONObject2) throws JSONException {
                jSONObject2.put("duration", j6);
                com.bytedance.sdk.openadsdk.up.j.j(jSONObject, nVar);
                jSONObject2.put("ad_extra_data", jSONObject.toString());
            }
        });
    }

    public static void j(final String str, n nVar, String str2, final int i6) {
        if (nVar == null) {
            return;
        }
        j(nVar, str2, "ad_show_time", new com.bytedance.sdk.openadsdk.m.j.j() { // from class: com.bytedance.sdk.openadsdk.core.jy.cw.37
            @Override // com.bytedance.sdk.openadsdk.m.j.j
            public void j(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt(SocialConstants.PARAM_SOURCE, Integer.valueOf(i6));
                jSONObject.putOpt("ad_extra_data", jSONObject2.toString());
                jSONObject.put("duration", str);
            }
        });
    }

    public static void xt(n nVar, String str, String str2) {
        j(nVar, str, str2, (com.bytedance.sdk.openadsdk.m.j.j) null);
    }

    public static long j(long j6, boolean z5, n nVar, String str, int i6) {
        if (z5) {
            return System.currentTimeMillis();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis() - j6);
        j(sb.toString(), nVar, str, i6);
        return 0L;
    }

    public static void xt(n nVar, String str, String str2, JSONObject jSONObject) {
        j(nVar, str, str2, jSONObject);
    }

    public static void xt(n nVar, String str, long j6) {
        String str2;
        if (com.bytedance.sdk.openadsdk.core.v.xt().ry()) {
            final long currentTimeMillis = System.currentTimeMillis() - j6;
            str.getClass();
            switch (str) {
                case "banner_ad":
                    str2 = "banner_ad_loadtime";
                    break;
                case "rewarded_video":
                    str2 = "rewarded_video_loadtime";
                    break;
                case "stream":
                    str2 = "stream_loadtime";
                    break;
                case "fullscreen_interstitial_ad":
                    str2 = "fullscreen_interstitial_ad_loadtime";
                    break;
                case "embeded_ad":
                    str2 = "embeded_ad_loadtime";
                    break;
                case "interaction":
                    str2 = "interaction_loadtime";
                    break;
                case "draw_ad":
                    str2 = "draw_ad_loadtime";
                    break;
                default:
                    str2 = "";
                    break;
            }
            j(nVar, str, str2, new com.bytedance.sdk.openadsdk.m.j.j() { // from class: com.bytedance.sdk.openadsdk.core.jy.cw.13
                @Override // com.bytedance.sdk.openadsdk.m.j.j
                public void j(JSONObject jSONObject) throws JSONException {
                    jSONObject.put("duration", currentTimeMillis);
                }
            });
        }
    }

    public static long j(long j6, n nVar, String str, int i6) {
        if (j6 <= 0) {
            return j6;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis() - j6);
        j(sb.toString(), nVar, str, i6);
        return 0L;
    }

    public static void j(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString(CommonNetImpl.TAG);
        String optString2 = jSONObject.optString(MediationConstant.EXTRA_ADID);
        String optString3 = jSONObject.optString(MediationConstant.EXTRA_LOG_EXTRA);
        if (TextUtils.isEmpty(optString3) || TextUtils.isEmpty(optString2) || TextUtils.isEmpty(optString)) {
            return;
        }
        j(optString, optString2, optString3, jSONObject2);
    }

    public static void j(String str, String str2, String str3, final JSONObject jSONObject) {
        j(str, "show_url", str2, str3, new com.bytedance.sdk.openadsdk.m.j.j() { // from class: com.bytedance.sdk.openadsdk.core.jy.cw.38
            @Override // com.bytedance.sdk.openadsdk.m.j.j
            public void j(JSONObject jSONObject2) throws JSONException {
                JSONObject jSONObject3 = jSONObject;
                if (jSONObject3 != null) {
                    jSONObject2.put("ad_extra_data", jSONObject3.toString());
                }
            }
        });
    }

    public static void j(final n nVar, final String str) {
        String xt;
        if (nVar == null || str == null || (xt = uf.xt(nVar)) == null) {
            return;
        }
        j(nVar, xt, "page_on_create", new com.bytedance.sdk.openadsdk.m.j.j() { // from class: com.bytedance.sdk.openadsdk.core.jy.cw.39
            @Override // com.bytedance.sdk.openadsdk.m.j.j
            public void j(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(d.f41203v, str);
                ed.j(jSONObject2, "");
                com.bytedance.sdk.openadsdk.up.j.j(jSONObject2, nVar);
                jSONObject.put("ad_extra_data", jSONObject2);
            }
        });
    }

    public static void xt(final n nVar, String str, String str2, final String str3) {
        j(nVar, str, str2, new com.bytedance.sdk.openadsdk.m.j.j() { // from class: com.bytedance.sdk.openadsdk.core.jy.cw.16
            @Override // com.bytedance.sdk.openadsdk.m.j.j
            public void j(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("scheme", str3);
                com.bytedance.sdk.openadsdk.up.j.j(jSONObject2, nVar);
                jSONObject.put("ad_extra_data", jSONObject2.toString());
            }
        });
    }

    public static void j(String str, final n nVar, final com.bytedance.sdk.openadsdk.core.tj.oq oqVar, final String str2, final boolean z5, final Map<String, Object> map, final int i6, boolean z6) {
        if (nVar == null || z6) {
            return;
        }
        final float floatValue = Double.valueOf((System.currentTimeMillis() / 1000) - uf.vl(nVar)).floatValue();
        j(nVar, str2, str, new com.bytedance.sdk.openadsdk.m.j.j() { // from class: com.bytedance.sdk.openadsdk.core.jy.cw.2
            @Override // com.bytedance.sdk.openadsdk.m.j.j
            public void j(JSONObject jSONObject) throws JSONException {
                com.bytedance.sdk.openadsdk.core.tj.oq oqVar2 = com.bytedance.sdk.openadsdk.core.tj.oq.this;
                if (oqVar2 != null) {
                    JSONObject j6 = oqVar2.j();
                    j6.put(ConstantHelper.LOG_DE, com.bytedance.sdk.openadsdk.core.cw.j.j(com.bytedance.sdk.openadsdk.core.v.getContext(), g.j(str2)).toString());
                    j6.put("is_valid", z5);
                    int i7 = i6;
                    if (i7 > 0 && i7 <= 2) {
                        j6.put("user_behavior_type", i7);
                    }
                    ed.j(j6, "");
                    Map map2 = map;
                    if (map2 != null) {
                        for (Map.Entry entry : map2.entrySet()) {
                            j6.put((String) entry.getKey(), entry.getValue());
                        }
                    }
                    cw.up(nVar, str2, j6);
                    j6.putOpt("obm_convert", com.bytedance.sdk.openadsdk.core.tj.tj.cw(nVar));
                    j6.put("can_use_sensor", com.bytedance.sdk.openadsdk.core.oq.i().m());
                    if (!com.bytedance.sdk.openadsdk.core.oq.i().qv()) {
                        j6.put("mcod", "0");
                    }
                    if (!com.bytedance.sdk.openadsdk.core.oq.i().tl()) {
                        j6.put("od", "0");
                    }
                    j6.put("is_shake_ads", com.bytedance.sdk.openadsdk.core.oq.i().mi());
                    j6.put("live_sdk_config", com.bytedance.sdk.openadsdk.core.live.xt.j().tl());
                    j6.put("direction", com.bytedance.sdk.openadsdk.core.a.j.j().m());
                    j6.put("is_cache", nVar.vr() ? 1 : 0);
                    j6.put("cache_type", nVar.pm());
                    j6.put("correct_action_code", nVar.xc());
                    j6.put("correct_result_code", nVar.lc());
                    com.bytedance.sdk.openadsdk.up.j.j(j6, nVar);
                    cw.j(j6);
                    jSONObject.put("ad_extra_data", j6.toString());
                }
                float f6 = floatValue;
                if (f6 <= 0.0f) {
                    f6 = 0.0f;
                }
                jSONObject.putOpt("show_time", Float.valueOf(f6));
            }
        });
        String cw = kt.cw();
        List<String> kk = nVar.kk();
        if (!TextUtils.isEmpty(cw) && AMPSConstants.FrequencyEventType.FREQUENCY_EVENT_TYPE_CLICK.equals(str)) {
            HashMap hashMap = new HashMap();
            hashMap.put(CommonNetImpl.AID, nVar.so());
            hashMap.put("cid", nVar.fs());
            hashMap.put("req_id", nVar.ej());
            hashMap.put("customer_id", uf.qv(nVar));
            com.bytedance.sdk.openadsdk.core.kt.xt.j(cw, kk, true, hashMap, j(nVar, str2, AMPSConstants.FrequencyEventType.FREQUENCY_EVENT_TYPE_CLICK));
        } else if (kk != null && kk.size() != 0 && AMPSConstants.FrequencyEventType.FREQUENCY_EVENT_TYPE_CLICK.equals(str)) {
            j(nVar, kk, str2, "no did", AMPSConstants.FrequencyEventType.FREQUENCY_EVENT_TYPE_CLICK);
        }
        if (str == AMPSConstants.FrequencyEventType.FREQUENCY_EVENT_TYPE_CLICK) {
            if (com.bytedance.sdk.openadsdk.core.video.cw.j.j(nVar)) {
                com.bytedance.sdk.openadsdk.core.video.cw.j.j(a.f54680b, nVar, 0L);
            }
            com.bytedance.sdk.openadsdk.core.live.xt.j().r(nVar);
        }
        v.j(1, 2);
        if (vl.cw()) {
            vl.j("AdEvent", str + " " + nVar.fs());
        }
    }

    public static void xt(final n nVar) {
        j(nVar, "landingpage", "open_url_h5", new com.bytedance.sdk.openadsdk.m.j.j() { // from class: com.bytedance.sdk.openadsdk.core.jy.cw.18
            @Override // com.bytedance.sdk.openadsdk.m.j.j
            public void j(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("render_type", "h5");
                jSONObject2.putOpt("render_type_2", 0);
                com.bytedance.sdk.openadsdk.up.j.j(jSONObject2, n.this);
                jSONObject.putOpt("ad_extra_data", jSONObject2);
            }
        });
    }

    public static void xt(final n nVar, String str, final int i6) {
        j(nVar, str, "qpon_apply", new com.bytedance.sdk.openadsdk.m.j.j() { // from class: com.bytedance.sdk.openadsdk.core.jy.cw.28
            @Override // com.bytedance.sdk.openadsdk.m.j.j
            public void j(JSONObject jSONObject) throws JSONException {
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("qpon_apply_status", i6);
                    com.bytedance.sdk.openadsdk.up.j.j(jSONObject2, nVar);
                    jSONObject.putOpt("ad_extra_data", jSONObject2.toString());
                } catch (Exception e6) {
                    vl.j(e6);
                }
            }
        });
    }

    public static void xt(n nVar, String str, final JSONObject jSONObject) {
        if (nVar == null || jSONObject == null) {
            return;
        }
        j(nVar, str, "cache_correct_details", new com.bytedance.sdk.openadsdk.m.j.j() { // from class: com.bytedance.sdk.openadsdk.core.jy.cw.29
            @Override // com.bytedance.sdk.openadsdk.m.j.j
            public void j(JSONObject jSONObject2) throws JSONException {
                jSONObject2.put("ad_extra_data", jSONObject.toString());
            }
        });
    }

    public static void xt(long j6, final n nVar) {
        if (nVar != null && n.xt(nVar)) {
            final long currentTimeMillis = j6 > 0 ? System.currentTimeMillis() - j6 : 0L;
            j(nVar, "splash_ad", "play_duration_sum", new com.bytedance.sdk.openadsdk.m.j.j() { // from class: com.bytedance.sdk.openadsdk.core.jy.cw.30
                @Override // com.bytedance.sdk.openadsdk.m.j.j
                public void j(JSONObject jSONObject) throws JSONException {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("skip_duration", currentTimeMillis);
                    com.bytedance.sdk.openadsdk.up.j.j(jSONObject2, nVar);
                    jSONObject.put("ad_extra_data", jSONObject2.toString());
                }
            });
        }
    }

    public static JSONObject j(n nVar, String str, String str2) {
        return j(nVar.os(), nVar.fs(), nVar.ej(), str, str2);
    }

    public static JSONObject j(String str, String str2, String str3, String str4, String str5) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(MediationConstant.EXTRA_LOG_EXTRA, str);
            jSONObject.put(MediationConstant.EXTRA_ADID, str2);
            jSONObject.put("req_id", str3);
            jSONObject.put(CommonNetImpl.TAG, str4);
            jSONObject.put("track_type", str5);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public static void j(final n nVar, String str, String str2, final long j6) {
        if (nVar == null) {
            return;
        }
        j(nVar, str, str2, new com.bytedance.sdk.openadsdk.m.j.j() { // from class: com.bytedance.sdk.openadsdk.core.jy.cw.3
            @Override // com.bytedance.sdk.openadsdk.m.j.j
            public void j(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("duration", j6);
                jSONObject2.put("rom_new_version", ch.az());
                jSONObject2.put("is_background", com.bytedance.sdk.openadsdk.core.oq.i().j());
                com.bytedance.sdk.openadsdk.up.j.j(jSONObject2, nVar);
                jSONObject.put("ad_extra_data", jSONObject2.toString());
            }
        });
    }

    public static void j(com.bytedance.sdk.openadsdk.core.dislike.cw.xt xtVar, com.bytedance.sdk.openadsdk.i.cw.xt.m mVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(mVar);
        com.bytedance.sdk.openadsdk.core.v.j().j(xtVar, arrayList);
        if (vl.cw()) {
            vl.j("AdEvent", "tt_dislike_icon " + xtVar.cw());
        }
    }

    public static void j(Context context, n nVar, String str, String str2, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str2) || nVar == null || jSONObject == null) {
            return;
        }
        Object opt = jSONObject.opt("value");
        if (opt == null) {
            opt = nVar.fs();
        }
        String optString = jSONObject.optString("category");
        if (TextUtils.isEmpty(optString)) {
            optString = "app_union";
        }
        Object opt2 = jSONObject.opt(MediationConstant.EXTRA_LOG_EXTRA);
        if (opt2 == null) {
            opt2 = nVar.os();
        }
        try {
            jSONObject.putOpt("nt", Integer.valueOf(ws.cw(context)));
            jSONObject.putOpt("scene_tag", "csj_sdk");
            jSONObject.putOpt(CommonNetImpl.TAG, "7.0.1.2");
            jSONObject.putOpt("subtag", str);
        } catch (Exception e6) {
            vl.cw(e6.getMessage());
        }
        String str3 = "";
        String obj = opt == null ? "" : opt.toString();
        if (opt2 != null) {
            str3 = opt2.toString();
        }
        new j.C0460j().up(obj).cw(optString).r(str3).j(str).j(jSONObject).xt(str2).j(new com.bytedance.sdk.openadsdk.m.j.j() { // from class: com.bytedance.sdk.openadsdk.core.jy.cw.4
            @Override // com.bytedance.sdk.openadsdk.m.j.j
            public void j(JSONObject jSONObject2) throws JSONException {
            }
        });
    }

    public static void j(final long j6, final n nVar) {
        if (nVar == null) {
            return;
        }
        j(nVar, "splash_ad", "skip", new com.bytedance.sdk.openadsdk.m.j.j() { // from class: com.bytedance.sdk.openadsdk.core.jy.cw.5
            @Override // com.bytedance.sdk.openadsdk.m.j.j
            public void j(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("skip_duration", j6);
                com.bytedance.sdk.openadsdk.up.j.j(jSONObject2, nVar);
                jSONObject.put("ad_extra_data", jSONObject2.toString());
            }
        });
    }

    public static void j(final n nVar, String str, final JSONObject jSONObject) {
        j(nVar, uf.xt(nVar), str, new com.bytedance.sdk.openadsdk.m.j.j() { // from class: com.bytedance.sdk.openadsdk.core.jy.cw.6
            @Override // com.bytedance.sdk.openadsdk.m.j.j
            public void j(JSONObject jSONObject2) throws JSONException {
                JSONObject jSONObject3 = jSONObject;
                if (jSONObject3 != null) {
                    com.bytedance.sdk.openadsdk.up.j.j(jSONObject3, nVar);
                    jSONObject2.put("ad_extra_data", jSONObject);
                }
            }
        });
    }

    public static void j(final n nVar, String str, String str2, final long j6, final int i6, final Map<String, Object> map) {
        j(nVar, str, str2, new com.bytedance.sdk.openadsdk.m.j.j() { // from class: com.bytedance.sdk.openadsdk.core.jy.cw.7
            @Override // com.bytedance.sdk.openadsdk.m.j.j
            public void j(JSONObject jSONObject) throws JSONException {
                jSONObject.put("duration", j6);
                jSONObject.put("percent", i6);
                if (map != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    for (Map.Entry entry : map.entrySet()) {
                        jSONObject2.put((String) entry.getKey(), entry.getValue());
                    }
                    com.bytedance.sdk.openadsdk.up.j.j(jSONObject2, nVar);
                    jSONObject.put("ad_extra_data", jSONObject2.toString());
                }
            }
        });
    }

    public static void j(final n nVar, String str, String str2, final long j6, final JSONObject jSONObject) {
        if (nVar == null || jSONObject == null) {
            return;
        }
        j(nVar, str, str2, new com.bytedance.sdk.openadsdk.m.j.j() { // from class: com.bytedance.sdk.openadsdk.core.jy.cw.8
            @Override // com.bytedance.sdk.openadsdk.m.j.j
            public void j(JSONObject jSONObject2) throws JSONException {
                jSONObject2.put("duration", j6);
                com.bytedance.sdk.openadsdk.up.j.j(jSONObject, nVar);
                jSONObject2.put("ad_extra_data", jSONObject.toString());
            }
        });
    }

    public static void j(String str, String str2, String str3, String str4) {
        new j.C0460j().j(str3).xt(str4).up(str).r(str2).j((com.bytedance.sdk.openadsdk.m.j.j) null);
        if (vl.cw()) {
            vl.j("AdEvent", "tag: " + str3 + "label: " + str4 + " " + str);
        }
    }

    public static void j(n nVar, String str, String str2, Throwable th) {
        xp al = nVar.al();
        JSONObject jSONObject = null;
        if (al != null) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("wc_type", al.up());
                } catch (Throwable unused) {
                }
                jSONObject = jSONObject2;
            } catch (Throwable unused2) {
            }
        }
        if (th != null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            try {
                jSONObject.put("throwable", th.getMessage());
            } catch (Exception unused3) {
            }
        }
        j(nVar, str, str2, jSONObject);
    }

    public static void j(n nVar, String str, String str2, String str3) {
        final JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(str3)) {
                jSONObject.put("refer", str3);
                com.bytedance.sdk.openadsdk.up.j.j(jSONObject, nVar);
            }
        } catch (Throwable unused) {
        }
        j(nVar, str, str2, new com.bytedance.sdk.openadsdk.m.j.j() { // from class: com.bytedance.sdk.openadsdk.core.jy.cw.14
            @Override // com.bytedance.sdk.openadsdk.m.j.j
            public void j(JSONObject jSONObject2) throws JSONException {
                jSONObject2.put("ad_extra_data", jSONObject);
            }
        });
    }

    public static void j(String str, final String str2, final String str3, long j6, long j7, JSONObject jSONObject) {
        final float floatValue = Double.valueOf((System.currentTimeMillis() / 1000) - uf.m(jSONObject.optString(MediationConstant.EXTRA_LOG_EXTRA))).floatValue();
        new j.C0460j().j(str2).xt(str3).cw(str).up(String.valueOf(j6)).m(String.valueOf(j7)).j(jSONObject).j(new com.bytedance.sdk.openadsdk.m.j.j() { // from class: com.bytedance.sdk.openadsdk.core.jy.cw.15
            @Override // com.bytedance.sdk.openadsdk.m.j.j
            public void j(JSONObject jSONObject2) throws JSONException {
                JSONObject jSONObject3 = new JSONObject();
                String optString = jSONObject2.optString("ad_extra_data", null);
                if (optString != null) {
                    jSONObject3 = new JSONObject(optString);
                }
                jSONObject3.put(ConstantHelper.LOG_DE, com.bytedance.sdk.openadsdk.core.cw.j.j(com.bytedance.sdk.openadsdk.core.v.getContext(), g.j(str2)).toString());
                jSONObject3.put("js_event", 1);
                jSONObject2.put("ad_extra_data", jSONObject3.toString());
                jSONObject2.put(CommonNetImpl.TAG, str2);
                if (AMPSConstants.FrequencyEventType.FREQUENCY_EVENT_TYPE_CLICK.equals(str3)) {
                    float f6 = floatValue;
                    if (f6 <= 0.0f) {
                        f6 = 0.0f;
                    }
                    jSONObject2.putOpt("show_time", Float.valueOf(f6));
                }
            }
        });
        if (vl.cw()) {
            vl.j("AdEvent", "sendJsAdEvent");
        }
    }

    public static void j(final long j6, String str, String str2) {
        n nVar;
        try {
            nVar = com.bytedance.sdk.openadsdk.core.j.j(new JSONObject(str2));
        } catch (Throwable unused) {
            nVar = null;
        }
        if (nVar == null) {
            return;
        }
        j(nVar, str, "open_appback", new com.bytedance.sdk.openadsdk.m.j.j() { // from class: com.bytedance.sdk.openadsdk.core.jy.cw.17
            @Override // com.bytedance.sdk.openadsdk.m.j.j
            public void j(JSONObject jSONObject) throws JSONException {
                jSONObject.put("duration", j6);
            }
        });
        com.bytedance.sdk.component.r.j.xt j7 = com.bytedance.sdk.openadsdk.core.xt.j();
        j7.j("save_jump_success_time", 0L);
        j7.j("save_jump_success_ad_tag", "");
    }

    public static void j(n nVar, String str, final int i6, final String str2) {
        j(nVar, str, "render_live_picture_fail", new com.bytedance.sdk.openadsdk.m.j.j() { // from class: com.bytedance.sdk.openadsdk.core.jy.cw.21
            @Override // com.bytedance.sdk.openadsdk.m.j.j
            public void j(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("error_code", Integer.valueOf(i6));
                jSONObject2.putOpt("error_message", str2);
                jSONObject.putOpt("ad_extra_data", jSONObject2.toString());
            }
        });
    }

    public static void j(n nVar, String str, final long j6, final String str2) {
        j(nVar, str, "live_play_success", new com.bytedance.sdk.openadsdk.m.j.j() { // from class: com.bytedance.sdk.openadsdk.core.jy.cw.23
            @Override // com.bytedance.sdk.openadsdk.m.j.j
            public void j(JSONObject jSONObject) throws JSONException {
                jSONObject.put("duration", j6);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("session_id", str2);
                jSONObject.putOpt("ad_extra_data", jSONObject2.toString());
            }
        });
    }

    public static void j(n nVar, String str, final int i6, final String str2, final String str3) {
        j(nVar, str, "live_play_fail", new com.bytedance.sdk.openadsdk.m.j.j() { // from class: com.bytedance.sdk.openadsdk.core.jy.cw.24
            @Override // com.bytedance.sdk.openadsdk.m.j.j
            public void j(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("error_code", Integer.valueOf(i6));
                jSONObject2.putOpt("error_message", str2);
                jSONObject2.putOpt("session_id", str3);
                jSONObject.putOpt("ad_extra_data", jSONObject2.toString());
            }
        });
    }

    public static void j(n nVar, String str, final long j6, final JSONObject jSONObject, final String str2) {
        j(nVar, str, "live_play_close", new com.bytedance.sdk.openadsdk.m.j.j() { // from class: com.bytedance.sdk.openadsdk.core.jy.cw.25
            @Override // com.bytedance.sdk.openadsdk.m.j.j
            public void j(JSONObject jSONObject2) throws JSONException {
                JSONObject jSONObject3 = jSONObject;
                if (jSONObject3 != null) {
                    jSONObject3.putOpt("session_id", str2);
                    jSONObject2.putOpt("ad_extra_data", jSONObject.toString());
                }
                jSONObject2.put("duration", j6);
            }
        });
    }

    public static void j(final n nVar, String str, final int i6, final int i7, final int i8, final boolean z5) {
        if (nVar != null && nVar.li() == 1) {
            j(nVar, str, "open_live", new com.bytedance.sdk.openadsdk.m.j.j() { // from class: com.bytedance.sdk.openadsdk.core.jy.cw.26
                @Override // com.bytedance.sdk.openadsdk.m.j.j
                public void j(JSONObject jSONObject) throws JSONException {
                    JSONObject jSONObject2 = new JSONObject();
                    int i9 = i8;
                    int ww = nVar.ww();
                    jSONObject2.put("live_interaction_type", ww);
                    jSONObject2.put("client_live_interaction_type", i6);
                    jSONObject2.put("real_live_interaction_type", i7);
                    jSONObject2.put("reward_live_type", hl.xt(nVar));
                    jSONObject2.put("is_inner", z5);
                    qb uw = nVar.uw();
                    if (uw != null) {
                        jSONObject2.putOpt("saas_info", uw.j());
                    }
                    i m111if = nVar.m111if();
                    if (m111if != null) {
                        String xt = m111if.xt();
                        if (xt.length() > 500) {
                            xt = xt.substring(0, 500);
                        }
                        jSONObject2.put("deep_link", xt);
                        if (!xt.startsWith("snssdk1128") && !xt.startsWith("snssdk2329") && ww == 1 && i9 != 0) {
                            i9 = 2;
                        }
                    }
                    jSONObject2.put("live_interaction_status", i9);
                    jSONObject.putOpt("ad_extra_data", jSONObject2.toString());
                }
            });
        }
    }

    public static void j(final n nVar, String str, final int i6) {
        j(nVar, str, "qpon_join", new com.bytedance.sdk.openadsdk.m.j.j() { // from class: com.bytedance.sdk.openadsdk.core.jy.cw.27
            @Override // com.bytedance.sdk.openadsdk.m.j.j
            public void j(JSONObject jSONObject) throws JSONException {
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("join_status", i6);
                    com.bytedance.sdk.openadsdk.up.j.j(jSONObject2, nVar);
                    jSONObject.putOpt("ad_extra_data", jSONObject2.toString());
                } catch (Exception e6) {
                    vl.j(e6);
                }
            }
        });
    }

    public static void j(final int i6, String str, final n nVar) {
        if (nVar == null) {
            return;
        }
        j(nVar, str, "saas_auth", new com.bytedance.sdk.openadsdk.m.j.j() { // from class: com.bytedance.sdk.openadsdk.core.jy.cw.31
            @Override // com.bytedance.sdk.openadsdk.m.j.j
            public void j(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("saas_auth_status", i6);
                qb uw = nVar.uw();
                if (uw != null) {
                    jSONObject2.put("saas_auth_type", uw.xt());
                }
                jSONObject.put("ad_extra_data", jSONObject2.toString());
            }
        });
    }

    public static void j(String str, n nVar) {
        if (nVar == null) {
            return;
        }
        j(nVar, str, "ec_mall_task", new com.bytedance.sdk.openadsdk.m.j.j() { // from class: com.bytedance.sdk.openadsdk.core.jy.cw.32
            @Override // com.bytedance.sdk.openadsdk.m.j.j
            public void j(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("mall_reward_callback", 1);
                jSONObject.put("ad_extra_data", jSONObject2.toString());
            }
        });
    }

    public static void j(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("isCanUseLocation", com.bytedance.sdk.openadsdk.core.oq.i().w().j());
            jSONObject2.put("isCanUsePhoneState", com.bytedance.sdk.openadsdk.core.oq.i().w().cw());
            jSONObject2.put("isCanUseWifiState", com.bytedance.sdk.openadsdk.core.oq.i().w().r());
            jSONObject2.put("isCanUseWriteExternal", com.bytedance.sdk.openadsdk.core.oq.i().w().up());
            jSONObject2.put("alist", com.bytedance.sdk.openadsdk.core.oq.i().w().xt());
            jSONObject2.put("isCanUseAndroidId", com.bytedance.sdk.openadsdk.core.oq.i().w().m());
            jSONObject2.put("isCanUsePermissionRecordAudio", com.bytedance.sdk.openadsdk.core.oq.i().w().ae());
            if (com.bytedance.sdk.openadsdk.core.oq.i().w().az() != null && !com.bytedance.sdk.openadsdk.core.oq.i().w().az().isEmpty()) {
                JSONObject jSONObject3 = new JSONObject();
                for (Map.Entry<String, Object> entry : com.bytedance.sdk.openadsdk.core.oq.i().w().az().entrySet()) {
                    jSONObject3.put(entry.getKey(), entry.getValue());
                }
                jSONObject2.put("update_privacyConfig", jSONObject3);
            }
            jSONObject.put("regulation_data", jSONObject2);
        } catch (JSONException unused) {
        }
    }
}
