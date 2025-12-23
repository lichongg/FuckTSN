package com.bytedance.sdk.gromore.j.j.ae.r;

import android.app.Activity;
import android.app.Dialog;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.bytedance.msdk.api.r.j.ae.tl;
import com.bytedance.msdk.core.tl.jy;
import com.bytedance.msdk.core.tl.qv;
import com.bytedance.msdk.cw.r.g;
import com.bytedance.msdk.tl.i;
import com.bytedance.msdk.tl.mi;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.gromore.j.j.r.oq;
import com.bytedance.sdk.openadsdk.i.cw.xt.ae;
import com.bytedance.sdk.openadsdk.i.cw.xt.ws;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class r extends ws {
    private com.bytedance.sdk.openadsdk.i.cw.j.cw ae;
    private com.bytedance.msdk.api.j.xt cw;

    /* renamed from: g, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.i.cw.j.xt f27392g;

    /* renamed from: j, reason: collision with root package name */
    private g f27393j;

    /* renamed from: m, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.s.j.xt.j.xt f27394m;

    /* renamed from: r, reason: collision with root package name */
    private View f27395r;
    private com.bytedance.sdk.openadsdk.mediation.ad.j.xt.j.xt tl;
    private com.bytedance.sdk.openadsdk.s.j.xt.j.cw up;
    private com.bytedance.msdk.xt.cw xt;

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.tl
    public void j(Double d6) {
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.tl
    public void xt(Double d6) {
    }

    private void av() {
        com.bytedance.msdk.xt.cw cwVar = this.xt;
        if (cwVar == null) {
            return;
        }
        int rh = cwVar.rh();
        if (rh != 4) {
            if (rh == 5) {
                jy();
                return;
            } else if (rh == 3) {
                qv();
                return;
            }
        }
        ws();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void az() {
        String str;
        long j6;
        if (this.xt == null || this.cw == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (mi.j(this.xt)) {
            str = mi.xt();
            j6 = System.currentTimeMillis() - currentTimeMillis;
        } else {
            str = null;
            j6 = -1;
        }
        String str2 = str;
        long j7 = j6;
        com.bytedance.msdk.core.xt.j.up(this.cw.v());
        com.bytedance.msdk.xt.cw cwVar = this.xt;
        com.bytedance.msdk.up.m.xt(cwVar, this.cw, 0, str2, j7, cwVar.gq());
    }

    private void jy() {
        com.bytedance.msdk.xt.cw cwVar = this.xt;
        if (cwVar == null) {
            return;
        }
        if (cwVar.aq()) {
            this.xt.j((com.bytedance.msdk.api.r.j.cw.j) new com.bytedance.msdk.api.r.j.cw.r() { // from class: com.bytedance.sdk.gromore.j.j.ae.r.r.5
                @Override // com.bytedance.msdk.api.r.j.cw.r
                public void j(View view, String str, int i6) {
                    if (r.this.f27394m != null) {
                        r.this.f27394m.j(view, str, i6);
                    }
                }

                @Override // com.bytedance.msdk.api.r.j.cw.r
                public void j(float f6, float f7) {
                    if (r.this.f27394m != null) {
                        r.this.f27394m.j((View) null, f6, f7);
                    }
                }

                @Override // com.bytedance.msdk.api.r.j.cw.j
                public void j(View view) {
                    if (r.this.f27394m != null) {
                        r.this.f27394m.j(view, 0);
                    }
                    r.this.az();
                }

                @Override // com.bytedance.msdk.api.r.j.cw.j
                public void j() {
                    r.this.j((View) null);
                }
            });
        } else {
            this.xt.j(new com.bytedance.msdk.api.r.j.cw.j() { // from class: com.bytedance.sdk.gromore.j.j.ae.r.r.6
                @Override // com.bytedance.msdk.api.r.j.cw.j
                public void j(View view) {
                    if (r.this.f27394m != null) {
                        r.this.f27394m.j(view, 0);
                    }
                    r.this.az();
                }

                @Override // com.bytedance.msdk.api.r.j.cw.j
                public void j() {
                    r.this.j((View) null);
                }
            });
        }
    }

    private void oq() {
        com.bytedance.msdk.xt.cw cwVar = this.xt;
        if (cwVar == null) {
            return;
        }
        cwVar.j(new tl() { // from class: com.bytedance.sdk.gromore.j.j.ae.r.r.1
            @Override // com.bytedance.msdk.api.r.j.ae.tl
            public void j() {
                if (r.this.up != null) {
                    r.this.up.j();
                }
            }

            @Override // com.bytedance.msdk.api.r.j.ae.tl
            public void cw() {
                if (r.this.up != null) {
                    r.this.up.cw();
                }
            }

            @Override // com.bytedance.msdk.api.r.j.ae.tl
            public void r() {
                if (r.this.up != null) {
                    r.this.up.r();
                }
            }

            @Override // com.bytedance.msdk.api.r.j.ae.tl
            public void up() {
                if (r.this.up != null) {
                    r.this.up.up();
                }
            }

            @Override // com.bytedance.msdk.api.r.j.ae.tl
            public void xt() {
                if (r.this.up != null) {
                    r.this.up.xt();
                }
            }

            @Override // com.bytedance.msdk.api.r.j.ae.tl
            public void j(com.bytedance.msdk.api.j jVar) {
                String str;
                long j6;
                long currentTimeMillis = System.currentTimeMillis();
                if (mi.j(r.this.xt)) {
                    str = mi.xt();
                    j6 = System.currentTimeMillis() - currentTimeMillis;
                } else {
                    str = null;
                    j6 = -1;
                }
                com.bytedance.msdk.up.m.j(r.this.xt, r.this.cw, (com.bytedance.msdk.api.j) null, 2, 0, str, j6);
                if (jVar == null || r.this.up == null) {
                    return;
                }
                r.this.up.j(jVar.f24334j, -1);
            }

            @Override // com.bytedance.msdk.api.r.j.ae.tl
            public void j(long j6, long j7) {
                if (r.this.up != null) {
                    r.this.up.j(j6, j7);
                }
            }
        });
        this.xt.j(new com.bytedance.msdk.api.r.j.xt() { // from class: com.bytedance.sdk.gromore.j.j.ae.r.r.2
            @Override // com.bytedance.msdk.api.r.j.xt
            public void j() {
                if (r.this.ae != null) {
                    r.this.ae.j();
                }
            }

            @Override // com.bytedance.msdk.api.r.j.xt
            public void xt() {
            }

            @Override // com.bytedance.msdk.api.r.j.xt
            public void xt(long j6, long j7, String str, String str2) {
                if (r.this.ae != null) {
                    r.this.ae.cw(j6, j7, str, str2);
                }
            }

            @Override // com.bytedance.msdk.api.r.j.xt
            public void j(long j6, long j7, int i6, int i7, String str, String str2) {
                if (r.this.ae != null) {
                    r.this.ae.j(j6, j7, str, str2);
                }
            }

            @Override // com.bytedance.msdk.api.r.j.xt
            public void j(long j6, long j7, String str, String str2) {
                if (r.this.ae != null) {
                    r.this.ae.xt(j6, j7, str, str2);
                }
            }

            @Override // com.bytedance.msdk.api.r.j.xt
            public void j(long j6, String str, String str2) {
                if (r.this.ae != null) {
                    r.this.ae.j(j6, str, str2);
                }
            }

            @Override // com.bytedance.msdk.api.r.j.xt
            public void j(String str, String str2) {
                if (r.this.ae != null) {
                    r.this.ae.j(str, str2);
                }
            }
        });
    }

    private void qv() {
        com.bytedance.msdk.xt.cw cwVar = this.xt;
        if (cwVar == null) {
            return;
        }
        cwVar.j((com.bytedance.msdk.j.xt.m) new com.bytedance.msdk.j.xt.j() { // from class: com.bytedance.sdk.gromore.j.j.ae.r.r.4
            @Override // com.bytedance.msdk.api.r.j.j.j
            public void j(@NonNull com.bytedance.msdk.api.j jVar) {
            }

            @Override // com.bytedance.msdk.api.r.j.j.j
            public void f_() {
                if (r.this.xt.mi() != null) {
                    r.this.xt.mi().j(0, "banner ad closed", false);
                }
            }

            @Override // com.bytedance.msdk.api.r.j.j.j
            public void j(View view) {
                if (r.this.f27394m != null) {
                    r.this.f27394m.j(view, 0);
                }
                r.this.az();
            }

            @Override // com.bytedance.msdk.api.r.j.j.j
            public void xt(View view) {
                r.this.j(view);
            }
        });
    }

    private void ws() {
        com.bytedance.msdk.xt.cw cwVar = this.xt;
        if (cwVar == null) {
            return;
        }
        if (cwVar.aq()) {
            this.xt.j((com.bytedance.msdk.api.r.j.ae.xt) new com.bytedance.msdk.api.r.j.ae.m() { // from class: com.bytedance.sdk.gromore.j.j.ae.r.r.7
                @Override // com.bytedance.msdk.api.r.j.ae.m
                public void j(View view, String str, int i6) {
                    if (r.this.f27394m != null) {
                        r.this.f27394m.j(view, str, i6);
                    }
                }

                @Override // com.bytedance.msdk.api.r.j.ae.m
                public void j(float f6, float f7) {
                    if (r.this.f27394m != null) {
                        r.this.f27394m.j((View) null, f6, f7);
                    }
                }

                @Override // com.bytedance.msdk.api.r.j.ae.xt
                public void j(View view) {
                    if (r.this.f27394m != null) {
                        r.this.f27394m.j(view, 0);
                    }
                    r.this.az();
                }

                @Override // com.bytedance.msdk.api.r.j.ae.xt
                public void j() {
                    r.this.j((View) null);
                }
            });
        } else {
            this.xt.j((com.bytedance.msdk.api.r.j.ae.xt) new com.bytedance.msdk.api.r.j.ae.cw() { // from class: com.bytedance.sdk.gromore.j.j.ae.r.r.8
                @Override // com.bytedance.msdk.api.r.j.ae.xt
                public void j(View view) {
                    if (r.this.f27394m != null) {
                        r.this.f27394m.j(view, 0);
                    }
                    r.this.az();
                }

                @Override // com.bytedance.msdk.api.r.j.ae.xt
                public void j() {
                    r.this.j((View) null);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.ws
    public int cw() {
        com.bytedance.msdk.xt.cw cwVar = this.xt;
        if (cwVar != null) {
            return cwVar.rr();
        }
        return -1;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.ws
    public com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.up g() {
        return new oq(new cw(this.f27393j, this.xt, this.cw));
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.tl
    public void j(Double d6, String str, String str2) {
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.ws
    public com.bytedance.sdk.openadsdk.i.cw.xt.r m() {
        com.bytedance.msdk.xt.cw cwVar = this.xt;
        if (cwVar != null) {
            return cwVar.kk();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.ws
    public void r() {
        com.bytedance.sdk.openadsdk.s.j.xt.j.xt xtVar;
        com.bytedance.msdk.xt.cw cwVar = this.xt;
        if (cwVar != null) {
            if (cwVar.aq()) {
                av();
                this.xt.qv();
                j(this.xt);
                if (this.xt.rh() != 3 || (xtVar = this.f27394m) == null) {
                    return;
                }
                xtVar.j((View) null, -1.0f, -2.0f);
                return;
            }
            com.bytedance.sdk.openadsdk.mediation.ad.j.xt.j.xt xtVar2 = this.tl;
            if (xtVar2 == null) {
                com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, "--==-- 自渲染信息流转模板，开发者未提供MediationNativeToBannerListener，将无法展示该广告");
                return;
            }
            try {
                View j6 = xtVar2.j(new com.bytedance.sdk.gromore.j.j.r.g(this.xt) { // from class: com.bytedance.sdk.gromore.j.j.ae.r.r.3
                    @Override // com.bytedance.sdk.gromore.j.j.r.g, com.bytedance.sdk.openadsdk.mediation.ad.j.xt.xt.j
                    public void j(final Activity activity, final ViewGroup viewGroup, final List<View> list, final List<View> list2, final List<View> list3, final com.bytedance.sdk.openadsdk.mediation.ad.j.xt.j.r rVar) {
                        r.this.j(true, new Handler.Callback() { // from class: com.bytedance.sdk.gromore.j.j.ae.r.r.3.1
                            @Override // android.os.Handler.Callback
                            public boolean handleMessage(@NonNull Message message) {
                                if (r.this.xt == null) {
                                    return false;
                                }
                                r.this.xt.j(activity, viewGroup, list, list2, list3, com.bytedance.msdk.api.r.j.ae.oq.j(rVar), null);
                                return false;
                            }
                        });
                    }
                });
                this.f27395r = j6;
                if (j6 != null) {
                    com.bytedance.sdk.openadsdk.s.j.xt.j.xt xtVar3 = this.f27394m;
                    if (xtVar3 != null) {
                        xtVar3.j(j6, 0.0f, 0.0f);
                        return;
                    }
                    return;
                }
                com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, "--==-- 自渲染信息流转模板，getMediationBannerViewFromNativeAd()返回null，将无法展示该广告");
                com.bytedance.sdk.openadsdk.s.j.xt.j.xt xtVar4 = this.f27394m;
                if (xtVar4 != null) {
                    xtVar4.j((View) null, "渲染失败", -99999);
                }
            } catch (Throwable th) {
                com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, "--==-- 自渲染信息流转模板，getMediationBannerViewFromNativeAd()发生异常，将无法展示该广告，信息如下：");
                vl.j(th);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.ws
    public Map<String, Object> tl() {
        com.bytedance.msdk.xt.cw cwVar = this.xt;
        if (cwVar == null) {
            return null;
        }
        Map<String, Object> p5 = cwVar.p();
        if (p5 == null) {
            com.bytedance.msdk.api.j.xt xtVar = this.cw;
            p5 = com.bytedance.msdk.cw.r.xt.cw(xtVar != null ? xtVar.v() : "");
        }
        if (this.xt.ya() && i.j()) {
            String j6 = i.j(com.bytedance.msdk.tl.ws.j(this.cw, this.xt, true));
            if (!TextUtils.isEmpty(j6)) {
                p5.put("get_show_ecpm_info", j6);
            }
        }
        return com.bytedance.sdk.gromore.j.xt.xt.j(p5, this.xt.b());
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.ws
    public void up() {
        com.bytedance.msdk.xt.cw cwVar = this.xt;
        if (cwVar != null) {
            try {
                cwVar.w();
            } catch (Throwable th) {
                vl.j(th);
            }
        }
    }

    public r(g gVar, com.bytedance.msdk.xt.cw cwVar, com.bytedance.msdk.api.j.xt xtVar, com.bytedance.sdk.openadsdk.mediation.ad.j.xt.j.xt xtVar2) {
        this.f27393j = gVar;
        this.tl = xtVar2;
        this.xt = cwVar;
        if (cwVar != null && cwVar.rh() == 3) {
            this.xt.ae(true);
        }
        this.cw = xtVar;
        oq();
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.ws
    public void j(JSONObject jSONObject) {
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.ws
    public int xt() {
        com.bytedance.msdk.xt.cw cwVar = this.xt;
        if (cwVar != null) {
            return cwVar.st();
        }
        return -1;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.ws
    public View j() {
        com.bytedance.msdk.xt.cw cwVar = this.xt;
        if (cwVar != null) {
            if (cwVar.aq()) {
                com.bytedance.msdk.up.m.j(this.cw);
                if (this.xt.yu() != null) {
                    this.xt.yu().j();
                }
                com.bytedance.msdk.xt.cw cwVar2 = this.xt;
                com.bytedance.msdk.up.m.j(cwVar2, this.cw, cwVar2.h(), 0);
                View g6 = this.xt.g();
                this.f27395r = g6;
                return g6;
            }
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(this.xt);
            com.bytedance.msdk.up.m.j(arrayList, this.cw, 0);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.ws
    public void j(com.bytedance.sdk.openadsdk.s.j.xt.j.xt xtVar) {
        this.f27394m = xtVar;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.ws
    public void j(com.bytedance.sdk.openadsdk.s.j.xt.j.j jVar) {
        this.f27394m = jVar;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.ws
    public void j(com.bytedance.sdk.openadsdk.i.cw.j.cw cwVar) {
        this.ae = cwVar;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.ws
    public void ae() {
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.ws
    public ae j(Activity activity) {
        com.bytedance.msdk.xt.cw cwVar = this.xt;
        if (cwVar != null) {
            return cwVar.j(activity);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.ws
    public void j(Activity activity, com.bytedance.sdk.openadsdk.kt.j.xt.j.j jVar) {
        com.bytedance.msdk.xt.cw cwVar = this.xt;
        if (cwVar == null || activity == null) {
            return;
        }
        cwVar.j(activity, jVar);
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.ws
    public void j(Dialog dialog, Integer[] numArr) {
        com.bytedance.msdk.xt.cw cwVar = this.xt;
        if (cwVar != null) {
            cwVar.j(dialog, numArr);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.ws
    public void j(String str) {
        com.bytedance.msdk.xt.cw cwVar = this.xt;
        if (cwVar != null) {
            cwVar.uf(str);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.ws
    public void j(int i6) {
        com.bytedance.msdk.xt.cw cwVar = this.xt;
        if (cwVar != null) {
            cwVar.v(i6);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.ws
    public void j(com.bytedance.sdk.openadsdk.s.j.xt.j.cw cwVar) {
        this.up = cwVar;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.ws
    public void j(boolean z5) {
        com.bytedance.msdk.xt.cw cwVar = this.xt;
        if (cwVar != null) {
            cwVar.oq(z5);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.tl
    public void j(com.bytedance.sdk.openadsdk.i.cw.j.xt xtVar) {
        this.f27392g = xtVar;
        com.bytedance.msdk.xt.cw cwVar = this.xt;
        if (cwVar != null) {
            cwVar.j(xtVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(View view) {
        com.bytedance.msdk.xt.cw cwVar;
        String str;
        long j6;
        if (this.cw == null || (cwVar = this.xt) == null) {
            return;
        }
        cwVar.m(true);
        com.bytedance.sdk.openadsdk.s.j.xt.j.xt xtVar = this.f27394m;
        if (xtVar != null) {
            xtVar.xt(view, 0);
        }
        com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, com.bytedance.msdk.j.up.up.j(this.cw.v(), "show_listen") + "adSlotId：" + this.xt.qa() + "，广告类型：" + com.bytedance.msdk.xt.j.j(this.xt.pz()));
        jy j7 = jy.j();
        StringBuilder sb = new StringBuilder();
        sb.append(this.cw.v());
        j7.ae(sb.toString());
        jy.j().xt(this.cw.v());
        qv.j().xt(this.cw.v(), this.xt.qa());
        com.bytedance.msdk.core.tl.vl.j().xt(this.cw.v(), this.xt.qa());
        com.bytedance.msdk.core.cw.cw.j(this.xt.zz(), this.cw.v(), this.xt.qa());
        if (this.xt.yu() != null) {
            this.xt.yu().j(this.xt);
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (mi.j(this.xt)) {
            str = mi.xt();
            j6 = System.currentTimeMillis() - currentTimeMillis;
        } else {
            str = null;
            j6 = -1;
        }
        String str2 = str;
        long j8 = j6;
        boolean la = this.xt.la();
        if (!la) {
            com.bytedance.msdk.core.xt.j.ae(this.cw.v());
            com.bytedance.msdk.core.xt.j.cw(this.cw.v());
            com.bytedance.msdk.core.g.r.j(1, this.cw.v(), this.xt.om(), this.xt.t());
        }
        com.bytedance.msdk.up.m.j(this.xt, this.cw, 0, str2, j8, la);
        com.bytedance.msdk.core.ae.cw.j(this.cw.v(), this.xt);
    }

    private void j(com.bytedance.msdk.xt.cw cwVar) {
        if (com.bytedance.msdk.core.xt.xt().la()) {
            com.bytedance.msdk.up.m.j(cwVar, this.cw, mi.j(), 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(boolean z5, Handler.Callback callback) {
        com.bytedance.msdk.up.m.j(this.cw);
        if (this.xt != null) {
            av();
            if (callback != null) {
                callback.handleMessage(null);
            }
            if (this.xt.yu() != null) {
                this.xt.yu().j();
            }
            j(this.xt);
            HashMap hashMap = new HashMap();
            hashMap.put("has_view_binder", Boolean.valueOf(z5));
            com.bytedance.msdk.xt.cw cwVar = this.xt;
            com.bytedance.msdk.up.m.j(cwVar, this.cw, cwVar.h(), 0, hashMap);
            return;
        }
        com.bytedance.msdk.up.m.j((List<com.bytedance.msdk.xt.cw>) null, this.cw, 0);
    }
}
