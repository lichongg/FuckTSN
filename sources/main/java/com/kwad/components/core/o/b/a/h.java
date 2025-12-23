package com.kwad.components.core.o.b.a;

import android.content.Context;
import com.kwad.components.offline.api.core.api.INet;
import com.kwad.sdk.core.network.idc.DomainException;
import com.kwad.sdk.utils.ao;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
final class h implements INet {
    h() {
    }

    @Override // com.kwad.components.offline.api.core.api.INet
    public final int getActiveNetworkType(Context context) {
        return ao.getActiveNetworkType(context);
    }

    @Override // com.kwad.components.offline.api.core.api.INet
    public final String getCurrHost(@INet.HostType String str, String str2) {
        return com.kwad.sdk.core.network.idc.a.HF().W(str, str2);
    }

    @Override // com.kwad.components.offline.api.core.api.INet
    public final void handleSwitchHost(String str, @INet.HostType String str2, int i6, Throwable th) {
        com.kwad.sdk.core.network.idc.a.HF().a(str, str2, new DomainException(i6, th));
    }

    @Override // com.kwad.components.offline.api.core.api.INet
    public final boolean isMobileConnected(Context context) {
        return ao.isMobileConnected(context);
    }

    @Override // com.kwad.components.offline.api.core.api.INet
    public final boolean isNetworkConnected(Context context) {
        return ao.isNetworkConnected(context);
    }

    @Override // com.kwad.components.offline.api.core.api.INet
    public final boolean isWifiConnected(Context context) {
        return ao.isWifiConnected(context);
    }
}
