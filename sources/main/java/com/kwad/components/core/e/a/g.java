package com.kwad.components.core.e.a;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.widget.KSFrameLayout;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SuppressLint({"ViewConstructor"})
/* loaded from: D:\Downloads\app\classes6.dex */
public final class g extends KSFrameLayout {
    private final d Ol;
    private a Ou;
    private final d Ow;
    private final com.kwad.components.core.widget.a.b fg;
    private final AdTemplate mAdTemplate;
    private Presenter mPresenter;
    private boolean qU;

    /* JADX INFO: Access modifiers changed from: private */
    public void eL() {
        if (this.qU) {
            return;
        }
        this.qU = true;
        this.Ol.oJ();
    }

    private a oQ() {
        a aVar = new a();
        aVar.Oj = this;
        aVar.mAdTemplate = this.mAdTemplate;
        aVar.Ok = this.fg;
        aVar.Ol = this.Ow;
        return aVar;
    }

    private static Presenter onCreatePresenter() {
        Presenter presenter = new Presenter();
        presenter.a(new f());
        return presenter;
    }

    public g(@NonNull Context context, AdTemplate adTemplate, d dVar) {
        super(context);
        this.Ow = new d() { // from class: com.kwad.components.core.e.a.g.1
            @Override // com.kwad.components.core.e.a.d
            public final void oJ() {
                g.this.eL();
            }
        };
        this.mAdTemplate = adTemplate;
        this.Ol = dVar;
        this.fg = new com.kwad.components.core.widget.a.b(this, 70);
        initMVP();
    }

    private void initMVP() {
        this.Ou = oQ();
        Presenter onCreatePresenter = onCreatePresenter();
        this.mPresenter = onCreatePresenter;
        onCreatePresenter.K(this);
        this.mPresenter.n(this.Ou);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void aa() {
        super.aa();
        com.kwad.sdk.core.d.c.d("InstalledActivateView", "onViewAttached");
        this.fg.wi();
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void ab() {
        super.ab();
        com.kwad.sdk.core.d.c.d("InstalledActivateView", "onViewDetached");
        this.fg.release();
        this.mPresenter.destroy();
        this.Ou.release();
        eL();
    }
}
