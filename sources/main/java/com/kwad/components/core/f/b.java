package com.kwad.components.core.f;

import android.content.Context;
import com.kwad.components.offline.api.IOfflineCompo;
import com.kwad.sdk.core.a.d;
import com.kwad.sdk.core.a.e;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b implements e {
    @Override // com.kwad.sdk.components.b
    public final Class getComponentsType() {
        return e.class;
    }

    @Override // com.kwad.sdk.components.b
    public final int priority() {
        return IOfflineCompo.Priority.HIGHEST;
    }

    @Override // com.kwad.sdk.core.a.e
    public final String as(String str) {
        return d.as(str);
    }

    @Override // com.kwad.sdk.core.a.e
    public final String getResponseData(String str) {
        return d.getResponseData(str);
    }

    @Override // com.kwad.sdk.components.b
    public final void init(Context context) {
    }
}
