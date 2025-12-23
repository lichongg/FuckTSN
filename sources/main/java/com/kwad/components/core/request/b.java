package com.kwad.components.core.request;

import com.kwad.sdk.service.ServiceProvider;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b {
    private final List<a> WW;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void sl();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.kwad.components.core.request.b$b, reason: collision with other inner class name */
    static class C0633b {
        private static final b WX = new b(0);
    }

    /* synthetic */ b(byte b6) {
        this();
    }

    private b() {
        this.WW = new CopyOnWriteArrayList();
    }

    public final void a(a aVar) {
        this.WW.add(aVar);
    }

    public final void b(a aVar) {
        this.WW.remove(aVar);
    }

    public final void sk() {
        for (a aVar : this.WW) {
            if (aVar != null) {
                try {
                    aVar.sl();
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        }
    }

    public static b sj() {
        return C0633b.WX;
    }
}
