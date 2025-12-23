package com.kwad.components.ad.reward.presenter;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.alibaba.fastjson.asm.Opcodes;
import com.kwad.components.ad.reward.h;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class f {
    private static long vC;

    public static void a(final com.kwad.components.ad.reward.g gVar, boolean z5) {
        AdTemplate adTemplate = gVar.mAdTemplate;
        final AdInfo el = com.kwad.sdk.core.response.b.e.el(adTemplate);
        if (!gVar.rS) {
            o(gVar);
            return;
        }
        q(gVar);
        boolean z6 = !gVar.gW() && V(gVar.mAdTemplate);
        if (N(adTemplate) || O(adTemplate) || gVar.sr < com.kwad.sdk.core.response.b.a.ag(el)) {
            if (z6) {
                a(gVar, new h.b() { // from class: com.kwad.components.ad.reward.presenter.f.2
                    @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.core.webview.tachikoma.f.c
                    public final void G(boolean z7) {
                        super.G(z7);
                        if (com.kwad.components.ad.reward.a.b.k(AdInfo.this)) {
                            gVar.iz();
                        } else if (com.kwad.sdk.core.response.b.a.bW(AdInfo.this)) {
                            f.p(gVar);
                        } else {
                            f.r(gVar);
                            com.kwad.components.ad.reward.l.j(gVar);
                        }
                    }
                });
                return;
            } else if (com.kwad.sdk.core.response.b.a.bW(el)) {
                p(gVar);
                return;
            } else {
                r(gVar);
                com.kwad.components.ad.reward.l.j(gVar);
                return;
            }
        }
        if (gVar.sl) {
            gVar.iz();
            return;
        }
        if (!gVar.ss && gVar.sr < com.kwad.sdk.core.response.b.a.ag(el)) {
            if (z5) {
                gVar.iz();
                return;
            }
            return;
        }
        if (gVar.ss) {
            gVar.Z(2);
        } else {
            gVar.Z(1);
        }
        y(gVar);
        if (com.kwad.sdk.core.response.b.a.bW(el)) {
            p(gVar);
        } else {
            r(gVar);
            com.kwad.components.ad.reward.l.j(gVar);
        }
    }

    public static void r(final com.kwad.components.ad.reward.g gVar) {
        gVar.rX = true;
        gVar.gX();
        if (i.z(gVar)) {
            bw.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.f.4
                @Override // java.lang.Runnable
                public final void run() {
                    f.s(com.kwad.components.ad.reward.g.this);
                }
            }, 200L);
        } else {
            s(gVar);
        }
    }

    private static void o(final com.kwad.components.ad.reward.g gVar) {
        if (com.kwad.sdk.core.response.b.a.bV(com.kwad.sdk.core.response.b.e.el(gVar.mAdTemplate))) {
            p(gVar);
            return;
        }
        if (gVar.rU) {
            r(gVar);
            return;
        }
        gVar.rX = true;
        com.kwad.components.ad.reward.g.a(gVar.rL, new com.kwad.sdk.g.a<com.kwad.components.ad.reward.k.a>() { // from class: com.kwad.components.ad.reward.presenter.f.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public void accept(com.kwad.components.ad.reward.k.a aVar) {
                aVar.jV();
            }
        });
        gVar.rD.onVideoSkipToEnd(0L);
        com.kwad.sdk.core.adlog.c.i(gVar.mAdTemplate, gVar.mReportExtData);
        com.kwad.components.ad.reward.m.e eVar = gVar.rE;
        if (eVar != null) {
            eVar.release();
        }
        gVar.gK();
        u(gVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void p(final com.kwad.components.ad.reward.g gVar) {
        bw.runOnUiThread(new bg() { // from class: com.kwad.components.ad.reward.presenter.f.3
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                com.kwad.components.ad.reward.g.this.gX();
                com.kwad.components.ad.reward.g gVar2 = com.kwad.components.ad.reward.g.this;
                gVar2.rD.onVideoSkipToEnd(gVar2.sr);
                com.kwad.components.ad.reward.g.this.release();
                com.kwad.components.ad.reward.g.this.iz();
            }
        });
    }

    private static void q(com.kwad.components.ad.reward.g gVar) {
        long j6 = gVar.sq;
        int i6 = j6 != 0 ? (int) (j6 / 1000) : 0;
        long j7 = gVar.sr;
        com.kwad.sdk.core.adlog.c.e(gVar.mAdTemplate, gVar.mReportExtData, new com.kwad.sdk.core.adlog.c.b().df(69).di(i6).dj(j7 != 0 ? (int) (j7 / 1000) : 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void s(final com.kwad.components.ad.reward.g gVar) {
        com.kwad.components.ad.reward.g.a(gVar.rL, new com.kwad.sdk.g.a<com.kwad.components.ad.reward.k.a>() { // from class: com.kwad.components.ad.reward.presenter.f.5
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public void accept(com.kwad.components.ad.reward.k.a aVar) {
                aVar.jV();
            }
        });
        com.kwad.components.ad.reward.m.e eVar = gVar.rE;
        if (eVar != null) {
            eVar.skipToEnd();
        }
    }

    public static void u(com.kwad.components.ad.reward.g gVar) {
        com.kwad.sdk.core.d.c.d("openAppMarket", "tryOpenAppMarket");
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (elapsedRealtime - vC < 300) {
            com.kwad.sdk.core.d.c.d("openAppMarket", "连续点击");
            return;
        }
        vC = elapsedRealtime;
        AdTemplate adTemplate = gVar.mAdTemplate;
        AdInfo el = com.kwad.sdk.core.response.b.e.el(adTemplate);
        if (a(el, "openAppMarket")) {
            return;
        }
        Context context = gVar.mContext;
        if (a("openAppMarket", adTemplate, el)) {
            return;
        }
        com.kwad.sdk.core.adlog.c.b dp = new com.kwad.sdk.core.adlog.c.b().dd(182).dp(8);
        boolean z5 = com.kwad.sdk.core.download.a.b.F(context, com.kwad.sdk.core.response.b.a.cT(el)) == 1;
        com.kwad.sdk.core.d.c.i("openAppMarket", "handleDeepLink dpSuccess: " + z5);
        if (z5) {
            com.kwad.components.ad.reward.j.b.a(adTemplate, "native_id", "autoLaunchMarket", dp, (JSONObject) null);
            com.kwad.components.ad.reward.h.a.J(context);
            return;
        }
        String cW = com.kwad.sdk.core.response.b.a.cW(el);
        com.kwad.sdk.core.d.c.i("openAppMarket", "tryOpenMiAppStore url：" + cW);
        if (com.kwad.sdk.utils.e.a(context, cW, adTemplate)) {
            com.kwad.components.ad.reward.j.b.a(adTemplate, "native_id", "autoLaunchMarket", dp, (JSONObject) null);
            com.kwad.sdk.core.adlog.c.h(adTemplate, 1, 8);
            com.kwad.components.ad.reward.h.a.J(context);
        } else {
            if (!com.kwad.sdk.utils.e.i(context, adTemplate)) {
                com.kwad.sdk.core.d.c.i("openAppMarket", "tryOpenMiAppStore failed");
                return;
            }
            com.kwad.components.ad.reward.j.b.a(adTemplate, "native_id", "autoLaunchMarket", dp, (JSONObject) null);
            com.kwad.sdk.core.adlog.c.h(adTemplate, 0, 8);
            com.kwad.components.ad.reward.h.a.J(context);
        }
    }

    public static void v(com.kwad.components.ad.reward.g gVar) {
        AdTemplate adTemplate = gVar.mAdTemplate;
        AdInfo el = com.kwad.sdk.core.response.b.e.el(adTemplate);
        if (!gVar.rS) {
            x(gVar);
            gVar.iz();
            return;
        }
        if (!N(adTemplate) && !O(adTemplate)) {
            long ag = com.kwad.sdk.core.response.b.a.ag(el);
            if (gVar.ss || gVar.sr >= ag) {
                y(gVar);
            }
            x(gVar);
            gVar.iz();
            return;
        }
        q(gVar);
        if (!gVar.gW() && V(gVar.mAdTemplate) && !gVar.rX) {
            w(gVar);
        } else {
            x(gVar);
            gVar.iz();
        }
    }

    private static void w(final com.kwad.components.ad.reward.g gVar) {
        final AdTemplate adTemplate = gVar.mAdTemplate;
        com.kwad.components.ad.reward.g.a(gVar, com.kwad.components.ad.reward.h.a(gVar, (String) null), new h.b() { // from class: com.kwad.components.ad.reward.presenter.f.6
            @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.core.webview.tachikoma.f.c
            public final void G(boolean z5) {
                com.kwad.components.ad.reward.g.this.E(false);
                if (!z5) {
                    com.kwad.sdk.core.adlog.c.p(adTemplate, 151);
                }
                f.x(com.kwad.components.ad.reward.g.this);
                com.kwad.components.ad.reward.g.this.iz();
            }

            @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.core.webview.tachikoma.f.c
            public final void ha() {
                com.kwad.components.ad.reward.g.this.E(true);
                com.kwad.sdk.core.adlog.c.b(adTemplate, Opcodes.FCMPL, com.kwad.components.ad.reward.g.this.mReportExtData);
            }

            @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.core.webview.tachikoma.f.c
            public final void hj() {
                com.kwad.components.ad.reward.g.this.E(false);
                com.kwad.sdk.core.adlog.c.p(adTemplate, 150);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void x(com.kwad.components.ad.reward.g gVar) {
        gVar.rD.i(false);
    }

    private static void y(com.kwad.components.ad.reward.g gVar) {
        gVar.rD.onRewardVerify();
    }

    private static boolean N(AdTemplate adTemplate) {
        return com.kwad.sdk.core.response.b.e.k(adTemplate, com.kwad.components.ad.reward.a.b.k(com.kwad.sdk.core.response.b.e.el(adTemplate)));
    }

    private static boolean O(AdTemplate adTemplate) {
        return com.kwad.sdk.core.response.b.e.O(adTemplate);
    }

    private static boolean V(AdTemplate adTemplate) {
        return com.kwad.sdk.core.response.b.a.ak(com.kwad.sdk.core.response.b.e.el(adTemplate));
    }

    public static void t(com.kwad.components.ad.reward.g gVar) {
        x(gVar);
        gVar.iz();
    }

    private static boolean a(String str, AdTemplate adTemplate, AdInfo adInfo) {
        if (com.kwad.sdk.core.response.b.a.bK(adInfo)) {
            com.kwad.sdk.core.d.c.i(str, "is playable return");
            return true;
        }
        if (!com.kwad.sdk.core.response.b.a.aF(adInfo)) {
            com.kwad.sdk.core.d.c.i(str, "is not Download type");
            return true;
        }
        if (com.kwad.sdk.core.response.b.e.k(adTemplate, com.kwad.components.ad.reward.a.b.k(adInfo))) {
            com.kwad.sdk.core.d.c.i(str, "isRewardLaunchAppTask");
            return true;
        }
        if (!com.kwad.components.ad.reward.g.g(adInfo)) {
            return false;
        }
        com.kwad.sdk.core.d.c.i(str, "is Aggregation return");
        return true;
    }

    private static boolean a(AdInfo adInfo, String str) {
        if (!com.kwad.components.ad.reward.a.b.hL()) {
            com.kwad.sdk.core.d.c.e(str, "isEnable false");
            return true;
        }
        if (TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.cW(adInfo))) {
            return true;
        }
        int hK = com.kwad.components.ad.reward.a.b.hK();
        com.kwad.sdk.core.d.c.d(str, "JumpDirectMaxCount " + hK);
        return hK <= 0 || com.kwad.components.ad.reward.h.a.dO() >= hK;
    }

    private static void a(final com.kwad.components.ad.reward.g gVar, @NonNull final h.b bVar) {
        String str;
        final AdTemplate adTemplate = gVar.mAdTemplate;
        AdInfo el = com.kwad.sdk.core.response.b.e.el(adTemplate);
        final JSONObject jSONObject = gVar.mReportExtData;
        long ad = com.kwad.sdk.core.response.b.a.ad(el);
        if (ad > 0 && com.kwad.sdk.core.response.b.a.L(el) > ad) {
            str = "观看视频" + ad + "s即可获取奖励";
        } else {
            str = "观看完整视频即可获取奖励";
        }
        final h.c a6 = com.kwad.components.ad.reward.h.a(gVar, str);
        com.kwad.components.ad.reward.g.a(gVar, a6, new h.b() { // from class: com.kwad.components.ad.reward.presenter.f.7
            @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.core.webview.tachikoma.f.c
            public final void G(boolean z5) {
                com.kwad.components.ad.reward.g.this.E(false);
                if (!z5) {
                    com.kwad.sdk.core.adlog.c.p(adTemplate, 151);
                }
                h.b bVar2 = bVar;
                if (bVar2 != null) {
                    bVar2.G(z5);
                }
            }

            @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.core.webview.tachikoma.f.c
            public final void ha() {
                com.kwad.components.ad.reward.m.e eVar = com.kwad.components.ad.reward.g.this.rE;
                if (eVar != null) {
                    eVar.pause();
                }
                com.kwad.components.ad.reward.g.this.E(true);
                if (a6.getStyle() == 0) {
                    com.kwad.sdk.core.adlog.c.j(adTemplate, jSONObject);
                } else {
                    com.kwad.sdk.core.adlog.c.b(adTemplate, Opcodes.FCMPL, jSONObject);
                }
            }

            @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.core.webview.tachikoma.f.c
            public final void hj() {
                com.kwad.components.ad.reward.g.this.E(false);
                com.kwad.components.ad.reward.m.e eVar = com.kwad.components.ad.reward.g.this.rE;
                if (eVar != null) {
                    eVar.resume();
                }
                if (a6.getStyle() == 1 || a6.getStyle() == 2 || a6.getStyle() == 5 || a6.getStyle() == 8) {
                    com.kwad.sdk.core.adlog.c.p(adTemplate, 150);
                } else {
                    com.kwad.sdk.core.adlog.c.k(adTemplate, jSONObject);
                }
            }

            @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.ad.reward.h.a
            public final void h(int i6, int i7) {
                super.h(i6, i7);
                com.kwad.components.ad.reward.g gVar2 = com.kwad.components.ad.reward.g.this;
                gVar2.a(1, gVar2.mContext, i6, i7);
            }

            @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.ad.reward.h.a
            public final void hh() {
                super.hh();
                com.kwad.sdk.core.adlog.c.p(adTemplate, 150);
                com.kwad.components.ad.reward.g gVar2 = com.kwad.components.ad.reward.g.this;
                gVar2.a(1, gVar2.mContext, 156, 1);
            }

            @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.core.webview.tachikoma.f.c
            public final void hi() {
                super.hi();
                com.kwad.components.ad.reward.g.this.E(false);
            }
        });
    }
}
