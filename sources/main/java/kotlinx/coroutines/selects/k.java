package kotlinx.coroutines.selects;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.n1;
import kotlinx.coroutines.InternalCoroutinesApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@InternalCoroutinesApi
/* loaded from: D:\Downloads\app\classes8.dex */
public interface k {
    @Nullable
    Function3<m<?>, Object, Object, Function1<Throwable, n1>> a();

    @NotNull
    Function3<Object, Object, Object, Object> b();

    @NotNull
    Function3<Object, m<?>, Object, n1> c();

    @NotNull
    Object d();
}
