package kotlin.comparisons;

import java.util.Comparator;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class g {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nComparisons.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Comparisons.kt\nkotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2\n*L\n1#1,328:1\n*E\n"})
    public static final class a<T> implements Comparator {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<T, Comparable<?>> f43736a;

        /* JADX WARN: Multi-variable type inference failed */
        public a(Function1<? super T, ? extends Comparable<?>> function1) {
            this.f43736a = function1;
        }

        @Override // java.util.Comparator
        public final int compare(T t5, T t6) {
            Function1<T, Comparable<?>> function1 = this.f43736a;
            return g.l(function1.invoke(t5), function1.invoke(t6));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nComparisons.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Comparisons.kt\nkotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$3\n*L\n1#1,328:1\n*E\n"})
    public static final class b<T> implements Comparator {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Comparator<? super K> f43737a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function1<T, K> f43738b;

        /* JADX WARN: Multi-variable type inference failed */
        public b(Comparator<? super K> comparator, Function1<? super T, ? extends K> function1) {
            this.f43737a = comparator;
            this.f43738b = function1;
        }

        @Override // java.util.Comparator
        public final int compare(T t5, T t6) {
            Comparator<? super K> comparator = this.f43737a;
            Function1<T, K> function1 = this.f43738b;
            return comparator.compare(function1.invoke(t5), function1.invoke(t6));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nComparisons.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Comparisons.kt\nkotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1\n*L\n1#1,328:1\n*E\n"})
    public static final class c<T> implements Comparator {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<T, Comparable<?>> f43739a;

        /* JADX WARN: Multi-variable type inference failed */
        public c(Function1<? super T, ? extends Comparable<?>> function1) {
            this.f43739a = function1;
        }

        @Override // java.util.Comparator
        public final int compare(T t5, T t6) {
            Function1<T, Comparable<?>> function1 = this.f43739a;
            return g.l(function1.invoke(t6), function1.invoke(t5));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nComparisons.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Comparisons.kt\nkotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$2\n*L\n1#1,328:1\n*E\n"})
    public static final class d<T> implements Comparator {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Comparator<? super K> f43740a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function1<T, K> f43741b;

        /* JADX WARN: Multi-variable type inference failed */
        public d(Comparator<? super K> comparator, Function1<? super T, ? extends K> function1) {
            this.f43740a = comparator;
            this.f43741b = function1;
        }

        @Override // java.util.Comparator
        public final int compare(T t5, T t6) {
            Comparator<? super K> comparator = this.f43740a;
            Function1<T, K> function1 = this.f43741b;
            return comparator.compare(function1.invoke(t6), function1.invoke(t5));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nComparisons.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Comparisons.kt\nkotlin/comparisons/ComparisonsKt__ComparisonsKt$thenBy$1\n*L\n1#1,328:1\n*E\n"})
    public static final class e<T> implements Comparator {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Comparator<T> f43742a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function1<T, Comparable<?>> f43743b;

        /* JADX WARN: Multi-variable type inference failed */
        public e(Comparator<T> comparator, Function1<? super T, ? extends Comparable<?>> function1) {
            this.f43742a = comparator;
            this.f43743b = function1;
        }

        @Override // java.util.Comparator
        public final int compare(T t5, T t6) {
            int compare = this.f43742a.compare(t5, t6);
            if (compare != 0) {
                return compare;
            }
            Function1<T, Comparable<?>> function1 = this.f43743b;
            return g.l(function1.invoke(t5), function1.invoke(t6));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nComparisons.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Comparisons.kt\nkotlin/comparisons/ComparisonsKt__ComparisonsKt$thenBy$2\n*L\n1#1,328:1\n*E\n"})
    public static final class f<T> implements Comparator {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Comparator<T> f43744a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Comparator<? super K> f43745b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Function1<T, K> f43746c;

        /* JADX WARN: Multi-variable type inference failed */
        public f(Comparator<T> comparator, Comparator<? super K> comparator2, Function1<? super T, ? extends K> function1) {
            this.f43744a = comparator;
            this.f43745b = comparator2;
            this.f43746c = function1;
        }

        @Override // java.util.Comparator
        public final int compare(T t5, T t6) {
            int compare = this.f43744a.compare(t5, t6);
            if (compare != 0) {
                return compare;
            }
            Comparator<? super K> comparator = this.f43745b;
            Function1<T, K> function1 = this.f43746c;
            return comparator.compare(function1.invoke(t5), function1.invoke(t6));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nComparisons.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Comparisons.kt\nkotlin/comparisons/ComparisonsKt__ComparisonsKt$thenByDescending$1\n*L\n1#1,328:1\n*E\n"})
    /* renamed from: kotlin.comparisons.g$g, reason: collision with other inner class name */
    public static final class C0861g<T> implements Comparator {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Comparator<T> f43747a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function1<T, Comparable<?>> f43748b;

        /* JADX WARN: Multi-variable type inference failed */
        public C0861g(Comparator<T> comparator, Function1<? super T, ? extends Comparable<?>> function1) {
            this.f43747a = comparator;
            this.f43748b = function1;
        }

        @Override // java.util.Comparator
        public final int compare(T t5, T t6) {
            int compare = this.f43747a.compare(t5, t6);
            if (compare != 0) {
                return compare;
            }
            Function1<T, Comparable<?>> function1 = this.f43748b;
            return g.l(function1.invoke(t6), function1.invoke(t5));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nComparisons.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Comparisons.kt\nkotlin/comparisons/ComparisonsKt__ComparisonsKt$thenByDescending$2\n*L\n1#1,328:1\n*E\n"})
    public static final class h<T> implements Comparator {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Comparator<T> f43749a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Comparator<? super K> f43750b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Function1<T, K> f43751c;

        /* JADX WARN: Multi-variable type inference failed */
        public h(Comparator<T> comparator, Comparator<? super K> comparator2, Function1<? super T, ? extends K> function1) {
            this.f43749a = comparator;
            this.f43750b = comparator2;
            this.f43751c = function1;
        }

        @Override // java.util.Comparator
        public final int compare(T t5, T t6) {
            int compare = this.f43749a.compare(t5, t6);
            if (compare != 0) {
                return compare;
            }
            Comparator<? super K> comparator = this.f43750b;
            Function1<T, K> function1 = this.f43751c;
            return comparator.compare(function1.invoke(t6), function1.invoke(t5));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nComparisons.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Comparisons.kt\nkotlin/comparisons/ComparisonsKt__ComparisonsKt$thenComparator$1\n*L\n1#1,328:1\n*E\n"})
    public static final class i<T> implements Comparator {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Comparator<T> f43752a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function2<T, T, Integer> f43753b;

        /* JADX WARN: Multi-variable type inference failed */
        public i(Comparator<T> comparator, Function2<? super T, ? super T, Integer> function2) {
            this.f43752a = comparator;
            this.f43753b = function2;
        }

        @Override // java.util.Comparator
        public final int compare(T t5, T t6) {
            int compare = this.f43752a.compare(t5, t6);
            return compare != 0 ? compare : this.f43753b.invoke(t5, t6).intValue();
        }
    }

    private static final <T> int p(T t5, T t6, Function1<? super T, ? extends Comparable<?>>[] function1Arr) {
        for (Function1<? super T, ? extends Comparable<?>> function1 : function1Arr) {
            int l6 = l(function1.invoke(t5), function1.invoke(t6));
            if (l6 != 0) {
                return l6;
            }
        }
        return 0;
    }

    @InlineOnly
    private static final <T, K> Comparator<T> B(Comparator<T> comparator, Comparator<? super K> comparator2, Function1<? super T, ? extends K> selector) {
        g0.p(comparator, "<this>");
        g0.p(comparator2, "comparator");
        g0.p(selector, "selector");
        return new f(comparator, comparator2, selector);
    }

    @InlineOnly
    private static final <T> Comparator<T> C(Comparator<T> comparator, Function1<? super T, ? extends Comparable<?>> selector) {
        g0.p(comparator, "<this>");
        g0.p(selector, "selector");
        return new e(comparator, selector);
    }

    @InlineOnly
    private static final <T, K> Comparator<T> D(Comparator<T> comparator, Comparator<? super K> comparator2, Function1<? super T, ? extends K> selector) {
        g0.p(comparator, "<this>");
        g0.p(comparator2, "comparator");
        g0.p(selector, "selector");
        return new h(comparator, comparator2, selector);
    }

    @InlineOnly
    private static final <T> Comparator<T> E(Comparator<T> comparator, Function1<? super T, ? extends Comparable<?>> selector) {
        g0.p(comparator, "<this>");
        g0.p(selector, "selector");
        return new C0861g(comparator, selector);
    }

    @InlineOnly
    private static final <T> Comparator<T> F(Comparator<T> comparator, Function2<? super T, ? super T, Integer> comparison) {
        g0.p(comparator, "<this>");
        g0.p(comparison, "comparison");
        return new i(comparator, comparison);
    }

    @NotNull
    public static final <T> Comparator<T> G(@NotNull final Comparator<T> comparator, @NotNull final Comparator<? super T> comparator2) {
        g0.p(comparator, "<this>");
        g0.p(comparator2, "comparator");
        return new Comparator() { // from class: kotlin.comparisons.c
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int H;
                H = g.H(comparator, comparator2, obj, obj2);
                return H;
            }
        };
    }

    @InlineOnly
    private static final <T, K> Comparator<T> f(Comparator<? super K> comparator, Function1<? super T, ? extends K> selector) {
        g0.p(comparator, "comparator");
        g0.p(selector, "selector");
        return new b(comparator, selector);
    }

    @InlineOnly
    private static final <T> Comparator<T> g(Function1<? super T, ? extends Comparable<?>> selector) {
        g0.p(selector, "selector");
        return new a(selector);
    }

    @NotNull
    public static final <T> Comparator<T> h(@NotNull final Function1<? super T, ? extends Comparable<?>>... selectors) {
        g0.p(selectors, "selectors");
        if (selectors.length > 0) {
            return new Comparator() { // from class: kotlin.comparisons.e
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    int i6;
                    i6 = g.i(selectors, obj, obj2);
                    return i6;
                }
            };
        }
        throw new IllegalArgumentException("Failed requirement.");
    }

    @InlineOnly
    private static final <T, K> Comparator<T> j(Comparator<? super K> comparator, Function1<? super T, ? extends K> selector) {
        g0.p(comparator, "comparator");
        g0.p(selector, "selector");
        return new d(comparator, selector);
    }

    @InlineOnly
    private static final <T> Comparator<T> k(Function1<? super T, ? extends Comparable<?>> selector) {
        g0.p(selector, "selector");
        return new c(selector);
    }

    public static <T extends Comparable<?>> int l(@Nullable T t5, @Nullable T t6) {
        if (t5 == t6) {
            return 0;
        }
        if (t5 == null) {
            return -1;
        }
        if (t6 == null) {
            return 1;
        }
        return t5.compareTo(t6);
    }

    @InlineOnly
    private static final <T, K> int m(T t5, T t6, Comparator<? super K> comparator, Function1<? super T, ? extends K> selector) {
        g0.p(comparator, "comparator");
        g0.p(selector, "selector");
        return comparator.compare(selector.invoke(t5), selector.invoke(t6));
    }

    @InlineOnly
    private static final <T> int n(T t5, T t6, Function1<? super T, ? extends Comparable<?>> selector) {
        g0.p(selector, "selector");
        return l(selector.invoke(t5), selector.invoke(t6));
    }

    public static final <T> int o(T t5, T t6, @NotNull Function1<? super T, ? extends Comparable<?>>... selectors) {
        g0.p(selectors, "selectors");
        if (selectors.length > 0) {
            return p(t5, t6, selectors);
        }
        throw new IllegalArgumentException("Failed requirement.");
    }

    @NotNull
    public static <T extends Comparable<? super T>> Comparator<T> q() {
        j jVar = j.f43754a;
        g0.n(jVar, "null cannot be cast to non-null type java.util.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.naturalOrder>");
        return jVar;
    }

    @NotNull
    public static final <T> Comparator<T> s(@NotNull final Comparator<? super T> comparator) {
        g0.p(comparator, "comparator");
        return new Comparator() { // from class: kotlin.comparisons.f
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int t5;
                t5 = g.t(comparator, obj, obj2);
                return t5;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int t(Comparator comparator, Object obj, Object obj2) {
        if (obj == obj2) {
            return 0;
        }
        if (obj == null) {
            return -1;
        }
        if (obj2 == null) {
            return 1;
        }
        return comparator.compare(obj, obj2);
    }

    @NotNull
    public static final <T> Comparator<T> v(@NotNull final Comparator<? super T> comparator) {
        g0.p(comparator, "comparator");
        return new Comparator() { // from class: kotlin.comparisons.b
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int w5;
                w5 = g.w(comparator, obj, obj2);
                return w5;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int w(Comparator comparator, Object obj, Object obj2) {
        if (obj == obj2) {
            return 0;
        }
        if (obj == null) {
            return 1;
        }
        if (obj2 == null) {
            return -1;
        }
        return comparator.compare(obj, obj2);
    }

    @NotNull
    public static <T extends Comparable<? super T>> Comparator<T> x() {
        k kVar = k.f43755a;
        g0.n(kVar, "null cannot be cast to non-null type java.util.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.reverseOrder>");
        return kVar;
    }

    @NotNull
    public static final <T> Comparator<T> y(@NotNull Comparator<T> comparator) {
        g0.p(comparator, "<this>");
        if (comparator instanceof l) {
            return ((l) comparator).a();
        }
        j jVar = j.f43754a;
        if (g0.g(comparator, jVar)) {
            k kVar = k.f43755a;
            g0.n(kVar, "null cannot be cast to non-null type java.util.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.reversed>");
            return kVar;
        }
        if (!g0.g(comparator, k.f43755a)) {
            return new l(comparator);
        }
        g0.n(jVar, "null cannot be cast to non-null type java.util.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.reversed>");
        return jVar;
    }

    @NotNull
    public static final <T> Comparator<T> z(@NotNull final Comparator<T> comparator, @NotNull final Comparator<? super T> comparator2) {
        g0.p(comparator, "<this>");
        g0.p(comparator2, "comparator");
        return new Comparator() { // from class: kotlin.comparisons.d
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int A;
                A = g.A(comparator, comparator2, obj, obj2);
                return A;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int A(Comparator comparator, Comparator comparator2, Object obj, Object obj2) {
        int compare = comparator.compare(obj, obj2);
        if (compare != 0) {
            return compare;
        }
        return comparator2.compare(obj, obj2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int H(Comparator comparator, Comparator comparator2, Object obj, Object obj2) {
        int compare = comparator.compare(obj, obj2);
        if (compare != 0) {
            return compare;
        }
        return comparator2.compare(obj2, obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int i(Function1[] function1Arr, Object obj, Object obj2) {
        return p(obj, obj2, function1Arr);
    }

    @InlineOnly
    private static final <T extends Comparable<? super T>> Comparator<T> r() {
        return s(q());
    }

    @InlineOnly
    private static final <T extends Comparable<? super T>> Comparator<T> u() {
        return v(q());
    }
}
