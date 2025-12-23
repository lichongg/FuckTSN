package com.kwad.components.ad.interstitial.h;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.interstitial.f.c;
import com.kwad.components.ad.interstitial.f.f;
import com.kwad.components.ad.interstitial.h.d;
import com.kwad.components.core.webview.tachikoma.f.g;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.o.m;
import com.kwad.sdk.utils.aq;
import com.kwad.sdk.widget.KSFrameLayout;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class c extends a {
    private KsAdVideoPlayConfig bU;
    protected KsInterstitialAd.AdInteractionListener kQ;
    private com.kwad.components.ad.interstitial.d kW;
    protected AdInfo mAdInfo;

    @NonNull
    protected AdResultData mAdResultData;

    @NonNull
    protected AdTemplate mAdTemplate;
    protected com.kwad.components.ad.interstitial.f.c mj;
    private boolean mn;
    private c.a mo;
    private g mq;
    private int mx;

    @Nullable
    protected com.kwad.components.ad.interstitial.f.b nW;
    private boolean nX;
    protected ViewGroup nY;

    public c(@NonNull Context context) {
        this(context, null);
    }

    static /* synthetic */ boolean a(c cVar, boolean z5) {
        cVar.nX = false;
        return false;
    }

    private c(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, null);
        this.mx = -1;
        this.mq = new g() { // from class: com.kwad.components.ad.interstitial.h.c.1
            @Override // com.kwad.components.core.webview.tachikoma.f.g
            public final void a(String str, long j6, long j7, long j8) {
                c.this.mj.mw = true;
            }

            @Override // com.kwad.components.core.webview.tachikoma.f.b
            public final void v(String str) {
                if ("tk_interstitial".equals(str)) {
                    c.a(c.this, false);
                    com.kwad.components.ad.interstitial.f.b bVar = c.this.nW;
                    if (bVar != null) {
                        bVar.ny();
                    }
                    c cVar = c.this;
                    cVar.nW = cVar.eZ();
                    c cVar2 = c.this;
                    cVar2.nW.K(cVar2.nY);
                    c cVar3 = c.this;
                    cVar3.nW.n(cVar3.mj);
                }
            }
        };
        this.nY = (ViewGroup) m.inflate(context, getLayoutId(), this);
    }

    private d a(Context context, AdInfo adInfo, com.kwad.components.ad.interstitial.f.c cVar) {
        boolean a6 = com.kwad.components.ad.interstitial.f.c.a(this.mContext, adInfo);
        d.a aVar = new d.a();
        aVar.w(a6);
        aVar.x(!cVar.M(context) && com.kwad.components.ad.interstitial.b.b.dI());
        aVar.R(com.kwad.components.ad.interstitial.b.b.dJ());
        aVar.y((com.kwad.sdk.core.response.b.a.aW(adInfo) && aq.QW()) ? false : true);
        return new d(context, aVar);
    }

    private com.kwad.components.ad.interstitial.f.c eY() {
        com.kwad.components.ad.interstitial.f.c cVar = new com.kwad.components.ad.interstitial.f.c();
        cVar.a(this.mAdResultData);
        cVar.setAdTemplate(this.mAdTemplate);
        cVar.kQ = this.kQ;
        cVar.kW = this.kW;
        cVar.mApkDownloadHelper = new com.kwad.components.core.e.d.c(this.mAdTemplate);
        cVar.bU = this.bU;
        cVar.cq = new com.kwad.sdk.core.video.videoview.a(this.mContext);
        KSFrameLayout kSFrameLayout = (KSFrameLayout) this.nY.findViewById(R.id.ksad_container);
        cVar.fV = kSFrameLayout;
        com.kwad.components.ad.interstitial.g.b bVar = new com.kwad.components.ad.interstitial.g.b(kSFrameLayout, com.kwad.sdk.core.config.e.Fb());
        cVar.kO = bVar;
        bVar.wi();
        cVar.mx = this.mx;
        cVar.mn = this.mn;
        cVar.mo = this.mo;
        cVar.mq = this.mq;
        cVar.mk = a(this.mContext, com.kwad.sdk.core.response.b.e.el(this.mAdTemplate), cVar);
        return cVar;
    }

    @Override // com.kwad.components.ad.interstitial.h.a
    public final void dA() {
        com.kwad.components.ad.interstitial.f.b bVar = this.nW;
        if (bVar != null) {
            bVar.dR();
        }
    }

    @Override // com.kwad.components.ad.interstitial.h.a
    public final void dB() {
        com.kwad.components.ad.interstitial.f.b bVar = this.nW;
        if (bVar != null) {
            bVar.dS();
        }
    }

    @NonNull
    public final com.kwad.components.ad.interstitial.f.b eZ() {
        com.kwad.components.ad.interstitial.f.b bVar = new com.kwad.components.ad.interstitial.f.b();
        if (this.nX) {
            bVar.a(new com.kwad.components.ad.interstitial.f.a.b());
            return bVar;
        }
        if (com.kwad.sdk.core.response.b.a.bc(this.mAdInfo)) {
            bVar.a(new f());
        }
        bVar.a(new com.kwad.components.ad.interstitial.f.g());
        bVar.a(new com.kwad.components.ad.interstitial.f.d());
        if (com.kwad.sdk.core.response.b.a.aP(this.mAdInfo)) {
            bVar.a(new com.kwad.components.ad.interstitial.f.a());
        }
        if (this.mj.M(getContext())) {
            bVar.a(new com.kwad.components.ad.interstitial.f.e());
        }
        return bVar;
    }

    public final void fa() {
        com.kwad.components.ad.interstitial.f.c cVar = this.mj;
        if (cVar == null || !cVar.mv) {
            return;
        }
        cVar.dT();
    }

    public final void fb() {
        com.kwad.components.ad.interstitial.f.c cVar = this.mj;
        if (cVar != null) {
            if (this.nX || cVar.mv) {
                cVar.dU();
            }
        }
    }

    public final void fc() {
        if (this.mj != null) {
            this.mj.a(new c.C0567c(this.mContext).l(true).M(1).n(true).L(2));
        }
    }

    public final boolean fd() {
        com.kwad.components.ad.interstitial.f.c cVar = this.mj;
        if (cVar != null) {
            return cVar.mw;
        }
        return false;
    }

    protected final int getLayoutId() {
        return R.layout.ksad_interstitial;
    }

    public final void setAdAggregateClickActionListener(c.a aVar) {
        this.mo = aVar;
        com.kwad.components.ad.interstitial.f.c cVar = this.mj;
        if (cVar != null) {
            cVar.mo = aVar;
        }
    }

    @Override // com.kwad.components.ad.interstitial.h.a
    public final void setAdInteractionListener(KsInterstitialAd.AdInteractionListener adInteractionListener) {
        this.kQ = adInteractionListener;
        com.kwad.components.ad.interstitial.f.c cVar = this.mj;
        if (cVar != null) {
            cVar.kQ = adInteractionListener;
        }
    }

    public final void setAggregateAdView(boolean z5) {
        this.mn = z5;
        com.kwad.components.ad.interstitial.f.c cVar = this.mj;
        if (cVar != null) {
            cVar.mn = z5;
        }
    }

    public final void setAggregateShowTriggerType(int i6) {
        this.mx = i6;
        com.kwad.components.ad.interstitial.f.c cVar = this.mj;
        if (cVar != null) {
            cVar.mx = i6;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.kwad.components.ad.interstitial.f.c cVar = this.mj;
        if (cVar != null) {
            cVar.release();
        }
        com.kwad.components.ad.interstitial.f.b bVar = this.nW;
        if (bVar != null) {
            bVar.destroy();
        }
    }

    @Override // com.kwad.components.ad.interstitial.h.a
    public final void a(@NonNull AdResultData adResultData, com.kwad.components.ad.interstitial.d dVar, @NonNull KsAdVideoPlayConfig ksAdVideoPlayConfig, KsInterstitialAd.AdInteractionListener adInteractionListener, int i6) {
        List<AdTemplate> adTemplateList = adResultData.getAdTemplateList();
        if (adTemplateList != null && i6 < adTemplateList.size()) {
            this.mAdTemplate = adTemplateList.get(i6);
        } else {
            this.mAdTemplate = com.kwad.sdk.core.response.b.c.r(adResultData);
        }
        this.mAdResultData = com.kwad.sdk.core.response.b.c.a(adResultData, this.mAdTemplate);
        this.mAdInfo = com.kwad.sdk.core.response.b.e.el(this.mAdTemplate);
        AdTemplate adTemplate = this.mAdTemplate;
        adTemplate.realShowType = 2;
        this.bU = ksAdVideoPlayConfig;
        this.kW = dVar;
        this.nX = com.kwad.sdk.core.response.b.b.di(adTemplate);
        this.kQ = adInteractionListener;
        this.mj = eY();
        if (this.nW == null) {
            this.nW = eZ();
        }
        this.nW.K(this.nY);
        this.nW.n(this.mj);
    }
}
