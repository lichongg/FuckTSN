package com.kwad.components.ad.reward;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.page.BackPressHandleResult;
import com.kwad.components.ad.reward.presenter.r;
import com.kwad.components.ad.reward.presenter.t;
import com.kwad.components.ad.reward.presenter.u;
import com.kwad.components.ad.reward.presenter.v;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdGlobalConfigInfo;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.aq;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class n extends com.kwad.components.ad.reward.presenter.b implements com.kwad.components.ad.reward.e.g, com.kwad.components.core.e.e.f {
    private ViewGroup jI;
    private com.kwad.components.core.m.b jJ;

    @Nullable
    private r jK;
    private FrameLayout jL;
    private com.kwad.components.ad.reward.presenter.f.b jM;

    @Nullable
    private com.kwad.components.ad.reward.presenter.e.a jO;
    private com.kwad.components.ad.reward.presenter.f.f jP;
    private Context mContext;
    private com.kwad.components.ad.reward.model.c mModel;
    private g tm;

    @Nullable
    private a tn;
    private boolean jQ = false;
    private com.kwad.components.core.webview.tachikoma.f.g mq = new com.kwad.components.core.webview.tachikoma.f.g() { // from class: com.kwad.components.ad.reward.n.1
        @Override // com.kwad.components.core.webview.tachikoma.f.g
        public final void a(String str, long j6, long j7, long j8) {
            n.this.tm.mw = true;
        }

        @Override // com.kwad.components.core.webview.tachikoma.f.b
        public final void v(String str) {
            if ("tk_reward".equals(str) || "tk_live_video".equals(str)) {
                n nVar = n.this;
                nVar.a(nVar);
                g.a(n.this.getContext(), n.this.tm, n.this.di());
                n.this.tm.a(RewardRenderResult.DEFAULT);
                n nVar2 = n.this;
                nVar2.a(nVar2.jJ, n.this.mModel);
                return;
            }
            if ("tk_image_video".equals(str)) {
                n nVar3 = n.this;
                nVar3.a(nVar3);
                n.this.tm.a(RewardRenderResult.DEFAULT);
                n nVar4 = n.this;
                nVar4.a(nVar4.jJ, n.this.mModel);
            }
        }
    };

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void onUnbind();
    }

    @Override // com.kwad.components.ad.reward.e.g
    public final int getPriority() {
        return 0;
    }

    private void dd() {
        com.kwad.components.ad.reward.presenter.f.b bVar = new com.kwad.components.ad.reward.presenter.f.b();
        this.jM = bVar;
        a(bVar);
    }

    private void de() {
        com.kwad.components.ad.reward.presenter.f.c cVar = new com.kwad.components.ad.reward.presenter.f.c();
        this.jP = cVar;
        a(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrameLayout di() {
        if (this.jL == null) {
            this.jL = (FrameLayout) this.jI.findViewById(R.id.ksad_reward_play_layout);
        }
        return this.jL;
    }

    private void hw() {
        com.kwad.components.ad.reward.presenter.f.f fVar = new com.kwad.components.ad.reward.presenter.f.f();
        this.jP = fVar;
        a(fVar);
    }

    @Override // com.kwad.components.ad.reward.e.g
    public final void cX() {
        this.tm.D(true);
    }

    @Override // com.kwad.components.core.e.e.f
    public final void dismiss() {
        this.tm.E(false);
        this.tm.gD();
    }

    public final BackPressHandleResult hx() {
        r rVar = this.jK;
        if (rVar != null && rVar.onBackPressed()) {
            return BackPressHandleResult.HANDLED;
        }
        com.kwad.components.ad.reward.presenter.e.a aVar = this.jO;
        if (aVar != null) {
            BackPressHandleResult hx = aVar.hx();
            BackPressHandleResult backPressHandleResult = BackPressHandleResult.HANDLED;
            if (hx == backPressHandleResult) {
                return backPressHandleResult;
            }
        }
        com.kwad.components.ad.reward.presenter.f.b bVar = this.jM;
        if (bVar != null) {
            return bVar.hx();
        }
        com.kwad.components.ad.reward.presenter.f.f fVar = this.jP;
        return fVar != null ? fVar.hx() : BackPressHandleResult.NOT_HANDLED;
    }

    @Override // com.kwad.components.core.e.e.f
    public final void show() {
        this.tm.gE();
        this.tm.E(true);
    }

    public n(com.kwad.components.core.m.b bVar, Context context, ViewGroup viewGroup, com.kwad.components.ad.reward.model.c cVar, g gVar) {
        boolean z5;
        boolean z6 = false;
        this.mContext = context;
        this.jI = viewGroup;
        this.mModel = cVar;
        this.tm = gVar;
        this.jJ = bVar;
        a(cVar);
        AdInfo cU = cVar.cU();
        boolean eq = com.kwad.sdk.core.response.b.b.eq(cU);
        if ((!com.kwad.sdk.core.response.b.a.cR(cU) || !a(this.tm.mAdResultData.adGlobalConfigInfo)) && !com.kwad.sdk.core.response.b.a.bd(cU) && !g.P(cVar.getAdTemplate())) {
            z5 = false;
        } else {
            z5 = true;
        }
        if (com.kwad.sdk.core.response.b.a.dc(cU) && a(this.tm.mAdResultData.adGlobalConfigInfo)) {
            z6 = true;
        }
        com.kwad.sdk.core.d.c.d("RewardPresenter", "notFullTk: " + z5 + ", mLoadStrategy: " + this.tm.sx);
        if (z6) {
            com.kwad.components.core.webview.tachikoma.e.c.vO().a(this.mq);
            gVar.a(RewardRenderResult.LIVE_TK);
            dd();
        } else if (eq) {
            com.kwad.components.core.webview.tachikoma.e.c.vO().a(this.mq);
            gVar.a(RewardRenderResult.TK_IMAGE);
            de();
        } else if (!z5 && this.tm.sx.equals(LoadStrategy.FULL_TK)) {
            com.kwad.components.core.webview.tachikoma.e.c.vO().a(this.mq);
            gVar.a(RewardRenderResult.NEO_TK);
            hw();
        } else {
            gVar.a(RewardRenderResult.DEFAULT);
            a(bVar, cVar);
        }
    }

    private static boolean a(AdGlobalConfigInfo adGlobalConfigInfo) {
        return adGlobalConfigInfo == null || adGlobalConfigInfo.neoPageType != 1;
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        this.tm.b(this);
        com.kwad.components.ad.reward.c.a.hV().setCallerContext(this.tm);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.jL = (FrameLayout) this.jI.findViewById(R.id.ksad_reward_play_layout);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
        this.jJ = null;
        com.kwad.components.core.webview.tachikoma.e.c.vO().b(this.mq);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.tm.c(this);
        a aVar = this.tn;
        if (aVar != null) {
            aVar.onUnbind();
        }
        com.kwad.components.core.e.e.g.pY().b(this);
        com.kwad.components.ad.reward.c.a.hV().reset();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(n nVar) {
        if (this.jQ) {
            return;
        }
        nVar.a((Presenter) new com.kwad.components.ad.reward.presenter.a(this.tm), true);
        this.jQ = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.kwad.components.core.m.b bVar, com.kwad.components.ad.reward.model.c cVar) {
        if (this.mModel == null) {
            return;
        }
        com.kwad.components.core.e.e.g.pY().a(this);
        AdInfo cU = this.mModel.cU();
        AdTemplate adTemplate = this.mModel.getAdTemplate();
        if (cVar.jk) {
            a(this);
        }
        a(new v(), true);
        if (com.kwad.sdk.core.response.b.a.aP(cU)) {
            a(new com.kwad.components.ad.reward.presenter.d(), true);
        }
        a(new com.kwad.components.ad.reward.presenter.m(), true);
        a(new com.kwad.components.ad.reward.presenter.h(), true);
        a(new com.kwad.components.ad.reward.presenter.platdetail.c(), true);
        a(new com.kwad.components.ad.reward.presenter.platdetail.a.e(), true);
        boolean is = cVar.is();
        boolean it = cVar.it();
        boolean z5 = cVar.cV() && !aq.isOrientationPortrait();
        if (!is && !it && !z5) {
            a(new com.kwad.components.ad.reward.presenter.platdetail.actionbar.c(), true);
        }
        a(new com.kwad.components.ad.reward.presenter.n(), true);
        a(new com.kwad.components.ad.reward.presenter.c(cU), true);
        a(new com.kwad.components.ad.reward.presenter.d.b(adTemplate, true), true);
        a(new com.kwad.components.ad.reward.presenter.c.a(), true);
        a(new u(), true);
        a(new com.kwad.components.ad.reward.presenter.e(cU, this.jI), true);
        r rVar = new r(adTemplate);
        this.jK = rVar;
        a((Presenter) rVar, true);
        a(new com.kwad.components.ad.reward.presenter.l(), true);
        g gVar = this.tm;
        if (gVar.rS && com.kwad.components.ad.reward.d.a.b(gVar.mContext, com.kwad.sdk.core.response.b.e.el(adTemplate))) {
            a(new com.kwad.components.ad.reward.presenter.a.a(), true);
        }
        if (com.kwad.sdk.core.response.b.b.dA(adTemplate)) {
            a(new t(), true);
        }
        if (com.kwad.sdk.core.response.b.a.bd(cU)) {
            a(new com.kwad.components.ad.reward.presenter.platdetail.b(), true);
        }
        if (com.kwad.sdk.core.response.b.a.cR(cU)) {
            a(new com.kwad.components.ad.reward.presenter.b.c(), true);
            a(new com.kwad.components.ad.reward.presenter.b.a(), true);
            a(new com.kwad.components.ad.reward.presenter.b.b(), true);
            a(new com.kwad.components.ad.reward.presenter.k(), true);
        }
        a(new com.kwad.components.ad.reward.presenter.j(), true);
    }

    private void a(com.kwad.components.ad.reward.model.c cVar) {
        AdInfo cU = cVar.cU();
        if (!cVar.jk) {
            a(this);
        }
        if (g.g(cU)) {
            a(new com.kwad.components.ad.reward.presenter.g());
        }
        if (com.kwad.sdk.core.response.b.a.aO(cU) && aq.QW()) {
            a(new com.kwad.components.ad.reward.presenter.h.a());
        }
        if (com.kwad.sdk.core.response.b.b.dA(cU)) {
            a(new com.kwad.components.ad.reward.presenter.f.h());
        }
        if (com.kwad.sdk.core.response.b.b.en(cU) && aq.isOrientationPortrait()) {
            com.kwad.components.ad.reward.presenter.e.a aVar = new com.kwad.components.ad.reward.presenter.e.a();
            this.jO = aVar;
            a(aVar);
        }
    }

    public final void a(@Nullable a aVar) {
        this.tn = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(com.kwad.components.ad.reward.e.g gVar) {
        return getPriority() - gVar.getPriority();
    }
}
