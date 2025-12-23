package com.kwad.components.ad.reward;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.h;
import com.kwad.components.ad.reward.k.s;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.j.a;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.tachikoma.d.e;
import com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.TKAdLiveShopItemInfo;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bv;
import com.kwad.sdk.utils.bw;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class g extends com.kwad.components.core.m.a {

    @Nullable
    public IAdLiveOfflineView dD;
    public boolean iH;
    private Handler iK;
    public boolean jk;
    public AdResultData mAdResultData;

    @NonNull
    public com.kwad.components.ad.reward.e.d mAdRewardStepListener;

    @Nullable
    public com.kwad.components.core.e.d.c mApkDownloadHelper;
    public boolean mCheckExposureResult;
    public long mPageEnterTime;

    @Nullable
    public JSONObject mReportExtData;
    private boolean mRewardVerifyCalled;

    @NonNull
    public AdBaseFrameLayout mRootContainer;
    public int mScreenOrientation;
    public bv mTimerHelper;

    @NonNull
    public KsVideoPlayConfig mVideoPlayConfig;
    public boolean mw;
    public boolean rC;

    @NonNull
    public com.kwad.components.ad.reward.e.b rD;
    public com.kwad.components.ad.reward.m.e rE;

    @Nullable
    public com.kwad.components.core.playable.a rF;

    @NonNull
    public RewardActionBarControl rG;

    @Nullable
    public j rH;

    @Nullable
    public com.kwad.components.ad.l.a rI;

    @Nullable
    public d rJ;
    private final PriorityQueue<com.kwad.components.ad.reward.e.g> rK;
    public final List<com.kwad.components.ad.reward.k.a> rL;
    private final List<s> rM;
    private final List<com.kwad.components.ad.reward.m.c> rN;
    public Set<com.kwad.components.ad.reward.e.e> rO;

    @Nullable
    private com.kwad.components.core.webview.tachikoma.f.a rP;
    private boolean rQ;
    private boolean rR;
    public boolean rS;
    public boolean rT;
    public boolean rU;
    public boolean rV;
    private boolean rW;
    public boolean rX;
    public boolean rY;
    public List<Integer> rZ;
    private List<b> sA;
    private List<a.InterfaceC0621a> sB;
    public int sa;
    public int sb;
    public int sc;
    public boolean sd;

    @Nullable
    public com.kwad.components.ad.reward.n.p se;
    public boolean sf;

    @Nullable
    private PlayableSource sg;
    private boolean sh;
    public long si;
    private List<DialogInterface.OnDismissListener> sj;

    @Nullable
    public com.kwad.components.ad.reward.e.o sk;
    public boolean sl;

    @Nullable
    public com.kwad.components.ad.reward.l.b.a sm;

    @Nullable
    public com.kwad.components.ad.reward.l.a.a sn;
    public int so;
    private int sp;
    public long sq;
    public long sr;
    public boolean ss;
    private boolean st;
    private boolean su;
    public boolean sv;
    public boolean sw;

    @NonNull
    public LoadStrategy sx;
    private RewardRenderResult sy;
    private List<a> sz;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void hd();

        void he();

        void hf();

        void hg();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface b {
        boolean interceptPlayCardResume();
    }

    public final void C(boolean z5) {
        this.sh = true;
    }

    public final void D(boolean z5) {
        this.st = true;
    }

    public final void b(a aVar) {
        this.sz.remove(aVar);
    }

    public final void d(DialogInterface dialogInterface) {
        Iterator<DialogInterface.OnDismissListener> it = this.sj.iterator();
        while (it.hasNext()) {
            it.next().onDismiss(dialogInterface);
        }
    }

    public static boolean g(AdInfo adInfo) {
        return com.kwad.sdk.core.response.b.b.g(adInfo) && !com.kwad.components.ad.reward.a.b.k(adInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gC() {
        Iterator<a> it = this.sz.iterator();
        while (it.hasNext()) {
            it.next().hd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gF() {
        Iterator<a> it = this.sz.iterator();
        while (it.hasNext()) {
            it.next().hg();
        }
    }

    private void gJ() {
        this.rK.clear();
        com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.clear();
        }
        j jVar = this.rH;
        if (jVar != null) {
            jVar.release();
        }
        d dVar = this.rJ;
        if (dVar != null) {
            dVar.release();
        }
        Set<com.kwad.components.ad.reward.e.e> set = this.rO;
        if (set != null) {
            set.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gL() {
        try {
            int size = this.rK.size();
            for (int i6 = 0; i6 < size; i6++) {
                com.kwad.components.ad.reward.e.g poll = this.rK.poll();
                if (poll != null) {
                    poll.cX();
                }
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public final void A(boolean z5) {
        this.rR = z5;
        if (z5) {
            gE();
        } else {
            gD();
        }
    }

    public final void B(boolean z5) {
        this.su = z5;
    }

    public final void D(String str) {
        int i6 = -1;
        try {
            if (com.kwad.sdk.core.config.e.BP()) {
                i6 = com.kwad.components.ad.reward.j.a.a(getActivity());
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
        }
        com.kwad.components.ad.reward.j.b.a(this.mContext, this.mAdTemplate, str, i6, this.mReportExtData);
    }

    public final void E(boolean z5) {
        this.rQ = z5;
    }

    public final void F(final boolean z5) {
        if (z5 != this.mRewardVerifyCalled) {
            a(this.rM, new com.kwad.sdk.g.a<s>() { // from class: com.kwad.components.ad.reward.g.11
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.g.a
                /* renamed from: c, reason: merged with bridge method [inline-methods] */
                public void accept(s sVar) {
                    sVar.ab(z5);
                }
            });
        }
        this.mRewardVerifyCalled = z5;
    }

    public final void Z(int i6) {
        this.sp = i6;
    }

    public final void a(AdResultData adResultData) {
        this.mAdResultData = adResultData;
        this.mAdTemplate = com.kwad.sdk.core.response.b.c.r(adResultData);
    }

    public final void b(b bVar) {
        this.sA.remove(bVar);
    }

    @MainThread
    public final void c(com.kwad.components.ad.reward.e.g gVar) {
        this.rK.remove(gVar);
    }

    public final void gD() {
        if (this.rR || this.rQ || this.st) {
            return;
        }
        Iterator<b> it = this.sA.iterator();
        boolean z5 = false;
        while (it.hasNext()) {
            z5 |= it.next().interceptPlayCardResume();
        }
        if (z5) {
            return;
        }
        Iterator<a> it2 = this.sz.iterator();
        while (it2.hasNext()) {
            it2.next().he();
        }
    }

    public final void gE() {
        Iterator<a> it = this.sz.iterator();
        while (it.hasNext()) {
            it.next().hf();
        }
    }

    public final boolean gG() {
        return this.rR;
    }

    public final void gH() {
        a(this.rN, new com.kwad.sdk.g.a<com.kwad.components.ad.reward.m.c>() { // from class: com.kwad.components.ad.reward.g.5
            @Override // com.kwad.sdk.g.a
            public final /* synthetic */ void accept(com.kwad.components.ad.reward.m.c cVar) {
                c(cVar);
            }

            private static void c(com.kwad.components.ad.reward.m.c cVar) {
                cVar.jB();
            }
        });
    }

    @Nullable
    public final String gI() {
        TKAdLiveShopItemInfo tKAdLiveShopItemInfo = this.mAdTemplate.tkLiveShopItemInfo;
        if (tKAdLiveShopItemInfo == null) {
            return null;
        }
        return tKAdLiveShopItemInfo.itemId;
    }

    public final boolean gM() {
        return this.su;
    }

    public final void gN() {
        com.kwad.components.core.webview.tachikoma.f.a aVar = this.rP;
        if (aVar == null) {
            return;
        }
        aVar.kk();
    }

    public final boolean gO() {
        return this.rW;
    }

    @Nullable
    public final PlayableSource gP() {
        return this.sg;
    }

    public final boolean gQ() {
        return this.sh;
    }

    public final List<a.InterfaceC0621a> gR() {
        return this.sB;
    }

    public final RewardRenderResult gS() {
        return this.sy;
    }

    public final boolean gT() {
        return RewardRenderResult.NEO_TK.equals(this.sy);
    }

    public final boolean gU() {
        return this.st;
    }

    public final boolean gV() {
        return this.rQ;
    }

    public final boolean gW() {
        return this.mRewardVerifyCalled;
    }

    public final void gX() {
        long j6 = this.sr;
        int i6 = j6 != 0 ? (int) (j6 / 1000) : 0;
        AdTemplate adTemplate = this.mAdTemplate;
        com.kwad.sdk.core.adlog.c.i(adTemplate, com.kwad.sdk.core.response.b.a.ae(com.kwad.sdk.core.response.b.e.el(adTemplate)), i6);
    }

    public g(com.kwad.components.core.m.b<?> bVar) {
        super(bVar);
        this.rC = false;
        this.rK = new PriorityQueue<>();
        this.rL = new CopyOnWriteArrayList();
        this.rM = new CopyOnWriteArrayList();
        this.rN = new CopyOnWriteArrayList();
        this.rO = new HashSet();
        this.rQ = false;
        this.rR = false;
        this.rT = false;
        this.rU = false;
        this.rV = false;
        this.rW = false;
        this.rX = false;
        this.mRewardVerifyCalled = false;
        this.rY = false;
        this.rZ = new ArrayList();
        this.mCheckExposureResult = true;
        this.sa = 1;
        this.sb = 1;
        this.sc = 0;
        this.sd = false;
        this.sf = false;
        this.sg = null;
        this.sh = false;
        this.jk = false;
        this.sj = new CopyOnWriteArrayList();
        this.iK = new Handler(Looper.getMainLooper());
        this.sl = false;
        this.sp = 2;
        this.st = false;
        this.su = false;
        this.sv = false;
        this.sw = false;
        this.sx = LoadStrategy.FULL_TK;
        this.sz = new CopyOnWriteArrayList();
        this.sA = new CopyOnWriteArrayList();
        this.sB = new CopyOnWriteArrayList();
        this.Rt.add(new com.kwad.components.core.m.a.a() { // from class: com.kwad.components.ad.reward.g.1
            @Override // com.kwad.components.core.m.a.a
            public final void c(com.kwad.components.core.proxy.f fVar) {
                g.this.gD();
            }

            @Override // com.kwad.components.core.m.a.a
            public final void d(com.kwad.components.core.proxy.f fVar) {
                g.this.gE();
            }

            @Override // com.kwad.components.core.m.a.a
            public final void gY() {
                g.this.gC();
            }

            @Override // com.kwad.components.core.m.a.a
            public final void gZ() {
                g.this.gF();
            }
        });
    }

    public static boolean N(AdTemplate adTemplate) {
        return com.kwad.sdk.core.response.b.e.k(adTemplate, com.kwad.components.ad.reward.a.b.k(com.kwad.sdk.core.response.b.e.el(adTemplate)));
    }

    public static boolean O(AdTemplate adTemplate) {
        return com.kwad.sdk.core.response.b.e.O(adTemplate);
    }

    public static boolean P(AdTemplate adTemplate) {
        if (com.kwad.sdk.core.response.b.a.cX(com.kwad.sdk.core.response.b.e.el(adTemplate))) {
            return false;
        }
        if (!N(adTemplate) && !O(adTemplate)) {
            return false;
        }
        return true;
    }

    private static com.kwad.components.ad.reward.k.a.b c(g gVar) {
        e.b bVar = new e.b();
        bVar.a(gVar.mAdResultData);
        bVar.bg(com.kwad.sdk.core.response.b.b.dO(gVar.mAdTemplate));
        bVar.aZ(false);
        bVar.ba(true);
        return com.kwad.components.ad.reward.k.a.b.a(gVar, bVar);
    }

    private static boolean isMainThread() {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            return true;
        }
        return false;
    }

    public final void b(com.kwad.components.ad.reward.k.a aVar) {
        this.rL.remove(aVar);
    }

    public final void d(@Nullable PlayableSource playableSource) {
        this.sg = playableSource;
    }

    public final void gK() {
        if (isMainThread()) {
            gL();
        } else {
            this.iK.post(new bg() { // from class: com.kwad.components.ad.reward.g.6
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    g.this.gL();
                }
            });
        }
    }

    @Override // com.kwad.components.core.m.a, com.kwad.sdk.mvp.a
    public final void release() {
        gJ();
        com.kwad.components.ad.reward.m.e eVar = this.rE;
        if (eVar != null) {
            eVar.release();
        }
    }

    public final void a(a aVar) {
        this.sz.add(aVar);
    }

    public final void b(s sVar) {
        this.rM.remove(sVar);
    }

    public final void d(final boolean z5, final boolean z6) {
        if (this.rE.kW()) {
            bw.runOnUiThreadDelay(new bg() { // from class: com.kwad.components.ad.reward.g.2
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    com.kwad.components.ad.reward.f.a kX = g.this.rE.kX();
                    if (kX != null) {
                        kX.setAudioEnabled(z5, z6);
                    }
                }
            }, 500L);
        }
    }

    public final void a(b bVar) {
        this.sA.add(bVar);
    }

    public final void b(com.kwad.components.ad.reward.m.c cVar) {
        if (cVar != null) {
            this.rN.remove(cVar);
        }
    }

    private static com.kwad.components.ad.reward.k.a.b d(g gVar) {
        if (com.kwad.sdk.core.response.b.a.cj(com.kwad.sdk.core.response.b.e.el(gVar.mAdTemplate)) == 4 || com.kwad.sdk.core.response.b.a.cj(com.kwad.sdk.core.response.b.e.el(gVar.mAdTemplate)) == 3) {
            return c(gVar);
        }
        return null;
    }

    public final void a(com.kwad.components.ad.reward.k.a aVar) {
        this.rL.add(aVar);
    }

    @MainThread
    public final void b(com.kwad.components.ad.reward.e.g gVar) {
        this.rK.offer(gVar);
    }

    public final void a(s sVar) {
        this.rM.add(sVar);
    }

    public final void b(int i6, Context context, int i7, int i8) {
        a(i6, context, i7, i8, 0L, false, null);
    }

    public final void a(com.kwad.components.ad.reward.m.c cVar) {
        if (cVar != null) {
            this.rN.add(cVar);
        }
    }

    public final void b(DialogInterface.OnDismissListener onDismissListener) {
        this.sj.remove(onDismissListener);
    }

    public static <T> void a(List<T> list, com.kwad.sdk.g.a<T> aVar) {
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                aVar.accept(it.next());
            }
        }
    }

    public final void b(com.kwad.components.ad.reward.c.b bVar) {
        com.kwad.components.ad.reward.c.a.hV().a(this.mAdTemplate, bVar);
    }

    public final void b(final com.kwad.components.core.j.c cVar) {
        final com.kwad.components.core.j.d P = com.kwad.components.ad.reward.e.f.P(this.mAdTemplate.getUniqueId());
        bw.runOnUiThread(new bg() { // from class: com.kwad.components.ad.reward.g.10
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                com.kwad.components.core.j.d dVar = P;
                if (dVar != null) {
                    dVar.d(cVar);
                }
            }
        });
    }

    public final void a(long j6, long j7, int i6) {
        Iterator<com.kwad.components.ad.reward.e.e> it = this.rO.iterator();
        while (it.hasNext()) {
            it.next().dq();
        }
    }

    public final void a(int i6, Context context, int i7, int i8) {
        b(i6, context, i7, i8);
    }

    public final void b(a.InterfaceC0621a interfaceC0621a) {
        List<a.InterfaceC0621a> list = this.sB;
        if (list != null) {
            list.remove(interfaceC0621a);
        }
    }

    public final void a(int i6, Context context, int i7, int i8, long j6) {
        a(1, context, 40, 1, j6, false, null);
    }

    public static boolean b(g gVar) {
        return gVar.rQ;
    }

    public final void a(int i6, Context context, final int i7, int i8, long j6, boolean z5, final com.kwad.sdk.core.adlog.c.b bVar) {
        com.kwad.components.core.e.d.a.a(new a.C0616a(context).aB(this.mAdTemplate).b(this.mApkDownloadHelper).aq(false).aB(i8).A(j6).aA(i7).az(i6).al(gI()).a(new Callable<String>() { // from class: com.kwad.components.ad.reward.g.8
            /* JADX INFO: Access modifiers changed from: private */
            @Override // java.util.concurrent.Callable
            /* renamed from: hb, reason: merged with bridge method [inline-methods] */
            public String call() {
                com.kwad.components.ad.reward.m.e eVar = g.this.rE;
                if (eVar != null) {
                    return eVar.kX().getCurrentShowShopItemInfo().itemId;
                }
                return null;
            }
        }).a(new a.b() { // from class: com.kwad.components.ad.reward.g.7
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                try {
                    g.this.a(i7, bVar);
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(g gVar, h.c cVar, h.a aVar) {
        boolean b6 = b(gVar);
        com.kwad.sdk.core.d.c.d("RewardCallerContext", "showNativeCloseDialog isCloseDialogShowing: " + b6);
        if (b6) {
            return;
        }
        h.a(gVar.getActivity(), gVar.mAdTemplate, cVar, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i6, com.kwad.sdk.core.adlog.c.b bVar) {
        if (bVar == null) {
            bVar = new com.kwad.sdk.core.adlog.c.b();
        }
        bVar.dd(i6);
        bVar.f(this.mRootContainer.getTouchCoords());
        com.kwad.components.ad.reward.j.b.a(this.mAdTemplate, (String) null, (String) null, bVar, this.mReportExtData);
        com.kwad.components.ad.reward.c.a.hV().c(this.mAdTemplate, com.kwad.components.ad.reward.c.b.STATUS_NONE);
        this.rD.cW();
    }

    public final void a(DialogInterface.OnDismissListener onDismissListener) {
        this.sj.add(onDismissListener);
    }

    public final void a(@Nullable com.kwad.components.ad.reward.e.o oVar) {
        this.sk = oVar;
    }

    public final void a(com.kwad.components.core.webview.tachikoma.f.a aVar) {
        this.rP = aVar;
    }

    public final void a(final com.kwad.components.core.j.c cVar) {
        final com.kwad.components.core.j.d P = com.kwad.components.ad.reward.e.f.P(this.mAdTemplate.getUniqueId());
        bw.runOnUiThread(new bg() { // from class: com.kwad.components.ad.reward.g.9
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                com.kwad.components.core.j.d dVar = P;
                if (dVar != null) {
                    dVar.c(cVar);
                }
            }
        });
    }

    public final void a(a.InterfaceC0621a interfaceC0621a) {
        List<a.InterfaceC0621a> list = this.sB;
        if (list != null) {
            list.add(interfaceC0621a);
        }
    }

    @Nullable
    public static com.kwad.components.core.j.c a(List<com.kwad.components.core.j.c> list, long j6) {
        if (j6 >= 0 && list != null) {
            for (com.kwad.components.core.j.c cVar : list) {
                if (com.kwad.sdk.core.response.b.e.ev(cVar.getAdTemplate()) == j6) {
                    return cVar;
                }
            }
        }
        return null;
    }

    public final void a(RewardRenderResult rewardRenderResult) {
        this.sy = rewardRenderResult;
    }

    public static void a(Context context, g gVar, ViewGroup viewGroup) {
        IAdLiveOfflineView iAdLiveOfflineView;
        AdInfo el = com.kwad.sdk.core.response.b.e.el(gVar.mAdTemplate);
        com.kwad.components.core.o.a.b.a aVar = (com.kwad.components.core.o.a.b.a) com.kwad.sdk.components.d.f(com.kwad.components.core.o.a.b.a.class);
        if (aVar != null && aVar.qu() && com.kwad.sdk.core.response.b.a.cR(com.kwad.sdk.core.response.b.e.el(gVar.mAdTemplate))) {
            try {
                iAdLiveOfflineView = com.kwad.components.ad.j.c.a(aVar, context, com.kwad.sdk.core.response.b.a.bf(el) == 8 ? 1 : 0);
            } catch (Throwable unused) {
                iAdLiveOfflineView = null;
            }
            IAdLiveOfflineView iAdLiveOfflineView2 = iAdLiveOfflineView;
            if (iAdLiveOfflineView2 != null) {
                View view = iAdLiveOfflineView2.getView();
                gVar.dD = iAdLiveOfflineView2;
                viewGroup.addView(view);
                gVar.rE.a(2, new com.kwad.components.ad.reward.f.a(gVar.mAdTemplate, aVar.getAdLivePlayModule(iAdLiveOfflineView2, ServiceProvider.getAppId(), String.valueOf(com.kwad.sdk.core.response.b.a.cp(el)), com.kwad.sdk.core.response.b.a.cq(el), com.kwad.sdk.core.response.b.a.cr(el))));
            }
        }
    }

    public static long a(long j6, AdInfo adInfo) {
        return Math.min(com.kwad.sdk.core.response.b.a.ag(adInfo), j6);
    }

    public static void a(g gVar, final h.c cVar, final h.a aVar) {
        if (!gVar.rE.kW()) {
            AdInfo el = com.kwad.sdk.core.response.b.e.el(gVar.mAdTemplate);
            r1 = (com.kwad.components.ad.reward.a.b.j(el) || com.kwad.sdk.core.response.b.a.cj(el) == 2) ? c(gVar) : null;
            if (r1 == null) {
                r1 = d(gVar);
            }
        }
        com.kwad.components.ad.reward.k.a.b bVar = r1;
        if (bVar != null) {
            com.kwad.components.ad.reward.k.a.b.a(bVar, gVar.getActivity(), gVar.rE.getPlayDuration(), aVar, new e.a() { // from class: com.kwad.components.ad.reward.g.12
                @Override // com.kwad.components.core.webview.tachikoma.d.e.a
                public final boolean hc() {
                    g.b(g.this, cVar, aVar);
                    return true;
                }
            });
        } else {
            b(gVar, cVar, aVar);
        }
    }

    public static void a(Activity activity, g gVar) {
        com.kwad.sdk.core.d.c.d("RewardCallerContext", "showExtraDialog");
        com.kwad.components.ad.reward.k.a.b.a(gVar, activity, gVar.rE.getPlayDuration(), new DialogInterface.OnDismissListener() { // from class: com.kwad.components.ad.reward.g.3
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                g.this.d(dialogInterface);
                com.kwad.sdk.core.c.b.Ho();
                Activity currentActivity = com.kwad.sdk.core.c.b.getCurrentActivity();
                if (currentActivity == null || !currentActivity.equals(g.this.getActivity())) {
                    return;
                }
                g.this.rE.resume();
            }
        }, new h.b() { // from class: com.kwad.components.ad.reward.g.4
            @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.core.webview.tachikoma.f.c
            public final void ha() {
                g.this.rE.pause();
            }
        });
    }
}
