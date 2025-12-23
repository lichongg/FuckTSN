package com.bytedance.msdk.cw.r;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.msdk.cw.cw.j.j;
import com.bytedance.msdk.tl.p;
import com.bytedance.msdk.xt.cw;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import xyz.adscope.amps.common.AMPSConstants;

/* loaded from: D:\Downloads\app\classes3.dex */
public class g extends xt {
    private j.InterfaceC0365j av;

    /* renamed from: i, reason: collision with root package name */
    private boolean f25043i;

    /* renamed from: j, reason: collision with root package name */
    private com.bytedance.msdk.api.r.j.ae.r f25044j;
    private com.bytedance.msdk.api.r.j.cw xt;

    /* JADX INFO: Access modifiers changed from: private */
    public void cw(com.bytedance.msdk.xt.cw cwVar) {
        com.bytedance.msdk.core.oq.xt xtVar;
        if (this.f25122m.sm() || cwVar == null || cwVar.pz() == 7 || (cwVar instanceof com.bytedance.msdk.api.r.j.xt.xt) || (xtVar = this.ae) == null || xtVar.vl()) {
            return;
        }
        com.bytedance.msdk.core.up.xt.r.j().xt(this.tl.get(), this.up, this.f25122m.up());
    }

    @Override // com.bytedance.msdk.cw.r.xt, com.bytedance.msdk.cw.xt.j.j
    public void xt(@NonNull com.bytedance.msdk.api.j jVar) {
        com.bytedance.msdk.api.r.j.cw cwVar;
        com.bytedance.msdk.api.r.j.ae.r rVar = this.f25044j;
        if (rVar != null) {
            rVar.j(jVar);
            if (this.qv != 0 || (cwVar = this.xt) == null) {
                return;
            }
            this.qv = 2;
            cwVar.j(jVar);
        }
    }

    @Override // com.bytedance.msdk.cw.r.xt, com.bytedance.msdk.cw.xt.j.j
    public void ae() {
        List<com.bytedance.msdk.xt.cw> kt;
        List<com.bytedance.msdk.xt.cw> j6;
        if (this.f25044j == null || (j6 = j((kt = this.cw.kt()), this.f25122m.a())) == null || j6.size() <= 0) {
            return;
        }
        if (com.bytedance.msdk.j.up.cw.xt()) {
            com.bytedance.msdk.j.up.cw.r(MediationConstant.TAG, "返回给外部开发者的广告数量：sumList.size=" + j6.size());
        }
        CopyOnWriteArrayList<com.bytedance.msdk.xt.cw> copyOnWriteArrayList = new CopyOnWriteArrayList<>(kt);
        for (com.bytedance.msdk.xt.cw cwVar : j6) {
            if (cwVar != null) {
                cwVar.up(true);
                if (cwVar.ll() && com.bytedance.msdk.core.up.j.j.j().r(this.up, cwVar.qa(), this.f25122m.up())) {
                    com.bytedance.msdk.cw.tl.up.j(cwVar, this.up, cwVar.qa());
                    j(copyOnWriteArrayList, cwVar);
                }
                j(this.cw.ae(), cwVar);
                j(this.cw.tl(), cwVar);
                j(this.cw.g(), cwVar);
                j(this.cw.oq(), cwVar);
            }
        }
        com.bytedance.msdk.core.up.j.j j7 = com.bytedance.msdk.core.up.j.j.j();
        String str = this.up;
        com.bytedance.msdk.api.j.xt xtVar = this.f25122m;
        j7.j(copyOnWriteArrayList, str, xtVar, xtVar.up(), null);
        this.f25044j.j(j6);
    }

    public g(Context context) {
        super(context);
        this.f25043i = false;
    }

    public void j(com.bytedance.msdk.api.j.xt xtVar, @NonNull com.bytedance.msdk.api.r.j.ae.r rVar) {
        j(xtVar);
        this.f25044j = rVar;
        g();
    }

