package com.bytedance.msdk.cw.r;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.mobads.sdk.api.SplashAd;
import com.bytedance.component.sdk.annotation.DungeonFlag;
import com.bytedance.msdk.tl.i;
import com.bytedance.msdk.tl.mi;
import com.bytedance.msdk.tl.p;
import com.bytedance.msdk.tl.tj;
import com.bytedance.msdk.tl.ws;
import com.bytedance.msdk.tl.x;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.lang.ref.SoftReference;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class xt implements com.bytedance.msdk.cw.xt.j.j {
    protected com.bytedance.msdk.core.oq.xt ae;
    protected com.bytedance.msdk.cw.m.j.xt cw;

    /* renamed from: g, reason: collision with root package name */
    protected com.bytedance.msdk.j.xt.m f25120g;
    protected com.bytedance.msdk.api.r.j.xt jy;

    /* renamed from: m, reason: collision with root package name */
    protected com.bytedance.msdk.api.j.xt f25122m;

    /* renamed from: r, reason: collision with root package name */
    protected com.bytedance.msdk.xt.cw f25123r;
    protected SoftReference<Context> tl;
    protected String up;
    protected com.bytedance.sdk.openadsdk.i.cw.j.xt ws;
    protected boolean oq = false;
    protected int qv = 0;
    protected volatile boolean vl = false;

    /* renamed from: j, reason: collision with root package name */
    private final Comparator<com.bytedance.msdk.core.oq.oq> f25121j = new Comparator<com.bytedance.msdk.core.oq.oq>() { // from class: com.bytedance.msdk.cw.r.xt.1
        @Override // java.util.Comparator
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public int compare(com.bytedance.msdk.core.oq.oq oqVar, com.bytedance.msdk.core.oq.oq oqVar2) {
            int x5;
            int x6;
            if (oqVar.x() == oqVar2.x()) {
                x5 = oqVar.ch();
                x6 = oqVar2.ch();
            } else {
                x5 = oqVar.x();
                x6 = oqVar2.x();
            }
            return x5 - x6;
        }
    };
    protected final Comparator<com.bytedance.msdk.core.oq.oq> az = new Comparator<com.bytedance.msdk.core.oq.oq>() { // from class: com.bytedance.msdk.cw.r.xt.2
        @Override // java.util.Comparator
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public int compare(com.bytedance.msdk.core.oq.oq oqVar, com.bytedance.msdk.core.oq.oq oqVar2) {
            if (oqVar.v() > oqVar2.v()) {
                return -1;
            }
            if (oqVar.v() < oqVar2.v()) {
                return 1;
            }
            return 0;
        }
    };

    private com.bytedance.msdk.xt.cw cw(com.bytedance.msdk.xt.cw cwVar) {
        LinkedList<com.bytedance.msdk.xt.cw> linkedList = new LinkedList();
        com.bytedance.msdk.cw.m.j.xt xtVar = this.cw;
        if (xtVar != null) {
            if (xtVar.oq() != null && this.cw.oq().size() != 0) {
                linkedList.addAll(this.cw.oq());
            }
            if (this.cw.tl() != null && this.cw.tl().size() != 0) {
                linkedList.addAll(this.cw.tl());
            }
            if (this.cw.ae() != null && this.cw.ae().size() != 0) {
                linkedList.addAll(this.cw.ae());
            }
        }
        com.bytedance.msdk.xt.cw cwVar2 = null;
        if (linkedList.size() != 0 && cwVar != null) {
            double d6 = Double.MIN_NORMAL;
            for (com.bytedance.msdk.xt.cw cwVar3 : linkedList) {
                if (cwVar3.t() < cwVar.t() && cwVar3.t() > d6) {
                    d6 = cwVar3.t();
                    cwVar2 = cwVar3;
                }
            }
        }
        return cwVar2;
    }

    @DungeonFlag
    private void r(com.bytedance.msdk.xt.cw cwVar) {
        HashMap hashMap;
        if (cwVar == null || this.f25122m == null) {
            return;
        }
        if (TextUtils.equals(cwVar.zz(), "xiaomi")) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put("ecpm", Long.valueOf((long) cwVar.t()));
            cwVar.xt(hashMap2);
            return;
        }
        if (this.f25122m.ed()) {
            if (cwVar.yl() || cwVar.oy() || cwVar.qo()) {
                if (TextUtils.equals(cwVar.zz(), "baidu")) {
                    hashMap = new HashMap();
                    if (com.bytedance.msdk.core.xt.xt().k()) {
                        com.bytedance.msdk.xt.cw cw = cw(cwVar);
                        hashMap.put("ecpm", Integer.valueOf(cw != null ? (int) cw.t() : 0));
                        hashMap.put(SplashAd.KEY_BIDFAIL_ADN, 10);
                        hashMap.put("ad_t", 7);
                        hashMap.put("ad_time", Long.valueOf(System.currentTimeMillis() / 1000));
                        hashMap.put("bid_t", 3);
                    } else if (com.bytedance.msdk.core.xt.xt().ff()) {
                        com.bytedance.msdk.xt.cw cw2 = cw(cwVar);
                        int t5 = cw2 != null ? (int) cw2.t() : 0;
                        int t6 = (int) cwVar.t();
                        int nextInt = new SecureRandom().nextInt(21) + 10;
                        com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "-------baidu_bid_win firstAdEcpm = " + t6 + " secondAdEcpm =" + t5 + " randomNumber = " + nextInt);
                        hashMap.put("ecpm", Integer.valueOf(Math.max(t6 - nextInt, t5)));
                        hashMap.put(SplashAd.KEY_BIDFAIL_ADN, 10);
                        hashMap.put("ad_t", 7);
                        hashMap.put("ad_time", Long.valueOf(System.currentTimeMillis() / 1000));
                        hashMap.put("bid_t", 4);
                    } else {
                        hashMap.put("ecpm", 0);
                        hashMap.put(SplashAd.KEY_BIDFAIL_ADN, 10);
                        hashMap.put("ad_t", 7);
                        hashMap.put("ad_time", Long.valueOf(System.currentTimeMillis() / 1000));
                        hashMap.put("bid_t", 4);
                    }
                } else if (TextUtils.equals(cwVar.zz(), MediationConstant.ADN_KS)) {
                    hashMap = new HashMap();
                    if (com.bytedance.msdk.core.xt.xt().ry()) {
                        com.bytedance.msdk.xt.cw cw3 = cw(cwVar);
                        hashMap.put("bidEcpm", Double.valueOf(cwVar.t()));
                        hashMap.put("lossBidEcpm", Double.valueOf(cw3 != null ? cw3.t() : 0.0d));
                    } else {
                        hashMap.put("bidEcpm", 0);
                        hashMap.put("lossBidEcpm", 0);
                    }
                } else {
                    hashMap = null;
                }
                cwVar.xt(hashMap);
            }
        }
    }

    @Override // com.bytedance.msdk.cw.xt.j.j
    public void j(@Nullable String str) {
    }

    @Override // com.bytedance.msdk.cw.xt.j.j
    public void xt(@NonNull com.bytedance.msdk.api.j jVar) {
    }

    public static int xt(String str) {
        if (!com.bytedance.msdk.core.tl.jy.j().tl(str)) {
            com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, "--==--: 命中展示频次");
            return 840041;
        }
        if (com.bytedance.msdk.core.tl.jy.j().cw(str)) {
            return 0;
        }
        com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, "--==--: 命中展示间隔");
        return 840042;
    }

    public com.bytedance.msdk.api.cw av() {
        List<com.bytedance.msdk.xt.cw> kt;
        com.bytedance.msdk.api.j.xt xtVar = this.f25122m;
        if ((xtVar != null && !xtVar.sm() && !com.bytedance.msdk.core.xt.xt().x()) || (kt = this.cw.kt()) == null || kt.size() == 0) {
            return null;
        }
        return ws.j(this.f25122m, kt.get(0), false);
    }

    public com.bytedance.msdk.api.cw az() {
        if (this.f25123r == null || i.j()) {
            return null;
        }
        return ws.j(this.f25122m, this.f25123r, true);
    }

    protected com.bytedance.msdk.cw.cw.j.ae g() {
        com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "ad load start.....");
        if (com.bytedance.msdk.core.xt.xt().la()) {
            com.bytedance.msdk.up.m.j((com.bytedance.msdk.xt.cw) null, this.cw.mi(), mi.j(), 3);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.bytedance.msdk.cw.cw.j.qv());
        arrayList.add(new com.bytedance.msdk.cw.cw.j.vl());
        arrayList.add(new com.bytedance.msdk.cw.cw.j.up());
        arrayList.add(new com.bytedance.msdk.cw.cw.j.cw());
        arrayList.add(new com.bytedance.msdk.cw.cw.j.jy());
        arrayList.add(new com.bytedance.msdk.cw.cw.j.m());
        arrayList.add(new com.bytedance.msdk.cw.cw.j.tl());
        arrayList.add(new com.bytedance.msdk.cw.cw.j.xt());
        arrayList.add(new com.bytedance.msdk.cw.cw.j.r());
        com.bytedance.msdk.cw.cw.j.ae aeVar = new com.bytedance.msdk.cw.cw.j.ae(arrayList);
        aeVar.j(this.cw);
        return aeVar;
    }

    public int i() {
        com.bytedance.msdk.xt.cw cwVar = this.f25123r;
        if (cwVar != null) {
            return cwVar.rr();
        }
        return -1;
    }

    @Override // com.bytedance.msdk.cw.xt.j.j
    public void j(@Nullable List<com.bytedance.msdk.xt.cw> list, @Nullable com.bytedance.msdk.api.j jVar) {
    }

    public com.bytedance.msdk.api.j.xt kt() {
        return this.f25122m;
    }

    public int mi() {
        com.bytedance.msdk.api.j.xt xtVar = this.f25122m;
        if (xtVar != null) {
            return xtVar.up();
        }
        return 0;
    }

    public List<com.bytedance.msdk.api.xt> oq() {
        return this.cw.ch();
    }

    public Map<String, Object> w() {
        com.bytedance.msdk.xt.cw cwVar = this.f25123r;
        Map<String, Object> p5 = cwVar != null ? cwVar.p() : null;
        if (p5 == null) {
            p5 = cw(this.up);
        }
        com.bytedance.msdk.xt.cw cwVar2 = this.f25123r;
        if (cwVar2 != null && cwVar2.b() != null) {
            p5.putAll(this.f25123r.b());
        }
        if (i.j()) {
            String j6 = i.j(ws.j(this.f25122m, this.f25123r, true));
            if (!TextUtils.isEmpty(j6)) {
                p5.put("get_show_ecpm_info", j6);
            }
        }
        return p5;
    }

    protected List<com.bytedance.msdk.core.oq.oq> ws() {
        com.bytedance.msdk.core.oq.xt xtVar = this.ae;
        if (xtVar == null || xtVar.ol() == null || this.ae.ol().size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (com.bytedance.msdk.core.oq.oq oqVar : this.ae.ol()) {
            if (oqVar != null && oqVar.mi() == 100) {
                arrayList.add(oqVar);
            }
        }
        return arrayList;
    }

    public xt(Context context) {
        this.tl = new SoftReference<>(context);
    }

    protected void j(com.bytedance.msdk.api.j.xt xtVar) {
        com.bytedance.msdk.cw.m.j.xt j6 = com.bytedance.msdk.cw.m.j.xt.j(this.tl, xtVar, this);
        this.cw = j6;
        com.bytedance.msdk.api.j.xt mi = j6.mi();
        this.f25122m = mi;
        this.up = mi.v();
        this.cw.p().put("allow_show_close_btn", Boolean.valueOf(xtVar.w()));
        this.ae = this.cw.vl();
    }

    protected boolean jy() {
        boolean cw = x.cw(com.bytedance.msdk.core.xt.getContext());
        boolean xt = x.xt(com.bytedance.msdk.core.xt.getContext());
        com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, com.bytedance.msdk.j.up.up.j(this.up) + "setting 下发是否为弱网执行：" + com.bytedance.msdk.core.xt.xt().vl() + "，当前网络环境：2G-type=" + cw + ",3G-type=" + xt);
        if (com.bytedance.msdk.core.xt.xt().vl()) {
            if (cw || xt) {
                return true;
            }
            return false;
        }
        return false;
    }

    public List<com.bytedance.msdk.api.cw> qv() {
        if (!com.bytedance.msdk.core.xt.xt().x()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<com.bytedance.msdk.xt.cw> it = this.cw.oq().iterator();
        while (it.hasNext()) {
            com.bytedance.msdk.xt.cw next = it.next();
            if (next != null) {
                arrayList.add(ws.j(this.f25122m, next, false));
            }
        }
        return arrayList;
    }

    public List<com.bytedance.msdk.api.cw> vl() {
        if (!com.bytedance.msdk.core.xt.xt().x()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (com.bytedance.msdk.xt.cw cwVar : this.cw.kt()) {
            if (cwVar != null) {
                arrayList.add(ws.j(this.f25122m, cwVar, false));
            }
        }
        return arrayList;
    }

    public HashMap<String, com.bytedance.msdk.xt.cw> xt(List<com.bytedance.msdk.xt.cw> list) {
        HashMap<String, com.bytedance.msdk.xt.cw> hashMap = new HashMap<>();
        if (list != null && list.size() > 0) {
            for (com.bytedance.msdk.xt.cw cwVar : list) {
                if (cwVar != null) {
                    hashMap.put(cwVar.qa(), cwVar);
                }
            }
        }
        return hashMap;
    }

    public void j() {
        com.bytedance.msdk.xt.cw cwVar = this.f25123r;
        if (cwVar != null) {
            cwVar.w();
        }
        this.cw.ed();
        this.f25120g = null;
    }

    public void xt(com.bytedance.msdk.xt.cw cwVar) {
        com.bytedance.msdk.api.j.xt xtVar = this.f25122m;
        int tl = cwVar.tl(xtVar != null ? xtVar.j() : null);
        cwVar.g(3);
        cwVar.oq(tl);
    }

    public void j(com.bytedance.msdk.xt.cw cwVar) {
        if (com.bytedance.msdk.core.xt.xt().la()) {
            com.bytedance.msdk.up.m.j(cwVar, this.f25122m, mi.j(), 2);
        }
    }

    private com.bytedance.msdk.xt.cw cw(List<com.bytedance.msdk.xt.cw> list) {
        com.bytedance.msdk.xt.cw cwVar = null;
        if (list != null && list.size() != 0) {
            if (list.size() == 1) {
                return list.get(0);
            }
            double d6 = Double.MIN_NORMAL;
            for (com.bytedance.msdk.xt.cw cwVar2 : list) {
                if (cwVar2.t() > d6) {
                    d6 = cwVar2.t();
                    cwVar = cwVar2;
                }
            }
        }
        return cwVar;
    }

    public List<com.bytedance.msdk.core.oq.oq> xt() {
        boolean z5;
        List<com.bytedance.msdk.core.oq.oq> arrayList = new ArrayList<>();
        com.bytedance.msdk.cw.m.j.xt xtVar = this.cw;
        if (xtVar == null || this.ae == null || xtVar.m()) {
            return arrayList;
        }
        Map<Integer, List<com.bytedance.msdk.core.oq.oq>> ch = this.ae.ch();
        ArrayList arrayList2 = new ArrayList();
        for (Integer num : ch.keySet()) {
            if (num != null) {
                arrayList2.add(num);
            }
        }
        com.bytedance.msdk.core.ae.xt.j(arrayList2);
        int i6 = 0;
        if (arrayList2.size() > 0) {
            int i7 = 0;
            z5 = false;
            while (i6 < arrayList2.size()) {
                Integer num2 = (Integer) arrayList2.get(i6);
                if (num2 != null) {
                    int intValue = num2.intValue();
                    if (intValue == -100) {
                        i7 = 1;
                    }
                    if (intValue < -100) {
                        z5 = true;
                    }
                    if (ch.get(num2) != null) {
                        arrayList.addAll(ch.get(num2));
                    }
                }
                i6++;
            }
            i6 = i7;
        } else {
            z5 = false;
        }
        if (i6 == 0 && this.ae.h() && !p.xt(this.cw.oq())) {
            Iterator<com.bytedance.msdk.xt.cw> it = this.cw.oq().iterator();
            while (it.hasNext()) {
                com.bytedance.msdk.xt.cw next = it.next();
                if (this.ae != null && (next.yl() || next.oy())) {
                    com.bytedance.msdk.core.oq.oq m6 = this.ae.m(next.qa());
                    if (m6 != null) {
                        arrayList.add(m6);
                    }
                }
            }
        }
        if (!z5) {
            List<com.bytedance.msdk.core.oq.oq> ws = ws();
            if (!p.j(ws)) {
                arrayList.addAll(ws);
            }
        }
        Iterator<com.bytedance.msdk.core.oq.oq> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            if (it2.next() == null) {
                it2.remove();
            }
        }
        if (!this.ae.p() && !this.ae.h()) {
            Collections.sort(arrayList, this.f25121j);
            return arrayList;
        }
        return r(arrayList);
    }

    @DungeonFlag
    public void j(List<com.bytedance.msdk.xt.cw> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        com.bytedance.msdk.core.r.j.j(this.f25122m, this.ae, list, this.cw.oq());
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            r((com.bytedance.msdk.xt.cw) it.next());
        }
        if (this.cw.oq().size() == 0) {
            return;
        }
        ArrayList<com.bytedance.msdk.xt.cw> arrayList2 = new ArrayList();
        arrayList2.addAll(this.cw.oq());
        com.bytedance.msdk.xt.cw cw = cw(list);
        for (com.bytedance.msdk.xt.cw cwVar : arrayList2) {
            Iterator<com.bytedance.msdk.xt.cw> it2 = list.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    j(cw, cwVar, 1);
                    break;
                }
                com.bytedance.msdk.xt.cw next = it2.next();
                if (next == null || cwVar == null || next != cwVar) {
                }
            }
        }
    }

    public static Map<String, Object> cw(String str) {
        tj tjVar = new tj();
        tjVar.put(MediationConstant.KEY_GM_PRIME_RIT, str);
        return tjVar;
    }

    @Override // com.bytedance.msdk.cw.xt.j.j
    public void ae() {
    }

    @Override // com.bytedance.msdk.cw.xt.j.j
    public void tl() {
    }

    @DungeonFlag
    protected void j(com.bytedance.msdk.xt.cw cwVar, com.bytedance.msdk.xt.cw cwVar2, int i6) {
        if (cwVar2 == null || this.f25122m == null || i6 <= 0) {
            return;
        }
        if (TextUtils.equals(cwVar2.zz(), "xiaomi")) {
            HashMap hashMap = new HashMap();
            hashMap.put("ecpm", Long.valueOf(cwVar != null ? (long) cwVar.t() : 0L));
            hashMap.put(MediationConstant.KEY_REASON, "其他");
            hashMap.put("adn_id", 1);
            cwVar2.j((Map<String, Object>) hashMap);
            return;
        }
        if (this.f25122m.ed()) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put(MediationConstant.BIDDING_LOSE_REASON, com.bytedance.sdk.openadsdk.core.wq.j.xt.j(i6));
            hashMap2.put("bidding_lose_reason_NUM", Integer.valueOf(i6));
            if (TextUtils.equals(cwVar2.zz(), "baidu")) {
                if (com.bytedance.msdk.core.xt.xt().k()) {
                    hashMap2.put("ecpm", Integer.valueOf(cwVar != null ? (int) cwVar.t() : 0));
                    hashMap2.put(SplashAd.KEY_BIDFAIL_ADN, 10);
                    hashMap2.put("ad_t", 7);
                    hashMap2.put("ad_time", Long.valueOf(System.currentTimeMillis() / 1000));
                    hashMap2.put("bid_t", 3);
                    hashMap2.put(MediationConstant.KEY_REASON, 203);
                    hashMap2.put("is_s", 1);
                    hashMap2.put("is_c", 2);
                } else if (com.bytedance.msdk.core.xt.xt().ff()) {
                    hashMap2.put("ecpm", Integer.valueOf(cwVar != null ? (int) cwVar.t() : 0));
                    hashMap2.put(SplashAd.KEY_BIDFAIL_ADN, 10);
                    hashMap2.put("ad_t", 7);
                    hashMap2.put("ad_time", Long.valueOf(System.currentTimeMillis() / 1000));
                    hashMap2.put("bid_t", 4);
                    hashMap2.put(MediationConstant.KEY_REASON, 203);
                    hashMap2.put("is_s", 1);
                    hashMap2.put("is_c", 2);
                } else {
                    hashMap2.put("ecpm", 0);
                    hashMap2.put(SplashAd.KEY_BIDFAIL_ADN, 10);
                    hashMap2.put("ad_t", 7);
                    hashMap2.put("ad_time", Long.valueOf(System.currentTimeMillis() / 1000));
                    hashMap2.put("bid_t", 4);
                    hashMap2.put(MediationConstant.KEY_REASON, 203);
                    hashMap2.put("is_s", 1);
                    hashMap2.put("is_c", 2);
                }
            } else if (TextUtils.equals(cwVar2.zz(), MediationConstant.ADN_KS)) {
                if (com.bytedance.msdk.core.xt.xt().ry()) {
                    hashMap2.put("failureCode", 2);
                    hashMap2.put("bidEcpm", Double.valueOf(cwVar != null ? cwVar.t() : 0.0d));
                    hashMap2.put("adType", 2);
                    hashMap2.put(MediationConstant.KEY_ADN_NAME, "other");
                } else {
                    hashMap2.put("failureCode", 0);
                    hashMap2.put("bidEcpm", 0);
                    hashMap2.put("adType", 2);
                    hashMap2.put(MediationConstant.KEY_ADN_NAME, "other");
                }
            }
            cwVar2.j((Map<String, Object>) hashMap2);
        }
    }

    private List<com.bytedance.msdk.core.oq.oq> r(List<com.bytedance.msdk.core.oq.oq> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator<com.bytedance.msdk.core.oq.oq> it = list.iterator();
        while (it.hasNext()) {
            com.bytedance.msdk.core.oq.oq next = it.next();
            if (next.gq()) {
                it.remove();
                arrayList2.add(next);
            } else if (next.h() || next.rn() || next.la()) {
                it.remove();
                com.bytedance.msdk.core.oq.oq oqVar = new com.bytedance.msdk.core.oq.oq();
                oqVar.up(next.w());
                oqVar.oq(next.mi());
                oqVar.cw(next.az());
                oqVar.r(next.tl());
                oqVar.j(next.ae());
                oqVar.qv(next.x());
                oqVar.vl(next.ch());
                oqVar.g(next.jy());
                StringBuilder sb = new StringBuilder();
                sb.append(next.v());
                oqVar.m(sb.toString());
                oqVar.xt(next.ws());
                oqVar.ae(next.s());
                oqVar.tl(next.a());
                oqVar.j(next.l());
                com.bytedance.msdk.xt.cw j6 = j(oqVar);
                if (j6 != null) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(j6.uq());
                    oqVar.m(sb2.toString());
                }
                arrayList.add(oqVar);
            }
        }
        list.addAll(arrayList);
        Collections.sort(list, this.az);
        Collections.sort(arrayList2, this.f25121j);
        list.addAll(0, arrayList2);
        return list;
    }

    private com.bytedance.msdk.xt.cw j(com.bytedance.msdk.core.oq.oq oqVar) {
        if (oqVar == null) {
            return null;
        }
        String w5 = oqVar.w();
        String cw = oqVar.l() != null ? oqVar.l().cw() : null;
        if (TextUtils.isEmpty(w5)) {
            return null;
        }
        Iterator<com.bytedance.msdk.xt.cw> it = this.cw.ae().iterator();
        while (it.hasNext()) {
            com.bytedance.msdk.xt.cw next = it.next();
            if (next != null && w5.equals(next.qa())) {
                return next;
            }
        }
        Iterator<com.bytedance.msdk.xt.cw> it2 = this.cw.tl().iterator();
        while (it2.hasNext()) {
            com.bytedance.msdk.xt.cw next2 = it2.next();
            if (next2 != null && w5.equals(next2.qa())) {
                return next2;
            }
        }
        Iterator<com.bytedance.msdk.xt.cw> it3 = this.cw.oq().iterator();
        while (it3.hasNext()) {
            com.bytedance.msdk.xt.cw next3 = it3.next();
            if (next3 != null) {
                if (next3.qo() && !TextUtils.isEmpty(cw) && !TextUtils.isEmpty(next3.gx())) {
                    if (w5.equals(next3.qa()) && cw.equals(next3.gx())) {
                        return next3;
                    }
                } else if (w5.equals(next3.qa())) {
                    return next3;
                }
            }
        }
        return null;
    }

    public void j(com.bytedance.msdk.api.r.j.xt xtVar) {
        this.jy = xtVar;
    }

    public void j(com.bytedance.sdk.openadsdk.i.cw.j.xt xtVar) {
        this.ws = xtVar;
    }
}
