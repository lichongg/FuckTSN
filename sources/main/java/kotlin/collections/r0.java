package kotlin.collections;

import com.daimajia.numberprogressbar.BuildConfig;
import defpackage.H5BaseWebChromeClient;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.OverloadResolutionByLambdaReturnType;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.comparisons.g;
import kotlin.internal.HidesMembers;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.random.Random;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\n_Collections.kt\nKotlin\n*S Kotlin\n*F\n+ 1 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 4 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 5 Iterators.kt\nkotlin/collections/CollectionsKt__IteratorsKt\n*L\n1#1,3794:1\n295#1,2:3795\n528#1,7:3797\n543#1,6:3804\n865#1,2:3811\n796#1:3813\n1878#1,2:3814\n797#1,2:3816\n1880#1:3818\n799#1:3819\n1878#1,3:3820\n817#1,2:3823\n855#1,2:3825\n1267#1,4:3831\n1236#1,4:3835\n1252#1,4:3839\n1299#1,4:3843\n1460#1,5:3847\n1475#1,5:3852\n1516#1,3:3857\n1519#1,3:3867\n1534#1,3:3870\n1537#1,3:3880\n1634#1,3:3897\n1604#1,4:3900\n1593#1:3904\n1878#1,2:3905\n1880#1:3908\n1594#1:3909\n1878#1,3:3910\n1625#1:3913\n1869#1:3914\n1870#1:3916\n1626#1:3917\n1869#1,2:3918\n1878#1,3:3920\n2967#1,3:3923\n2970#1,6:3927\n2992#1,3:3933\n2995#1,7:3937\n865#1,2:3944\n827#1:3946\n855#1,2:3947\n827#1:3949\n855#1,2:3950\n827#1:3952\n855#1,2:3953\n3516#1,8:3959\n3544#1,7:3967\n3575#1,10:3974\n1#2:3810\n1#2:3907\n1#2:3915\n1#2:3926\n1#2:3936\n37#3,2:3827\n37#3,2:3829\n382#4,7:3860\n382#4,7:3873\n382#4,7:3883\n382#4,7:3890\n32#5,2:3955\n32#5,2:3957\n*S KotlinDebug\n*F\n+ 1 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n174#1:3795,2\n184#1:3797,7\n194#1:3804,6\n774#1:3811,2\n785#1:3813\n785#1:3814,2\n785#1:3816,2\n785#1:3818\n785#1:3819\n796#1:3820,3\n808#1:3823,2\n827#1:3825,2\n1194#1:3831,4\n1209#1:3835,4\n1223#1:3839,4\n1286#1:3843,4\n1374#1:3847,5\n1387#1:3852,5\n1491#1:3857,3\n1491#1:3867,3\n1504#1:3870,3\n1504#1:3880,3\n1563#1:3897,3\n1573#1:3900,4\n1583#1:3904\n1583#1:3905,2\n1583#1:3908\n1583#1:3909\n1593#1:3910,3\n1617#1:3913\n1617#1:3914\n1617#1:3916\n1617#1:3917\n1625#1:3918,2\n2767#1:3920,3\n3067#1:3923,3\n3067#1:3927,6\n3084#1:3933,3\n3084#1:3937,7\n3254#1:3944,2\n3262#1:3946\n3262#1:3947,2\n3272#1:3949\n3272#1:3950,2\n3282#1:3952\n3282#1:3953,2\n3505#1:3959,8\n3533#1:3967,7\n3562#1:3974,10\n1583#1:3907\n1617#1:3915\n3067#1:3926\n3084#1:3936\n1042#1:3827,2\n1089#1:3829,2\n1491#1:3860,7\n1504#1:3873,7\n1518#1:3883,7\n1536#1:3890,7\n3450#1:3955,2\n3492#1:3957,2\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public class r0 extends o0 {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nSequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Sequences.kt\nkotlin/sequences/SequencesKt__SequencesKt$Sequence$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,731:1\n3635#2:732\n*E\n"})
    public static final class a<T> implements kotlin.sequences.m<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Iterable f43677a;

        public a(Iterable iterable) {
            this.f43677a = iterable;
        }

        @Override // kotlin.sequences.m
        public Iterator<T> iterator() {
            return this.f43677a.iterator();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T, K] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\n_Collections.kt\nKotlin\n*S Kotlin\n*F\n+ 1 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt$groupingBy$1\n*L\n1#1,3794:1\n*E\n"})
    public static final class b<K, T> implements w0<T, K> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Iterable<T> f43678a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function1<T, K> f43679b;

        /* JADX WARN: Multi-variable type inference failed */
        public b(Iterable<? extends T> iterable, Function1<? super T, ? extends K> function1) {
            this.f43678a = iterable;
            this.f43679b = function1;
        }

        @Override // kotlin.collections.w0
        public K a(T t5) {
            return this.f43679b.invoke(t5);
        }

        @Override // kotlin.collections.w0
        public Iterator<T> b() {
            return this.f43678a.iterator();
        }
    }

    public static <T> boolean A1(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return true;
        }
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            if (!predicate.invoke(it.next()).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @NotNull
    public static final <T, C extends Collection<? super T>> C A2(@NotNull Iterable<? extends T> iterable, @NotNull C destination, @NotNull Function1<? super T, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (T t5 : iterable) {
            if (predicate.invoke(t5).booleanValue()) {
                destination.add(t5);
            }
        }
        return destination;
    }

    @Nullable
    public static <T> T A3(@NotNull List<? extends T> list) {
        kotlin.jvm.internal.g0.p(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(list.size() - 1);
    }

    public static final <T> boolean A4(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return true;
        }
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            if (predicate.invoke(it.next()).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @NotNull
    public static final <T> Set<T> A5(@NotNull Iterable<? extends T> iterable, @NotNull Iterable<? extends T> other) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        Set<T> e6 = e6(iterable);
        m0.J0(e6, other);
        return e6;
    }

    public static final <T> boolean B1(@NotNull Iterable<? extends T> iterable) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        return iterable instanceof Collection ? !((Collection) iterable).isEmpty() : iterable.iterator().hasNext();
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    @InlineOnly
    private static final <T> T B2(Iterable<? extends T> iterable, Function1<? super T, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (T t5 : iterable) {
            if (predicate.invoke(t5).booleanValue()) {
                return t5;
            }
        }
        return null;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [T, java.lang.Object] */
    @Nullable
    public static final <T> T B3(@NotNull List<? extends T> list, @NotNull Function1<? super T, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(list, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        ListIterator<? extends T> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            T previous = listIterator.previous();
            if (predicate.invoke(previous).booleanValue()) {
                return previous;
            }
        }
        return null;
    }

    @SinceKotlin(version = "1.1")
    @NotNull
    public static final <T, C extends Iterable<? extends T>> C B4(@NotNull C c6, @NotNull Function1<? super T, kotlin.n1> action) {
        kotlin.jvm.internal.g0.p(c6, "<this>");
        kotlin.jvm.internal.g0.p(action, "action");
        Iterator<T> it = c6.iterator();
        while (it.hasNext()) {
            action.invoke(it.next());
        }
        return c6;
    }

    @Deprecated(message = "Use sumOf instead.", replaceWith = @ReplaceWith(expression = "this.sumOf(selector)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final <T> int B5(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, Integer> selector) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        int i6 = 0;
        while (it.hasNext()) {
            i6 += selector.invoke(it.next()).intValue();
        }
        return i6;
    }

    public static final <T> boolean C1(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return false;
        }
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            if (predicate.invoke(it.next()).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object] */
    @InlineOnly
    private static final <T> T C2(Iterable<? extends T> iterable, Function1<? super T, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        T t5 = null;
        for (T t6 : iterable) {
            if (predicate.invoke(t6).booleanValue()) {
                t5 = t6;
            }
        }
        return t5;
    }

    @NotNull
    public static <T, R> List<R> C3(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, ? extends R> transform) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(transform, "transform");
        ArrayList arrayList = new ArrayList(i0.d0(iterable, 10));
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(transform.invoke(it.next()));
        }
        return arrayList;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @NotNull
    public static final <T, C extends Iterable<? extends T>> C C4(@NotNull C c6, @NotNull Function2<? super Integer, ? super T, kotlin.n1> action) {
        kotlin.jvm.internal.g0.p(c6, "<this>");
        kotlin.jvm.internal.g0.p(action, "action");
        int i6 = 0;
        for (T t5 : c6) {
            int i7 = i6 + 1;
            if (i6 < 0) {
                h0.b0();
            }
            action.invoke(Integer.valueOf(i6), t5);
            i6 = i7;
        }
        return c6;
    }

    @Deprecated(message = "Use sumOf instead.", replaceWith = @ReplaceWith(expression = "this.sumOf(selector)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final <T> double C5(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, Double> selector) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        double d6 = 0.0d;
        while (it.hasNext()) {
            d6 += selector.invoke(it.next()).doubleValue();
        }
        return d6;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @InlineOnly
    private static final <T> Iterable<T> D1(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        return iterable;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [T, java.lang.Object] */
    @InlineOnly
    private static final <T> T D2(List<? extends T> list, Function1<? super T, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(list, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        ListIterator<? extends T> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            T previous = listIterator.previous();
            if (predicate.invoke(previous).booleanValue()) {
                return previous;
            }
        }
        return null;
    }

    @NotNull
    public static final <T, R> List<R> D3(@NotNull Iterable<? extends T> iterable, @NotNull Function2<? super Integer, ? super T, ? extends R> transform) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(transform, "transform");
        ArrayList arrayList = new ArrayList(i0.d0(iterable, 10));
        int i6 = 0;
        for (T t5 : iterable) {
            int i7 = i6 + 1;
            if (i6 < 0) {
                h0.b0();
            }
            arrayList.add(transform.invoke(Integer.valueOf(i6), t5));
            i6 = i7;
        }
        return arrayList;
    }

    @NotNull
    public static final <T> Pair<List<T>, List<T>> D4(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (T t5 : iterable) {
            if (predicate.invoke(t5).booleanValue()) {
                arrayList.add(t5);
            } else {
                arrayList2.add(t5);
            }
        }
        return new Pair<>(arrayList, arrayList2);
    }

    @JvmName(name = "sumOfByte")
    public static final int D5(@NotNull Iterable<Byte> iterable) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        Iterator<Byte> it = iterable.iterator();
        int i6 = 0;
        while (it.hasNext()) {
            i6 += it.next().byteValue();
        }
        return i6;
    }

    @NotNull
    public static <T> kotlin.sequences.m<T> E1(@NotNull Iterable<? extends T> iterable) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        return new a(iterable);
    }

    public static <T> T E2(@NotNull Iterable<? extends T> iterable) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        if (iterable instanceof List) {
            return (T) G2((List) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    @NotNull
    public static final <T, R> List<R> E3(@NotNull Iterable<? extends T> iterable, @NotNull Function2<? super Integer, ? super T, ? extends R> transform) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int i6 = 0;
        for (T t5 : iterable) {
            int i7 = i6 + 1;
            if (i6 < 0) {
                h0.b0();
            }
            R invoke = transform.invoke(Integer.valueOf(i6), t5);
            if (invoke != null) {
                arrayList.add(invoke);
            }
            i6 = i7;
        }
        return arrayList;
    }

    @NotNull
    public static <T> List<T> E4(@NotNull Iterable<? extends T> iterable, @NotNull Iterable<? extends T> elements) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(elements, "elements");
        if (iterable instanceof Collection) {
            return I4((Collection) iterable, elements);
        }
        ArrayList arrayList = new ArrayList();
        m0.s0(arrayList, iterable);
        m0.s0(arrayList, elements);
        return arrayList;
    }

    @JvmName(name = "sumOfDouble")
    public static final double E5(@NotNull Iterable<Double> iterable) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        Iterator<Double> it = iterable.iterator();
        double d6 = 0.0d;
        while (it.hasNext()) {
            d6 += it.next().doubleValue();
        }
        return d6;
    }

    @NotNull
    public static final <T, K, V> Map<K, V> F1(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, ? extends Pair<? extends K, ? extends V>> transform) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(transform, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.t.u(k1.j(i0.d0(iterable, 10)), 16));
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            Pair<? extends K, ? extends V> invoke = transform.invoke(it.next());
            linkedHashMap.put(invoke.getFirst(), invoke.getSecond());
        }
        return linkedHashMap;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    public static final <T> T F2(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (T t5 : iterable) {
            if (predicate.invoke(t5).booleanValue()) {
                return t5;
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    @NotNull
    public static final <T, R, C extends Collection<? super R>> C F3(@NotNull Iterable<? extends T> iterable, @NotNull C destination, @NotNull Function2<? super Integer, ? super T, ? extends R> transform) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(transform, "transform");
        int i6 = 0;
        for (T t5 : iterable) {
            int i7 = i6 + 1;
            if (i6 < 0) {
                h0.b0();
            }
            R invoke = transform.invoke(Integer.valueOf(i6), t5);
            if (invoke != null) {
                destination.add(invoke);
            }
            i6 = i7;
        }
        return destination;
    }

    @NotNull
    public static <T> List<T> F4(@NotNull Iterable<? extends T> iterable, T t5) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        if (iterable instanceof Collection) {
            return J4((Collection) iterable, t5);
        }
        ArrayList arrayList = new ArrayList();
        m0.s0(arrayList, iterable);
        arrayList.add(t5);
        return arrayList;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    @JvmName(name = "sumOfDouble")
    @OverloadResolutionByLambdaReturnType
    private static final <T> double F5(Iterable<? extends T> iterable, Function1<? super T, Double> selector) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        double d6 = 0.0d;
        while (it.hasNext()) {
            d6 += selector.invoke(it.next()).doubleValue();
        }
        return d6;
    }

    @NotNull
    public static final <T, K> Map<K, T> G1(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, ? extends K> keySelector) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.t.u(k1.j(i0.d0(iterable, 10)), 16));
        for (T t5 : iterable) {
            linkedHashMap.put(keySelector.invoke(t5), t5);
        }
        return linkedHashMap;
    }

    public static <T> T G2(@NotNull List<? extends T> list) {
        kotlin.jvm.internal.g0.p(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(0);
    }

    @NotNull
    public static final <T, R, C extends Collection<? super R>> C G3(@NotNull Iterable<? extends T> iterable, @NotNull C destination, @NotNull Function2<? super Integer, ? super T, ? extends R> transform) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(transform, "transform");
        int i6 = 0;
        for (T t5 : iterable) {
            int i7 = i6 + 1;
            if (i6 < 0) {
                h0.b0();
            }
            destination.add(transform.invoke(Integer.valueOf(i6), t5));
            i6 = i7;
        }
        return destination;
    }

    @NotNull
    public static final <T> List<T> G4(@NotNull Iterable<? extends T> iterable, @NotNull kotlin.sequences.m<? extends T> elements) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(elements, "elements");
        ArrayList arrayList = new ArrayList();
        m0.s0(arrayList, iterable);
        m0.t0(arrayList, elements);
        return arrayList;
    }

    @JvmName(name = "sumOfFloat")
    public static final float G5(@NotNull Iterable<Float> iterable) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        Iterator<Float> it = iterable.iterator();
        float f6 = 0.0f;
        while (it.hasNext()) {
            f6 += it.next().floatValue();
        }
        return f6;
    }

    @NotNull
    public static final <T, K, V> Map<K, V> H1(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, ? extends K> keySelector, @NotNull Function1<? super T, ? extends V> valueTransform) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(keySelector, "keySelector");
        kotlin.jvm.internal.g0.p(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.t.u(k1.j(i0.d0(iterable, 10)), 16));
        for (T t5 : iterable) {
            linkedHashMap.put(keySelector.invoke(t5), valueTransform.invoke(t5));
        }
        return linkedHashMap;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final <T, R> R H2(Iterable<? extends T> iterable, Function1<? super T, ? extends R> transform) {
        R r5;
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(transform, "transform");
        Iterator<? extends T> it = iterable.iterator();
        while (true) {
            if (!it.hasNext()) {
                r5 = null;
                break;
            }
            r5 = transform.invoke(it.next());
            if (r5 != null) {
                break;
            }
        }
        if (r5 != null) {
            return r5;
        }
        throw new NoSuchElementException("No element of the collection was transformed to a non-null value.");
    }

    @NotNull
    public static final <T, R> List<R> H3(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, ? extends R> transform) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            R invoke = transform.invoke(it.next());
            if (invoke != null) {
                arrayList.add(invoke);
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <T> List<T> H4(@NotNull Iterable<? extends T> iterable, @NotNull T[] elements) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(elements, "elements");
        if (iterable instanceof Collection) {
            return L4((Collection) iterable, elements);
        }
        ArrayList arrayList = new ArrayList();
        m0.s0(arrayList, iterable);
        m0.u0(arrayList, elements);
        return arrayList;
    }

    @JvmName(name = "sumOfInt")
    public static int H5(@NotNull Iterable<Integer> iterable) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        Iterator<Integer> it = iterable.iterator();
        int i6 = 0;
        while (it.hasNext()) {
            i6 += it.next().intValue();
        }
        return i6;
    }

    @NotNull
    public static final <T, K, M extends Map<? super K, ? super T>> M I1(@NotNull Iterable<? extends T> iterable, @NotNull M destination, @NotNull Function1<? super T, ? extends K> keySelector) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(keySelector, "keySelector");
        for (T t5 : iterable) {
            destination.put(keySelector.invoke(t5), t5);
        }
        return destination;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final <T, R> R I2(Iterable<? extends T> iterable, Function1<? super T, ? extends R> transform) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(transform, "transform");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            R invoke = transform.invoke(it.next());
            if (invoke != null) {
                return invoke;
            }
        }
        return null;
    }

    @NotNull
    public static final <T, R, C extends Collection<? super R>> C I3(@NotNull Iterable<? extends T> iterable, @NotNull C destination, @NotNull Function1<? super T, ? extends R> transform) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(transform, "transform");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            R invoke = transform.invoke(it.next());
            if (invoke != null) {
                destination.add(invoke);
            }
        }
        return destination;
    }

    @NotNull
    public static <T> List<T> I4(@NotNull Collection<? extends T> collection, @NotNull Iterable<? extends T> elements) {
        kotlin.jvm.internal.g0.p(collection, "<this>");
        kotlin.jvm.internal.g0.p(elements, "elements");
        if (!(elements instanceof Collection)) {
            ArrayList arrayList = new ArrayList(collection);
            m0.s0(arrayList, elements);
            return arrayList;
        }
        Collection collection2 = (Collection) elements;
        ArrayList arrayList2 = new ArrayList(collection.size() + collection2.size());
        arrayList2.addAll(collection);
        arrayList2.addAll(collection2);
        return arrayList2;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    @JvmName(name = "sumOfInt")
    private static final <T> int I5(Iterable<? extends T> iterable, Function1<? super T, Integer> selector) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        int i6 = 0;
        while (it.hasNext()) {
            i6 += selector.invoke(it.next()).intValue();
        }
        return i6;
    }

    @NotNull
    public static final <T, K, V, M extends Map<? super K, ? super V>> M J1(@NotNull Iterable<? extends T> iterable, @NotNull M destination, @NotNull Function1<? super T, ? extends K> keySelector, @NotNull Function1<? super T, ? extends V> valueTransform) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(keySelector, "keySelector");
        kotlin.jvm.internal.g0.p(valueTransform, "valueTransform");
        for (T t5 : iterable) {
            destination.put(keySelector.invoke(t5), valueTransform.invoke(t5));
        }
        return destination;
    }

    @Nullable
    public static <T> T J2(@NotNull Iterable<? extends T> iterable) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (list.isEmpty()) {
                return null;
            }
            return (T) list.get(0);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }

    @NotNull
    public static final <T, R, C extends Collection<? super R>> C J3(@NotNull Iterable<? extends T> iterable, @NotNull C destination, @NotNull Function1<? super T, ? extends R> transform) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(transform, "transform");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            destination.add(transform.invoke(it.next()));
        }
        return destination;
    }

    @NotNull
    public static <T> List<T> J4(@NotNull Collection<? extends T> collection, T t5) {
        kotlin.jvm.internal.g0.p(collection, "<this>");
        ArrayList arrayList = new ArrayList(collection.size() + 1);
        arrayList.addAll(collection);
        arrayList.add(t5);
        return arrayList;
    }

    @JvmName(name = "sumOfLong")
    public static final long J5(@NotNull Iterable<Long> iterable) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        Iterator<Long> it = iterable.iterator();
        long j6 = 0;
        while (it.hasNext()) {
            j6 += it.next().longValue();
        }
        return j6;
    }

    @NotNull
    public static final <T, K, V, M extends Map<? super K, ? super V>> M K1(@NotNull Iterable<? extends T> iterable, @NotNull M destination, @NotNull Function1<? super T, ? extends Pair<? extends K, ? extends V>> transform) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(transform, "transform");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            Pair<? extends K, ? extends V> invoke = transform.invoke(it.next());
            destination.put(invoke.getFirst(), invoke.getSecond());
        }
        return destination;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    @Nullable
    public static final <T> T K2(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (T t5 : iterable) {
            if (predicate.invoke(t5).booleanValue()) {
                return t5;
            }
        }
        return null;
    }

    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [T] */
    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final <T, R extends Comparable<? super R>> T K3(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        if (!it.hasNext()) {
            return next;
        }
        R invoke = selector.invoke(next);
        do {
            T next2 = it.next();
            R invoke2 = selector.invoke(next2);
            next = next;
            if (invoke.compareTo(invoke2) < 0) {
                invoke = invoke2;
                next = next2;
            }
        } while (it.hasNext());
        return (T) next;
    }

    @NotNull
    public static final <T> List<T> K4(@NotNull Collection<? extends T> collection, @NotNull kotlin.sequences.m<? extends T> elements) {
        kotlin.jvm.internal.g0.p(collection, "<this>");
        kotlin.jvm.internal.g0.p(elements, "elements");
        ArrayList arrayList = new ArrayList(collection.size() + 10);
        arrayList.addAll(collection);
        m0.t0(arrayList, elements);
        return arrayList;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    @JvmName(name = "sumOfLong")
    @OverloadResolutionByLambdaReturnType
    private static final <T> long K5(Iterable<? extends T> iterable, Function1<? super T, Long> selector) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        long j6 = 0;
        while (it.hasNext()) {
            j6 += selector.invoke(it.next()).longValue();
        }
        return j6;
    }

    @SinceKotlin(version = "1.3")
    @NotNull
    public static final <K, V> Map<K, V> L1(@NotNull Iterable<? extends K> iterable, @NotNull Function1<? super K, ? extends V> valueSelector) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(valueSelector, "valueSelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.t.u(k1.j(i0.d0(iterable, 10)), 16));
        for (K k6 : iterable) {
            linkedHashMap.put(k6, valueSelector.invoke(k6));
        }
        return linkedHashMap;
    }

    @Nullable
    public static <T> T L2(@NotNull List<? extends T> list) {
        kotlin.jvm.internal.g0.p(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [T] */
    @SinceKotlin(version = "1.7")
    @JvmName(name = "maxByOrThrow")
    public static final <T, R extends Comparable<? super R>> T L3(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        T next = it.next();
        if (!it.hasNext()) {
            return next;
        }
        R invoke = selector.invoke(next);
        do {
            T next2 = it.next();
            R invoke2 = selector.invoke(next2);
            next = next;
            if (invoke.compareTo(invoke2) < 0) {
                invoke = invoke2;
                next = next2;
            }
        } while (it.hasNext());
        return (T) next;
    }

    @NotNull
    public static final <T> List<T> L4(@NotNull Collection<? extends T> collection, @NotNull T[] elements) {
        kotlin.jvm.internal.g0.p(collection, "<this>");
        kotlin.jvm.internal.g0.p(elements, "elements");
        ArrayList arrayList = new ArrayList(collection.size() + elements.length);
        arrayList.addAll(collection);
        m0.u0(arrayList, elements);
        return arrayList;
    }

    @JvmName(name = "sumOfShort")
    public static final int L5(@NotNull Iterable<Short> iterable) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        Iterator<Short> it = iterable.iterator();
        int i6 = 0;
        while (it.hasNext()) {
            i6 += it.next().shortValue();
        }
        return i6;
    }

    @SinceKotlin(version = "1.3")
    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M M1(@NotNull Iterable<? extends K> iterable, @NotNull M destination, @NotNull Function1<? super K, ? extends V> valueSelector) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(valueSelector, "valueSelector");
        for (K k6 : iterable) {
            destination.put(k6, valueSelector.invoke(k6));
        }
        return destination;
    }

    @NotNull
    public static final <T, R> List<R> M2(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            m0.s0(arrayList, transform.invoke(it.next()));
        }
        return arrayList;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <T> double M3(Iterable<? extends T> iterable, Function1<? super T, Double> selector) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        double doubleValue = selector.invoke(it.next()).doubleValue();
        while (it.hasNext()) {
            doubleValue = Math.max(doubleValue, selector.invoke(it.next()).doubleValue());
        }
        return doubleValue;
    }

    @InlineOnly
    private static final <T> List<T> M4(Iterable<? extends T> iterable, T t5) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        return F4(iterable, t5);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @JvmName(name = "sumOfUInt")
    private static final <T> int M5(Iterable<? extends T> iterable, Function1<? super T, kotlin.z0> selector) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        int k6 = kotlin.z0.k(0);
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            k6 = kotlin.z0.k(k6 + selector.invoke(it.next()).q0());
        }
        return k6;
    }

    @JvmName(name = "averageOfByte")
    public static final double N1(@NotNull Iterable<Byte> iterable) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        Iterator<Byte> it = iterable.iterator();
        double d6 = 0.0d;
        int i6 = 0;
        while (it.hasNext()) {
            d6 += it.next().byteValue();
            i6++;
            if (i6 < 0) {
                h0.a0();
            }
        }
        if (i6 == 0) {
            return Double.NaN;
        }
        return d6 / i6;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    @JvmName(name = "flatMapIndexedIterable")
    @OverloadResolutionByLambdaReturnType
    private static final <T, R> List<R> N2(Iterable<? extends T> iterable, Function2<? super Integer, ? super T, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int i6 = 0;
        for (T t5 : iterable) {
            int i7 = i6 + 1;
            if (i6 < 0) {
                h0.b0();
            }
            m0.s0(arrayList, transform.invoke(Integer.valueOf(i6), t5));
            i6 = i7;
        }
        return arrayList;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <T> float N3(Iterable<? extends T> iterable, Function1<? super T, Float> selector) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        float floatValue = selector.invoke(it.next()).floatValue();
        while (it.hasNext()) {
            floatValue = Math.max(floatValue, selector.invoke(it.next()).floatValue());
        }
        return floatValue;
    }

    @InlineOnly
    private static final <T> List<T> N4(Collection<? extends T> collection, T t5) {
        kotlin.jvm.internal.g0.p(collection, "<this>");
        return J4(collection, t5);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @JvmName(name = "sumOfULong")
    @OverloadResolutionByLambdaReturnType
    private static final <T> long N5(Iterable<? extends T> iterable, Function1<? super T, kotlin.d1> selector) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        long k6 = kotlin.d1.k(0L);
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            k6 = kotlin.d1.k(k6 + selector.invoke(it.next()).q0());
        }
        return k6;
    }

    @JvmName(name = "averageOfDouble")
    public static double O1(@NotNull Iterable<Double> iterable) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        Iterator<Double> it = iterable.iterator();
        double d6 = 0.0d;
        int i6 = 0;
        while (it.hasNext()) {
            d6 += it.next().doubleValue();
            i6++;
            if (i6 < 0) {
                h0.a0();
            }
        }
        if (i6 == 0) {
            return Double.NaN;
        }
        return d6 / i6;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    @JvmName(name = "flatMapIndexedIterableTo")
    @OverloadResolutionByLambdaReturnType
    private static final <T, R, C extends Collection<? super R>> C O2(Iterable<? extends T> iterable, C destination, Function2<? super Integer, ? super T, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(transform, "transform");
        int i6 = 0;
        for (T t5 : iterable) {
            int i7 = i6 + 1;
            if (i6 < 0) {
                h0.b0();
            }
            m0.s0(destination, transform.invoke(Integer.valueOf(i6), t5));
            i6 = i7;
        }
        return destination;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <T, R extends Comparable<? super R>> R O3(Iterable<? extends T> iterable, Function1<? super T, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        R invoke = selector.invoke(it.next());
        while (it.hasNext()) {
            R invoke2 = selector.invoke(it.next());
            if (invoke.compareTo(invoke2) < 0) {
                invoke = invoke2;
            }
        }
        return invoke;
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <T> T O4(Collection<? extends T> collection) {
        kotlin.jvm.internal.g0.p(collection, "<this>");
        return (T) P4(collection, Random.Default);
    }

    @NotNull
    public static final <T> List<T> O5(@NotNull Iterable<? extends T> iterable, int i6) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        if (i6 < 0) {
            throw new IllegalArgumentException(("Requested element count " + i6 + " is less than zero.").toString());
        }
        if (i6 == 0) {
            return h0.J();
        }
        if (iterable instanceof Collection) {
            if (i6 >= ((Collection) iterable).size()) {
                return a6(iterable);
            }
            if (i6 == 1) {
                return g0.l(E2(iterable));
            }
        }
        ArrayList arrayList = new ArrayList(i6);
        Iterator<? extends T> it = iterable.iterator();
        int i7 = 0;
        while (it.hasNext()) {
            arrayList.add(it.next());
            i7++;
            if (i7 == i6) {
                break;
            }
        }
        return h0.V(arrayList);
    }

    @JvmName(name = "averageOfFloat")
    public static final double P1(@NotNull Iterable<Float> iterable) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        Iterator<Float> it = iterable.iterator();
        double d6 = 0.0d;
        int i6 = 0;
        while (it.hasNext()) {
            d6 += it.next().floatValue();
            i6++;
            if (i6 < 0) {
                h0.a0();
            }
        }
        if (i6 == 0) {
            return Double.NaN;
        }
        return d6 / i6;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    @JvmName(name = "flatMapIndexedSequence")
    @OverloadResolutionByLambdaReturnType
    private static final <T, R> List<R> P2(Iterable<? extends T> iterable, Function2<? super Integer, ? super T, ? extends kotlin.sequences.m<? extends R>> transform) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int i6 = 0;
        for (T t5 : iterable) {
            int i7 = i6 + 1;
            if (i6 < 0) {
                h0.b0();
            }
            m0.t0(arrayList, transform.invoke(Integer.valueOf(i6), t5));
            i6 = i7;
        }
        return arrayList;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <T, R extends Comparable<? super R>> R P3(Iterable<? extends T> iterable, Function1<? super T, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        R invoke = selector.invoke(it.next());
        while (it.hasNext()) {
            R invoke2 = selector.invoke(it.next());
            if (invoke.compareTo(invoke2) < 0) {
                invoke = invoke2;
            }
        }
        return invoke;
    }

    @SinceKotlin(version = "1.3")
    public static final <T> T P4(@NotNull Collection<? extends T> collection, @NotNull Random random) {
        kotlin.jvm.internal.g0.p(collection, "<this>");
        kotlin.jvm.internal.g0.p(random, "random");
        if (collection.isEmpty()) {
            throw new NoSuchElementException("Collection is empty.");
        }
        return (T) k2(collection, random.nextInt(collection.size()));
    }

    @NotNull
    public static <T> List<T> P5(@NotNull List<? extends T> list, int i6) {
        kotlin.jvm.internal.g0.p(list, "<this>");
        if (i6 < 0) {
            throw new IllegalArgumentException(("Requested element count " + i6 + " is less than zero.").toString());
        }
        if (i6 == 0) {
            return h0.J();
        }
        int size = list.size();
        if (i6 >= size) {
            return a6(list);
        }
        if (i6 == 1) {
            return g0.l(u3(list));
        }
        ArrayList arrayList = new ArrayList(i6);
        if (list instanceof RandomAccess) {
            for (int i7 = size - i6; i7 < size; i7++) {
                arrayList.add(list.get(i7));
            }
        } else {
            ListIterator<? extends T> listIterator = list.listIterator(size - i6);
            while (listIterator.hasNext()) {
                arrayList.add(listIterator.next());
            }
        }
        return arrayList;
    }

    @JvmName(name = "averageOfInt")
    public static double Q1(@NotNull Iterable<Integer> iterable) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        Iterator<Integer> it = iterable.iterator();
        double d6 = 0.0d;
        int i6 = 0;
        while (it.hasNext()) {
            d6 += it.next().intValue();
            i6++;
            if (i6 < 0) {
                h0.a0();
            }
        }
        if (i6 == 0) {
            return Double.NaN;
        }
        return d6 / i6;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    @JvmName(name = "flatMapIndexedSequenceTo")
    @OverloadResolutionByLambdaReturnType
    private static final <T, R, C extends Collection<? super R>> C Q2(Iterable<? extends T> iterable, C destination, Function2<? super Integer, ? super T, ? extends kotlin.sequences.m<? extends R>> transform) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(transform, "transform");
        int i6 = 0;
        for (T t5 : iterable) {
            int i7 = i6 + 1;
            if (i6 < 0) {
                h0.b0();
            }
            m0.t0(destination, transform.invoke(Integer.valueOf(i6), t5));
            i6 = i7;
        }
        return destination;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <T> Double Q3(Iterable<? extends T> iterable, Function1<? super T, Double> selector) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        double doubleValue = selector.invoke(it.next()).doubleValue();
        while (it.hasNext()) {
            doubleValue = Math.max(doubleValue, selector.invoke(it.next()).doubleValue());
        }
        return Double.valueOf(doubleValue);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final <T> T Q4(Collection<? extends T> collection) {
        kotlin.jvm.internal.g0.p(collection, "<this>");
        return (T) R4(collection, Random.Default);
    }

    @NotNull
    public static final <T> List<T> Q5(@NotNull List<? extends T> list, @NotNull Function1<? super T, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(list, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        if (list.isEmpty()) {
            return h0.J();
        }
        ListIterator<? extends T> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            if (!predicate.invoke(listIterator.previous()).booleanValue()) {
                listIterator.next();
                int size = list.size() - listIterator.nextIndex();
                if (size == 0) {
                    return h0.J();
                }
                ArrayList arrayList = new ArrayList(size);
                while (listIterator.hasNext()) {
                    arrayList.add(listIterator.next());
                }
                return arrayList;
            }
        }
        return a6(list);
    }

    @JvmName(name = "averageOfLong")
    public static final double R1(@NotNull Iterable<Long> iterable) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        Iterator<Long> it = iterable.iterator();
        double d6 = 0.0d;
        int i6 = 0;
        while (it.hasNext()) {
            d6 += it.next().longValue();
            i6++;
            if (i6 < 0) {
                h0.a0();
            }
        }
        if (i6 == 0) {
            return Double.NaN;
        }
        return d6 / i6;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @JvmName(name = "flatMapSequence")
    @NotNull
    @OverloadResolutionByLambdaReturnType
    public static final <T, R> List<R> R2(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, ? extends kotlin.sequences.m<? extends R>> transform) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            m0.t0(arrayList, transform.invoke(it.next()));
        }
        return arrayList;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <T> Float R3(Iterable<? extends T> iterable, Function1<? super T, Float> selector) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        float floatValue = selector.invoke(it.next()).floatValue();
        while (it.hasNext()) {
            floatValue = Math.max(floatValue, selector.invoke(it.next()).floatValue());
        }
        return Float.valueOf(floatValue);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final <T> T R4(@NotNull Collection<? extends T> collection, @NotNull Random random) {
        kotlin.jvm.internal.g0.p(collection, "<this>");
        kotlin.jvm.internal.g0.p(random, "random");
        if (collection.isEmpty()) {
            return null;
        }
        return (T) k2(collection, random.nextInt(collection.size()));
    }

    @NotNull
    public static final <T> List<T> R5(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (T t5 : iterable) {
            if (!predicate.invoke(t5).booleanValue()) {
                break;
            }
            arrayList.add(t5);
        }
        return arrayList;
    }

    @JvmName(name = "averageOfShort")
    public static final double S1(@NotNull Iterable<Short> iterable) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        Iterator<Short> it = iterable.iterator();
        double d6 = 0.0d;
        int i6 = 0;
        while (it.hasNext()) {
            d6 += it.next().shortValue();
            i6++;
            if (i6 < 0) {
                h0.a0();
            }
        }
        if (i6 == 0) {
            return Double.NaN;
        }
        return d6 / i6;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @JvmName(name = "flatMapSequenceTo")
    @NotNull
    @OverloadResolutionByLambdaReturnType
    public static final <T, R, C extends Collection<? super R>> C S2(@NotNull Iterable<? extends T> iterable, @NotNull C destination, @NotNull Function1<? super T, ? extends kotlin.sequences.m<? extends R>> transform) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(transform, "transform");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            m0.t0(destination, transform.invoke(it.next()));
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <T, R> R S3(Iterable<? extends T> iterable, Comparator<? super R> comparator, Function1<? super T, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        kotlin.jvm.internal.g0.p(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        Object obj = (R) selector.invoke((T) it.next());
        while (it.hasNext()) {
            Object obj2 = (R) selector.invoke((T) it.next());
            if (comparator.compare(obj, obj2) < 0) {
                obj = (R) obj2;
            }
        }
        return (R) obj;
    }

    public static final <S, T extends S> S S4(@NotNull Iterable<? extends T> iterable, @NotNull Function2<? super S, ? super T, ? extends S> operation) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new UnsupportedOperationException("Empty collection can't be reduced.");
        }
        S next = it.next();
        while (it.hasNext()) {
            next = operation.invoke(next, it.next());
        }
        return next;
    }

    @NotNull
    public static final boolean[] S5(@NotNull Collection<Boolean> collection) {
        kotlin.jvm.internal.g0.p(collection, "<this>");
        boolean[] zArr = new boolean[collection.size()];
        Iterator<Boolean> it = collection.iterator();
        int i6 = 0;
        while (it.hasNext()) {
            zArr[i6] = it.next().booleanValue();
            i6++;
        }
        return zArr;
    }

    @SinceKotlin(version = "1.2")
    @NotNull
    public static final <T> List<List<T>> T1(@NotNull Iterable<? extends T> iterable, int i6) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        return i6(iterable, i6, i6, true);
    }

    @NotNull
    public static final <T, R, C extends Collection<? super R>> C T2(@NotNull Iterable<? extends T> iterable, @NotNull C destination, @NotNull Function1<? super T, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(transform, "transform");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            m0.s0(destination, transform.invoke(it.next()));
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <T, R> R T3(Iterable<? extends T> iterable, Comparator<? super R> comparator, Function1<? super T, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        kotlin.jvm.internal.g0.p(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        Object obj = (R) selector.invoke((T) it.next());
        while (it.hasNext()) {
            Object obj2 = (R) selector.invoke((T) it.next());
            if (comparator.compare(obj, obj2) < 0) {
                obj = (R) obj2;
            }
        }
        return (R) obj;
    }

    public static final <S, T extends S> S T4(@NotNull Iterable<? extends T> iterable, @NotNull Function3<? super Integer, ? super S, ? super T, ? extends S> operation) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new UnsupportedOperationException("Empty collection can't be reduced.");
        }
        S next = it.next();
        int i6 = 1;
        while (it.hasNext()) {
            int i7 = i6 + 1;
            if (i6 < 0) {
                h0.b0();
            }
            next = operation.invoke(Integer.valueOf(i6), next, it.next());
            i6 = i7;
        }
        return next;
    }

    @NotNull
    public static byte[] T5(@NotNull Collection<Byte> collection) {
        kotlin.jvm.internal.g0.p(collection, "<this>");
        byte[] bArr = new byte[collection.size()];
        Iterator<Byte> it = collection.iterator();
        int i6 = 0;
        while (it.hasNext()) {
            bArr[i6] = it.next().byteValue();
            i6++;
        }
        return bArr;
    }

    @SinceKotlin(version = "1.2")
    @NotNull
    public static final <T, R> List<R> U1(@NotNull Iterable<? extends T> iterable, int i6, @NotNull Function1<? super List<? extends T>, ? extends R> transform) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(transform, "transform");
        return j6(iterable, i6, i6, true, transform);
    }

    public static final <T, R> R U2(@NotNull Iterable<? extends T> iterable, R r5, @NotNull Function2<? super R, ? super T, ? extends R> operation) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            r5 = operation.invoke(r5, it.next());
        }
        return r5;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static <T extends Comparable<? super T>> T U3(@NotNull Iterable<? extends T> iterable) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (next.compareTo(next2) < 0) {
                next = next2;
            }
        }
        return next;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final <S, T extends S> S U4(@NotNull Iterable<? extends T> iterable, @NotNull Function3<? super Integer, ? super S, ? super T, ? extends S> operation) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        S next = it.next();
        int i6 = 1;
        while (it.hasNext()) {
            int i7 = i6 + 1;
            if (i6 < 0) {
                h0.b0();
            }
            next = operation.invoke(Integer.valueOf(i6), next, it.next());
            i6 = i7;
        }
        return next;
    }

    @NotNull
    public static final char[] U5(@NotNull Collection<Character> collection) {
        kotlin.jvm.internal.g0.p(collection, "<this>");
        char[] cArr = new char[collection.size()];
        Iterator<Character> it = collection.iterator();
        int i6 = 0;
        while (it.hasNext()) {
            cArr[i6] = it.next().charValue();
            i6++;
        }
        return cArr;
    }

    @InlineOnly
    private static final <T> T V1(List<? extends T> list) {
        kotlin.jvm.internal.g0.p(list, "<this>");
        return list.get(0);
    }

    public static final <T, R> R V2(@NotNull Iterable<? extends T> iterable, R r5, @NotNull Function3<? super Integer, ? super R, ? super T, ? extends R> operation) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        int i6 = 0;
        for (T t5 : iterable) {
            int i7 = i6 + 1;
            if (i6 < 0) {
                h0.b0();
            }
            r5 = operation.invoke(Integer.valueOf(i6), r5, t5);
            i6 = i7;
        }
        return r5;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static Double V3(@NotNull Iterable<Double> iterable) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        Iterator<Double> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        double doubleValue = it.next().doubleValue();
        while (it.hasNext()) {
            doubleValue = Math.max(doubleValue, it.next().doubleValue());
        }
        return Double.valueOf(doubleValue);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final <S, T extends S> S V4(@NotNull Iterable<? extends T> iterable, @NotNull Function2<? super S, ? super T, ? extends S> operation) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        S next = it.next();
        while (it.hasNext()) {
            next = operation.invoke(next, it.next());
        }
        return next;
    }

    @NotNull
    public static final <T, C extends Collection<? super T>> C V5(@NotNull Iterable<? extends T> iterable, @NotNull C destination) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            destination.add(it.next());
        }
        return destination;
    }

    @InlineOnly
    private static final <T> T W1(List<? extends T> list) {
        kotlin.jvm.internal.g0.p(list, "<this>");
        return list.get(1);
    }

    public static final <T, R> R W2(@NotNull List<? extends T> list, R r5, @NotNull Function2<? super T, ? super R, ? extends R> operation) {
        kotlin.jvm.internal.g0.p(list, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        if (!list.isEmpty()) {
            ListIterator<? extends T> listIterator = list.listIterator(list.size());
            while (listIterator.hasPrevious()) {
                r5 = operation.invoke(listIterator.previous(), r5);
            }
        }
        return r5;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final Float W3(@NotNull Iterable<Float> iterable) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        Iterator<Float> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        float floatValue = it.next().floatValue();
        while (it.hasNext()) {
            floatValue = Math.max(floatValue, it.next().floatValue());
        }
        return Float.valueOf(floatValue);
    }

    public static final <S, T extends S> S W4(@NotNull List<? extends T> list, @NotNull Function2<? super T, ? super S, ? extends S> operation) {
        kotlin.jvm.internal.g0.p(list, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        ListIterator<? extends T> listIterator = list.listIterator(list.size());
        if (!listIterator.hasPrevious()) {
            throw new UnsupportedOperationException("Empty list can't be reduced.");
        }
        S previous = listIterator.previous();
        while (listIterator.hasPrevious()) {
            previous = operation.invoke(listIterator.previous(), previous);
        }
        return previous;
    }

    @NotNull
    public static double[] W5(@NotNull Collection<Double> collection) {
        kotlin.jvm.internal.g0.p(collection, "<this>");
        double[] dArr = new double[collection.size()];
        Iterator<Double> it = collection.iterator();
        int i6 = 0;
        while (it.hasNext()) {
            dArr[i6] = it.next().doubleValue();
            i6++;
        }
        return dArr;
    }

    @InlineOnly
    private static final <T> T X1(List<? extends T> list) {
        kotlin.jvm.internal.g0.p(list, "<this>");
        return list.get(2);
    }

    public static final <T, R> R X2(@NotNull List<? extends T> list, R r5, @NotNull Function3<? super Integer, ? super T, ? super R, ? extends R> operation) {
        kotlin.jvm.internal.g0.p(list, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        if (!list.isEmpty()) {
            ListIterator<? extends T> listIterator = list.listIterator(list.size());
            while (listIterator.hasPrevious()) {
                r5 = operation.invoke(Integer.valueOf(listIterator.previousIndex()), listIterator.previous(), r5);
            }
        }
        return r5;
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "maxOrThrow")
    public static final double X3(@NotNull Iterable<Double> iterable) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        Iterator<Double> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        double doubleValue = it.next().doubleValue();
        while (it.hasNext()) {
            doubleValue = Math.max(doubleValue, it.next().doubleValue());
        }
        return doubleValue;
    }

    public static final <S, T extends S> S X4(@NotNull List<? extends T> list, @NotNull Function3<? super Integer, ? super T, ? super S, ? extends S> operation) {
        kotlin.jvm.internal.g0.p(list, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        ListIterator<? extends T> listIterator = list.listIterator(list.size());
        if (!listIterator.hasPrevious()) {
            throw new UnsupportedOperationException("Empty list can't be reduced.");
        }
        S previous = listIterator.previous();
        while (listIterator.hasPrevious()) {
            previous = operation.invoke(Integer.valueOf(listIterator.previousIndex()), listIterator.previous(), previous);
        }
        return previous;
    }

    @NotNull
    public static final float[] X5(@NotNull Collection<Float> collection) {
        kotlin.jvm.internal.g0.p(collection, "<this>");
        float[] fArr = new float[collection.size()];
        Iterator<Float> it = collection.iterator();
        int i6 = 0;
        while (it.hasNext()) {
            fArr[i6] = it.next().floatValue();
            i6++;
        }
        return fArr;
    }

    @InlineOnly
    private static final <T> T Y1(List<? extends T> list) {
        kotlin.jvm.internal.g0.p(list, "<this>");
        return list.get(3);
    }

    @HidesMembers
    public static final <T> void Y2(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, kotlin.n1> action) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(action, "action");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            action.invoke(it.next());
        }
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "maxOrThrow")
    public static final float Y3(@NotNull Iterable<Float> iterable) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        Iterator<Float> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        float floatValue = it.next().floatValue();
        while (it.hasNext()) {
            floatValue = Math.max(floatValue, it.next().floatValue());
        }
        return floatValue;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final <S, T extends S> S Y4(@NotNull List<? extends T> list, @NotNull Function3<? super Integer, ? super T, ? super S, ? extends S> operation) {
        kotlin.jvm.internal.g0.p(list, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        ListIterator<? extends T> listIterator = list.listIterator(list.size());
        if (!listIterator.hasPrevious()) {
            return null;
        }
        S previous = listIterator.previous();
        while (listIterator.hasPrevious()) {
            previous = operation.invoke(Integer.valueOf(listIterator.previousIndex()), listIterator.previous(), previous);
        }
        return previous;
    }

    @NotNull
    public static final <T> HashSet<T> Y5(@NotNull Iterable<? extends T> iterable) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        return (HashSet) V5(iterable, new HashSet(k1.j(i0.d0(iterable, 12))));
    }

    @InlineOnly
    private static final <T> T Z1(List<? extends T> list) {
        kotlin.jvm.internal.g0.p(list, "<this>");
        return list.get(4);
    }

    public static final <T> void Z2(@NotNull Iterable<? extends T> iterable, @NotNull Function2<? super Integer, ? super T, kotlin.n1> action) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(action, "action");
        int i6 = 0;
        for (T t5 : iterable) {
            int i7 = i6 + 1;
            if (i6 < 0) {
                h0.b0();
            }
            action.invoke(Integer.valueOf(i6), t5);
            i6 = i7;
        }
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "maxOrThrow")
    @NotNull
    public static final <T extends Comparable<? super T>> T Z3(@NotNull Iterable<? extends T> iterable) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (next.compareTo(next2) < 0) {
                next = next2;
            }
        }
        return next;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final <S, T extends S> S Z4(@NotNull List<? extends T> list, @NotNull Function2<? super T, ? super S, ? extends S> operation) {
        kotlin.jvm.internal.g0.p(list, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        ListIterator<? extends T> listIterator = list.listIterator(list.size());
        if (!listIterator.hasPrevious()) {
            return null;
        }
        S previous = listIterator.previous();
        while (listIterator.hasPrevious()) {
            previous = operation.invoke(listIterator.previous(), previous);
        }
        return previous;
    }

    @NotNull
    public static int[] Z5(@NotNull Collection<Integer> collection) {
        kotlin.jvm.internal.g0.p(collection, "<this>");
        int[] iArr = new int[collection.size()];
        Iterator<Integer> it = collection.iterator();
        int i6 = 0;
        while (it.hasNext()) {
            iArr[i6] = it.next().intValue();
            i6++;
        }
        return iArr;
    }

    public static <T> boolean a2(@NotNull Iterable<? extends T> iterable, T t5) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        return iterable instanceof Collection ? ((Collection) iterable).contains(t5) : h3(iterable, t5) >= 0;
    }

    @InlineOnly
    private static final <T> T a3(List<? extends T> list, int i6, Function1<? super Integer, ? extends T> defaultValue) {
        kotlin.jvm.internal.g0.p(list, "<this>");
        kotlin.jvm.internal.g0.p(defaultValue, "defaultValue");
        return (i6 < 0 || i6 >= list.size()) ? defaultValue.invoke(Integer.valueOf(i6)) : list.get(i6);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final <T> T a4(@NotNull Iterable<? extends T> iterable, @NotNull Comparator<? super T> comparator) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        Object obj = (T) it.next();
        while (it.hasNext()) {
            Object obj2 = (T) it.next();
            if (comparator.compare(obj, obj2) < 0) {
                obj = (T) obj2;
            }
        }
        return (T) obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <T> Iterable<T> a5(@NotNull Iterable<? extends T> iterable) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new IllegalArgumentException("null element found in " + iterable + '.');
            }
        }
        return iterable;
    }

    @NotNull
    public static <T> List<T> a6(@NotNull Iterable<? extends T> iterable) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return h0.V(c6(iterable));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return h0.J();
        }
        if (size != 1) {
            return d6(collection);
        }
        return g0.l(iterable instanceof List ? ((List) iterable).get(0) : collection.iterator().next());
    }

    public static final <T> int b2(@NotNull Iterable<? extends T> iterable) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        if (iterable instanceof Collection) {
            return ((Collection) iterable).size();
        }
        Iterator<? extends T> it = iterable.iterator();
        int i6 = 0;
        while (it.hasNext()) {
            it.next();
            i6++;
            if (i6 < 0) {
                h0.a0();
            }
        }
        return i6;
    }

    @Nullable
    public static <T> T b3(@NotNull List<? extends T> list, int i6) {
        kotlin.jvm.internal.g0.p(list, "<this>");
        if (i6 < 0 || i6 >= list.size()) {
            return null;
        }
        return list.get(i6);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.7")
    @JvmName(name = "maxWithOrThrow")
    public static final <T> T b4(@NotNull Iterable<? extends T> iterable, @NotNull Comparator<? super T> comparator) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        Object obj = (T) it.next();
        while (it.hasNext()) {
            Object obj2 = (T) it.next();
            if (comparator.compare(obj, obj2) < 0) {
                obj = (T) obj2;
            }
        }
        return (T) obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <T> List<T> b5(@NotNull List<? extends T> list) {
        kotlin.jvm.internal.g0.p(list, "<this>");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new IllegalArgumentException("null element found in " + list + '.');
            }
        }
        return list;
    }

    @NotNull
    public static final long[] b6(@NotNull Collection<Long> collection) {
        kotlin.jvm.internal.g0.p(collection, "<this>");
        long[] jArr = new long[collection.size()];
        Iterator<Long> it = collection.iterator();
        int i6 = 0;
        while (it.hasNext()) {
            jArr[i6] = it.next().longValue();
            i6++;
        }
        return jArr;
    }

    public static final <T> int c2(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        int i6 = 0;
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return 0;
        }
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            if (predicate.invoke(it.next()).booleanValue() && (i6 = i6 + 1) < 0) {
                h0.a0();
            }
        }
        return i6;
    }

    @NotNull
    public static final <T, K> Map<K, List<T>> c3(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, ? extends K> keySelector) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (T t5 : iterable) {
            K invoke = keySelector.invoke(t5);
            Object obj = linkedHashMap.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(invoke, obj);
            }
            ((List) obj).add(t5);
        }
        return linkedHashMap;
    }

    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [T] */
    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final <T, R extends Comparable<? super R>> T c4(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        if (!it.hasNext()) {
            return next;
        }
        R invoke = selector.invoke(next);
        do {
            T next2 = it.next();
            R invoke2 = selector.invoke(next2);
            next = next;
            if (invoke.compareTo(invoke2) > 0) {
                invoke = invoke2;
                next = next2;
            }
        } while (it.hasNext());
        return (T) next;
    }

    @NotNull
    public static <T> List<T> c5(@NotNull Iterable<? extends T> iterable) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        if ((iterable instanceof Collection) && ((Collection) iterable).size() <= 1) {
            return a6(iterable);
        }
        List<T> c6 = c6(iterable);
        o0.t1(c6);
        return c6;
    }

    @NotNull
    public static final <T> List<T> c6(@NotNull Iterable<? extends T> iterable) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        return iterable instanceof Collection ? d6((Collection) iterable) : (List) V5(iterable, new ArrayList());
    }

    @InlineOnly
    private static final <T> int d2(Collection<? extends T> collection) {
        kotlin.jvm.internal.g0.p(collection, "<this>");
        return collection.size();
    }

    @NotNull
    public static final <T, K, V> Map<K, List<V>> d3(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, ? extends K> keySelector, @NotNull Function1<? super T, ? extends V> valueTransform) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(keySelector, "keySelector");
        kotlin.jvm.internal.g0.p(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (T t5 : iterable) {
            K invoke = keySelector.invoke(t5);
            List<V> list = linkedHashMap.get(invoke);
            if (list == null) {
                list = new ArrayList<>();
                linkedHashMap.put(invoke, list);
            }
            list.add(valueTransform.invoke(t5));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [T] */
    @SinceKotlin(version = "1.7")
    @JvmName(name = "minByOrThrow")
    public static final <T, R extends Comparable<? super R>> T d4(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        T next = it.next();
        if (!it.hasNext()) {
            return next;
        }
        R invoke = selector.invoke(next);
        do {
            T next2 = it.next();
            R invoke2 = selector.invoke(next2);
            next = next;
            if (invoke.compareTo(invoke2) > 0) {
                invoke = invoke2;
                next = next2;
            }
        } while (it.hasNext());
        return (T) next;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @NotNull
    public static final <T, R> List<R> d5(@NotNull Iterable<? extends T> iterable, R r5, @NotNull Function2<? super R, ? super T, ? extends R> operation) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        int d02 = i0.d0(iterable, 9);
        if (d02 == 0) {
            return g0.l(r5);
        }
        ArrayList arrayList = new ArrayList(d02 + 1);
        arrayList.add(r5);
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            r5 = operation.invoke(r5, it.next());
            arrayList.add(r5);
        }
        return arrayList;
    }

    @NotNull
    public static <T> List<T> d6(@NotNull Collection<? extends T> collection) {
        kotlin.jvm.internal.g0.p(collection, "<this>");
        return new ArrayList(collection);
    }

    @NotNull
    public static <T> List<T> e2(@NotNull Iterable<? extends T> iterable) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        return a6(e6(iterable));
    }

    @NotNull
    public static final <T, K, M extends Map<? super K, List<T>>> M e3(@NotNull Iterable<? extends T> iterable, @NotNull M destination, @NotNull Function1<? super T, ? extends K> keySelector) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(keySelector, "keySelector");
        for (T t5 : iterable) {
            K invoke = keySelector.invoke(t5);
            Object obj = destination.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                destination.put(invoke, obj);
            }
            ((List) obj).add(t5);
        }
        return destination;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <T> double e4(Iterable<? extends T> iterable, Function1<? super T, Double> selector) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        double doubleValue = selector.invoke(it.next()).doubleValue();
        while (it.hasNext()) {
            doubleValue = Math.min(doubleValue, selector.invoke(it.next()).doubleValue());
        }
        return doubleValue;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @NotNull
    public static final <T, R> List<R> e5(@NotNull Iterable<? extends T> iterable, R r5, @NotNull Function3<? super Integer, ? super R, ? super T, ? extends R> operation) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        int d02 = i0.d0(iterable, 9);
        if (d02 == 0) {
            return g0.l(r5);
        }
        ArrayList arrayList = new ArrayList(d02 + 1);
        arrayList.add(r5);
        Iterator<? extends T> it = iterable.iterator();
        int i6 = 0;
        while (it.hasNext()) {
            r5 = operation.invoke(Integer.valueOf(i6), r5, it.next());
            arrayList.add(r5);
            i6++;
        }
        return arrayList;
    }

    @NotNull
    public static <T> Set<T> e6(@NotNull Iterable<? extends T> iterable) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        return iterable instanceof Collection ? new LinkedHashSet((Collection) iterable) : (Set) V5(iterable, new LinkedHashSet());
    }

    @NotNull
    public static final <T, K> List<T> f2(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, ? extends K> selector) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (T t5 : iterable) {
            if (hashSet.add(selector.invoke(t5))) {
                arrayList.add(t5);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <T, K, V, M extends Map<? super K, List<V>>> M f3(@NotNull Iterable<? extends T> iterable, @NotNull M destination, @NotNull Function1<? super T, ? extends K> keySelector, @NotNull Function1<? super T, ? extends V> valueTransform) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(keySelector, "keySelector");
        kotlin.jvm.internal.g0.p(valueTransform, "valueTransform");
        for (T t5 : iterable) {
            K invoke = keySelector.invoke(t5);
            Object obj = destination.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                destination.put(invoke, obj);
            }
            ((List) obj).add(valueTransform.invoke(t5));
        }
        return destination;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <T> float f4(Iterable<? extends T> iterable, Function1<? super T, Float> selector) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        float floatValue = selector.invoke(it.next()).floatValue();
        while (it.hasNext()) {
            floatValue = Math.min(floatValue, selector.invoke(it.next()).floatValue());
        }
        return floatValue;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @NotNull
    public static final <S, T extends S> List<S> f5(@NotNull Iterable<? extends T> iterable, @NotNull Function2<? super S, ? super T, ? extends S> operation) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return h0.J();
        }
        S next = it.next();
        ArrayList arrayList = new ArrayList(i0.d0(iterable, 10));
        arrayList.add(next);
        while (it.hasNext()) {
            next = operation.invoke(next, it.next());
            arrayList.add(next);
        }
        return arrayList;
    }

    @NotNull
    public static <T> Set<T> f6(@NotNull Iterable<? extends T> iterable) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return w1.r((Set) V5(iterable, new LinkedHashSet()));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return w1.k();
        }
        if (size != 1) {
            return (Set) V5(iterable, new LinkedHashSet(k1.j(collection.size())));
        }
        return v1.f(iterable instanceof List ? ((List) iterable).get(0) : collection.iterator().next());
    }

    @NotNull
    public static <T> List<T> g2(@NotNull Iterable<? extends T> iterable, int i6) {
        ArrayList arrayList;
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        if (i6 < 0) {
            throw new IllegalArgumentException(("Requested element count " + i6 + " is less than zero.").toString());
        }
        if (i6 == 0) {
            return a6(iterable);
        }
        if (iterable instanceof Collection) {
            int size = ((Collection) iterable).size() - i6;
            if (size <= 0) {
                return h0.J();
            }
            if (size == 1) {
                return g0.l(s3(iterable));
            }
            arrayList = new ArrayList(size);
            if (iterable instanceof List) {
                if (iterable instanceof RandomAccess) {
                    List list = (List) iterable;
                    int size2 = list.size();
                    while (i6 < size2) {
                        arrayList.add(list.get(i6));
                        i6++;
                    }
                } else {
                    ListIterator listIterator = ((List) iterable).listIterator(i6);
                    while (listIterator.hasNext()) {
                        arrayList.add(listIterator.next());
                    }
                }
                return arrayList;
            }
        } else {
            arrayList = new ArrayList();
        }
        int i7 = 0;
        for (T t5 : iterable) {
            if (i7 >= i6) {
                arrayList.add(t5);
            } else {
                i7++;
            }
        }
        return h0.V(arrayList);
    }

    @SinceKotlin(version = "1.1")
    @NotNull
    public static final <T, K> w0<T, K> g3(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, ? extends K> keySelector) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(keySelector, "keySelector");
        return new b(iterable, keySelector);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <T, R extends Comparable<? super R>> R g4(Iterable<? extends T> iterable, Function1<? super T, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        R invoke = selector.invoke(it.next());
        while (it.hasNext()) {
            R invoke2 = selector.invoke(it.next());
            if (invoke.compareTo(invoke2) > 0) {
                invoke = invoke2;
            }
        }
        return invoke;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @NotNull
    public static final <S, T extends S> List<S> g5(@NotNull Iterable<? extends T> iterable, @NotNull Function3<? super Integer, ? super S, ? super T, ? extends S> operation) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return h0.J();
        }
        S next = it.next();
        ArrayList arrayList = new ArrayList(i0.d0(iterable, 10));
        arrayList.add(next);
        int i6 = 1;
        while (it.hasNext()) {
            next = operation.invoke(Integer.valueOf(i6), next, it.next());
            arrayList.add(next);
            i6++;
        }
        return arrayList;
    }

    @NotNull
    public static final short[] g6(@NotNull Collection<Short> collection) {
        kotlin.jvm.internal.g0.p(collection, "<this>");
        short[] sArr = new short[collection.size()];
        Iterator<Short> it = collection.iterator();
        int i6 = 0;
        while (it.hasNext()) {
            sArr[i6] = it.next().shortValue();
            i6++;
        }
        return sArr;
    }

    @NotNull
    public static <T> List<T> h2(@NotNull List<? extends T> list, int i6) {
        kotlin.jvm.internal.g0.p(list, "<this>");
        if (i6 >= 0) {
            return O5(list, kotlin.ranges.t.u(list.size() - i6, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i6 + " is less than zero.").toString());
    }

    public static final <T> int h3(@NotNull Iterable<? extends T> iterable, T t5) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        if (iterable instanceof List) {
            return ((List) iterable).indexOf(t5);
        }
        int i6 = 0;
        for (T t6 : iterable) {
            if (i6 < 0) {
                h0.b0();
            }
            if (kotlin.jvm.internal.g0.g(t5, t6)) {
                return i6;
            }
            i6++;
        }
        return -1;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <T, R extends Comparable<? super R>> R h4(Iterable<? extends T> iterable, Function1<? super T, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        R invoke = selector.invoke(it.next());
        while (it.hasNext()) {
            R invoke2 = selector.invoke(it.next());
            if (invoke.compareTo(invoke2) > 0) {
                invoke = invoke2;
            }
        }
        return invoke;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @NotNull
    public static final <T, R> List<R> h5(@NotNull Iterable<? extends T> iterable, R r5, @NotNull Function2<? super R, ? super T, ? extends R> operation) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        int d02 = i0.d0(iterable, 9);
        if (d02 == 0) {
            return g0.l(r5);
        }
        ArrayList arrayList = new ArrayList(d02 + 1);
        arrayList.add(r5);
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            r5 = operation.invoke(r5, it.next());
            arrayList.add(r5);
        }
        return arrayList;
    }

    @NotNull
    public static <T> Set<T> h6(@NotNull Iterable<? extends T> iterable, @NotNull Iterable<? extends T> other) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        Set<T> e6 = e6(iterable);
        m0.s0(e6, other);
        return e6;
    }

    @NotNull
    public static final <T> List<T> i2(@NotNull List<? extends T> list, @NotNull Function1<? super T, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(list, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        if (!list.isEmpty()) {
            ListIterator<? extends T> listIterator = list.listIterator(list.size());
            while (listIterator.hasPrevious()) {
                if (!predicate.invoke(listIterator.previous()).booleanValue()) {
                    return O5(list, listIterator.nextIndex() + 1);
                }
            }
        }
        return h0.J();
    }

    public static final <T> int i3(@NotNull List<? extends T> list, T t5) {
        kotlin.jvm.internal.g0.p(list, "<this>");
        return list.indexOf(t5);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <T> Double i4(Iterable<? extends T> iterable, Function1<? super T, Double> selector) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        double doubleValue = selector.invoke(it.next()).doubleValue();
        while (it.hasNext()) {
            doubleValue = Math.min(doubleValue, selector.invoke(it.next()).doubleValue());
        }
        return Double.valueOf(doubleValue);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @NotNull
    public static final <T, R> List<R> i5(@NotNull Iterable<? extends T> iterable, R r5, @NotNull Function3<? super Integer, ? super R, ? super T, ? extends R> operation) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        int d02 = i0.d0(iterable, 9);
        if (d02 == 0) {
            return g0.l(r5);
        }
        ArrayList arrayList = new ArrayList(d02 + 1);
        arrayList.add(r5);
        Iterator<? extends T> it = iterable.iterator();
        int i6 = 0;
        while (it.hasNext()) {
            r5 = operation.invoke(Integer.valueOf(i6), r5, it.next());
            arrayList.add(r5);
            i6++;
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.2")
    @NotNull
    public static final <T> List<List<T>> i6(@NotNull Iterable<? extends T> iterable, int i6, int i7, boolean z5) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        z1.a(i6, i7);
        if (!(iterable instanceof RandomAccess) || !(iterable instanceof List)) {
            ArrayList arrayList = new ArrayList();
            Iterator b6 = z1.b(iterable.iterator(), i6, i7, z5, false);
            while (b6.hasNext()) {
                arrayList.add((List) b6.next());
            }
            return arrayList;
        }
        List list = (List) iterable;
        int size = list.size();
        ArrayList arrayList2 = new ArrayList((size / i7) + (size % i7 == 0 ? 0 : 1));
        int i8 = 0;
        while (i8 >= 0 && i8 < size) {
            int B = kotlin.ranges.t.B(i6, size - i8);
            if (B < i6 && !z5) {
                return arrayList2;
            }
            ArrayList arrayList3 = new ArrayList(B);
            for (int i9 = 0; i9 < B; i9++) {
                arrayList3.add(list.get(i9 + i8));
            }
            arrayList2.add(arrayList3);
            i8 += i7;
        }
        return arrayList2;
    }

    @NotNull
    public static final <T> List<T> j2(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z5 = false;
        for (T t5 : iterable) {
            if (z5) {
                arrayList.add(t5);
            } else if (!predicate.invoke(t5).booleanValue()) {
                arrayList.add(t5);
                z5 = true;
            }
        }
        return arrayList;
    }

    public static final <T> int j3(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        int i6 = 0;
        for (T t5 : iterable) {
            if (i6 < 0) {
                h0.b0();
            }
            if (predicate.invoke(t5).booleanValue()) {
                return i6;
            }
            i6++;
        }
        return -1;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <T> Float j4(Iterable<? extends T> iterable, Function1<? super T, Float> selector) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        float floatValue = selector.invoke(it.next()).floatValue();
        while (it.hasNext()) {
            floatValue = Math.min(floatValue, selector.invoke(it.next()).floatValue());
        }
        return Float.valueOf(floatValue);
    }

    @SinceKotlin(version = "1.3")
    public static final <T> void j5(@NotNull List<T> list, @NotNull Random random) {
        kotlin.jvm.internal.g0.p(list, "<this>");
        kotlin.jvm.internal.g0.p(random, "random");
        for (int L = h0.L(list); L > 0; L--) {
            int nextInt = random.nextInt(L + 1);
            list.set(nextInt, list.set(L, list.get(nextInt)));
        }
    }

    @SinceKotlin(version = "1.2")
    @NotNull
    public static final <T, R> List<R> j6(@NotNull Iterable<? extends T> iterable, int i6, int i7, boolean z5, @NotNull Function1<? super List<? extends T>, ? extends R> transform) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(transform, "transform");
        z1.a(i6, i7);
        if (!(iterable instanceof RandomAccess) || !(iterable instanceof List)) {
            ArrayList arrayList = new ArrayList();
            Iterator b6 = z1.b(iterable.iterator(), i6, i7, z5, true);
            while (b6.hasNext()) {
                arrayList.add(transform.invoke((List) b6.next()));
            }
            return arrayList;
        }
        List list = (List) iterable;
        int size = list.size();
        int i8 = 0;
        ArrayList arrayList2 = new ArrayList((size / i7) + (size % i7 == 0 ? 0 : 1));
        o1 o1Var = new o1(list);
        while (i8 >= 0 && i8 < size) {
            int B = kotlin.ranges.t.B(i6, size - i8);
            if (!z5 && B < i6) {
                return arrayList2;
            }
            o1Var.e(i8, B + i8);
            arrayList2.add(transform.invoke(o1Var));
            i8 += i7;
        }
        return arrayList2;
    }

    public static <T> T k2(@NotNull Iterable<? extends T> iterable, final int i6) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        return iterable instanceof List ? (T) ((List) iterable).get(i6) : (T) n2(iterable, i6, new Function1() { // from class: kotlin.collections.q0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Object m22;
                m22 = r0.m2(i6, ((Integer) obj).intValue());
                return m22;
            }
        });
    }

    public static final <T> int k3(@NotNull List<? extends T> list, @NotNull Function1<? super T, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(list, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        Iterator<? extends T> it = list.iterator();
        int i6 = 0;
        while (it.hasNext()) {
            if (predicate.invoke(it.next()).booleanValue()) {
                return i6;
            }
            i6++;
        }
        return -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <T, R> R k4(Iterable<? extends T> iterable, Comparator<? super R> comparator, Function1<? super T, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        kotlin.jvm.internal.g0.p(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        Object obj = (R) selector.invoke((T) it.next());
        while (it.hasNext()) {
            Object obj2 = (R) selector.invoke((T) it.next());
            if (comparator.compare(obj, obj2) > 0) {
                obj = (R) obj2;
            }
        }
        return (R) obj;
    }

    public static <T> T k5(@NotNull Iterable<? extends T> iterable) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        if (iterable instanceof List) {
            return (T) m5((List) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException("Collection is empty.");
        }
        T next = it.next();
        if (it.hasNext()) {
            throw new IllegalArgumentException("Collection has more than one element.");
        }
        return next;
    }

    public static /* synthetic */ List k6(Iterable iterable, int i6, int i7, boolean z5, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            i7 = 1;
        }
        if ((i8 & 4) != 0) {
            z5 = false;
        }
        return i6(iterable, i6, i7, z5);
    }

    @InlineOnly
    private static final <T> T l2(List<? extends T> list, int i6) {
        kotlin.jvm.internal.g0.p(list, "<this>");
        return list.get(i6);
    }

    public static final <T> int l3(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        int i6 = -1;
        int i7 = 0;
        for (T t5 : iterable) {
            if (i7 < 0) {
                h0.b0();
            }
            if (predicate.invoke(t5).booleanValue()) {
                i6 = i7;
            }
            i7++;
        }
        return i6;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <T, R> R l4(Iterable<? extends T> iterable, Comparator<? super R> comparator, Function1<? super T, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        kotlin.jvm.internal.g0.p(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        Object obj = (R) selector.invoke((T) it.next());
        while (it.hasNext()) {
            Object obj2 = (R) selector.invoke((T) it.next());
            if (comparator.compare(obj, obj2) > 0) {
                obj = (R) obj2;
            }
        }
        return (R) obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object] */
    public static final <T> T l5(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        T t5 = null;
        boolean z5 = false;
        for (T t6 : iterable) {
            if (predicate.invoke(t6).booleanValue()) {
                if (z5) {
                    throw new IllegalArgumentException("Collection contains more than one matching element.");
                }
                z5 = true;
                t5 = t6;
            }
        }
        if (z5) {
            return t5;
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    public static /* synthetic */ List l6(Iterable iterable, int i6, int i7, boolean z5, Function1 function1, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            i7 = 1;
        }
        if ((i8 & 4) != 0) {
            z5 = false;
        }
        return j6(iterable, i6, i7, z5, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object m2(int i6, int i7) {
        throw new IndexOutOfBoundsException("Collection doesn't contain element at index " + i6 + '.');
    }

    public static final <T> int m3(@NotNull List<? extends T> list, @NotNull Function1<? super T, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(list, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        ListIterator<? extends T> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            if (predicate.invoke(listIterator.previous()).booleanValue()) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static <T extends Comparable<? super T>> T m4(@NotNull Iterable<? extends T> iterable) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (next.compareTo(next2) > 0) {
                next = next2;
            }
        }
        return next;
    }

    public static <T> T m5(@NotNull List<? extends T> list) {
        kotlin.jvm.internal.g0.p(list, "<this>");
        int size = list.size();
        if (size == 0) {
            throw new NoSuchElementException("List is empty.");
        }
        if (size == 1) {
            return list.get(0);
        }
        throw new IllegalArgumentException("List has more than one element.");
    }

    @NotNull
    public static <T> Iterable<a1<T>> m6(@NotNull final Iterable<? extends T> iterable) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        return new b1(new Function0() { // from class: kotlin.collections.p0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Iterator n6;
                n6 = r0.n6(iterable);
                return n6;
            }
        });
    }

    public static final <T> T n2(@NotNull Iterable<? extends T> iterable, int i6, @NotNull Function1<? super Integer, ? extends T> defaultValue) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(defaultValue, "defaultValue");
        if (iterable instanceof List) {
            List list = (List) iterable;
            return (i6 < 0 || i6 >= list.size()) ? defaultValue.invoke(Integer.valueOf(i6)) : (T) list.get(i6);
        }
        if (i6 < 0) {
            return defaultValue.invoke(Integer.valueOf(i6));
        }
        int i7 = 0;
        for (T t5 : iterable) {
            int i8 = i7 + 1;
            if (i6 == i7) {
                return t5;
            }
            i7 = i8;
        }
        return defaultValue.invoke(Integer.valueOf(i6));
    }

    @NotNull
    public static <T> Set<T> n3(@NotNull Iterable<? extends T> iterable, @NotNull Iterable<? extends T> other) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        Set<T> e6 = e6(iterable);
        m0.T0(e6, other);
        return e6;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static Double n4(@NotNull Iterable<Double> iterable) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        Iterator<Double> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        double doubleValue = it.next().doubleValue();
        while (it.hasNext()) {
            doubleValue = Math.min(doubleValue, it.next().doubleValue());
        }
        return Double.valueOf(doubleValue);
    }

    @Nullable
    public static <T> T n5(@NotNull Iterable<? extends T> iterable) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (list.size() == 1) {
                return (T) list.get(0);
            }
            return null;
        }
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        if (it.hasNext()) {
            return null;
        }
        return next;
    }

    @InlineOnly
    private static final <T> T o2(List<? extends T> list, int i6, Function1<? super Integer, ? extends T> defaultValue) {
        kotlin.jvm.internal.g0.p(list, "<this>");
        kotlin.jvm.internal.g0.p(defaultValue, "defaultValue");
        return (i6 < 0 || i6 >= list.size()) ? defaultValue.invoke(Integer.valueOf(i6)) : list.get(i6);
    }

    @NotNull
    public static final <T, A extends Appendable> A o3(@NotNull Iterable<? extends T> iterable, @NotNull A buffer, @NotNull CharSequence separator, @NotNull CharSequence prefix, @NotNull CharSequence postfix, int i6, @NotNull CharSequence truncated, @Nullable Function1<? super T, ? extends CharSequence> function1) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(buffer, "buffer");
        kotlin.jvm.internal.g0.p(separator, "separator");
        kotlin.jvm.internal.g0.p(prefix, "prefix");
        kotlin.jvm.internal.g0.p(postfix, "postfix");
        kotlin.jvm.internal.g0.p(truncated, "truncated");
        buffer.append(prefix);
        int i7 = 0;
        for (T t5 : iterable) {
            i7++;
            if (i7 > 1) {
                buffer.append(separator);
            }
            if (i6 >= 0 && i7 > i6) {
                break;
            }
            kotlin.text.u.b(buffer, t5, function1);
        }
        if (i6 >= 0 && i7 > i6) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final Float o4(@NotNull Iterable<Float> iterable) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        Iterator<Float> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        float floatValue = it.next().floatValue();
        while (it.hasNext()) {
            floatValue = Math.min(floatValue, it.next().floatValue());
        }
        return Float.valueOf(floatValue);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Object] */
    @Nullable
    public static final <T> T o5(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        boolean z5 = false;
        T t5 = null;
        for (T t6 : iterable) {
            if (predicate.invoke(t6).booleanValue()) {
                if (z5) {
                    return null;
                }
                z5 = true;
                t5 = t6;
            }
        }
        if (z5) {
            return t5;
        }
        return null;
    }

    @NotNull
    public static <T, R> List<Pair<T, R>> o6(@NotNull Iterable<? extends T> iterable, @NotNull Iterable<? extends R> other) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        Iterator<? extends T> it = iterable.iterator();
        Iterator<? extends R> it2 = other.iterator();
        ArrayList arrayList = new ArrayList(Math.min(i0.d0(iterable, 10), i0.d0(other, 10)));
        while (it.hasNext() && it2.hasNext()) {
            arrayList.add(kotlin.o0.a(it.next(), it2.next()));
        }
        return arrayList;
    }

    @Nullable
    public static final <T> T p2(@NotNull Iterable<? extends T> iterable, int i6) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        if (iterable instanceof List) {
            return (T) b3((List) iterable, i6);
        }
        if (i6 < 0) {
            return null;
        }
        int i7 = 0;
        for (T t5 : iterable) {
            int i8 = i7 + 1;
            if (i6 == i7) {
                return t5;
            }
            i7 = i8;
        }
        return null;
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "minOrThrow")
    public static final double p4(@NotNull Iterable<Double> iterable) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        Iterator<Double> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        double doubleValue = it.next().doubleValue();
        while (it.hasNext()) {
            doubleValue = Math.min(doubleValue, it.next().doubleValue());
        }
        return doubleValue;
    }

    @Nullable
    public static <T> T p5(@NotNull List<? extends T> list) {
        kotlin.jvm.internal.g0.p(list, "<this>");
        if (list.size() == 1) {
            return list.get(0);
        }
        return null;
    }

    @NotNull
    public static final <T, R, V> List<V> p6(@NotNull Iterable<? extends T> iterable, @NotNull Iterable<? extends R> other, @NotNull Function2<? super T, ? super R, ? extends V> transform) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        kotlin.jvm.internal.g0.p(transform, "transform");
        Iterator<? extends T> it = iterable.iterator();
        Iterator<? extends R> it2 = other.iterator();
        ArrayList arrayList = new ArrayList(Math.min(i0.d0(iterable, 10), i0.d0(other, 10)));
        while (it.hasNext() && it2.hasNext()) {
            arrayList.add(transform.invoke(it.next(), it2.next()));
        }
        return arrayList;
    }

    @InlineOnly
    private static final <T> T q2(List<? extends T> list, int i6) {
        kotlin.jvm.internal.g0.p(list, "<this>");
        return (T) b3(list, i6);
    }

    @NotNull
    public static final <T> String q3(@NotNull Iterable<? extends T> iterable, @NotNull CharSequence separator, @NotNull CharSequence prefix, @NotNull CharSequence postfix, int i6, @NotNull CharSequence truncated, @Nullable Function1<? super T, ? extends CharSequence> function1) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(separator, "separator");
        kotlin.jvm.internal.g0.p(prefix, "prefix");
        kotlin.jvm.internal.g0.p(postfix, "postfix");
        kotlin.jvm.internal.g0.p(truncated, "truncated");
        return ((StringBuilder) o3(iterable, new StringBuilder(), separator, prefix, postfix, i6, truncated, function1)).toString();
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "minOrThrow")
    public static final float q4(@NotNull Iterable<Float> iterable) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        Iterator<Float> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        float floatValue = it.next().floatValue();
        while (it.hasNext()) {
            floatValue = Math.min(floatValue, it.next().floatValue());
        }
        return floatValue;
    }

    @NotNull
    public static final <T> List<T> q5(@NotNull List<? extends T> list, @NotNull Iterable<Integer> indices) {
        kotlin.jvm.internal.g0.p(list, "<this>");
        kotlin.jvm.internal.g0.p(indices, "indices");
        int d02 = i0.d0(indices, 10);
        if (d02 == 0) {
            return h0.J();
        }
        ArrayList arrayList = new ArrayList(d02);
        Iterator<Integer> it = indices.iterator();
        while (it.hasNext()) {
            arrayList.add(list.get(it.next().intValue()));
        }
        return arrayList;
    }

    @NotNull
    public static final <T, R> List<Pair<T, R>> q6(@NotNull Iterable<? extends T> iterable, @NotNull R[] other) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        int length = other.length;
        ArrayList arrayList = new ArrayList(Math.min(i0.d0(iterable, 10), length));
        int i6 = 0;
        for (T t5 : iterable) {
            if (i6 >= length) {
                break;
            }
            arrayList.add(kotlin.o0.a(t5, other[i6]));
            i6++;
        }
        return arrayList;
    }

    @NotNull
    public static <T> List<T> r2(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (T t5 : iterable) {
            if (predicate.invoke(t5).booleanValue()) {
                arrayList.add(t5);
            }
        }
        return arrayList;
    }

    public static /* synthetic */ String r3(Iterable iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i6, CharSequence charSequence4, Function1 function1, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            charSequence = ", ";
        }
        if ((i7 & 2) != 0) {
            charSequence2 = "";
        }
        if ((i7 & 4) != 0) {
            charSequence3 = "";
        }
        if ((i7 & 8) != 0) {
            i6 = -1;
        }
        if ((i7 & 16) != 0) {
            charSequence4 = "...";
        }
        if ((i7 & 32) != 0) {
            function1 = null;
        }
        CharSequence charSequence5 = charSequence4;
        Function1 function12 = function1;
        return q3(iterable, charSequence, charSequence2, charSequence3, i6, charSequence5, function12);
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "minOrThrow")
    @NotNull
    public static final <T extends Comparable<? super T>> T r4(@NotNull Iterable<? extends T> iterable) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (next.compareTo(next2) > 0) {
                next = next2;
            }
        }
        return next;
    }

    @NotNull
    public static <T> List<T> r5(@NotNull List<? extends T> list, @NotNull kotlin.ranges.m indices) {
        kotlin.jvm.internal.g0.p(list, "<this>");
        kotlin.jvm.internal.g0.p(indices, "indices");
        return indices.isEmpty() ? h0.J() : a6(list.subList(indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <T, R, V> List<V> r6(@NotNull Iterable<? extends T> iterable, @NotNull R[] other, @NotNull Function2<? super T, ? super R, ? extends V> transform) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        kotlin.jvm.internal.g0.p(transform, "transform");
        int length = other.length;
        ArrayList arrayList = new ArrayList(Math.min(i0.d0(iterable, 10), length));
        int i6 = 0;
        for (T t5 : iterable) {
            if (i6 >= length) {
                break;
            }
            arrayList.add(transform.invoke(t5, other[i6]));
            i6++;
        }
        return arrayList;
    }

    @NotNull
    public static final <T> List<T> s2(@NotNull Iterable<? extends T> iterable, @NotNull Function2<? super Integer, ? super T, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int i6 = 0;
        for (T t5 : iterable) {
            int i7 = i6 + 1;
            if (i6 < 0) {
                h0.b0();
            }
            if (predicate.invoke(Integer.valueOf(i6), t5).booleanValue()) {
                arrayList.add(t5);
            }
            i6 = i7;
        }
        return arrayList;
    }

    public static <T> T s3(@NotNull Iterable<? extends T> iterable) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        if (iterable instanceof List) {
            return (T) u3((List) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException("Collection is empty.");
        }
        T next = it.next();
        while (it.hasNext()) {
            next = it.next();
        }
        return next;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final <T> T s4(@NotNull Iterable<? extends T> iterable, @NotNull Comparator<? super T> comparator) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        Object obj = (T) it.next();
        while (it.hasNext()) {
            Object obj2 = (T) it.next();
            if (comparator.compare(obj, obj2) > 0) {
                obj = (T) obj2;
            }
        }
        return (T) obj;
    }

    public static final <T, R extends Comparable<? super R>> void s5(@NotNull List<T> list, @NotNull Function1<? super T, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(list, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (list.size() > 1) {
            l0.r0(list, new g.a(selector));
        }
    }

    @SinceKotlin(version = "1.2")
    @NotNull
    public static <T> List<Pair<T, T>> s6(@NotNull Iterable<? extends T> iterable) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return h0.J();
        }
        ArrayList arrayList = new ArrayList();
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            arrayList.add(kotlin.o0.a(next, next2));
            next = next2;
        }
        return arrayList;
    }

    @NotNull
    public static final <T, C extends Collection<? super T>> C t2(@NotNull Iterable<? extends T> iterable, @NotNull C destination, @NotNull Function2<? super Integer, ? super T, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        int i6 = 0;
        for (T t5 : iterable) {
            int i7 = i6 + 1;
            if (i6 < 0) {
                h0.b0();
            }
            if (predicate.invoke(Integer.valueOf(i6), t5).booleanValue()) {
                destination.add(t5);
            }
            i6 = i7;
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object] */
    public static final <T> T t3(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        T t5 = null;
        boolean z5 = false;
        for (T t6 : iterable) {
            if (predicate.invoke(t6).booleanValue()) {
                z5 = true;
                t5 = t6;
            }
        }
        if (z5) {
            return t5;
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.7")
    @JvmName(name = "minWithOrThrow")
    public static final <T> T t4(@NotNull Iterable<? extends T> iterable, @NotNull Comparator<? super T> comparator) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        Object obj = (T) it.next();
        while (it.hasNext()) {
            Object obj2 = (T) it.next();
            if (comparator.compare(obj, obj2) > 0) {
                obj = (T) obj2;
            }
        }
        return (T) obj;
    }

    public static final <T, R extends Comparable<? super R>> void t5(@NotNull List<T> list, @NotNull Function1<? super T, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(list, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (list.size() > 1) {
            l0.r0(list, new g.c(selector));
        }
    }

    @SinceKotlin(version = "1.2")
    @NotNull
    public static final <T, R> List<R> t6(@NotNull Iterable<? extends T> iterable, @NotNull Function2<? super T, ? super T, ? extends R> transform) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(transform, "transform");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return h0.J();
        }
        ArrayList arrayList = new ArrayList();
        H5BaseWebChromeClient next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            arrayList.add(transform.invoke(next, next2));
            next = next2;
        }
        return arrayList;
    }

    public static final /* synthetic */ <R> List<R> u2(Iterable<?> iterable) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        ArrayList arrayList = new ArrayList();
        for (Object obj : iterable) {
            kotlin.jvm.internal.g0.y(3, "R");
            if (androidx.activity.k.a(obj)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static <T> T u3(@NotNull List<? extends T> list) {
        kotlin.jvm.internal.g0.p(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(h0.L(list));
    }

    @NotNull
    public static final <T> List<T> u4(@NotNull Iterable<? extends T> iterable, @NotNull Iterable<? extends T> elements) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(elements, "elements");
        Collection v02 = m0.v0(elements);
        if (v02.isEmpty()) {
            return a6(iterable);
        }
        ArrayList arrayList = new ArrayList();
        for (T t5 : iterable) {
            if (!v02.contains(t5)) {
                arrayList.add(t5);
            }
        }
        return arrayList;
    }

    public static final <T extends Comparable<? super T>> void u5(@NotNull List<T> list) {
        kotlin.jvm.internal.g0.p(list, "<this>");
        l0.r0(list, kotlin.comparisons.a.x());
    }

    public static final /* synthetic */ <R, C extends Collection<? super R>> C v2(Iterable<?> iterable, C destination) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        for (Object obj : iterable) {
            kotlin.jvm.internal.g0.y(3, "R");
            if (androidx.activity.k.a(obj)) {
                destination.add(obj);
            }
        }
        return destination;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [T, java.lang.Object] */
    public static final <T> T v3(@NotNull List<? extends T> list, @NotNull Function1<? super T, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(list, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        ListIterator<? extends T> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            T previous = listIterator.previous();
            if (predicate.invoke(previous).booleanValue()) {
                return previous;
            }
        }
        throw new NoSuchElementException("List contains no element matching the predicate.");
    }

    @NotNull
    public static <T> List<T> v4(@NotNull Iterable<? extends T> iterable, T t5) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        ArrayList arrayList = new ArrayList(i0.d0(iterable, 10));
        boolean z5 = false;
        for (T t6 : iterable) {
            boolean z6 = true;
            if (!z5 && kotlin.jvm.internal.g0.g(t6, t5)) {
                z5 = true;
                z6 = false;
            }
            if (z6) {
                arrayList.add(t6);
            }
        }
        return arrayList;
    }

    @NotNull
    public static <T extends Comparable<? super T>> List<T> v5(@NotNull Iterable<? extends T> iterable) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            List<T> c6 = c6(iterable);
            l0.o0(c6);
            return c6;
        }
        Collection collection = (Collection) iterable;
        if (collection.size() <= 1) {
            return a6(iterable);
        }
        Object[] array = collection.toArray(new Comparable[0]);
        q.U3((Comparable[]) array);
        return q.t(array);
    }

    @NotNull
    public static final <T> List<T> w2(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (T t5 : iterable) {
            if (!predicate.invoke(t5).booleanValue()) {
                arrayList.add(t5);
            }
        }
        return arrayList;
    }

    public static final <T> int w3(@NotNull Iterable<? extends T> iterable, T t5) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        if (iterable instanceof List) {
            return ((List) iterable).lastIndexOf(t5);
        }
        int i6 = -1;
        int i7 = 0;
        for (T t6 : iterable) {
            if (i7 < 0) {
                h0.b0();
            }
            if (kotlin.jvm.internal.g0.g(t5, t6)) {
                i6 = i7;
            }
            i7++;
        }
        return i6;
    }

    @NotNull
    public static final <T> List<T> w4(@NotNull Iterable<? extends T> iterable, @NotNull kotlin.sequences.m<? extends T> elements) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(elements, "elements");
        List I3 = kotlin.sequences.p.I3(elements);
        if (I3.isEmpty()) {
            return a6(iterable);
        }
        ArrayList arrayList = new ArrayList();
        for (T t5 : iterable) {
            if (!I3.contains(t5)) {
                arrayList.add(t5);
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <T, R extends Comparable<? super R>> List<T> w5(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        return z5(iterable, new g.a(selector));
    }

    @NotNull
    public static <T> List<T> x2(@NotNull Iterable<? extends T> iterable) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        return (List) y2(iterable, new ArrayList());
    }

    public static final <T> int x3(@NotNull List<? extends T> list, T t5) {
        kotlin.jvm.internal.g0.p(list, "<this>");
        return list.lastIndexOf(t5);
    }

    @NotNull
    public static final <T> List<T> x4(@NotNull Iterable<? extends T> iterable, @NotNull T[] elements) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(elements, "elements");
        if (elements.length == 0) {
            return a6(iterable);
        }
        ArrayList arrayList = new ArrayList();
        for (T t5 : iterable) {
            if (!a0.B8(elements, t5)) {
                arrayList.add(t5);
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <T, R extends Comparable<? super R>> List<T> x5(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        return z5(iterable, new g.c(selector));
    }

    @NotNull
    public static final <C extends Collection<? super T>, T> C y2(@NotNull Iterable<? extends T> iterable, @NotNull C destination) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        for (T t5 : iterable) {
            if (t5 != null) {
                destination.add(t5);
            }
        }
        return destination;
    }

    @Nullable
    public static <T> T y3(@NotNull Iterable<? extends T> iterable) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (list.isEmpty()) {
                return null;
            }
            return (T) list.get(list.size() - 1);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        while (it.hasNext()) {
            next = it.next();
        }
        return next;
    }

    @InlineOnly
    private static final <T> List<T> y4(Iterable<? extends T> iterable, T t5) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        return v4(iterable, t5);
    }

    @NotNull
    public static final <T extends Comparable<? super T>> List<T> y5(@NotNull Iterable<? extends T> iterable) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        return z5(iterable, kotlin.comparisons.a.x());
    }

    @NotNull
    public static final <T, C extends Collection<? super T>> C z2(@NotNull Iterable<? extends T> iterable, @NotNull C destination, @NotNull Function1<? super T, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (T t5 : iterable) {
            if (!predicate.invoke(t5).booleanValue()) {
                destination.add(t5);
            }
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object] */
    @Nullable
    public static final <T> T z3(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        T t5 = null;
        for (T t6 : iterable) {
            if (predicate.invoke(t6).booleanValue()) {
                t5 = t6;
            }
        }
        return t5;
    }

    public static final <T> boolean z4(@NotNull Iterable<? extends T> iterable) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        return iterable instanceof Collection ? ((Collection) iterable).isEmpty() : !iterable.iterator().hasNext();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static <T> List<T> z5(@NotNull Iterable<? extends T> iterable, @NotNull Comparator<? super T> comparator) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        if (!(iterable instanceof Collection)) {
            List<T> c6 = c6(iterable);
            l0.r0(c6, comparator);
            return c6;
        }
        Collection collection = (Collection) iterable;
        if (collection.size() <= 1) {
            return a6(iterable);
        }
        Object[] array = collection.toArray(new Object[0]);
        q.h4(array, comparator);
        return q.t(array);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Iterator n6(Iterable iterable) {
        return iterable.iterator();
    }
}
