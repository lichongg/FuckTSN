package com.kwad.components.ad;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.ad.adbit.c;
import com.kwad.components.core.c.g;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.components.d;
import com.kwad.sdk.core.network.e;
import com.kwad.sdk.l;
import com.kwad.sdk.service.ServiceProvider;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class KsAdLoadManager {
    private volatile boolean bA;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    enum Holder {
        INSTANCE;

        private final KsAdLoadManager mInstance = new KsAdLoadManager(0);

        Holder() {
        }
    }

    /* synthetic */ KsAdLoadManager(byte b6) {
        this();
    }

    private static boolean b(com.kwad.components.core.request.model.a aVar) {
        try {
            d.f(DevelopMangerComponents.class);
            return false;
        } catch (Exception e6) {
            ServiceProvider.reportSdkCaughtException(e6);
            return false;
        }
    }

    public final void a(@NonNull com.kwad.components.core.request.model.a aVar) {
        if (!l.Cf().CG()) {
            e eVar = e.aEn;
            com.kwad.components.core.request.model.a.a(aVar, eVar.errorCode, eVar.msg, true);
        } else {
            if (c.c(aVar) || b(aVar)) {
                return;
            }
            if (!this.bA) {
                N();
                this.bA = true;
            }
            com.kwad.components.core.c.d.od().d(aVar);
        }
    }

    private KsAdLoadManager() {
        this.bA = false;
    }

    public static KsAdLoadManager M() {
        return Holder.INSTANCE.mInstance;
    }

    private static void N() {
        boolean Gt = com.kwad.sdk.core.config.e.Gt();
        com.kwad.sdk.core.d.c.d("AdLoadManager", "reportInstallerCheckRecord isInstallerCheckEnable: " + Gt);
        if (!Gt) {
            return;
        }
        Context context = ServiceProvider.getContext();
        try {
            com.kwad.components.ad.j.b.ak(context);
            com.kwad.components.ad.j.b.al(context);
        } catch (Throwable th) {
            com.kwad.sdk.crash.b.n(th);
        }
    }

    public final synchronized <T> void b(List<T> list) {
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            g.om().add(it.next());
        }
    }

    public final synchronized <T> void a(T t5) {
        g.om().add(t5);
    }
}
