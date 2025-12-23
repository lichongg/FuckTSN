package kotlin.time;

import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.time.h;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Marker;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nDuration.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Duration.kt\nkotlin/time/DurationKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1062:1\n1015#1,6:1064\n1018#1,3:1070\n1015#1,6:1073\n1015#1,6:1079\n1018#1,3:1085\n1#2:1063\n*S KotlinDebug\n*F\n+ 1 Duration.kt\nkotlin/time/DurationKt\n*L\n930#1:1064,6\n964#1:1070,3\n967#1:1073,6\n970#1:1079,6\n1015#1:1085,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public static final int f48026a = 1000000;

    /* renamed from: b, reason: collision with root package name */
    public static final long f48027b = 4611686018426999999L;

    /* renamed from: c, reason: collision with root package name */
    public static final long f48028c = 4611686018427387903L;

    /* renamed from: d, reason: collision with root package name */
    private static final long f48029d = 4611686018426L;

    /* JADX INFO: Access modifiers changed from: private */
    public static final long i(long j6, int i6) {
        return h.l((j6 << 1) + i6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long j(long j6) {
        return h.l((j6 << 1) + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long l(long j6) {
        return h.l(j6 << 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long p(String str, boolean z5) {
        int i6;
        char charAt;
        char charAt2;
        int i7;
        boolean z6;
        int length = str.length();
        if (length == 0) {
            throw new IllegalArgumentException("The string is empty");
        }
        h.a aVar = h.f48019b;
        long T = aVar.T();
        char charAt3 = str.charAt(0);
        int i8 = (charAt3 == '+' || charAt3 == '-') ? 1 : 0;
        boolean z7 = i8 > 0;
        boolean z8 = z7 && kotlin.text.u.y5(str, '-', false, 2, null);
        if (length <= i8) {
            throw new IllegalArgumentException("No components");
        }
        char c6 = ':';
        char c7 = '0';
        if (str.charAt(i8) == 'P') {
            int i9 = i8 + 1;
            if (i9 == length) {
                throw new IllegalArgumentException();
            }
            boolean z9 = false;
            DurationUnit durationUnit = null;
            while (i9 < length) {
                if (str.charAt(i9) != 'T') {
                    int i10 = i9;
                    while (true) {
                        if (i10 >= str.length()) {
                            i7 = length;
                            break;
                        }
                        char charAt4 = str.charAt(i10);
                        if (c7 > charAt4 || charAt4 >= c6) {
                            i7 = length;
                            if (!kotlin.text.u.k3("+-.", charAt4, false, 2, null)) {
                                break;
                            }
                        } else {
                            i7 = length;
                        }
                        i10++;
                        length = i7;
                        c7 = '0';
                        c6 = ':';
                    }
                    kotlin.jvm.internal.g0.n(str, "null cannot be cast to non-null type java.lang.String");
                    String substring = str.substring(i9, i10);
                    kotlin.jvm.internal.g0.o(substring, "substring(...)");
                    if (substring.length() == 0) {
                        throw new IllegalArgumentException();
                    }
                    int length2 = i9 + substring.length();
                    if (length2 < 0 || length2 >= str.length()) {
                        throw new IllegalArgumentException("Missing unit for value " + substring);
                    }
                    char charAt5 = str.charAt(length2);
                    i9 = length2 + 1;
                    DurationUnit f6 = m.f(charAt5, z9);
                    if (durationUnit != null && durationUnit.compareTo(f6) <= 0) {
                        throw new IllegalArgumentException("Unexpected order of duration components");
                    }
                    int G3 = kotlin.text.u.G3(substring, '.', 0, false, 6, null);
                    if (f6 != DurationUnit.SECONDS || G3 <= 0) {
                        z6 = z9;
                        T = h.Y(T, x(q(substring), f6));
                    } else {
                        kotlin.jvm.internal.g0.n(substring, "null cannot be cast to non-null type java.lang.String");
                        String substring2 = substring.substring(0, G3);
                        kotlin.jvm.internal.g0.o(substring2, "substring(...)");
                        z6 = z9;
                        long Y = h.Y(T, x(q(substring2), f6));
                        kotlin.jvm.internal.g0.n(substring, "null cannot be cast to non-null type java.lang.String");
                        String substring3 = substring.substring(G3);
                        kotlin.jvm.internal.g0.o(substring3, "substring(...)");
                        T = h.Y(Y, v(Double.parseDouble(substring3), f6));
                    }
                    z9 = z6;
                    durationUnit = f6;
                    length = i7;
                    c7 = '0';
                    c6 = ':';
                } else {
                    if (z9 || (i9 = i9 + 1) == length) {
                        throw new IllegalArgumentException();
                    }
                    z9 = true;
                }
            }
        } else {
            if (z5) {
                throw new IllegalArgumentException();
            }
            char c8 = '0';
            if (kotlin.text.u.q2(str, i8, "Infinity", 0, Math.max(length - i8, 8), true)) {
                T = aVar.n();
            } else {
                boolean z10 = !z7;
                if (z7 && str.charAt(i8) == '(' && kotlin.text.u.U7(str) == ')') {
                    i8++;
                    int i11 = length - 1;
                    if (i8 == i11) {
                        throw new IllegalArgumentException("No components");
                    }
                    i6 = i11;
                    z10 = true;
                } else {
                    i6 = length;
                }
                boolean z11 = false;
                DurationUnit durationUnit2 = null;
                while (i8 < i6) {
                    if (z11 && z10) {
                        while (i8 < str.length() && str.charAt(i8) == ' ') {
                            i8++;
                        }
                    }
                    int i12 = i8;
                    while (i12 < str.length() && ((c8 <= (charAt2 = str.charAt(i12)) && charAt2 < ':') || charAt2 == '.')) {
                        i12++;
                    }
                    kotlin.jvm.internal.g0.n(str, "null cannot be cast to non-null type java.lang.String");
                    String substring4 = str.substring(i8, i12);
                    kotlin.jvm.internal.g0.o(substring4, "substring(...)");
                    if (substring4.length() == 0) {
                        throw new IllegalArgumentException();
                    }
                    int length3 = i8 + substring4.length();
                    int i13 = length3;
                    while (i13 < str.length() && 'a' <= (charAt = str.charAt(i13)) && charAt < '{') {
                        i13++;
                    }
                    kotlin.jvm.internal.g0.n(str, "null cannot be cast to non-null type java.lang.String");
                    String substring5 = str.substring(length3, i13);
                    kotlin.jvm.internal.g0.o(substring5, "substring(...)");
                    i8 = length3 + substring5.length();
                    DurationUnit g6 = m.g(substring5);
                    if (durationUnit2 != null && durationUnit2.compareTo(g6) <= 0) {
                        throw new IllegalArgumentException("Unexpected order of duration components");
                    }
                    int G32 = kotlin.text.u.G3(substring4, '.', 0, false, 6, null);
                    if (G32 > 0) {
                        kotlin.jvm.internal.g0.n(substring4, "null cannot be cast to non-null type java.lang.String");
                        String substring6 = substring4.substring(0, G32);
                        kotlin.jvm.internal.g0.o(substring6, "substring(...)");
                        long Y2 = h.Y(T, x(Long.parseLong(substring6), g6));
                        kotlin.jvm.internal.g0.n(substring4, "null cannot be cast to non-null type java.lang.String");
                        String substring7 = substring4.substring(G32);
                        kotlin.jvm.internal.g0.o(substring7, "substring(...)");
                        T = h.Y(Y2, v(Double.parseDouble(substring7), g6));
                        if (i8 < i6) {
                            throw new IllegalArgumentException("Fractional component must be last");
                        }
                    } else {
                        T = h.Y(T, x(Long.parseLong(substring4), g6));
                    }
                    durationUnit2 = g6;
                    z11 = true;
                    c8 = '0';
                }
            }
        }
        return z8 ? h.n0(T) : T;
    }

    private static final String s(String str, int i6, Function1<? super Character, Boolean> function1) {
        int i7 = i6;
        while (i7 < str.length() && function1.invoke(Character.valueOf(str.charAt(i7))).booleanValue()) {
            i7++;
        }
        kotlin.jvm.internal.g0.n(str, "null cannot be cast to non-null type java.lang.String");
        String substring = str.substring(i6, i7);
        kotlin.jvm.internal.g0.o(substring, "substring(...)");
        return substring;
    }

    @SinceKotlin(version = cn.bluemobi.dylan.photoview.a.f1297f)
    public static final long v(double d6, @NotNull DurationUnit unit) {
        kotlin.jvm.internal.g0.p(unit, "unit");
        double a6 = l.a(d6, unit, DurationUnit.NANOSECONDS);
        if (Double.isNaN(a6)) {
            throw new IllegalArgumentException("Duration value cannot be NaN.");
        }
        long M0 = kotlin.math.b.M0(a6);
        return (-4611686018426999999L > M0 || M0 >= 4611686018427000000L) ? k(kotlin.math.b.M0(l.a(d6, unit, DurationUnit.MILLISECONDS))) : l(M0);
    }

    @SinceKotlin(version = cn.bluemobi.dylan.photoview.a.f1297f)
    public static final long w(int i6, @NotNull DurationUnit unit) {
        kotlin.jvm.internal.g0.p(unit, "unit");
        return unit.compareTo(DurationUnit.SECONDS) <= 0 ? l(l.c(i6, unit, DurationUnit.NANOSECONDS)) : x(i6, unit);
    }

    @SinceKotlin(version = cn.bluemobi.dylan.photoview.a.f1297f)
    public static final long x(long j6, @NotNull DurationUnit unit) {
        kotlin.jvm.internal.g0.p(unit, "unit");
        DurationUnit durationUnit = DurationUnit.NANOSECONDS;
        long c6 = l.c(f48027b, durationUnit, unit);
        return ((-c6) > j6 || j6 > c6) ? j(kotlin.ranges.t.K(l.b(j6, unit, DurationUnit.MILLISECONDS), -4611686018427387903L, f48028c)) : l(l.c(j6, unit, durationUnit));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long n(long j6) {
        return j6 * 1000000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long o(long j6) {
        return j6 / 1000000;
    }

    private static final long q(String str) {
        int i6;
        char charAt;
        int length = str.length();
        if (length > 0 && kotlin.text.u.k3("+-", str.charAt(0), false, 2, null)) {
            i6 = 1;
        } else {
            i6 = 0;
        }
        if (length - i6 > 16) {
            int i7 = i6;
            while (true) {
                if (i6 < length) {
                    char charAt2 = str.charAt(i6);
                    if (charAt2 == '0') {
                        if (i7 == i6) {
                            i7++;
                        }
                    } else if ('1' > charAt2 || charAt2 >= ':') {
                        break;
                    }
                    i6++;
                } else if (length - i7 > 16) {
                    if (str.charAt(0) == '-') {
                        return Long.MIN_VALUE;
                    }
                    return Long.MAX_VALUE;
                }
            }
        }
        if (kotlin.text.u.H2(str, Marker.ANY_NON_NULL_MARKER, false, 2, null) && length > 1 && '0' <= (charAt = str.charAt(1)) && charAt < ':') {
            return Long.parseLong(kotlin.text.u.b7(str, 1));
        }
        return Long.parseLong(str);
    }

    private static final int r(String str, int i6, Function1<? super Character, Boolean> function1) {
        while (i6 < str.length() && function1.invoke(Character.valueOf(str.charAt(i6))).booleanValue()) {
            i6++;
        }
        return i6;
    }

    @SinceKotlin(version = cn.bluemobi.dylan.photoview.a.f1297f)
    @InlineOnly
    private static final long t(double d6, long j6) {
        return h.Z(j6, d6);
    }

    @SinceKotlin(version = cn.bluemobi.dylan.photoview.a.f1297f)
    @InlineOnly
    private static final long u(int i6, long j6) {
        return h.a0(j6, i6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long k(long j6) {
        if (-4611686018426L <= j6 && j6 < 4611686018427L) {
            return l(n(j6));
        }
        return j(kotlin.ranges.t.K(j6, -4611686018427387903L, f48028c));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long m(long j6) {
        if (-4611686018426999999L <= j6 && j6 < 4611686018427000000L) {
            return l(j6);
        }
        return j(o(j6));
    }
}
