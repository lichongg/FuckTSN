package com.kwad.components.ad.j;

import android.content.Context;
import androidx.annotation.Nullable;
import com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView;
import com.kwad.sdk.service.ServiceProvider;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class c {
    @Nullable
    public static IAdLiveOfflineView a(com.kwad.components.core.o.a.b.a aVar, Context context, int i6) {
        try {
            return aVar.getView(context, i6);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTrace(th);
            ServiceProvider.reportSdkCaughtException(th);
            return null;
        }
    }
}
