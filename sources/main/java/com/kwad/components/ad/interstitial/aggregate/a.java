package com.kwad.components.ad.interstitial.aggregate;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import com.kwad.components.ad.interstitial.d;
import com.kwad.components.ad.interstitial.f.c;
import com.kwad.components.ad.interstitial.h.c;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a extends PagerAdapter {
    private final KsAdVideoPlayConfig bU;
    private final KsInterstitialAd.AdInteractionListener kQ;
    private final d kW;
    private final boolean kX;
    private b kY;
    private InterfaceC0563a kZ;
    private AdResultData mAdResultData;
    private final List<AdTemplate> mAdTemplateList = new ArrayList();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.kwad.components.ad.interstitial.aggregate.a$a, reason: collision with other inner class name */
    public interface InterfaceC0563a {
        void dz();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface b {
        void a(c cVar, int i6);
    }

    public final void a(b bVar) {
        this.kY = bVar;
    }

    public final void d(List<AdTemplate> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.mAdTemplateList.clear();
        this.mAdTemplateList.addAll(list);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void destroyItem(@NonNull ViewGroup viewGroup, int i6, Object obj) {
        if (obj instanceof View) {
            viewGroup.removeView((View) obj);
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final int getCount() {
        return this.mAdTemplateList.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @NonNull
    public final Object instantiateItem(@NonNull ViewGroup viewGroup, final int i6) {
        c cVar = new c(viewGroup.getContext());
        viewGroup.addView(cVar);
        cVar.setAggregateAdView(i6 > 0);
        cVar.setAdAggregateClickActionListener(new c.a() { // from class: com.kwad.components.ad.interstitial.aggregate.a.1
            @Override // com.kwad.components.ad.interstitial.f.c.a
            public final void a(long j6, long j7, boolean z5) {
                AdTemplate adTemplate = (AdTemplate) a.this.mAdTemplateList.get(i6);
                if (adTemplate == null) {
                    return;
                }
                if (i6 == 0 && z5) {
                    com.kwad.components.ad.interstitial.report.a.eO().b(adTemplate, j6, j7);
                }
                if (a.this.kZ != null) {
                    a.this.kZ.dz();
                }
            }
        });
        if (i6 > 0) {
            cVar.setAggregateShowTriggerType(8);
        }
        cVar.a(this.mAdResultData, this.kW, this.bU, this.kQ, i6);
        b bVar = this.kY;
        if (bVar != null) {
            bVar.a(cVar, i6);
        }
        return cVar;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
        return view == obj;
    }

    public a(AdResultData adResultData, d dVar, KsAdVideoPlayConfig ksAdVideoPlayConfig, KsInterstitialAd.AdInteractionListener adInteractionListener) {
        this.mAdResultData = adResultData;
        this.kW = dVar;
        this.bU = ksAdVideoPlayConfig;
        this.kQ = adInteractionListener;
        this.kX = com.kwad.sdk.core.response.b.a.cA(e.el(com.kwad.sdk.core.response.b.c.r(adResultData))) == 1;
    }

    public final void a(InterfaceC0563a interfaceC0563a) {
        this.kZ = interfaceC0563a;
    }
}
