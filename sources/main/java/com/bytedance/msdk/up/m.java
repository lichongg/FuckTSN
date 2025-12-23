package com.bytedance.msdk.up;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.mobads.sdk.api.SplashAd;
import com.baidu.mobads.sdk.internal.d;
import com.bytedance.msdk.tl.l;
import com.bytedance.msdk.tl.mi;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.huawei.hms.feature.dynamic.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class m {
    private static int cw;

    /* renamed from: j, reason: collision with root package name */
    private static int f25254j;
    private static int xt;

    public static void j(com.bytedance.msdk.xt.cw cwVar, com.bytedance.msdk.api.j.xt xtVar, int i6, String str, long j6, int i7, int i8, String str2) {
        com.bytedance.msdk.core.ws.cw xt2;
        com.bytedance.msdk.core.oq.xt j7;
        r xt3 = r.xt();
        xt3.j("media_reward_verify").j("adn_preload", Integer.valueOf((cwVar == null || !cwVar.nd()) ? 0 : 1)).j(MediationConstant.KEY_REASON, Integer.valueOf(i7)).j("play_again", Integer.valueOf(i6));
        if (i8 != 0 && i8 != 20000) {
            xt3.xt(i8).oq(str2);
        }
        HashMap hashMap = new HashMap();
        boolean z5 = j6 >= 0;
        if (cwVar != null && cwVar.dj()) {
            hashMap.put("custom_adn_sample_ratio", Double.valueOf(mi.cw()));
            hashMap.put("custom_adn_sample_ratio_result", Boolean.valueOf(z5));
            if (z5) {
                hashMap.put("custom_adn_rec_time", Long.valueOf(j6));
            }
        }
        if (xtVar != null && (xt2 = com.bytedance.msdk.core.xt.xt()) != null && (j7 = xt2.j(xtVar.v(), xtVar.f(), 101)) != null) {
            hashMap.put("reward_callback_type", Integer.valueOf(j7.nd()));
            hashMap.put("reward_start_time", Integer.valueOf(j7.n()));
        }
        if (str != null) {
            xt3.j("sub_adn_name", str);
        }
        j(xt3, xtVar, (com.bytedance.msdk.core.oq.oq) null, cwVar, hashMap);
        cw.j(com.bytedance.msdk.core.xt.getContext(), xt3, hashMap);
    }

    public static void xt(com.bytedance.msdk.xt.cw cwVar, com.bytedance.msdk.api.j.xt xtVar, int i6, String str, long j6, boolean z5) {
        xt(cwVar, xtVar, i6, str, j6, null, z5);
    }

    public static void xt(com.bytedance.msdk.xt.cw cwVar, com.bytedance.msdk.api.j.xt xtVar, int i6, String str, long j6, String str2, boolean z5) {
        r xt2 = r.xt();
        xt2.j("media_click_listen").j("adn_preload", Integer.valueOf((cwVar == null || !cwVar.nd()) ? 0 : 1)).j("play_again", Integer.valueOf(i6)).j("is_repeat", Integer.valueOf(z5 ? 1 : 0));
        if (str != null) {
            xt2.j("sub_adn_name", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            xt2.j("callstack_message", str2);
        }
        HashMap hashMap = new HashMap();
        boolean z6 = j6 >= 0;
        if (cwVar != null && cwVar.dj()) {
            hashMap.put("custom_adn_sample_ratio", Double.valueOf(mi.cw()));
            hashMap.put("custom_adn_sample_ratio_result", Boolean.valueOf(z6));
            if (z6) {
                hashMap.put("custom_adn_rec_time", Long.valueOf(j6));
            }
        }
        j(xt2, xtVar, (com.bytedance.msdk.core.oq.oq) null, cwVar, hashMap);
        cw.j(com.bytedance.msdk.core.xt.getContext(), xt2, hashMap);
    }

    public static void cw(com.bytedance.msdk.api.j.xt xtVar, int i6) {
        r xt2 = r.xt();
        xt2.j("mt_ra_c").xt(i6);
        HashMap hashMap = new HashMap();
        j(xt2, xtVar, (com.bytedance.msdk.core.oq.oq) null, (com.bytedance.msdk.xt.cw) null, hashMap);
        cw.j(com.bytedance.msdk.core.xt.getContext(), xt2, hashMap);
    }

    public static void xt(final com.bytedance.msdk.api.j.xt xtVar, final int i6) {
        final r cw2 = r.cw();
        com.bytedance.msdk.j.up.m.r(new Runnable() { // from class: com.bytedance.msdk.up.m.5
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.up.cw.j.j().j(r.this, xtVar, i6);
            }
        });
    }

    public static void j(com.bytedance.msdk.xt.cw cwVar, com.bytedance.msdk.api.j.xt xtVar, int i6, String str, long j6, boolean z5) {
        j(cwVar, xtVar, i6, str, j6, (String) null, z5);
    }

    public static void xt() {
        r xt2 = r.xt();
        xt2.j("start_up");
        cw.j(com.bytedance.msdk.core.xt.getContext(), xt2, (Map<String, Object>) null);
    }

    public static void j() {
        r xt2 = r.xt();
        xt2.j("mediation_sdk_init");
        HashMap hashMap = new HashMap();
        hashMap.put("call_init_time", Long.valueOf(com.bytedance.sdk.gromore.init.up.f27347j));
        hashMap.put("call_init_csj_start_time", Long.valueOf(com.bytedance.sdk.gromore.init.up.xt));
        hashMap.put("call_init_csj_end_time", Long.valueOf(com.bytedance.sdk.gromore.init.up.cw));
        hashMap.put("call_init_csj_duration", Long.valueOf(com.bytedance.sdk.gromore.init.up.xt - com.bytedance.sdk.gromore.init.up.f27347j));
        hashMap.put("init_csj_duration", Long.valueOf(com.bytedance.sdk.gromore.init.up.cw - com.bytedance.sdk.gromore.init.up.xt));
        hashMap.put("call_init_gromore_start_time", Long.valueOf(com.bytedance.sdk.gromore.init.up.f27349r));
        hashMap.put("call_init_gromore_end_time", Long.valueOf(com.bytedance.sdk.gromore.init.up.up));
        hashMap.put("call_init_gromore_duration", Long.valueOf(com.bytedance.sdk.gromore.init.up.f27349r - com.bytedance.sdk.gromore.init.up.f27347j));
        hashMap.put("init_gromore_duration", Long.valueOf(com.bytedance.sdk.gromore.init.up.up - com.bytedance.sdk.gromore.init.up.f27349r));
        hashMap.put("init_total_duration", Long.valueOf(com.bytedance.sdk.gromore.init.up.up - com.bytedance.sdk.gromore.init.up.f27347j));
        try {
            j(xt2, (com.bytedance.msdk.api.j.xt) null, (com.bytedance.msdk.core.oq.oq) null, (com.bytedance.msdk.xt.cw) null, hashMap);
            cw.j(com.bytedance.msdk.core.xt.getContext(), xt2, hashMap);
        } catch (Throwable th) {
            vl.j(th);
        }
    }

    public static void xt(long j6) {
        r xt2 = r.xt();
        xt2.j("sdk_backstage").j(j6);
        HashMap hashMap = new HashMap();
        if (com.bytedance.msdk.ae.xt.j.j().qv()) {
            if (com.bytedance.msdk.ae.xt.j.j().tl() > 0) {
                com.bytedance.msdk.ae.xt.j.j().j(j.cw);
                hashMap.put("call_init_method_duration", Long.valueOf(com.bytedance.msdk.ae.xt.j.j().tl()));
            }
        } else if (com.bytedance.msdk.ae.xt.j.j().vl()) {
            hashMap.put("call_init_method_duration", Long.valueOf(com.bytedance.msdk.ae.xt.j.j().tl()));
        }
        hashMap.put(b.f33222u, l.ae(b.f33222u));
        hashMap.put("v1", l.ae("v1"));
        hashMap.put("v2Enc_config", l.ae("v2Enc_config"));
        hashMap.put("v4Enc_config", l.ae("v4Enc_config"));
        hashMap.put("v2Enc_exchange", l.ae("v2Enc_exchange"));
        hashMap.put("v4Enc_exchange", l.ae("v4Enc_exchange"));
        hashMap.put("v2Enc_reward", l.ae("v2Enc_reward"));
        hashMap.put("v4Enc_reward", l.ae("v4Enc_reward"));
        hashMap.put("enable_label_return", Integer.valueOf(com.bytedance.msdk.core.xt.xt().uf() ? 1 : 0));
        hashMap.put("if_labelapi_call", Integer.valueOf(com.bytedance.msdk.core.j.qv().j() ? 1 : 0));
        hashMap.put("adn_init_duration", com.bytedance.msdk.m.xt.up.xt());
        com.bytedance.msdk.core.j.j.up.j(hashMap);
        JSONArray r5 = l.r();
        if (r5 != null) {
            r5.length();
            hashMap.put("sp_v3_bug", r5);
        }
        cw.j(com.bytedance.msdk.core.xt.getContext(), xt2, hashMap);
    }

    public static void j(com.bytedance.msdk.xt.cw cwVar, com.bytedance.msdk.api.j.xt xtVar, int i6, String str, long j6, String str2, boolean z5) {
        r xt2 = r.xt();
        xt2.j("media_show_listen").j("adn_preload", Integer.valueOf((cwVar == null || !cwVar.nd()) ? 0 : 1)).j("play_again", Integer.valueOf(i6)).j("is_repeat", Integer.valueOf(z5 ? 1 : 0));
        if (str != null) {
            xt2.j("sub_adn_name", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            xt2.j("callstack_message", str2);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("enable_label_return", Integer.valueOf(com.bytedance.msdk.core.xt.xt().uf() ? 1 : 0));
        hashMap.put("if_labelapi_call", Integer.valueOf(com.bytedance.msdk.core.j.qv().j() ? 1 : 0));
        com.bytedance.msdk.core.xt.cw.j(cwVar, xtVar, hashMap);
        boolean z6 = j6 >= 0;
        if (cwVar != null && cwVar.dj()) {
            hashMap.put("custom_adn_sample_ratio", Double.valueOf(mi.cw()));
            hashMap.put("custom_adn_sample_ratio_result", Boolean.valueOf(z6));
            if (z6) {
                hashMap.put("custom_adn_rec_time", Long.valueOf(j6));
            }
        }
        j(xt2, xtVar, (com.bytedance.msdk.core.oq.oq) null, cwVar, hashMap);
        cw.j(com.bytedance.msdk.core.xt.getContext(), xt2, hashMap);
    }

    public static void xt(com.bytedance.msdk.api.j.xt xtVar) {
        r xt2 = r.xt();
        xt2.j("mt_ra_cc");
        HashMap hashMap = new HashMap();
        j(xt2, xtVar, (com.bytedance.msdk.core.oq.oq) null, (com.bytedance.msdk.xt.cw) null, hashMap);
        cw.j(com.bytedance.msdk.core.xt.getContext(), xt2, hashMap);
    }

    public static void j(com.bytedance.msdk.xt.cw cwVar, com.bytedance.msdk.api.j.xt xtVar, String str) {
        r xt2 = r.xt();
        xt2.j("media_show_dislike").oq(str);
        HashMap hashMap = new HashMap();
        j(xt2, xtVar, (com.bytedance.msdk.core.oq.oq) null, cwVar, hashMap);
        cw.j(com.bytedance.msdk.core.xt.getContext(), xt2, hashMap);
    }

    public static void j(com.bytedance.msdk.xt.cw cwVar, com.bytedance.msdk.api.j.xt xtVar, boolean z5, int i6) {
        j(cwVar, xtVar, z5, i6, (Map<String, Object>) null);
    }

    public static void j(com.bytedance.msdk.xt.cw cwVar, com.bytedance.msdk.api.j.xt xtVar, boolean z5, int i6, Map<String, Object> map) {
        r xt2 = r.xt();
        xt2.j("media_show").j("adn_preload", Integer.valueOf((cwVar == null || !cwVar.nd()) ? 0 : 1)).j("play_again", Integer.valueOf(i6)).j("is_repeat", Integer.valueOf(z5 ? 1 : 0));
        HashMap hashMap = new HashMap();
        if (map != null && !map.isEmpty()) {
            hashMap.putAll(map);
        }
        j(xt2, xtVar, (com.bytedance.msdk.core.oq.oq) null, cwVar, hashMap);
        cw.j(com.bytedance.msdk.core.xt.getContext(), xt2, hashMap);
    }

    public static void j(List<com.bytedance.msdk.xt.cw> list, List<com.bytedance.msdk.xt.cw> list2, List<com.bytedance.msdk.xt.cw> list3, com.bytedance.msdk.api.j.xt xtVar, int i6) {
        boolean z5;
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            arrayList.addAll(list);
        }
        if (list2 != null && list2.size() > 0) {
            arrayList.addAll(list2);
        }
        if (list3 != null && list3.size() > 0) {
            arrayList.addAll(list3);
        }
        int i7 = 0;
        com.bytedance.msdk.xt.cw cwVar = arrayList.size() > 0 ? (com.bytedance.msdk.xt.cw) arrayList.get(0) : null;
        r xt2 = r.xt();
        xt2.j("media_show_is_ready");
        if (i6 == 0) {
            try {
                JSONArray jSONArray = new JSONArray();
                Iterator it = arrayList.iterator();
                loop0: while (true) {
                    z5 = false;
                    while (it.hasNext()) {
                        com.bytedance.msdk.xt.cw cwVar2 = (com.bytedance.msdk.xt.cw) it.next();
                        if (cwVar2 != null) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put(SplashAd.KEY_BIDFAIL_ADN, cwVar2.ff());
                            jSONObject.put("type", com.bytedance.msdk.xt.j.j(cwVar2.om(), cwVar2.rh()));
                            jSONObject.put("adnSlotId", cwVar2.qa());
                            jSONObject.put("loadSort", cwVar2.wi());
                            jSONObject.put("showSort", cwVar2.d());
                            if (xtVar != null) {
                                jSONObject.put("isReady", cwVar2.wq(xtVar.v()) ? 1 : 0);
                            }
                            jSONObject.put("hasShown", cwVar2.qb() ? 1 : 0);
                            if (cwVar2.lx()) {
                                jSONObject.put("is_video_cache_success", cwVar2.fp() ? 1 : 0);
                            }
                            jSONObject.put("mediationrit_req_type", cwVar2.tl(xtVar != null ? xtVar.j() : null));
                            jSONObject.put("mediationrit_req_type_src", cwVar2.g(xtVar != null ? xtVar.j() : null));
                            jSONArray.put(jSONObject);
                            if (!z5 && xtVar != null) {
                                if (xtVar.f() == 5) {
                                    z5 = cwVar2.wq(xtVar.v());
                                } else if (cwVar2.wq(xtVar.v()) && !cwVar2.qb()) {
                                    z5 = true;
                                }
                            }
                        }
                    }
                    break loop0;
                }
                if (!z5) {
                    i7 = -1;
                }
                xt2.xt(i7);
                xt2.oq(jSONArray.toString());
            } catch (JSONException e6) {
                vl.j(e6);
            }
        } else {
            xt2.xt(2);
            xt2.oq(com.bytedance.msdk.api.j.j(i6));
        }
        HashMap hashMap = new HashMap();
        j(xt2, xtVar, (com.bytedance.msdk.core.oq.oq) null, cwVar, hashMap);
        cw.j(com.bytedance.msdk.core.xt.getContext(), xt2, hashMap);
    }

    public static void j(List<com.bytedance.msdk.xt.cw> list, com.bytedance.msdk.api.j.xt xtVar, int i6) {
        com.bytedance.msdk.xt.cw cwVar = (list == null || list.size() <= 0) ? null : list.get(0);
        r xt2 = r.xt();
        xt2.j("media_show_fail");
        if (i6 == 0) {
            xt2.xt(40052);
            if (cwVar != null) {
                try {
                    JSONArray jSONArray = new JSONArray();
                    for (com.bytedance.msdk.xt.cw cwVar2 : list) {
                        if (cwVar2 != null) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put(SplashAd.KEY_BIDFAIL_ADN, cwVar2.ff());
                            jSONObject.put("type", com.bytedance.msdk.xt.j.j(cwVar2.om(), cwVar2.rh()));
                            jSONObject.put("adnSlotId", cwVar2.qa());
                            jSONObject.put("loadSort", cwVar2.wi());
                            jSONObject.put("showSort", cwVar2.d());
                            if (xtVar != null) {
                                jSONObject.put("isReady", cwVar2.wq(xtVar.v()) ? 1 : 0);
                            }
                            jSONObject.put("hasShown", cwVar2.qb() ? 1 : 0);
                            jSONArray.put(jSONObject);
                        }
                    }
                    xt2.oq(jSONArray.toString());
                } catch (JSONException e6) {
                    vl.j(e6);
                }
            }
        } else {
            xt2.xt(i6);
            xt2.oq(com.bytedance.msdk.api.j.j(i6));
        }
        HashMap hashMap = new HashMap();
        j(xt2, xtVar, (com.bytedance.msdk.core.oq.oq) null, cwVar, hashMap);
        xt2.j("is_video_cache_success", 0);
        cw.j(com.bytedance.msdk.core.xt.getContext(), xt2, hashMap);
    }

    public static void j(com.bytedance.msdk.api.j.xt xtVar, int i6) {
        r xt2 = r.xt();
        xt2.j("media_carousel_fail").xt(i6).oq(com.bytedance.msdk.api.j.j(i6));
        HashMap hashMap = new HashMap();
        j(xt2, xtVar, (com.bytedance.msdk.core.oq.oq) null, (com.bytedance.msdk.xt.cw) null, hashMap);
        xt2.j("is_video_cache_success", 0);
        cw.j(com.bytedance.msdk.core.xt.getContext(), xt2, hashMap);
    }

    public static void j(final int i6, final int i7, final long j6, final String str, final String str2) {
        final r cw2 = r.cw();
        com.bytedance.msdk.j.up.m.r(new Runnable() { // from class: com.bytedance.msdk.up.m.1
            @Override // java.lang.Runnable
            public void run() {
                r.this.j("rit_map_query").setResult(i7).j(j6).up(i6);
                HashMap hashMap = new HashMap();
                if (!TextUtils.isEmpty(str)) {
                    r.this.tl(str);
                    hashMap.put("origin_rit", str);
                }
                if (!TextUtils.isEmpty(str2)) {
                    r.this.xt(str2);
                    hashMap.put(MediationConstant.KEY_GM_PRIME_RIT, str2);
                }
                cw.j(com.bytedance.msdk.core.xt.getContext(), r.this, hashMap);
            }
        });
    }

    public static void j(final com.bytedance.msdk.core.oq.oq oqVar, final com.bytedance.msdk.api.j.xt xtVar, final String str, final boolean z5, final int i6, final int i7, final int i8, final int i9, final com.bytedance.msdk.api.j jVar, final long j6, final boolean z6, final boolean z7) {
        final r cw2 = r.cw();
        com.bytedance.msdk.j.up.m.r(new Runnable() { // from class: com.bytedance.msdk.up.m.12
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.up.cw.j.j().j(r.this, oqVar, xtVar, str, z5, i6, i7, i8, i9, jVar, j6, z6, z7, null);
            }
        });
    }

    public static void j(final com.bytedance.msdk.core.oq.oq oqVar, final com.bytedance.msdk.api.j.xt xtVar, final String str, final boolean z5, final int i6, final int i7, final int i8, final int i9, final com.bytedance.msdk.api.j jVar, final long j6, final boolean z6, final boolean z7, final String str2) {
        final r cw2 = r.cw();
        com.bytedance.msdk.j.up.m.r(new Runnable() { // from class: com.bytedance.msdk.up.m.16
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.up.cw.j.j().j(r.this, oqVar, xtVar, str, z5, i6, i7, i8, i9, jVar, j6, z6, z7, str2);
            }
        });
    }

    public static void j(com.bytedance.msdk.core.oq.oq oqVar, com.bytedance.msdk.api.j.xt xtVar, com.bytedance.msdk.xt.cw cwVar, int i6, String str) {
        r xt2 = r.xt();
        r j6 = xt2.j("bidding_info_invalid").xt(i6).oq(str).j("ad_count", Integer.valueOf(xtVar != null ? xtVar.a() : 0));
        com.bytedance.msdk.core.ws.xt.j(com.bytedance.msdk.core.xt.xt());
        j6.j("grouping_params", com.bytedance.msdk.core.ws.xt.xt()).j("log_source", 2);
        HashMap hashMap = new HashMap();
        j(xt2, xtVar, oqVar, cwVar, hashMap);
        cw.j(com.bytedance.msdk.core.xt.getContext(), xt2, hashMap);
    }

    public static void j(final com.bytedance.msdk.xt.cw cwVar, final int i6, final String str, final long j6, final com.bytedance.msdk.api.j.xt xtVar, final int i7, final int i8, final int i9, final String str2, final long j7, final long j8) {
        final r cw2 = r.cw();
        com.bytedance.msdk.j.up.m.r(new Runnable() { // from class: com.bytedance.msdk.up.m.17
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.up.cw.j.j().j(r.this, cwVar, i6, str, j6, xtVar, i7, i8, i9, str2, j7, j8);
            }
        });
    }

    public static void j(final com.bytedance.msdk.api.j jVar, final com.bytedance.msdk.api.j.xt xtVar, final com.bytedance.msdk.core.oq.oq oqVar, final int i6, final int i7, final int i8, final String str, final long j6, final String str2, final String str3, final String str4, final long j7) {
        final r cw2 = r.cw();
        com.bytedance.msdk.j.up.m.r(new Runnable() { // from class: com.bytedance.msdk.up.m.18
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.up.cw.j.j().j(r.this, jVar, xtVar, oqVar, i6, i7, i8, str, j6, str2, str3, str4, j7);
            }
        });
    }

    public static void j(com.bytedance.msdk.api.j jVar, com.bytedance.msdk.api.j.xt xtVar, com.bytedance.msdk.core.oq.oq oqVar, int i6, int i7, int i8, String str, long j6) {
        r xt2 = r.xt();
        xt2.j("bidding_adm_load_fail").j(j6).m(str).xt(jVar != null ? jVar.cw : -1).oq(jVar != null ? jVar.f24335r : "unknown error").j("adn_count", Integer.valueOf(i6)).j("adn_preload", 0).j("mediationrit_req_type", Integer.valueOf(i7)).j("mediationrit_req_type_src", Integer.valueOf(i8));
        if (jVar instanceof com.bytedance.msdk.api.xt.j) {
            xt2.ws = jVar.f24334j;
            xt2.qv = jVar.xt;
        }
        HashMap hashMap = new HashMap();
        j(xt2, xtVar, oqVar, (com.bytedance.msdk.xt.cw) null, hashMap);
        cw.j(com.bytedance.msdk.core.xt.getContext(), xt2, hashMap);
    }

    public static void j(@Nullable final com.bytedance.msdk.api.j.xt xtVar, final com.bytedance.msdk.api.j jVar, final String str) {
        final r cw2 = r.cw();
        com.bytedance.msdk.j.up.m.r(new Runnable() { // from class: com.bytedance.msdk.up.m.19
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.up.cw.j.j().j(r.this, xtVar, jVar, str);
            }
        });
    }

    public static void j(final com.bytedance.msdk.core.oq.oq oqVar, final com.bytedance.msdk.api.j.xt xtVar, final int i6, final int i7) {
        final r cw2 = r.cw();
        com.bytedance.msdk.j.up.m.r(new Runnable() { // from class: com.bytedance.msdk.up.m.20
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.up.cw.j.j().j(r.this, oqVar, xtVar, i6, i7);
            }
        });
    }

    public static void j(final com.bytedance.msdk.api.j.xt xtVar, final String str, final boolean z5, final String str2, final int i6, final Map<String, Object> map) {
        if (xtVar != null) {
            com.bytedance.sdk.gromore.xt.j.j().j(xtVar.j(), j.cw);
        }
        final r cw2 = r.cw();
        final long currentTimeMillis = System.currentTimeMillis();
        com.bytedance.msdk.j.up.m.r(new Runnable() { // from class: com.bytedance.msdk.up.m.21
            @Override // java.lang.Runnable
            public void run() {
                r.this.j(System.currentTimeMillis() - currentTimeMillis);
                com.bytedance.msdk.up.cw.j.j().j(r.this, xtVar, str, z5, str2, i6, map);
            }
        });
    }

    public static void j(Map<String, Object> map, final com.bytedance.msdk.api.j.xt xtVar, final com.bytedance.msdk.xt.cw cwVar, final long j6, final int i6, final int i7, final int i8, final String str, final int i9, final int i10, final com.bytedance.msdk.core.oq.xt xtVar2) {
        JSONObject jSONObject;
        int i11;
        final r cw2 = r.cw();
        if (map != null) {
            int intValue = map.get("group_type") instanceof Integer ? ((Integer) map.get("group_type")).intValue() : 0;
            double doubleValue = map.get("ecpm") instanceof Double ? ((Double) map.get("ecpm")).doubleValue() : 0.0d;
            jSONObject = new JSONObject();
            try {
                jSONObject.put("price_from", map.get("price_from"));
                jSONObject.put("grout_type", intValue);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("target_ecpm_origin", doubleValue);
                jSONObject2.put("target_ecpm_upper", map.get("upper_cpm_x"));
                jSONObject.put("price", jSONObject2);
                if (map.get("price_source") != null) {
                    jSONObject.put("price_source", map.get("price_source"));
                }
                int intValue2 = map.get("rule_in_use") instanceof Integer ? ((Integer) map.get("rule_in_use")).intValue() : 0;
                boolean booleanValue = map.get("has_serverBidding") instanceof Boolean ? ((Boolean) map.get("has_serverBidding")).booleanValue() : false;
                if (intValue != 3 && intValue != 4) {
                    i11 = 0;
                } else if (!booleanValue) {
                    i11 = 1;
                } else if (doubleValue == 0.0d) {
                    i11 = 2;
                } else if (intValue2 == 0) {
                    i11 = 5;
                } else {
                    i11 = (intValue != 4 || (map.get("serverBidding_timeout") instanceof Boolean ? ((Boolean) map.get("serverBidding_timeout")).booleanValue() : false)) ? 4 : 3;
                }
                jSONObject.put("pos_state", i11);
                jSONObject.put("rule_id", map.get("rule_id"));
                jSONObject.put("rule_inuse", intValue2);
            } catch (JSONException unused) {
            }
        } else {
            jSONObject = null;
        }
        final JSONObject jSONObject3 = jSONObject;
        com.bytedance.msdk.j.up.m.r(new Runnable() { // from class: com.bytedance.msdk.up.m.22
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.up.cw.j.j().j(r.this, xtVar, cwVar, j6, i6, i7, i8, str, i9, i10, xtVar2, jSONObject3);
            }
        });
    }

    public static void j(final com.bytedance.msdk.api.j.xt xtVar, final com.bytedance.msdk.xt.cw cwVar, final long j6) {
        final r cw2 = r.cw();
        com.bytedance.msdk.j.up.m.r(new Runnable() { // from class: com.bytedance.msdk.up.m.2
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.up.cw.j.j().j(r.this, xtVar, cwVar, j6);
            }
        });
    }

    public static void j(final com.bytedance.msdk.api.j.xt xtVar, final com.bytedance.msdk.xt.cw cwVar, final com.bytedance.msdk.core.oq.oq oqVar) {
        final r cw2 = r.cw();
        com.bytedance.msdk.j.up.m.r(new Runnable() { // from class: com.bytedance.msdk.up.m.3
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.up.cw.j.j().j(r.this, xtVar, cwVar, oqVar);
            }
        });
    }

    public static void j(final com.bytedance.msdk.xt.cw cwVar, final com.bytedance.msdk.api.j.xt xtVar, final com.bytedance.msdk.core.oq.xt xtVar2, final long j6, final String str, final boolean z5, final int i6, final boolean z6, final boolean z7) {
        final r cw2 = r.cw();
        com.bytedance.msdk.j.up.m.r(new Runnable() { // from class: com.bytedance.msdk.up.m.4
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.up.cw.j.j().j(r.this, cwVar, xtVar, xtVar2, j6, str, z5, i6, z6, z7);
            }
        });
    }

    public static void j(final boolean z5) {
        final r cw2 = r.cw();
        com.bytedance.msdk.j.up.m.r(new Runnable() { // from class: com.bytedance.msdk.up.m.6
            @Override // java.lang.Runnable
            public void run() {
                int i6;
                boolean up = com.bytedance.msdk.ae.j.j().up("is_config_from_assert");
                if (z5) {
                    if (up) {
                        i6 = 2;
                    } else {
                        i6 = 1;
                    }
                } else {
                    i6 = 0;
                }
                cw2.j("get_config_start").j(MediationConstant.KEY_REASON, Integer.valueOf(i6));
                cw.j(com.bytedance.msdk.core.xt.getContext(), cw2, (Map<String, Object>) null);
            }
        });
    }

    public static void j(long j6) {
        String str;
        r xt2 = r.xt();
        xt2.j("sdk_init").cw(j6);
        l m6 = com.bytedance.msdk.ae.j.m();
        boolean up = m6.up("check_unity3d");
        long r5 = m6.r("check_unity3d_time");
        long currentTimeMillis = System.currentTimeMillis();
        if (up && currentTimeMillis - r5 > 2592000000L) {
            try {
                Class.forName("com.unity3d.player.UnityPlayer");
                str = "unity_pure";
                try {
                    Class.forName("com.bytedance.android.NativeAdManager");
                    str = MediationConstant.ADN_UNITY;
                } catch (Throwable unused) {
                }
            } catch (Throwable unused2) {
                str = null;
            }
            if (str != null) {
                xt2.j("develop_type", str);
            }
            m6.j("check_unity3d", true);
            m6.j("check_unity3d_time", currentTimeMillis);
        }
        HashMap hashMap = new HashMap();
        int r6 = com.bytedance.msdk.ae.xt.j.j().r();
        if (r6 > 0) {
            com.bytedance.msdk.ae.xt.j.j().up();
            hashMap.put("discard_num", Integer.valueOf(r6));
        }
        hashMap.put("csj_plugin_version", com.bytedance.msdk.m.cw.cw());
        JSONObject up2 = l.up();
        if (up2 != null) {
            hashMap.put(d.f10985a, up2);
        }
        l.j(hashMap);
        l.xt(hashMap);
        cw.j(com.bytedance.msdk.core.xt.getContext(), xt2, hashMap);
    }

    public static void j(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        final r cw2 = r.cw();
        com.bytedance.msdk.j.up.m.r(new Runnable() { // from class: com.bytedance.msdk.up.m.7
            @Override // java.lang.Runnable
            public void run() {
                r.this.j("callstack_dynamic");
                r.this.j("callstack_message", str);
                r.this.j("callstack_report_time", 1);
                cw.j(com.bytedance.msdk.core.xt.getContext(), r.this, (Map<String, Object>) null);
            }
        });
    }

    public static void j(final com.bytedance.msdk.xt.cw cwVar, final com.bytedance.msdk.api.j.xt xtVar, final String str, final int i6) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        final r cw2 = r.cw();
        com.bytedance.msdk.j.up.m.r(new Runnable() { // from class: com.bytedance.msdk.up.m.8
            @Override // java.lang.Runnable
            public void run() {
                r.this.j("callstack_static").j("callstack_message", str).j("callstack_report_time", Integer.valueOf(i6));
                HashMap hashMap = new HashMap();
                m.j(r.this, xtVar, (com.bytedance.msdk.core.oq.oq) null, cwVar, hashMap);
                cw.j(com.bytedance.msdk.core.xt.getContext(), r.this, hashMap);
            }
        });
    }

    public static void j(long j6, int i6, int i7, long j7, JSONObject jSONObject, Map<String, Object> map) {
        r xt2 = r.xt();
        xt2.j("sdk_init_end");
        xt2.j(j6);
        xt2.cw(j7);
        xt2.j("adn_count", Integer.valueOf(i6));
        HashMap hashMap = new HashMap();
        if (map != null && map.size() > 0) {
            hashMap.putAll(map);
        }
        hashMap.put("is_from_local_config", Integer.valueOf(i7));
        hashMap.put("adapter_version_list", com.bytedance.msdk.tl.ae.j());
        if (jSONObject != null) {
            hashMap.put("local_init_time", jSONObject);
        }
        cw.j(com.bytedance.msdk.core.xt.getContext(), xt2, hashMap);
    }

    public static void j(int i6, int i7, long j6, boolean z5, boolean z6, JSONObject jSONObject, long j7, JSONObject jSONObject2) {
        r xt2 = r.xt();
        boolean up = com.bytedance.msdk.ae.j.j().up("is_config_from_assert");
        if (i6 != 1) {
            i6 = (z5 || (i6 == 0 && up)) ? 2 : 0;
        }
        xt2.setResult(i6).j(j6).j("get_config_final").m(i7).xt(i7).j("transparent_params", com.bytedance.msdk.core.xt.xt().g());
        HashMap hashMap = new HashMap();
        com.bytedance.msdk.core.g.r.j(z6, xt2, jSONObject, hashMap);
        if (jSONObject2 != null) {
            hashMap.put("cfg_handle_time", jSONObject2);
        }
        hashMap.put("config_size", Long.valueOf(j7));
        cw.j(com.bytedance.msdk.core.xt.getContext(), xt2, hashMap);
    }

    public static void j(final com.bytedance.msdk.api.j.xt xtVar, final JSONObject jSONObject) {
        final r cw2 = r.cw();
        com.bytedance.msdk.j.up.m.r(new Runnable() { // from class: com.bytedance.msdk.up.m.9
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.up.cw.j.j().j(r.this, xtVar, jSONObject);
            }
        });
    }

    public static void j(final com.bytedance.msdk.api.j.xt xtVar, final com.bytedance.msdk.core.r.xt xtVar2, final int i6) {
        final r cw2 = r.cw();
        com.bytedance.msdk.j.up.m.r(new Runnable() { // from class: com.bytedance.msdk.up.m.10
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.up.cw.j.j().j(r.this, xtVar, xtVar2, i6);
            }
        });
    }

    public static void j(final com.bytedance.msdk.xt.cw cwVar, final com.bytedance.msdk.api.j.xt xtVar, final List<com.bytedance.msdk.xt.cw> list, final List<com.bytedance.msdk.xt.cw> list2) {
        final r cw2 = r.cw();
        com.bytedance.msdk.j.up.m.r(new Runnable() { // from class: com.bytedance.msdk.up.m.11
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.up.cw.j.j().j(r.this, cwVar, xtVar, list, list2);
            }
        });
    }

    public static void j(final com.bytedance.msdk.core.oq.oq oqVar, final com.bytedance.msdk.api.j.xt xtVar, final String str) {
        final r cw2 = r.cw();
        com.bytedance.msdk.j.up.m.r(new Runnable() { // from class: com.bytedance.msdk.up.m.13
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.up.cw.j.j().j(r.this, oqVar, xtVar, str);
            }
        });
    }

    public static void j(final com.bytedance.msdk.xt.cw cwVar, final com.bytedance.msdk.api.j.xt xtVar, final com.bytedance.msdk.core.oq.oq oqVar, final long j6) {
        final r cw2 = r.cw();
        com.bytedance.msdk.j.up.m.r(new Runnable() { // from class: com.bytedance.msdk.up.m.14
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.up.cw.j.j().j(r.this, cwVar, xtVar, oqVar, j6);
            }
        });
    }

    public static void j(final com.bytedance.msdk.xt.cw cwVar, final com.bytedance.msdk.api.j.xt xtVar, final com.bytedance.msdk.core.oq.oq oqVar) {
        final r cw2 = r.cw();
        com.bytedance.msdk.j.up.m.r(new Runnable() { // from class: com.bytedance.msdk.up.m.15
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.up.cw.j.j().j(r.this, cwVar, xtVar, oqVar);
            }
        });
    }

    public static void j(com.bytedance.msdk.api.j.xt xtVar, String str) {
        r xt2 = r.xt();
        xt2.j("cache_cannot_use").j("cache_invalid_info", str);
        HashMap hashMap = new HashMap();
        j(xt2, xtVar, (com.bytedance.msdk.core.oq.oq) null, (com.bytedance.msdk.xt.cw) null, hashMap);
        cw.j(com.bytedance.msdk.core.xt.getContext(), xt2, hashMap);
    }

    public static void j(com.bytedance.msdk.api.j.xt xtVar, com.bytedance.msdk.xt.cw cwVar, String str) {
        r xt2 = r.xt();
        xt2.j("rit_cache_cannot_use").j("cache_invalid_info", str);
        HashMap hashMap = new HashMap();
        j(xt2, xtVar, (com.bytedance.msdk.core.oq.oq) null, cwVar, hashMap);
        xt2.j("mediationrit_req_type", 2);
        cw.j(com.bytedance.msdk.core.xt.getContext(), xt2, hashMap);
    }

    public static void j(com.bytedance.msdk.api.j.xt xtVar) {
        r xt2 = r.xt();
        xt2.j("media_will_show");
        HashMap hashMap = new HashMap();
        j(xt2, xtVar, (com.bytedance.msdk.core.oq.oq) null, (com.bytedance.msdk.xt.cw) null, hashMap);
        cw.j(com.bytedance.msdk.core.xt.getContext(), xt2, hashMap);
    }

    public static void j(com.bytedance.msdk.xt.cw cwVar, com.bytedance.msdk.api.j.xt xtVar, com.bytedance.msdk.api.j jVar, int i6, int i7, String str, long j6) {
        j(cwVar, xtVar, jVar, i6, i7, str, j6, (String) null);
    }

    public static void j(com.bytedance.msdk.xt.cw cwVar, com.bytedance.msdk.api.j.xt xtVar, com.bytedance.msdk.api.j jVar, int i6, int i7, String str, long j6, String str2) {
        r xt2 = r.xt();
        xt2.setResult(i6).xt(jVar != null ? jVar.cw : 0).oq(jVar != null ? jVar.f24335r : null).j("media_show_fail_listen").j("play_again", Integer.valueOf(i7));
        if (str != null) {
            xt2.j("sub_adn_name", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            xt2.j("callstack_message", str2);
        }
        HashMap hashMap = new HashMap();
        boolean z5 = j6 >= 0;
        if (cwVar != null && cwVar.dj()) {
            hashMap.put("custom_adn_sample_ratio", Double.valueOf(mi.cw()));
            hashMap.put("custom_adn_sample_ratio_result", Boolean.valueOf(z5));
            if (z5) {
                hashMap.put("custom_adn_rec_time", Long.valueOf(j6));
            }
        }
        j(xt2, xtVar, (com.bytedance.msdk.core.oq.oq) null, cwVar, hashMap);
        cw.j(com.bytedance.msdk.core.xt.getContext(), xt2, hashMap);
    }

    public static void j(com.bytedance.msdk.xt.cw cwVar, com.bytedance.msdk.api.j.xt xtVar, int i6, int i7, int i8, String str) {
        r xt2 = r.xt();
        xt2.setResult(i7).j("media_show_after").j("play_again", Integer.valueOf(i8)).j(MediationConstant.KEY_REASON, Integer.valueOf(i6));
        if (!TextUtils.isEmpty(str)) {
            xt2.j("callstack_message", str);
        }
        HashMap hashMap = new HashMap();
        j(xt2, xtVar, (com.bytedance.msdk.core.oq.oq) null, cwVar, hashMap);
        cw.j(com.bytedance.msdk.core.xt.getContext(), xt2, hashMap);
    }

    public static void j(String str, com.bytedance.msdk.xt.cw cwVar, com.bytedance.msdk.api.j.xt xtVar, com.bytedance.msdk.core.oq.oq oqVar, com.bytedance.msdk.api.j jVar) {
        r xt2 = r.xt();
        r oq = xt2.xt(jVar != null ? jVar.f24334j : 0).oq(jVar != null ? jVar.xt : null);
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        oq.up(str).j("custom_adn_init_fail");
        HashMap hashMap = new HashMap();
        j(xt2, xtVar, oqVar, cwVar, hashMap);
        cw.j(com.bytedance.msdk.core.xt.getContext(), xt2, hashMap);
    }

    public static void j(com.bytedance.msdk.api.j.xt xtVar, int i6, int i7) {
        r xt2 = r.xt();
        xt2.j("mt_ra_s").xt(i6);
        HashMap hashMap = new HashMap();
        hashMap.put("pre_req", Integer.valueOf(i7));
        j(xt2, xtVar, (com.bytedance.msdk.core.oq.oq) null, (com.bytedance.msdk.xt.cw) null, hashMap);
        cw.j(com.bytedance.msdk.core.xt.getContext(), xt2, hashMap);
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x0413  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x049b  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x04f0  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0503  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0258  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x03ed  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void j(com.bytedance.msdk.up.r r16, com.bytedance.msdk.api.j.xt r17, com.bytedance.msdk.core.oq.oq r18, com.bytedance.msdk.xt.cw r19, java.util.Map<java.lang.String, java.lang.Object> r20) {
        /*
            Method dump skipped, instructions count: 1298
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.up.m.j(com.bytedance.msdk.up.r, com.bytedance.msdk.api.j.xt, com.bytedance.msdk.core.oq.oq, com.bytedance.msdk.xt.cw, java.util.Map):void");
    }
}
