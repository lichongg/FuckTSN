package androidx.lifecycle;

import androidx.annotation.MainThread;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import kotlinx.coroutines.g1;
import kotlinx.coroutines.j1;
import kotlinx.coroutines.s0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class EmittedSource implements j1 {
    private boolean disposed;

    @NotNull
    private final MediatorLiveData<?> mediator;

    @NotNull
    private final LiveData<?> source;

    public EmittedSource(@NotNull LiveData<?> source, @NotNull MediatorLiveData<?> mediator) {
        g0.p(source, "source");
        g0.p(mediator, "mediator");
        this.source = source;
        this.mediator = mediator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @MainThread
    public final void removeSource() {
        if (this.disposed) {
            return;
        }
        this.mediator.removeSource(this.source);
        this.disposed = true;
    }

    @Override // kotlinx.coroutines.j1
    public void dispose() {
        kotlinx.coroutines.k.f(s0.a(g1.e().t()), null, null, new EmittedSource$dispose$1(this, null), 3, null);
    }

    @Nullable
    public final Object disposeNow(@NotNull kotlin.coroutines.e<? super n1> eVar) {
        Object h6 = kotlinx.coroutines.i.h(g1.e().t(), new EmittedSource$disposeNow$2(this, null), eVar);
        if (h6 == kotlin.coroutines.intrinsics.a.l()) {
            return h6;
        }
        return n1.f44123a;
    }
}
