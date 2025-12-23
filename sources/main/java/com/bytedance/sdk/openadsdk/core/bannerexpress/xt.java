package com.bytedance.sdk.openadsdk.core.bannerexpress;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.component.oq.g;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.core.EmptyView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.m;
import com.bytedance.sdk.openadsdk.core.nativeexpress.r;
import com.bytedance.sdk.openadsdk.core.nativeexpress.s;
import com.bytedance.sdk.openadsdk.core.nativeexpress.up;
import com.bytedance.sdk.openadsdk.core.nativeexpress.xt;
import com.bytedance.sdk.openadsdk.core.qv.tl;
import com.bytedance.sdk.openadsdk.core.qv.xt.j;
import com.bytedance.sdk.openadsdk.core.rn.rn;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.core.xt.j.cw.cw;
import com.bytedance.sdk.openadsdk.l.ae;
import com.bytedance.sdk.openadsdk.mediation.MediationNativeManagerDefault;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt extends com.bytedance.sdk.openadsdk.core.nativeexpress.xt implements l.j {

    /* renamed from: a, reason: collision with root package name */
    private boolean f27982a;
    protected WeakReference<BannerExpressBackupView> ae;
    private up ch;
    protected n cw;

    /* renamed from: j, reason: collision with root package name */
    protected j f27985j;
    private int jy;

    /* renamed from: m, reason: collision with root package name */
    protected com.bytedance.sdk.openadsdk.core.qv.xt.j f27986m;
    private com.bytedance.sdk.openadsdk.core.qv.xt.cw oq;
    private com.bytedance.sdk.openadsdk.core.dislike.ui.j qv;

    /* renamed from: r, reason: collision with root package name */
    protected com.bytedance.sdk.openadsdk.i.cw.cw.xt f27987r;

    /* renamed from: s, reason: collision with root package name */
    private NativeExpressView f27988s;
    protected com.bytedance.sdk.openadsdk.core.nativeexpress.j up;

    /* renamed from: v, reason: collision with root package name */
    private volatile View f27989v;
    private l vl;
    private com.bytedance.sdk.openadsdk.kt.j.xt.j.j ws;

    /* renamed from: x, reason: collision with root package name */
    private m f27991x;
    protected final Context xt;
    private String az = "banner_ad";
    private final Queue<Long> av = new LinkedList();

    /* renamed from: i, reason: collision with root package name */
    private Double f27984i = null;

    /* renamed from: w, reason: collision with root package name */
    private boolean f27990w = false;
    private boolean mi = false;
    private AtomicBoolean kt = new AtomicBoolean(false);
    private AtomicBoolean tj = new AtomicBoolean(false);

    /* renamed from: f, reason: collision with root package name */
    private AtomicBoolean f27983f = new AtomicBoolean(false);

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.ws
    public void ae() {
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.ws
    public void j(JSONObject jSONObject) {
    }

    private void av() {
        r.j(this.xt).j(this.f27987r, 1, null, new r.xt(new r.j() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.xt.6
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.r.j
            public void j(List<n> list) {
                if (list == null || list.isEmpty()) {
                    xt.this.ws();
                    return;
                }
                n nVar = list.get(0);
                xt xtVar = xt.this;
                xtVar.f27985j.j(nVar, xtVar.f27987r);
                xt.this.j(nVar);
                xt.this.f27985j.cw();
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.r.j
            public void j() {
                xt.this.ws();
            }
        }), 5000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void az() {
        l lVar = this.vl;
        if (lVar != null) {
            lVar.removeCallbacksAndMessages(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jy() {
        if (this.cw.jl() == 4) {
            ae.j(new g("banner_express_register_download") { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.xt.1
                @Override // java.lang.Runnable
                public void run() {
                    if (xt.this.cw.jl() == 4) {
                        xt xtVar = xt.this;
                        xtVar.oq = tl.j(xtVar.xt, xtVar.cw, xtVar.az, false);
                        xt.this.oq.j();
                        xt xtVar2 = xt.this;
                        if (xtVar2.xt instanceof Activity) {
                            xtVar2.oq.j((Activity) xt.this.xt);
                        }
                        if (xt.this.f27991x != null) {
                            ((com.bytedance.sdk.openadsdk.core.xt.j.j.j) xt.this.f27991x.j(com.bytedance.sdk.openadsdk.core.xt.j.j.j.class)).j(xt.this.oq);
                        }
                        if (xt.this.ch != null) {
                            ((com.bytedance.sdk.openadsdk.core.xt.j.j.j) xt.this.ch.j(com.bytedance.sdk.openadsdk.core.xt.j.j.j.class)).j(xt.this.oq);
                        }
                        xt xtVar3 = xt.this;
                        xtVar3.j(xtVar3.oq, xt.this.f27988s);
                        xt.this.oq.j(false);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ws() {
        l lVar;
        if (this.f27989v == null || !this.f27989v.isShown() || (lVar = this.vl) == null) {
            return;
        }
        lVar.removeCallbacksAndMessages(null);
        this.vl.sendEmptyMessageDelayed(112201, this.jy);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.xt, com.bytedance.sdk.openadsdk.i.cw.xt.ws
    public int cw() {
        n nVar = this.cw;
        if (nVar == null) {
            return -1;
        }
        return nVar.jl();
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.ws
    public com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.up g() {
        return new MediationNativeManagerDefault();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.xt, com.bytedance.sdk.openadsdk.i.cw.xt.ws
    public com.bytedance.sdk.openadsdk.i.cw.xt.r m() {
        n nVar = this.cw;
        if (nVar == null || nVar.gs() == null) {
            return null;
        }
        this.cw.gs().xt(this.az);
        return new com.bytedance.sdk.openadsdk.core.dislike.cw.j(this.cw.gs());
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.xt
    public n oq() {
        return this.cw;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.xt, com.bytedance.sdk.openadsdk.i.cw.xt.ws
    public void r() {
        com.bytedance.sdk.openadsdk.core.dislike.ui.j jVar = this.qv;
        if (jVar != null) {
            jVar.j(this.f27985j);
        }
        this.f27985j.up();
        com.bytedance.sdk.openadsdk.core.ae.r.j().j(this.cw).j(1);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.xt, com.bytedance.sdk.openadsdk.i.cw.xt.ws
    public Map<String, Object> tl() {
        n nVar = this.cw;
        if (nVar != null) {
            return nVar.lg();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.xt, com.bytedance.sdk.openadsdk.i.cw.xt.ws
    public void up() {
        super.up();
        j jVar = this.f27985j;
        if (jVar != null) {
            jVar.r();
        }
        l lVar = this.vl;
        if (lVar != null) {
            lVar.removeCallbacksAndMessages(null);
            this.vl = null;
        }
        n nVar = this.cw;
        rn.xt(nVar != null ? nVar.ae() : 0);
    }

    public xt(Context context, n nVar, com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar) {
        boolean z5;
        this.f27982a = false;
        this.xt = context;
        this.cw = nVar;
        this.f27987r = xtVar;
        boolean lv = v.xt().lv();
        if (!v.xt().ua() && !lv) {
            z5 = false;
        } else {
            z5 = true;
        }
        this.f27982a = z5;
        j(context, nVar, xtVar);
        j(this.f27985j.getCurView(), this.cw, false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.xt, com.bytedance.sdk.openadsdk.i.cw.xt.ws
    public int xt() {
        n nVar = this.cw;
        if (nVar == null) {
            return -1;
        }
        return nVar.ve();
    }

    private void xt(Activity activity, com.bytedance.sdk.openadsdk.kt.j.xt.j.j jVar) {
        if (this.qv == null) {
            com.bytedance.sdk.openadsdk.core.dislike.ui.j jVar2 = new com.bytedance.sdk.openadsdk.core.dislike.ui.j(activity, this.cw.gs(), this.az, false);
            this.qv = jVar2;
            com.bytedance.sdk.openadsdk.core.dislike.cw.j(activity, this.cw, jVar2);
        }
        com.bytedance.sdk.openadsdk.core.dislike.ui.j jVar3 = this.qv;
        if (jVar3 != null) {
            jVar3.j(this.f27985j);
        }
        this.qv.j(jVar);
        j jVar4 = this.f27985j;
        if (jVar4 == null || jVar4.getCurView() == null) {
            return;
        }
        this.f27985j.getCurView().setDislike(this.qv);
    }

    protected void j(Context context, n nVar, com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar) {
        this.f27985j = new j(context, nVar, xtVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.xt, com.bytedance.sdk.openadsdk.i.cw.xt.ws
    public View j() {
        com.bytedance.sdk.openadsdk.core.ae.r.j().j(this.cw).j(1);
        return this.f27985j;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.xt, com.bytedance.sdk.openadsdk.i.cw.xt.ws
    public void j(com.bytedance.sdk.openadsdk.s.j.xt.j.xt xtVar) {
        com.bytedance.sdk.openadsdk.core.nativeexpress.j j6 = com.bytedance.sdk.openadsdk.core.nativeexpress.j.j(xtVar);
        this.up = j6;
        this.f27985j.setExpressInteractionListener(j6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xt(n nVar) {
        Queue<Long> queue = this.av;
        if (queue == null || queue.size() <= 0 || nVar == null) {
            return;
        }
        try {
            long longValue = this.av.poll().longValue();
            if (longValue > 0) {
                StringBuilder sb = new StringBuilder();
                sb.append(System.currentTimeMillis() - longValue);
                com.bytedance.sdk.openadsdk.core.jy.cw.j(sb.toString(), nVar, this.az, 21);
            }
        } catch (Exception e6) {
            vl.j(e6);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.xt, com.bytedance.sdk.openadsdk.i.cw.xt.ws
    public void j(com.bytedance.sdk.openadsdk.s.j.xt.j.j jVar) {
        com.bytedance.sdk.openadsdk.core.nativeexpress.j j6 = com.bytedance.sdk.openadsdk.core.nativeexpress.j.j(jVar);
        this.up = j6;
        this.f27985j.setExpressInteractionListener(j6);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.xt, com.bytedance.sdk.openadsdk.i.cw.xt.ws
    public void j(com.bytedance.sdk.openadsdk.i.cw.j.cw cwVar) {
        com.bytedance.sdk.openadsdk.core.qv.xt.j j6 = j.C0471j.j(cwVar);
        this.f27986m = j6;
        xt.j jVar = this.tl;
        if (jVar != null) {
            jVar.j(j6);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.xt, com.bytedance.sdk.openadsdk.i.cw.xt.tl
    public void xt(Double d6) {
        this.f27984i = d6;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.xt, com.bytedance.sdk.openadsdk.i.cw.xt.ws
    public void j(Activity activity, com.bytedance.sdk.openadsdk.kt.j.xt.j.j jVar) {
        if (jVar == null || activity == null) {
            return;
        }
        this.ws = jVar;
        xt(activity, jVar);
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.ws
    public void j(String str) {
        com.bytedance.sdk.openadsdk.core.jy.cw.xt(this.cw, str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.xt
    protected void j(Dialog dialog) {
        if (dialog == null) {
            vl.cw("dialog is null, please check");
            return;
        }
        j jVar = this.f27985j;
        if (jVar == null || jVar.getCurView() == null) {
            return;
        }
        this.f27985j.getCurView().setOuterDislike(dialog);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.xt, com.bytedance.sdk.openadsdk.i.cw.xt.ws
    public com.bytedance.sdk.openadsdk.i.cw.xt.ae j(Activity activity) {
        if (this.qv == null) {
            xt(activity, (com.bytedance.sdk.openadsdk.kt.j.xt.j.j) null);
        }
        return this.qv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(n nVar) {
        if (this.f27985j.getNextView() == null || !this.f27985j.xt()) {
            return;
        }
        j(this.f27985j.getNextView(), nVar.gs());
        this.f27983f.set(false);
        j(this.f27985j.getNextView(), nVar, true);
    }

    private void j(NativeExpressView nativeExpressView, com.bytedance.sdk.openadsdk.core.dislike.cw.xt xtVar) {
        if (xtVar == null) {
            return;
        }
        if (this.ws != null) {
            this.qv.j(xtVar);
            if (nativeExpressView != null) {
                nativeExpressView.setDislike(this.qv);
            }
        }
        if (this.f29753g != null) {
            j(xtVar);
            if (nativeExpressView != null) {
                nativeExpressView.setOuterDislike(this.f29753g);
            }
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    protected void j(final NativeExpressView nativeExpressView, final n nVar, boolean z5) {
        final EmptyView emptyView;
        if (nativeExpressView == null || nVar == null) {
            return;
        }
        this.f27988s = nativeExpressView;
        n nVar2 = this.cw;
        if (nVar2 != null) {
            rn.xt(nVar2.ae());
        }
        this.cw = nVar;
        nativeExpressView.setBackupListener(new com.bytedance.sdk.component.adexpress.xt.cw() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.xt.2
            @Override // com.bytedance.sdk.component.adexpress.xt.cw
            public boolean j(ViewGroup viewGroup, int i6) {
                try {
                    ((NativeExpressView) viewGroup).mi();
                    BannerExpressBackupView bannerExpressBackupView = new BannerExpressBackupView(viewGroup.getContext());
                    xt xtVar = xt.this;
                    bannerExpressBackupView.j(xtVar.cw, (NativeExpressView) viewGroup, xtVar.oq);
                    bannerExpressBackupView.setDislikeInner(xt.this.qv);
                    bannerExpressBackupView.setDislikeOuter(((com.bytedance.sdk.openadsdk.core.nativeexpress.xt) xt.this).f29753g);
                    xt xtVar2 = xt.this;
                    if (xtVar2.cw != null) {
                        xtVar2.j(nVar.gs());
                    }
                    xt.this.ae = new WeakReference<>(bannerExpressBackupView);
                    return true;
                } catch (Exception unused) {
                    return false;
                }
            }
        });
        com.bytedance.sdk.openadsdk.core.jy.cw.j(nVar);
        EmptyView j6 = j(nativeExpressView);
        if (j6 == null) {
            EmptyView emptyView2 = new EmptyView(this.xt, nativeExpressView, nVar.at());
            emptyView2.j(this.cw, this.az);
            nativeExpressView.addView(emptyView2);
            emptyView = emptyView2;
        } else {
            emptyView = j6;
        }
        this.f27989v = emptyView;
        emptyView.setCallback(new EmptyView.j() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.xt.3
            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.j
            public void j(boolean z6) {
                String unused = xt.this.az;
                if (xt.this.oq != null) {
                    if (z6) {
                        xt.this.oq.j();
                    } else {
                        com.bytedance.sdk.openadsdk.core.qv.xt.cw unused2 = xt.this.oq;
                    }
                }
                if (z6) {
                    xt.this.ws();
                } else {
                    xt.this.az();
                }
                xt.this.j(z6, nVar);
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.j
            public void xt() {
                if (xt.this.oq != null) {
                    xt.this.oq.xt();
                }
                xt.this.xt(nVar);
                xt.this.kt.set(false);
                xt.this.tj.set(false);
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.j
            public void j() {
                xt.this.jy();
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.j
            public void j(View view, Map<String, Object> map) {
                if (xt.this.av != null) {
                    xt.this.av.offer(Long.valueOf(System.currentTimeMillis()));
                }
                Map j7 = xt.this.j(nativeExpressView, nVar);
                if (map != null && map.containsKey("show_send_type")) {
                    j7.put("show_send_type", map.get("show_send_type"));
                }
                j7.put("is_repeat", Boolean.valueOf(xt.this.f27983f.get()));
                xt.this.kt.set(true);
                if (!xt.this.tj.get()) {
                    xt.this.tj.set(true);
                    com.bytedance.sdk.openadsdk.core.jy.cw.j(nVar, xt.this.az, (Map<String, Object>) j7, xt.this.f27984i);
                    com.bytedance.sdk.openadsdk.core.a.j.j().r();
                    n nVar3 = nVar;
                    rn.j(nVar3 != null ? nVar3.ae() : 0);
                }
                boolean rs = v.xt().rs();
                xt xtVar = xt.this;
                if (xtVar.up != null && (!xtVar.f27983f.getAndSet(true) || rs)) {
                    xt.this.up.xt(view, nVar.jl());
                    if (nVar.up() && nVar.m111if() != null) {
                        com.bytedance.sdk.openadsdk.ae.j.j().j(xt.this.xt, nVar.m111if().xt());
                    }
                }
                xt.this.ws();
                j jVar = xt.this.f27985j;
                if (jVar == null || jVar.getCurView() == null) {
                    return;
                }
                xt.this.f27985j.getCurView().w();
                xt.this.f27985j.getCurView().av();
            }
        });
        m mVar = new m(this.xt, nVar, this.az, 2);
        this.f27991x = mVar;
        final com.bytedance.sdk.openadsdk.core.xt.j.cw.cw cwVar = (com.bytedance.sdk.openadsdk.core.xt.j.cw.cw) mVar.j(com.bytedance.sdk.openadsdk.core.xt.j.cw.cw.class);
        cwVar.j(new cw.j() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.xt.4
            @Override // com.bytedance.sdk.openadsdk.core.xt.j.cw.cw.j
            public boolean j() {
                cwVar.j(emptyView);
                cwVar.j(xt.this.j(nativeExpressView, nVar));
                cwVar.j(xt.this.az);
                cwVar.j(xt.this.f27984i);
                return xt.this.kt.get();
            }
        });
        this.f27991x.j(nativeExpressView);
        ((com.bytedance.sdk.openadsdk.core.xt.j.j.j) this.f27991x.j(com.bytedance.sdk.openadsdk.core.xt.j.j.j.class)).j(this);
        nativeExpressView.setClickListener(this.f27991x);
        up upVar = new up(this.xt, nVar, this.az, 2);
        this.ch = upVar;
        final com.bytedance.sdk.openadsdk.core.xt.j.cw.cw cwVar2 = (com.bytedance.sdk.openadsdk.core.xt.j.cw.cw) upVar.j(com.bytedance.sdk.openadsdk.core.xt.j.cw.cw.class);
        cwVar2.j(new cw.j() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.xt.5
            @Override // com.bytedance.sdk.openadsdk.core.xt.j.cw.cw.j
            public boolean j() {
                cwVar2.j(emptyView);
                cwVar2.j(xt.this.j(nativeExpressView, nVar));
                cwVar2.j(xt.this.az);
                cwVar2.j(xt.this.f27984i);
                return xt.this.kt.get();
            }
        });
        this.ch.j(nativeExpressView);
        ((com.bytedance.sdk.openadsdk.core.xt.j.j.j) this.ch.j(com.bytedance.sdk.openadsdk.core.xt.j.j.j.class)).j(this);
        nativeExpressView.setClickCreativeListener(this.ch);
        if (!this.f27982a) {
            emptyView.setNeedCheckingShow(true);
        }
        if (z5) {
            jy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, Object> j(NativeExpressView nativeExpressView, n nVar) {
        HashMap hashMap = new HashMap();
        s.j(hashMap, this.cw, nativeExpressView);
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(com.bytedance.sdk.openadsdk.core.qv.xt.cw cwVar, NativeExpressView nativeExpressView) {
        String str;
        if (cwVar == null || nativeExpressView == null) {
            return;
        }
        n nVar = this.cw;
        if (nVar != null) {
            str = nVar.fs();
        } else {
            str = "";
        }
        xt.j jVar = new xt.j(this.f27986m, str);
        this.tl = jVar;
        cwVar.j(jVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(boolean z5, n nVar) {
        Queue<Long> queue = this.av;
        if (queue == null) {
            return;
        }
        try {
            if (z5) {
                queue.offer(Long.valueOf(System.currentTimeMillis()));
            } else if (queue.size() > 0) {
                long longValue = this.av.poll().longValue();
                StringBuilder sb = new StringBuilder();
                sb.append(System.currentTimeMillis() - longValue);
                com.bytedance.sdk.openadsdk.core.jy.cw.j(sb.toString(), nVar, this.az, 1);
            }
        } catch (Exception e6) {
            vl.j(e6);
        }
    }

    private EmptyView j(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return null;
        }
        for (int i6 = 0; i6 < viewGroup.getChildCount(); i6++) {
            try {
                View childAt = viewGroup.getChildAt(i6);
                if (childAt instanceof EmptyView) {
                    return (EmptyView) childAt;
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.xt, com.bytedance.sdk.openadsdk.i.cw.xt.ws
    public void j(int i6) {
        if (i6 <= 0) {
            return;
        }
        this.az = "slide_banner_ad";
        j(this.f27985j.getCurView(), this.cw, false);
        this.f27985j.setDuration(1000);
        if (i6 < 30000) {
            i6 = KSImageLoader.InnerImageLoadingListener.MAX_DURATION;
        } else if (i6 > 120000) {
            i6 = 120000;
        }
        this.jy = i6;
        this.vl = new l(Looper.getMainLooper(), this);
    }

    @Override // com.bytedance.sdk.component.utils.l.j
    public void j(Message message) {
        if (message.what == 112201 && this.f27989v != null && this.f27989v.isShown()) {
            av();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.xt, com.bytedance.sdk.openadsdk.i.cw.xt.tl
    public void j(Double d6) {
        if (this.f27990w) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.rn.l.j(this.cw, d6);
        this.f27990w = true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.xt, com.bytedance.sdk.openadsdk.i.cw.xt.tl
    public void j(Double d6, String str, String str2) {
        if (this.mi) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.rn.l.j(this.cw, d6, str, str2);
        this.mi = true;
    }
}
