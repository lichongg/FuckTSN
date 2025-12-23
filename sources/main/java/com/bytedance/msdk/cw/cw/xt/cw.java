package com.bytedance.msdk.cw.cw.xt;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.msdk.core.oq.g;
import com.bytedance.msdk.core.oq.oq;
import com.bytedance.msdk.core.tl.ws;
import com.bytedance.msdk.cw.cw.xt.j;
import com.bytedance.msdk.tl.h;
import com.bytedance.msdk.tl.mi;
import com.bytedance.msdk.tl.p;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\Downloads\app\classes3.dex */
public class cw implements j, com.bytedance.msdk.cw.j.xt {
    private long ae;
    private com.bytedance.msdk.api.j.xt cw;

    /* renamed from: j, reason: collision with root package name */
    private com.bytedance.msdk.cw.m.xt.xt f24859j;

    /* renamed from: m, reason: collision with root package name */
    private long f24860m;

    /* renamed from: r, reason: collision with root package name */
    private com.bytedance.msdk.cw.j.j f24861r = null;
    private volatile long up = -1;
    private com.bytedance.msdk.cw.m.j.xt xt;

    private void cw(List<com.bytedance.msdk.xt.cw> list) {
        com.bytedance.msdk.cw.m.xt.xt xtVar = this.f24859j;
        if (xtVar != null) {
            xtVar.j(list, xtVar.tl());
        }
        j(new Runnable() { // from class: com.bytedance.msdk.cw.cw.xt.cw.2
            @Override // java.lang.Runnable
            public void run() {
                if (cw.this.f24859j != null) {
                    com.bytedance.msdk.core.cw.cw.cw(cw.this.f24859j.jy(), cw.this.f24859j.xt(), cw.this.f24859j.vl());
                }
            }
        });
    }

    private List<com.bytedance.msdk.xt.cw> xt(List<com.bytedance.msdk.xt.cw> list) {
        List<com.bytedance.msdk.xt.cw> list2;
        String str;
        long j6;
        ArrayList arrayList = new ArrayList();
        if (p.j(list)) {
            list2 = list;
        } else {
            list2 = list;
            arrayList.addAll(list2);
        }
        if (this.f24859j != null && !p.xt(list2) && (this.f24859j.j() || this.f24859j.x())) {
            for (com.bytedance.msdk.xt.cw cwVar : list2) {
                h.j(cwVar, this.f24859j.tl(), this.cw, true);
                double z5 = this.cw.z();
                if (z5 > 0.0d && z5 > cwVar.t()) {
                    arrayList.remove(cwVar);
                    String valueOf = String.valueOf(cwVar.t());
                    String q5 = cwVar.q();
                    long currentTimeMillis = System.currentTimeMillis();
                    if (mi.j(this.f24859j.tl())) {
                        str = mi.xt();
                        j6 = System.currentTimeMillis() - currentTimeMillis;
                    } else {
                        str = null;
                        j6 = -1;
                    }
                    com.bytedance.msdk.up.m.j(new com.bytedance.msdk.api.j(50100, com.bytedance.msdk.api.j.j(50100)), this.cw, this.f24859j.tl(), this.f24859j.cw(), this.f24859j.ae(), this.f24859j.m(), j(this.f24859j.jy()), this.f24860m, valueOf, q5, str, j6);
                }
            }
        }
        return arrayList;
    }

