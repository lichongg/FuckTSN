package com.bytedance.sdk.openadsdk.core.p;

import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.bn;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.component.utils.ws;
import com.bytedance.sdk.component.widget.web.MultiWebview;
import com.bytedance.sdk.openadsdk.core.cw.up;
import com.bytedance.sdk.openadsdk.core.nativeexpress.tj;
import com.bytedance.sdk.openadsdk.core.rn.a;
import com.bytedance.sdk.openadsdk.core.rn.ch;
import com.bytedance.sdk.openadsdk.core.rn.h;
import com.bytedance.sdk.openadsdk.core.rn.rn;
import com.bytedance.sdk.openadsdk.core.rn.s;
import com.bytedance.sdk.openadsdk.core.tj.e;
import com.bytedance.sdk.openadsdk.core.tj.gq;
import com.bytedance.sdk.openadsdk.core.tj.gx;
import com.bytedance.sdk.openadsdk.core.tj.la;
import com.bytedance.sdk.openadsdk.core.tj.mi;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.tj.p;
import com.bytedance.sdk.openadsdk.core.tj.pz;
import com.bytedance.sdk.openadsdk.core.tj.wq;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import master.flame.danmaku.danmaku.parser.b;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class oq implements up {
    private static volatile boolean er;
    private static final String lx = null;
    private static volatile boolean sz;
    private int ag;
    private int al;
    private boolean ar;
    private int ay;
    private volatile int bh;
    private int by;
    private JSONObject cb;
    private Boolean cr;
    public volatile com.bytedance.sdk.component.r.j.xt cw;

    /* renamed from: d, reason: collision with root package name */
    private String f29805d;
    private int dj;
    private String ed;
    private boolean ej;
    private Boolean ek;
    private int el;
    private volatile boolean et;
    private boolean fj;
    private int fk;
    private int fp;
    private String fs;
    private boolean fv;
    private int fx;
    private m fz;
    private int gr;
    private Object gs;

    /* renamed from: h, reason: collision with root package name */
    private String f29809h;
    private String hk;
    private String hu;
    private JSONObject hw;
    private String id;

    /* renamed from: if, reason: not valid java name */
    private String f0if;
    private JSONObject ig;
    private String ih;
    private volatile SharedPreferences ij;
    private int ik;
    private gx im;
    private JSONObject ja;
    private int jl;
    private int ju;
    private float ka;
    private int ki;
    private String kj;
    private JSONObject kk;
    private Map<String, Object> km;
    private String la;
    private long lc;
    private int lg;
    private float ll;
    private int ln;
    private int lo;
    private JSONObject lv;
    private int lw;
    private boolean mc;
    private boolean mm;
    private int mp;
    private volatile int mz;

    /* renamed from: n, reason: collision with root package name */
    private String f29815n;
    private int na;
    private wq nd;
    private int nt;
    private volatile com.bytedance.sdk.component.r.j.xt nu;
    private String nv;
    private boolean nw;

    /* renamed from: o, reason: collision with root package name */
    private boolean f29816o;
    private SharedPreferences om;
    private int os;
    private JSONObject ot;
    private float ov;
    private boolean oy;
    private long pm;
    private boolean px;
    private String qe;
    private int qf;
    private JSONObject qg;
    private boolean qn;
    private float qo;

    /* renamed from: r, reason: collision with root package name */
    public volatile com.bytedance.sdk.component.r.j.xt f29819r;
    private boolean rf;
    private com.bytedance.sdk.openadsdk.core.az.j.j rh;
    private String ri;
    private int rs;
    private int sf;
    private volatile SharedPreferences sh;
    private int si;
    private tj sj;
    private xt so;

    /* renamed from: t, reason: collision with root package name */
    private int f29821t;
    private int tk;
    private boolean to;

    /* renamed from: tv, reason: collision with root package name */
    private int f29822tv;

    /* renamed from: u, reason: collision with root package name */
    private float f29823u;
    private boolean ua;
    private String uc;
    private long uf;
    private boolean uh;
    private int uo;
    public int up;
    private int uq;
    private String ve;
    private int vm;
    private int vr;
    private int vu;
    private final int wf;
    private String wi;
    private boolean wo;
    private JSONObject wq;
    private boolean xa;
    private int xc;
    private int xj;
    private final String xp;
    private String xw;

    /* renamed from: y, reason: collision with root package name */
    private int f29827y;
    private JSONObject yb;
    private String yl;
    private int ym;
    private int yu;
    private volatile int yv;
    private volatile boolean zd;
    private ae zi;
    private JSONObject zk;
    private float zs;
    private boolean zw;

    /* renamed from: m, reason: collision with root package name */
    private int f29814m = Integer.MAX_VALUE;
    private Set<String> ae = Collections.synchronizedSet(new HashSet());
    private int tl = Integer.MAX_VALUE;

    /* renamed from: g, reason: collision with root package name */
    private int f29808g = Integer.MAX_VALUE;
    private int oq = Integer.MAX_VALUE;
    private int qv = Integer.MAX_VALUE;
    private String vl = null;
    private int jy = Integer.MAX_VALUE;
    private int ws = Integer.MAX_VALUE;
    private int az = Integer.MIN_VALUE;
    private int av = Integer.MIN_VALUE;

    /* renamed from: i, reason: collision with root package name */
    private int f29810i = Integer.MIN_VALUE;

    /* renamed from: w, reason: collision with root package name */
    private int f29825w = -1;
    private int mi = Integer.MIN_VALUE;
    private String kt = null;

    /* renamed from: j, reason: collision with root package name */
    public int f29811j = 0;
    private int tj = Integer.MIN_VALUE;

    /* renamed from: f, reason: collision with root package name */
    private int f29807f = Integer.MAX_VALUE;
    public int xt = 10;

    /* renamed from: v, reason: collision with root package name */
    private int f29824v = Integer.MAX_VALUE;

    /* renamed from: x, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.ae.xt f29826x = null;
    private com.bytedance.sdk.openadsdk.core.dislike.r ch = null;

    /* renamed from: s, reason: collision with root package name */
    private boolean f29820s = false;

    /* renamed from: a, reason: collision with root package name */
    private int f29802a = Integer.MAX_VALUE;

    /* renamed from: l, reason: collision with root package name */
    private final Map<String, j> f29813l = new ConcurrentHashMap();

    /* renamed from: p, reason: collision with root package name */
    private Map<String, com.bytedance.sdk.component.adexpress.j.cw.r> f29817p = new HashMap();
    private Set<String> gq = Collections.synchronizedSet(new HashSet());
    private final List<Object> rn = new CopyOnWriteArrayList();

    /* renamed from: c, reason: collision with root package name */
    private JSONObject f29804c = null;
    private String gx = "";
    private int ol = Integer.MAX_VALUE;
    private int hh = Integer.MAX_VALUE;

    /* renamed from: z, reason: collision with root package name */
    private long f29828z = 0;
    private Set<String> hl = new ConcurrentSkipListSet();

    /* renamed from: b, reason: collision with root package name */
    private Set<String> f29803b = new ConcurrentSkipListSet();

    /* renamed from: e, reason: collision with root package name */
    private Set<String> f29806e = new ConcurrentSkipListSet();

    /* renamed from: q, reason: collision with root package name */
    private int f29818q = Integer.MAX_VALUE;
    private int qb = Integer.MAX_VALUE;
    private long ya = 2147483647L;
    private int sm = Integer.MAX_VALUE;
    private int xq = Integer.MAX_VALUE;

    /* renamed from: k, reason: collision with root package name */
    private int f29812k = Integer.MAX_VALUE;
    private int ff = Integer.MAX_VALUE;
    private int ry = 0;
    private long zz = 0;
    private int kc = 0;
    private long aq = 0;
    private int rr = Integer.MAX_VALUE;
    private JSONObject st = null;
    private JSONObject pz = null;
    private int qa = 3;

    public static String cw() {
        return "tt_sdk_settings_other_bst";
    }

    private void fj() {
        xt();
        this.cw.j("url_stats", this.yl);
        this.cw.j("mini_game_preload", this.al);
        if (!"https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/csj_assets/".equals(this.qe) && !TextUtils.isEmpty(this.qe)) {
            this.cw.j("img_bucket", this.qe);
        }
        SharedPreferences.Editor edit = zw().edit();
        edit.putString("url_stats", this.yl);
        this.cw.j("url_alog", this.ri);
        edit.putString("url_alog", this.ri);
        this.cw.j("xpath", this.ed);
        if (this.wq != null) {
            this.cw.j("digest", this.wq.toString());
        }
        this.cw.j("data_time", this.uf);
        this.cw.j("fetch_template", this.nt);
        this.cw.j("pyload_h5", this.f29815n);
        com.bytedance.sdk.component.r.j.xt xtVar = this.cw;
        wq wqVar = this.nd;
        xtVar.j("insert_js_config", wqVar != null ? wqVar.toString() : "");
        com.bytedance.sdk.component.r.j.xt xtVar2 = this.cw;
        com.bytedance.sdk.openadsdk.core.az.j.j jVar = this.rh;
        xtVar2.j("white_check_config", jVar != null ? jVar.toString() : "");
        this.cw.j("splash_check_type", this.ol);
        this.cw.j("if_both_open", this.f29818q);
        this.cw.j("adlog_exception_batch", this.xq);
        this.cw.j("adlog_interval", this.ya);
        this.cw.j("adlog_batch", this.sm);
        this.cw.j("adlog_debug", this.f29812k);
        this.cw.j("adlog_monitor", this.ff);
        this.cw.j("enable_ttvideo", this.f29825w);
        this.cw.j("enable_zaid", this.mi);
        this.cw.j("ext_use_type", this.aq);
        this.cw.j("enable_dl_ext", this.kc);
        this.cw.j("download_receiver_enable", this.f29824v);
        this.cw.j("launch_strategy", this.f29811j);
        this.cw.j("dl_popup_duration", this.tj);
        this.cw.j("switch_audio_focus", this.rr);
        this.cw.j("opt_show_check", this.f29807f);
        if (this.st != null) {
            this.cw.j("pitaya_general_settings", this.st.toString());
        }
        if (this.kk != null) {
            this.cw.j("live_stream_cof", this.kk.toString());
        }
        if (this.hw != null) {
            this.cw.j("dl_notification", this.hw.toString());
        }
        this.cw.j("disable_show_url", this.dj);
        if (this.zk != null) {
            this.cw.j("sensor_direction", this.zk.toString());
        }
        if (this.ja != null) {
            this.cw.j("pitaya_business_conf", this.ja.toString());
        }
        com.bytedance.sdk.component.r.j.xt xtVar3 = this.cw;
        JSONObject jSONObject = this.pz;
        xtVar3.j("http_drop", jSONObject == null ? "" : jSONObject.toString());
        this.cw.j("stats_batch", this.qa);
        this.cw.j("event_switch", this.ln);
        this.cw.j("pre_fetch_cnt", this.xt);
        this.cw.j("web_upload_enable", this.f29814m);
        this.cw.j("web_upload_content_type", this.ae);
        this.cw.j("web_upload_send_restowv", this.tl);
        this.cw.j("web_upload_max_retry", this.ws);
        this.cw.j("web_upload_max_single_file", this.f29808g);
        this.cw.j("web_upload_max_zip_file", this.oq);
        this.cw.j("web_upload_report_url", this.vl);
        this.cw.j("web_upload_storage_type", this.jy);
        this.cw.j("web_upload_report_only_wifi", this.qv);
        this.cw.j("app_list_control", this.hh);
        this.cw.j("max_tpl_cnts", this.ki);
        this.cw.j("fetch_tpl_timeout_ctrl", this.f29821t);
        this.cw.j("interact_show_after_time", this.uq);
        this.cw.j("fetch_tpl_timeout_ctrl_bad_device", this.ik);
        this.cw.j("tpl_render_error_rate_h5", this.ka);
        this.cw.j("tpl_render_error_rate_native", this.f29823u);
        this.cw.j("mid_value", this.qo);
        this.cw.j("low_value", this.ll);
        this.cw.j("tpl_enable_render_timeout_opt", this.wo);
        this.cw.j("open_single_abi", this.oy);
        com.bytedance.sdk.component.r.j.xt xtVar4 = this.cw;
        int i6 = this.ju;
        if (i6 == Integer.MAX_VALUE) {
            i6 = 0;
        }
        xtVar4.j("show_callback_mult", i6);
        this.cw.j("webview_cache_count", this.fx);
        this.cw.j("webview_cache_count_v3", this.na);
        this.cw.j("webview_render_concurrent_count", this.gr);
        this.cw.j("enable_apm_pv", this.px);
        this.cw.j("hit_app_list_time", this.f29828z);
        this.cw.j("hit_app_list_data", this.hl);
        this.cw.j("scheme_list_data", this.f29803b);
        this.cw.j("top_scheme_list_data", this.f29806e);
        this.cw.j("policy_url", this.hu);
        com.bytedance.sdk.component.r.j.xt xtVar5 = this.cw;
        Boolean bool = this.ek;
        xtVar5.j("use_mediation_map", bool != null ? bool.booleanValue() : false);
        this.cw.j("apm_pv_config", this.kt);
        this.cw.j("dyn_draw_engine_url", this.xw);
        this.cw.j("play_component_ugen_engine_url", this.f29805d);
        this.cw.j("ad_pkg_info_url", this.wi);
        this.cw.j("sp_key_if_sp_cache", this.tk);
        this.cw.j("download_sdk_config", this.gx);
        com.bytedance.sdk.component.r.j.xt xtVar6 = this.cw;
        JSONObject jSONObject2 = this.yb;
        xtVar6.j("thread_config", jSONObject2 != null ? jSONObject2.toString() : "");
        this.cw.j("npth_enable_type", this.up);
        this.cw.j("is_sp_send_meta", this.fj);
        this.cw.j("opt_config", this.zi.toString());
        this.cw.j("kv_config", this.fz.toString());
        this.cw.j("is_first_plugin_resources", this.zw);
        this.cw.j("vbtt", this.f29827y);
        this.cw.j("preload_switch", this.xa);
        this.cw.j("preload_time_point", this.si);
        this.cw.j("app_info_cache_switch", this.nw);
        this.cw.j("is_adapt_density", this.ar);
        this.cw.j("disable_easy_playable", this.zd);
        this.cw.j("enable_target_34", this.yv);
        this.cw.j("enable_xm_market", this.bh);
        this.cw.j("disable_repeat_render", this.rf);
        this.cw.j("status_bar_adapt", this.f29822tv);
        if (!TextUtils.isEmpty(this.la)) {
            this.cw.j("template_ids", this.la);
        }
        if (!TextUtils.isEmpty(this.f29809h)) {
            this.cw.j("tpl_infos", this.f29809h);
        }
        com.bytedance.sdk.component.r.j.xt xtVar7 = this.cw;
        tj tjVar = this.sj;
        xtVar7.j("tpl_timeout_ctrl", tjVar != null ? tjVar.toString() : "");
        this.cw.j("call_stack_rate", this.ov);
        this.cw.j("gnd_prefetch_cache_ttl", this.pm);
        this.cw.j("gnd_prefetch_cache_size", this.ay);
        this.cw.j("global_rate", this.zs);
        this.cw.j("read_video_from_cache", this.rs);
        this.cw.j("brand_video_cache_count", this.jl);
        this.cw.j("enable_bw_screen_detection", this.f29816o);
        this.cw.j("splash_card_show_max_count", this.el);
        com.bytedance.sdk.component.r.j.xt xtVar8 = this.cw;
        com.bytedance.sdk.openadsdk.core.ae.xt xtVar9 = this.f29826x;
        xtVar8.j("clog_config", xtVar9 != null ? xtVar9.toString() : "");
        com.bytedance.sdk.component.r.j.xt xtVar10 = this.cw;
        com.bytedance.sdk.openadsdk.core.dislike.r rVar = this.ch;
        xtVar10.j("clog_config", rVar != null ? rVar.toString() : "");
        this.cw.j("check_live_room", this.f29820s);
        this.cw.j("can_init_live", this.to);
        this.cw.j("new_app_list", this.ej);
        com.bytedance.sdk.component.r.j.xt xtVar11 = this.cw;
        xt xtVar12 = this.so;
        xtVar11.j("app_live_config", xtVar12 != null ? xtVar12.toString() : "");
        com.bytedance.sdk.component.r.j.xt xtVar13 = this.cw;
        JSONObject jSONObject3 = this.ot;
        xtVar13.j("plugin_update_state", jSONObject3 != null ? jSONObject3.toString() : "");
        com.bytedance.sdk.component.r.j.xt xtVar14 = this.cw;
        JSONObject jSONObject4 = this.cb;
        xtVar14.j("antispam_autoclick_detect", jSONObject4 != null ? jSONObject4.toString() : "");
        this.cw.j("pglam_main_enable", this.by);
        this.cw.j("pglam_dns_check_enable", this.yu);
        this.cw.j("pglam_clazz_check", this.f0if);
        this.cw.j("ud_enable", this.os);
        this.cw.j("is_open_isw", this.fk);
        edit.putInt("is_kv_cache_type", this.xj);
        edit.putInt("kv_init_type", this.lo);
        edit.putString(TKDownloadReason.KSAD_TK_MD5, this.kj);
        edit.putString("url", this.hk);
        edit.apply();
        this.cw.j("lp_url_sw", this.vr);
        if (this.vr == 1) {
            if (com.bytedance.sdk.openadsdk.core.cw.cw.j().g()) {
                mm().j("lp_list", this.id);
            } else if (!com.bytedance.sdk.openadsdk.core.oq.i().la()) {
                mm().j("lp_list", this.id);
            }
        }
        if (this.im != null) {
            this.cw.j("live_sdk_conf", this.im.toString());
        }
        this.cw.j("open_dl_type", this.uo);
        this.cw.j("app_dl_scheme_list", this.nv);
        this.cw.j("scheme_get_type", this.fp);
        this.cw.j("scheme_get_num", this.ym);
        this.cw.j("if_query_all_package", this.sf);
        if (this.ig != null) {
            this.cw.j("video_cache_config", this.ig.toString());
        }
        if (this.qg != null) {
            this.cw.j("log_rate_conf", this.qg.toString());
        }
        this.cw.j("splash_close_text", this.ve);
        this.cw.j("network_module", this.f29802a);
        this.cw.j("m_vids_join", this.lw);
        this.cw.j("mini_event_upload_version", this.xc);
        this.cw.j("bg_web_readd_t", this.lc);
        this.cw.j("title_priority", this.vu);
        this.cw.j("splash_video_opt_enable", this.lg);
        this.cw.j("gesture_through_enable", this.ag);
        this.cw.j("refresh_req_num", this.qf);
        this.cw.j("refresh_max_times", this.vm);
        this.cw.j("shake_trigger_control", this.mp);
        this.cw.j("net_rating", this.uh);
        this.cw.j("device_rating", this.ua);
        this.cw.j("bytebench_rating", this.mm);
        com.bytedance.sdk.component.r.j.xt xtVar15 = this.cw;
        JSONObject jSONObject5 = this.lv;
        xtVar15.j("net_rating_config", jSONObject5 != null ? jSONObject5.toString() : "");
        this.cw.j("express_gesture_enable", this.az);
        this.cw.j("enable_download_proto", this.f29810i);
        this.cw.j("app_express_gesture_priority", this.av);
        this.cw.j("ad_slot_conf_block", this.ih);
        this.cw.j("view_check_by_window", this.qn);
        this.cw.j("shake_twist_bind_show", this.mc);
        this.cw.j("view_check_by_click", this.fv);
        gq.j(this.cw);
        e.j(this.cw);
        com.bytedance.sdk.openadsdk.core.tj.tl.xt(this.cw);
        mi.j(this.cw);
        p.xt(this.cw);
        la.xt(this.cw);
    }

    public static void g() {
        oq xt = v.xt();
        if (xt != null) {
            boolean aq = xt.aq();
            if (com.bytedance.sdk.openadsdk.i.cw.xt(com.bytedance.sdk.openadsdk.core.oq.i().gx()).booleanValue(1) != aq) {
                com.bytedance.sdk.openadsdk.core.oq.i().gx().apply(com.bytedance.sdk.openadsdk.i.r.j().j(10).j(Void.class).j(0, new com.bytedance.sdk.openadsdk.core.rn.la().j("downloadPath", com.bytedance.sdk.openadsdk.core.qv.g.j(aq))).xt());
            }
            if (xt.to && xt.im != null) {
                com.bytedance.sdk.openadsdk.core.live.xt.j().xt();
            }
            com.bytedance.sdk.openadsdk.core.wq.cw();
            com.bytedance.sdk.openadsdk.core.uf.j.j().j(v.getContext());
        }
    }

    private String kt(String str) {
        return "ad_slot_conf_".concat(String.valueOf(str));
    }

    public static String m() {
        return com.bytedance.sdk.openadsdk.core.r.j.ae() ? "tt_sdk_settings_slot_splash_bst" : "tt_sdk_settings_slot_splash";
    }

    public static String r() {
        return com.bytedance.sdk.openadsdk.core.r.j.ae() ? "tt_sdk_lp_w_list_bst" : "tt_sdk_lp_w_list";
    }

    public static String up() {
        return com.bytedance.sdk.openadsdk.core.r.j.ae() ? "tt_sdk_settings_slot_bst" : "tt_sdk_settings_slot";
    }

    private static boolean vl(int i6) {
        return i6 == 0 || i6 == 1 || i6 == 2;
    }

    public boolean ae() {
        return this.al == 1;
    }

    public String av() {
        if (TextUtils.isEmpty(this.yl)) {
            String xt = xt().xt("url_stats", "api-access.pangolin-sdk-toutiao1.com");
            this.yl = xt;
            if (TextUtils.isEmpty(xt)) {
                this.yl = "api-access.pangolin-sdk-toutiao1.com";
            }
        }
        return this.yl;
    }

    public int az() {
        if (this.av == Integer.MIN_VALUE) {
            this.av = xt().xt("app_express_gesture_priority", -1);
        }
        return this.av;
    }

    public boolean f() {
        if (this.ff == Integer.MAX_VALUE) {
            this.ff = xt().xt("adlog_monitor", 1);
        }
        return this.ff != 0;
    }

    public String i() {
        if (TextUtils.isEmpty(this.qe)) {
            this.qe = xt().xt("img_bucket", "https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/csj_assets/");
        }
        return this.qe;
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.up
    public synchronized void j() {
        xt();
        this.et = true;
        this.xq = this.cw.xt("adlog_exception_batch", 100);
        this.yl = this.cw.xt("url_stats", "api-access.pangolin-sdk-toutiao1.com");
        this.al = this.cw.xt("mini_game_preload", 1);
        this.qe = this.cw.xt("img_bucket", "https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/csj_assets/");
        this.px = this.cw.xt("enable_apm_pv", false);
        this.ri = this.cw.xt("url_alog", "log-api.pangolin-sdk-toutiao-b.com/service/2/app_log/");
        this.ed = this.cw.xt("xpath", "");
        this.uf = this.cw.xt("data_time", 0L);
        this.nt = this.cw.xt("fetch_template", 3600);
        this.f29827y = this.cw.xt("vbtt", 5);
        this.la = this.cw.xt("template_ids", this.fs);
        this.f29815n = this.cw.xt("pyload_h5", this.fs);
        this.nd = wq.j(this.cw.xt("insert_js_config", this.fs));
        this.ol = this.cw.xt("splash_check_type", 1);
        this.f29812k = this.cw.xt("adlog_debug", 0);
        this.sm = this.cw.xt("adlog_batch", 10);
        this.ya = this.cw.xt("adlog_interval", 5000L);
        this.xq = this.cw.xt("adlog_exception_batch", 100);
        this.ff = this.cw.xt("adlog_monitor", 1);
        this.f29825w = this.cw.xt("enable_ttvideo", -1);
        this.mi = this.cw.xt("enable_zaid", 0);
        this.kc = this.cw.xt("enable_dl_ext", this.ry);
        this.aq = this.cw.xt("ext_use_type", this.zz);
        this.f29811j = this.cw.xt("launch_strategy", 0);
        this.tj = this.cw.xt("dl_popup_duration", 1000);
        this.f29807f = this.cw.xt("opt_show_check", 0);
        this.sj = tj.cw(this.cw.xt("tpl_timeout_ctrl", ""));
        MultiWebview.setMaxWebViewCount(this.cw.xt("open_webview_count", 0));
        String xt = this.cw.xt("digest", "");
        if (!TextUtils.isEmpty(xt)) {
            try {
                this.wq = new JSONObject(xt);
            } catch (Exception e6) {
                vl.j(e6);
            }
        }
        String xt2 = this.cw.xt("pitaya_general_settings", "");
        if (!TextUtils.isEmpty(xt2)) {
            try {
                this.st = new JSONObject(xt2);
            } catch (Exception e7) {
                vl.j(e7);
            }
        }
        String xt3 = this.cw.xt("dl_notification", "");
        if (!TextUtils.isEmpty(xt3)) {
            try {
                this.hw = new JSONObject(xt3);
            } catch (Exception unused) {
            }
        }
        String xt4 = this.cw.xt("live_stream_cof", "");
        if (!TextUtils.isEmpty(xt4)) {
            try {
                this.kk = new JSONObject(xt4);
            } catch (Exception e8) {
                vl.r("parse exception", "e:" + e8.getMessage());
            }
        }
        this.dj = this.cw.xt("disable_show_url", 0);
        String xt5 = this.cw.xt("sensor_direction", "");
        if (!TextUtils.isEmpty(xt5)) {
            try {
                this.zk = new JSONObject(xt5);
            } catch (Exception e9) {
                vl.r("parse ex", "e:" + e9.getMessage());
            }
        }
        String xt6 = this.cw.xt("pitaya_business_conf", "");
        if (!TextUtils.isEmpty(xt6)) {
            try {
                this.ja = new JSONObject(xt6);
            } catch (Exception e10) {
                vl.r("parse exception", "e:" + e10.getMessage());
            }
        }
        String xt7 = this.cw.xt("http_drop", "");
        if (!TextUtils.isEmpty(xt7)) {
            try {
                this.pz = new JSONObject(xt7);
            } catch (Exception e11) {
                vl.j(e11);
            }
        }
        this.qa = this.cw.xt("stats_batch", 5);
        this.rr = this.cw.xt("switch_audio_focus", 0);
        this.f29824v = this.cw.xt("download_receiver_enable", 1);
        this.ln = this.cw.xt("event_switch", this.wf);
        this.xt = this.cw.xt("pre_fetch_cnt", 10);
        this.f29818q = this.cw.xt("if_both_open", 0);
        this.f29809h = this.cw.xt("tpl_infos", this.fs);
        this.pm = this.cw.xt("gnd_prefetch_cache_ttl", 0L);
        this.ay = this.cw.xt("gnd_prefetch_cache_size", 5);
        this.zs = this.cw.xt("global_rate", 1.0f);
        this.hh = this.cw.xt("app_list_control", 0);
        this.ki = this.cw.xt("max_tpl_cnts", 100);
        this.f29821t = this.cw.xt("fetch_tpl_timeout_ctrl", 5000);
        this.uq = this.cw.xt("interact_show_after_time", 500);
        this.ik = this.cw.xt("fetch_tpl_timeout_ctrl_bad_device", 300);
        this.ka = this.cw.xt("tpl_render_error_rate_h5", 4.5f);
        this.wo = this.cw.xt("tpl_enable_render_timeout_opt", false);
        this.f29823u = this.cw.xt("tpl_render_error_rate_native", 1.0f);
        this.mm = this.cw.xt("enable", false);
        this.qo = this.cw.xt("mid_value", 8.5f);
        this.ll = this.cw.xt("low_value", 7.3f);
        this.oy = this.cw.xt("open_single_abi", false);
        this.ju = this.cw.xt("show_callback_mult", 0);
        this.fx = this.cw.xt("webview_cache_count", 3);
        this.na = this.cw.xt("webview_cache_count_v3", 3);
        this.gr = this.cw.xt("webview_render_concurrent_count", 2);
        this.hu = this.cw.xt("policy_url", lx);
        this.ek = Boolean.valueOf(this.cw.xt("use_mediation_map", false));
        this.f29828z = this.cw.xt("hit_app_list_time", 0L);
        this.hl.clear();
        this.kt = this.cw.xt("apm_pv_config", "");
        this.xw = this.cw.xt("dyn_draw_engine_url", "https://sf3-fe-tos.pglstatp-toutiao.com/obj/ad-pattern/renderer/package.json");
        this.f29805d = this.cw.xt("play_component_ugen_engine_url", "");
        this.wi = this.cw.xt("ad_pkg_info_url", "apps.bytesfield.com");
        this.tk = this.cw.xt("sp_key_if_sp_cache", 1);
        this.az = this.cw.xt("express_gesture_enable", 0);
        this.f29810i = this.cw.xt("enable_download_proto", 1);
        this.av = this.cw.xt("app_express_gesture_priority", -1);
        this.ve = this.cw.xt("splash_close_text", "跳过");
        this.f29802a = this.cw.xt("network_module", 1);
        com.bytedance.sdk.component.xt.j.j.j.j().j(this.f29802a != 2);
        this.f29814m = this.cw.xt("web_upload_enable", 0);
        Set<String> xt8 = this.cw.xt("web_upload_content_type", Collections.synchronizedSet(new HashSet()));
        this.ae.clear();
        if (xt8 != null && xt8.size() != 0) {
            Iterator<String> it = xt8.iterator();
            while (it.hasNext()) {
                this.ae.add(it.next());
            }
        }
        this.tl = this.cw.xt("web_upload_send_restowv", 0);
        this.f29808g = this.cw.xt("web_upload_max_single_file", 2);
        this.oq = this.cw.xt("web_upload_max_zip_file", 5);
        this.ws = this.cw.xt("web_upload_max_retry", 0);
        this.vl = this.cw.xt("web_upload_report_url", "https://api-access.pangolin-sdk-toutiao.com/v2/inspect/aegis/client/page/");
        this.jy = this.cw.xt("web_upload_storage_type", 0);
        this.qv = this.cw.xt("web_upload_report_only_wifi", 0);
        Set<String> xt9 = this.cw.xt("hit_app_list_data", Collections.synchronizedSet(new HashSet()));
        if (xt9 != null && !xt9.isEmpty()) {
            Iterator<String> it2 = xt9.iterator();
            while (it2.hasNext()) {
                this.hl.add(it2.next());
            }
        }
        synchronized (this.f29803b) {
            try {
                this.f29803b.clear();
                Set<String> xt10 = this.cw.xt("scheme_list_data", Collections.synchronizedSet(new HashSet()));
                if (xt10 != null && !xt10.isEmpty()) {
                    Iterator<String> it3 = xt10.iterator();
                    while (it3.hasNext()) {
                        this.f29803b.add(it3.next());
                    }
                }
            } finally {
            }
        }
        synchronized (this.f29806e) {
            try {
                this.f29806e.clear();
                Set<String> xt11 = this.cw.xt("top_scheme_list_data", Collections.synchronizedSet(new HashSet()));
                if (xt11 != null && !xt11.isEmpty()) {
                    Iterator<String> it4 = xt11.iterator();
                    while (it4.hasNext()) {
                        this.f29806e.add(it4.next());
                    }
                }
            } finally {
            }
        }
        String xt12 = this.cw.xt("download_sdk_config", "");
        this.gx = xt12;
        if (!TextUtils.isEmpty(xt12)) {
            try {
                this.f29804c = new JSONObject(this.gx);
            } catch (JSONException e12) {
                vl.cw("TTSdkSettings", e12);
            }
        }
        String xt13 = this.cw.xt("thread_config", "");
        if (!TextUtils.isEmpty(xt13)) {
            try {
                this.yb = new JSONObject(xt13);
                com.bytedance.sdk.openadsdk.core.h.j.xt();
            } catch (JSONException e13) {
                vl.cw("TTSdkSettings", e13);
            }
        }
        this.ov = this.cw.xt("call_stack_rate", 0.0f);
        this.rs = this.cw.xt("read_video_from_cache", 1);
        this.jl = this.cw.xt("brand_video_cache_count", 2);
        this.f29816o = this.cw.xt("enable_bw_screen_detection", false);
        this.el = this.cw.xt("splash_card_show_max_count", 3);
        this.f29826x = com.bytedance.sdk.openadsdk.core.ae.xt.j(this.cw.xt("clog_config", this.fs));
        this.ch = com.bytedance.sdk.openadsdk.core.dislike.r.j(this.cw.xt("oncall_upload", ""));
        this.f29820s = this.cw.xt("check_live_room", false);
        this.to = this.cw.xt("can_init_live", true);
        this.ej = this.cw.xt("new_app_list", false);
        String xt14 = this.cw.xt("plugin_update_state", "");
        if (!TextUtils.isEmpty(xt14)) {
            try {
                this.ot = new JSONObject(xt14);
            } catch (JSONException e14) {
                vl.j(e14);
            }
        }
        String xt15 = this.cw.xt("antispam_autoclick_detect", "");
        if (!TextUtils.isEmpty(xt15)) {
            try {
                this.cb = new JSONObject(xt15);
                com.bytedance.sdk.component.panglearmor.xt.up.j().j(this.cb);
            } catch (JSONException e15) {
                vl.j(e15);
            }
        }
        String xt16 = this.cw.xt("app_live_config", "");
        if (!TextUtils.isEmpty(xt16)) {
            try {
                this.so = xt.j(new JSONObject(xt16));
            } catch (JSONException unused2) {
            }
        }
        this.by = this.cw.xt("pglam_main_enable", 0);
        this.yu = this.cw.xt("pglam_dns_check_enable", 0);
        this.f0if = this.cw.xt("pglam_clazz_check", "");
        this.os = this.cw.xt("ud_enable", 1);
        this.xj = zw().getInt("is_kv_cache_type", 0);
        this.lo = zw().getInt("kv_init_type", 0);
        this.uo = this.cw.xt("open_dl_type", 0);
        this.nv = this.cw.xt("app_dl_scheme_list", "");
        int xt17 = this.cw.xt("lp_url_sw", 0);
        this.vr = xt17;
        if (xt17 == 1) {
            this.id = mm().xt("lp_list", "");
        }
        this.kj = zw().getString(TKDownloadReason.KSAD_TK_MD5, "");
        String string = zw().getString("url", "");
        this.hk = string;
        com.bytedance.sdk.openadsdk.core.g.j.r.j.j(this.kj, string);
        this.fk = this.cw.xt("is_open_isw", 1);
        String xt18 = this.cw.xt("live_sdk_conf", this.fs);
        if (!TextUtils.isEmpty(xt18)) {
            this.im = gx.j(xt18);
        }
        this.up = this.cw.xt("npth_enable_type", 0);
        this.fp = this.cw.xt("scheme_get_type", 0);
        this.ym = this.cw.xt("scheme_get_num", 1);
        this.sf = this.cw.xt("if_query_all_package", 0);
        this.fj = this.cw.xt("is_sp_send_meta", true);
        this.zi = ae.j(this.cw.xt("opt_config", ""));
        this.fz = m.j(this.cw.xt("kv_config", ""));
        this.zw = this.cw.xt("is_first_plugin_resources", false);
        this.lw = this.cw.xt("m_vids_join", 0);
        this.xc = this.cw.xt("mini_event_upload_version", 0);
        this.lc = this.cw.xt("bg_web_readd_t", 3000L);
        this.vu = this.cw.xt("title_priority", 0);
        this.lg = this.cw.xt("splash_video_opt_enable", 0);
        this.ag = this.cw.xt("gesture_through_enable", 0);
        this.qf = this.cw.xt("refresh_req_num", 2);
        this.vm = this.cw.xt("refresh_max_times", 1);
        this.mz = this.cw.xt("settings_open", 1);
        this.mp = this.cw.xt("shake_trigger_control", 0);
        this.xa = this.cw.xt("preload_switch", false);
        this.si = this.cw.xt("preload_time_point", 0);
        this.ar = this.cw.xt("is_adapt_density", false);
        this.nw = this.cw.xt("app_info_cache_switch", false);
        this.zd = this.cw.xt("disable_easy_playable", false);
        this.yv = this.cw.xt("enable_target_34", 1);
        this.bh = this.cw.xt("enable_xm_market", 1);
        this.rf = this.cw.xt("disable_repeat_render", true);
        this.f29822tv = this.cw.xt("status_bar_adapt", 1);
        this.qn = this.cw.xt("view_check_by_window", false);
        this.mc = this.cw.xt("shake_twist_bind_show", false);
        this.fv = this.cw.xt("view_check_by_click", false);
        gq.xt(this.cw);
        e.xt(this.cw);
        com.bytedance.sdk.openadsdk.core.tj.tl.j(this.cw);
        mi.xt(this.cw);
        p.j(this.cw);
        la.j(this.cw);
        String xt19 = this.cw.xt("video_cache_config", "");
        if (!TextUtils.isEmpty(xt19)) {
            try {
                JSONObject jSONObject = new JSONObject(xt19);
                this.ig = jSONObject;
                com.bykv.vk.openvk.component.video.j.j.j(jSONObject);
            } catch (JSONException e16) {
                vl.j(e16);
            }
        }
        String xt20 = this.cw.xt("log_rate_conf", "");
        if (!TextUtils.isEmpty(xt20)) {
            try {
                this.qg = new JSONObject(xt20);
            } catch (Exception unused3) {
            }
        }
        try {
            this.ih = this.cw.xt("ad_slot_conf_block", "");
            JSONObject jSONObject2 = new JSONObject(this.ih);
            if (jSONObject2.length() > 0) {
                this.km.clear();
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    this.km.put(next, jSONObject2.opt(next));
                }
            }
        } catch (Exception unused4) {
        }
        g();
    }

    public boolean jy() {
        if (this.mi == Integer.MIN_VALUE) {
            this.mi = xt().xt("enable_zaid", 0);
        }
        return this.mi != 0;
    }

    public void mi() {
        this.uc = "api-access.pangolin-sdk-toutiao-b.com";
    }

    public boolean oq() {
        return this.mp == 1;
    }

    public String qv() {
        if (TextUtils.isEmpty(this.uc)) {
            this.uc = com.bytedance.sdk.openadsdk.core.cw.cw.j().r();
        }
        return this.uc;
    }

    public boolean tj() {
        if (this.f29812k == Integer.MAX_VALUE) {
            this.f29812k = xt().xt("adlog_debug", 0);
        }
        return this.f29812k == 1;
    }

    public com.bytedance.sdk.component.r.j.xt tl() {
        if (this.nu == null) {
            this.nu = h.j(up());
        }
        if (h.xt() != 1) {
            return null;
        }
        return this.nu;
    }

    public long v() {
        if (this.ya == 2147483647L) {
            this.ya = xt().xt("adlog_interval", 5000L);
        }
        return this.ya;
    }

    public boolean w() {
        boolean xt = xt().xt("enable_apm_pv", false);
        this.px = xt;
        return xt;
    }

    public boolean ws() {
        if (this.az == Integer.MIN_VALUE) {
            this.az = xt().xt("express_gesture_enable", 0);
        }
        return this.az == 1;
    }

    public synchronized boolean xj() {
        try {
            if (!sz) {
                er = this.zd;
                sz = true;
            }
        } catch (Throwable th) {
            throw th;
        }
        return er;
    }

    public com.bytedance.sdk.component.r.j.xt xt() {
        if (this.cw == null) {
            this.cw = h.j(cw());
        }
        return this.cw;
    }

    private static j cw(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("code_id");
        boolean j6 = a.j(jSONObject, "enable_bidding_cache", false);
        long j7 = a.j(jSONObject, "bidding_cache_skip_time", 0L);
        boolean j8 = a.j(jSONObject, "enable_bidding_pre_fetch", false);
        int j9 = a.j(jSONObject, "auto_play", 1);
        int j10 = a.j(jSONObject, "voice_control", 1);
        int j11 = a.j(jSONObject, "voice_control", 0);
        int j12 = a.j(jSONObject, "rv_preload", 2);
        int j13 = a.j(jSONObject, "nv_preload", 1);
        int j14 = a.j(jSONObject, "sp_preload", 0);
        int j15 = a.j(jSONObject, "skip_time_displayed", 0);
        int j16 = a.j(jSONObject, "reg_creative_control", 1);
        int j17 = a.j(jSONObject, "rv_skip_time", 0);
        int j18 = a.j(jSONObject, "iv_skip_time", 0);
        int j19 = a.j(jSONObject, "if_show_win", 1);
        int j20 = a.j(jSONObject, "stop_time", 1500);
        boolean j21 = a.j(jSONObject, "close_on_click", false);
        int j22 = a.j(jSONObject, "splash_load_type", 2);
        int j23 = a.j(jSONObject, "splash_buffer_time", 100);
        int j24 = a.j(jSONObject, "time_out_control", 2000);
        int j25 = a.j(jSONObject, "time_out_control_type", 0);
        int j26 = a.j(jSONObject, "slot_type", -1);
        return j.j().j(optString).g(j9).oq(!vl(j10) ? 1 : j10).qv(j12).vl(j13).jy(j15).ws(j16).ae(j17).m(vl(j11) ? j11 : 0).az(j19).r(j14).up(j20).cw(j24).av(j22).i(j23).tl(j18).cw(j21).w(j25).j(j7).xt(j6).j(j8).xt(j26).j(a.j(jSONObject, "refresh_rit_sw", 0));
    }

    private com.bytedance.sdk.component.r.j.xt mm() {
        if (this.f29819r == null) {
            this.f29819r = h.j(r());
        }
        return this.f29819r;
    }

    private void zi() {
        com.bytedance.sdk.component.oq.ae.xt(new com.bytedance.sdk.component.oq.g("") { // from class: com.bytedance.sdk.openadsdk.core.p.oq.2
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.core.ch.xt.j.j();
            }
        });
    }

    private SharedPreferences zw() {
        if (this.om == null) {
            this.om = com.bytedance.sdk.openadsdk.api.plugin.xt.xt(v.getContext(), cw(), 0);
        }
        return this.om;
    }

    public boolean a() {
        if (this.f29824v == Integer.MAX_VALUE) {
            this.f29824v = xt().xt("download_receiver_enable", 1);
        }
        return this.f29824v != 0;
    }

    public boolean ae(String str) {
        return str == null || v.xt().w(str).vl == 1;
    }

    public String ag() {
        if (TextUtils.isEmpty(this.kj)) {
            this.kj = zw().getString(TKDownloadReason.KSAD_TK_MD5, "");
        }
        return this.kj;
    }

    public xt ay() {
        return this.so;
    }

    public int b() {
        if (this.qv == Integer.MAX_VALUE) {
            this.qv = xt().xt("web_upload_report_only_wifi", 0);
        }
        return this.qv;
    }

    public int by() {
        return this.f29822tv;
    }

    public JSONObject c() {
        if (this.wq == null) {
            String xt = xt().xt("digest", "");
            if (!TextUtils.isEmpty(xt)) {
                try {
                    this.wq = new JSONObject(xt);
                } catch (Exception unused) {
                }
            }
        }
        return this.wq;
    }

    public boolean cb() {
        return this.mm;
    }

    public boolean ch() {
        if (this.kc == this.ry) {
            this.kc = xt().xt("enable_dl_ext", this.ry);
        }
        return this.kc == 1;
    }

    public int d() {
        if (this.qf == Integer.MAX_VALUE) {
            this.qf = xt().xt("refresh_req_num", 2);
        }
        if (this.qf <= 0) {
            this.qf = 2;
        }
        return this.qf;
    }

    public void dj() {
        if (this.ij == null) {
            synchronized (this.gs) {
                try {
                    if (this.ij == null) {
                        this.ij = com.bytedance.sdk.openadsdk.api.plugin.xt.xt(v.getContext(), m(), 0);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public String e() {
        if (TextUtils.equals(this.vl, "https://api-access.pangolin-sdk-toutiao.com/v2/inspect/aegis/client/page/")) {
            this.vl = xt().xt("web_upload_report_url", "https://api-access.pangolin-sdk-toutiao.com/v2/inspect/aegis/client/page/");
        }
        return this.vl;
    }

    public String ed() {
        if (TextUtils.isEmpty(this.ed)) {
            this.ed = xt().xt("xpath", "");
        }
        return this.ed;
    }

    public boolean ej() {
        return this.fj;
    }

    public float el() {
        if (this.f29823u == 0.0f) {
            this.f29823u = xt().xt("tpl_render_error_rate_native", 1.0f);
        }
        return this.f29823u;
    }

    public JSONObject et() {
        if (this.ig == null) {
            try {
                String xt = xt().xt("video_cache_config", "");
                if (!TextUtils.isEmpty(xt)) {
                    this.ig = new JSONObject(xt);
                }
            } catch (Throwable th) {
                vl.xt("TTSdkSettings", th.getMessage());
            }
        }
        return this.ig;
    }

    public ae fk() {
        return this.zi;
    }

    public int fp() {
        if (this.na == Integer.MAX_VALUE) {
            this.na = xt().xt("webview_cache_count_v3", 3);
        }
        int i6 = this.na;
        if (i6 < 0) {
            return 3;
        }
        return i6;
    }

    public boolean fs() {
        return this.rf;
    }

    public boolean fx() {
        if (!TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.h.cw) && com.bytedance.sdk.openadsdk.core.h.cw.compareTo(com.bytedance.sdk.openadsdk.core.h.tl) < 0) {
            return false;
        }
        Boolean bool = this.cr;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (this.ek == null) {
            this.ek = Boolean.valueOf(xt().xt("use_mediation_map", false));
        }
        Boolean bool2 = this.ek;
        this.cr = bool2;
        return bool2.booleanValue();
    }

    public boolean fz() {
        return this.f29820s;
    }

    public boolean gq() {
        if (this.f29811j == 0) {
            this.f29811j = xt().xt("launch_strategy", 0);
        }
        return this.f29811j == 1;
    }

    public int gr() {
        if (this.tk == Integer.MAX_VALUE) {
            this.tk = xt().xt("sp_key_if_sp_cache", 1);
        }
        return this.tk;
    }

    public boolean gs() {
        return this.ar;
    }

    public long gx() {
        if (this.uf == 0) {
            this.uf = xt().xt("data_time", 0L);
        }
        return this.uf;
    }

    public int h() {
        if (this.xt == 10) {
            this.xt = xt().xt("pre_fetch_cnt", 10);
        }
        return this.xt;
    }

    public int hh() {
        if (this.f29808g == Integer.MAX_VALUE) {
            this.f29808g = xt().xt("web_upload_max_single_file", 2);
        }
        return this.f29808g;
    }

    public JSONObject hk() {
        return this.ot;
    }

    public int hl() {
        if (this.ws == Integer.MAX_VALUE) {
            this.ws = xt().xt("web_upload_max_retry", 0);
        }
        return this.ws;
    }

    public float hu() {
        if (this.ll == 0.0f) {
            this.ll = xt().xt("low_value", 7.3f);
        }
        return this.ll;
    }

    public int hw() {
        if (this.ay == -1) {
            this.ay = xt().xt("gnd_prefetch_cache_size", 5);
        }
        return this.ay;
    }

    public boolean id() {
        return this.to;
    }

    /* renamed from: if, reason: not valid java name */
    public int m110if() {
        return this.el;
    }

    public int ig() {
        if (this.ik == 0) {
            this.ik = xt().xt("fetch_tpl_timeout_ctrl_bad_device", 300);
        }
        return this.ik;
    }

    public boolean ij() {
        return this.nw;
    }

    public com.bytedance.sdk.openadsdk.core.ae.xt im() {
        return this.f29826x;
    }

    public long ja() {
        if (this.pm == -1) {
            this.pm = xt().xt("gnd_prefetch_cache_ttl", 0L);
        }
        return this.pm;
    }

    public int jl() {
        if (this.uq == Integer.MAX_VALUE) {
            this.uq = xt().xt("interact_show_after_time", 500);
        }
        return this.uq;
    }

    public int k() {
        if (this.ol == Integer.MAX_VALUE) {
            this.ol = xt().xt("splash_check_type", 1);
        }
        return this.ol;
    }

    public boolean ka() {
        if (this.mz == Integer.MAX_VALUE) {
            this.mz = xt().xt("settings_open", 1);
        }
        return this.mz == 1;
    }

    public JSONObject kc() {
        if (this.qg == null) {
            try {
                this.qg = new JSONObject(xt().xt("log_rate_conf", ""));
            } catch (Exception unused) {
            }
        }
        return this.qg;
    }

    public String ki() {
        if (TextUtils.isEmpty(this.wi)) {
            this.wi = xt().xt("ad_pkg_info_url", "apps.bytesfield.com");
        }
        if (TextUtils.isEmpty(this.wi)) {
            this.wi = "apps.bytesfield.com";
        }
        return this.wi;
    }

    public boolean kj() {
        return this.ej;
    }

    public boolean kk() {
        return this.et;
    }

    public String kt() {
        if (TextUtils.isEmpty(this.ri)) {
            String xt = xt().xt("url_alog", "log-api.pangolin-sdk-toutiao-b.com/service/2/app_log/");
            this.ri = xt;
            if (TextUtils.isEmpty(xt)) {
                this.ri = "log-api.pangolin-sdk-toutiao-b.com/service/2/app_log/";
            }
        }
        return this.ri;
    }

    public boolean l() {
        if (this.rr == Integer.MAX_VALUE) {
            this.rr = xt().xt("switch_audio_focus", 0);
        }
        return this.rr == 1;
    }

    public long la() {
        if (this.aq == this.zz) {
            this.aq = xt().xt("ext_use_type", this.zz);
        }
        return this.aq;
    }

    public int lc() {
        return this.xj;
    }

    public String lg() {
        if (this.vr != 1) {
            return "";
        }
        if (!TextUtils.isEmpty(this.id)) {
            return this.id;
        }
        String xt = mm().xt("lp_list", this.id);
        this.id = xt;
        return xt;
    }

    public int ll() {
        if (this.lw == Integer.MAX_VALUE) {
            this.lw = xt().xt("m_vids_join", 0);
        }
        int i6 = this.lw;
        if (i6 == Integer.MAX_VALUE) {
            return 0;
        }
        return i6;
    }

    public JSONObject ln() {
        return this.ja;
    }

    public int lo() {
        return this.yu;
    }

    public boolean lv() {
        return this.qn;
    }

    public int lx() {
        if (this.fx == Integer.MAX_VALUE) {
            this.fx = xt().xt("webview_cache_count", 3);
        }
        int i6 = this.fx;
        if (i6 < 0) {
            return 3;
        }
        return i6;
    }

    public boolean mi(String str) {
        if (TextUtils.isEmpty(str) || str.equals(b.f50154a) || str.equals(b.f50155b)) {
            return false;
        }
        if (this.uo == 0) {
            this.uo = xt().xt("open_dl_type", 0);
        }
        int i6 = this.uo;
        if (i6 == 0) {
            return false;
        }
        if (i6 == 2) {
            return true;
        }
        return v(str);
    }

    public int mp() {
        return this.si;
    }

    public boolean mz() {
        if (this.os == 1) {
            this.os = xt().xt("ud_enable", 1);
        }
        return this.os == 1;
    }

    public float n() {
        if (this.ov < 0.0f) {
            this.ov = xt().xt("call_stack_rate", 0.0f);
        }
        return this.ov;
    }

    public List<String> na() {
        if (this.f29828z + bn.f10749e < System.currentTimeMillis()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = this.hl.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    public int nd() {
        if (this.f29814m == Integer.MAX_VALUE) {
            this.f29814m = xt().xt("web_upload_enable", 0);
        }
        return this.f29814m;
    }

    public boolean nt() {
        if (this.dj == Integer.MAX_VALUE) {
            this.dj = this.cw.xt("disable_show_url", 0);
        }
        return this.dj == 1;
    }

    public Set<String> nu() {
        if (this.f29806e.size() == 0) {
            return null;
        }
        return this.f29806e;
    }

    public float o() {
        if (this.ka == 0.0f) {
            this.ka = xt().xt("tpl_render_error_rate_h5", 4.5f);
        }
        return this.ka;
    }

    public int ol() {
        if (this.tl == Integer.MAX_VALUE) {
            this.tl = xt().xt("web_upload_send_restowv", 0);
        }
        return this.tl;
    }

    public boolean om() {
        if (this.hh == Integer.MAX_VALUE) {
            this.hh = xt().xt("app_list_control", 0);
        }
        return this.hh == 1;
    }

    public boolean oq(String str) {
        try {
            j w5 = v.xt().w(String.valueOf(str));
            if (w5 != null) {
                return w5.f29794i != null;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public int os() {
        return this.jl;
    }

    public boolean ot() {
        return this.zi.f29783j;
    }

    public List<String> ov() {
        if (this.f29828z + bn.f10749e < System.currentTimeMillis()) {
            return null;
        }
        Map<String, Boolean> xt = s.xt(86400000L);
        ArrayList arrayList = new ArrayList();
        synchronized (this.f29803b) {
            try {
                for (String str : this.f29803b) {
                    if (!xt.containsKey(str.replaceAll("[&\\?]?tt_csj_scheme_priority=[^&]*", ""))) {
                        arrayList.add(str);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        Collections.sort(arrayList, new Comparator<String>() { // from class: com.bytedance.sdk.openadsdk.core.p.oq.3
            @Override // java.util.Comparator
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public int compare(String str2, String str3) {
                try {
                    return Integer.parseInt(Uri.parse(str2).getQueryParameter("tt_csj_scheme_priority")) - Integer.parseInt(Uri.parse(str3).getQueryParameter("tt_csj_scheme_priority"));
                } catch (Throwable unused) {
                    return 0;
                }
            }
        });
        int size = arrayList.size();
        for (int i6 = 0; i6 < size; i6++) {
            arrayList.set(i6, ((String) arrayList.get(i6)).replaceAll("[&\\?]?tt_csj_scheme_priority=[^&]*", ""));
        }
        return arrayList;
    }

    public boolean oy() {
        return Build.VERSION.SDK_INT < this.xc;
    }

    public boolean p() {
        if (this.ln == this.wf) {
            this.ln = xt().xt("event_switch", this.wf);
        }
        return this.ln == 1;
    }

    public boolean px() {
        if (this.lg == Integer.MAX_VALUE) {
            this.lg = xt().xt("splash_video_opt_enable", 0);
        }
        return this.lg == 1;
    }

    public JSONObject pz() {
        return this.kk;
    }

    public int q() {
        if (this.jy == Integer.MAX_VALUE) {
            this.jy = xt().xt("web_upload_storage_type", 0);
        }
        return this.jy;
    }

    public JSONObject qa() {
        return this.hw;
    }

    public wq qb() {
        if (this.nd == null) {
            this.nd = wq.j(xt().xt("insert_js_config", ""));
        }
        return this.nd;
    }

    public boolean qe() {
        if (this.vu == Integer.MAX_VALUE) {
            this.vu = xt().xt("title_priority", 0);
        }
        return this.vu == 1;
    }

    public String qf() {
        if (TextUtils.isEmpty(this.hk)) {
            this.hk = zw().getString("url", "");
        }
        return this.hk;
    }

    public boolean qg() {
        return this.oy;
    }

    public boolean qo() {
        return this.sf == 1;
    }

    public Set<String> rh() {
        Set<String> xt;
        if (this.ae.isEmpty() && (xt = xt().xt("web_upload_content_type", Collections.synchronizedSet(new HashSet()))) != null && xt.size() != 0) {
            Iterator<String> it = xt.iterator();
            while (it.hasNext()) {
                this.ae.add(it.next());
            }
        }
        return this.ae;
    }

    public String ri() {
        if (TextUtils.isEmpty(this.f29805d)) {
            this.f29805d = xt().xt("play_component_ugen_engine_url", "");
        }
        return this.f29805d;
    }

    public boolean rn() {
        if (this.f29807f == Integer.MAX_VALUE) {
            this.f29807f = xt().xt("opt_show_check", 0);
        }
        return this.f29807f == 1;
    }

    public JSONObject rr() {
        return this.st;
    }

    public boolean rs() {
        if (this.ju == Integer.MAX_VALUE) {
            this.ju = xt().xt("show_callback_mult", 0);
        }
        return this.ju == 1;
    }

    public boolean ry() {
        if (this.zs == 2.1474836E9f) {
            this.zs = xt().xt("global_rate", 1.0f);
        }
        return ((float) ((int) this.zs)) == 1.0f;
    }

    public int s() {
        if (this.qa == 3) {
            this.qa = xt().xt("stats_batch", 5);
        }
        int i6 = this.qa;
        if (i6 <= 0 || i6 > 100) {
            return 5;
        }
        return i6;
    }

    public int sf() {
        if (this.bh == Integer.MAX_VALUE) {
            this.bh = xt().xt("enable_xm_market", 1);
        }
        return this.bh;
    }

    public boolean sh() {
        return this.ua;
    }

    public JSONObject sm() {
        if (this.f29804c == null) {
            String xt = xt().xt("download_sdk_config", "");
            this.gx = xt;
            if (!TextUtils.isEmpty(xt)) {
                try {
                    this.f29804c = new JSONObject(this.gx);
                } catch (JSONException e6) {
                    vl.j(e6);
                }
            }
        }
        return this.f29804c;
    }

    public boolean so() {
        return this.zi.cw;
    }

    public JSONObject st() {
        if (this.pz == null) {
            String xt = xt().xt("http_drop", "");
            if (!TextUtils.isEmpty(xt)) {
                try {
                    this.pz = new JSONObject(xt);
                } catch (Exception e6) {
                    vl.j(e6);
                }
            }
        }
        return this.pz;
    }

    public String t() {
        if (TextUtils.isEmpty(this.ve)) {
            this.ve = xt().xt("splash_close_text", "跳过");
        }
        if (TextUtils.isEmpty(this.ve)) {
            this.ve = "跳过";
        }
        return this.ve;
    }

    public String tk() {
        if (TextUtils.isEmpty(this.hu)) {
            this.hu = xt().xt("policy_url", lx);
        }
        return this.hu;
    }

    public boolean u() {
        return this.fp != 1;
    }

    public boolean ua() {
        return this.fv;
    }

    public String uc() {
        if (TextUtils.isEmpty(this.xw)) {
            this.xw = xt().xt("dyn_draw_engine_url", "https://sf3-fe-tos.pglstatp-toutiao.com/obj/ad-pattern/renderer/package.json");
        }
        return this.xw;
    }

    public boolean uf() {
        if (this.qb == Integer.MAX_VALUE) {
            this.qb = 1;
        }
        return this.qb == 1;
    }

    public boolean uh() {
        return this.mc;
    }

    public m ve() {
        return this.fz;
    }

    public boolean vl() {
        if (this.f29825w == -1) {
            this.f29825w = xt().xt("enable_ttvideo", -1);
        }
        int i6 = this.f29825w;
        if (i6 == 0) {
            return false;
        }
        return (i6 == 1 && (ch.mi() || ch.w())) ? false : true;
    }

    public boolean vm() {
        return this.xa;
    }

    public String[] vr() {
        String str = this.f0if;
        if (str == null || str.length() <= 0) {
            return null;
        }
        return this.f0if.split("//");
    }

    public int vu() {
        if (this.lo == 0) {
            this.lo = zw().getInt("kv_init_type", 0);
        }
        return this.lo;
    }

    public j w(String str) {
        if (str == null) {
            return cw(new JSONObject());
        }
        j jVar = this.f29813l.get(str);
        if (jVar == null) {
            jVar = f(str);
        }
        if (jVar != null) {
            return jVar;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code_id", str);
            return cw(jSONObject);
        } catch (JSONException e6) {
            throw new RuntimeException(e6);
        }
    }

    public JSONObject wf() {
        return this.zk;
    }

    public int wi() {
        if (this.vm == Integer.MAX_VALUE) {
            this.vm = xt().xt("refresh_max_times", 1);
        }
        if (this.vm < 0) {
            this.vm = 1;
        }
        return this.vm;
    }

    public int wo() {
        int i6 = this.ym;
        if (i6 <= 0) {
            return 1;
        }
        return i6;
    }

    public int wq() {
        if (this.xq == Integer.MAX_VALUE) {
            this.xq = xt().xt("adlog_exception_batch", 100);
        }
        return this.xq;
    }

    public int x() {
        if (this.sm == Integer.MAX_VALUE) {
            this.sm = xt().xt("adlog_batch", 10);
        }
        return this.sm;
    }

    public int xc() {
        if (this.xj == 0) {
            this.xj = zw().getInt("is_kv_cache_type", 0);
        }
        return this.xj;
    }

    public gx xp() {
        return this.im;
    }

    public JSONObject xq() {
        return this.yb;
    }

    public boolean xw() {
        if (this.ag == Integer.MAX_VALUE) {
            this.ag = xt().xt("gesture_through_enable", 0);
        }
        return this.ag == 1;
    }

    public com.bytedance.sdk.openadsdk.core.dislike.r y() {
        return this.ch;
    }

    public com.bytedance.sdk.openadsdk.core.az.j.j ya() {
        if (this.rh == null) {
            this.rh = com.bytedance.sdk.openadsdk.core.az.j.j.j(xt().xt("white_check_config", ""));
        }
        return this.rh;
    }

    public boolean yb() {
        if (!this.wo) {
            this.wo = xt().xt("tpl_enable_render_timeout_opt", false);
        }
        return this.wo;
    }

    public long yl() {
        if (this.lc == 2147483647L) {
            this.lc = xt().xt("bg_web_readd_t", 3000L);
        }
        return this.lc;
    }

    public int ym() {
        if (this.f29827y == Integer.MAX_VALUE) {
            this.f29827y = xt().xt("vbtt", 5);
        }
        return this.f29827y;
    }

    public boolean yu() {
        if (this.rs == Integer.MAX_VALUE) {
            this.rs = xt().xt("read_video_from_cache", 1);
        }
        return this.rs == 1;
    }

    public int z() {
        if (this.oq == Integer.MAX_VALUE) {
            this.oq = xt().xt("web_upload_max_zip_file", 5);
        }
        return this.oq;
    }

    public int zk() {
        if (this.yv == Integer.MAX_VALUE) {
            this.yv = xt().xt("enable_target_34", 1);
        }
        return this.yv;
    }

    public int zs() {
        if (this.ki == Integer.MAX_VALUE) {
            this.ki = xt().xt("max_tpl_cnts", 100);
        }
        return this.ki;
    }

    public String zz() {
        if (TextUtils.isEmpty(this.kt)) {
            this.kt = xt().xt("apm_pv_config", "");
        }
        return this.kt;
    }

    public oq() {
        int cw = com.bytedance.sdk.openadsdk.j.xt.xt.cw();
        this.wf = cw;
        this.ln = cw;
        this.xp = "live_sdk_conf";
        this.f29827y = Integer.MAX_VALUE;
        this.nt = Integer.MAX_VALUE;
        this.uc = null;
        this.ri = null;
        this.ki = Integer.MAX_VALUE;
        this.f29821t = Integer.MAX_VALUE;
        this.uq = Integer.MAX_VALUE;
        this.ik = 0;
        this.ka = 0.0f;
        this.f29823u = 0.0f;
        this.wo = false;
        this.qo = 8.5f;
        this.ll = 7.3f;
        this.xw = null;
        this.f29805d = null;
        this.wi = "apps.bytesfield.com";
        this.tk = Integer.MAX_VALUE;
        this.fx = Integer.MAX_VALUE;
        this.na = 3;
        this.gr = 2;
        this.et = false;
        this.ov = -1.0f;
        this.zs = 2.1474836E9f;
        this.qg = null;
        this.rs = Integer.MAX_VALUE;
        this.jl = 2;
        this.ig = null;
        this.yb = null;
        this.f29816o = false;
        this.el = 3;
        this.fp = 0;
        this.ym = 1;
        this.dj = Integer.MAX_VALUE;
        this.zk = null;
        this.sf = 0;
        this.fs = null;
        this.by = 0;
        this.yu = 0;
        this.f0if = null;
        this.os = 1;
        this.to = true;
        this.ej = false;
        this.ot = null;
        this.fk = 1;
        this.ve = "跳过";
        this.xj = 0;
        this.fz = new m();
        this.lo = 0;
        this.vr = 0;
        this.id = "";
        this.kj = "21ea2d6d4f321553dd684e6b864bf0b7";
        this.hk = "https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/uchain/20103/uchain_dsl.bin";
        this.ay = -1;
        this.pm = -1L;
        this.xc = 0;
        this.lc = 2147483647L;
        this.vu = Integer.MAX_VALUE;
        this.lg = Integer.MAX_VALUE;
        this.ag = Integer.MAX_VALUE;
        this.qf = Integer.MAX_VALUE;
        this.vm = Integer.MAX_VALUE;
        this.mz = Integer.MAX_VALUE;
        this.sh = null;
        this.cb = null;
        this.ij = null;
        this.gs = new Object();
        this.cw = null;
        this.lv = null;
        this.uh = false;
        this.ua = false;
        this.mm = false;
        this.up = 0;
        this.zi = new ae();
        this.fj = true;
        this.zw = false;
        this.uo = 0;
        this.lw = Integer.MAX_VALUE;
        this.xa = false;
        this.si = 0;
        this.km = new HashMap();
        this.ih = "";
        this.ek = null;
        this.cr = null;
        this.ar = false;
        this.qn = false;
        this.mc = false;
        this.fv = false;
        this.ju = Integer.MAX_VALUE;
        this.zd = false;
        this.yv = Integer.MAX_VALUE;
        this.bh = Integer.MAX_VALUE;
        this.rf = true;
        this.al = 1;
        this.f29822tv = 1;
    }

    public boolean aq() {
        return com.bytedance.sdk.openadsdk.core.cw.up.j().tl();
    }

    public boolean ff() {
        if (k() == 1) {
            return true;
        }
        return false;
    }

    public boolean ik() {
        int uq = uq();
        if ((uq == 40001 || uq == 40002 || uq == 4) && com.bytedance.sdk.component.panglearmor.g.xt()) {
            return true;
        }
        return false;
    }

    public boolean pm() {
        if (com.bytedance.sdk.openadsdk.core.h.m() && this.fk == 1) {
            return true;
        }
        return false;
    }

    public int to() {
        int xt = xt().xt("npth_enable_type", 0);
        this.up = xt;
        return xt;
    }

    public int uq() {
        return com.bytedance.sdk.openadsdk.core.cw.up.j().g();
    }

    private j f(String str) {
        String xt;
        com.bytedance.sdk.component.r.j.xt tl = tl();
        j jVar = null;
        try {
            if (tl != null) {
                xt = tl.xt(kt(str), "");
            } else {
                if (this.sh == null) {
                    this.sh = com.bytedance.sdk.openadsdk.api.plugin.xt.xt(v.getContext(), up(), 0);
                }
                xt = this.sh.getString(kt(str), "");
            }
            if (TextUtils.isEmpty(xt)) {
                return null;
            }
            jVar = cw(new JSONObject(xt));
            this.f29813l.put(str, jVar);
            return jVar;
        } catch (Throwable th) {
            vl.xt("TTSdkSetting", "buildSlot failed:" + th.getMessage());
            return jVar;
        }
    }

    private void m(JSONObject jSONObject) {
        int length;
        SharedPreferences.Editor editor;
        JSONArray optJSONArray = jSONObject.optJSONArray("ad_slot_conf_list");
        if (optJSONArray == null || (length = optJSONArray.length()) <= 0) {
            return;
        }
        this.f29813l.clear();
        dj();
        com.bytedance.sdk.component.r.j.xt tl = tl();
        SharedPreferences.Editor editor2 = null;
        if (tl == null) {
            if (this.sh == null) {
                this.sh = com.bytedance.sdk.openadsdk.api.plugin.xt.xt(v.getContext(), up(), 0);
            }
            editor = this.sh.edit();
        } else {
            editor = null;
        }
        for (int i6 = 0; i6 < length; i6++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i6);
            j cw = cw(optJSONObject);
            if (cw != null) {
                this.f29813l.put(cw.f29795j, cw);
                if (com.bytedance.sdk.openadsdk.core.cw.r.j().ae(cw.cw())) {
                    if (editor2 == null && this.ij != null) {
                        editor2 = this.ij.edit();
                    }
                    if (editor2 != null) {
                        editor2.putString(kt(cw.f29795j), optJSONObject.toString());
                    }
                }
                if (tl != null) {
                    tl.j(kt(cw.f29795j), optJSONObject.toString());
                } else if (editor != null) {
                    editor.putString(kt(cw.f29795j), optJSONObject.toString());
                }
                com.bytedance.sdk.openadsdk.tools.xt.j(cw.f29795j, optJSONObject);
            }
        }
        if (editor2 != null) {
            try {
                editor2.commit();
            } catch (Throwable th) {
                vl.xt("TTSdkSetting", "saveSlotConfig failed:" + th.getMessage());
                return;
            }
        }
        if (editor != null) {
            editor.commit();
        }
    }

    private void r(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.f29814m = jSONObject.optInt("enable", 0);
            JSONArray optJSONArray = jSONObject.optJSONArray("content_type");
            this.ae.clear();
            if (optJSONArray != null && optJSONArray.length() != 0) {
                for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                    String optString = optJSONArray.optString(i6);
                    if (!TextUtils.isEmpty(optString)) {
                        this.ae.add(optString);
                    }
                }
            }
            this.tl = jSONObject.optInt("send_response_to_webview", 0);
            this.f29808g = jSONObject.optInt("max_report_size_single", 2);
            this.oq = jSONObject.optInt("max_report_size_total", 5);
            this.ws = jSONObject.optInt("max_report_times", 0);
            this.vl = jSONObject.optString("report_url", "https://api-access.pangolin-sdk-toutiao.com/v2/inspect/aegis/client/page/");
            this.jy = jSONObject.optInt("storage_type", 0);
            this.qv = jSONObject.optInt("report_only_wifi_enable", 0);
            return;
        }
        this.f29814m = 0;
        this.ae.clear();
        this.tl = 0;
        this.f29808g = 2;
        this.oq = 5;
        this.ws = 0;
        this.vl = "https://api-access.pangolin-sdk-toutiao.com/v2/inspect/aegis/client/page/";
        this.jy = 0;
        this.qv = 0;
    }

    private j tj(String str) {
        j jVar = null;
        try {
            dj();
            String string = this.ij.getString(kt(str), null);
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            jVar = cw(new JSONObject(string));
            this.f29813l.put(str, jVar);
            return jVar;
        } catch (Throwable th) {
            vl.xt("TTSdkSetting", "buildSlot failed:" + th.getMessage());
            return jVar;
        }
    }

    private int up(JSONObject jSONObject) {
        int optInt = jSONObject.optInt("splash_check_type", 1);
        this.ol = optInt;
        if (optInt == 0 || optInt == 1) {
            return optInt;
        }
        return 1;
    }

    private boolean v(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!TextUtils.isEmpty(this.nv)) {
            this.nv = xt().xt("app_dl_scheme_list", "");
        }
        if (TextUtils.isEmpty(this.nv)) {
            return false;
        }
        String[] split = this.nv.split(",");
        if (split.length == 0) {
            return false;
        }
        for (String str2 : split) {
            if (str.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public int ae(int i6) {
        int i7 = w(String.valueOf(i6)).xt;
        if (i7 <= 0 || i7 > 5) {
            return 1;
        }
        return i7;
    }

    public int az(String str) {
        return i(String.valueOf(str)).kt;
    }

    public j i(String str) {
        if (str == null) {
            return cw(new JSONObject());
        }
        j jVar = this.f29813l.get(str);
        if (jVar == null) {
            jVar = tj(str);
        }
        if (jVar != null) {
            return jVar;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code_id", str);
            return cw(jSONObject);
        } catch (JSONException e6) {
            throw new RuntimeException(e6);
        }
    }

    public int jy(String str) {
        int xt;
        if (this.sj == null) {
            return 5000;
        }
        str.getClass();
        switch (str) {
            case "banner_ad":
                xt = this.sj.xt("banner");
                break;
            case "rewarded_video":
                xt = this.sj.xt("rewarded");
                break;
            case "fullscreen_interstitial_ad":
                xt = this.sj.xt("fullscreen");
                break;
            case "embeded_ad":
                xt = this.sj.xt("feed");
                break;
            case "draw_ad":
                xt = this.sj.xt(MediationConstant.RIT_TYPE_DRAW);
                break;
            default:
                xt = 5000;
                break;
        }
        if (xt <= 0) {
            return 5000;
        }
        return xt;
    }

    public int oq(int i6) {
        return i(String.valueOf(i6)).mi;
    }

    public boolean qv(String str) {
        try {
            j i6 = v.xt().i(String.valueOf(str));
            if (i6 != null) {
                return i6.f29794i != null;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public int ws(String str) {
        int j6;
        if (this.sj == null) {
            return 5000;
        }
        str.getClass();
        switch (str) {
            case "banner_ad":
                j6 = this.sj.j("banner");
                break;
            case "rewarded_video":
                j6 = this.sj.j("rewarded");
                break;
            case "fullscreen_interstitial_ad":
                j6 = this.sj.j("fullscreen");
                break;
            case "embeded_ad":
                j6 = this.sj.j("feed");
                break;
            case "draw_ad":
                j6 = this.sj.j(MediationConstant.RIT_TYPE_DRAW);
                break;
            default:
                j6 = 5000;
                break;
        }
        if (j6 <= 0) {
            return 5000;
        }
        return j6;
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.up
    public void xt(final JSONObject jSONObject) {
        this.xw = jSONObject.optString("dyn_draw_engine_url", "https://sf3-fe-tos.pglstatp-toutiao.com/obj/ad-pattern/renderer/package.json");
        this.f29805d = jSONObject.optString("play_component_ugen_engine_url", "");
        this.uc = jSONObject.optString("ads_url", "api-access.pangolin-sdk-toutiao.com");
        this.ri = jSONObject.optString("app_log_url", "log-api.pangolin-sdk-toutiao-b.com/service/2/app_log/");
        this.ed = jSONObject.optString("xpath");
        this.wq = jSONObject.optJSONObject("digest");
        this.uf = jSONObject.optLong("data_time");
        JSONObject optJSONObject = jSONObject.optJSONObject("feq_policy");
        up.xt xtVar = new up.xt();
        if (optJSONObject != null) {
            xtVar.j(optJSONObject.optLong("duration") * 1000);
            xtVar.j(optJSONObject.optInt("max"));
            xtVar.j((float) optJSONObject.optDouble("agg_multiple"));
        }
        this.f29827y = jSONObject.optInt("vbtt", 5);
        this.nt = jSONObject.optInt("fetch_tpl_interval", 3600);
        this.hu = jSONObject.optString("privacy_url", lx);
        this.ek = Boolean.valueOf(jSONObject.optBoolean("use_mediation_map"));
        JSONObject optJSONObject2 = jSONObject.optJSONObject("abtest");
        if (optJSONObject2 != null) {
            xtVar.j(optJSONObject2.optString("version"));
            xtVar.xt(optJSONObject2.optString("param"));
        } else {
            com.bytedance.sdk.openadsdk.core.cw.up.j().ae();
        }
        this.rs = jSONObject.optInt("read_video_from_cache", 1);
        this.f29816o = jSONObject.optBoolean("enable_bw_screen_detection", false);
        r(jSONObject.optJSONObject("web_upload"));
        JSONObject optJSONObject3 = jSONObject.optJSONObject("log_rate_conf");
        this.qg = optJSONObject3;
        if (optJSONObject3 != null) {
            this.zs = (float) optJSONObject3.optDouble("global_rate", 1.0d);
            if (this.qg.has("call_stack_rate")) {
                this.ov = (float) this.qg.optDouble("call_stack_rate");
            } else {
                this.ov = this.zs;
            }
        } else {
            this.zs = 1.0f;
        }
        this.f29815n = jSONObject.optString("pyload_h5");
        this.nd = wq.j(jSONObject.optJSONObject("insert_js_config"));
        this.ol = up(jSONObject);
        vl.r("splashLoad", "setting-》mSplashCheckType=" + this.ol);
        this.f29818q = jSONObject.optInt("if_both_open", 0);
        this.qb = jSONObject.optInt("support_tnc", Integer.MAX_VALUE);
        this.hh = jSONObject.optInt("al", 1);
        this.ki = jSONObject.optInt("max_tpl_cnts", 100);
        com.bytedance.sdk.openadsdk.core.cw.cw.j().j(jSONObject);
        JSONObject optJSONObject4 = jSONObject.optJSONObject("app_common_config");
        if (optJSONObject4 != null) {
            this.yl = optJSONObject4.optString("stats_url", "api-access.pangolin-sdk-toutiao1.com");
            this.al = optJSONObject4.optInt("mini_game_preload", 1);
            this.qe = optJSONObject4.optString("img_bucket", "https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/csj_assets/");
            this.px = optJSONObject4.optBoolean("enable_apm_pv", false);
            this.oy = optJSONObject4.optBoolean("open_single_abi", false);
            this.ju = optJSONObject4.optBoolean("show_callback_mult", false) ? 1 : 0;
            this.f29821t = optJSONObject4.optInt("fetch_tpl_timeout_ctrl", 5000);
            this.uq = optJSONObject4.optInt("interact_show_after_time", 500);
            this.ik = optJSONObject4.optInt("fetch_tpl_timeout_ctrl_bad_device", 300);
            this.ka = (float) optJSONObject4.optDouble("tpl_render_error_rate_h5", 4.5d);
            this.f29823u = (float) optJSONObject4.optDouble("tpl_render_error_rate_native", 1.0d);
            this.wo = optJSONObject4.optBoolean("tpl_enable_render_timeout_opt", false);
            String optString = optJSONObject4.optString("tpl_timeout_ctrl");
            if (!TextUtils.isEmpty(optString)) {
                this.sj = tj.cw(optString);
            }
            this.tk = optJSONObject4.optInt("if_sp_cache", 1);
            xtVar.j(optJSONObject4.optBoolean("is_spl_cache_remove_change", false));
            this.az = optJSONObject4.optInt("express_gesture_enable", 0);
            this.f29810i = optJSONObject4.optInt("enable_download_proto", 1);
            this.av = optJSONObject4.optInt("app_express_gesture_priority", -1);
            this.fx = optJSONObject4.optInt("webview_cache_count", 3);
            this.na = optJSONObject4.optInt("webview_cache_count_v3", 3);
            this.gr = optJSONObject4.optInt("webview_render_concurrent_count", 2);
            this.wi = optJSONObject4.optString("ad_pkg_info_url", "apps.bytesfield.com");
            this.ve = optJSONObject4.optString("splash_close_text", "跳过");
            this.f29802a = optJSONObject4.optInt("network_module", 1);
            xtVar.xt(optJSONObject4.optInt("cypher_version", 40001));
            com.bytedance.sdk.component.xt.j.j.j.j().j(this.f29802a != 2);
            this.f29812k = optJSONObject4.optInt("adlog_debug", 0);
            this.sm = optJSONObject4.optInt("adlog_batch", 10);
            this.ya = optJSONObject4.optLong("adlog_interval", 5000L);
            this.xq = optJSONObject4.optInt("adlog_exception_batch", 100);
            this.ff = optJSONObject4.optInt("adlog_monitor", 1);
            this.f29825w = optJSONObject4.optInt("enable_ttvideo", -1);
            this.mi = optJSONObject4.optInt("enable_zaid", 0);
            this.aq = optJSONObject4.optLong("ext_use_type", this.zz);
            this.kc = optJSONObject4.optInt("enable_dl_ext", this.ry);
            this.f29824v = optJSONObject4.optInt("download_receiver_enable", 1);
            this.f29811j = optJSONObject4.optInt("launch_strategy", 0);
            this.tj = optJSONObject4.optInt("dl_popup_duration", 1000);
            this.f29807f = optJSONObject4.optInt("opt_show_check", 0);
            this.mp = optJSONObject4.optInt("shake_trigger_control", 0);
            this.st = optJSONObject4.optJSONObject("pitaya_general_settings");
            this.pz = optJSONObject4.optJSONObject("http_drop");
            this.qa = optJSONObject4.optInt("stats_batch", 5);
            this.kk = optJSONObject4.optJSONObject("live_stream_cof");
            this.hw = optJSONObject4.optJSONObject("dl_notification");
            this.dj = optJSONObject4.optInt("disable_show_url", 0);
            this.zk = optJSONObject4.optJSONObject("sensor_direction");
            this.ja = optJSONObject4.optJSONObject("pitaya_business_conf");
            xtVar.cw(optJSONObject4.optInt("spl_cache_conf", 14));
            xtVar.r(optJSONObject4.optInt("spl_thread_conf", 1));
            xtVar.up(optJSONObject4.optInt("spl_common_conf", 0));
            xtVar.m(optJSONObject4.optInt("spl_cache_expired", 0));
            xtVar.cw(optJSONObject4.optString("drop_cache_black_conf", ""));
            xtVar.j(this.ja);
            xtVar.ae(optJSONObject4.optInt("splash_render_timeout_backup", 100));
            JSONObject optJSONObject5 = optJSONObject4.optJSONObject("client_intelligence_conf");
            if (optJSONObject5 != null) {
                this.uh = optJSONObject5.optBoolean("net_rating");
                this.lv = optJSONObject5.optJSONObject("net_rating_config");
                this.ua = optJSONObject5.optBoolean("device_rating");
            }
            JSONObject optJSONObject6 = optJSONObject4.optJSONObject("bytebench_rating");
            if (optJSONObject6 != null) {
                this.mm = optJSONObject6.optBoolean("enable");
                this.qo = (float) optJSONObject6.optDouble("mid_value");
                this.ll = (float) optJSONObject6.optDouble("low_value");
            }
            this.ln = optJSONObject4.optInt("event_switch", this.wf);
            this.rr = optJSONObject4.optInt("switch_audio_focus", 0);
            this.kt = optJSONObject4.optString("apm_pv_config", "");
            this.el = optJSONObject4.optInt("splash_card_show_max_count", 3);
            this.xt = optJSONObject4.optInt("pre_fetch_cnt", 10);
            this.ay = optJSONObject4.optInt("gnd_prefetch_cache_size", 5);
            this.pm = optJSONObject4.optLong("gnd_prefetch_cache_ttl", 0L);
            this.rh = com.bytedance.sdk.openadsdk.core.az.j.j.j(optJSONObject4.optJSONObject("white_check_config"));
            this.fp = optJSONObject4.optInt("scheme_get_type", 0);
            this.ym = optJSONObject4.optInt("scheme_get_num", 1);
            this.sf = optJSONObject4.optInt("if_query_all_package", 0);
            this.f29826x = com.bytedance.sdk.openadsdk.core.ae.xt.j(optJSONObject4.optJSONObject("clog_config"));
            this.ch = com.bytedance.sdk.openadsdk.core.dislike.r.j(optJSONObject4.optJSONObject("oncall_upload"));
            this.f29820s = optJSONObject4.optBoolean("check_live_room", false);
            JSONObject optJSONObject7 = optJSONObject4.optJSONObject("pglam");
            if (optJSONObject7 != null) {
                this.by = optJSONObject7.optInt("pglam_main_enable", 0);
                this.yu = optJSONObject7.optInt("pglam_dns_check_enable", 0);
                this.f0if = optJSONObject7.optString("pglam_clazz_check", "");
            }
            this.os = optJSONObject4.optInt("ud_enable", 1);
            this.yb = optJSONObject4.optJSONObject("thread_config");
            com.bytedance.sdk.openadsdk.core.h.j.xt();
            this.ej = optJSONObject4.optBoolean("new_app_list", false);
            this.so = xt.j(optJSONObject4.optJSONObject("app_live_config"));
            this.ot = optJSONObject4.optJSONObject("plugin_update_state");
            this.cb = optJSONObject4.optJSONObject("antispam_autoclick_detect");
            com.bytedance.sdk.component.panglearmor.xt.up.j().j(this.cb);
            this.fk = optJSONObject4.optInt("is_open_isw", 1);
            this.xj = optJSONObject4.optInt("is_kv_cache_type", 0);
            this.lo = optJSONObject4.optInt("kv_init_type", 0);
            this.uo = optJSONObject4.optInt("open_dl_type", 0);
            this.nv = optJSONObject4.optString("app_dl_scheme_list", "");
            int optInt = optJSONObject4.optInt("lp_url_sw", 0);
            this.vr = optInt;
            if (optInt == 1) {
                this.id = optJSONObject4.optString("lp_list", "");
            }
            JSONObject optJSONObject8 = optJSONObject4.optJSONObject("uchain");
            if (optJSONObject8 != null) {
                String optString2 = optJSONObject8.optString(TKDownloadReason.KSAD_TK_MD5, "");
                String optString3 = optJSONObject8.optString("url", "");
                if (!TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString3)) {
                    this.kj = optString2;
                    this.hk = optString3;
                }
            }
            com.bytedance.sdk.openadsdk.core.g.j.r.j.j(this.kj, this.hk);
            this.lw = optJSONObject4.optInt("m_vids_join", 0);
            this.xc = optJSONObject4.optInt("mini_event_upload_version", 0);
            this.lc = optJSONObject4.optLong("bg_web_readd_t", 3000L);
            this.vu = optJSONObject4.optInt("title_priority", 0);
            this.lg = optJSONObject4.optInt("splash_video_opt_enable", 0);
            this.ag = optJSONObject4.optInt("gesture_through_enable", 0);
            this.qf = optJSONObject4.optInt("refresh_req_num", 2);
            this.vm = optJSONObject4.optInt("refresh_max_times", 1);
            zw().edit().putBoolean("_use_pl_", optJSONObject4.optBoolean("_use_pl_", false)).apply();
            this.up = optJSONObject4.optInt("npth_enable_type", 0);
            this.fj = optJSONObject4.optBoolean("is_sp_send_meta", true);
            this.zi = ae.j(optJSONObject4.optString("opt_config"));
            this.fz = m.j(optJSONObject4.optString("kv_config"));
            this.xa = optJSONObject4.optBoolean("preload_switch", false);
            this.si = optJSONObject4.optInt("preload_time_point", 0);
            this.ar = optJSONObject4.optBoolean("is_adapt_density", false);
            this.zd = optJSONObject4.optBoolean("disable_easy_playable", false);
            this.yv = optJSONObject4.optInt("enable_target_34", 1);
            this.bh = optJSONObject4.optInt("enable_xm_market", 1);
            this.nw = optJSONObject4.optBoolean("app_info_cache_switch", false);
            this.rf = optJSONObject4.optBoolean("disable_repeat_render", true);
            this.f29822tv = optJSONObject4.optInt("status_bar_adapt", 1);
            JSONObject optJSONObject9 = optJSONObject4.optJSONObject("view_report_opt");
            if (optJSONObject9 != null) {
                this.qn = optJSONObject9.optBoolean("view_check_by_window", false);
                this.mc = optJSONObject9.optBoolean("shake_twist_bind_show", false);
                this.fv = optJSONObject9.optBoolean("view_check_by_click", false);
            }
            rn.j();
            this.zw = optJSONObject4.optBoolean("is_first_plugin_resources", false);
            int optInt2 = optJSONObject4.optInt("open_webview_count");
            MultiWebview.setMaxWebViewCount(optInt2);
            xt().j("open_webview_count", optInt2);
            new com.bytedance.sdk.openadsdk.core.p.j.xt().j(optJSONObject4);
        }
        JSONObject optJSONObject10 = jSONObject.optJSONObject("download_config");
        if (optJSONObject10 != null) {
            xtVar.tl(optJSONObject10.optInt("if_storage_internal", 1));
        }
        xtVar.j();
        gq.xt(jSONObject);
        e.j(jSONObject);
        la.j(jSONObject);
        com.bytedance.sdk.openadsdk.core.tj.tl.j(jSONObject);
        mi.j(jSONObject);
        new com.bytedance.sdk.openadsdk.core.r.xt("h5_resource_sync").xt(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.p.oq.1
            @Override // java.lang.Runnable
            public void run() {
                p.j(jSONObject, new p.j() { // from class: com.bytedance.sdk.openadsdk.core.p.oq.1.1
                    @Override // com.bytedance.sdk.openadsdk.core.tj.p.j
                    public void j(p.cw cwVar) {
                        p.j(oq.this.cw, cwVar);
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.tj.p.j
                    public void xt(p.cw cwVar) {
                        p.xt(oq.this.cw, cwVar);
                    }
                });
            }
        });
        pz.j(jSONObject);
        this.f29828z = System.currentTimeMillis();
        this.hl.clear();
        JSONArray optJSONArray = jSONObject.optJSONArray("spam_app_list");
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i6 = 0; i6 < length; i6++) {
                String optString4 = optJSONArray.optString(i6);
                if (!TextUtils.isEmpty(optString4)) {
                    this.hl.add(optString4);
                }
            }
        }
        synchronized (this.f29803b) {
            try {
                this.f29803b.clear();
                JSONArray optJSONArray2 = jSONObject.optJSONArray("scheme_check_list");
                if (optJSONArray2 != null) {
                    int length2 = optJSONArray2.length();
                    for (int i7 = 0; i7 < length2; i7++) {
                        String optString5 = optJSONArray2.optString(i7);
                        if (!TextUtils.isEmpty(optString5)) {
                            this.f29803b.add(optString5);
                        }
                    }
                }
            } finally {
            }
        }
        synchronized (this.f29806e) {
            try {
                this.f29806e.clear();
                JSONArray optJSONArray3 = jSONObject.optJSONArray("top_scheme_list");
                if (optJSONArray3 != null) {
                    int length3 = optJSONArray3.length();
                    for (int i8 = 0; i8 < length3; i8++) {
                        String optString6 = optJSONArray3.optString(i8);
                        if (!TextUtils.isEmpty(optString6)) {
                            this.f29806e.add(optString6);
                        }
                    }
                }
            } finally {
            }
        }
        JSONObject optJSONObject11 = jSONObject.optJSONObject("download_sdk_config");
        if (optJSONObject11 != null) {
            this.gx = optJSONObject11.toString();
        } else {
            this.gx = "";
        }
        this.f29804c = optJSONObject11;
        try {
            JSONObject optJSONObject12 = jSONObject.optJSONObject("ad_slot_conf_block");
            if (optJSONObject12 != null) {
                this.ih = optJSONObject12.toString();
                this.km.clear();
                Iterator<String> keys = optJSONObject12.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    this.km.put(next, optJSONObject12.opt(next));
                }
            }
        } catch (Exception unused) {
        }
        if (com.bytedance.sdk.openadsdk.core.cw.cw.j().g()) {
            m(jSONObject);
        } else if (!com.bytedance.sdk.openadsdk.core.oq.i().la()) {
            m(jSONObject);
        }
        com.bytedance.sdk.openadsdk.tools.xt.cw(15, this.uc);
        if (com.bytedance.sdk.openadsdk.tools.xt.j()) {
            JSONObject optJSONObject13 = optJSONObject4 != null ? optJSONObject4.optJSONObject("test_tool_urls") : null;
            if (optJSONObject13 != null) {
                if (optJSONObject13.has("qa_tool_host")) {
                    try {
                        String host = new URL(optJSONObject13.optString("qa_tool_host")).getHost();
                        if (!TextUtils.isEmpty(host)) {
                            com.bytedance.sdk.openadsdk.core.oq.i().oq(host);
                        }
                    } catch (MalformedURLException unused2) {
                    }
                }
                if (!TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.oq.i().kc())) {
                    if (optJSONObject13.has("ad_preview_url")) {
                        com.bytedance.sdk.openadsdk.core.oq.i().qv(optJSONObject13.optString("ad_preview_url"));
                    }
                    if (optJSONObject13.has("basic_info_url")) {
                        com.bytedance.sdk.openadsdk.core.oq.i().vl(optJSONObject13.optString("basic_info_url"));
                    }
                }
            }
        }
        this.jl = jSONObject.optInt("pre_cache_brand_count", this.jl);
        JSONObject optJSONObject14 = jSONObject.optJSONObject("video_cache_config");
        this.ig = optJSONObject14;
        if (optJSONObject14 != null) {
            com.bykv.vk.openvk.component.video.j.j.j(optJSONObject14);
        }
        g();
        fj();
        com.bytedance.sdk.openadsdk.core.ae.cw.j(this.f29826x);
        zi();
    }

    public boolean tl(String str) {
        return str == null || v.xt().i(str).jy == 0;
    }

    public boolean up(String str) {
        return w(String.valueOf(str)).f29796m == 1;
    }

    public boolean av(String str) {
        return w(str).xt() == 1;
    }

    public boolean qv(int i6) {
        return w(String.valueOf(i6)).av;
    }

    public int vl(String str) {
        return w(str).tl;
    }

    public int tl(int i6) {
        return w(String.valueOf(i6)).ae;
    }

    public int up(int i6) {
        return Math.max(w(String.valueOf(i6)).f29793g, 0);
    }

    public int g(String str) {
        if (str == null) {
            return 1500;
        }
        return v.xt().w(str).ws;
    }

    public int g(int i6) {
        int i7 = i(String.valueOf(i6)).f29799w;
        if (i7 == 0 || i7 == 1 || i7 == 2 || i7 == 3 || i7 == 4) {
            return i7;
        }
        return 2;
    }

    public int m(String str) {
        return i(str).az;
    }

    public int m(int i6) {
        return Math.max(w(String.valueOf(i6)).oq, 0);
    }

    public boolean r(int i6) {
        return w(String.valueOf(i6)).cw == 1;
    }

    public boolean r(String str) {
        int i6 = v.xt().w(String.valueOf(str)).up;
        if (i6 != 1) {
            return i6 == 2 && ws.cw(v.getContext()) != 0;
        }
        return ws.r(v.getContext());
    }

    public long cw(String str) {
        return w(str).f29798v;
    }

    public void cw(int i6) {
        if (this.mz != i6) {
            this.mz = i6;
            xt().j("settings_open", this.mz);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.up
    public void j(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null) {
            return;
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("app_common_config");
        if (optJSONObject2 != null) {
            this.to = optJSONObject2.optBoolean("can_init_live", true);
        }
        if (!this.to || (optJSONObject = jSONObject.optJSONObject("live_sdk_conf")) == null) {
            return;
        }
        this.im = gx.j(optJSONObject);
        com.bytedance.sdk.openadsdk.core.live.xt.j().xt();
    }

    public <T> T j(String str, T t5) {
        try {
            if (this.km.containsKey(str)) {
                T t6 = (T) this.km.get(str);
                if (t6 != null) {
                    return t6;
                }
            }
        } catch (Exception unused) {
        }
        return t5;
    }

    public void j(int i6) {
        this.qb = i6;
    }

    public boolean j(String str) {
        return w(str).tj;
    }

    public boolean j(n nVar, int i6) {
        j w5 = v.xt().w(String.valueOf(i6));
        return com.bytedance.sdk.openadsdk.core.component.reward.r.r.j(nVar) == 4 ? w5.cw == 1 : w5.qv == 1;
    }

    public int j(String str, int i6) {
        if (i6 != 0 && i6 != 9) {
            return jy(str);
        }
        return ws(str);
    }

    public boolean xt(int i6) {
        return g(i6) != 0;
    }

    public boolean xt(String str) {
        return w(str).f29792f;
    }
}
