package com.kwad.components.offline.d.a;

import com.kwad.components.offline.api.tk.IOfflineApkLoader;
import com.kwad.components.offline.api.tk.IOfflineApkLoaderHolder;
import com.kwad.sdk.components.k;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class e implements IOfflineApkLoaderHolder {
    private k afU;

    @Override // com.kwad.components.offline.api.tk.IOfflineApkLoaderHolder
    public final IOfflineApkLoader getApkLoader(int i6) {
        return new d(this.afU.bi(i6));
    }

    public e(k kVar) {
        this.afU = kVar;
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineApkLoaderHolder
    public final IOfflineApkLoader getApkLoader(String str) {
        return new d(this.afU.bf(str));
    }
}
