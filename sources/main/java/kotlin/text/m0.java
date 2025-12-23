package kotlin.text;

import com.daimajia.numberprogressbar.BuildConfig;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Comparator;
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
@SourceDebugExtension({"SMAP\n_StringsJvm.kt\nKotlin\n*S Kotlin\n*F\n+ 1 _StringsJvm.kt\nkotlin/text/StringsKt___StringsJvmKt\n+ 2 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n*L\n1#1,108:1\n1260#2,14:109\n1584#2,14:123\n*S KotlinDebug\n*F\n+ 1 _StringsJvm.kt\nkotlin/text/StringsKt___StringsJvmKt\n*L\n45#1:109,14\n66#1:123,14\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
class m0 extends l0 {
    @NotNull
    public static final SortedSet<Character> A6(@NotNull CharSequence charSequence) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        return (SortedSet) s0.F9(charSequence, new TreeSet());
    }

    @InlineOnly
    private static final char r6(CharSequence charSequence, int i6) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        return charSequence.charAt(i6);
    }

    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = cn.bluemobi.dylan.photoview.a.f1297f, warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Character s6(CharSequence charSequence) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        return s0.q8(charSequence);
    }

    @Deprecated(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = cn.bluemobi.dylan.photoview.a.f1297f, warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ <R extends Comparable<? super R>> Character t6(CharSequence charSequence, Function1<? super Character, ? extends R> selector) {
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

    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = cn.bluemobi.dylan.photoview.a.f1297f, warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Character u6(CharSequence charSequence, Comparator comparator) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        return s0.s8(charSequence, comparator);
    }

    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = cn.bluemobi.dylan.photoview.a.f1297f, warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Character v6(CharSequence charSequence) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        return s0.E8(charSequence);
    }

    @Deprecated(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = cn.bluemobi.dylan.photoview.a.f1297f, warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ <R extends Comparable<? super R>> Character w6(CharSequence charSequence, Function1<? super Character, ? extends R> selector) {
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

    @Deprecated(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = cn.bluemobi.dylan.photoview.a.f1297f, warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Character x6(CharSequence charSequence, Comparator comparator) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        return s0.G8(charSequence, comparator);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    @JvmName(name = "sumOfBigDecimal")
    @OverloadResolutionByLambdaReturnType
    private static final BigDecimal y6(CharSequence charSequence, Function1<? super Character, ? extends BigDecimal> selector) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        BigDecimal valueOf = BigDecimal.valueOf(0L);
        kotlin.jvm.internal.g0.o(valueOf, "valueOf(...)");
        for (int i6 = 0; i6 < charSequence.length(); i6++) {
            valueOf = valueOf.add(selector.invoke(Character.valueOf(charSequence.charAt(i6))));
            kotlin.jvm.internal.g0.o(valueOf, "add(...)");
        }
        return valueOf;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    @JvmName(name = "sumOfBigInteger")
    @OverloadResolutionByLambdaReturnType
    private static final BigInteger z6(CharSequence charSequence, Function1<? super Character, ? extends BigInteger> selector) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        BigInteger valueOf = BigInteger.valueOf(0L);
        kotlin.jvm.internal.g0.o(valueOf, "valueOf(...)");
        for (int i6 = 0; i6 < charSequence.length(); i6++) {
            valueOf = valueOf.add(selector.invoke(Character.valueOf(charSequence.charAt(i6))));
            kotlin.jvm.internal.g0.o(valueOf, "add(...)");
        }
        return valueOf;
    }
}
