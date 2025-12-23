package com.kwad.components.ad.reward.presenter.f;

import android.text.TextUtils;
import android.widget.FrameLayout;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.e.j;
import com.kwad.components.ad.reward.e.n;
import com.kwad.components.ad.reward.k.l;
import com.kwad.components.ad.reward.page.BackPressHandleResult;
import com.kwad.components.core.j.a;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.p;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.b;
import com.kwad.components.core.webview.tachikoma.c.u;
import com.kwad.sdk.R;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.t;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class f extends a implements j, a.InterfaceC0621a {
    private List<com.kwad.components.core.j.c> bK;
    private com.kwad.components.core.webview.tachikoma.e nD;
    protected FrameLayout zB;
    private boolean zC = false;
    private final com.kwad.components.core.webview.tachikoma.f.a rP = new com.kwad.components.core.webview.tachikoma.f.a() { // from class: com.kwad.components.ad.reward.presenter.f.f.1
        @Override // com.kwad.components.core.webview.tachikoma.f.a
        public final void kk() {
            if (f.this.nD != null) {
                com.kwad.components.core.webview.tachikoma.c.a aVar = new com.kwad.components.core.webview.tachikoma.c.a();
                aVar.agT = f.this.tm.iH ? 1 : 0;
                f.this.nD.b(aVar);
            }
        }
    };

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void f(AdTemplate adTemplate) {
    }

    private void W(boolean z5) {
        com.kwad.sdk.core.d.c.d("TkRewardPagePresenter", "fullTK: " + z5);
        FrameLayout frameLayout = this.zB;
        if (frameLayout == null) {
            return;
        }
        frameLayout.setVisibility(z5 ? 0 : 8);
    }

    private com.kwad.components.core.webview.tachikoma.c eD() {
        return new com.kwad.components.core.webview.tachikoma.c() { // from class: com.kwad.components.ad.reward.presenter.f.f.6
            @Override // com.kwad.components.core.webview.tachikoma.c, com.kwad.sdk.core.webview.c.a
            public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
                super.a(str, cVar);
                com.kwad.components.core.webview.tachikoma.c.c cVar2 = new com.kwad.components.core.webview.tachikoma.c.c();
                cVar2.agV = com.kwad.components.ad.reward.model.b.dQ();
                cVar.a(cVar2);
            }
        };
    }

    private com.kwad.components.core.webview.tachikoma.e eE() {
        return new com.kwad.components.core.webview.tachikoma.e() { // from class: com.kwad.components.ad.reward.presenter.f.f.5
            @Override // com.kwad.components.core.webview.tachikoma.e, com.kwad.sdk.core.webview.c.a
            public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
                super.a(str, cVar);
                com.kwad.components.core.webview.tachikoma.c.a aVar = new com.kwad.components.core.webview.tachikoma.c.a();
                aVar.agT = f.this.tm.iH ? 1 : 0;
                cVar.a(aVar);
            }
        };
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(@Nullable com.kwad.sdk.core.webview.d.b.a aVar) {
        if (aVar == null || com.kwad.sdk.core.response.b.e.b(this.tm.mAdResultData.getProceedTemplateList(), aVar.creativeId, aVar.adStyle)) {
            this.tm.rD.cW();
            return;
        }
        if (aVar.adTemplate != null && !aVar.aNR) {
            this.tm.rD.cW();
            return;
        }
        com.kwad.components.core.j.c a6 = com.kwad.components.ad.reward.g.a(this.bK, aVar.creativeId);
        if (a6 != null) {
            this.tm.a(a6);
        }
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void dk() {
        FrameLayout frameLayout;
        if (this.zC || (frameLayout = this.zB) == null) {
            return;
        }
        frameLayout.setVisibility(0);
    }

    @IdRes
    protected int du() {
        return R.id.ksad_js_reward_card;
    }

    @Override // com.kwad.components.core.j.a.InterfaceC0621a
    public final void e(@Nullable List<com.kwad.components.core.j.c> list) {
        if (list == null || list.size() == 0 || this.zF == null) {
            return;
        }
        this.bK = list;
        List<AdTemplate> a6 = a(list, this.tm.mAdTemplate);
        com.kwad.sdk.core.webview.b uU = this.zF.uU();
        if (uU != null) {
            uU.setAdTemplateList(a6);
        }
        l ky = this.zF.ky();
        if (ky != null) {
            ky.g(a6);
        } else {
            this.zF.h(a6);
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public FrameLayout getTKContainer() {
        return this.zB;
    }

    public String getTKReaderScene() {
        return "tk_reward";
    }

    public String getTkTemplateId() {
        return com.kwad.sdk.core.response.b.b.dF(this.tm.mAdTemplate);
    }

    public final BackPressHandleResult hx() {
        com.kwad.components.ad.reward.k.a.d dVar = this.zF;
        return dVar == null ? BackPressHandleResult.NOT_HANDLED : dVar.hx();
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        if (!this.zC) {
            W(true);
        }
        com.kwad.components.ad.reward.g gVar = this.tm;
        gVar.rT = true ^ this.zC;
        gVar.a((a.InterfaceC0621a) this);
        com.kwad.components.ad.reward.a.gg().a(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.zB = (FrameLayout) findViewById(du());
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.tm.b((a.InterfaceC0621a) this);
        com.kwad.components.ad.reward.a.gg().b(this);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(TKRenderFailReason tKRenderFailReason) {
        super.a(tKRenderFailReason);
        com.kwad.components.ad.reward.monitor.b.a(this.mAdTemplate, tKRenderFailReason);
        com.kwad.sdk.core.d.c.d("TkRewardPagePresenter", "onTkLoadFailed");
        this.zC = true;
        this.tm.rT = false;
        W(false);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.a, com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(t tVar, com.kwad.sdk.core.webview.b bVar) {
        super.a(tVar, bVar);
        tVar.c(new com.kwad.components.ad.reward.c.f(new com.kwad.components.ad.reward.c.d() { // from class: com.kwad.components.ad.reward.presenter.f.f.2
            @Override // com.kwad.components.ad.reward.c.d
            public final void a(com.kwad.components.ad.reward.c.b bVar2) {
                com.kwad.sdk.core.d.c.d("TkRewardPagePresenter", "onUpdateExtraReward : " + bVar2.hY());
                f.this.a(bVar2);
            }
        }));
        this.nD = eE();
        this.tm.a(this.rP);
        tVar.c(this.nD);
        tVar.c(new com.kwad.components.core.webview.tachikoma.b(new b.a() { // from class: com.kwad.components.ad.reward.presenter.f.f.3
            @Override // com.kwad.components.core.webview.tachikoma.b.a
            public final void eN() {
                com.kwad.components.ad.reward.model.b.L(f.this.tm.mContext);
            }
        }));
        tVar.c(eD());
        tVar.c(new com.kwad.components.core.webview.jshandler.j(new p() { // from class: com.kwad.components.ad.reward.presenter.f.f.4
            @Override // com.kwad.components.core.webview.jshandler.p
            public final void a(com.kwad.components.core.webview.jshandler.j jVar, String str) {
                if (TextUtils.equals(str, "autoCallApp")) {
                    jVar.aW(com.kwad.components.ad.reward.g.g(com.kwad.sdk.core.response.b.e.el(f.this.tm.mAdTemplate)) && com.kwad.sdk.core.local.a.Hr() && f.this.tm.mScreenOrientation == 0);
                }
            }
        }));
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void dl() {
    }

    @Override // com.kwad.components.core.j.a.InterfaceC0621a
    public final void onRequestResult(int i6) {
    }

    private static List<AdTemplate> a(List<com.kwad.components.core.j.c> list, AdTemplate adTemplate) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(adTemplate);
        arrayList.addAll(com.kwad.components.core.j.c.n(list));
        return arrayList;
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void a(PlayableSource playableSource, @Nullable n nVar) {
        FrameLayout frameLayout;
        if (this.zC || (frameLayout = this.zB) == null) {
            return;
        }
        frameLayout.setVisibility(8);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(u uVar) {
        com.kwad.components.ad.reward.e.b bVar;
        com.kwad.sdk.core.d.c.d("TkRewardPagePresenter", "onSkipClick: " + uVar.aci);
        com.kwad.components.ad.reward.g gVar = this.tm;
        if (gVar != null && (bVar = gVar.rD) != null) {
            bVar.onVideoSkipToEnd(uVar.aci * 1000);
        }
        com.kwad.components.ad.reward.presenter.f.u(this.tm);
        com.kwad.components.ad.reward.g.a(this.tm.rL, new com.kwad.sdk.g.a<com.kwad.components.ad.reward.k.a>() { // from class: com.kwad.components.ad.reward.presenter.f.f.7
            @Override // com.kwad.sdk.g.a
            public final /* synthetic */ void accept(com.kwad.components.ad.reward.k.a aVar) {
                c(aVar);
            }

            private static void c(com.kwad.components.ad.reward.k.a aVar) {
                aVar.jV();
            }
        });
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(WebCloseStatus webCloseStatus) {
        super.a(webCloseStatus);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.a, com.kwad.components.core.webview.tachikoma.j
    public final void a(ae.a aVar) {
        float f6;
        float f7;
        float bj = com.kwad.sdk.c.a.a.bj(getContext());
        FrameLayout frameLayout = this.zB;
        if (frameLayout != null) {
            f6 = frameLayout.getHeight();
            f7 = this.zB.getWidth();
        } else {
            f6 = 0.0f;
            f7 = 0.0f;
        }
        if (f6 != 0.0f && f7 != 0.0f) {
            aVar.width = (int) ((f7 / bj) + 0.5f);
            aVar.height = (int) ((f6 / bj) + 0.5f);
        } else {
            super.a(aVar);
        }
    }

    @Override // com.kwad.components.core.j.a.InterfaceC0621a
    public final void onError(int i6, String str) {
    }
}
