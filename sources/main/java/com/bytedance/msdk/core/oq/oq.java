package com.bytedance.msdk.core.oq;

import android.text.TextUtils;
import com.bytedance.msdk.tl.qv;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\Downloads\app\classes3.dex */
public class oq implements Comparable<oq> {
    private int ae;
    private int av;
    private int az;
    private int ch;
    private String cw;

    /* renamed from: f, reason: collision with root package name */
    private int f24638f;

    /* renamed from: g, reason: collision with root package name */
    private int f24639g;

    /* renamed from: i, reason: collision with root package name */
    private int f24640i;

    /* renamed from: j, reason: collision with root package name */
    private String f24641j;
    private int jy;
    private int kt;

    /* renamed from: m, reason: collision with root package name */
    private int f24642m;
    private Map<String, String> mi;
    private String oq;
    private String qv;
    private String tj;
    private int tl;

    /* renamed from: v, reason: collision with root package name */
    private com.bytedance.msdk.core.tl.g f24644v;
    private String vl;

    /* renamed from: w, reason: collision with root package name */
    private tl f24645w;
    private int ws;

    /* renamed from: x, reason: collision with root package name */
    private com.bytedance.msdk.core.tl.ae f24646x;
    private String xt;

    /* renamed from: r, reason: collision with root package name */
    private String f24643r = "1";
    private String up = "0";

    public String ae() {
        return this.oq;
    }

    public com.bytedance.msdk.core.tl.g cw() {
        return this.f24644v;
    }

    public int g() {
        return this.ws;
    }

    public void j(int i6) {
        this.ch = i6;
    }

    public int m() {
        return this.kt;
    }

    public int oq() {
        return this.az;
    }

    public int qv() {
        return this.av;
    }

    public boolean r() {
        return this.f24638f == 1;
    }

    public int tl() {
        return this.jy;
    }

    public oq up() {
        ConcurrentHashMap concurrentHashMap;
        List<String> xt = qv.xt();
        oq oqVar = new oq();
        oqVar.f24641j = this.f24641j;
        qv.j(xt, "mAdnetworkName");
        oqVar.cw = this.cw;
        qv.j(xt, "mAdnetwokrSlotId");
        oqVar.f24643r = this.f24643r;
        qv.j(xt, "mExchangeRate");
        oqVar.up = this.up;
        qv.j(xt, "mEcpm");
        oqVar.f24642m = this.f24642m;
        qv.j(xt, "mAdnetworkSlotType");
        oqVar.ae = this.ae;
        qv.j(xt, "mLoadSort");
        oqVar.tl = this.tl;
        qv.j(xt, "mShowSort");
        oqVar.f24639g = this.f24639g;
        qv.j(xt, "mRitType");
        oqVar.az = this.az;
        qv.j(xt, "originType");
        oqVar.kt = this.kt;
        qv.j(xt, "mSubAdType");
        oqVar.oq = this.oq;
        qv.j(xt, "mLoaderAdapterName");
        oqVar.qv = this.qv;
        qv.j(xt, "mWaterfallAbTestParam");
        oqVar.vl = this.vl;
        qv.j(xt, "mServerBiddingExtra");
        oqVar.jy = this.jy;
        qv.j(xt, "adExpiredTime");
        oqVar.ws = this.ws;
        qv.j(xt, "ifReuseAds");
        oqVar.av = this.av;
        qv.j(xt, "ifPreRequest");
        oqVar.f24640i = this.f24640i;
        qv.j(xt, "ifIsReady");
        oqVar.ch = this.ch;
        qv.j(xt, "isRefresh");
        oqVar.xt = this.xt;
        qv.j(xt, "mCustomAdnetworkName");
        Map<String, String> map = this.mi;
        if (map == null || map.size() <= 0) {
            concurrentHashMap = null;
        } else {
            concurrentHashMap = new ConcurrentHashMap();
            concurrentHashMap.putAll(this.mi);
        }
        oqVar.mi = concurrentHashMap;
        qv.j(xt, "mMultilevelSlotCpm");
        oqVar.tj = this.tj;
        qv.j(xt, "mCustomAdapterJson");
        oqVar.f24638f = this.f24638f;
        qv.j(xt, "mAdnRitTimingMode");
        oqVar.f24646x = this.f24646x;
        qv.j(xt, "mIntervalFreqctlBean");
        oqVar.f24644v = this.f24644v;
        qv.j(xt, "mIntervalPacingBean");
        qv.xt(xt, "WaterFallConfig");
        return oqVar;
    }

    public int vl() {
        return this.f24640i;
    }

    public com.bytedance.msdk.core.tl.ae xt() {
        return this.f24646x;
    }

    public String a() {
        return this.vl;
    }

    public void ae(int i6) {
        this.av = i6;
    }

    public String av() {
        return this.xt;
    }

    public String az() {
        return this.f24641j;
    }

