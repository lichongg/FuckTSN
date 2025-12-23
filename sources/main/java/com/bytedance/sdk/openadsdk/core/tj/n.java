package com.bytedance.sdk.openadsdk.core.tj;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.tj.ff;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kwad.components.offline.api.IOfflineCompo;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import com.tencent.connect.common.Constants;
import com.tencent.open.SocialConstants;
import com.umeng.analytics.pro.bi;
import com.umeng.analytics.pro.d;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    private JSONObject f30334a;
    private int ag;
    private com.bytedance.sdk.openadsdk.core.ugeno.m.j al;
    private int ar;
    private long av;
    private String az;

    /* renamed from: b, reason: collision with root package name */
    private z f30335b;
    private String bh;
    private long by;
    private ch cb;
    private String ch;
    private int cr;
    private com.bytedance.sdk.openadsdk.core.dislike.cw.xt cw;

    /* renamed from: d, reason: collision with root package name */
    private String f30337d;
    private int dj;

    /* renamed from: e, reason: collision with root package name */
    private ed f30338e;
    private rn ej;
    private w ek;
    private hl et;

    /* renamed from: f, reason: collision with root package name */
    private f f30339f;
    private JSONObject fj;
    private m fk;
    private String fp;
    private kc fs;
    private boolean fv;
    private int fz;

    /* renamed from: g, reason: collision with root package name */
    private JSONObject f30340g;
    private ln gq;
    private rh gr;
    private JSONObject gs;

    /* renamed from: h, reason: collision with root package name */
    private int f30341h;
    private tj hh;
    private vl hk;
    private e hl;
    private k hu;
    private String hw;

    /* renamed from: i, reason: collision with root package name */
    private String f30342i;

    /* renamed from: if, reason: not valid java name */
    private ol f1if;
    private int ig;
    private a ih;
    private s ij;
    private String ik;
    private int im;

    /* renamed from: j, reason: collision with root package name */
    public xp f30343j;
    private ws ja;
    private int jl;
    private boolean ju;

    /* renamed from: k, reason: collision with root package name */
    private int f30344k;
    private String ka;
    private String ki;
    private int kj;
    private az kk;

    /* renamed from: l, reason: collision with root package name */
    private String f30345l;
    private int la;
    private String lg;
    private boolean ll;
    private String lo;
    private la lw;
    private int lx;

    /* renamed from: m, reason: collision with root package name */
    private String f30346m;
    private int mc;
    private int mm;
    private boolean mp;
    private volatile JSONObject mz;
    private l nv;
    private int nw;
    private boolean ol;
    private JSONObject oq;
    private kt os;
    private v ot;
    private uf ov;
    private String oy;

    /* renamed from: p, reason: collision with root package name */
    private long f30349p;
    private JSONObject pm;
    private JSONObject pz;
    private int qa;
    private int qe;
    private String qf;
    private int qg;
    private int qn;
    private String qo;

    /* renamed from: r, reason: collision with root package name */
    private int f30351r;
    private int rf;
    private long ri;
    private int rn;
    private JSONObject rr;
    private int rs;
    private String ry;

    /* renamed from: s, reason: collision with root package name */
    private String f30352s;
    private qb sf;
    private String sh;
    private com.bytedance.sdk.openadsdk.i.cw.cw.xt sm;
    private gq so;

    /* renamed from: t, reason: collision with root package name */
    private String f30353t;
    private up tj;
    private String tl;
    private xq to;

    /* renamed from: tv, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.ugeno.g.j f30354tv;

    /* renamed from: u, reason: collision with root package name */
    private String f30355u;
    private String ua;
    private boolean uf;
    private String uh;
    private JSONObject uo;
    private h up;
    private boolean uq;

    /* renamed from: v, reason: collision with root package name */
    private i f30356v;
    private String ve;
    private String vl;
    private String vm;
    private String vu;

    /* renamed from: w, reason: collision with root package name */
    private String f30357w;
    private long wo;
    private boolean wq;

    /* renamed from: x, reason: collision with root package name */
    private int f30358x;
    private boolean xa;
    private boolean xc;
    private int xj;
    private int xq;
    public String xt;

    /* renamed from: y, reason: collision with root package name */
    private ff f30359y;
    private int yb;
    private String yl;
    private int ym;
    private hh yu;
    private int yv;

    /* renamed from: z, reason: collision with root package name */
    private Map<String, Object> f30360z;
    private int zd;
    private int zi;
    private c zk;
    private zz zs;
    private JSONObject zw;
    private int ae = -1;
    private List<h> qv = new ArrayList();
    private List<String> jy = new ArrayList();
    private List<String> ws = new ArrayList();
    private String mi = "0";
    private String kt = "0";
    private int ed = -1;

    /* renamed from: c, reason: collision with root package name */
    private long f30336c = -1;
    private long gx = -1;

    /* renamed from: n, reason: collision with root package name */
    private long f30347n = System.currentTimeMillis();
    private String nd = UUID.randomUUID().toString();
    private String rh = "";

    /* renamed from: q, reason: collision with root package name */
    private int f30350q = IOfflineCompo.Priority.HIGHEST;
    private int qb = 0;
    private g ya = new g();
    private int ff = 1;
    private int zz = 0;
    private int kc = 0;
    private int aq = 0;
    private int st = 1;
    private int wf = 0;
    private int ln = 0;
    private int xp = 0;
    private int nt = 1;
    private boolean uc = false;
    private int px = 1;
    private float xw = 100.0f;
    private int wi = 0;
    private int tk = 2;
    private int fx = 0;
    private int na = 100;
    private int nu = 2;
    private int om = 2;

    /* renamed from: o, reason: collision with root package name */
    private float f30348o = 0.07f;
    private float el = 0.0f;
    private int vr = -1;
    private long id = 0;
    private boolean ay = true;
    private int lc = -1;
    private int lv = 0;
    private int sj = 0;
    private long si = 0;
    private int km = 0;

    public long a() {
        return this.by;
    }

    public w av() {
        return this.ek;
    }

    public boolean az() {
        return ws() == 1;
    }

    public boolean b() {
        return this.zz == 1;
    }

    public long c() {
        return this.wo;
    }

    public long ch() {
        return this.ri;
    }

    public boolean cw() {
        return this.zd == 1;
    }

    public ol e() {
        return this.f1if;
    }

    public String ed() {
        return this.f30355u;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            n nVar = (n) obj;
            if (this.mi.equals(nVar.mi) && this.f30352s.equals(nVar.f30352s)) {
                return true;
            }
        }
        return false;
    }

    public String f() {
        return this.vm;
    }

    public int ff() {
        return this.lc;
    }

    public String fk() {
        try {
            return ot().optString("convert_id", null);
        } catch (Throwable unused) {
            return null;
        }
    }

    public boolean g() {
        return tl() == 1;
    }

    public boolean gq() {
        return this.uq;
    }

    public int gx() {
        return this.kj;
    }

    public com.bytedance.sdk.openadsdk.core.ugeno.g.j h() {
        return this.f30354tv;
    }

    public e hh() {
        return this.hl;
    }

    public int hl() {
        return this.zz;
    }

    public boolean i() {
        return this.xa;
    }

    public boolean j() {
        return this.fv;
    }

    public boolean jy() {
        return vl() == 1;
    }

    public int k() {
        return this.aq;
    }

    public int kt() {
        return this.ag;
    }

    public int l() {
        if (kt.r(this)) {
            return 0;
        }
        return this.rf;
    }

    public String la() {
        return this.f30353t;
    }

    public int m() {
        return this.vr;
    }

    public String mi() {
        return this.lg;
    }

    public int n() {
        return this.om;
    }

    public int nd() {
        return this.nu;
    }

    public int ol() {
        return this.xp;
    }

    public int oq() {
        return this.nw;
    }

    public com.bytedance.sdk.openadsdk.core.ugeno.m.j p() {
        return this.al;
    }

    public hh q() {
        return this.yu;
    }

    public String qb() {
        return this.ua;
    }

    public boolean qv() {
        return this.nw == 1;
    }

    public boolean r() {
        return this.ju && jy();
    }

    public int rh() {
        return this.la;
    }

    public String rn() {
        return this.ik;
    }

    public String s() {
        return this.ki;
    }

    public kt sm() {
        return this.os;
    }

    public String tj() {
        return this.qf;
    }

    public JSONObject tv() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("s_sig_ts", nv());
            jSONObject.put("ad_rec_stamp", lw());
            jSONObject.put("interaction_type", jl());
            jSONObject.put("target_url", yb());
            jSONObject.put("use_media_video_player", ol());
            jSONObject.put("landing_scroll_percentage", o());
            jSONObject.put("gecko_id", el());
            jSONObject.put("extension", hu());
            jSONObject.put("overlay", lx());
            jSONObject.put(MediationConstant.EXTRA_ADID, fs());
            jSONObject.put(SocialConstants.PARAM_SOURCE, rs());
            jSONObject.put(bi.f40972o, ij());
            jSONObject.put("screenshot", lo());
            jSONObject.put("play_bar_style", kc());
            jSONObject.put("play_bar_show_time", qa());
            jSONObject.put("if_block_lp", hl());
            jSONObject.put("cache_sort", wf());
            jSONObject.put("if_sp_cache", ln());
            jSONObject.put("splash_timeout_stage", xp());
            jSONObject.put("is_from_local_cache", vr());
            jSONObject.put("is_from_cache_type", pm());
            jSONObject.put("correct_action_code", xc());
            jSONObject.put("correct_result_code", lc());
            jSONObject.put("meta_hashcode", ae());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("cta", nd());
            jSONObject2.put("other", n());
            jSONObject.put("set_click_type", jSONObject2);
            h ig = ig();
            if (ig != null && !TextUtils.isEmpty(ig.j())) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("url", ig.j());
                jSONObject3.put("height", ig.cw());
                jSONObject3.put("width", ig.xt());
                jSONObject.put("icon", jSONObject3);
            }
            Object ag = ag();
            if (ag != null) {
                jSONObject.put("session_params", ag);
            }
            Object qf = qf();
            if (qf != null) {
                jSONObject.put("cache_control", qf);
            }
            g aq = aq();
            if (aq != null) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("click_upper_content_area", aq.f30271j);
                jSONObject4.put("click_upper_non_content_area", aq.xt);
                jSONObject4.put("click_lower_content_area", aq.cw);
                jSONObject4.put("click_lower_non_content_area", aq.f30273r);
                jSONObject4.put("click_button_area", aq.up);
                jSONObject4.put("click_video_area", aq.f30272m);
                jSONObject.put("click_area", jSONObject4);
            }
            com.bytedance.sdk.openadsdk.i.cw.cw.xt rr = rr();
            if (rr != null) {
                jSONObject.put("adslot", com.bytedance.sdk.openadsdk.core.rn.a.j(rr));
            }
            List<h> fp = fp();
            if (fp != null) {
                JSONArray jSONArray = new JSONArray();
                for (h hVar : fp) {
                    JSONObject jSONObject5 = new JSONObject();
                    jSONObject5.put("url", hVar.j());
                    jSONObject5.put("height", hVar.cw());
                    jSONObject5.put("width", hVar.xt());
                    jSONObject5.put("image_preview", hVar.m());
                    jSONObject5.put("image_key", hVar.ae());
                    jSONArray.put(jSONObject5);
                }
                jSONObject.put(SocializeProtocolConstants.IMAGE, jSONArray);
            }
            List<String> dj = dj();
            if (dj != null) {
                JSONArray jSONArray2 = new JSONArray();
                Iterator<String> it = dj.iterator();
                while (it.hasNext()) {
                    jSONArray2.put(it.next());
                }
                jSONObject.put("show_url", jSONArray2);
            }
            List<String> kk = kk();
            if (kk != null) {
                JSONArray jSONArray3 = new JSONArray();
                Iterator<String> it2 = kk.iterator();
                while (it2.hasNext()) {
                    jSONArray3.put(it2.next());
                }
                jSONObject.put("click_url", jSONArray3);
            }
            jSONObject.put("phone_num", ym());
            jSONObject.put("title", hw());
            jSONObject.put("download_num", ja());
            jSONObject.put(SocialConstants.PARAM_COMMENT, zk());
            jSONObject.put(SocializeProtocolConstants.PROTOCOL_KEY_EXTEND, os());
            jSONObject.put("req_id", ej());
            jSONObject.put("image_mode", ve());
            jSONObject.put("intercept_flag", st());
            jSONObject.put("web_inspector", pz());
            jSONObject.put("button_text", sf());
            jSONObject.put("ad_logo", zz());
            jSONObject.put("video_adaptation", ry());
            jSONObject.put("feed_video_opentype", k());
            jSONObject.put("feed_reward_type", ff());
            jSONObject.put("orientation", zw());
            jSONObject.put("aspect_ratio", uo());
            jSONObject.put("aspect_margin", bh());
            jSONObject.put("corner_radius", rf());
            up by = by();
            if (by != null) {
                JSONObject jSONObject6 = new JSONObject();
                jSONObject6.put("app_name", by.cw());
                jSONObject6.put(bi.f40972o, by.r());
                jSONObject6.put("download_url", by.xt());
                jSONObject6.put("score", by.up());
                jSONObject6.put("comment_num", by.m());
                jSONObject6.put("quick_app_url", by.j());
                jSONObject6.put("app_size", by.ae());
                jSONObject.put(Constants.JumpUrlConstants.SRC_TYPE_APP, jSONObject6);
            }
            f yu = yu();
            if (yu != null) {
                jSONObject.put("download_sdk_conf", yu.cw());
            }
            if (hh() != null) {
                hh().xt(jSONObject);
            }
            if (bl() != null) {
                bl().j(jSONObject);
            }
            if (m111if() != null) {
                m111if().j(jSONObject);
            }
            if (gs() != null) {
                gs().j(jSONObject);
            }
            if (q() != null) {
                q().j(jSONObject);
            }
            if (e() != null) {
                e().j(jSONObject);
            }
            if (sm() != null) {
                sm().j(jSONObject);
            }
            if (lv() != null) {
                lv().j(jSONObject);
            }
            if (xq() != null) {
                xq().j(jSONObject);
            }
            if (uh() != null) {
                uh().j(jSONObject);
            }
            if (zd() != null) {
                zd().j(jSONObject);
            }
            if (z() != null) {
                z().xt(jSONObject);
            }
            jSONObject.put("count_down", fz());
            jSONObject.put("expiration_time", xj());
            jSONObject.put("_child_metas", kg());
            jSONObject.put("src_req_id", hk());
            jSONObject.put("player_type", ly());
            jSONObject.put("video_encode_type", qg());
            jSONObject.put("feed_video_finish_type", rh());
            if (zs() != null) {
                zs().j(jSONObject);
            }
            if (fx() != null) {
                fx().j(jSONObject);
            }
            jSONObject.put("if_both_open", mp());
            jSONObject.put("if_double_deeplink", cb());
            JSONObject jSONObject7 = new JSONObject();
            jSONObject7.put("splash_clickarea", im());
            jSONObject7.put("splash_clicktext", y());
            jSONObject7.put("area_height", uc());
            jSONObject7.put("area_width", ri());
            jSONObject7.put("area_blank_height", ki());
            jSONObject7.put("half_blank_height", t());
            jSONObject7.put("splash_style_id", uq());
            jSONObject7.put("btn_background_dest_color", ik());
            jSONObject7.put("top_splash_clicktext", ka());
            jSONObject7.put("splash_load_time_optimization", u());
            jSONObject7.put("text_config", ll() != null ? ll().j() : null);
            jSONObject7.put("top_text_config", oy() != null ? oy().j() : null);
            jSONObject7.put("sliding_distance", qc());
            jSONObject7.put("slide_area", yl() != null ? yl().up() : null);
            jSONObject.put("splash_control", jSONObject7);
            JSONObject jSONObject8 = new JSONObject();
            jSONObject8.put("position", qe());
            jSONObject8.put("left_or_right_margin", px());
            jSONObject8.put("top_or_bottom_margin", xw());
            zz zzVar = this.zs;
            jSONObject8.put("skip_style", zzVar == null ? 1 : zzVar.r());
            zz zzVar2 = this.zs;
            jSONObject8.put("hide_native_skip_logo", zzVar2 == null ? 0 : zzVar2.up());
            jSONObject.put("skip_control", jSONObject8);
            JSONObject jSONObject9 = new JSONObject();
            jSONObject9.put("show_type", d());
            jSONObject9.put("blank", wi());
            jSONObject9.put("half_blank", tk());
            jSONObject.put("splash_compliance_bar", jSONObject9);
            if (lg() != null) {
                JSONObject jSONObject10 = new JSONObject();
                Set<Map.Entry<String, Object>> entrySet = lg().entrySet();
                if (entrySet != null && !entrySet.isEmpty()) {
                    for (Map.Entry<String, Object> entry : entrySet) {
                        jSONObject10.put(entry.getKey(), entry.getValue());
                    }
                }
                jSONObject.put("media_ext", jSONObject10);
            }
            jSONObject.put("isDirectDownload", i());
            jSONObject.put("page_render_type", l());
            jSONObject.put("promotion_type", gx());
            jSONObject.put("if_lpua_package", this.zi);
            jSONObject.put("click_freq", this.sj);
            com.bytedance.sdk.openadsdk.core.ugeno.m.j p5 = p();
            if (p5 != null) {
                JSONObject jSONObject11 = new JSONObject();
                jSONObject11.put("id", p5.j());
                jSONObject11.put(TKDownloadReason.KSAD_TK_MD5, p5.xt());
                jSONObject11.put("url", p5.cw());
                jSONObject11.put("scene", p5.r());
                jSONObject.put("ugeno", jSONObject11);
            }
            com.bytedance.sdk.openadsdk.core.ugeno.g.j h6 = h();
            if (h6 != null) {
                JSONObject jSONObject12 = new JSONObject();
                jSONObject12.put("product_infos", h6.j());
                jSONObject12.put("coupon", h6.xt());
                jSONObject12.put("render_config", h6.cw());
                jSONObject12.put("live_room_data", h6.r());
                jSONObject12.putOpt("ec_mall_conf", h6.up());
                jSONObject.put("dylite_info", jSONObject12);
            }
            jSONObject.put("native_lp_data", mi());
            jSONObject.put("native_lp_tpl_id", kt());
            jSONObject.put("native_lp_ugen_url", tj());
            jSONObject.put("native_lp_ugen_md5", f());
            jSONObject.put("download_url", w());
            jSONObject.put("native_lp_is_preload", v());
            if (v()) {
                jSONObject.put("native_lp_content", x());
            }
            jSONObject.put("market_url", vm());
            jSONObject.put("close_on_dislike", hi());
            m et = et();
            if (et != null) {
                JSONObject jSONObject13 = new JSONObject();
                jSONObject13.put("developer_name", et.ae());
                jSONObject13.put("app_version", et.up());
                jSONObject13.put("permissions", et.vl());
                jSONObject13.put("privacy_policy_url", et.tl());
                jSONObject13.put(bi.f40972o, et.jy());
                jSONObject13.put("app_name", et.ws());
                jSONObject13.put("score", et.cw());
                jSONObject13.put("creative_tags", et.r());
                jSONObject13.put("permissions_url", et.xt());
                jSONObject13.put("desc_url", et.g());
                jSONObject13.put("reg_number", et.oq());
                jSONObject13.put("reg_url", et.qv());
                jSONObject.put("app_manage", jSONObject13);
            }
            ch qn = qn();
            if (qn != null) {
                JSONObject jSONObject14 = new JSONObject();
                jSONObject14.put("ugen_dialog_url", qn.xt());
                jSONObject14.put("ugen_dialog_md5", qn.cw());
                jSONObject14.put("dialog_style", qn.j());
                jSONObject.put("easy_dl_dialog", jSONObject14);
            }
            if (ar() != null) {
                jSONObject.put("easy_pl_material", ar());
            }
            jSONObject.put("micro_app_type", m());
            jSONObject.put("app_manage_type", nu());
            jSONObject.put("lp_down_rule", om() == 1 ? 1 : 0);
            jSONObject.put("auction_price", ua());
            jSONObject.put("price", ed());
            jSONObject.put("ad_info", fj());
            jSONObject.put("adx_name", ek());
            jSONObject.put("no_default_ttdsp_price", zi());
            jSONObject.put("endcard_close_time", cr());
            jSONObject.put("proportion_watching", nw());
            jSONObject.put("video_skip_result", tz());
            jSONObject.put("shake_value", si());
            jSONObject.put("deep_shake_value", ho());
            jSONObject.put("rotation_angle", km());
            jSONObject.put("calculation_method", wo());
            jSONObject.put("calculation_method_twist", qo());
            jSONObject.put("show_poll_time", at());
            jSONObject.put("dynamic_join_type", to());
            jSONObject.put("cache_ext", s());
            jSONObject.put("cache_time", ch());
            jSONObject.put("req_id", la());
            jSONObject.put("is_cache", gq());
            jSONObject.put("log_ext", rn());
            jSONObject.put("material_key", wq());
            jSONObject.put("need_get_materials", uf());
            jSONObject.put("s_send_ts", c());
            jSONObject.put("parse_material_ts", a());
            xp xpVar = this.f30343j;
            if (xpVar != null) {
                jSONObject.put("wc_miniapp_info", xpVar.g());
            }
            vl pa = pa();
            if (pa != null) {
                JSONObject jSONObject15 = new JSONObject();
                jSONObject15.put("click_trigger_type", pa.j());
                jSONObject15.put("shake_start_time", pa.xt());
                jSONObject15.put("shake_end_time", pa.cw());
                jSONObject.put("click_trigger_config", jSONObject15);
            }
            jSONObject.put("web_monitor_rate", xt());
        } catch (Exception unused) {
        }
        if (xg() != null) {
            xg().j(jSONObject);
        }
        try {
            jSONObject.put("live_room_id", re());
            jSONObject.put("ad_type", li());
            jSONObject.put("live_interaction_type", ww());
            jSONObject.put("ec_schema", qb());
        } catch (JSONException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
        }
        try {
            jSONObject.put("ecom_live_params", kb());
        } catch (JSONException e7) {
            com.bytedance.sdk.component.utils.vl.j(e7);
        }
        gq jm = jm();
        if (jm != null) {
            jm.j(jSONObject);
        }
        v ne = ne();
        if (ne != null) {
            ne.j(jSONObject);
        }
        uf yv = yv();
        if (yv != null) {
            try {
                JSONObject jSONObject16 = new JSONObject();
                jSONObject16.put("reward_live_deep_link_user_id", yv.j());
                jSONObject16.put("reward_live_deep_link_request_id", yv.m());
                jSONObject16.put("reward_live_deep_link_room_id", yv.xt());
                jSONObject16.put("reward_live_last_time", yv.up());
                jSONObject16.put("reawrd_live_short_touch_params", yv.cw());
                jSONObject16.put("reawrd_live_extra_pangle_scheme_params", yv.r());
                jSONObject.put("reward_live_deep_link_params", jSONObject16);
            } catch (Exception unused2) {
            }
        }
        az vd = vd();
        if (vd != null) {
            try {
                JSONObject jSONObject17 = new JSONObject();
                jSONObject17.put("style_type", vd.j());
                jSONObject17.put("image_url", vd.xt());
                jSONObject17.put("position", vd.cw());
                jSONObject17.put("image_height", vd.r());
                jSONObject17.put("image_scale_rate", vd.m());
                jSONObject17.put("image_gif_url", vd.up());
                jSONObject17.put("image_gif_aspect_ratio", vd.ae());
                jSONObject.put("dynamic_join_coupon_style", jSONObject17);
            } catch (Exception unused3) {
            }
        }
        ws ml = ml();
        if (ml != null) {
            try {
                jSONObject.put("coupon", ml.j());
            } catch (JSONException e8) {
                com.bytedance.sdk.component.utils.vl.j(e8);
            }
        }
        c yx = yx();
        if (yx != null) {
            try {
                jSONObject.put("live_info", yx.j());
            } catch (JSONException unused4) {
            }
        }
        qb uw = uw();
        if (uw != null) {
            try {
                jSONObject.put("saas_info", uw.j());
            } catch (JSONException unused5) {
            }
        }
        Object na = na();
        if (na != null) {
            try {
                jSONObject.put(d.K, na);
            } catch (Exception unused6) {
            }
        }
        kc bw = bw();
        if (bw != null) {
            try {
                JSONObject jSONObject18 = new JSONObject();
                jSONObject18.put("video_adapter_type", bw.j());
                jSONObject18.put("video_mute_type", bw.xt());
                jSONObject.put("video_config", jSONObject18);
            } catch (Exception unused7) {
            }
        }
        try {
            jSONObject.put("not_valid_download_url", er());
        } catch (JSONException e9) {
            com.bytedance.sdk.component.utils.vl.j(e9);
        }
        try {
            jSONObject.put("dynamic_configs", sz());
            String of = of();
            if (!TextUtils.isEmpty(of)) {
                jSONObject.put("gnd_prefetch_cache_key", of);
                jSONObject.put("gnd_prefetch_timing", oz());
            }
        } catch (JSONException e10) {
            com.bytedance.sdk.component.utils.vl.j(e10);
        }
        try {
            jSONObject.put("twist_config", mt());
            jSONObject.put("shake_interact_conf", xn());
            jSONObject.put("twist_interact_conf", lr());
        } catch (JSONException e11) {
            com.bytedance.sdk.component.utils.vl.j(e11);
        }
        try {
            l lVar = this.nv;
            if (lVar != null) {
                lVar.xt(jSONObject);
            }
        } catch (Throwable unused8) {
        }
        try {
            la laVar = this.lw;
            if (laVar != null) {
                laVar.xt(jSONObject);
            }
        } catch (Throwable unused9) {
        }
        w av = av();
        if (av != null) {
            try {
                JSONObject jSONObject19 = new JSONObject();
                jSONObject19.put("lottie_tmp_url", av.cw());
                JSONArray jSONArray4 = new JSONArray();
                List<h> j6 = av.j();
                if (j6 != null) {
                    for (h hVar2 : j6) {
                        if (hVar2 != null) {
                            JSONObject jSONObject20 = new JSONObject();
                            jSONObject20.put("width", hVar2.xt());
                            jSONObject20.put("height", hVar2.cw());
                            jSONObject20.put("url", hVar2.j());
                            jSONArray4.put(jSONObject20);
                        }
                    }
                }
                JSONArray jSONArray5 = new JSONArray();
                List<com.bykv.vk.openvk.component.video.api.cw.cw> xt = av.xt();
                if (xt != null) {
                    for (com.bykv.vk.openvk.component.video.api.cw.cw cwVar : xt) {
                        if (cwVar != null) {
                            JSONObject jSONObject21 = new JSONObject();
                            jSONObject21.put("file_hash", cwVar.az());
                            jSONObject21.put("resolution", cwVar.g());
                            jSONObject21.put("video_duration", cwVar.m());
                            jSONObject21.put("video_url", cwVar.vl());
                            jSONArray5.put(jSONObject21);
                        }
                    }
                }
                JSONObject jSONObject22 = new JSONObject();
                jSONObject22.put("bg_anim_img_android", jSONArray4);
                jSONObject22.put("bg_videos", jSONArray5);
                JSONObject jSONObject23 = new JSONObject();
                jSONObject23.put("sdk_template_info", jSONObject19);
                jSONObject23.put("aigc", jSONObject22);
                jSONObject.put("sdk_derive_info", jSONObject23);
            } catch (JSONException unused10) {
            }
        }
        try {
            jSONObject.put("disable_video_join", tl());
            jSONObject.put("disable_top_bar", vl());
            jSONObject.put("disable_rtn_button", ws());
            jSONObject.put("disable_safe_area", r());
            jSONObject.put("disable_slide_return", oq());
        } catch (Throwable unused11) {
        }
        return jSONObject;
    }

    public boolean uf() {
        return this.ll;
    }

    public boolean up() {
        return this.vr == 3;
    }

    public boolean v() {
        return this.mp;
    }

    public int vl() {
        return this.ar;
    }

    public String w() {
        return this.sh;
    }

    public String wq() {
        return this.qo;
    }

    public int ws() {
        return this.qn;
    }

    public JSONObject x() {
        return this.mz;
    }

    public xq xq() {
        return this.to;
    }

    public int xt() {
        return this.mc;
    }

    public int ya() {
        return this.mm;
    }

    public la z() {
        return this.lw;
    }

    private float qc() {
        if (this.f30359y == null) {
            return 5.0f;
        }
        return r0.az();
    }

    public void a(int i6) {
        this.ig = i6;
    }

    public int ae() {
        return this.yv;
    }

    public JSONObject ag() {
        return this.rr;
    }

    public xp al() {
        return this.f30343j;
    }

    public g aq() {
        return this.ya;
    }

    public JSONObject ar() {
        return this.gs;
    }

    public int at() {
        return this.lx;
    }

    public void av(int i6) {
        this.aq = i6;
    }

    public void az(int i6) {
        this.mm = i6;
    }

    public void b(int i6) {
        this.fx = i6;
    }

    public float bh() {
        float f6 = this.f30348o;
        if (f6 < 0.07f || f6 > 0.175f) {
            this.f30348o = 0.07f;
        }
        return this.f30348o;
    }

    public z bl() {
        return this.f30335b;
    }

    public kc bw() {
        return this.fs;
    }

    public up by() {
        return this.tj;
    }

    public void c(int i6) {
        this.ed = i6;
    }

    public int cb() {
        return this.ln;
    }

    public void ch(int i6) {
        this.qa = i6;
    }

    public int cr() {
        return this.wi;
    }

    public void cw(int i6) {
        this.vr = i6;
    }

    public int d() {
        k kVar = this.hu;
        if (kVar == null) {
            return 0;
        }
        return kVar.j();
    }

    public List<String> dj() {
        return this.jy;
    }

    public void e(int i6) {
        int i7 = 500;
        if (i6 == Integer.MIN_VALUE) {
            i6 = com.bytedance.sdk.openadsdk.core.rn.uf.tl(this) == 3 ? 500 : 1000;
        }
        if (i6 >= 500) {
            i7 = 3000;
            if (i6 <= 3000) {
                i7 = i6;
            }
        }
        this.lx = i7;
    }

    public void ed(int i6) {
        this.f30341h = i6;
    }

    public String ej() {
        return this.f30345l;
    }

    public String ek() {
        if (!TextUtils.isEmpty(this.f30337d)) {
            this.f30337d = this.f30337d.trim();
        }
        return this.f30337d;
    }

    public String el() {
        return this.tl;
    }

    public boolean er() {
        return this.xc;
    }

    public m et() {
        return this.fk;
    }

    public void f(int i6) {
        this.f30344k = i6;
    }

    public void ff(int i6) {
        this.zi = i6;
    }

    public String fj() {
        return this.oy;
    }

    public List<h> fp() {
        return this.qv;
    }

    public String fs() {
        return this.mi;
    }

    public boolean fw() {
        return this.ay;
    }

    public tj fx() {
        return this.hh;
    }

    public int fz() {
        return this.f30341h;
    }

    public void g(int i6) {
        this.ag = i6;
    }

    public void gq(int i6) {
        this.f30351r = i6;
    }

    public ff gr() {
        return this.f30359y;
    }

    public void gx(int i6) {
        this.wf = i6;
    }

    public void h(int i6) {
        if (i6 != 1) {
            i6 = 0;
        }
        this.fz = i6;
    }

    public int hashCode() {
        return (this.mi.hashCode() * 31) + this.f30352s.hashCode();
    }

    public void hh(int i6) {
        if (i6 < 0 || i6 > 180) {
            this.rs = 50;
        } else {
            this.rs = i6;
        }
    }

    public boolean hi() {
        return this.uc;
    }

    public String hk() {
        return this.rh;
    }

    public void hl(int i6) {
        if (i6 < 0 || i6 > 100) {
            return;
        }
        this.na = i6;
    }

    public String hm() {
        return hashCode() + ej() + a();
    }

    public int ho() {
        if (this.f30351r == 4 && TextUtils.isEmpty(this.ry)) {
            return this.jl;
        }
        return 0;
    }

    public JSONObject hu() {
        return this.f30340g;
    }

    public String hw() {
        return this.az;
    }

    public void i(int i6) {
        this.lc = i6;
    }

    public long id() {
        return this.f30347n;
    }

    /* renamed from: if, reason: not valid java name */
    public i m111if() {
        return this.f30356v;
    }

    public h ig() {
        return this.up;
    }

    public String ij() {
        return this.xt;
    }

    public String ik() {
        ff ffVar = this.f30359y;
        return ffVar == null ? "#008DEA" : ffVar.oq();
    }

    public int im() {
        ff ffVar = this.f30359y;
        if (ffVar == null) {
            return 1;
        }
        return ffVar.j();
    }

    public void j(boolean z5) {
        this.fv = z5;
    }

    public long ja() {
        return this.av;
    }

    public int jl() {
        return this.f30351r;
    }

    public gq jm() {
        return this.so;
    }

    public int ju() {
        JSONObject jSONObject = this.f30340g;
        if (jSONObject != null) {
            return jSONObject.optInt("easy_playable_skip_duration", 0);
        }
        return 0;
    }

    public a jv() {
        return this.ih;
    }

    public void jy(int i6) {
        this.xp = i6;
    }

    public void k(int i6) {
        this.sj = i6;
    }

    public String ka() {
        ff ffVar = this.f30359y;
        return ffVar == null ? "点击查看" : ffVar.qv();
    }

    public String kb() {
        return this.hw;
    }

    public String kg() {
        return this.bh;
    }

    public int ki() {
        ff ffVar = this.f30359y;
        if (ffVar == null) {
            return 82;
        }
        return ffVar.m();
    }

    public String kj() {
        return this.nd;
    }

    public List<String> kk() {
        return this.ws;
    }

    public int km() {
        return this.rs;
    }

    public void kt(int i6) {
        this.qb = i6;
    }

    public void la(int i6) {
        this.rn = i6;
    }

    public long lc() {
        return this.gx;
    }

    public Map<String, Object> lg() {
        return this.f30360z;
    }

    public int li() {
        return this.ym;
    }

    public ff.xt ll() {
        ff ffVar = this.f30359y;
        if (ffVar != null) {
            return ffVar.vl();
        }
        return null;
    }

    public int ln() {
        return this.qa;
    }

    public boolean lo() {
        return this.wq;
    }

    public JSONObject lr() {
        return this.uo;
    }

    public rh lv() {
        return this.gr;
    }

    public long lw() {
        return this.id;
    }

    public JSONObject lx() {
        return this.oq;
    }

    public int ly() {
        return this.fx;
    }

    public void m(int i6) {
        this.nw = i6;
    }

    public s mc() {
        return this.ij;
    }

    public void mi(int i6) {
        this.ff = i6;
    }

    public ws ml() {
        return this.ja;
    }

    public int mp() {
        return this.wf;
    }

    public JSONObject mt() {
        return this.fj;
    }

    public void n(int i6) {
        this.ln = i6;
    }

    public JSONObject na() {
        return this.pm;
    }

    public void nd(int i6) {
        this.qe = i6;
    }

    public v ne() {
        return this.ot;
    }

    public l ng() {
        return this.nv;
    }

    public boolean nt() {
        ff ffVar = this.f30359y;
        return ffVar == null || ffVar.cw();
    }

    public int nu() {
        return this.xj;
    }

    public String nv() {
        return this.lo;
    }

    public int nw() {
        return this.na;
    }

    public int o() {
        return this.ae;
    }

    public String of() {
        return this.uh;
    }

    public void ol(int i6) {
        if (i6 < 12) {
            i6 = 12;
        }
        if (i6 > 20) {
            i6 = 20;
        }
        this.qg = i6;
    }

    public int om() {
        return this.fz;
    }

    public void oq(int i6) {
        this.rf = i6;
    }

    public String os() {
        return this.f30352s;
    }

    public JSONObject ot() {
        if (this.f30334a == null) {
            try {
                if (!TextUtils.isEmpty(this.f30352s)) {
                    this.f30334a = new JSONObject(this.f30352s);
                }
            } catch (JSONException unused) {
            }
        }
        return this.f30334a;
    }

    public String ov() {
        return this.ve;
    }

    public ff.xt oy() {
        ff ffVar = this.f30359y;
        if (ffVar != null) {
            return ffVar.jy();
        }
        return null;
    }

    public int oz() {
        return this.lv;
    }

    public void p(int i6) {
        this.xj = i6;
    }

    public vl pa() {
        return this.hk;
    }

    public int pm() {
        return this.ed;
    }

    public zz pq() {
        return this.zs;
    }

    public int px() {
        zz zzVar = this.zs;
        if (zzVar == null) {
            return 16;
        }
        return zzVar.xt();
    }

    public int pz() {
        return this.f30344k;
    }

    public void q(int i6) {
        this.ym = i6;
    }

    public int qa() {
        return this.f30350q;
    }

    public void qb(int i6) {
        this.dj = i6;
    }

    public int qe() {
        zz zzVar = this.zs;
        if (zzVar == null) {
            return 2;
        }
        return zzVar.j();
    }

    public JSONObject qf() {
        return this.pz;
    }

    public int qg() {
        return this.rn;
    }

    public ch qn() {
        return this.cb;
    }

    public int qo() {
        return this.yb;
    }

    public void qv(int i6) {
        this.kj = i6;
    }

    public void r(int i6) {
        this.cr = i6;
    }

    public String re() {
        return this.fp;
    }

    public float rf() {
        float f6 = this.el;
        if (f6 < 0.0f || f6 > 50.0f) {
            this.el = 0.0f;
        }
        return this.el;
    }

    public void rh(int i6) {
        this.px = i6;
    }

    public int ri() {
        ff ffVar = this.f30359y;
        return ffVar == null ? org.apache.commons.net.telnet.f.f51105u : ffVar.up();
    }

    public void rn(int i6) {
        this.ae = i6;
    }

    public com.bytedance.sdk.openadsdk.i.cw.cw.xt rr() {
        return this.sm;
    }

    public String rs() {
        return this.ch;
    }

    public int ry() {
        return this.kc;
    }

    public void s(int i6) {
        this.nt = i6;
    }

    public String sf() {
        return this.f30357w;
    }

    public int si() {
        return this.qg;
    }

    public void sm(int i6) {
        this.jl = i6;
    }

    public String so() {
        return this.kt;
    }

    public int st() {
        return this.xq;
    }

    public String sz() {
        return this.vu;
    }

    public int t() {
        ff ffVar = this.f30359y;
        if (ffVar == null) {
            return 56;
        }
        return ffVar.ae();
    }

    public void tj(int i6) {
        this.xq = i6;
    }

    public int tk() {
        k kVar = this.hu;
        if (kVar == null) {
            return 90;
        }
        return kVar.cw();
    }

    public int tl() {
        return this.cr;
    }

    public int to() {
        return this.im;
    }

    public int tz() {
        return this.tk;
    }

    public int u() {
        ff ffVar = this.f30359y;
        if (ffVar == null) {
            return 0;
        }
        return ffVar.tl();
    }

    public String ua() {
        return this.yl;
    }

    public int uc() {
        ff ffVar = this.f30359y;
        if (ffVar == null) {
            return 50;
        }
        return ffVar.r();
    }

    public void uf(int i6) {
        this.f30358x = i6;
    }

    public rn uh() {
        return this.ej;
    }

    public float uo() {
        if (this.xw <= 0.0f) {
            this.xw = 100.0f;
        }
        return (this.xw * 1000.0f) / 1000.0f;
    }

    public void up(int i6) {
        if (this.yv == 0) {
            this.yv = i6;
        }
    }

    public int uq() {
        ff ffVar = this.f30359y;
        if (ffVar == null) {
            return 0;
        }
        return ffVar.g();
    }

    public String uv() {
        JSONObject jSONObject = this.rr;
        String optString = jSONObject != null ? jSONObject.optString("session_id") : "";
        return TextUtils.isEmpty(optString) ? hm() : optString;
    }

    public qb uw() {
        return this.sf;
    }

    public void v(int i6) {
        this.f30350q = i6;
    }

    public az vd() {
        return this.kk;
    }

    public int ve() {
        return this.f30358x;
    }

    public k vi() {
        return this.hu;
    }

    public void vl(int i6) {
        this.la = i6;
    }

    public String vm() {
        return this.ry;
    }

    public boolean vr() {
        return this.uf;
    }

    public boolean vu() {
        return this.ol;
    }

    public void w(int i6) {
        this.kc = i6;
    }

    public int wf() {
        return this.st;
    }

    public int wi() {
        k kVar = this.hu;
        if (kVar == null) {
            return 90;
        }
        return kVar.xt();
    }

    public int wo() {
        return this.ig;
    }

    public void wq(int i6) {
        this.im = i6;
    }

    public void ws(int i6) {
        this.zz = i6;
    }

    public int ww() {
        return this.dj;
    }

    public void x(int i6) {
        this.st = i6;
    }

    public long xc() {
        return this.f30336c;
    }

    public ed xg() {
        return this.f30338e;
    }

    public long xj() {
        return this.f30349p;
    }

    public JSONObject xn() {
        return this.zw;
    }

    public int xp() {
        return this.nt;
    }

    public void xq(int i6) {
        this.lv = i6;
    }

    public void xt(int i6) {
        this.zd = i6;
    }

    public int xw() {
        zz zzVar = this.zs;
        if (zzVar == null) {
            return 30;
        }
        return zzVar.cw();
    }

    public String y() {
        ff ffVar = this.f30359y;
        return ffVar == null ? "" : ffVar.xt();
    }

    public void ya(int i6) {
        if (i6 <= 0 || i6 > 9) {
            this.tk = 3;
        } else {
            this.tk = i6;
        }
    }

    public String yb() {
        return this.f30346m;
    }

    public ff.j yl() {
        ff ffVar = this.f30359y;
        if (ffVar != null) {
            return ffVar.ws();
        }
        return null;
    }

    public String ym() {
        return this.vl;
    }

    public f yu() {
        return this.f30339f;
    }

    public uf yv() {
        return this.ov;
    }

    public c yx() {
        return this.zk;
    }

    public void z(int i6) {
        this.wi = i6;
    }

    public hl zd() {
        return this.et;
    }

    public int zi() {
        return this.qe;
    }

    public String zk() {
        return this.f30342i;
    }

    public ln zs() {
        return this.gq;
    }

    public int zw() {
        if (this.px != 2) {
            this.px = 1;
        }
        return this.px;
    }

    public int zz() {
        return this.ff;
    }

    public void a(String str) {
        this.xt = str;
    }

    public void ae(int i6) {
        this.ar = i6;
    }

    public void av(String str) {
        this.vl = str;
    }

    public boolean ay() {
        if (TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.rn.uf.oq(this)) || TextUtils.isEmpty(this.rh) || com.bytedance.sdk.openadsdk.core.rn.uf.oq(this).contains(this.rh)) {
            return false;
        }
        return true;
    }

    public void az(String str) {
        this.tl = str;
    }

    public void ch(String str) {
        this.rh = str;
    }

    public void cw(boolean z5) {
        this.xa = z5;
    }

    public void ed(String str) {
        this.uh = str;
    }

    public void f(String str) {
        this.f30345l = str;
    }

    public int fv() {
        return kt.tl(this);
    }

    public void g(String str) {
        this.f30355u = str;
    }

    public void gq(String str) {
        this.vu = str;
    }

    public com.bytedance.sdk.openadsdk.core.dislike.cw.xt gs() {
        com.bytedance.sdk.openadsdk.core.dislike.xt.j();
        return this.cw;
    }

    public void h(String str) {
        this.lo = str;
    }

    public void i(String str) {
        this.az = str;
    }

    public boolean ih() {
        int ws = com.bytedance.sdk.openadsdk.core.rn.uf.ws(this);
        if (ws != 3 && ws != 6) {
            return false;
        }
        return true;
    }

    public void j(int i6) {
        this.mc = i6;
    }

    public void jy(String str) {
        this.ch = str;
    }

    public int kc() {
        if (uo() == 100.0f && hh.j(this) != 2) {
            return this.qb;
        }
        return 0;
    }

    public void kt(String str) {
        this.mi = str;
    }

    public void l(int i6) {
        this.yb = i6;
    }

    public void la(String str) {
        this.f30337d = str;
    }

    public void m(String str) {
        this.f30353t = str;
    }

    public void mi(String str) {
        this.f30357w = str;
    }

    public boolean mm() {
        if (zi() != 1) {
            return true;
        }
        return false;
    }

    public boolean mz() {
        if (mp() == 1) {
            return true;
        }
        return false;
    }

    public void oq(String str) {
        this.ka = str;
    }

    public void p(String str) {
        this.oy = str;
    }

    public void qv(String str) {
        this.ua = str;
    }

    public void r(String str) {
        this.vm = str;
    }

    public void rn(String str) {
        this.fp = str;
    }

    public void s(String str) {
        this.ry = str;
    }

    public boolean sh() {
        if (cb() == 1) {
            return true;
        }
        return false;
    }

    public boolean sj() {
        if (com.bytedance.sdk.openadsdk.core.video.cw.j.j(this)) {
            return true;
        }
        if (this.qv.isEmpty()) {
            return false;
        }
        if (this.f30358x == 4 && this.qv.size() < 3) {
            return false;
        }
        Iterator<h> it = this.qv.iterator();
        while (it.hasNext()) {
            if (!it.next().up()) {
                return false;
            }
        }
        return true;
    }

    public void tj(String str) {
        this.f30352s = str;
    }

    public void tl(int i6) {
        this.qn = i6;
    }

    public void uf(String str) {
        this.bh = str;
    }

    public void v(String str) {
        this.kt = str;
    }

    public void vl(String str) {
        this.ve = str;
    }

    public void w(String str) {
        this.f30342i = str;
    }

    public void wq(String str) {
        this.hw = str;
    }

    public void ws(String str) {
        this.f30346m = str;
    }

    public void x(String str) {
        this.nd = str;
    }

    public boolean xa() {
        if (gs() != null) {
            return gs().up();
        }
        return false;
    }

    public void xt(boolean z5) {
        this.ju = z5;
    }

    public void ae(String str) {
        this.ik = str;
    }

    public void cw(String str) {
        this.qf = str;
    }

    public void g(boolean z5) {
        this.ol = z5;
    }

    public void j(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.ek = new w();
            JSONObject optJSONObject = jSONObject.optJSONObject("sdk_template_info");
            if (optJSONObject != null) {
                this.ek.j(optJSONObject.optString("lottie_tmp_url"));
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("aigc");
            if (optJSONObject2 != null) {
                JSONArray optJSONArray = optJSONObject2.optJSONArray("bg_anim_img_android");
                if (optJSONArray != null) {
                    ArrayList arrayList = new ArrayList();
                    this.ek.j(arrayList);
                    for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                        JSONObject optJSONObject3 = optJSONArray.optJSONObject(i6);
                        if (optJSONObject3 != null) {
                            h hVar = new h();
                            hVar.j(optJSONObject3.optInt("width"));
                            hVar.xt(optJSONObject3.optInt("height"));
                            hVar.j(optJSONObject3.optString("url"));
                            arrayList.add(hVar);
                        }
                    }
                }
                JSONArray optJSONArray2 = optJSONObject2.optJSONArray("bg_videos");
                if (optJSONArray2 != null) {
                    ArrayList arrayList2 = new ArrayList();
                    this.ek.xt(arrayList2);
                    for (int i7 = 0; i7 < optJSONArray2.length(); i7++) {
                        JSONObject optJSONObject4 = optJSONArray2.optJSONObject(i7);
                        if (optJSONObject4 != null) {
                            com.bykv.vk.openvk.component.video.api.cw.cw cwVar = new com.bykv.vk.openvk.component.video.api.cw.cw();
                            cwVar.up(optJSONObject4.optString("file_hash"));
                            cwVar.j(optJSONObject4.optString("resolution"));
                            cwVar.j(optJSONObject4.optDouble("video_duration"));
                            cwVar.cw(optJSONObject4.optString("video_url"));
                            arrayList2.add(cwVar);
                        }
                    }
                }
            }
        }
    }

    public void l(String str) {
        this.yl = str;
    }

    public void m(boolean z5) {
        this.ll = z5;
    }

    public void oq(boolean z5) {
        this.xc = z5;
    }

    public void qv(boolean z5) {
        this.uc = z5;
    }

    public void r(boolean z5) {
        this.mp = z5;
    }

    public void tl(String str) {
        this.qo = str;
    }

    public void up(String str) {
        this.ki = str;
    }

    public void vl(boolean z5) {
        this.ay = z5;
    }

    public void xt(String str) {
        this.lg = str;
    }

    public static boolean cw(n nVar) {
        try {
            if (nVar.ag() != null) {
                if (nVar.ag().optInt("parent_type") == 1) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public void ae(boolean z5) {
        this.wq = z5;
    }

    public void g(long j6) {
        if (j6 != 0) {
            this.id = j6;
        } else {
            this.id = System.currentTimeMillis() / 1000;
        }
    }

    public void m(long j6) {
        this.f30347n = j6;
    }

    public void oq(JSONObject jSONObject) {
        this.zw = jSONObject;
    }

    public void qv(JSONObject jSONObject) {
        this.uo = jSONObject;
    }

    public void r(JSONObject jSONObject) {
        this.f30340g = jSONObject;
    }

    public void tl(boolean z5) {
        this.uf = z5;
    }

    public void up(boolean z5) {
        this.uq = z5;
    }

    public void xt(JSONObject jSONObject) {
        this.mz = jSONObject;
    }

    public static boolean xt(n nVar) {
        if (nVar == null) {
            return false;
        }
        return nVar.ve() == 5 || nVar.ve() == 15 || nVar.ve() == 166;
    }

    public void ae(long j6) {
        this.f30336c = j6;
    }

    public void cw(long j6) {
        this.wo = j6;
    }

    public void m(JSONObject jSONObject) {
        this.rr = jSONObject;
    }

    public void r(long j6) {
        this.av = j6;
    }

    public void tl(long j6) {
        this.gx = j6;
    }

    public void up(JSONObject jSONObject) {
        this.oq = jSONObject;
    }

    public static void m(n nVar) {
        if (nVar == null) {
            return;
        }
        nVar.si = System.currentTimeMillis();
    }

    public static boolean r(n nVar) {
        return nVar != null && nVar.zi == 1;
    }

    public void ae(JSONObject jSONObject) {
        this.pz = jSONObject;
    }

    public void cw(JSONObject jSONObject) {
        this.pm = jSONObject;
    }

    public void g(JSONObject jSONObject) {
        this.fj = jSONObject;
    }

    public void tl(JSONObject jSONObject) {
        this.gs = jSONObject;
    }

    public void up(long j6) {
        this.f30349p = j6;
    }

    public static boolean up(n nVar) {
        if (nVar == null || nVar.si <= 0 || nVar.sj <= 0) {
            return false;
        }
        boolean z5 = System.currentTimeMillis() - nVar.si < ((long) nVar.sj);
        if (z5) {
            nVar.km++;
            com.bytedance.sdk.openadsdk.core.kt.ws.j().xt(new com.bytedance.sdk.openadsdk.vl.j.j() { // from class: com.bytedance.sdk.openadsdk.core.tj.n.1
                @Override // com.bytedance.sdk.openadsdk.vl.j.j
                public com.bytedance.sdk.openadsdk.core.kt.j.j j() throws Exception {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("count", n.this.km);
                    jSONObject.put("click_freq", n.this.sj);
                    return com.bytedance.sdk.openadsdk.core.kt.j.xt.xt().j("click_intercept").tl(n.this.os()).xt(jSONObject.toString());
                }
            }, "click_intercept");
        }
        return z5;
    }

    public void cw(float f6) {
        this.el = f6;
    }

    public void xt(long j6) {
        this.by = j6;
    }

    public void xt(double d6) {
        if (d6 != 2.0d && d6 != 1.0d) {
            this.nu = 2;
        } else {
            this.nu = (int) d6;
        }
    }

    public void xt(h hVar) {
        this.qv.add(hVar);
    }

    public void xt(float f6) {
        this.f30348o = f6;
    }

    public void j(String str) {
        this.sh = str;
    }

    public static boolean j(n nVar) {
        return nVar != null && nVar.ol() == 1;
    }

    public void j(long j6) {
        this.ri = j6;
    }

    public void j(com.bytedance.sdk.openadsdk.core.ugeno.m.j jVar) {
        this.al = jVar;
    }

    public void j(com.bytedance.sdk.openadsdk.core.ugeno.g.j jVar) {
        this.f30354tv = jVar;
    }

    public void j(double d6) {
        if (d6 != 2.0d && d6 != 1.0d) {
            this.om = 2;
        } else {
            this.om = (int) d6;
        }
    }

    public void j(e eVar) {
        this.hl = eVar;
    }

    public void j(la laVar) {
        this.lw = laVar;
    }

    public void j(ol olVar) {
        this.f1if = olVar;
    }

    public void j(hh hhVar) {
        this.yu = hhVar;
    }

    public void j(kt ktVar) {
        this.os = ktVar;
    }

    public void j(xq xqVar) {
        this.to = xqVar;
    }

    public void j(g gVar) {
        this.ya = gVar;
    }

    public void j(com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar) {
        if (xtVar == null) {
            com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar2 = this.sm;
            if (xtVar2 != null) {
                this.sm = new cw(xtVar2);
                return;
            }
            return;
        }
        this.sm = xtVar;
    }

    public void j(tj tjVar) {
        this.hh = tjVar;
    }

    public void j(ff ffVar) {
        this.f30359y = ffVar;
    }

    public void j(m mVar) {
        this.fk = mVar;
    }

    public void j(ln lnVar) {
        this.gq = lnVar;
    }

    public void j(h hVar) {
        this.up = hVar;
    }

    public void j(up upVar) {
        this.tj = upVar;
    }

    public void j(f fVar) {
        this.f30339f = fVar;
    }

    public void j(i iVar) {
        this.f30356v = iVar;
    }

    public void j(Map<String, Object> map) {
        this.f30360z = map;
    }

    public void j(com.bytedance.sdk.openadsdk.core.dislike.cw.xt xtVar) {
        this.cw = xtVar;
    }

    public void j(rh rhVar) {
        this.gr = rhVar;
    }

    public void j(rn rnVar) {
        this.ej = rnVar;
    }

    public void j(float f6) {
        this.xw = f6;
    }

    public void j(ch chVar) {
        this.cb = chVar;
        if (chVar != null) {
            String xt = chVar.xt();
            String cw = this.cb.cw();
            if (TextUtils.isEmpty(xt)) {
                return;
            }
            com.bytedance.sdk.openadsdk.core.ugeno.oq.j(xt, cw);
        }
    }

    public void j(s sVar) {
        this.ij = sVar;
    }

    public void j(hl hlVar) {
        this.et = hlVar;
    }

    public void j(uf ufVar) {
        this.ov = ufVar;
    }

    public void j(xp xpVar) {
        this.f30343j = xpVar;
    }

    public void j(zz zzVar) {
        this.zs = zzVar;
    }

    public void j(k kVar) {
        this.hu = kVar;
    }

    public void j(z zVar) {
        this.f30335b = zVar;
    }

    public void j(ws wsVar) {
        this.ja = wsVar;
    }

    public void j(c cVar) {
        this.zk = cVar;
    }

    public void j(qb qbVar) {
        this.sf = qbVar;
    }

    public void j(az azVar) {
        this.kk = azVar;
    }

    public void j(kc kcVar) {
        this.fs = kcVar;
    }

    public void j(vl vlVar) {
        this.hk = vlVar;
    }

    public void j(ed edVar) {
        this.f30338e = edVar;
    }

    public void j(com.bykv.vk.openvk.component.video.api.cw.cw cwVar) {
        if (this.gq == null) {
            this.gq = new ln();
        }
        this.gq.j(cwVar);
    }

    public void j(gq gqVar) {
        this.so = gqVar;
    }

    public void j(v vVar) {
        this.ot = vVar;
    }

    public void j(l lVar) {
        this.nv = lVar;
    }

    public void j(a aVar) {
        this.ih = aVar;
    }
}
