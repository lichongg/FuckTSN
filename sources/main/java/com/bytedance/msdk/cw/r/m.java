package com.bytedance.msdk.cw.r;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.msdk.tl.mi;
import com.bytedance.msdk.tl.ws;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import xyz.adscope.amps.common.AMPSConstants;

/* loaded from: D:\Downloads\app\classes3.dex */
public class m extends xt implements com.bytedance.msdk.j.xt.j {
    private boolean av;

    /* renamed from: i, reason: collision with root package name */
    private com.bytedance.msdk.api.r.j.j.r f25059i;

    /* renamed from: j, reason: collision with root package name */
    private com.bytedance.msdk.api.r.j.j.j f25060j;
    private com.bytedance.msdk.api.r.j.j.xt xt;

    public boolean cw() {
        List<com.bytedance.msdk.core.oq.oq> list;
        try {
            list = xt();
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.vl.j(th);
            list = null;
        }
        return ws.j(this.cw.ae(), this.cw.oq(), this.cw.tl(), this.f25122m, this.vl, this.up, this.f25122m.up(), list);
    }

    public int r() {
        com.bytedance.msdk.xt.cw cwVar = this.f25123r;
        if (cwVar != null) {
            return cwVar.st();
        }
        return 0;
    }

    @Override // com.bytedance.msdk.cw.r.xt, com.bytedance.msdk.cw.xt.j.j
    public void xt(@NonNull com.bytedance.msdk.api.j jVar) {
        com.bytedance.msdk.api.r.j.j.xt xtVar = this.xt;
        if (xtVar != null) {
            xtVar.j(jVar);
        }
    }

    @Override // com.bytedance.msdk.cw.r.xt, com.bytedance.msdk.cw.xt.j.j
    public void ae() {
        com.bytedance.msdk.api.r.j.j.xt xtVar = this.xt;
        if (xtVar != null) {
            xtVar.j();
        }
    }

