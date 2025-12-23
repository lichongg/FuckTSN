package androidx.lifecycle;

import java.io.Closeable;
import kotlin.jvm.internal.g0;
import kotlinx.coroutines.j2;
import kotlinx.coroutines.r0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class CloseableCoroutineScope implements Closeable, r0 {

    @NotNull
    private final kotlin.coroutines.i coroutineContext;

    public CloseableCoroutineScope(@NotNull kotlin.coroutines.i context) {
        g0.p(context, "context");
        this.coroutineContext = context;
    }

    @Override // kotlinx.coroutines.r0
    @NotNull
    public kotlin.coroutines.i getCoroutineContext() {
        return this.coroutineContext;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        j2.i(getCoroutineContext(), null, 1, null);
    }
}
