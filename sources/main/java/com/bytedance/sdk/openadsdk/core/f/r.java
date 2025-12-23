package com.bytedance.sdk.openadsdk.core.f;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.av;
import com.bytedance.sdk.component.utils.kt;
import com.bytedance.sdk.openadsdk.core.f;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.ch;
import com.bytedance.sdk.openadsdk.core.qv.xt.j;
import com.bytedance.sdk.openadsdk.core.rn.l;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.tj.a;
import com.bytedance.sdk.openadsdk.core.tj.ed;
import com.bytedance.sdk.openadsdk.core.tj.h;
import com.bytedance.sdk.openadsdk.core.tj.hh;
import com.bytedance.sdk.openadsdk.core.tj.ln;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.tj.oq;
import com.bytedance.sdk.openadsdk.core.tj.qv;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.UGenVideoOrImgPanelView;
import com.bytedance.sdk.openadsdk.core.x;
import com.bytedance.sdk.openadsdk.i.cw.xt.ae;
import com.bytedance.sdk.openadsdk.i.cw.xt.jy;
import com.bytedance.sdk.openadsdk.i.cw.xt.up;
import com.bytedance.sdk.openadsdk.i.cw.xt.vl;
import com.bytedance.sdk.openadsdk.i.cw.xt.ws;
import com.bytedance.sdk.openadsdk.mediation.MediationNativeManagerDefault;
import com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
import xyz.adscope.amps.common.AMPSConstants;

/* loaded from: D:\Downloads\app\classes4.dex */
public class r extends jy {
    private int ae;
    private float az;
    private final com.bytedance.sdk.openadsdk.core.ugeno.component.interact.r ch;
    private final Context cw;

    /* renamed from: g, reason: collision with root package name */
    private ws f28941g;

    /* renamed from: j, reason: collision with root package name */
    private final f f28943j;
    private TextView kt;

    /* renamed from: m, reason: collision with root package name */
    private int f28945m;
    private com.bytedance.sdk.openadsdk.ch.j.xt.j.j mi;
    private volatile ViewGroup oq;
    private View qv;

    /* renamed from: r, reason: collision with root package name */
    private ae f28947r;

    /* renamed from: s, reason: collision with root package name */
    private UGenVideoOrImgPanelView f28948s;
    private com.bytedance.sdk.openadsdk.i.cw.cw.xt tl;
    private up up;

    /* renamed from: v, reason: collision with root package name */
    private final boolean f28949v;

    /* renamed from: w, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.ch.j.xt.j.cw f28950w;
    private float ws;
    private final n xt;
    private boolean vl = false;
    private boolean jy = true;
    private AtomicBoolean av = new AtomicBoolean(false);

    /* renamed from: i, reason: collision with root package name */
    private AtomicBoolean f28942i = new AtomicBoolean(false);
    private boolean tj = false;

    /* renamed from: f, reason: collision with root package name */
    private boolean f28940f = false;

    /* renamed from: x, reason: collision with root package name */
    private volatile WeakReference<NativeVideoTsView> f28951x = null;

