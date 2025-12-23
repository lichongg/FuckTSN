package com.kwad.components.core.o.b;

import android.content.Context;
import com.ksad.annotation.invoker.ForInvoker;
import com.kwad.components.core.o.b.a.j;
import com.kwad.components.offline.api.OfflineHostProvider;
import com.kwad.components.offline.d.c;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.h;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b {
    private static final AtomicBoolean mHasInit = new AtomicBoolean();

    public static void init(final Context context) {
        AtomicBoolean atomicBoolean = mHasInit;
        if (atomicBoolean.get()) {
            return;
        }
        atomicBoolean.set(true);
        OfflineHostProvider.get().init(context, new j());
        h.execute(new bg() { // from class: com.kwad.components.core.o.b.b.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                b.ax(context);
            }
        });
    }

    @ForInvoker(methodId = "initOC")
    public static void ax(Context context) {
        com.kwad.components.offline.a.b.aF(context);
        com.kwad.components.offline.b.b.aF(context);
        com.kwad.components.offline.c.b.aF(context);
        c.aF(context);
    }
}
