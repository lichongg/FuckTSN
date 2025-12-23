package kotlinx.coroutines.flow.internal;

import kotlin.PublishedApi;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class o {
    @PublishedApi
    public static final int a(int i6) {
        if (i6 >= 0) {
            return i6;
        }
        throw new ArithmeticException("Index overflow has happened");
    }

    public static final void b(@NotNull AbortFlowException abortFlowException, @NotNull kotlinx.coroutines.flow.j<?> jVar) {
        if (abortFlowException.owner != jVar) {
            throw abortFlowException;
        }
    }
}
