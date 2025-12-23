package com.kwad.components.offline.b;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.core.o.b.a.l;
import com.kwad.components.offline.api.adWaynePlayer.IAdWaynePlayerOfflineCompo;
import com.kwad.components.offline.api.adWaynePlayer.IAdWaynePlayerOfflineCompoInitConfig;
import com.kwad.components.offline.api.core.api.IOfflineCompoWrapper;
import com.kwad.components.offline.api.core.soloader.ISoLoader;
import com.kwad.components.offline.api.core.soloader.SoLoadListener;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class c implements IAdWaynePlayerOfflineCompoInitConfig {
    @Override // com.kwad.components.offline.api.adWaynePlayer.IAdWaynePlayerOfflineCompoInitConfig
    public final ISoLoader soLoader() {
        return new ISoLoader() { // from class: com.kwad.components.offline.b.c.1
            @Override // com.kwad.components.offline.api.core.soloader.ISoLoader
            public final void loadSo(Context context, @NonNull SoLoadListener soLoadListener) {
                com.kwad.components.offline.b.a.a.a(context, soLoadListener);
            }
        };
    }

    @Override // com.kwad.components.offline.api.IOfflineCompoInitConfig
    public final IOfflineCompoWrapper wrapper() {
        return new l(IAdWaynePlayerOfflineCompo.PACKAGE_NAME);
    }
}