    @Override // com.bytedance.msdk.cw.r.xt
    public com.bytedance.msdk.api.cw az() {
        if (this.av) {
            return super.az();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.r.j.j.j
    public void f_() {
        com.bytedance.msdk.api.r.j.j.j jVar = this.f25060j;
        if (jVar != null) {
            jVar.f_();
        }
    }

    public void j(com.bytedance.msdk.api.j.xt xtVar, com.bytedance.msdk.api.r.j.j.xt xtVar2) {
        j(xtVar);
        this.f25120g = this;
        this.xt = xtVar2;
        g();
    }

    public void m() {
        com.bytedance.msdk.xt.cw cwVar = this.f25123r;
        if (cwVar != null) {
            cwVar.av();
        }
    }

    public com.bytedance.sdk.openadsdk.i.cw.xt.r tj() {
        com.bytedance.msdk.xt.cw cwVar = this.f25123r;
        if (cwVar != null) {
            return cwVar.kk();
        }
        return null;
    }

    public void up() {
        com.bytedance.msdk.xt.cw cwVar = this.f25123r;
        if (cwVar != null) {
            cwVar.i();
        }
    }

    public m(Context context) {
        super(context);
        this.av = false;
    }

    public void r(String str) {
        com.bytedance.msdk.xt.cw cwVar = this.f25123r;
        if (cwVar != null) {
            cwVar.uf(str);
        }
    }

    @Override // com.bytedance.msdk.api.r.j.j.j
    public void xt(View view) {
        String str;
        long j6;
        this.av = true;
        if (this.f25060j != null) {
            com.bytedance.msdk.core.tl.jy.j().ae(this.up);
            com.bytedance.msdk.core.tl.jy.j().xt(this.up);
            this.f25060j.xt(view);
        }
        if (this.f25123r != null) {
            com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, com.bytedance.msdk.j.up.up.j(this.up, "show_listen") + "adSlotId：" + this.f25123r.qa() + "，广告类型：" + com.bytedance.msdk.xt.j.j(this.f25123r.pz()));
            com.bytedance.msdk.core.tl.qv.j().xt(this.up, this.f25123r.qa());
            com.bytedance.msdk.core.tl.vl.j().xt(this.up, this.f25123r.qa());
        }
        com.bytedance.msdk.xt.cw cwVar = this.f25123r;
        if (cwVar != null) {
            com.bytedance.msdk.core.cw.cw.j(cwVar.zz(), this.up, this.f25123r.qa());
        }
        j(true);
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

    private void cw(final com.bytedance.msdk.api.j jVar) {
        com.bytedance.msdk.j.up.m.cw(new Runnable() { // from class: com.bytedance.msdk.cw.r.m.2
            @Override // java.lang.Runnable
            public void run() {
                if (m.this.f25060j != null) {
                    m.this.f25060j.j(jVar);
                }
            }
        });
    }

    public void j(com.bytedance.msdk.api.r.j.j.r rVar) {
        this.f25059i = rVar;
    }

    private com.bytedance.msdk.api.r.j.j.cw cw(final com.bytedance.msdk.xt.cw cwVar) {
        return new com.bytedance.msdk.api.r.j.j.cw() { // from class: com.bytedance.msdk.cw.r.m.3
            @Override // com.bytedance.msdk.api.r.j.j.cw
            @Nullable
            public String j() {
                return cwVar.zs();
            }

            @Override // com.bytedance.msdk.api.r.j.j.cw
            @Nullable
            public String xt() {
                return cwVar.fx();
            }

            @Override // com.bytedance.msdk.api.r.j.j.cw
            @Nullable
            public String ae() {
                return cwVar.jl();
            }

            @Override // com.bytedance.msdk.api.r.j.j.cw
            @Nullable
            public String cw() {
                return cwVar.na();
            }

            @Override // com.bytedance.msdk.api.r.j.j.cw
            public int g() {
                return cwVar.rr();
            }

            @Override // com.bytedance.msdk.api.r.j.j.cw
            public void j(@NonNull Activity activity, @NonNull ViewGroup viewGroup, @NonNull List<View> list, @Nullable List<View> list2, @Nullable List<View> list3, com.bytedance.msdk.api.r.j.ae.oq oqVar) {
                cwVar.j(activity, viewGroup, list, list2, list3, oqVar, null);
            }

            @Override // com.bytedance.msdk.api.r.j.j.cw
            @Nullable
            public List<String> m() {
                return cwVar.tk();
            }

            @Override // com.bytedance.msdk.api.r.j.j.cw
            public com.bytedance.msdk.api.r.j.ae.j oq() {
                if (!cwVar.wf()) {
                    return null;
                }
                com.bytedance.msdk.api.r.j.ae.j jVar = new com.bytedance.msdk.api.r.j.ae.j();
                jVar.r(cwVar.ln());
                jVar.up(cwVar.xp());
                jVar.j(cwVar.im());
                jVar.m(cwVar.y());
                jVar.ae(cwVar.nt());
                jVar.tl(cwVar.uc());
                jVar.j(cwVar.ri());
                jVar.xt(cwVar.ki());
                jVar.cw(cwVar.hl());
                jVar.j(cwVar.hh());
                jVar.xt(cwVar.z());
                return jVar;
            }

            @Override // com.bytedance.msdk.api.r.j.j.cw
            public boolean qv() {
                return cwVar.kt();
            }

            @Override // com.bytedance.msdk.api.r.j.j.cw
            @Nullable
            public String r() {
                return cwVar.ov();
            }

            @Override // com.bytedance.msdk.api.r.j.j.cw
            public int tl() {
                return cwVar.st();
            }

            @Override // com.bytedance.msdk.api.r.j.j.cw
            public double up() {
                return cwVar.rs();
            }

            @Override // com.bytedance.msdk.api.r.j.j.cw
            public com.bytedance.sdk.openadsdk.i.cw.xt.r vl() {
                com.bytedance.msdk.xt.cw cwVar2 = cwVar;
                if (cwVar2 != null) {
                    return cwVar2.kk();
                }
                return null;
            }

            @Override // com.bytedance.msdk.api.r.j.j.cw
            public com.bytedance.sdk.openadsdk.i.cw.xt.ae xt(Activity activity) {
                com.bytedance.msdk.xt.cw cwVar2 = cwVar;
                if (cwVar2 != null) {
                    return cwVar2.j(activity);
                }
                return null;
            }

            @Override // com.bytedance.msdk.api.r.j.j.cw
            @Nullable
            public com.bytedance.msdk.api.r.xt j(Activity activity) {
                return j(activity, (Map<String, Object>) null);
            }

            @Override // com.bytedance.msdk.api.r.j.j.cw
            @Nullable
            public com.bytedance.msdk.api.r.xt j(Activity activity, Map<String, Object> map) {
                final com.bytedance.sdk.openadsdk.i.cw.xt.ae j6 = cwVar.j(activity);
                return new com.bytedance.msdk.api.r.xt() { // from class: com.bytedance.msdk.cw.r.m.3.1
                    @Override // com.bytedance.msdk.api.r.xt
                    public void j() {
                        com.bytedance.sdk.openadsdk.i.cw.xt.ae aeVar = j6;
                        if (aeVar != null) {
                            aeVar.j();
                        }
                    }

                    @Override // com.bytedance.msdk.api.r.xt
                    public void j(final com.bytedance.msdk.api.r.ae aeVar) {
                        com.bytedance.sdk.openadsdk.i.cw.xt.ae aeVar2 = j6;
                        if (aeVar2 != null) {
                            aeVar2.j(new com.bytedance.sdk.openadsdk.kt.j.xt.j.j(null) { // from class: com.bytedance.msdk.cw.r.m.3.1.1
                                @Override // com.bytedance.sdk.openadsdk.kt.j.xt.j.j
                                public void j() {
                                    com.bytedance.msdk.api.r.ae aeVar3 = aeVar;
                                    if (aeVar3 != null) {
                                        aeVar3.xt();
                                    }
                                }

                                @Override // com.bytedance.sdk.openadsdk.kt.j.xt.j.j
                                public void xt() {
                                    com.bytedance.msdk.api.r.ae aeVar3 = aeVar;
                                    if (aeVar3 != null) {
                                        aeVar3.j();
                                    }
                                }

                                @Override // com.bytedance.sdk.openadsdk.kt.j.xt.j.j
                                public void j(int i6, String str, boolean z5) {
                                    com.bytedance.msdk.api.r.ae aeVar3 = aeVar;
                                    if (aeVar3 != null) {
                                        aeVar3.j(i6, str);
                                    }
                                }
                            });
                        }
                    }
                };
            }

            @Override // com.bytedance.msdk.api.r.j.j.cw
            public com.bytedance.sdk.openadsdk.i.cw.xt.ae xt(Dialog dialog, Integer[] numArr) {
                com.bytedance.msdk.xt.cw cwVar2 = cwVar;
                if (cwVar2 != null) {
                    return cwVar2.xt(dialog, numArr);
                }
                return null;
            }

            @Override // com.bytedance.msdk.api.r.j.j.cw
            public void j(Activity activity, com.bytedance.sdk.openadsdk.kt.j.xt.j.j jVar) {
                com.bytedance.msdk.xt.cw cwVar2 = cwVar;
                if (cwVar2 != null) {
                    cwVar2.j(activity, jVar);
                }
            }

            @Override // com.bytedance.msdk.api.r.j.j.cw
            public void j(Dialog dialog, Integer[] numArr) {
                com.bytedance.msdk.xt.cw cwVar2 = cwVar;
                if (cwVar2 != null) {
                    cwVar2.j(dialog, numArr);
                }
            }
        };
    }

    public void j(com.bytedance.msdk.api.r.j.j.j jVar) {
        this.f25060j = jVar;
    }

    private View j(Context context, com.bytedance.msdk.xt.cw cwVar) {
        this.f25123r = cwVar;
        this.cw.j(cwVar);
        this.f25123r.up(true);
        this.f25123r.j(this.f25120g);
        if (this.f25123r.ll() && com.bytedance.msdk.core.up.j.j.j().r(this.up, this.f25123r.qa(), this.f25122m.up())) {
            com.bytedance.msdk.xt.cw cwVar2 = this.f25123r;
            com.bytedance.msdk.cw.tl.up.j(cwVar2, this.up, cwVar2.qa());
        }
        j(false);
        com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, com.bytedance.msdk.j.up.up.j(this.up, AMPSConstants.FrequencyEventType.FREQUENCY_EVENT_TYPE_SHOW) + "展示的广告类型：" + com.bytedance.msdk.xt.j.j(this.f25123r.pz()) + ",slotId：" + this.f25123r.qa() + ",slotType:" + this.f25123r.xw());
        final View g6 = this.f25123r.g();
        if (!this.f25123r.dj() && this.f25123r.rh() == 4 && this.f25123r.ol() == 2 && !this.f25123r.aq()) {
            com.bytedance.msdk.api.r.j.j.r rVar = this.f25059i;
            if (rVar == null) {
                com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, "--==-- banner混出自渲染信息流，但未提供GMNativeToBannerListener，将无法展示该广告");
            } else {
                try {
                    g6 = rVar.j(cw(this.f25123r));
                    if (g6 == null) {
                        com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, "--==-- banner混出自渲染信息流，getGMBannerViewFromNativeAd()返回null，将无法展示该广告");
                    }
                } catch (Throwable th) {
                    com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, "--==-- banner混出自渲染信息流，getGMBannerViewFromNativeAd()发生异常，将无法展示该广告，信息如下：");
                    com.bytedance.sdk.component.utils.vl.j(th);
                }
            }
        }
        if (this.f25123r.kt() && context != null) {
            this.f25123r.j((Activity) context, new com.bytedance.sdk.openadsdk.kt.j.xt.j.j(null) { // from class: com.bytedance.msdk.cw.r.m.1
                @Override // com.bytedance.sdk.openadsdk.kt.j.xt.j.j
                public void j(int i6, String str, boolean z5) {
                    View view = g6;
                    if (view != null) {
                        View view2 = (View) view.getParent();
                        if (view2 instanceof ViewGroup) {
                            ((ViewGroup) view2).removeViewInLayout(g6);
                        }
                    }
                }
            });
        }
        return g6;
    }

    public void xt(com.bytedance.sdk.openadsdk.i.cw.j.xt xtVar) {
        com.bytedance.msdk.xt.cw cwVar = this.f25123r;
        if (cwVar != null) {
            cwVar.j(xtVar);
        }
    }

    public synchronized View j(Context context) {
        List<com.bytedance.msdk.core.oq.oq> list;
        View view;
        com.bytedance.msdk.xt.cw cwVar;
        com.bytedance.msdk.xt.cw next;
        com.bytedance.msdk.xt.cw cwVar2;
        com.bytedance.msdk.up.m.j(this.f25122m);
        if (this.vl) {
            com.bytedance.msdk.up.m.j((List<com.bytedance.msdk.xt.cw>) null, this.f25122m, 0);
            cw(new com.bytedance.msdk.api.j(40052, com.bytedance.msdk.api.j.j(40052)));
            return null;
        }
        int xt = xt.xt(this.up);
        if (xt != 0) {
            com.bytedance.msdk.up.m.j((List<com.bytedance.msdk.xt.cw>) null, this.f25122m, xt);
            cw(new com.bytedance.msdk.api.j(xt, com.bytedance.msdk.api.j.j(xt)));
            return null;
        }
        List<com.bytedance.msdk.xt.cw> kt = this.cw.kt();
        try {
            list = xt();
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.vl.j(th);
            list = null;
        }
        if (list != null && list.size() > 0) {
            HashMap<String, com.bytedance.msdk.xt.cw> xt2 = xt(kt);
            view = null;
            for (com.bytedance.msdk.core.oq.oq oqVar : list) {
                if (oqVar != null) {
                    String w5 = oqVar.w();
                    com.bytedance.msdk.xt.cw cwVar3 = xt2.get(w5);
                    if (cwVar3 != null && cwVar3.wq(this.up) && !cwVar3.qb() && (view = j(context, cwVar3)) != null) {
                        break;
                    }
                    if (oqVar.kt() && com.bytedance.msdk.core.up.j.j.j().r(this.up, w5, this.f25122m.up()) && com.bytedance.msdk.core.up.j.j.j().j(w5, this.f25122m, false) == 3) {
                        com.bytedance.msdk.core.up.j.j j6 = com.bytedance.msdk.core.up.j.j.j();
                        com.bytedance.msdk.api.j.xt xtVar = this.f25122m;
                        List<com.bytedance.msdk.core.up.xt.ae> j7 = j6.j(w5, xtVar, xtVar.up());
                        if (j7 != null && j7.size() > 0 && (cwVar2 = j7.get(0).f24739j) != null && cwVar2.wq(this.up) && !cwVar2.qb()) {
                            xt(cwVar2);
                            view = j(context, cwVar2);
                            if (view != null) {
                                break;
                            }
                        }
                    }
                }
            }
        } else {
            view = null;
        }
        if (view == null && kt != null && kt.size() > 0) {
            Iterator<com.bytedance.msdk.xt.cw> it = kt.iterator();
            while (it.hasNext() && ((next = it.next()) == null || !next.wq(this.up) || next.qb() || (view = j(context, next)) == null)) {
            }
        }
        if (view != null) {
            this.vl = true;
            List<com.bytedance.msdk.xt.cw> kt2 = this.cw.kt();
            com.bytedance.msdk.core.up.j.j j8 = com.bytedance.msdk.core.up.j.j.j();
            String str = this.up;
            com.bytedance.msdk.api.j.xt xtVar2 = this.f25122m;
            j8.j(kt2, str, xtVar2, xtVar2.up(), this.f25123r);
            if (this.f25123r != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.f25123r);
                com.bytedance.msdk.cw.up.j j9 = com.bytedance.msdk.cw.up.j.j();
                com.bytedance.msdk.api.j.xt xtVar3 = this.f25122m;
                j9.j(xtVar3, com.bytedance.msdk.cw.up.j.j(xtVar3, arrayList, kt2));
                j(arrayList);
            }
            com.bytedance.msdk.up.m.j(this.f25123r, this.f25122m, false, 0);
            if (this.f25060j != null && (cwVar = this.f25123r) != null && cwVar.pz() == 2) {
                com.bytedance.msdk.j.up.cw.j("ADMOB_EVENT", com.bytedance.msdk.j.up.up.xt(this.up, this.f25123r.qa()) + "mTTAdBannerListener-->Admob--->onAdShow......");
                com.bytedance.msdk.core.tl.jy.j().ae(this.up);
                com.bytedance.msdk.core.tl.jy.j().xt(this.up);
                this.f25060j.xt(null);
                if (this.f25123r != null) {
                    com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, com.bytedance.msdk.j.up.up.j(this.up, "show_listen") + "adSlotId：" + this.f25123r.qa() + "，广告类型：" + com.bytedance.msdk.xt.j.j(this.f25123r.pz()));
                    com.bytedance.msdk.core.tl.qv.j().xt(this.up, this.f25123r.qa());
                    com.bytedance.msdk.core.tl.vl.j().xt(this.up, this.f25123r.qa());
                }
                com.bytedance.msdk.xt.cw cwVar4 = this.f25123r;
                if (cwVar4 != null) {
                    com.bytedance.msdk.core.cw.cw.j(cwVar4.zz(), this.up, this.f25123r.qa());
                }
                j(true);
                com.bytedance.msdk.up.m.j(this.f25123r, this.f25122m, 0, (String) null, 0L, false);
                com.bytedance.msdk.core.ae.cw.j(this.up, this.f25123r);
            }
            return view;
        }
        com.bytedance.msdk.up.m.j(kt, this.f25122m, 0);
        cw(new com.bytedance.msdk.api.j(40052, com.bytedance.msdk.api.j.j(40052)));
        return null;
    }

    private void j(boolean z5) {
        com.bytedance.msdk.xt.cw cwVar = this.f25123r;
        if (cwVar != null && cwVar.ll() && com.bytedance.msdk.core.up.j.j.j().r(this.up, this.f25123r.qa(), this.f25122m.up())) {
            com.bytedance.msdk.core.up.j.j.j().j(this.f25123r.qa(), this.f25122m, this.cw.p(), z5, this.cw.h(), this.cw.wq(), this.tl.get());
        }
    }

    @Override // com.bytedance.msdk.cw.r.xt
    public void j() {
        if (!this.vl) {
            com.bytedance.msdk.core.up.j.j j6 = com.bytedance.msdk.core.up.j.j.j();
            List<com.bytedance.msdk.xt.cw> kt = this.cw.kt();
            String str = this.up;
            com.bytedance.msdk.api.j.xt xtVar = this.f25122m;
            j6.j(kt, str, xtVar, xtVar.up(), this.f25123r);
        }
        super.j();
        this.f25060j = null;
        this.xt = null;
    }

    @Override // com.bytedance.msdk.api.r.j.j.j
    public void j(View view) {
        String str;
        long j6;
        com.bytedance.msdk.api.r.j.j.j jVar = this.f25060j;
        if (jVar != null) {
            jVar.j(view);
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

    @Override // com.bytedance.msdk.api.r.j.j.j
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

    public void j(Activity activity, com.bytedance.sdk.openadsdk.kt.j.xt.j.j jVar) {
        com.bytedance.msdk.xt.cw cwVar = this.f25123r;
        if (cwVar != null) {
            cwVar.j(activity, jVar);
        }
    }

    public void j(Dialog dialog, Integer[] numArr) {
        com.bytedance.msdk.xt.cw cwVar = this.f25123r;
        if (cwVar != null) {
            cwVar.j(dialog, numArr);
        }
    }

    public com.bytedance.sdk.openadsdk.i.cw.xt.ae j(Activity activity) {
        com.bytedance.msdk.xt.cw cwVar = this.f25123r;
        if (cwVar != null) {
            return cwVar.j(activity);
        }
        return null;
    }

    public void j(com.bytedance.sdk.openadsdk.i.cw.j.cw cwVar) {
        com.bytedance.msdk.xt.cw cwVar2 = this.f25123r;
        if (cwVar2 != null) {
            cwVar2.j(cwVar);
        }
    }

    public void j(com.bytedance.sdk.openadsdk.s.j.xt.j.cw cwVar) {
        com.bytedance.msdk.xt.cw cwVar2 = this.f25123r;
        if (cwVar2 != null) {
            cwVar2.j(cwVar);
        }
    }
}
