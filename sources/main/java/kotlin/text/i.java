package kotlin.text;

import kotlin.ExperimentalStdlibApi;
import kotlin.KotlinNothingValueException;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.d1;
import kotlin.j1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.j;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nHexExtensions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HexExtensions.kt\nkotlin/text/HexExtensionsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n*L\n1#1,1237:1\n1186#1,7:1239\n1186#1,7:1246\n1186#1,7:1253\n1186#1,7:1260\n1186#1,7:1267\n1186#1,7:1274\n1186#1,7:1281\n1186#1,7:1288\n1197#1,5:1295\n1197#1,5:1300\n1186#1,7:1305\n1186#1,7:1312\n1197#1,5:1319\n1206#1,5:1324\n1#2:1238\n1188#3,3:1329\n1188#3,3:1332\n1188#3,3:1335\n1188#3,3:1338\n*S KotlinDebug\n*F\n+ 1 HexExtensions.kt\nkotlin/text/HexExtensionsKt\n*L\n450#1:1239,7\n482#1:1246,7\n486#1:1253,7\n489#1:1260,7\n529#1:1267,7\n532#1:1274,7\n537#1:1281,7\n542#1:1288,7\n549#1:1295,5\n550#1:1300,5\n1141#1:1305,7\n1143#1:1312,7\n1171#1:1319,5\n1179#1:1324,5\n42#1:1329,3\n43#1:1332,3\n54#1:1335,3\n55#1:1338,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final String f47871a = "0123456789abcdef";

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final String f47872b = "0123456789ABCDEF";

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final int[] f47873c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final int[] f47874d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final int[] f47875e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final long[] f47876f;

    private static final short J(String str, int i6, int i7, j jVar) {
        return (short) D(str, i6, i7, jVar, 4);
    }

    private static final int P(String str, int i6, int i7) {
        int i8;
        int i9 = 0;
        while (i6 < i7) {
            int i10 = i9 << 4;
            char charAt = str.charAt(i6);
            if ((charAt >>> '\b') != 0 || (i8 = f47875e[charAt]) < 0) {
                S(str, i6);
                throw new KotlinNothingValueException();
            }
            i9 = i10 | i8;
            i6++;
        }
        return i9;
    }

    private static final byte n(String str, int i6, int i7, j jVar) {
        return (byte) D(str, i6, i7, jVar, 2);
    }

    static {
        int[] iArr = new int[256];
        int i6 = 0;
        for (int i7 = 0; i7 < 256; i7++) {
            iArr[i7] = f47871a.charAt(i7 & 15) | (f47871a.charAt(i7 >> 4) << '\b');
        }
        f47873c = iArr;
        int[] iArr2 = new int[256];
        for (int i8 = 0; i8 < 256; i8++) {
            iArr2[i8] = f47872b.charAt(i8 & 15) | (f47872b.charAt(i8 >> 4) << '\b');
        }
        f47874d = iArr2;
        int[] iArr3 = new int[256];
        for (int i9 = 0; i9 < 256; i9++) {
            iArr3[i9] = -1;
        }
        int i10 = 0;
        int i11 = 0;
        while (i10 < f47871a.length()) {
            iArr3[f47871a.charAt(i10)] = i11;
            i10++;
            i11++;
        }
        int i12 = 0;
        int i13 = 0;
        while (i12 < f47872b.length()) {
            iArr3[f47872b.charAt(i12)] = i13;
            i12++;
            i13++;
        }
        f47875e = iArr3;
        long[] jArr = new long[256];
        for (int i14 = 0; i14 < 256; i14++) {
            jArr[i14] = -1;
        }
        int i15 = 0;
        int i16 = 0;
        while (i15 < f47871a.length()) {
            jArr[f47871a.charAt(i15)] = i16;
            i15++;
            i16++;
        }
        int i17 = 0;
        while (i6 < f47872b.length()) {
            jArr[f47872b.charAt(i6)] = i17;
            i6++;
            i17++;
        }
        f47876f = jArr;
    }

    @SinceKotlin(version = "2.2")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final int A(@NotNull String str, @NotNull j format) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        kotlin.jvm.internal.g0.p(format, "format");
        return z(str, 0, str.length(), format);
    }

    public static /* synthetic */ int B(String str, int i6, int i7, j jVar, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i6 = 0;
        }
        if ((i8 & 2) != 0) {
            i7 = str.length();
        }
        if ((i8 & 4) != 0) {
            jVar = j.f47879d.a();
        }
        return z(str, i6, i7, jVar);
    }

    public static /* synthetic */ int C(String str, j jVar, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            jVar = j.f47879d.a();
        }
        return A(str, jVar);
    }

    private static final int D(String str, int i6, int i7, j jVar, int i8) {
        kotlin.collections.d.Companion.a(i6, i7, str.length());
        j.d d6 = jVar.d();
        if (d6.i()) {
            e(str, i6, i7, i8);
            return P(str, i6, i7);
        }
        String f6 = d6.f();
        String h6 = d6.h();
        f(str, i6, i7, f6, h6, d6.c(), i8);
        return P(str, i6 + f6.length(), i7 - h6.length());
    }

    public static final long E(@NotNull String str, int i6, int i7, @NotNull j format) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        kotlin.jvm.internal.g0.p(format, "format");
        return I(str, i6, i7, format, 16);
    }

    @SinceKotlin(version = "2.2")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final long F(@NotNull String str, @NotNull j format) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        kotlin.jvm.internal.g0.p(format, "format");
        return E(str, 0, str.length(), format);
    }

    public static /* synthetic */ long G(String str, int i6, int i7, j jVar, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i6 = 0;
        }
        if ((i8 & 2) != 0) {
            i7 = str.length();
        }
        if ((i8 & 4) != 0) {
            jVar = j.f47879d.a();
        }
        return E(str, i6, i7, jVar);
    }

    public static /* synthetic */ long H(String str, j jVar, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            jVar = j.f47879d.a();
        }
        return F(str, jVar);
    }

    private static final long I(String str, int i6, int i7, j jVar, int i8) {
        kotlin.collections.d.Companion.a(i6, i7, str.length());
        j.d d6 = jVar.d();
        if (d6.i()) {
            e(str, i6, i7, i8);
            return Q(str, i6, i7);
        }
        String f6 = d6.f();
        String h6 = d6.h();
        f(str, i6, i7, f6, h6, d6.c(), i8);
        return Q(str, i6 + f6.length(), i7 - h6.length());
    }

    @SinceKotlin(version = "2.2")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final short K(@NotNull String str, @NotNull j format) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        kotlin.jvm.internal.g0.p(format, "format");
        return J(str, 0, str.length(), format);
    }

    static /* synthetic */ short L(String str, int i6, int i7, j jVar, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i6 = 0;
        }
        if ((i8 & 2) != 0) {
            i7 = str.length();
        }
        if ((i8 & 4) != 0) {
            jVar = j.f47879d.a();
        }
        return J(str, i6, i7, jVar);
    }

    public static /* synthetic */ short M(String str, j jVar, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            jVar = j.f47879d.a();
        }
        return K(str, jVar);
    }

    private static final long Q(String str, int i6, int i7) {
        long j6 = 0;
        while (i6 < i7) {
            long j7 = j6 << 4;
            char charAt = str.charAt(i6);
            if ((charAt >>> '\b') == 0) {
                long j8 = f47876f[charAt];
                if (j8 >= 0) {
                    j6 = j7 | j8;
                    i6++;
                }
            }
            S(str, i6);
            throw new KotlinNothingValueException();
        }
        return j6;
    }

    public static final int R(int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
        long a6;
        if (i6 <= 0) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        long j6 = i11 + 2 + i12;
        long a7 = a(j6, i8, i10);
        if (i7 <= i8) {
            a6 = a(j6, i7, i10);
        } else {
            a6 = a(a7, i7 / i8, i9);
            int i13 = i7 % i8;
            if (i13 != 0) {
                a6 = a6 + i9 + a(j6, i13, i10);
            }
        }
        long j7 = i6;
        long o02 = o0(j7, a6, 1);
        long j8 = j7 - ((a6 + 1) * o02);
        long o03 = o0(j8, a7, i9);
        long j9 = j8 - ((a7 + i9) * o03);
        long o04 = o0(j9, j6, i10);
        return (int) ((o02 * i7) + (o03 * i8) + o04 + (j9 - ((j6 + ((long) i10)) * o04) > 0 ? 1 : 0));
    }

    private static final Void S(String str, int i6) {
        throw new NumberFormatException("Expected a hexadecimal digit at index " + i6 + ", but was " + str.charAt(i6));
    }

    private static final void T(String str, int i6, int i7, String str2, int i8) {
        kotlin.jvm.internal.g0.n(str, "null cannot be cast to non-null type java.lang.String");
        String substring = str.substring(i6, i7);
        kotlin.jvm.internal.g0.o(substring, "substring(...)");
        throw new NumberFormatException("Expected " + str2 + ' ' + i8 + " hexadecimal digits at index " + i6 + ", but was \"" + substring + "\" of length " + (i7 - i6));
    }

    private static final void U(String str, int i6, int i7, String str2, String str3) {
        kotlin.jvm.internal.g0.n(str, "null cannot be cast to non-null type java.lang.String");
        String substring = str.substring(i6, i7);
        kotlin.jvm.internal.g0.o(substring, "substring(...)");
        throw new NumberFormatException("Expected a hexadecimal number with prefix \"" + str2 + "\" and suffix \"" + str3 + "\", but was " + substring);
    }

    @SinceKotlin(version = "2.2")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @NotNull
    public static final String X(byte b6, @NotNull j format) {
        kotlin.jvm.internal.g0.p(format, "format");
        String str = format.e() ? f47872b : f47871a;
        j.d d6 = format.d();
        if (!d6.j()) {
            return j0(b6, d6, str, 8);
        }
        char[] cArr = {str.charAt((b6 >> 4) & 15), str.charAt(b6 & 15)};
        return d6.g() ? g0.L1(cArr, kotlin.ranges.t.B((Integer.numberOfLeadingZeros(b6 & 255) - 24) >> 2, 1), 0, 2, null) : g0.J1(cArr);
    }

    @SinceKotlin(version = "2.2")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @NotNull
    public static final String Y(int i6, @NotNull j format) {
        kotlin.jvm.internal.g0.p(format, "format");
        String str = format.e() ? f47872b : f47871a;
        j.d d6 = format.d();
        if (!d6.j()) {
            return j0(i6, d6, str, 32);
        }
        char[] cArr = {str.charAt((i6 >> 28) & 15), str.charAt((i6 >> 24) & 15), str.charAt((i6 >> 20) & 15), str.charAt((i6 >> 16) & 15), str.charAt((i6 >> 12) & 15), str.charAt((i6 >> 8) & 15), str.charAt((i6 >> 4) & 15), str.charAt(i6 & 15)};
        return d6.g() ? g0.L1(cArr, kotlin.ranges.t.B(Integer.numberOfLeadingZeros(i6) >> 2, 7), 0, 2, null) : g0.J1(cArr);
    }

    @SinceKotlin(version = "2.2")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @NotNull
    public static final String Z(long j6, @NotNull j format) {
        kotlin.jvm.internal.g0.p(format, "format");
        String str = format.e() ? f47872b : f47871a;
        j.d d6 = format.d();
        if (!d6.j()) {
            return j0(j6, d6, str, 64);
        }
        char[] cArr = {str.charAt((int) ((j6 >> 60) & 15)), str.charAt((int) ((j6 >> 56) & 15)), str.charAt((int) ((j6 >> 52) & 15)), str.charAt((int) ((j6 >> 48) & 15)), str.charAt((int) ((j6 >> 44) & 15)), str.charAt((int) ((j6 >> 40) & 15)), str.charAt((int) ((j6 >> 36) & 15)), str.charAt((int) ((j6 >> 32) & 15)), str.charAt((int) ((j6 >> 28) & 15)), str.charAt((int) ((j6 >> 24) & 15)), str.charAt((int) ((j6 >> 20) & 15)), str.charAt((int) ((j6 >> 16) & 15)), str.charAt((int) ((j6 >> 12) & 15)), str.charAt((int) ((j6 >> 8) & 15)), str.charAt((int) ((j6 >> 4) & 15)), str.charAt((int) (j6 & 15))};
        return d6.g() ? g0.L1(cArr, kotlin.ranges.t.B(Long.numberOfLeadingZeros(j6) >> 2, 15), 0, 2, null) : g0.J1(cArr);
    }

    private static final long a(long j6, int i6, int i7) {
        if (i6 <= 0) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        long j7 = i6;
        return (j6 * j7) + (i7 * (j7 - 1));
    }

    @SinceKotlin(version = "2.2")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @NotNull
    public static final String a0(short s5, @NotNull j format) {
        kotlin.jvm.internal.g0.p(format, "format");
        String str = format.e() ? f47872b : f47871a;
        j.d d6 = format.d();
        if (!d6.j()) {
            return j0(s5, d6, str, 16);
        }
        char[] cArr = {str.charAt((s5 >> 12) & 15), str.charAt((s5 >> 8) & 15), str.charAt((s5 >> 4) & 15), str.charAt(s5 & 15)};
        return d6.g() ? g0.L1(cArr, kotlin.ranges.t.B((Integer.numberOfLeadingZeros(s5 & j1.f43986d) - 16) >> 2, 3), 0, 2, null) : g0.J1(cArr);
    }

    @SinceKotlin(version = "2.2")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @NotNull
    public static final String b0(@NotNull byte[] bArr, int i6, int i7, @NotNull j format) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(format, "format");
        kotlin.collections.d.Companion.a(i6, i7, bArr.length);
        if (i6 == i7) {
            return "";
        }
        int[] iArr = format.e() ? f47874d : f47873c;
        j.b c6 = format.c();
        return c6.j() ? k0(bArr, i6, i7, c6, iArr) : n0(bArr, i6, i7, c6, iArr);
    }

    private static final int c(long j6) {
        if (0 <= j6 && j6 <= 2147483647L) {
            return (int) j6;
        }
        throw new IllegalArgumentException("The resulting string length is too big: " + ((Object) d1.l0(d1.k(j6))));
    }

    @SinceKotlin(version = "2.2")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @NotNull
    public static final String c0(@NotNull byte[] bArr, @NotNull j format) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(format, "format");
        return b0(bArr, 0, bArr.length, format);
    }

    public static /* synthetic */ String d0(byte b6, j jVar, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            jVar = j.f47879d.a();
        }
        return X(b6, jVar);
    }

    private static final void e(String str, int i6, int i7, int i8) {
        int i9 = i7 - i6;
        if (i9 < 1) {
            T(str, i6, i7, "at least", 1);
        } else if (i9 > i8) {
            g(str, i6, (i9 + i6) - i8);
        }
    }

    public static /* synthetic */ String e0(int i6, j jVar, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            jVar = j.f47879d.a();
        }
        return Y(i6, jVar);
    }

    private static final void f(String str, int i6, int i7, String str2, String str3, boolean z5, int i8) {
        if ((i7 - i6) - str2.length() <= str3.length()) {
            U(str, i6, i7, str2, str3);
        }
        if (str2.length() != 0) {
            int length = str2.length();
            for (int i9 = 0; i9 < length; i9++) {
                if (!d.J(str2.charAt(i9), str.charAt(i6 + i9), z5)) {
                    V(str, i6, i7, str2, "prefix");
                }
            }
            i6 += str2.length();
        }
        int length2 = i7 - str3.length();
        if (str3.length() != 0) {
            int length3 = str3.length();
            for (int i10 = 0; i10 < length3; i10++) {
                if (!d.J(str3.charAt(i10), str.charAt(length2 + i10), z5)) {
                    V(str, length2, i7, str3, "suffix");
                }
            }
        }
        e(str, i6, length2, i8);
    }

    public static /* synthetic */ String f0(long j6, j jVar, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            jVar = j.f47879d.a();
        }
        return Z(j6, jVar);
    }

    private static final void g(String str, int i6, int i7) {
        while (i6 < i7) {
            if (str.charAt(i6) != '0') {
                throw new NumberFormatException("Expected the hexadecimal digit '0' at index " + i6 + ", but was '" + str.charAt(i6) + "'.\nThe result won't fit the type being parsed.");
            }
            i6++;
        }
    }

    public static /* synthetic */ String g0(short s5, j jVar, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            jVar = j.f47879d.a();
        }
        return a0(s5, jVar);
    }

    public static /* synthetic */ String h0(byte[] bArr, int i6, int i7, j jVar, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i6 = 0;
        }
        if ((i8 & 2) != 0) {
            i7 = bArr.length;
        }
        if ((i8 & 4) != 0) {
            jVar = j.f47879d.a();
        }
        return b0(bArr, i6, i7, jVar);
    }

    public static /* synthetic */ String i0(byte[] bArr, j jVar, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            jVar = j.f47879d.a();
        }
        return c0(bArr, jVar);
    }

    private static final int j(byte[] bArr, int i6, int[] iArr, char[] cArr, int i7) {
        int i8 = iArr[bArr[i6] & 255];
        cArr[i7] = (char) (i8 >> 8);
        cArr[i7 + 1] = (char) (i8 & 255);
        return i7 + 2;
    }

    private static final String j0(long j6, j.d dVar, String str, int i6) {
        if ((i6 & 3) != 0) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        int i7 = i6 >> 2;
        int d6 = dVar.d();
        int u5 = kotlin.ranges.t.u(d6 - i7, 0);
        String f6 = dVar.f();
        String h6 = dVar.h();
        boolean g6 = dVar.g();
        int c6 = c(f6.length() + u5 + i7 + h6.length());
        char[] cArr = new char[c6];
        int W = W(f6, cArr, 0);
        if (u5 > 0) {
            int i8 = u5 + W;
            kotlin.collections.n.H1(cArr, str.charAt(0), W, i8);
            W = i8;
        }
        int i9 = i6;
        for (int i10 = 0; i10 < i7; i10++) {
            i9 -= 4;
            int i11 = (int) ((j6 >> i9) & 15);
            g6 = g6 && i11 == 0 && (i9 >> 2) >= d6;
            if (!g6) {
                cArr[W] = str.charAt(i11);
                W++;
            }
        }
        int W2 = W(h6, cArr, W);
        return W2 == c6 ? g0.J1(cArr) : g0.L1(cArr, 0, W2, 1, null);
    }

    private static final int k(int i6, int i7, int i8, int i9) {
        if (i6 <= 0) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        long j6 = i7;
        return c((i6 * (((i8 + 2) + i9) + j6)) - j6);
    }

    public static final int l(int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
        if (i6 <= 0) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        int i13 = (i6 - 1) / i7;
        int i14 = (i7 - 1) / i8;
        int i15 = i6 % i7;
        if (i15 != 0) {
            i7 = i15;
        }
        return c(i13 + (((i14 * i13) + ((i7 - 1) / i8)) * i9) + (((r0 - i13) - r2) * i10) + (i6 * (i11 + 2 + i12)));
    }

    @NotNull
    public static final int[] m() {
        return f47873c;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0057 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final java.lang.String n0(byte[] r17, int r18, int r19, kotlin.text.j.b r20, int[] r21) {
        /*
            r0 = r19
            int r2 = r20.g()
            int r3 = r20.f()
            java.lang.String r8 = r20.c()
            java.lang.String r9 = r20.e()
            java.lang.String r11 = r20.d()
            java.lang.String r12 = r20.h()
            int r1 = r0 - r18
            int r4 = r12.length()
            int r5 = r11.length()
            int r6 = r8.length()
            int r7 = r9.length()
            int r1 = l(r1, r2, r3, r4, r5, r6, r7)
            r7 = r9
            char[] r9 = new char[r1]
            r13 = 0
            r5 = r18
            r4 = 0
            r6 = 0
            r10 = 0
        L39:
            if (r5 >= r0) goto L72
            if (r6 != r2) goto L47
            int r6 = r4 + 1
            r10 = 10
            r9[r4] = r10
            r4 = r6
            r14 = 0
        L45:
            r15 = 0
            goto L51
        L47:
            if (r10 != r3) goto L4f
            int r4 = W(r12, r9, r4)
            r14 = r6
            goto L45
        L4f:
            r14 = r6
            r15 = r10
        L51:
            if (r15 == 0) goto L57
            int r4 = W(r11, r9, r4)
        L57:
            r10 = r4
            r6 = r8
            r4 = r17
            r8 = r21
            int r10 = i(r4, r5, r6, r7, r8, r9, r10)
            int r4 = r15 + 1
            int r8 = r14 + 1
            int r5 = r5 + 1
            r16 = r10
            r10 = r4
            r4 = r16
            r16 = r8
            r8 = r6
            r6 = r16
            goto L39
        L72:
            if (r4 != r1) goto L79
            java.lang.String r0 = kotlin.text.g0.J1(r9)
            return r0
        L79:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Check failed."
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.i.n0(byte[], int, int, kotlin.text.j$b, int[]):java.lang.String");
    }

    @SinceKotlin(version = "2.2")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final byte o(@NotNull String str, @NotNull j format) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        kotlin.jvm.internal.g0.p(format, "format");
        return n(str, 0, str.length(), format);
    }

    private static final long o0(long j6, long j7, int i6) {
        if (j6 <= 0 || j7 <= 0) {
            return 0L;
        }
        long j8 = i6;
        return (j6 + j8) / (j7 + j8);
    }

    static /* synthetic */ byte p(String str, int i6, int i7, j jVar, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i6 = 0;
        }
        if ((i8 & 2) != 0) {
            i7 = str.length();
        }
        if ((i8 & 4) != 0) {
            jVar = j.f47879d.a();
        }
        return n(str, i6, i7, jVar);
    }

    public static /* synthetic */ byte q(String str, j jVar, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            jVar = j.f47879d.a();
        }
        return o(str, jVar);
    }

    private static final byte[] r(String str, int i6, int i7, j jVar) {
        byte[] v5;
        kotlin.collections.d.Companion.a(i6, i7, str.length());
        if (i6 == i7) {
            return new byte[0];
        }
        j.b c6 = jVar.c();
        return (!c6.j() || (v5 = v(str, i6, i7, c6)) == null) ? y(str, i6, i7, c6) : v5;
    }

    @SinceKotlin(version = "2.2")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @NotNull
    public static final byte[] s(@NotNull String str, @NotNull j format) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        kotlin.jvm.internal.g0.p(format, "format");
        return r(str, 0, str.length(), format);
    }

    static /* synthetic */ byte[] t(String str, int i6, int i7, j jVar, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i6 = 0;
        }
        if ((i8 & 2) != 0) {
            i7 = str.length();
        }
        if ((i8 & 4) != 0) {
            jVar = j.f47879d.a();
        }
        return r(str, i6, i7, jVar);
    }

    public static /* synthetic */ byte[] u(String str, j jVar, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            jVar = j.f47879d.a();
        }
        return s(str, jVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x00cb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final byte[] y(java.lang.String r18, int r19, int r20, kotlin.text.j.b r21) {
        /*
            Method dump skipped, instructions count: 335
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.i.y(java.lang.String, int, int, kotlin.text.j$b):byte[]");
    }

    public static final int z(@NotNull String str, int i6, int i7, @NotNull j format) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        kotlin.jvm.internal.g0.p(format, "format");
        return D(str, i6, i7, format, 8);
    }

    private static final long N(String str, int i6) {
        char charAt = str.charAt(i6);
        if ((charAt >>> '\b') == 0) {
            long j6 = f47876f[charAt];
            if (j6 >= 0) {
                return j6;
            }
        }
        S(str, i6);
        throw new KotlinNothingValueException();
    }

    private static final byte O(String str, int i6) {
        int[] iArr;
        int i7;
        int i8;
        char charAt = str.charAt(i6);
        if ((charAt >>> '\b') == 0 && (i7 = (iArr = f47875e)[charAt]) >= 0) {
            int i9 = i6 + 1;
            char charAt2 = str.charAt(i9);
            if ((charAt2 >>> '\b') == 0 && (i8 = iArr[charAt2]) >= 0) {
                return (byte) ((i7 << 4) | i8);
            }
            S(str, i9);
            throw new KotlinNothingValueException();
        }
        S(str, i6);
        throw new KotlinNothingValueException();
    }

    private static final void V(String str, int i6, int i7, String str2, String str3) {
        int B = kotlin.ranges.t.B(str2.length() + i6, i7);
        kotlin.jvm.internal.g0.n(str, "null cannot be cast to non-null type java.lang.String");
        String substring = str.substring(i6, B);
        kotlin.jvm.internal.g0.o(substring, "substring(...)");
        throw new NumberFormatException("Expected " + str3 + " \"" + str2 + "\" at index " + i6 + ", but was " + substring);
    }

    private static final int W(String str, char[] cArr, int i6) {
        int length = str.length();
        if (length != 0) {
            if (length != 1) {
                int length2 = str.length();
                kotlin.jvm.internal.g0.n(str, "null cannot be cast to non-null type java.lang.String");
                str.getChars(0, length2, cArr, i6);
            } else {
                cArr[i6] = str.charAt(0);
            }
        }
        return i6 + str.length();
    }

    private static final int b(String str, int i6, int i7, String str2, boolean z5, String str3) {
        if (str2.length() == 0) {
            return i6;
        }
        int length = str2.length();
        for (int i8 = 0; i8 < length; i8++) {
            if (!d.J(str2.charAt(i8), str.charAt(i6 + i8), z5)) {
                V(str, i6, i7, str2, str3);
            }
        }
        return i6 + str2.length();
    }

    private static final int d(String str, int i6, int i7) {
        if (str.charAt(i6) == '\r') {
            int i8 = i6 + 1;
            if (i8 < i7 && str.charAt(i8) == '\n') {
                return i6 + 2;
            }
            return i8;
        }
        if (str.charAt(i6) == '\n') {
            return i6 + 1;
        }
        throw new NumberFormatException("Expected a new line at index " + i6 + ", but was " + str.charAt(i6));
    }

    private static final int h(String str, int i6) {
        int i7;
        char charAt = str.charAt(i6);
        if ((charAt >>> '\b') == 0 && (i7 = f47875e[charAt]) >= 0) {
            return i7;
        }
        S(str, i6);
        throw new KotlinNothingValueException();
    }

    private static final int i(byte[] bArr, int i6, String str, String str2, int[] iArr, char[] cArr, int i7) {
        return W(str2, cArr, j(bArr, i6, iArr, cArr, W(str, cArr, i7)));
    }

    private static final String k0(byte[] bArr, int i6, int i7, j.b bVar, int[] iArr) {
        if (bVar.k()) {
            return m0(bArr, i6, i7, bVar, iArr);
        }
        return l0(bArr, i6, i7, bVar, iArr);
    }

    private static final String l0(byte[] bArr, int i6, int i7, j.b bVar, int[] iArr) {
        String c6 = bVar.c();
        String e6 = bVar.e();
        String d6 = bVar.d();
        char[] cArr = new char[k(i7 - i6, d6.length(), c6.length(), e6.length())];
        int i8 = i(bArr, i6, c6, e6, iArr, cArr, 0);
        for (int i9 = i6 + 1; i9 < i7; i9++) {
            i8 = i(bArr, i9, c6, e6, iArr, cArr, W(d6, cArr, i8));
        }
        return g0.J1(cArr);
    }

    private static final String m0(byte[] bArr, int i6, int i7, j.b bVar, int[] iArr) {
        int length = bVar.d().length();
        if (length <= 1) {
            int i8 = i7 - i6;
            int i9 = 0;
            if (length == 0) {
                char[] cArr = new char[c(i8 * 2)];
                while (i6 < i7) {
                    i9 = j(bArr, i6, iArr, cArr, i9);
                    i6++;
                }
                return g0.J1(cArr);
            }
            char[] cArr2 = new char[c((i8 * 3) - 1)];
            char charAt = bVar.d().charAt(0);
            int j6 = j(bArr, i6, iArr, cArr2, 0);
            for (int i10 = i6 + 1; i10 < i7; i10++) {
                cArr2[j6] = charAt;
                j6 = j(bArr, i10, iArr, cArr2, j6 + 1);
            }
            return g0.J1(cArr2);
        }
        throw new IllegalArgumentException("Failed requirement.");
    }

    private static final byte[] v(String str, int i6, int i7, j.b bVar) {
        if (bVar.k()) {
            return x(str, i6, i7, bVar);
        }
        return w(str, i6, i7, bVar);
    }

    private static final byte[] w(String str, int i6, int i7, j.b bVar) {
        String c6 = bVar.c();
        String e6 = bVar.e();
        String d6 = bVar.d();
        long length = d6.length();
        long length2 = c6.length() + 2 + e6.length() + length;
        long j6 = i7 - i6;
        int i8 = (int) ((j6 + length) / length2);
        if ((i8 * length2) - length != j6) {
            return null;
        }
        boolean i9 = bVar.i();
        byte[] bArr = new byte[i8];
        if (c6.length() != 0) {
            int length3 = c6.length();
            for (int i10 = 0; i10 < length3; i10++) {
                if (!d.J(c6.charAt(i10), str.charAt(i6 + i10), i9)) {
                    V(str, i6, i7, c6, "byte prefix");
                }
            }
            i6 += c6.length();
        }
        String str2 = e6 + d6 + c6;
        int i11 = i8 - 1;
        for (int i12 = 0; i12 < i11; i12++) {
            bArr[i12] = O(str, i6);
            i6 += 2;
            if (str2.length() != 0) {
                int length4 = str2.length();
                for (int i13 = 0; i13 < length4; i13++) {
                    if (!d.J(str2.charAt(i13), str.charAt(i6 + i13), i9)) {
                        V(str, i6, i7, str2, "byte suffix + byte separator + byte prefix");
                    }
                }
                i6 += str2.length();
            }
        }
        bArr[i11] = O(str, i6);
        int i14 = i6 + 2;
        if (e6.length() == 0) {
            return bArr;
        }
        int length5 = e6.length();
        for (int i15 = 0; i15 < length5; i15++) {
            if (!d.J(e6.charAt(i15), str.charAt(i14 + i15), i9)) {
                V(str, i14, i7, e6, "byte suffix");
            }
        }
        return bArr;
    }

    private static final byte[] x(String str, int i6, int i7, j.b bVar) {
        int length = bVar.d().length();
        if (length <= 1) {
            int i8 = i7 - i6;
            int i9 = 2;
            if (length == 0) {
                if ((i8 & 1) != 0) {
                    return null;
                }
                int i10 = i8 >> 1;
                byte[] bArr = new byte[i10];
                int i11 = 0;
                for (int i12 = 0; i12 < i10; i12++) {
                    bArr[i12] = O(str, i11);
                    i11 += 2;
                }
                return bArr;
            }
            if (i8 % 3 != 2) {
                return null;
            }
            int i13 = (i8 / 3) + 1;
            byte[] bArr2 = new byte[i13];
            char charAt = bVar.d().charAt(0);
            bArr2[0] = O(str, 0);
            for (int i14 = 1; i14 < i13; i14++) {
                if (str.charAt(i9) != charAt) {
                    String d6 = bVar.d();
                    boolean i15 = bVar.i();
                    if (d6.length() != 0) {
                        int length2 = d6.length();
                        for (int i16 = 0; i16 < length2; i16++) {
                            if (!d.J(d6.charAt(i16), str.charAt(i9 + i16), i15)) {
                                V(str, i9, i7, d6, "byte separator");
                            }
                        }
                        d6.length();
                    }
                }
                bArr2[i14] = O(str, i9 + 1);
                i9 += 3;
            }
            return bArr2;
        }
        throw new IllegalArgumentException("Failed requirement.");
    }
}
