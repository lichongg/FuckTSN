package com.kwad.components.core.o.b.a;

import android.text.TextUtils;
import com.kwad.components.offline.api.core.api.ICache;
import com.kwad.sdk.service.ServiceProvider;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
final class b implements ICache {
    b() {
    }

    @Override // com.kwad.components.offline.api.core.api.ICache
    public final String getPreCacheUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return com.kwad.components.core.video.k.h(ServiceProvider.getContext(), str);
    }
}
