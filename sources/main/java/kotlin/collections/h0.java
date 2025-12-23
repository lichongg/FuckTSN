package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.BuilderInference;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.random.Random;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nCollections.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Collections.kt\nkotlin/collections/CollectionsKt__CollectionsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,527:1\n1#2:528\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public class h0 extends g0 {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX WARN: Incorrect field signature: TK; */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nCollections.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Collections.kt\nkotlin/collections/CollectionsKt__CollectionsKt$binarySearchBy$1\n*L\n1#1,527:1\n*E\n"})
    public static final class a<T> implements Function1<T, Integer> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<T, K> f43645a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Comparable f43646b;

        /* JADX WARN: Incorrect types in method signature: (Lkotlin/jvm/functions/Function1<-TT;+TK;>;TK;)V */
        public a(Function1 function1, Comparable comparable) {
            this.f43645a = function1;
            this.f43646b = comparable;
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Integer invoke(T t5) {
            return Integer.valueOf(kotlin.comparisons.a.l((Comparable) this.f43645a.invoke(t5), this.f43646b));
        }
    }

    public static /* synthetic */ int A(List list, Comparable comparable, int i6, int i7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            i6 = 0;
        }
        if ((i8 & 4) != 0) {
            i7 = list.size();
        }
        return x(list, comparable, i6, i7);
    }

    public static /* synthetic */ int B(List list, Object obj, Comparator comparator, int i6, int i7, int i8, Object obj2) {
        if ((i8 & 4) != 0) {
            i6 = 0;
        }
        if ((i8 & 8) != 0) {
            i7 = list.size();
        }
        return y(list, obj, comparator, i6, i7);
    }

    public static final <T, K extends Comparable<? super K>> int C(@NotNull List<? extends T> list, @Nullable K k6, int i6, int i7, @NotNull Function1<? super T, ? extends K> selector) {
        kotlin.jvm.internal.g0.p(list, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        return w(list, i6, i7, new a(selector, k6));
    }

    public static /* synthetic */ int D(List list, Comparable comparable, int i6, int i7, Function1 selector, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            i6 = 0;
        }
        if ((i8 & 4) != 0) {
            i7 = list.size();
        }
        kotlin.jvm.internal.g0.p(list, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        return w(list, i6, i7, new a(selector, comparable));
    }

    @SinceKotlin(version = cn.bluemobi.dylan.photoview.a.f1297f)
    @InlineOnly
    private static final <E> List<E> E(int i6, @BuilderInference Function1<? super List<E>, kotlin.n1> builderAction) {
        kotlin.jvm.internal.g0.p(builderAction, "builderAction");
        List k6 = g0.k(i6);
        builderAction.invoke(k6);
        return g0.b(k6);
    }

    @SinceKotlin(version = cn.bluemobi.dylan.photoview.a.f1297f)
    @InlineOnly
    private static final <E> List<E> F(@BuilderInference Function1<? super List<E>, kotlin.n1> builderAction) {
        kotlin.jvm.internal.g0.p(builderAction, "builderAction");
        List j6 = g0.j();
        builderAction.invoke(j6);
        return g0.b(j6);
    }

    @NotNull
    public static final Object[] G(@NotNull Collection<?> collection) {
        kotlin.jvm.internal.g0.p(collection, "collection");
        int i6 = 0;
        if (collection.isEmpty()) {
            return new Object[0];
        }
        Object[] objArr = new Object[collection.size()];
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            objArr[i6] = it.next();
            i6++;
        }
        return objArr;
    }

    @NotNull
    public static final <T> T[] H(@NotNull Collection<?> collection, @NotNull T[] array) {
        kotlin.jvm.internal.g0.p(collection, "collection");
        kotlin.jvm.internal.g0.p(array, "array");
        int i6 = 0;
        if (collection.isEmpty()) {
            return (T[]) g0.o(0, array);
        }
        int length = array.length;
        Object[] objArr = array;
        if (length < collection.size()) {
            objArr = (T[]) o.a(array, collection.size());
        }
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            objArr[i6] = it.next();
            i6++;
        }
        return (T[]) g0.o(collection.size(), objArr);
    }

    @InlineOnly
    private static final <T> boolean I(Collection<? extends T> collection, Collection<? extends T> elements) {
        kotlin.jvm.internal.g0.p(collection, "<this>");
        kotlin.jvm.internal.g0.p(elements, "elements");
        return collection.containsAll(elements);
    }

    @NotNull
    public static <T> List<T> J() {
        return EmptyList.INSTANCE;
    }

    @NotNull
    public static kotlin.ranges.m K(@NotNull Collection<?> collection) {
        kotlin.jvm.internal.g0.p(collection, "<this>");
        return new kotlin.ranges.m(0, collection.size() - 1);
    }

    public static <T> int L(@NotNull List<? extends T> list) {
        kotlin.jvm.internal.g0.p(list, "<this>");
        return list.size() - 1;
    }

    /* JADX WARN: Incorrect types in method signature: <C::Ljava/util/Collection<*>;:TR;R:Ljava/lang/Object;>(TC;Lkotlin/jvm/functions/Function0<+TR;>;)TR; */
    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final Object M(Collection collection, Function0 defaultValue) {
        kotlin.jvm.internal.g0.p(defaultValue, "defaultValue");
        return collection.isEmpty() ? defaultValue.invoke() : collection;
    }

    @InlineOnly
    private static final <T> boolean N(Collection<? extends T> collection) {
        kotlin.jvm.internal.g0.p(collection, "<this>");
        return !collection.isEmpty();
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <T> boolean O(Collection<? extends T> collection) {
        return collection == null || collection.isEmpty();
    }

    @NotNull
    public static <T> List<T> Q(@NotNull T... elements) {
        kotlin.jvm.internal.g0.p(elements, "elements");
        return elements.length > 0 ? q.t(elements) : J();
    }

    @NotNull
    public static <T> List<T> R(@Nullable T t5) {
        return t5 != null ? g0.l(t5) : J();
    }

    @NotNull
    public static <T> List<T> S(@NotNull T... elements) {
        kotlin.jvm.internal.g0.p(elements, "elements");
        return a0.lb(elements);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final <T> List<T> T() {
        return new ArrayList();
    }

    @NotNull
    public static <T> List<T> U(@NotNull T... elements) {
        kotlin.jvm.internal.g0.p(elements, "elements");
        return elements.length == 0 ? new ArrayList() : new ArrayList(u(elements, true));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <T> List<T> V(@NotNull List<? extends T> list) {
        kotlin.jvm.internal.g0.p(list, "<this>");
        int size = list.size();
        return size != 0 ? size != 1 ? list : g0.l(list.get(0)) : J();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @InlineOnly
    private static final <T> Collection<T> W(Collection<? extends T> collection) {
        return collection == 0 ? J() : collection;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @InlineOnly
    private static final <T> List<T> X(List<? extends T> list) {
        return list == 0 ? J() : list;
    }

    private static final void Y(int i6, int i7, int i8) {
        if (i7 > i8) {
            throw new IllegalArgumentException("fromIndex (" + i7 + ") is greater than toIndex (" + i8 + ").");
        }
        if (i7 < 0) {
            throw new IndexOutOfBoundsException("fromIndex (" + i7 + ") is less than zero.");
        }
        if (i8 <= i6) {
            return;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i8 + ") is greater than size (" + i6 + ").");
    }

    @SinceKotlin(version = "1.3")
    @NotNull
    public static final <T> List<T> Z(@NotNull Iterable<? extends T> iterable, @NotNull Random random) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(random, "random");
        List<T> c6 = r0.c6(iterable);
        r0.j5(c6, random);
        return c6;
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    public static void a0() {
        throw new ArithmeticException("Count overflow has happened.");
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    public static void b0() {
        throw new ArithmeticException("Index overflow has happened.");
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final <T> List<T> q(int i6, Function1<? super Integer, ? extends T> init) {
        kotlin.jvm.internal.g0.p(init, "init");
        ArrayList arrayList = new ArrayList(i6);
        for (int i7 = 0; i7 < i6; i7++) {
            arrayList.add(init.invoke(Integer.valueOf(i7)));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final <T> List<T> r(int i6, Function1<? super Integer, ? extends T> init) {
        kotlin.jvm.internal.g0.p(init, "init");
        ArrayList arrayList = new ArrayList(i6);
        for (int i7 = 0; i7 < i6; i7++) {
            arrayList.add(init.invoke(Integer.valueOf(i7)));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final <T> ArrayList<T> s() {
        return new ArrayList<>();
    }

    @NotNull
    public static final <T> ArrayList<T> t(@NotNull T... elements) {
        kotlin.jvm.internal.g0.p(elements, "elements");
        return elements.length == 0 ? new ArrayList<>() : new ArrayList<>(u(elements, true));
    }

    @NotNull
    public static final <T> Collection<T> u(@NotNull T[] tArr, boolean z5) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        return new l(tArr, z5);
    }

    public static /* synthetic */ Collection v(Object[] objArr, boolean z5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            z5 = false;
        }
        return u(objArr, z5);
    }

    public static final <T> int w(@NotNull List<? extends T> list, int i6, int i7, @NotNull Function1<? super T, Integer> comparison) {
        kotlin.jvm.internal.g0.p(list, "<this>");
        kotlin.jvm.internal.g0.p(comparison, "comparison");
        Y(list.size(), i6, i7);
        int i8 = i7 - 1;
        while (i6 <= i8) {
            int i9 = (i6 + i8) >>> 1;
            int intValue = comparison.invoke(list.get(i9)).intValue();
            if (intValue < 0) {
                i6 = i9 + 1;
            } else {
                if (intValue <= 0) {
                    return i9;
                }
                i8 = i9 - 1;
            }
        }
        return -(i6 + 1);
    }

    public static final <T extends Comparable<? super T>> int x(@NotNull List<? extends T> list, @Nullable T t5, int i6, int i7) {
        kotlin.jvm.internal.g0.p(list, "<this>");
        Y(list.size(), i6, i7);
        int i8 = i7 - 1;
        while (i6 <= i8) {
            int i9 = (i6 + i8) >>> 1;
            int l6 = kotlin.comparisons.a.l(list.get(i9), t5);
            if (l6 < 0) {
                i6 = i9 + 1;
            } else {
                if (l6 <= 0) {
                    return i9;
                }
                i8 = i9 - 1;
            }
        }
        return -(i6 + 1);
    }

    public static final <T> int y(@NotNull List<? extends T> list, T t5, @NotNull Comparator<? super T> comparator, int i6, int i7) {
        kotlin.jvm.internal.g0.p(list, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        Y(list.size(), i6, i7);
        int i8 = i7 - 1;
        while (i6 <= i8) {
            int i9 = (i6 + i8) >>> 1;
            int compare = comparator.compare(list.get(i9), t5);
            if (compare < 0) {
                i6 = i9 + 1;
            } else {
                if (compare <= 0) {
                    return i9;
                }
                i8 = i9 - 1;
            }
        }
        return -(i6 + 1);
    }

    public static /* synthetic */ int z(List list, int i6, int i7, Function1 function1, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i6 = 0;
        }
        if ((i8 & 2) != 0) {
            i7 = list.size();
        }
        return w(list, i6, i7, function1);
    }

    @InlineOnly
    private static final <T> List<T> P() {
        return J();
    }
}
