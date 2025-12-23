package com.bytedance.sdk.openadsdk.core.tj;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class e {
    private static int cw = 0;

    /* renamed from: j, reason: collision with root package name */
    private static long f30245j = 27000;
    private static int xt;

    /* renamed from: a, reason: collision with root package name */
    private boolean f30246a;
    private boolean ae;
    private boolean av;
    private int az;
    private ArrayList<qa> ch;

    /* renamed from: f, reason: collision with root package name */
    private int f30247f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f30248g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f30249h;

    /* renamed from: i, reason: collision with root package name */
    private double f30250i;
    private int jy;
    private int kt;

    /* renamed from: l, reason: collision with root package name */
    private boolean f30251l;
    private int la;

    /* renamed from: m, reason: collision with root package name */
    private boolean f30252m;
    private double mi;
    private double oq;

    /* renamed from: p, reason: collision with root package name */
    private int f30253p;
    private String qv;

    /* renamed from: r, reason: collision with root package name */
    private String f30254r;

    /* renamed from: s, reason: collision with root package name */
    private q f30255s;
    private int tj;
    private double tl;
    private int up;

    /* renamed from: v, reason: collision with root package name */
    private boolean f30256v;
    private int vl;

    /* renamed from: w, reason: collision with root package name */
    private boolean f30257w;
    private int ws;

    /* renamed from: x, reason: collision with root package name */
    private boolean f30258x;

    public static boolean cw(n nVar) {
        e l6 = l(nVar);
        if (l6 == null) {
            return false;
        }
        return l6.f30252m;
    }

    public static void j(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("app_common_config");
        if (optJSONObject != null) {
            try {
                f30245j = optJSONObject.optLong("reward_time_limited", 27000L);
                xt = optJSONObject.optInt("reward_force_close_max_count", 0);
                cw = optJSONObject.optInt("reward_local_countdown_close_style", 0);
            } catch (Exception unused) {
            }
        }
    }

    public static void xt(com.bytedance.sdk.component.r.j.xt xtVar) {
        f30245j = xtVar.xt("reward_time_limited", 27000L);
        xt = xtVar.xt("reward_force_close_max_count", 0);
        cw = xtVar.xt("reward_local_countdown_close_style", 0);
    }

    private static e l(n nVar) {
        if (nVar == null) {
            return null;
        }
        return nVar.hh();
    }

    public e(JSONObject jSONObject) {
        this.f30247f = 0;
        this.f30256v = false;
        this.f30258x = false;
        this.ch = new ArrayList<>();
        if (jSONObject == null) {
            return;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("reward");
        if (optJSONObject != null) {
            JSONArray optJSONArray = optJSONObject.optJSONArray("retain_dialog_config");
            if (optJSONArray != null) {
                this.ch = new ArrayList<>();
                for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                    JSONObject optJSONObject2 = optJSONArray.optJSONObject(i6);
                    if (optJSONObject2 != null) {
                        this.ch.add(new qa(optJSONObject2));
                    }
                }
            }
            this.f30255s = new q(optJSONObject);
            this.f30251l = optJSONObject.optBoolean("endcard_transform_enabled", false);
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject("reward_data");
        if (optJSONObject3 != null) {
            this.up = optJSONObject3.optInt(MediationConstant.REWARD_AMOUNT, 0);
            this.f30254r = optJSONObject3.optString(MediationConstant.REWARD_NAME, "");
            this.f30252m = optJSONObject3.optBoolean("reward_info_show", false);
            this.jy = optJSONObject3.optInt("reward_back_type", 0);
            this.ws = optJSONObject3.optInt("reward_backup_timing", 0);
            this.az = optJSONObject3.optInt("reward_backup_duration", Integer.MAX_VALUE);
            this.f30253p = optJSONObject3.optInt("reward_is_callback", 0);
            this.f30249h = optJSONObject3.optBoolean("reward_need_click", false);
            JSONObject optJSONObject4 = optJSONObject3.optJSONObject("reward_advanced_config");
            if (optJSONObject4 != null) {
                JSONObject optJSONObject5 = optJSONObject4.optJSONObject("easy_playable");
                if (optJSONObject5 != null) {
                    this.ae = optJSONObject5.optBoolean("enable");
                    double optDouble = optJSONObject5.optDouble("propose_reward", 0.0d);
                    this.tl = optDouble;
                    if (optDouble < 0.0d) {
                        this.tl = 0.0d;
                    }
                }
                JSONObject optJSONObject6 = optJSONObject4.optJSONObject("play_complete");
                if (optJSONObject6 != null) {
                    this.f30248g = optJSONObject6.optBoolean("enable");
                    double optDouble2 = optJSONObject6.optDouble("propose_reward", 0.0d);
                    this.oq = optDouble2;
                    if (optDouble2 < 0.0d) {
                        this.oq = 0.0d;
                    }
                    this.qv = optJSONObject6.optString("tip_toast");
                    this.vl = optJSONObject6.optInt("min_duration");
                }
                JSONObject optJSONObject7 = optJSONObject4.optJSONObject("playable_interactive");
                if (optJSONObject7 != null) {
                    this.av = optJSONObject7.optBoolean("enable");
                    this.f30250i = optJSONObject7.optDouble("propose_reward", 0.0d);
                }
                JSONObject optJSONObject8 = optJSONObject4.optJSONObject("click_landing");
                if (optJSONObject8 != null) {
                    this.f30257w = optJSONObject8.optBoolean("enable");
                    this.mi = optJSONObject8.optDouble("propose_reward", 0.0d);
                    this.kt = optJSONObject8.optInt("landing_view_time", 5);
                }
            }
        }
        this.tj = jSONObject.optInt("reward_full_play_time", 30);
        this.f30247f = jSONObject.optInt("reward_full_time_type", 0);
        this.f30246a = jSONObject.optBoolean("interstitial_bg_transparent", false);
        this.la = jSONObject.optInt("template_sign", 0);
        this.f30256v = jSONObject.optBoolean("__is_use_local_time", false);
        this.f30258x = jSONObject.optBoolean("__is_click_landing_reward", false);
    }

    public static int a(n nVar) {
        e l6 = l(nVar);
        if (l6 == null) {
            return 0;
        }
        return l6.la;
    }

    public static boolean ae(n nVar) {
        e l6 = l(nVar);
        if (l6 == null) {
            return false;
        }
        return l6.f30248g;
    }

    public static int av(n nVar) {
        e l6 = l(nVar);
        if (l6 == null) {
            return 0;
        }
        return l6.f30247f;
    }

    public static int az(n nVar) {
        int i6;
        e l6 = l(nVar);
        if (l6 == null || (i6 = l6.tj) < 10 || i6 > 60) {
            return 30;
        }
        return i6;
    }

    public static boolean ch(n nVar) {
        e l6 = l(nVar);
        if (l6 == null || l6.f30253p != 1) {
            return false;
        }
        return true;
    }

    public static boolean cw() {
        return cw == 1;
    }

    public static q f(n nVar) {
        e l6 = l(nVar);
        if (l6 != null) {
            return l6.f30255s;
        }
        return null;
    }

    public static String g(n nVar) {
        e l6 = l(nVar);
        if (l6 == null) {
            return "";
        }
        if (TextUtils.isEmpty(l6.qv)) {
            return "别急着跳过，继续观看完整视频，可获得更多额外奖励～";
        }
        return l6.qv;
    }

    public static boolean i(n nVar) {
        e l6 = l(nVar);
        if (l6 == null || !l6.f30256v) {
            return false;
        }
        if (!kt.r(nVar) && av(nVar) != 1 && av(nVar) != 2) {
            return false;
        }
        return true;
    }

    public static boolean jy(n nVar) {
        e l6 = l(nVar);
        if (l6 == null) {
            return false;
        }
        return l6.f30257w;
    }

    public static ArrayList<qa> kt(n nVar) {
        e l6 = l(nVar);
        if (l6 != null) {
            return l6.ch;
        }
        return new ArrayList<>();
    }

    public static double m(n nVar) {
        e l6 = l(nVar);
        if (l6 == null) {
            return 0.0d;
        }
        return l6.tl;
    }

    public static boolean mi(n nVar) {
        e l6 = l(nVar);
        if (l6 == null || !l6.f30258x) {
            return false;
        }
        return jy(nVar);
    }

    public static int oq(n nVar) {
        e l6 = l(nVar);
        if (l6 == null) {
            return KSImageLoader.InnerImageLoadingListener.MAX_DURATION;
        }
        int i6 = 30;
        int max = Math.max(l6.vl, 30);
        if (max <= 60) {
            i6 = max;
        }
        return i6 * 1000;
    }

    public static boolean qv(n nVar) {
        e l6 = l(nVar);
        if (l6 == null) {
            return false;
        }
        return l6.av;
    }

    public static boolean r(n nVar) {
        e l6 = l(nVar);
        if (l6 == null || l6.jy != 1) {
            return false;
        }
        return true;
    }

    public static boolean s(n nVar) {
        e l6 = l(nVar);
        if (l6 == null) {
            return false;
        }
        return l6.f30249h;
    }

    public static boolean tj(n nVar) {
        e l6 = l(nVar);
        if (l6 == null || l6.ws != 1) {
            return false;
        }
        return true;
    }

    public static double tl(n nVar) {
        e l6 = l(nVar);
        if (l6 == null) {
            return 0.0d;
        }
        return l6.oq;
    }

    public static boolean up(n nVar) {
        e l6 = l(nVar);
        if (l6 == null) {
            return false;
        }
        return l6.ae;
    }

    public static boolean v(n nVar) {
        e l6 = l(nVar);
        if (l6 != null) {
            return l6.f30246a;
        }
        return false;
    }

    public static double vl(n nVar) {
        e l6 = l(nVar);
        if (l6 == null) {
            return 0.0d;
        }
        return l6.f30250i;
    }

    public static boolean w(n nVar) {
        e l6 = l(nVar);
        if (l6 == null || !l6.f30256v || av(nVar) != 1) {
            return false;
        }
        return true;
    }

    public static int ws(n nVar) {
        e l6 = l(nVar);
        if (l6 == null) {
            return 5;
        }
        return Math.max(5, l6.kt);
    }

    public static boolean x(n nVar) {
        e l6 = l(nVar);
        if (l6 == null) {
            return false;
        }
        return l6.f30251l;
    }

    public void xt(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            ArrayList<qa> arrayList = this.ch;
            if (arrayList != null && arrayList.size() != 0) {
                Iterator<qa> it = this.ch.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next().j());
                }
            }
            jSONObject2.put("retain_dialog_config", jSONArray);
            q qVar = this.f30255s;
            if (qVar != null) {
                qVar.j(jSONObject2);
            }
            jSONObject2.put("endcard_transform_enabled", this.f30251l);
            jSONObject.put("reward", jSONObject2);
        } catch (JSONException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
        }
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(MediationConstant.REWARD_NAME, this.f30254r);
            jSONObject3.put(MediationConstant.REWARD_AMOUNT, this.up);
            jSONObject3.put("reward_info_show", this.f30252m);
            jSONObject3.put("reward_back_type", this.jy);
            jSONObject3.put("reward_backup_timing", this.ws);
            jSONObject3.put("reward_backup_duration", this.az);
            jSONObject3.put("reward_is_callback", this.f30253p);
            jSONObject3.put("reward_need_click", this.f30249h);
            JSONObject jSONObject4 = new JSONObject();
            JSONObject jSONObject5 = new JSONObject();
            jSONObject5.put("enable", this.ae);
            jSONObject5.put("propose_reward", this.tl);
            jSONObject4.put("easy_playable", jSONObject5);
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6.put("enable", this.f30248g);
            jSONObject6.put("propose_reward", this.oq);
            jSONObject6.put("tip_toast", this.qv);
            jSONObject6.put("min_duration", this.vl);
            jSONObject4.put("play_complete", jSONObject6);
            JSONObject jSONObject7 = new JSONObject();
            jSONObject7.put("enable", this.av);
            jSONObject7.put("propose_reward", this.f30250i);
            jSONObject4.put("playable_interactive", jSONObject7);
            JSONObject jSONObject8 = new JSONObject();
            jSONObject8.put("enable", this.f30257w);
            jSONObject8.put("propose_reward", this.mi);
            jSONObject8.put("landing_view_time", this.kt);
            jSONObject4.put("click_landing", jSONObject8);
            jSONObject3.put("reward_advanced_config", jSONObject4);
            jSONObject.put("reward_data", jSONObject3);
        } catch (JSONException e7) {
            com.bytedance.sdk.component.utils.vl.j(e7);
        }
        try {
            jSONObject.put("reward_full_play_time", this.tj);
            jSONObject.put("reward_full_time_type", this.f30247f);
            jSONObject.put("interstitial_bg_transparent", this.f30246a);
            jSONObject.put("template_sign", this.la);
            jSONObject.put("__is_use_local_time", this.f30256v);
            jSONObject.put("__is_click_landing_reward", this.f30258x);
        } catch (JSONException e8) {
            com.bytedance.sdk.component.utils.vl.j(e8);
        }
    }

    public static void j(com.bytedance.sdk.component.r.j.xt xtVar) {
        xtVar.j("reward_time_limited", f30245j);
        xtVar.j("reward_force_close_max_count", xt);
        xtVar.j("reward_local_countdown_close_style", cw);
    }

    public static String j(n nVar) {
        e l6 = l(nVar);
        if (l6 == null) {
            return "";
        }
        return l6.f30254r;
    }

    public static long j() {
        return f30245j;
    }

    public static float j(n nVar, int i6) {
        double m6;
        if (i6 == 0) {
            return 1.0f;
        }
        if (i6 == 1) {
            m6 = m(nVar);
        } else if (i6 == 2) {
            m6 = tl(nVar);
        } else {
            if (i6 != 3) {
                return 0.0f;
            }
            m6 = vl(nVar);
        }
        return (float) m6;
    }

    public static void j(n nVar, boolean z5) {
        e l6 = l(nVar);
        if (l6 != null) {
            l6.f30256v = z5;
        }
    }

    public static int xt(n nVar) {
        e l6 = l(nVar);
        if (l6 == null) {
            return 0;
        }
        return l6.up;
    }

    public static long xt() {
        return xt;
    }

    public static void xt(n nVar, boolean z5) {
        e l6 = l(nVar);
        if (l6 != null) {
            l6.f30258x = z5;
        }
    }

    public static int xt(n nVar, int i6) {
        int i7;
        e l6 = l(nVar);
        return (l6 != null && (i7 = l6.az) > 0) ? Math.min(i6, i7) : i6;
    }
}
