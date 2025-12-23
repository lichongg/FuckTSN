package com.kwad.components.offline.api.core.network;

import androidx.annotation.NonNull;
import com.kwad.components.offline.api.core.network.IOfflineCompoRequest;
import com.kwad.components.offline.api.core.network.model.BaseOfflineCompoResultData;
import com.kwad.sdk.core.network.c;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public interface IOfflineCompoNetworking<R extends IOfflineCompoRequest, T extends BaseOfflineCompoResultData> {
    void cancel();

    @NonNull
    R createRequest();

    boolean enableMonitorReport();

    boolean isPostByJson();

    void onResponse(R r5, c cVar);

    void request(@NonNull IOfflineCompoRequestListener<R, T> iOfflineCompoRequestListener);
}
