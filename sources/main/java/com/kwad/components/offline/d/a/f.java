package com.kwad.components.offline.d.a;

import com.kwad.components.offline.api.tk.jsbridge.IOfflineCompoTKBridgeHandler;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class f implements IOfflineCompoTKBridgeHandler {
    private final com.kwad.sdk.core.webview.c.g akF;

    @Override // com.kwad.components.offline.api.tk.jsbridge.IOfflineCompoTKBridgeHandler
    public final void callTKBridge(String str) {
        com.kwad.sdk.core.webview.c.g gVar = this.akF;
        if (gVar != null) {
            gVar.callTKBridge(str);
        }
    }

    f(com.kwad.sdk.core.webview.c.g gVar) {
        this.akF = gVar;
    }
}
