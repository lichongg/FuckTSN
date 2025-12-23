package com.kwad.components.core.o.b.b;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.components.offline.api.core.adlive.IAdLiveEndRequest;
import com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView;
import com.kwad.components.offline.api.core.adlive.IAdLivePlayModule;
import com.kwad.components.offline.api.core.adlive.ILive;
import com.kwad.sdk.components.d;
import com.kwad.sdk.service.ServiceProvider;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a implements ILive {
    @Override // com.kwad.components.offline.api.core.adlive.ILive
    public final IAdLivePlayModule getAdLivePlayModule(IAdLiveOfflineView iAdLiveOfflineView, String str, String str2, String str3, long j6) {
        com.kwad.components.core.o.a.b.a aVar = (com.kwad.components.core.o.a.b.a) d.f(com.kwad.components.core.o.a.b.a.class);
        if (aVar == null || !aVar.qu()) {
            return null;
        }
        return aVar.getAdLivePlayModule(iAdLiveOfflineView, str, str2, str3, j6);
    }

    @Override // com.kwad.components.offline.api.core.adlive.ILive
    public final IAdLiveOfflineView getIAdLiveOfflineView(Context context, int i6) {
        com.kwad.components.core.o.a.b.a aVar = (com.kwad.components.core.o.a.b.a) d.f(com.kwad.components.core.o.a.b.a.class);
        if (aVar == null || !aVar.qu()) {
            return null;
        }
        try {
            return aVar.getView(context, i6);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
            return null;
        }
    }

    @Override // com.kwad.components.offline.api.core.adlive.ILive
    public final IAdLiveEndRequest mIAdLiveEndRequest(String str) {
        com.kwad.components.core.o.a.b.a aVar;
        if (!TextUtils.isEmpty(str) && (aVar = (com.kwad.components.core.o.a.b.a) d.f(com.kwad.components.core.o.a.b.a.class)) != null && aVar.qu()) {
            return aVar.getAdLiveEndRequest(str);
        }
        return null;
    }
}
