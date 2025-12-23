package kotlin.reflect;

import kotlin.jvm.functions.Function2;
import kotlin.n1;
import kotlin.reflect.j;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public interface l<T, V> extends p<T, V>, j<V> {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a<T, V> extends j.a<V>, Function2<T, V, n1> {
    }

    @Override // kotlin.reflect.j
    @NotNull
    a<T, V> getSetter();

    void set(T t5, V v5);
}
