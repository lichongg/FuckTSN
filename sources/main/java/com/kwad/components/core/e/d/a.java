package com.kwad.components.core.e.d;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.page.AdWebViewVideoActivityProxy;
import com.kwad.components.core.webview.tachikoma.b.k;
import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.track.AdTrackLog;
import com.kwad.sdk.o.m;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aj;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a {
    private static List<WeakReference<k.b>> OT;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.kwad.components.core.e.d.a$a, reason: collision with other inner class name */
    public static class C0616a {
        private boolean OU;
        private boolean OV;
        private boolean OW;
        private boolean OX;
        private boolean OY;
        private boolean OZ;
        private boolean Pa;
        private b Pb;
        private c Pc;
        private boolean Pd;
        private boolean Pe;
        private long Pf;
        private boolean Pg;
        private boolean Ph;
        public String Pj;
        public a.C0675a Pk;
        private JSONObject Pn;
        private boolean Pp;
        private int Pq;
        private int Pr;
        private int Ps;
        private int Pt;
        private Callable<String> Pu;
        private String Pv;
        private AdTemplate adTemplate;
        private final Context context;
        private int mG;
        private int mI;
        public aj.a mK;
        public long yU;
        public int Pi = -1;
        public int Pl = 0;
        public int Pm = -1;
        private boolean Po = false;

        public final C0616a a(@Nullable Callable<String> callable) {
            this.Pu = callable;
            return this;
        }

        public final C0616a aB(AdTemplate adTemplate) {
            this.adTemplate = adTemplate;
            return this;
        }

        public final void am(boolean z5) {
            this.Pe = true;
        }

        public final C0616a ao(boolean z5) {
            this.Pa = true;
            return this;
        }

        public final C0616a ap(boolean z5) {
            this.OY = true;
            return this;
        }

        public final C0616a av(boolean z5) {
            this.OX = true;
            return this;
        }

        public final void ay(int i6) {
            this.Pr = i6;
        }

        public final C0616a A(long j6) {
            this.Pf = j6;
            return this;
        }

        public final C0616a B(long j6) {
            this.yU = j6;
            return this;
        }

        public final C0616a a(b bVar) {
            this.Pb = bVar;
            return this;
        }

        public final C0616a aA(int i6) {
            this.mI = i6;
            return this;
        }

        public final C0616a aB(int i6) {
            this.mG = i6;
            return this;
        }

        public final C0616a aC(int i6) {
            this.Pl = i6;
            return this;
        }

        public final C0616a aD(int i6) {
            this.Pm = i6;
            return this;
        }

        public final C0616a aE(int i6) {
            this.Pq = i6;
            return this;
        }

        public final C0616a aF(int i6) {
            this.Ps = i6;
            return this;
        }

        public final C0616a al(String str) {
            this.Pv = str;
            return this;
        }

        public final C0616a am(String str) {
            this.Pj = str;
            return this;
        }

        public final C0616a an(boolean z5) {
            this.OZ = z5;
            return this;
        }

        public final C0616a aq(boolean z5) {
            this.Pd = z5;
            return this;
        }

        public final C0616a ar(boolean z5) {
            this.Pg = z5;
            return this;
        }

        public final C0616a as(boolean z5) {
            this.Ph = z5;
            return this;
        }

        public final C0616a at(boolean z5) {
            this.Po = z5;
            return this;
        }

        public final C0616a au(boolean z5) {
            this.OV = z5;
            return this;
        }

        public final C0616a aw(boolean z5) {
            this.OU = z5;
            return this;
        }

        public final C0616a ax(boolean z5) {
            this.Pp = z5;
            return this;
        }

        public final C0616a ay(boolean z5) {
            this.OW = true;
            return this;
        }

        public final C0616a az(int i6) {
            this.Pt = i6;
            return this;
        }

        public final C0616a b(c cVar) {
            this.Pc = cVar;
            return this;
        }

        public final C0616a c(JSONObject jSONObject) {
            this.Pn = jSONObject;
            return this;
        }

        public final C0616a d(aj.a aVar) {
            this.mK = aVar;
            return this;
        }

        public final int dW() {
            return this.mG;
        }

        public final int dZ() {
            return this.mI;
        }

        public final AdTemplate getAdTemplate() {
            return this.adTemplate;
        }

        public final Context getContext() {
            return this.context;
        }

        public final c ij() {
            return this.Pc;
        }

        public final JSONObject ix() {
            return this.Pn;
        }

        public final String pd() {
            return this.Pv;
        }

        public final Callable<String> pe() {
            return this.Pu;
        }

        public final boolean pf() {
            return this.Pe;
        }

        public final int pg() {
            return this.Pr;
        }

        public final b ph() {
            return this.Pb;
        }

        public final boolean pi() {
            return this.OY;
        }

        public final int pj() {
            return this.Pt;
        }

        public final boolean pk() {
            return this.OZ;
        }

        public final boolean pl() {
            return this.Pa;
        }

        public final boolean pm() {
            return this.Pd;
        }

        public final long pn() {
            return this.Pf;
        }

        public final boolean po() {
            return this.Pg;
        }

        public final boolean pp() {
            return this.Ph;
        }

        public final boolean pr() {
            return this.Po;
        }

        public final boolean ps() {
            return this.OV;
        }

        public final boolean pt() {
            return this.OX;
        }

        public final boolean pu() {
            return this.OU;
        }

        public final boolean pv() {
            return this.Pp;
        }

        public final int pw() {
            return this.Pq;
        }

        public final int px() {
            return this.Ps;
        }

        public final boolean py() {
            return this.OW;
        }

        public C0616a(Context context) {
            this.context = context;
        }

        public final C0616a a(String str, String str2, com.kwad.sdk.g.a<AdTrackLog> aVar) {
            if (this.Pk == null) {
                this.Pk = new a.C0675a();
            }
            this.Pk.a(this.adTemplate, null, null, null);
            return this;
        }

        public final com.kwad.sdk.core.adlog.c.a pq() {
            return com.kwad.sdk.core.adlog.c.a.EK().cX(this.mI).dr(this.Pj).e(this.mK).cY(this.Pl).cZ(this.Pm).au(this.yU).a(this.Pk).da(this.Pi);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface b {
        void onAdClicked();
    }

    public static int a(@NonNull Context context, @NonNull AdTemplate adTemplate, @NonNull b bVar, @Nullable c cVar, boolean z5, boolean z6, boolean z7, boolean z8) {
        com.kwad.sdk.commercial.d.a.f(adTemplate, true);
        adTemplate.converted = true;
        d.az(false);
        AdInfo el = com.kwad.sdk.core.response.b.e.el(adTemplate);
        com.kwad.sdk.components.d.f(com.kwad.components.a.a.a.class);
        C0616a at = new C0616a(context).aB(adTemplate).a(bVar).b(cVar).aq(z5).ar(z6).an(z8).at(false);
        int an = com.kwad.sdk.core.response.b.a.an(el);
        if (!z7 && at.px() != 2 && at.px() != 1 && !TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.aS(el)) && !at.pt()) {
            if (an == 1) {
                return com.kwad.sdk.core.response.b.a.bi(el) ? k(at) : l(at);
            }
            if (an == 2) {
                int h6 = h(at);
                if (h6 == 1) {
                    return 13;
                }
                if (h6 == 2) {
                    return 16;
                }
                return com.kwad.sdk.core.response.b.a.bi(el) ? k(at) : l(at);
            }
        }
        int h7 = h(at);
        if (h7 == 1) {
            return 13;
        }
        if (h7 == 2) {
            return 16;
        }
        if (!com.kwad.sdk.core.response.b.a.aF(el)) {
            if (j(at)) {
                return 11;
            }
            return l(at);
        }
        int m6 = m(at);
        int i6 = el.status;
        if (i6 != 2 && i6 != 3) {
            e(at);
        }
        return m6;
    }

    private static int b(C0616a c0616a) {
        Context context = c0616a.getContext();
        AdTemplate adTemplate = c0616a.getAdTemplate();
        AdInfo el = com.kwad.sdk.core.response.b.e.el(adTemplate);
        Activity ej = m.ej(context);
        if (ej == null || !com.kwad.sdk.core.response.b.a.V(el) || c0616a.pf() || c0616a.pk()) {
            AdWebViewActivityProxy.launch(context, new AdWebViewActivityProxy.a.C0627a().aA(com.kwad.sdk.core.response.b.b.cN(adTemplate)).aD(adTemplate).aG(true).qW());
            d(adTemplate, 20);
            return 20;
        }
        c0616a.ay(2);
        com.kwad.components.core.e.e.e.a(ej, c0616a);
        d(adTemplate, 19);
        return 19;
    }

    private static int d(C0616a c0616a) {
        AdInfo el = com.kwad.sdk.core.response.b.e.el(c0616a.getAdTemplate());
        if (el.unDownloadConf.unDownloadRegionConf == null) {
            return 0;
        }
        int dW = c0616a.dW();
        return dW != 2 ? dW != 3 ? el.unDownloadConf.unDownloadRegionConf.actionBarType : el.unDownloadConf.unDownloadRegionConf.materialJumpType : el.unDownloadConf.unDownloadRegionConf.describeBarType;
    }

    private static void g(C0616a c0616a) {
        k.b bVar;
        List<WeakReference<k.b>> list = OT;
        if (list == null || list.isEmpty() || c0616a.adTemplate == null) {
            return;
        }
        for (WeakReference<k.b> weakReference : OT) {
            if (weakReference != null && (bVar = weakReference.get()) != null) {
                bVar.S(com.kwad.sdk.core.response.b.e.ev(c0616a.adTemplate));
            }
        }
    }

    private static boolean c(C0616a c0616a) {
        if (com.kwad.sdk.core.response.b.a.aF(com.kwad.sdk.core.response.b.e.el(c0616a.getAdTemplate()))) {
            if (c0616a.pv() || c.A(c0616a) != 3) {
                return false;
            }
            return true;
        }
        if (d(c0616a) != 1) {
            return false;
        }
        return true;
    }

    private static void e(C0616a c0616a) {
        if (c0616a.pf()) {
            return;
        }
        g(c0616a);
        f(c0616a);
        if (c0616a.ph() != null) {
            try {
                c0616a.ph().onAdClicked();
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }
        com.kwad.sdk.commercial.d.a.bo(c0616a.getAdTemplate());
    }

    private static void f(C0616a c0616a) {
        if (c0616a.pp()) {
            com.kwad.sdk.core.adlog.c.a(c0616a.adTemplate, c0616a.pq(), c0616a.ix());
        }
    }

    private static int h(C0616a c0616a) {
        AdTemplate adTemplate = c0616a.getAdTemplate();
        AdInfo el = com.kwad.sdk.core.response.b.e.el(adTemplate);
        int a6 = d.a(c0616a, 1);
        if (a6 == 1) {
            d.az(true);
            e(c0616a);
            if ((com.kwad.sdk.core.response.b.a.cQ(el) || com.kwad.sdk.core.response.b.a.cR(el)) && !c0616a.py()) {
                com.kwad.sdk.core.adlog.c.m(c0616a.getAdTemplate(), (int) Math.ceil(c0616a.pn() / 1000.0f));
            }
            d(adTemplate, 13);
            return a6;
        }
        if (a6 == 2) {
            e(c0616a);
            d(adTemplate, 16);
        }
        return a6;
    }

    private static int i(C0616a c0616a) {
        Context context = c0616a.getContext();
        AdTemplate adTemplate = c0616a.getAdTemplate();
        AdInfo el = com.kwad.sdk.core.response.b.e.el(c0616a.getAdTemplate());
        Activity ej = m.ej(c0616a.getContext());
        if (ej != null && com.kwad.sdk.core.response.b.a.T(el) && !c0616a.pf() && e.E(el) && !c0616a.pk()) {
            c0616a.ay(1);
            com.kwad.components.core.e.e.e.a(ej, c0616a);
            e(c0616a);
            d(adTemplate, 17);
            return 2;
        }
        int e6 = e.e(context, adTemplate);
        if (e6 == 1) {
            e(c0616a);
            d(adTemplate, 12);
        }
        return e6;
    }

    private static boolean j(C0616a c0616a) {
        AdTemplate adTemplate = c0616a.getAdTemplate();
        boolean i6 = com.kwad.sdk.utils.e.i(c0616a.getContext(), adTemplate);
        if (i6) {
            e(c0616a);
            com.kwad.sdk.core.adlog.c.k(adTemplate, 0);
            d(adTemplate, 11);
        }
        return i6;
    }

    private static int k(C0616a c0616a) {
        e(c0616a);
        AdTemplate adTemplate = c0616a.getAdTemplate();
        AdInfo el = com.kwad.sdk.core.response.b.e.el(c0616a.getAdTemplate());
        Activity ej = m.ej(c0616a.getContext());
        if (ej != null && com.kwad.sdk.core.response.b.a.V(el) && !c0616a.pf() && !c0616a.pk()) {
            c0616a.ay(2);
            com.kwad.components.core.e.e.e.a(ej, c0616a);
            d(adTemplate, 19);
            return 19;
        }
        AdWebViewVideoActivityProxy.launch(c0616a.getContext(), adTemplate);
        d(adTemplate, 15);
        return 15;
    }

    private static int l(C0616a c0616a) {
        e(c0616a);
        Context context = c0616a.getContext();
        AdTemplate adTemplate = c0616a.getAdTemplate();
        AdInfo el = com.kwad.sdk.core.response.b.e.el(adTemplate);
        Activity ej = m.ej(context);
        if (ej != null && com.kwad.sdk.core.response.b.a.V(el) && !c0616a.pf() && !c0616a.pk()) {
            c0616a.ay(2);
            com.kwad.components.core.e.e.e.a(ej, c0616a);
            d(adTemplate, 19);
            return 19;
        }
        AdWebViewActivityProxy.launch(context, new AdWebViewActivityProxy.a.C0627a().aA(com.kwad.sdk.core.response.b.b.cN(adTemplate)).aD(adTemplate).aH(c0616a.pi()).aO(1).qW());
        d(adTemplate, 14);
        return 14;
    }

    private static int m(C0616a c0616a) {
        c ij = c0616a.ij();
        if (ij == null) {
            ij = new c(c0616a.adTemplate);
            c0616a.b(ij);
        }
        int r5 = ij.r(c0616a);
        d(c0616a.getAdTemplate(), r5);
        return r5;
    }

    private static int n(C0616a c0616a) {
        AdTemplate adTemplate = c0616a.getAdTemplate();
        AdInfo el = com.kwad.sdk.core.response.b.e.el(adTemplate);
        if (j(c0616a)) {
            return 11;
        }
        if (com.kwad.sdk.core.response.b.a.b(el, com.kwad.sdk.core.config.e.Fn()) && !adTemplate.mAdWebVideoPageShowing) {
            return k(c0616a);
        }
        return l(c0616a);
    }

    private static void d(AdTemplate adTemplate, int i6) {
        switch (i6) {
            case 0:
                com.kwad.sdk.commercial.d.a.bE(adTemplate);
                break;
            case 1:
                com.kwad.sdk.commercial.d.a.bt(adTemplate);
                break;
            case 2:
                com.kwad.sdk.commercial.d.a.bD(adTemplate);
                break;
            case 3:
                com.kwad.sdk.commercial.d.a.bv(adTemplate);
                break;
            case 4:
                com.kwad.sdk.commercial.d.a.bB(adTemplate);
                break;
            case 5:
                com.kwad.sdk.commercial.d.a.bC(adTemplate);
                break;
            case 6:
                com.kwad.sdk.commercial.d.a.bw(adTemplate);
                break;
            case 7:
                com.kwad.sdk.commercial.d.a.bx(adTemplate);
                break;
            case 8:
                com.kwad.sdk.commercial.d.a.by(adTemplate);
                break;
            case 9:
                com.kwad.sdk.commercial.d.a.bA(adTemplate);
                break;
            case 10:
                com.kwad.sdk.commercial.d.a.bz(adTemplate);
                break;
            case 11:
                com.kwad.sdk.commercial.d.a.bs(adTemplate);
                break;
            case 12:
                com.kwad.sdk.commercial.d.a.br(adTemplate);
                break;
            case 13:
                com.kwad.sdk.commercial.d.a.bq(adTemplate);
                break;
            case 14:
                com.kwad.sdk.commercial.d.a.bp(adTemplate);
                break;
            case 15:
                com.kwad.sdk.commercial.d.a.bu(adTemplate);
                break;
            case 16:
                com.kwad.sdk.commercial.d.a.bG(adTemplate);
                break;
            case 17:
                com.kwad.sdk.commercial.d.a.bJ(adTemplate);
                break;
            case 18:
                com.kwad.sdk.commercial.d.a.bF(adTemplate);
                break;
            case 19:
                com.kwad.sdk.commercial.d.a.bH(adTemplate);
                break;
            case 20:
                com.kwad.sdk.commercial.d.a.bI(adTemplate);
                break;
        }
    }

    public static void b(k.b bVar) {
        if (OT == null) {
            return;
        }
        int i6 = 0;
        while (true) {
            if (i6 >= OT.size()) {
                i6 = -1;
                break;
            }
            WeakReference<k.b> weakReference = OT.get(i6);
            if (weakReference != null && weakReference.get() != null && bVar == weakReference.get()) {
                break;
            } else {
                i6++;
            }
        }
        if (i6 != -1) {
            OT.remove(i6);
        }
    }

    public static int a(C0616a c0616a) {
        Context context = c0616a.getContext();
        AdTemplate adTemplate = c0616a.getAdTemplate();
        AdInfo el = com.kwad.sdk.core.response.b.e.el(adTemplate);
        d.az(false);
        if (c0616a.pl()) {
            return b(c0616a);
        }
        if (c0616a.pu()) {
            return a(context, adTemplate, c0616a.ph(), c0616a.ij(), c0616a.Pd, c0616a.po(), false, c0616a.pk());
        }
        com.kwad.sdk.commercial.d.a.f(adTemplate, false);
        if (c(c0616a)) {
            d(adTemplate, 1);
            return 1;
        }
        adTemplate.converted = true;
        com.kwad.sdk.components.d.f(com.kwad.components.a.a.a.class);
        int an = com.kwad.sdk.core.response.b.a.an(el);
        if (c0616a.px() != 2 && c0616a.px() != 1 && !TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.aS(el)) && !c0616a.pt()) {
            if (an == 1) {
                if (com.kwad.sdk.core.response.b.a.bi(el)) {
                    return k(c0616a);
                }
                return l(c0616a);
            }
            if (an == 2) {
                int h6 = h(c0616a);
                if (h6 == 1) {
                    return 13;
                }
                if (h6 == 2) {
                    return 16;
                }
                if (com.kwad.sdk.core.response.b.a.bi(el)) {
                    return k(c0616a);
                }
                return l(c0616a);
            }
        }
        int h7 = h(c0616a);
        if (h7 == 1) {
            return 13;
        }
        if (h7 == 2) {
            return 16;
        }
        int i6 = i(c0616a);
        if (i6 == 1) {
            return 12;
        }
        if (i6 == 2) {
            return 17;
        }
        if (c0616a.ps() && !com.kwad.sdk.core.response.b.a.aF(el)) {
            return n(c0616a);
        }
        if (!com.kwad.sdk.core.response.b.a.aF(el)) {
            if (adTemplate.isWebViewDownload) {
                int m6 = m(c0616a);
                adTemplate.isWebViewDownload = false;
                return m6;
            }
            if (j(c0616a)) {
                return 11;
            }
            return l(c0616a);
        }
        if (c0616a.px() != 2 && c0616a.px() != 1) {
            if (c0616a.ps() && com.kwad.sdk.core.response.b.a.b(el, com.kwad.sdk.core.config.e.Fn()) && !TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.aS(el)) && !AdWebViewVideoActivityProxy.showingAdWebViewVideoActivity) {
                int q5 = c0616a.ij().q(c0616a);
                if (q5 == 0) {
                    return k(c0616a);
                }
                e(c0616a);
                d(adTemplate, q5);
                return q5;
            }
            e(c0616a);
            c0616a.at(true);
            return m(c0616a);
        }
        c0616a.at(false);
        e(c0616a);
        return m(c0616a);
    }

    public static void a(k.b bVar) {
        if (OT == null) {
            OT = new CopyOnWriteArrayList();
        }
        OT.add(new WeakReference<>(bVar));
    }
}
