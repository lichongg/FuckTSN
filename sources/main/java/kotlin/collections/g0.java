package kotlin.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Random;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.collections.builders.ListBuilder;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nCollectionsJVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CollectionsJVM.kt\nkotlin/collections/CollectionsKt__CollectionsJVMKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,133:1\n1#2:134\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public class g0 {
    @InlineOnly
    private static final <T> ArrayList<T> a(T[] tArr) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        return new ArrayList<>(h0.u(tArr, true));
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @NotNull
    public static <E> List<E> b(@NotNull List<E> builder) {
        kotlin.jvm.internal.g0.p(builder, "builder");
        return ((ListBuilder) builder).build();
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @InlineOnly
    private static final <E> List<E> c(int i6, Function1<? super List<E>, kotlin.n1> builderAction) {
        kotlin.jvm.internal.g0.p(builderAction, "builderAction");
        List k6 = k(i6);
        builderAction.invoke(k6);
        return b(k6);
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @InlineOnly
    private static final <E> List<E> d(Function1<? super List<E>, kotlin.n1> builderAction) {
        kotlin.jvm.internal.g0.p(builderAction, "builderAction");
        List j6 = j();
        builderAction.invoke(j6);
        return b(j6);
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @InlineOnly
    private static final int e(int i6) {
        if (i6 < 0) {
            h0.a0();
        }
        return i6;
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @InlineOnly
    private static final int f(int i6) {
        if (i6 < 0) {
            h0.b0();
        }
        return i6;
    }

    @InlineOnly
    private static final Object[] g(Collection<?> collection) {
        kotlin.jvm.internal.g0.p(collection, "collection");
        return kotlin.jvm.internal.u.a(collection);
    }

    @InlineOnly
    private static final <T> T[] h(Collection<?> collection, T[] array) {
        kotlin.jvm.internal.g0.p(collection, "collection");
        kotlin.jvm.internal.g0.p(array, "array");
        return (T[]) kotlin.jvm.internal.u.b(collection, array);
    }

    @NotNull
    public static final <T> Object[] i(@NotNull T[] tArr, boolean z5) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        if (z5 && kotlin.jvm.internal.g0.g(tArr.getClass(), Object[].class)) {
            return tArr;
        }
        Object[] copyOf = Arrays.copyOf(tArr, tArr.length, Object[].class);
        kotlin.jvm.internal.g0.o(copyOf, "copyOf(...)");
        return copyOf;
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @NotNull
    public static <E> List<E> j() {
        return new ListBuilder(0, 1, null);
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @NotNull
    public static <E> List<E> k(int i6) {
        return new ListBuilder(i6);
    }

    @SinceKotlin(version = "1.2")
    @NotNull
    public static final <T> List<T> m(@NotNull Iterable<? extends T> iterable) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        List<T> c6 = r0.c6(iterable);
        Collections.shuffle(c6);
        return c6;
    }

    @SinceKotlin(version = "1.2")
    @NotNull
    public static final <T> List<T> n(@NotNull Iterable<? extends T> iterable, @NotNull Random random) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(random, "random");
        List<T> c6 = r0.c6(iterable);
        Collections.shuffle(c6, random);
        return c6;
    }

    @NotNull
    public static <T> T[] o(int i6, @NotNull T[] array) {
        kotlin.jvm.internal.g0.p(array, "array");
        if (i6 < array.length) {
            array[i6] = null;
        }
        return array;
    }

    @InlineOnly
    private static final <T> List<T> p(Enumeration<T> enumeration) {
        kotlin.jvm.internal.g0.p(enumeration, "<this>");
        ArrayList list = Collections.list(enumeration);
        kotlin.jvm.internal.g0.o(list, "list(...)");
        return list;
    }

    @NotNull
    public static <T> List<T> l(T t5) {
        List<T> singletonList = Collections.singletonList(t5);
        kotlin.jvm.internal.g0.o(singletonList, "singletonList(...)");
        return singletonList;
    }
}
