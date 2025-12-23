package com.kwad.components.offline.c;

import com.kwad.components.core.o.b.a.l;
import com.kwad.components.offline.api.core.api.IOfflineCompoWrapper;
import com.kwad.components.offline.api.obiwan.IObiwanOfflineCompo;
import com.kwad.components.offline.api.obiwan.IObiwanOfflineCompoInitConfig;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.be;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class d implements IObiwanOfflineCompoInitConfig {
    @Override // com.kwad.components.offline.api.obiwan.IObiwanOfflineCompoInitConfig
    public final long getLogObiwanStorageQuota() {
        com.kwad.sdk.components.d.f(DevelopMangerComponents.class);
        return e.a(com.kwad.sdk.core.config.c.aAy);
    }

    @Override // com.kwad.components.offline.api.obiwan.IObiwanOfflineCompoInitConfig
    public final boolean isLogObiwanEnableNow() {
        return e.a(com.kwad.sdk.core.config.c.aAw);
    }

    @Override // com.kwad.components.offline.api.obiwan.IObiwanOfflineCompoInitConfig
    public final boolean isLogObiwanRecordAll() {
        return e.a(com.kwad.sdk.core.config.c.aAx);
    }

    @Override // com.kwad.components.offline.api.IOfflineCompoInitConfig
    public final IOfflineCompoWrapper wrapper() {
        return new l(IObiwanOfflineCompo.PACKAGE_NAME);
    }

    @Override // com.kwad.components.offline.api.obiwan.IObiwanOfflineCompoInitConfig
    public final String getLogDirPath() {
        return be.dH(ServiceProvider.getContext()).getAbsolutePath();
    }

    @Override // com.kwad.components.offline.api.obiwan.IObiwanOfflineCompoInitConfig
    public final String getLogObiwanData() {
        return e.getLogObiwanData();
    }
}
