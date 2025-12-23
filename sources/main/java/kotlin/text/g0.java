package kotlin.text;

import com.daimajia.numberprogressbar.BuildConfig;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.internal.LowPriorityInOverloadResolution;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nStringsJVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StringsJVM.kt\nkotlin/text/StringsKt__StringsJVMKt\n+ 2 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,885:1\n1179#2,2:886\n1#3:888\n*S KotlinDebug\n*F\n+ 1 StringsJVM.kt\nkotlin/text/StringsKt__StringsJVMKt\n*L\n73#1:886,2\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public class g0 extends f0 {
    @InlineOnly
    private static final String A1(char[] chars, int i6, int i7) {
        kotlin.jvm.internal.g0.p(chars, "chars");
        return new String(chars, i6, i7);
    }

    public static /* synthetic */ String A2(String str, char c6, char c7, boolean z5, int i6, Object obj) {
        if ((i6 & 4) != 0) {
            z5 = false;
        }
        return y2(str, c6, c7, z5);
    }

    @InlineOnly
    private static final String B1(int[] codePoints, int i6, int i7) {
        kotlin.jvm.internal.g0.p(codePoints, "codePoints");
        return new String(codePoints, i6, i7);
    }

    public static /* synthetic */ String B2(String str, String str2, String str3, boolean z5, int i6, Object obj) {
        if ((i6 & 4) != 0) {
            z5 = false;
        }
        return z2(str, str2, str3, z5);
    }

    @Deprecated(message = "Use replaceFirstChar instead.", replaceWith = @ReplaceWith(expression = "replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }", imports = {"java.util.Locale"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @NotNull
    public static final String C1(@NotNull String str) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        Locale locale = Locale.getDefault();
        kotlin.jvm.internal.g0.o(locale, "getDefault(...)");
        return D1(str, locale);
    }

    @NotNull
    public static final List<String> C2(@NotNull CharSequence charSequence, @NotNull Pattern regex, int i6) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(regex, "regex");
        l0.f5(i6);
        if (i6 == 0) {
            i6 = -1;
        }
        String[] split = regex.split(charSequence, i6);
        kotlin.jvm.internal.g0.o(split, "split(...)");
        return kotlin.collections.n.t(split);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @NotNull
    @Deprecated(message = "Use replaceFirstChar instead.", replaceWith = @ReplaceWith(expression = "replaceFirstChar { if (it.isLowerCase()) it.titlecase(locale) else it.toString() }", imports = {}))
    @LowPriorityInOverloadResolution
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final String D1(@NotNull String str, @NotNull Locale locale) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        kotlin.jvm.internal.g0.p(locale, "locale");
        if (str.length() <= 0) {
            return str;
        }
        char charAt = str.charAt(0);
        if (!Character.isLowerCase(charAt)) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        char titleCase = Character.toTitleCase(charAt);
        if (titleCase != Character.toUpperCase(charAt)) {
            sb.append(titleCase);
        } else {
            String substring = str.substring(0, 1);
            kotlin.jvm.internal.g0.o(substring, "substring(...)");
            kotlin.jvm.internal.g0.n(substring, "null cannot be cast to non-null type java.lang.String");
            String upperCase = substring.toUpperCase(locale);
            kotlin.jvm.internal.g0.o(upperCase, "toUpperCase(...)");
            sb.append(upperCase);
        }
        String substring2 = str.substring(1);
        kotlin.jvm.internal.g0.o(substring2, "substring(...)");
        sb.append(substring2);
        return sb.toString();
    }

    public static /* synthetic */ List D2(CharSequence charSequence, Pattern pattern, int i6, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            i6 = 0;
        }
        return C2(charSequence, pattern, i6);
    }

    @InlineOnly
    private static final int E1(String str, int i6) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        return str.codePointAt(i6);
    }

    public static boolean E2(@NotNull String str, @NotNull String prefix, int i6, boolean z5) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        kotlin.jvm.internal.g0.p(prefix, "prefix");
        return !z5 ? str.startsWith(prefix, i6) : q2(str, i6, prefix, 0, prefix.length(), z5);
    }

    @InlineOnly
    private static final int F1(String str, int i6) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        return str.codePointBefore(i6);
    }

    public static boolean F2(@NotNull String str, @NotNull String prefix, boolean z5) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        kotlin.jvm.internal.g0.p(prefix, "prefix");
        return !z5 ? str.startsWith(prefix) : q2(str, 0, prefix, 0, prefix.length(), z5);
    }

    @InlineOnly
    private static final int G1(String str, int i6, int i7) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        return str.codePointCount(i6, i7);
    }

    public static /* synthetic */ boolean G2(String str, String str2, int i6, boolean z5, int i7, Object obj) {
        if ((i7 & 4) != 0) {
            z5 = false;
        }
        return E2(str, str2, i6, z5);
    }

    public static final int H1(@NotNull String str, @NotNull String other, boolean z5) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        return z5 ? str.compareToIgnoreCase(other) : str.compareTo(other);
    }

    public static /* synthetic */ boolean H2(String str, String str2, boolean z5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            z5 = false;
        }
        return F2(str, str2, z5);
    }

    public static /* synthetic */ int I1(String str, String str2, boolean z5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            z5 = false;
        }
        return H1(str, str2, z5);
    }

    @InlineOnly
    private static final String I2(String str, int i6) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        String substring = str.substring(i6);
        kotlin.jvm.internal.g0.o(substring, "substring(...)");
        return substring;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @NotNull
    public static String J1(@NotNull char[] cArr) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        return new String(cArr);
    }

    @InlineOnly
    private static final String J2(String str, int i6, int i7) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        String substring = str.substring(i6, i7);
        kotlin.jvm.internal.g0.o(substring, "substring(...)");
        return substring;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @NotNull
    public static String K1(@NotNull char[] cArr, int i6, int i7) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.collections.d.Companion.a(i6, i7, cArr.length);
        return new String(cArr, i6, i7 - i6);
    }

    @InlineOnly
    private static final byte[] K2(String str, Charset charset) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        kotlin.jvm.internal.g0.p(charset, "charset");
        byte[] bytes = str.getBytes(charset);
        kotlin.jvm.internal.g0.o(bytes, "getBytes(...)");
        return bytes;
    }

    public static /* synthetic */ String L1(char[] cArr, int i6, int i7, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i6 = 0;
        }
        if ((i8 & 2) != 0) {
            i7 = cArr.length;
        }
        return K1(cArr, i6, i7);
    }

    static /* synthetic */ byte[] L2(String str, Charset charset, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            charset = e.f47851b;
        }
        kotlin.jvm.internal.g0.p(str, "<this>");
        kotlin.jvm.internal.g0.p(charset, "charset");
        byte[] bytes = str.getBytes(charset);
        kotlin.jvm.internal.g0.o(bytes, "getBytes(...)");
        return bytes;
    }

    @SinceKotlin(version = "1.5")
    public static final boolean M1(@Nullable CharSequence charSequence, @Nullable CharSequence charSequence2) {
        return (!(charSequence instanceof String) || charSequence2 == null) ? l0.n3(charSequence, charSequence2) : ((String) charSequence).contentEquals(charSequence2);
    }

    @InlineOnly
    private static final char[] M2(String str) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        char[] charArray = str.toCharArray();
        kotlin.jvm.internal.g0.o(charArray, "toCharArray(...)");
        return charArray;
    }

    @SinceKotlin(version = "1.5")
    public static final boolean N1(@Nullable CharSequence charSequence, @Nullable CharSequence charSequence2, boolean z5) {
        return z5 ? l0.m3(charSequence, charSequence2) : M1(charSequence, charSequence2);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @NotNull
    public static final char[] N2(@NotNull String str, int i6, int i7) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        kotlin.collections.d.Companion.a(i6, i7, str.length());
        char[] cArr = new char[i7 - i6];
        str.getChars(i6, i7, cArr, 0);
        return cArr;
    }

    @InlineOnly
    private static final boolean O1(String str, CharSequence charSequence) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        kotlin.jvm.internal.g0.p(charSequence, "charSequence");
        return str.contentEquals(charSequence);
    }

    @InlineOnly
    private static final char[] O2(String str, char[] destination, int i6, int i7, int i8) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        str.getChars(i7, i8, destination, i6);
        return destination;
    }

    @InlineOnly
    private static final boolean P1(String str, StringBuffer stringBuilder) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        kotlin.jvm.internal.g0.p(stringBuilder, "stringBuilder");
        return str.contentEquals(stringBuilder);
    }

    public static /* synthetic */ char[] P2(String str, int i6, int i7, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i6 = 0;
        }
        if ((i8 & 2) != 0) {
            i7 = str.length();
        }
        return N2(str, i6, i7);
    }

    @Deprecated(message = "Use replaceFirstChar instead.", replaceWith = @ReplaceWith(expression = "replaceFirstChar { it.lowercase(Locale.getDefault()) }", imports = {"java.util.Locale"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @NotNull
    public static final String Q1(@NotNull String str) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        if (str.length() <= 0 || Character.isLowerCase(str.charAt(0))) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        String substring = str.substring(0, 1);
        kotlin.jvm.internal.g0.o(substring, "substring(...)");
        Locale locale = Locale.getDefault();
        kotlin.jvm.internal.g0.o(locale, "getDefault(...)");
        kotlin.jvm.internal.g0.n(substring, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = substring.toLowerCase(locale);
        kotlin.jvm.internal.g0.o(lowerCase, "toLowerCase(...)");
        sb.append(lowerCase);
        String substring2 = str.substring(1);
        kotlin.jvm.internal.g0.o(substring2, "substring(...)");
        sb.append(substring2);
        return sb.toString();
    }

    static /* synthetic */ char[] Q2(String str, char[] destination, int i6, int i7, int i8, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            i6 = 0;
        }
        if ((i9 & 4) != 0) {
            i7 = 0;
        }
        if ((i9 & 8) != 0) {
            i8 = str.length();
        }
        kotlin.jvm.internal.g0.p(str, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        str.getChars(i7, i8, destination, i6);
        return destination;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @NotNull
    @Deprecated(message = "Use replaceFirstChar instead.", replaceWith = @ReplaceWith(expression = "replaceFirstChar { it.lowercase(locale) }", imports = {}))
    @LowPriorityInOverloadResolution
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final String R1(@NotNull String str, @NotNull Locale locale) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        kotlin.jvm.internal.g0.p(locale, "locale");
        if (str.length() <= 0 || Character.isLowerCase(str.charAt(0))) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        String substring = str.substring(0, 1);
        kotlin.jvm.internal.g0.o(substring, "substring(...)");
        kotlin.jvm.internal.g0.n(substring, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = substring.toLowerCase(locale);
        kotlin.jvm.internal.g0.o(lowerCase, "toLowerCase(...)");
        sb.append(lowerCase);
        String substring2 = str.substring(1);
        kotlin.jvm.internal.g0.o(substring2, "substring(...)");
        sb.append(substring2);
        return sb.toString();
    }

    @Deprecated(message = "Use lowercase() instead.", replaceWith = @ReplaceWith(expression = "lowercase(Locale.getDefault())", imports = {"java.util.Locale"}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.5")
    @InlineOnly
    private static final String R2(String str) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        String lowerCase = str.toLowerCase();
        kotlin.jvm.internal.g0.o(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @NotNull
    public static String S1(@NotNull byte[] bArr) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        return new String(bArr, e.f47851b);
    }

    @Deprecated(message = "Use lowercase() instead.", replaceWith = @ReplaceWith(expression = "lowercase(locale)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.5")
    @InlineOnly
    private static final String S2(String str, Locale locale) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        kotlin.jvm.internal.g0.p(locale, "locale");
        String lowerCase = str.toLowerCase(locale);
        kotlin.jvm.internal.g0.o(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @NotNull
    public static final String T1(@NotNull byte[] bArr, int i6, int i7, boolean z5) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.collections.d.Companion.a(i6, i7, bArr.length);
        if (!z5) {
            return new String(bArr, i6, i7 - i6, e.f47851b);
        }
        CharsetDecoder newDecoder = e.f47851b.newDecoder();
        CodingErrorAction codingErrorAction = CodingErrorAction.REPORT;
        String charBuffer = newDecoder.onMalformedInput(codingErrorAction).onUnmappableCharacter(codingErrorAction).decode(ByteBuffer.wrap(bArr, i6, i7 - i6)).toString();
        kotlin.jvm.internal.g0.o(charBuffer, "toString(...)");
        return charBuffer;
    }

    @InlineOnly
    private static final Pattern T2(String str, int i6) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        Pattern compile = Pattern.compile(str, i6);
        kotlin.jvm.internal.g0.o(compile, "compile(...)");
        return compile;
    }

    public static /* synthetic */ String U1(byte[] bArr, int i6, int i7, boolean z5, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i6 = 0;
        }
        if ((i8 & 2) != 0) {
            i7 = bArr.length;
        }
        if ((i8 & 4) != 0) {
            z5 = false;
        }
        return T1(bArr, i6, i7, z5);
    }

    static /* synthetic */ Pattern U2(String str, int i6, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            i6 = 0;
        }
        kotlin.jvm.internal.g0.p(str, "<this>");
        Pattern compile = Pattern.compile(str, i6);
        kotlin.jvm.internal.g0.o(compile, "compile(...)");
        return compile;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @NotNull
    public static byte[] V1(@NotNull String str) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        byte[] bytes = str.getBytes(e.f47851b);
        kotlin.jvm.internal.g0.o(bytes, "getBytes(...)");
        return bytes;
    }

    @Deprecated(message = "Use uppercase() instead.", replaceWith = @ReplaceWith(expression = "uppercase(Locale.getDefault())", imports = {"java.util.Locale"}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.5")
    @InlineOnly
    private static final String V2(String str) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        String upperCase = str.toUpperCase();
        kotlin.jvm.internal.g0.o(upperCase, "toUpperCase(...)");
        return upperCase;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @NotNull
    public static final byte[] W1(@NotNull String str, int i6, int i7, boolean z5) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        kotlin.collections.d.Companion.a(i6, i7, str.length());
        if (!z5) {
            String substring = str.substring(i6, i7);
            kotlin.jvm.internal.g0.o(substring, "substring(...)");
            Charset charset = e.f47851b;
            kotlin.jvm.internal.g0.n(substring, "null cannot be cast to non-null type java.lang.String");
            byte[] bytes = substring.getBytes(charset);
            kotlin.jvm.internal.g0.o(bytes, "getBytes(...)");
            return bytes;
        }
        CharsetEncoder newEncoder = e.f47851b.newEncoder();
        CodingErrorAction codingErrorAction = CodingErrorAction.REPORT;
        ByteBuffer encode = newEncoder.onMalformedInput(codingErrorAction).onUnmappableCharacter(codingErrorAction).encode(CharBuffer.wrap(str, i6, i7));
        if (encode.hasArray() && encode.arrayOffset() == 0) {
            int remaining = encode.remaining();
            byte[] array = encode.array();
            kotlin.jvm.internal.g0.m(array);
            if (remaining == array.length) {
                byte[] array2 = encode.array();
                kotlin.jvm.internal.g0.m(array2);
                return array2;
            }
        }
        byte[] bArr = new byte[encode.remaining()];
        encode.get(bArr);
        return bArr;
    }

    @Deprecated(message = "Use uppercase() instead.", replaceWith = @ReplaceWith(expression = "uppercase(locale)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.5")
    @InlineOnly
    private static final String W2(String str, Locale locale) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        kotlin.jvm.internal.g0.p(locale, "locale");
        String upperCase = str.toUpperCase(locale);
        kotlin.jvm.internal.g0.o(upperCase, "toUpperCase(...)");
        return upperCase;
    }

    public static /* synthetic */ byte[] X1(String str, int i6, int i7, boolean z5, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i6 = 0;
        }
        if ((i8 & 2) != 0) {
            i7 = str.length();
        }
        if ((i8 & 4) != 0) {
            z5 = false;
        }
        return W1(str, i6, i7, z5);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final String X2(String str) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        String upperCase = str.toUpperCase(Locale.ROOT);
        kotlin.jvm.internal.g0.o(upperCase, "toUpperCase(...)");
        return upperCase;
    }

    public static boolean Y1(@NotNull String str, @NotNull String suffix, boolean z5) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        kotlin.jvm.internal.g0.p(suffix, "suffix");
        return !z5 ? str.endsWith(suffix) : q2(str, str.length() - suffix.length(), suffix, 0, suffix.length(), true);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final String Y2(String str, Locale locale) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        kotlin.jvm.internal.g0.p(locale, "locale");
        String upperCase = str.toUpperCase(locale);
        kotlin.jvm.internal.g0.o(upperCase, "toUpperCase(...)");
        return upperCase;
    }

    public static /* synthetic */ boolean Z1(String str, String str2, boolean z5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            z5 = false;
        }
        return Y1(str, str2, z5);
    }

    public static boolean a2(@Nullable String str, @Nullable String str2, boolean z5) {
        return str == null ? str2 == null : !z5 ? str.equals(str2) : str.equalsIgnoreCase(str2);
    }

    public static /* synthetic */ boolean b2(String str, String str2, boolean z5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            z5 = false;
        }
        return a2(str, str2, z5);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final String c2(String str, Locale locale, Object... args) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        kotlin.jvm.internal.g0.p(args, "args");
        String format = String.format(locale, str, Arrays.copyOf(args, args.length));
        kotlin.jvm.internal.g0.o(format, "format(...)");
        return format;
    }

    @InlineOnly
    private static final String d2(String str, Object... args) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        kotlin.jvm.internal.g0.p(args, "args");
        String format = String.format(str, Arrays.copyOf(args, args.length));
        kotlin.jvm.internal.g0.o(format, "format(...)");
        return format;
    }

    @InlineOnly
    private static final String e2(kotlin.jvm.internal.t0 t0Var, String format, Object... args) {
        kotlin.jvm.internal.g0.p(t0Var, "<this>");
        kotlin.jvm.internal.g0.p(format, "format");
        kotlin.jvm.internal.g0.p(args, "args");
        String format2 = String.format(format, Arrays.copyOf(args, args.length));
        kotlin.jvm.internal.g0.o(format2, "format(...)");
        return format2;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final String f2(kotlin.jvm.internal.t0 t0Var, Locale locale, String format, Object... args) {
        kotlin.jvm.internal.g0.p(t0Var, "<this>");
        kotlin.jvm.internal.g0.p(format, "format");
        kotlin.jvm.internal.g0.p(args, "args");
        String format2 = String.format(locale, format, Arrays.copyOf(args, args.length));
        kotlin.jvm.internal.g0.o(format2, "format(...)");
        return format2;
    }

    @NotNull
    public static Comparator<String> g2(@NotNull kotlin.jvm.internal.t0 t0Var) {
        kotlin.jvm.internal.g0.p(t0Var, "<this>");
        Comparator<String> CASE_INSENSITIVE_ORDER = String.CASE_INSENSITIVE_ORDER;
        kotlin.jvm.internal.g0.o(CASE_INSENSITIVE_ORDER, "CASE_INSENSITIVE_ORDER");
        return CASE_INSENSITIVE_ORDER;
    }

    @InlineOnly
    private static final String h2(String str) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        String intern = str.intern();
        kotlin.jvm.internal.g0.o(intern, "intern(...)");
        return intern;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final String i2(String str) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        String lowerCase = str.toLowerCase(Locale.ROOT);
        kotlin.jvm.internal.g0.o(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final String j2(String str, Locale locale) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        kotlin.jvm.internal.g0.p(locale, "locale");
        String lowerCase = str.toLowerCase(locale);
        kotlin.jvm.internal.g0.o(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    @InlineOnly
    private static final int k2(String str, char c6, int i6) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        return str.indexOf(c6, i6);
    }

    @InlineOnly
    private static final int l2(String str, String str2, int i6) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        kotlin.jvm.internal.g0.p(str2, "str");
        return str.indexOf(str2, i6);
    }

    @InlineOnly
    private static final int m2(String str, char c6, int i6) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        return str.lastIndexOf(c6, i6);
    }

    @InlineOnly
    private static final int n2(String str, String str2, int i6) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        kotlin.jvm.internal.g0.p(str2, "str");
        return str.lastIndexOf(str2, i6);
    }

    @InlineOnly
    private static final int o2(String str, int i6, int i7) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        return str.offsetByCodePoints(i6, i7);
    }

    public static final boolean p2(@NotNull CharSequence charSequence, int i6, @NotNull CharSequence other, int i7, int i8, boolean z5) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        return ((charSequence instanceof String) && (other instanceof String)) ? q2((String) charSequence, i6, (String) other, i7, i8, z5) : l0.t4(charSequence, i6, other, i7, i8, z5);
    }

    public static boolean q2(@NotNull String str, int i6, @NotNull String other, int i7, int i8, boolean z5) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        return !z5 ? str.regionMatches(i6, other, i7, i8) : str.regionMatches(z5, i6, other, i7, i8);
    }

    @InlineOnly
    private static final String t1(StringBuffer stringBuffer) {
        kotlin.jvm.internal.g0.p(stringBuffer, "stringBuffer");
        return new String(stringBuffer);
    }

    @NotNull
    public static String t2(@NotNull CharSequence charSequence, int i6) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        if (i6 < 0) {
            throw new IllegalArgumentException(("Count 'n' must be non-negative, but was " + i6 + '.').toString());
        }
        if (i6 == 0) {
            return "";
        }
        int i7 = 1;
        if (i6 == 1) {
            return charSequence.toString();
        }
        int length = charSequence.length();
        if (length == 0) {
            return "";
        }
        if (length == 1) {
            char charAt = charSequence.charAt(0);
            char[] cArr = new char[i6];
            for (int i8 = 0; i8 < i6; i8++) {
                cArr[i8] = charAt;
            }
            return new String(cArr);
        }
        StringBuilder sb = new StringBuilder(charSequence.length() * i6);
        if (1 <= i6) {
            while (true) {
                sb.append(charSequence);
                if (i7 == i6) {
                    break;
                }
                i7++;
            }
        }
        String sb2 = sb.toString();
        kotlin.jvm.internal.g0.m(sb2);
        return sb2;
    }

    @InlineOnly
    private static final String u1(StringBuilder stringBuilder) {
        kotlin.jvm.internal.g0.p(stringBuilder, "stringBuilder");
        return new String(stringBuilder);
    }

    @NotNull
    public static final String u2(@NotNull String str, char c6, char c7, boolean z5) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        if (!z5) {
            String replace = str.replace(c6, c7);
            kotlin.jvm.internal.g0.o(replace, "replace(...)");
            return replace;
        }
        StringBuilder sb = new StringBuilder(str.length());
        for (int i6 = 0; i6 < str.length(); i6++) {
            char charAt = str.charAt(i6);
            if (d.J(charAt, c6, z5)) {
                charAt = c7;
            }
            sb.append(charAt);
        }
        return sb.toString();
    }

    @InlineOnly
    private static final String v1(byte[] bytes) {
        kotlin.jvm.internal.g0.p(bytes, "bytes");
        return new String(bytes, e.f47851b);
    }

    @NotNull
    public static final String v2(@NotNull String str, @NotNull String oldValue, @NotNull String newValue, boolean z5) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        kotlin.jvm.internal.g0.p(oldValue, "oldValue");
        kotlin.jvm.internal.g0.p(newValue, "newValue");
        int i6 = 0;
        int D3 = l0.D3(str, oldValue, 0, z5);
        if (D3 < 0) {
            return str;
        }
        int length = oldValue.length();
        int u5 = kotlin.ranges.t.u(length, 1);
        int length2 = (str.length() - length) + newValue.length();
        if (length2 < 0) {
            throw new OutOfMemoryError();
        }
        StringBuilder sb = new StringBuilder(length2);
        do {
            sb.append((CharSequence) str, i6, D3);
            sb.append(newValue);
            i6 = D3 + length;
            if (D3 >= str.length()) {
                break;
            }
            D3 = l0.D3(str, oldValue, D3 + u5, z5);
        } while (D3 > 0);
        sb.append((CharSequence) str, i6, str.length());
        String sb2 = sb.toString();
        kotlin.jvm.internal.g0.o(sb2, "toString(...)");
        return sb2;
    }

    @InlineOnly
    private static final String w1(byte[] bytes, int i6, int i7) {
        kotlin.jvm.internal.g0.p(bytes, "bytes");
        return new String(bytes, i6, i7, e.f47851b);
    }

    public static /* synthetic */ String w2(String str, char c6, char c7, boolean z5, int i6, Object obj) {
        if ((i6 & 4) != 0) {
            z5 = false;
        }
        return u2(str, c6, c7, z5);
    }

    @InlineOnly
    private static final String x1(byte[] bytes, int i6, int i7, Charset charset) {
        kotlin.jvm.internal.g0.p(bytes, "bytes");
        kotlin.jvm.internal.g0.p(charset, "charset");
        return new String(bytes, i6, i7, charset);
    }

    public static /* synthetic */ String x2(String str, String str2, String str3, boolean z5, int i6, Object obj) {
        if ((i6 & 4) != 0) {
            z5 = false;
        }
        return v2(str, str2, str3, z5);
    }

    @InlineOnly
    private static final String y1(byte[] bytes, Charset charset) {
        kotlin.jvm.internal.g0.p(bytes, "bytes");
        kotlin.jvm.internal.g0.p(charset, "charset");
        return new String(bytes, charset);
    }

    @NotNull
    public static final String y2(@NotNull String str, char c6, char c7, boolean z5) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        int G3 = l0.G3(str, c6, 0, z5, 2, null);
        return G3 < 0 ? str : l0.b5(str, G3, G3 + 1, String.valueOf(c7)).toString();
    }

    @InlineOnly
    private static final String z1(char[] chars) {
        kotlin.jvm.internal.g0.p(chars, "chars");
        return new String(chars);
    }

    @NotNull
    public static final String z2(@NotNull String str, @NotNull String oldValue, @NotNull String newValue, boolean z5) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        kotlin.jvm.internal.g0.p(oldValue, "oldValue");
        kotlin.jvm.internal.g0.p(newValue, "newValue");
        int H3 = l0.H3(str, oldValue, 0, z5, 2, null);
        return H3 < 0 ? str : l0.b5(str, H3, oldValue.length() + H3, newValue).toString();
    }
}
