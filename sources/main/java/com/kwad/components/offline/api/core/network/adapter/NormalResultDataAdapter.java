package com.kwad.components.offline.api.core.network.adapter;

import com.kwad.components.offline.api.core.network.model.NormalOfflineCompoResultData;
import com.kwad.sdk.core.network.NormalResultData;
import com.kwad.sdk.core.network.c;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class NormalResultDataAdapter<T extends NormalOfflineCompoResultData> extends NormalResultData {
    private final T mOfflineCompoResultData;

    public T getOfflineCompoResultData() {
        return this.mOfflineCompoResultData;
    }

    public NormalResultDataAdapter(T t5) {
        this.mOfflineCompoResultData = t5;
    }

    @Override // com.kwad.sdk.core.network.NormalResultData
    public void parseResponse(c cVar) {
        super.parseResponse(cVar);
        this.mOfflineCompoResultData.parseResponse(cVar);
    }
}
