package kotlinx.coroutines.flow;

import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public interface x<T> extends i<T> {
    @NotNull
    List<T> a();

    @Override // kotlinx.coroutines.flow.i
    @Nullable
    Object collect(@NotNull j<? super T> jVar, @NotNull kotlin.coroutines.e<?> eVar);
}
