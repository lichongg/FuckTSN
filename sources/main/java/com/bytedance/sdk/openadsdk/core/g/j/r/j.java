package com.bytedance.sdk.openadsdk.core.g.j.r;

import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.component.qv.j.xt;
import com.bytedance.sdk.component.qv.r.cw;
import com.bytedance.sdk.component.qv.r.r;
import com.bytedance.sdk.component.qv.r.up;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.api.plugin.xt;
import com.bytedance.sdk.openadsdk.core.cw.m;
import com.bytedance.sdk.openadsdk.core.p.oq;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.v;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {
    private static String ae;

    /* renamed from: m, reason: collision with root package name */
    private static long f29009m;
    private static String tl;
    private static long up;

    /* renamed from: j, reason: collision with root package name */
    private static AtomicInteger f29008j = new AtomicInteger(0);
    private static SharedPreferences xt = xt.xt(v.getContext(), "uchain_data", 0);
    private static int cw = -1;

    /* renamed from: r, reason: collision with root package name */
    private static int f29010r = -1;

    /* renamed from: com.bytedance.sdk.openadsdk.core.g.j.r.j$3, reason: invalid class name */
    static class AnonymousClass3 implements cw {

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ JSONArray f29013j;

        AnonymousClass3(JSONArray jSONArray) {
            this.f29013j = jSONArray;
        }

        @Override // com.bytedance.sdk.component.qv.r.cw
        public void j(com.bytedance.sdk.component.qv.j.j jVar) {
            jVar.j(new r() { // from class: com.bytedance.sdk.openadsdk.core.g.j.r.j.3.1
                @Override // com.bytedance.sdk.component.qv.r.r
                public up xt() {
                    return new up() { // from class: com.bytedance.sdk.openadsdk.core.g.j.r.j.3.1.1
                        @Override // com.bytedance.sdk.component.qv.r.up
                        public void j(com.bytedance.sdk.component.qv.j.j jVar2, Map<String, Object> map) {
                            try {
                                String j6 = jVar2.ae().j();
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("event", j6);
                                jSONObject.put(NotificationCompat.CATEGORY_STATUS, true);
                                AnonymousClass3.this.f29013j.put(jSONObject);
                            } catch (JSONException e6) {
                                vl.j(e6);
                            }
                        }

                        @Override // com.bytedance.sdk.component.qv.r.up
                        public void xt(com.bytedance.sdk.component.qv.j.j jVar2, Map<String, Object> map) {
                            try {
                                String j6 = jVar2.ae().j();
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("event", j6);
                                jSONObject.put(NotificationCompat.CATEGORY_STATUS, false);
                                AnonymousClass3.this.f29013j.put(jSONObject);
                            } catch (JSONException e6) {
                                vl.j(e6);
                            }
                        }
                    };
                }
            });
        }
    }

    private static void qv() {
        String ag;
        String qf;
        JSONObject xt2;
        cw = -1;
        oq xt3 = v.xt();
        if (xt3 != null && (xt2 = xt((ag = xt3.ag()), (qf = xt3.qf()))) != null && xt2.length() > 0) {
            f29010r = 2;
            ae = ag;
            tl = qf;
            long currentTimeMillis = System.currentTimeMillis() - f29009m;
            up = currentTimeMillis;
            xt(cw, f29010r, currentTimeMillis);
            xt(xt2);
            return;
        }
        JSONObject j6 = j();
        if (j6 == null || j6.length() <= 0) {
            f29008j.set(3);
            xt(cw, f29010r, up);
            return;
        }
        f29010r = 0;
        tl = "uc_dsl/uc_dsl.bin";
        long currentTimeMillis2 = System.currentTimeMillis() - f29009m;
        up = currentTimeMillis2;
        xt(cw, f29010r, currentTimeMillis2);
        xt(j6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void oq() {
        cw = 100008;
        long currentTimeMillis = System.currentTimeMillis() - f29009m;
        up = currentTimeMillis;
        xt(cw, f29010r, currentTimeMillis);
        qv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void xt(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() <= 0) {
            jSONObject = j();
        }
        if (jSONObject != null && jSONObject.length() > 0) {
            JSONObject optJSONObject = jSONObject.optJSONObject("event_template");
            if (optJSONObject != null && optJSONObject.length() > 0) {
                com.bytedance.sdk.component.qv.cw.xt.INSTANCE.j(optJSONObject);
                f29008j.set(2);
                return;
            } else {
                f29008j.set(3);
                return;
            }
        }
        f29008j.set(3);
    }

    public static void j(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            str = "21ea2d6d4f321553dd684e6b864bf0b7";
            str2 = "https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/uchain/20103/uchain_dsl.bin";
        }
        ae = str;
        tl = str2;
        f29009m = System.currentTimeMillis();
        JSONObject xt2 = xt(ae, tl);
        if (xt2 != null && xt2.length() > 0) {
            f29010r = 2;
            long currentTimeMillis = System.currentTimeMillis() - f29009m;
            up = currentTimeMillis;
            xt(cw, f29010r, currentTimeMillis);
            xt(xt2);
            return;
        }
        com.bytedance.sdk.component.g.xt.j up2 = com.bytedance.sdk.openadsdk.core.v.up.j().xt().up();
        if (up2 == null) {
            f29008j.set(3);
            return;
        }
        up2.j(tl);
        final String str3 = ae;
        final String str4 = tl;
        up2.j(new com.bytedance.sdk.component.g.j.j() { // from class: com.bytedance.sdk.openadsdk.core.g.j.r.j.1
            @Override // com.bytedance.sdk.component.g.j.j
            public void j(com.bytedance.sdk.component.g.xt.r rVar, com.bytedance.sdk.component.g.xt xtVar) {
                int unused = j.f29010r = 1;
                String unused2 = j.ae = str3;
                String unused3 = j.tl = str4;
                if (xtVar != null) {
                    try {
                        if (xtVar.tl()) {
                            JSONObject j6 = m.j(xtVar.oq(), "uchain_dsl");
                            long unused4 = j.up = System.currentTimeMillis() - j.f29009m;
                            if (j6 != null && j6.length() > 0) {
                                j.xt(j.cw, j.f29010r, j.up);
                                j.xt(j6);
                                j.xt.edit().putString(str3, com.bytedance.sdk.component.utils.j.xt(j6.toString())).apply();
                                return;
                            }
                            j.xt(j.cw, j.f29010r, j.up);
                            j.oq();
                            return;
                        }
                    } catch (Throwable unused5) {
                        j.oq();
                        return;
                    }
                }
                j.oq();
            }

            @Override // com.bytedance.sdk.component.g.j.j
            public void j(com.bytedance.sdk.component.g.xt.r rVar, IOException iOException) {
                int unused = j.f29010r = 1;
                j.oq();
            }
        });
    }

    public static JSONObject xt(String str, String str2) {
        if ((TextUtils.isEmpty(str2) && TextUtils.isEmpty(str)) || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String string = xt.getString(str, "");
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            String cw2 = com.bytedance.sdk.component.utils.j.cw(string);
            f29010r = 2;
            ae = str;
            tl = str2;
            return new JSONObject(cw2);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void xt(final int i6, final int i7, final long j6) {
        com.bytedance.sdk.openadsdk.core.kt.xt.cw().j(new com.bytedance.sdk.openadsdk.vl.j.j() { // from class: com.bytedance.sdk.openadsdk.core.g.j.r.j.2
            @Override // com.bytedance.sdk.openadsdk.vl.j.j
            public com.bytedance.sdk.openadsdk.core.kt.j.j j() {
                JSONObject jSONObject = new JSONObject();
                try {
                    int i8 = i6;
                    if (i8 != -1) {
                        jSONObject.put("dsl_error_code", i8);
                    }
                    jSONObject.put("dsl_url", j.tl);
                    jSONObject.put("dsl_md5", j.ae);
                    jSONObject.put("dsl_load_type", i7);
                    jSONObject.put("dsl_load_time", j6);
                    jSONObject.put("dsl_stats_id", UUID.randomUUID());
                } catch (Throwable unused) {
                }
                return com.bytedance.sdk.openadsdk.core.kt.j.xt.xt().j("uchain_stats_tracker").xt(jSONObject.toString());
            }
        }, "uchain_stats_tracker", false);
    }

    public static void j(n nVar, Map<String, Object> map, String str, HashMap<String, Object> hashMap, String str2, HashMap<String, Object> hashMap2) {
        if (f29008j.get() != 2) {
            f29009m = System.currentTimeMillis();
            qv();
        }
        if (nVar == null) {
            return;
        }
        JSONObject tv2 = nVar.tv();
        try {
            for (Map.Entry<String, Object> entry : hashMap2.entrySet()) {
                tv2.put(entry.getKey(), entry.getValue());
            }
        } catch (JSONException e6) {
            vl.j(e6);
        }
        JSONArray jSONArray = new JSONArray();
        new xt.j(str).j(tv2).j(hashMap).j(new AnonymousClass3(jSONArray)).j().j();
        JSONObject jSONObject = new JSONObject();
        UUID randomUUID = UUID.randomUUID();
        if (map != null) {
            map.put("uchain_event_id", randomUUID);
        }
        try {
            jSONObject.put("uchain_event_id", randomUUID);
            jSONObject.put(str, jSONArray);
            jSONObject.put("slot_type", uf.tl(nVar));
            com.bytedance.sdk.openadsdk.core.jy.cw.xt(nVar, str2, "uchain_event_tracker", jSONObject);
        } catch (JSONException unused) {
        }
    }

    public static boolean j(Map<String, Object> map) {
        if (map == null) {
            return false;
        }
        Object obj = map.get("is_feed_register_direct_download");
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        return false;
    }

    public static JSONObject j() {
        try {
            return new JSONObject("{\"template_info\":{\"version\":\"2.1.3\"},\"event_template\":{\"clickEvent\":{\"main\":\"open_sass_live\",\"lazyLoad\":\"0\",\"events\":[{\"name\":\"open_sass_live\",\"scheme\":\"uchain://open_sass_live?ad_id=${ad_id}&ad_info=${ad_info}&log_extra=${ext}&coupon=${coupon}&ec_schema=${ec_schema}&ecom_live_params=${ecom_live_params}&live_interaction_type=${live_interaction_type}&live_room_id=${live_room_id}&deep_link=${deep_link}\",\"params\":{},\"next\":[],\"callback\":{\"success\":[],\"fail\":[{\"name\":\"open_miniapp\"}]}},{\"name\":\"open_miniapp\",\"scheme\":\"uchain://open_miniapp?ad_id=${ad_id}&ad_info=${ad_info}&log_extra=${ext}&wc_miniapp_info=${wc_miniapp_info}&target_url=${target_url}\",\"params\":{},\"next\":[],\"callback\":{\"success\":[],\"fail\":[{\"condition\":\"${(is_video_lp==true||if_both_open==1)&&deep_link==null&&ulink==null}\",\"name\":\"open_landing_page\"},{\"condition\":\"${deep_link!=null||ulink!=null||(is_video_lp!=true&&if_both_open==0)}\",\"name\":\"open_scheme\"}]}},{\"name\":\"open_landing_page\",\"scheme\":\"uchain://open_landing_page?ad_id=${ad_id}&ad_info=${ad_info}&log_extra=${ext}&interaction_type=${interaction_type}&title=${title!=null?title:'广告'}&url=${target_url}&button_text=${button_text!=null?button_text:'立即下载'}&gecko_id=${gecko_id}&block_auto_open=${block_auto_open}&ugeno=${ugeno}&page_render_type=${page_render_type}&session_params=${session_params}&dylite_info=${dylite_info}&filter_words=${filter_words}&video=${video}&app_info=${app}&use_media_video_player=${use_media_video_player}&source=${source}&title=${title}&image_mode=${image_mode}&landing_page_conf=${landing_page_conf}&image=${image}&landing_scroll_percentage=${landing_scroll_percentage}&sdk_derive_info=${sdk_derive_info}&dynamic_join_type=${dynamic_join_type}&audio=${audio}&disable_video_join=${disable_video_join}&disable_top_bar=${disable_top_bar}&disable_rtn_button=${disable_rtn_button}&disable_safe_area=${disable_safe_area}&gnd_prefetch_timing=${gnd_prefetch_timing}&gnd_prefetch_cache_key=${gnd_prefetch_cache_key}&direct_landing_page_info=${direct_landing_page_info}&reward_browse_type=${reward_browse_type}&voice_control=${voice_control}\",\"params\":{},\"next\":[{\"condition\":\"${if_both_open==1&&(is_video_lp!=true||app.appleid==null||app.appleid=='0')}\",\"name\":\"download\"}],\"callback\":{\"success\":[],\"fail\":[]}},{\"name\":\"open_scheme\",\"scheme\":\"uchain://open_scheme?ad_id=${ad_id}&ad_info=${ad_info}&log_extra=${ext}&interaction_type=${interaction_type}&deep_link=${deep_link}&ulink=${ulink}&ulink_priority=${ulink_priority}&sub_convert_link=${sub_convert_link}&app_info=${app}&block_auto_open=${block_auto_open}\",\"params\":{},\"next\":[],\"callback\":{\"success\":[],\"fail\":[{\"condition\":\"${(deep_link!=null&&deep_link.fallback_type==1)||(deep_link==null&&(interaction_type==3||ext.interaction_type==3))}\",\"name\":\"open_landing_page\"},{\"condition\":\"${(deep_link!=null&&deep_link.fallback_type==2)||(deep_link==null&&(interaction_type==4||ext.interaction_type==4))}\",\"name\":\"download\"}]}},{\"name\":\"download\",\"scheme\":\"uchain://download?ad_id=${ad_id}&ad_info=${ad_info}&log_extra=${ext}&app_info=${app}&download_conf=${download_conf}&appstore_jump_type=${appstore_jump_type}&market_url=${market_url}&download_sdk_conf=${download_sdk_conf}&icon=${icon}&interaction_type=${interaction_type}&skan=${skan}\",\"params\":{},\"next\":[],\"callback\":{\"success\":[],\"fail\":[{\"condition\":\"${if_both_open==0}\",\"name\":\"open_landing_page\"}]}}]},\"ugen_view_visibility_tracker\":{\"main\":\"report_event\",\"lazyLoad\":\"0\",\"events\":[{\"name\":\"report_event\",\"scheme\":\"uchain://report_event?label=ugen_view_visibility&ad_id=${ad_id}&log_extra=${ext}&ugen_id=${ugen_event_params.ugen_id}&visibility=${ugen_event_params.visibility}\",\"params\":{},\"next\":[],\"callback\":{\"success\":[],\"fail\":[]}}]},\"video_rate\":{\"main\":\"video\",\"lazyLoad\":\"0\",\"events\":[{\"name\":\"video\",\"scheme\":\"uchain://video?action=rate&identifier=${ad_info}&rate=1.0\",\"params\":{},\"next\":[],\"callback\":{\"success\":[],\"fail\":[]}}]},\"video_pause\":{\"main\":\"video\",\"lazyLoad\":\"0\",\"events\":[{\"name\":\"video\",\"scheme\":\"uchain://video?action=pause&identifier=${ad_info}\",\"params\":{},\"next\":[],\"callback\":{\"success\":[],\"fail\":[]}}]},\"video_play\":{\"main\":\"video\",\"lazyLoad\":\"0\",\"events\":[{\"name\":\"video\",\"scheme\":\"uchain://video?action=play&identifier=${ad_info}\",\"params\":{},\"next\":[],\"callback\":{\"success\":[],\"fail\":[]}}]},\"video_replay\":{\"main\":\"video\",\"lazyLoad\":\"0\",\"events\":[{\"name\":\"video\",\"scheme\":\"uchain://video?action=replay&identifier=${ad_info}\",\"params\":{},\"next\":[],\"callback\":{\"success\":[],\"fail\":[]}}]},\"openPolicy\":{\"main\":\"open_policy\",\"lazyLoad\":\"0\",\"events\":[{\"name\":\"open_policy\",\"scheme\":\"uchain://open_policy?ad_info=${ad_info}&adx_name=${adx_name}&filter_words=${filter_words}\",\"params\":{},\"next\":[],\"callback\":{\"success\":[],\"fail\":[]}}]},\"continue_watch\":{\"main\":\"reward_continue\",\"lazyLoad\":\"0\",\"events\":[{\"name\":\"reward_continue\",\"scheme\":\"uchain://reward_continue\",\"params\":{},\"next\":[],\"callback\":{\"success\":[],\"fail\":[]}}]},\"exit_watch\":{\"main\":\"close_reward\",\"lazyLoad\":\"0\",\"events\":[{\"name\":\"close_reward\",\"scheme\":\"uchain://close_reward\",\"params\":{},\"next\":[],\"callback\":{\"success\":[],\"fail\":[]}}]},\"reward_again\":{\"main\":\"reward_again\",\"lazyLoad\":\"0\",\"events\":[{\"name\":\"reward_again\",\"scheme\":\"uchain://reward_again?pression_sessions=${play_again.pression_sessions}&play_again_rit=${play_again.play_again_rit}&log_extra=${ext}\",\"params\":{},\"next\":[],\"callback\":{\"success\":[],\"fail\":[]}}]}}}");
        } catch (Exception unused) {
            return null;
        }
    }
}
