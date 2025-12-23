package com.kwad.components.ad.draw.b;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.e.d.c;
import com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView;
import com.kwad.components.offline.api.core.adlive.IAdLivePlayModule;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.service.ServiceProvider;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b extends com.kwad.sdk.mvp.a {
    private boolean dA;

    @Nullable
    public com.kwad.components.ad.draw.c.a dB;

    @Nullable
    public IAdLivePlayModule dC;

    @Nullable
    public IAdLiveOfflineView dD;

    @NonNull
    public com.kwad.components.ad.draw.presenter.b.a dE;

    @Nullable
    public com.kwad.components.ad.l.b dF;

    @Nullable
    public KsDrawAd.AdInteractionListener dh;

    @Nullable
    public c mApkDownloadHelper;

    @NonNull
    public AdBaseFrameLayout mRootContainer;

    public final void a(int i6, Context context, final int i7, int i8) {
        a.C0616a aB = new a.C0616a(context).aB(this.mAdTemplate).b(this.mApkDownloadHelper).aq(false).aB(i8);
        IAdLivePlayModule iAdLivePlayModule = this.dC;
        com.kwad.components.core.e.d.a.a(aB.A(iAdLivePlayModule == null ? 0L : iAdLivePlayModule.getPlayDuration()).ay(true).aA(i7).az(i6).a(new a.b() { // from class: com.kwad.components.ad.draw.b.b.1
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                try {
                    b.this.a(i7, null);
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        }));
    }

    @Override // com.kwad.sdk.mvp.a
    public final void release() {
        c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.clear();
        }
        IAdLivePlayModule iAdLivePlayModule = this.dC;
        if (iAdLivePlayModule != null) {
            iAdLivePlayModule.release();
            this.dC = null;
        }
        IAdLiveOfflineView iAdLiveOfflineView = this.dD;
        if (iAdLiveOfflineView != null) {
            iAdLiveOfflineView.onDestroy();
            this.dD = null;
        }
        com.kwad.components.ad.draw.c.a aVar = this.dB;
        if (aVar != null) {
            aVar.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i6, com.kwad.sdk.core.adlog.c.b bVar) {
        if (bVar == null) {
            bVar = new com.kwad.sdk.core.adlog.c.b();
        }
        bVar.dd(i6);
        bVar.f(this.mRootContainer.getTouchCoords());
        com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, bVar, (JSONObject) null);
        KsDrawAd.AdInteractionListener adInteractionListener = this.dh;
        if (adInteractionListener != null) {
            adInteractionListener.onAdClicked();
        }
        if (this.dA) {
            return;
        }
        AdTemplate adTemplate = this.mAdTemplate;
        com.kwad.components.ad.draw.a.c.b(adTemplate, 1, com.kwad.sdk.core.response.b.b.de(adTemplate) ? 2 : 1);
        this.dA = true;
    }
}
