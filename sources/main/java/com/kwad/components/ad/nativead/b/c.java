package com.kwad.components.ad.nativead.b;

import android.view.View;
import com.kwad.components.core.video.l;
import com.kwad.components.core.video.m;
import java.util.List;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class c extends com.kwad.components.ad.nativead.a.a {
    private List<Integer> ck;
    private volatile boolean eE = false;

    /* JADX INFO: Access modifiers changed from: private */
    public void c(long j6) {
        int ceil = (int) Math.ceil(j6 / 1000.0f);
        List<Integer> list = this.ck;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (Integer num : this.ck) {
            if (ceil >= num.intValue()) {
                com.kwad.sdk.core.adlog.c.a(this.pq.mAdTemplate, ceil, (JSONObject) null);
                this.ck.remove(num);
                return;
            }
        }
    }

    @Override // com.kwad.components.ad.nativead.a.a, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        this.ck = com.kwad.sdk.core.response.b.a.bp(com.kwad.sdk.core.response.b.e.el(this.pq.mAdTemplate));
        m mVar = new m() { // from class: com.kwad.components.ad.nativead.b.c.1
            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlayCompleted() {
                com.kwad.sdk.core.adlog.c.bY(c.this.pq.mAdTemplate);
            }

            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlayProgress(long j6, long j7) {
                c.this.c(j7);
            }

            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlayStart() {
                c.this.eE = false;
                if (!c.this.pq.mAdTemplate.mPvReported) {
                    c.this.pq.oW.fr();
                }
                com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
                View view = (View) c.this.pq.f36338pl.getParent();
                if (view != null) {
                    bVar.w(view.getHeight(), view.getWidth());
                }
                com.kwad.components.core.t.b.sY().a(c.this.pq.mAdTemplate, null, bVar);
                com.kwad.sdk.core.adlog.c.bX(c.this.pq.mAdTemplate);
            }

            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlaying() {
                if (c.this.eE) {
                    return;
                }
                c.this.eE = true;
                com.kwad.components.core.p.a.se().a(c.this.pq.mAdTemplate, System.currentTimeMillis(), 1);
            }
        };
        this.mVideoPlayStateListener = mVar;
        this.pq.pr.b((l) mVar);
    }
}
