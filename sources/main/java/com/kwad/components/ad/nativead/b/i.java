package com.kwad.components.ad.nativead.b;

import android.view.MotionEvent;
import android.view.View;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.video.l;
import com.kwad.components.core.video.m;
import com.kwad.sdk.R;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class i extends com.kwad.components.ad.nativead.a.a implements View.OnClickListener, View.OnTouchListener {
    private DetailVideoView mDetailVideoView;
    private MotionEvent pJ;

    private void fC() {
        com.kwad.components.core.e.d.a.a(new a.C0616a(getContext()).aB(this.pq.mAdTemplate).b(this.pq.mApkDownloadHelper).A(this.pq.pr.getPlayDuration()).a(new a.b() { // from class: com.kwad.components.ad.nativead.b.i.3
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                com.kwad.sdk.core.adlog.c.a(i.this.pq.mAdTemplate, 153, i.this.pq.f36338pl.getTouchCoords());
            }
        }));
    }

    private void fF() {
        com.kwad.components.core.e.d.a.a(new a.C0616a(getContext()).aB(this.pq.mAdTemplate).b(this.pq.mApkDownloadHelper).A(this.pq.pr.getPlayDuration()).a(new a.b() { // from class: com.kwad.components.ad.nativead.b.i.2
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                com.kwad.sdk.core.adlog.c.a(i.this.pq.mAdTemplate, 2, i.this.pq.f36338pl.getTouchCoords());
            }
        }));
    }

    private void n(View view) {
        if (view == this.mDetailVideoView) {
            fC();
            notifyAdClick();
        }
    }

    private void notifyAdClick() {
        this.pq.oW.m(this.mDetailVideoView);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.pq.px && view == this.mDetailVideoView) {
            fF();
            notifyAdClick();
        }
    }

    @Override // com.kwad.components.ad.nativead.a.a, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        m mVar = new m() { // from class: com.kwad.components.ad.nativead.b.i.1
            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlayStart() {
                super.onMediaPlayStart();
            }
        };
        this.mVideoPlayStateListener = mVar;
        this.pq.pr.b((l) mVar);
        DetailVideoView detailVideoView = this.mDetailVideoView;
        if (detailVideoView != null) {
            detailVideoView.setOnClickListener(this);
            this.mDetailVideoView.setOnTouchListener(this);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.mDetailVideoView = (DetailVideoView) findViewById(R.id.ksad_video_player);
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

    @Override // com.kwad.components.ad.nativead.a.a, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        DetailVideoView detailVideoView = this.mDetailVideoView;
        if (detailVideoView != null) {
            detailVideoView.setOnClickListener(null);
            this.mDetailVideoView.setOnTouchListener(null);
        }
    }
}
