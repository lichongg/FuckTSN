package kotlinx.coroutines.flow;

import kotlin.n1;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public interface s<T> extends x<T>, j<T> {
    @ExperimentalCoroutinesApi
    void b();

    boolean c(T t5);

    @NotNull
    h0<Integer> d();

    @Override // kotlinx.coroutines.flow.j
    @Nullable
    Object emit(T t5, @NotNull kotlin.coroutines.e<? super n1> eVar);
}
