package com.kwad.components.ad.reward;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class j extends com.kwad.components.ad.l.b {

    @Nullable
    private com.kwad.components.ad.reward.c.d tc;
    private WeakReference<g> td;

    public j(g gVar, @Nullable JSONObject jSONObject, @Nullable String str) {
        super(jSONObject, null);
        this.td = new WeakReference<>(gVar);
    }

    public final void a(@Nullable com.kwad.components.ad.reward.c.d dVar) {
        this.tc = dVar;
    }

    @Override // com.kwad.components.ad.l.b
    public final void gv() {
        WeakReference<g> weakReference = this.td;
        com.kwad.components.ad.reward.monitor.c.a((weakReference != null ? weakReference.get() : null) != null, "end_card");
    }

    @Override // com.kwad.components.ad.l.b
    public final void gw() {
        WeakReference<g> weakReference = this.td;
        boolean z5 = (weakReference != null ? weakReference.get() : null) != null;
        AdTemplate adTemplate = this.mAdTemplate;
        com.kwad.components.ad.reward.monitor.c.a(adTemplate, z5, "end_card", K(adTemplate));
    }

    @Override // com.kwad.components.ad.l.b
    public final void gx() {
        WeakReference<g> weakReference = this.td;
        com.kwad.components.ad.reward.monitor.c.a((weakReference != null ? weakReference.get() : null) != null, "end_card", K(this.mAdTemplate), System.currentTimeMillis() - getLoadTime());
    }

    @Override // com.kwad.components.ad.l.b
    public final void a(com.kwad.components.core.webview.a aVar) {
        super.a(aVar);
        aVar.a(new com.kwad.components.ad.reward.i.b(this.eN.getContext(), this.mAdTemplate, PlayableSource.ENDCARD_CLICK));
        aVar.a(new com.kwad.components.ad.reward.c.f(new com.kwad.components.ad.reward.c.d() { // from class: com.kwad.components.ad.reward.j.1
            @Override // com.kwad.components.ad.reward.c.d
            public final void a(com.kwad.components.ad.reward.c.b bVar) {
                if (j.this.tc != null) {
                    j.this.tc.a(bVar);
                }
            }
        }));
        aVar.a(new com.kwad.components.core.webview.jshandler.j(new com.kwad.components.core.webview.jshandler.p() { // from class: com.kwad.components.ad.reward.j.2
            @Override // com.kwad.components.core.webview.jshandler.p
            public final void a(com.kwad.components.core.webview.jshandler.j jVar, String str) {
                if (TextUtils.equals(str, "getExtraReward")) {
                    jVar.a(com.kwad.components.ad.reward.c.a.hV().hW());
                }
            }
        }));
        WeakReference<g> weakReference = this.td;
        aVar.b(new com.kwad.components.ad.reward.k.p(weakReference != null ? weakReference.get() : null, "native_id", -1L, this.eQ));
    }
}
