package com.bytedance.sdk.openadsdk.core;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.component.utils.f;
import com.bytedance.sdk.openadsdk.core.EmptyView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.xt.j.cw.cw;
import com.bytedance.sdk.openadsdk.core.xt.j.j.j;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.xt.j f28914a;
    private com.bytedance.sdk.openadsdk.ch.j.xt.j.j ae;
    private com.bytedance.sdk.openadsdk.ch.j.xt.j.j av;
    private View az;
    private volatile com.bytedance.sdk.openadsdk.core.xt.j ch;
    private final Context cw;

    /* renamed from: f, reason: collision with root package name */
    private EmptyView f28915f;
    private com.bytedance.sdk.openadsdk.core.video.nativevideo.j gq;

    /* renamed from: j, reason: collision with root package name */
    private final com.bytedance.sdk.openadsdk.core.tj.n f28919j;
    private ViewGroup jy;

    /* renamed from: l, reason: collision with root package name */
    private Activity f28920l;
    private com.bytedance.sdk.openadsdk.core.ugeno.component.interact.ae la;

    /* renamed from: m, reason: collision with root package name */
    private String f28921m;
    private com.bytedance.sdk.openadsdk.core.qv.xt.j mi;

    /* renamed from: p, reason: collision with root package name */
    private WeakReference<NativeVideoTsView> f28922p;

    /* renamed from: r, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.i.cw.xt.jy f28923r;

    /* renamed from: s, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.xt.j f28924s;
    private long tl;

    /* renamed from: v, reason: collision with root package name */
    private View f28925v;

    /* renamed from: w, reason: collision with root package name */
    private com.bytedance.sdk.component.utils.f f28926w;
    private WeakReference<ViewGroup> ws;

    /* renamed from: x, reason: collision with root package name */
    private volatile com.bytedance.sdk.openadsdk.core.xt.xt f28927x;
    private volatile com.bytedance.sdk.openadsdk.core.qv.xt.cw xt;
    private List<View> up = new ArrayList();

    /* renamed from: g, reason: collision with root package name */
    private Double f28916g = null;
    private AtomicBoolean oq = new AtomicBoolean(false);
    private AtomicBoolean qv = new AtomicBoolean(false);
    private AtomicBoolean vl = new AtomicBoolean(false);

    /* renamed from: i, reason: collision with root package name */
    private int f28918i = 5;
    private volatile long kt = 0;
    private volatile boolean tj = true;

    /* renamed from: h, reason: collision with root package name */
    private volatile boolean f28917h = false;

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, Object> ae() {
        NativeVideoTsView nativeVideoTsView;
        HashMap hashMap = new HashMap();
        if (this.up != null) {
            JSONArray jSONArray = new JSONArray();
            for (View view : this.up) {
                if (view != null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("width", view.getWidth());
                        jSONObject.put("height", view.getHeight());
                        jSONObject.put("alpha", view.getAlpha());
                    } catch (Throwable unused) {
                    }
                    jSONArray.put(jSONObject);
                }
            }
            hashMap.put("image_view", jSONArray.toString());
        }
        if (this.jy != null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("width", this.jy.getWidth());
                jSONObject2.put("height", this.jy.getHeight());
                jSONObject2.put("alpha", this.jy.getAlpha());
            } catch (Throwable unused2) {
            }
            hashMap.put("root_view", jSONObject2.toString());
        }
        WeakReference<NativeVideoTsView> weakReference = this.f28922p;
        if (weakReference != null && (nativeVideoTsView = weakReference.get()) != null) {
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("width", nativeVideoTsView.getWidth());
                jSONObject3.put("height", nativeVideoTsView.getHeight());
                jSONObject3.put("alpha", nativeVideoTsView.getAlpha());
            } catch (JSONException unused3) {
            }
            hashMap.put("video_view", jSONObject3.toString());
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cw() {
        com.bytedance.sdk.openadsdk.core.tj.n nVar = this.f28919j;
        if (nVar == null || nVar.jl() != 4) {
            return;
        }
        if (this.f28917h) {
            r();
        } else {
            this.f28917h = true;
            com.bytedance.sdk.openadsdk.l.ae.j(new com.bytedance.sdk.component.oq.g("feed_register_download") { // from class: com.bytedance.sdk.openadsdk.core.f.1
                @Override // java.lang.Runnable
                public void run() {
                    if (f.this.xt == null) {
                        f fVar = f.this;
                        fVar.xt = com.bytedance.sdk.openadsdk.core.qv.tl.j(fVar.cw, f.this.f28919j, f.this.f28921m, false);
                    }
                    f.this.xt.j(f.this.f28920l);
                    f.this.r();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        com.bytedance.sdk.openadsdk.core.tj.vl up = up();
        if (up == null) {
            return;
        }
        final float xt = up.xt();
        final float cw = up.cw();
        if (this.f28926w == null) {
            this.f28926w = new com.bytedance.sdk.component.utils.f(v.getContext(), 1, oq.i().up());
        }
        this.f28926w.xt(this.f28919j.km());
        this.f28926w.j(this.f28919j.mt());
        this.f28926w.xt(this.f28919j.lr());
        this.f28926w.m(this.f28919j.qo());
        this.f28926w.cw(this.f28919j.xn());
        this.f28926w.j(this.f28919j.si());
        this.f28926w.up(this.f28919j.wo());
        this.f28926w.j(new f.j() { // from class: com.bytedance.sdk.openadsdk.core.f.6
            @Override // com.bytedance.sdk.component.utils.f.j
            public void j(int i6) {
                if (i6 == 1 && f.this.tj && uf.j(f.this.jy)) {
                    com.bytedance.sdk.openadsdk.core.rn.gq.j(f.this.ws, xt, cw, f.this.kt);
                }
            }
        });
        com.bytedance.sdk.component.utils.f fVar = this.f28926w;
        com.bytedance.sdk.openadsdk.core.tj.n nVar = this.f28919j;
        fVar.j(nVar != null ? nVar.ae() : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        if (this.xt != null) {
            if (this.f28927x != null) {
                ((com.bytedance.sdk.openadsdk.core.xt.j.j.j) this.f28927x.j(com.bytedance.sdk.openadsdk.core.xt.j.j.j.class)).j(this.xt);
            }
            if (this.ch != null) {
                ((com.bytedance.sdk.openadsdk.core.xt.j.j.j) this.ch.j(com.bytedance.sdk.openadsdk.core.xt.j.j.j.class)).j(this.xt);
            }
            com.bytedance.sdk.openadsdk.core.xt.j jVar = this.f28914a;
            if (jVar != null) {
                ((com.bytedance.sdk.openadsdk.core.xt.j.j.j) jVar.j(com.bytedance.sdk.openadsdk.core.xt.j.j.j.class)).j(this.xt);
            }
            com.bytedance.sdk.openadsdk.core.xt.j jVar2 = this.f28924s;
            if (jVar2 != null) {
                ((com.bytedance.sdk.openadsdk.core.xt.j.j.j) jVar2.j(com.bytedance.sdk.openadsdk.core.xt.j.j.j.class)).j(this.xt);
            }
            try {
                this.xt.j(false);
                this.xt.j(this.mi);
            } catch (Exception e6) {
                com.bytedance.sdk.component.utils.vl.j(e6);
            }
        }
    }

    private com.bytedance.sdk.openadsdk.core.tj.vl up() {
        com.bytedance.sdk.openadsdk.core.tj.n nVar;
        com.bytedance.sdk.openadsdk.core.tj.vl pa;
        if (this.f28918i == 5 && (nVar = this.f28919j) != null && (pa = nVar.pa()) != null && pa.j() == 1) {
            return pa;
        }
        return null;
    }

    public f(Context context, com.bytedance.sdk.openadsdk.i.cw.xt.jy jyVar, com.bytedance.sdk.openadsdk.core.tj.n nVar, String str) {
        this.f28921m = "embeded_ad";
        this.f28923r = jyVar;
        this.f28919j = nVar;
        this.cw = context;
        this.f28921m = str;
    }

    private View xt(ViewGroup viewGroup) {
        Object obj;
        for (int i6 = 0; i6 < viewGroup.getChildCount(); i6++) {
            View childAt = viewGroup.getChildAt(i6);
            Object tag = childAt.getTag();
            String str = "";
            if ((tag instanceof Map) && (obj = ((Map) tag).get(CommonNetImpl.TAG)) != null) {
                str = obj.toString();
            }
            if ("shake_compat".equals(str)) {
                return childAt;
            }
        }
        return null;
    }

    public void j(com.bytedance.sdk.openadsdk.i.cw.xt.jy jyVar) {
        this.f28923r = jyVar;
    }

    public void j(Activity activity) {
        this.f28920l = activity;
        if (this.xt != null) {
            this.xt.j(activity);
        }
    }

    private EmptyView cw(ViewGroup viewGroup) {
        for (int i6 = 0; i6 < viewGroup.getChildCount(); i6++) {
            View childAt = viewGroup.getChildAt(i6);
            if (childAt instanceof EmptyView) {
                return (EmptyView) childAt;
            }
        }
        return null;
    }

    public void j(View view, int i6) {
        com.bytedance.sdk.openadsdk.ch.j.xt.j.j jVar = this.ae;
        if (jVar != null) {
            jVar.xt(view, this.f28923r);
        }
    }

    public void j(NativeExpressView nativeExpressView) {
        if (nativeExpressView != null) {
            if (this.ch != null) {
                nativeExpressView.setClickCreativeListener(this.ch);
            }
            if (this.f28927x != null) {
                nativeExpressView.setClickListener(this.f28927x);
            }
        }
    }

    public void xt(View view, com.bytedance.sdk.openadsdk.core.tj.qv qvVar) {
        if (this.f28927x != null) {
            this.f28927x.j(view, qvVar);
        }
    }

    public void xt() {
        if (this.xt != null) {
            this.xt.xt();
        }
        WeakReference<ViewGroup> weakReference = this.ws;
        if (weakReference != null) {
            weakReference.clear();
        }
        final ViewGroup viewGroup = this.jy;
        final EmptyView emptyView = this.f28915f;
        if (viewGroup != null && emptyView != null) {
            com.bytedance.sdk.component.utils.tl.xt().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.f.8
                @Override // java.lang.Runnable
                public void run() {
                    viewGroup.removeView(emptyView);
                }
            });
        }
        final View view = this.f28925v;
        if (viewGroup != null && view != null) {
            com.bytedance.sdk.component.utils.tl.xt().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.f.9
                @Override // java.lang.Runnable
                public void run() {
                    viewGroup.removeView(view);
                }
            });
        }
        com.bytedance.sdk.component.utils.f fVar = this.f28926w;
        if (fVar != null) {
            com.bytedance.sdk.openadsdk.core.tj.n nVar = this.f28919j;
            fVar.xt(nVar != null ? nVar.ae() : 0);
        }
        com.bytedance.sdk.openadsdk.core.tj.n nVar2 = this.f28919j;
        com.bytedance.sdk.openadsdk.core.rn.rn.xt(nVar2 != null ? nVar2.ae() : 0);
    }

    public com.bytedance.sdk.openadsdk.core.qv.xt.cw j() {
        return this.xt;
    }

    public void j(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, List<View> list4, View view, com.bytedance.sdk.openadsdk.ch.j.xt.j.j jVar, com.bytedance.sdk.openadsdk.ch.j.xt.j.j jVar2) {
        EmptyView emptyView;
        final com.bytedance.sdk.openadsdk.ch.j.xt.j.j jVar3;
        this.ae = jVar;
        this.jy = viewGroup;
        this.ws = new WeakReference<>(this.jy);
        this.az = view;
        this.av = jVar2;
        com.bytedance.sdk.openadsdk.core.jy.cw.j(this.f28919j);
        Context context = this.cw;
        com.bytedance.sdk.openadsdk.core.tj.n nVar = this.f28919j;
        String str = this.f28921m;
        this.f28914a = new com.bytedance.sdk.openadsdk.core.xt.j(context, nVar, str, com.bytedance.sdk.openadsdk.core.rn.uf.xt(str));
        j(viewGroup);
        EmptyView cw = cw(viewGroup);
        if (cw == null) {
            com.bytedance.sdk.openadsdk.core.tj.n nVar2 = this.f28919j;
            EmptyView emptyView2 = new EmptyView(this.cw, viewGroup, nVar2 != null ? nVar2.at() : 1000) { // from class: com.bytedance.sdk.openadsdk.core.f.2
                @Override // android.view.View
                protected void onVisibilityChanged(View view2, int i6) {
                    super.onVisibilityChanged(view2, i6);
                    com.bytedance.sdk.component.utils.f fVar = f.this.f28926w;
                    if (fVar != null) {
                        try {
                            f.this.tj = isShown();
                            int i7 = 0;
                            if (isShown()) {
                                if (f.this.f28919j != null) {
                                    i7 = f.this.f28919j.ae();
                                }
                                fVar.j(i7);
                            } else {
                                if (f.this.f28919j != null) {
                                    i7 = f.this.f28919j.ae();
                                }
                                fVar.xt(i7);
                            }
                        } catch (Throwable unused) {
                        }
                    }
                }
            };
            emptyView2.j(this.f28919j, this.f28921m);
            viewGroup.addView(emptyView2);
            emptyView = emptyView2;
        } else {
            emptyView = cw;
        }
        emptyView.j();
        emptyView.setRefClickViews(list2);
        emptyView.setRefCreativeViews(list3);
        emptyView.setRefDirectDownloadViews(list4);
        this.f28915f = emptyView;
        j(this.f28914a, this.jy, this.az, jVar, this.av, 3);
        this.up = list;
        Context context2 = this.cw;
        com.bytedance.sdk.openadsdk.core.tj.n nVar3 = this.f28919j;
        String str2 = this.f28921m;
        this.f28927x = new com.bytedance.sdk.openadsdk.core.xt.xt(context2, nVar3, str2, com.bytedance.sdk.openadsdk.core.rn.uf.xt(str2));
        j(this.f28927x, viewGroup, view, jVar, jVar2, 0);
        Context context3 = this.cw;
        com.bytedance.sdk.openadsdk.core.tj.n nVar4 = this.f28919j;
        String str3 = this.f28921m;
        this.ch = new com.bytedance.sdk.openadsdk.core.xt.j(context3, nVar4, str3, com.bytedance.sdk.openadsdk.core.rn.uf.xt(str3));
        j(this.ch, viewGroup, view, jVar, jVar2, 1);
        if (com.bytedance.sdk.component.utils.oq.j(list4)) {
            jVar3 = jVar;
        } else {
            Context context4 = this.cw;
            com.bytedance.sdk.openadsdk.core.tj.n nVar5 = this.f28919j;
            String str4 = this.f28921m;
            com.bytedance.sdk.openadsdk.core.xt.j jVar4 = new com.bytedance.sdk.openadsdk.core.xt.j(context4, nVar5, str4, com.bytedance.sdk.openadsdk.core.rn.uf.xt(str4));
            this.f28924s = jVar4;
            jVar4.j(2);
            jVar3 = jVar;
            j(this.f28924s, viewGroup, view, jVar3, jVar2, 2);
        }
        emptyView.j(list2, this.f28927x);
        emptyView.j(list3, this.ch);
        emptyView.j(list4, this.f28924s);
        emptyView.setCallback(new EmptyView.j() { // from class: com.bytedance.sdk.openadsdk.core.f.3
            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.j
            public void j(boolean z5) {
                f fVar = f.this;
                fVar.tl = com.bytedance.sdk.openadsdk.core.jy.cw.j(fVar.tl, z5, f.this.f28919j, f.this.f28921m, 3);
                if (f.this.f28926w != null) {
                    if (z5) {
                        f.this.f28926w.j(f.this.f28919j != null ? f.this.f28919j.ae() : 0);
                        return;
                    }
                    try {
                        if (f.this.f28926w != null) {
                            f.this.f28926w.xt(f.this.f28919j != null ? f.this.f28919j.ae() : 0);
                        }
                    } catch (Throwable th) {
                        com.bytedance.sdk.component.utils.vl.r("ShakeUtils", "onPause error:" + th.getMessage());
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.j
            public void xt() {
                if (f.this.xt != null) {
                    f.this.xt.xt();
                }
                try {
                    if (f.this.f28926w != null) {
                        f.this.f28926w.xt(f.this.f28919j != null ? f.this.f28919j.ae() : 0);
                    }
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.vl.r("ShakeUtils", "onPause error:" + th.getMessage());
                }
                f.this.oq.set(false);
                f.this.qv.set(false);
                f fVar = f.this;
                fVar.tl = com.bytedance.sdk.openadsdk.core.jy.cw.j(fVar.tl, f.this.f28919j, f.this.f28921m, 23);
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.j
            public void j() {
                f.this.cw();
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.j
            public void j(View view2, Map<String, Object> map) {
                f.this.cw();
                f.this.tl = System.currentTimeMillis();
                Map ae = f.this.ae();
                ae.put("is_repeat", Boolean.valueOf(f.this.vl.get()));
                if (map != null && map.containsKey("show_send_type")) {
                    ae.put("show_send_type", map.get("show_send_type"));
                }
                ae.put("is_repeat", Boolean.valueOf(f.this.vl.get()));
                f.this.oq.set(true);
                if (!f.this.qv.get()) {
                    f.this.qv.set(true);
                    com.bytedance.sdk.openadsdk.core.jy.cw.j(f.this.f28919j, f.this.f28921m, (Map<String, Object>) ae, f.this.f28916g);
                    com.bytedance.sdk.openadsdk.core.a.j.j().r();
                    com.bytedance.sdk.openadsdk.core.rn.rn.j(f.this.f28919j != null ? f.this.f28919j.ae() : 0);
                }
                if (jVar3 != null) {
                    boolean rs = v.xt().rs();
                    if (!f.this.vl.getAndSet(true) || rs) {
                        jVar3.j(f.this.f28923r);
                        if (f.this.f28919j != null && f.this.f28919j.up() && f.this.f28919j.m111if() != null) {
                            com.bytedance.sdk.openadsdk.ae.j.j().j(f.this.cw, f.this.f28919j.m111if().xt());
                        }
                    }
                    f.this.kt = System.currentTimeMillis();
                    f.this.m();
                }
                if (f.this.gq != null) {
                    f.this.gq.j();
                }
                if (f.this.la != null) {
                    f.this.la.r();
                }
            }
        });
        emptyView.setNeedCheckingShow(true);
        cw();
    }

    public void j(com.bytedance.sdk.openadsdk.core.ugeno.component.interact.ae aeVar) {
        this.la = aeVar;
    }

    public void j(com.bytedance.sdk.openadsdk.core.video.nativevideo.j jVar) {
        this.gq = jVar;
    }

    public void j(WeakReference<NativeVideoTsView> weakReference) {
        this.f28922p = weakReference;
    }

    private void j(com.bytedance.sdk.openadsdk.core.xt.xt xtVar, ViewGroup viewGroup, View view, final com.bytedance.sdk.openadsdk.ch.j.xt.j.j jVar, final com.bytedance.sdk.openadsdk.ch.j.xt.j.j jVar2, int i6) {
        j((com.bytedance.sdk.openadsdk.core.xt.j.cw.cw) xtVar.j(com.bytedance.sdk.openadsdk.core.xt.j.cw.cw.class));
        if (i6 != 3) {
            HashMap hashMap = new HashMap();
            hashMap.put("click_type", 1);
            ((com.bytedance.sdk.openadsdk.core.xt.j.cw.j) xtVar.j(com.bytedance.sdk.openadsdk.core.xt.j.cw.j.class)).j(hashMap);
        }
        xtVar.j(viewGroup);
        xtVar.xt(view);
        ((com.bytedance.sdk.openadsdk.core.xt.j.j.j) xtVar.j(com.bytedance.sdk.openadsdk.core.xt.j.j.j.class)).j(this.f28923r);
        ((com.bytedance.sdk.openadsdk.core.xt.j.j.j) xtVar.j(com.bytedance.sdk.openadsdk.core.xt.j.j.j.class)).j(new j.InterfaceC0499j() { // from class: com.bytedance.sdk.openadsdk.core.f.4
            @Override // com.bytedance.sdk.openadsdk.core.xt.j.j.j.InterfaceC0499j
            public void j(View view2, int i7) {
                com.bytedance.sdk.openadsdk.ch.j.xt.j.j jVar3 = jVar;
                if (jVar3 != null) {
                    jVar3.xt(view2, f.this.f28923r);
                }
                com.bytedance.sdk.openadsdk.ch.j.xt.j.j jVar4 = jVar2;
                if (jVar4 != null) {
                    jVar4.xt(view2, f.this.f28923r);
                }
                if (i7 != 2 || f.this.f28919j == null) {
                    return;
                }
                f.this.f28919j.cw(true);
            }
        });
    }

    public void j(int i6) {
        this.f28918i = i6;
    }

    private void j(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        View xt = xt(viewGroup);
        if (xt != null) {
            HashMap hashMap = new HashMap();
            hashMap.put(CommonNetImpl.TAG, "shake_compat");
            hashMap.put("click_listener", this.f28914a);
            try {
                xt.setTag(com.bytedance.sdk.openadsdk.core.rn.gq.f30074j, hashMap);
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.vl.r("ShakeUtils", "onPause error:" + th.getMessage());
                com.bytedance.sdk.openadsdk.core.rn.gq.j(com.bytedance.sdk.openadsdk.core.rn.gq.f30074j, th.getMessage());
            }
            this.f28925v = xt;
            return;
        }
        View view = new View(this.cw);
        view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.bytedance.sdk.openadsdk.core.f.5
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                try {
                    if (f.this.f28926w != null) {
                        f.this.f28926w.xt(f.this.f28919j != null ? f.this.f28919j.ae() : 0);
                    }
                } catch (Throwable th2) {
                    com.bytedance.sdk.component.utils.vl.r("ShakeUtils", "onPause error:" + th2.getMessage());
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
            }
        });
        HashMap hashMap2 = new HashMap();
        hashMap2.put(CommonNetImpl.TAG, "shake_compat");
        hashMap2.put("click_listener", this.f28914a);
        try {
            view.setTag(com.bytedance.sdk.openadsdk.core.rn.gq.f30074j, hashMap2);
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.vl.r("ShakeUtils", "onPause error:" + th2.getMessage());
            com.bytedance.sdk.openadsdk.core.rn.gq.j(com.bytedance.sdk.openadsdk.core.rn.gq.f30074j, th2.getMessage());
        }
        view.setLayoutParams(new ViewGroup.LayoutParams(0, 0));
        viewGroup.addView(view);
        this.f28925v = view;
    }

    public void j(final com.bytedance.sdk.openadsdk.core.xt.j.cw.cw cwVar) {
        cwVar.j(new cw.j() { // from class: com.bytedance.sdk.openadsdk.core.f.7
            @Override // com.bytedance.sdk.openadsdk.core.xt.j.cw.cw.j
            public boolean j() {
                cwVar.j(f.this.f28915f);
                cwVar.j(f.this.ae());
                cwVar.j(f.this.f28921m);
                cwVar.j(f.this.f28916g);
                return f.this.oq.get();
            }
        });
    }

    public void j(com.bytedance.sdk.openadsdk.core.qv.xt.j jVar) {
        this.mi = jVar;
    }

    public void j(View view, com.bytedance.sdk.openadsdk.core.tj.qv qvVar) {
        if (this.ch != null) {
            this.ch.j(view, qvVar);
        }
    }

    public void j(Double d6) {
        this.f28916g = d6;
    }
}
