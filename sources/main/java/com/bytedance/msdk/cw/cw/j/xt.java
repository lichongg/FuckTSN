package com.bytedance.msdk.cw.cw.j;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.msdk.core.r.r;
import com.bytedance.msdk.cw.cw.j.j;
import com.bytedance.msdk.tl.kt;
import com.bytedance.msdk.tl.la;
import com.bytedance.msdk.tl.p;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* loaded from: D:\Downloads\app\classes3.dex */
public class xt implements j, com.bytedance.msdk.cw.xt.xt.j {
    private String ae;

    /* renamed from: g, reason: collision with root package name */
    private List<Integer> f24848g;

    /* renamed from: j, reason: collision with root package name */
    Map<Integer, List<com.bytedance.msdk.core.oq.oq>> f24849j;

    /* renamed from: m, reason: collision with root package name */
    private com.bytedance.msdk.core.oq.xt f24850m;
    private Handler oq;
    private com.bytedance.msdk.cw.ae.xt.j qv;

    /* renamed from: r, reason: collision with root package name */
    protected long f24851r;
    private com.bytedance.msdk.api.j.xt tl;
    private com.bytedance.msdk.cw.m.j.xt up;
    protected com.bytedance.msdk.cw.m.j.j xt;
    protected final List<com.bytedance.msdk.core.oq.oq> cw = new CopyOnWriteArrayList();
    private boolean vl = false;

