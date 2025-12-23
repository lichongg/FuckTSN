package androidx.core.util;

import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
final class ContinuationRunnable extends AtomicBoolean implements Runnable {

    @NotNull
    private final kotlin.coroutines.e<n1> continuation;

    /* JADX WARN: Multi-variable type inference failed */
    public ContinuationRunnable(@NotNull kotlin.coroutines.e<? super n1> eVar) {
        super(false);
        this.continuation = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (compareAndSet(false, true)) {
            kotlin.coroutines.e<n1> eVar = this.continuation;
            Result.a aVar = Result.Companion;
            eVar.resumeWith(Result.m130constructorimpl(n1.f44123a));
        }
    }

    @Override // java.util.concurrent.atomic.AtomicBoolean
    @NotNull
    public String toString() {
        return "ContinuationRunnable(ran = " + get() + ')';
    }
}
