package kotlin.reflect;

import kotlin.SinceKotlin;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.n;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public interface q<D, E, V> extends n<V>, Function2<D, E, V> {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a<D, E, V> extends n.c<V>, Function2<D, E, V> {
    }

    V get(D d6, E e6);

    @SinceKotlin(version = "1.1")
    @Nullable
    Object getDelegate(D d6, E e6);

    @Override // kotlin.reflect.n
    @NotNull
    a<D, E, V> getGetter();
}
