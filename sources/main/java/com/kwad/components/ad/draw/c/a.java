package com.kwad.components.ad.draw.c;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.ad.k.b;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.video.l;
import com.kwad.components.core.video.m;
import com.kwad.sdk.contentalliance.a.a.b;
import com.kwad.sdk.core.j.c;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.b.h;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.a.c;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.n;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a extends b {
    private long ff;
    private com.kwad.components.core.widget.a.b fg;
    private com.kwad.sdk.contentalliance.a.a.a fh;
    private boolean fi;
    private boolean fj;
    private int fk;
    public boolean fl;
    public int fm;
    private boolean fn;
    private final c fo;
    private Context mContext;

    public final void bq() {
        this.fh = null;
        this.fg.b(this.fo);
        this.LU.release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bp() {
        int i6 = this.fm;
        if (i6 == 1) {
            return true;
        }
        if (i6 != 2) {
            return this.fl;
        }
        return false;
    }

    private void bs() {
        this.LU.a(new b.a(this.mAdTemplate).dg(e.en(this.mAdTemplate)).dh(h.b(e.em(this.mAdTemplate))).a(this.mAdTemplate.mVideoPlayerStatus).b(new com.kwad.sdk.contentalliance.a.a.a(this.mAdTemplate, System.currentTimeMillis())).El(), this.mDetailVideoView);
        this.LU.prepareAsync();
        if (this.fk != -1 || this.fj) {
            setVideoSound(!this.fj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void start(long j6) {
        if (this.fg.ae() && bp() && !this.fn) {
            this.LU.a(new com.kwad.sdk.contentalliance.a.a.a(this.mAdTemplate, j6));
            this.LU.start();
        }
    }

    public final void bo() {
        long eN = n.eN(this.mAdTemplate);
        if (this.LU.tz() == null) {
            bs();
        }
        start(eN);
        this.fg.a(this.fo);
        b((l) new m() { // from class: com.kwad.components.ad.draw.c.a.2
            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlayCompleted() {
                a.a(a.this, true);
            }
        });
    }

    public final boolean br() {
        return this.fn;
    }

    public final void g(boolean z5) {
        this.fi = z5;
    }

    public final void setVideoSound(boolean z5) {
        com.kwad.components.core.video.b bVar = this.LU;
        if (bVar == null) {
            return;
        }
        if (z5) {
            bVar.setVolume(1.0f, 1.0f);
            this.fj = false;
        } else {
            bVar.setVolume(0.0f, 0.0f);
            this.fj = true;
        }
        this.fk = 1;
    }

    public a(@NonNull AdTemplate adTemplate, @NonNull com.kwad.components.core.widget.a.b bVar, @NonNull DetailVideoView detailVideoView) {
        super(adTemplate, detailVideoView);
        this.fj = false;
        this.fk = -1;
        this.fl = true;
        this.fm = 0;
        this.fo = new c() { // from class: com.kwad.components.ad.draw.c.a.3
            @Override // com.kwad.sdk.core.j.c
            public final void bt() {
                if (a.this.fh == null) {
                    a aVar = a.this;
                    aVar.fh = com.kwad.sdk.contentalliance.a.a.a.bQ(aVar.mAdTemplate);
                    a.this.LU.a(a.this.fh);
                }
                if (a.this.fn || a.this.fi || !a.this.bp()) {
                    return;
                }
                a.this.resume();
            }

            @Override // com.kwad.sdk.core.j.c
            public final void bu() {
                a.this.pause();
            }
        };
        this.ff = com.kwad.sdk.core.response.b.a.ab(e.el(this.mAdTemplate));
        this.fg = bVar;
        this.mContext = detailVideoView.getContext();
        bs();
        if (com.kwad.sdk.core.response.b.a.cb(e.el(this.mAdTemplate))) {
            this.LU.setVolume(0.0f, 0.0f);
            this.fj = true;
        }
        this.LU.a(new c.e() { // from class: com.kwad.components.ad.draw.c.a.1
            @Override // com.kwad.sdk.core.video.a.c.e
            public final void a(com.kwad.sdk.core.video.a.c cVar) {
                try {
                    a.this.start(n.eN(a.this.mAdTemplate));
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        });
    }

    @Override // com.kwad.components.ad.k.b, com.kwad.components.ad.k.a
    public final void resume() {
        super.resume();
        com.kwad.components.core.t.a.aC(this.mContext).aQ(false);
    }

    static /* synthetic */ boolean a(a aVar, boolean z5) {
        aVar.fn = true;
        return true;
    }
}
