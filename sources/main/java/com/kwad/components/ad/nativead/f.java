package com.kwad.components.ad.nativead;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.nativead.b.g;
import com.kwad.components.ad.nativead.b.h;
import com.kwad.components.ad.nativead.b.i;
import com.kwad.components.ad.nativead.b.j;
import com.kwad.components.ad.nativead.b.k;
import com.kwad.components.ad.nativead.d;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBasePvFrameLayout;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.o.m;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;
import com.kwad.sdk.utils.n;
import com.kwad.sdk.widget.KSFrameLayout;
import com.kwad.sdk.widget.l;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class f extends KSFrameLayout {
    private l eF;
    private com.kwad.components.core.widget.a.b fg;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private DetailVideoView mDetailVideoView;
    private Presenter mPresenter;
    private KsNativeAd.VideoPlayListener oQ;
    private d.a oW;

    /* renamed from: pl, reason: collision with root package name */
    private AdBasePvFrameLayout f36340pl;
    private com.kwad.components.ad.nativead.a.b pq;
    public com.kwad.components.ad.nativead.c.a pr;
    private KsAdVideoPlayConfig ps;
    private boolean pt;
    private boolean pu;

    public f(@NonNull Context context) {
        this(context, null);
    }

    public final void g(int i6, int i7) {
        if (i6 == 0) {
            this.pu = true;
        }
        if (i7 == 0) {
            this.pt = true;
        }
    }

    private f(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, null, 0);
    }

    private void B(Context context) {
        m.inflate(context, R.layout.ksad_native_video_layout, this);
        AdBasePvFrameLayout adBasePvFrameLayout = (AdBasePvFrameLayout) findViewById(R.id.ksad_root_container);
        this.f36340pl = adBasePvFrameLayout;
        DetailVideoView detailVideoView = (DetailVideoView) adBasePvFrameLayout.findViewById(R.id.ksad_video_player);
        this.mDetailVideoView = detailVideoView;
        detailVideoView.setAd(true);
    }

    private Presenter bD() {
        Presenter presenter = new Presenter();
        presenter.a(new com.kwad.components.ad.nativead.b.e());
        presenter.a(new com.kwad.components.ad.nativead.b.c());
        presenter.a(new i());
        presenter.a(new j());
        presenter.a(new com.kwad.components.ad.nativead.b.d());
        presenter.a(new com.kwad.components.ad.nativead.b.b());
        presenter.a(new k());
        presenter.a(new com.kwad.components.ad.nativead.b.a(this.ps));
        presenter.a(new g());
        if (com.kwad.sdk.core.response.b.a.aF(com.kwad.sdk.core.response.b.e.el(this.mAdTemplate))) {
            presenter.a(new com.kwad.components.ad.nativead.b.f());
            return presenter;
        }
        presenter.a(new h());
        return presenter;
    }

    private com.kwad.components.ad.nativead.a.b fv() {
        com.kwad.components.ad.nativead.a.b bVar = new com.kwad.components.ad.nativead.a.b();
        bVar.f36338pl = this.f36340pl;
        AdTemplate adTemplate = this.mAdTemplate;
        bVar.mAdTemplate = adTemplate;
        bVar.oW = this.oW;
        bVar.oQ = this.oQ;
        if (com.kwad.sdk.core.response.b.a.aF(com.kwad.sdk.core.response.b.e.el(adTemplate))) {
            com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
            if (cVar == null) {
                bVar.mApkDownloadHelper = new com.kwad.components.core.e.d.c(this.mAdTemplate);
            } else {
                cVar.pz();
                bVar.mApkDownloadHelper = this.mApkDownloadHelper;
            }
        }
        bVar.px = this.pu;
        bVar.pw = this.pt;
        bVar.pr = this.pr;
        return bVar;
    }

    public final void a(@NonNull AdTemplate adTemplate, @Nullable com.kwad.components.core.e.d.c cVar, @Nullable KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        this.mAdTemplate = adTemplate;
        this.mApkDownloadHelper = cVar;
        this.ps = ksAdVideoPlayConfig;
        this.f36340pl.setVisibleListener(this.eF);
        this.fg = new com.kwad.components.core.widget.a.b(getParent() == null ? this : (View) getParent(), 30);
    }

    public final void setInnerAdInteractionListener(d.a aVar) {
        this.oW = aVar;
    }

    public final void setPlayState(int i6) {
        com.kwad.components.ad.nativead.c.a aVar = this.pr;
        if (aVar != null) {
            aVar.V(i6);
        }
    }

    public final void setVideoPlayListener(KsNativeAd.VideoPlayListener videoPlayListener) {
        this.oQ = videoPlayListener;
    }

    private f(@NonNull Context context, @Nullable AttributeSet attributeSet, int i6) {
        super(context, attributeSet, 0);
        this.pt = false;
        this.pu = false;
        this.eF = new l() { // from class: com.kwad.components.ad.nativead.f.1
            @Override // com.kwad.sdk.widget.l
            public final void aT() {
                n.eM(f.this.mAdTemplate);
            }
        };
        B(context);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void aa() {
        super.aa();
        if (this.pr == null) {
            this.pr = new com.kwad.components.ad.nativead.c.a(this.mAdTemplate, this.fg, this.mDetailVideoView, this.ps);
        }
        this.pq = fv();
        Presenter bD = bD();
        this.mPresenter = bD;
        bD.K(this.f36340pl);
        this.mPresenter.n(this.pq);
        this.fg.wi();
        this.pr.bo();
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void ab() {
        super.ab();
        bw.runOnUiThread(new bg() { // from class: com.kwad.components.ad.nativead.f.2
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                if (f.this.fg != null) {
                    f.this.fg.release();
                }
                com.kwad.components.ad.nativead.c.a aVar = f.this.pr;
                if (aVar != null) {
                    aVar.bq();
                }
                if (f.this.pq != null) {
                    f.this.pq.release();
                }
                if (f.this.mPresenter != null) {
                    f.this.mPresenter.destroy();
                }
            }
        });
    }
}
