package kotlin.text;

import com.daimajia.numberprogressbar.BuildConfig;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nStringNumberConversionsJVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StringNumberConversionsJVM.kt\nkotlin/text/StringsKt__StringNumberConversionsJVMKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,512:1\n267#1,7:513\n267#1,7:520\n267#1,7:527\n267#1,7:534\n1#2:541\n*S KotlinDebug\n*F\n+ 1 StringNumberConversionsJVM.kt\nkotlin/text/StringsKt__StringNumberConversionsJVMKt\n*L\n166#1:513,7\n173#1:520,7\n253#1:527,7\n264#1:534,7\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
class e0 extends d0 {
    @InlineOnly
    private static final int C0(String str, int i6, int i7, boolean z5, Function1<? super Character, Boolean> function1) {
        boolean z6;
        int i8 = i6;
        while (i8 <= i7 && function1.invoke(Character.valueOf(str.charAt(i8))).booleanValue()) {
            i8++;
        }
        boolean z7 = i6 != i8;
        if (i8 > i7) {
            if (z5) {
                return -1;
            }
            return i8;
        }
        if (str.charAt(i8) == '.') {
            int i9 = i8 + 1;
            int i10 = i9;
            while (i10 <= i7 && function1.invoke(Character.valueOf(str.charAt(i10))).booleanValue()) {
                i10++;
            }
            z6 = i9 != i10;
            i8 = i10;
        } else {
            z6 = false;
        }
        if (z7 || z6) {
            return i8;
        }
        if (z5) {
            return -1;
        }
        String str2 = i7 == i8 + 2 ? "NaN" : i7 == i8 + 7 ? "Infinity" : null;
        if (str2 != null && l0.D3(str, str2, i8, false) == i8) {
            return i7 + 1;
        }
        return -1;
    }

    private static final <T> T K0(String str, Function1<? super String, ? extends T> function1) {
        try {
            if (J0(str)) {
                return function1.invoke(str);
            }
        } catch (NumberFormatException unused) {
        }
        return null;
    }

    @InlineOnly
    private static final int D0(String str, int i6, int i7, Function1<? super Character, Boolean> function1) {
        while (i6 <= i7 && function1.invoke(Character.valueOf(str.charAt(i6))).booleanValue()) {
            i6++;
        }
        return i6;
    }

    @InlineOnly
    private static final int E0(char c6) {
        return c6 | ' ';
    }

    @InlineOnly
    private static final int F0(String str, int i6, int i7, Function1<? super Character, Boolean> function1) {
        while (i7 > i6 && function1.invoke(Character.valueOf(str.charAt(i7))).booleanValue()) {
            i7--;
        }
        return i7;
    }

    @InlineOnly
    private static final String G0(int i6, int i7) {
        if (i7 == i6 + 2) {
            return "NaN";
        }
        if (i7 == i6 + 7) {
            return "Infinity";
        }
        return null;
    }

    @InlineOnly
    private static final boolean H0(char c6) {
        return ((c6 + 65488) & 65535) < 10;
    }

    @InlineOnly
    private static final boolean I0(char c6) {
        return (((c6 | ' ') + (-97)) & 65535) < 6;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0138  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final boolean J0(java.lang.String r19) {
        /*
            Method dump skipped, instructions count: 374
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.e0.J0(java.lang.String):boolean");
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigDecimal L0(String str) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        return new BigDecimal(str);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigDecimal M0(String str, MathContext mathContext) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        kotlin.jvm.internal.g0.p(mathContext, "mathContext");
        return new BigDecimal(str, mathContext);
    }

    @SinceKotlin(version = "1.2")
    @Nullable
    public static final BigDecimal N0(@NotNull String str) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        try {
            if (J0(str)) {
                return new BigDecimal(str);
            }
        } catch (NumberFormatException unused) {
        }
        return null;
    }

    @SinceKotlin(version = "1.2")
    @Nullable
    public static final BigDecimal O0(@NotNull String str, @NotNull MathContext mathContext) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        kotlin.jvm.internal.g0.p(mathContext, "mathContext");
        try {
            if (J0(str)) {
                return new BigDecimal(str, mathContext);
            }
        } catch (NumberFormatException unused) {
        }
        return null;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigInteger P0(String str) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        return new BigInteger(str);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigInteger Q0(String str, int i6) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        return new BigInteger(str, c.a(i6));
    }

    @SinceKotlin(version = "1.2")
    @Nullable
    public static final BigInteger R0(@NotNull String str) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        return S0(str, 10);
    }

    @SinceKotlin(version = "1.2")
    @Nullable
    public static final BigInteger S0(@NotNull String str, int i6) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        c.a(i6);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        if (length != 1) {
            for (int i7 = str.charAt(0) == '-' ? 1 : 0; i7 < length; i7++) {
                if (c.b(str.charAt(i7), i6) < 0) {
                    return null;
                }
            }
        } else if (c.b(str.charAt(0), i6) < 0) {
            return null;
        }
        return new BigInteger(str, c.a(i6));
    }

    @InlineOnly
    private static final byte U0(String str) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        return Byte.parseByte(str);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final byte V0(String str, int i6) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        return Byte.parseByte(str, c.a(i6));
    }

    @InlineOnly
    private static final double W0(String str) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        return Double.parseDouble(str);
    }

    @SinceKotlin(version = "1.1")
    @Nullable
    public static final Double X0(@NotNull String str) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        try {
            if (J0(str)) {
                return Double.valueOf(Double.parseDouble(str));
            }
        } catch (NumberFormatException unused) {
        }
        return null;
    }

    @InlineOnly
    private static final float Y0(String str) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        return Float.parseFloat(str);
    }

    @SinceKotlin(version = "1.1")
    @Nullable
    public static final Float Z0(@NotNull String str) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        try {
            if (J0(str)) {
                return Float.valueOf(Float.parseFloat(str));
            }
        } catch (NumberFormatException unused) {
        }
        return null;
    }

    @InlineOnly
    private static final int a1(String str) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        return Integer.parseInt(str);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final int b1(String str, int i6) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        return Integer.parseInt(str, c.a(i6));
    }

    @InlineOnly
    private static final long c1(String str) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        return Long.parseLong(str);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final long d1(String str, int i6) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        return Long.parseLong(str, c.a(i6));
    }

    @InlineOnly
    private static final short e1(String str) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        return Short.parseShort(str);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final short f1(String str, int i6) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        return Short.parseShort(str, c.a(i6));
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final boolean T0(String str) {
        return Boolean.parseBoolean(str);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final String g1(byte b6, int i6) {
        String num = Integer.toString(b6, c.a(i6));
        kotlin.jvm.internal.g0.o(num, "toString(...)");
        return num;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final String h1(int i6, int i7) {
        String num = Integer.toString(i6, c.a(i7));
        kotlin.jvm.internal.g0.o(num, "toString(...)");
        return num;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final String i1(long j6, int i6) {
        String l6 = Long.toString(j6, c.a(i6));
        kotlin.jvm.internal.g0.o(l6, "toString(...)");
        return l6;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final String j1(short s5, int i6) {
        String num = Integer.toString(s5, c.a(i6));
        kotlin.jvm.internal.g0.o(num, "toString(...)");
        return num;
    }
}
