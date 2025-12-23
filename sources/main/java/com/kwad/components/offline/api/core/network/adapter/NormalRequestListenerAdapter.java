package com.kwad.components.offline.api.core.network.adapter;

import androidx.annotation.NonNull;
import com.kwad.components.offline.api.core.network.IOfflineCompoRequest;
import com.kwad.components.offline.api.core.network.IOfflineCompoRequestListener;
import com.kwad.components.offline.api.core.network.model.NormalOfflineCompoResultData;
import com.kwad.sdk.core.network.g;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class NormalRequestListenerAdapter<R extends IOfflineCompoRequest, T extends NormalOfflineCompoResultData> implements g<NormalRequestAdapter<R>, NormalResultDataAdapter<T>> {
    private final IOfflineCompoRequestListener<R, T> mRequestListener;

    @Override // com.kwad.sdk.core.network.g
    public void onError(@NonNull NormalRequestAdapter<R> normalRequestAdapter, int i6, String str) {
        this.mRequestListener.onError(normalRequestAdapter.getOfflineCompoRequest(), i6, str);
    }

    @Override // com.kwad.sdk.core.network.g
    public void onStartRequest(@NonNull NormalRequestAdapter<R> normalRequestAdapter) {
        this.mRequestListener.onStartRequest(normalRequestAdapter.getOfflineCompoRequest());
    }

    @Override // com.kwad.sdk.core.network.g
    public void onSuccess(@NonNull NormalRequestAdapter<R> normalRequestAdapter, @NonNull NormalResultDataAdapter<T> normalResultDataAdapter) {
        this.mRequestListener.onSuccess(normalRequestAdapter.getOfflineCompoRequest(), normalResultDataAdapter.getOfflineCompoResultData());
    }

    public NormalRequestListenerAdapter(IOfflineCompoRequestListener<R, T> iOfflineCompoRequestListener) {
        this.mRequestListener = iOfflineCompoRequestListener;
    }
}
