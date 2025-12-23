package kotlin.text;

import kotlin.KotlinNothingValueException;
import kotlin.SinceKotlin;
import kotlin.d1;
import kotlin.j1;
import kotlin.jvm.JvmName;
import kotlin.o1;
import kotlin.z0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JvmName(name = "UStringsKt")
/* loaded from: D:\Downloads\app\classes8.dex */
public final class x0 {
    @SinceKotlin(version = "1.5")
    @NotNull
    public static final String b(byte b6, int i6) {
        String num = Integer.toString(b6 & 255, c.a(i6));
        kotlin.jvm.internal.g0.o(num, "toString(...)");
        return num;
    }

    @SinceKotlin(version = "1.5")
    public static final byte e(@NotNull String str) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        kotlin.v0 g6 = g(str);
        if (g6 != null) {
            return g6.o0();
        }
        f0.k1(str);
        throw new KotlinNothingValueException();
    }

    @SinceKotlin(version = "1.5")
    public static final byte f(@NotNull String str, int i6) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        kotlin.v0 h6 = h(str, i6);
        if (h6 != null) {
            return h6.o0();
        }
        f0.k1(str);
        throw new KotlinNothingValueException();
    }

    @SinceKotlin(version = "1.5")
    @Nullable
    public static final kotlin.v0 g(@NotNull String str) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        return h(str, 10);
    }

    @SinceKotlin(version = "1.5")
    @Nullable
    public static final kotlin.v0 h(@NotNull String str, int i6) {
        int compare;
        kotlin.jvm.internal.g0.p(str, "<this>");
        z0 l6 = l(str, i6);
        if (l6 == null) {
            return null;
        }
        int q02 = l6.q0();
        compare = Integer.compare(q02 ^ Integer.MIN_VALUE, z0.k(255) ^ Integer.MIN_VALUE);
        if (compare > 0) {
            return null;
        }
        return kotlin.v0.b(kotlin.v0.k((byte) q02));
    }

    @SinceKotlin(version = "1.5")
    public static final int i(@NotNull String str) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        z0 k6 = k(str);
        if (k6 != null) {
            return k6.q0();
        }
        f0.k1(str);
        throw new KotlinNothingValueException();
    }

    @SinceKotlin(version = "1.5")
    public static final int j(@NotNull String str, int i6) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        z0 l6 = l(str, i6);
        if (l6 != null) {
            return l6.q0();
        }
        f0.k1(str);
        throw new KotlinNothingValueException();
    }

    @SinceKotlin(version = "1.5")
    @Nullable
    public static final z0 k(@NotNull String str) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        return l(str, 10);
    }

    @SinceKotlin(version = "1.5")
    @Nullable
    public static final z0 l(@NotNull String str, int i6) {
        int i7;
        int compare;
        int compare2;
        int compare3;
        kotlin.jvm.internal.g0.p(str, "<this>");
        c.a(i6);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i8 = 0;
        char charAt = str.charAt(0);
        if (kotlin.jvm.internal.g0.t(charAt, 48) < 0) {
            i7 = 1;
            if (length == 1 || charAt != '+') {
                return null;
            }
        } else {
            i7 = 0;
        }
        int k6 = z0.k(i6);
        int i9 = 119304647;
        while (i7 < length) {
            int b6 = c.b(str.charAt(i7), i6);
            if (b6 < 0) {
                return null;
            }
            compare = Integer.compare(i8 ^ Integer.MIN_VALUE, i9 ^ Integer.MIN_VALUE);
            if (compare > 0) {
                if (i9 == 119304647) {
                    i9 = kotlin.q0.a(-1, k6);
                    compare3 = Integer.compare(i8 ^ Integer.MIN_VALUE, i9 ^ Integer.MIN_VALUE);
                    if (compare3 > 0) {
                    }
                }
                return null;
            }
            int k7 = z0.k(i8 * k6);
            int k8 = z0.k(z0.k(b6) + k7);
            compare2 = Integer.compare(k8 ^ Integer.MIN_VALUE, k7 ^ Integer.MIN_VALUE);
            if (compare2 < 0) {
                return null;
            }
            i7++;
            i8 = k8;
        }
        return z0.b(i8);
    }

    @SinceKotlin(version = "1.5")
    public static final long m(@NotNull String str) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        d1 o5 = o(str);
        if (o5 != null) {
            return o5.q0();
        }
        f0.k1(str);
        throw new KotlinNothingValueException();
    }

    @SinceKotlin(version = "1.5")
    public static final long n(@NotNull String str, int i6) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        d1 p5 = p(str, i6);
        if (p5 != null) {
            return p5.q0();
        }
        f0.k1(str);
        throw new KotlinNothingValueException();
    }

    @SinceKotlin(version = "1.5")
    @Nullable
    public static final d1 o(@NotNull String str) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        return p(str, 10);
    }

    @SinceKotlin(version = "1.5")
    @Nullable
    public static final d1 p(@NotNull String str, int i6) {
        int compare;
        int compare2;
        int compare3;
        kotlin.jvm.internal.g0.p(str, "<this>");
        c.a(i6);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i7 = 0;
        char charAt = str.charAt(0);
        if (kotlin.jvm.internal.g0.t(charAt, 48) < 0) {
            i7 = 1;
            if (length == 1 || charAt != '+') {
                return null;
            }
        }
        long k6 = d1.k(i6);
        long j6 = 0;
        long j7 = 512409557603043100L;
        while (i7 < length) {
            if (c.b(str.charAt(i7), i6) < 0) {
                return null;
            }
            compare = Long.compare(j6 ^ Long.MIN_VALUE, j7 ^ Long.MIN_VALUE);
            if (compare > 0) {
                if (j7 == 512409557603043100L) {
                    j7 = kotlin.t0.a(-1L, k6);
                    compare3 = Long.compare(j6 ^ Long.MIN_VALUE, j7 ^ Long.MIN_VALUE);
                    if (compare3 > 0) {
                    }
                }
                return null;
            }
            long k7 = d1.k(j6 * k6);
            long k8 = d1.k(d1.k(z0.k(r13) & 4294967295L) + k7);
            compare2 = Long.compare(k8 ^ Long.MIN_VALUE, k7 ^ Long.MIN_VALUE);
            if (compare2 < 0) {
                return null;
            }
            i7++;
            j6 = k8;
        }
        return d1.b(j6);
    }

    @SinceKotlin(version = "1.5")
    public static final short q(@NotNull String str) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        j1 s5 = s(str);
        if (s5 != null) {
            return s5.o0();
        }
        f0.k1(str);
        throw new KotlinNothingValueException();
    }

    @SinceKotlin(version = "1.5")
    public static final short r(@NotNull String str, int i6) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        j1 t5 = t(str, i6);
        if (t5 != null) {
            return t5.o0();
        }
        f0.k1(str);
        throw new KotlinNothingValueException();
    }

    @SinceKotlin(version = "1.5")
    @Nullable
    public static final j1 s(@NotNull String str) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        return t(str, 10);
    }

    @SinceKotlin(version = "1.5")
    @Nullable
    public static final j1 t(@NotNull String str, int i6) {
        int compare;
        kotlin.jvm.internal.g0.p(str, "<this>");
        z0 l6 = l(str, i6);
        if (l6 == null) {
            return null;
        }
        int q02 = l6.q0();
        compare = Integer.compare(q02 ^ Integer.MIN_VALUE, z0.k(65535) ^ Integer.MIN_VALUE);
        if (compare > 0) {
            return null;
        }
        return j1.b(j1.k((short) q02));
    }

    @SinceKotlin(version = "1.5")
    @NotNull
    public static final String a(long j6, int i6) {
        return o1.t(j6, c.a(i6));
    }

    @SinceKotlin(version = "1.5")
    @NotNull
    public static final String c(int i6, int i7) {
        return o1.t(i6 & 4294967295L, c.a(i7));
    }

    @SinceKotlin(version = "1.5")
    @NotNull
    public static final String d(short s5, int i6) {
        String num = Integer.toString(s5 & j1.f43986d, c.a(i6));
        kotlin.jvm.internal.g0.o(num, "toString(...)");
        return num;
    }
}
