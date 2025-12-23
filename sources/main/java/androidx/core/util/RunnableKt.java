package androidx.core.util;

import kotlin.n1;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class RunnableKt {
    @NotNull
    public static final Runnable asRunnable(@NotNull kotlin.coroutines.e<? super n1> eVar) {
        return new ContinuationRunnable(eVar);
    }
}
