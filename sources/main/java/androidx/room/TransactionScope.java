package androidx.room;

import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public interface TransactionScope<T> extends PooledConnection {
    @Nullable
    Object rollback(T t5, @NotNull kotlin.coroutines.e<?> eVar);

    @Nullable
    <R> Object withNestedTransaction(@NotNull Function2<? super TransactionScope<R>, ? super kotlin.coroutines.e<? super R>, ? extends Object> function2, @NotNull kotlin.coroutines.e<? super R> eVar);
}
