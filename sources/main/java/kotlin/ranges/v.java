package kotlin.ranges;

import com.daimajia.numberprogressbar.BuildConfig;
import java.util.NoSuchElementException;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.ExperimentalStdlibApi;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.random.Random;
import kotlin.ranges.a;
import kotlin.ranges.k;
import kotlin.ranges.n;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\n_Ranges.kt\nKotlin\n*S Kotlin\n*F\n+ 1 _Ranges.kt\nkotlin/ranges/RangesKt___RangesKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1572:1\n1#2:1573\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public class v extends u {
    @NotNull
    public static final c R1(char c6, char c7) {
        return g0.t(c7, 0) <= 0 ? c.f44165e.a() : new c(c6, (char) (c7 - 1));
    }

    public static final float A(float f6, float f7) {
        return f6 > f7 ? f7 : f6;
    }

    @SinceKotlin(version = "1.7")
    @Nullable
    public static final Integer A0(@NotNull k kVar) {
        g0.p(kVar, "<this>");
        if (kVar.isEmpty()) {
            return null;
        }
        return Integer.valueOf(kVar.e());
    }

    @NotNull
    public static final a A1(@NotNull a aVar, int i6) {
        g0.p(aVar, "<this>");
        u.a(i6 > 0, Integer.valueOf(i6));
        a.C0870a c0870a = a.f44151d;
        char e6 = aVar.e();
        char f6 = aVar.f();
        if (aVar.g() <= 0) {
            i6 = -i6;
        }
        return c0870a.a(e6, f6, i6);
    }

    public static int B(int i6, int i7) {
        return i6 > i7 ? i7 : i6;
    }

    @SinceKotlin(version = "1.7")
    @Nullable
    public static final Long B0(@NotNull n nVar) {
        g0.p(nVar, "<this>");
        if (nVar.isEmpty()) {
            return null;
        }
        return Long.valueOf(nVar.e());
    }

    @NotNull
    public static k B1(@NotNull k kVar, int i6) {
        g0.p(kVar, "<this>");
        u.a(i6 > 0, Integer.valueOf(i6));
        k.a aVar = k.f44175d;
        int e6 = kVar.e();
        int f6 = kVar.f();
        if (kVar.g() <= 0) {
            i6 = -i6;
        }
        return aVar.a(e6, f6, i6);
    }

    public static long C(long j6, long j7) {
        return j6 > j7 ? j7 : j6;
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = BuildConfig.VERSION_NAME, hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "floatRangeContains")
    public static final /* synthetic */ boolean C0(h hVar, byte b6) {
        g0.p(hVar, "<this>");
        return hVar.contains(Float.valueOf(b6));
    }

    @NotNull
    public static final n C1(@NotNull n nVar, long j6) {
        g0.p(nVar, "<this>");
        u.a(j6 > 0, Long.valueOf(j6));
        n.a aVar = n.f44185d;
        long e6 = nVar.e();
        long f6 = nVar.f();
        if (nVar.g() <= 0) {
            j6 = -j6;
        }
        return aVar.a(e6, f6, j6);
    }

    @NotNull
    public static final <T extends Comparable<? super T>> T D(@NotNull T t5, @NotNull T maximumValue) {
        g0.p(t5, "<this>");
        g0.p(maximumValue, "maximumValue");
        return t5.compareTo(maximumValue) > 0 ? maximumValue : t5;
    }

    @JvmName(name = "floatRangeContains")
    public static final boolean D0(@NotNull h<Float> hVar, double d6) {
        g0.p(hVar, "<this>");
        return hVar.contains(Float.valueOf((float) d6));
    }

    @Nullable
    public static final Byte D1(double d6) {
        if (-128.0d > d6 || d6 > 127.0d) {
            return null;
        }
        return Byte.valueOf((byte) d6);
    }

    public static final short E(short s5, short s6) {
        return s5 > s6 ? s6 : s5;
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = BuildConfig.VERSION_NAME, hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "floatRangeContains")
    public static final /* synthetic */ boolean E0(h hVar, int i6) {
        g0.p(hVar, "<this>");
        return hVar.contains(Float.valueOf(i6));
    }

    @Nullable
    public static final Byte E1(float f6) {
        if (-128.0f > f6 || f6 > 127.0f) {
            return null;
        }
        return Byte.valueOf((byte) f6);
    }

    public static final byte F(byte b6, byte b7, byte b8) {
        if (b7 <= b8) {
            return b6 < b7 ? b7 : b6 > b8 ? b8 : b6;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ((int) b8) + " is less than minimum " + ((int) b7) + '.');
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = BuildConfig.VERSION_NAME, hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "floatRangeContains")
    public static final /* synthetic */ boolean F0(h hVar, long j6) {
        g0.p(hVar, "<this>");
        return hVar.contains(Float.valueOf(j6));
    }

    @Nullable
    public static final Byte F1(int i6) {
        if (-128 > i6 || i6 >= 128) {
            return null;
        }
        return Byte.valueOf((byte) i6);
    }

    public static final double G(double d6, double d7, double d8) {
        if (d7 <= d8) {
            return d6 < d7 ? d7 : d6 > d8 ? d8 : d6;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + d8 + " is less than minimum " + d7 + '.');
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = BuildConfig.VERSION_NAME, hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "floatRangeContains")
    public static final /* synthetic */ boolean G0(h hVar, short s5) {
        g0.p(hVar, "<this>");
        return hVar.contains(Float.valueOf(s5));
    }

    @Nullable
    public static final Byte G1(long j6) {
        if (-128 > j6 || j6 >= 128) {
            return null;
        }
        return Byte.valueOf((byte) j6);
    }

    public static final float H(float f6, float f7, float f8) {
        if (f7 <= f8) {
            return f6 < f7 ? f7 : f6 > f8 ? f8 : f6;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + f8 + " is less than minimum " + f7 + '.');
    }

    @JvmName(name = "intRangeContains")
    public static final boolean H0(@NotNull h<Integer> hVar, byte b6) {
        g0.p(hVar, "<this>");
        return hVar.contains(Integer.valueOf(b6));
    }

    @Nullable
    public static final Byte H1(short s5) {
        if (-128 > s5 || s5 >= 128) {
            return null;
        }
        return Byte.valueOf((byte) s5);
    }

    public static int I(int i6, int i7, int i8) {
        if (i7 <= i8) {
            return i6 < i7 ? i7 : i6 > i8 ? i8 : i6;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i8 + " is less than minimum " + i7 + '.');
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = BuildConfig.VERSION_NAME, hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "intRangeContains")
    public static final /* synthetic */ boolean I0(h hVar, double d6) {
        g0.p(hVar, "<this>");
        Integer I1 = I1(d6);
        if (I1 != null) {
            return hVar.contains(I1);
        }
        return false;
    }

    @Nullable
    public static final Integer I1(double d6) {
        if (-2.147483648E9d > d6 || d6 > 2.147483647E9d) {
            return null;
        }
        return Integer.valueOf((int) d6);
    }

    public static final int J(int i6, @NotNull h<Integer> range) {
        g0.p(range, "range");
        if (range instanceof g) {
            return ((Number) N(Integer.valueOf(i6), (g) range)).intValue();
        }
        if (!range.isEmpty()) {
            return i6 < range.getStart().intValue() ? range.getStart().intValue() : i6 > range.getEndInclusive().intValue() ? range.getEndInclusive().intValue() : i6;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + range + '.');
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = BuildConfig.VERSION_NAME, hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "intRangeContains")
    public static final /* synthetic */ boolean J0(h hVar, float f6) {
        g0.p(hVar, "<this>");
        Integer J1 = J1(f6);
        if (J1 != null) {
            return hVar.contains(J1);
        }
        return false;
    }

    @Nullable
    public static final Integer J1(float f6) {
        if (-2.1474836E9f > f6 || f6 > 2.1474836E9f) {
            return null;
        }
        return Integer.valueOf((int) f6);
    }

    public static long K(long j6, long j7, long j8) {
        if (j7 <= j8) {
            return j6 < j7 ? j7 : j6 > j8 ? j8 : j6;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + j8 + " is less than minimum " + j7 + '.');
    }

    @JvmName(name = "intRangeContains")
    public static final boolean K0(@NotNull h<Integer> hVar, long j6) {
        g0.p(hVar, "<this>");
        Integer K1 = K1(j6);
        if (K1 != null) {
            return hVar.contains(K1);
        }
        return false;
    }

    public static long L(long j6, @NotNull h<Long> range) {
        g0.p(range, "range");
        if (range instanceof g) {
            return ((Number) N(Long.valueOf(j6), (g) range)).longValue();
        }
        if (!range.isEmpty()) {
            return j6 < range.getStart().longValue() ? range.getStart().longValue() : j6 > range.getEndInclusive().longValue() ? range.getEndInclusive().longValue() : j6;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + range + '.');
    }

    @JvmName(name = "intRangeContains")
    public static final boolean L0(@NotNull h<Integer> hVar, short s5) {
        g0.p(hVar, "<this>");
        return hVar.contains(Integer.valueOf(s5));
    }

    @Nullable
    public static final Long L1(double d6) {
        if (-9.223372036854776E18d > d6 || d6 > 9.223372036854776E18d) {
            return null;
        }
        return Long.valueOf((long) d6);
    }

    @NotNull
    public static final <T extends Comparable<? super T>> T M(@NotNull T t5, @Nullable T t6, @Nullable T t7) {
        g0.p(t5, "<this>");
        if (t6 == null || t7 == null) {
            if (t6 != null && t5.compareTo(t6) < 0) {
                return t6;
            }
            if (t7 != null && t5.compareTo(t7) > 0) {
                return t7;
            }
        } else {
            if (t6.compareTo(t7) > 0) {
                throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + t7 + " is less than minimum " + t6 + '.');
            }
            if (t5.compareTo(t6) < 0) {
                return t6;
            }
            if (t5.compareTo(t7) > 0) {
                return t7;
            }
        }
        return t5;
    }

    @SinceKotlin(version = "1.9")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @JvmName(name = "intRangeContains")
    public static final boolean M0(@NotNull s<Integer> sVar, byte b6) {
        g0.p(sVar, "<this>");
        return sVar.contains(Integer.valueOf(b6));
    }

    @Nullable
    public static final Long M1(float f6) {
        if (-9.223372E18f > f6 || f6 > 9.223372E18f) {
            return null;
        }
        return Long.valueOf((long) f6);
    }

    @SinceKotlin(version = "1.1")
    @NotNull
    public static final <T extends Comparable<? super T>> T N(@NotNull T t5, @NotNull g<T> range) {
        g0.p(t5, "<this>");
        g0.p(range, "range");
        if (!range.isEmpty()) {
            return (!range.a(t5, range.getStart()) || range.a(range.getStart(), t5)) ? (!range.a(range.getEndInclusive(), t5) || range.a(t5, range.getEndInclusive())) ? t5 : range.getEndInclusive() : range.getStart();
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + range + '.');
    }

    @SinceKotlin(version = "1.9")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @JvmName(name = "intRangeContains")
    public static final boolean N0(@NotNull s<Integer> sVar, long j6) {
        g0.p(sVar, "<this>");
        Integer K1 = K1(j6);
        if (K1 != null) {
            return sVar.contains(K1);
        }
        return false;
    }

    @Nullable
    public static final Short N1(double d6) {
        if (-32768.0d > d6 || d6 > 32767.0d) {
            return null;
        }
        return Short.valueOf((short) d6);
    }

    @NotNull
    public static final <T extends Comparable<? super T>> T O(@NotNull T t5, @NotNull h<T> range) {
        g0.p(t5, "<this>");
        g0.p(range, "range");
        if (range instanceof g) {
            return (T) N(t5, (g) range);
        }
        if (!range.isEmpty()) {
            return t5.compareTo(range.getStart()) < 0 ? range.getStart() : t5.compareTo(range.getEndInclusive()) > 0 ? range.getEndInclusive() : t5;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + range + '.');
    }

    @SinceKotlin(version = "1.9")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @JvmName(name = "intRangeContains")
    public static final boolean O0(@NotNull s<Integer> sVar, short s5) {
        g0.p(sVar, "<this>");
        return sVar.contains(Integer.valueOf(s5));
    }

    @Nullable
    public static final Short O1(float f6) {
        if (-32768.0f > f6 || f6 > 32767.0f) {
            return null;
        }
        return Short.valueOf((short) f6);
    }

    public static final short P(short s5, short s6, short s7) {
        if (s6 <= s7) {
            return s5 < s6 ? s6 : s5 > s7 ? s7 : s5;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ((int) s7) + " is less than minimum " + ((int) s6) + '.');
    }

    @SinceKotlin(version = "1.7")
    public static final char P0(@NotNull a aVar) {
        g0.p(aVar, "<this>");
        if (!aVar.isEmpty()) {
            return aVar.f();
        }
        throw new NoSuchElementException("Progression " + aVar + " is empty.");
    }

    @Nullable
    public static final Short P1(int i6) {
        if (-32768 > i6 || i6 >= 32768) {
            return null;
        }
        return Short.valueOf((short) i6);
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final boolean Q(c cVar, Character ch) {
        g0.p(cVar, "<this>");
        return ch != null && cVar.n(ch.charValue());
    }

    @SinceKotlin(version = "1.7")
    public static final int Q0(@NotNull k kVar) {
        g0.p(kVar, "<this>");
        if (!kVar.isEmpty()) {
            return kVar.f();
        }
        throw new NoSuchElementException("Progression " + kVar + " is empty.");
    }

    @Nullable
    public static final Short Q1(long j6) {
        if (-32768 > j6 || j6 >= 32768) {
            return null;
        }
        return Short.valueOf((short) j6);
    }

    @InlineOnly
    private static final boolean R(m mVar, byte b6) {
        g0.p(mVar, "<this>");
        return H0(mVar, b6);
    }

    @SinceKotlin(version = "1.7")
    public static final long R0(@NotNull n nVar) {
        g0.p(nVar, "<this>");
        if (!nVar.isEmpty()) {
            return nVar.f();
        }
        throw new NoSuchElementException("Progression " + nVar + " is empty.");
    }

    @InlineOnly
    private static final boolean S(m mVar, long j6) {
        g0.p(mVar, "<this>");
        return K0(mVar, j6);
    }

    @SinceKotlin(version = "1.7")
    @Nullable
    public static final Character S0(@NotNull a aVar) {
        g0.p(aVar, "<this>");
        if (aVar.isEmpty()) {
            return null;
        }
        return Character.valueOf(aVar.f());
    }

    @NotNull
    public static final m S1(byte b6, byte b7) {
        return new m(b6, b7 - 1);
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final boolean T(m mVar, Integer num) {
        g0.p(mVar, "<this>");
        return num != null && mVar.n(num.intValue());
    }

    @SinceKotlin(version = "1.7")
    @Nullable
    public static final Integer T0(@NotNull k kVar) {
        g0.p(kVar, "<this>");
        if (kVar.isEmpty()) {
            return null;
        }
        return Integer.valueOf(kVar.f());
    }

    @NotNull
    public static final m T1(byte b6, int i6) {
        return i6 <= Integer.MIN_VALUE ? m.f44183e.a() : new m(b6, i6 - 1);
    }

    @InlineOnly
    private static final boolean U(m mVar, short s5) {
        g0.p(mVar, "<this>");
        return L0(mVar, s5);
    }

    @SinceKotlin(version = "1.7")
    @Nullable
    public static final Long U0(@NotNull n nVar) {
        g0.p(nVar, "<this>");
        if (nVar.isEmpty()) {
            return null;
        }
        return Long.valueOf(nVar.f());
    }

    @NotNull
    public static final m U1(byte b6, short s5) {
        return new m(b6, s5 - 1);
    }

    @InlineOnly
    private static final boolean V(p pVar, byte b6) {
        g0.p(pVar, "<this>");
        return V0(pVar, b6);
    }

    @JvmName(name = "longRangeContains")
    public static final boolean V0(@NotNull h<Long> hVar, byte b6) {
        g0.p(hVar, "<this>");
        return hVar.contains(Long.valueOf(b6));
    }

    @NotNull
    public static final m V1(int i6, byte b6) {
        return new m(i6, b6 - 1);
    }

    @InlineOnly
    private static final boolean W(p pVar, int i6) {
        g0.p(pVar, "<this>");
        return Y0(pVar, i6);
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = BuildConfig.VERSION_NAME, hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "longRangeContains")
    public static final /* synthetic */ boolean W0(h hVar, double d6) {
        g0.p(hVar, "<this>");
        Long L1 = L1(d6);
        if (L1 != null) {
            return hVar.contains(L1);
        }
        return false;
    }

    @NotNull
    public static m W1(int i6, int i7) {
        return i7 <= Integer.MIN_VALUE ? m.f44183e.a() : new m(i6, i7 - 1);
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final boolean X(p pVar, Long l6) {
        g0.p(pVar, "<this>");
        return l6 != null && pVar.n(l6.longValue());
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = BuildConfig.VERSION_NAME, hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "longRangeContains")
    public static final /* synthetic */ boolean X0(h hVar, float f6) {
        g0.p(hVar, "<this>");
        Long M1 = M1(f6);
        if (M1 != null) {
            return hVar.contains(M1);
        }
        return false;
    }

    @NotNull
    public static final m X1(int i6, short s5) {
        return new m(i6, s5 - 1);
    }

    @InlineOnly
    private static final boolean Y(p pVar, short s5) {
        g0.p(pVar, "<this>");
        return Z0(pVar, s5);
    }

    @JvmName(name = "longRangeContains")
    public static final boolean Y0(@NotNull h<Long> hVar, int i6) {
        g0.p(hVar, "<this>");
        return hVar.contains(Long.valueOf(i6));
    }

    @NotNull
    public static final m Y1(short s5, byte b6) {
        return new m(s5, b6 - 1);
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = BuildConfig.VERSION_NAME, hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "doubleRangeContains")
    public static final /* synthetic */ boolean Z(h hVar, byte b6) {
        g0.p(hVar, "<this>");
        return hVar.contains(Double.valueOf(b6));
    }

    @JvmName(name = "longRangeContains")
    public static final boolean Z0(@NotNull h<Long> hVar, short s5) {
        g0.p(hVar, "<this>");
        return hVar.contains(Long.valueOf(s5));
    }

    @NotNull
    public static final m Z1(short s5, int i6) {
        return i6 <= Integer.MIN_VALUE ? m.f44183e.a() : new m(s5, i6 - 1);
    }

    @JvmName(name = "doubleRangeContains")
    public static final boolean a0(@NotNull h<Double> hVar, float f6) {
        g0.p(hVar, "<this>");
        return hVar.contains(Double.valueOf(f6));
    }

    @SinceKotlin(version = "1.9")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @JvmName(name = "longRangeContains")
    public static final boolean a1(@NotNull s<Long> sVar, byte b6) {
        g0.p(sVar, "<this>");
        return sVar.contains(Long.valueOf(b6));
    }

    @NotNull
    public static final m a2(short s5, short s6) {
        return new m(s5, s6 - 1);
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = BuildConfig.VERSION_NAME, hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "doubleRangeContains")
    public static final /* synthetic */ boolean b0(h hVar, int i6) {
        g0.p(hVar, "<this>");
        return hVar.contains(Double.valueOf(i6));
    }

    @SinceKotlin(version = "1.9")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @JvmName(name = "longRangeContains")
    public static final boolean b1(@NotNull s<Long> sVar, int i6) {
        g0.p(sVar, "<this>");
        return sVar.contains(Long.valueOf(i6));
    }

    @NotNull
    public static final p b2(byte b6, long j6) {
        return j6 <= Long.MIN_VALUE ? p.f44193e.a() : new p(b6, j6 - 1);
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = BuildConfig.VERSION_NAME, hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "doubleRangeContains")
    public static final /* synthetic */ boolean c0(h hVar, long j6) {
        g0.p(hVar, "<this>");
        return hVar.contains(Double.valueOf(j6));
    }

    @SinceKotlin(version = "1.9")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @JvmName(name = "longRangeContains")
    public static final boolean c1(@NotNull s<Long> sVar, short s5) {
        g0.p(sVar, "<this>");
        return sVar.contains(Long.valueOf(s5));
    }

    @NotNull
    public static final p c2(int i6, long j6) {
        return j6 <= Long.MIN_VALUE ? p.f44193e.a() : new p(i6, j6 - 1);
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = BuildConfig.VERSION_NAME, hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "doubleRangeContains")
    public static final /* synthetic */ boolean d0(h hVar, short s5) {
        g0.p(hVar, "<this>");
        return hVar.contains(Double.valueOf(s5));
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final char d1(c cVar) {
        g0.p(cVar, "<this>");
        return e1(cVar, Random.Default);
    }

    @NotNull
    public static final p d2(long j6, byte b6) {
        return new p(j6, b6 - 1);
    }

    @SinceKotlin(version = "1.9")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @JvmName(name = "doubleRangeContains")
    public static final boolean e0(@NotNull s<Double> sVar, float f6) {
        g0.p(sVar, "<this>");
        return sVar.contains(Double.valueOf(f6));
    }

    @SinceKotlin(version = "1.3")
    public static final char e1(@NotNull c cVar, @NotNull Random random) {
        g0.p(cVar, "<this>");
        g0.p(random, "random");
        try {
            return (char) random.nextInt(cVar.e(), cVar.f() + 1);
        } catch (IllegalArgumentException e6) {
            throw new NoSuchElementException(e6.getMessage());
        }
    }

    @NotNull
    public static final p e2(long j6, int i6) {
        return new p(j6, i6 - 1);
    }

    @NotNull
    public static final a f0(char c6, char c7) {
        return a.f44151d.a(c6, c7, -1);
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final int f1(m mVar) {
        g0.p(mVar, "<this>");
        return g1(mVar, Random.Default);
    }

    @NotNull
    public static final p f2(long j6, long j7) {
        return j7 <= Long.MIN_VALUE ? p.f44193e.a() : new p(j6, j7 - 1);
    }

    @NotNull
    public static final k g0(byte b6, byte b7) {
        return k.f44175d.a(b6, b7, -1);
    }

    @SinceKotlin(version = "1.3")
    public static final int g1(@NotNull m mVar, @NotNull Random random) {
        g0.p(mVar, "<this>");
        g0.p(random, "random");
        try {
            return kotlin.random.f.h(random, mVar);
        } catch (IllegalArgumentException e6) {
            throw new NoSuchElementException(e6.getMessage());
        }
    }

    @NotNull
    public static final p g2(long j6, short s5) {
        return new p(j6, s5 - 1);
    }

    @NotNull
    public static final k h0(byte b6, int i6) {
        return k.f44175d.a(b6, i6, -1);
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final long h1(p pVar) {
        g0.p(pVar, "<this>");
        return i1(pVar, Random.Default);
    }

    @NotNull
    public static final p h2(short s5, long j6) {
        return j6 <= Long.MIN_VALUE ? p.f44193e.a() : new p(s5, j6 - 1);
    }

    @NotNull
    public static final k i0(byte b6, short s5) {
        return k.f44175d.a(b6, s5, -1);
    }

    @SinceKotlin(version = "1.3")
    public static final long i1(@NotNull p pVar, @NotNull Random random) {
        g0.p(pVar, "<this>");
        g0.p(random, "random");
        try {
            return kotlin.random.f.i(random, pVar);
        } catch (IllegalArgumentException e6) {
            throw new NoSuchElementException(e6.getMessage());
        }
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = BuildConfig.VERSION_NAME, hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "byteRangeContains")
    public static final /* synthetic */ boolean j(h hVar, double d6) {
        g0.p(hVar, "<this>");
        Byte D1 = D1(d6);
        if (D1 != null) {
            return hVar.contains(D1);
        }
        return false;
    }

    @NotNull
    public static final k j0(int i6, byte b6) {
        return k.f44175d.a(i6, b6, -1);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final Character j1(c cVar) {
        g0.p(cVar, "<this>");
        return k1(cVar, Random.Default);
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = BuildConfig.VERSION_NAME, hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "byteRangeContains")
    public static final /* synthetic */ boolean k(h hVar, float f6) {
        g0.p(hVar, "<this>");
        Byte E1 = E1(f6);
        if (E1 != null) {
            return hVar.contains(E1);
        }
        return false;
    }

    @NotNull
    public static k k0(int i6, int i7) {
        return k.f44175d.a(i6, i7, -1);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final Character k1(@NotNull c cVar, @NotNull Random random) {
        g0.p(cVar, "<this>");
        g0.p(random, "random");
        if (cVar.isEmpty()) {
            return null;
        }
        return Character.valueOf((char) random.nextInt(cVar.e(), cVar.f() + 1));
    }

    @JvmName(name = "byteRangeContains")
    public static final boolean l(@NotNull h<Byte> hVar, int i6) {
        g0.p(hVar, "<this>");
        Byte F1 = F1(i6);
        if (F1 != null) {
            return hVar.contains(F1);
        }
        return false;
    }

    @NotNull
    public static final k l0(int i6, short s5) {
        return k.f44175d.a(i6, s5, -1);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final Integer l1(m mVar) {
        g0.p(mVar, "<this>");
        return m1(mVar, Random.Default);
    }

    @JvmName(name = "byteRangeContains")
    public static final boolean m(@NotNull h<Byte> hVar, long j6) {
        g0.p(hVar, "<this>");
        Byte G1 = G1(j6);
        if (G1 != null) {
            return hVar.contains(G1);
        }
        return false;
    }

    @NotNull
    public static final k m0(short s5, byte b6) {
        return k.f44175d.a(s5, b6, -1);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final Integer m1(@NotNull m mVar, @NotNull Random random) {
        g0.p(mVar, "<this>");
        g0.p(random, "random");
        if (mVar.isEmpty()) {
            return null;
        }
        return Integer.valueOf(kotlin.random.f.h(random, mVar));
    }

    @JvmName(name = "byteRangeContains")
    public static final boolean n(@NotNull h<Byte> hVar, short s5) {
        g0.p(hVar, "<this>");
        Byte H1 = H1(s5);
        if (H1 != null) {
            return hVar.contains(H1);
        }
        return false;
    }

    @NotNull
    public static final k n0(short s5, int i6) {
        return k.f44175d.a(s5, i6, -1);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final Long n1(p pVar) {
        g0.p(pVar, "<this>");
        return o1(pVar, Random.Default);
    }

    @SinceKotlin(version = "1.9")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @JvmName(name = "byteRangeContains")
    public static final boolean o(@NotNull s<Byte> sVar, int i6) {
        g0.p(sVar, "<this>");
        Byte F1 = F1(i6);
        if (F1 != null) {
            return sVar.contains(F1);
        }
        return false;
    }

    @NotNull
    public static final k o0(short s5, short s6) {
        return k.f44175d.a(s5, s6, -1);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final Long o1(@NotNull p pVar, @NotNull Random random) {
        g0.p(pVar, "<this>");
        g0.p(random, "random");
        if (pVar.isEmpty()) {
            return null;
        }
        return Long.valueOf(kotlin.random.f.i(random, pVar));
    }

    @SinceKotlin(version = "1.9")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @JvmName(name = "byteRangeContains")
    public static final boolean p(@NotNull s<Byte> sVar, long j6) {
        g0.p(sVar, "<this>");
        Byte G1 = G1(j6);
        if (G1 != null) {
            return sVar.contains(G1);
        }
        return false;
    }

    @NotNull
    public static final n p0(byte b6, long j6) {
        return n.f44185d.a(b6, j6, -1L);
    }

    @NotNull
    public static final a p1(@NotNull a aVar) {
        g0.p(aVar, "<this>");
        return a.f44151d.a(aVar.f(), aVar.e(), -aVar.g());
    }

    @SinceKotlin(version = "1.9")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @JvmName(name = "byteRangeContains")
    public static final boolean q(@NotNull s<Byte> sVar, short s5) {
        g0.p(sVar, "<this>");
        Byte H1 = H1(s5);
        if (H1 != null) {
            return sVar.contains(H1);
        }
        return false;
    }

    @NotNull
    public static final n q0(int i6, long j6) {
        return n.f44185d.a(i6, j6, -1L);
    }

    @NotNull
    public static final k q1(@NotNull k kVar) {
        g0.p(kVar, "<this>");
        return k.f44175d.a(kVar.f(), kVar.e(), -kVar.g());
    }

    public static final byte r(byte b6, byte b7) {
        return b6 < b7 ? b7 : b6;
    }

    @NotNull
    public static final n r0(long j6, byte b6) {
        return n.f44185d.a(j6, b6, -1L);
    }

    @NotNull
    public static final n r1(@NotNull n nVar) {
        g0.p(nVar, "<this>");
        return n.f44185d.a(nVar.f(), nVar.e(), -nVar.g());
    }

    public static final double s(double d6, double d7) {
        return d6 < d7 ? d7 : d6;
    }

    @NotNull
    public static final n s0(long j6, int i6) {
        return n.f44185d.a(j6, i6, -1L);
    }

    @JvmName(name = "shortRangeContains")
    public static final boolean s1(@NotNull h<Short> hVar, byte b6) {
        g0.p(hVar, "<this>");
        return hVar.contains(Short.valueOf(b6));
    }

    public static final float t(float f6, float f7) {
        return f6 < f7 ? f7 : f6;
    }

    @NotNull
    public static final n t0(long j6, long j7) {
        return n.f44185d.a(j6, j7, -1L);
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = BuildConfig.VERSION_NAME, hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "shortRangeContains")
    public static final /* synthetic */ boolean t1(h hVar, double d6) {
        g0.p(hVar, "<this>");
        Short N1 = N1(d6);
        if (N1 != null) {
            return hVar.contains(N1);
        }
        return false;
    }

    public static int u(int i6, int i7) {
        return i6 < i7 ? i7 : i6;
    }

    @NotNull
    public static final n u0(long j6, short s5) {
        return n.f44185d.a(j6, s5, -1L);
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = BuildConfig.VERSION_NAME, hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "shortRangeContains")
    public static final /* synthetic */ boolean u1(h hVar, float f6) {
        g0.p(hVar, "<this>");
        Short O1 = O1(f6);
        if (O1 != null) {
            return hVar.contains(O1);
        }
        return false;
    }

    public static long v(long j6, long j7) {
        return j6 < j7 ? j7 : j6;
    }

    @NotNull
    public static final n v0(short s5, long j6) {
        return n.f44185d.a(s5, j6, -1L);
    }

    @JvmName(name = "shortRangeContains")
    public static final boolean v1(@NotNull h<Short> hVar, int i6) {
        g0.p(hVar, "<this>");
        Short P1 = P1(i6);
        if (P1 != null) {
            return hVar.contains(P1);
        }
        return false;
    }

    @NotNull
    public static final <T extends Comparable<? super T>> T w(@NotNull T t5, @NotNull T minimumValue) {
        g0.p(t5, "<this>");
        g0.p(minimumValue, "minimumValue");
        return t5.compareTo(minimumValue) < 0 ? minimumValue : t5;
    }

    @SinceKotlin(version = "1.7")
    public static final char w0(@NotNull a aVar) {
        g0.p(aVar, "<this>");
        if (!aVar.isEmpty()) {
            return aVar.e();
        }
        throw new NoSuchElementException("Progression " + aVar + " is empty.");
    }

    @JvmName(name = "shortRangeContains")
    public static final boolean w1(@NotNull h<Short> hVar, long j6) {
        g0.p(hVar, "<this>");
        Short Q1 = Q1(j6);
        if (Q1 != null) {
            return hVar.contains(Q1);
        }
        return false;
    }

    public static final short x(short s5, short s6) {
        return s5 < s6 ? s6 : s5;
    }

    @SinceKotlin(version = "1.7")
    public static final int x0(@NotNull k kVar) {
        g0.p(kVar, "<this>");
        if (!kVar.isEmpty()) {
            return kVar.e();
        }
        throw new NoSuchElementException("Progression " + kVar + " is empty.");
    }

    @SinceKotlin(version = "1.9")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @JvmName(name = "shortRangeContains")
    public static final boolean x1(@NotNull s<Short> sVar, byte b6) {
        g0.p(sVar, "<this>");
        return sVar.contains(Short.valueOf(b6));
    }

    public static final byte y(byte b6, byte b7) {
        return b6 > b7 ? b7 : b6;
    }

    @SinceKotlin(version = "1.7")
    public static final long y0(@NotNull n nVar) {
        g0.p(nVar, "<this>");
        if (!nVar.isEmpty()) {
            return nVar.e();
        }
        throw new NoSuchElementException("Progression " + nVar + " is empty.");
    }

    @SinceKotlin(version = "1.9")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @JvmName(name = "shortRangeContains")
    public static final boolean y1(@NotNull s<Short> sVar, int i6) {
        g0.p(sVar, "<this>");
        Short P1 = P1(i6);
        if (P1 != null) {
            return sVar.contains(P1);
        }
        return false;
    }

    public static final double z(double d6, double d7) {
        return d6 > d7 ? d7 : d6;
    }

    @SinceKotlin(version = "1.7")
    @Nullable
    public static final Character z0(@NotNull a aVar) {
        g0.p(aVar, "<this>");
        if (aVar.isEmpty()) {
            return null;
        }
        return Character.valueOf(aVar.e());
    }

    @SinceKotlin(version = "1.9")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @JvmName(name = "shortRangeContains")
    public static final boolean z1(@NotNull s<Short> sVar, long j6) {
        g0.p(sVar, "<this>");
        Short Q1 = Q1(j6);
        if (Q1 != null) {
            return sVar.contains(Q1);
        }
        return false;
    }

    @Nullable
    public static final Integer K1(long j6) {
        if (-2147483648L <= j6 && j6 < IjkMediaMeta.AV_CH_WIDE_LEFT) {
            return Integer.valueOf((int) j6);
        }
        return null;
    }
}
