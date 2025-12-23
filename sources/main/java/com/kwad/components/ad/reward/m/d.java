package com.kwad.components.ad.reward.m;

import android.content.Context;
import androidx.annotation.MainThread;
import com.kwad.components.ad.reward.g;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.video.k;
import com.kwad.components.core.video.m;
import com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.contentalliance.a.a.b;
import com.kwad.sdk.core.response.b.h;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
import com.kwad.sdk.core.video.a.c;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class d extends com.kwad.components.ad.k.b implements g.a {
    private String Bh;
    private AtomicBoolean Bi;
    private boolean Bj;
    private final List<i.a> Bk;
    private final List<Object> Bl;
    private OfflineOnAudioConflictListener Bm;
    private Context mContext;
    private KsVideoPlayConfig mVideoPlayConfig;
    private VideoPlayerStatus mVideoPlayerStatus;
    private boolean ng;
    private boolean pW;
    private m pY;
    private g tm;

    @Override // com.kwad.components.ad.reward.g.a
    public final void hd() {
        this.Bj = false;
    }

    @Override // com.kwad.components.ad.reward.g.a
    public final void hg() {
        com.kwad.components.core.video.b bVar;
        this.Bj = false;
        if (!this.Bi.get() || (bVar = this.LU) == null) {
            return;
        }
        bVar.d(this.pY);
        this.LU.release();
    }

    @Override // com.kwad.components.ad.k.b, com.kwad.components.ad.k.a
    public final void resume() {
        this.ng = false;
        if (!this.Bi.get() || this.LU == null || kU() || g.b(this.tm)) {
            return;
        }
        super.resume();
    }

    public d(g gVar, DetailVideoView detailVideoView) {
        super(gVar.mAdTemplate, detailVideoView);
        this.Bi = new AtomicBoolean(false);
        this.Bj = false;
        this.ng = false;
        this.Bk = new ArrayList();
        this.Bl = new ArrayList();
        this.Bm = new OfflineOnAudioConflictListener() { // from class: com.kwad.components.ad.reward.m.d.1
            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeOccupied() {
                d.a(d.this, true);
                if (d.this.LU != null) {
                    d.this.LU.setAudioEnabled(false);
                }
                synchronized (d.this.Bk) {
                    try {
                        Iterator it = d.this.Bk.iterator();
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
                synchronized (d.this.Bk) {
                    try {
                        Iterator it = d.this.Bk.iterator();
                        while (it.hasNext()) {
                            ((i.a) it.next()).onAudioBeReleased();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        };
        this.tm = gVar;
        this.mContext = gVar.mContext;
        this.mVideoPlayConfig = gVar.mVideoPlayConfig;
        this.mVideoPlayerStatus = this.mAdTemplate.mVideoPlayerStatus;
        this.Bh = getVideoUrl();
    }

    static /* synthetic */ boolean a(d dVar, boolean z5) {
        dVar.Bj = true;
        return true;
    }

    private boolean kU() {
        return com.kwad.sdk.core.response.b.a.cR(com.kwad.sdk.core.response.b.e.el(this.mAdTemplate));
    }

    public final void b(i.a aVar) {
        this.Bk.remove(aVar);
    }

    @Override // com.kwad.components.ad.k.b, com.kwad.components.ad.k.a
    public final long getPlayDuration() {
        if (this.Bi.get()) {
            return super.getPlayDuration();
        }
        return 0L;
    }

    @Override // com.kwad.components.ad.reward.g.a
    public final void he() {
        if (this.ng) {
            return;
        }
        resume();
        if (this.pW || (com.kwad.components.ad.reward.a.b.hC() && this.Bj)) {
            com.kwad.components.core.t.a.aC(this.mContext).aQ(com.kwad.components.ad.reward.a.b.hC());
            if (com.kwad.components.ad.reward.a.b.hC() && this.Bj) {
                this.Bj = false;
                this.pW = true;
                setAudioEnabled(true, false);
            } else {
                if (this.tm.rC || !com.kwad.components.core.t.a.aC(this.mContext).sW()) {
                    return;
                }
                this.pW = false;
                setAudioEnabled(false, false);
            }
        }
    }

    public final void kS() {
        if (this.Bi.get()) {
            return;
        }
        this.Bi.set(true);
        bs();
        m mVar = new m() { // from class: com.kwad.components.ad.reward.m.d.2
            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlayError(int i6, int i7) {
                super.onMediaPlayError(i6, i7);
                com.kwad.components.core.p.a.se().g(d.this.mAdTemplate, i6, i7);
            }
        };
        this.pY = mVar;
        this.LU.c(mVar);
        this.LU.a(new c.e() { // from class: com.kwad.components.ad.reward.m.d.3
            @Override // com.kwad.sdk.core.video.a.c.e
            public final void a(com.kwad.sdk.core.video.a.c cVar) {
                try {
                    com.kwad.sdk.core.c.b.Ho();
                    if (com.kwad.sdk.core.c.b.isAppOnForeground()) {
                        d.this.LU.start();
                    }
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        });
        this.LU.start();
        com.kwad.components.core.t.a.aC(this.mContext).a(this.Bm);
    }

    public final void kT() {
        Iterator<Object> it = this.Bl.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    @Override // com.kwad.components.ad.k.b, com.kwad.components.ad.k.a
    public final void pause() {
        if (!this.Bi.get() || this.LU == null || kU()) {
            return;
        }
        super.pause();
    }

    @Override // com.kwad.components.ad.k.a
    public final void setAudioEnabled(boolean z5, boolean z6) {
        this.pW = z5;
        if (!this.Bi.get() || this.LU == null) {
            return;
        }
        if (z5 && z6) {
            com.kwad.components.core.t.a.aC(this.mContext).aQ(true);
        }
        this.LU.setAudioEnabled(z5);
    }

    @Override // com.kwad.components.ad.k.a
    @Deprecated
    public final void skipToEnd() {
        com.kwad.components.core.video.b bVar;
        if (!this.Bi.get() || (bVar = this.LU) == null) {
            return;
        }
        bVar.onPlayStateChanged(9);
        stop();
    }

    private void bs() {
        if (kU()) {
            return;
        }
        this.LU.a(new b.a(this.mAdTemplate).dg(this.Bh).dh(h.b(com.kwad.sdk.core.response.b.e.em(this.mAdTemplate))).a(this.mVideoPlayerStatus).b(com.kwad.sdk.contentalliance.a.a.a.bQ(this.mAdTemplate)).El(), this.mDetailVideoView);
        KsVideoPlayConfig ksVideoPlayConfig = this.mVideoPlayConfig;
        if (ksVideoPlayConfig != null) {
            setAudioEnabled(ksVideoPlayConfig.isVideoSoundEnable(), false);
        }
        this.LU.prepareAsync();
    }

    private String getVideoUrl() {
        if (kU()) {
            return "";
        }
        return k.g(this.mContext, this.mAdTemplate);
    }

    private void stop() {
        pause();
        this.ng = true;
    }

    public final void a(i.a aVar) {
        this.Bk.add(aVar);
    }

    @Override // com.kwad.components.ad.reward.g.a
    public final void hf() {
        pause();
    }

    @Override // com.kwad.components.ad.k.b, com.kwad.components.ad.k.a
    @MainThread
    public final void release() {
        super.release();
        com.kwad.components.core.t.a.aC(this.mContext).b(this.Bm);
    }
}
