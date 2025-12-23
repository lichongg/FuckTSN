package com.kwad.components.ad.nativead.a;

import android.view.View;
import com.kwad.components.core.video.l;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.service.ServiceProvider;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class a extends Presenter {
    public l mVideoPlayStateListener;
    public b pq;

    protected static void a(View view, String str) {
        if (view == null) {
            ServiceProvider.reportSdkCaughtException(new RuntimeException(" findViewById failed " + str));
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void at() {
        super.at();
        this.pq = (b) NN();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void onUnbind() {
        super.onUnbind();
        this.pq.pr.a(this.mVideoPlayStateListener);
    }
}
