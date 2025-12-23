package com.umeng.analytics.pro;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class au {
    public static final String A = "rtd";
    public static final String B = "lepd";
    public static final String C = "ccfg";
    private static Map<String, String> D = null;
    private static String E = null;

    /* renamed from: a, reason: collision with root package name */
    public static final String f40896a = "env";

    /* renamed from: b, reason: collision with root package name */
    public static final String f40897b = "exp";

    /* renamed from: c, reason: collision with root package name */
    public static final String f40898c = "imp";

    /* renamed from: d, reason: collision with root package name */
    public static final String f40899d = "ua";

    /* renamed from: e, reason: collision with root package name */
    public static final String f40900e = "zc";

    /* renamed from: f, reason: collision with root package name */
    public static final String f40901f = "id";

    /* renamed from: g, reason: collision with root package name */
    public static final String f40902g = "zf";

    /* renamed from: h, reason: collision with root package name */
    public static final String f40903h = "exid";

    /* renamed from: i, reason: collision with root package name */
    public static final String f40904i = "ucc";

    /* renamed from: j, reason: collision with root package name */
    public static final String f40905j = "ugc";

    /* renamed from: k, reason: collision with root package name */
    public static final String f40906k = "usi";

    /* renamed from: l, reason: collision with root package name */
    public static final String f40907l = "uso";

    /* renamed from: m, reason: collision with root package name */
    public static final String f40908m = "user";

    /* renamed from: n, reason: collision with root package name */
    public static final String f40909n = "uspi";

    /* renamed from: o, reason: collision with root package name */
    public static final String f40910o = "dtfn";

    /* renamed from: p, reason: collision with root package name */
    public static final String f40911p = "pr";

    /* renamed from: q, reason: collision with root package name */
    public static final String f40912q = "upg";

    /* renamed from: r, reason: collision with root package name */
    public static final String f40913r = "pri";

    /* renamed from: s, reason: collision with root package name */
    public static final String f40914s = "probe";

    /* renamed from: t, reason: collision with root package name */
    public static final String f40915t = "bl";

    /* renamed from: u, reason: collision with root package name */
    public static final String f40916u = "wl";

    /* renamed from: v, reason: collision with root package name */
    public static final String f40917v = "subp";

    /* renamed from: w, reason: collision with root package name */
    public static final String f40918w = "subua";

    /* renamed from: x, reason: collision with root package name */
    public static final String f40919x = "sta";

    /* renamed from: y, reason: collision with root package name */
    public static final String f40920y = "emi";

    /* renamed from: z, reason: collision with root package name */
    public static final String f40921z = "sli";

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.umeng.analytics.pro.au$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final au f40922a = new au(null);

        private a() {
        }
    }

    /* synthetic */ au(AnonymousClass1 anonymousClass1) {
        this();
    }

    public void a(String str) {
        if (!TextUtils.isEmpty(str) && TextUtils.isEmpty(E)) {
            if (str.length() > 3) {
                E = str.substring(0, 3) + "_";
                return;
            }
            E = str + "_";
        }
    }

    public String b(String str) {
        if (!D.containsKey(str)) {
            return "";
        }
        String str2 = D.get(str);
        if (!f40897b.equalsIgnoreCase(str) && !f40898c.equalsIgnoreCase(str) && !f40920y.equalsIgnoreCase(str)) {
            return E + str2;
        }
        return "." + E + str2.substring(1);
    }

    static {
        HashMap hashMap = new HashMap();
        D = hashMap;
        E = "";
        hashMap.put(f40896a, "envelope");
        D.put(f40897b, ".umeng");
        D.put(f40898c, ".imprint");
        D.put(f40899d, "ua.db");
        D.put(f40900e, "umeng_zero_cache.db");
        D.put("id", "umeng_it.cache");
        D.put(f40902g, "umeng_zcfg_flag");
        D.put(f40903h, "exid.dat");
        D.put(f40904i, "umeng_common_config");
        D.put(f40905j, "umeng_general_config");
        D.put(f40906k, "um_session_id");
        D.put(f40907l, "umeng_sp_oaid");
        D.put(f40908m, "mobclick_agent_user_");
        D.put(f40909n, "umeng_subprocess_info");
        D.put(f40910o, "delayed_transmission_flag_new");
        D.put("pr", "umeng_policy_result_flag");
        D.put(f40912q, "um_policy_grant");
        D.put(f40913r, "um_pri");
        D.put(f40914s, "UM_PROBE_DATA");
        D.put(f40915t, "ekv_bl");
        D.put(f40916u, "ekv_wl");
        D.put(f40917v, e.f41220a);
        D.put(f40918w, "ua_");
        D.put(f40919x, "stateless");
        D.put(f40920y, ".emitter");
        D.put(f40921z, "um_slmode_sp");
        D.put(A, "um_rtd_conf");
        D.put(B, "");
        D.put(C, ".dmpvedpogjhejs.cfg");
    }

    private au() {
    }

    public void a() {
        E = "";
    }

    public static au b() {
        return a.f40922a;
    }
}
