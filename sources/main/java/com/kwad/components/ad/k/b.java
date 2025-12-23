package com.kwad.components.ad.k;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.video.l;
import com.kwad.components.core.video.m;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class b extends a<l> {
    public com.kwad.components.core.video.b LU;
    private boolean LV;
    private l LW;
    protected DetailVideoView mDetailVideoView;

    private void nH() {
        this.LU.c(this.LW);
    }

    private void nI() {
        l lVar;
        com.kwad.components.core.video.b bVar = this.LU;
        if (bVar == null || (lVar = this.LW) == null) {
            return;
        }
        bVar.d(lVar);
        this.LW = null;
    }

    @Override // com.kwad.components.ad.k.a
    public long getPlayDuration() {
        com.kwad.components.core.video.b bVar = this.LU;
        if (bVar != null) {
            return bVar.getPlayDuration();
        }
        return 0L;
    }

    @Override // com.kwad.components.ad.k.a
    public void pause() {
        this.LU.pause();
    }

    @Override // com.kwad.components.ad.k.a
    public void resume() {
        this.LU.resume();
    }

    public b(@NonNull AdTemplate adTemplate, DetailVideoView detailVideoView) {
        super(adTemplate);
        this.LV = false;
        this.LW = new m() { // from class: com.kwad.components.ad.k.b.1
            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlayCompleted() {
                b.this.mAdTemplate.setmCurPlayTime(-1L);
            }

            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlayProgress(long j6, long j7) {
                b.this.mAdTemplate.setmCurPlayTime(j7);
            }

            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlayError(int i6, int i7) {
                try {
                    super.onMediaPlayError(i6, i7);
                    if (!b.this.LV) {
                        b.this.nJ();
                    } else if (e.FV()) {
                        b.this.nJ();
                    }
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        };
        this.mDetailVideoView = detailVideoView;
        this.LU = new com.kwad.components.core.video.b(this.mDetailVideoView, adTemplate);
        nH();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nJ() {
        com.kwad.components.core.p.a.se().f(this.mAdTemplate, 21008);
        this.LV = true;
    }

    @Override // com.kwad.components.ad.k.a
    @MainThread
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final void b(l lVar) {
        com.kwad.components.core.video.b bVar;
        if (lVar == null || (bVar = this.LU) == null) {
            return;
        }
        bVar.c(lVar);
    }

    @Override // com.kwad.components.ad.k.a
    @MainThread
    /* renamed from: b, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final void a(l lVar) {
        if (lVar == null) {
            return;
        }
        this.LU.d(lVar);
    }

    @Override // com.kwad.components.ad.k.a
    @WorkerThread
    public void release() {
        super.release();
        this.LV = false;
        nI();
        com.kwad.components.core.video.b bVar = this.LU;
        if (bVar != null) {
            bVar.clear();
            this.LU.release();
        }
    }
}
