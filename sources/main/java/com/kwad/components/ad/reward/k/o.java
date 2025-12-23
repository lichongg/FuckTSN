package com.kwad.components.ad.reward.k;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.webview.jshandler.as;
import com.kwad.components.core.webview.tachikoma.b.w;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class o extends w implements as.b {

    @Nullable
    private com.kwad.components.core.playable.a rF;

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "registerPlayableStatusListener";
    }

    public o(com.kwad.components.ad.reward.g gVar) {
        com.kwad.components.core.playable.a aVar = gVar.rF;
        this.rF = aVar;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    @Override // com.kwad.components.core.webview.jshandler.as.b
    public final void a(as.a aVar) {
        b(aVar);
    }

    @Override // com.kwad.components.core.webview.tachikoma.b.w, com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        super.onDestroy();
        com.kwad.components.core.playable.a aVar = this.rF;
        if (aVar != null) {
            aVar.b(this);
            this.rF = null;
        }
    }
}
