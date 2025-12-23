package com.bytedance.msdk.up.cw;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.bytedance.msdk.api.j.xt;
import com.bytedance.msdk.core.oq.oq;
import com.bytedance.msdk.m.cw;
import com.bytedance.msdk.tl.mi;
import com.bytedance.msdk.tl.p;
import com.bytedance.msdk.up.m;
import com.bytedance.msdk.up.r;
import com.bytedance.msdk.up.tl;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.umeng.analytics.pro.bi;
import com.umeng.analytics.pro.d;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class j {

    /* renamed from: j, reason: collision with root package name */
    private static volatile j f25244j;

    public static j j() {
        if (f25244j == null) {
            synchronized (j.class) {
                try {
                    if (f25244j == null) {
                        f25244j = new j();
                    }
                } finally {
                }
            }
        }
        return f25244j;
    }

    private static void xt(r rVar) {
        rVar.j("block_pacing", "-1");
        rVar.j("rit_adn_show_rule_id", "-1");
        rVar.j("block_show_count", "-1");
    }

    public void j(r rVar, xt xtVar, String str, boolean z5, String str2, int i6, Map<String, Object> map) {
        String str3;
        if (i6 > 0) {
            str3 = com.bytedance.msdk.api.j.j(i6);
        } else {
            str3 = "";
            i6 = 0;
        }
        rVar.j("mediation_request").j("server_bidding_extra", str2).j("mediation_req_type", Integer.valueOf(i6 != 0 ? z5 ? 2 : 3 : !z5 ? 1 : 0)).j("ad_count", Integer.valueOf(xtVar != null ? xtVar.a() : 0)).xt(i6).oq(str3);
        HashMap hashMap = new HashMap();
        if (map != null && map.size() > 0) {
            hashMap.putAll(map);
        }
        if (xtVar != null && xtVar.cw() == 5) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("parallel_num", com.bytedance.msdk.core.up.xt.r.j().cw());
                jSONObject.put(bi.aX, com.bytedance.msdk.core.up.xt.r.j().r());
                jSONObject.put("primerit_list", com.bytedance.msdk.core.up.xt.r.j().xt());
                hashMap.put("preload_info", jSONObject);
            } catch (JSONException e6) {
                vl.j(e6);
            }
        }
        if (xtVar != null && xtVar.f() == 3) {
            if (com.bytedance.msdk.ae.xt.j.j().qv()) {
                hashMap.put("init_splash_request_duration", Long.valueOf(com.bytedance.msdk.ae.xt.j.j().g()));
            } else if (com.bytedance.msdk.ae.xt.j.j().vl()) {
                hashMap.put("init_splash_request_duration", Long.valueOf(com.bytedance.msdk.ae.xt.j.j().g()));
            }
        }
        hashMap.put("csj_plugin_version", cw.cw());
        m.j(rVar, xtVar, (oq) null, (com.bytedance.msdk.xt.cw) null, hashMap);
        com.bytedance.msdk.up.cw.j(com.bytedance.msdk.core.xt.getContext(), rVar, hashMap);
    }

    public void j(r rVar, com.bytedance.msdk.xt.cw cwVar, xt xtVar, com.bytedance.msdk.core.oq.xt xtVar2, long j6, String str, boolean z5, int i6, boolean z6, boolean z7) {
        rVar.j("mediation_fill").j(j6).j("server_bidding_extra", str).j("mediation_req_type", Integer.valueOf(!z5 ? 1 : 0)).j("ad_count", Integer.valueOf(i6)).xt(0).oq("");
        HashMap hashMap = new HashMap();
        if (xtVar != null && xtVar.f() == 3) {
            if (com.bytedance.msdk.ae.xt.j.j().qv()) {
                com.bytedance.msdk.ae.xt.j.j().j(com.bytedance.msdk.up.j.cw);
                hashMap.put("init_splash_fill_duration", Long.valueOf(com.bytedance.msdk.ae.xt.j.j().oq()));
            } else if (com.bytedance.msdk.ae.xt.j.j().vl()) {
                hashMap.put("init_splash_fill_duration", Long.valueOf(com.bytedance.msdk.ae.xt.j.j().oq()));
            }
        }
        m.j(rVar, xtVar, (oq) null, cwVar, hashMap);
        hashMap.put("timeout_req", Integer.valueOf(z6 ? 1 : 0));
        hashMap.put("is_callback", Integer.valueOf(z7 ? 1 : 0));
        com.bytedance.msdk.up.cw.j(com.bytedance.msdk.core.xt.getContext(), rVar, hashMap);
    }

    public void j(r rVar, xt xtVar, com.bytedance.msdk.xt.cw cwVar, long j6, int i6, int i7, int i8, String str, int i9, int i10, com.bytedance.msdk.core.oq.xt xtVar2, JSONObject jSONObject) {
        JSONObject oq;
        rVar.j("mediation_request_end").j(j6).j("ad_count", Integer.valueOf(i9)).j(MediationConstant.KEY_REASON, Integer.valueOf(i10)).xt(i8);
        HashMap hashMap = new HashMap();
        m.j(rVar, xtVar, (oq) null, cwVar, hashMap);
        hashMap.put("requested_adn_count", Integer.valueOf(i6));
        hashMap.put("requested_level_count", Integer.valueOf(i7));
        if (jSONObject != null) {
            hashMap.put("auto_detail", jSONObject);
        }
        if (xtVar2 != null) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("layer_time_rate", String.format(Locale.getDefault(), "%.2f", Double.valueOf(xtVar2.xt())));
                jSONObject2.putOpt("req_interval", Long.valueOf(xtVar2.r()));
                jSONObject2.putOpt("total_time_rate", String.format(Locale.getDefault(), "%.2f", Double.valueOf(xtVar2.cw())));
                hashMap.put("preload_req", jSONObject2);
            } catch (Throwable th) {
                vl.j(th);
            }
        }
        if (xtVar != null && (oq = xtVar.oq()) != null) {
            hashMap.put("behavior", oq);
        }
        com.bytedance.msdk.up.cw.j(com.bytedance.msdk.core.xt.getContext(), rVar, hashMap);
    }

    public void j(r rVar, @Nullable xt xtVar, com.bytedance.msdk.api.j jVar, String str) {
        JSONObject oq;
        rVar.j("total_load_fail").j("server_bidding_extra", str);
        int i6 = jVar.f24334j;
        if (i6 == 10003) {
            rVar.xt(10010).oq("延长瀑布流总超时时长或者缩短层超时并添加兜底代码位");
            j(rVar);
        } else if (i6 == 810085) {
            rVar.xt(i6).oq(jVar.xt);
            j(rVar);
        } else if (jVar instanceof com.bytedance.msdk.api.xt.cw) {
            com.bytedance.msdk.api.xt.cw cwVar = (com.bytedance.msdk.api.xt.cw) jVar;
            rVar.xt(i6).oq(jVar.xt);
            rVar.j("block_pacing", cwVar.j());
            rVar.j("waterfall_show_rule_id", cwVar.xt());
        } else if (jVar instanceof com.bytedance.msdk.api.xt.xt) {
            com.bytedance.msdk.api.xt.xt xtVar2 = (com.bytedance.msdk.api.xt.xt) jVar;
            rVar.xt(i6).oq(jVar.xt);
            rVar.j("block_show_count", xtVar2.j());
            rVar.j("waterfall_show_rule_id", xtVar2.xt());
        } else if (jVar instanceof com.bytedance.msdk.api.xt.j) {
            rVar.xt(i6).oq(jVar.xt);
            j(rVar);
        } else {
            rVar.xt(10086).oq("Ad load fail all loadsorts! ");
            j(rVar);
        }
        HashMap hashMap = new HashMap();
        if (xtVar != null && (oq = xtVar.oq()) != null) {
            hashMap.put("behavior", oq);
        }
        rVar.j("ad_count", Integer.valueOf(xtVar != null ? xtVar.a() : 0));
        m.j(rVar, xtVar, (oq) null, (com.bytedance.msdk.xt.cw) null, hashMap);
        com.bytedance.msdk.up.cw.j(com.bytedance.msdk.core.xt.getContext(), rVar, hashMap);
    }

    public void j(r rVar, oq oqVar, xt xtVar, String str, boolean z5, int i6, int i7, int i8, int i9, com.bytedance.msdk.api.j jVar, long j6, boolean z6, boolean z7, String str2) {
        int j7;
        if ((jVar instanceof com.bytedance.msdk.api.xt.cw) || (jVar instanceof com.bytedance.msdk.api.xt.xt) || (jVar instanceof com.bytedance.msdk.api.xt.j)) {
            rVar.xt(jVar.f24334j).oq(jVar.xt);
        }
        rVar.j("media_request").m(str).j("ad_count", Integer.valueOf(xtVar != null ? xtVar.a() : 0)).j("adn_count", Integer.valueOf(i7)).j("mediationrit_req_type", Integer.valueOf(i8)).j("mediationrit_req_type_src", Integer.valueOf(i9)).j("mediation_req_type", Integer.valueOf(!z5 ? 1 : 0)).j("media_req_type", Integer.valueOf(i6));
        HashMap hashMap = new HashMap();
        hashMap.put("timeout_req", Integer.valueOf(z6 ? 1 : 0));
        hashMap.put("is_callback", Integer.valueOf(z7 ? 1 : 0));
        if (xtVar != null && xtVar.sm() && !TextUtils.isEmpty(str2)) {
            hashMap.put("origin_link_id", str2);
        }
        if (xtVar != null && xtVar.n() != null && oqVar != null && MediationConstant.ADN_PANGLE.equals(oqVar.az()) && oqVar.jy() == 5 && (j7 = xtVar.n().j()) == 1) {
            hashMap.put("support_render_control", Integer.valueOf(j7));
        }
        if (j6 != -1) {
            hashMap.put(d.f41197p, Long.valueOf(SystemClock.elapsedRealtime() - j6));
        }
        m.j(rVar, xtVar, oqVar, (com.bytedance.msdk.xt.cw) null, hashMap);
        com.bytedance.msdk.up.cw.j(com.bytedance.msdk.core.xt.getContext(), rVar, hashMap);
    }

    public void j(r rVar, com.bytedance.msdk.xt.cw cwVar, int i6, String str, long j6, xt xtVar, int i7, int i8, int i9, String str2, long j7, long j8) {
        rVar.j("media_fill").j(j6).xt(i6).oq(str).j("adn_count", Integer.valueOf(i7)).j("adn_preload", Integer.valueOf((cwVar == null || !cwVar.nd()) ? 0 : 1)).j("ad_count", Integer.valueOf(i8));
        rVar.j("fill_type", Integer.valueOf(i9));
        if (str2 != null) {
            rVar.j("sub_adn_name", str2);
        }
        HashMap hashMap = new HashMap();
        boolean z5 = j7 >= 0;
        if (cwVar != null && cwVar.dj()) {
            hashMap.put("custom_adn_sample_ratio", Double.valueOf(mi.cw()));
            hashMap.put("custom_adn_sample_ratio_result", Boolean.valueOf(z5));
            if (z5) {
                hashMap.put("custom_adn_rec_time", Long.valueOf(j7));
            }
        }
        if (j8 != -1) {
            hashMap.put(d.f41198q, Long.valueOf(j8));
        }
        if (cwVar != null && MediationConstant.ADN_PANGLE.equals(cwVar.ff()) && cwVar.om() == 5 && cwVar.ch() == 1) {
            hashMap.put("if_to_express", Integer.valueOf(cwVar.ch()));
        }
        if (com.bytedance.msdk.core.xt.xt().hh() && cwVar != null && 5 == cwVar.om()) {
            rVar.j("ex_info", tl.j().j(cwVar));
        }
        m.j(rVar, xtVar, (oq) null, cwVar, hashMap);
        com.bytedance.msdk.up.cw.j(com.bytedance.msdk.core.xt.getContext(), rVar, hashMap);
    }

    public void j(r rVar, com.bytedance.msdk.api.j jVar, xt xtVar, oq oqVar, int i6, int i7, int i8, String str, long j6, String str2, String str3, String str4, long j7) {
        if (jVar instanceof com.bytedance.msdk.api.xt.cw) {
            com.bytedance.msdk.api.xt.cw cwVar = (com.bytedance.msdk.api.xt.cw) jVar;
            rVar.xt(jVar.f24334j).oq(jVar.xt);
            rVar.j("block_pacing", cwVar.j());
            rVar.j("adn_rit_show_rule_id", cwVar.xt());
        } else if (jVar instanceof com.bytedance.msdk.api.xt.xt) {
            com.bytedance.msdk.api.xt.xt xtVar2 = (com.bytedance.msdk.api.xt.xt) jVar;
            rVar.xt(jVar.f24334j).oq(jVar.xt);
            rVar.j("block_show_count", xtVar2.j());
            rVar.j("adn_rit_show_rule_id", xtVar2.xt());
        } else if (jVar instanceof com.bytedance.msdk.api.xt.j) {
            rVar.xt(jVar.f24334j);
            rVar.oq(jVar.xt);
            xt(rVar);
        } else {
            rVar.xt(jVar != null ? jVar.cw : -1).oq(jVar != null ? jVar.f24335r : "unknown error");
            xt(rVar);
        }
        rVar.j("media_fill_fail").j(j6).m(str).j("adn_count", Integer.valueOf(i6)).j("adn_preload", 0).j("mediationrit_req_type", Integer.valueOf(i7)).j("mediationrit_req_type_src", Integer.valueOf(i8));
        HashMap hashMap = new HashMap();
        boolean z5 = j7 >= 0;
        if (oqVar != null && oqVar.c()) {
            hashMap.put("custom_adn_sample_ratio", Double.valueOf(mi.cw()));
            hashMap.put("custom_adn_sample_ratio_result", Boolean.valueOf(z5));
            if (z5) {
                hashMap.put("custom_adn_rec_time", Long.valueOf(j7));
            }
        }
        m.j(rVar, xtVar, oqVar, (com.bytedance.msdk.xt.cw) null, hashMap);
        if (!TextUtils.isEmpty(str2)) {
            rVar.g(str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            rVar.j("level_tag", str3);
        }
        if (str4 != null) {
            rVar.j("sub_adn_name", str4);
        }
        com.bytedance.msdk.up.cw.j(com.bytedance.msdk.core.xt.getContext(), rVar, hashMap);
    }

    public void j(r rVar, oq oqVar, xt xtVar, int i6, int i7) {
        rVar.j("adapter_request_fail").j(0L).m((String) null).xt(-99999).oq("adapter create fail !").j("mediationrit_req_type", Integer.valueOf(i6)).j("mediationrit_req_type_src", Integer.valueOf(i7));
        HashMap hashMap = new HashMap();
        m.j(rVar, xtVar, oqVar, (com.bytedance.msdk.xt.cw) null, hashMap);
        com.bytedance.msdk.up.cw.j(com.bytedance.msdk.core.xt.getContext(), rVar, hashMap);
    }

    public void j(r rVar, xt xtVar, int i6) {
        rVar.j("get_config_error").xt(i6);
        HashMap hashMap = new HashMap();
        m.j(rVar, xtVar, (oq) null, (com.bytedance.msdk.xt.cw) null, hashMap);
        com.bytedance.msdk.up.cw.j(com.bytedance.msdk.core.xt.getContext(), rVar, hashMap);
    }

    public void j(r rVar, com.bytedance.msdk.xt.cw cwVar, xt xtVar, List<com.bytedance.msdk.xt.cw> list, List<com.bytedance.msdk.xt.cw> list2) {
        Iterator<com.bytedance.msdk.xt.cw> it;
        HashMap hashMap;
        JSONObject jSONObject;
        rVar.j("bidding_win_event");
        HashMap hashMap2 = new HashMap();
        m.j(rVar, xtVar, (oq) null, cwVar, hashMap2);
        JSONArray jSONArray = new JSONArray();
        if (!p.j(list)) {
            for (com.bytedance.msdk.xt.cw cwVar2 : list) {
                if (cwVar2 != null) {
                    try {
                        jSONObject = new JSONObject();
                        hashMap = hashMap2;
                    } catch (Exception unused) {
                        hashMap = hashMap2;
                    }
                    try {
                        jSONObject.putOpt("mediation_rit", cwVar2.qa());
                        jSONObject.putOpt(MediationConstant.EXTRA_ADN_NAME, cwVar2.ff());
                        jSONObject.putOpt("load_sort", Integer.valueOf(cwVar2.wi()));
                        jSONObject.putOpt("show_sort", Integer.valueOf(cwVar2.d()));
                        jSONObject.putOpt("exchange_rate", cwVar2.k());
                        jSONObject.putOpt("rit_cpm", Double.valueOf(cwVar2.t()));
                        jSONObject.putOpt("m_aid", cwVar2.gx());
                        jSONObject.putOpt("req_bidding_type", Integer.valueOf(cwVar2.xw()));
                        jSONObject.putOpt("win_state", 1);
                        jSONObject.putOpt("ad_extra", cwVar2.n());
                        jSONObject.putOpt("win_callback", cwVar2.ed());
                        jSONObject.putOpt("loss_callback", cwVar2.c());
                        if (cwVar2.qo()) {
                            jSONObject.putOpt("pricing_type", Integer.valueOf(cwVar2.wq()));
                        }
                        jSONArray.put(jSONObject);
                    } catch (Exception unused2) {
                        hashMap2 = hashMap;
                    }
                } else {
                    hashMap = hashMap2;
                }
                hashMap2 = hashMap;
            }
        }
        HashMap hashMap3 = hashMap2;
        if (!p.j(list2)) {
            Iterator<com.bytedance.msdk.xt.cw> it2 = list2.iterator();
            while (it2.hasNext()) {
                com.bytedance.msdk.xt.cw next = it2.next();
                if (next != null) {
                    it = it2;
                    try {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.putOpt("mediation_rit", next.qa());
                        jSONObject2.putOpt(MediationConstant.EXTRA_ADN_NAME, next.ff());
                        jSONObject2.putOpt("load_sort", Integer.valueOf(next.wi()));
                        jSONObject2.putOpt("show_sort", Integer.valueOf(next.d()));
                        jSONObject2.putOpt("exchange_rate", next.k());
                        jSONObject2.putOpt("rit_cpm", Double.valueOf(next.t()));
                        jSONObject2.putOpt("m_aid", next.gx());
                        jSONObject2.putOpt("req_bidding_type", Integer.valueOf(next.xw()));
                        jSONObject2.putOpt("win_state", 0);
                        jSONObject2.putOpt("ad_extra", next.n());
                        jSONObject2.putOpt("win_callback", next.ed());
                        jSONObject2.putOpt("loss_callback", next.c());
                        if (next.qo()) {
                            jSONObject2.putOpt("pricing_type", Integer.valueOf(next.wq()));
                        }
                        jSONArray.put(jSONObject2);
                    } catch (Exception unused3) {
                    }
                } else {
                    it = it2;
                }
                it2 = it;
            }
        }
        hashMap3.put("others", jSONArray);
        com.bytedance.msdk.up.cw.j(com.bytedance.msdk.core.xt.getContext(), rVar, hashMap3);
    }

    public void j(r rVar, xt xtVar, JSONObject jSONObject) {
        rVar.j("start_bidding_request").j(2).j("ad_count", Integer.valueOf(xtVar != null ? xtVar.a() : 0));
        HashMap hashMap = new HashMap();
        if (jSONObject != null) {
            hashMap.put("token_time", jSONObject);
        }
        m.j(rVar, xtVar, (oq) null, (com.bytedance.msdk.xt.cw) null, hashMap);
        com.bytedance.msdk.up.cw.j(com.bytedance.msdk.core.xt.getContext(), rVar, hashMap);
    }

    public void j(r rVar, xt xtVar, com.bytedance.msdk.core.r.xt xtVar2, int i6) {
        if (xtVar2 == null) {
            return;
        }
        r result = rVar.j("return_bidding_result").j(xtVar2.ae).setResult(xtVar2.f24691m);
        com.bytedance.msdk.api.j jVar = xtVar2.tl;
        r xt = result.xt(jVar == null ? 0 : jVar.f24334j);
        com.bytedance.msdk.api.j jVar2 = xtVar2.tl;
        xt.oq(jVar2 == null ? "" : jVar2.xt).j(2).j("fill_type", Integer.valueOf(i6)).j("server_bidding_extra", xtVar2.f24692r).j("ad_count", Integer.valueOf(xtVar2.f24689g));
        HashMap hashMap = new HashMap();
        com.bytedance.msdk.core.g.r.j(xtVar2.oq, xtVar2.f24690j, hashMap);
        JSONObject jSONObject = xtVar2.qv;
        if (jSONObject != null) {
            hashMap.put("token_time", jSONObject);
        }
        m.j(rVar, xtVar, (oq) null, (com.bytedance.msdk.xt.cw) null, hashMap);
        com.bytedance.msdk.up.cw.j(com.bytedance.msdk.core.xt.getContext(), rVar, hashMap);
    }

    public void j(r rVar, oq oqVar, xt xtVar, String str) {
        rVar.j("get_bidding_adm_to_adn").m(str);
        HashMap hashMap = new HashMap();
        m.j(rVar, xtVar, oqVar, (com.bytedance.msdk.xt.cw) null, hashMap);
        com.bytedance.msdk.up.cw.j(com.bytedance.msdk.core.xt.getContext(), rVar, hashMap);
    }

    public void j(r rVar, com.bytedance.msdk.xt.cw cwVar, xt xtVar, oq oqVar, long j6) {
        rVar.j("bidding_adm_load").j(j6);
        HashMap hashMap = new HashMap();
        if (com.bytedance.msdk.core.xt.xt().hh() && cwVar != null && 5 == cwVar.om()) {
            rVar.j("ex_info", tl.j().j(cwVar));
        }
        m.j(rVar, xtVar, oqVar, cwVar, hashMap);
        com.bytedance.msdk.up.cw.j(com.bytedance.msdk.core.xt.getContext(), rVar, hashMap);
    }

    public void j(r rVar, com.bytedance.msdk.xt.cw cwVar, xt xtVar, oq oqVar) {
        rVar.j("bidding_adm_cache");
        HashMap hashMap = new HashMap();
        m.j(rVar, xtVar, oqVar, cwVar, hashMap);
        com.bytedance.msdk.up.cw.j(com.bytedance.msdk.core.xt.getContext(), rVar, hashMap);
    }

    public void j(r rVar, xt xtVar, com.bytedance.msdk.xt.cw cwVar, oq oqVar) {
        rVar.j("media_cache_success");
        HashMap hashMap = new HashMap();
        m.j(rVar, xtVar, oqVar, cwVar, hashMap);
        com.bytedance.msdk.up.cw.j(com.bytedance.msdk.core.xt.getContext(), rVar, hashMap);
    }

    public void j(r rVar, xt xtVar, com.bytedance.msdk.xt.cw cwVar, long j6) {
        rVar.j("mediation_video_cached").j(j6);
        HashMap hashMap = new HashMap();
        m.j(rVar, xtVar, (oq) null, cwVar, hashMap);
        com.bytedance.msdk.up.cw.j(com.bytedance.msdk.core.xt.getContext(), rVar, hashMap);
    }

    private static void j(r rVar) {
        rVar.j("block_pacing", "-1");
        rVar.j("waterfall_show_rule_id", "-1");
        rVar.j("block_show_count", "-1");
    }
}