    /* renamed from: a, reason: collision with root package name */
    private final com.bytedance.sdk.openadsdk.core.video.nativevideo.j f28939a = new com.bytedance.sdk.openadsdk.core.video.nativevideo.j() { // from class: com.bytedance.sdk.openadsdk.core.f.r.1
        @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.j
        public void j() {
            com.bytedance.sdk.openadsdk.l.ae.j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.f.r.1.1
                @Override // java.lang.Runnable
                public void run() {
                    r.this.p();
                    r.this.la();
                }
            }, v.xt().jl());
        }
    };

    /* renamed from: l, reason: collision with root package name */
    private volatile boolean f28944l = false;

    /* renamed from: p, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.ch.j.xt.j.j f28946p = null;

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.jy
    public void j(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, com.bytedance.sdk.openadsdk.ch.j.xt.j.j jVar, com.bytedance.sdk.openadsdk.mediation.ad.j.xt.j.r rVar) {
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.jy
    public View tj() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.jy
    public void x() {
        this.f28944l = true;
        ws wsVar = this.f28941g;
        if (wsVar != null) {
            wsVar.up();
        }
        n nVar = this.xt;
        if (nVar != null) {
            x.j(nVar.uv());
        }
        f fVar = this.f28943j;
        if (fVar != null) {
            fVar.xt();
        }
        this.ch.xt();
        UGenVideoOrImgPanelView uGenVideoOrImgPanelView = this.f28948s;
        if (uGenVideoOrImgPanelView != null) {
            uGenVideoOrImgPanelView.jy();
        }
    }

    private NativeVideoTsView cw(ViewGroup viewGroup) {
        for (int i6 = 0; i6 < viewGroup.getChildCount(); i6++) {
            View childAt = viewGroup.getChildAt(i6);
            if ("ado_tag".equals(childAt.getTag()) && (childAt instanceof NativeVideoTsView)) {
                return (NativeVideoTsView) childAt;
            }
        }
        return null;
    }

    private boolean gq() {
        n nVar = this.xt;
        if (nVar == null || nVar.jl() == 5) {
            return false;
        }
        if (this.ae == 0) {
            this.ae = uf.g(this.xt);
        }
        return v.xt().tl(this.ae) == 1;
    }

    private void h() {
        View xt;
        if (n.xt(this.xt) || (xt = xt(this.oq)) == null) {
            return;
        }
        this.f28948s = new UGenVideoOrImgPanelView(this.cw, this.xt, null, xt, this.oq, uf.xt(this.f28945m), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void la() {
        NativeVideoTsView nativeVideoTsView;
        f fVar = this.f28943j;
        if (fVar != null) {
            fVar.j(this.ch.j());
        }
        if (!n.xt(this.xt)) {
            this.ch.j(this.oq, xt(this.oq));
            return;
        }
        if (this.f28951x == null || this.f28951x.get() == null) {
            nativeVideoTsView = null;
        } else {
            nativeVideoTsView = this.f28951x.get();
            nativeVideoTsView.setEasyPlayableEventSender(this.ch.j());
        }
        this.ch.j(this.oq, nativeVideoTsView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        UGenVideoOrImgPanelView uGenVideoOrImgPanelView = this.f28948s;
        if (uGenVideoOrImgPanelView != null) {
            uGenVideoOrImgPanelView.jy();
        }
        if (UGenVideoOrImgPanelView.j(this.xt) || !v.xt().fk().f29784r) {
            if (n.xt(this.xt)) {
                j();
            } else {
                h();
            }
            f fVar = this.f28943j;
            if (fVar != null) {
                fVar.j((NativeExpressView) this.f28948s);
            }
            UGenVideoOrImgPanelView uGenVideoOrImgPanelView2 = this.f28948s;
            if (uGenVideoOrImgPanelView2 != null) {
                uGenVideoOrImgPanelView2.setAdSlot(this.tl);
            }
        }
    }

    private void rn() {
        com.bytedance.sdk.openadsdk.ch.j.xt.j.cw cwVar;
        if (this.f28941g == null) {
            com.bytedance.sdk.openadsdk.ch.j.xt.j.cw cwVar2 = this.f28950w;
            if (cwVar2 != null) {
                cwVar2.j(this.oq, this.tl.tl(), this.tl.g(), false);
                return;
            }
            return;
        }
        if (this.av.get() && (cwVar = this.f28950w) != null) {
            cwVar.j(this.qv, this.ws, this.az, this.f28942i.get());
        } else {
            this.f28941g.j(new com.bytedance.sdk.openadsdk.s.j.xt.j.xt(null) { // from class: com.bytedance.sdk.openadsdk.core.f.r.6
                @Override // com.bytedance.sdk.openadsdk.s.j.xt.j.xt
                public void j(View view, int i6) {
                    if (r.this.mi != null) {
                        r.this.mi.j(view, r.this);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.s.j.xt.j.xt
                public void xt(View view, int i6) {
                    if (r.this.mi != null) {
                        r.this.mi.j(r.this);
                    }
                    if (r.this.ch != null && r.this.ch.j() != null) {
                        r.this.ch.j().r();
                    }
                    if (!r.this.xt.up() || r.this.xt.m111if() == null) {
                        return;
                    }
                    com.bytedance.sdk.openadsdk.ae.j.j().j(r.this.cw, r.this.xt.m111if().xt());
                }

                @Override // com.bytedance.sdk.openadsdk.s.j.xt.j.xt
                public void j(View view, String str, int i6) {
                    r.this.av.set(true);
                    r rVar = r.this;
                    rVar.qv = rVar.oq;
                    r rVar2 = r.this;
                    rVar2.ws = rVar2.tl.tl();
                    r rVar3 = r.this;
                    rVar3.az = rVar3.tl.g();
                    if (r.this.f28950w != null) {
                        r.this.f28950w.j(r.this.oq, r.this.tl.tl(), r.this.tl.g(), false);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.s.j.xt.j.xt
                public void j(View view, float f6, float f7) {
                    r.this.av.set(true);
                    r.this.f28942i.set(true);
                    r.this.qv = view;
                    r.this.ws = f6;
                    r.this.az = f7;
                    if (r.this.f28950w != null) {
                        r.this.f28950w.j(view, f6, f7, true);
                    }
                }
            });
            this.f28941g.r();
        }
    }

    private void wq() {
        if (this.oq == null || this.f28941g == null || this.qv == null) {
            return;
        }
        this.oq.removeAllViews();
        if (this.qv.getParent() != null) {
            ((ViewGroup) this.qv.getParent()).removeAllViews();
        }
        this.oq.addView(this.qv);
    }

    public boolean a() {
        return this.jy;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.jy
    public String ae() {
        n nVar = this.xt;
        if (nVar == null) {
            return "";
        }
        if (com.bytedance.sdk.openadsdk.core.video.cw.j.j(nVar) && !TextUtils.isEmpty(ed.cw(this.xt))) {
            return ed.cw(this.xt);
        }
        if (v.xt().qe()) {
            if (!TextUtils.isEmpty(this.xt.hw())) {
                return this.xt.hw();
            }
            if (this.xt.by() != null && !TextUtils.isEmpty(this.xt.by().cw())) {
                return this.xt.by().cw();
            }
            if (!TextUtils.isEmpty(jy())) {
                return jy();
            }
        } else {
            if (this.xt.by() != null && !TextUtils.isEmpty(this.xt.by().cw())) {
                return this.xt.by().cw();
            }
            if (!TextUtils.isEmpty(jy())) {
                return jy();
            }
            if (!TextUtils.isEmpty(this.xt.hw())) {
                return this.xt.hw();
            }
        }
        return "";
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.jy
    public int av() {
        n nVar = this.xt;
        if (nVar == null) {
            return -1;
        }
        return nVar.jl();
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.jy
    public List<vl> az() {
        ArrayList arrayList = new ArrayList();
        if (this.xt.fp() != null && !this.xt.fp().isEmpty()) {
            Iterator<h> it = this.xt.fp().iterator();
            while (it.hasNext()) {
                vl j6 = h.j(it.next());
                if (j6 != null) {
                    arrayList.add(j6);
                }
            }
        }
        return arrayList;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.jy
    public com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.up ch() {
        return new MediationNativeManagerDefault();
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.jy
    public Map<String, Object> f() {
        n nVar = this.xt;
        if (nVar != null) {
            return nVar.lg();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.jy
    public String g() {
        return this.xt.sf();
    }

    public Context getContext() {
        return this.cw;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.jy
    public int i() {
        n nVar = this.xt;
        if (nVar == null) {
            return -1;
        }
        List<h> fp = nVar.fp();
        return (fp == null || fp.isEmpty() || fp.get(0) == null || !fp.get(0).up() || !com.bytedance.sdk.openadsdk.up.j.tl(this.xt)) ? this.xt.ve() : fp.get(0).xt() >= fp.get(0).cw() ? 5 : 15;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.jy
    public String jy() {
        return this.xt.rs();
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.jy
    public up kt() {
        if (this.f28941g != null && this.av.get()) {
            return null;
        }
        n nVar = this.xt;
        boolean z5 = nVar != null && nVar.jl() == 4;
        if (this.up == null && this.f28943j != null && z5) {
            this.up = new up() { // from class: com.bytedance.sdk.openadsdk.core.f.r.4
                @Override // com.bytedance.sdk.openadsdk.i.cw.xt.up
                public void j() {
                    int vl;
                    if (r.this.f28946p != null) {
                        com.bytedance.sdk.openadsdk.core.qv.xt.cw j6 = r.this.f28943j.j();
                        if ((j6 instanceof com.bytedance.sdk.openadsdk.core.qv.cw.up) && (1 == (vl = ((com.bytedance.sdk.openadsdk.core.qv.cw.up) j6).vl()) || 4 == vl || 6 == vl || 7 == vl)) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("downloadstatuscontroller_type", 1);
                            r rVar = r.this;
                            String j7 = rVar.j(rVar.f28945m);
                            oq.j jVar = new oq.j();
                            float m6 = com.bytedance.sdk.openadsdk.core.rn.ed.m(r.this.cw);
                            com.bytedance.sdk.openadsdk.core.jy.cw.j(AMPSConstants.FrequencyEventType.FREQUENCY_EVENT_TYPE_CLICK, r.this.xt, jVar.j(m6).j(com.bytedance.sdk.openadsdk.core.rn.ed.tl(r.this.cw)).xt(com.bytedance.sdk.openadsdk.core.rn.ed.ae(r.this.cw)).j(), j7, true, hashMap, 1, false);
                        }
                        if (j6 != null) {
                            j6.r(true);
                            j6.j(uf.mi(r.this.xt), false);
                        }
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.i.cw.xt.up
                public void xt() {
                    com.bytedance.sdk.openadsdk.core.qv.xt.cw j6;
                    if (r.this.f28946p == null || (j6 = r.this.f28943j.j()) == null) {
                        return;
                    }
                    j6.r();
                }
            };
        }
        return this.up;
    }

    public boolean l() {
        return this.vl;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.jy
    public Bitmap m() {
        n nVar = this.xt;
        if (nVar == null) {
            return BitmapFactory.decodeResource(this.cw.getResources(), kt.up(v.getContext(), "tt_ad_logo_new"));
        }
        String ek = nVar.ek();
        if (TextUtils.isEmpty(ek)) {
            return BitmapFactory.decodeResource(this.cw.getResources(), kt.up(v.getContext(), "tt_ad_logo_new"));
        }
        if (this.kt == null) {
            this.kt = new TextView(v.getContext());
            this.kt.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        }
        com.bytedance.sdk.openadsdk.core.rn.ed.j(this.kt, ek, v.getContext());
        return com.bytedance.sdk.openadsdk.core.rn.ed.ae(this.kt);
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.jy
    public int oq() {
        if (this.xt.by() != null) {
            return this.xt.by().up();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.jy
    public int qv() {
        if (this.xt.by() != null) {
            return this.xt.by().m();
        }
        return 0;
    }

    public f r() {
        return this.f28943j;
    }

    public n s() {
        return this.xt;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.jy
    public String tl() {
        n nVar = this.xt;
        if (nVar == null) {
            return "";
        }
        if (com.bytedance.sdk.openadsdk.core.video.cw.j.j(nVar) && !TextUtils.isEmpty(ed.m(this.xt))) {
            return ed.m(this.xt);
        }
        if (v.xt().qe()) {
            if (!TextUtils.isEmpty(this.xt.zk())) {
                return this.xt.zk();
            }
            if (!TextUtils.isEmpty(this.xt.hw())) {
                return this.xt.hw();
            }
        } else {
            if (!TextUtils.isEmpty(this.xt.hw())) {
                return this.xt.hw();
            }
            if (!TextUtils.isEmpty(this.xt.zk())) {
                return this.xt.zk();
            }
        }
        return "";
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.jy
    public vl up() {
        n nVar = this.xt;
        if (nVar == null) {
            return h.j(0, 0, "", 0.0d);
        }
        if (com.bytedance.sdk.openadsdk.core.video.cw.j.j(nVar)) {
            return TextUtils.isEmpty(ed.tl(this.xt)) ? h.j(0, 0, "", 0.0d) : h.j(ed.jy(this.xt), ed.vl(this.xt), ed.tl(this.xt), 0.0d);
        }
        if (ln.ws(this.xt) != null) {
            return h.j(ln.cw(this.xt), ln.r(this.xt), ln.xt(this.xt), 0.0d);
        }
        return h.j(0, 0, "", 0.0d);
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.jy
    public int vl() {
        if (this.xt.by() != null) {
            return this.xt.by().ae();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.jy
    public com.bytedance.sdk.openadsdk.i.cw.xt.r w() {
        n nVar = this.xt;
        if (nVar == null || nVar.gs() == null) {
            return null;
        }
        this.xt.gs().xt(j(this.f28945m));
        return new com.bytedance.sdk.openadsdk.core.dislike.cw.j(this.xt.gs());
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.jy
    public vl ws() {
        return com.bytedance.sdk.openadsdk.core.video.cw.j.j(this.xt) ? TextUtils.isEmpty(ed.g(this.xt)) ? h.j(0, 0, "", 0.0d) : h.j(ed.qv(this.xt), ed.oq(this.xt), ed.g(this.xt), 0.0d) : this.xt.ig() == null ? h.j(0, 0, "", 0.0d) : h.j(this.xt.ig());
    }

    public r(Context context, final n nVar, int i6, com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, boolean z5) {
        av.j(nVar, "materialMeta不能为null");
        this.f28949v = z5;
        this.xt = nVar;
        if (context == null) {
            this.cw = v.getContext();
        } else {
            this.cw = context;
        }
        this.f28945m = i6;
        this.tl = xtVar;
        f fVar = new f(this.cw, this, nVar, j(i6));
        this.f28943j = fVar;
        fVar.j(i6);
        this.f28941g = j(nVar);
        this.ch = new com.bytedance.sdk.openadsdk.core.ugeno.component.interact.r(nVar, true, new com.bytedance.sdk.openadsdk.core.ugeno.component.interact.j() { // from class: com.bytedance.sdk.openadsdk.core.f.r.2
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
            public int cw() {
                return 0;
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
            public void j(float f6) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
            public void xt(int i7) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
            public void j(int i7) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
            public int xt() {
                NativeVideoTsView nativeVideoTsView;
                if (r.this.f28951x == null || (nativeVideoTsView = (NativeVideoTsView) r.this.f28951x.get()) == null) {
                    return 0;
                }
                com.bykv.vk.openvk.component.video.api.r.cw nativeVideoController = nativeVideoTsView.getNativeVideoController();
                if (nativeVideoController == null) {
                    return 4;
                }
                if (nativeVideoController.kt()) {
                    return 5;
                }
                if (nativeVideoController.f()) {
                    return 1;
                }
                return ((nativeVideoController instanceof com.bytedance.sdk.openadsdk.core.video.nativevideo.r) && ((com.bytedance.sdk.openadsdk.core.video.nativevideo.r) nativeVideoController).hh()) ? 2 : 3;
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
            public long getActualPlayDuration() {
                return j();
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
            public void j(int i7, String str) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.j
            public void j(ViewGroup viewGroup) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
            public long j() {
                NativeVideoTsView nativeVideoTsView;
                com.bykv.vk.openvk.component.video.api.r.cw nativeVideoController;
                if (r.this.f28951x == null || (nativeVideoTsView = (NativeVideoTsView) r.this.f28951x.get()) == null || (nativeVideoController = nativeVideoTsView.getNativeVideoController()) == null) {
                    return 0L;
                }
                return ((int) nativeVideoController.qv()) / 1000;
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.j
            public void xt(View view, int i7, com.bytedance.sdk.component.adexpress.cw cwVar) {
                qv qvVar;
                if ((i7 == 1 || i7 == 2) && (cwVar instanceof com.bytedance.sdk.openadsdk.core.tj.x)) {
                    com.bytedance.sdk.openadsdk.core.tj.x xVar = (com.bytedance.sdk.openadsdk.core.tj.x) cwVar;
                    qvVar = new qv();
                    qvVar.j(xVar.f30480j);
                    qvVar.xt(xVar.xt);
                    qvVar.cw(xVar.cw);
                    qvVar.r(xVar.f30482r);
                    qvVar.j(xVar.up);
                    qvVar.xt(xVar.f30481m);
                    qvVar.j(xVar.az);
                } else {
                    qvVar = null;
                }
                if (i7 == 2) {
                    r.this.f28943j.j(view, qvVar);
                }
                if (i7 == 1) {
                    r.this.f28943j.xt(view, qvVar);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.j
            public void j(View view) {
                if (r.this.mi != null) {
                    r.this.mi.j(view, r.this);
                }
                n nVar2 = nVar;
                com.bytedance.sdk.openadsdk.core.ugeno.component.interact.oq.j(nVar2, true, a.cw(nVar2), 2, (JSONObject) null);
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.j
            public void j(View view, int i7, com.bytedance.sdk.component.adexpress.cw cwVar) {
                qv qvVar;
                if (cwVar instanceof com.bytedance.sdk.openadsdk.core.tj.x) {
                    com.bytedance.sdk.openadsdk.core.tj.x xVar = (com.bytedance.sdk.openadsdk.core.tj.x) cwVar;
                    qvVar = new qv();
                    qvVar.j(xVar.f30480j);
                    qvVar.xt(xVar.xt);
                    qvVar.cw(xVar.cw);
                    qvVar.r(xVar.f30482r);
                    qvVar.j(xVar.up);
                    qvVar.xt(xVar.f30481m);
                    qvVar.j(xVar.az);
                } else {
                    qvVar = null;
                }
                r.this.f28943j.j(view, qvVar);
                boolean j6 = com.bytedance.sdk.openadsdk.core.ugeno.component.interact.oq.j(r.this.f28951x == null ? null : (NativeVideoTsView) r.this.f28951x.get(), cwVar);
                n nVar2 = nVar;
                com.bytedance.sdk.openadsdk.core.ugeno.component.interact.oq.j(nVar2, j6, a.cw(nVar2), 1, (JSONObject) null);
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
            public void m() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
            public void r() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
            public void up() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
            public void setPauseFromExpressView(boolean z6) {
            }
        });
    }

    private View xt(ViewGroup viewGroup) {
        ImageView imageView = null;
        if (viewGroup != null) {
            ArrayList arrayList = new ArrayList();
            UpieImageView[] upieImageViewArr = {null};
            j(viewGroup, arrayList, upieImageViewArr);
            UpieImageView upieImageView = upieImageViewArr[0];
            if (upieImageView != null) {
                return upieImageView;
            }
            if (!arrayList.isEmpty()) {
                for (int i6 = 0; i6 < arrayList.size(); i6++) {
                    ImageView imageView2 = arrayList.get(i6);
                    if (imageView == null || (imageView2.getWidth() > imageView.getWidth() && imageView2.getHeight() > imageView.getHeight())) {
                        imageView = imageView2;
                    }
                }
            }
        }
        return imageView;
    }

    protected void finalize() throws Throwable {
        super.finalize();
        if (!this.f28944l) {
            x();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.jy
    public void v() {
        rn();
        com.bytedance.sdk.openadsdk.core.ae.r.j().j(this.xt).j(this.f28945m).xt(this.ae);
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.jy
    public void j(ViewGroup viewGroup, View view, com.bytedance.sdk.openadsdk.ch.j.xt.j.j jVar) {
        av.j(viewGroup != null || this.f28942i.get(), "container不能为null");
        av.j(view != null || this.f28942i.get(), "clickView不能为null");
        this.oq = viewGroup;
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(view);
        j(viewGroup, arrayList, null, jVar);
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.jy
    /* renamed from: cw, reason: merged with bridge method [inline-methods] */
    public com.bytedance.sdk.openadsdk.core.tj.jy mi() {
        n nVar = this.xt;
        if (nVar == null || nVar.jl() != 4) {
            return null;
        }
        return new com.bytedance.sdk.openadsdk.core.tj.jy(this.xt);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v2, types: [android.content.Context] */
    private void cw(Activity activity) {
        Context context = this.cw;
        Activity activity2 = activity;
        if (context instanceof Activity) {
            activity2 = activity;
            if (!((Activity) context).isFinishing()) {
                activity2 = this.cw;
            }
        }
        com.bytedance.sdk.openadsdk.core.dislike.ui.j jVar = new com.bytedance.sdk.openadsdk.core.dislike.ui.j(activity2, this.xt.gs(), j(this.f28945m), false);
        this.f28947r = jVar;
        com.bytedance.sdk.openadsdk.core.dislike.cw.j(activity2, this.xt, jVar);
    }

    public void xt() {
        if (this.f28951x == null || this.f28951x.get() == null) {
            return;
        }
        this.f28951x.get().setEasyPlayableEventSender(this.ch.j());
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.jy
    public void j(ViewGroup viewGroup, List<View> list, List<View> list2, com.bytedance.sdk.openadsdk.ch.j.xt.j.j jVar) {
        av.j(viewGroup != null || this.f28942i.get(), "container不能为null");
        av.j(list != null || this.f28942i.get(), "clickView不能为null");
        av.j(list != null && list.size() > 0, "clickViews数量必须大于等于1");
        this.oq = viewGroup;
        j(viewGroup, list, list2, null, jVar);
    }

    private void cw(boolean z5) {
        com.bytedance.sdk.openadsdk.core.kt.ws.j().j(this.f28945m, this.xt, z5);
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.jy
    public void xt(Activity activity) {
        if (activity != null) {
            this.f28943j.j(activity);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.jy
    public void xt(final Dialog dialog, final Integer[] numArr) {
        ws wsVar = this.f28941g;
        if (wsVar != null) {
            wsVar.j(dialog, numArr);
        }
        try {
            dialog.getWindow().getDecorView().addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.bytedance.sdk.openadsdk.core.f.r.5
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View view) {
                    com.bytedance.sdk.openadsdk.core.dislike.cw.xt gs = r.this.xt != null ? r.this.xt.gs() : null;
                    if (gs != null) {
                        com.bytedance.sdk.openadsdk.core.dislike.j.xt.j(gs, dialog, numArr);
                    }
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View view) {
                }
            });
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.jy
    public void j(ViewGroup viewGroup, List<View> list, List<View> list2, View view, com.bytedance.sdk.openadsdk.ch.j.xt.j.j jVar) {
        av.j(viewGroup != null || this.f28942i.get(), "container不能为null");
        av.j(list != null || this.f28942i.get(), "clickView不能为null");
        av.j(list != null && list.size() > 0, "clickViews数量必须大于等于1");
        this.oq = viewGroup;
        j(viewGroup, null, list, list2, view, jVar);
    }

    public void xt(boolean z5) {
        this.vl = z5;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.tl
    public void xt(Double d6) {
        f fVar = this.f28943j;
        if (fVar != null) {
            fVar.j(d6);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.jy
    public void j(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, View view, com.bytedance.sdk.openadsdk.ch.j.xt.j.j jVar) {
        av.j(viewGroup != null || this.f28942i.get(), "container不能为null");
        av.j(list2 != null || this.f28942i.get(), "clickView不能为null");
        av.j(list2 != null && list2.size() > 0, "clickViews数量必须大于等于1");
        this.oq = viewGroup;
        j(viewGroup, list, list2, list3, (List<View>) null, view, jVar);
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.jy
    public void j(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, List<View> list4, View view, com.bytedance.sdk.openadsdk.ch.j.xt.j.j jVar) {
        int i6;
        boolean z5 = false;
        av.j(viewGroup != null || this.f28942i.get(), "container不能为null");
        av.j(list2 != null || this.f28942i.get(), "clickView不能为null");
        av.j(list2 != null && list2.size() > 0, "clickViews数量必须大于等于1");
        this.oq = viewGroup;
        this.mi = jVar;
        if (list3 != null && list3.size() > 0) {
            z5 = true;
        }
        cw(z5);
        List<View> j6 = gq() ? j(list2, list3) : list3;
        if (this.f28942i.get() && ((i6 = this.f28945m) == 5 || i6 == 1 || i6 == 9)) {
            wq();
        }
        if (!this.f28942i.get()) {
            f fVar = this.f28943j;
            if (fVar != null) {
                fVar.j(this.f28939a);
                this.f28943j.j(viewGroup, list, list2, j6, list4, view, jVar, this.f28946p);
            }
            j(viewGroup);
        }
        ae aeVar = this.f28947r;
        if (aeVar instanceof com.bytedance.sdk.openadsdk.core.dislike.ui.j) {
            ((com.bytedance.sdk.openadsdk.core.dislike.ui.j) aeVar).j(this.oq);
        }
    }

    private void j(ViewGroup viewGroup, List<ImageView> list, UpieImageView[] upieImageViewArr) {
        if (viewGroup != null) {
            for (int i6 = 0; i6 < viewGroup.getChildCount(); i6++) {
                View childAt = viewGroup.getChildAt(i6);
                if (childAt instanceof ImageView) {
                    list.add((ImageView) childAt);
                } else if (childAt instanceof UpieImageView) {
                    upieImageViewArr[0] = (UpieImageView) childAt;
                    return;
                } else if (childAt instanceof ViewGroup) {
                    j((ViewGroup) childAt, list, upieImageViewArr);
                }
            }
        }
    }

    private List<View> j(List<View> list, List<View> list2) {
        LinkedList linkedList = new LinkedList();
        if (list != null && !list.isEmpty()) {
            int size = list.size();
            for (int i6 = 0; i6 < size; i6++) {
                linkedList.add(list.get(i6));
            }
        }
        if (list2 != null && !list2.isEmpty()) {
            int size2 = list2.size();
            for (int i7 = 0; i7 < size2; i7++) {
                linkedList.add(list2.get(i7));
            }
        }
        return linkedList;
    }

    public void j(WeakReference<NativeVideoTsView> weakReference) {
        this.f28951x = weakReference;
        f fVar = this.f28943j;
        if (fVar != null) {
            fVar.j(weakReference);
        }
    }

    public void j() {
        NativeVideoTsView nativeVideoTsView;
        if (this.f28951x == null || (nativeVideoTsView = this.f28951x.get()) == null || nativeVideoTsView.av()) {
            return;
        }
        this.f28948s = new UGenVideoOrImgPanelView(this.cw, this.xt, nativeVideoTsView, null, this.oq, uf.xt(this.f28945m), true);
    }

    void j(ViewGroup viewGroup) {
        if (viewGroup != null && this.f28949v && com.bytedance.sdk.openadsdk.l.oq.j(this.xt)) {
            NativeVideoTsView cw = cw(viewGroup);
            if (cw != null) {
                if (5 == this.f28945m) {
                    cw.setIsAutoPlay(this.vl ? this.tl.up() : this.jy);
                    return;
                } else {
                    cw.setIsAutoPlay(this.jy);
                    return;
                }
            }
            NativeVideoTsView nativeVideoTsView = new NativeVideoTsView(this.cw, this.xt, false, false, uf.xt(this.f28945m), false, false);
            if (5 == this.f28945m) {
                nativeVideoTsView.setIsAutoPlay(this.vl ? this.tl.up() : this.jy);
            } else {
                nativeVideoTsView.setIsAutoPlay(this.jy);
            }
            nativeVideoTsView.setTag("ado_tag");
            nativeVideoTsView.setLayoutParams(new ViewGroup.LayoutParams(0, 0));
            viewGroup.addView(nativeVideoTsView);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.jy
    public void j(com.bytedance.sdk.openadsdk.i.cw.j.cw cwVar) {
        av.j(cwVar, "downloadListener不能为null");
        this.f28943j.j(j.C0471j.j(cwVar, this.xt));
        ws wsVar = this.f28941g;
        if (wsVar != null) {
            wsVar.j(cwVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.jy
    public ae j(Activity activity) {
        if (this.f28941g != null && this.f28942i.get()) {
            return this.f28941g.j(activity);
        }
        if (this.f28947r == null) {
            cw(activity);
        }
        return this.f28947r;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.jy
    public ae j(final Dialog dialog, Integer[] numArr) {
        if (dialog != null) {
            com.bytedance.sdk.openadsdk.core.dislike.j.xt.j(this.xt.gs(), dialog, numArr);
            return new ae() { // from class: com.bytedance.sdk.openadsdk.core.f.r.3
                @Override // com.bytedance.sdk.openadsdk.i.cw.xt.ae
                public boolean cw() {
                    return false;
                }

                @Override // com.bytedance.sdk.openadsdk.i.cw.xt.ae
                public void j(com.bytedance.sdk.openadsdk.kt.j.xt.j.j jVar) {
                }

                @Override // com.bytedance.sdk.openadsdk.i.cw.xt.ae
                public void j(String str) {
                }

                @Override // com.bytedance.sdk.openadsdk.i.cw.xt.ae
                public void j() {
                    if (!(dialog.getContext() instanceof Activity) || ((Activity) dialog.getContext()).isFinishing()) {
                        return;
                    }
                    dialog.show();
                }

                @Override // com.bytedance.sdk.openadsdk.i.cw.xt.ae
                public void xt() {
                }
            };
        }
        throw new IllegalArgumentException("dialog is null, please check");
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.jy
    public void j(com.bytedance.sdk.openadsdk.ch.j.xt.j.cw cwVar) {
        this.f28950w = cwVar;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.jy
    public void j(com.bytedance.sdk.openadsdk.ch.j.xt.j.xt xtVar) {
        this.ch.j(xtVar);
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.jy
    public void j(Activity activity, com.bytedance.sdk.openadsdk.kt.j.xt.j.j jVar) {
        ws wsVar;
        if (jVar == null || activity == null || (wsVar = this.f28941g) == null) {
            return;
        }
        wsVar.j(activity, jVar);
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.jy
    public void j(String str) {
        com.bytedance.sdk.openadsdk.core.jy.cw.xt(this.xt, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String j(int i6) {
        if (i6 == 1) {
            return "banner_ad";
        }
        if (i6 == 2) {
            return "interaction";
        }
        if (i6 == 5) {
            return "embeded_ad";
        }
        if (i6 == 6) {
            return "stream";
        }
        if (i6 != 9) {
            return "embeded_ad";
        }
        return "draw_ad";
    }

    private ws j(n nVar) {
        n nVar2 = this.xt;
        if (nVar2 == null || hh.j(nVar2) != 2) {
            return null;
        }
        boolean z5 = ln.ws(nVar) != null;
        int i6 = this.f28945m;
        if (i6 == 1) {
            if (z5) {
                return new com.bytedance.sdk.openadsdk.core.bannerexpress.cw(this.cw, nVar, this.tl);
            }
            return new com.bytedance.sdk.openadsdk.core.bannerexpress.xt(this.cw, nVar, this.tl);
        }
        if (i6 != 5) {
            if (i6 != 9) {
                return null;
            }
            return new com.bytedance.sdk.openadsdk.core.nativeexpress.x(this.cw, nVar, this.tl);
        }
        if (z5) {
            return new ch(this.cw, nVar, this.tl);
        }
        return new com.bytedance.sdk.openadsdk.core.nativeexpress.v(this.cw, nVar, this.tl);
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.tl
    public void j(Double d6) {
        if (this.tj) {
            return;
        }
        l.j(this.xt, d6);
        this.tj = true;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.tl
    public void j(Double d6, String str, String str2) {
        if (this.f28940f) {
            return;
        }
        l.j(this.xt, d6, str, str2);
        this.f28940f = true;
    }

    public void j(boolean z5) {
        this.jy = z5;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.tl
    public void j(com.bytedance.sdk.openadsdk.i.cw.j.xt xtVar) {
        n nVar = this.xt;
        if (nVar != null) {
            x.j(nVar.uv(), xtVar, com.bytedance.sdk.openadsdk.i.cw.j.xt.class);
        }
    }

    public void j(com.bytedance.sdk.openadsdk.ch.j.xt.j.j jVar) {
        this.f28946p = jVar;
    }
}
