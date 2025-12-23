package com.kwad.components.offline.api.tk.jsbridge;

import androidx.annotation.NonNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public interface IOfflineCompoBridgeHandler {
    @NonNull
    String getKey();

    void handleJsCall(String str, @NonNull IOfflineCompoCallBackFunction iOfflineCompoCallBackFunction);

    void onDestroy();
}
