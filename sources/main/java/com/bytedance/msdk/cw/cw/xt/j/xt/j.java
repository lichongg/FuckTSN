package com.bytedance.msdk.cw.cw.xt.j.xt;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.core.gq;
import com.bytedance.sdk.openadsdk.i.cw.cw.xt;
import com.bytedance.sdk.openadsdk.i.cw.xt.jy;
import com.bytedance.sdk.openadsdk.i.cw.xt.ws;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.stub.StubApp;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes3.dex */
public class j extends com.bytedance.msdk.cw.cw.xt.j.xt.xt {
    private com.bytedance.msdk.cw.m.xt.xt cw;
    private com.bytedance.msdk.api.j.xt xt;

    class cw extends com.bytedance.msdk.xt.cw {

        /* renamed from: g, reason: collision with root package name */
        ws f24933g;
        private boolean jy;
        SoftReference<FrameLayout> oq;
        private boolean ws;
        final Object qv = new Object();
        private volatile boolean az = false;
        private final com.bytedance.sdk.openadsdk.s.j.xt.j.xt av = new com.bytedance.sdk.openadsdk.s.j.xt.j.xt(null) { // from class: com.bytedance.msdk.cw.cw.xt.j.xt.j.cw.4
            @Override // com.bytedance.sdk.openadsdk.s.j.xt.j.xt
            public void j(View view, int i6) {
                if (((com.bytedance.msdk.xt.cw) cw.this).ae instanceof com.bytedance.msdk.j.xt.j) {
                    cw.this.m100if().j(view);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.s.j.xt.j.xt
            public void xt(View view, int i6) {
                if (((com.bytedance.msdk.xt.cw) cw.this).ae instanceof com.bytedance.msdk.j.xt.j) {
                    cw.this.m100if().xt(view);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.s.j.xt.j.xt
            public void j(View view, String str, int i6) {
                cw.this.ws = false;
                com.bytedance.msdk.j.up.cw.r("TTMediationSDK_banner", com.bytedance.msdk.j.up.up.xt(j.this.cw.xt(), j.this.cw.vl()) + "TTBannerView onRenderFail -> code=" + i6 + ",msg=" + str);
            }

            @Override // com.bytedance.sdk.openadsdk.s.j.xt.j.xt
            public void j(View view, float f6, float f7) {
                com.bytedance.msdk.j.up.cw.r("TTMediationSDK_banner", com.bytedance.msdk.j.up.up.xt(j.this.cw.xt(), j.this.cw.vl()) + "TTBannerView onRenderSuccess 渲染成功！！mBannerViewRef = " + cw.this.oq);
                SoftReference<FrameLayout> softReference = cw.this.oq;
                if (softReference != null) {
                    FrameLayout frameLayout = softReference.get();
                    if (frameLayout != null) {
                        com.bytedance.msdk.api.up.j(view);
                        frameLayout.addView(view, new ViewGroup.LayoutParams(-1, -1));
                    }
                    cw.this.ws = true;
                }
            }
        };

        @Override // com.bytedance.msdk.xt.cw
        public synchronized View g() {
            SoftReference<FrameLayout> softReference = this.oq;
            if (softReference == null) {
                return null;
            }
            FrameLayout frameLayout = softReference.get();
            synchronized (this.qv) {
                if (frameLayout == null) {
                    try {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        long j6 = 2000 + uptimeMillis;
                        while (!this.ws && uptimeMillis < j6) {
                            this.qv.wait(j6 - uptimeMillis);
                            uptimeMillis = SystemClock.uptimeMillis();
                        }
                    } catch (InterruptedException e6) {
                        com.bytedance.sdk.component.utils.vl.j(e6);
                    }
                }
            }
            return frameLayout;
        }

        @Override // com.bytedance.msdk.xt.cw
        public void w() {
            this.az = true;
            com.bytedance.msdk.j.up.m.cw(new Runnable() { // from class: com.bytedance.msdk.cw.cw.xt.j.xt.j.cw.2
                @Override // java.lang.Runnable
                public void run() {
                    ws wsVar = cw.this.f24933g;
                    if (wsVar != null) {
                        wsVar.j((com.bytedance.sdk.openadsdk.s.j.xt.j.j) null);
                        cw.this.f24933g.up();
                    }
                }
            });
        }

        cw() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: if, reason: not valid java name */
        public com.bytedance.msdk.j.xt.j m100if() {
            return (com.bytedance.msdk.j.xt.j) this.ae;
        }

        @Override // com.bytedance.msdk.xt.cw
        public long ig() {
            ws wsVar = this.f24933g;
            if (wsVar != null) {
                return com.bytedance.msdk.j.cw.xt.j(wsVar.tl());
            }
            return 0L;
        }

        @Override // com.bytedance.msdk.xt.cw
        public com.bytedance.sdk.openadsdk.i.cw.xt.r kk() {
            if (this.f24933g == null) {
                return null;
            }
            com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "pangle banner : getDislikeInfo");
            return this.f24933g.m();
        }

        @Override // com.bytedance.msdk.xt.cw
        public String o() {
            ws wsVar = this.f24933g;
            return wsVar != null ? com.bytedance.msdk.j.cw.xt.cw(wsVar.tl()) : "";
        }

        @Override // com.bytedance.msdk.xt.cw
        public Map<String, Object> p() {
            Map<String, Object> tl;
            ws wsVar = this.f24933g;
            if (wsVar == null || (tl = wsVar.tl()) == null) {
                return null;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("coupon", tl.get("coupon"));
            hashMap.put("live_room", tl.get("live_room"));
            hashMap.put("product", tl.get("product"));
            cw(hashMap);
            return super.p();
        }

        @Override // com.bytedance.msdk.xt.cw
        public void uf(String str) {
            com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "pangle banner : uploadDislikeEvent event = ".concat(String.valueOf(str)));
            ws wsVar = this.f24933g;
            if (wsVar != null) {
                wsVar.j(str);
            }
        }

        @Override // com.bytedance.msdk.xt.cw
        public boolean up() {
            return this.az;
        }

        @Override // com.bytedance.msdk.xt.cw
        public void v(int i6) {
            if (this.f24933g != null) {
                com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "pangle banner : setSlideIntervalTime  intervalTime = ".concat(String.valueOf(i6)));
                this.f24933g.j(i6);
            }
        }

        @Override // com.bytedance.msdk.xt.cw
        public long yb() {
            ws wsVar = this.f24933g;
            if (wsVar != null) {
                return com.bytedance.msdk.j.cw.xt.xt(wsVar.tl());
            }
            return 0L;
        }

        public void j(final Context context) {
            gq j6 = j.this.j(context);
            if (j6 == null) {
                return;
            }
            xt.j j7 = com.bytedance.msdk.j.cw.xt.j(j.this.xt, j.this.cw.vl(), j.this.cw.av(), j.this.cw.i(), j.this.cw.ch(), false);
            float ws = j.this.xt.ws();
            j7.j(ws).xt(j.this.xt.az());
            j6.cw(j7.j(), new com.bytedance.sdk.openadsdk.tj.j.xt.j.m(null) { // from class: com.bytedance.msdk.cw.cw.xt.j.xt.j.cw.1
                @Override // com.bytedance.sdk.openadsdk.tj.j.xt.j.m
                public void j(int i6, String str) {
                    j.this.j(new com.bytedance.msdk.api.j(i6, str));
                }

                @Override // com.bytedance.sdk.openadsdk.tj.j.xt.j.m
                public void j(List<ws> list) {
                    Map<String, Object> tl;
                    if (list == null || list.size() == 0 || context == null) {
                        j.this.j(new com.bytedance.msdk.api.j(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "load list is null or empty"));
                        return;
                    }
                    cw.this.f24933g = list.get(0);
                    Context context2 = context;
                    if (context2 instanceof Activity) {
                        cw.this.f24933g.j((Activity) context2, new com.bytedance.sdk.openadsdk.kt.j.xt.j.j(null) { // from class: com.bytedance.msdk.cw.cw.xt.j.xt.j.cw.1.1
                            @Override // com.bytedance.sdk.openadsdk.kt.j.xt.j.j
                            public void j() {
                            }

                            @Override // com.bytedance.sdk.openadsdk.kt.j.xt.j.j
                            public void j(int i6, String str, boolean z5) {
                                if (cw.this.jy) {
                                    return;
                                }
                                cw.this.jy = true;
                                if (((com.bytedance.msdk.xt.cw) cw.this).ae instanceof com.bytedance.msdk.j.xt.j) {
                                    com.bytedance.msdk.core.xt.j.j(j.this.cw.xt());
                                    cw.this.m100if().f_();
                                }
                            }

                            @Override // com.bytedance.sdk.openadsdk.kt.j.xt.j.j
                            public void xt() {
                            }
                        });
                    }
                    cw.this.ae(true);
                    cw cwVar = cw.this;
                    cwVar.vl(cwVar.f24933g.cw());
                    cw cwVar2 = cw.this;
                    cwVar2.qv(cwVar2.f24933g.xt());
                    if (j.this.cw.j() && (tl = cw.this.f24933g.tl()) != null) {
                        double j8 = com.bytedance.msdk.j.cw.xt.j(tl.get("price"));
                        com.bytedance.msdk.j.up.cw.j("TTMediationSDK_ECMP", com.bytedance.msdk.j.up.up.xt(j.this.cw.xt(), j.this.cw.vl()) + "pangle banner 返回的 cpm价格：" + j8);
                        cw cwVar3 = cw.this;
                        if (j8 <= 0.0d) {
                            j8 = 0.0d;
                        }
                        cwVar3.j(j8);
                    }
                    cw cwVar4 = cw.this;
                    cwVar4.f24933g.j(cwVar4.av);
                    cw.this.oq = new SoftReference<>(new FrameLayout(context));
                    cw.this.f24933g.r();
                    ArrayList arrayList = new ArrayList(1);
                    arrayList.add(cw.this);
                    j.this.j(arrayList);
                }
            });
        }

        @Override // com.bytedance.msdk.xt.cw
        public void j(Activity activity, final com.bytedance.sdk.openadsdk.kt.j.xt.j.j jVar) {
            if (this.f24933g != null) {
                com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "pangle banner : activity = " + activity + " pluginDislikeInteractionCallback:" + jVar);
                this.f24933g.j(activity, new com.bytedance.sdk.openadsdk.kt.j.xt.j.j(null) { // from class: com.bytedance.msdk.cw.cw.xt.j.xt.j.cw.3
                    @Override // com.bytedance.sdk.openadsdk.kt.j.xt.j.j
                    public void j() {
                        com.bytedance.sdk.openadsdk.kt.j.xt.j.j jVar2 = jVar;
                        if (jVar2 != null) {
                            jVar2.j();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.kt.j.xt.j.j
                    public void xt() {
                        com.bytedance.sdk.openadsdk.kt.j.xt.j.j jVar2 = jVar;
                        if (jVar2 != null) {
                            jVar2.xt();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.kt.j.xt.j.j
                    public void j(int i6, String str, boolean z5) {
                        if (cw.this.jy) {
                            return;
                        }
                        cw.this.jy = true;
                        com.bytedance.msdk.core.xt.j.j(j.this.cw.xt());
                        com.bytedance.sdk.openadsdk.kt.j.xt.j.j jVar2 = jVar;
                        if (jVar2 != null) {
                            jVar2.j(i6, str, z5);
                        }
                    }
                });
            }
        }

        @Override // com.bytedance.msdk.xt.cw
        public void j(Dialog dialog, Integer[] numArr) {
            if (this.f24933g != null) {
                com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "pangle banner :  ttDislikeDialogAbstract = ".concat(String.valueOf(dialog)));
                this.f24933g.j(dialog, numArr);
            }
        }

        @Override // com.bytedance.msdk.xt.cw
        public com.bytedance.sdk.openadsdk.i.cw.xt.ae j(Activity activity) {
            if (this.f24933g == null) {
                return null;
            }
            com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "pangle banner : getDislikeDialog = ".concat(String.valueOf(activity)));
            return this.f24933g.j(activity);
        }

        @Override // com.bytedance.msdk.xt.cw
        public void j(com.bytedance.sdk.openadsdk.i.cw.j.xt xtVar) {
            com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "pangle banner : setAdInteractionListener pluginTTAdInteractionListener = ".concat(String.valueOf(xtVar)));
            ws wsVar = this.f24933g;
            if (wsVar != null) {
                wsVar.j(xtVar);
            }
        }
    }

    /* renamed from: com.bytedance.msdk.cw.cw.xt.j.xt.j$j, reason: collision with other inner class name */
    class C0372j extends com.bytedance.msdk.xt.cw {
        private boolean jy;
        private com.bytedance.sdk.openadsdk.i.cw.xt.oq qv;
        private Context vl;
        private volatile boolean ws = false;

        /* renamed from: g, reason: collision with root package name */
        com.bytedance.sdk.openadsdk.ch.j.xt.j.j f24939g = new com.bytedance.sdk.openadsdk.ch.j.xt.j.j(0 == true ? 1 : 0) { // from class: com.bytedance.msdk.cw.cw.xt.j.xt.j.j.3
            @Override // com.bytedance.sdk.openadsdk.ch.j.xt.j.j
            public void j(View view, jy jyVar) {
                if (((com.bytedance.msdk.xt.cw) C0372j.this).ae instanceof com.bytedance.msdk.j.xt.j) {
                    C0372j.this.m101if().j(view);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.ch.j.xt.j.j
            public void xt(View view, jy jyVar) {
                if (((com.bytedance.msdk.xt.cw) C0372j.this).ae instanceof com.bytedance.msdk.j.xt.j) {
                    C0372j.this.m101if().j(view);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.ch.j.xt.j.j
            public void j(jy jyVar) {
                if (((com.bytedance.msdk.xt.cw) C0372j.this).ae instanceof com.bytedance.msdk.j.xt.j) {
                    C0372j.this.m101if().xt(null);
                }
            }
        };

        @Override // com.bytedance.msdk.xt.cw
        public boolean kt() {
            return true;
        }

        @Override // com.bytedance.msdk.xt.cw
        public void w() {
            this.ws = true;
            com.bytedance.msdk.j.up.m.cw(new Runnable() { // from class: com.bytedance.msdk.cw.cw.xt.j.xt.j.j.2
                @Override // java.lang.Runnable
                public void run() {
                    if (C0372j.this.qv != null) {
                        C0372j.this.qv.j((com.bytedance.sdk.openadsdk.v.j.xt.j.j) null);
                        C0372j.this.qv.j((com.bytedance.sdk.openadsdk.i.cw.j.xt) null);
                        C0372j.this.qv.x();
                    }
                }
            });
        }

        C0372j(Context context, com.bytedance.sdk.openadsdk.i.cw.xt.oq oqVar) {
            Map<String, Object> f6;
            this.qv = oqVar;
            this.vl = context;
            com.bytedance.sdk.openadsdk.i.cw.xt.cw mi = oqVar.mi();
            if (mi != null) {
                f(mi.j());
                v(mi.cw());
                ch(mi.r());
                s(mi.xt());
                HashMap hashMap = new HashMap();
                Map<String, String> up = mi.up();
                if (up != null && up.size() > 0) {
                    hashMap.putAll(up);
                }
                up(hashMap);
                if (com.bytedance.msdk.j.cw.xt.j("5.4.0.3")) {
                    vl(mi.ae());
                }
                if (com.bytedance.msdk.j.cw.xt.j("6.8.1.6")) {
                    oq(mi.tl());
                }
                qv(mi.g());
            }
            la(oqVar.ae());
            gq(oqVar.tl());
            p(oqVar.g());
            a(oqVar.ws() != null ? oqVar.ws().cw() : null);
            qv(oqVar.i());
            vl(oqVar.av());
            rn(oqVar.jy());
            r(oqVar.oq());
            tl(oqVar.av() == 4);
            ae(false);
            if (oqVar.i() == 16 || oqVar.i() == 3 || oqVar.i() == 2 || oqVar.i() == 131) {
                if (oqVar.az() != null && !oqVar.az().isEmpty() && oqVar.az().get(0) != null) {
                    com.bytedance.sdk.openadsdk.i.cw.xt.vl vlVar = oqVar.az().get(0);
                    l(vlVar.cw());
                    mi(vlVar.j());
                    w(vlVar.xt());
                }
            } else if (oqVar.i() == 4 && oqVar.az() != null && oqVar.az().size() > 0) {
                ArrayList arrayList = new ArrayList();
                Iterator<com.bytedance.sdk.openadsdk.i.cw.xt.vl> it = oqVar.az().iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().cw());
                }
                j((List<String>) arrayList);
            }
            qv(oqVar.i());
            if (!j.this.cw.j() || (f6 = oqVar.f()) == null) {
                return;
            }
            double j6 = com.bytedance.msdk.j.cw.xt.j(f6.get("price"));
            com.bytedance.msdk.j.up.cw.j("TTMediationSDK_ECMP", "pangle native 返回的 cpm价格：".concat(String.valueOf(j6)));
            j(j6 <= 0.0d ? 0.0d : j6);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: if, reason: not valid java name */
        public com.bytedance.msdk.j.xt.j m101if() {
            return (com.bytedance.msdk.j.xt.j) this.ae;
        }

        @Override // com.bytedance.msdk.xt.cw
        public int el() {
            com.bytedance.sdk.openadsdk.i.cw.xt.oq oqVar = this.qv;
            if (oqVar != null) {
                return oqVar.cw();
            }
            return 0;
        }

        @Override // com.bytedance.msdk.xt.cw
        public int hu() {
            com.bytedance.sdk.openadsdk.i.cw.xt.oq oqVar = this.qv;
            if (oqVar != null) {
                return oqVar.r();
            }
            return 0;
        }

        @Override // com.bytedance.msdk.xt.cw
        public long ig() {
            com.bytedance.sdk.openadsdk.i.cw.xt.oq oqVar = this.qv;
            if (oqVar != null) {
                return com.bytedance.msdk.j.cw.xt.j(oqVar.f());
            }
            return 0L;
        }

        @Override // com.bytedance.msdk.xt.cw
        public com.bytedance.sdk.openadsdk.i.cw.xt.r kk() {
            if (this.qv == null) {
                return null;
            }
            com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "pangle banner native : getDislikeInfo");
            return this.qv.w();
        }

        @Override // com.bytedance.msdk.xt.cw
        public String o() {
            com.bytedance.sdk.openadsdk.i.cw.xt.oq oqVar = this.qv;
            return oqVar != null ? com.bytedance.msdk.j.cw.xt.cw(oqVar.f()) : "";
        }

        @Override // com.bytedance.msdk.xt.cw
        public Map<String, Object> p() {
            Map<String, Object> f6;
            com.bytedance.sdk.openadsdk.i.cw.xt.oq oqVar = this.qv;
            if (oqVar == null || (f6 = oqVar.f()) == null) {
                return null;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("coupon", f6.get("coupon"));
            hashMap.put("live_room", f6.get("live_room"));
            hashMap.put("product", f6.get("product"));
            cw(hashMap);
            return super.p();
        }

        @Override // com.bytedance.msdk.xt.cw
        public void uf(String str) {
            com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "pangle banner native: uploadDislikeEvent event = ".concat(String.valueOf(str)));
            com.bytedance.sdk.openadsdk.i.cw.xt.oq oqVar = this.qv;
            if (oqVar != null) {
                oqVar.j(str);
            }
        }

        @Override // com.bytedance.msdk.xt.cw
        public boolean up() {
            return this.ws;
        }

        @Override // com.bytedance.msdk.xt.cw
        public com.bytedance.sdk.openadsdk.i.cw.xt.ae xt(Dialog dialog, Integer[] numArr) {
            if (this.qv == null) {
                return null;
            }
            com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "pangle banner native : getDislikeDialog = ".concat(String.valueOf(dialog)));
            return this.qv.j(dialog, numArr);
        }

        @Override // com.bytedance.msdk.xt.cw
        public long yb() {
            com.bytedance.sdk.openadsdk.i.cw.xt.oq oqVar = this.qv;
            if (oqVar != null) {
                return com.bytedance.msdk.j.cw.xt.xt(oqVar.f());
            }
            return 0L;
        }

        @Override // com.bytedance.msdk.xt.cw
        public void j(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, com.bytedance.msdk.api.r.j.ae.oq oqVar, List<View> list4) {
            FrameLayout frameLayout;
            com.bytedance.sdk.openadsdk.i.cw.xt.oq oqVar2;
            View tj;
            View findViewById;
            super.j(activity, viewGroup, list, list2, list3, oqVar, list4);
            com.bytedance.sdk.openadsdk.i.cw.xt.oq oqVar3 = this.qv;
            if (oqVar3 != null) {
                oqVar3.j(viewGroup, (List<View>) null, list, list2, list3, (View) null, this.f24939g);
                this.qv.j(activity, new com.bytedance.sdk.openadsdk.kt.j.xt.j.j(null) { // from class: com.bytedance.msdk.cw.cw.xt.j.xt.j.j.1
                    @Override // com.bytedance.sdk.openadsdk.kt.j.xt.j.j
                    public void j() {
                    }

                    @Override // com.bytedance.sdk.openadsdk.kt.j.xt.j.j
                    public void j(int i6, String str, boolean z5) {
                        if (C0372j.this.jy) {
                            return;
                        }
                        C0372j.this.jy = true;
                        if (((com.bytedance.msdk.xt.cw) C0372j.this).ae instanceof com.bytedance.msdk.j.xt.j) {
                            com.bytedance.msdk.core.xt.j.j(j.this.cw.xt());
                            C0372j.this.m101if().f_();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.kt.j.xt.j.j
                    public void xt() {
                    }
                });
            }
            com.bytedance.sdk.openadsdk.i.cw.xt.oq oqVar4 = this.qv;
            if (oqVar4 != null && oqVar4.m() != null && oqVar != null && (findViewById = viewGroup.findViewById(oqVar.vl)) != null) {
                findViewById.setVisibility(0);
                if (findViewById instanceof ViewGroup) {
                    ViewGroup viewGroup2 = (ViewGroup) findViewById;
                    viewGroup2.removeAllViews();
                    ImageView imageView = new ImageView(this.vl);
                    imageView.setImageBitmap(this.qv.m());
                    imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                    ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
                    layoutParams.width = com.bytedance.msdk.api.up.cw(this.vl, 38.0f);
                    layoutParams.height = com.bytedance.msdk.api.up.cw(this.vl, 38.0f);
                    findViewById.setLayoutParams(layoutParams);
                    viewGroup2.addView(imageView, -1, -1);
                } else if (findViewById instanceof ImageView) {
                    ((ImageView) findViewById).setImageBitmap(this.qv.m());
                }
            }
            if (oqVar == null || (frameLayout = (FrameLayout) viewGroup.findViewById(oqVar.ae)) == null || (oqVar2 = this.qv) == null || (tj = oqVar2.tj()) == null) {
                return;
            }
            xt(tj);
            frameLayout.removeAllViews();
            frameLayout.addView(tj, -1, -1);
        }

        @Override // com.bytedance.msdk.xt.cw
        public void j(Activity activity, final com.bytedance.sdk.openadsdk.kt.j.xt.j.j jVar) {
            if (this.qv != null) {
                com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "pangle banner native:  activity = " + activity + " pluginDislikeInteractionCallback:" + jVar);
                this.qv.j(activity, new com.bytedance.sdk.openadsdk.kt.j.xt.j.j(null) { // from class: com.bytedance.msdk.cw.cw.xt.j.xt.j.j.4
                    @Override // com.bytedance.sdk.openadsdk.kt.j.xt.j.j
                    public void j() {
                        com.bytedance.sdk.openadsdk.kt.j.xt.j.j jVar2 = jVar;
                        if (jVar2 != null) {
                            jVar2.j();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.kt.j.xt.j.j
                    public void xt() {
                        com.bytedance.sdk.openadsdk.kt.j.xt.j.j jVar2 = jVar;
                        if (jVar2 != null) {
                            jVar2.xt();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.kt.j.xt.j.j
                    public void j(int i6, String str, boolean z5) {
                        if (C0372j.this.jy) {
                            return;
                        }
                        C0372j.this.jy = true;
                        com.bytedance.msdk.core.xt.j.j(j.this.cw.xt());
                        com.bytedance.sdk.openadsdk.kt.j.xt.j.j jVar2 = jVar;
                        if (jVar2 != null) {
                            jVar2.j(i6, str, z5);
                        }
                    }
                });
            }
        }

        @Override // com.bytedance.msdk.xt.cw
        public void j(Dialog dialog, Integer[] numArr) {
            if (this.qv != null) {
                com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "pangle banner native:  ttDislikeDialogAbstract = ".concat(String.valueOf(dialog)));
                if (dialog instanceof TTDislikeDialogAbstract) {
                    this.qv.xt(dialog, numArr);
                }
            }
        }

        @Override // com.bytedance.msdk.xt.cw
        public com.bytedance.sdk.openadsdk.i.cw.xt.ae j(Activity activity) {
            if (this.qv == null) {
                return null;
            }
            com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "pangle banner native: getDislikeDialog = ".concat(String.valueOf(activity)));
            return this.qv.j(activity);
        }

        @Override // com.bytedance.msdk.xt.cw
        public void j(com.bytedance.sdk.openadsdk.i.cw.j.xt xtVar) {
            com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "pangle banner native: setAdInteractionListener pluginTTAdInteractionListener = ".concat(String.valueOf(xtVar)));
            com.bytedance.sdk.openadsdk.i.cw.xt.oq oqVar = this.qv;
            if (oqVar != null) {
                oqVar.j(xtVar);
            }
        }
    }

    class xt extends com.bytedance.msdk.xt.cw {

        /* renamed from: g, reason: collision with root package name */
        ws f24944g;
        private final com.bytedance.sdk.openadsdk.s.j.xt.j.xt jy;
        private boolean qv;
        private volatile boolean vl = false;

        @Override // com.bytedance.msdk.xt.cw
        public void w() {
            this.vl = true;
            com.bytedance.msdk.j.up.m.cw(new Runnable() { // from class: com.bytedance.msdk.cw.cw.xt.j.xt.j.xt.2
                @Override // java.lang.Runnable
                public void run() {
                    ws wsVar = xt.this.f24944g;
                    if (wsVar != null) {
                        wsVar.up();
                    }
                }
            });
        }

        xt(Context context, ws wsVar) {
            Map<String, Object> tl;
            Function function = null;
            com.bytedance.sdk.openadsdk.s.j.xt.j.xt xtVar = new com.bytedance.sdk.openadsdk.s.j.xt.j.xt(function) { // from class: com.bytedance.msdk.cw.cw.xt.j.xt.j.xt.3
                @Override // com.bytedance.sdk.openadsdk.s.j.xt.j.xt
                public void j(View view, int i6) {
                    if (((com.bytedance.msdk.xt.cw) xt.this).ae instanceof com.bytedance.msdk.j.xt.j) {
                        xt.this.m102if().j(view);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.s.j.xt.j.xt
                public void xt(View view, int i6) {
                    if (((com.bytedance.msdk.xt.cw) xt.this).ae instanceof com.bytedance.msdk.j.xt.j) {
                        xt.this.m102if().xt(view);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.s.j.xt.j.xt
                public void j(View view, String str, int i6) {
                    j.this.j(new com.bytedance.msdk.api.j(i6, str));
                }

                @Override // com.bytedance.sdk.openadsdk.s.j.xt.j.xt
                public void j(View view, float f6, float f7) {
                    ArrayList arrayList = new ArrayList(1);
                    arrayList.add(xt.this);
                    j.this.j(arrayList);
                }
            };
            this.jy = xtVar;
            this.f24944g = wsVar;
            qv(wsVar.xt());
            vl(this.f24944g.cw());
            ae(true);
            this.f24944g.j(xtVar);
            if (context instanceof Activity) {
                this.f24944g.j((Activity) context, new com.bytedance.sdk.openadsdk.kt.j.xt.j.j(function) { // from class: com.bytedance.msdk.cw.cw.xt.j.xt.j.xt.1
                    @Override // com.bytedance.sdk.openadsdk.kt.j.xt.j.j
                    public void j() {
                    }

                    @Override // com.bytedance.sdk.openadsdk.kt.j.xt.j.j
                    public void j(int i6, String str, boolean z5) {
                        if (xt.this.qv) {
                            return;
                        }
                        xt.this.qv = true;
                        if (((com.bytedance.msdk.xt.cw) xt.this).ae instanceof com.bytedance.msdk.j.xt.j) {
                            com.bytedance.msdk.core.xt.j.j(j.this.cw.xt());
                            xt.this.m102if().f_();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.kt.j.xt.j.j
                    public void xt() {
                    }
                });
            }
            if (!j.this.cw.j() || (tl = this.f24944g.tl()) == null) {
                return;
            }
            double j6 = com.bytedance.msdk.j.cw.xt.j(tl.get("price"));
            com.bytedance.msdk.j.up.cw.j("TTMediationSDK_ECMP", "banner混存 pangle 模板native 返回的 cpm价格：".concat(String.valueOf(j6)));
            j(j6 <= 0.0d ? 0.0d : j6);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: if, reason: not valid java name */
        public com.bytedance.msdk.j.xt.j m102if() {
            return (com.bytedance.msdk.j.xt.j) this.ae;
        }

        @Override // com.bytedance.msdk.xt.cw
        public View g() {
            ws wsVar = this.f24944g;
            if (wsVar != null) {
                return wsVar.j();
            }
            return null;
        }

        @Override // com.bytedance.msdk.xt.cw
        public long ig() {
            ws wsVar = this.f24944g;
            if (wsVar != null) {
                return com.bytedance.msdk.j.cw.xt.j(wsVar.tl());
            }
            return 0L;
        }

        @Override // com.bytedance.msdk.xt.cw
        public com.bytedance.sdk.openadsdk.i.cw.xt.r kk() {
            ws wsVar = this.f24944g;
            return wsVar != null ? wsVar.m() : super.kk();
        }

        @Override // com.bytedance.msdk.xt.cw
        public String o() {
            ws wsVar = this.f24944g;
            return wsVar != null ? com.bytedance.msdk.j.cw.xt.cw(wsVar.tl()) : "";
        }

        @Override // com.bytedance.msdk.xt.cw
        public Map<String, Object> p() {
            Map<String, Object> tl;
            ws wsVar = this.f24944g;
            if (wsVar == null || (tl = wsVar.tl()) == null) {
                return null;
            }
            com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "getMediaExtraInfo ".concat(String.valueOf(tl)));
            cw(tl);
            return super.p();
        }

        @Override // com.bytedance.msdk.xt.cw
        public void qv() {
            ws wsVar = this.f24944g;
            if (wsVar != null) {
                wsVar.r();
            }
        }

        @Override // com.bytedance.msdk.xt.cw
        public void uf(String str) {
            com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "pangle banner express: uploadDislikeEvent event = ".concat(String.valueOf(str)));
            ws wsVar = this.f24944g;
            if (wsVar != null) {
                wsVar.j(str);
            }
        }

        @Override // com.bytedance.msdk.xt.cw
        public boolean up() {
            return this.vl;
        }

        @Override // com.bytedance.msdk.xt.cw
        public long yb() {
            ws wsVar = this.f24944g;
            if (wsVar != null) {
                return com.bytedance.msdk.j.cw.xt.xt(wsVar.tl());
            }
            return 0L;
        }

        @Override // com.bytedance.msdk.xt.cw
        public void j(Activity activity, final com.bytedance.sdk.openadsdk.kt.j.xt.j.j jVar) {
            if (this.f24944g != null) {
                com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "pangle banner-native express:  activity = " + activity + " pluginDislikeInteractionCallback:" + jVar);
                this.f24944g.j(activity, new com.bytedance.sdk.openadsdk.kt.j.xt.j.j(null) { // from class: com.bytedance.msdk.cw.cw.xt.j.xt.j.xt.4
                    @Override // com.bytedance.sdk.openadsdk.kt.j.xt.j.j
                    public void j() {
                        com.bytedance.sdk.openadsdk.kt.j.xt.j.j jVar2 = jVar;
                        if (jVar2 != null) {
                            jVar2.j();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.kt.j.xt.j.j
                    public void xt() {
                        com.bytedance.sdk.openadsdk.kt.j.xt.j.j jVar2 = jVar;
                        if (jVar2 != null) {
                            jVar2.xt();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.kt.j.xt.j.j
                    public void j(int i6, String str, boolean z5) {
                        if (xt.this.qv) {
                            return;
                        }
                        xt.this.qv = true;
                        com.bytedance.msdk.core.xt.j.j(j.this.cw.xt());
                        com.bytedance.sdk.openadsdk.kt.j.xt.j.j jVar2 = jVar;
                        if (jVar2 != null) {
                            jVar2.j(i6, str, z5);
                        }
                    }
                });
            }
        }

        @Override // com.bytedance.msdk.xt.cw
        public void j(Dialog dialog, Integer[] numArr) {
            if (this.f24944g != null) {
                com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "pangle banner-native express:  ttDislikeDialogAbstract = ".concat(String.valueOf(dialog)));
                this.f24944g.j(dialog, numArr);
            }
        }

        @Override // com.bytedance.msdk.xt.cw
        public com.bytedance.sdk.openadsdk.i.cw.xt.ae j(Activity activity) {
            ws wsVar = this.f24944g;
            if (wsVar != null) {
                return wsVar.j(activity);
            }
            return super.j(activity);
        }

        @Override // com.bytedance.msdk.xt.cw
        public void j(com.bytedance.sdk.openadsdk.i.cw.j.cw cwVar) {
            com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "pangle banner express: setDownloadListener pluginTTAppDownloadListener = ".concat(String.valueOf(cwVar)));
            ws wsVar = this.f24944g;
            if (wsVar != null) {
                wsVar.j(cwVar);
            }
        }

        @Override // com.bytedance.msdk.xt.cw
        public void j(com.bytedance.sdk.openadsdk.s.j.xt.j.cw cwVar) {
            com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "pangle banner express: setVideoAdListener pluginExpressVideoAdListener = ".concat(String.valueOf(cwVar)));
            ws wsVar = this.f24944g;
            if (wsVar != null) {
                wsVar.j(cwVar);
            }
        }

        @Override // com.bytedance.msdk.xt.cw
        public void j(com.bytedance.sdk.openadsdk.i.cw.j.xt xtVar) {
            com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "pangle banner express: setAdInteractionListener pluginTTAdInteractionListener = ".concat(String.valueOf(xtVar)));
            ws wsVar = this.f24944g;
            if (wsVar != null) {
                wsVar.j(xtVar);
            }
        }
    }

    @Override // com.bytedance.msdk.cw.cw.xt.j.xt
    public void xt(Context context, com.bytedance.msdk.cw.m.xt.xt xtVar, com.bytedance.msdk.api.j.xt xtVar2, Map<String, Object> map) {
        this.xt = xtVar2;
        this.cw = xtVar;
        if (xtVar2 == null) {
            j(new com.bytedance.msdk.api.j("load ad fail adSlot is null"));
            return;
        }
        if (map != null) {
            Object obj = map.get("tt_ad_sub_type");
            if (obj == null || ((Integer) obj).intValue() != 4) {
                new cw().j(StubApp.getOrigApplicationContext(context.getApplicationContext()));
                return;
            }
            Object obj2 = map.get("tt_ad_origin_type");
            if (obj2 != null) {
                int intValue = ((Integer) obj2).intValue();
                if (intValue == 1) {
                    xt(StubApp.getOrigApplicationContext(context.getApplicationContext()));
                } else if (intValue == 2) {
                    cw(StubApp.getOrigApplicationContext(context.getApplicationContext()));
                } else {
                    j(new com.bytedance.msdk.api.j(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "originType is mismatch"));
                }
            }
        }
    }

    public j(com.bytedance.msdk.cw.j.xt xtVar) {
        super(xtVar);
    }

    private void cw(final Context context) {
        gq j6 = j(context);
        if (j6 == null) {
            return;
        }
        xt.j j7 = com.bytedance.msdk.j.cw.xt.j(this.xt, this.cw.vl(), this.cw.av(), this.cw.i(), this.cw.ch(), false);
        j7.j(this.xt.ch()).xt(this.xt.s());
        j6.j(j7.j(), new com.bytedance.sdk.openadsdk.tj.j.xt.j.cw(null) { // from class: com.bytedance.msdk.cw.cw.xt.j.xt.j.2
            @Override // com.bytedance.sdk.openadsdk.tj.j.xt.j.cw
            public void j(int i6, String str) {
                j.this.j(new com.bytedance.msdk.api.j(i6, str));
            }

            @Override // com.bytedance.sdk.openadsdk.tj.j.xt.j.cw
            public void j(List<com.bytedance.sdk.openadsdk.i.cw.xt.oq> list) {
                if (list == null || list.isEmpty()) {
                    j.this.j(new com.bytedance.msdk.api.j(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "load list is null or empty"));
                    return;
                }
                ArrayList arrayList = new ArrayList(1);
                arrayList.add(j.this.new C0372j(context, list.get(0)));
                j.this.j(arrayList);
            }
        });
    }

    private void xt(final Context context) {
        gq j6 = j(context);
        if (j6 == null) {
            return;
        }
        xt.j xt2 = com.bytedance.msdk.j.cw.xt.j(this.xt, this.cw.vl(), this.cw.av(), this.cw.i(), this.cw.ch(), false).j(this.xt.ch()).xt(this.xt.s());
        float ws = this.xt.ws();
        float az = this.xt.az();
        boolean j7 = com.bytedance.msdk.j.cw.xt.j(this.xt);
        com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "pangle banner native express autoHeight:" + j7 + " width:" + ws + "  height:" + az);
        if (az > 0.0f && !j7) {
            xt2.j(ws).xt(az);
        } else {
            xt2.j(ws).xt(0.0f);
        }
        j6.j(xt2.j(), new com.bytedance.sdk.openadsdk.tj.j.xt.j.m(null) { // from class: com.bytedance.msdk.cw.cw.xt.j.xt.j.1
            @Override // com.bytedance.sdk.openadsdk.tj.j.xt.j.m
            public void j(int i6, String str) {
                j.this.j(new com.bytedance.msdk.api.j(i6, str));
            }

            @Override // com.bytedance.sdk.openadsdk.tj.j.xt.j.m
            public void j(List<ws> list) {
                if (list == null || list.size() == 0) {
                    j.this.j(new com.bytedance.msdk.api.j(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "load list is null or empty"));
                    return;
                }
                for (ws wsVar : list) {
                    if (wsVar != null) {
                        j.this.new xt(context, wsVar).qv();
                        return;
                    }
                }
            }
        });
    }
}
