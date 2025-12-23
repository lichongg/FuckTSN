package com.kwad.sdk;

import androidx.annotation.NonNull;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.export.proxy.AdHttpProxy;
import java.util.Random;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class g {
    private static AdHttpProxy asa;

    @NonNull
    public static AdHttpProxy AI() {
        AdHttpProxy adHttpProxy = asa;
        if (adHttpProxy != null) {
            return adHttpProxy;
        }
        if (com.kwad.framework.a.a.oz.booleanValue()) {
            return AJ();
        }
        try {
            if (com.kwad.sdk.core.network.a.c.HD() != null) {
                asa = new com.kwad.sdk.core.network.c.b();
            } else {
                asa = new com.kwad.sdk.core.network.c.a();
            }
        } catch (Throwable unused) {
            asa = new com.kwad.sdk.core.network.c.a();
        }
        return asa;
    }

    private static AdHttpProxy AJ() {
        com.kwad.sdk.components.d.f(DevelopMangerComponents.class);
        return new Random().nextInt(5) != 0 ? new com.kwad.sdk.core.network.c.b() : new com.kwad.sdk.core.network.c.a();
    }
}
