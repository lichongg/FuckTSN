package com.kwad.components.ad.reward.k.a;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.c.f;
import com.kwad.components.core.webview.jshandler.j;
import com.kwad.components.core.webview.jshandler.p;
import com.kwad.components.core.webview.tachikoma.i;
import com.kwad.sdk.components.t;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class c extends com.kwad.components.core.webview.tachikoma.d.c implements e {
    private a AQ;

    public final void a(com.kwad.components.ad.reward.c.b bVar) {
        a aVar = this.AQ;
        if (aVar != null) {
            aVar.b(bVar);
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.d.a
    public final i iY() {
        this.AQ = (a) this.ahp;
        return new d(this.AQ.ks(), this.AQ.AO, getContext());
    }

    @Override // com.kwad.components.core.webview.tachikoma.d.a, com.kwad.components.core.webview.tachikoma.j
    public final void a(@Nullable com.kwad.sdk.core.webview.d.b.a aVar) {
        super.a(aVar);
        a aVar2 = this.AQ;
        if (aVar2 == null || aVar2.ks() == null) {
            return;
        }
        this.AQ.ks().rD.cW();
    }

    @Override // com.kwad.components.core.webview.tachikoma.d.a, com.kwad.components.core.webview.tachikoma.j
    public final void a(t tVar, com.kwad.sdk.core.webview.b bVar) {
        super.a(tVar, bVar);
        tVar.c(new f(new com.kwad.components.ad.reward.c.d() { // from class: com.kwad.components.ad.reward.k.a.c.1
            @Override // com.kwad.components.ad.reward.c.d
            public final void a(com.kwad.components.ad.reward.c.b bVar2) {
                com.kwad.sdk.core.d.c.d("RewardTKDialogFragmentPresenter", "onUpdateExtraReward : " + bVar2.hY());
                c.this.a(bVar2);
            }
        }));
        tVar.c(new j(new p() { // from class: com.kwad.components.ad.reward.k.a.c.2
            @Override // com.kwad.components.core.webview.jshandler.p
            public final void a(j jVar, String str) {
                if (TextUtils.equals(str, "getExtraReward")) {
                    jVar.a(com.kwad.components.ad.reward.c.a.hV().hW());
                    com.kwad.components.ad.reward.c.a.hV().a(jVar);
                }
            }
        }));
    }
}
