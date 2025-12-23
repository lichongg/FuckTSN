package com.bytedance.sdk.gromore.j.j.ae.r;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.bytedance.msdk.api.r.j.ae.tl;
import com.bytedance.msdk.core.tl.qv;
import com.bytedance.msdk.cw.r.g;
import com.bytedance.msdk.tl.i;
import com.bytedance.msdk.tl.mi;
import com.bytedance.msdk.tl.ws;
import com.bytedance.sdk.gromore.j.j.r.jy;
import com.bytedance.sdk.openadsdk.i.cw.xt.ae;
import com.bytedance.sdk.openadsdk.i.cw.xt.oq;
import com.bytedance.sdk.openadsdk.i.cw.xt.vl;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt extends oq {
    private com.bytedance.sdk.openadsdk.ch.j.xt.j.j ae;
    private com.bytedance.msdk.api.j.xt cw;

    /* renamed from: g, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.i.cw.j.cw f27410g;

    /* renamed from: j, reason: collision with root package name */
    private g f27411j;

    /* renamed from: m, reason: collision with root package name */
    private View f27412m;
    private com.bytedance.sdk.openadsdk.i.cw.j.xt oq;

    /* renamed from: r, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.v.j.xt.j.j f27413r;
    private com.bytedance.sdk.openadsdk.ch.j.xt.j.cw tl;
    private com.bytedance.sdk.openadsdk.v.j.xt.j.xt up;
    private com.bytedance.msdk.xt.cw xt;

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.jy
    public void j(com.bytedance.sdk.openadsdk.ch.j.xt.j.xt xtVar) {
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.tl
    public void xt(Double d6) {
    }

    private void gq() {
        com.bytedance.msdk.xt.cw cwVar = this.xt;
        if (cwVar == null) {
            return;
        }
        if (cwVar.aq()) {
            this.xt.j((com.bytedance.msdk.api.r.j.cw.j) new com.bytedance.msdk.api.r.j.cw.r() { // from class: com.bytedance.sdk.gromore.j.j.ae.r.xt.8
                @Override // com.bytedance.msdk.api.r.j.cw.r
                public void j(View view, String str, int i6) {
                    if (xt.this.tl instanceof com.bytedance.sdk.openadsdk.mediation.ad.j.xt.j.up) {
                        ((com.bytedance.sdk.openadsdk.mediation.ad.j.xt.j.up) xt.this.tl).j(view, str, i6);
                    }
                }

                @Override // com.bytedance.msdk.api.r.j.cw.r
                public void j(float f6, float f7) {
                    if (xt.this.tl != null) {
                        xt.this.tl.j(xt.this.f27412m, f6, f7, true);
                    }
                }

                @Override // com.bytedance.msdk.api.r.j.cw.j
                public void j(View view) {
                    xt.this.j(view);
                }

                @Override // com.bytedance.msdk.api.r.j.cw.j
                public void j() {
                    xt.this.xt((View) null);
                }
            });
        } else {
            this.xt.j(new com.bytedance.msdk.api.r.j.cw.j() { // from class: com.bytedance.sdk.gromore.j.j.ae.r.xt.9
                @Override // com.bytedance.msdk.api.r.j.cw.j
                public void j(View view) {
                    xt.this.j(view);
                }

                @Override // com.bytedance.msdk.api.r.j.cw.j
                public void j() {
                    xt.this.xt((View) null);
                }
            });
        }
    }

    private void h() {
        int rh = this.xt.rh();
        if (rh != 4) {
            if (rh == 5) {
                gq();
                return;
            } else if (rh == 3) {
                la();
                return;
            }
        }
        rn();
    }

    private void l() {
        com.bytedance.msdk.xt.cw cwVar = this.xt;
        if (cwVar == null || !cwVar.aq()) {
            return;
        }
        com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "当前广告为模版广告，不能使用自渲染接口进行渲染，请使用render进行渲染");
    }

    private void la() {
        com.bytedance.msdk.xt.cw cwVar = this.xt;
        if (cwVar == null) {
            return;
        }
        cwVar.j((com.bytedance.msdk.j.xt.m) new com.bytedance.msdk.j.xt.j() { // from class: com.bytedance.sdk.gromore.j.j.ae.r.xt.7
            @Override // com.bytedance.msdk.api.r.j.j.j
            public void j(@NonNull com.bytedance.msdk.api.j jVar) {
            }

            @Override // com.bytedance.msdk.api.r.j.j.j
            public void f_() {
                if (xt.this.xt.mi() != null) {
                    xt.this.xt.mi().j(0, "banner ad closed", false);
                }
            }

            @Override // com.bytedance.msdk.api.r.j.j.j
            public void j(View view) {
                xt.this.j(view);
            }

            @Override // com.bytedance.msdk.api.r.j.j.j
            public void xt(View view) {
                xt.this.xt(view);
            }
        });
    }

    private void p() {
        com.bytedance.msdk.xt.cw cwVar = this.xt;
        if (cwVar == null || cwVar.aq()) {
            return;
        }
        com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "当前广告为自渲染广告，不能使用模版接口进行渲染，请使用registerViewForInteraction进行渲染");
    }

    private void rn() {
        com.bytedance.msdk.xt.cw cwVar = this.xt;
        if (cwVar == null) {
            return;
        }
        if (cwVar.aq()) {
            this.xt.j((com.bytedance.msdk.api.r.j.ae.xt) new com.bytedance.msdk.api.r.j.ae.m() { // from class: com.bytedance.sdk.gromore.j.j.ae.r.xt.10
                @Override // com.bytedance.msdk.api.r.j.ae.m
                public void j(View view, String str, int i6) {
                    if (xt.this.tl instanceof com.bytedance.sdk.openadsdk.mediation.ad.j.xt.j.up) {
                        ((com.bytedance.sdk.openadsdk.mediation.ad.j.xt.j.up) xt.this.tl).j(view, str, i6);
                    }
                }

                @Override // com.bytedance.msdk.api.r.j.ae.m
                public void j(float f6, float f7) {
                    if (xt.this.tl != null) {
                        xt.this.tl.j(xt.this.f27412m, f6, f7, true);
                    }
                }

                @Override // com.bytedance.msdk.api.r.j.ae.xt
                public void j(View view) {
                    xt.this.j(view);
                }

                @Override // com.bytedance.msdk.api.r.j.ae.xt
                public void j() {
                    xt.this.xt((View) null);
                }
            });
        } else {
            this.xt.j((com.bytedance.msdk.api.r.j.ae.xt) new com.bytedance.msdk.api.r.j.ae.cw() { // from class: com.bytedance.sdk.gromore.j.j.ae.r.xt.2
                @Override // com.bytedance.msdk.api.r.j.ae.xt
                public void j(View view) {
                    xt.this.j(view);
                }

                @Override // com.bytedance.msdk.api.r.j.ae.xt
                public void j() {
                    xt.this.xt((View) null);
                }
            });
        }
    }

    private void s() {
        com.bytedance.msdk.xt.cw cwVar = this.xt;
        if (cwVar != null) {
            cwVar.j(new tl() { // from class: com.bytedance.sdk.gromore.j.j.ae.r.xt.1
                @Override // com.bytedance.msdk.api.r.j.ae.tl
                public void j() {
                    if (xt.this.f27413r != null) {
                        xt.this.f27413r.j(xt.this);
                    }
                }

                @Override // com.bytedance.msdk.api.r.j.ae.tl
                public void cw() {
                    if (xt.this.f27413r != null) {
                        xt.this.f27413r.cw(xt.this);
                    }
                }

                @Override // com.bytedance.msdk.api.r.j.ae.tl
                public void r() {
                    if (xt.this.f27413r != null) {
                        xt.this.f27413r.r(xt.this);
                    }
                }

                @Override // com.bytedance.msdk.api.r.j.ae.tl
                public void up() {
                    if (xt.this.f27413r != null) {
                        xt.this.f27413r.up(xt.this);
                    }
                }

                @Override // com.bytedance.msdk.api.r.j.ae.tl
                public void xt() {
                    if (xt.this.f27413r != null) {
                        xt.this.f27413r.xt(xt.this);
                    }
                }

                @Override // com.bytedance.msdk.api.r.j.ae.tl
                public void j(com.bytedance.msdk.api.j jVar) {
                    String str;
                    long j6;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (mi.j(xt.this.xt)) {
                        str = mi.xt();
                        j6 = System.currentTimeMillis() - currentTimeMillis;
                    } else {
                        str = null;
                        j6 = -1;
                    }
                    com.bytedance.msdk.up.m.j(xt.this.xt, xt.this.cw, (com.bytedance.msdk.api.j) null, 2, 0, str, j6);
                    if (jVar == null || xt.this.f27413r == null) {
                        return;
                    }
                    xt.this.f27413r.j(jVar.f24334j, -1);
                }

                @Override // com.bytedance.msdk.api.r.j.ae.tl
                public void j(long j6, long j7) {
                    if (xt.this.f27413r != null) {
                        xt.this.f27413r.j(j6, j7);
                    }
                }
            });
            this.xt.j(new com.bytedance.msdk.api.r.j.xt() { // from class: com.bytedance.sdk.gromore.j.j.ae.r.xt.3
                @Override // com.bytedance.msdk.api.r.j.xt
                public void j() {
                    if (xt.this.f27410g != null) {
                        xt.this.f27410g.j();
                    }
                }

                @Override // com.bytedance.msdk.api.r.j.xt
                public void xt() {
                }

                @Override // com.bytedance.msdk.api.r.j.xt
                public void xt(long j6, long j7, String str, String str2) {
                    if (xt.this.f27410g != null) {
                        xt.this.f27410g.cw(j6, j7, str, str2);
                    }
                }

                @Override // com.bytedance.msdk.api.r.j.xt
                public void j(long j6, long j7, int i6, int i7, String str, String str2) {
                    if (xt.this.f27410g != null) {
                        xt.this.f27410g.j(j6, j7, str, str2);
                    }
                }

                @Override // com.bytedance.msdk.api.r.j.xt
                public void j(long j6, long j7, String str, String str2) {
                    if (xt.this.f27410g != null) {
                        xt.this.f27410g.xt(j6, j7, str, str2);
                    }
                }

                @Override // com.bytedance.msdk.api.r.j.xt
                public void j(long j6, String str, String str2) {
                    if (xt.this.f27410g != null) {
                        xt.this.f27410g.j(j6, str, str2);
                    }
                }

                @Override // com.bytedance.msdk.api.r.j.xt
                public void j(String str, String str2) {
                    if (xt.this.f27410g != null) {
                        xt.this.f27410g.j(str, str2);
                    }
                }
            });
            this.xt.j(new com.bytedance.msdk.api.r.j.ae.g() { // from class: com.bytedance.sdk.gromore.j.j.ae.r.xt.4
                @Override // com.bytedance.msdk.api.r.j.ae.g
                public void j(int i6) {
                    if (xt.this.up != null) {
                        xt.this.up.j(i6);
                    }
                }
            });
        }
    }

    private void wq() {
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

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.jy
    public String ae() {
        com.bytedance.msdk.xt.cw cwVar = this.xt;
        if (cwVar != null) {
            return cwVar.zs();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.jy
    public int av() {
        com.bytedance.msdk.xt.cw cwVar = this.xt;
        if (cwVar != null) {
            return cwVar.rr();
        }
        return -1;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.jy
    public List<vl> az() {
        ArrayList arrayList = new ArrayList();
        com.bytedance.msdk.xt.cw cwVar = this.xt;
        List<String> tk = cwVar != null ? cwVar.tk() : null;
        com.bytedance.msdk.xt.cw cwVar2 = this.xt;
        String na = cwVar2 != null ? cwVar2.na() : null;
        if (tk != null) {
            if (tk.size() != 0) {
                Iterator<String> it = tk.iterator();
                while (it.hasNext()) {
                    arrayList.add(new jy(it.next()));
                }
            } else if (!TextUtils.isEmpty(na)) {
                com.bytedance.msdk.xt.cw cwVar3 = this.xt;
                int gr = cwVar3 != null ? cwVar3.gr() : 0;
                com.bytedance.msdk.xt.cw cwVar4 = this.xt;
                arrayList.add(new jy(na, gr, cwVar4 != null ? cwVar4.et() : 0));
            }
        }
        return arrayList;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.jy
    public com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.up ch() {
        return new com.bytedance.sdk.gromore.j.j.r.oq(new cw(this.f27411j, this.xt, this.cw));
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.oq
    public int cw() {
        com.bytedance.msdk.xt.cw cwVar = this.xt;
        if (cwVar != null) {
            if (cwVar.aq()) {
                View view = this.f27412m;
                if (view != null) {
                    return view.getWidth();
                }
                return 0;
            }
            com.bytedance.msdk.xt.cw cwVar2 = this.xt;
            if (cwVar2 != null) {
                return cwVar2.el();
            }
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.jy
    public Map<String, Object> f() {
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
            String j6 = i.j(ws.j(this.cw, this.xt, true));
            if (!TextUtils.isEmpty(j6)) {
                p5.put("get_show_ecpm_info", j6);
            }
        }
        return com.bytedance.sdk.gromore.j.xt.xt.j(p5, this.xt.b());
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.jy
    public String g() {
        com.bytedance.msdk.xt.cw cwVar = this.xt;
        return cwVar != null ? cwVar.ov() : "";
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.jy
    public int i() {
        com.bytedance.msdk.xt.cw cwVar = this.xt;
        if (cwVar != null) {
            return cwVar.st();
        }
        return -1;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.tl
    public void j(Double d6) {
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.jy
    public String jy() {
        com.bytedance.msdk.xt.cw cwVar = this.xt;
        if (cwVar != null) {
            return cwVar.jl();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.jy
    public com.bytedance.sdk.openadsdk.i.cw.xt.up kt() {
        return new com.bytedance.sdk.gromore.j.j.r.r(this.xt);
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.jy
    public Bitmap m() {
        com.bytedance.msdk.xt.cw cwVar = this.xt;
        if (cwVar != null) {
            return cwVar.ja();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.jy
    public com.bytedance.sdk.openadsdk.i.cw.xt.cw mi() {
        return new com.bytedance.sdk.gromore.j.j.r.xt(this.xt);
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.jy
    public int oq() {
        com.bytedance.msdk.xt.cw cwVar = this.xt;
        if (cwVar != null) {
            return (int) cwVar.rs();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.jy
    public int qv() {
        com.bytedance.msdk.xt.cw cwVar = this.xt;
        if (cwVar != null) {
            return cwVar.fs();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.oq
    public int r() {
        com.bytedance.msdk.xt.cw cwVar = this.xt;
        if (cwVar != null) {
            if (cwVar.aq()) {
                View view = this.f27412m;
                if (view != null) {
                    return view.getHeight();
                }
                return 0;
            }
            com.bytedance.msdk.xt.cw cwVar2 = this.xt;
            if (cwVar2 != null) {
                return cwVar2.hu();
            }
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.jy
    public View tj() {
        com.bytedance.msdk.xt.cw cwVar = this.xt;
        if (cwVar == null) {
            return null;
        }
        if (!cwVar.aq()) {
            return this.xt.oq();
        }
        com.bytedance.msdk.up.m.j(this.cw);
        if (this.xt.yu() != null) {
            this.xt.yu().j();
        }
        com.bytedance.msdk.xt.cw cwVar2 = this.xt;
        com.bytedance.msdk.up.m.j(cwVar2, this.cw, cwVar2.h(), 0);
        View g6 = this.xt.g();
        this.f27412m = g6;
        return g6;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.jy
    public String tl() {
        com.bytedance.msdk.xt.cw cwVar = this.xt;
        if (cwVar != null) {
            return cwVar.qg();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.jy
    public vl up() {
        com.bytedance.msdk.xt.cw cwVar = this.xt;
        if (cwVar != null) {
            return cwVar.zk();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.jy
    public int vl() {
        com.bytedance.msdk.xt.cw cwVar = this.xt;
        if (cwVar != null) {
            return cwVar.nu();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.jy
    public com.bytedance.sdk.openadsdk.i.cw.xt.r w() {
        com.bytedance.msdk.xt.cw cwVar = this.xt;
        if (cwVar != null) {
            return cwVar.kk();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.jy
    public vl ws() {
        com.bytedance.msdk.xt.cw cwVar = this.xt;
        return new jy(cwVar != null ? cwVar.fx() : null);
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.jy
    public void x() {
        com.bytedance.msdk.xt.cw cwVar = this.xt;
        if (cwVar != null) {
            try {
                cwVar.w();
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.vl.j(th);
            }
        }
    }

    public xt(g gVar, com.bytedance.msdk.xt.cw cwVar, com.bytedance.msdk.api.j.xt xtVar) {
        this.f27411j = gVar;
        this.xt = cwVar;
        if (cwVar != null && cwVar.rh() == 3) {
            this.xt.ae(true);
        }
        this.cw = xtVar;
        s();
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.tl
    public void j(Double d6, String str, String str2) {
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.jy
    public void v() {
        com.bytedance.sdk.openadsdk.ch.j.xt.j.cw cwVar;
        p();
        if (this.xt != null) {
            h();
            this.xt.qv();
            j(this.xt);
            if (this.xt.rh() == 3 && (cwVar = this.tl) != null) {
                cwVar.j(this.f27412m, -1.0f, -2.0f, true);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.oq
    public com.bytedance.sdk.openadsdk.v.j.xt.xt.j xt() {
        return new com.bytedance.sdk.gromore.j.j.r.cw(this.xt);
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.jy
    public void xt(Activity activity) {
        com.bytedance.msdk.xt.cw cwVar = this.xt;
        if (cwVar != null) {
            cwVar.xt(activity);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.oq
    public void j(com.bytedance.sdk.openadsdk.v.j.xt.j.j jVar) {
        this.f27413r = jVar;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.oq
    public void j(com.bytedance.sdk.openadsdk.v.j.xt.j.xt xtVar) {
        this.up = xtVar;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.jy
    public void xt(Dialog dialog, Integer[] numArr) {
        com.bytedance.msdk.xt.cw cwVar = this.xt;
        if (cwVar != null) {
            cwVar.j(dialog, numArr);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.oq
    public double j() {
        com.bytedance.msdk.xt.cw cwVar = this.xt;
        if (cwVar != null) {
            return cwVar.hw();
        }
        return 0.0d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xt(View view) {
        com.bytedance.msdk.xt.cw cwVar;
        String str;
        long j6;
        if (this.cw == null || (cwVar = this.xt) == null) {
            return;
        }
        cwVar.m(true);
        com.bytedance.sdk.openadsdk.ch.j.xt.j.cw cwVar2 = this.tl;
        if (cwVar2 instanceof com.bytedance.sdk.openadsdk.mediation.ad.j.xt.j.up) {
            ((com.bytedance.sdk.openadsdk.mediation.ad.j.xt.j.up) cwVar2).xt();
        }
        com.bytedance.sdk.openadsdk.ch.j.xt.j.j jVar = this.ae;
        if (jVar != null) {
            jVar.j(this);
        }
        com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, com.bytedance.msdk.j.up.up.j(this.cw.v(), "show_listen") + "adSlotId：" + this.xt.qa() + "，广告类型：" + com.bytedance.msdk.xt.j.j(this.xt.pz()));
        com.bytedance.msdk.core.tl.jy j7 = com.bytedance.msdk.core.tl.jy.j();
        StringBuilder sb = new StringBuilder();
        sb.append(this.cw.v());
        j7.ae(sb.toString());
        com.bytedance.msdk.core.tl.jy.j().xt(this.cw.v());
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
        com.bytedance.msdk.api.j.xt xtVar = this.cw;
        com.bytedance.msdk.core.ae.cw.j(xtVar != null ? xtVar.v() : "", this.xt);
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.jy
    public ae j(Activity activity) {
        com.bytedance.msdk.xt.cw cwVar = this.xt;
        if (cwVar != null) {
            return cwVar.j(activity);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.jy
    public ae j(Dialog dialog, Integer[] numArr) {
        com.bytedance.msdk.xt.cw cwVar = this.xt;
        if (cwVar != null) {
            return cwVar.xt(dialog, numArr);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.jy
    public void j(ViewGroup viewGroup, View view, com.bytedance.sdk.openadsdk.ch.j.xt.j.j jVar) {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(view);
        j(viewGroup, (List<View>) null, arrayList, (List<View>) null, (List<View>) null, (View) null, jVar);
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.jy
    public void j(ViewGroup viewGroup, List<View> list, List<View> list2, com.bytedance.sdk.openadsdk.ch.j.xt.j.j jVar) {
        j(viewGroup, (List<View>) null, list, list2, (List<View>) null, (View) null, jVar);
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.jy
    public void j(ViewGroup viewGroup, List<View> list, List<View> list2, View view, com.bytedance.sdk.openadsdk.ch.j.xt.j.j jVar) {
        j(viewGroup, (List<View>) null, list, list2, (List<View>) null, view, jVar);
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.jy
    public void j(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, View view, com.bytedance.sdk.openadsdk.ch.j.xt.j.j jVar) {
        j(viewGroup, list, list2, list3, (List<View>) null, view, jVar);
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.jy
    public void j(final ViewGroup viewGroup, final List<View> list, final List<View> list2, final List<View> list3, final List<View> list4, final View view, com.bytedance.sdk.openadsdk.ch.j.xt.j.j jVar) {
        l();
        if (this.xt != null) {
            j(jVar);
            j(false, new Handler.Callback() { // from class: com.bytedance.sdk.gromore.j.j.ae.r.xt.5
                @Override // android.os.Handler.Callback
                public boolean handleMessage(@NonNull Message message) {
                    if (TextUtils.equals(xt.this.xt.ff(), MediationConstant.ADN_PANGLE)) {
                        xt.this.xt.j(viewGroup, list, list2, list3, list4, view);
                        return false;
                    }
                    xt.this.xt.j(null, viewGroup, list2, list3, list4, null, list);
                    return false;
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.jy
    public void j(final Activity activity, final ViewGroup viewGroup, final List<View> list, final List<View> list2, final List<View> list3, com.bytedance.sdk.openadsdk.ch.j.xt.j.j jVar, final com.bytedance.sdk.openadsdk.mediation.ad.j.xt.j.r rVar) {
        l();
        if (this.xt != null) {
            j(jVar);
            j(true, new Handler.Callback() { // from class: com.bytedance.sdk.gromore.j.j.ae.r.xt.6
                @Override // android.os.Handler.Callback
                public boolean handleMessage(@NonNull Message message) {
                    xt.this.xt.j(activity, viewGroup, list, list2, list3, com.bytedance.msdk.api.r.j.ae.oq.j(rVar), null);
                    return false;
                }
            });
        }
    }

    private void j(com.bytedance.sdk.openadsdk.ch.j.xt.j.j jVar) {
        this.ae = jVar;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.jy
    public void j(com.bytedance.sdk.openadsdk.i.cw.j.cw cwVar) {
        this.f27410g = cwVar;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.jy
    public void j(com.bytedance.sdk.openadsdk.ch.j.xt.j.cw cwVar) {
        this.tl = cwVar;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.jy
    public void j(Activity activity, com.bytedance.sdk.openadsdk.kt.j.xt.j.j jVar) {
        com.bytedance.msdk.xt.cw cwVar = this.xt;
        if (cwVar == null || activity == null) {
            return;
        }
        cwVar.j(activity, jVar);
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.jy
    public void j(String str) {
        com.bytedance.msdk.xt.cw cwVar = this.xt;
        if (cwVar != null) {
            cwVar.uf(str);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.tl
    public void j(com.bytedance.sdk.openadsdk.i.cw.j.xt xtVar) {
        this.oq = xtVar;
        com.bytedance.msdk.xt.cw cwVar = this.xt;
        if (cwVar != null) {
            cwVar.j(xtVar);
        }
    }

    private void j(boolean z5, Handler.Callback callback) {
        com.bytedance.msdk.up.m.j(this.cw);
        if (this.xt != null) {
            h();
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

    private void j(com.bytedance.msdk.xt.cw cwVar) {
        if (com.bytedance.msdk.core.xt.xt().la()) {
            com.bytedance.msdk.up.m.j(cwVar, this.cw, mi.j(), 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(View view) {
        com.bytedance.sdk.openadsdk.ch.j.xt.j.cw cwVar = this.tl;
        if (cwVar instanceof com.bytedance.sdk.openadsdk.mediation.ad.j.xt.j.up) {
            ((com.bytedance.sdk.openadsdk.mediation.ad.j.xt.j.up) cwVar).j();
        }
        com.bytedance.sdk.openadsdk.ch.j.xt.j.j jVar = this.ae;
        if (jVar != null) {
            jVar.j(view, this);
        }
        wq();
    }
}
