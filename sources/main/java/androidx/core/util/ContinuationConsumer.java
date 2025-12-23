package androidx.core.util;

import androidx.annotation.RequiresApi;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(24)
/* loaded from: D:\Downloads\app\classes.dex */
final class ContinuationConsumer<T> extends AtomicBoolean implements java.util.function.Consumer<T> {

    @NotNull
    private final kotlin.coroutines.e<T> continuation;

    /* JADX WARN: Multi-variable type inference failed */
    public ContinuationConsumer(@NotNull kotlin.coroutines.e<? super T> eVar) {
        super(false);
        this.continuation = eVar;
    }

    @Override // java.util.function.Consumer
    public void accept(T t5) {
        if (compareAndSet(false, true)) {
            kotlin.coroutines.e<T> eVar = this.continuation;
            Result.a aVar = Result.Companion;
            eVar.resumeWith(Result.m130constructorimpl(t5));
        }
    }

    @Override // java.util.concurrent.atomic.AtomicBoolean
    @NotNull
    public String toString() {
        return "ContinuationConsumer(resultAccepted = " + get() + ')';
    }
}
