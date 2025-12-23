package com.kwad.components.offline.b;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.offline.api.adWaynePlayer.IAdWaynePlayerOfflineCompo;
import com.kwad.components.offline.api.core.adWaynePlayer.IAdWaynePlayerPlayModule;
import com.kwad.sdk.service.ServiceProvider;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class a implements com.kwad.components.core.o.a.a.a {
    private final IAdWaynePlayerOfflineCompo ajF;

    @Override // com.kwad.sdk.components.b
    public final Class<a> getComponentsType() {
        return a.class;
    }

    @Override // com.kwad.sdk.components.b
    public final int priority() {
        return this.ajF.priority();
    }

    @Override // com.kwad.components.core.o.a.a.a
    public final boolean qt() {
        return this.ajF.getState() == IAdWaynePlayerOfflineCompo.AdWaynePlayerState.READY;
    }

    public a(@NonNull IAdWaynePlayerOfflineCompo iAdWaynePlayerOfflineCompo) {
        this.ajF = iAdWaynePlayerOfflineCompo;
    }

    @Override // com.kwad.components.core.o.a.a.a
    public final IAdWaynePlayerPlayModule getAdWaynePlayerPlayModule(String str, boolean z5) {
        if (!qt()) {
            return null;
        }
        try {
            return this.ajF.getAdWaynePlayerPlayModule(str, z5);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
            return null;
        }
    }

    @Override // com.kwad.sdk.components.b
    public final void init(Context context) {
    }
}
