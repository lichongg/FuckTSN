package androidx.lifecycle;

import kotlin.n1;
import kotlinx.coroutines.j1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public interface LiveDataScope<T> {
    @Nullable
    Object emit(T t5, @NotNull kotlin.coroutines.e<? super n1> eVar);

    @Nullable
    Object emitSource(@NotNull LiveData<T> liveData, @NotNull kotlin.coroutines.e<? super j1> eVar);

    @Nullable
    T getLatestValue();
}
