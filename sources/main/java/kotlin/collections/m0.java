package kotlin.collections;

import com.daimajia.numberprogressbar.BuildConfig;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class m0 extends l0 {
    @InlineOnly
    private static final <T> void A0(Collection<? super T> collection, kotlin.sequences.m<? extends T> elements) {
        kotlin.jvm.internal.g0.p(collection, "<this>");
        kotlin.jvm.internal.g0.p(elements, "elements");
        L0(collection, elements);
    }

    @InlineOnly
    private static final <T> void B0(Collection<? super T> collection, T[] elements) {
        kotlin.jvm.internal.g0.p(collection, "<this>");
        kotlin.jvm.internal.g0.p(elements, "elements");
        M0(collection, elements);
    }

    @InlineOnly
    private static final <T> void C0(Collection<? super T> collection, Iterable<? extends T> elements) {
        kotlin.jvm.internal.g0.p(collection, "<this>");
        kotlin.jvm.internal.g0.p(elements, "elements");
        s0(collection, elements);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @InlineOnly
    private static final <T> void D0(Collection<? super T> collection, T t5) {
        kotlin.jvm.internal.g0.p(collection, "<this>");
        collection.add(t5);
    }

    @InlineOnly
    private static final <T> void E0(Collection<? super T> collection, kotlin.sequences.m<? extends T> elements) {
        kotlin.jvm.internal.g0.p(collection, "<this>");
        kotlin.jvm.internal.g0.p(elements, "elements");
        t0(collection, elements);
    }

    @InlineOnly
    private static final <T> void F0(Collection<? super T> collection, T[] elements) {
        kotlin.jvm.internal.g0.p(collection, "<this>");
        kotlin.jvm.internal.g0.p(elements, "elements");
        u0(collection, elements);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use removeAt(index) instead.", replaceWith = @ReplaceWith(expression = "removeAt(index)", imports = {}))
    @InlineOnly
    private static final <T> T G0(List<T> list, int i6) {
        kotlin.jvm.internal.g0.p(list, "<this>");
        return list.remove(i6);
    }

    @InlineOnly
    private static final <T> boolean H0(Collection<? extends T> collection, T t5) {
        kotlin.jvm.internal.g0.p(collection, "<this>");
        return kotlin.jvm.internal.u0.a(collection).remove(t5);
    }

    public static final <T> boolean I0(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        return w0(iterable, predicate, true);
    }

    public static final <T> boolean J0(@NotNull Collection<? super T> collection, @NotNull Iterable<? extends T> elements) {
        kotlin.jvm.internal.g0.p(collection, "<this>");
        kotlin.jvm.internal.g0.p(elements, "elements");
        return collection.removeAll(v0(elements));
    }

    @InlineOnly
    private static final <T> boolean K0(Collection<? extends T> collection, Collection<? extends T> elements) {
        kotlin.jvm.internal.g0.p(collection, "<this>");
        kotlin.jvm.internal.g0.p(elements, "elements");
        return kotlin.jvm.internal.u0.a(collection).removeAll(elements);
    }

    public static final <T> boolean L0(@NotNull Collection<? super T> collection, @NotNull kotlin.sequences.m<? extends T> elements) {
        kotlin.jvm.internal.g0.p(collection, "<this>");
        kotlin.jvm.internal.g0.p(elements, "elements");
        List I3 = kotlin.sequences.p.I3(elements);
        return !I3.isEmpty() && collection.removeAll(I3);
    }

    public static final <T> boolean M0(@NotNull Collection<? super T> collection, @NotNull T[] elements) {
        kotlin.jvm.internal.g0.p(collection, "<this>");
        kotlin.jvm.internal.g0.p(elements, "elements");
        return !(elements.length == 0) && collection.removeAll(q.t(elements));
    }

    public static final <T> boolean N0(@NotNull List<T> list, @NotNull Function1<? super T, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(list, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        return x0(list, predicate, true);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    public static final <T> T O0(@NotNull List<T> list) {
        kotlin.jvm.internal.g0.p(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.remove(0);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final <T> T P0(@NotNull List<T> list) {
        kotlin.jvm.internal.g0.p(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.remove(0);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    public static <T> T Q0(@NotNull List<T> list) {
        kotlin.jvm.internal.g0.p(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.remove(h0.L(list));
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static <T> T R0(@NotNull List<T> list) {
        kotlin.jvm.internal.g0.p(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.remove(h0.L(list));
    }

    public static <T> boolean S0(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        return w0(iterable, predicate, false);
    }

    public static final <T> boolean T0(@NotNull Collection<? super T> collection, @NotNull Iterable<? extends T> elements) {
        kotlin.jvm.internal.g0.p(collection, "<this>");
        kotlin.jvm.internal.g0.p(elements, "elements");
        return collection.retainAll(v0(elements));
    }

    @InlineOnly
    private static final <T> boolean U0(Collection<? extends T> collection, Collection<? extends T> elements) {
        kotlin.jvm.internal.g0.p(collection, "<this>");
        kotlin.jvm.internal.g0.p(elements, "elements");
        return kotlin.jvm.internal.u0.a(collection).retainAll(elements);
    }

    public static final <T> boolean V0(@NotNull Collection<? super T> collection, @NotNull kotlin.sequences.m<? extends T> elements) {
        kotlin.jvm.internal.g0.p(collection, "<this>");
        kotlin.jvm.internal.g0.p(elements, "elements");
        List I3 = kotlin.sequences.p.I3(elements);
        return !I3.isEmpty() ? collection.retainAll(I3) : Y0(collection);
    }

    public static final <T> boolean W0(@NotNull Collection<? super T> collection, @NotNull T[] elements) {
        kotlin.jvm.internal.g0.p(collection, "<this>");
        kotlin.jvm.internal.g0.p(elements, "elements");
        return !(elements.length == 0) ? collection.retainAll(q.t(elements)) : Y0(collection);
    }

    public static final <T> boolean X0(@NotNull List<T> list, @NotNull Function1<? super T, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(list, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        return x0(list, predicate, false);
    }

    public static <T> boolean s0(@NotNull Collection<? super T> collection, @NotNull Iterable<? extends T> elements) {
        kotlin.jvm.internal.g0.p(collection, "<this>");
        kotlin.jvm.internal.g0.p(elements, "elements");
        if (elements instanceof Collection) {
            return collection.addAll((Collection) elements);
        }
        Iterator<? extends T> it = elements.iterator();
        boolean z5 = false;
        while (it.hasNext()) {
            if (collection.add(it.next())) {
                z5 = true;
            }
        }
        return z5;
    }

    public static <T> boolean t0(@NotNull Collection<? super T> collection, @NotNull kotlin.sequences.m<? extends T> elements) {
        kotlin.jvm.internal.g0.p(collection, "<this>");
        kotlin.jvm.internal.g0.p(elements, "elements");
        Iterator<? extends T> it = elements.iterator();
        boolean z5 = false;
        while (it.hasNext()) {
            if (collection.add(it.next())) {
                z5 = true;
            }
        }
        return z5;
    }

    public static <T> boolean u0(@NotNull Collection<? super T> collection, @NotNull T[] elements) {
        kotlin.jvm.internal.g0.p(collection, "<this>");
        kotlin.jvm.internal.g0.p(elements, "elements");
        return collection.addAll(q.t(elements));
    }

    @NotNull
    public static <T> Collection<T> v0(@NotNull Iterable<? extends T> iterable) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        return iterable instanceof Collection ? (Collection) iterable : r0.a6(iterable);
    }

    private static final <T> boolean x0(List<T> list, Function1<? super T, Boolean> function1, boolean z5) {
        int i6;
        if (!(list instanceof RandomAccess)) {
            kotlin.jvm.internal.g0.n(list, "null cannot be cast to non-null type kotlin.collections.MutableIterable<T of kotlin.collections.CollectionsKt__MutableCollectionsKt.filterInPlace>");
            return w0(kotlin.jvm.internal.u0.c(list), function1, z5);
        }
        int L = h0.L(list);
        if (L >= 0) {
            int i7 = 0;
            i6 = 0;
            while (true) {
                T t5 = list.get(i7);
                if (function1.invoke(t5).booleanValue() != z5) {
                    if (i6 != i7) {
                        list.set(i6, t5);
                    }
                    i6++;
                }
                if (i7 == L) {
                    break;
                }
                i7++;
            }
        } else {
            i6 = 0;
        }
        if (i6 >= list.size()) {
            return false;
        }
        int L2 = h0.L(list);
        if (i6 > L2) {
            return true;
        }
        while (true) {
            list.remove(L2);
            if (L2 == i6) {
                return true;
            }
            L2--;
        }
    }

    @InlineOnly
    private static final <T> void y0(Collection<? super T> collection, Iterable<? extends T> elements) {
        kotlin.jvm.internal.g0.p(collection, "<this>");
        kotlin.jvm.internal.g0.p(elements, "elements");
        J0(collection, elements);
    }

    @InlineOnly
    private static final <T> void z0(Collection<? super T> collection, T t5) {
        kotlin.jvm.internal.g0.p(collection, "<this>");
        collection.remove(t5);
    }

    private static final boolean Y0(Collection<?> collection) {
        boolean z5 = !collection.isEmpty();
        collection.clear();
        return z5;
    }

    private static final <T> boolean w0(Iterable<? extends T> iterable, Function1<? super T, Boolean> function1, boolean z5) {
        Iterator<? extends T> it = iterable.iterator();
        boolean z6 = false;
        while (it.hasNext()) {
            if (function1.invoke(it.next()).booleanValue() == z5) {
                it.remove();
                z6 = true;
            }
        }
        return z6;
    }
}
