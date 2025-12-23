package com.kwad.components.ad.nativead.b;

import android.widget.ImageView;
import com.kwad.components.core.video.l;
import com.kwad.components.core.video.m;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class g extends com.kwad.components.ad.nativead.a.a {
    private ImageView pM;

    /* JADX INFO: Access modifiers changed from: private */
    public void fD() {
        KSImageLoader.loadImage(this.pM, com.kwad.sdk.core.response.b.a.X(com.kwad.sdk.core.response.b.e.el(this.pq.mAdTemplate)), this.pq.mAdTemplate);
        this.pM.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fE() {
        if (this.pM.getVisibility() == 0) {
            this.pM.setVisibility(8);
        }
    }

    @Override // com.kwad.components.ad.nativead.a.a, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        m mVar = new m() { // from class: com.kwad.components.ad.nativead.b.g.1
            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlayCompleted() {
                g.this.fD();
            }

            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlayStart() {
                super.onMediaPlayStart();
                g.this.fE();
            }
        };
        this.mVideoPlayStateListener = mVar;
        this.pq.pr.b((l) mVar);
        this.pM.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        ImageView imageView = (ImageView) findViewById(R.id.ksad_video_cover_image);
        this.pM = imageView;
        com.kwad.components.ad.nativead.a.a.a(imageView, "NativePlayEndCoverPresenter R.id.ksad_video_cover_image is null");
    }
}
