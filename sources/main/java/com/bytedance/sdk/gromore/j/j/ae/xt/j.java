package com.bytedance.sdk.gromore.j.j.ae.xt;

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
import com.bytedance.msdk.core.tl.jy;
import com.bytedance.msdk.core.tl.qv;
import com.bytedance.msdk.core.tl.vl;
import com.bytedance.msdk.cw.r.ae;
import com.bytedance.msdk.tl.i;
import com.bytedance.msdk.tl.mi;
import com.bytedance.msdk.tl.ws;
import com.bytedance.msdk.up.m;
import com.bytedance.sdk.gromore.j.j.r.oq;
import com.bytedance.sdk.openadsdk.i.cw.xt.g;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.mediation.ad.j.xt.j.up;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j extends g {
    private com.bytedance.sdk.openadsdk.v.j.xt.j.j ae;
    private com.bytedance.msdk.api.j.xt cw;

    /* renamed from: j, reason: collision with root package name */
    private ae f27438j;

    /* renamed from: m, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.ch.j.xt.j.j f27439m;

    /* renamed from: r, reason: collision with root package name */
    private View f27440r;
    private com.bytedance.sdk.openadsdk.i.cw.j.xt tl;
    private com.bytedance.sdk.openadsdk.ch.j.xt.j.cw up;
    private com.bytedance.msdk.xt.cw xt;

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.jy
    public void j(com.bytedance.sdk.openadsdk.ch.j.xt.j.xt xtVar) {
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.tl
    public void xt(Double d6) {
    }

    private void h() {
        com.bytedance.msdk.xt.cw cwVar = this.xt;
        if (cwVar == null) {
            return;
        }
        if (cwVar.aq()) {
            this.xt.j((com.bytedance.msdk.api.r.j.cw.j) new com.bytedance.msdk.api.r.j.cw.r() { // from class: com.bytedance.sdk.gromore.j.j.ae.xt.j.4
                @Override // com.bytedance.msdk.api.r.j.cw.r
                public void j(View view, String str, int i6) {
                    if (j.this.up instanceof up) {
                        ((up) j.this.up).j(view, str, i6);
                    }
                }

                @Override // com.bytedance.msdk.api.r.j.cw.r
                public void j(float f6, float f7) {
                    if (j.this.up != null) {
                        j.this.up.j(j.this.f27440r, f6, f7, true);
                    }
                }

                @Override // com.bytedance.msdk.api.r.j.cw.j
                public void j(View view) {
                    j.this.j(view);
                }

                @Override // com.bytedance.msdk.api.r.j.cw.j
                public void j() {
                    j.this.la();
                }
            });
        } else {
            this.xt.j(new com.bytedance.msdk.api.r.j.cw.j() { // from class: com.bytedance.sdk.gromore.j.j.ae.xt.j.5
                @Override // com.bytedance.msdk.api.r.j.cw.j
                public void j(View view) {
                    j.this.j(view);
                }

                @Override // com.bytedance.msdk.api.r.j.cw.j
                public void j() {
                    j.this.la();
                }
            });
        }
    }

    private void l() {
        com.bytedance.msdk.xt.cw cwVar = this.xt;
        if (cwVar == null || !cwVar.aq()) {
            return;
        }
        com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "当前广告为模版广告，不能使用自渲染接口进行渲染，请使用render进行渲染");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void la() {
        com.bytedance.msdk.xt.cw cwVar;
        String str;
        long j6;
        if (this.cw == null || (cwVar = this.xt) == null) {
            return;
        }
        cwVar.m(true);
        com.bytedance.sdk.openadsdk.ch.j.xt.j.cw cwVar2 = this.up;
        if (cwVar2 instanceof up) {
            ((up) cwVar2).xt();
        }
        com.bytedance.sdk.openadsdk.ch.j.xt.j.j jVar = this.f27439m;
        if (jVar != null) {
            jVar.j(this);
        }
        com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, com.bytedance.msdk.j.up.up.j(this.cw.v(), "show_listen") + "adSlotId：" + this.xt.qa() + "，广告类型：" + com.bytedance.msdk.xt.j.j(this.xt.pz()));
        jy j7 = jy.j();
        StringBuilder sb = new StringBuilder();
        sb.append(this.cw.v());
        j7.ae(sb.toString());
        jy.j().xt(this.cw.v());
        qv.j().xt(this.cw.v(), this.xt.qa());
        vl.j().xt(this.cw.v(), this.xt.qa());
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
        m.j(this.xt, this.cw, 0, str2, j8, la);
        com.bytedance.msdk.api.j.xt xtVar = this.cw;
        com.bytedance.msdk.core.ae.cw.j(xtVar != null ? xtVar.v() : "", this.xt);
    }

    private void p() {
        com.bytedance.msdk.xt.cw cwVar = this.xt;
        if (cwVar == null || cwVar.aq()) {
            return;
        }
        com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "当前广告为自渲染广告，不能使用模版接口进行渲染，请使用registerViewForInteraction进行渲染");
    }

    private void s() {
        com.bytedance.msdk.xt.cw cwVar = this.xt;
        if (cwVar != null) {
            cwVar.j(new tl() { // from class: com.bytedance.sdk.gromore.j.j.ae.xt.j.1
                @Override // com.bytedance.msdk.api.r.j.ae.tl
                public void j() {
                    if (j.this.ae != null) {
                        j.this.ae.j(j.this);
                    }
                }

                @Override // com.bytedance.msdk.api.r.j.ae.tl
                public void cw() {
                    if (j.this.ae != null) {
                        j.this.ae.cw(j.this);
                    }
                }

                @Override // com.bytedance.msdk.api.r.j.ae.tl
                public void r() {
                    if (j.this.ae != null) {
                        j.this.ae.r(j.this);
                    }
                }

                @Override // com.bytedance.msdk.api.r.j.ae.tl
                public void up() {
                    if (j.this.ae != null) {
                        j.this.ae.up(j.this);
                    }
                }

                @Override // com.bytedance.msdk.api.r.j.ae.tl
                public void xt() {
                    if (j.this.ae != null) {
                        j.this.ae.xt(j.this);
                    }
                }

                @Override // com.bytedance.msdk.api.r.j.ae.tl
                public void j(com.bytedance.msdk.api.j jVar) {
                    String str;
                    long j6;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (mi.j(j.this.xt)) {
                        str = mi.xt();
                        j6 = System.currentTimeMillis() - currentTimeMillis;
                    } else {
                        str = null;
                        j6 = -1;
                    }
                    m.j(j.this.xt, j.this.cw, (com.bytedance.msdk.api.j) null, 2, 0, str, j6);
                    if (jVar == null || j.this.ae == null) {
                        return;
                    }
                    j.this.ae.j(jVar.f24334j, -1);
                }

                @Override // com.bytedance.msdk.api.r.j.ae.tl
                public void j(long j6, long j7) {
                    if (j.this.ae != null) {
                        j.this.ae.j(j6, j7);
                    }
                }
            });
        }
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
    public List<com.bytedance.sdk.openadsdk.i.cw.xt.vl> az() {
        ArrayList arrayList = new ArrayList();
        com.bytedance.msdk.xt.cw cwVar = this.xt;
        List<String> tk = cwVar != null ? cwVar.tk() : null;
        com.bytedance.msdk.xt.cw cwVar2 = this.xt;
        String na = cwVar2 != null ? cwVar2.na() : null;
        if (tk != null) {
            if (tk.size() != 0) {
                Iterator<String> it = tk.iterator();
                while (it.hasNext()) {
                    arrayList.add(new com.bytedance.sdk.gromore.j.j.r.jy(it.next()));
                }
            } else if (!TextUtils.isEmpty(na)) {
                com.bytedance.msdk.xt.cw cwVar3 = this.xt;
                int gr = cwVar3 != null ? cwVar3.gr() : 0;
                com.bytedance.msdk.xt.cw cwVar4 = this.xt;
                arrayList.add(new com.bytedance.sdk.gromore.j.j.r.jy(na, gr, cwVar4 != null ? cwVar4.et() : 0));
            }
        }
        return arrayList;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.jy
    public com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.up ch() {
        return new oq(new xt(this.f27438j, this.xt, this.cw));
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.oq
    public int cw() {
        com.bytedance.msdk.xt.cw cwVar = this.xt;
        if (cwVar != null) {
            if (cwVar.aq()) {
                View view = this.f27440r;
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
        if (cwVar != null) {
            return cwVar.ov();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.jy
    public int i() {
        com.bytedance.msdk.xt.cw cwVar = this.xt;
        if (cwVar != null) {
            return cwVar.st();
        }
        return -1;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.oq
    public void j(com.bytedance.sdk.openadsdk.v.j.xt.j.xt xtVar) {
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
        com.bytedance.msdk.xt.cw cwVar = this.xt;
        if (cwVar != null) {
            return cwVar.by();
        }
        return null;
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
        return new com.bytedance.sdk.gromore.j.j.xt.j(this.xt);
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
                View view = this.f27440r;
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
        m.j(this.cw);
        if (this.xt.yu() != null) {
            this.xt.yu().j();
        }
        com.bytedance.msdk.xt.cw cwVar2 = this.xt;
        m.j(cwVar2, this.cw, cwVar2.h(), 0);
        View g6 = this.xt.g();
        this.f27440r = g6;
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
    public com.bytedance.sdk.openadsdk.i.cw.xt.vl up() {
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
    public com.bytedance.sdk.openadsdk.i.cw.xt.vl ws() {
        com.bytedance.msdk.xt.cw cwVar = this.xt;
        return new com.bytedance.sdk.gromore.j.j.r.jy(cwVar != null ? cwVar.fx() : "");
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

    public j(ae aeVar, com.bytedance.msdk.xt.cw cwVar, com.bytedance.msdk.api.j.xt xtVar) {
        this.f27438j = aeVar;
        this.xt = cwVar;
        this.cw = xtVar;
        s();
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.tl
    public void j(Double d6) {
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.jy
    public void v() {
        p();
        if (this.xt != null) {
            h();
            this.xt.qv();
            j(this.xt);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.oq
    public com.bytedance.sdk.openadsdk.v.j.xt.xt.j xt() {
        return new com.bytedance.sdk.gromore.j.j.xt.xt(this.xt);
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.tl
    public void j(Double d6, String str, String str2) {
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.jy
    public void xt(Activity activity) {
        com.bytedance.msdk.xt.cw cwVar = this.xt;
        if (cwVar != null) {
            cwVar.xt(activity);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.jy
    public void xt(Dialog dialog, Integer[] numArr) {
        com.bytedance.msdk.xt.cw cwVar = this.xt;
        if (cwVar != null) {
            cwVar.j(dialog, numArr);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.g
    public void j(boolean z5) {
        com.bytedance.msdk.xt.cw cwVar = this.xt;
        if (cwVar != null) {
            cwVar.oq(z5);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.g
    public void j(Bitmap bitmap, int i6) {
        com.bytedance.msdk.xt.cw cwVar = this.xt;
        if (cwVar != null) {
            cwVar.j(bitmap, i6);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.g
    public void j(com.bytedance.sdk.openadsdk.f.j.xt.j.j jVar) {
        com.bytedance.msdk.xt.cw cwVar = this.xt;
        if (cwVar != null) {
            cwVar.j(jVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.oq
    public void j(com.bytedance.sdk.openadsdk.v.j.xt.j.j jVar) {
        this.ae = jVar;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.oq
    public double j() {
        com.bytedance.msdk.xt.cw cwVar = this.xt;
        if (cwVar != null) {
            return cwVar.hw();
        }
        return 0.0d;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.jy
    public com.bytedance.sdk.openadsdk.i.cw.xt.ae j(Activity activity) {
        com.bytedance.msdk.xt.cw cwVar = this.xt;
        if (cwVar != null) {
            return cwVar.j(activity);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.jy
    public com.bytedance.sdk.openadsdk.i.cw.xt.ae j(Dialog dialog, Integer[] numArr) {
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
            j(false, new Handler.Callback() { // from class: com.bytedance.sdk.gromore.j.j.ae.xt.j.2
                @Override // android.os.Handler.Callback
                public boolean handleMessage(@NonNull Message message) {
                    if (TextUtils.equals(j.this.xt.ff(), MediationConstant.ADN_PANGLE)) {
                        j.this.xt.j(viewGroup, list, list2, list3, list4, view);
                        return false;
                    }
                    j.this.xt.j(null, viewGroup, list2, list3, list4, null, list);
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
            j(true, new Handler.Callback() { // from class: com.bytedance.sdk.gromore.j.j.ae.xt.j.3
                @Override // android.os.Handler.Callback
                public boolean handleMessage(@NonNull Message message) {
                    j.this.xt.j(activity, viewGroup, list, list2, list3, com.bytedance.msdk.api.r.j.ae.oq.j(rVar), null);
                    return false;
                }
            });
        }
    }

    private void j(com.bytedance.sdk.openadsdk.ch.j.xt.j.j jVar) {
        this.f27439m = jVar;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.jy
    public void j(com.bytedance.sdk.openadsdk.i.cw.j.cw cwVar) {
        com.bytedance.msdk.xt.cw cwVar2 = this.xt;
        if (cwVar2 != null) {
            cwVar2.j(cwVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.jy
    public void j(com.bytedance.sdk.openadsdk.ch.j.xt.j.cw cwVar) {
        this.up = cwVar;
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
        this.tl = xtVar;
        com.bytedance.msdk.xt.cw cwVar = this.xt;
        if (cwVar != null) {
            cwVar.j(xtVar);
        }
    }

    private void j(boolean z5, Handler.Callback callback) {
        m.j(this.cw);
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
            m.j(cwVar, this.cw, cwVar.h(), 0, hashMap);
            return;
        }
        m.j((List<com.bytedance.msdk.xt.cw>) null, this.cw, 0);
    }

    private void j(com.bytedance.msdk.xt.cw cwVar) {
        if (com.bytedance.msdk.core.xt.xt().la()) {
            m.j(cwVar, this.cw, mi.j(), 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(View view) {
        String str;
        long j6;
        com.bytedance.sdk.openadsdk.ch.j.xt.j.cw cwVar = this.up;
        if (cwVar instanceof up) {
            ((up) cwVar).j();
        }
        com.bytedance.sdk.openadsdk.ch.j.xt.j.j jVar = this.f27439m;
        if (jVar != null) {
            jVar.j(view, this);
        }
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
        com.bytedance.msdk.xt.cw cwVar2 = this.xt;
        m.xt(cwVar2, this.cw, 0, str2, j7, cwVar2.gq());
    }
}
