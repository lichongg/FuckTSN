package com.kwad.components.offline.api.core.network;

import androidx.annotation.NonNull;
import com.kwad.components.offline.api.core.network.IOfflineCompoRequest;
import com.kwad.components.offline.api.core.network.adapter.NormalNetworkingAdapter;
import com.kwad.components.offline.api.core.network.adapter.NormalRequestListenerAdapter;
import com.kwad.components.offline.api.core.network.model.NormalOfflineCompoResultData;
import com.kwad.sdk.core.network.c;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public abstract class OfflineCompoNormalNetworking<R extends IOfflineCompoRequest, T extends NormalOfflineCompoResultData> implements IOfflineCompoNetworking<R, T> {
    private NormalNetworkingAdapter<R, T> mNetworking = new NormalNetworkingAdapter<>(this);

    public abstract T createResponseData();

    @Override // com.kwad.components.offline.api.core.network.IOfflineCompoNetworking
    public boolean enableMonitorReport() {
        return false;
    }

    @Override // com.kwad.components.offline.api.core.network.IOfflineCompoNetworking
    public boolean isPostByJson() {
        return false;
    }

    @Override // com.kwad.components.offline.api.core.network.IOfflineCompoNetworking
    public void cancel() {
        this.mNetworking.cancel();
    }

    @Override // com.kwad.components.offline.api.core.network.IOfflineCompoNetworking
    public void request(@NonNull IOfflineCompoRequestListener<R, T> iOfflineCompoRequestListener) {
        this.mNetworking.request(new NormalRequestListenerAdapter(iOfflineCompoRequestListener));
    }

    @Override // com.kwad.components.offline.api.core.network.IOfflineCompoNetworking
    public void onResponse(R r5, c cVar) {
    }
}
