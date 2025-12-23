package com.bytedance.msdk.cw.cw.j;

import com.bytedance.msdk.core.up.xt.r;
import com.bytedance.msdk.cw.cw.j.j;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes3.dex */
public class tl implements j {

    /* renamed from: j, reason: collision with root package name */
    private int f24838j = 0;

    @Override // com.bytedance.msdk.cw.cw.j.j
    public void xt(j.InterfaceC0365j interfaceC0365j) {
        interfaceC0365j.j((String) null);
    }

    @Override // com.bytedance.msdk.cw.cw.j.j
    public void j(j.InterfaceC0365j interfaceC0365j) {
        String rn = interfaceC0365j.j().vl().rn();
        com.bytedance.msdk.api.j.xt mi = interfaceC0365j.j().mi();
        boolean v5 = interfaceC0365j.j().v();
        if (com.bytedance.msdk.core.up.xt.r.j().cw(rn, mi.up())) {
            boolean z5 = com.bytedance.msdk.core.up.xt.r.j().j(rn) == null;
            if (!v5 && !z5 && j(rn, mi, interfaceC0365j.j())) {
                interfaceC0365j.j().cw(true);
                j(mi, rn, interfaceC0365j.j().vl(), interfaceC0365j.j());
                return;
            }
            com.bytedance.msdk.core.up.xt.r.j().j(rn, mi);
        }
        interfaceC0365j.j(interfaceC0365j.j());
    }

    private boolean j(String str, com.bytedance.msdk.api.j.xt xtVar, com.bytedance.msdk.cw.m.j.xt xtVar2) {
        List<com.bytedance.msdk.core.up.xt.ae> r5;
        com.bytedance.msdk.core.oq.xt vl = xtVar2.vl();
        if (com.bytedance.msdk.core.up.xt.r.j().j(str, xtVar, vl != null ? vl.hh() : null) && (r5 = com.bytedance.msdk.core.up.xt.r.j().r(str)) != null && r5.size() > 0) {
            for (com.bytedance.msdk.core.up.xt.ae aeVar : r5) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(aeVar.f24739j);
                xtVar2.j(arrayList);
            }
            if (xtVar2.ae().size() > 0 || xtVar2.oq().size() > 0 || xtVar2.tl().size() > 0) {
                com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, com.bytedance.msdk.j.up.up.j(str) + "--==-- hit cache!!! -----");
                return true;
            }
        }
        com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, com.bytedance.msdk.j.up.up.j(str) + "--==-- not hit cache!!! -----");
        return false;
    }

    private void j(com.bytedance.msdk.api.j.xt xtVar, String str, com.bytedance.msdk.core.oq.xt xtVar2, final com.bytedance.msdk.cw.m.j.xt xtVar3) {
        com.bytedance.msdk.api.j.xt xt = com.bytedance.msdk.core.up.xt.r.j().xt(str);
        if (xt != null) {
            xtVar.j(xt.j());
            xtVar.xt(xt.cw());
        }
        com.bytedance.msdk.core.up.xt.r.j().j(str, xtVar);
        com.bytedance.msdk.up.m.j(xtVar3.mi(), xtVar2.hh(), !xtVar3.v(), xtVar3.wq().f24631j, 0, (Map<String, Object>) null);
        com.bytedance.msdk.xt.cw cwVar = null;
        com.bytedance.msdk.cw.tl.j.j(xtVar3, null, false);
        com.bytedance.msdk.core.up.xt.xt cw = com.bytedance.msdk.core.up.xt.r.j().cw(str);
        if (cw != null) {
            xtVar3.j(cw.r() != null ? cw.r().wq() : null);
            xtVar3.j(cw.cw());
        }
        final int xt2 = com.bytedance.msdk.core.up.xt.r.j().xt(str, xtVar.up());
        if (xt2 == 2) {
            this.f24838j = 1;
            xtVar3.j(1);
            xtVar3.r();
            return;
        }
        if (xt2 != 3 && xt2 != 4) {
            com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "--==-- 预缓存reqType错误：reqType = ".concat(String.valueOf(xt2)));
            return;
        }
        if (xtVar.tl() == 1) {
            com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "--==-- 激励再得情况，不进行预缓存补充，直接对外给出回调");
            this.f24838j = 2;
            xtVar3.j(2);
            xtVar3.r();
            return;
        }
        long up = com.bytedance.msdk.core.up.xt.r.up(str);
        long currentTimeMillis = System.currentTimeMillis() - up;
        if (up != -1 && currentTimeMillis < xtVar2.r()) {
            com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "--==-- 预缓存补充请求无需发起，时间间隔不够，interval：" + currentTimeMillis + ", config interval: " + xtVar2.r());
            this.f24838j = 3;
            xtVar3.j(3);
            xtVar3.r();
            return;
        }
        List<com.bytedance.msdk.xt.cw> kt = xtVar3.kt();
        if (kt != null && kt.size() > 0) {
            cwVar = kt.get(0);
        }
        com.bytedance.msdk.xt.cw cwVar2 = cwVar;
        final double j6 = j(str, xtVar.f());
        if (cwVar2 == null || cwVar2.px() || cwVar2.t() >= j6) {
            com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "--==-- 预缓存补充请求无需发起，已经命中最优");
            this.f24838j = 4;
            xtVar3.j(4);
            xtVar3.r();
            return;
        }
        com.bytedance.msdk.core.up.xt.r.j().j(xtVar3.getContext(), str, xt2, xtVar, cwVar2, new r.cw() { // from class: com.bytedance.msdk.cw.cw.j.tl.1
            @Override // com.bytedance.msdk.core.up.xt.r.cw
            public void j(String str2, boolean z5, int i6, List<com.bytedance.msdk.xt.cw> list) {
                tl.this.j(str2, z5, i6, list, xt2, j6, xtVar3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(String str, boolean z5, int i6, List<com.bytedance.msdk.xt.cw> list, int i7, double d6, com.bytedance.msdk.cw.m.j.xt xtVar) {
        if (z5) {
            if (i7 == 4) {
                com.bytedance.msdk.xt.cw cwVar = (list == null || list.size() <= 0) ? null : list.get(0);
                if (cwVar != null && cwVar.t() >= d6) {
                    this.f24838j = 6;
                } else {
                    this.f24838j = 7;
                }
            } else if (i7 == 3) {
                this.f24838j = 5;
            }
        } else if (i6 == 10003) {
            this.f24838j = 9;
        } else if (i6 == 10086) {
            this.f24838j = 8;
        }
        xtVar.j(this.f24838j);
        xtVar.j(list);
        com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "--==-- 预缓存补充请求结束，对外给出回调");
        xtVar.r();
    }

    private double j(String str, int i6) {
        com.bytedance.msdk.core.oq.xt j6 = com.bytedance.msdk.ae.j.cw.j().j(str, i6, 102);
        double d6 = 0.0d;
        if (j6 == null) {
            return 0.0d;
        }
        for (com.bytedance.msdk.core.oq.oq oqVar : j6.ol()) {
            if (oqVar.uf() && oqVar.v() > d6) {
                d6 = oqVar.v();
            }
        }
        return d6;
    }
}
