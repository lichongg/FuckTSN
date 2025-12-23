package kotlin.reflect;

import kotlin.jvm.functions.Function3;
import kotlin.n1;
import kotlin.reflect.j;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public interface m<D, E, V> extends q<D, E, V>, j<V> {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a<D, E, V> extends j.a<V>, Function3<D, E, V, n1> {
    }

    @Override // kotlin.reflect.j
    @NotNull
    a<D, E, V> getSetter();

    void set(D d6, E e6, V v5);
}
