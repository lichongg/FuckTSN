package com.bytedance.msdk.cw.m.j;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.msdk.api.r.qv;
import com.bytedance.msdk.core.oq.g;
import com.bytedance.msdk.core.oq.oq;
import com.bytedance.msdk.core.up.xt.r;
import com.bytedance.msdk.j.up.m;
import com.bytedance.msdk.j.up.up;
import com.bytedance.msdk.tl.p;
import com.bytedance.msdk.tl.ws;
import com.bytedance.msdk.xt.cw;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* loaded from: D:\Downloads\app\classes3.dex */
public class xt {

    /* renamed from: a, reason: collision with root package name */
    private r.cw f25011a;
    private com.bytedance.msdk.cw.xt.j.j av;
    private String az;

    /* renamed from: j, reason: collision with root package name */
    protected SoftReference<Context> f25016j;
    private com.bytedance.msdk.core.oq.xt jy;

    /* renamed from: m, reason: collision with root package name */
    protected cw f25018m;

    /* renamed from: p, reason: collision with root package name */
    private long f25019p;
    private com.bytedance.msdk.api.j.xt qv;
    private Handler tj;
    private qv vl;
    private j ws;
    protected CopyOnWriteArrayList<cw> xt = new CopyOnWriteArrayList<>();
    protected CopyOnWriteArrayList<cw> cw = new CopyOnWriteArrayList<>();

    /* renamed from: r, reason: collision with root package name */
    protected CopyOnWriteArrayList<cw> f25020r = new CopyOnWriteArrayList<>();
    protected CopyOnWriteArrayList<cw> up = new CopyOnWriteArrayList<>();

    /* renamed from: i, reason: collision with root package name */
    private final AtomicBoolean f25015i = new AtomicBoolean(false);

    /* renamed from: w, reason: collision with root package name */
    private final AtomicBoolean f25023w = new AtomicBoolean(false);
    private final AtomicBoolean mi = new AtomicBoolean(false);
    private volatile boolean kt = false;
    protected Map<String, com.bytedance.msdk.cw.j.j> ae = new ConcurrentHashMap();
    protected long tl = 0;

    /* renamed from: f, reason: collision with root package name */
    private long f25012f = 0;

    /* renamed from: v, reason: collision with root package name */
    private AtomicBoolean f25022v = new AtomicBoolean(false);

    /* renamed from: x, reason: collision with root package name */
    private boolean f25024x = false;
    private boolean ch = false;

    /* renamed from: s, reason: collision with root package name */
    private boolean f25021s = false;

    /* renamed from: l, reason: collision with root package name */
    private final AtomicInteger f25017l = new AtomicInteger(0);

    /* renamed from: g, reason: collision with root package name */
    protected Map<String, Object> f25013g = new ConcurrentHashMap();
    protected g oq = new g();

    /* renamed from: h, reason: collision with root package name */
    private int f25014h = 0;
    private ConcurrentHashMap<String, com.bytedance.msdk.api.xt> la = new ConcurrentHashMap<>();

    private boolean c() {
        return !this.jy.p() || this.ws.up(0) || this.ws.ae();
    }

    private int gx() {
        List<oq> list;
        com.bytedance.msdk.core.oq.xt xtVar = this.jy;
        int i6 = 0;
        if (xtVar == null) {
            return 0;
        }
        Map<Integer, List<oq>> ch = xtVar.ch();
        if (ch != null && ch.size() != 0) {
            ArrayList<Integer> arrayList = new ArrayList();
            arrayList.addAll(ch.keySet());
            for (Integer num : arrayList) {
                if (this.ws.cw(num.intValue()) && (list = ch.get(num)) != null) {
                    i6 += list.size();
                }
            }
        }
        return i6;
    }

    public void a() {
        this.f25017l.incrementAndGet();
    }

    public CopyOnWriteArrayList<cw> ae() {
        return this.up;
    }

    public boolean av() {
        int size = this.up.size() + this.xt.size() + this.f25020r.size();
        com.bytedance.msdk.api.j.xt xtVar = this.qv;
        return size >= (xtVar != null ? xtVar.a() : 1);
    }

    public boolean az() {
        int size = this.up.size() + this.xt.size();
        com.bytedance.msdk.api.j.xt xtVar = this.qv;
        return size >= (xtVar != null ? xtVar.a() : 1);
    }

