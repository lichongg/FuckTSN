package kotlin.collections;

import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.collections.builders.SetBuilder;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class v1 {
    @SinceKotlin(version = "1.3")
    @PublishedApi
    @NotNull
    public static <E> Set<E> a(@NotNull Set<E> builder) {
        kotlin.jvm.internal.g0.p(builder, "builder");
        return ((SetBuilder) builder).build();
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @InlineOnly
    private static final <E> Set<E> b(int i6, Function1<? super Set<E>, kotlin.n1> builderAction) {
        kotlin.jvm.internal.g0.p(builderAction, "builderAction");
        Set e6 = e(i6);
        builderAction.invoke(e6);
        return a(e6);
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @InlineOnly
    private static final <E> Set<E> c(Function1<? super Set<E>, kotlin.n1> builderAction) {
        kotlin.jvm.internal.g0.p(builderAction, "builderAction");
        Set d6 = d();
        builderAction.invoke(d6);
        return a(d6);
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @NotNull
    public static <E> Set<E> d() {
        return new SetBuilder();
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @NotNull
    public static <E> Set<E> e(int i6) {
        return new SetBuilder(i6);
    }

    @NotNull
    public static final <T> TreeSet<T> g(@NotNull Comparator<? super T> comparator, @NotNull T... elements) {
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        kotlin.jvm.internal.g0.p(elements, "elements");
        return (TreeSet) a0.Iy(elements, new TreeSet(comparator));
    }

    @NotNull
    public static final <T> TreeSet<T> h(@NotNull T... elements) {
        kotlin.jvm.internal.g0.p(elements, "elements");
        return (TreeSet) a0.Iy(elements, new TreeSet());
    }

    @NotNull
    public static <T> Set<T> f(T t5) {
        Set<T> singleton = Collections.singleton(t5);
        kotlin.jvm.internal.g0.o(singleton, "singleton(...)");
        return singleton;
    }
}
