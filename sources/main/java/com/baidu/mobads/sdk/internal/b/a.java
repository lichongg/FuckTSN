package com.baidu.mobads.sdk.internal.b;

import com.baidu.mobads.proxy.R;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.Map;
import xyz.adscope.common.v2.dev.info.ResIdentify;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class a implements IOAdEventListener {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.baidu.mobads.sdk.internal.b.a$a, reason: collision with other inner class name */
    public static class C0101a {
        public static final String A = "ic_white_cross";
        public static final String B = "ic_gray_complaints";
        public static final String C = "ic_gray_low_quality";
        public static final String D = "ic_gray_repeat";
        public static final String E = "ic_gray_unlike";
        public static final String F = "ic_white_ad_logo_gray_bg";
        public static final String G = "ic_white_bqt_logo_gray_bg";
        public static final String H = "ic_white_shake_gesture";
        public static final String I = "ic_arrow_up";
        public static final String J = "ic_blue_no_ad";
        public static final String K = "ic_fallback_gray";
        public static final String L = "ic_gift_box";
        public static final String M = "ic_gift_ribbon";
        public static final String N = "ic_gold_star";
        public static final String O = "ic_gray_left_quot";
        public static final String P = "ic_gray_right_quot";
        public static final String Q = "ic_gray_star";
        public static final String R = "ic_half_gold_star";
        public static final String S = "ic_orange_cross";
        public static final String T = "ic_twist_phone";
        public static final String U = "ic_white_answer_error";
        public static final String V = "ic_white_answer_right";
        public static final String W = "ic_white_ad_logo";
        public static final String X = "ic_white_cross_in_circle";
        public static final String Y = "ic_black_arrow_left";
        public static final String Z = "ic_black_three_points";

        /* renamed from: a, reason: collision with root package name */
        public static final String f10676a = "rsp_big_red_heart";
        public static final String aA = "ic_white_three_points";
        public static final String aB = "ic_white_voice";
        public static final String aC = "ic_white_voice_mute";
        public static final String aD = "ic_white_pause_gray_round";
        public static final String aE = "ic_yellow_dl_black_bg";
        public static final String aF = "ic_yellow_lp_black_bg";
        public static final String aa = "ic_gray_ad";
        public static final String ab = "ic_gray_ad_logo";
        public static final String ac = "ic_gray_bqt_logo";
        public static final String ad = "ic_gray_cross_black_round";
        public static final String ae = "ic_gray_cross_white_oval";
        public static final String af = "ic_gray_logo";
        public static final String ag = "ic_slide_arrow_duplicate";
        public static final String ah = "ic_slide_arrow_point";
        public static final String ai = "ic_white_ad_gray_bg";
        public static final String aj = "ic_white_arrow_left";
        public static final String ak = "ic_white_arrow_right";
        public static final String al = "ic_white_bqt_gray_bg";
        public static final String am = "ic_white_bqt_logo";
        public static final String an = "ic_white_comments";
        public static final String ao = "ic_white_cross_circle_shadow";
        public static final String ap = "ic_white_finger_shadow";
        public static final String aq = "ic_white_logo";
        public static final String ar = "ic_white_logo_gray_bg";
        public static final String as = "ic_white_replay";
        public static final String at = "ic_white_replay_gray_round";
        public static final String au = "ic_white_speed075";
        public static final String av = "ic_white_speed100";
        public static final String aw = "ic_white_speed125";
        public static final String ax = "ic_white_speed150";
        public static final String ay = "ic_white_speed175";
        public static final String az = "ic_white_speed200";

        /* renamed from: b, reason: collision with root package name */
        public static final String f10677b = "rsp_small_red_heart";

        /* renamed from: c, reason: collision with root package name */
        public static final String f10678c = "bg_blur_white";

        /* renamed from: d, reason: collision with root package name */
        public static final String f10679d = "bg_app_icon";

        /* renamed from: e, reason: collision with root package name */
        public static final String f10680e = "bg_hot_recommendation";

        /* renamed from: f, reason: collision with root package name */
        public static final String f10681f = "bg_black_round_rectangle";

        /* renamed from: g, reason: collision with root package name */
        public static final String f10682g = "bg_red_rectangle";

        /* renamed from: h, reason: collision with root package name */
        public static final String f10683h = "bg_red_circle";

        /* renamed from: i, reason: collision with root package name */
        public static final String f10684i = "bg_red_ribbon_rectangle";

        /* renamed from: j, reason: collision with root package name */
        public static final String f10685j = "bg_red_ribbon_circle";

        /* renamed from: k, reason: collision with root package name */
        public static final String f10686k = "ic_video_play";

        /* renamed from: l, reason: collision with root package name */
        public static final String f10687l = "ic_stars";

        /* renamed from: m, reason: collision with root package name */
        public static final String f10688m = "ic_fallback";

        /* renamed from: n, reason: collision with root package name */
        public static final String f10689n = "ic_guide_circle";

        /* renamed from: o, reason: collision with root package name */
        public static final String f10690o = "ic_guide_finger";

        /* renamed from: p, reason: collision with root package name */
        public static final String f10691p = "ic_white_play";

        /* renamed from: q, reason: collision with root package name */
        public static final String f10692q = "ic_white_pause";

        /* renamed from: r, reason: collision with root package name */
        public static final String f10693r = "ic_white_apo";

        /* renamed from: s, reason: collision with root package name */
        public static final String f10694s = "ic_white_dl";

        /* renamed from: t, reason: collision with root package name */
        public static final String f10695t = "ic_white_link";

        /* renamed from: u, reason: collision with root package name */
        public static final String f10696u = "ic_white_fullscreen_shrink";

        /* renamed from: v, reason: collision with root package name */
        public static final String f10697v = "ic_white_fullscreen_stretch";

        /* renamed from: w, reason: collision with root package name */
        public static final String f10698w = "ic_black_cross";

        /* renamed from: x, reason: collision with root package name */
        public static final String f10699x = "ic_white_cross_dark_round";

        /* renamed from: y, reason: collision with root package name */
        public static final String f10700y = "ic_gray_cross";

        /* renamed from: z, reason: collision with root package name */
        public static final String f10701z = "ic_light_gray_cross";
    }

    private Integer b(String str) {
        return null;
    }

    private Integer c(String str) {
        return null;
    }

    private Integer d(String str) {
        return null;
    }

    private Integer a(String str) {
        if (C0101a.f10678c.equals(str)) {
            return Integer.valueOf(R.drawable.bd_bg_blur_white);
        }
        if (C0101a.f10679d.equals(str)) {
            return Integer.valueOf(R.drawable.bd_bg_app_icon);
        }
        if (C0101a.f10680e.equals(str)) {
            return Integer.valueOf(R.drawable.bd_bg_hot_recommendation);
        }
        if (C0101a.f10681f.equals(str)) {
            return Integer.valueOf(R.drawable.bd_bg_black_round_rectangle);
        }
        if (C0101a.f10682g.equals(str)) {
            return Integer.valueOf(R.drawable.bd_bg_red_rect);
        }
        if (C0101a.f10683h.equals(str)) {
            return Integer.valueOf(R.drawable.bd_bg_red_circle);
        }
        if (C0101a.f10684i.equals(str)) {
            return Integer.valueOf(R.drawable.bd_bg_red_ribbon_rect);
        }
        if (C0101a.f10685j.equals(str)) {
            return Integer.valueOf(R.drawable.bd_bg_red_ribbon_circle);
        }
        if (C0101a.f10686k.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_video_play);
        }
        if (C0101a.f10687l.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_stars);
        }
        if (C0101a.f10688m.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_fallback);
        }
        if (C0101a.f10689n.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_guide_circle);
        }
        if (C0101a.f10690o.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_guide_finger);
        }
        if (C0101a.f10691p.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_play);
        }
        if (C0101a.f10692q.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_pause);
        }
        if (C0101a.f10693r.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_apo);
        }
        if (C0101a.f10694s.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_dl);
        }
        if (C0101a.f10695t.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_link);
        }
        if (C0101a.f10696u.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_fullscreen_shrink);
        }
        if (C0101a.f10697v.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_fullscreen_stretch);
        }
        if (C0101a.f10698w.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_black_cross);
        }
        if (C0101a.f10699x.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_cross_dark_round);
        }
        if (C0101a.f10676a.equals(str)) {
            return Integer.valueOf(R.drawable.bd_rsp_big_red_heart);
        }
        if (C0101a.f10677b.equals(str)) {
            return Integer.valueOf(R.drawable.bd_rsp_small_red_heart);
        }
        if (C0101a.f10700y.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_gray_cross);
        }
        if (C0101a.f10701z.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_light_gray_cross);
        }
        if (C0101a.A.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_cross);
        }
        if (C0101a.B.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_gray_complaints);
        }
        if (C0101a.C.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_gray_low_quality);
        }
        if (C0101a.D.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_gray_repeat);
        }
        if (C0101a.E.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_gray_unlike);
        }
        if (C0101a.F.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_ad_logo_gray_bg);
        }
        if (C0101a.G.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_bqt_logo_gray_bg);
        }
        if (C0101a.H.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_shake_gesture);
        }
        if (C0101a.I.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_arrow_up);
        }
        if (C0101a.J.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_blue_no_ad);
        }
        if (C0101a.K.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_fallback_gray);
        }
        if (C0101a.L.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_gift_box);
        }
        if (C0101a.M.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_gift_ribbon);
        }
        if (C0101a.N.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_gold_star);
        }
        if (C0101a.O.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_gray_left_quot);
        }
        if (C0101a.P.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_gray_right_quot);
        }
        if (C0101a.Q.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_gray_star);
        }
        if (C0101a.R.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_half_gold_star);
        }
        if (C0101a.S.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_orange_cross);
        }
        if (C0101a.T.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_twist_phone);
        }
        if (C0101a.W.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_ad_logo);
        }
        if (C0101a.U.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_answer_error);
        }
        if (C0101a.V.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_answer_right);
        }
        if (C0101a.X.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_cross_in_circle);
        }
        if (C0101a.Y.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_black_arrow_left);
        }
        if (C0101a.Z.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_black_three_points);
        }
        if (C0101a.aa.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_gray_ad);
        }
        if (C0101a.ab.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_gray_ad_logo);
        }
        if (C0101a.ac.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_gray_bqt_logo);
        }
        if (C0101a.ad.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_gray_cross_black_round);
        }
        if (C0101a.ae.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_gray_cross_white_oval);
        }
        if (C0101a.af.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_gray_logo);
        }
        if (C0101a.ag.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_slide_arrow_duplicate);
        }
        if (C0101a.ah.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_slide_arrow_point);
        }
        if (C0101a.ai.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_ad_gray_bg);
        }
        if (C0101a.aj.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_arrow_left);
        }
        if (C0101a.ak.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_arrow_right);
        }
        if (C0101a.al.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_bqt_gray_bg);
        }
        if (C0101a.am.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_bqt_logo);
        }
        if (C0101a.an.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_comments);
        }
        if (C0101a.ao.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_cross_circle_shadow);
        }
        if (C0101a.ap.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_finger_shadow);
        }
        if (C0101a.aq.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_logo);
        }
        if (C0101a.ar.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_logo_gray_bg);
        }
        if (C0101a.aD.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_pause_gray_round);
        }
        if (C0101a.as.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_replay);
        }
        if (C0101a.at.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_replay_gray_round);
        }
        if (C0101a.au.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_speed075);
        }
        if (C0101a.av.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_speed100);
        }
        if (C0101a.aw.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_speed125);
        }
        if (C0101a.ax.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_speed150);
        }
        if (C0101a.ay.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_speed175);
        }
        if (C0101a.az.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_speed200);
        }
        if (C0101a.aA.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_three_points);
        }
        if (C0101a.aB.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_voice);
        }
        if (C0101a.aC.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_voice_mute);
        }
        if (C0101a.aE.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_yellow_dl_black_bg);
        }
        if (C0101a.aF.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_yellow_lp_black_bg);
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        if (iOAdEvent != null) {
            String type = iOAdEvent.getType();
            Map<String, Object> data = iOAdEvent.getData();
            String str = (String) data.get(CommonNetImpl.NAME);
            data.put("id", ResIdentify.RES_TYPE_DRAWABLE.equals(type) ? a(str) : ResIdentify.RES_TYPE_LAYOUT.equals(type) ? b(str) : ResIdentify.RES_TYPE_STRING.equals(type) ? c(str) : ResIdentify.RES_TYPE_STYLE.equals(type) ? d(str) : null);
        }
    }
}
