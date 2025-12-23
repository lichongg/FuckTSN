package com.kwad.components.offline.d.a;

import com.kwad.components.offline.api.tk.IOfflineTKRenderListener;
import com.kwad.sdk.components.s;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class h implements IOfflineTKRenderListener {
    private final s akH;

    @Override // com.kwad.components.offline.api.tk.IOfflineTKRenderListener
    public final void onFailed(Throwable th) {
        s sVar = this.akH;
        if (sVar != null) {
            sVar.onFailed(th);
        }
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineTKRenderListener
    public final void onSuccess() {
        s sVar = this.akH;
        if (sVar != null) {
            sVar.onSuccess();
        }
    }

    public h(s sVar) {
        this.akH = sVar;
    }
}