    @Override // com.bytedance.msdk.cw.j.xt
    public void j(List<com.bytedance.msdk.xt.cw> list) {
        cw cwVar;
        String str;
        if (list == null) {
            return;
        }
        long j6 = -1;
        if (this.up == -1) {
            this.up = SystemClock.elapsedRealtime();
        }
        this.f24860m = System.currentTimeMillis() - this.ae;
        Iterator<com.bytedance.msdk.xt.cw> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            com.bytedance.msdk.xt.cw next = it.next();
            com.bytedance.msdk.api.j.xt xtVar = this.cw;
            com.bytedance.msdk.cw.m.xt.xt xtVar2 = this.f24859j;
            com.bytedance.msdk.cw.m.j.xt xtVar3 = this.xt;
            g wq = xtVar3 != null ? xtVar3.wq() : null;
            com.bytedance.msdk.cw.m.xt.xt xtVar4 = this.f24859j;
            com.bytedance.msdk.cw.tl.cw.j(next, xtVar, xtVar2, wq, xtVar4 != null ? j(xtVar4.jy()) : "");
        }
        List<com.bytedance.msdk.xt.cw> xt = xt(list);
        if (xt.size() == 0) {
            j(new com.bytedance.msdk.api.j(50100, com.bytedance.msdk.api.j.j(50100)), false);
            return;
        }
        if (this.f24859j != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (mi.j(this.f24859j.tl())) {
                String xt2 = mi.xt();
                j6 = System.currentTimeMillis() - currentTimeMillis;
                str = xt2;
            } else {
                str = null;
            }
            long j7 = j6;
            int i6 = list.size() > 0 ? 20000 : 820001;
            if (this.f24859j.j() || this.f24859j.x()) {
                for (com.bytedance.msdk.xt.cw cwVar2 : list) {
                    if (cwVar2 != null) {
                        j(i6, cwVar2, 1, str, j7);
                    }
                }
                cwVar = this;
            } else {
                cwVar = this;
                cwVar.j(i6, xt.get(0), xt.size(), str, j7);
            }
            if (cwVar.f24859j.v() && !p.xt(list)) {
                com.bytedance.msdk.up.m.j(list.get(0), cwVar.cw, cwVar.f24859j.tl(), cwVar.f24860m);
            }
        } else {
            cwVar = this;
        }
        cw(xt);
        if (cwVar.f24859j.tl() != null && cwVar.f24859j.tl().jy() == 10 && cwVar.f24859j.tl().m() == 1) {
            j(xt, (com.bytedance.msdk.api.j) null);
        }
    }

    private void xt(com.bytedance.msdk.api.j jVar) {
        com.bytedance.msdk.cw.m.xt.xt xtVar = this.f24859j;
        if (xtVar != null) {
            xtVar.j(jVar, xtVar.tl());
        }
    }

    private void xt() {
        com.bytedance.msdk.cw.m.xt.xt xtVar;
        com.bytedance.msdk.cw.m.xt.xt xtVar2 = this.f24859j;
        xtVar2.j(com.bytedance.msdk.cw.tl.cw.j(this.cw, xtVar2));
        this.f24859j.xt(this.xt.vl().rn());
        if (!this.f24859j.oq()) {
            if (this.f24859j.qv()) {
                this.f24861r = com.bytedance.msdk.cw.cw.xt.j.r.j(this.f24859j, this);
            } else if (com.bytedance.msdk.core.ae.cw.j(this.f24859j.tl())) {
                this.f24861r = new com.bytedance.msdk.cw.cw.xt.j.cw(this);
            }
        } else {
            Context context = com.bytedance.msdk.core.xt.getContext();
            com.bytedance.msdk.cw.m.xt.xt xtVar3 = this.f24859j;
            com.bytedance.msdk.m.xt.j(context, xtVar3 != null ? xtVar3.jy() : "");
            if (com.bytedance.msdk.m.xt.j.j(this.f24859j.jy()) == null) {
                com.bytedance.msdk.up.m.j("", this.xt.qv(), this.cw, this.f24859j.tl(), new com.bytedance.msdk.api.j(49014, "创建自定义广告对象 configuration is null"));
            } else {
                com.bytedance.msdk.core.oq.j j6 = com.bytedance.msdk.ae.j.xt.j().j(this.f24859j.jy());
                if (j6 == null) {
                    com.bytedance.msdk.up.m.j("", (com.bytedance.msdk.xt.cw) null, (com.bytedance.msdk.api.j.xt) null, (oq) null, new com.bytedance.msdk.api.j(49013, "创建自定义广告对象 adNetworkConfValue is null"));
                } else if (j6.cw() == null) {
                    com.bytedance.msdk.up.m.j("", (com.bytedance.msdk.xt.cw) null, (com.bytedance.msdk.api.j.xt) null, (oq) null, new com.bytedance.msdk.api.j(49013, "创建自定义广告对象 getGMCustomConfig is null"));
                } else {
                    com.bytedance.msdk.api.r.j.xt.cw.j j7 = j6.cw().j(this.f24859j.s(), this.f24859j.az());
                    if (j7 == null) {
                        com.bytedance.msdk.up.m.j("", (com.bytedance.msdk.xt.cw) null, (com.bytedance.msdk.api.j.xt) null, (oq) null, new com.bytedance.msdk.api.j(49013, "创建自定义广告对象 adConfig is null"));
                    } else if (com.bytedance.msdk.cw.tl.cw.j(j7)) {
                        this.f24861r = com.bytedance.msdk.cw.cw.xt.j.r.j(j7.j(), this.f24859j, this);
                    } else {
                        com.bytedance.msdk.up.m.j("", (com.bytedance.msdk.xt.cw) null, (com.bytedance.msdk.api.j.xt) null, (oq) null, new com.bytedance.msdk.api.j(49013, "创建自定义广告对象 check className false className is " + j7.j()));
                    }
                }
            }
        }
        com.bytedance.msdk.cw.j.j jVar = this.f24861r;
        if (jVar != null) {
            String j8 = jVar.j(this.f24859j.jy());
            if (!TextUtils.isEmpty(j8) && (xtVar = this.f24859j) != null && !TextUtils.isEmpty(xtVar.vl()) && !this.f24859j.oq()) {
                com.bytedance.msdk.core.up.j.j.j().r(this.f24859j.vl(), j8);
            }
            j(this.f24859j, this.xt, null, j8);
            com.bytedance.msdk.cw.j.j jVar2 = this.f24861r;
            Context context2 = this.xt.getContext();
            com.bytedance.msdk.cw.m.xt.xt xtVar4 = this.f24859j;
            com.bytedance.msdk.api.j.xt xtVar5 = this.cw;
            jVar2.j(context2, xtVar4, xtVar5, com.bytedance.msdk.cw.tl.cw.j(xtVar4, xtVar5, this.xt.p()));
            if (this.f24859j.oq()) {
                return;
            }
            com.bytedance.msdk.core.up.j.j.j().j(this.f24859j.xt(), this.f24859j.vl(), this.f24859j.tl(), this.f24859j.cw());
            return;
        }
        com.bytedance.msdk.j.up.cw.r(MediationConstant.TAG, "**********【重要】" + this.f24859j.jy() + "创建失败，请检查adapter是否接入 **********");
        com.bytedance.msdk.up.m.j(this.f24859j.tl(), this.cw, this.f24859j.ae(), this.f24859j.m());
        j(this.f24859j, this.xt, new com.bytedance.msdk.api.j("create adn loader fail"), "");
        j(new com.bytedance.msdk.api.j("create adn loader fail"));
    }

    @Override // com.bytedance.msdk.cw.j.xt
    public void j(com.bytedance.msdk.api.j jVar) {
        j(jVar, true);
    }

    private void j(com.bytedance.msdk.api.j jVar, boolean z5) {
        long j6;
        String str;
        com.bytedance.msdk.api.j jVar2;
        this.f24860m = System.currentTimeMillis() - this.ae;
        com.bytedance.msdk.cw.m.xt.xt xtVar = this.f24859j;
        if (xtVar != null && xtVar.tl() != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (mi.j(this.f24859j.tl())) {
                String xt = mi.xt();
                j6 = System.currentTimeMillis() - currentTimeMillis;
                str = xt;
            } else {
                j6 = -1;
                str = null;
            }
            long j7 = j6;
            if (!this.f24859j.v() && z5) {
                jVar2 = jVar;
                com.bytedance.msdk.up.m.j(jVar2, this.cw, this.f24859j.tl(), this.f24859j.cw(), this.f24859j.ae(), this.f24859j.m(), j(this.f24859j.jy()), this.f24860m, (String) null, (String) null, str, j7);
            } else {
                jVar2 = jVar;
                com.bytedance.msdk.up.m.j(jVar2, this.cw, this.f24859j.tl(), this.f24859j.cw(), this.f24859j.ae(), this.f24859j.m(), j(this.f24859j.jy()), this.f24860m);
            }
            oq tl = this.f24859j.tl();
            if (jVar2 != null) {
                if (this.cw != null) {
                    if (com.bytedance.msdk.xt.xt.xt) {
                        StringBuilder sb = new StringBuilder();
                        com.bytedance.msdk.api.j.xt xtVar2 = this.cw;
                        sb.append(com.bytedance.msdk.j.up.up.j(xtVar2 != null ? xtVar2.v() : "", "fill_fail"));
                        sb.append("AdNetWorkName[");
                        sb.append(tl.az());
                        sb.append("] AdUnitId[");
                        sb.append(tl.w());
                        sb.append("] AdType[");
                        sb.append(com.bytedance.msdk.xt.j.j(this.cw.f(), tl.m(), tl));
                        sb.append("] 请求失败 (loadSort=");
                        sb.append(tl.x());
                        sb.append(",showSort=");
                        sb.append(tl.ch());
                        sb.append("),error=");
                        sb.append(jVar2.cw);
                        sb.append(",msg=");
                        sb.append(jVar2.f24335r);
                        com.bytedance.msdk.j.up.cw.r(MediationConstant.TAG, sb.toString());
                    } else {
                        StringBuilder sb2 = new StringBuilder();
                        com.bytedance.msdk.api.j.xt xtVar3 = this.cw;
                        sb2.append(com.bytedance.msdk.j.up.up.j(xtVar3 != null ? xtVar3.v() : "", "fill_fail"));
                        sb2.append("AdNetWorkName[");
                        sb2.append(tl.az());
                        sb2.append("] AdType[");
                        sb2.append(com.bytedance.msdk.xt.j.j(this.cw.f(), tl.m(), tl));
                        sb2.append("] 请求失败 error=");
                        sb2.append(jVar2.cw);
                        sb2.append(",msg=");
                        sb2.append(jVar2.f24335r);
                        com.bytedance.msdk.j.up.cw.r(MediationConstant.TAG, sb2.toString());
                    }
                }
                StringBuilder sb3 = new StringBuilder();
                sb3.append(jVar2.cw);
                String sb4 = sb3.toString();
                String j8 = com.bytedance.msdk.j.j.j(this.f24859j.tl().az(), jVar2.f24335r);
                ws j9 = ws.j();
                com.bytedance.msdk.api.j.xt xtVar4 = this.cw;
                if (j9.j(xtVar4 == null ? null : xtVar4.v(), this.f24859j.tl().i())) {
                    ws j10 = ws.j();
                    com.bytedance.msdk.api.j.xt xtVar5 = this.cw;
                    j10.j(xtVar5 != null ? xtVar5.v() : null, this.f24859j.tl().az(), this.f24859j.tl().w(), com.bytedance.msdk.j.j.j(this.f24859j.tl().az(), sb4, j8));
                } else {
                    com.bytedance.msdk.core.tl.cw.j().j(this.f24859j.tl().az(), this.f24859j.tl().w(), com.bytedance.msdk.j.j.j(this.f24859j.tl().az(), sb4, j8));
                }
            }
        }
        xt(jVar);
    }

    @Override // com.bytedance.msdk.cw.j.xt
    public void j(final List<com.bytedance.msdk.xt.cw> list, com.bytedance.msdk.api.j jVar) {
        if (list != null) {
            for (com.bytedance.msdk.xt.cw cwVar : list) {
                if (cwVar != null) {
                    cwVar.g(true);
                    com.bytedance.msdk.api.j.xt xtVar = this.cw;
                    com.bytedance.msdk.cw.m.xt.xt xtVar2 = this.f24859j;
                    com.bytedance.msdk.cw.m.j.xt xtVar3 = this.xt;
                    g wq = xtVar3 == null ? null : xtVar3.wq();
                    com.bytedance.msdk.cw.m.xt.xt xtVar4 = this.f24859j;
                    com.bytedance.msdk.cw.tl.cw.j(cwVar, xtVar, xtVar2, wq, xtVar4 != null ? j(xtVar4.jy()) : "");
                    j(cwVar);
                }
            }
        }
        if (jVar != null && jVar.f24334j == 30010 && com.bytedance.msdk.j.j.j()) {
            com.bytedance.msdk.j.up.m.j(new Runnable() { // from class: com.bytedance.msdk.cw.cw.xt.cw.1
                @Override // java.lang.Runnable
                public void run() {
                    if (cw.this.f24859j != null && cw.this.f24859j.v()) {
                        com.bytedance.msdk.up.m.j(!p.xt(list) ? (com.bytedance.msdk.xt.cw) list.get(0) : null, cw.this.cw, cw.this.f24859j.tl());
                    }
                    cw.this.j();
                }
            }, 1000L);
            return;
        }
        com.bytedance.msdk.cw.m.xt.xt xtVar5 = this.f24859j;
        if (xtVar5 != null && xtVar5.v()) {
            com.bytedance.msdk.up.m.j(p.xt(list) ? null : list.get(0), this.cw, this.f24859j.tl());
        }
        j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        com.bytedance.msdk.cw.m.xt.xt xtVar = this.f24859j;
        if (xtVar != null) {
            xtVar.g();
        }
    }

    private void j(Runnable runnable) {
        com.bytedance.msdk.j.up.m.j(runnable);
    }

    @Override // com.bytedance.msdk.cw.j.xt
    public void j(com.bytedance.msdk.xt.cw cwVar, String str) {
        if (cwVar == null || cwVar.om() != 5) {
            return;
        }
        com.bytedance.msdk.up.m.j(cwVar, this.cw, str);
    }

    @Override // com.bytedance.msdk.cw.cw.xt.j
    public void j(j.InterfaceC0366j interfaceC0366j) {
        if (interfaceC0366j == null) {
            return;
        }
        this.ae = System.currentTimeMillis();
        this.f24859j = interfaceC0366j.j();
        com.bytedance.msdk.cw.m.j.xt xt = interfaceC0366j.xt();
        this.xt = xt;
        this.cw = xt.mi();
        if (this.xt.getContext() == null) {
            com.bytedance.msdk.api.j jVar = new com.bytedance.msdk.api.j("request adn context is null");
            j(this.f24859j, this.xt, jVar, "");
            j(jVar);
        } else {
            if (this.f24859j != null) {
                xt();
                return;
            }
            com.bytedance.msdk.api.j jVar2 = new com.bytedance.msdk.api.j("request adn waterfall request is null");
            j(this.f24859j, this.xt, jVar2, "");
            j(jVar2);
        }
    }

    private void j(com.bytedance.msdk.cw.m.xt.xt xtVar, com.bytedance.msdk.cw.m.j.xt xtVar2, com.bytedance.msdk.api.j jVar, String str) {
        if (xtVar == null || xtVar2 == null || xtVar.tl() == null) {
            return;
        }
        oq tl = xtVar.tl();
        String j6 = TextUtils.isEmpty(str) ? com.bytedance.msdk.core.up.j.j.j().j(tl.w()) : str;
        if (!tl.h()) {
            com.bytedance.msdk.up.m.j(tl, this.cw, j6, xtVar.up(), xtVar.ae() == 4 ? 3 : 0, xtVar.cw(), xtVar.ae(), xtVar.m(), jVar, xtVar.r(), xtVar2.wq().up, false);
        } else if (tl.l() != null) {
            com.bytedance.msdk.up.m.j(tl, this.cw, j6);
        }
    }

    private void j(com.bytedance.msdk.xt.cw cwVar) {
        com.bytedance.msdk.cw.m.xt.xt xtVar;
        if (this.xt == null || this.cw == null || (xtVar = this.f24859j) == null || xtVar.tl() == null) {
            return;
        }
        oq tl = this.f24859j.tl();
        if (!this.f24859j.v() && cwVar != null) {
            com.bytedance.msdk.up.m.j(this.cw, cwVar, this.f24859j.tl());
        }
        if (com.bytedance.msdk.xt.xt.xt) {
            com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, com.bytedance.msdk.j.up.up.j(this.cw.v(), "fill") + "AdNetWorkName[" + tl.az() + "] AdUnitId[" + tl.w() + "] AdType[" + com.bytedance.msdk.xt.j.j(this.cw.f(), tl.m(), tl) + "] 视频缓存成功 (loadSort=" + tl.x() + ",showSort=" + tl.ch() + ")");
            return;
        }
        com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, com.bytedance.msdk.j.up.up.j(this.cw.v(), "fill") + "AdNetWorkName[" + tl.az() + "] AdType[" + com.bytedance.msdk.xt.j.j(this.cw.f(), tl.m(), tl) + "] 视频缓存成功 ");
    }

    private void j(int i6, com.bytedance.msdk.xt.cw cwVar, int i7, String str, long j6) {
        com.bytedance.msdk.cw.m.xt.xt xtVar;
        if (this.xt == null || this.cw == null || (xtVar = this.f24859j) == null || xtVar.tl() == null) {
            return;
        }
        oq tl = this.f24859j.tl();
        String str2 = i6 == 20000 ? "load success" : "请求成功，但无广告可用";
        boolean z5 = this.xt.wq().f24632m;
        if (!this.f24859j.v() && cwVar != null) {
            com.bytedance.msdk.up.m.j(cwVar, i6, str2, this.f24860m, this.cw, this.f24859j.cw(), i7, z5 ? 1 : 0, str, j6, this.up != -1 ? SystemClock.elapsedRealtime() - this.up : -1L);
        }
        if (com.bytedance.msdk.xt.xt.xt) {
            com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, com.bytedance.msdk.j.up.up.j(this.cw.v(), "fill") + "AdNetWorkName[" + tl.az() + "] AdUnitId[" + tl.w() + "] AdType[" + com.bytedance.msdk.xt.j.j(this.cw.f(), tl.m(), tl) + "] 请求成功 (loadSort=" + tl.x() + ",showSort=" + tl.ch() + ")");
            return;
        }
        com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, com.bytedance.msdk.j.up.up.j(this.cw.v(), "fill") + "AdNetWorkName[" + tl.az() + "] AdType[" + com.bytedance.msdk.xt.j.j(this.cw.f(), tl.m(), tl) + "] 请求成功");
    }

    private String j(String str) {
        com.bytedance.msdk.j.j.r j6 = com.bytedance.msdk.m.xt.xt.j().j(str);
        if (j6 != null) {
            return j6.xt();
        }
        return null;
    }
}
