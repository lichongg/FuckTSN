package com.kwad.components.ad.reward.m;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.g;
import com.kwad.components.core.video.m;
import com.kwad.sdk.utils.i;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class e {

    @Nullable
    private com.kwad.components.ad.reward.f.a Bp;

    @Nullable
    private d Bq;

    @Nullable
    private b Br;

    @NonNull
    private com.kwad.components.ad.k.a Bs;
    private g tm;
    private int Bo = 0;
    private int Bt = 0;
    private List<m> Bu = new CopyOnWriteArrayList();

    public final void a(int i6, com.kwad.components.ad.k.a aVar) {
        this.Bo = i6;
        if (i6 == 1) {
            this.Bq = (d) aVar;
        } else if (i6 == 2) {
            this.Bp = (com.kwad.components.ad.reward.f.a) aVar;
        } else if (i6 == 3) {
            this.Br = (b) aVar;
        }
        this.Bs = aVar;
        Iterator<m> it = this.Bu.iterator();
        while (it.hasNext()) {
            this.Bs.b(it.next());
        }
        this.Bu.clear();
    }

    public final void b(@Nullable m mVar) {
        kV().a(mVar);
        if (mVar != null) {
            this.Bu.remove(mVar);
        }
    }

    private com.kwad.components.ad.k.a kV() {
        return this.Bs;
    }

    public final void kS() {
        d dVar = this.Bq;
        if (dVar != null) {
            dVar.kS();
        } else {
            b bVar = this.Br;
            if (bVar != null) {
                bVar.kS();
            }
        }
        this.tm.gH();
    }

    public final void kT() {
        d dVar = this.Bq;
        if (dVar != null) {
            dVar.kT();
        }
    }

    public final boolean kW() {
        return this.Bp != null;
    }

    @Nullable
    public final com.kwad.components.ad.reward.f.a kX() {
        return this.Bp;
    }

    @Nullable
    public final b kY() {
        return this.Br;
    }

    public final void setAudioEnabled(boolean z5, boolean z6) {
        this.Bt = z5 ? 2 : 1;
        kV().setAudioEnabled(z5, z6);
    }

    public e(g gVar) {
        this.tm = gVar;
        this.Bs = new a(gVar.mAdTemplate);
    }

    public final void b(i.a aVar) {
        d dVar = this.Bq;
        if (dVar != null) {
            dVar.b(aVar);
        }
    }

    public final long getPlayDuration() {
        return kV().getPlayDuration();
    }

    public final void pause() {
        kV().pause();
    }

    public final void release() {
        kV().release();
    }

    public final void resume() {
        int i6;
        boolean z5;
        kV().resume();
        com.kwad.components.ad.reward.f.a aVar = this.Bp;
        if (aVar != null && (i6 = this.Bt) > 0) {
            if (i6 == 2) {
                z5 = true;
            } else {
                z5 = false;
            }
            aVar.setAudioEnabled(z5, false);
        }
    }

    public final void skipToEnd() {
        kV().skipToEnd();
    }

    public final void a(@Nullable m mVar) {
        if (kV().kR()) {
            this.Bu.add(mVar);
        } else {
            kV().b(mVar);
        }
    }

    public final void a(i.a aVar) {
        d dVar = this.Bq;
        if (dVar != null) {
            dVar.a(aVar);
        }
    }
}