    private void cw(List<com.bytedance.msdk.xt.cw> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        ArrayList<com.bytedance.msdk.xt.cw> arrayList = new ArrayList(list.size());
        arrayList.addAll(list);
        list.clear();
        for (com.bytedance.msdk.xt.cw cwVar : arrayList) {
            if (cwVar != null && !cwVar.qb() && cwVar.wq(this.up)) {
                list.add(cwVar);
            }
        }
    }

    private boolean xt(String str, List<com.bytedance.msdk.xt.cw> list) {
        if (list == null || list.size() <= 0) {
            return false;
        }
        for (com.bytedance.msdk.xt.cw cwVar : list) {
            if (cwVar != null && TextUtils.equals(str, cwVar.qa())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bytedance.msdk.cw.r.xt, com.bytedance.msdk.cw.xt.j.j
    public void j(@Nullable List<com.bytedance.msdk.xt.cw> list, @Nullable com.bytedance.msdk.api.j jVar) {
        super.j(list, jVar);
        if (!(this.f25044j instanceof com.bytedance.msdk.api.r.j.ae.ae) || p.j(list)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (com.bytedance.msdk.xt.cw cwVar : list) {
            cwVar.j(new cw.j() { // from class: com.bytedance.msdk.cw.r.g.1
                @Override // com.bytedance.msdk.xt.cw.j
                public void j() {
                    g.this.vl = true;
                }

                @Override // com.bytedance.msdk.xt.cw.j
                public void j(com.bytedance.msdk.xt.cw cwVar2) {
                    g.this.j(cwVar2, false);
                }
            });
            arrayList.add(cwVar);
        }
    }

    private void cw() {
        try {
            List<com.bytedance.msdk.core.oq.oq> xt = xt();
            if (xt == null || xt.size() <= 0) {
                return;
            }
            for (com.bytedance.msdk.core.oq.oq oqVar : xt) {
                if (oqVar != null) {
                    String w5 = oqVar.w();
                    if (com.bytedance.msdk.core.up.j.j.j().r(this.up, w5, this.f25122m.up())) {
                        if (oqVar.mi() == 100) {
                            j(w5, this.cw.ae());
                        } else if (oqVar.mi() == 0) {
                            j(w5, this.cw.tl());
                        }
                    }
                }
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.vl.j(th);
        }
    }

    @Override // com.bytedance.msdk.cw.r.xt, com.bytedance.msdk.cw.xt.j.j
    public void j(@Nullable String str) {
        com.bytedance.msdk.api.r.j.cw cwVar;
        if (this.qv != 0 || (cwVar = this.xt) == null) {
            return;
        }
        this.qv = 1;
        cwVar.j(str);
    }

    public void j(String str, com.bytedance.msdk.api.r.j.ae.r rVar) {
        if (this.qv != 1) {
            if (rVar != null) {
                rVar.j(new com.bytedance.msdk.api.j(10015, com.bytedance.msdk.api.j.j(10015)));
            }
        } else if (this.oq) {
            if (rVar != null) {
                rVar.j(new com.bytedance.msdk.api.j(40047, com.bytedance.msdk.api.j.j(40047)));
            }
        } else {
            this.oq = true;
            this.f25044j = rVar;
            j.InterfaceC0365j interfaceC0365j = this.av;
            if (interfaceC0365j != null) {
                interfaceC0365j.j(str);
            }
        }
    }

    public void j(com.bytedance.msdk.api.j.xt xtVar, com.bytedance.msdk.api.r.j.cw cwVar) {
        j(xtVar);
        this.xt = cwVar;
        if (this.cw.vl() != null && this.cw.vl().vl()) {
            this.av = g();
        } else if (cwVar != null) {
            cwVar.j(new com.bytedance.msdk.api.j(10014, com.bytedance.msdk.api.j.j(10014)));
        }
    }

    @Override // com.bytedance.msdk.cw.r.xt
    public void j() {
        this.f25044j = null;
    }

    private List<com.bytedance.msdk.xt.cw> j(List<com.bytedance.msdk.xt.cw> list, int i6) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        cw(list);
        cw();
        ArrayList arrayList = new ArrayList();
        Iterator<com.bytedance.msdk.xt.cw> it = list.iterator();
        while (it.hasNext() && arrayList.size() < i6) {
            com.bytedance.msdk.xt.cw next = it.next();
            arrayList.add(next);
            if (com.bytedance.msdk.j.up.cw.xt()) {
                com.bytedance.msdk.j.up.cw.r(MediationConstant.TAG, "");
                com.bytedance.msdk.j.up.cw.r(MediationConstant.TAG, com.bytedance.msdk.j.up.up.j(this.up, AMPSConstants.FrequencyEventType.FREQUENCY_EVENT_TYPE_SHOW) + "返回给开发者最终广告：slotId=" + next.qa() + ",slotType:" + next.xw() + ",cpm=" + next.t() + ",广告类型：" + com.bytedance.msdk.xt.j.j(next.pz()) + ",ImageMode=" + next.st() + ",showSort=" + next.d() + ",isExpressAd=" + next.aq());
            }
            next.j(new cw.j() { // from class: com.bytedance.msdk.cw.r.g.2
                @Override // com.bytedance.msdk.xt.cw.j
                public void j() {
                    g.this.vl = true;
                }

                @Override // com.bytedance.msdk.xt.cw.j
                public void j(com.bytedance.msdk.xt.cw cwVar) {
                    boolean z5;
                    com.bytedance.msdk.core.up.xt.r j6 = com.bytedance.msdk.core.up.xt.r.j();
                    g gVar = g.this;
                    if (j6.cw(gVar.up, gVar.f25122m.up()) || g.this.f25043i) {
                        z5 = false;
                    } else {
                        z5 = true;
                        g.this.f25043i = true;
                    }
                    g.this.j(cwVar, z5);
                    g.this.cw(cwVar);
                }
            });
            it.remove();
        }
        com.bytedance.msdk.cw.up.j j6 = com.bytedance.msdk.cw.up.j.j();
        com.bytedance.msdk.api.j.xt xtVar = this.f25122m;
        j6.j(xtVar, com.bytedance.msdk.cw.up.j.j(xtVar, arrayList, list));
        j(arrayList);
        return arrayList;
    }

    public void j(com.bytedance.msdk.xt.cw cwVar, boolean z5) {
        if (cwVar != null && cwVar.ll() && com.bytedance.msdk.core.up.j.j.j().r(this.up, cwVar.qa(), this.f25122m.up())) {
            com.bytedance.msdk.core.up.j.j.j().j(cwVar.qa(), this.f25122m, this.cw.p(), z5, this.cw.h(), this.cw.wq(), this.tl.get());
        }
    }

    private void j(CopyOnWriteArrayList<com.bytedance.msdk.xt.cw> copyOnWriteArrayList, com.bytedance.msdk.xt.cw cwVar) {
        Iterator<com.bytedance.msdk.xt.cw> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            com.bytedance.msdk.xt.cw next = it.next();
            if (next == cwVar && next != null) {
                copyOnWriteArrayList.remove(next);
            }
        }
    }

    private void j(String str, List<com.bytedance.msdk.xt.cw> list) {
        com.bytedance.msdk.xt.cw cwVar;
        if (xt(str, list) || com.bytedance.msdk.core.up.j.j.j().j(str, this.f25122m, false) != 3) {
            return;
        }
        com.bytedance.msdk.core.up.j.j j6 = com.bytedance.msdk.core.up.j.j.j();
        com.bytedance.msdk.api.j.xt xtVar = this.f25122m;
        List<com.bytedance.msdk.core.up.xt.ae> j7 = j6.j(str, xtVar, xtVar.up());
        if (j7 == null || j7.size() <= 0) {
            return;
        }
        for (com.bytedance.msdk.core.up.xt.ae aeVar : j7) {
            if (aeVar != null && (cwVar = aeVar.f24739j) != null && !cwVar.qb() && aeVar.f24739j.wq(this.up)) {
                list.add(aeVar.f24739j);
                xt(aeVar.f24739j);
            }
        }
    }
}
