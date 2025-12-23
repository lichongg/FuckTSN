package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.core.s;
import com.bytedance.sdk.openadsdk.core.tj.nd;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class gq implements Function<SparseArray<Object>, Object> {

    /* renamed from: j, reason: collision with root package name */
    private final s f29091j = v.j();
    private volatile Context xt;

    private void g(PluginValueSet pluginValueSet, Function<SparseArray<Object>, Object> function) {
        j(com.bytedance.sdk.openadsdk.core.rn.a.j(7, pluginValueSet), new com.bytedance.sdk.openadsdk.core.j.g(function));
    }

    private void tl(PluginValueSet pluginValueSet, Function<SparseArray<Object>, Object> function) {
        j(com.bytedance.sdk.openadsdk.core.rn.a.j(5, pluginValueSet), new com.bytedance.sdk.openadsdk.core.j.up(function));
    }

    public void ae(PluginValueSet pluginValueSet, Function<SparseArray<Object>, Object> function) {
        cw(com.bytedance.sdk.openadsdk.core.rn.a.j(1, pluginValueSet), new com.bytedance.sdk.openadsdk.core.j.tl(function));
    }

    public void cw(PluginValueSet pluginValueSet, Function<SparseArray<Object>, Object> function) {
        j(1, com.bytedance.sdk.openadsdk.core.rn.a.j(1, pluginValueSet), new com.bytedance.sdk.openadsdk.core.j.ae(function));
    }

    public void up(PluginValueSet pluginValueSet, Function<SparseArray<Object>, Object> function) {
        j(com.bytedance.sdk.openadsdk.core.rn.a.j(5, pluginValueSet), new com.bytedance.sdk.openadsdk.core.j.tl(function));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Context getContext() {
        if (this.xt == null) {
            this.xt = v.getContext();
        }
        return this.xt;
    }

    public void m(PluginValueSet pluginValueSet, Function<SparseArray<Object>, Object> function) {
        xt(com.bytedance.sdk.openadsdk.core.rn.a.j(9, pluginValueSet), new com.bytedance.sdk.openadsdk.core.j.tl(function));
    }

    public void r(PluginValueSet pluginValueSet, Function<SparseArray<Object>, Object> function) {
        j(com.bytedance.sdk.openadsdk.core.rn.a.j(8, pluginValueSet), new com.bytedance.sdk.openadsdk.core.j.m(function));
    }

    public void xt(final com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, final com.bytedance.sdk.openadsdk.tj.j.xt.j.cw cwVar) {
        if (!com.bytedance.sdk.openadsdk.core.p.g.j()) {
            cwVar.j(1000, "广告请求开关已关闭,请联系穿山甲管理员");
            return;
        }
        com.bytedance.sdk.component.oq.g gVar = new com.bytedance.sdk.component.oq.g("loadStream") { // from class: com.bytedance.sdk.openadsdk.core.gq.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.bytedance.sdk.openadsdk.core.component.j.j.j().xt(gq.this.getContext(), xtVar, cwVar);
                } catch (Throwable th) {
                    cwVar.j(4000, "feed component maybe not exist, pls check1, msg = " + th.getMessage());
                    com.bytedance.sdk.component.utils.vl.cw("TTAdNativeImpl", "feed component maybe not exist, pls check1", th);
                }
            }
        };
        if (tj.f30204j) {
            j(gVar, 6);
            com.bytedance.sdk.openadsdk.core.m.j.cw().j(6, xtVar);
        } else {
            com.bytedance.sdk.component.utils.vl.r("TTAdNativeImpl", "please exec TTAdSdk.init and TTAdSdk.start before load ad");
            cwVar.j(10000, "please exec TTAdSdk.init and TTAdSdk.start before load ad");
        }
    }

    public gq(Context context) {
        this.xt = StubApp.getOrigApplicationContext((context == null ? v.getContext() : context).getApplicationContext());
    }

    public void cw(final com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, final com.bytedance.sdk.openadsdk.tj.j.xt.j.m mVar) {
        if (!com.bytedance.sdk.openadsdk.core.p.g.j()) {
            mVar.j(1000, "广告请求开关已关闭,请联系穿山甲管理员");
            return;
        }
        com.bytedance.sdk.component.oq.g gVar = new com.bytedance.sdk.component.oq.g("loadBannerExpressAd") { // from class: com.bytedance.sdk.openadsdk.core.gq.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (gq.this.j(xtVar, false)) {
                        com.bytedance.sdk.openadsdk.core.nativeexpress.r.j(gq.this.getContext()).j(xtVar, 1, mVar, 5000);
                    } else {
                        mVar.j(110, g.j(110));
                    }
                } catch (Throwable th) {
                    mVar.j(4000, " msg = " + th.getMessage());
                    com.bytedance.sdk.component.utils.vl.cw("TTAdNativeImpl", "Banner express error, pls check", th);
                }
            }
        };
        if (!tj.f30204j) {
            com.bytedance.sdk.component.utils.vl.r("TTAdNativeImpl", "please exec TTAdSdk.init and TTAdSdk.start before load ad");
            mVar.j(10000, "please exec TTAdSdk.init and TTAdSdk.start before load ad");
        } else {
            j(gVar, 1);
            com.bytedance.sdk.openadsdk.core.m.j.cw().j(1, xtVar);
        }
    }

    public void j(final com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, final com.bytedance.sdk.openadsdk.tj.j.xt.j.cw cwVar) {
        if (!com.bytedance.sdk.openadsdk.core.p.g.j()) {
            cwVar.j(1000, "广告请求开关已关闭,请联系穿山甲管理员");
            return;
        }
        com.bytedance.sdk.component.oq.g gVar = new com.bytedance.sdk.component.oq.g("loadFeedAd") { // from class: com.bytedance.sdk.openadsdk.core.gq.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.bytedance.sdk.openadsdk.core.component.j.j.j().j(gq.this.getContext(), xtVar, cwVar);
                } catch (Throwable th) {
                    cwVar.j(4000, "feed component maybe not exist, pls check1, msg = " + th.getMessage());
                    com.bytedance.sdk.component.utils.vl.cw("TTAdNativeImpl", "feed component maybe not exist, pls check1", th);
                }
            }
        };
        if (!tj.f30204j) {
            com.bytedance.sdk.component.utils.vl.r("TTAdNativeImpl", "please exec TTAdSdk.init and TTAdSdk.start before load ad");
            cwVar.j(10000, "Please exec  TTAdSdk.init and TTAdSdk.start before load ad");
        } else {
            j(gVar, 5);
            com.bytedance.sdk.openadsdk.core.m.j.cw().j(5, xtVar);
        }
    }

    public void xt(PluginValueSet pluginValueSet, Function<SparseArray<Object>, Object> function) {
        j(com.bytedance.sdk.openadsdk.core.rn.a.j(9, pluginValueSet), new com.bytedance.sdk.openadsdk.core.j.r(function));
    }

    public void j(PluginValueSet pluginValueSet, Function<SparseArray<Object>, Object> function) {
        xt(com.bytedance.sdk.openadsdk.core.rn.a.j(6, pluginValueSet), new com.bytedance.sdk.openadsdk.core.j.up(function));
    }

    public void xt(final com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, final com.bytedance.sdk.openadsdk.tj.j.xt.j.m mVar) {
        if (!com.bytedance.sdk.openadsdk.core.p.g.j()) {
            mVar.j(1000, "广告请求开关已关闭,请联系穿山甲管理员");
            return;
        }
        com.bytedance.sdk.component.oq.g gVar = new com.bytedance.sdk.component.oq.g("loadExpressDrawFeedAd") { // from class: com.bytedance.sdk.openadsdk.core.gq.10
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (gq.this.j(xtVar, false)) {
                        com.bytedance.sdk.openadsdk.core.nativeexpress.r.j(gq.this.getContext()).j(xtVar, 9, mVar, 5000);
                    } else {
                        mVar.j(110, g.j(110));
                    }
                } catch (Throwable th) {
                    mVar.j(4000, " msg = " + th.getMessage());
                    com.bytedance.sdk.component.utils.vl.cw("TTAdNativeImpl", "Error msg =", th);
                }
            }
        };
        if (!tj.f30204j) {
            com.bytedance.sdk.component.utils.vl.r("TTAdNativeImpl", "please exec TTAdSdk.init and TTAdSdk.start before load ad");
            mVar.j(10000, "please exec TTAdSdk.init and TTAdSdk.start before load ad");
        } else {
            j(gVar, 9);
            com.bytedance.sdk.openadsdk.core.m.j.cw().j(9, xtVar);
        }
    }

    public void j(final com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, final com.bytedance.sdk.openadsdk.tj.j.xt.j.xt xtVar2) {
        if (!com.bytedance.sdk.openadsdk.core.p.g.j()) {
            xtVar2.j(1000, "广告请求开关已关闭,请联系穿山甲管理员");
            return;
        }
        com.bytedance.sdk.component.oq.g gVar = new com.bytedance.sdk.component.oq.g("loadDrawFeedAd") { // from class: com.bytedance.sdk.openadsdk.core.gq.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    gq.this.j(xtVar);
                    com.bytedance.sdk.openadsdk.core.component.j.j.j().j(gq.this.getContext(), xtVar, xtVar2);
                } catch (Throwable th) {
                    xtVar2.j(4000, "feed component maybe not exist, pls check2, msg = " + th.getMessage());
                    com.bytedance.sdk.component.utils.vl.cw("TTAdNativeImpl", "feed component maybe not exist, pls check2", th);
                }
            }
        };
        if (!tj.f30204j) {
            com.bytedance.sdk.component.utils.vl.r("TTAdNativeImpl", "please exec TTAdSdk.init and TTAdSdk.start before load ad");
            xtVar2.j(10000, "please exec TTAdSdk.init and TTAdSdk.start before load ad");
        } else {
            j(gVar, 9);
            com.bytedance.sdk.openadsdk.core.m.j.cw().j(9, xtVar);
        }
    }

    public void j(final int i6, final com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, final com.bytedance.sdk.openadsdk.tj.j.xt.j.up upVar) {
        if (!com.bytedance.sdk.openadsdk.core.p.g.j()) {
            upVar.j(1000, "广告请求开关已关闭,请联系穿山甲管理员");
            return;
        }
        final long currentTimeMillis = System.currentTimeMillis();
        com.bytedance.sdk.component.oq.g gVar = new com.bytedance.sdk.component.oq.g("loadNativeAd") { // from class: com.bytedance.sdk.openadsdk.core.gq.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    nd ndVar = new nd();
                    ndVar.tl = currentTimeMillis;
                    gq.this.f29091j.j(xtVar, ndVar, i6, new s.xt() { // from class: com.bytedance.sdk.openadsdk.core.gq.5.1
                        @Override // com.bytedance.sdk.openadsdk.core.s.xt
                        public void j(int i7, String str, com.bytedance.sdk.openadsdk.core.tj.xt xtVar2) {
                            upVar.j(i7, str);
                            xtVar2.j(i7);
                            com.bytedance.sdk.openadsdk.core.tj.xt.j(xtVar2);
                        }

                        @Override // com.bytedance.sdk.openadsdk.core.s.xt
                        public void j(com.bytedance.sdk.openadsdk.core.tj.j jVar, com.bytedance.sdk.openadsdk.core.tj.xt xtVar2) {
                            if (jVar.xt() != null && !jVar.xt().isEmpty()) {
                                List<com.bytedance.sdk.openadsdk.core.tj.n> xt = jVar.xt();
                                ArrayList arrayList = new ArrayList(xt.size());
                                for (com.bytedance.sdk.openadsdk.core.tj.n nVar : xt) {
                                    if (nVar.sj()) {
                                        Context context = gq.this.getContext();
                                        AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                                        arrayList.add(new com.bytedance.sdk.openadsdk.core.f.r(context, nVar, i6, xtVar, false));
                                    }
                                }
                                if (!arrayList.isEmpty()) {
                                    com.bytedance.sdk.openadsdk.core.jy.cw.xt(xt.get(0), com.bytedance.sdk.openadsdk.core.rn.uf.xt(xtVar.kt()), currentTimeMillis);
                                    upVar.j(arrayList);
                                    return;
                                } else {
                                    upVar.j(-4, g.j(-4));
                                    xtVar2.j(-4);
                                    com.bytedance.sdk.openadsdk.core.tj.xt.j(xtVar2);
                                    return;
                                }
                            }
                            upVar.j(-3, g.j(-3));
                            xtVar2.j(-3);
                            com.bytedance.sdk.openadsdk.core.tj.xt.j(xtVar2);
                        }
                    });
                } catch (Throwable th) {
                    upVar.j(4000, " msg = " + th.getMessage());
                    com.bytedance.sdk.component.utils.vl.cw("TTAdNativeImpl", "Error msg = ", th.getMessage());
                }
            }
        };
        if (!tj.f30204j) {
            com.bytedance.sdk.component.utils.vl.r("TTAdNativeImpl", "please exec TTAdSdk.init and TTAdSdk.start before load ad");
            upVar.j(10000, "please exec TTAdSdk.init and TTAdSdk.start before load ad");
        } else {
            j(gVar, i6);
            com.bytedance.sdk.openadsdk.core.m.j.cw().j(i6, xtVar.r());
        }
    }

    public void j(PluginValueSet pluginValueSet, Function<SparseArray<Object>, Object> function, int i6) {
        j(com.bytedance.sdk.openadsdk.core.rn.a.j(3, pluginValueSet), new com.bytedance.sdk.openadsdk.core.j.cw(function), i6);
    }

    public void j(final com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, final com.bytedance.sdk.openadsdk.tj.j.xt.j.j jVar, final int i6) {
        if (!com.bytedance.sdk.openadsdk.core.p.g.j()) {
            jVar.j(new com.bytedance.sdk.openadsdk.i.cw.cw(1000, "广告请求开关已关闭,请联系穿山甲管理员"));
            return;
        }
        int g6 = v.xt().g(com.bytedance.sdk.openadsdk.core.rn.uf.xt(xtVar));
        com.bytedance.sdk.component.oq.g gVar = new com.bytedance.sdk.component.oq.g("loadSplashAd b") { // from class: com.bytedance.sdk.openadsdk.core.gq.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    oq.i().ae(1);
                    com.bytedance.sdk.openadsdk.core.component.splash.r.j(gq.this.getContext()).j(xtVar, jVar, i6);
                } catch (Throwable th) {
                    jVar.j(new com.bytedance.sdk.openadsdk.i.cw.cw(4000, " msg = " + th.getMessage()));
                    com.bytedance.sdk.component.utils.vl.cw("TTAdNativeImpl", "splash component maybe not exist, pls check1", th);
                }
            }
        };
        if (!tj.f30204j) {
            com.bytedance.sdk.component.utils.vl.r("TTAdNativeImpl", "please exec TTAdSdk.init and TTAdSdk.start before load ad");
            jVar.j(new com.bytedance.sdk.openadsdk.i.cw.cw(10000, "please exec TTAdSdk.init and TTAdSdk.start before load ad"));
            return;
        }
        if (AdSdkInitializerHolder.isSdkInitSuccess() && (g6 == 4 || com.bytedance.sdk.openadsdk.core.component.splash.r.j(xtVar))) {
            gVar.run();
        } else if (j()) {
            com.bytedance.sdk.component.oq.ae.up(gVar);
        } else {
            com.bytedance.sdk.component.oq.qv.xt.vl().execute(gVar);
        }
        com.bytedance.sdk.openadsdk.core.m.j.cw().j(3, xtVar);
    }

    public void j(final com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, final com.bytedance.sdk.openadsdk.tj.j.xt.j.ae aeVar) {
        if (!com.bytedance.sdk.openadsdk.core.p.g.j()) {
            aeVar.j(1000, "广告请求开关已关闭,请联系穿山甲管理员");
            return;
        }
        com.bytedance.sdk.component.oq.g gVar = new com.bytedance.sdk.component.oq.g("loadRewardVideoAd") { // from class: com.bytedance.sdk.openadsdk.core.gq.7
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.bytedance.sdk.openadsdk.core.component.reward.j.up.j().j(xtVar, new com.bytedance.sdk.openadsdk.core.component.reward.j.cw(aeVar));
                } catch (Throwable th) {
                    aeVar.j(4000, " msg = " + th.getMessage());
                    com.bytedance.sdk.component.utils.vl.cw("TTAdNativeImpl", "reward  component maybe not exist, pls check1", th);
                }
            }
        };
        if (!tj.f30204j) {
            com.bytedance.sdk.component.utils.vl.r("TTAdNativeImpl", "please exec TTAdSdk.init and TTAdSdk.start before load ad");
            aeVar.j(10000, "please exec TTAdSdk.init and TTAdSdk.start before load ad");
        } else {
            j(gVar, 7);
            com.bytedance.sdk.openadsdk.core.m.j.cw().j(7, xtVar);
        }
    }

    public void j(final com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, final com.bytedance.sdk.openadsdk.tj.j.xt.j.r rVar) {
        if (!com.bytedance.sdk.openadsdk.core.p.g.j()) {
            rVar.j(1000, "广告请求开关已关闭,请联系穿山甲管理员");
            return;
        }
        com.bytedance.sdk.component.oq.g gVar = new com.bytedance.sdk.component.oq.g("loadFullScreenVideoAd") { // from class: com.bytedance.sdk.openadsdk.core.gq.8
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.bytedance.sdk.openadsdk.core.component.reward.j.j.j().j(xtVar, new com.bytedance.sdk.openadsdk.core.component.reward.j.cw(rVar));
                } catch (Throwable th) {
                    rVar.j(4000, " msg = " + th.getMessage());
                    com.bytedance.sdk.component.utils.vl.xt("TTAdNativeImpl", "reward component maybe not exist, pls check2", th);
                }
            }
        };
        if (!tj.f30204j) {
            com.bytedance.sdk.component.utils.vl.r("TTAdNativeImpl", "please exec TTAdSdk.init and TTAdSdk.start before load ad");
            rVar.j(10000, "please exec TTAdSdk.init and TTAdSdk.start before load ad");
        } else {
            j(gVar, 8);
            com.bytedance.sdk.openadsdk.core.m.j.cw().j(8, xtVar);
        }
    }

    public void j(final com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, final com.bytedance.sdk.openadsdk.tj.j.xt.j.m mVar) {
        if (!com.bytedance.sdk.openadsdk.core.p.g.j()) {
            mVar.j(1000, "广告请求开关已关闭,请联系穿山甲管理员");
            return;
        }
        com.bytedance.sdk.component.oq.g gVar = new com.bytedance.sdk.component.oq.g("loadNativeExpressAd") { // from class: com.bytedance.sdk.openadsdk.core.gq.9
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (gq.this.j(xtVar, false)) {
                        com.bytedance.sdk.openadsdk.core.nativeexpress.r.j(gq.this.getContext()).j(xtVar, 5, mVar, 5000);
                    } else {
                        mVar.j(110, g.j(110));
                    }
                } catch (Throwable th) {
                    mVar.j(4000, " msg = " + th.getMessage());
                    com.bytedance.sdk.component.utils.vl.cw("TTAdNativeImpl", "Error msg = ", th);
                }
            }
        };
        if (!tj.f30204j) {
            com.bytedance.sdk.component.utils.vl.r("TTAdNativeImpl", "please exec TTAdSdk.init and TTAdSdk.start before load ad");
            mVar.j(10000, "please exec TTAdSdk.init and TTAdSdk.start before load ad");
        } else {
            j(gVar, 5);
            com.bytedance.sdk.openadsdk.core.m.j.cw().j(5, xtVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar) {
        com.bytedance.sdk.component.utils.av.j(xtVar.m() > 0, "必须设置图片素材尺寸");
        com.bytedance.sdk.component.utils.av.j(xtVar.ae() > 0, "必须设置图片素材尺寸");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean j(com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, boolean z5) {
        if (xtVar == null) {
            return false;
        }
        return (z5 && !v.xt().oq(xtVar.r())) || xtVar.tl() > 0.0f;
    }

    private boolean j() {
        return AdSdkInitializerHolder.isSdkInitSuccess();
    }

    private void j(com.bytedance.sdk.component.oq.g gVar, int i6) {
        if (j()) {
            com.bytedance.sdk.component.oq.ae.up(gVar);
        } else {
            com.bytedance.sdk.component.oq.qv.xt.vl().execute(gVar);
        }
    }

    @Override // java.util.function.Function
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            com.bytedance.sdk.component.utils.vl.cw("apply->load with null ->SparseArray");
            return null;
        }
        PluginValueSet k6 = com.bykv.j.j.j.j.e.i(sparseArray).k();
        int intValue = k6.intValue(-99999982);
        Function<SparseArray<Object>, Object> a6 = a1.b.a(k6.objectValue(1, a1.a.a()));
        if (a6 == null) {
            com.bytedance.sdk.component.utils.vl.cw("apply->load with null callback");
            return null;
        }
        j(intValue, k6, a6);
        return null;
    }

    public void j(int i6, PluginValueSet pluginValueSet, Function<SparseArray<Object>, Object> function) {
        com.bykv.j.j.j.j.e j6 = com.bykv.j.j.j.j.e.j(pluginValueSet);
        j6.e(1, 0);
        PluginValueSet k6 = j6.k();
        if (i6 == 1) {
            if (k6.booleanValue(2)) {
                ae(k6, function);
                return;
            } else {
                cw(k6, function);
                return;
            }
        }
        if (i6 != 3) {
            switch (i6) {
                case 5:
                    if (k6.booleanValue(2)) {
                        up(k6, function);
                        break;
                    } else {
                        tl(k6, function);
                        break;
                    }
                case 6:
                    j(k6, function);
                    break;
                case 7:
                    g(k6, function);
                    break;
                case 8:
                    r(k6, function);
                    break;
                case 9:
                    if (k6.booleanValue(2)) {
                        m(k6, function);
                        break;
                    } else {
                        xt(k6, function);
                        break;
                    }
            }
            return;
        }
        j(k6, function, k6.intValue(3));
    }
}
