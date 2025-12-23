package com.kwad.components.ad.nativead.b;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.video.l;
import com.kwad.components.core.video.m;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class f extends com.kwad.components.ad.nativead.a.a implements View.OnClickListener, View.OnTouchListener {
    private TextView ee;
    private ImageView gw;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;

    @Nullable
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private ViewGroup pH;
    private TextView pI;
    private MotionEvent pJ;
    private KsAppDownloadListener pK = new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.ad.nativead.b.f.2
        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFailed() {
            f.this.pI.setText(com.kwad.sdk.core.response.b.a.aE(f.this.mAdInfo));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFinished() {
            f.this.pI.setText(com.kwad.sdk.core.response.b.a.cl(f.this.mAdTemplate));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onIdle() {
            f.this.pI.setText(com.kwad.sdk.core.response.b.a.aE(f.this.mAdInfo));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onInstalled() {
            f.this.pI.setText(com.kwad.sdk.core.response.b.a.ac(f.this.mAdInfo));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onProgressUpdate(int i6) {
        }
    };

    private void T(int i6) {
        com.kwad.components.ad.nativead.c.a aVar;
        a.C0616a b6 = new a.C0616a(getContext()).aB(this.mAdTemplate).aB(i6).b(this.mApkDownloadHelper);
        com.kwad.components.ad.nativead.a.b bVar = this.pq;
        com.kwad.components.core.e.d.a.a(b6.A((bVar == null || (aVar = bVar.pr) == null) ? 0L : aVar.getPlayDuration()).a(new a.b() { // from class: com.kwad.components.ad.nativead.b.f.3
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                com.kwad.sdk.core.adlog.c.a(f.this.mAdTemplate, 2, f.this.pq.f36338pl.getTouchCoords());
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fA() {
        KSImageLoader.loadAppIcon(this.gw, com.kwad.sdk.core.response.b.a.co(this.mAdInfo), this.mAdTemplate, 12);
        this.ee.setText(com.kwad.sdk.core.response.b.a.av(this.mAdInfo));
        this.pI.setText(com.kwad.sdk.core.response.b.a.aE(this.mAdInfo));
        com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.b(this.pK);
        }
        this.pH.setOnClickListener(this);
        this.pH.setOnTouchListener(this);
        this.pH.setVisibility(0);
        this.ee.setVisibility(0);
        this.pI.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fB() {
        try {
            this.ee.setVisibility(8);
            this.pI.setVisibility(8);
            this.pH.setVisibility(8);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private void fC() {
        com.kwad.components.core.e.d.a.a(new a.C0616a(getContext()).aB(this.pq.mAdTemplate).b(this.pq.mApkDownloadHelper).A(this.pq.pr.getPlayDuration()).a(new a.b() { // from class: com.kwad.components.ad.nativead.b.f.4
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                com.kwad.sdk.core.adlog.c.a(f.this.pq.mAdTemplate, 153, f.this.pq.f36338pl.getTouchCoords());
            }
        }));
    }

    private void n(View view) {
        if (view == this.pH) {
            fC();
            notifyAdClick();
        }
    }

    private void notifyAdClick() {
        ViewGroup viewGroup = this.pH;
        if (viewGroup != null) {
            this.pq.oW.m(viewGroup);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.pq.px) {
            if (view == this.pH) {
                T(2);
                notifyAdClick();
            } else if (view == this.pI) {
                T(1);
                notifyAdClick();
            }
        }
    }

    @Override // com.kwad.components.ad.nativead.a.a, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        AdTemplate adTemplate = this.pq.mAdTemplate;
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.b.e.el(adTemplate);
        this.mApkDownloadHelper = this.pq.mApkDownloadHelper;
        m mVar = new m() { // from class: com.kwad.components.ad.nativead.b.f.1
            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlayCompleted() {
                try {
                    f.this.fA();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                    com.kwad.components.core.d.a.reportSdkCaughtException(th);
                }
            }

            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlayStart() {
                super.onMediaPlayStart();
                f.this.fB();
            }
        };
        this.mVideoPlayStateListener = mVar;
        this.pq.pr.b((l) mVar);
        ViewGroup viewGroup = this.pH;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.pH = (ViewGroup) findViewById(R.id.ksad_video_complete_app_container);
        this.gw = (ImageView) findViewById(R.id.ksad_app_icon);
        this.ee = (TextView) findViewById(R.id.ksad_app_name);
        this.pI = (TextView) findViewById(R.id.ksad_app_download);
        com.kwad.components.ad.nativead.a.a.a(this.pH, "NativePlayEndAppPresenter: R.id.ksad_video_complete_app_container is null");
        com.kwad.components.ad.nativead.a.a.a(this.gw, "NativePlayEndAppPresenter: R.id.ksad_app_icon is null");
        com.kwad.components.ad.nativead.a.a.a(this.ee, "NativePlayEndAppPresenter: R.id.ksad_app_name is null");
        com.kwad.components.ad.nativead.a.a.a(this.pI, "NativePlayEndAppPresenter: R.id.ksad_app_download is null");
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        boolean z5 = false;
        if (action == 0) {
            this.pJ = MotionEvent.obtain(motionEvent);
            return false;
        }
        if (action != 1 && action != 3) {
            return false;
        }
        if (com.kwad.sdk.utils.b.a(this.pJ, motionEvent)) {
            if (this.pq.pw && com.kwad.sdk.utils.b.a(this.pJ, motionEvent, this.mAdTemplate)) {
                n(view);
            }
            z5 = true;
        }
        this.pJ = null;
        return z5;
    }

    @Override // com.kwad.components.ad.nativead.a.a, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.c(this.pK);
        }
    }
}
