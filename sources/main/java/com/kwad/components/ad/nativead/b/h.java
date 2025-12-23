package com.kwad.components.ad.nativead.b;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.video.l;
import com.kwad.components.core.video.m;
import com.kwad.sdk.R;
import com.kwad.sdk.service.ServiceProvider;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class h extends com.kwad.components.ad.nativead.a.a implements View.OnClickListener, View.OnTouchListener {
    private MotionEvent pJ;
    private ViewGroup pO;
    private TextView pP;

    /* JADX INFO: Access modifiers changed from: private */
    public void fA() {
        try {
            this.pP.setText(com.kwad.sdk.core.response.b.a.aE(com.kwad.sdk.core.response.b.e.el(this.pq.mAdTemplate)));
            this.pO.setOnClickListener(this);
            this.pO.setOnTouchListener(this);
            this.pO.setVisibility(0);
            this.pP.setVisibility(0);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fB() {
        try {
            this.pO.setVisibility(8);
            this.pP.setVisibility(8);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private void fC() {
        com.kwad.components.core.e.d.a.a(new a.C0616a(getContext()).aB(this.pq.mAdTemplate).b(this.pq.mApkDownloadHelper).A(this.pq.pr.getPlayDuration()).a(new a.b() { // from class: com.kwad.components.ad.nativead.b.h.3
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                com.kwad.sdk.core.adlog.c.a(h.this.pq.mAdTemplate, 153, h.this.pq.f36338pl.getTouchCoords());
            }
        }));
    }

    private void fF() {
        com.kwad.components.core.e.d.a.a(new a.C0616a(getContext()).aB(this.pq.mAdTemplate).aB(2).a(new a.b() { // from class: com.kwad.components.ad.nativead.b.h.2
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                com.kwad.sdk.core.adlog.c.a(h.this.pq.mAdTemplate, 2, h.this.pq.f36338pl.getTouchCoords());
            }
        }));
    }

    private void n(View view) {
        if (view == this.pO) {
            fC();
            notifyAdClick();
        }
    }

    private void notifyAdClick() {
        ViewGroup viewGroup = this.pO;
        if (viewGroup != null) {
            this.pq.oW.m(viewGroup);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.pq.px) {
            fF();
            notifyAdClick();
        }
    }

    @Override // com.kwad.components.ad.nativead.a.a, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        m mVar = new m() { // from class: com.kwad.components.ad.nativead.b.h.1
            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlayCompleted() {
                h.this.fA();
            }

            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlayStart() {
                super.onMediaPlayStart();
                h.this.fB();
            }
        };
        this.mVideoPlayStateListener = mVar;
        this.pq.pr.b((l) mVar);
        ViewGroup viewGroup = this.pO;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.pO = (ViewGroup) findViewById(R.id.ksad_video_complete_h5_container);
        this.pP = (TextView) findViewById(R.id.ksad_h5_open);
        com.kwad.components.ad.nativead.a.a.a(this.pO, "NativePlayEndH5Presenter: R.id.ksad_video_complete_h5_container is null");
        com.kwad.components.ad.nativead.a.a.a(this.pP, "NativePlayEndH5Presenter: R.id.ksad_h5_open is null");
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        MotionEvent motionEvent2;
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
            com.kwad.components.ad.nativead.a.b bVar = this.pq;
            if (bVar.pw && (motionEvent2 = this.pJ) != null && com.kwad.sdk.utils.b.a(motionEvent2, motionEvent, bVar.mAdTemplate)) {
                n(view);
            }
            z5 = true;
        }
        this.pJ = null;
        return z5;
    }
}
