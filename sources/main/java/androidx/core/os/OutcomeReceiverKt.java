package androidx.core.os;

import android.os.OutcomeReceiver;
import androidx.annotation.RequiresApi;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(31)
/* loaded from: D:\Downloads\app\classes.dex */
public final class OutcomeReceiverKt {
    @RequiresApi(31)
    @NotNull
    public static final <R, E extends Throwable> OutcomeReceiver<R, E> asOutcomeReceiver(@NotNull kotlin.coroutines.e<? super R> eVar) {
        return i.a(new ContinuationOutcomeReceiver(eVar));
    }
}
