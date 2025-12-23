package kotlin.reflect;

import kotlin.SinceKotlin;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.n;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public interface o<V> extends n<V>, Function0<V> {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a<V> extends n.c<V>, Function0<V> {
    }

    V get();

    @SinceKotlin(version = "1.1")
    @Nullable
    Object getDelegate();

    @Override // kotlin.reflect.n
    @NotNull
    a<V> getGetter();
}
