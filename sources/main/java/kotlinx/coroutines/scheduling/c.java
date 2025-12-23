package kotlinx.coroutines.scheduling;

import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.internal.t;
import kotlinx.coroutines.m0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class c extends h {

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public static final c f49485g = new c();

    private c() {
        super(n.f49509c, n.f49510d, n.f49511e, n.f49507a);
    }

    @Override // kotlinx.coroutines.scheduling.h, kotlinx.coroutines.t1, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    @Override // kotlinx.coroutines.m0
    @NotNull
    public String toString() {
        return "Dispatchers.Default";
    }

    public final void B() {
        super.close();
    }

    @Override // kotlinx.coroutines.m0
    @ExperimentalCoroutinesApi
    @NotNull
    public m0 limitedParallelism(int i6) {
        t.a(i6);
        if (i6 >= n.f49509c) {
            return this;
        }
        return super.limitedParallelism(i6);
    }
}
