package com.kwad.components.offline.d.a;

import com.kwad.components.offline.api.tk.IOfflineTKCallHandler;
import com.kwad.sdk.components.q;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class g implements IOfflineTKCallHandler {
    private final q akG;

    @Override // com.kwad.components.offline.api.tk.IOfflineTKCallHandler
    public final void callJS(String str) {
        q qVar = this.akG;
        if (qVar != null) {
            qVar.callJS(str);
        }
    }

    public g(q qVar) {
        this.akG = qVar;
    }
}
