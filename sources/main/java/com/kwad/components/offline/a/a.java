package com.kwad.components.offline.a;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.offline.api.adLive.IAdLiveOfflineCompo;
import com.kwad.components.offline.api.core.adlive.IAdLiveEndRequest;
import com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView;
import com.kwad.components.offline.api.core.adlive.IAdLivePlayModule;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class a implements com.kwad.components.core.o.a.b.a {
    private final IAdLiveOfflineCompo ajt;

    @Override // com.kwad.components.core.o.a.b.a
    public final IAdLiveEndRequest getAdLiveEndRequest(String str) {
        return this.ajt.getAdLiveEndRequest(str);
    }

    @Override // com.kwad.components.core.o.a.b.a
    public final IAdLivePlayModule getAdLivePlayModule(IAdLiveOfflineView iAdLiveOfflineView, String str, String str2, String str3, long j6) {
        return this.ajt.getAdLivePlayModule(iAdLiveOfflineView, str, str2, str3, j6);
    }

    @Override // com.kwad.sdk.components.b
    public final Class<a> getComponentsType() {
        return a.class;
    }

    @Override // com.kwad.components.core.o.a.b.a
    public final IAdLiveOfflineView getView(Context context, int i6) {
        return this.ajt.getView(context, i6);
    }

    @Override // com.kwad.sdk.components.b
    public final int priority() {
        return this.ajt.priority();
    }

    @Override // com.kwad.components.core.o.a.b.a
    public final boolean qu() {
        return this.ajt.getState() == IAdLiveOfflineCompo.AdLiveState.READY;
    }

    public a(@NonNull IAdLiveOfflineCompo iAdLiveOfflineCompo) {
        this.ajt = iAdLiveOfflineCompo;
    }

    @Override // com.kwad.sdk.components.b
    public final void init(Context context) {
    }
}
