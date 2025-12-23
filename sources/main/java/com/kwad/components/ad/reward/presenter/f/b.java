package com.kwad.components.ad.reward.presenter.f;

import android.widget.FrameLayout;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import com.kwad.components.ad.reward.page.BackPressHandleResult;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.x;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.b;
import com.kwad.components.core.webview.tachikoma.c.u;
import com.kwad.components.core.webview.tachikoma.c.y;
import com.kwad.sdk.R;
import com.kwad.sdk.components.t;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class b extends d {
    private FrameLayout zB;
    private boolean zC = false;

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void f(AdTemplate adTemplate) {
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d
    protected final boolean jW() {
        return true;
    }

    private void U(boolean z5) {
        this.zB.setVisibility(z5 ? 0 : 8);
    }

    private com.kwad.components.core.webview.tachikoma.c eD() {
        return new com.kwad.components.core.webview.tachikoma.c() { // from class: com.kwad.components.ad.reward.presenter.f.b.1
            @Override // com.kwad.components.core.webview.tachikoma.c, com.kwad.sdk.core.webview.c.a
            public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
                super.a(str, cVar);
                com.kwad.components.core.webview.tachikoma.c.c cVar2 = new com.kwad.components.core.webview.tachikoma.c.c();
                cVar2.agV = com.kwad.components.ad.reward.model.b.dQ();
                cVar.a(cVar2);
            }
        };
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(t tVar, com.kwad.sdk.core.webview.b bVar) {
        super.a(tVar, bVar);
        tVar.c(eD());
        tVar.c(new com.kwad.components.core.webview.tachikoma.b(new b.a() { // from class: com.kwad.components.ad.reward.presenter.f.b.2
            @Override // com.kwad.components.core.webview.tachikoma.b.a
            public final void eN() {
                com.kwad.components.ad.reward.model.b.L(b.this.tm.mContext);
            }
        }));
        tVar.c(new x() { // from class: com.kwad.components.ad.reward.presenter.f.b.3
            @Override // com.kwad.components.core.webview.jshandler.x
            public final void a(y yVar) {
                super.a(yVar);
                long vE = yVar.vE();
                b.this.tm.rD.onVideoPlayError(yVar.errorCode, (int) vE);
                com.kwad.components.ad.reward.monitor.c.a(b.this.tm.rS, b.this.tm.mAdTemplate, b.this.tm.sr, yVar.errorCode, vE);
                com.kwad.components.ad.reward.monitor.b.c(b.this.tm.rS, b.this.mAdTemplate);
            }

            @Override // com.kwad.components.core.webview.jshandler.x
            public final void b(y yVar) {
                super.b(yVar);
                b.this.tm.rD.onVideoPlayStart();
                com.kwad.components.ad.reward.monitor.c.b(b.this.tm.rS, b.this.tm.mAdTemplate, b.this.tm.mPageEnterTime);
            }

            @Override // com.kwad.components.core.webview.jshandler.x
            public final void c(y yVar) {
                super.c(yVar);
                b.this.tm.rD.onVideoPlayEnd();
                b.this.tm.mAdTemplate.setmCurPlayTime(-1L);
                com.kwad.components.ad.reward.presenter.f.u(b.this.tm);
            }

            @Override // com.kwad.components.core.webview.jshandler.x
            public final void d(y yVar) {
                super.d(yVar);
                b.this.tm.mAdTemplate.setmCurPlayTime(yVar.qz);
            }
        });
    }

    @IdRes
    protected int du() {
        return R.id.ksad_js_reward_card;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public FrameLayout getTKContainer() {
        return this.zB;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public String getTKReaderScene() {
        return "tk_live_video";
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public String getTkTemplateId() {
        return com.kwad.sdk.core.response.b.b.dG(this.tm.mAdTemplate);
    }

    public final BackPressHandleResult hx() {
        com.kwad.components.ad.reward.k.a.d dVar = this.zF;
        return dVar == null ? BackPressHandleResult.NOT_HANDLED : dVar.hx();
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        if (!this.zC) {
            U(true);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.zB = (FrameLayout) findViewById(du());
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(final u uVar) {
        com.kwad.sdk.core.d.c.d("TKLivePresenter", "onSkipClick: " + uVar.aci);
        bw.postOnUiThread(new bg() { // from class: com.kwad.components.ad.reward.presenter.f.b.4
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                if (b.this.tm != null && b.this.tm.rD != null) {
                    b.this.tm.rD.onVideoSkipToEnd(uVar.aci * 1000);
                }
                com.kwad.components.ad.reward.presenter.f.u(b.this.tm);
            }
        });
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(TKRenderFailReason tKRenderFailReason) {
        super.a(tKRenderFailReason);
        com.kwad.components.ad.reward.monitor.b.a(this.mAdTemplate, tKRenderFailReason);
        this.zC = true;
        U(false);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
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
        if (f6 == 0.0f || f7 == 0.0f) {
            f6 = com.kwad.sdk.c.a.a.getScreenHeight(getContext());
            f7 = com.kwad.sdk.c.a.a.getScreenWidth(getContext());
        }
        aVar.width = (int) ((f7 / bj) + 0.5f);
        aVar.height = (int) ((f6 / bj) + 0.5f);
    }
}
