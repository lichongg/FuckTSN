package com.kwad.components.ad.c;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.kwad.components.ad.c.b;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsBannerAd;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.mvp.Presenter;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class i extends com.kwad.components.core.m.c<b> {
    private KsAdVideoPlayConfig bJ;
    private List<AdTemplate> bK;
    private KsBannerAd.BannerAdInteractionListener bL;
    private d bM;
    private f ce;
    private Context context;
    private AdInfo mAdInfo;
    private AdResultData mAdResultData;
    private SceneImpl mAdScene;
    private AdTemplate mAdTemplate;

    @Override // com.kwad.components.core.m.c
    public final boolean ai() {
        return true;
    }

    private static Presenter a(Context context, AdTemplate adTemplate) {
        com.kwad.sdk.core.response.b.e.el(adTemplate);
        Presenter presenter = new Presenter();
        if (b.a(adTemplate)) {
            presenter.a(new com.kwad.components.ad.c.d.a(context));
            return presenter;
        }
        presenter.a(new com.kwad.components.ad.c.c.c());
        return presenter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.components.core.m.c
    /* renamed from: aj, reason: merged with bridge method [inline-methods] */
    public b al() {
        f fVar = new f(this.nY, com.kwad.sdk.core.response.b.a.cG(this.mAdInfo));
        this.ce = fVar;
        fVar.wi();
        b bVar = new b();
        bVar.a(this.mAdResultData);
        bVar.a(this.bL);
        bVar.setBannerUpdateAdResultDataListener(this.bM);
        bVar.mAdScene = this.mAdScene;
        bVar.bH = (FrameLayout) findViewById(R.id.ksad_banner_base_content);
        bVar.bN = c(this.mAdTemplate);
        bVar.bK = this.bK;
        bVar.mContext = this.context;
        bVar.bJ = this.bJ;
        bVar.a(new b.a() { // from class: com.kwad.components.ad.c.i.1
            @Override // com.kwad.components.ad.c.b.a
            public final void Z() {
                i.this.mPresenter.a(new com.kwad.components.ad.c.c.c(), true);
            }
        });
        return bVar;
    }

    @Override // com.kwad.components.core.m.c
    public final int getLayoutId() {
        return R.layout.ksad_banner_base;
    }

    @Override // com.kwad.components.core.m.c
    public final void initData() {
        this.mAdInfo = com.kwad.sdk.core.response.b.e.el(this.mAdTemplate);
    }

    public final void setBannerAdListener(KsBannerAd.BannerAdInteractionListener bannerAdInteractionListener) {
        this.bL = bannerAdInteractionListener;
    }

    public final void setBannerUpdateAdResultDataListener(d dVar) {
        this.bM = dVar;
    }

    public i(Context context, AdResultData adResultData, KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        super(context);
        this.context = context;
        this.mAdResultData = adResultData;
        AdTemplate r5 = com.kwad.sdk.core.response.b.c.r(adResultData);
        this.mAdTemplate = r5;
        this.mAdScene = r5.mAdScene;
        this.bK = this.mAdResultData.getAdTemplateList();
        this.bJ = ksAdVideoPlayConfig;
        qs();
    }

    private static StyleTemplate c(AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate k6 = com.kwad.sdk.core.response.b.b.k(adTemplate, com.kwad.sdk.core.response.b.b.dM(adTemplate));
        StyleTemplate styleTemplate = new StyleTemplate();
        if (k6 != null) {
            styleTemplate.templateId = k6.templateId;
            styleTemplate.templateMd5 = k6.templateMd5;
            styleTemplate.templateUrl = k6.templateUrl;
            styleTemplate.templateVersionCode = (int) k6.templateVersionCode;
        }
        return styleTemplate;
    }

    @Override // com.kwad.components.core.m.c
    @NonNull
    public final Presenter onCreatePresenter() {
        return a(getContext(), this.mAdTemplate);
    }

    @Override // com.kwad.components.core.m.c
    public final void ak() {
    }
}
