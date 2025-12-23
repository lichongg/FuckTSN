package kotlin.coroutines;

import java.io.Serializable;
import kotlin.SinceKotlin;
import kotlin.coroutines.i;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SinceKotlin(version = "1.3")
/* loaded from: D:\Downloads\app\classes8.dex */
public final class EmptyCoroutineContext implements i, Serializable {

    @NotNull
    public static final EmptyCoroutineContext INSTANCE = new EmptyCoroutineContext();
    private static final long serialVersionUID = 0;

    public int hashCode() {
        return 0;
    }

    private final Object readResolve() {
        return INSTANCE;
    }

    @Override // kotlin.coroutines.i
    public <R> R fold(R r5, @NotNull Function2<? super R, ? super i.b, ? extends R> operation) {
        g0.p(operation, "operation");
        return r5;
    }

    @Override // kotlin.coroutines.i
    @Nullable
    public <E extends i.b> E get(@NotNull i.c<E> key) {
        g0.p(key, "key");
        return null;
    }

    @Override // kotlin.coroutines.i
    @NotNull
    public i minusKey(@NotNull i.c<?> key) {
        g0.p(key, "key");
        return this;
    }

    @Override // kotlin.coroutines.i
    @NotNull
    public i plus(@NotNull i context) {
        g0.p(context, "context");
        return context;
    }

    @NotNull
    public String toString() {
        return "EmptyCoroutineContext";
    }

    private EmptyCoroutineContext() {
    }
}
