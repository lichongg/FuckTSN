package com.kwad.components.ad.reward.k;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.webview.jshandler.am;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class p extends am {
    private long AH;
    private String AI;
    private WeakReference<com.kwad.components.ad.reward.g> td;

    @Override // com.kwad.components.core.webview.jshandler.am
    public final void b(boolean z5, AdTemplate adTemplate, @Nullable JSONObject jSONObject, @Nullable com.kwad.sdk.core.adlog.c.b bVar) {
        com.kwad.components.ad.reward.j.b.a(z5, adTemplate, null, bVar);
    }

    private static boolean X(String str) {
        try {
            return new JSONObject(str).optInt("elementType") == 18;
        } catch (Exception unused) {
            return false;
        }
    }

    private boolean b(am.b bVar) {
        WeakReference<com.kwad.components.ad.reward.g> weakReference;
        if (bVar.getActionType() != 140 || !com.kwad.sdk.core.config.e.BP() || !X(bVar.uD()) || (weakReference = this.td) == null || weakReference.get() == null) {
            return false;
        }
        final com.kwad.components.ad.reward.g gVar = this.td.get();
        bw.runOnUiThreadDelay(new bg() { // from class: com.kwad.components.ad.reward.k.p.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                gVar.D(p.this.AI);
            }
        }, 1500L);
        return true;
    }

    @Override // com.kwad.components.core.webview.jshandler.am
    public final void a(@NonNull am.b bVar) {
        if (b(bVar)) {
            return;
        }
        super.a(bVar);
    }

    public p(com.kwad.components.ad.reward.g gVar, String str, long j6, com.kwad.sdk.core.webview.b bVar) {
        super(bVar);
        this.AI = str;
        this.AH = j6;
        if (gVar != null) {
            this.td = new WeakReference<>(gVar);
        }
    }

    @Override // com.kwad.components.core.webview.jshandler.am
    public final void a(com.kwad.sdk.core.adlog.c.b bVar) {
        super.a(bVar);
        WeakReference<com.kwad.components.ad.reward.g> weakReference = this.td;
        if (weakReference != null && weakReference.get() != null) {
            bVar.aw(this.td.get().rE.getPlayDuration());
            return;
        }
        long j6 = this.AH;
        if (j6 > 0) {
            bVar.aw(j6);
        }
    }
}
