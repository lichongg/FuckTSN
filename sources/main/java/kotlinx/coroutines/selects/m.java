package kotlinx.coroutines.selects;

import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.j1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@InternalCoroutinesApi
/* loaded from: D:\Downloads\app\classes8.dex */
public interface m<R> {
    void f(@Nullable Object obj);

    @NotNull
    kotlin.coroutines.i getContext();

    void h(@NotNull j1 j1Var);

    boolean j(@NotNull Object obj, @Nullable Object obj2);
}
