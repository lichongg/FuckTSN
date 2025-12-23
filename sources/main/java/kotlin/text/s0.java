package kotlin.text;

import com.daimajia.numberprogressbar.BuildConfig;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.OverloadResolutionByLambdaReturnType;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.collections.a1;
import kotlin.collections.b1;
import kotlin.collections.i1;
import kotlin.collections.u1;
import kotlin.collections.z1;
import kotlin.d1;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.n1;
import kotlin.random.Random;
import kotlin.z0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\n_Strings.kt\nKotlin\n*S Kotlin\n*F\n+ 1 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,2565:1\n130#1,2:2566\n221#1,5:2568\n507#1,5:2574\n507#1,5:2579\n467#1:2584\n1188#1,2:2585\n468#1,2:2587\n1190#1:2589\n470#1:2590\n467#1:2591\n1188#1,2:2592\n468#1,2:2594\n1190#1:2596\n470#1:2597\n1188#1,3:2598\n497#1,2:2601\n497#1,2:2603\n755#1,4:2605\n724#1,4:2609\n740#1,4:2613\n787#1,4:2617\n887#1,5:2621\n928#1,3:2626\n931#1,3:2636\n946#1,3:2639\n949#1,3:2649\n1046#1,3:2666\n1016#1,4:2669\n1005#1:2673\n1188#1,2:2674\n1190#1:2677\n1006#1:2678\n1188#1,3:2679\n1037#1:2682\n1179#1:2683\n1180#1:2685\n1038#1:2686\n1179#1,2:2687\n1188#1,3:2689\n2069#1,2:2692\n2071#1,6:2695\n2093#1,2:2701\n2095#1,6:2704\n2510#1,6:2710\n2540#1,7:2716\n1#2:2573\n1#2:2676\n1#2:2684\n1#2:2694\n1#2:2703\n382#3,7:2629\n382#3,7:2642\n382#3,7:2652\n382#3,7:2659\n*S KotlinDebug\n*F\n+ 1 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n*L\n56#1:2566,2\n66#1:2568,5\n425#1:2574,5\n434#1:2579,5\n445#1:2584\n445#1:2585,2\n445#1:2587,2\n445#1:2589\n445#1:2590\n456#1:2591\n456#1:2592,2\n456#1:2594,2\n456#1:2596\n456#1:2597\n467#1:2598,3\n479#1:2601,2\n488#1:2603,2\n682#1:2605,4\n697#1:2609,4\n711#1:2613,4\n774#1:2617,4\n847#1:2621,5\n903#1:2626,3\n903#1:2636,3\n916#1:2639,3\n916#1:2649,3\n975#1:2666,3\n985#1:2669,4\n995#1:2673\n995#1:2674,2\n995#1:2677\n995#1:2678\n1005#1:2679,3\n1029#1:2682\n1029#1:2683\n1029#1:2685\n1029#1:2686\n1037#1:2687,2\n1875#1:2689,3\n2163#1:2692,2\n2163#1:2695,6\n2180#1:2701,2\n2180#1:2704,6\n2499#1:2710,6\n2527#1:2716,7\n995#1:2676\n1029#1:2684\n2163#1:2694\n2180#1:2703\n903#1:2629,7\n916#1:2642,7\n930#1:2652,7\n948#1:2659,7\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public class s0 extends m0 {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nIterables.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Iterables.kt\nkotlin/collections/CollectionsKt__IterablesKt$Iterable$1\n+ 2 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n*L\n1#1,70:1\n2554#2:71\n*E\n"})
    public static final class a implements Iterable<Character>, m3.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CharSequence f47950a;

        public a(CharSequence charSequence) {
            this.f47950a = charSequence;
        }

        @Override // java.lang.Iterable
        public Iterator<Character> iterator() {
            return l0.S3(this.f47950a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nSequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Sequences.kt\nkotlin/sequences/SequencesKt__SequencesKt$Sequence$1\n+ 2 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n*L\n1#1,731:1\n2562#2:732\n*E\n"})
    public static final class b implements kotlin.sequences.m<Character> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CharSequence f47951a;

        public b(CharSequence charSequence) {
            this.f47951a = charSequence;
        }

        @Override // kotlin.sequences.m
        public Iterator<Character> iterator() {
            return l0.S3(this.f47951a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [K] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\n_Strings.kt\nKotlin\n*S Kotlin\n*F\n+ 1 _Strings.kt\nkotlin/text/StringsKt___StringsKt$groupingBy$1\n*L\n1#1,2565:1\n*E\n"})
    public static final class c<K> implements kotlin.collections.w0<Character, K> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CharSequence f47952a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function1<Character, K> f47953b;

        /* JADX WARN: Multi-variable type inference failed */
        public c(CharSequence charSequence, Function1<? super Character, ? extends K> function1) {
            this.f47952a = charSequence;
            this.f47953b = function1;
        }

        @Override // kotlin.collections.w0
        public /* bridge */ /* synthetic */ Object a(Character ch) {
            return c(ch.charValue());
        }

        @Override // kotlin.collections.w0
        public Iterator<Character> b() {
            return l0.S3(this.f47952a);
        }

        public K c(char c6) {
            return this.f47953b.invoke(Character.valueOf(c6));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object U9(int i6, CharSequence charSequence, Function1 function1, int i7) {
        int i8 = i6 + i7;
        if (i8 < 0 || i8 > charSequence.length()) {
            i8 = charSequence.length();
        }
        return function1.invoke(charSequence.subSequence(i7, i8));
    }

    @Nullable
    public static final Character A7(@NotNull CharSequence charSequence, @NotNull Function1<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (int i6 = 0; i6 < charSequence.length(); i6++) {
            char charAt = charSequence.charAt(i6);
            if (predicate.invoke(Character.valueOf(charAt)).booleanValue()) {
                return Character.valueOf(charAt);
            }
        }
        return null;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final Double A8(CharSequence charSequence, Function1<? super Character, Double> selector) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (charSequence.length() == 0) {
            return null;
        }
        double doubleValue = selector.invoke(Character.valueOf(charSequence.charAt(0))).doubleValue();
        int y32 = l0.y3(charSequence);
        int i6 = 1;
        if (1 <= y32) {
            while (true) {
                doubleValue = Math.min(doubleValue, selector.invoke(Character.valueOf(charSequence.charAt(i6))).doubleValue());
                if (i6 == y32) {
                    break;
                }
                i6++;
            }
        }
        return Double.valueOf(doubleValue);
    }

    @NotNull
    public static final String A9(@NotNull String str, int i6) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        if (i6 >= 0) {
            int length = str.length();
            String substring = str.substring(length - kotlin.ranges.t.B(i6, length));
            kotlin.jvm.internal.g0.o(substring, "substring(...)");
            return substring;
        }
        throw new IllegalArgumentException(("Requested character count " + i6 + " is less than zero.").toString());
    }

    @NotNull
    public static final <R> List<R> B7(@NotNull CharSequence charSequence, @NotNull Function1<? super Character, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        for (int i6 = 0; i6 < charSequence.length(); i6++) {
            kotlin.collections.f0.s0(arrayList, transform.invoke(Character.valueOf(charSequence.charAt(i6))));
        }
        return arrayList;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final Float B8(CharSequence charSequence, Function1<? super Character, Float> selector) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (charSequence.length() == 0) {
            return null;
        }
        float floatValue = selector.invoke(Character.valueOf(charSequence.charAt(0))).floatValue();
        int y32 = l0.y3(charSequence);
        int i6 = 1;
        if (1 <= y32) {
            while (true) {
                floatValue = Math.min(floatValue, selector.invoke(Character.valueOf(charSequence.charAt(i6))).floatValue());
                if (i6 == y32) {
                    break;
                }
                i6++;
            }
        }
        return Float.valueOf(floatValue);
    }

    @NotNull
    public static final CharSequence B9(@NotNull CharSequence charSequence, @NotNull Function1<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (int y32 = l0.y3(charSequence); -1 < y32; y32--) {
            if (!predicate.invoke(Character.valueOf(charSequence.charAt(y32))).booleanValue()) {
                return charSequence.subSequence(y32 + 1, charSequence.length());
            }
        }
        return charSequence.subSequence(0, charSequence.length());
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    @JvmName(name = "flatMapIndexedIterable")
    @OverloadResolutionByLambdaReturnType
    private static final <R> List<R> C7(CharSequence charSequence, Function2<? super Integer, ? super Character, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int i6 = 0;
        int i7 = 0;
        while (i6 < charSequence.length()) {
            kotlin.collections.f0.s0(arrayList, transform.invoke(Integer.valueOf(i7), Character.valueOf(charSequence.charAt(i6))));
            i6++;
            i7++;
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <R> R C8(CharSequence charSequence, Comparator<? super R> comparator, Function1<? super Character, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (charSequence.length() == 0) {
            throw new NoSuchElementException();
        }
        Object obj = (R) selector.invoke(Character.valueOf(charSequence.charAt(0)));
        int y32 = l0.y3(charSequence);
        int i6 = 1;
        if (1 <= y32) {
            while (true) {
                Object obj2 = (R) selector.invoke(Character.valueOf(charSequence.charAt(i6)));
                if (comparator.compare(obj, obj2) > 0) {
                    obj = (R) obj2;
                }
                if (i6 == y32) {
                    break;
                }
                i6++;
            }
        }
        return (R) obj;
    }

    @NotNull
    public static final String C9(@NotNull String str, @NotNull Function1<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (int y32 = l0.y3(str); -1 < y32; y32--) {
            if (!predicate.invoke(Character.valueOf(str.charAt(y32))).booleanValue()) {
                String substring = str.substring(y32 + 1);
                kotlin.jvm.internal.g0.o(substring, "substring(...)");
                return substring;
            }
        }
        return str;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    @JvmName(name = "flatMapIndexedIterableTo")
    @OverloadResolutionByLambdaReturnType
    private static final <R, C extends Collection<? super R>> C D7(CharSequence charSequence, C destination, Function2<? super Integer, ? super Character, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(transform, "transform");
        int i6 = 0;
        int i7 = 0;
        while (i6 < charSequence.length()) {
            kotlin.collections.f0.s0(destination, transform.invoke(Integer.valueOf(i7), Character.valueOf(charSequence.charAt(i6))));
            i6++;
            i7++;
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <R> R D8(CharSequence charSequence, Comparator<? super R> comparator, Function1<? super Character, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (charSequence.length() == 0) {
            return null;
        }
        Object obj = (R) selector.invoke(Character.valueOf(charSequence.charAt(0)));
        int y32 = l0.y3(charSequence);
        int i6 = 1;
        if (1 <= y32) {
            while (true) {
                Object obj2 = (R) selector.invoke(Character.valueOf(charSequence.charAt(i6)));
                if (comparator.compare(obj, obj2) > 0) {
                    obj = (R) obj2;
                }
                if (i6 == y32) {
                    break;
                }
                i6++;
            }
        }
        return (R) obj;
    }

    @NotNull
    public static final CharSequence D9(@NotNull CharSequence charSequence, @NotNull Function1<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        int length = charSequence.length();
        for (int i6 = 0; i6 < length; i6++) {
            if (!predicate.invoke(Character.valueOf(charSequence.charAt(i6))).booleanValue()) {
                return charSequence.subSequence(0, i6);
            }
        }
        return charSequence.subSequence(0, charSequence.length());
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C E7(@NotNull CharSequence charSequence, @NotNull C destination, @NotNull Function1<? super Character, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(transform, "transform");
        for (int i6 = 0; i6 < charSequence.length(); i6++) {
            kotlin.collections.f0.s0(destination, transform.invoke(Character.valueOf(charSequence.charAt(i6))));
        }
        return destination;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final Character E8(@NotNull CharSequence charSequence) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        if (charSequence.length() == 0) {
            return null;
        }
        char charAt = charSequence.charAt(0);
        int y32 = l0.y3(charSequence);
        int i6 = 1;
        if (1 <= y32) {
            while (true) {
                char charAt2 = charSequence.charAt(i6);
                if (kotlin.jvm.internal.g0.t(charAt, charAt2) > 0) {
                    charAt = charAt2;
                }
                if (i6 == y32) {
                    break;
                }
                i6++;
            }
        }
        return Character.valueOf(charAt);
    }

    @NotNull
    public static final String E9(@NotNull String str, @NotNull Function1<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        int length = str.length();
        for (int i6 = 0; i6 < length; i6++) {
            if (!predicate.invoke(Character.valueOf(str.charAt(i6))).booleanValue()) {
                String substring = str.substring(0, i6);
                kotlin.jvm.internal.g0.o(substring, "substring(...)");
                return substring;
            }
        }
        return str;
    }

    public static final <R> R F7(@NotNull CharSequence charSequence, R r5, @NotNull Function2<? super R, ? super Character, ? extends R> operation) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        for (int i6 = 0; i6 < charSequence.length(); i6++) {
            r5 = operation.invoke(r5, Character.valueOf(charSequence.charAt(i6)));
        }
        return r5;
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "minOrThrow")
    public static final char F8(@NotNull CharSequence charSequence) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        if (charSequence.length() == 0) {
            throw new NoSuchElementException();
        }
        char charAt = charSequence.charAt(0);
        int y32 = l0.y3(charSequence);
        int i6 = 1;
        if (1 <= y32) {
            while (true) {
                char charAt2 = charSequence.charAt(i6);
                if (kotlin.jvm.internal.g0.t(charAt, charAt2) > 0) {
                    charAt = charAt2;
                }
                if (i6 == y32) {
                    break;
                }
                i6++;
            }
        }
        return charAt;
    }

    @NotNull
    public static final <C extends Collection<? super Character>> C F9(@NotNull CharSequence charSequence, @NotNull C destination) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        for (int i6 = 0; i6 < charSequence.length(); i6++) {
            destination.add(Character.valueOf(charSequence.charAt(i6)));
        }
        return destination;
    }

    public static final boolean G6(@NotNull CharSequence charSequence, @NotNull Function1<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (int i6 = 0; i6 < charSequence.length(); i6++) {
            if (!predicate.invoke(Character.valueOf(charSequence.charAt(i6))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final <R> R G7(@NotNull CharSequence charSequence, R r5, @NotNull Function3<? super Integer, ? super R, ? super Character, ? extends R> operation) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        int i6 = 0;
        int i7 = 0;
        while (i6 < charSequence.length()) {
            R r6 = r5;
            r5 = operation.invoke(Integer.valueOf(i7), r6, Character.valueOf(charSequence.charAt(i6)));
            i6++;
            i7++;
        }
        return r5;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final Character G8(@NotNull CharSequence charSequence, @NotNull Comparator<? super Character> comparator) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        if (charSequence.length() == 0) {
            return null;
        }
        char charAt = charSequence.charAt(0);
        int y32 = l0.y3(charSequence);
        int i6 = 1;
        if (1 <= y32) {
            while (true) {
                char charAt2 = charSequence.charAt(i6);
                if (comparator.compare(Character.valueOf(charAt), Character.valueOf(charAt2)) > 0) {
                    charAt = charAt2;
                }
                if (i6 == y32) {
                    break;
                }
                i6++;
            }
        }
        return Character.valueOf(charAt);
    }

    @NotNull
    public static final HashSet<Character> G9(@NotNull CharSequence charSequence) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        return (HashSet) F9(charSequence, new HashSet(i1.j(kotlin.ranges.t.B(charSequence.length(), 128))));
    }

    public static final boolean H6(@NotNull CharSequence charSequence) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        return !(charSequence.length() == 0);
    }

    public static final <R> R H7(@NotNull CharSequence charSequence, R r5, @NotNull Function2<? super Character, ? super R, ? extends R> operation) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        for (int y32 = l0.y3(charSequence); y32 >= 0; y32--) {
            r5 = operation.invoke(Character.valueOf(charSequence.charAt(y32)), r5);
        }
        return r5;
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "minWithOrThrow")
    public static final char H8(@NotNull CharSequence charSequence, @NotNull Comparator<? super Character> comparator) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        if (charSequence.length() == 0) {
            throw new NoSuchElementException();
        }
        char charAt = charSequence.charAt(0);
        int y32 = l0.y3(charSequence);
        int i6 = 1;
        if (1 <= y32) {
            while (true) {
                char charAt2 = charSequence.charAt(i6);
                if (comparator.compare(Character.valueOf(charAt), Character.valueOf(charAt2)) > 0) {
                    charAt = charAt2;
                }
                if (i6 == y32) {
                    break;
                }
                i6++;
            }
        }
        return charAt;
    }

    @NotNull
    public static final List<Character> H9(@NotNull CharSequence charSequence) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        int length = charSequence.length();
        return length != 0 ? length != 1 ? I9(charSequence) : kotlin.collections.f0.l(Character.valueOf(charSequence.charAt(0))) : kotlin.collections.f0.J();
    }

    public static final boolean I6(@NotNull CharSequence charSequence, @NotNull Function1<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (int i6 = 0; i6 < charSequence.length(); i6++) {
            if (predicate.invoke(Character.valueOf(charSequence.charAt(i6))).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public static final <R> R I7(@NotNull CharSequence charSequence, R r5, @NotNull Function3<? super Integer, ? super Character, ? super R, ? extends R> operation) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        for (int y32 = l0.y3(charSequence); y32 >= 0; y32--) {
            r5 = operation.invoke(Integer.valueOf(y32), Character.valueOf(charSequence.charAt(y32)), r5);
        }
        return r5;
    }

    public static final boolean I8(@NotNull CharSequence charSequence) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        return charSequence.length() == 0;
    }

    @NotNull
    public static final List<Character> I9(@NotNull CharSequence charSequence) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        return (List) F9(charSequence, new ArrayList(charSequence.length()));
    }

    @NotNull
    public static final Iterable<Character> J6(@NotNull CharSequence charSequence) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        return ((charSequence instanceof String) && charSequence.length() == 0) ? kotlin.collections.f0.J() : new a(charSequence);
    }

    public static final void J7(@NotNull CharSequence charSequence, @NotNull Function1<? super Character, n1> action) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(action, "action");
        for (int i6 = 0; i6 < charSequence.length(); i6++) {
            action.invoke(Character.valueOf(charSequence.charAt(i6)));
        }
    }

    public static final boolean J8(@NotNull CharSequence charSequence, @NotNull Function1<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (int i6 = 0; i6 < charSequence.length(); i6++) {
            if (predicate.invoke(Character.valueOf(charSequence.charAt(i6))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @NotNull
    public static final Set<Character> J9(@NotNull CharSequence charSequence) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        int length = charSequence.length();
        return length != 0 ? length != 1 ? (Set) F9(charSequence, new LinkedHashSet(i1.j(kotlin.ranges.t.B(charSequence.length(), 128)))) : u1.f(Character.valueOf(charSequence.charAt(0))) : u1.k();
    }

    @NotNull
    public static final kotlin.sequences.m<Character> K6(@NotNull CharSequence charSequence) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        return ((charSequence instanceof String) && charSequence.length() == 0) ? kotlin.sequences.p.l() : new b(charSequence);
    }

    public static final void K7(@NotNull CharSequence charSequence, @NotNull Function2<? super Integer, ? super Character, n1> action) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(action, "action");
        int i6 = 0;
        int i7 = 0;
        while (i6 < charSequence.length()) {
            action.invoke(Integer.valueOf(i7), Character.valueOf(charSequence.charAt(i6)));
            i6++;
            i7++;
        }
    }

    @SinceKotlin(version = "1.1")
    @NotNull
    public static final <S extends CharSequence> S K8(@NotNull S s5, @NotNull Function1<? super Character, n1> action) {
        kotlin.jvm.internal.g0.p(s5, "<this>");
        kotlin.jvm.internal.g0.p(action, "action");
        for (int i6 = 0; i6 < s5.length(); i6++) {
            action.invoke(Character.valueOf(s5.charAt(i6)));
        }
        return s5;
    }

    @SinceKotlin(version = "1.2")
    @NotNull
    public static final List<String> K9(@NotNull CharSequence charSequence, int i6, int i7, boolean z5) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        return L9(charSequence, i6, i7, z5, new Function1() { // from class: kotlin.text.n0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                String O9;
                O9 = s0.O9((CharSequence) obj);
                return O9;
            }
        });
    }

    @NotNull
    public static final <K, V> Map<K, V> L6(@NotNull CharSequence charSequence, @NotNull Function1<? super Character, ? extends Pair<? extends K, ? extends V>> transform) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(transform, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.t.u(i1.j(charSequence.length()), 16));
        for (int i6 = 0; i6 < charSequence.length(); i6++) {
            Pair<? extends K, ? extends V> invoke = transform.invoke(Character.valueOf(charSequence.charAt(i6)));
            linkedHashMap.put(invoke.getFirst(), invoke.getSecond());
        }
        return linkedHashMap;
    }

    @InlineOnly
    private static final char L7(CharSequence charSequence, int i6, Function1<? super Integer, Character> defaultValue) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(defaultValue, "defaultValue");
        return (i6 < 0 || i6 >= charSequence.length()) ? defaultValue.invoke(Integer.valueOf(i6)).charValue() : charSequence.charAt(i6);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @NotNull
    public static final <S extends CharSequence> S L8(@NotNull S s5, @NotNull Function2<? super Integer, ? super Character, n1> action) {
        kotlin.jvm.internal.g0.p(s5, "<this>");
        kotlin.jvm.internal.g0.p(action, "action");
        int i6 = 0;
        int i7 = 0;
        while (i6 < s5.length()) {
            action.invoke(Integer.valueOf(i7), Character.valueOf(s5.charAt(i6)));
            i6++;
            i7++;
        }
        return s5;
    }

    @SinceKotlin(version = "1.2")
    @NotNull
    public static final <R> List<R> L9(@NotNull CharSequence charSequence, int i6, int i7, boolean z5, @NotNull Function1<? super CharSequence, ? extends R> transform) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(transform, "transform");
        z1.a(i6, i7);
        int length = charSequence.length();
        int i8 = 0;
        ArrayList arrayList = new ArrayList((length / i7) + (length % i7 == 0 ? 0 : 1));
        while (i8 >= 0 && i8 < length) {
            int i9 = i8 + i6;
            if (i9 < 0 || i9 > length) {
                if (!z5) {
                    break;
                }
                i9 = length;
            }
            arrayList.add(transform.invoke(charSequence.subSequence(i8, i9)));
            i8 += i7;
        }
        return arrayList;
    }

    @NotNull
    public static final <K> Map<K, Character> M6(@NotNull CharSequence charSequence, @NotNull Function1<? super Character, ? extends K> keySelector) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.t.u(i1.j(charSequence.length()), 16));
        for (int i6 = 0; i6 < charSequence.length(); i6++) {
            char charAt = charSequence.charAt(i6);
            linkedHashMap.put(keySelector.invoke(Character.valueOf(charAt)), Character.valueOf(charAt));
        }
        return linkedHashMap;
    }

    @Nullable
    public static final Character M7(@NotNull CharSequence charSequence, int i6) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        if (i6 < 0 || i6 >= charSequence.length()) {
            return null;
        }
        return Character.valueOf(charSequence.charAt(i6));
    }

    @NotNull
    public static final Pair<CharSequence, CharSequence> M8(@NotNull CharSequence charSequence, @NotNull Function1<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (int i6 = 0; i6 < charSequence.length(); i6++) {
            char charAt = charSequence.charAt(i6);
            if (predicate.invoke(Character.valueOf(charAt)).booleanValue()) {
                sb.append(charAt);
            } else {
                sb2.append(charAt);
            }
        }
        return new Pair<>(sb, sb2);
    }

    public static /* synthetic */ List M9(CharSequence charSequence, int i6, int i7, boolean z5, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            i7 = 1;
        }
        if ((i8 & 4) != 0) {
            z5 = false;
        }
        return K9(charSequence, i6, i7, z5);
    }

    @NotNull
    public static final <K, V> Map<K, V> N6(@NotNull CharSequence charSequence, @NotNull Function1<? super Character, ? extends K> keySelector, @NotNull Function1<? super Character, ? extends V> valueTransform) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(keySelector, "keySelector");
        kotlin.jvm.internal.g0.p(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.t.u(i1.j(charSequence.length()), 16));
        for (int i6 = 0; i6 < charSequence.length(); i6++) {
            char charAt = charSequence.charAt(i6);
            linkedHashMap.put(keySelector.invoke(Character.valueOf(charAt)), valueTransform.invoke(Character.valueOf(charAt)));
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <K> Map<K, List<Character>> N7(@NotNull CharSequence charSequence, @NotNull Function1<? super Character, ? extends K> keySelector) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (int i6 = 0; i6 < charSequence.length(); i6++) {
            char charAt = charSequence.charAt(i6);
            K invoke = keySelector.invoke(Character.valueOf(charAt));
            Object obj = linkedHashMap.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(invoke, obj);
            }
            ((List) obj).add(Character.valueOf(charAt));
        }
        return linkedHashMap;
    }

    @NotNull
    public static final Pair<String, String> N8(@NotNull String str, @NotNull Function1<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        int length = str.length();
        for (int i6 = 0; i6 < length; i6++) {
            char charAt = str.charAt(i6);
            if (predicate.invoke(Character.valueOf(charAt)).booleanValue()) {
                sb.append(charAt);
            } else {
                sb2.append(charAt);
            }
        }
        return new Pair<>(sb.toString(), sb2.toString());
    }

    public static /* synthetic */ List N9(CharSequence charSequence, int i6, int i7, boolean z5, Function1 function1, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            i7 = 1;
        }
        if ((i8 & 4) != 0) {
            z5 = false;
        }
        return L9(charSequence, i6, i7, z5, function1);
    }

    @NotNull
    public static final <K, M extends Map<? super K, ? super Character>> M O6(@NotNull CharSequence charSequence, @NotNull M destination, @NotNull Function1<? super Character, ? extends K> keySelector) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(keySelector, "keySelector");
        for (int i6 = 0; i6 < charSequence.length(); i6++) {
            char charAt = charSequence.charAt(i6);
            destination.put(keySelector.invoke(Character.valueOf(charAt)), Character.valueOf(charAt));
        }
        return destination;
    }

    @NotNull
    public static final <K, V> Map<K, List<V>> O7(@NotNull CharSequence charSequence, @NotNull Function1<? super Character, ? extends K> keySelector, @NotNull Function1<? super Character, ? extends V> valueTransform) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(keySelector, "keySelector");
        kotlin.jvm.internal.g0.p(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (int i6 = 0; i6 < charSequence.length(); i6++) {
            char charAt = charSequence.charAt(i6);
            K invoke = keySelector.invoke(Character.valueOf(charAt));
            List<V> list = linkedHashMap.get(invoke);
            if (list == null) {
                list = new ArrayList<>();
                linkedHashMap.put(invoke, list);
            }
            list.add(valueTransform.invoke(Character.valueOf(charAt)));
        }
        return linkedHashMap;
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final char O8(CharSequence charSequence) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        return P8(charSequence, Random.Default);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String O9(CharSequence it) {
        kotlin.jvm.internal.g0.p(it, "it");
        return it.toString();
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M P6(@NotNull CharSequence charSequence, @NotNull M destination, @NotNull Function1<? super Character, ? extends K> keySelector, @NotNull Function1<? super Character, ? extends V> valueTransform) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(keySelector, "keySelector");
        kotlin.jvm.internal.g0.p(valueTransform, "valueTransform");
        for (int i6 = 0; i6 < charSequence.length(); i6++) {
            char charAt = charSequence.charAt(i6);
            destination.put(keySelector.invoke(Character.valueOf(charAt)), valueTransform.invoke(Character.valueOf(charAt)));
        }
        return destination;
    }

    @NotNull
    public static final <K, M extends Map<? super K, List<Character>>> M P7(@NotNull CharSequence charSequence, @NotNull M destination, @NotNull Function1<? super Character, ? extends K> keySelector) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(keySelector, "keySelector");
        for (int i6 = 0; i6 < charSequence.length(); i6++) {
            char charAt = charSequence.charAt(i6);
            K invoke = keySelector.invoke(Character.valueOf(charAt));
            Object obj = destination.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                destination.put(invoke, obj);
            }
            ((List) obj).add(Character.valueOf(charAt));
        }
        return destination;
    }

    @SinceKotlin(version = "1.3")
    public static final char P8(@NotNull CharSequence charSequence, @NotNull Random random) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(random, "random");
        if (charSequence.length() != 0) {
            return charSequence.charAt(random.nextInt(charSequence.length()));
        }
        throw new NoSuchElementException("Char sequence is empty.");
    }

    @SinceKotlin(version = "1.2")
    @NotNull
    public static final kotlin.sequences.m<String> P9(@NotNull CharSequence charSequence, int i6, int i7, boolean z5) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        return Q9(charSequence, i6, i7, z5, new Function1() { // from class: kotlin.text.o0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                String T9;
                T9 = s0.T9((CharSequence) obj);
                return T9;
            }
        });
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M Q6(@NotNull CharSequence charSequence, @NotNull M destination, @NotNull Function1<? super Character, ? extends Pair<? extends K, ? extends V>> transform) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(transform, "transform");
        for (int i6 = 0; i6 < charSequence.length(); i6++) {
            Pair<? extends K, ? extends V> invoke = transform.invoke(Character.valueOf(charSequence.charAt(i6)));
            destination.put(invoke.getFirst(), invoke.getSecond());
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <K, V, M extends Map<? super K, List<V>>> M Q7(@NotNull CharSequence charSequence, @NotNull M destination, @NotNull Function1<? super Character, ? extends K> keySelector, @NotNull Function1<? super Character, ? extends V> valueTransform) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(keySelector, "keySelector");
        kotlin.jvm.internal.g0.p(valueTransform, "valueTransform");
        for (int i6 = 0; i6 < charSequence.length(); i6++) {
            char charAt = charSequence.charAt(i6);
            K invoke = keySelector.invoke(Character.valueOf(charAt));
            Object obj = destination.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                destination.put(invoke, obj);
            }
            ((List) obj).add(valueTransform.invoke(Character.valueOf(charAt)));
        }
        return destination;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final Character Q8(CharSequence charSequence) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        return R8(charSequence, Random.Default);
    }

    @SinceKotlin(version = "1.2")
    @NotNull
    public static final <R> kotlin.sequences.m<R> Q9(@NotNull final CharSequence charSequence, final int i6, int i7, boolean z5, @NotNull final Function1<? super CharSequence, ? extends R> transform) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(transform, "transform");
        z1.a(i6, i7);
        return kotlin.sequences.p.N1(kotlin.collections.f0.E1(kotlin.ranges.t.B1(z5 ? l0.x3(charSequence) : kotlin.ranges.t.W1(0, (charSequence.length() - i6) + 1), i7)), new Function1() { // from class: kotlin.text.r0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Object U9;
                U9 = s0.U9(i6, charSequence, transform, ((Integer) obj).intValue());
                return U9;
            }
        });
    }

    @SinceKotlin(version = "1.3")
    @NotNull
    public static final <V> Map<Character, V> R6(@NotNull CharSequence charSequence, @NotNull Function1<? super Character, ? extends V> valueSelector) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(valueSelector, "valueSelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.t.u(i1.j(kotlin.ranges.t.B(charSequence.length(), 128)), 16));
        for (int i6 = 0; i6 < charSequence.length(); i6++) {
            char charAt = charSequence.charAt(i6);
            linkedHashMap.put(Character.valueOf(charAt), valueSelector.invoke(Character.valueOf(charAt)));
        }
        return linkedHashMap;
    }

    @SinceKotlin(version = "1.1")
    @NotNull
    public static final <K> kotlin.collections.w0<Character, K> R7(@NotNull CharSequence charSequence, @NotNull Function1<? super Character, ? extends K> keySelector) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(keySelector, "keySelector");
        return new c(charSequence, keySelector);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final Character R8(@NotNull CharSequence charSequence, @NotNull Random random) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(random, "random");
        if (charSequence.length() == 0) {
            return null;
        }
        return Character.valueOf(charSequence.charAt(random.nextInt(charSequence.length())));
    }

    public static /* synthetic */ kotlin.sequences.m R9(CharSequence charSequence, int i6, int i7, boolean z5, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            i7 = 1;
        }
        if ((i8 & 4) != 0) {
            z5 = false;
        }
        return P9(charSequence, i6, i7, z5);
    }

    @SinceKotlin(version = "1.3")
    @NotNull
    public static final <V, M extends Map<? super Character, ? super V>> M S6(@NotNull CharSequence charSequence, @NotNull M destination, @NotNull Function1<? super Character, ? extends V> valueSelector) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(valueSelector, "valueSelector");
        for (int i6 = 0; i6 < charSequence.length(); i6++) {
            char charAt = charSequence.charAt(i6);
            destination.put(Character.valueOf(charAt), valueSelector.invoke(Character.valueOf(charAt)));
        }
        return destination;
    }

    public static final int S7(@NotNull CharSequence charSequence, @NotNull Function1<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        int length = charSequence.length();
        for (int i6 = 0; i6 < length; i6++) {
            if (predicate.invoke(Character.valueOf(charSequence.charAt(i6))).booleanValue()) {
                return i6;
            }
        }
        return -1;
    }

    public static final char S8(@NotNull CharSequence charSequence, @NotNull Function2<? super Character, ? super Character, Character> operation) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        if (charSequence.length() == 0) {
            throw new UnsupportedOperationException("Empty char sequence can't be reduced.");
        }
        char charAt = charSequence.charAt(0);
        int y32 = l0.y3(charSequence);
        int i6 = 1;
        if (1 <= y32) {
            while (true) {
                charAt = operation.invoke(Character.valueOf(charAt), Character.valueOf(charSequence.charAt(i6))).charValue();
                if (i6 == y32) {
                    break;
                }
                i6++;
            }
        }
        return charAt;
    }

    public static /* synthetic */ kotlin.sequences.m S9(CharSequence charSequence, int i6, int i7, boolean z5, Function1 function1, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            i7 = 1;
        }
        if ((i8 & 4) != 0) {
            z5 = false;
        }
        return Q9(charSequence, i6, i7, z5, function1);
    }

    @SinceKotlin(version = "1.2")
    @NotNull
    public static List<String> T6(@NotNull CharSequence charSequence, int i6) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        return K9(charSequence, i6, i6, true);
    }

    public static final int T7(@NotNull CharSequence charSequence, @NotNull Function1<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        int length = charSequence.length() - 1;
        if (length >= 0) {
            while (true) {
                int i6 = length - 1;
                if (predicate.invoke(Character.valueOf(charSequence.charAt(length))).booleanValue()) {
                    return length;
                }
                if (i6 < 0) {
                    break;
                }
                length = i6;
            }
        }
        return -1;
    }

    public static final char T8(@NotNull CharSequence charSequence, @NotNull Function3<? super Integer, ? super Character, ? super Character, Character> operation) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        if (charSequence.length() == 0) {
            throw new UnsupportedOperationException("Empty char sequence can't be reduced.");
        }
        char charAt = charSequence.charAt(0);
        int y32 = l0.y3(charSequence);
        int i6 = 1;
        if (1 <= y32) {
            while (true) {
                charAt = operation.invoke(Integer.valueOf(i6), Character.valueOf(charAt), Character.valueOf(charSequence.charAt(i6))).charValue();
                if (i6 == y32) {
                    break;
                }
                i6++;
            }
        }
        return charAt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String T9(CharSequence it) {
        kotlin.jvm.internal.g0.p(it, "it");
        return it.toString();
    }

    @SinceKotlin(version = "1.2")
    @NotNull
    public static final <R> List<R> U6(@NotNull CharSequence charSequence, int i6, @NotNull Function1<? super CharSequence, ? extends R> transform) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(transform, "transform");
        return L9(charSequence, i6, i6, true, transform);
    }

    public static char U7(@NotNull CharSequence charSequence) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        if (charSequence.length() != 0) {
            return charSequence.charAt(l0.y3(charSequence));
        }
        throw new NoSuchElementException("Char sequence is empty.");
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final Character U8(@NotNull CharSequence charSequence, @NotNull Function3<? super Integer, ? super Character, ? super Character, Character> operation) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        if (charSequence.length() == 0) {
            return null;
        }
        char charAt = charSequence.charAt(0);
        int y32 = l0.y3(charSequence);
        int i6 = 1;
        if (1 <= y32) {
            while (true) {
                charAt = operation.invoke(Integer.valueOf(i6), Character.valueOf(charAt), Character.valueOf(charSequence.charAt(i6))).charValue();
                if (i6 == y32) {
                    break;
                }
                i6++;
            }
        }
        return Character.valueOf(charAt);
    }

    @SinceKotlin(version = "1.2")
    @NotNull
    public static final kotlin.sequences.m<String> V6(@NotNull CharSequence charSequence, int i6) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        return W6(charSequence, i6, new Function1() { // from class: kotlin.text.p0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                String X6;
                X6 = s0.X6((CharSequence) obj);
                return X6;
            }
        });
    }

    public static final char V7(@NotNull CharSequence charSequence, @NotNull Function1<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        int length = charSequence.length() - 1;
        if (length >= 0) {
            while (true) {
                int i6 = length - 1;
                char charAt = charSequence.charAt(length);
                if (!predicate.invoke(Character.valueOf(charAt)).booleanValue()) {
                    if (i6 < 0) {
                        break;
                    }
                    length = i6;
                } else {
                    return charAt;
                }
            }
        }
        throw new NoSuchElementException("Char sequence contains no character matching the predicate.");
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final Character V8(@NotNull CharSequence charSequence, @NotNull Function2<? super Character, ? super Character, Character> operation) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        if (charSequence.length() == 0) {
            return null;
        }
        char charAt = charSequence.charAt(0);
        int y32 = l0.y3(charSequence);
        int i6 = 1;
        if (1 <= y32) {
            while (true) {
                charAt = operation.invoke(Character.valueOf(charAt), Character.valueOf(charSequence.charAt(i6))).charValue();
                if (i6 == y32) {
                    break;
                }
                i6++;
            }
        }
        return Character.valueOf(charAt);
    }

    @NotNull
    public static final Iterable<a1<Character>> V9(@NotNull final CharSequence charSequence) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        return new b1(new Function0() { // from class: kotlin.text.q0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Iterator W9;
                W9 = s0.W9(charSequence);
                return W9;
            }
        });
    }

    @SinceKotlin(version = "1.2")
    @NotNull
    public static final <R> kotlin.sequences.m<R> W6(@NotNull CharSequence charSequence, int i6, @NotNull Function1<? super CharSequence, ? extends R> transform) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(transform, "transform");
        return Q9(charSequence, i6, i6, true, transform);
    }

    @Nullable
    public static final Character W7(@NotNull CharSequence charSequence) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        if (charSequence.length() == 0) {
            return null;
        }
        return Character.valueOf(charSequence.charAt(charSequence.length() - 1));
    }

    public static final char W8(@NotNull CharSequence charSequence, @NotNull Function2<? super Character, ? super Character, Character> operation) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        int y32 = l0.y3(charSequence);
        if (y32 < 0) {
            throw new UnsupportedOperationException("Empty char sequence can't be reduced.");
        }
        char charAt = charSequence.charAt(y32);
        for (int i6 = y32 - 1; i6 >= 0; i6--) {
            charAt = operation.invoke(Character.valueOf(charSequence.charAt(i6)), Character.valueOf(charAt)).charValue();
        }
        return charAt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String X6(CharSequence it) {
        kotlin.jvm.internal.g0.p(it, "it");
        return it.toString();
    }

    @Nullable
    public static final Character X7(@NotNull CharSequence charSequence, @NotNull Function1<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        int length = charSequence.length() - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i6 = length - 1;
            char charAt = charSequence.charAt(length);
            if (predicate.invoke(Character.valueOf(charAt)).booleanValue()) {
                return Character.valueOf(charAt);
            }
            if (i6 < 0) {
                return null;
            }
            length = i6;
        }
    }

    public static final char X8(@NotNull CharSequence charSequence, @NotNull Function3<? super Integer, ? super Character, ? super Character, Character> operation) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        int y32 = l0.y3(charSequence);
        if (y32 < 0) {
            throw new UnsupportedOperationException("Empty char sequence can't be reduced.");
        }
        char charAt = charSequence.charAt(y32);
        for (int i6 = y32 - 1; i6 >= 0; i6--) {
            charAt = operation.invoke(Integer.valueOf(i6), Character.valueOf(charSequence.charAt(i6)), Character.valueOf(charAt)).charValue();
        }
        return charAt;
    }

    @NotNull
    public static final List<Pair<Character, Character>> X9(@NotNull CharSequence charSequence, @NotNull CharSequence other) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        int min = Math.min(charSequence.length(), other.length());
        ArrayList arrayList = new ArrayList(min);
        for (int i6 = 0; i6 < min; i6++) {
            arrayList.add(kotlin.o0.a(Character.valueOf(charSequence.charAt(i6)), Character.valueOf(other.charAt(i6))));
        }
        return arrayList;
    }

    @InlineOnly
    private static final int Y6(CharSequence charSequence) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        return charSequence.length();
    }

    @NotNull
    public static final <R> List<R> Y7(@NotNull CharSequence charSequence, @NotNull Function1<? super Character, ? extends R> transform) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(transform, "transform");
        ArrayList arrayList = new ArrayList(charSequence.length());
        for (int i6 = 0; i6 < charSequence.length(); i6++) {
            arrayList.add(transform.invoke(Character.valueOf(charSequence.charAt(i6))));
        }
        return arrayList;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final Character Y8(@NotNull CharSequence charSequence, @NotNull Function3<? super Integer, ? super Character, ? super Character, Character> operation) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        int y32 = l0.y3(charSequence);
        if (y32 < 0) {
            return null;
        }
        char charAt = charSequence.charAt(y32);
        for (int i6 = y32 - 1; i6 >= 0; i6--) {
            charAt = operation.invoke(Integer.valueOf(i6), Character.valueOf(charSequence.charAt(i6)), Character.valueOf(charAt)).charValue();
        }
        return Character.valueOf(charAt);
    }

    @NotNull
    public static final <V> List<V> Y9(@NotNull CharSequence charSequence, @NotNull CharSequence other, @NotNull Function2<? super Character, ? super Character, ? extends V> transform) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        kotlin.jvm.internal.g0.p(transform, "transform");
        int min = Math.min(charSequence.length(), other.length());
        ArrayList arrayList = new ArrayList(min);
        for (int i6 = 0; i6 < min; i6++) {
            arrayList.add(transform.invoke(Character.valueOf(charSequence.charAt(i6)), Character.valueOf(other.charAt(i6))));
        }
        return arrayList;
    }

    public static final int Z6(@NotNull CharSequence charSequence, @NotNull Function1<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        int i6 = 0;
        for (int i7 = 0; i7 < charSequence.length(); i7++) {
            if (predicate.invoke(Character.valueOf(charSequence.charAt(i7))).booleanValue()) {
                i6++;
            }
        }
        return i6;
    }

    @NotNull
    public static final <R> List<R> Z7(@NotNull CharSequence charSequence, @NotNull Function2<? super Integer, ? super Character, ? extends R> transform) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(transform, "transform");
        ArrayList arrayList = new ArrayList(charSequence.length());
        int i6 = 0;
        int i7 = 0;
        while (i6 < charSequence.length()) {
            arrayList.add(transform.invoke(Integer.valueOf(i7), Character.valueOf(charSequence.charAt(i6))));
            i6++;
            i7++;
        }
        return arrayList;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final Character Z8(@NotNull CharSequence charSequence, @NotNull Function2<? super Character, ? super Character, Character> operation) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        int y32 = l0.y3(charSequence);
        if (y32 < 0) {
            return null;
        }
        char charAt = charSequence.charAt(y32);
        for (int i6 = y32 - 1; i6 >= 0; i6--) {
            charAt = operation.invoke(Character.valueOf(charSequence.charAt(i6)), Character.valueOf(charAt)).charValue();
        }
        return Character.valueOf(charAt);
    }

    @SinceKotlin(version = "1.2")
    @NotNull
    public static final List<Pair<Character, Character>> Z9(@NotNull CharSequence charSequence) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        int length = charSequence.length() - 1;
        if (length < 1) {
            return kotlin.collections.f0.J();
        }
        ArrayList arrayList = new ArrayList(length);
        int i6 = 0;
        while (i6 < length) {
            char charAt = charSequence.charAt(i6);
            i6++;
            arrayList.add(kotlin.o0.a(Character.valueOf(charAt), Character.valueOf(charSequence.charAt(i6))));
        }
        return arrayList;
    }

    @NotNull
    public static final CharSequence a7(@NotNull CharSequence charSequence, int i6) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        if (i6 >= 0) {
            return charSequence.subSequence(kotlin.ranges.t.B(i6, charSequence.length()), charSequence.length());
        }
        throw new IllegalArgumentException(("Requested character count " + i6 + " is less than zero.").toString());
    }

    @NotNull
    public static final <R> List<R> a8(@NotNull CharSequence charSequence, @NotNull Function2<? super Integer, ? super Character, ? extends R> transform) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int i6 = 0;
        int i7 = 0;
        while (i6 < charSequence.length()) {
            int i8 = i7 + 1;
            R invoke = transform.invoke(Integer.valueOf(i7), Character.valueOf(charSequence.charAt(i6)));
            if (invoke != null) {
                arrayList.add(invoke);
            }
            i6++;
            i7 = i8;
        }
        return arrayList;
    }

    @NotNull
    public static final CharSequence a9(@NotNull CharSequence charSequence) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        return new StringBuilder(charSequence).reverse();
    }

    @SinceKotlin(version = "1.2")
    @NotNull
    public static final <R> List<R> aa(@NotNull CharSequence charSequence, @NotNull Function2<? super Character, ? super Character, ? extends R> transform) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(transform, "transform");
        int length = charSequence.length() - 1;
        if (length < 1) {
            return kotlin.collections.f0.J();
        }
        ArrayList arrayList = new ArrayList(length);
        int i6 = 0;
        while (i6 < length) {
            Character valueOf = Character.valueOf(charSequence.charAt(i6));
            i6++;
            arrayList.add(transform.invoke(valueOf, Character.valueOf(charSequence.charAt(i6))));
        }
        return arrayList;
    }

    @NotNull
    public static String b7(@NotNull String str, int i6) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        if (i6 >= 0) {
            String substring = str.substring(kotlin.ranges.t.B(i6, str.length()));
            kotlin.jvm.internal.g0.o(substring, "substring(...)");
            return substring;
        }
        throw new IllegalArgumentException(("Requested character count " + i6 + " is less than zero.").toString());
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C b8(@NotNull CharSequence charSequence, @NotNull C destination, @NotNull Function2<? super Integer, ? super Character, ? extends R> transform) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(transform, "transform");
        int i6 = 0;
        int i7 = 0;
        while (i6 < charSequence.length()) {
            int i8 = i7 + 1;
            R invoke = transform.invoke(Integer.valueOf(i7), Character.valueOf(charSequence.charAt(i6)));
            if (invoke != null) {
                destination.add(invoke);
            }
            i6++;
            i7 = i8;
        }
        return destination;
    }

    @InlineOnly
    private static final String b9(String str) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        return a9(str).toString();
    }

    @NotNull
    public static final CharSequence c7(@NotNull CharSequence charSequence, int i6) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        if (i6 >= 0) {
            return x9(charSequence, kotlin.ranges.t.u(charSequence.length() - i6, 0));
        }
        throw new IllegalArgumentException(("Requested character count " + i6 + " is less than zero.").toString());
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C c8(@NotNull CharSequence charSequence, @NotNull C destination, @NotNull Function2<? super Integer, ? super Character, ? extends R> transform) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(transform, "transform");
        int i6 = 0;
        int i7 = 0;
        while (i6 < charSequence.length()) {
            destination.add(transform.invoke(Integer.valueOf(i7), Character.valueOf(charSequence.charAt(i6))));
            i6++;
            i7++;
        }
        return destination;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @NotNull
    public static final <R> List<R> c9(@NotNull CharSequence charSequence, R r5, @NotNull Function2<? super R, ? super Character, ? extends R> operation) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        if (charSequence.length() == 0) {
            return kotlin.collections.f0.l(r5);
        }
        ArrayList arrayList = new ArrayList(charSequence.length() + 1);
        arrayList.add(r5);
        for (int i6 = 0; i6 < charSequence.length(); i6++) {
            r5 = operation.invoke(r5, Character.valueOf(charSequence.charAt(i6)));
            arrayList.add(r5);
        }
        return arrayList;
    }

    @NotNull
    public static String d7(@NotNull String str, int i6) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        if (i6 >= 0) {
            return y9(str, kotlin.ranges.t.u(str.length() - i6, 0));
        }
        throw new IllegalArgumentException(("Requested character count " + i6 + " is less than zero.").toString());
    }

    @NotNull
    public static final <R> List<R> d8(@NotNull CharSequence charSequence, @NotNull Function1<? super Character, ? extends R> transform) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        for (int i6 = 0; i6 < charSequence.length(); i6++) {
            R invoke = transform.invoke(Character.valueOf(charSequence.charAt(i6)));
            if (invoke != null) {
                arrayList.add(invoke);
            }
        }
        return arrayList;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @NotNull
    public static final <R> List<R> d9(@NotNull CharSequence charSequence, R r5, @NotNull Function3<? super Integer, ? super R, ? super Character, ? extends R> operation) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        if (charSequence.length() == 0) {
            return kotlin.collections.f0.l(r5);
        }
        ArrayList arrayList = new ArrayList(charSequence.length() + 1);
        arrayList.add(r5);
        int length = charSequence.length();
        for (int i6 = 0; i6 < length; i6++) {
            r5 = operation.invoke(Integer.valueOf(i6), r5, Character.valueOf(charSequence.charAt(i6)));
            arrayList.add(r5);
        }
        return arrayList;
    }

    @NotNull
    public static final CharSequence e7(@NotNull CharSequence charSequence, @NotNull Function1<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (int y32 = l0.y3(charSequence); -1 < y32; y32--) {
            if (!predicate.invoke(Character.valueOf(charSequence.charAt(y32))).booleanValue()) {
                return charSequence.subSequence(0, y32 + 1);
            }
        }
        return "";
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C e8(@NotNull CharSequence charSequence, @NotNull C destination, @NotNull Function1<? super Character, ? extends R> transform) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(transform, "transform");
        for (int i6 = 0; i6 < charSequence.length(); i6++) {
            R invoke = transform.invoke(Character.valueOf(charSequence.charAt(i6)));
            if (invoke != null) {
                destination.add(invoke);
            }
        }
        return destination;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @NotNull
    public static final List<Character> e9(@NotNull CharSequence charSequence, @NotNull Function2<? super Character, ? super Character, Character> operation) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        if (charSequence.length() == 0) {
            return kotlin.collections.f0.J();
        }
        char charAt = charSequence.charAt(0);
        ArrayList arrayList = new ArrayList(charSequence.length());
        arrayList.add(Character.valueOf(charAt));
        int length = charSequence.length();
        int i6 = 1;
        while (i6 < length) {
            Character invoke = operation.invoke(Character.valueOf(charAt), Character.valueOf(charSequence.charAt(i6)));
            char charValue = invoke.charValue();
            arrayList.add(invoke);
            i6++;
            charAt = charValue;
        }
        return arrayList;
    }

    @NotNull
    public static final String f7(@NotNull String str, @NotNull Function1<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (int y32 = l0.y3(str); -1 < y32; y32--) {
            if (!predicate.invoke(Character.valueOf(str.charAt(y32))).booleanValue()) {
                String substring = str.substring(0, y32 + 1);
                kotlin.jvm.internal.g0.o(substring, "substring(...)");
                return substring;
            }
        }
        return "";
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C f8(@NotNull CharSequence charSequence, @NotNull C destination, @NotNull Function1<? super Character, ? extends R> transform) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(transform, "transform");
        for (int i6 = 0; i6 < charSequence.length(); i6++) {
            destination.add(transform.invoke(Character.valueOf(charSequence.charAt(i6))));
        }
        return destination;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @NotNull
    public static final List<Character> f9(@NotNull CharSequence charSequence, @NotNull Function3<? super Integer, ? super Character, ? super Character, Character> operation) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        if (charSequence.length() == 0) {
            return kotlin.collections.f0.J();
        }
        char charAt = charSequence.charAt(0);
        ArrayList arrayList = new ArrayList(charSequence.length());
        arrayList.add(Character.valueOf(charAt));
        int length = charSequence.length();
        int i6 = 1;
        while (i6 < length) {
            Character invoke = operation.invoke(Integer.valueOf(i6), Character.valueOf(charAt), Character.valueOf(charSequence.charAt(i6)));
            char charValue = invoke.charValue();
            arrayList.add(invoke);
            i6++;
            charAt = charValue;
        }
        return arrayList;
    }

    @NotNull
    public static final CharSequence g7(@NotNull CharSequence charSequence, @NotNull Function1<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        int length = charSequence.length();
        for (int i6 = 0; i6 < length; i6++) {
            if (!predicate.invoke(Character.valueOf(charSequence.charAt(i6))).booleanValue()) {
                return charSequence.subSequence(i6, charSequence.length());
            }
        }
        return "";
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final <R extends Comparable<? super R>> Character g8(@NotNull CharSequence charSequence, @NotNull Function1<? super Character, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (charSequence.length() == 0) {
            return null;
        }
        char charAt = charSequence.charAt(0);
        int y32 = l0.y3(charSequence);
        if (y32 == 0) {
            return Character.valueOf(charAt);
        }
        R invoke = selector.invoke(Character.valueOf(charAt));
        int i6 = 1;
        if (1 <= y32) {
            while (true) {
                char charAt2 = charSequence.charAt(i6);
                R invoke2 = selector.invoke(Character.valueOf(charAt2));
                if (invoke.compareTo(invoke2) < 0) {
                    charAt = charAt2;
                    invoke = invoke2;
                }
                if (i6 == y32) {
                    break;
                }
                i6++;
            }
        }
        return Character.valueOf(charAt);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @NotNull
    public static final <R> List<R> g9(@NotNull CharSequence charSequence, R r5, @NotNull Function2<? super R, ? super Character, ? extends R> operation) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        if (charSequence.length() == 0) {
            return kotlin.collections.f0.l(r5);
        }
        ArrayList arrayList = new ArrayList(charSequence.length() + 1);
        arrayList.add(r5);
        for (int i6 = 0; i6 < charSequence.length(); i6++) {
            r5 = operation.invoke(r5, Character.valueOf(charSequence.charAt(i6)));
            arrayList.add(r5);
        }
        return arrayList;
    }

    @NotNull
    public static final String h7(@NotNull String str, @NotNull Function1<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        int length = str.length();
        for (int i6 = 0; i6 < length; i6++) {
            if (!predicate.invoke(Character.valueOf(str.charAt(i6))).booleanValue()) {
                String substring = str.substring(i6);
                kotlin.jvm.internal.g0.o(substring, "substring(...)");
                return substring;
            }
        }
        return "";
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "maxByOrThrow")
    public static final <R extends Comparable<? super R>> char h8(@NotNull CharSequence charSequence, @NotNull Function1<? super Character, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (charSequence.length() == 0) {
            throw new NoSuchElementException();
        }
        char charAt = charSequence.charAt(0);
        int y32 = l0.y3(charSequence);
        if (y32 != 0) {
            R invoke = selector.invoke(Character.valueOf(charAt));
            int i6 = 1;
            if (1 <= y32) {
                while (true) {
                    char charAt2 = charSequence.charAt(i6);
                    R invoke2 = selector.invoke(Character.valueOf(charAt2));
                    if (invoke.compareTo(invoke2) < 0) {
                        charAt = charAt2;
                        invoke = invoke2;
                    }
                    if (i6 == y32) {
                        break;
                    }
                    i6++;
                }
            }
        }
        return charAt;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @NotNull
    public static final <R> List<R> h9(@NotNull CharSequence charSequence, R r5, @NotNull Function3<? super Integer, ? super R, ? super Character, ? extends R> operation) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        if (charSequence.length() == 0) {
            return kotlin.collections.f0.l(r5);
        }
        ArrayList arrayList = new ArrayList(charSequence.length() + 1);
        arrayList.add(r5);
        int length = charSequence.length();
        for (int i6 = 0; i6 < length; i6++) {
            r5 = operation.invoke(Integer.valueOf(i6), r5, Character.valueOf(charSequence.charAt(i6)));
            arrayList.add(r5);
        }
        return arrayList;
    }

    @InlineOnly
    private static final char i7(CharSequence charSequence, int i6, Function1<? super Integer, Character> defaultValue) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(defaultValue, "defaultValue");
        return (i6 < 0 || i6 >= charSequence.length()) ? defaultValue.invoke(Integer.valueOf(i6)).charValue() : charSequence.charAt(i6);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final double i8(CharSequence charSequence, Function1<? super Character, Double> selector) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (charSequence.length() == 0) {
            throw new NoSuchElementException();
        }
        double doubleValue = selector.invoke(Character.valueOf(charSequence.charAt(0))).doubleValue();
        int y32 = l0.y3(charSequence);
        int i6 = 1;
        if (1 <= y32) {
            while (true) {
                doubleValue = Math.max(doubleValue, selector.invoke(Character.valueOf(charSequence.charAt(i6))).doubleValue());
                if (i6 == y32) {
                    break;
                }
                i6++;
            }
        }
        return doubleValue;
    }

    public static final char i9(@NotNull CharSequence charSequence) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        int length = charSequence.length();
        if (length == 0) {
            throw new NoSuchElementException("Char sequence is empty.");
        }
        if (length == 1) {
            return charSequence.charAt(0);
        }
        throw new IllegalArgumentException("Char sequence has more than one element.");
    }

    @InlineOnly
    private static final Character j7(CharSequence charSequence, int i6) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        return M7(charSequence, i6);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final float j8(CharSequence charSequence, Function1<? super Character, Float> selector) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (charSequence.length() == 0) {
            throw new NoSuchElementException();
        }
        float floatValue = selector.invoke(Character.valueOf(charSequence.charAt(0))).floatValue();
        int y32 = l0.y3(charSequence);
        int i6 = 1;
        if (1 <= y32) {
            while (true) {
                floatValue = Math.max(floatValue, selector.invoke(Character.valueOf(charSequence.charAt(i6))).floatValue());
                if (i6 == y32) {
                    break;
                }
                i6++;
            }
        }
        return floatValue;
    }

    public static final char j9(@NotNull CharSequence charSequence, @NotNull Function1<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        Character ch = null;
        boolean z5 = false;
        for (int i6 = 0; i6 < charSequence.length(); i6++) {
            char charAt = charSequence.charAt(i6);
            if (predicate.invoke(Character.valueOf(charAt)).booleanValue()) {
                if (z5) {
                    throw new IllegalArgumentException("Char sequence contains more than one matching element.");
                }
                ch = Character.valueOf(charAt);
                z5 = true;
            }
        }
        if (!z5) {
            throw new NoSuchElementException("Char sequence contains no character matching the predicate.");
        }
        kotlin.jvm.internal.g0.n(ch, "null cannot be cast to non-null type kotlin.Char");
        return ch.charValue();
    }

    @NotNull
    public static final CharSequence k7(@NotNull CharSequence charSequence, @NotNull Function1<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        StringBuilder sb = new StringBuilder();
        int length = charSequence.length();
        for (int i6 = 0; i6 < length; i6++) {
            char charAt = charSequence.charAt(i6);
            if (predicate.invoke(Character.valueOf(charAt)).booleanValue()) {
                sb.append(charAt);
            }
        }
        return sb;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <R extends Comparable<? super R>> R k8(CharSequence charSequence, Function1<? super Character, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (charSequence.length() == 0) {
            throw new NoSuchElementException();
        }
        R invoke = selector.invoke(Character.valueOf(charSequence.charAt(0)));
        int y32 = l0.y3(charSequence);
        int i6 = 1;
        if (1 <= y32) {
            while (true) {
                R invoke2 = selector.invoke(Character.valueOf(charSequence.charAt(i6)));
                if (invoke.compareTo(invoke2) < 0) {
                    invoke = invoke2;
                }
                if (i6 == y32) {
                    break;
                }
                i6++;
            }
        }
        return invoke;
    }

    @Nullable
    public static final Character k9(@NotNull CharSequence charSequence) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        if (charSequence.length() == 1) {
            return Character.valueOf(charSequence.charAt(0));
        }
        return null;
    }

    @NotNull
    public static final String l7(@NotNull String str, @NotNull Function1<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i6 = 0; i6 < length; i6++) {
            char charAt = str.charAt(i6);
            if (predicate.invoke(Character.valueOf(charAt)).booleanValue()) {
                sb.append(charAt);
            }
        }
        return sb.toString();
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <R extends Comparable<? super R>> R l8(CharSequence charSequence, Function1<? super Character, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (charSequence.length() == 0) {
            return null;
        }
        R invoke = selector.invoke(Character.valueOf(charSequence.charAt(0)));
        int y32 = l0.y3(charSequence);
        int i6 = 1;
        if (1 <= y32) {
            while (true) {
                R invoke2 = selector.invoke(Character.valueOf(charSequence.charAt(i6)));
                if (invoke.compareTo(invoke2) < 0) {
                    invoke = invoke2;
                }
                if (i6 == y32) {
                    break;
                }
                i6++;
            }
        }
        return invoke;
    }

    @Nullable
    public static final Character l9(@NotNull CharSequence charSequence, @NotNull Function1<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        Character ch = null;
        boolean z5 = false;
        for (int i6 = 0; i6 < charSequence.length(); i6++) {
            char charAt = charSequence.charAt(i6);
            if (predicate.invoke(Character.valueOf(charAt)).booleanValue()) {
                if (z5) {
                    return null;
                }
                ch = Character.valueOf(charAt);
                z5 = true;
            }
        }
        if (z5) {
            return ch;
        }
        return null;
    }

    @NotNull
    public static final CharSequence m7(@NotNull CharSequence charSequence, @NotNull Function2<? super Integer, ? super Character, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        StringBuilder sb = new StringBuilder();
        int i6 = 0;
        int i7 = 0;
        while (i6 < charSequence.length()) {
            char charAt = charSequence.charAt(i6);
            int i8 = i7 + 1;
            if (predicate.invoke(Integer.valueOf(i7), Character.valueOf(charAt)).booleanValue()) {
                sb.append(charAt);
            }
            i6++;
            i7 = i8;
        }
        return sb;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final Double m8(CharSequence charSequence, Function1<? super Character, Double> selector) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (charSequence.length() == 0) {
            return null;
        }
        double doubleValue = selector.invoke(Character.valueOf(charSequence.charAt(0))).doubleValue();
        int y32 = l0.y3(charSequence);
        int i6 = 1;
        if (1 <= y32) {
            while (true) {
                doubleValue = Math.max(doubleValue, selector.invoke(Character.valueOf(charSequence.charAt(i6))).doubleValue());
                if (i6 == y32) {
                    break;
                }
                i6++;
            }
        }
        return Double.valueOf(doubleValue);
    }

    @NotNull
    public static final CharSequence m9(@NotNull CharSequence charSequence, @NotNull Iterable<Integer> indices) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(indices, "indices");
        int d02 = kotlin.collections.f0.d0(indices, 10);
        if (d02 == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(d02);
        Iterator<Integer> it = indices.iterator();
        while (it.hasNext()) {
            sb.append(charSequence.charAt(it.next().intValue()));
        }
        return sb;
    }

    @NotNull
    public static final String n7(@NotNull String str, @NotNull Function2<? super Integer, ? super Character, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        StringBuilder sb = new StringBuilder();
        int i6 = 0;
        int i7 = 0;
        while (i6 < str.length()) {
            char charAt = str.charAt(i6);
            int i8 = i7 + 1;
            if (predicate.invoke(Integer.valueOf(i7), Character.valueOf(charAt)).booleanValue()) {
                sb.append(charAt);
            }
            i6++;
            i7 = i8;
        }
        return sb.toString();
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final Float n8(CharSequence charSequence, Function1<? super Character, Float> selector) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (charSequence.length() == 0) {
            return null;
        }
        float floatValue = selector.invoke(Character.valueOf(charSequence.charAt(0))).floatValue();
        int y32 = l0.y3(charSequence);
        int i6 = 1;
        if (1 <= y32) {
            while (true) {
                floatValue = Math.max(floatValue, selector.invoke(Character.valueOf(charSequence.charAt(i6))).floatValue());
                if (i6 == y32) {
                    break;
                }
                i6++;
            }
        }
        return Float.valueOf(floatValue);
    }

    @NotNull
    public static final CharSequence n9(@NotNull CharSequence charSequence, @NotNull kotlin.ranges.m indices) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(indices, "indices");
        return indices.isEmpty() ? "" : l0.B5(charSequence, indices);
    }

    @NotNull
    public static final <C extends Appendable> C o7(@NotNull CharSequence charSequence, @NotNull C destination, @NotNull Function2<? super Integer, ? super Character, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        int i6 = 0;
        int i7 = 0;
        while (i6 < charSequence.length()) {
            char charAt = charSequence.charAt(i6);
            int i8 = i7 + 1;
            if (predicate.invoke(Integer.valueOf(i7), Character.valueOf(charAt)).booleanValue()) {
                destination.append(charAt);
            }
            i6++;
            i7 = i8;
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <R> R o8(CharSequence charSequence, Comparator<? super R> comparator, Function1<? super Character, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (charSequence.length() == 0) {
            throw new NoSuchElementException();
        }
        Object obj = (R) selector.invoke(Character.valueOf(charSequence.charAt(0)));
        int y32 = l0.y3(charSequence);
        int i6 = 1;
        if (1 <= y32) {
            while (true) {
                Object obj2 = (R) selector.invoke(Character.valueOf(charSequence.charAt(i6)));
                if (comparator.compare(obj, obj2) < 0) {
                    obj = (R) obj2;
                }
                if (i6 == y32) {
                    break;
                }
                i6++;
            }
        }
        return (R) obj;
    }

    @InlineOnly
    private static final String o9(String str, Iterable<Integer> indices) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        kotlin.jvm.internal.g0.p(indices, "indices");
        return m9(str, indices).toString();
    }

    @NotNull
    public static final CharSequence p7(@NotNull CharSequence charSequence, @NotNull Function1<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        StringBuilder sb = new StringBuilder();
        for (int i6 = 0; i6 < charSequence.length(); i6++) {
            char charAt = charSequence.charAt(i6);
            if (!predicate.invoke(Character.valueOf(charAt)).booleanValue()) {
                sb.append(charAt);
            }
        }
        return sb;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <R> R p8(CharSequence charSequence, Comparator<? super R> comparator, Function1<? super Character, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (charSequence.length() == 0) {
            return null;
        }
        Object obj = (R) selector.invoke(Character.valueOf(charSequence.charAt(0)));
        int y32 = l0.y3(charSequence);
        int i6 = 1;
        if (1 <= y32) {
            while (true) {
                Object obj2 = (R) selector.invoke(Character.valueOf(charSequence.charAt(i6)));
                if (comparator.compare(obj, obj2) < 0) {
                    obj = (R) obj2;
                }
                if (i6 == y32) {
                    break;
                }
                i6++;
            }
        }
        return (R) obj;
    }

    @NotNull
    public static final String p9(@NotNull String str, @NotNull kotlin.ranges.m indices) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        kotlin.jvm.internal.g0.p(indices, "indices");
        return indices.isEmpty() ? "" : l0.F5(str, indices);
    }

    @NotNull
    public static final String q7(@NotNull String str, @NotNull Function1<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        StringBuilder sb = new StringBuilder();
        for (int i6 = 0; i6 < str.length(); i6++) {
            char charAt = str.charAt(i6);
            if (!predicate.invoke(Character.valueOf(charAt)).booleanValue()) {
                sb.append(charAt);
            }
        }
        return sb.toString();
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final Character q8(@NotNull CharSequence charSequence) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        if (charSequence.length() == 0) {
            return null;
        }
        char charAt = charSequence.charAt(0);
        int y32 = l0.y3(charSequence);
        int i6 = 1;
        if (1 <= y32) {
            while (true) {
                char charAt2 = charSequence.charAt(i6);
                if (kotlin.jvm.internal.g0.t(charAt, charAt2) < 0) {
                    charAt = charAt2;
                }
                if (i6 == y32) {
                    break;
                }
                i6++;
            }
        }
        return Character.valueOf(charAt);
    }

    @Deprecated(message = "Use sumOf instead.", replaceWith = @ReplaceWith(expression = "this.sumOf(selector)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final int q9(@NotNull CharSequence charSequence, @NotNull Function1<? super Character, Integer> selector) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        int i6 = 0;
        for (int i7 = 0; i7 < charSequence.length(); i7++) {
            i6 += selector.invoke(Character.valueOf(charSequence.charAt(i7))).intValue();
        }
        return i6;
    }

    @NotNull
    public static final <C extends Appendable> C r7(@NotNull CharSequence charSequence, @NotNull C destination, @NotNull Function1<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (int i6 = 0; i6 < charSequence.length(); i6++) {
            char charAt = charSequence.charAt(i6);
            if (!predicate.invoke(Character.valueOf(charAt)).booleanValue()) {
                destination.append(charAt);
            }
        }
        return destination;
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "maxOrThrow")
    public static final char r8(@NotNull CharSequence charSequence) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        if (charSequence.length() == 0) {
            throw new NoSuchElementException();
        }
        char charAt = charSequence.charAt(0);
        int y32 = l0.y3(charSequence);
        int i6 = 1;
        if (1 <= y32) {
            while (true) {
                char charAt2 = charSequence.charAt(i6);
                if (kotlin.jvm.internal.g0.t(charAt, charAt2) < 0) {
                    charAt = charAt2;
                }
                if (i6 == y32) {
                    break;
                }
                i6++;
            }
        }
        return charAt;
    }

    @Deprecated(message = "Use sumOf instead.", replaceWith = @ReplaceWith(expression = "this.sumOf(selector)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final double r9(@NotNull CharSequence charSequence, @NotNull Function1<? super Character, Double> selector) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        double d6 = 0.0d;
        for (int i6 = 0; i6 < charSequence.length(); i6++) {
            d6 += selector.invoke(Character.valueOf(charSequence.charAt(i6))).doubleValue();
        }
        return d6;
    }

    @NotNull
    public static final <C extends Appendable> C s7(@NotNull CharSequence charSequence, @NotNull C destination, @NotNull Function1<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        int length = charSequence.length();
        for (int i6 = 0; i6 < length; i6++) {
            char charAt = charSequence.charAt(i6);
            if (predicate.invoke(Character.valueOf(charAt)).booleanValue()) {
                destination.append(charAt);
            }
        }
        return destination;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final Character s8(@NotNull CharSequence charSequence, @NotNull Comparator<? super Character> comparator) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        if (charSequence.length() == 0) {
            return null;
        }
        char charAt = charSequence.charAt(0);
        int y32 = l0.y3(charSequence);
        int i6 = 1;
        if (1 <= y32) {
            while (true) {
                char charAt2 = charSequence.charAt(i6);
                if (comparator.compare(Character.valueOf(charAt), Character.valueOf(charAt2)) < 0) {
                    charAt = charAt2;
                }
                if (i6 == y32) {
                    break;
                }
                i6++;
            }
        }
        return Character.valueOf(charAt);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    @JvmName(name = "sumOfDouble")
    @OverloadResolutionByLambdaReturnType
    private static final double s9(CharSequence charSequence, Function1<? super Character, Double> selector) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        double d6 = 0.0d;
        for (int i6 = 0; i6 < charSequence.length(); i6++) {
            d6 += selector.invoke(Character.valueOf(charSequence.charAt(i6))).doubleValue();
        }
        return d6;
    }

    @InlineOnly
    private static final Character t7(CharSequence charSequence, Function1<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (int i6 = 0; i6 < charSequence.length(); i6++) {
            char charAt = charSequence.charAt(i6);
            if (predicate.invoke(Character.valueOf(charAt)).booleanValue()) {
                return Character.valueOf(charAt);
            }
        }
        return null;
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "maxWithOrThrow")
    public static final char t8(@NotNull CharSequence charSequence, @NotNull Comparator<? super Character> comparator) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        if (charSequence.length() == 0) {
            throw new NoSuchElementException();
        }
        char charAt = charSequence.charAt(0);
        int y32 = l0.y3(charSequence);
        int i6 = 1;
        if (1 <= y32) {
            while (true) {
                char charAt2 = charSequence.charAt(i6);
                if (comparator.compare(Character.valueOf(charAt), Character.valueOf(charAt2)) < 0) {
                    charAt = charAt2;
                }
                if (i6 == y32) {
                    break;
                }
                i6++;
            }
        }
        return charAt;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    @JvmName(name = "sumOfInt")
    private static final int t9(CharSequence charSequence, Function1<? super Character, Integer> selector) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        int i6 = 0;
        for (int i7 = 0; i7 < charSequence.length(); i7++) {
            i6 += selector.invoke(Character.valueOf(charSequence.charAt(i7))).intValue();
        }
        return i6;
    }

    @InlineOnly
    private static final Character u7(CharSequence charSequence, Function1<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        int length = charSequence.length() - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i6 = length - 1;
            char charAt = charSequence.charAt(length);
            if (predicate.invoke(Character.valueOf(charAt)).booleanValue()) {
                return Character.valueOf(charAt);
            }
            if (i6 < 0) {
                return null;
            }
            length = i6;
        }
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final <R extends Comparable<? super R>> Character u8(@NotNull CharSequence charSequence, @NotNull Function1<? super Character, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (charSequence.length() == 0) {
            return null;
        }
        char charAt = charSequence.charAt(0);
        int y32 = l0.y3(charSequence);
        if (y32 == 0) {
            return Character.valueOf(charAt);
        }
        R invoke = selector.invoke(Character.valueOf(charAt));
        int i6 = 1;
        if (1 <= y32) {
            while (true) {
                char charAt2 = charSequence.charAt(i6);
                R invoke2 = selector.invoke(Character.valueOf(charAt2));
                if (invoke.compareTo(invoke2) > 0) {
                    charAt = charAt2;
                    invoke = invoke2;
                }
                if (i6 == y32) {
                    break;
                }
                i6++;
            }
        }
        return Character.valueOf(charAt);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    @JvmName(name = "sumOfLong")
    @OverloadResolutionByLambdaReturnType
    private static final long u9(CharSequence charSequence, Function1<? super Character, Long> selector) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        long j6 = 0;
        for (int i6 = 0; i6 < charSequence.length(); i6++) {
            j6 += selector.invoke(Character.valueOf(charSequence.charAt(i6))).longValue();
        }
        return j6;
    }

    public static final char v7(@NotNull CharSequence charSequence) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        if (charSequence.length() != 0) {
            return charSequence.charAt(0);
        }
        throw new NoSuchElementException("Char sequence is empty.");
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "minByOrThrow")
    public static final <R extends Comparable<? super R>> char v8(@NotNull CharSequence charSequence, @NotNull Function1<? super Character, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (charSequence.length() == 0) {
            throw new NoSuchElementException();
        }
        char charAt = charSequence.charAt(0);
        int y32 = l0.y3(charSequence);
        if (y32 != 0) {
            R invoke = selector.invoke(Character.valueOf(charAt));
            int i6 = 1;
            if (1 <= y32) {
                while (true) {
                    char charAt2 = charSequence.charAt(i6);
                    R invoke2 = selector.invoke(Character.valueOf(charAt2));
                    if (invoke.compareTo(invoke2) > 0) {
                        charAt = charAt2;
                        invoke = invoke2;
                    }
                    if (i6 == y32) {
                        break;
                    }
                    i6++;
                }
            }
        }
        return charAt;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @JvmName(name = "sumOfUInt")
    private static final int v9(CharSequence charSequence, Function1<? super Character, z0> selector) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        int k6 = z0.k(0);
        for (int i6 = 0; i6 < charSequence.length(); i6++) {
            k6 = z0.k(k6 + selector.invoke(Character.valueOf(charSequence.charAt(i6))).q0());
        }
        return k6;
    }

    public static final char w7(@NotNull CharSequence charSequence, @NotNull Function1<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (int i6 = 0; i6 < charSequence.length(); i6++) {
            char charAt = charSequence.charAt(i6);
            if (predicate.invoke(Character.valueOf(charAt)).booleanValue()) {
                return charAt;
            }
        }
        throw new NoSuchElementException("Char sequence contains no character matching the predicate.");
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final double w8(CharSequence charSequence, Function1<? super Character, Double> selector) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (charSequence.length() == 0) {
            throw new NoSuchElementException();
        }
        double doubleValue = selector.invoke(Character.valueOf(charSequence.charAt(0))).doubleValue();
        int y32 = l0.y3(charSequence);
        int i6 = 1;
        if (1 <= y32) {
            while (true) {
                doubleValue = Math.min(doubleValue, selector.invoke(Character.valueOf(charSequence.charAt(i6))).doubleValue());
                if (i6 == y32) {
                    break;
                }
                i6++;
            }
        }
        return doubleValue;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @JvmName(name = "sumOfULong")
    @OverloadResolutionByLambdaReturnType
    private static final long w9(CharSequence charSequence, Function1<? super Character, d1> selector) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        long k6 = d1.k(0L);
        for (int i6 = 0; i6 < charSequence.length(); i6++) {
            k6 = d1.k(k6 + selector.invoke(Character.valueOf(charSequence.charAt(i6))).q0());
        }
        return k6;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final <R> R x7(CharSequence charSequence, Function1<? super Character, ? extends R> transform) {
        R r5;
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(transform, "transform");
        int i6 = 0;
        while (true) {
            if (i6 >= charSequence.length()) {
                r5 = null;
                break;
            }
            r5 = transform.invoke(Character.valueOf(charSequence.charAt(i6)));
            if (r5 != null) {
                break;
            }
            i6++;
        }
        if (r5 != null) {
            return r5;
        }
        throw new NoSuchElementException("No element of the char sequence was transformed to a non-null value.");
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final float x8(CharSequence charSequence, Function1<? super Character, Float> selector) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (charSequence.length() == 0) {
            throw new NoSuchElementException();
        }
        float floatValue = selector.invoke(Character.valueOf(charSequence.charAt(0))).floatValue();
        int y32 = l0.y3(charSequence);
        int i6 = 1;
        if (1 <= y32) {
            while (true) {
                floatValue = Math.min(floatValue, selector.invoke(Character.valueOf(charSequence.charAt(i6))).floatValue());
                if (i6 == y32) {
                    break;
                }
                i6++;
            }
        }
        return floatValue;
    }

    @NotNull
    public static final CharSequence x9(@NotNull CharSequence charSequence, int i6) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        if (i6 >= 0) {
            return charSequence.subSequence(0, kotlin.ranges.t.B(i6, charSequence.length()));
        }
        throw new IllegalArgumentException(("Requested character count " + i6 + " is less than zero.").toString());
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final <R> R y7(CharSequence charSequence, Function1<? super Character, ? extends R> transform) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(transform, "transform");
        for (int i6 = 0; i6 < charSequence.length(); i6++) {
            R invoke = transform.invoke(Character.valueOf(charSequence.charAt(i6)));
            if (invoke != null) {
                return invoke;
            }
        }
        return null;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <R extends Comparable<? super R>> R y8(CharSequence charSequence, Function1<? super Character, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (charSequence.length() == 0) {
            throw new NoSuchElementException();
        }
        R invoke = selector.invoke(Character.valueOf(charSequence.charAt(0)));
        int y32 = l0.y3(charSequence);
        int i6 = 1;
        if (1 <= y32) {
            while (true) {
                R invoke2 = selector.invoke(Character.valueOf(charSequence.charAt(i6)));
                if (invoke.compareTo(invoke2) > 0) {
                    invoke = invoke2;
                }
                if (i6 == y32) {
                    break;
                }
                i6++;
            }
        }
        return invoke;
    }

    @NotNull
    public static String y9(@NotNull String str, int i6) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        if (i6 >= 0) {
            String substring = str.substring(0, kotlin.ranges.t.B(i6, str.length()));
            kotlin.jvm.internal.g0.o(substring, "substring(...)");
            return substring;
        }
        throw new IllegalArgumentException(("Requested character count " + i6 + " is less than zero.").toString());
    }

    @Nullable
    public static final Character z7(@NotNull CharSequence charSequence) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        if (charSequence.length() == 0) {
            return null;
        }
        return Character.valueOf(charSequence.charAt(0));
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <R extends Comparable<? super R>> R z8(CharSequence charSequence, Function1<? super Character, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (charSequence.length() == 0) {
            return null;
        }
        R invoke = selector.invoke(Character.valueOf(charSequence.charAt(0)));
        int y32 = l0.y3(charSequence);
        int i6 = 1;
        if (1 <= y32) {
            while (true) {
                R invoke2 = selector.invoke(Character.valueOf(charSequence.charAt(i6)));
                if (invoke.compareTo(invoke2) > 0) {
                    invoke = invoke2;
                }
                if (i6 == y32) {
                    break;
                }
                i6++;
            }
        }
        return invoke;
    }

    @NotNull
    public static final CharSequence z9(@NotNull CharSequence charSequence, int i6) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        if (i6 >= 0) {
            int length = charSequence.length();
            return charSequence.subSequence(length - kotlin.ranges.t.B(i6, length), length);
        }
        throw new IllegalArgumentException(("Requested character count " + i6 + " is less than zero.").toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Iterator W9(CharSequence charSequence) {
        return l0.S3(charSequence);
    }
}
