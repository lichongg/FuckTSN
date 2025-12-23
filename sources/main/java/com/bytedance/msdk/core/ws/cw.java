package com.bytedance.msdk.core.ws;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.msdk.api.r.av;
import com.bytedance.msdk.core.oq.oq;
import com.bytedance.msdk.core.oq.r;
import com.bytedance.msdk.core.tl.ws;
import com.bytedance.msdk.j.up.m;
import com.bytedance.msdk.m.xt.up;
import com.bytedance.msdk.tl.l;
import com.bytedance.msdk.tl.rn;
import com.bytedance.msdk.tl.x;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class cw implements j {
    private String ae;

    /* renamed from: b, reason: collision with root package name */
    private int f24778b;

    /* renamed from: c, reason: collision with root package name */
    private int f24779c;
    private String cw;

    /* renamed from: e, reason: collision with root package name */
    private com.bytedance.msdk.core.cw.xt f24780e;

    /* renamed from: g, reason: collision with root package name */
    private String f24782g;
    private String gx;

    /* renamed from: i, reason: collision with root package name */
    private long f24784i;
    private int jy;

    /* renamed from: m, reason: collision with root package name */
    private String f24788m;

    /* renamed from: n, reason: collision with root package name */
    private int f24789n;
    private int nd;
    private int oq;

    /* renamed from: p, reason: collision with root package name */
    private int f24790p;
    private String qv;

    /* renamed from: r, reason: collision with root package name */
    private long f24792r;
    private com.bytedance.msdk.core.xt.xt rh;
    private boolean ry;
    private String tl;
    private long up;
    private String vl;

    /* renamed from: w, reason: collision with root package name */
    private long f24795w;
    private com.bytedance.msdk.core.m.xt zz;

    /* renamed from: j, reason: collision with root package name */
    private int f24785j = 259200000;
    private final List<Object> xt = new CopyOnWriteArrayList();
    private String ws = null;
    private int az = 0;
    private String av = "log-api.pangolin-sdk-toutiao.com/service/2/app_log/";
    private int mi = Integer.MAX_VALUE;
    private final List<av> kt = new CopyOnWriteArrayList();
    private Map<String, Boolean> tj = new HashMap();

    /* renamed from: f, reason: collision with root package name */
    private final AtomicBoolean f24781f = new AtomicBoolean(false);

    /* renamed from: v, reason: collision with root package name */
    private final AtomicBoolean f24794v = new AtomicBoolean(false);

    /* renamed from: x, reason: collision with root package name */
    private int f24796x = 0;
    private Map<String, String> ch = new ConcurrentHashMap();

    /* renamed from: s, reason: collision with root package name */
    private Map<String, List<String>> f24793s = new ConcurrentHashMap();

    /* renamed from: a, reason: collision with root package name */
    private double f24777a = 0.0d;

    /* renamed from: l, reason: collision with root package name */
    private boolean f24787l = false;

    /* renamed from: h, reason: collision with root package name */
    private Map<String, com.bytedance.msdk.core.oq.cw> f24783h = new ConcurrentHashMap();
    private int la = 0;
    private final Map<String, List<com.bytedance.msdk.core.oq.cw>> gq = new ConcurrentHashMap();
    private final Map<String, r> rn = new ConcurrentHashMap();
    private final Map<String, Integer> wq = new ConcurrentHashMap();
    private final Map<String, Integer> uf = new ConcurrentHashMap();
    private int ed = 0;
    private int ol = 0;
    private int hh = 0;

    /* renamed from: z, reason: collision with root package name */
    private int f24797z = 0;
    private int hl = 0;

    /* renamed from: q, reason: collision with root package name */
    private int f24791q = 0;
    private int qb = 0;
    private boolean ya = false;
    private boolean sm = false;
    private boolean xq = false;

    /* renamed from: k, reason: collision with root package name */
    private boolean f24786k = false;
    private int ff = 0;

    private void oq(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.wq.clear();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            this.wq.put(next, Integer.valueOf(jSONObject.optInt(next)));
        }
    }

    private void qv(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.uf.clear();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            this.uf.put(next, Integer.valueOf(jSONObject.optInt(next)));
        }
    }

    private boolean zz() {
        Boolean bool = this.tj.get("active_control");
        return bool == null || !bool.booleanValue();
    }

    public long a() {
        return com.bytedance.msdk.ae.j.j.j().cw();
    }

    public boolean ae() {
        return this.f24781f.get();
    }

    public boolean av() {
        if (!zz()) {
            return false;
        }
        Boolean bool = this.tj.get("type_interaction_control");
        return bool == null || !bool.booleanValue();
    }

    public boolean az() {
        if (!zz()) {
            return false;
        }
        Boolean bool = this.tj.get("type_banner_control");
        return bool == null || !bool.booleanValue();
    }

    public int b() {
        return this.f24785j;
    }

    public boolean c() {
        return this.f24778b == 1;
    }

    public boolean ch() {
        return Integer.valueOf(this.qv).intValue() > 1;
    }

    public boolean cw() {
        return this.sm;
    }

    public int e() {
        com.bytedance.msdk.core.xt.xt xtVar = this.rh;
        if (xtVar != null) {
            return xtVar.j();
        }
        return 0;
    }

    public boolean ed() {
        return this.nd == 1;
    }

    public boolean f() {
        if (!zz()) {
            return false;
        }
        Boolean bool = this.tj.get("type_native_control");
        return bool == null || !bool.booleanValue();
    }

    public boolean ff() {
        return this.f24797z == 1 && this.hl == 2;
    }

    public String g() {
        return this.f24782g;
    }

    public Map<String, String> gq() {
        return this.ch;
    }

    public com.bytedance.msdk.core.xt.xt gx() {
        return this.rh;
    }

    public boolean h() {
        if (this.mi == Integer.MAX_VALUE) {
            this.mi = 1;
        }
        return this.mi == 1;
    }

    public boolean hh() {
        return this.f24779c == 1;
    }

    public boolean hl() {
        return this.la == 1;
    }

    public boolean i() {
        if (!zz()) {
            return false;
        }
        Boolean bool = this.tj.get("type_interactionfull_control");
        return bool == null || !bool.booleanValue();
    }

    public int j() {
        return this.qb;
    }

    public String jy() {
        return this.ws;
    }

    public boolean k() {
        return this.f24797z == 1 && this.hl == 1;
    }

    public boolean kt() {
        if (!zz()) {
            return false;
        }
        Boolean bool = this.tj.get("type_reward_control");
        return bool == null || !bool.booleanValue();
    }

    public boolean l() {
        return (com.bytedance.msdk.ae.j.cw.j().cw() || com.bytedance.msdk.ae.j.xt.j().cw()) ? false : true;
    }

    public boolean la() {
        return this.f24796x == 1;
    }

    public boolean m() {
        return this.ff == 1;
    }

    public boolean mi() {
        if (!zz()) {
            return false;
        }
        Boolean bool = this.tj.get("type_feed_control");
        return bool == null || !bool.booleanValue();
    }

    public boolean nd() {
        return this.f24790p == 1;
    }

    public Map<String, com.bytedance.msdk.core.oq.cw> ol() {
        return this.f24783h;
    }

    public boolean p() {
        if (TextUtils.isEmpty(com.bytedance.msdk.core.j.qv().vl())) {
            return false;
        }
        com.bytedance.msdk.j.up.cw.xt("TTMediationSDK_SDK_Init", "--==----- isConfigLoadAndAdnInit: " + ae());
        if (com.bytedance.msdk.ae.j.cw.j().cw() || !ae()) {
            com.bytedance.msdk.j.up.cw.xt("TTMediationSDK_SDK_Init", "--==----- isConfigLoadAndAdnInit 2");
            return false;
        }
        com.bytedance.msdk.j.up.cw.xt("TTMediationSDK_SDK_Init", "--==----- isConfigLoadAndAdnInit 1");
        return true;
    }

    public Map<String, Integer> q() {
        return this.wq;
    }

    public Map<String, Integer> qb() {
        return this.uf;
    }

    public boolean r() {
        return this.xq;
    }

    public int rh() {
        return this.f24790p;
    }

    public Map<String, List<String>> rn() {
        return this.f24793s;
    }

    public boolean ry() {
        com.bytedance.msdk.j.up.cw.xt("TMe", "enable_bid_result_return = " + this.f24797z);
        com.bytedance.msdk.j.up.cw.xt("TMe", "enable_bid_result_return_for_ks = " + this.f24791q);
        return this.f24797z == 1 && this.f24791q == 1;
    }

    public int s() {
        return com.bytedance.msdk.ae.j.j.j().xt();
    }

    public int sm() {
        return this.hh;
    }

    public boolean tj() {
        if (!zz()) {
            return false;
        }
        Boolean bool = this.tj.get("type_full_control");
        return bool == null || !bool.booleanValue();
    }

    public String tl() {
        return this.tl;
    }

    public boolean uf() {
        return this.f24789n == 1;
    }

    public boolean up() {
        return this.f24786k;
    }

    public boolean v() {
        return this.oq > 0;
    }

    public boolean vl() {
        return this.jy == 1;
    }

    public boolean w() {
        if (!zz()) {
            return false;
        }
        Boolean bool = this.tj.get("type_splash_control");
        return bool == null || !bool.booleanValue();
    }

    public double wq() {
        return this.f24777a;
    }

    public boolean ws() {
        if (!zz()) {
            return false;
        }
        Boolean bool = this.tj.get("ad_event_control");
        return bool == null || !bool.booleanValue();
    }

    public boolean x() {
        try {
            return Integer.valueOf(this.qv).intValue() > 0;
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean xq() {
        com.bytedance.msdk.j.up.cw.xt("TMe", "enable_bid_result_return = " + this.f24797z);
        com.bytedance.msdk.j.up.cw.xt("TMe", "enable_bid_result_return_for_baidu = " + this.hl);
        return k() || ff();
    }

    public boolean xt() {
        return this.ya;
    }

    public int ya() {
        return this.ol;
    }

    public String z() {
        return this.gx;
    }

    private void ae(String str) {
        try {
            com.bytedance.msdk.core.admanager.reward.rewardagain.cw.j(new JSONArray(str));
        } catch (JSONException e6) {
            vl.j(e6);
        }
    }

    private String g(JSONObject jSONObject) {
        this.tj.clear();
        if (jSONObject == null) {
            return null;
        }
        try {
            if (jSONObject.optBoolean("ad_event_control")) {
                this.tj.put("ad_event_control", Boolean.TRUE);
            }
            if (jSONObject.optBoolean("type_banner_control")) {
                this.tj.put("type_banner_control", Boolean.TRUE);
            }
            if (jSONObject.optBoolean("type_interaction_control")) {
                this.tj.put("type_interaction_control", Boolean.TRUE);
            }
            if (jSONObject.optBoolean("type_interactionfull_control")) {
                this.tj.put("type_interactionfull_control", Boolean.TRUE);
            }
            if (jSONObject.optBoolean("type_splash_control")) {
                this.tj.put("type_splash_control", Boolean.TRUE);
            }
            if (jSONObject.optBoolean("type_feed_control")) {
                this.tj.put("type_feed_control", Boolean.TRUE);
            }
            if (jSONObject.optBoolean("type_reward_control")) {
                this.tj.put("type_reward_control", Boolean.TRUE);
            }
            if (jSONObject.optBoolean("type_full_control")) {
                this.tj.put("type_full_control", Boolean.TRUE);
            }
            if (jSONObject.optBoolean("type_native_control")) {
                this.tj.put("type_native_control", Boolean.TRUE);
            }
            return jSONObject.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kc() {
        com.bytedance.msdk.core.qv.j.j().up();
        if (!p()) {
            return;
        }
        Iterator<av> it = this.kt.iterator();
        while (it.hasNext()) {
            it.next().j();
        }
        this.kt.clear();
    }

    private String m(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        this.jy = jSONObject.optInt("fetch_ad_type", 0);
        return jSONObject.toString();
    }

    private String r(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.length() != 0) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    JSONArray jSONArray = jSONObject.getJSONArray(next);
                    if (jSONArray.length() > 0) {
                        ArrayList arrayList = new ArrayList();
                        for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                            arrayList.add(com.bytedance.msdk.core.oq.cw.j(next, jSONArray.optJSONObject(i6)));
                        }
                        this.gq.put(next, arrayList);
                    }
                } catch (Exception e6) {
                    vl.j(e6);
                }
            }
            return jSONObject.toString();
        }
        return "";
    }

    private void tl(String str) {
        try {
            JSONObject optJSONObject = new JSONObject(new JSONObject(str).optString("app_ab_params")).optJSONObject("mediation_settings");
            if (optJSONObject != null) {
                this.ed = optJSONObject.optInt("ad_request_optmize");
                this.ya = optJSONObject.optInt("applog_cypher") == 2;
                this.sm = optJSONObject.optInt("reward_cypher") == 2;
                this.xq = optJSONObject.optInt("config_cypher") == 2;
                this.f24786k = optJSONObject.optInt("exchange_cypher") == 2;
            }
        } catch (Throwable unused) {
        }
    }

    private String up(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            this.f24783h.put(next, com.bytedance.msdk.core.oq.cw.j(next, jSONObject.optJSONObject(next)));
        }
        return jSONObject.toString();
    }

    public boolean cw(String str) {
        return com.bytedance.msdk.ae.j.xt.j().xt(str);
    }

    public com.bytedance.msdk.core.oq.xt j(String str, int i6, int i7) {
        return com.bytedance.msdk.ae.j.cw.j().j(str, i6, i7);
    }

    public com.bytedance.msdk.core.cw.xt n() {
        if (c()) {
            return this.f24780e;
        }
        return null;
    }

    public void xt(boolean z5) {
        this.xq = z5;
    }

    private String cw(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        this.f24780e = new com.bytedance.msdk.core.cw.xt(jSONObject);
        return jSONObject.toString();
    }

    public long j(int i6, String str) {
        com.bytedance.msdk.core.oq.xt j6 = j(str, i6, 101);
        if (j6 != null) {
            return j6.gx();
        }
        return 3000L;
    }

    public com.bytedance.msdk.core.oq.j xt(String str) {
        return com.bytedance.msdk.ae.j.xt.j().j(str);
    }

    private String xt(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        this.rh = new com.bytedance.msdk.core.xt.xt(jSONObject);
        return jSONObject.toString();
    }

    public List<com.bytedance.msdk.core.oq.cw> m(String str) {
        return this.gq.get(str);
    }

    private void ae(JSONObject jSONObject) {
        this.ch.clear();
        this.f24796x = 0;
        if (jSONObject == null) {
            return;
        }
        this.f24796x = jSONObject.optInt("if_sample", 0);
        JSONObject optJSONObject = jSONObject.optJSONObject("call_stack_path");
        if (optJSONObject != null) {
            try {
                Iterator<String> keys = optJSONObject.keys();
                if (keys != null) {
                    while (keys.hasNext()) {
                        String next = keys.next();
                        String optString = optJSONObject.optString(next);
                        if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(optString)) {
                            this.ch.put(next, optString);
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    private String cw(JSONArray jSONArray) {
        JSONArray optJSONArray;
        JSONArray optJSONArray2;
        if (jSONArray != null) {
            ConcurrentHashMap<String, List<com.bytedance.msdk.core.tl.xt>> concurrentHashMap = new ConcurrentHashMap<>();
            for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i6);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString(MediationConstant.EXTRA_ADN_NAME);
                    if (!TextUtils.isEmpty(optString) && (optJSONArray = optJSONObject.optJSONArray("break_request_error_code")) != null && (optJSONArray2 = optJSONObject.optJSONArray("rit_list")) != null) {
                        ArrayList arrayList = new ArrayList();
                        for (int i7 = 0; i7 < optJSONArray.length(); i7++) {
                            arrayList.add(optJSONArray.optString(i7));
                        }
                        com.bytedance.msdk.core.tl.xt xtVar = new com.bytedance.msdk.core.tl.xt();
                        xtVar.j(optJSONObject.optLong("break_request_duration"));
                        xtVar.j(arrayList);
                        ArrayList arrayList2 = new ArrayList();
                        for (int i8 = 0; i8 < optJSONArray2.length(); i8++) {
                            arrayList2.add(optJSONArray2.optString(i8));
                        }
                        xtVar.xt(arrayList2);
                        List<com.bytedance.msdk.core.tl.xt> list = concurrentHashMap.get(optString);
                        if (list == null) {
                            list = new ArrayList<>();
                        }
                        list.add(xtVar);
                        concurrentHashMap.put(optString, list);
                    }
                }
            }
            ws.j().j(concurrentHashMap);
            return jSONArray.toString();
        }
        ws.j().j(null);
        return null;
    }

    public com.bytedance.msdk.core.oq.j j(String str) {
        return com.bytedance.msdk.ae.j.xt.j().j(str);
    }

    public boolean j(String str, String str2, int i6) {
        List<oq> ol;
        com.bytedance.msdk.core.oq.xt j6 = com.bytedance.msdk.ae.j.cw.j().j(str, i6, 101);
        if (j6 == null || (ol = j6.ol()) == null) {
            return false;
        }
        for (oq oqVar : ol) {
            if (oqVar != null && TextUtils.equals(oqVar.w(), str2)) {
                return oqVar.c();
            }
        }
        return false;
    }

    public boolean xt(String str, int i6) {
        return (com.bytedance.msdk.ae.j.xt.j().cw() || com.bytedance.msdk.ae.j.cw.j().cw() || com.bytedance.msdk.ae.j.cw.j().j(str, i6, 101) == null) ? false : true;
    }

    public String oq() {
        if (this.cw == null) {
            this.cw = com.bytedance.msdk.ae.j.j().xt("etag");
        }
        return this.cw;
    }

    public String qv() {
        return this.av;
    }

    private String xt(JSONArray jSONArray) {
        JSONArray optJSONArray;
        if (jSONArray != null) {
            ConcurrentHashMap<String, com.bytedance.msdk.core.tl.xt> concurrentHashMap = new ConcurrentHashMap<>();
            for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i6);
                if (optJSONObject != null && (optJSONArray = optJSONObject.optJSONArray("break_request_error_code")) != null) {
                    ArrayList arrayList = new ArrayList();
                    for (int i7 = 0; i7 < optJSONArray.length(); i7++) {
                        arrayList.add(optJSONArray.optString(i7));
                    }
                    com.bytedance.msdk.core.tl.xt xtVar = new com.bytedance.msdk.core.tl.xt();
                    xtVar.j(optJSONObject.optLong("break_request_duration"));
                    xtVar.j(arrayList);
                    concurrentHashMap.put(optJSONObject.optString(MediationConstant.EXTRA_ADN_NAME), xtVar);
                }
            }
            com.bytedance.msdk.core.tl.cw.j().j(concurrentHashMap);
            return jSONArray.toString();
        }
        com.bytedance.msdk.core.tl.cw.j().j(null);
        return null;
    }

    public r up(String str) {
        return this.rn.get(str);
    }

    private void tl(JSONObject jSONObject) {
        this.f24793s.clear();
        if (jSONObject != null) {
            try {
                Iterator<String> keys = jSONObject.keys();
                if (keys != null) {
                    while (keys.hasNext()) {
                        String next = keys.next();
                        JSONArray optJSONArray = jSONObject.optJSONArray(next);
                        ArrayList arrayList = new ArrayList();
                        if (optJSONArray != null) {
                            for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                                if (optJSONArray.get(i6) != null) {
                                    arrayList.add(optJSONArray.get(i6).toString());
                                }
                            }
                        }
                        if (!TextUtils.isEmpty(next) && !arrayList.isEmpty()) {
                            this.f24793s.put(next, arrayList);
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public boolean j(String str, int i6) {
        com.bytedance.msdk.core.oq.xt j6;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return com.bytedance.msdk.ae.j.cw.j().cw() || (j6 = com.bytedance.msdk.ae.j.cw.j().j(str, i6, 101)) == null || j6.wq() == i6;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [com.bytedance.msdk.core.m.xt, org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r2v5 */
    @Override // com.bytedance.msdk.core.ws.j
    public void j(JSONObject jSONObject, final boolean z5) {
        ?? r22;
        final String optString;
        final JSONObject optJSONObject;
        final JSONArray optJSONArray;
        final String xt;
        final String cw;
        final String m6;
        final String g6;
        final JSONObject optJSONObject2;
        final JSONObject optJSONObject3;
        final JSONObject optJSONObject4;
        final JSONObject optJSONObject5;
        final String up;
        final String r5;
        if (jSONObject == null) {
            return;
        }
        boolean z6 = false;
        try {
            String optString2 = jSONObject.optString("app_abtest");
            this.ws = optString2;
            tl(optString2);
            this.qb = jSONObject.optInt("is_trusteeship_monetize");
            this.ff = jSONObject.optInt("share_cache_enable");
            this.cw = jSONObject.optString("etag");
            this.f24792r = jSONObject.optLong("max_age");
            this.up = System.currentTimeMillis() + this.f24792r;
            this.f24788m = jSONObject.optString("ab_version");
            this.ae = jSONObject.optString("ab_params");
            this.tl = jSONObject.optString("country");
            this.f24782g = jSONObject.optString("transparent_params");
            this.f24790p = jSONObject.optInt("if_test");
            this.oq = jSONObject.optInt("if_get_detail_return");
            this.qv = jSONObject.optString("ecpm_precision_level");
            this.vl = jSONObject.optString("fetch_primerit_level");
            optString = jSONObject.optString("url");
            this.az = jSONObject.optInt("innerLog", 0);
            this.av = jSONObject.optString("app_log_url", "log-api.pangolin-sdk-toutiao.com/service/2/app_log/");
            this.f24784i = jSONObject.optLong("break_request_times", 0L);
            this.f24795w = jSONObject.optLong("break_request_hold_time", 10000L);
            this.f24779c = jSONObject.optInt("ex_info", 0);
            this.gx = jSONObject.optString("ex_");
            this.la = jSONObject.optInt("if_enable_label", 0);
            this.f24785j = jSONObject.optInt("ecpm_ttl", 259200000);
            int optInt = jSONObject.optInt("support_tnc", Integer.MAX_VALUE);
            this.mi = optInt;
            if (optInt != 0 && optInt != 1) {
                this.mi = 1;
            }
            this.f24777a = jSONObject.optDouble("custom_adn_sample_ratio", 0.0d);
            int optInt2 = jSONObject.optInt("enable_label_return", 0);
            this.f24789n = optInt2;
            if (optInt2 != 0 && optInt2 != 1) {
                this.f24789n = 0;
            }
            this.nd = jSONObject.optInt("dynamic_policy_enable", 0);
            com.bytedance.msdk.j.up.cw.xt("DynamicPolicy", "mDynamicPolicyEnable=" + this.nd);
            int i6 = this.nd;
            if (i6 != 0 && i6 != 1) {
                this.nd = 0;
            }
            int i7 = this.ol;
            int i8 = this.hh;
            JSONObject optJSONObject6 = jSONObject.optJSONObject("p_c");
            if (optJSONObject6 != null) {
                this.ol = optJSONObject6.optInt("l_p_a", 0);
                this.hh = optJSONObject6.optInt("l_p_r", 0);
            } else {
                this.ol = 0;
                this.hh = 0;
            }
            if (i7 != this.ol || i8 != this.hh) {
                up.j();
            }
            com.bytedance.msdk.core.ae.j.j().j(this.f24784i, this.f24795w);
            this.f24797z = jSONObject.optInt("enable_bid_result_return", 0);
            this.hl = jSONObject.optInt("enable_bid_result_return_for_baidu", 0);
            this.f24791q = jSONObject.optInt("enable_bid_result_return_for_ks", 0);
            optJSONObject = jSONObject.optJSONObject("supervisor_feature");
            if (optJSONObject != null) {
                com.bytedance.msdk.tl.av.j(true);
                com.bytedance.msdk.tl.av.j(optJSONObject);
            } else {
                com.bytedance.msdk.tl.av.j(false);
            }
            optJSONArray = jSONObject.optJSONArray("ra_info");
            if (optJSONArray != null) {
                com.bytedance.msdk.core.admanager.reward.rewardagain.cw.j(optJSONArray);
            }
            com.bytedance.msdk.ae.j.j.j().j(jSONObject.optJSONObject("app_common_config"));
            com.bytedance.msdk.ae.j.xt.j().j(jSONObject.optJSONObject("adn_init_conf"));
            xt = xt(jSONObject.optJSONArray("adn_control_conf"));
            cw = cw(jSONObject.optJSONArray("rit_adn_control_conf"));
            m6 = m(jSONObject.optJSONObject("poor_network_config"));
            com.bytedance.msdk.ae.j.cw.j().j(jSONObject.optJSONArray("rit_conf"));
            g6 = g(jSONObject.optJSONObject("module_disable_control"));
            optJSONObject2 = jSONObject.optJSONObject("call_stack_conf");
            ae(optJSONObject2);
            optJSONObject3 = jSONObject.optJSONObject("custom_adn_feature");
            tl(optJSONObject3);
            optJSONObject4 = jSONObject.optJSONObject("timeout_req");
            oq(optJSONObject4);
            optJSONObject5 = jSONObject.optJSONObject("is_callback");
            qv(optJSONObject5);
            up = up(jSONObject.optJSONObject("label_outputs"));
            r5 = r(jSONObject.optJSONObject("label_group_infos"));
        } catch (Throwable th) {
            th = th;
            r22 = 0;
        }
        try {
            final String j6 = j(jSONObject.optJSONArray("dynamic_rules"));
            final String xt2 = xt(jSONObject.optJSONObject("dynamic_policy"));
            z6 = false;
            this.f24778b = jSONObject.optInt("behavior_policy_enable", 0);
            com.bytedance.msdk.j.up.cw.xt("BehaviorPolicy", "mBehaviorPolicyConfigEnable=" + this.f24778b);
            final String cw2 = cw(jSONObject.optJSONObject("behavior_policy"));
            JSONObject optJSONObject7 = jSONObject.optJSONObject("inter_full_refresh_cfg");
            String jSONObject2 = optJSONObject7 != null ? optJSONObject7.toString() : null;
            com.bytedance.msdk.core.admanager.j.j(jSONObject2);
            com.bytedance.msdk.cw.tl.r.j(jSONObject.optJSONObject("csj_code_mapping_conf"));
            final String str = jSONObject2;
            m.r(new Runnable() { // from class: com.bytedance.msdk.core.ws.cw.1
                @Override // java.lang.Runnable
                public void run() {
                    String str2;
                    String j7;
                    String j8;
                    String j9;
                    String j10;
                    String j11;
                    String j12;
                    String j13;
                    String j14;
                    String j15;
                    l j16 = com.bytedance.msdk.ae.j.j();
                    j16.j("is_trusteeship_monetize", cw.this.qb);
                    j16.j("share_cache_enable", cw.this.ff);
                    j16.j("etag", cw.this.cw);
                    j16.j("max_age", cw.this.f24792r);
                    j16.j("max_expire_time", cw.this.up);
                    j16.j("ab_version", cw.this.f24788m);
                    j16.j("ab_params", cw.this.ae);
                    j16.j("country", cw.this.tl);
                    j16.j("transparent_params", cw.this.f24782g);
                    j16.j("if_test", cw.this.f24790p);
                    j16.j("network_permission", cw.this.oq);
                    j16.j("ecpm_precision_level", cw.this.qv);
                    j16.j("fetch_primerit_level", cw.this.vl);
                    j16.j("app_abtest", cw.this.ws);
                    j16.j("module_control", g6);
                    j16.j("tt_app_log_url", cw.this.av);
                    j16.j("break_request_times", cw.this.f24784i);
                    j16.j("break_request_hold_time", cw.this.f24795w);
                    j16.j("ex_info", cw.this.f24779c);
                    j16.j("if_enable_label", cw.this.la);
                    j16.j("cpm_expire_time", cw.this.f24785j);
                    JSONObject jSONObject3 = optJSONObject;
                    if (jSONObject3 == null) {
                        str2 = "";
                    } else {
                        str2 = jSONObject3.toString();
                    }
                    j16.j("key_supervisor_feature", str2);
                    j16.j("custom_adn_sample_ratio", (float) cw.this.f24777a);
                    j16.j("enable_label_return", cw.this.f24789n);
                    j16.j("dynamic_policy_enable", cw.this.nd);
                    j16.j("behavior_policy_enable", cw.this.f24778b);
                    j16.j("limit_p_a", cw.this.ol);
                    j16.j("limit_p_r", cw.this.hh);
                    j16.j("enable_bid_result_return", cw.this.f24797z);
                    j16.j("enable_bid_result_return_for_baidu", cw.this.hl);
                    j16.j("enable_bid_result_return_for_ks", cw.this.f24791q);
                    JSONObject jSONObject4 = optJSONObject2;
                    if (jSONObject4 != null) {
                        j16.j("call_stack", jSONObject4.toString());
                    } else {
                        j16.j("call_stack", "");
                    }
                    JSONObject jSONObject5 = optJSONObject3;
                    if (jSONObject5 != null) {
                        j16.j("custom_adn_feature", jSONObject5.toString());
                    } else {
                        j16.j("custom_adn_feature", "");
                    }
                    JSONObject jSONObject6 = optJSONObject4;
                    if (jSONObject6 != null) {
                        j16.j("timeout_req", jSONObject6.toString());
                    } else {
                        j16.j("timeout_req", "");
                    }
                    JSONObject jSONObject7 = optJSONObject5;
                    if (jSONObject7 != null) {
                        j16.j("is_callback", jSONObject7.toString());
                    } else {
                        j16.j("is_callback", "");
                    }
                    String str3 = optString;
                    if (str3 != null && !TextUtils.isEmpty(str3)) {
                        String j17 = com.bytedance.msdk.tl.j.j(optString, com.bytedance.msdk.tl.xt.j());
                        if (j17 != null) {
                            j16.j("server_dist_host", j17);
                        }
                    } else {
                        j16.m("server_dist_host");
                    }
                    String str4 = xt;
                    if (str4 != null && (j15 = com.bytedance.msdk.tl.j.j(str4, com.bytedance.msdk.tl.xt.j())) != null) {
                        j16.j("adn_control_conf", j15);
                    }
                    if (!TextUtils.isEmpty(cw)) {
                        j16.j("rit_adn_control_conf", cw);
                    } else {
                        j16.m("rit_adn_control_conf");
                    }
                    String str5 = m6;
                    if (str5 != null) {
                        j16.j("network_conf", str5);
                    }
                    if (!TextUtils.isEmpty(up) && (j14 = com.bytedance.msdk.tl.j.j(up, com.bytedance.msdk.tl.xt.j())) != null) {
                        j16.j("label_outputs", j14);
                    }
                    if (!TextUtils.isEmpty(r5) && (j13 = com.bytedance.msdk.tl.j.j(r5, com.bytedance.msdk.tl.xt.j())) != null) {
                        j16.j("label_group_infos", j13);
                    }
                    if (!TextUtils.isEmpty(j6) && (j12 = com.bytedance.msdk.tl.j.j(j6, com.bytedance.msdk.tl.xt.j())) != null) {
                        j16.j("dynamic_rules", j12);
                    }
                    if (!TextUtils.isEmpty(cw.this.gx) && (j11 = com.bytedance.msdk.tl.j.j(cw.this.gx, com.bytedance.msdk.tl.xt.j())) != null) {
                        j16.j("ex_", j11);
                    }
                    JSONArray jSONArray = optJSONArray;
                    if (jSONArray != null) {
                        String jSONArray2 = jSONArray.toString();
                        if (!TextUtils.isEmpty(jSONArray2) && (j10 = com.bytedance.msdk.tl.j.j(jSONArray2, com.bytedance.msdk.tl.xt.j())) != null) {
                            j16.j("reward_again_styles", j10);
                        }
                    }
                    if (!TextUtils.isEmpty(xt2) && (j9 = com.bytedance.msdk.tl.j.j(xt2, com.bytedance.msdk.tl.xt.j())) != null) {
                        j16.j("dynamic_policy", j9);
                    }
                    if (!TextUtils.isEmpty(cw2) && (j8 = com.bytedance.msdk.tl.j.j(cw2, com.bytedance.msdk.tl.xt.j())) != null) {
                        j16.j("behavior_policy", j8);
                    }
                    if (!TextUtils.isEmpty(str) && (j7 = com.bytedance.msdk.tl.j.j(str, com.bytedance.msdk.tl.xt.j())) != null) {
                        j16.j("inter_full_refresh_cfg", j7);
                    }
                    j16.j("is_config_from_assert", z5);
                    j16.j("has_config_in_sp", true);
                }
            });
            j(false, (JSONObject) null, (com.bytedance.msdk.core.m.xt) null);
        } catch (Throwable th2) {
            th = th2;
            r22 = 0;
            z6 = false;
            try {
                vl.j(th);
            } finally {
                j(z6, (JSONObject) r22, (com.bytedance.msdk.core.m.xt) r22);
            }
        }
    }

    public void r(String str) {
        try {
            l j6 = com.bytedance.msdk.ae.j.j();
            if ("2".equals(str)) {
                this.tj.put("active_control", Boolean.TRUE);
                j6.j("all_active_control", true);
            } else {
                this.tj.put("active_control", Boolean.FALSE);
                j6.j("all_active_control", false);
            }
        } catch (Exception e6) {
            vl.j(e6);
        }
    }

    public void xt(int i6) {
        this.mi = i6;
    }

    public void cw(int i6) {
        this.f24790p = i6;
    }

    private String j(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        for (int i6 = 0; i6 < jSONArray.length(); i6++) {
            try {
                r.j(jSONArray.optJSONObject(i6), this.rn);
            } catch (Exception e6) {
                com.bytedance.msdk.j.up.cw.cw(MediationConstant.TAG, "maybe some rit parse dynamic rules fail .....");
                vl.j(e6);
            }
        }
        return jSONArray.toString();
    }

    public void j(com.bytedance.msdk.core.m.xt xtVar) {
        this.zz = xtVar;
    }

    public void j(final boolean z5, final JSONObject jSONObject, com.bytedance.msdk.core.m.xt xtVar) {
        if (xtVar != null) {
            this.zz = xtVar;
        }
        final boolean l6 = l();
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        com.bytedance.msdk.m.xt.j.xt().j(com.bytedance.msdk.core.xt.getContext(), z5, l6, new com.bytedance.msdk.core.m.xt() { // from class: com.bytedance.msdk.core.ws.cw.2
            @Override // com.bytedance.msdk.core.m.xt
            public void j() {
                com.bytedance.msdk.j.up.cw.r("TTMediationSDK_SDK_Init", "MSDK init finish.........hasConfig:" + l6);
                if (l6) {
                    cw.this.f24781f.set(true);
                    cw.this.kc();
                    if (cw.this.zz != null) {
                        cw.this.zz.j();
                    }
                    m.r(new Runnable() { // from class: com.bytedance.msdk.core.ws.cw.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!cw.this.f24794v.get()) {
                                cw.this.f24794v.set(true);
                                int j6 = com.bytedance.msdk.m.xt.j.j();
                                long elapsedRealtime2 = SystemClock.elapsedRealtime() - com.bytedance.msdk.m.cw.j();
                                long elapsedRealtime3 = SystemClock.elapsedRealtime();
                                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                long j7 = elapsedRealtime3 - elapsedRealtime;
                                try {
                                    JSONObject jSONObject2 = jSONObject;
                                    if (jSONObject2 != null) {
                                        jSONObject2.put("adn_time", j7);
                                    }
                                } catch (Throwable unused) {
                                }
                                HashMap hashMap = new HashMap();
                                hashMap.put("csj_init_time", Long.valueOf(com.bytedance.sdk.gromore.init.up.f27349r - com.bytedance.sdk.gromore.init.up.f27347j));
                                if (cw.this.ry) {
                                    hashMap.put("is_import_cfg", Boolean.valueOf(cw.this.ry));
                                }
                                if (com.bytedance.msdk.m.r.j()) {
                                    com.bytedance.msdk.j.up.cw.j("TMe", "-----==---- 正常上报sdk_init_end");
                                    AnonymousClass2 anonymousClass22 = AnonymousClass2.this;
                                    com.bytedance.msdk.m.r.j(elapsedRealtime2, j6, z5 ? 1 : 0, -1L, jSONObject, hashMap);
                                } else {
                                    com.bytedance.msdk.j.up.cw.j("TMe", "-----==---- 延时上报sdk_init_end");
                                    AnonymousClass2 anonymousClass23 = AnonymousClass2.this;
                                    com.bytedance.msdk.m.r.j(elapsedRealtime2, j6, z5 ? 1 : 0, jSONObject, hashMap);
                                }
                                com.bytedance.msdk.core.xt.j.j();
                                com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, "sdk init end, duration: " + elapsedRealtime2 + ", initAdnCount: " + j6 + ", isFromLocalConfig: " + z5);
                            }
                            xt.j(com.bytedance.msdk.core.xt.xt()).j(new com.bytedance.msdk.api.r.up() { // from class: com.bytedance.msdk.core.ws.cw.2.1.1
                                @Override // com.bytedance.msdk.api.r.up
                                public void j(List<String> list) {
                                    com.bytedance.msdk.j.up.cw.j("TMe", "初始化更新pangle配置成功");
                                }
                            });
                        }
                    });
                }
            }
        });
    }

    @Override // com.bytedance.msdk.core.ws.j
    public void j(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.optInt("state_code") != 30004) {
            return;
        }
        l j6 = com.bytedance.msdk.ae.j.j();
        this.f24792r = jSONObject.optLong("max_age");
        long currentTimeMillis = System.currentTimeMillis();
        long j7 = this.f24792r;
        this.up = currentTimeMillis + j7;
        j6.j("max_age", j7);
        j6.j("max_expire_time", this.up);
    }

    @Override // com.bytedance.msdk.core.ws.j
    public void j(boolean z5) {
        l j6;
        JSONObject ed;
        JSONObject jSONObject;
        int optInt;
        try {
            j6 = com.bytedance.msdk.ae.j.j();
        } catch (Throwable unused) {
            if (!z5) {
                j(true, (JSONObject) null, (com.bytedance.msdk.core.m.xt) null);
            }
            if (!com.bytedance.msdk.ae.j.cw.j().cw() || x.j(com.bytedance.msdk.core.xt.getContext())) {
                return;
            }
        }
        if (!j6.up("has_config_in_sp") && (ed = com.bytedance.msdk.core.j.qv().ed()) != null) {
            this.ry = true;
            int optInt2 = ed.optInt("cypher", -1);
            if (optInt2 == 2) {
                String j7 = rn.j(ed.optString(CrashHianalyticsData.MESSAGE));
                if (!TextUtils.isEmpty(j7)) {
                    try {
                        jSONObject = new JSONObject(j7);
                        ed = jSONObject;
                    } catch (Throwable th) {
                        com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, ">>>>> setting data error: " + th.toString());
                    }
                }
                optInt = ed.optInt("state_code");
                String optString = ed.optString(CrashHianalyticsData.MESSAGE);
                if (optInt != 20000 && !TextUtils.isEmpty(ed.toString())) {
                    ed.optJSONObject("adn_init_conf");
                    if (ed.optString("app_id").equals(com.bytedance.msdk.core.j.qv().vl())) {
                        com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "本地配置解析成功");
                        j(ed, true);
                        com.bytedance.msdk.core.qv.j.j().m();
                        com.bytedance.msdk.core.j.qv().j((JSONObject) null);
                        if (!z5) {
                            j(true, (JSONObject) null, (com.bytedance.msdk.core.m.xt) null);
                        }
                        if (!com.bytedance.msdk.ae.j.cw.j().cw() || x.j(com.bytedance.msdk.core.xt.getContext())) {
                            return;
                        }
                        com.bytedance.msdk.core.qv.j.j().j(-2, "本地没有配置/当前网络不可用");
                    }
                    com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "本地配置appid或appkey非法");
                } else {
                    com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, " 解密错误或者解析错误：stateCode=" + optInt + "，msg=" + optString);
                }
            } else {
                if (optInt2 == 1) {
                    String xt = com.bytedance.msdk.tl.j.xt(ed.optString(CrashHianalyticsData.MESSAGE), com.bytedance.msdk.tl.xt.j());
                    if (!TextUtils.isEmpty(xt)) {
                        try {
                            com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, "setting data : " + xt.toString());
                            jSONObject = new JSONObject(xt);
                            ed = jSONObject;
                        } catch (Throwable th2) {
                            com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, "setting data error: ", th2);
                        }
                    }
                } else if (optInt2 == 0) {
                    ed = new JSONObject(ed.optString(CrashHianalyticsData.MESSAGE));
                }
                optInt = ed.optInt("state_code");
                String optString2 = ed.optString(CrashHianalyticsData.MESSAGE);
                if (optInt != 20000) {
                }
                com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, " 解密错误或者解析错误：stateCode=" + optInt + "，msg=" + optString2);
            }
        }
        com.bytedance.msdk.core.j.qv().j((JSONObject) null);
        this.qb = j6.cw("is_trusteeship_monetize");
        this.ff = j6.cw("share_cache_enable");
        this.cw = j6.xt("etag");
        this.f24792r = j6.r("max_age");
        this.up = j6.r("max_expire_time");
        this.f24788m = j6.xt("ab_version");
        this.ae = j6.xt("ab_params");
        this.tl = j6.xt("country");
        this.f24782g = j6.xt("transparent_params");
        this.f24790p = j6.cw("if_test");
        this.oq = j6.cw("network_permission");
        this.qv = j6.xt("ecpm_precision_level");
        this.vl = j6.xt("fetch_primerit_level");
        this.av = j6.xt("tt_app_log_url", "log-api.pangolin-sdk-toutiao.com/service/2/app_log/");
        this.f24784i = j6.xt("break_request_times", 0L);
        this.f24795w = j6.xt("break_request_hold_time", 10000L);
        this.f24779c = j6.xt("ex_info", 0);
        this.la = j6.xt("if_enable_label", 0);
        this.f24785j = j6.xt("cpm_expire_time", 259200000);
        this.f24777a = j6.xt("custom_adn_sample_ratio", 0.0f);
        this.f24789n = j6.xt("enable_label_return", 0);
        this.nd = j6.xt("dynamic_policy_enable", 0);
        this.f24778b = j6.xt("behavior_policy_enable", 0);
        this.ol = j6.xt("limit_p_a", 0);
        this.hh = j6.xt("limit_p_r", 0);
        this.f24797z = j6.xt("enable_bid_result_return", 0);
        this.hl = j6.xt("enable_bid_result_return_for_baidu", 0);
        this.f24791q = j6.xt("enable_bid_result_return_for_ks", 0);
        com.bytedance.msdk.core.ae.j.j().j(this.f24784i, this.f24795w);
        String xt2 = j6.xt("network_conf");
        if (!TextUtils.isEmpty(xt2)) {
            m(new JSONObject(xt2));
        }
        String xt3 = j6.xt("reward_again_styles");
        if (!TextUtils.isEmpty(xt3)) {
            ae(com.bytedance.msdk.tl.j.xt(xt3, com.bytedance.msdk.tl.xt.j()));
        }
        String xt4 = j6.xt("adn_control_conf");
        if (!TextUtils.isEmpty(xt4)) {
            if (!xt4.startsWith("[") && !xt4.startsWith("{")) {
                xt4 = com.bytedance.msdk.tl.j.xt(xt4, com.bytedance.msdk.tl.xt.j());
            }
            xt(new JSONArray(xt4));
        }
        String xt5 = j6.xt("rit_adn_control_conf");
        if (!TextUtils.isEmpty(xt5)) {
            cw(new JSONArray(xt5));
        }
        String xt6 = j6.xt("module_control");
        if (!TextUtils.isEmpty(xt6)) {
            g(new JSONObject(xt6));
        }
        boolean up = j6.up("all_active_control");
        if (up) {
            this.tj.put("active_control", Boolean.valueOf(up));
        }
        String xt7 = j6.xt("call_stack");
        if (!TextUtils.isEmpty(xt7)) {
            ae(new JSONObject(xt7));
        }
        String xt8 = j6.xt("custom_adn_feature");
        if (!TextUtils.isEmpty(xt8)) {
            tl(new JSONObject(xt8));
        }
        String xt9 = j6.xt("timeout_req");
        if (!TextUtils.isEmpty(xt9)) {
            oq(new JSONObject(xt9));
        }
        String xt10 = j6.xt("is_callback");
        if (!TextUtils.isEmpty(xt10)) {
            qv(new JSONObject(xt10));
        }
        String xt11 = j6.xt("key_supervisor_feature");
        if (!TextUtils.isEmpty(xt11)) {
            com.bytedance.msdk.tl.av.j(true);
            com.bytedance.msdk.tl.av.j(new JSONObject(xt11));
        } else {
            com.bytedance.msdk.tl.av.j(false);
        }
        String xt12 = j6.xt("label_outputs");
        if (!TextUtils.isEmpty(xt12)) {
            if (!xt12.startsWith("[") && !xt12.startsWith("{")) {
                xt12 = com.bytedance.msdk.tl.j.xt(xt12, com.bytedance.msdk.tl.xt.j());
            }
            if (!TextUtils.isEmpty(xt12)) {
                up(new JSONObject(xt12));
            }
        }
        String xt13 = j6.xt("label_group_infos");
        if (!TextUtils.isEmpty(xt13)) {
            if (!xt13.startsWith("[") && !xt13.startsWith("{")) {
                xt13 = com.bytedance.msdk.tl.j.xt(xt13, com.bytedance.msdk.tl.xt.j());
            }
            if (!TextUtils.isEmpty(xt13)) {
                r(new JSONObject(xt13));
            }
        }
        String xt14 = j6.xt("dynamic_rules");
        if (!TextUtils.isEmpty(xt14)) {
            if (!xt14.startsWith("[") && !xt14.startsWith("{")) {
                xt14 = com.bytedance.msdk.tl.j.xt(xt14, com.bytedance.msdk.tl.xt.j());
            }
            if (!TextUtils.isEmpty(xt14)) {
                j(new JSONArray(xt14));
            }
        }
        String xt15 = j6.xt("dynamic_policy");
        if (!TextUtils.isEmpty(xt15)) {
            if (!xt15.startsWith("[") && !xt15.startsWith("{")) {
                xt15 = com.bytedance.msdk.tl.j.xt(xt15, com.bytedance.msdk.tl.xt.j());
            }
            if (!TextUtils.isEmpty(xt15)) {
                xt(new JSONObject(xt15));
            }
        }
        String xt16 = j6.xt("behavior_policy");
        if (!TextUtils.isEmpty(xt16)) {
            if (!xt16.startsWith("[") && !xt16.startsWith("{")) {
                xt16 = com.bytedance.msdk.tl.j.xt(xt16, com.bytedance.msdk.tl.xt.j());
            }
            if (!TextUtils.isEmpty(xt16)) {
                cw(new JSONObject(xt16));
            }
        }
        String xt17 = j6.xt("inter_full_refresh_cfg");
        if (!TextUtils.isEmpty(xt17)) {
            String xt18 = com.bytedance.msdk.tl.j.xt(xt17, com.bytedance.msdk.tl.xt.j());
            if (!TextUtils.isEmpty(xt18)) {
                com.bytedance.msdk.core.admanager.j.j(xt18);
            }
        }
        String xt19 = j6.xt("ex_");
        if (!TextUtils.isEmpty(xt19) && !xt19.startsWith("[") && !xt19.startsWith("{")) {
            this.gx = com.bytedance.msdk.tl.j.xt(xt19, com.bytedance.msdk.tl.xt.j());
        }
        if (!TextUtils.isEmpty(j6.xt("app_abtest"))) {
            String xt20 = j6.xt("app_abtest");
            this.ws = xt20;
            tl(xt20);
        }
        if (!z5) {
            j(true, (JSONObject) null, (com.bytedance.msdk.core.m.xt) null);
        }
        if (!com.bytedance.msdk.ae.j.cw.j().cw() || x.j(com.bytedance.msdk.core.xt.getContext())) {
            return;
        }
        com.bytedance.msdk.core.qv.j.j().j(-2, "本地没有配置/当前网络不可用");
    }

    public boolean j(int i6) {
        if (!zz()) {
            return false;
        }
        if (i6 == 1) {
            return az();
        }
        if (i6 == 2) {
            return av();
        }
        if (i6 == 3) {
            return w();
        }
        if (i6 == 5) {
            return mi() && f();
        }
        if (i6 == 10) {
            return i();
        }
        if (i6 == 7) {
            return kt();
        }
        if (i6 != 8) {
            return true;
        }
        return tj();
    }

    public List<String> j(List<String> list) {
        if (list != null && list.size() > 0) {
            if (com.bytedance.msdk.ae.j.cw.j().cw()) {
                return list;
            }
            ArrayList arrayList = new ArrayList();
            for (String str : list) {
                if (com.bytedance.msdk.ae.j.cw.j().j(str, 0, 101) == null) {
                    arrayList.add(str);
                }
            }
            if (arrayList.size() > 0) {
                return arrayList;
            }
        }
        return null;
    }

    public void j(av avVar) {
        if (avVar == null) {
            return;
        }
        if (p()) {
            avVar.j();
            return;
        }
        synchronized (this.kt) {
            try {
                if (!this.kt.contains(avVar)) {
                    this.kt.add(avVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean j(long j6) {
        return j6 < ((long) this.f24785j);
    }
}
