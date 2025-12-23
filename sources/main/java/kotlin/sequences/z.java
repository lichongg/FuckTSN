package kotlin.sequences;

import com.daimajia.numberprogressbar.BuildConfig;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
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

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\n_SequencesJvm.kt\nKotlin\n*S Kotlin\n*F\n+ 1 _SequencesJvm.kt\nkotlin/sequences/SequencesKt___SequencesJvmKt\n+ 2 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,172:1\n1463#2,14:173\n1923#2,14:187\n*S KotlinDebug\n*F\n+ 1 _SequencesJvm.kt\nkotlin/sequences/SequencesKt___SequencesJvmKt\n*L\n89#1:173,14\n126#1:187,14\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
class z extends x {
    @NotNull
    public static final <R> m<R> H(@NotNull m<?> mVar, @NotNull final Class<R> klass) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(klass, "klass");
        m<R> P0 = k0.P0(mVar, new Function1() { // from class: kotlin.sequences.y
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                boolean I;
                I = z.I(klass, obj);
                return Boolean.valueOf(I);
            }
        });
        kotlin.jvm.internal.g0.n(P0, "null cannot be cast to non-null type kotlin.sequences.Sequence<R of kotlin.sequences.SequencesKt___SequencesJvmKt.filterIsInstance>");
        return P0;
    }

    @NotNull
    public static final <C extends Collection<? super R>, R> C J(@NotNull m<?> mVar, @NotNull C destination, @NotNull Class<R> klass) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(klass, "klass");
        for (Object obj : mVar) {
            if (klass.isInstance(obj)) {
                destination.add(obj);
            }
        }
        return destination;
    }

    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = cn.bluemobi.dylan.photoview.a.f1297f, warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Comparable K(m mVar) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        return k0.f2(mVar);
    }

    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @SinceKotlin(version = "1.1")
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = cn.bluemobi.dylan.photoview.a.f1297f, warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Double L(m mVar) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        return k0.g2(mVar);
    }

    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @SinceKotlin(version = "1.1")
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = cn.bluemobi.dylan.photoview.a.f1297f, warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Float M(m mVar) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        return k0.h2(mVar);
    }

    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [T] */
    @Deprecated(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = cn.bluemobi.dylan.photoview.a.f1297f, warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ <T, R extends Comparable<? super R>> T N(m<? extends T> mVar, Function1<? super T, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        Iterator<? extends T> it = mVar.iterator();
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
    public static final /* synthetic */ Object O(m mVar, Comparator comparator) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        return k0.l2(mVar, comparator);
    }

    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = cn.bluemobi.dylan.photoview.a.f1297f, warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Comparable P(m mVar) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        return k0.x2(mVar);
    }

    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @SinceKotlin(version = "1.1")
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = cn.bluemobi.dylan.photoview.a.f1297f, warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Double Q(m mVar) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        return k0.y2(mVar);
    }

    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @SinceKotlin(version = "1.1")
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = cn.bluemobi.dylan.photoview.a.f1297f, warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Float R(m mVar) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        return k0.z2(mVar);
    }

    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [T] */
    @Deprecated(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = cn.bluemobi.dylan.photoview.a.f1297f, warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ <T, R extends Comparable<? super R>> T S(m<? extends T> mVar, Function1<? super T, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        Iterator<? extends T> it = mVar.iterator();
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
    public static final /* synthetic */ Object T(m mVar, Comparator comparator) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        return k0.D2(mVar, comparator);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    @JvmName(name = "sumOfBigDecimal")
    @OverloadResolutionByLambdaReturnType
    private static final <T> BigDecimal U(m<? extends T> mVar, Function1<? super T, ? extends BigDecimal> selector) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        BigDecimal valueOf = BigDecimal.valueOf(0L);
        kotlin.jvm.internal.g0.o(valueOf, "valueOf(...)");
        Iterator<? extends T> it = mVar.iterator();
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
    private static final <T> BigInteger V(m<? extends T> mVar, Function1<? super T, ? extends BigInteger> selector) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        BigInteger valueOf = BigInteger.valueOf(0L);
        kotlin.jvm.internal.g0.o(valueOf, "valueOf(...)");
        Iterator<? extends T> it = mVar.iterator();
        while (it.hasNext()) {
            valueOf = valueOf.add(selector.invoke(it.next()));
            kotlin.jvm.internal.g0.o(valueOf, "add(...)");
        }
        return valueOf;
    }

    @NotNull
    public static final <T extends Comparable<? super T>> SortedSet<T> W(@NotNull m<? extends T> mVar) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        return (SortedSet) k0.G3(mVar, new TreeSet());
    }

    @NotNull
    public static final <T> SortedSet<T> X(@NotNull m<? extends T> mVar, @NotNull Comparator<? super T> comparator) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        return (SortedSet) k0.G3(mVar, new TreeSet(comparator));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean I(Class cls, Object obj) {
        return cls.isInstance(obj);
    }
}
