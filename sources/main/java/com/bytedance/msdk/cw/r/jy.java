package com.bytedance.msdk.cw.r;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.bytedance.msdk.api.r.av;
import com.bytedance.msdk.tl.mi;
import com.bytedance.msdk.tl.ws;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import xyz.adscope.amps.common.AMPSConstants;

/* loaded from: D:\Downloads\app\classes3.dex */
public class jy extends xt implements com.bytedance.msdk.j.xt.up {
    private View av;

    /* renamed from: i, reason: collision with root package name */
    private com.bytedance.msdk.api.r.j.g.cw f25052i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f25053j;
    private com.bytedance.msdk.api.r.j.g.r mi;

    /* renamed from: w, reason: collision with root package name */
    private com.bytedance.msdk.api.r.j.g.xt f25054w;
    private boolean xt;

    /* JADX INFO: Access modifiers changed from: private */
    public void xt(ViewGroup viewGroup) {
        boolean z5;
        boolean z6;
        List<com.bytedance.msdk.core.up.xt.ae> j6;
        com.bytedance.msdk.xt.cw cwVar;
        com.bytedance.msdk.up.m.j(this.f25122m);
        List<com.bytedance.msdk.core.oq.oq> list = null;
        if (this.vl) {
            com.bytedance.msdk.up.m.j((List<com.bytedance.msdk.xt.cw>) null, this.f25122m, 0);
            cw(new com.bytedance.msdk.api.j(40052, com.bytedance.msdk.api.j.j(40052)));
            return;
        }
        int xt = xt.xt(this.up);
        if (xt != 0) {
            com.bytedance.msdk.up.m.j((List<com.bytedance.msdk.xt.cw>) null, this.f25122m, xt);
            cw(new com.bytedance.msdk.api.j(xt, com.bytedance.msdk.api.j.j(xt)));
            return;
        }
        List<com.bytedance.msdk.xt.cw> kt = this.cw.kt();
        if (viewGroup == null) {
            com.bytedance.msdk.up.m.j(kt, this.f25122m, 0);
            cw(new com.bytedance.msdk.api.j(40052, com.bytedance.msdk.api.j.j(40052)));
            return;
        }
        try {
            list = xt();
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.vl.j(th);
        }
        if (list != null && list.size() > 0) {
            HashMap<String, com.bytedance.msdk.xt.cw> xt2 = xt(kt);
            for (com.bytedance.msdk.core.oq.oq oqVar : list) {
                if (oqVar != null) {
                    String w5 = oqVar.w();
                    com.bytedance.msdk.xt.cw cwVar2 = xt2.get(w5);
                    if (cwVar2 != null && cwVar2.wq(this.up) && !cwVar2.qb()) {
                        j(cwVar2, viewGroup);
                    } else if (oqVar.kt() && com.bytedance.msdk.core.up.j.j.j().r(this.up, w5, mi()) && com.bytedance.msdk.core.up.j.j.j().j(w5, this.f25122m, false) == 3 && (j6 = com.bytedance.msdk.core.up.j.j.j().j(w5, this.f25122m, mi())) != null && j6.size() > 0 && (cwVar = j6.get(0).f24739j) != null && cwVar.wq(this.up) && !cwVar.qb()) {
                        com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, com.bytedance.msdk.j.up.up.j(this.up, AMPSConstants.FrequencyEventType.FREQUENCY_EVENT_TYPE_SHOW) + "adSlotId：" + cwVar.qa() + "，广告类型：" + com.bytedance.msdk.xt.j.j(cwVar.pz()) + ",isReady()：" + cwVar.wq(this.up));
                        xt(cwVar);
                        j(cwVar, viewGroup);
                    }
                    z5 = true;
                    z6 = true;
                    break;
                }
            }
        }
        z5 = false;
        z6 = false;
        if (!z5 && kt != null && kt.size() > 0) {
            Iterator<com.bytedance.msdk.xt.cw> it = kt.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.bytedance.msdk.xt.cw next = it.next();
                if (next != null && next.wq(this.up) && !next.qb()) {
                    j(next, viewGroup);
                    z6 = true;
                    break;
                }
            }
        }
        if (!z6) {
            com.bytedance.msdk.up.m.j(kt, this.f25122m, 0);
            cw(new com.bytedance.msdk.api.j(40052, com.bytedance.msdk.api.j.j(40052)));
            return;
        }
        this.vl = true;
        if (this.f25123r != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.f25123r);
            j(arrayList);
        }
        com.bytedance.msdk.up.m.j(this.f25123r, this.f25122m, false, 0);
    }

    @Override // com.bytedance.msdk.j.xt.up
    public void cw() {
        com.bytedance.msdk.api.r.j.g.r rVar = this.mi;
        if (rVar != null) {
            rVar.cw();
        }
    }

    public View m() {
        return null;
    }

    public void x() {
        this.xt = true;
    }

    @Override // com.bytedance.msdk.cw.r.xt, com.bytedance.msdk.cw.xt.j.j
    public void ae() {
        com.bytedance.msdk.api.r.j.g.cw cwVar = this.f25052i;
        if (cwVar != null) {
            cwVar.j();
        }
    }

    public View f() {
        SoftReference<Context> softReference = this.tl;
        Context context = softReference != null ? softReference.get() : null;
        if (this.av == null && context != null) {
            FrameLayout frameLayout = new FrameLayout(context);
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            xt(frameLayout);
            this.av = frameLayout;
            j(this.f25123r);
        }
        return this.av;
    }

    @Override // com.bytedance.msdk.j.xt.up
    public Activity getActivity() {
        com.bytedance.msdk.api.r.j.g.r rVar = this.mi;
        if (rVar != null) {
            return rVar.getActivity();
        }
        return null;
    }

    @Override // com.bytedance.msdk.j.xt.up
    public void k_() {
        com.bytedance.msdk.api.r.j.g.r rVar = this.mi;
        if (rVar != null) {
            rVar.j();
        }
    }

    @Override // com.bytedance.msdk.j.xt.up
    public void l_() {
        com.bytedance.msdk.api.r.j.g.r rVar = this.mi;
        if (rVar != null) {
            rVar.xt();
        }
    }

    @Override // com.bytedance.msdk.api.r.j.g.xt
    public void r() {
        String str;
        long j6;
        com.bytedance.msdk.api.r.j.g.xt xtVar = this.f25054w;
        if (xtVar != null) {
            xtVar.r();
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (mi.j(this.f25123r)) {
            str = mi.xt();
            j6 = System.currentTimeMillis() - currentTimeMillis;
        } else {
            str = null;
            j6 = -1;
        }
        String str2 = str;
        long j7 = j6;
        com.bytedance.msdk.core.xt.j.up(this.f25122m.v());
        com.bytedance.msdk.xt.cw cwVar = this.f25123r;
        com.bytedance.msdk.up.m.xt(cwVar, this.f25122m, 0, str2, j7, cwVar.gq());
    }

    @Override // com.bytedance.msdk.api.r.j.g.xt
    public void up() {
        String str;
        long j6;
        com.bytedance.msdk.api.r.j.g.xt xtVar = this.f25054w;
        if (xtVar != null) {
            xtVar.up();
        }
        com.bytedance.msdk.core.tl.jy.j().ae(this.up);
        if (this.f25123r != null) {
            com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, com.bytedance.msdk.j.up.up.j(this.up, "show_listen") + "adSlotId：" + this.f25123r.qa() + "，广告类型：" + com.bytedance.msdk.xt.j.j(this.f25123r.pz()));
            com.bytedance.msdk.core.tl.qv.j().xt(this.up, this.f25123r.qa());
        }
        com.bytedance.msdk.xt.cw cwVar = this.f25123r;
        if (cwVar != null) {
            com.bytedance.msdk.core.cw.cw.j(cwVar.zz(), this.up, this.f25123r.qa());
        }
        v();
        long currentTimeMillis = System.currentTimeMillis();
        if (mi.j(this.f25123r)) {
            str = mi.xt();
            j6 = System.currentTimeMillis() - currentTimeMillis;
        } else {
            str = null;
            j6 = -1;
        }
        com.bytedance.msdk.up.m.j(this.f25123r, this.f25122m, 0, str, j6, false);
        com.bytedance.msdk.core.xt.j.ae(this.f25122m.v());
        com.bytedance.msdk.core.xt.j.cw(this.f25122m.v());
        com.bytedance.msdk.core.g.r.j(1, this.f25122m.v(), this.f25123r.om(), this.f25123r.t());
        com.bytedance.msdk.core.ae.cw.j(this.up, this.f25123r);
    }

    protected void v() {
        if (this.f25123r.ll() && com.bytedance.msdk.core.up.j.j.j().r(this.up, this.f25123r.qa(), mi())) {
            com.bytedance.msdk.core.up.j.j.j().j(this.f25123r.qa(), this.f25122m, this.cw.p(), true, this.cw.h(), this.cw.wq(), this.tl.get());
        }
    }

    public jy(Context context) {
        super(context);
        this.f25053j = false;
        this.xt = false;
    }

    private void cw(final com.bytedance.msdk.api.j jVar) {
        com.bytedance.msdk.j.up.m.cw(new Runnable() { // from class: com.bytedance.msdk.cw.r.jy.3
            @Override // java.lang.Runnable
            public void run() {
                if (jy.this.f25054w != null) {
                    jy.this.f25054w.j(jVar);
                }
            }
        });
    }

    public void j(com.bytedance.msdk.api.j.xt xtVar, com.bytedance.msdk.api.r.qv qvVar, com.bytedance.msdk.api.r.j.g.cw cwVar) {
        j(xtVar);
        this.cw.j(qvVar);
        this.f25052i = cwVar;
        this.f25120g = this;
        this.cw.p().put("ad_load_timeout", Integer.valueOf(xtVar.i()));
        if (com.bytedance.msdk.core.xt.xt().l()) {
            com.bytedance.msdk.api.r.oq.j(new av() { // from class: com.bytedance.msdk.cw.r.jy.1
                @Override // com.bytedance.msdk.api.r.av
                public void j() {
                    jy.this.g();
                }
            });
        } else {
            g();
        }
    }

    public boolean tj() {
        List<com.bytedance.msdk.core.oq.oq> list;
        try {
            list = xt();
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.vl.j(th);
            list = null;
        }
        return ws.j(this.cw.ae(), this.cw.oq(), this.cw.tl(), this.f25122m, this.vl, this.up, this.f25122m.up(), list);
    }

    public void j(com.bytedance.msdk.api.r.j.g.xt xtVar) {
        this.f25054w = xtVar;
    }

    public void j(com.bytedance.msdk.api.r.j.g.r rVar) {
        this.mi = rVar;
    }

    public void j(final ViewGroup viewGroup) {
        final String[] strArr = new String[1];
        final boolean la = com.bytedance.msdk.core.xt.xt().la();
        if (la) {
            strArr[0] = mi.j();
        }
        com.bytedance.msdk.j.up.m.cw(new Runnable() { // from class: com.bytedance.msdk.cw.r.jy.2
            @Override // java.lang.Runnable
            public void run() {
                jy.this.xt(viewGroup);
                if (la) {
                    jy jyVar = jy.this;
                    com.bytedance.msdk.up.m.j(jyVar.f25123r, jyVar.f25122m, strArr[0], 2);
                }
            }
        });
    }

    private void j(com.bytedance.msdk.xt.cw cwVar, ViewGroup viewGroup) {
        this.f25123r = cwVar;
        if (this.xt) {
            cwVar.sf();
        }
        com.bytedance.msdk.api.r.j.xt xtVar = this.jy;
        if (xtVar != null) {
            this.f25123r.j(xtVar);
        }
        com.bytedance.sdk.openadsdk.i.cw.j.xt xtVar2 = this.ws;
        if (xtVar2 != null) {
            this.f25123r.j(xtVar2);
        }
        this.cw.j(this.f25123r);
        this.f25123r.up(true);
        this.f25123r.j(this.f25120g);
        if (this.f25123r.ll() && com.bytedance.msdk.core.up.j.j.j().r(this.up, this.f25123r.qa(), mi())) {
            com.bytedance.msdk.xt.cw cwVar2 = this.f25123r;
            com.bytedance.msdk.cw.tl.up.j(cwVar2, this.up, cwVar2.qa());
        }
        com.bytedance.msdk.core.up.j.j.j().j(this.cw.kt(), this.up, this.f25122m, mi(), this.f25123r);
        com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, com.bytedance.msdk.j.up.up.j(this.up, AMPSConstants.FrequencyEventType.FREQUENCY_EVENT_TYPE_SHOW) + "展示的广告类型：" + com.bytedance.msdk.xt.j.j(this.f25123r.pz()) + ",slotId：" + this.f25123r.qa() + ",slotType:" + this.f25123r.xw());
        com.bytedance.msdk.core.tl.jy j6 = com.bytedance.msdk.core.tl.jy.j();
        StringBuilder sb = new StringBuilder();
        sb.append(this.up);
        j6.xt(sb.toString());
        com.bytedance.msdk.core.tl.vl.j().xt(this.up, this.f25123r.qa());
        this.f25123r.j(viewGroup);
    }

    @Override // com.bytedance.msdk.cw.r.xt
    public void j() {
        if (this.f25123r == null) {
            com.bytedance.msdk.core.up.j.j j6 = com.bytedance.msdk.core.up.j.j.j();
            List<com.bytedance.msdk.xt.cw> kt = this.cw.kt();
            String str = this.up;
            com.bytedance.msdk.api.j.xt xtVar = this.f25122m;
            j6.j(kt, str, xtVar, xtVar.up(), this.f25123r);
        }
        super.j();
    }

    @Override // com.bytedance.msdk.api.r.j.g.xt
    public void j(@NonNull com.bytedance.msdk.api.j jVar) {
        String str;
        long j6;
        long currentTimeMillis = System.currentTimeMillis();
        if (mi.j(this.f25123r)) {
            str = mi.xt();
            j6 = System.currentTimeMillis() - currentTimeMillis;
        } else {
            str = null;
            j6 = -1;
        }
        com.bytedance.msdk.up.m.j(this.f25123r, this.f25122m, jVar, 1, 0, str, j6);
        cw(jVar);
    }

    @Override // com.bytedance.msdk.cw.r.xt, com.bytedance.msdk.cw.xt.j.j
    public void xt(@NonNull com.bytedance.msdk.api.j jVar) {
        com.bytedance.msdk.api.r.j.g.cw cwVar = this.f25052i;
        if (cwVar != null) {
            cwVar.j(jVar);
        }
    }

    @Override // com.bytedance.msdk.api.r.j.g.xt
    public void j(int i6) {
        com.bytedance.msdk.api.r.j.g.xt xtVar = this.f25054w;
        if (xtVar != null) {
            xtVar.j(1);
        }
        com.bytedance.msdk.core.up.xt.r.j().j(this.tl.get(), this.up, mi());
    }

    @Override // com.bytedance.msdk.api.r.j.g.xt
    public void xt(int i6) {
        com.bytedance.msdk.api.r.j.g.xt xtVar = this.f25054w;
        if (xtVar != null) {
            xtVar.xt(i6);
        }
        com.bytedance.msdk.core.up.xt.r.j().j(this.tl.get(), this.up, mi());
    }

    public void j(ViewGroup viewGroup, Activity activity) {
        com.bytedance.msdk.xt.cw cwVar = this.f25123r;
        if (cwVar != null) {
            cwVar.j(viewGroup, activity);
        }
    }
}
