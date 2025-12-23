package com.kwad.components.core.page.d;

import android.content.Context;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.kwad.components.core.proxy.f;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.video.b;
import com.kwad.components.core.video.k;
import com.kwad.components.core.video.l;
import com.kwad.components.core.video.m;
import com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.contentalliance.a.a.b;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.b.h;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
import com.kwad.sdk.core.video.a.c;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a implements com.kwad.components.core.m.a.a {
    private String Bh;
    private boolean Bj = false;
    private final List<i.a> Bk = new ArrayList();
    private OfflineOnAudioConflictListener Bm = new OfflineOnAudioConflictListener() { // from class: com.kwad.components.core.page.d.a.1
        @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
        public final void onAudioBeOccupied() {
            a.a(a.this, true);
            if (a.this.LU != null) {
                a.this.LU.setAudioEnabled(false);
            }
            synchronized (a.this.Bk) {
                try {
                    Iterator it = a.this.Bk.iterator();
                    while (it.hasNext()) {
                        ((i.a) it.next()).onAudioBeOccupied();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
        public final void onAudioBeReleased() {
            synchronized (a.this.Bk) {
                try {
                    Iterator it = a.this.Bk.iterator();
                    while (it.hasNext()) {
                        ((i.a) it.next()).onAudioBeReleased();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    };
    private b LU;
    private AdTemplate mAdTemplate;
    private Context mContext;
    private DetailVideoView mDetailVideoView;
    private KsVideoPlayConfig mVideoPlayConfig;
    private VideoPlayerStatus mVideoPlayerStatus;
    private boolean pW;
    private m pY;

    @Override // com.kwad.components.core.m.a.a
    public final void gY() {
        this.Bj = false;
        if (this.LU.tz() == null) {
            bs();
        }
    }

    @Override // com.kwad.components.core.m.a.a
    public final void gZ() {
        this.Bj = false;
        b bVar = this.LU;
        if (bVar != null) {
            bVar.d(this.pY);
            this.LU.release();
        }
    }

    static /* synthetic */ boolean a(a aVar, boolean z5) {
        aVar.Bj = true;
        return true;
    }

    private void bs() {
        this.LU.a(new b.a(this.mAdTemplate).dg(this.Bh).dh(h.b(e.em(this.mAdTemplate))).a(this.mVideoPlayerStatus).b(com.kwad.sdk.contentalliance.a.a.a.bQ(this.mAdTemplate)).El(), this.mDetailVideoView);
        KsVideoPlayConfig ksVideoPlayConfig = this.mVideoPlayConfig;
        if (ksVideoPlayConfig != null) {
            setAudioEnabled(ksVideoPlayConfig.isVideoSoundEnable(), false);
        }
        this.LU.prepareAsync();
    }

    private void pause() {
        SceneImpl sceneImpl;
        AdTemplate adTemplate = this.mAdTemplate;
        if (adTemplate.mXiaomiAppStoreDetailViewOpen && (sceneImpl = adTemplate.mAdScene) != null && sceneImpl.getAdStyle() == 2) {
            return;
        }
        this.LU.pause();
    }

    private void resume() {
        this.LU.resume();
    }

    private void setAudioEnabled(boolean z5, boolean z6) {
        this.pW = z5;
        this.LU.setAudioEnabled(z5);
    }

    @MainThread
    public final void b(l lVar) {
        if (lVar == null) {
            return;
        }
        this.LU.d(lVar);
    }

    @MainThread
    public final void release() {
        com.kwad.components.core.video.b bVar = this.LU;
        if (bVar != null) {
            bVar.clear();
            this.LU.release();
        }
        com.kwad.components.core.t.a.aC(this.mContext).b(this.Bm);
    }

    public a(@NonNull final AdTemplate adTemplate, @NonNull DetailVideoView detailVideoView, KsVideoPlayConfig ksVideoPlayConfig) {
        this.mVideoPlayConfig = ksVideoPlayConfig;
        this.mAdTemplate = adTemplate;
        Context context = detailVideoView.getContext();
        this.mContext = context;
        this.mVideoPlayerStatus = adTemplate.mVideoPlayerStatus;
        this.Bh = k.g(context, adTemplate);
        this.mDetailVideoView = detailVideoView;
        this.LU = new com.kwad.components.core.video.b(detailVideoView, adTemplate);
        bs();
        m mVar = new m() { // from class: com.kwad.components.core.page.d.a.2
            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlayError(int i6, int i7) {
                super.onMediaPlayError(i6, i7);
                com.kwad.components.core.p.a.se().g(adTemplate, i6, i7);
            }
        };
        this.pY = mVar;
        this.LU.c(mVar);
        this.LU.a(new c.e() { // from class: com.kwad.components.core.page.d.a.3
            @Override // com.kwad.sdk.core.video.a.c.e
            public final void a(c cVar) {
                try {
                    a.this.LU.start();
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        });
        com.kwad.components.core.t.a.aC(this.mContext).a(this.Bm);
    }

    @MainThread
    public final void a(l lVar) {
        if (lVar == null) {
            return;
        }
        this.LU.c(lVar);
    }

    @Override // com.kwad.components.core.m.a.a
    public final void c(f fVar) {
        resume();
    }

    @Override // com.kwad.components.core.m.a.a
    public final void d(f fVar) {
        pause();
    }
}
