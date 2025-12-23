package androidx.core.os;

import android.os.OutcomeReceiver;
import androidx.annotation.RequiresApi;
import java.lang.Throwable;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(31)
/* loaded from: D:\Downloads\app\classes.dex */
final class ContinuationOutcomeReceiver<R, E extends Throwable> extends AtomicBoolean implements OutcomeReceiver<R, E> {

    @NotNull
    private final kotlin.coroutines.e<R> continuation;

    /* JADX WARN: Multi-variable type inference failed */
    public ContinuationOutcomeReceiver(@NotNull kotlin.coroutines.e<? super R> eVar) {
        super(false);
        this.continuation = eVar;
    }

    @Override // android.os.OutcomeReceiver
    public void onError(@NotNull E e6) {
        if (compareAndSet(false, true)) {
            kotlin.coroutines.e<R> eVar = this.continuation;
            Result.a aVar = Result.Companion;
            eVar.resumeWith(Result.m130constructorimpl(g0.a(e6)));
        }
    }

    @Override // android.os.OutcomeReceiver
    public void onResult(R r5) {
        if (compareAndSet(false, true)) {
            kotlin.coroutines.e<R> eVar = this.continuation;
            Result.a aVar = Result.Companion;
            eVar.resumeWith(Result.m130constructorimpl(r5));
        }
    }

    @Override // java.util.concurrent.atomic.AtomicBoolean
    @NotNull
    public String toString() {
        return "ContinuationOutcomeReceiver(outcomeReceived = " + get() + ')';
    }
}
