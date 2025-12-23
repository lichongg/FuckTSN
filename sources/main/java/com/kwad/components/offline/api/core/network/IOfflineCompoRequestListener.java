package com.kwad.components.offline.api.core.network;

import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.components.offline.api.core.network.IOfflineCompoRequest;
import com.kwad.components.offline.api.core.network.model.BaseOfflineCompoResultData;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public interface IOfflineCompoRequestListener<R extends IOfflineCompoRequest, T extends BaseOfflineCompoResultData> {
    @WorkerThread
    void onError(@NonNull R r5, int i6, String str);

    @WorkerThread
    void onStartRequest(@NonNull R r5);

    @WorkerThread
    void onSuccess(@NonNull R r5, @NonNull T t5);
}
