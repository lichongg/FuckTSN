package kotlin.reflect;

import kotlin.SinceKotlin;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.n;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public interface p<T, V> extends n<V>, Function1<T, V> {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a<T, V> extends n.c<V>, Function1<T, V> {
    }

    V get(T t5);

    @SinceKotlin(version = "1.1")
    @Nullable
    Object getDelegate(T t5);

    @Override // kotlin.reflect.n
    @NotNull
    a<T, V> getGetter();
}
