package com.kwad.components.core.o.b.a;

import com.kwad.components.offline.api.core.api.IAsync;
import com.kwad.sdk.utils.bw;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
final class a implements IAsync {
    a() {
    }

    @Override // com.kwad.components.offline.api.core.api.IAsync
    public final void execute(Runnable runnable) {
        com.kwad.sdk.utils.h.execute(runnable);
    }

    @Override // com.kwad.components.offline.api.core.api.IAsync
    public final void runOnDefaultExecutor(Runnable runnable) {
        com.kwad.sdk.utils.h.execute(runnable);
    }

    @Override // com.kwad.components.offline.api.core.api.IAsync
    public final void runOnUiThread(Runnable runnable) {
        bw.runOnUiThread(runnable);
    }

    @Override // com.kwad.components.offline.api.core.api.IAsync
    public final void runOnUiThreadDelay(Runnable runnable, long j6) {
        bw.runOnUiThreadDelay(runnable, j6);
    }

    @Override // com.kwad.components.offline.api.core.api.IAsync
    public final void schedule(Runnable runnable, long j6, TimeUnit timeUnit) {
        com.kwad.sdk.utils.h.schedule(runnable, j6, timeUnit);
    }
}