    public List<com.bytedance.msdk.api.xt> ch() {
        com.bytedance.msdk.api.xt value;
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, com.bytedance.msdk.api.xt> entry : x().entrySet()) {
            if (entry != null && (value = entry.getValue()) != null && !TextUtils.equals("广告加载成功", value.m()) && !TextUtils.equals("广告请求中", value.m())) {
                arrayList.add(value);
            }
        }
        return arrayList;
    }

    public boolean cw() {
        return this.mi.get();
    }

    public void ed() {
        m.j(new Runnable() { // from class: com.bytedance.msdk.cw.m.j.xt.6
            @Override // java.lang.Runnable
            public void run() {
                xt.this.kt = true;
                CopyOnWriteArrayList<cw> copyOnWriteArrayList = xt.this.xt;
                if (copyOnWriteArrayList != null) {
                    copyOnWriteArrayList.clear();
                }
                CopyOnWriteArrayList<cw> copyOnWriteArrayList2 = xt.this.cw;
                if (copyOnWriteArrayList2 != null) {
                    copyOnWriteArrayList2.clear();
                }
                CopyOnWriteArrayList<cw> copyOnWriteArrayList3 = xt.this.f25020r;
                if (copyOnWriteArrayList3 != null) {
                    copyOnWriteArrayList3.clear();
                }
                CopyOnWriteArrayList<cw> copyOnWriteArrayList4 = xt.this.up;
                if (copyOnWriteArrayList4 != null) {
                    copyOnWriteArrayList4.clear();
                }
                if (xt.this.tj != null) {
                    xt.this.tj.removeCallbacksAndMessages(null);
                }
                xt.this.ws.vl();
                xt.this.vl = null;
                if (xt.this.f25023w.get() || xt.this.f25015i.get()) {
                    return;
                }
                xt.this.j(new com.bytedance.msdk.api.xt.j(41044, com.bytedance.msdk.api.j.j(41044)));
            }
        });
    }

    public boolean f() {
        return this.f25021s;
    }

    public CopyOnWriteArrayList<cw> g() {
        return this.cw;
    }

    public Context getContext() {
        return this.f25016j.get();
    }

    public long gq() {
        return this.f25012f;
    }

    public qv h() {
        return this.vl;
    }

    public boolean i() {
        return !this.jy.h() || this.ws.up(-100) || this.ws.m();
    }

    public j jy() {
        return this.ws;
    }

    public List<cw> kt() {
        ArrayList arrayList = new ArrayList();
        if (!p.j(this.xt)) {
            arrayList.addAll(this.xt);
        }
        if (!p.j(this.f25020r)) {
            arrayList.addAll(this.f25020r);
        }
        com.bytedance.msdk.core.ae.cw.j(arrayList, com.bytedance.msdk.core.ae.cw.j());
        if (!p.j(this.up)) {
            com.bytedance.msdk.core.ae.cw.j(this.up, (Comparator<cw>) null);
            arrayList.addAll(0, this.up);
        }
        return arrayList;
    }

    public long l() {
        return this.f25019p;
    }

    public long la() {
        return this.tl;
    }

    public boolean m() {
        return this.kt;
    }

    public com.bytedance.msdk.api.j.xt mi() {
        return this.qv;
    }

    public CopyOnWriteArrayList<cw> oq() {
        return this.f25020r;
    }

    public Map<String, Object> p() {
        return this.f25013g;
    }

    public cw qv() {
        return this.f25018m;
    }

    public void r() {
        ArrayList arrayList;
        ArrayList arrayList2;
        Map<String, Object> map;
        com.bytedance.msdk.j.up.cw.r(MediationConstant.TAG, up.j(this.jy) + " v2 load done..........s:" + j() + "  f:" + xt() + "     p.size" + ae().size() + "   bidding.size:" + oq().size() + "   normal.size:" + tl().size() + "   underNormal.size:" + g().size());
        if (j() || xt()) {
            return;
        }
        this.f25015i.set(true);
        Handler handler = this.tj;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        List<cw> kt = kt();
        if ((v() || (!v() && !this.ch)) && this.jy != null && !this.qv.sm() && (this.jy.p() || this.jy.h())) {
            cw cwVar = kt.size() > 0 ? kt.get(0) : null;
            int a6 = this.qv.a();
            if (a6 > 1) {
                arrayList = new ArrayList();
                for (int i6 = 1; i6 < a6; i6++) {
                    if (i6 < kt.size()) {
                        arrayList.add(kt.get(i6));
                    }
                }
                if (kt.size() > a6) {
                    arrayList2 = new ArrayList();
                    while (a6 < kt.size()) {
                        cw cwVar2 = kt.get(a6);
                        if (cwVar2 != null && cwVar2.qo()) {
                            arrayList2.add(cwVar2);
                        }
                        a6++;
                    }
                } else {
                    arrayList2 = null;
                }
            } else {
                arrayList = null;
                arrayList2 = null;
            }
            com.bytedance.msdk.up.m.j(cwVar, this.qv, arrayList, arrayList2);
        }
        if (!this.qv.sm() && !this.ch) {
            com.bytedance.msdk.core.g.r.j(this.jy, !p.xt(kt) ? kt.get(0).t() : 0.0d, this.qv.v(), this.qv.f());
        }
        if (v()) {
            up(true);
            return;
        }
        int a7 = kt.size() > this.qv.a() ? this.qv.a() : kt.size();
        com.bytedance.msdk.core.oq.xt xtVar = this.jy;
        if (xtVar != null) {
            Map<String, Object> up = xtVar.up();
            up.put("has_serverBidding", Boolean.valueOf(this.jy.p()));
            map = up;
        } else {
            map = null;
        }
        if (!f()) {
            com.bytedance.msdk.api.j.xt xtVar2 = this.qv;
            cw cwVar3 = this.f25018m;
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.tl;
            int gx = gx();
            int xt = xt(this.ws.qv());
            com.bytedance.msdk.core.oq.xt xtVar3 = this.jy;
            com.bytedance.msdk.up.m.j(map, xtVar2, cwVar3, elapsedRealtime, gx, xt, 0, xtVar3 != null ? xtVar3.hh() : null, a7, this.f25014h, this.jy);
        }
        com.bytedance.msdk.j.up.cw.r(MediationConstant.TAG, up.j(this.jy) + "广告加载成功！给外部回调：invokeAdLoadSuccessOnMainUI........P.size:" + ae().size() + "   bidding.size:" + oq().size() + "   normal.size:" + tl().size());
        m.cw(new Runnable() { // from class: com.bytedance.msdk.cw.m.j.xt.2
            @Override // java.lang.Runnable
            public void run() {
                if (xt.this.av != null) {
                    xt.this.av.ae();
                }
            }
        });
        n();
    }

    public boolean rn() {
        return this.f25022v.get();
    }

    public int s() {
        return this.f25017l.get();
    }

    public Map<String, com.bytedance.msdk.cw.j.j> tj() {
        return this.ae;
    }

    public CopyOnWriteArrayList<cw> tl() {
        return this.xt;
    }

    public String uf() {
        return this.az;
    }

    public void up() {
        if (v() || xt() || cw() || !j()) {
            return;
        }
        com.bytedance.msdk.api.j.xt xtVar = this.qv;
        if (xtVar != null && (xtVar.f() == 7 || this.qv.f() == 8 || this.qv.f() == 10)) {
            com.bytedance.msdk.j.up.cw.cw(MediationConstant.TAG, up.j(this.jy) + "广告缓存成功！给外部回调：invokeAdVideoCacheOnMainUI........");
            com.bytedance.msdk.up.m.j(this.qv, qv(), SystemClock.elapsedRealtime() - gq());
        }
        this.mi.set(true);
        m.cw(new Runnable() { // from class: com.bytedance.msdk.cw.m.j.xt.4
            @Override // java.lang.Runnable
            public void run() {
                if (xt.this.av != null) {
                    xt.this.av.tl();
                }
            }
        });
    }

    public boolean v() {
        return this.f25024x;
    }

    public com.bytedance.msdk.core.oq.xt vl() {
        return this.jy;
    }

    public g wq() {
        return this.oq;
    }

    public boolean ws() {
        int size = this.up.size();
        com.bytedance.msdk.api.j.xt xtVar = this.qv;
        return size >= (xtVar != null ? xtVar.a() : 1);
    }

    public ConcurrentHashMap<String, com.bytedance.msdk.api.xt> x() {
        return this.la;
    }

    public boolean xt() {
        return this.f25023w.get();
    }

    private xt() {
    }

    private void n() {
        if (!v() && !xt() && !cw() && j()) {
            if (nd()) {
                up();
            } else {
                final long j6 = com.bytedance.msdk.core.xt.xt().j(this.qv.f(), this.qv.v());
                m.j(new Runnable() { // from class: com.bytedance.msdk.cw.m.j.xt.7
                    @Override // java.lang.Runnable
                    public void run() {
                        com.bytedance.msdk.j.up.cw.cw(MediationConstant.TAG, up.j(xt.this.jy) + "m-sdk----设置 cacheTimeout 已到时间【" + j6 + "】，给外部invokeAdVideoCache ...");
                        xt.this.up();
                    }
                }, j6);
            }
        }
    }

    private boolean nd() {
        if (ae() != null) {
            Iterator<cw> it = ae().iterator();
            while (it.hasNext()) {
                if (it.next().fp()) {
                    return true;
                }
            }
        }
        if (oq() != null) {
            Iterator<cw> it2 = oq().iterator();
            while (it2.hasNext()) {
                if (it2.next().fp()) {
                    return true;
                }
            }
        }
        if (tl() != null) {
            Iterator<cw> it3 = tl().iterator();
            while (it3.hasNext()) {
                if (it3.next().fp()) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public void cw(boolean z5) {
        this.ch = z5;
    }

    public boolean w() {
        if (i() && c()) {
            return true;
        }
        return false;
    }

    public void xt(boolean z5) {
        this.f25024x = z5;
    }

    public static xt j(SoftReference<Context> softReference, com.bytedance.msdk.api.j.xt xtVar, com.bytedance.msdk.cw.xt.j.j jVar) {
        xt xtVar2 = new xt();
        com.bytedance.msdk.core.oq.xt j6 = com.bytedance.msdk.core.xt.xt().j(xtVar.v(), xtVar.f(), 100);
        xtVar.j(j6);
        xtVar2.qv = xtVar;
        xtVar2.jy = j6;
        if (j6 != null) {
            xtVar2.f25013g.put("render_control", Integer.valueOf(j6.j()));
        }
        xtVar2.qv.r(com.bytedance.msdk.core.xt.xt().rh());
        xtVar2.qv.xt(com.bytedance.msdk.core.xt.xt().g());
        xtVar2.qv.j(com.bytedance.msdk.core.ae.cw.r());
        xtVar2.qv.j(com.bytedance.msdk.core.ae.cw.cw());
        xtVar2.qv.cw(r.j().xt(xtVar2.qv.v(), com.bytedance.msdk.core.xt.xt().rh()));
        xtVar2.oq.cw = com.bytedance.msdk.core.xt.xt().g();
        xtVar2.f25016j = softReference;
        xtVar2.av = jVar;
        xtVar2.ws = new j();
        return xtVar2;
    }

    public void cw(long j6) {
        this.f25012f = j6;
    }

    public void xt(long j6) {
        this.tl = j6;
    }

    public void xt(String str) {
        this.az = str;
    }

    protected int xt(int i6) {
        if (this.ws.j() == null) {
            return -1;
        }
        return this.ws.j().indexOf(Integer.valueOf(i6)) + 1;
    }

    private void up(final boolean z5) {
        m.j(new Runnable() { // from class: com.bytedance.msdk.cw.m.j.xt.8
            @Override // java.lang.Runnable
            public void run() {
                if (xt.this.f25011a != null) {
                    xt.this.f25011a.j(xt.this.qv.v(), z5, 0, null);
                }
            }
        });
    }

    public void j(int i6) {
        this.f25014h = i6;
    }

    public boolean j() {
        return this.f25015i.get();
    }

    public void j(final String str) {
        m.r(new Runnable() { // from class: com.bytedance.msdk.cw.m.j.xt.1
            @Override // java.lang.Runnable
            public void run() {
                if (xt.this.av != null) {
                    xt.this.av.j(str);
                }
            }
        });
    }

    public void j(com.bytedance.msdk.api.j jVar) {
        Handler handler;
        if (jVar == null) {
            jVar = new com.bytedance.msdk.api.j(IjkMediaPlayer.FFP_PROP_INT64_VIDEO_CACHED_DURATION, com.bytedance.msdk.api.j.j(IjkMediaPlayer.FFP_PROP_INT64_VIDEO_CACHED_DURATION));
        }
        if ((!com.bytedance.msdk.tl.xt.j.j(this.jy) || jVar.f24334j != 10003) && (handler = this.tj) != null) {
            handler.removeCallbacksAndMessages(null);
        }
        if (j() || xt()) {
            return;
        }
        this.f25023w.set(true);
        wq().up = true;
        if (!f()) {
            com.bytedance.msdk.up.m.j(this.qv, jVar, this.oq.f24631j);
        }
        if (v()) {
            up(false);
            return;
        }
        com.bytedance.msdk.j.up.cw.r(MediationConstant.TAG, up.j(this.jy) + "广告加载失败！给外部回调：invokeAdLoadFailCallbackOnMainUI...... error Code = " + jVar.f24334j + " error Message = " + jVar.xt);
        final com.bytedance.msdk.api.j j6 = ws.j(this.qv, jVar, ch());
        m.cw(new Runnable() { // from class: com.bytedance.msdk.cw.m.j.xt.3
            @Override // java.lang.Runnable
            public void run() {
                if (xt.this.av != null) {
                    xt.this.av.xt(j6);
                }
            }
        });
    }

    public void j(final List<cw> list, final com.bytedance.msdk.api.j jVar) {
        com.bytedance.msdk.core.oq.xt xtVar = this.jy;
        if (xtVar == null || !xtVar.vl()) {
            return;
        }
        if (m()) {
            jVar = new com.bytedance.msdk.api.j(41044, com.bytedance.msdk.api.j.j(41044));
            list = null;
        }
        if (v()) {
            return;
        }
        if (!p.j(list)) {
            com.bytedance.msdk.j.up.cw.r(MediationConstant.TAG, up.j(this.jy) + "单个广告加载完成！给外部回调：invokeSingleAdLoadCallbackUI......");
            for (cw cwVar : list) {
                com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, up.j(this.qv.v(), "fill") + "AdNetWorkName[" + cwVar.ff() + "] AdUnitId[" + cwVar.qa() + "]  请求成功 (loadSort=" + cwVar.wi() + ",showSort=" + cwVar.d() + ")");
            }
        }
        if (jVar != null) {
            com.bytedance.msdk.j.up.cw.r(MediationConstant.TAG, up.j(this.jy) + "单个广告加载失败！给外部回调：invokeSingleAdLoadCallbackUI...... errorCode:" + jVar.f24334j + "  errorMsg:" + jVar.xt);
        }
        m.cw(new Runnable() { // from class: com.bytedance.msdk.cw.m.j.xt.5
            @Override // java.lang.Runnable
            public void run() {
                if (xt.this.av != null) {
                    xt.this.av.j(list, jVar);
                }
            }
        });
    }

    public void r(boolean z5) {
        this.f25022v.set(z5);
    }

    public void j(cw cwVar) {
        this.f25018m = cwVar;
    }

    public void j(com.bytedance.msdk.core.oq.xt xtVar) {
        this.jy = xtVar;
    }

    public void j(List<cw> list) {
        cw cwVar;
        if (p.j(list) || (cwVar = list.get(0)) == null) {
            return;
        }
        if (cwVar.px()) {
            this.up.addAll(list);
            return;
        }
        if (cwVar.qe()) {
            this.xt.addAll(list);
        } else if (cwVar.qo() || cwVar.oy() || cwVar.yl()) {
            this.f25020r.addAll(list);
        }
    }

    public void j(boolean z5) {
        this.f25021s = z5;
    }

    public void j(ConcurrentHashMap<String, com.bytedance.msdk.api.xt> concurrentHashMap) {
        this.la = concurrentHashMap;
    }

    public void j(r.cw cwVar) {
        this.f25011a = cwVar;
    }

    public void j(long j6) {
        this.f25019p = j6;
    }

    public void j(qv qvVar) {
        this.vl = qvVar;
    }

    public void j(Handler handler) {
        this.tj = handler;
    }

    public void j(g gVar) {
        this.oq = gVar;
    }
}
