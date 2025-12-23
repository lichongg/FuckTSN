package kotlin.collections;

import com.daimajia.numberprogressbar.BuildConfig;
import defpackage.H5BaseWebChromeClient;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.OverloadResolutionByLambdaReturnType;
import kotlin.Pair;
import kotlin.SinceKotlin;
import kotlin.internal.HidesMembers;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\n_Maps.kt\nKotlin\n*S Kotlin\n*F\n+ 1 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,671:1\n97#1,5:672\n112#1,5:677\n153#1,3:682\n144#1:685\n216#1:686\n217#1:688\n145#1:689\n216#1:690\n217#1:692\n1#2:687\n1#2:691\n1969#3,14:693\n1999#3,14:707\n2393#3,14:721\n2423#3,14:735\n1878#3,3:749\n*S KotlinDebug\n*F\n+ 1 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n77#1:672,5\n90#1:677,5\n126#1:682,3\n136#1:685\n136#1:686\n136#1:688\n136#1:689\n144#1:690\n144#1:692\n136#1:687\n238#1:693,14\n256#1:707,14\n436#1:721,14\n454#1:735,14\n651#1:749,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public class n1 extends m1 {
    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <K, V> Float A1(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, Float> selector) {
        kotlin.jvm.internal.g0.p(map, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            return null;
        }
        float floatValue = selector.invoke((Object) it.next()).floatValue();
        while (it.hasNext()) {
            floatValue = Math.min(floatValue, selector.invoke((Object) it.next()).floatValue());
        }
        return Float.valueOf(floatValue);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <K, V, R> R B1(Map<? extends K, ? extends V> map, Comparator<? super R> comparator, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(map, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        kotlin.jvm.internal.g0.p(selector, "selector");
        Iterator it = map.entrySet().iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        Object obj = (R) selector.invoke((Object) it.next());
        while (it.hasNext()) {
            Object obj2 = (R) selector.invoke((Object) it.next());
            if (comparator.compare(obj, obj2) > 0) {
                obj = (R) obj2;
            }
        }
        return (R) obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <K, V, R> R C1(Map<? extends K, ? extends V> map, Comparator<? super R> comparator, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(map, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        kotlin.jvm.internal.g0.p(selector, "selector");
        Iterator it = map.entrySet().iterator();
        if (!it.hasNext()) {
            return null;
        }
        Object obj = (R) selector.invoke((Object) it.next());
        while (it.hasNext()) {
            Object obj2 = (R) selector.invoke((Object) it.next());
            if (comparator.compare(obj, obj2) > 0) {
                obj = (R) obj2;
            }
        }
        return (R) obj;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final <K, V> Map.Entry<K, V> D1(Map<? extends K, ? extends V> map, Comparator<? super Map.Entry<? extends K, ? extends V>> comparator) {
        kotlin.jvm.internal.g0.p(map, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        return (Map.Entry) r0.s4(map.entrySet(), comparator);
    }

    @SinceKotlin(version = "1.7")
    @InlineOnly
    @JvmName(name = "minWithOrThrow")
    private static final <K, V> Map.Entry<K, V> E1(Map<? extends K, ? extends V> map, Comparator<? super Map.Entry<? extends K, ? extends V>> comparator) {
        kotlin.jvm.internal.g0.p(map, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        return (Map.Entry) r0.t4(map.entrySet(), comparator);
    }

    public static final <K, V> boolean F1(@NotNull Map<? extends K, ? extends V> map) {
        kotlin.jvm.internal.g0.p(map, "<this>");
        return map.isEmpty();
    }

    public static final <K, V> boolean G1(@NotNull Map<? extends K, ? extends V> map, @NotNull Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(map, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        if (map.isEmpty()) {
            return true;
        }
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            if (predicate.invoke(it.next()).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @SinceKotlin(version = "1.1")
    @NotNull
    public static final <K, V, M extends Map<? extends K, ? extends V>> M H1(@NotNull M m6, @NotNull Function1<? super Map.Entry<? extends K, ? extends V>, kotlin.n1> action) {
        kotlin.jvm.internal.g0.p(m6, "<this>");
        kotlin.jvm.internal.g0.p(action, "action");
        Iterator<Map.Entry<K, V>> it = m6.entrySet().iterator();
        while (it.hasNext()) {
            action.invoke(it.next());
        }
        return m6;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @NotNull
    public static final <K, V, M extends Map<? extends K, ? extends V>> M I1(@NotNull M m6, @NotNull Function2<? super Integer, ? super Map.Entry<? extends K, ? extends V>, kotlin.n1> action) {
        kotlin.jvm.internal.g0.p(m6, "<this>");
        kotlin.jvm.internal.g0.p(action, "action");
        Iterator<T> it = m6.entrySet().iterator();
        int i6 = 0;
        while (it.hasNext()) {
            H5BaseWebChromeClient h5BaseWebChromeClient = (Object) it.next();
            int i7 = i6 + 1;
            if (i6 < 0) {
                h0.b0();
            }
            action.invoke(Integer.valueOf(i6), h5BaseWebChromeClient);
            i6 = i7;
        }
        return m6;
    }

    @NotNull
    public static <K, V> List<Pair<K, V>> J1(@NotNull Map<? extends K, ? extends V> map) {
        kotlin.jvm.internal.g0.p(map, "<this>");
        if (map.size() == 0) {
            return h0.J();
        }
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            return h0.J();
        }
        Map.Entry<? extends K, ? extends V> next = it.next();
        if (!it.hasNext()) {
            return g0.l(new Pair(next.getKey(), next.getValue()));
        }
        ArrayList arrayList = new ArrayList(map.size());
        arrayList.add(new Pair(next.getKey(), next.getValue()));
        do {
            Map.Entry<? extends K, ? extends V> next2 = it.next();
            arrayList.add(new Pair(next2.getKey(), next2.getValue()));
        } while (it.hasNext());
        return arrayList;
    }

    public static final <K, V> boolean P0(@NotNull Map<? extends K, ? extends V> map, @NotNull Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(map, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        if (map.isEmpty()) {
            return true;
        }
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            if (!predicate.invoke(it.next()).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final <K, V> boolean Q0(@NotNull Map<? extends K, ? extends V> map) {
        kotlin.jvm.internal.g0.p(map, "<this>");
        return !map.isEmpty();
    }

    public static final <K, V> boolean R0(@NotNull Map<? extends K, ? extends V> map, @NotNull Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(map, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        if (map.isEmpty()) {
            return false;
        }
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            if (predicate.invoke(it.next()).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @InlineOnly
    private static final <K, V> Iterable<Map.Entry<K, V>> S0(Map<? extends K, ? extends V> map) {
        kotlin.jvm.internal.g0.p(map, "<this>");
        return map.entrySet();
    }

    @NotNull
    public static final <K, V> kotlin.sequences.m<Map.Entry<K, V>> T0(@NotNull Map<? extends K, ? extends V> map) {
        kotlin.jvm.internal.g0.p(map, "<this>");
        return r0.E1(map.entrySet());
    }

    @InlineOnly
    private static final <K, V> int U0(Map<? extends K, ? extends V> map) {
        kotlin.jvm.internal.g0.p(map, "<this>");
        return map.size();
    }

    public static final <K, V> int V0(@NotNull Map<? extends K, ? extends V> map, @NotNull Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(map, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        int i6 = 0;
        if (map.isEmpty()) {
            return 0;
        }
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            if (predicate.invoke(it.next()).booleanValue()) {
                i6++;
            }
        }
        return i6;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final <K, V, R> R W0(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> transform) {
        R r5;
        kotlin.jvm.internal.g0.p(map, "<this>");
        kotlin.jvm.internal.g0.p(transform, "transform");
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
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
        throw new NoSuchElementException("No element of the map was transformed to a non-null value.");
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final <K, V, R> R X0(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> transform) {
        kotlin.jvm.internal.g0.p(map, "<this>");
        kotlin.jvm.internal.g0.p(transform, "transform");
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            R invoke = transform.invoke(it.next());
            if (invoke != null) {
                return invoke;
            }
        }
        return null;
    }

    @NotNull
    public static final <K, V, R> List<R> Y0(@NotNull Map<? extends K, ? extends V> map, @NotNull Function1<? super Map.Entry<? extends K, ? extends V>, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.g0.p(map, "<this>");
        kotlin.jvm.internal.g0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            m0.s0(arrayList, transform.invoke(it.next()));
        }
        return arrayList;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @JvmName(name = "flatMapSequence")
    @NotNull
    @OverloadResolutionByLambdaReturnType
    public static final <K, V, R> List<R> Z0(@NotNull Map<? extends K, ? extends V> map, @NotNull Function1<? super Map.Entry<? extends K, ? extends V>, ? extends kotlin.sequences.m<? extends R>> transform) {
        kotlin.jvm.internal.g0.p(map, "<this>");
        kotlin.jvm.internal.g0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            m0.t0(arrayList, transform.invoke(it.next()));
        }
        return arrayList;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @JvmName(name = "flatMapSequenceTo")
    @NotNull
    @OverloadResolutionByLambdaReturnType
    public static final <K, V, R, C extends Collection<? super R>> C a1(@NotNull Map<? extends K, ? extends V> map, @NotNull C destination, @NotNull Function1<? super Map.Entry<? extends K, ? extends V>, ? extends kotlin.sequences.m<? extends R>> transform) {
        kotlin.jvm.internal.g0.p(map, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(transform, "transform");
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            m0.t0(destination, transform.invoke(it.next()));
        }
        return destination;
    }

    @NotNull
    public static final <K, V, R, C extends Collection<? super R>> C b1(@NotNull Map<? extends K, ? extends V> map, @NotNull C destination, @NotNull Function1<? super Map.Entry<? extends K, ? extends V>, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.g0.p(map, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(transform, "transform");
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            m0.s0(destination, transform.invoke(it.next()));
        }
        return destination;
    }

    @HidesMembers
    public static final <K, V> void c1(@NotNull Map<? extends K, ? extends V> map, @NotNull Function1<? super Map.Entry<? extends K, ? extends V>, kotlin.n1> action) {
        kotlin.jvm.internal.g0.p(map, "<this>");
        kotlin.jvm.internal.g0.p(action, "action");
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            action.invoke(it.next());
        }
    }

    @NotNull
    public static final <K, V, R> List<R> d1(@NotNull Map<? extends K, ? extends V> map, @NotNull Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> transform) {
        kotlin.jvm.internal.g0.p(map, "<this>");
        kotlin.jvm.internal.g0.p(transform, "transform");
        ArrayList arrayList = new ArrayList(map.size());
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add(transform.invoke(it.next()));
        }
        return arrayList;
    }

    @NotNull
    public static final <K, V, R> List<R> e1(@NotNull Map<? extends K, ? extends V> map, @NotNull Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> transform) {
        kotlin.jvm.internal.g0.p(map, "<this>");
        kotlin.jvm.internal.g0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            R invoke = transform.invoke(it.next());
            if (invoke != null) {
                arrayList.add(invoke);
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <K, V, R, C extends Collection<? super R>> C f1(@NotNull Map<? extends K, ? extends V> map, @NotNull C destination, @NotNull Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> transform) {
        kotlin.jvm.internal.g0.p(map, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(transform, "transform");
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            R invoke = transform.invoke(it.next());
            if (invoke != null) {
                destination.add(invoke);
            }
        }
        return destination;
    }

    @NotNull
    public static final <K, V, R, C extends Collection<? super R>> C g1(@NotNull Map<? extends K, ? extends V> map, @NotNull C destination, @NotNull Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> transform) {
        kotlin.jvm.internal.g0.p(map, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(transform, "transform");
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            destination.add(transform.invoke(it.next()));
        }
        return destination;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final <K, V, R extends Comparable<? super R>> Map.Entry<K, V> h1(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> selector) {
        Map.Entry<K, V> entry;
        kotlin.jvm.internal.g0.p(map, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (it.hasNext()) {
            Map.Entry<K, V> entry2 = (Object) it.next();
            if (it.hasNext()) {
                R invoke = selector.invoke(entry2);
                do {
                    Map.Entry<K, V> entry3 = (Object) it.next();
                    R invoke2 = selector.invoke(entry3);
                    if (invoke.compareTo(invoke2) < 0) {
                        entry2 = entry3;
                        invoke = invoke2;
                    }
                } while (it.hasNext());
            }
            entry = entry2;
        } else {
            entry = null;
        }
        return entry;
    }

    @SinceKotlin(version = "1.7")
    @InlineOnly
    @JvmName(name = "maxByOrThrow")
    private static final <K, V, R extends Comparable<? super R>> Map.Entry<K, V> i1(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(map, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        Map.Entry<K, V> entry = (Object) it.next();
        if (it.hasNext()) {
            R invoke = selector.invoke(entry);
            do {
                Map.Entry<K, V> entry2 = (Object) it.next();
                R invoke2 = selector.invoke(entry2);
                if (invoke.compareTo(invoke2) < 0) {
                    entry = entry2;
                    invoke = invoke2;
                }
            } while (it.hasNext());
        }
        return entry;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <K, V> double j1(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, Double> selector) {
        kotlin.jvm.internal.g0.p(map, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        double doubleValue = selector.invoke((Object) it.next()).doubleValue();
        while (it.hasNext()) {
            doubleValue = Math.max(doubleValue, selector.invoke((Object) it.next()).doubleValue());
        }
        return doubleValue;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <K, V> float k1(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, Float> selector) {
        kotlin.jvm.internal.g0.p(map, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        float floatValue = selector.invoke((Object) it.next()).floatValue();
        while (it.hasNext()) {
            floatValue = Math.max(floatValue, selector.invoke((Object) it.next()).floatValue());
        }
        return floatValue;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <K, V, R extends Comparable<? super R>> R l1(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(map, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        R invoke = selector.invoke((Object) it.next());
        while (it.hasNext()) {
            R invoke2 = selector.invoke((Object) it.next());
            if (invoke.compareTo(invoke2) < 0) {
                invoke = invoke2;
            }
        }
        return invoke;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <K, V, R extends Comparable<? super R>> R m1(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(map, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            return null;
        }
        R invoke = selector.invoke((Object) it.next());
        while (it.hasNext()) {
            R invoke2 = selector.invoke((Object) it.next());
            if (invoke.compareTo(invoke2) < 0) {
                invoke = invoke2;
            }
        }
        return invoke;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <K, V> Double n1(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, Double> selector) {
        kotlin.jvm.internal.g0.p(map, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            return null;
        }
        double doubleValue = selector.invoke((Object) it.next()).doubleValue();
        while (it.hasNext()) {
            doubleValue = Math.max(doubleValue, selector.invoke((Object) it.next()).doubleValue());
        }
        return Double.valueOf(doubleValue);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <K, V> Float o1(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, Float> selector) {
        kotlin.jvm.internal.g0.p(map, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            return null;
        }
        float floatValue = selector.invoke((Object) it.next()).floatValue();
        while (it.hasNext()) {
            floatValue = Math.max(floatValue, selector.invoke((Object) it.next()).floatValue());
        }
        return Float.valueOf(floatValue);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <K, V, R> R p1(Map<? extends K, ? extends V> map, Comparator<? super R> comparator, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(map, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        kotlin.jvm.internal.g0.p(selector, "selector");
        Iterator it = map.entrySet().iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        Object obj = (R) selector.invoke((Object) it.next());
        while (it.hasNext()) {
            Object obj2 = (R) selector.invoke((Object) it.next());
            if (comparator.compare(obj, obj2) < 0) {
                obj = (R) obj2;
            }
        }
        return (R) obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <K, V, R> R q1(Map<? extends K, ? extends V> map, Comparator<? super R> comparator, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(map, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        kotlin.jvm.internal.g0.p(selector, "selector");
        Iterator it = map.entrySet().iterator();
        if (!it.hasNext()) {
            return null;
        }
        Object obj = (R) selector.invoke((Object) it.next());
        while (it.hasNext()) {
            Object obj2 = (R) selector.invoke((Object) it.next());
            if (comparator.compare(obj, obj2) < 0) {
                obj = (R) obj2;
            }
        }
        return (R) obj;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final <K, V> Map.Entry<K, V> r1(Map<? extends K, ? extends V> map, Comparator<? super Map.Entry<? extends K, ? extends V>> comparator) {
        kotlin.jvm.internal.g0.p(map, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        return (Map.Entry) r0.a4(map.entrySet(), comparator);
    }

    @SinceKotlin(version = "1.7")
    @InlineOnly
    @JvmName(name = "maxWithOrThrow")
    private static final <K, V> Map.Entry<K, V> s1(Map<? extends K, ? extends V> map, Comparator<? super Map.Entry<? extends K, ? extends V>> comparator) {
        kotlin.jvm.internal.g0.p(map, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        return (Map.Entry) r0.b4(map.entrySet(), comparator);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final <K, V, R extends Comparable<? super R>> Map.Entry<K, V> t1(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> selector) {
        Map.Entry<K, V> entry;
        kotlin.jvm.internal.g0.p(map, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (it.hasNext()) {
            Map.Entry<K, V> entry2 = (Object) it.next();
            if (it.hasNext()) {
                R invoke = selector.invoke(entry2);
                do {
                    Map.Entry<K, V> entry3 = (Object) it.next();
                    R invoke2 = selector.invoke(entry3);
                    if (invoke.compareTo(invoke2) > 0) {
                        entry2 = entry3;
                        invoke = invoke2;
                    }
                } while (it.hasNext());
            }
            entry = entry2;
        } else {
            entry = null;
        }
        return entry;
    }

    @SinceKotlin(version = "1.7")
    @InlineOnly
    @JvmName(name = "minByOrThrow")
    private static final <K, V, R extends Comparable<? super R>> Map.Entry<K, V> u1(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(map, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        Map.Entry<K, V> entry = (Object) it.next();
        if (it.hasNext()) {
            R invoke = selector.invoke(entry);
            do {
                Map.Entry<K, V> entry2 = (Object) it.next();
                R invoke2 = selector.invoke(entry2);
                if (invoke.compareTo(invoke2) > 0) {
                    entry = entry2;
                    invoke = invoke2;
                }
            } while (it.hasNext());
        }
        return entry;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <K, V> double v1(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, Double> selector) {
        kotlin.jvm.internal.g0.p(map, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        double doubleValue = selector.invoke((Object) it.next()).doubleValue();
        while (it.hasNext()) {
            doubleValue = Math.min(doubleValue, selector.invoke((Object) it.next()).doubleValue());
        }
        return doubleValue;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <K, V> float w1(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, Float> selector) {
        kotlin.jvm.internal.g0.p(map, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        float floatValue = selector.invoke((Object) it.next()).floatValue();
        while (it.hasNext()) {
            floatValue = Math.min(floatValue, selector.invoke((Object) it.next()).floatValue());
        }
        return floatValue;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <K, V, R extends Comparable<? super R>> R x1(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(map, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        R invoke = selector.invoke((Object) it.next());
        while (it.hasNext()) {
            R invoke2 = selector.invoke((Object) it.next());
            if (invoke.compareTo(invoke2) > 0) {
                invoke = invoke2;
            }
        }
        return invoke;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <K, V, R extends Comparable<? super R>> R y1(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(map, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            return null;
        }
        R invoke = selector.invoke((Object) it.next());
        while (it.hasNext()) {
            R invoke2 = selector.invoke((Object) it.next());
            if (invoke.compareTo(invoke2) > 0) {
                invoke = invoke2;
            }
        }
        return invoke;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <K, V> Double z1(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, Double> selector) {
        kotlin.jvm.internal.g0.p(map, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            return null;
        }
        double doubleValue = selector.invoke((Object) it.next()).doubleValue();
        while (it.hasNext()) {
            doubleValue = Math.min(doubleValue, selector.invoke((Object) it.next()).doubleValue());
        }
        return Double.valueOf(doubleValue);
    }
}
