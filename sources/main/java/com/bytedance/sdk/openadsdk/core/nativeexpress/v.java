package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.core.EmptyView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.xt;
import com.bytedance.sdk.openadsdk.core.qv.xt.j;
import com.bytedance.sdk.openadsdk.core.rn.l;
import com.bytedance.sdk.openadsdk.core.rn.rn;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.xt.j.cw.cw;
import com.bytedance.sdk.openadsdk.mediation.MediationNativeManagerDefault;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class v extends xt {
    private com.bytedance.sdk.openadsdk.core.qv.xt.j ae;
    private EmptyView ch;
    protected n cw;

    /* renamed from: f, reason: collision with root package name */
    private final FrameLayout f29718f;

    /* renamed from: j, reason: collision with root package name */
    protected NativeExpressView f29720j;
    private up kt;

    /* renamed from: m, reason: collision with root package name */
    private j f29721m;
    private m mi;
    private com.bytedance.sdk.openadsdk.core.dislike.ui.j oq;
    private com.bytedance.sdk.openadsdk.core.qv.xt.cw qv;

    /* renamed from: s, reason: collision with root package name */
    private boolean f29723s;
    protected WeakReference<jy> up;

    /* renamed from: v, reason: collision with root package name */
    private final com.bytedance.sdk.openadsdk.core.ugeno.component.interact.r f29724v;
    protected final Context xt;

    /* renamed from: r, reason: collision with root package name */
    protected String f29722r = "embeded_ad";
    private long vl = 0;
    private Double jy = null;
    private boolean ws = false;
    private boolean az = false;
    private AtomicBoolean av = new AtomicBoolean(false);

    /* renamed from: i, reason: collision with root package name */
    private AtomicBoolean f29719i = new AtomicBoolean(false);

    /* renamed from: w, reason: collision with root package name */
    private AtomicBoolean f29725w = new AtomicBoolean(false);
    private volatile boolean tj = false;

    /* renamed from: x, reason: collision with root package name */
    private final ViewGroup f29726x = new FrameLayout(com.bytedance.sdk.openadsdk.core.v.getContext());

    /* renamed from: a, reason: collision with root package name */
    private final j f29717a = new j() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.v.1
        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.j
        public void j(View view, int i6) {
            if (v.this.f29721m != null) {
                v.this.f29721m.j(v.this.f29726x, i6);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.j
        public void j(View view, String str, int i6) {
            if (v.this.f29721m != null) {
                v.this.f29721m.j(v.this.f29726x, str, i6);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.j
        public void xt(View view, int i6) {
            boolean rs = com.bytedance.sdk.openadsdk.core.v.xt().rs();
            if (v.this.f29721m != null && (!v.this.f29725w.getAndSet(true) || rs)) {
                v.this.f29721m.xt(v.this.f29726x, i6);
                com.bytedance.sdk.openadsdk.core.tj.i m111if = v.this.cw.m111if();
                if (v.this.cw.up() && m111if != null) {
                    com.bytedance.sdk.openadsdk.ae.j.j().j(v.this.xt, m111if.xt());
                }
            }
            if (v.this.f29724v != null && v.this.f29724v.j() != null) {
                v.this.f29724v.j().r();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.j
        public void j(View view, float f6, float f7) {
            v vVar = v.this;
            if (vVar.f29720j != null && vVar.f29724v != null) {
                v vVar2 = v.this;
                vVar2.f29720j.setEasyPlayableSender(vVar2.f29724v.j());
                v.this.f29724v.j(v.this.f29720j.getEasyPlayableLayout(), v.this.f29720j.getVideoContainer());
            }
            v.this.f29726x.removeAllViews();
            v.this.f29726x.addView(view);
            v.this.f29726x.addView(v.this.f29718f, new FrameLayout.LayoutParams((int) f6, (int) f7));
            if (v.this.f29721m != null) {
                v.this.f29721m.j(v.this.f29726x, f6, f7);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void jy() {
        if (!this.tj) {
            this.tj = true;
            if (this.cw.jl() == 4) {
                com.bytedance.sdk.openadsdk.l.ae.j(new com.bytedance.sdk.component.oq.g("native_register_download") { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.v.3
                    @Override // java.lang.Runnable
                    public void run() {
                        v vVar = v.this;
                        vVar.qv = com.bytedance.sdk.openadsdk.core.qv.tl.j(vVar.xt, vVar.cw, vVar.f29722r, false);
                        if (v.this.mi != null) {
                            ((com.bytedance.sdk.openadsdk.core.xt.j.j.j) v.this.mi.j(com.bytedance.sdk.openadsdk.core.xt.j.j.j.class)).j(v.this.qv);
                        }
                        if (v.this.kt != null) {
                            ((com.bytedance.sdk.openadsdk.core.xt.j.j.j) v.this.kt.j(com.bytedance.sdk.openadsdk.core.xt.j.j.j.class)).j(v.this.qv);
                        }
                        v vVar2 = v.this;
                        if (vVar2.xt instanceof Activity) {
                            vVar2.qv.j((Activity) v.this.xt);
                        }
                        v vVar3 = v.this;
                        vVar3.j(vVar3.qv, v.this.f29720j);
                        v.this.qv.j(false);
                        v.this.qv.j(v.this.tl);
                    }
                });
                return;
            }
            return;
        }
        if (this.qv != null) {
            m mVar = this.mi;
            if (mVar != null) {
                ((com.bytedance.sdk.openadsdk.core.xt.j.j.j) mVar.j(com.bytedance.sdk.openadsdk.core.xt.j.j.j.class)).j(this.qv);
            }
            up upVar = this.kt;
            if (upVar != null) {
                ((com.bytedance.sdk.openadsdk.core.xt.j.j.j) upVar.j(com.bytedance.sdk.openadsdk.core.xt.j.j.j.class)).j(this.qv);
            }
            try {
                j(this.qv, this.f29720j);
                this.qv.j(false);
                this.qv.j(this.tl);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, Object> ws() {
        HashMap hashMap = new HashMap();
        s.j(hashMap, this.cw, this.f29720j);
        return hashMap;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.ws
    public void ae() {
        NativeExpressView nativeExpressView = this.f29720j;
        if (nativeExpressView != null) {
            nativeExpressView.f();
        }
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
        this.cw.gs().xt(this.f29722r);
        return new com.bytedance.sdk.openadsdk.core.dislike.cw.j(this.cw.gs());
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.xt
    public n oq() {
        return this.cw;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.xt, com.bytedance.sdk.openadsdk.i.cw.xt.ws
    public void r() {
        com.bytedance.sdk.openadsdk.core.dislike.ui.j jVar = this.oq;
        if (jVar != null) {
            jVar.j(this.f29720j);
        }
        this.f29720j.i();
        com.bytedance.sdk.openadsdk.core.ae.r.j().j(this.cw);
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
        NativeExpressView nativeExpressView = this.f29720j;
        if (nativeExpressView != null) {
            nativeExpressView.jy();
        }
        com.bytedance.sdk.openadsdk.core.qv.xt.cw cwVar = this.qv;
        if (cwVar != null) {
            cwVar.xt();
        }
        com.bytedance.sdk.openadsdk.core.ugeno.component.interact.r rVar = this.f29724v;
        if (rVar != null) {
            rVar.xt();
        }
        n nVar = this.cw;
        rn.xt(nVar != null ? nVar.ae() : 0);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.xt, com.bytedance.sdk.openadsdk.i.cw.xt.ws
    public int xt() {
        n nVar = this.cw;
        if (nVar == null) {
            return -1;
        }
        return nVar.ve();
    }

    public v(Context context, final n nVar, com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar) {
        boolean z5;
        this.f29723s = false;
        this.xt = context;
        this.cw = nVar;
        boolean lv = com.bytedance.sdk.openadsdk.core.v.xt().lv();
        if (!com.bytedance.sdk.openadsdk.core.v.xt().ua() && !lv) {
            z5 = false;
        } else {
            z5 = true;
        }
        this.f29723s = z5;
        j(context, nVar, xtVar);
        this.f29718f = new FrameLayout(context);
        this.f29724v = new com.bytedance.sdk.openadsdk.core.ugeno.component.interact.r(nVar, false, new com.bytedance.sdk.openadsdk.core.ugeno.component.interact.j() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.v.2
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.j
            public void j(ViewGroup viewGroup) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
            public int xt() {
                NativeExpressView nativeExpressView = v.this.f29720j;
                if (nativeExpressView != null) {
                    return nativeExpressView.xt();
                }
                return 0;
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
            public int cw() {
                NativeExpressView nativeExpressView = v.this.f29720j;
                if (nativeExpressView != null) {
                    return nativeExpressView.cw();
                }
                return 0;
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
            public long getActualPlayDuration() {
                NativeExpressView nativeExpressView = v.this.f29720j;
                if (nativeExpressView != null) {
                    return nativeExpressView.getActualPlayDuration();
                }
                return 0L;
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
            public void j(int i6) {
                NativeExpressView nativeExpressView = v.this.f29720j;
                if (nativeExpressView != null) {
                    nativeExpressView.j(i6);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
            public void m() {
                NativeExpressView nativeExpressView = v.this.f29720j;
                if (nativeExpressView != null) {
                    nativeExpressView.m();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
            public void r() {
                NativeExpressView nativeExpressView = v.this.f29720j;
                if (nativeExpressView != null) {
                    nativeExpressView.r();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
            public void setPauseFromExpressView(boolean z6) {
                NativeExpressView nativeExpressView = v.this.f29720j;
                if (nativeExpressView != null) {
                    nativeExpressView.setPauseFromExpressView(z6);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
            public void up() {
                NativeExpressView nativeExpressView = v.this.f29720j;
                if (nativeExpressView != null) {
                    nativeExpressView.up();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
            public void xt(int i6) {
                NativeExpressView nativeExpressView = v.this.f29720j;
                if (nativeExpressView != null) {
                    nativeExpressView.xt(i6);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
            public long j() {
                NativeExpressView nativeExpressView = v.this.f29720j;
                if (nativeExpressView != null) {
                    return nativeExpressView.j();
                }
                return 0L;
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.j
            public void xt(View view, int i6, com.bytedance.sdk.component.adexpress.cw cwVar) {
                NativeExpressView nativeExpressView = v.this.f29720j;
                if (nativeExpressView != null) {
                    nativeExpressView.j(view, i6, cwVar);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
            public void j(int i6, String str) {
                NativeExpressView nativeExpressView = v.this.f29720j;
                if (nativeExpressView != null) {
                    nativeExpressView.j(i6, str);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
            public void j(float f6) {
                NativeExpressView nativeExpressView = v.this.f29720j;
                if (nativeExpressView != null) {
                    nativeExpressView.j(f6);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.j
            public void j(View view) {
                v.this.f29717a.j(view, nVar.jl());
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.j
            public void j(View view, int i6, com.bytedance.sdk.component.adexpress.cw cwVar) {
                NativeExpressView nativeExpressView = v.this.f29720j;
                if (nativeExpressView != null) {
                    nativeExpressView.j(view, i6, cwVar);
                }
            }
        });
    }

    private void xt(Activity activity, com.bytedance.sdk.openadsdk.kt.j.xt.j.j jVar) {
        if (this.oq == null) {
            com.bytedance.sdk.openadsdk.core.dislike.ui.j jVar2 = new com.bytedance.sdk.openadsdk.core.dislike.ui.j(activity, this.cw.gs(), this.f29722r, false);
            this.oq = jVar2;
            com.bytedance.sdk.openadsdk.core.dislike.cw.j(activity, this.cw, jVar2);
        }
        com.bytedance.sdk.openadsdk.core.dislike.ui.j jVar3 = this.oq;
        if (jVar3 != null) {
            jVar3.j(this.f29720j);
        }
        this.oq.j(jVar);
        NativeExpressView nativeExpressView = this.f29720j;
        if (nativeExpressView != null) {
            nativeExpressView.setDislike(this.oq);
        }
    }

    public void j(Context context, n nVar, com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar) {
        NativeExpressView nativeExpressView = new NativeExpressView(context, nVar, xtVar, this.f29722r);
        this.f29720j = nativeExpressView;
        this.f29726x.addView(nativeExpressView);
        j(this.f29720j, this.cw);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.xt, com.bytedance.sdk.openadsdk.i.cw.xt.ws
    public View j() {
        com.bytedance.sdk.openadsdk.core.ae.r.j().j(this.cw);
        return this.f29726x;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.xt, com.bytedance.sdk.openadsdk.i.cw.xt.ws
    public void j(com.bytedance.sdk.openadsdk.s.j.xt.j.xt xtVar) {
        this.f29721m = j.j(xtVar);
        this.f29720j.setExpressInteractionListener(this.f29717a);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.xt, com.bytedance.sdk.openadsdk.i.cw.xt.ws
    public void j(com.bytedance.sdk.openadsdk.s.j.xt.j.j jVar) {
        this.f29721m = j.j(jVar);
        this.f29720j.setExpressInteractionListener(this.f29717a);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.xt, com.bytedance.sdk.openadsdk.i.cw.xt.tl
    public void xt(Double d6) {
        this.jy = d6;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.xt, com.bytedance.sdk.openadsdk.i.cw.xt.ws
    public void j(com.bytedance.sdk.openadsdk.i.cw.j.cw cwVar) {
        com.bytedance.sdk.openadsdk.core.qv.xt.j j6 = j.C0471j.j(cwVar);
        this.ae = j6;
        xt.j jVar = this.tl;
        if (jVar != null) {
            jVar.j(j6);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.xt, com.bytedance.sdk.openadsdk.i.cw.xt.ws
    public void j(Activity activity, com.bytedance.sdk.openadsdk.kt.j.xt.j.j jVar) {
        if (jVar == null || activity == null) {
            return;
        }
        xt(activity, jVar);
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.ws
    public void j(String str) {
        com.bytedance.sdk.openadsdk.core.jy.cw.xt(this.cw, str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.xt
    protected void j(Dialog dialog) {
        if (dialog == null) {
            com.bytedance.sdk.component.utils.vl.cw("dialog is null, please check");
            return;
        }
        NativeExpressView nativeExpressView = this.f29720j;
        if (nativeExpressView != null) {
            nativeExpressView.setOuterDislike(dialog);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.xt, com.bytedance.sdk.openadsdk.i.cw.xt.ws
    public com.bytedance.sdk.openadsdk.i.cw.xt.ae j(Activity activity) {
        if (this.oq == null) {
            xt(activity, null);
        }
        return this.oq;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.ws
    public void j(JSONObject jSONObject) {
        NativeExpressView nativeExpressView = this.f29720j;
        if (nativeExpressView != null) {
            nativeExpressView.j(jSONObject);
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    protected void j(NativeExpressView nativeExpressView, final n nVar) {
        this.cw = nVar;
        nativeExpressView.setBackupListener(new com.bytedance.sdk.component.adexpress.xt.cw() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.v.4
            @Override // com.bytedance.sdk.component.adexpress.xt.cw
            public boolean j(ViewGroup viewGroup, int i6) {
                try {
                    ((NativeExpressView) viewGroup).mi();
                    jy jyVar = new jy(viewGroup.getContext());
                    com.bytedance.sdk.openadsdk.core.video.r.j.j(Integer.valueOf(nVar.hashCode()), v.this);
                    v vVar = v.this;
                    jyVar.j(vVar.cw, (NativeExpressView) viewGroup, vVar.qv);
                    jyVar.setDislikeInner(v.this.oq);
                    jyVar.setDislikeOuter(v.this.f29753g);
                    v vVar2 = v.this;
                    n nVar2 = vVar2.cw;
                    if (nVar2 != null) {
                        vVar2.j(nVar2.gs());
                    }
                    v.this.up = new WeakReference<>(jyVar);
                    return true;
                } catch (Exception unused) {
                    return false;
                }
            }
        });
        com.bytedance.sdk.openadsdk.core.jy.cw.j(nVar);
        EmptyView j6 = j(nativeExpressView);
        this.ch = j6;
        if (j6 == null) {
            EmptyView emptyView = new EmptyView(this.xt, nativeExpressView, nVar != null ? nVar.at() : 1000);
            this.ch = emptyView;
            emptyView.j(this.cw, this.f29722r);
            nativeExpressView.addView(this.ch);
        }
        this.ch.setCallback(new EmptyView.j() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.v.5
            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.j
            public void j(boolean z5) {
                if (v.this.qv != null) {
                    if (z5) {
                        v.this.qv.j();
                    } else {
                        com.bytedance.sdk.openadsdk.core.qv.xt.cw unused = v.this.qv;
                    }
                }
                v vVar = v.this;
                vVar.vl = com.bytedance.sdk.openadsdk.core.jy.cw.j(vVar.vl, z5, nVar, v.this.f29722r, 2);
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.j
            public void xt() {
                if (v.this.qv != null) {
                    v.this.qv.xt();
                }
                v vVar = v.this;
                vVar.vl = com.bytedance.sdk.openadsdk.core.jy.cw.j(vVar.vl, nVar, v.this.f29722r, 22);
                v.this.av.set(false);
                v.this.f29719i.set(false);
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.j
            public void j() {
                v.this.jy();
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.j
            public void j(View view, Map<String, Object> map) {
                v.this.jy();
                v.this.vl = System.currentTimeMillis();
                Map ws = v.this.ws();
                ws.put("is_repeat", Boolean.valueOf(v.this.f29725w.get()));
                if (map != null && map.containsKey("show_send_type")) {
                    ws.put("show_send_type", map.get("show_send_type"));
                }
                ws.put("is_repeat", Boolean.valueOf(v.this.f29725w.get()));
                v.this.av.set(true);
                if (!v.this.f29719i.get()) {
                    v.this.f29719i.set(true);
                    n nVar2 = nVar;
                    v vVar = v.this;
                    com.bytedance.sdk.openadsdk.core.jy.cw.j(nVar2, vVar.f29722r, (Map<String, Object>) ws, vVar.jy);
                    com.bytedance.sdk.openadsdk.core.a.j.j().r();
                    n nVar3 = nVar;
                    rn.j(nVar3 != null ? nVar3.ae() : 0);
                }
                v.this.f29717a.xt(view, nVar.jl());
                NativeExpressView nativeExpressView2 = v.this.f29720j;
                if (nativeExpressView2 != null) {
                    nativeExpressView2.w();
                    v.this.f29720j.av();
                }
            }
        });
        Context context = this.xt;
        String str = this.f29722r;
        m mVar = new m(context, nVar, str, uf.xt(str));
        this.mi = mVar;
        j((com.bytedance.sdk.openadsdk.core.xt.j.cw.cw) mVar.j(com.bytedance.sdk.openadsdk.core.xt.j.cw.cw.class));
        this.mi.j(nativeExpressView);
        ((com.bytedance.sdk.openadsdk.core.xt.j.j.j) this.mi.j(com.bytedance.sdk.openadsdk.core.xt.j.j.j.class)).j(this);
        this.f29720j.setClickListener(this.mi);
        Context context2 = this.xt;
        String str2 = this.f29722r;
        up upVar = new up(context2, nVar, str2, uf.xt(str2));
        this.kt = upVar;
        j((com.bytedance.sdk.openadsdk.core.xt.j.cw.cw) upVar.j(com.bytedance.sdk.openadsdk.core.xt.j.cw.cw.class));
        this.kt.j(nativeExpressView);
        ((com.bytedance.sdk.openadsdk.core.xt.j.j.j) this.kt.j(com.bytedance.sdk.openadsdk.core.xt.j.j.j.class)).j(this);
        this.f29720j.setClickCreativeListener(this.kt);
        if (this.f29723s) {
            return;
        }
        this.ch.setNeedCheckingShow(true);
    }

    public void j(final com.bytedance.sdk.openadsdk.core.xt.j.cw.cw cwVar) {
        cwVar.j(new cw.j() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.v.6
            @Override // com.bytedance.sdk.openadsdk.core.xt.j.cw.cw.j
            public boolean j() {
                cwVar.j(v.this.ch);
                cwVar.j(v.this.ws());
                cwVar.j(v.this.f29722r);
                cwVar.j(v.this.jy);
                return v.this.av.get();
            }
        });
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
        xt.j jVar = new xt.j(this.ae, str);
        this.tl = jVar;
        cwVar.j(jVar);
    }

    private EmptyView j(ViewGroup viewGroup) {
        for (int i6 = 0; i6 < viewGroup.getChildCount(); i6++) {
            View childAt = viewGroup.getChildAt(i6);
            if (childAt instanceof EmptyView) {
                return (EmptyView) childAt;
            }
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.xt, com.bytedance.sdk.openadsdk.i.cw.xt.tl
    public void j(Double d6) {
        if (this.ws) {
            return;
        }
        l.j(this.cw, d6);
        this.ws = true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.xt, com.bytedance.sdk.openadsdk.i.cw.xt.tl
    public void j(Double d6, String str, String str2) {
        if (this.az) {
            return;
        }
        l.j(this.cw, d6, str, str2);
        this.az = true;
    }
}
