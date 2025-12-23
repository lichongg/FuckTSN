package com.kwad.components.core.page.c;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.widget.FeedVideoView;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.service.ServiceProvider;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a extends Presenter {
    private int Ty;
    private FeedVideoView Tz;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        final com.kwad.components.core.page.recycle.e eVar = (com.kwad.components.core.page.recycle.e) NN();
        KsAdVideoPlayConfig build = new KsAdVideoPlayConfig.Builder().videoSoundEnable(eVar.adTemplate.mIsAudioEnable).build();
        FeedVideoView feedVideoView = (FeedVideoView) getRootView();
        this.Tz = feedVideoView;
        feedVideoView.d(com.kwad.sdk.core.response.b.c.dW(eVar.adTemplate));
        this.Tz.a(build, eVar.Pc);
        this.Tz.setVisibility(0);
        final AdInfo el = com.kwad.sdk.core.response.b.e.el(eVar.adTemplate);
        this.Tz.setOnEndBtnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.c.a.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                try {
                    if (com.kwad.sdk.core.response.b.a.aF(el)) {
                        if (eVar.Pc != null) {
                            com.kwad.components.core.e.d.a.a(new a.C0616a(a.this.getActivity()).aq(false).ar(false).av(true).aB(eVar.adTemplate).at(false));
                            com.kwad.sdk.core.adlog.c.a(eVar.adTemplate, 50, a.this.Tz.getTouchCoords());
                            return;
                        }
                        return;
                    }
                    RecyclerView recyclerView = eVar.Vb;
                    if (recyclerView == null || recyclerView.getAdapter() == null || eVar.Vb.getAdapter().getItemCount() <= 1) {
                        return;
                    }
                    eVar.Vb.scrollToPosition(1);
                    com.kwad.sdk.core.adlog.c.a(eVar.adTemplate, 50, a.this.Tz.getTouchCoords());
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        });
        if (com.kwad.sdk.core.response.b.a.aq(el)) {
            this.Tz.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.c.a.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    try {
                        if (com.kwad.sdk.core.response.b.a.aF(el)) {
                            if (eVar.Pc != null) {
                                com.kwad.components.core.e.d.a.a(new a.C0616a(a.this.getActivity()).aq(false).ar(false).av(true).aB(eVar.adTemplate).at(false));
                                com.kwad.sdk.core.adlog.c.a(eVar.adTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_BIT_RATE, a.this.Tz.getTouchCoords());
                                return;
                            }
                            return;
                        }
                        RecyclerView recyclerView = eVar.Vb;
                        if (recyclerView == null || recyclerView.getAdapter() == null || eVar.Vb.getAdapter().getItemCount() <= 1) {
                            return;
                        }
                        eVar.Vb.scrollToPosition(1);
                        com.kwad.sdk.core.adlog.c.a(eVar.adTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_BIT_RATE, a.this.Tz.getTouchCoords());
                    } catch (Throwable th) {
                        ServiceProvider.reportSdkCaughtException(th);
                    }
                }
            });
        }
        this.Tz.setWindowFullScreenListener(new FeedVideoView.a() { // from class: com.kwad.components.core.page.c.a.3
            @Override // com.kwad.components.core.widget.FeedVideoView.a
            public final void rb() {
                RecyclerView recyclerView = eVar.Vb;
                if (recyclerView != null) {
                    a.this.Ty = recyclerView.computeVerticalScrollOffset();
                }
            }

            @Override // com.kwad.components.core.widget.FeedVideoView.a
            public final void rc() {
                RecyclerView recyclerView = eVar.Vb;
                if (recyclerView != null) {
                    recyclerView.scrollToPosition(a.this.Ty);
                }
            }
        });
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.Tz.release();
    }
}