    /* JADX INFO: Access modifiers changed from: private */
    public void cw(int i6) {
        if (i6 < 0) {
            return;
        }
        if (!com.bytedance.msdk.cw.tl.m.j(i6, this.f24848g)) {
            r(i6);
            return;
        }
        int hl = this.f24850m.hl();
        com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, com.bytedance.msdk.j.up.up.j(this.f24850m) + "the " + i6 + " level is first level normal ad and ParallelNum:" + hl);
        for (int i7 = 0; i7 < hl; i7++) {
            r(i6 + i7);
        }
    }

    private void r(int i6) {
        if (this.up.j() || up()) {
            com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, com.bytedance.msdk.j.up.up.j(this.f24850m) + "已经触发过成功、失败回调...");
            return;
        }
        if (this.up.m()) {
            com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, com.bytedance.msdk.j.up.up.j(this.f24850m) + "已经触发过destroy操作...");
            return;
        }
        if (xt()) {
            return;
        }
        if (i6 >= this.f24848g.size()) {
            com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, com.bytedance.msdk.j.up.up.j(this.f24850m) + "第 " + i6 + " 层没有广告可以请求...");
            return;
        }
        Integer num = this.f24848g.get(i6);
        int intValue = num.intValue();
        if (this.xt.cw(intValue)) {
            cw(i6 + 1);
            return;
        }
        if (com.bytedance.msdk.cw.tl.m.xt(intValue) && this.xt.xt() == -1) {
            com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, com.bytedance.msdk.j.up.up.j(this.f24850m) + "开启serverBidding exchange 请求....");
            j(this.f24849j.get(num));
            j(i6);
            return;
        }
        this.xt.xt(intValue);
        j(intValue, i6);
        if (com.bytedance.msdk.cw.tl.m.cw(intValue) || com.bytedance.msdk.cw.tl.m.xt(intValue)) {
            com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, com.bytedance.msdk.j.up.up.j(this.f24850m) + "第 " + i6 + "层 ClientBidding,ServerBidding 广告，levelSort：" + intValue + "，同时请求下一层广告...");
            cw(i6 + 1);
        }
    }

    public boolean up() {
        if (this.up.xt()) {
            return (this.vl && com.bytedance.msdk.tl.xt.j.j(this.f24850m)) ? false : true;
        }
        return false;
    }

    @Override // com.bytedance.msdk.cw.cw.j.j
    public void xt(j.InterfaceC0365j interfaceC0365j) {
        ((com.bytedance.msdk.core.r.m) com.bytedance.msdk.core.r.up.j()).j(this.up.uf(), this.f24851r, this.tl, this.f24850m, new r.j() { // from class: com.bytedance.msdk.cw.cw.j.xt.3
            @Override // com.bytedance.msdk.core.r.r.j
            public void j(com.bytedance.msdk.core.r.xt xtVar) {
                Map<Integer, List<com.bytedance.msdk.core.oq.oq>> map = xt.this.f24849j;
                List<com.bytedance.msdk.core.oq.oq> list = map != null ? map.get(0) : null;
                xt xtVar2 = xt.this;
                xtVar2.j(xtVar2.tl, list, xtVar);
            }
        });
    }

    public xt() {
        Looper xt = com.bytedance.msdk.j.up.m.xt();
        if (xt != null) {
            this.oq = new Handler(xt) { // from class: com.bytedance.msdk.cw.cw.j.xt.1
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    xt.this.j(message);
                }
            };
        } else {
            com.bytedance.msdk.j.up.m.j();
            this.oq = new Handler(com.bytedance.msdk.j.up.m.xt()) { // from class: com.bytedance.msdk.cw.cw.j.xt.2
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    xt.this.j(message);
                }
            };
        }
    }

    public boolean xt() {
        return xt(null, 3);
    }

    @Override // com.bytedance.msdk.cw.cw.j.j
    public void j(j.InterfaceC0365j interfaceC0365j) {
        com.bytedance.msdk.cw.m.j.xt j6 = interfaceC0365j.j();
        this.up = j6;
        j6.j(this.oq);
        this.xt = this.up.jy();
        this.f24850m = this.up.vl();
        com.bytedance.msdk.api.j.xt mi = this.up.mi();
        this.tl = mi;
        this.ae = mi.v();
        this.f24849j = this.f24850m.ch();
        ArrayList arrayList = new ArrayList();
        this.f24848g = arrayList;
        arrayList.addAll(this.f24849j.keySet());
        com.bytedance.msdk.core.ae.xt.j(this.f24848g);
        this.xt.j(this.f24848g);
        this.xt.ae(this.f24850m.f());
        List<com.bytedance.msdk.core.oq.oq> j7 = com.bytedance.msdk.cw.tl.m.j(this.f24850m.ol());
        List<com.bytedance.msdk.core.oq.oq> xt = com.bytedance.msdk.cw.tl.m.xt(this.f24850m.ol());
        this.xt.tl(j7 == null ? 0 : j7.size());
        this.xt.g(xt == null ? 0 : xt.size());
        Handler handler = this.oq;
        if (handler != null) {
            handler.sendEmptyMessageDelayed(6, this.f24850m.c());
        }
        if (!this.up.f()) {
            com.bytedance.msdk.up.m.j(this.tl, this.f24850m.hh(), !this.up.v(), this.up.wq().f24631j, 0, (Map<String, Object>) null);
        }
        if (this.f24850m.vl()) {
            interfaceC0365j.j(interfaceC0365j.j());
        } else {
            if (com.bytedance.msdk.j.up.cw.xt()) {
                com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, com.bytedance.msdk.j.up.up.j(this.f24850m) + "开始加载广告 num:" + this.f24850m.f());
            }
            cw(0);
        }
        com.bytedance.msdk.core.ws.xt.j(com.bytedance.msdk.core.xt.xt()).xt(1);
    }

    public boolean xt(com.bytedance.msdk.core.oq.oq oqVar, int i6) {
        if (this.up.j() || up()) {
            return true;
        }
        if (this.xt.up()) {
            com.bytedance.msdk.j.up.cw.r(MediationConstant.TAG, com.bytedance.msdk.j.up.up.j(this.f24850m) + "触发总超时或全部代码位响应结束.....totalTimeout：" + this.xt.up() + "  allWtfFinish:" + this.xt.tl());
            if (p.j(this.up.ae()) && p.j(this.up.tl()) && p.j(this.up.oq())) {
                if (com.bytedance.msdk.tl.xt.j.xt(this.f24850m)) {
                    com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, com.bytedance.msdk.j.up.up.j(this.f24850m) + "总加载时间超时.......isCallback:true");
                    if (com.bytedance.msdk.tl.xt.j.j(this.up, this.f24848g, this.f24849j)) {
                        cw();
                        return true;
                    }
                }
                this.vl = true;
                j(new com.bytedance.msdk.api.j(10003, com.bytedance.msdk.api.j.j(10003)));
            } else {
                cw();
            }
            return true;
        }
        if (this.xt.tl()) {
            com.bytedance.msdk.j.up.cw.r(MediationConstant.TAG, com.bytedance.msdk.j.up.up.j(this.f24850m) + "全部广告完成响应...");
            if (p.j(this.up.ae()) && p.j(this.up.tl()) && p.j(this.up.oq())) {
                j(new com.bytedance.msdk.api.j(IjkMediaPlayer.FFP_PROP_INT64_VIDEO_CACHED_DURATION, com.bytedance.msdk.api.j.j(IjkMediaPlayer.FFP_PROP_INT64_VIDEO_CACHED_DURATION)));
            } else {
                cw();
            }
            return true;
        }
        if (this.up.ws()) {
            com.bytedance.msdk.j.up.cw.r(MediationConstant.TAG, com.bytedance.msdk.j.up.up.j(this.f24850m) + "p层广告已经满足返回条件...");
            cw();
            return true;
        }
        if (!(this.f24850m.p() && this.xt.cw()) && this.f24850m.p()) {
            return false;
        }
        if (oqVar == null) {
            if (this.up.az() && this.up.i()) {
                com.bytedance.msdk.j.up.cw.r(MediationConstant.TAG, com.bytedance.msdk.j.up.up.j(this.f24850m) + "p层&普通层广告 已经满足返回条件 V1 .........");
                cw();
                return true;
            }
            if (!this.up.av() || !this.xt.g() || !this.xt.oq() || !this.up.w()) {
                return false;
            }
            com.bytedance.msdk.j.up.cw.r(MediationConstant.TAG, com.bytedance.msdk.j.up.up.j(this.f24850m) + "p层&普通&Bidding层广告 已经满足返回条件 V2 .........");
            cw();
            return true;
        }
        if (this.up.az() && this.up.i()) {
            Iterator<com.bytedance.msdk.xt.cw> it = this.up.tl().iterator();
            while (it.hasNext()) {
                com.bytedance.msdk.xt.cw next = it.next();
                com.bytedance.msdk.cw.ae.j.j j6 = com.bytedance.msdk.cw.ae.j.r.j(this.f24850m);
                com.bytedance.msdk.cw.m.j.xt xtVar = this.up;
                Map<Integer, List<com.bytedance.msdk.core.oq.oq>> map = this.f24849j;
                if (j6.j(xtVar, next, map == null ? null : map.get(Integer.valueOf(com.bytedance.msdk.cw.tl.m.j(this.f24850m, next))))) {
                    com.bytedance.msdk.j.up.cw.r(MediationConstant.TAG, com.bytedance.msdk.j.up.up.j(this.f24850m) + "p层&普通层广告 已经满足返回条件 V3 .........");
                    cw();
                    return true;
                }
            }
            return false;
        }
        if (!this.up.av() || !this.xt.g() || !this.xt.oq() || !this.up.w()) {
            return false;
        }
        com.bytedance.msdk.j.up.cw.r(MediationConstant.TAG, com.bytedance.msdk.j.up.up.j(this.f24850m) + "p层&普通&Bidding层广告 已经满足返回条件 V4 .........");
        cw();
        return true;
    }

    private void cw(com.bytedance.msdk.core.oq.oq oqVar, int i6) {
        int i7;
        if (oqVar == null || this.oq == null) {
            return;
        }
        if (oqVar.gq()) {
            i7 = 1;
        } else if (oqVar.la() || oqVar.rn()) {
            i7 = 2;
        } else {
            i7 = oqVar.h() ? 3 : 4;
        }
        if (oqVar.uf()) {
            this.oq.removeMessages(i7, kt.j(i6));
        } else {
            this.oq.removeMessages(i7);
        }
    }

    void cw() {
        this.vl = false;
        this.up.r();
    }

    private void cw(List<com.bytedance.msdk.xt.cw> list) {
        if (list == null) {
            return;
        }
        for (com.bytedance.msdk.xt.cw cwVar : list) {
            if (cwVar != null) {
                com.bytedance.msdk.core.up.xt.r.j().j(this.ae, new com.bytedance.msdk.core.up.xt.ae(cwVar, this.up.l(), this.tl));
            }
        }
    }

    void r() {
        this.up.up();
    }

    private void j(int i6, int i7) {
        long ed;
        Handler handler;
        Map<Integer, List<com.bytedance.msdk.core.oq.oq>> map = this.f24849j;
        if (map == null) {
            return;
        }
        final List<com.bytedance.msdk.core.oq.oq> list = map.get(Integer.valueOf(i6));
        StringBuilder sb = new StringBuilder();
        sb.append(com.bytedance.msdk.j.up.up.j(this.f24850m));
        sb.append("loadLevelWaterFall start...执行当前加载层级 ：");
        sb.append(i7);
        sb.append(" levelSort:");
        sb.append(i6);
        sb.append("  waterFallConfig.size:");
        sb.append(list == null ? 0 : list.size());
        com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, sb.toString());
        if (p.j(list)) {
            return;
        }
        this.xt.j(i6, list.size());
        if (com.bytedance.msdk.cw.tl.m.cw(i6)) {
            ed = this.f24850m.kt();
        } else {
            ed = this.f24850m.ed();
        }
        Message obtain = Message.obtain();
        if (com.bytedance.msdk.cw.tl.m.j(i6)) {
            obtain.what = 1;
        } else if (com.bytedance.msdk.cw.tl.m.cw(i6)) {
            obtain.what = 2;
        } else if (com.bytedance.msdk.cw.tl.m.xt(i6)) {
            obtain.what = 3;
        } else {
            obtain.what = 4;
            obtain.obj = kt.j(i6);
        }
        obtain.arg1 = i6;
        Handler handler2 = this.oq;
        if (handler2 != null) {
            handler2.sendMessageDelayed(obtain, ed);
        }
        long uf = this.f24850m.uf();
        if (uf != 0 && (handler = this.oq) != null) {
            handler.removeMessages(5);
            this.oq.sendEmptyMessageDelayed(5, uf);
        }
        for (final int i8 = 0; i8 < list.size(); i8++) {
            try {
                com.bytedance.msdk.j.up.m.r(new Runnable() { // from class: com.bytedance.msdk.cw.cw.j.xt.4
                    @Override // java.lang.Runnable
                    public void run() {
                        xt.this.j((com.bytedance.msdk.core.oq.oq) list.get(i8), list.size());
                    }
                });
                if (this.up.v()) {
                    this.up.a();
                }
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.vl.j(th);
            }
        }
    }

    protected int xt(int i6) {
        int indexOf;
        List<Integer> list = this.f24848g;
        if (list == null || (indexOf = list.indexOf(Integer.valueOf(i6))) == -1) {
            return -1;
        }
        return indexOf + 1;
    }

    private void xt(List<com.bytedance.msdk.xt.cw> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        String qa = list.get(0).qa();
        if (list.get(0).ll() && com.bytedance.msdk.core.up.j.j.j().up(this.ae, qa, this.tl.up()) == 1) {
            ArrayList arrayList = new ArrayList();
            for (com.bytedance.msdk.xt.cw cwVar : list) {
                if (cwVar != null) {
                    arrayList.add(new com.bytedance.msdk.core.up.xt.ae(cwVar, 0L, this.tl));
                }
            }
            if (arrayList.size() > 0) {
                com.bytedance.msdk.xt.cw cwVar2 = ((com.bytedance.msdk.core.up.xt.ae) arrayList.get(0)).f24739j;
                com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "--==-- 广告复用:广告缓存成功 -------" + cwVar2.ff() + ", adType: " + com.bytedance.msdk.xt.j.j(cwVar2.om(), cwVar2.rh()) + ", adnSlotId: " + cwVar2.qa() + ", ad个数: " + arrayList.size());
                com.bytedance.msdk.core.up.j.j.j().j(qa, (List<com.bytedance.msdk.core.up.xt.ae>) arrayList, false);
            }
        }
    }

    protected void j(com.bytedance.msdk.core.oq.oq oqVar, int i6) {
        xt xtVar;
        if (oqVar == null || this.tl == null) {
            xtVar = this;
        } else {
            xtVar = this;
            xtVar.j(oqVar.w(), oqVar.az(), oqVar.av(), com.bytedance.msdk.xt.j.j(this.tl.f(), oqVar.m()), 0, "广告请求中");
        }
        com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, com.bytedance.msdk.j.up.up.j(xtVar.f24850m) + "开始 某一层级的waterFallConfig请求 WaterFallConfig:" + oqVar.toString());
        com.bytedance.msdk.cw.m.xt.xt j6 = com.bytedance.msdk.cw.m.xt.xt.j(oqVar, this);
        j6.cw(1);
        j6.xt(1);
        j6.j(i6);
        j6.j(!xtVar.up.v());
        j6.j(SystemClock.elapsedRealtime());
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.bytedance.msdk.cw.cw.xt.xt());
        arrayList.add(new com.bytedance.msdk.cw.cw.xt.r());
        arrayList.add(new com.bytedance.msdk.cw.cw.xt.m());
        arrayList.add(new com.bytedance.msdk.cw.cw.xt.cw());
        new com.bytedance.msdk.cw.cw.xt.up(arrayList).j(xtVar.up, j6);
    }

    protected void j(final List<com.bytedance.msdk.core.oq.oq> list) {
        final Context context = this.up.getContext();
        if (context != null) {
            com.bytedance.msdk.j.up.m.r(new Runnable() { // from class: com.bytedance.msdk.cw.cw.j.xt.5
                @Override // java.lang.Runnable
                public void run() {
                    xt xtVar = xt.this;
                    xtVar.j(context, xtVar.tl, list, !xt.this.up.v());
                }
            });
        }
    }

    public void j(final int i6) {
        com.bytedance.msdk.cw.ae.xt.j j6 = com.bytedance.msdk.cw.ae.xt.up.j(this.f24850m);
        this.qv = j6;
        Handler handler = this.oq;
        com.bytedance.msdk.core.oq.xt xtVar = this.f24850m;
        j6.j(handler, xtVar, new com.bytedance.msdk.cw.ae.xt.xt(xtVar, new Runnable() { // from class: com.bytedance.msdk.cw.cw.j.xt.6
            @Override // java.lang.Runnable
            public void run() {
                xt.this.cw(i6 + 1);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(Message message) {
        int i6 = message.arg1;
        switch (message.what) {
            case 1:
            case 4:
                StringBuilder sb = new StringBuilder();
                sb.append(com.bytedance.msdk.j.up.up.j(this.f24850m));
                sb.append(message.what == 1 ? "P层" : "普通层");
                sb.append("广告触发层超时.........levelSort:");
                sb.append(i6);
                com.bytedance.msdk.j.up.cw.r(MediationConstant.TAG, sb.toString());
                this.xt.r(i6);
                if (!xt()) {
                    cw(xt(i6));
                    break;
                }
                break;
            case 2:
            case 3:
                StringBuilder sb2 = new StringBuilder();
                sb2.append(com.bytedance.msdk.j.up.up.j(this.f24850m));
                sb2.append(message.what == 2 ? "ClientBidding层" : "ServerBidding层层");
                sb2.append("广告触发层超时.........levelSort:");
                sb2.append(i6);
                com.bytedance.msdk.j.up.cw.r(MediationConstant.TAG, sb2.toString());
                this.xt.r(i6);
                xt();
                break;
            case 5:
                com.bytedance.msdk.j.up.cw.r(MediationConstant.TAG, com.bytedance.msdk.j.up.up.j(this.f24850m) + "触发最小层超时.........levelSort:" + i6);
                xt();
                break;
            case 6:
                com.bytedance.msdk.j.up.cw.r(MediationConstant.TAG, com.bytedance.msdk.j.up.up.j(this.f24850m) + "触发总超时.........");
                this.xt.r();
                this.up.wq().f24632m = true;
                xt();
                break;
        }
    }

    @Override // com.bytedance.msdk.cw.xt.xt.j
    public void j(List<com.bytedance.msdk.xt.cw> list, com.bytedance.msdk.core.oq.oq oqVar) {
        if (p.j(list) || oqVar == null) {
            return;
        }
        j(list, this.f24850m);
        j(oqVar.w(), oqVar.az(), oqVar.av(), com.bytedance.msdk.xt.j.j(oqVar.jy(), oqVar.m()), 0, "广告加载成功");
        com.bytedance.msdk.core.ae.cw.j(this.ae, oqVar, !p.xt(list) ? list.get(0) : null);
        xt(list);
        int j6 = com.bytedance.msdk.cw.tl.m.j(this.f24850m, oqVar);
        if (oqVar.uf() && com.bytedance.msdk.cw.ae.j.j(this.xt, this.cw, oqVar.w())) {
            com.bytedance.msdk.j.up.cw.r(MediationConstant.TAG, com.bytedance.msdk.j.up.up.j(this.f24850m) + "返回的普通广告被server Bidding过滤了......slotId:" + oqVar.w());
            this.up.g().addAll(list);
            return;
        }
        com.bytedance.msdk.cw.tl.j.j(this.up, list, false);
        this.xt.j(j6, oqVar.w());
        if (this.up.v()) {
            cw(list);
        }
        if (this.xt.up()) {
            j((List<com.bytedance.msdk.xt.cw>) null, new com.bytedance.msdk.api.j(10012, "load ad timeout !!!"));
        } else {
            j(list, (com.bytedance.msdk.api.j) null);
        }
        this.up.j(list);
        if (xt(oqVar, 1) || this.xt.m(j6) != 0 || oqVar.wq()) {
            return;
        }
        int xt = xt(j6);
        cw(oqVar, j6);
        com.bytedance.msdk.j.up.cw.r(MediationConstant.TAG, com.bytedance.msdk.j.up.up.j(this.f24850m) + "onAdLoaded levelSort: " + j6 + " 广告全部响应结束&不满足返回条件，直接请求下一层广告 nextIdx：" + xt);
        cw(xt);
    }

    @Override // com.bytedance.msdk.cw.xt.xt.j
    public void j(com.bytedance.msdk.api.j jVar, com.bytedance.msdk.core.oq.oq oqVar) {
        xt xtVar;
        if (oqVar == null) {
            return;
        }
        j((List<com.bytedance.msdk.xt.cw>) null, jVar);
        if (jVar != null) {
            xtVar = this;
            xtVar.j(oqVar.w(), oqVar.i(), oqVar.av(), com.bytedance.msdk.xt.j.j(oqVar.jy(), oqVar.m()), jVar.cw, jVar.f24335r);
        } else {
            xtVar = this;
        }
        com.bytedance.msdk.core.ae.cw.j(jVar, oqVar);
        if (oqVar.uf() && com.bytedance.msdk.cw.ae.j.j(xtVar.xt, xtVar.cw, oqVar.w())) {
            return;
        }
        int j6 = com.bytedance.msdk.cw.tl.m.j(xtVar.f24850m, oqVar);
        xtVar.xt.j(j6, oqVar.w());
        if (xt(oqVar, 2) || xtVar.xt.up(j6) || xtVar.xt.m(j6) != 0 || oqVar.wq()) {
            return;
        }
        int xt = xt(j6);
        cw(oqVar, j6);
        com.bytedance.msdk.j.up.cw.r(MediationConstant.TAG, com.bytedance.msdk.j.up.up.j(xtVar.f24850m) + "onAdFailed levelSort " + j6 + " 广告全部响应结束&不满足返回条件，直接请求下一层广告 nextIdx：" + xt);
        cw(xt);
    }

    @Override // com.bytedance.msdk.cw.xt.xt.j
    public void j() {
        com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, com.bytedance.msdk.j.up.up.j(this.f24850m) + "onAdVideoCache.....");
        r();
    }

    void j(com.bytedance.msdk.api.j jVar) {
        this.up.j(jVar);
    }

    void j(List<com.bytedance.msdk.xt.cw> list, com.bytedance.msdk.api.j jVar) {
        this.up.j(list, jVar);
    }

    protected void j(Context context, final com.bytedance.msdk.api.j.xt xtVar, final List<com.bytedance.msdk.core.oq.oq> list, boolean z5) {
        com.bytedance.msdk.core.r.r j6 = com.bytedance.msdk.core.r.up.j();
        if (j6 != null) {
            this.xt.j(0);
            this.up.wq().f24633r = true;
            com.bytedance.msdk.core.r.cw cwVar = new com.bytedance.msdk.core.r.cw();
            cwVar.f24679j = xtVar;
            cwVar.xt = list;
            cwVar.f24681r = this.f24850m;
            cwVar.f24680m = z5;
            cwVar.up = xtVar != null ? xtVar.cw() : 1;
            j6.j(this.up.tj(), context, cwVar, new r.j() { // from class: com.bytedance.msdk.cw.cw.j.xt.7
                @Override // com.bytedance.msdk.core.r.r.j
                public void j(com.bytedance.msdk.core.r.xt xtVar2) {
                    xt.this.j(xtVar, list, xtVar2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(com.bytedance.msdk.api.j.xt xtVar, List<com.bytedance.msdk.core.oq.oq> list, com.bytedance.msdk.core.r.xt xtVar2) {
        com.bytedance.msdk.cw.ae.xt.j jVar;
        if (this.up != null && xtVar2 != null && !TextUtils.isEmpty(xtVar2.f24692r)) {
            this.up.wq().f24631j = xtVar2.f24692r;
        }
        com.bytedance.msdk.core.oq.xt xtVar3 = this.f24850m;
        if (xtVar3 != null && xtVar2 != null) {
            xtVar3.up().put("price_source", Integer.valueOf(xtVar2.jy));
        }
        if (xtVar2 != null) {
            com.bytedance.msdk.up.m.j(xtVar, xtVar2, this.xt.up() ? 1 : 0);
        }
        if (xtVar2 != null && !p.j(xtVar2.xt)) {
            this.xt.j(1);
            if (this.up.j() || this.up.xt()) {
                return;
            }
            this.cw.clear();
            this.cw.addAll(xtVar2.xt);
            Handler handler = this.oq;
            if (handler != null) {
                handler.removeMessages(1);
                this.oq.removeMessages(4);
                this.oq.removeMessages(5);
            }
            la.j(xtVar2.xt);
            this.f24849j = com.bytedance.msdk.cw.tl.m.j(xtVar2.xt, this.f24850m.qv());
            ArrayList arrayList = new ArrayList();
            this.f24848g = arrayList;
            arrayList.addAll(this.f24849j.keySet());
            com.bytedance.msdk.core.ae.xt.j(this.f24848g);
            this.xt.j(this.f24848g);
            this.xt.j(xtVar2.xt, com.bytedance.msdk.cw.tl.m.j(this.f24850m.ol()), com.bytedance.msdk.cw.tl.m.cw(this.f24850m.ol()));
            com.bytedance.msdk.cw.ae.j.j(this.f24850m, this.up, xtVar2.xt);
            com.bytedance.msdk.j.up.cw.r(MediationConstant.TAG, com.bytedance.msdk.j.up.up.j(this.f24850m) + "serverBidding响应回来..........开始从头开始请求waterFallConfig  代码位总数量：" + xtVar2.xt.size());
            cw(0);
            xt();
        } else {
            this.xt.j(2);
            if (this.up.j() || this.up.xt()) {
                return;
            }
            com.bytedance.msdk.j.up.cw.r(MediationConstant.TAG, com.bytedance.msdk.j.up.up.j(this.f24850m) + "serverBidding响应失败了.......... ");
            this.xt.xt(0);
            if (list != null) {
                int size = list.size();
                for (int i6 = 0; i6 < size; i6++) {
                    com.bytedance.msdk.core.oq.oq oqVar = list.get(i6);
                    this.xt.j(com.bytedance.msdk.cw.tl.m.j(this.f24850m, oqVar), oqVar.w());
                }
            }
            if (!xt() && (jVar = this.qv) != null) {
                jVar.j();
            }
        }
        if (this.f24850m != null && xtVar2 != null) {
            com.bytedance.msdk.core.g.xt.r().j(xtVar2.vl, xtVar2.ws, this.f24850m.rn(), this.f24850m.la());
        }
        if (xtVar2 == null || !xtVar2.cw) {
            return;
        }
        com.bytedance.msdk.core.ws.xt.j(com.bytedance.msdk.core.xt.xt()).j().xt(1);
    }

    protected void j(List<com.bytedance.msdk.xt.cw> list, com.bytedance.msdk.core.oq.xt xtVar) {
        com.bytedance.msdk.core.g.r.j(list, xtVar);
        com.bytedance.msdk.core.xt.j.j(list, xtVar);
    }

    protected void j(String str, String str2, String str3, String str4, int i6, String str5) {
        com.bytedance.msdk.api.xt xtVar = this.up.x().get(str);
        if (xtVar == null) {
            xtVar = new com.bytedance.msdk.api.xt();
        }
        xtVar.xt(str).cw(str2).r(str3).j(i6).up(str5).j(str4);
        this.up.x().put(str, xtVar);
    }
}
