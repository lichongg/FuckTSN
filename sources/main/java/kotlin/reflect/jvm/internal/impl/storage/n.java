package kotlin.reflect.jvm.internal.impl.storage;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public interface n {
    @NotNull
    <T> i<T> a(@NotNull Function0<? extends T> function0, @NotNull T t5);

    @NotNull
    <T> i<T> b(@NotNull Function0<? extends T> function0, @Nullable Function1<? super Boolean, ? extends T> function1, @NotNull Function1<? super T, n1> function12);

    @NotNull
    <K, V> h<K, V> c(@NotNull Function1<? super K, ? extends V> function1);

    @NotNull
    <K, V> a<K, V> d();

    @NotNull
    <T> i<T> e(@NotNull Function0<? extends T> function0);

    <T> T f(@NotNull Function0<? extends T> function0);

    @NotNull
    <T> j<T> g(@NotNull Function0<? extends T> function0);

    @NotNull
    <K, V> b<K, V> h();

    @NotNull
    <K, V> g<K, V> i(@NotNull Function1<? super K, ? extends V> function1);
}
