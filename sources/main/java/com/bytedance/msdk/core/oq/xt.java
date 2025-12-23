package com.bytedance.msdk.core.oq;

import android.text.TextUtils;
import com.bytedance.msdk.tl.qv;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class xt {

    /* renamed from: a, reason: collision with root package name */
    private boolean f24656a;
    private long ae;
    private int av;
    private int az;

    /* renamed from: b, reason: collision with root package name */
    private int f24657b;

    /* renamed from: c, reason: collision with root package name */
    private com.bytedance.msdk.core.tl.g f24658c;
    private int ch;
    private int cw;
    private int ed;

    /* renamed from: f, reason: collision with root package name */
    private int f24660f;
    private int gq;
    private com.bytedance.msdk.core.tl.ae gx;

    /* renamed from: h, reason: collision with root package name */
    private double f24662h;
    private double hh;
    private long hl;

    /* renamed from: i, reason: collision with root package name */
    private long f24663i;

    /* renamed from: j, reason: collision with root package name */
    private String f24664j;
    private String kt;

    /* renamed from: l, reason: collision with root package name */
    private boolean f24665l;
    private int la;

    /* renamed from: m, reason: collision with root package name */
    private long f24666m;
    private String mi;

    /* renamed from: n, reason: collision with root package name */
    private int f24667n;
    private JSONObject nd;

    /* renamed from: p, reason: collision with root package name */
    private int f24668p;

    /* renamed from: r, reason: collision with root package name */
    private long f24670r;
    private int rh;
    private int rn;

    /* renamed from: s, reason: collision with root package name */
    private long f24671s;
    private int tj;
    private String tl;
    private int uf;
    private long up;

    /* renamed from: v, reason: collision with root package name */
    private int f24672v;

    /* renamed from: w, reason: collision with root package name */
    private int f24673w;
    private int wq;

    /* renamed from: x, reason: collision with root package name */
    private String f24674x;
    private int xt;

    /* renamed from: z, reason: collision with root package name */
    private double f24675z;

    /* renamed from: g, reason: collision with root package name */
    private List<oq> f24661g = new CopyOnWriteArrayList();
    private Map<Integer, List<oq>> oq = new HashMap();
    private Map<Integer, List<oq>> qv = new HashMap();
    private List<Integer> vl = new ArrayList();
    private double jy = -1.0d;
    private double ws = -1.0d;
    private int ol = 1000;

    /* renamed from: e, reason: collision with root package name */
    private int f24659e = 0;

    /* renamed from: q, reason: collision with root package name */
    private int f24669q = 2;
    private int qb = 0;
    private Map<String, Object> ya = new HashMap();

    public int ae() {
        int min = Math.min(this.ol, 1000);
        if (min <= 0) {
            return 1000;
        }
        return min;
    }

    /* renamed from: av, reason: merged with bridge method [inline-methods] */
    public xt clone() {
        xt xtVar = new xt();
        xtVar.f24664j = this.f24664j;
        xtVar.xt = this.xt;
        xtVar.cw = this.cw;
        xtVar.f24670r = this.f24670r;
        xtVar.up = this.up;
        xtVar.f24666m = this.f24666m;
        xtVar.ae = this.ae;
        xtVar.tl = this.tl;
        xtVar.f24663i = this.f24663i;
        xtVar.f24672v = this.f24672v;
        xtVar.kt = this.kt;
        xtVar.f24673w = this.f24673w;
        xtVar.mi = this.mi;
        xtVar.tj = this.tj;
        xtVar.f24660f = this.f24660f;
        xtVar.f24674x = this.f24674x;
        xtVar.ch = this.ch;
        xtVar.f24671s = this.f24671s;
        xtVar.f24668p = this.f24668p;
        xtVar.f24662h = this.f24662h;
        xtVar.rn = this.rn;
        xtVar.wq = this.wq;
        xtVar.uf = this.uf;
        xtVar.la = this.la;
        xtVar.gq = this.gq;
        xtVar.f24667n = this.f24667n;
        xtVar.gx = this.gx;
        xtVar.f24658c = this.f24658c;
        xtVar.ed = this.ed;
        xtVar.f24656a = this.f24656a;
        xtVar.f24665l = this.f24665l;
        xtVar.nd = this.nd;
        xtVar.jy = this.jy;
        xtVar.av = this.av;
        xtVar.f24661g = new CopyOnWriteArrayList(this.f24661g);
        xtVar.oq = new HashMap(this.oq);
        xtVar.az = this.az;
        xtVar.vl = new ArrayList(this.vl);
        xtVar.ya = new HashMap(this.ya);
        xtVar.qv = new HashMap(this.qv);
        xtVar.rh = this.rh;
        xtVar.ol = this.ol;
        xtVar.ws = this.ws;
        xtVar.hl = this.hl;
        xtVar.hh = this.hh;
        xtVar.f24675z = this.f24675z;
        xtVar.f24659e = this.f24659e;
        xtVar.f24669q = this.f24669q;
        xtVar.qb = this.qb;
        return xtVar;
    }

    public xt az() {
        List<String> j6 = qv.j();
        xt xtVar = new xt();
        xtVar.f24664j = this.f24664j;
        qv.j(j6, "mRitId");
        xtVar.xt = this.xt;
        qv.j(j6, "mRitType");
        xtVar.cw = this.cw;
        qv.j(j6, "mLookType");
        xtVar.f24670r = this.f24670r;
        qv.j(j6, "mMinWaitTime");
        xtVar.up = this.up;
        qv.j(j6, "mLayerTimeOut");
        xtVar.f24666m = this.f24666m;
        qv.j(j6, "mTotalTimeOut");
        xtVar.ae = this.ae;
        qv.j(j6, "mCacheTimeOut");
        xtVar.tl = this.tl;
        qv.j(j6, "mVersion");
        xtVar.f24663i = this.f24663i;
        qv.j(j6, "mWaterFallId");
        xtVar.f24672v = this.f24672v;
        qv.j(j6, "reqType");
        xtVar.kt = this.kt;
        qv.j(j6, "mWaterfallAbTestParam");
        xtVar.f24673w = this.f24673w;
        qv.j(j6, "segmentId");
        xtVar.mi = this.mi;
        qv.j(j6, "segmentVersion");
        xtVar.tj = this.tj;
        qv.j(j6, "preLoadSortControl");
        xtVar.f24660f = this.f24660f;
        qv.j(j6, "preShowSortControl");
        xtVar.f24674x = this.f24674x;
        qv.j(j6, "waterfallExtra");
        xtVar.ch = this.ch;
        qv.j(j6, "mMultilevelAfterP");
        xtVar.f24671s = this.f24671s;
        qv.j(j6, "mMultilevelTimeOut");
        xtVar.f24668p = this.f24668p;
        qv.j(j6, "mRefreshTime");
        xtVar.f24662h = this.f24662h;
        qv.j(j6, "mBidFloor");
        xtVar.rn = this.rn;
        qv.j(j6, "mParallelType");
        xtVar.wq = this.wq;
        qv.j(j6, "mReqParallelNum");
        xtVar.uf = this.uf;
        qv.j(j6, "mAdCount");
        xtVar.la = this.la;
        qv.j(j6, "serverSideVerifyPreRequestTime");
        xtVar.gq = this.gq;
        qv.j(j6, "serverSideRewardType");
        xtVar.f24667n = this.f24667n;
        qv.j(j6, "mAdPrime");
        xtVar.f24669q = this.f24669q;
        qv.j(j6, "mRefreshNum");
        xtVar.f24659e = this.f24659e;
        qv.j(j6, "mIsRefresh");
        xtVar.gx = this.gx;
        qv.j(j6, "mIntervalFreqctlBean");
        xtVar.f24658c = this.f24658c;
        qv.j(j6, "mIntervalPacingBean");
        xtVar.ed = this.ed;
        qv.j(j6, "mWaterFallTimingMode");
        xtVar.hl = this.hl;
        qv.j(j6, "mReqInterval");
        xtVar.hh = this.hh;
        qv.j(j6, "mTotalTimeoutRate");
        xtVar.f24675z = this.f24675z;
        qv.j(j6, "mLayerTimeoutRate");
        xtVar.ya = new HashMap(this.ya);
        xtVar.rh = this.rh;
        xtVar.ol = this.ol;
        xtVar.ws = this.ws;
        xtVar.qv = new HashMap(this.qv);
        qv.xt(j6, "AdsenseRitConfig");
        xtVar.qb = this.qb;
        qv.j(j6, "mBehaviorTTL");
        return xtVar;
    }

    public double cw() {
        return this.hh;
    }

    public int f() {
        return this.av;
    }

    public com.bytedance.msdk.core.tl.g g() {
        return this.f24658c;
    }

    public int i() {
        return this.uf;
    }

    public int j() {
        return this.f24657b;
    }

    public int jy() {
        return this.f24659e;
    }

    public long kt() {
        return this.f24671s;
    }

    public int m() {
        return this.rh;
    }

    public String mi() {
        return this.f24674x;
    }

    public boolean oq() {
        return this.ed == 1;
    }

    public boolean qv() {
        return this.rn == 3;
    }

    public long r() {
        return this.hl;
    }

    public int tj() {
        return this.f24672v;
    }

    public com.bytedance.msdk.core.tl.ae tl() {
        return this.gx;
    }

    public Map<String, Object> up() {
        return this.ya;
    }

    public boolean vl() {
        return this.f24667n == 1;
    }

    public double w() {
        return this.f24662h;
    }

    public int ws() {
        int i6 = this.f24669q;
        if (i6 < 2) {
            return 2;
        }
        return i6;
    }

    public double xt() {
        return this.f24675z;
    }

    private static Long f(int i6) {
        if (i6 != 1 && i6 != 2) {
            if (i6 == 3) {
                return 5000L;
            }
            if (i6 != 5) {
                if (i6 == 7 || i6 == 8) {
                    return Long.valueOf(TTAdConstant.AD_MAX_EVENT_TIME);
                }
                return 10000L;
            }
        }
        return 10000L;
    }

    private static Long tj(int i6) {
        return (i6 == 1 || !(i6 == 2 || i6 == 3 || i6 != 5)) ? 1000L : 0L;
    }

    public int a() {
        return this.f24673w;
    }

    public void ae(int i6) {
        this.f24669q = i6;
    }

    public int b() {
        return this.qb;
    }

    public long c() {
        return this.f24666m;
    }

    public Map<Integer, List<oq>> ch() {
        HashMap hashMap = new HashMap();
        Map<Integer, List<oq>> map = this.oq;
        if (map != null) {
            for (Map.Entry<Integer, List<oq>> entry : map.entrySet()) {
                List<oq> value = entry.getValue();
                Integer key = entry.getKey();
                key.intValue();
                hashMap.put(key, new ArrayList(value));
            }
        }
        return hashMap;
    }

    public void cw(int i6) {
        this.ol = i6;
    }

    public long ed() {
        return this.up;
    }

    public int g(int i6) {
        if (m() == 2) {
            int j6 = com.bytedance.msdk.core.g.r.j(this.f24664j, i6, up());
            if (this.f24668p != 0 && j6 != 0) {
                return j6;
            }
        }
        return this.f24668p;
    }

    public List<Integer> gq() {
        return this.vl;
    }

    public long gx() {
        return this.ae;
    }

    public boolean h() {
        return this.f24665l;
    }

    public String hh() {
        return this.kt;
    }

    public int hl() {
        return this.wq;
    }

    public void i(int i6) {
        this.gq = i6;
    }

    public void j(int i6) {
        this.f24657b = i6;
    }

    public void jy(int i6) {
        this.f24673w = i6;
    }

    public void kt(int i6) {
        this.qb = i6;
    }

    public String l() {
        return this.mi;
    }

    public String la() {
        return this.tl;
    }

    public void m(int i6) {
        this.f24659e = i6;
    }

    public void mi(int i6) {
        this.wq = i6;
    }

    public int n() {
        return this.la;
    }

    public int nd() {
        return this.gq;
    }

    public List<oq> ol() {
        return this.f24661g;
    }

    public void oq(int i6) {
        this.f24668p = i6;
    }

    public boolean p() {
        return this.f24656a;
    }

    public void qv(int i6) {
        this.ch = i6;
    }

    public void r(int i6) {
        this.f24667n = i6;
    }

    public Map<Integer, List<oq>> rh() {
        return this.qv;
    }

    public String rn() {
        return this.f24664j;
    }

    public long s() {
        return this.f24663i;
    }

    public void tl(int i6) {
        this.uf = i6;
    }

    public String toString() {
        return "AdsenseRitConfig{mRitId='" + this.f24664j + "', mIsSpeed=" + qv() + ", mHasServerbidding=" + this.f24656a + ", mHasClientOrMultiLevel=" + this.f24665l + ", mRitType=" + this.xt + ", mLookType=" + this.cw + ", mMinWaitTime=" + this.f24670r + ", mLayerTimeOut=" + this.up + ", mTotalTimeOut=" + this.f24666m + ", mWaterFallConfigList=" + this.f24661g + ", mWaterFallConfMap=" + this.oq + ", mLoadSortLevelList=" + this.vl + ", mCurrentCommonAdMaxCpm=" + this.jy + ", mTotalLoadLevelCount=" + this.az + ", mTotalWaterFallCount=" + this.av + ", mWaterfallAbTestParam=" + this.kt + ", mServerSideVerifyPreRequestTime=" + this.la + ", mServerSideVerifyRewardType=" + this.gq + '}';
    }

    public long uf() {
        return this.f24670r;
    }

    public void up(int i6) {
        this.ed = i6;
    }

    public double v() {
        return this.jy;
    }

    public void vl(int i6) {
        this.f24672v = i6;
    }

    public void w(int i6) {
        this.rn = i6;
    }

    public int wq() {
        return this.xt;
    }

    public void ws(int i6) {
        this.xt = i6;
    }

    public double x() {
        return this.ws;
    }

    public void xt(double d6) {
        if (d6 < 0.01d || d6 > 1.0d) {
            d6 = 0.01d;
        }
        this.hh = d6;
    }

    public int z() {
        return this.rn;
    }

    public void ae(long j6) {
        this.ae = j6;
    }

    public void cw(double d6) {
        this.f24662h = d6;
    }

    public void j(double d6) {
        if (d6 < 0.1d || d6 > 1.0d) {
            d6 = 0.1d;
        }
        this.f24675z = d6;
    }

    public void m(long j6) {
        this.f24666m = j6;
    }

    public void r(double d6) {
        this.jy = d6;
    }

    public void up(double d6) {
        this.ws = d6;
    }

    public void xt(int i6) {
        this.rh = i6;
    }

    public static xt ae(String str) {
        if (TextUtils.isEmpty(str)) {
            com.bytedance.msdk.j.up.cw.j("AdsenseRitConfig", "TMe jsonStr is null or empty");
            return null;
        }
        try {
            return j(new JSONObject(str), true);
        } catch (JSONException e6) {
            vl.j(e6);
            return null;
        }
    }

    public void cw(long j6) {
        this.f24663i = j6;
    }

    public void j(long j6) {
        if (j6 < 1000) {
            j6 = 1000;
        }
        this.hl = j6;
    }

    public oq m(String str) {
        List<oq> list;
        if (!TextUtils.isEmpty(str) && (list = this.f24661g) != null && list.size() != 0) {
            for (oq oqVar : this.f24661g) {
                if (str.equals(oqVar.w())) {
                    return oqVar;
                }
            }
        }
        return null;
    }

    public void r(String str) {
        this.f24664j = str;
    }

    public void up(long j6) {
        this.up = j6;
    }

    public void xt(long j6) {
        this.f24671s = j6;
    }

    public void cw(String str) {
        this.tl = str;
    }

    public void j(com.bytedance.msdk.core.tl.ae aeVar) {
        this.gx = aeVar;
    }

    public void r(long j6) {
        this.f24670r = j6;
    }

    public void up(String str) {
        this.kt = str;
    }

    public void xt(String str) {
        this.mi = str;
    }

    private void cw(List<oq> list) {
        int i6;
        List<oq> list2;
        if (list == null) {
            return;
        }
        this.qv.clear();
        int i7 = -1000;
        for (int i8 = 0; i8 < list.size(); i8++) {
            oq oqVar = list.get(i8);
            if (oqVar != null) {
                if (oqVar.mi() == 0) {
                    list2 = new ArrayList<>();
                    i6 = oqVar.ch();
                } else if (oqVar.x() != i7) {
                    list2 = new ArrayList<>();
                    i6 = oqVar.x();
                } else {
                    i6 = i7;
                    list2 = this.qv.get(Integer.valueOf(i7));
                }
                if (list2 != null) {
                    list2.add(oqVar);
                    this.qv.put(Integer.valueOf(i6), list2);
                }
                i7 = i6;
            }
        }
    }

    private void r(List<oq> list) {
        int i6;
        List<oq> list2;
        if (list == null) {
            return;
        }
        this.qv.clear();
        int i7 = -1000;
        for (int i8 = 0; i8 < list.size(); i8++) {
            oq oqVar = list.get(i8);
            if (oqVar != null) {
                if (oqVar.x() != i7) {
                    list2 = new ArrayList<>();
                    i6 = oqVar.x();
                } else {
                    i6 = i7;
                    list2 = this.qv.get(Integer.valueOf(i7));
                }
                if (list2 != null) {
                    list2.add(oqVar);
                    this.qv.put(Integer.valueOf(i6), list2);
                }
                i7 = i6;
            }
        }
    }

    public void j(com.bytedance.msdk.core.tl.g gVar) {
        this.f24658c = gVar;
    }

    public void xt(boolean z5) {
        this.f24665l = z5;
    }

    public void j(String str) {
        this.f24674x = str;
    }

    public void xt(List<oq> list) {
        int i6;
        List<oq> list2;
        cw(list);
        this.f24661g = list;
        if (list == null) {
            return;
        }
        this.az = 0;
        this.oq.clear();
        this.vl.clear();
        this.av = this.f24661g.size();
        int i7 = -1000;
        for (int i8 = 0; i8 < this.f24661g.size(); i8++) {
            oq oqVar = list.get(i8);
            if (oqVar != null) {
                if (oqVar.mi() == 0) {
                    this.az++;
                    list2 = new ArrayList<>();
                    i6 = oqVar.ch();
                } else if (oqVar.x() != i7) {
                    this.az++;
                    list2 = new ArrayList<>();
                    i6 = oqVar.x();
                } else {
                    i6 = i7;
                    list2 = this.oq.get(Integer.valueOf(i7));
                }
                if (list2 != null) {
                    list2.add(oqVar);
                    this.oq.put(Integer.valueOf(i6), list2);
                }
                i7 = i6;
            }
        }
        this.vl.addAll(this.oq.keySet());
    }

    public void j(boolean z5) {
        this.f24656a = z5;
    }

    public void j(List<oq> list) {
        int i6;
        List<oq> list2;
        r(list);
        this.f24661g = list;
        if (list == null) {
            return;
        }
        this.az = 0;
        this.oq.clear();
        this.vl.clear();
        this.av = this.f24661g.size();
        int i7 = -1000;
        for (int i8 = 0; i8 < this.f24661g.size(); i8++) {
            oq oqVar = list.get(i8);
            if (oqVar != null) {
                if (oqVar.x() != i7) {
                    this.az++;
                    list2 = new ArrayList<>();
                    i6 = oqVar.x();
                } else {
                    i6 = i7;
                    list2 = this.oq.get(Integer.valueOf(i7));
                }
                if (list2 != null) {
                    list2.add(oqVar);
                    this.oq.put(Integer.valueOf(i6), list2);
                }
                i7 = i6;
            }
        }
        this.vl.addAll(this.oq.keySet());
    }

    public void j(JSONObject jSONObject) {
        this.nd = jSONObject;
    }

    public static xt j(JSONObject jSONObject, boolean z5) {
        String str;
        JSONObject jSONObject2;
        oq oqVar;
        String str2;
        int i6;
        String str3;
        String str4 = null;
        if (jSONObject == null) {
            return null;
        }
        xt xtVar = new xt();
        xtVar.j(jSONObject);
        xtVar.cw(jSONObject.optDouble("bid_floor", 0.0d));
        xtVar.r(jSONObject.optString("rit_id"));
        xtVar.cw(jSONObject.optString("version"));
        xtVar.cw(jSONObject.optLong("waterfall_id", -1L));
        xtVar.ws(jSONObject.optInt("rit_type"));
        xtVar.az(jSONObject.optInt("look_type", 1));
        xtVar.r(jSONObject.optLong("time_min", tj(xtVar.wq()).longValue()));
        xtVar.up(jSONObject.optLong("layer_time_out", 2000L));
        xtVar.m(jSONObject.optLong("total_time_out", f(xtVar.wq()).longValue()));
        xtVar.xt(jSONObject.optLong("multilevel_time_out", 2000L));
        xtVar.ae(jSONObject.optLong("cache_time_out", 3000L));
        xtVar.vl(jSONObject.optInt("req_type", 0));
        com.bytedance.msdk.core.up.xt.r.j().j(xtVar.rn(), xtVar.tj());
        xtVar.jy(jSONObject.optInt("segment_id"));
        xtVar.xt(jSONObject.optString("segment_version"));
        xtVar.j(jSONObject.optString("waterfall_extra"));
        xtVar.qv(jSONObject.optInt("multilevel_after_p", 1));
        xtVar.oq(jSONObject.optInt("refresh_time", 0));
        xtVar.m(jSONObject.optInt("is_refresh", 0));
        xtVar.ae(jSONObject.optInt("refresh_num", 2));
        xtVar.w(jSONObject.optInt("parallel_type", 1));
        xtVar.r(jSONObject.optInt("is_adprime", 0));
        xtVar.mi(jSONObject.optInt("req_parallel_num", 2));
        xtVar.av(jSONObject.optInt("reward_start_time", 15000));
        xtVar.i(jSONObject.optInt("reward_callback_type"));
        xtVar.j(jSONObject.optLong("req_interval", 1000L));
        xtVar.xt(jSONObject.optDouble("total_time_rate", 0.01d));
        xtVar.j(jSONObject.optDouble("layer_time_rate", 0.1d));
        xtVar.j(jSONObject.optInt("support_render_control", 0));
        xtVar.kt(jSONObject.optInt("behavior_ttl"));
        int optInt = jSONObject.optInt("ad_count", 0);
        if (optInt < 0) {
            optInt = 0;
        } else if (optInt > 3) {
            optInt = 3;
        }
        xtVar.tl(optInt);
        xtVar.xt(jSONObject.optInt("group_type"));
        xtVar.cw(jSONObject.optInt("bidding_time_out", 1000));
        String optString = jSONObject.optString("waterfall_abtest");
        if (optString != null) {
            xtVar.up(optString);
        }
        int optInt2 = jSONObject.optInt("waterfall_timing_mode");
        xtVar.up(optInt2);
        if (xtVar.oq()) {
            JSONObject optJSONObject = jSONObject.optJSONObject("waterfall_show_pacing_rule");
            if (optJSONObject == null) {
                str3 = "waterfall_show_rules_version";
            } else {
                String str5 = xtVar.rn();
                String optString2 = jSONObject.optString("waterfall_show_rules_version");
                String optString3 = optJSONObject.optString("waterfall_show_pacing");
                String optString4 = optJSONObject.optString("waterfall_show_pacing_rule_id");
                str3 = "waterfall_show_rules_version";
                xtVar.j(new com.bytedance.msdk.core.tl.g(str5, "", optString2, "", optInt2, optString3, optString4));
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("waterfall_show_freqctl_rules");
            xtVar.j(new com.bytedance.msdk.core.tl.ae(xtVar.rn(), "", jSONObject.optString(str3), "", optInt2, optJSONArray == null ? "[]" : optJSONArray.toString()));
        }
        if (jSONObject.optInt("is_ra") == 1) {
            com.bytedance.msdk.core.admanager.reward.rewardagain.j jVar = new com.bytedance.msdk.core.admanager.reward.rewardagain.j();
            jVar.j(jSONObject.optString("ra_id"));
            jVar.xt(jSONObject.optInt("ra_max", 0));
            jVar.xt(jSONObject.optDouble("ra_ecpm"));
            jVar.j(jSONObject.optLong("ra_in", 0L));
            jVar.j(jSONObject.optInt("ra_h_max", 0));
            jVar.j(jSONObject.optDouble("ra_ra"));
            com.bytedance.msdk.core.admanager.reward.rewardagain.cw.j(xtVar.rn(), jVar);
        } else {
            com.bytedance.msdk.core.admanager.reward.rewardagain.cw.oq(xtVar.rn());
        }
        JSONArray optJSONArray2 = jSONObject.optJSONArray("adn_rit_conf");
        ArrayList arrayList = new ArrayList();
        if (optJSONArray2 != null) {
            int i7 = 0;
            while (i7 < optJSONArray2.length()) {
                try {
                    jSONObject2 = optJSONArray2.getJSONObject(i7);
                    oqVar = new oq();
                    oqVar.cw(jSONObject2.optString(MediationConstant.EXTRA_ADN_NAME));
                    if (com.bytedance.msdk.core.xt.xt().cw(jSONObject2.optString(MediationConstant.EXTRA_ADN_NAME))) {
                        oqVar.r(jSONObject2.optString("custom_adn_name"));
                    } else {
                        oqVar.r(str4);
                    }
                    oqVar.ae(xtVar.hh());
                    String optString5 = jSONObject2.optString("adn_slot_id");
                    oqVar.up(optString5);
                    if (!z5 && !TextUtils.isEmpty(optString5) && !TextUtils.isEmpty(xtVar.rn())) {
                        com.bytedance.msdk.cw.tl.r.xt.put(optString5, xtVar.rn());
                    }
                    oqVar.j(jSONObject2.optInt("is_refresh", 0));
                    int optInt3 = jSONObject2.optInt("freqctl_timing_mode");
                    oqVar.xt(optInt3);
                    if (oqVar.r()) {
                        try {
                            JSONObject optJSONObject2 = jSONObject2.optJSONObject("show_pacing_rule");
                            if (optJSONObject2 != null) {
                                str = str4;
                                try {
                                    str2 = optString5;
                                    i6 = optInt3;
                                    oqVar.j(new com.bytedance.msdk.core.tl.g(xtVar.rn(), str2, "", "", i6, optJSONObject2.optString("pacing"), optJSONObject2.optString("rule_id")));
                                } catch (JSONException e6) {
                                    e = e6;
                                    vl.j(e);
                                    i7++;
                                    str4 = str;
                                }
                            } else {
                                str = str4;
                                str2 = optString5;
                                i6 = optInt3;
                            }
                            JSONArray optJSONArray3 = jSONObject2.optJSONArray("show_freqctl_rules");
                            oqVar.j(new com.bytedance.msdk.core.tl.ae(xtVar.rn(), str2, "", jSONObject2.optString("show_freqctl_rules_version"), i6, optJSONArray3 == null ? "[]" : optJSONArray3.toString()));
                        } catch (JSONException e7) {
                            e = e7;
                            str = str4;
                        }
                    } else {
                        str = str4;
                    }
                    oqVar.oq(jSONObject2.optInt("req_bidding_type"));
                    oqVar.m(jSONObject2.optString("slot_cpm", "0"));
                    oqVar.xt(jSONObject2.optString("exchange_rate"));
                    oqVar.qv(jSONObject2.optInt("load_sort"));
                    oqVar.vl(jSONObject2.optInt("show_sort"));
                    oqVar.r(jSONObject2.optInt("ad_expired_time", 1800000));
                    com.bytedance.msdk.core.up.xt.r.j().j(xtVar.rn(), oqVar.w(), oqVar.tl());
                    com.bytedance.msdk.core.up.j.j.j().j(xtVar.rn(), oqVar.w(), oqVar.tl());
                    oqVar.tl(jSONObject2.optInt("if_is_ready", 1));
                    com.bytedance.msdk.core.up.xt.r.j().xt(xtVar.rn(), oqVar.w(), oqVar.vl());
                    com.bytedance.msdk.core.up.j.j.j().xt(xtVar.rn(), oqVar.w(), oqVar.vl());
                    oqVar.up(jSONObject2.optInt("if_reuse_ads", 0));
                    com.bytedance.msdk.core.up.j.j.j().cw(xtVar.rn(), oqVar.w(), oqVar.g());
                    oqVar.ae(jSONObject2.optInt("if_pre_request", 0));
                    com.bytedance.msdk.core.up.j.j.j().m(xtVar.rn(), oqVar.w(), oqVar.qv());
                    oqVar.g(xtVar.wq());
                    oqVar.j("%1$s%2$sAdapter");
                    oqVar.m(jSONObject2.optInt("origin_type"));
                    oqVar.cw(jSONObject2.optInt("sub_adtype"));
                    oqVar.j(xt(jSONObject2.optJSONObject("multilevel_slot_cpm")));
                } catch (JSONException e8) {
                    e = e8;
                    str = str4;
                }
                if (oqVar.mi() == 1) {
                    xtVar.xt(true);
                } else if (oqVar.mi() == 2) {
                    xtVar.j(true);
                } else {
                    if (oqVar.mi() == 3) {
                        try {
                            xtVar.xt(true);
                        } catch (JSONException e9) {
                            e = e9;
                            vl.j(e);
                            i7++;
                            str4 = str;
                        }
                    } else if (oqVar.mi() != 100) {
                        if (xtVar.v() == -1.0d || xtVar.v() < oqVar.v()) {
                            xtVar.r(oqVar.v());
                        }
                        if (xtVar.x() == -1.0d || xtVar.x() > oqVar.v()) {
                            xtVar.up(oqVar.v());
                        }
                    }
                    oqVar.g(jSONObject2.optString("customer_adapter_json"));
                    arrayList.add(oqVar);
                    i7++;
                    str4 = str;
                }
                oqVar.g(jSONObject2.optString("customer_adapter_json"));
                arrayList.add(oqVar);
                i7++;
                str4 = str;
            }
        }
        Collections.sort(arrayList);
        if (xtVar.qv()) {
            xtVar.xt(arrayList);
        } else {
            xtVar.j(arrayList);
        }
        return xtVar;
    }

    private static Map<String, String> xt(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        try {
            Iterator<String> keys = jSONObject.keys();
            if (keys == null) {
                return null;
            }
            while (keys.hasNext()) {
                String next = keys.next();
                String optString = jSONObject.optString(next);
                if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(optString)) {
                    hashMap.put(next, optString);
                }
            }
            if (hashMap.size() == 0) {
                return null;
            }
            return hashMap;
        } catch (Exception unused) {
            return null;
        }
    }

    public void av(int i6) {
        this.la = i6;
    }

    public void az(int i6) {
        this.cw = i6;
    }
}
