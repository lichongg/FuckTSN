package com.bytedance.msdk.cw.r;

import android.app.Activity;
import android.content.Context;
import com.bytedance.msdk.tl.ws;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import xyz.adscope.amps.common.AMPSConstants;

/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class oq extends xt {

    /* renamed from: i, reason: collision with root package name */
    protected boolean f25066i;

    /* renamed from: j, reason: collision with root package name */
    private Object f25067j;
    protected com.bytedance.msdk.j.xt.m mi;

    /* renamed from: w, reason: collision with root package name */
    protected boolean f25068w;

    public interface j {
        void j();
    }

    public void cw(final com.bytedance.msdk.xt.cw cwVar) {
        if (this.f25122m.sm()) {
            return;
        }
        com.bytedance.msdk.j.up.m.cw(new Runnable() { // from class: com.bytedance.msdk.cw.r.oq.1
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.xt.cw cwVar2 = cwVar;
                if (cwVar2 == null || !cwVar2.lx() || !cwVar.fp() || (oq.this.f25123r instanceof com.bytedance.msdk.api.r.j.xt.xt)) {
                    return;
                }
                com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, com.bytedance.msdk.j.up.up.xt(oq.this.up, cwVar.qa()) + "在show时触发了预加载【" + cwVar.ff() + "】, loadSort: " + cwVar.wi() + ", showSort: " + cwVar.d());
                oq.this.f25068w = true;
                com.bytedance.msdk.core.up.xt.r j6 = com.bytedance.msdk.core.up.xt.r.j();
                Context context = oq.this.tl.get();
                oq oqVar = oq.this;
                j6.xt(context, oqVar.up, oqVar.f25122m.up());
            }
        });
    }

    protected boolean tj() {
        return false;
    }

    private boolean xt(com.bytedance.msdk.xt.cw cwVar, Activity activity, Object obj, String str) {
        if (!cwVar.wq(this.up) || cwVar.qb()) {
            return false;
        }
        if (!tj()) {
            com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, com.bytedance.msdk.j.up.up.xt(this.up, cwVar.qa()) + "弱网情况下没有缓存好的广告,那么直接根据优先级展示，广告类型：" + com.bytedance.msdk.xt.j.j(cwVar.pz()) + ",isReady()：" + cwVar.wq(this.up));
            j(cwVar, activity, obj, str);
            return true;
        }
        if (!r(cwVar) || com.bytedance.msdk.core.admanager.j.j(cwVar.ff(), cwVar.om(), cwVar.rh())) {
            com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "--==--- 插全屏轮播中，不能轮播的自定义adn跳过");
            return false;
        }
        com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, com.bytedance.msdk.j.up.up.xt(this.up, cwVar.qa()) + "弱网情况下没有缓存好的广告,那么直接根据优先级展示，广告类型：" + com.bytedance.msdk.xt.j.j(cwVar.pz()) + ",isReady()：" + cwVar.wq(this.up));
        j(cwVar, activity, obj, str);
        return true;
    }

    public boolean ch() {
        return this.f25066i;
    }

    public void j(boolean z5) {
        this.f25066i = z5;
    }

    public void s() {
        com.bytedance.msdk.xt.cw cwVar;
        if (this.f25122m.sm() || (cwVar = this.f25123r) == null || cwVar.pz() == 4) {
            return;
        }
        com.bytedance.msdk.core.up.xt.r.j().j(this.tl.get(), this.up, this.f25122m.up());
    }

    public oq(Context context) {
        super(context);
        this.f25066i = false;
        this.f25068w = false;
        this.f25067j = null;
    }

    private boolean cw(com.bytedance.msdk.xt.cw cwVar, Activity activity, Object obj, String str) {
        if (!cwVar.wq(this.up) || cwVar.qb()) {
            return false;
        }
        if (tj()) {
            if (r(cwVar) && !com.bytedance.msdk.core.admanager.j.j(cwVar.ff(), cwVar.om(), cwVar.rh())) {
                com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, com.bytedance.msdk.j.up.up.xt(this.up, cwVar.qa()) + "弱网情况下没有缓存好的广告,那么直接根据优先级展示，广告类型：" + com.bytedance.msdk.xt.j.j(cwVar.pz()) + ",isReady()：" + cwVar.wq(this.up));
                xt(cwVar);
                j(cwVar, activity, obj, str);
                return true;
            }
            com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "--==--- cache 插全屏轮播中，不能轮播的自定义adn跳过");
            return false;
        }
        com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, com.bytedance.msdk.j.up.up.xt(this.up, cwVar.qa()) + "弱网情况下没有缓存好的广告,那么直接根据优先级展示，广告类型：" + com.bytedance.msdk.xt.j.j(cwVar.pz()) + ",isReady()：" + cwVar.wq(this.up));
        xt(cwVar);
        j(cwVar, activity, obj, str);
        return true;
    }

    private boolean r(com.bytedance.msdk.xt.cw cwVar) {
        if (!cwVar.dj() || cwVar.x() == 1) {
            return true;
        }
        return false;
    }

    public boolean a() {
        List<com.bytedance.msdk.core.oq.oq> list;
        try {
            list = xt();
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.vl.j(th);
            list = null;
        }
        return ws.j(this.cw.ae(), this.cw.oq(), this.cw.tl(), this.f25122m, this.vl, this.up, this.f25122m.up(), list);
    }

    public void j(com.bytedance.msdk.cw.m.j.xt xtVar) {
        boolean z5;
        com.bytedance.msdk.core.oq.xt xtVar2;
        if (this.f25123r.om() == 10 || this.f25123r.om() == 8 || this.f25123r.om() == 7) {
            boolean z6 = (this.f25123r.lx() && this.f25123r.fp() && com.bytedance.msdk.core.up.xt.r.j().cw(this.up, this.f25122m.up())) ? false : true;
            com.bytedance.msdk.api.j.xt xtVar3 = this.f25122m;
            z5 = this.f25123r.pz() == 4 ? false : (xtVar3 == null || !(xtVar3.f() == 10 || this.f25122m.f() == 8) || (xtVar2 = this.ae) == null || xtVar2.jy() == 0) ? z6 : true;
        } else {
            z5 = true;
        }
        if (this.f25123r.ll() && com.bytedance.msdk.core.up.j.j.j().r(this.up, this.f25123r.qa(), this.f25122m.up())) {
            com.bytedance.msdk.core.up.j.j.j().j(this.f25123r.qa(), this.f25122m, xtVar != null ? xtVar.p() : null, z5, xtVar != null ? xtVar.h() : null, (com.bytedance.msdk.core.oq.g) null, this.tl.get());
        }
    }

    @Override // com.bytedance.msdk.cw.r.xt
    public void j() {
        super.j();
        this.mi = null;
    }

    public void j(Activity activity, Object obj, String str, j jVar) {
        oq oqVar;
        Activity activity2;
        Object obj2;
        String str2;
        List<com.bytedance.msdk.core.oq.oq> list = null;
        if (!tj()) {
            com.bytedance.msdk.up.m.j(this.f25122m);
            if (this.vl) {
                com.bytedance.msdk.up.m.j((List<com.bytedance.msdk.xt.cw>) null, this.f25122m, 0);
                if (jVar != null) {
                    jVar.j();
                    return;
                }
                return;
            }
        }
        int xt = xt.xt(this.up);
        if (xt != 0) {
            com.bytedance.msdk.up.m.j((List<com.bytedance.msdk.xt.cw>) null, this.f25122m, xt);
            if (jVar != null) {
                jVar.j();
                return;
            }
            return;
        }
        boolean jy = jy();
        List<com.bytedance.msdk.xt.cw> kt = this.cw.kt();
        try {
            list = xt();
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.vl.j(th);
        }
        List<com.bytedance.msdk.core.oq.oq> list2 = list;
        if (list2 == null || list2.size() <= 0) {
            oqVar = this;
            activity2 = activity;
            obj2 = obj;
            str2 = str;
        } else {
            oqVar = this;
            activity2 = activity;
            obj2 = obj;
            str2 = str;
            if (oqVar.j(list2, kt, jy, activity2, obj2, str2)) {
                return;
            }
        }
        if (kt != null && kt.size() > 0) {
            for (com.bytedance.msdk.xt.cw cwVar : kt) {
                if (cwVar != null && (!jy || cwVar.fp())) {
                    if (xt(cwVar, activity2, obj2, str2)) {
                        return;
                    }
                }
            }
            if (jy && oqVar.f25123r == null) {
                for (com.bytedance.msdk.xt.cw cwVar2 : kt) {
                    if (cwVar2 != null && xt(cwVar2, activity2, obj2, str2)) {
                        return;
                    }
                }
            }
        }
        com.bytedance.msdk.up.m.j(kt, oqVar.f25122m, 0);
        if (jVar != null) {
            jVar.j();
        }
    }

    public void j(com.bytedance.msdk.xt.cw cwVar, final Activity activity, final Object obj, final String str) {
        this.f25123r = cwVar;
        com.bytedance.msdk.j.up.m.cw(new Runnable() { // from class: com.bytedance.msdk.cw.r.oq.2
            @Override // java.lang.Runnable
            public void run() {
                oq oqVar = oq.this;
                if (oqVar.f25123r != null) {
                    if (oqVar.f25067j != null) {
                        oq oqVar2 = oq.this;
                        oqVar2.f25123r.j(oqVar2.f25067j);
                    }
                    oq oqVar3 = oq.this;
                    com.bytedance.msdk.api.r.j.xt xtVar = oqVar3.jy;
                    if (xtVar != null) {
                        oqVar3.f25123r.j(xtVar);
                    }
                    oq oqVar4 = oq.this;
                    com.bytedance.sdk.openadsdk.i.cw.j.xt xtVar2 = oqVar4.ws;
                    if (xtVar2 != null) {
                        oqVar4.f25123r.j(xtVar2);
                    }
                    oq oqVar5 = oq.this;
                    oqVar5.cw.j(oqVar5.f25123r);
                    oq.this.f25123r.up(true);
                    oq oqVar6 = oq.this;
                    oqVar6.f25123r.j(oqVar6.f25120g);
                    oq oqVar7 = oq.this;
                    oqVar7.f25123r.xt(oqVar7.mi);
                    if (oq.this.f25123r.ll()) {
                        com.bytedance.msdk.core.up.j.j j6 = com.bytedance.msdk.core.up.j.j.j();
                        oq oqVar8 = oq.this;
                        if (j6.r(oqVar8.up, oqVar8.f25123r.qa(), oq.this.mi())) {
                            oq oqVar9 = oq.this;
                            com.bytedance.msdk.xt.cw cwVar2 = oqVar9.f25123r;
                            com.bytedance.msdk.cw.tl.up.j(cwVar2, oqVar9.up, cwVar2.qa());
                        }
                    }
                    List<com.bytedance.msdk.xt.cw> kt = oq.this.cw.kt();
                    com.bytedance.msdk.core.up.j.j j7 = com.bytedance.msdk.core.up.j.j.j();
                    oq oqVar10 = oq.this;
                    String str2 = oqVar10.up;
                    com.bytedance.msdk.api.j.xt xtVar3 = oqVar10.f25122m;
                    j7.j(kt, str2, xtVar3, xtVar3.up(), oq.this.f25123r);
                    StringBuilder sb = new StringBuilder();
                    sb.append(com.bytedance.msdk.j.up.up.j(oq.this.up, AMPSConstants.FrequencyEventType.FREQUENCY_EVENT_TYPE_SHOW));
                    sb.append("展示的广告类型：");
                    sb.append(com.bytedance.msdk.xt.j.j(oq.this.f25123r.pz()));
                    sb.append(",slotId：");
                    sb.append(oq.this.f25123r.qa());
                    sb.append(",slotType:");
                    sb.append(oq.this.f25123r.xw());
                    sb.append(",isReady()：");
                    oq oqVar11 = oq.this;
                    sb.append(oqVar11.f25123r.wq(oqVar11.up));
                    sb.append("，是否为缓存广告:");
                    sb.append(oq.this.f25123r.fp());
                    com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, sb.toString());
                    oq.this.f25123r.j(activity, obj, str);
                    com.bytedance.msdk.core.tl.jy.j().xt(oq.this.up);
                    com.bytedance.msdk.core.tl.vl j8 = com.bytedance.msdk.core.tl.vl.j();
                    oq oqVar12 = oq.this;
                    j8.xt(oqVar12.up, oqVar12.f25123r.qa());
                    oq.this.vl = true;
                    if (oq.this.f25123r != null) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(oq.this.f25123r);
                        if (oq.this.f25122m.f() == 7 || oq.this.f25122m.f() == 10) {
                            com.bytedance.msdk.cw.up.j j9 = com.bytedance.msdk.cw.up.j.j();
                            com.bytedance.msdk.api.j.xt xtVar4 = oq.this.f25122m;
                            j9.j(xtVar4, com.bytedance.msdk.cw.up.j.j(xtVar4, arrayList, kt));
                        }
                        oq.this.j((List<com.bytedance.msdk.xt.cw>) arrayList);
                    }
                    oq oqVar13 = oq.this;
                    com.bytedance.msdk.up.m.j(oqVar13.f25123r, oqVar13.f25122m, false, oqVar13.tj() ? 1 : 0);
                }
            }
        });
    }

    private boolean j(List<com.bytedance.msdk.core.oq.oq> list, List<com.bytedance.msdk.xt.cw> list2, boolean z5, Activity activity, Object obj, String str) {
        com.bytedance.msdk.xt.cw cwVar;
        com.bytedance.msdk.xt.cw cwVar2;
        HashMap<String, com.bytedance.msdk.xt.cw> xt = xt(list2);
        for (com.bytedance.msdk.core.oq.oq oqVar : list) {
            if (oqVar != null) {
                String w5 = oqVar.w();
                com.bytedance.msdk.xt.cw cwVar3 = xt.get(w5);
                if (cwVar3 != null) {
                    if (z5) {
                        if (cwVar3.fp() && xt(cwVar3, activity, obj, str)) {
                            return true;
                        }
                    } else if (xt(cwVar3, activity, obj, str)) {
                        return true;
                    }
                }
                if (oqVar.kt() && com.bytedance.msdk.core.up.j.j.j().r(this.up, w5, this.f25122m.up()) && com.bytedance.msdk.core.up.j.j.j().j(w5, this.f25122m, false) == 3) {
                    com.bytedance.msdk.core.up.j.j j6 = com.bytedance.msdk.core.up.j.j.j();
                    com.bytedance.msdk.api.j.xt xtVar = this.f25122m;
                    List<com.bytedance.msdk.core.up.xt.ae> j7 = j6.j(w5, xtVar, xtVar.up());
                    if (j7 != null && j7.size() > 0 && (cwVar2 = j7.get(0).f24739j) != null) {
                        if (z5) {
                            if (cwVar2.fp() && cw(cwVar2, activity, obj, str)) {
                                return true;
                            }
                        } else if (cw(cwVar2, activity, obj, str)) {
                            return true;
                        }
                    }
                }
            }
        }
        if (z5 && this.f25123r == null) {
            for (com.bytedance.msdk.core.oq.oq oqVar2 : list) {
                if (oqVar2 != null) {
                    String w6 = oqVar2.w();
                    com.bytedance.msdk.xt.cw cwVar4 = xt.get(w6);
                    if (cwVar4 != null && xt(cwVar4, activity, obj, str)) {
                        return true;
                    }
                    if (oqVar2.kt() && com.bytedance.msdk.core.up.j.j.j().r(this.up, w6, this.f25122m.up()) && com.bytedance.msdk.core.up.j.j.j().j(w6, this.f25122m, false) == 3) {
                        com.bytedance.msdk.core.up.j.j j8 = com.bytedance.msdk.core.up.j.j.j();
                        com.bytedance.msdk.api.j.xt xtVar2 = this.f25122m;
                        List<com.bytedance.msdk.core.up.xt.ae> j9 = j8.j(w6, xtVar2, xtVar2.up());
                        if (j9 != null && j9.size() > 0 && (cwVar = j9.get(0).f24739j) != null && cw(cwVar, activity, obj, str)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public void j(Object obj) {
        this.f25067j = obj;
        com.bytedance.msdk.xt.cw cwVar = this.f25123r;
        if (cwVar != null) {
            cwVar.j(obj);
        }
    }
}
