package kotlin.text;

import java.util.Locale;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.PublishedApi;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class c {
    @PublishedApi
    public static int a(int i6) {
        if (2 <= i6 && i6 < 37) {
            return i6;
        }
        throw new IllegalArgumentException("radix " + i6 + " was not in valid range " + new kotlin.ranges.m(2, 36));
    }

    @SinceKotlin(version = "1.5")
    @NotNull
    public static final String B(char c6, @NotNull Locale locale) {
        kotlin.jvm.internal.g0.p(locale, "locale");
        String valueOf = String.valueOf(c6);
        kotlin.jvm.internal.g0.n(valueOf, "null cannot be cast to non-null type java.lang.String");
        String upperCase = valueOf.toUpperCase(locale);
        kotlin.jvm.internal.g0.o(upperCase, "toUpperCase(...)");
        return upperCase;
    }

    @NotNull
    public static final CharCategory c(char c6) {
        return CharCategory.Companion.a(Character.getType(c6));
    }

    @NotNull
    public static final CharDirectionality d(char c6) {
        return CharDirectionality.Companion.b(Character.getDirectionality(c6));
    }

    @SinceKotlin(version = "1.5")
    @NotNull
    public static final String t(char c6, @NotNull Locale locale) {
        kotlin.jvm.internal.g0.p(locale, "locale");
        String valueOf = String.valueOf(c6);
        kotlin.jvm.internal.g0.n(valueOf, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = valueOf.toLowerCase(locale);
        kotlin.jvm.internal.g0.o(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    @SinceKotlin(version = "1.5")
    @NotNull
    public static final String v(char c6, @NotNull Locale locale) {
        kotlin.jvm.internal.g0.p(locale, "locale");
        String B = B(c6, locale);
        if (B.length() <= 1) {
            String valueOf = String.valueOf(c6);
            kotlin.jvm.internal.g0.n(valueOf, "null cannot be cast to non-null type java.lang.String");
            String upperCase = valueOf.toUpperCase(Locale.ROOT);
            kotlin.jvm.internal.g0.o(upperCase, "toUpperCase(...)");
            if (kotlin.jvm.internal.g0.g(B, upperCase)) {
                return String.valueOf(Character.toTitleCase(c6));
            }
        } else if (c6 != 329) {
            char charAt = B.charAt(0);
            kotlin.jvm.internal.g0.n(B, "null cannot be cast to non-null type java.lang.String");
            String substring = B.substring(1);
            kotlin.jvm.internal.g0.o(substring, "substring(...)");
            kotlin.jvm.internal.g0.n(substring, "null cannot be cast to non-null type java.lang.String");
            String lowerCase = substring.toLowerCase(Locale.ROOT);
            kotlin.jvm.internal.g0.o(lowerCase, "toLowerCase(...)");
            return charAt + lowerCase;
        }
        return B;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final String A(char c6) {
        String valueOf = String.valueOf(c6);
        kotlin.jvm.internal.g0.n(valueOf, "null cannot be cast to non-null type java.lang.String");
        String upperCase = valueOf.toUpperCase(Locale.ROOT);
        kotlin.jvm.internal.g0.o(upperCase, "toUpperCase(...)");
        return upperCase;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final char C(char c6) {
        return Character.toUpperCase(c6);
    }

    public static final int b(char c6, int i6) {
        return Character.digit((int) c6, i6);
    }

    @InlineOnly
    private static final boolean e(char c6) {
        return Character.isDefined(c6);
    }

    @InlineOnly
    private static final boolean f(char c6) {
        return Character.isDigit(c6);
    }

    @InlineOnly
    private static final boolean g(char c6) {
        return Character.isHighSurrogate(c6);
    }

    @InlineOnly
    private static final boolean h(char c6) {
        return Character.isISOControl(c6);
    }

    @InlineOnly
    private static final boolean i(char c6) {
        return Character.isIdentifierIgnorable(c6);
    }

    @InlineOnly
    private static final boolean j(char c6) {
        return Character.isJavaIdentifierPart(c6);
    }

    @InlineOnly
    private static final boolean k(char c6) {
        return Character.isJavaIdentifierStart(c6);
    }

    @InlineOnly
    private static final boolean l(char c6) {
        return Character.isLetter(c6);
    }

    @InlineOnly
    private static final boolean m(char c6) {
        return Character.isLetterOrDigit(c6);
    }

    @InlineOnly
    private static final boolean n(char c6) {
        return Character.isLowSurrogate(c6);
    }

    @InlineOnly
    private static final boolean o(char c6) {
        return Character.isLowerCase(c6);
    }

    @InlineOnly
    private static final boolean p(char c6) {
        return Character.isTitleCase(c6);
    }

    @InlineOnly
    private static final boolean q(char c6) {
        return Character.isUpperCase(c6);
    }

    public static boolean r(char c6) {
        if (!Character.isWhitespace(c6) && !Character.isSpaceChar(c6)) {
            return false;
        }
        return true;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final String s(char c6) {
        String valueOf = String.valueOf(c6);
        kotlin.jvm.internal.g0.n(valueOf, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = valueOf.toLowerCase(Locale.ROOT);
        kotlin.jvm.internal.g0.o(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final char u(char c6) {
        return Character.toLowerCase(c6);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final char w(char c6) {
        return Character.toTitleCase(c6);
    }

    @Deprecated(message = "Use lowercaseChar() instead.", replaceWith = @ReplaceWith(expression = "lowercaseChar()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.5")
    @InlineOnly
    private static final char x(char c6) {
        return Character.toLowerCase(c6);
    }

    @Deprecated(message = "Use titlecaseChar() instead.", replaceWith = @ReplaceWith(expression = "titlecaseChar()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.5")
    @InlineOnly
    private static final char y(char c6) {
        return Character.toTitleCase(c6);
    }

    @Deprecated(message = "Use uppercaseChar() instead.", replaceWith = @ReplaceWith(expression = "uppercaseChar()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.5")
    @InlineOnly
    private static final char z(char c6) {
        return Character.toUpperCase(c6);
    }
}
