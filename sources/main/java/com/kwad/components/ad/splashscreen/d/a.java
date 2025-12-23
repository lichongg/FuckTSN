package com.kwad.components.ad.splashscreen.d;

import android.content.Context;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.kwad.components.ad.k.b;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.contentalliance.a.a.b;
import com.kwad.sdk.core.j.c;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.b.h;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
import com.kwad.sdk.core.video.a.c;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bz;
import com.kwad.sdk.utils.i;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a extends b implements c {
    private String Bh;
    private final List<i.a> Bk;
    private OfflineOnAudioConflictListener Bm;
    public int Gl;
    private boolean Jl;
    public long Jm;
    private Context mContext;
    private KsVideoPlayConfig mVideoPlayConfig;
    private VideoPlayerStatus mVideoPlayerStatus;
    private boolean pW;

    public final void ag(boolean z5) {
        this.Jl = true;
    }

    private void bs() {
        com.kwad.sdk.contentalliance.a.a.b El = new b.a(this.mAdTemplate).a(this.mVideoPlayerStatus).dg(this.Bh).dh(h.b(e.em(this.mAdTemplate))).b(com.kwad.sdk.contentalliance.a.a.a.bQ(this.mAdTemplate)).El();
        this.Jm = SystemClock.elapsedRealtime();
        com.kwad.components.ad.splashscreen.monitor.b.lZ();
        com.kwad.components.ad.splashscreen.monitor.b.e(this.mAdTemplate, 1, this.Gl);
        this.LU.a(El, this.mDetailVideoView);
        KsVideoPlayConfig ksVideoPlayConfig = this.mVideoPlayConfig;
        if (ksVideoPlayConfig != null) {
            setAudioEnabled(ksVideoPlayConfig.isVideoSoundEnable(), false);
        }
        this.LU.prepareAsync();
    }

    public final void a(i.a aVar) {
        this.Bk.add(aVar);
    }

    public final void b(i.a aVar) {
        this.Bk.remove(aVar);
    }

    public final long getCurrentPosition() {
        return this.LU.getCurrentPosition();
    }

    public final void nk() {
        if (this.LU.tz() == null) {
            bs();
        }
        this.LU.start();
    }

    @Override // com.kwad.components.ad.k.a
    public final void setAudioEnabled(boolean z5, boolean z6) {
        this.pW = z5;
        if (z5 && z6) {
            com.kwad.components.core.t.a.aC(this.mContext).aQ(true);
        }
        this.LU.setAudioEnabled(z5);
    }

    public a(@NonNull AdTemplate adTemplate, @NonNull final DetailVideoView detailVideoView, KsVideoPlayConfig ksVideoPlayConfig) {
        super(adTemplate, detailVideoView);
        int i6;
        this.Bk = new ArrayList();
        this.Bm = new OfflineOnAudioConflictListener() { // from class: com.kwad.components.ad.splashscreen.d.a.1
            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeOccupied() {
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
        this.mVideoPlayConfig = ksVideoPlayConfig;
        this.mContext = detailVideoView.getContext();
        String aZ = com.kwad.sdk.core.response.b.a.aZ(e.el(adTemplate));
        this.mVideoPlayerStatus = adTemplate.mVideoPlayerStatus;
        e.el(adTemplate);
        if (com.kwad.components.ad.splashscreen.h.ac(adTemplate)) {
            i6 = 2;
        } else {
            i6 = 1;
        }
        this.Gl = i6;
        File cf = com.kwad.sdk.core.diskcache.b.a.GP().cf(aZ);
        if (cf != null && cf.exists()) {
            this.Bh = cf.getAbsolutePath();
        }
        this.LU.a(new c.e() { // from class: com.kwad.components.ad.splashscreen.d.a.2
            @Override // com.kwad.sdk.core.video.a.c.e
            public final void a(com.kwad.sdk.core.video.a.c cVar) {
                com.kwad.sdk.core.d.c.d("SplashPlayModule", " onPrepared");
                detailVideoView.post(new bg() { // from class: com.kwad.components.ad.splashscreen.d.a.2.1
                    @Override // com.kwad.sdk.utils.bg
                    public final void doTask() {
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        com.kwad.components.ad.splashscreen.monitor.b.lZ();
                        AdTemplate adTemplate2 = a.this.mAdTemplate;
                        a aVar = a.this;
                        com.kwad.components.ad.splashscreen.monitor.b.a(adTemplate2, 1, aVar.Gl, 2, elapsedRealtime - aVar.Jm, elapsedRealtime - aVar.mAdTemplate.showTime);
                        boolean a6 = bz.a(detailVideoView, 50, true);
                        com.kwad.sdk.core.d.c.d("SplashPlayModule", " onPrepared" + a6);
                        if (a6) {
                            a.this.LU.start();
                        }
                    }
                });
            }
        });
        com.kwad.components.core.t.a.aC(this.mContext).a(this.Bm);
    }

    @Override // com.kwad.sdk.core.j.c
    public final void bt() {
        resume();
    }

    @Override // com.kwad.sdk.core.j.c
    public final void bu() {
        pause();
    }

    @Override // com.kwad.components.ad.k.b, com.kwad.components.ad.k.a
    public final void release() {
        super.release();
        com.kwad.components.core.t.a.aC(this.mContext).b(this.Bm);
    }

    @Override // com.kwad.components.ad.k.b, com.kwad.components.ad.k.a
    public final void resume() {
        super.resume();
        if (this.pW && this.Jl) {
            com.kwad.components.core.t.a.aC(this.mContext).aQ(false);
            if (com.kwad.components.core.t.a.aC(this.mContext).sW()) {
                this.pW = false;
                setAudioEnabled(false, false);
            }
        }
    }
}
