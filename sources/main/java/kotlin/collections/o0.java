package kotlin.collections;

import com.daimajia.numberprogressbar.BuildConfig;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.OverloadResolutionByLambdaReturnType;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\n_CollectionsJvm.kt\nKotlin\n*S Kotlin\n*F\n+ 1 _CollectionsJvm.kt\nkotlin/collections/CollectionsKt___CollectionsJvmKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,168:1\n1999#2,14:169\n2423#2,14:183\n*S KotlinDebug\n*F\n+ 1 _CollectionsJvm.kt\nkotlin/collections/CollectionsKt___CollectionsJvmKt\n*L\n89#1:169,14\n126#1:183,14\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public class o0 extends n0 {
    @NotNull
    public static <R> List<R> h1(@NotNull Iterable<?> iterable, @NotNull Class<R> klass) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(klass, "klass");
        return (List) i1(iterable, new ArrayList(), klass);
    }

    @NotNull
    public static final <C extends Collection<? super R>, R> C i1(@NotNull Iterable<?> iterable, @NotNull C destination, @NotNull Class<R> klass) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(klass, "klass");
        for (Object obj : iterable) {
            if (klass.isInstance(obj)) {
                destination.add(obj);
            }
        }
        return destination;
    }

    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = cn.bluemobi.dylan.photoview.a.f1297f, warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Comparable j1(Iterable iterable) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        return r0.U3(iterable);
    }

    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @SinceKotlin(version = "1.1")
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = cn.bluemobi.dylan.photoview.a.f1297f, warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Double k1(Iterable iterable) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        return r0.V3(iterable);
    }

    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @SinceKotlin(version = "1.1")
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = cn.bluemobi.dylan.photoview.a.f1297f, warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Float l1(Iterable iterable) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        return r0.W3(iterable);
    }

    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [T] */
    @Deprecated(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = cn.bluemobi.dylan.photoview.a.f1297f, warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ <T, R extends Comparable<? super R>> T m1(Iterable<? extends T> iterable, Function1<? super T, ? extends R> selector) {
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

    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = cn.bluemobi.dylan.photoview.a.f1297f, warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Object n1(Iterable iterable, Comparator comparator) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        return r0.a4(iterable, comparator);
    }

    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = cn.bluemobi.dylan.photoview.a.f1297f, warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Comparable o1(Iterable iterable) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        return r0.m4(iterable);
    }

    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @SinceKotlin(version = "1.1")
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = cn.bluemobi.dylan.photoview.a.f1297f, warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Double p1(Iterable iterable) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        return r0.n4(iterable);
    }

    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @SinceKotlin(version = "1.1")
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = cn.bluemobi.dylan.photoview.a.f1297f, warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Float q1(Iterable iterable) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        return r0.o4(iterable);
    }

    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [T] */
    @Deprecated(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = cn.bluemobi.dylan.photoview.a.f1297f, warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ <T, R extends Comparable<? super R>> T r1(Iterable<? extends T> iterable, Function1<? super T, ? extends R> selector) {
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

    @Deprecated(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = cn.bluemobi.dylan.photoview.a.f1297f, warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Object s1(Iterable iterable, Comparator comparator) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        return r0.s4(iterable, comparator);
    }

    public static <T> void t1(@NotNull List<T> list) {
        kotlin.jvm.internal.g0.p(list, "<this>");
        Collections.reverse(list);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    @JvmName(name = "sumOfBigDecimal")
    @OverloadResolutionByLambdaReturnType
    private static final <T> BigDecimal u1(Iterable<? extends T> iterable, Function1<? super T, ? extends BigDecimal> selector) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        BigDecimal valueOf = BigDecimal.valueOf(0L);
        kotlin.jvm.internal.g0.o(valueOf, "valueOf(...)");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            valueOf = valueOf.add(selector.invoke(it.next()));
            kotlin.jvm.internal.g0.o(valueOf, "add(...)");
        }
        return valueOf;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    @JvmName(name = "sumOfBigInteger")
    @OverloadResolutionByLambdaReturnType
    private static final <T> BigInteger v1(Iterable<? extends T> iterable, Function1<? super T, ? extends BigInteger> selector) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        BigInteger valueOf = BigInteger.valueOf(0L);
        kotlin.jvm.internal.g0.o(valueOf, "valueOf(...)");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            valueOf = valueOf.add(selector.invoke(it.next()));
            kotlin.jvm.internal.g0.o(valueOf, "add(...)");
        }
        return valueOf;
    }

    @NotNull
    public static final <T extends Comparable<? super T>> SortedSet<T> w1(@NotNull Iterable<? extends T> iterable) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        return (SortedSet) r0.V5(iterable, new TreeSet());
    }

    @NotNull
    public static final <T> SortedSet<T> x1(@NotNull Iterable<? extends T> iterable, @NotNull Comparator<? super T> comparator) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        return (SortedSet) r0.V5(iterable, new TreeSet(comparator));
    }
}