    public int ch() {
        return this.tl;
    }

    public void cw(int i6) {
        this.kt = i6;
    }

    public String ed() {
        return this.tj;
    }

    public double f() {
        tl tlVar = this.f24645w;
        if (tlVar != null && !TextUtils.isEmpty(tlVar.m())) {
            try {
                return Double.valueOf(this.f24645w.m()).doubleValue();
            } catch (Exception e6) {
                com.bytedance.msdk.j.up.cw.r("WaterFallConfig", "getServerBiddingLoadEcpm error " + e6.toString());
            }
        }
        return -1.0d;
    }

    public void g(int i6) {
        this.f24639g = i6;
    }

    public boolean gq() {
        return this.f24642m == 100;
    }

    public boolean h() {
        return this.f24642m == 2;
    }

    public String i() {
        return TextUtils.isEmpty(this.f24641j) ? this.xt : this.f24641j;
    }

    public int j() {
        return this.ch;
    }

    public int jy() {
        return this.f24639g;
    }

    public boolean kt() {
        int i6 = this.f24642m;
        return i6 == 0 || i6 == 100;
    }

    public tl l() {
        return this.f24645w;
    }

    public boolean la() {
        return this.f24642m == 1;
    }

    public void m(int i6) {
        this.az = i6;
    }

    public int mi() {
        return this.f24642m;
    }

    public void oq(int i6) {
        this.f24642m = i6;
    }

    public Map<String, String> p() {
        return this.mi;
    }

    public void qv(int i6) {
        this.ae = i6;
    }

    public void r(int i6) {
        this.jy = i6;
    }

    public boolean rn() {
        return this.f24642m == 3;
    }

    public String s() {
        return this.qv;
    }

    public double tj() {
        tl tlVar = this.f24645w;
        if (tlVar != null && !TextUtils.isEmpty(tlVar.up())) {
            try {
                return Double.valueOf(this.f24645w.up()).doubleValue();
            } catch (Exception e6) {
                com.bytedance.msdk.j.up.cw.r("WaterFallConfig", "getServerBiddingShowEcpm error " + e6.toString());
            }
        }
        return -1.0d;
    }

    public void tl(int i6) {
        this.f24640i = i6;
    }

    public String toString() {
        return "WaterFallConfig{mAdnetworkName='" + this.f24641j + "', mCustomAdnetworkName='" + this.xt + "', mAdnetwokrSlotId='" + this.cw + "', mExchangeRate=" + this.f24643r + ", mSlotEcpm=" + this.up + ", mAdnetworkSlotType=" + this.f24642m + ", mLoadSort=" + this.ae + ", mShowSort=" + this.tl + '}';
    }

    public boolean uf() {
        return this.f24642m == 0;
    }

    public double v() {
        try {
            return Double.valueOf(this.up).doubleValue() * Double.valueOf(this.f24643r).doubleValue();
        } catch (Exception e6) {
            com.bytedance.msdk.j.up.cw.r("WaterFallConfig", "getEcpm error " + e6.toString());
            return 0.0d;
        }
    }

    public void vl(int i6) {
        this.tl = i6;
    }

    public String w() {
        return this.cw;
    }

    public String ws() {
        return this.f24643r;
    }

    public int x() {
        return this.ae;
    }

    public void xt(int i6) {
        this.f24638f = i6;
    }

    public void ae(String str) {
        this.qv = str;
    }

    public boolean c() {
        return com.bytedance.msdk.core.xt.xt().cw(this.f24641j);
    }

    public void cw(String str) {
        this.f24641j = str;
    }

    public void g(String str) {
        this.tj = str;
    }

    public void j(com.bytedance.msdk.core.tl.ae aeVar) {
        this.f24646x = aeVar;
    }

    public void m(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "0";
        }
        this.up = str;
    }

    public void r(String str) {
        this.xt = str;
    }

    public void tl(String str) {
        this.vl = str;
    }

    public boolean wq() {
        if (!h() && !la() && !rn()) {
            return false;
        }
        return true;
    }

    public void xt(String str) {
        this.f24643r = str;
    }

    public void j(com.bytedance.msdk.core.tl.g gVar) {
        this.f24644v = gVar;
    }

    public void j(String str) {
        this.oq = str;
    }

    public void j(tl tlVar) {
        this.f24645w = tlVar;
    }

    public void j(Map<String, String> map) {
        this.mi = map;
    }

    @Override // java.lang.Comparable
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public int compareTo(oq oqVar) {
        if (oqVar == null || this.ae > oqVar.x()) {
            return 1;
        }
        if (this.ae < oqVar.x()) {
            return -1;
        }
        if (this.tl > oqVar.ch()) {
            return 1;
        }
        return this.tl < oqVar.ch() ? -1 : 0;
    }

    public void up(int i6) {
        this.ws = i6;
    }

    public void up(String str) {
        this.cw = str;
    }
}
