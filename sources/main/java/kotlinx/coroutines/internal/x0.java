package kotlinx.coroutines.internal;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final /* synthetic */ class x0 {
    public static final int a(@NotNull String str, int i6, int i7, int i8) {
        return (int) v0.c(str, i6, i7, i8);
    }

    public static /* synthetic */ int e(String str, int i6, int i7, int i8, int i9, Object obj) {
        if ((i9 & 4) != 0) {
            i7 = 1;
        }
        if ((i9 & 8) != 0) {
            i8 = Integer.MAX_VALUE;
        }
        return v0.b(str, i6, i7, i8);
    }

    public static /* synthetic */ long f(String str, long j6, long j7, long j8, int i6, Object obj) {
        if ((i6 & 4) != 0) {
            j7 = 1;
        }
        long j9 = j7;
        if ((i6 & 8) != 0) {
            j8 = Long.MAX_VALUE;
        }
        return v0.c(str, j6, j9, j8);
    }

    public static final long b(@NotNull String str, long j6, long j7, long j8) {
        String d6 = v0.d(str);
        if (d6 == null) {
            return j6;
        }
        Long p12 = kotlin.text.u.p1(d6);
        if (p12 != null) {
            long longValue = p12.longValue();
            if (j7 <= longValue && longValue <= j8) {
                return longValue;
            }
            throw new IllegalStateException(("System property '" + str + "' should be in range " + j7 + ".." + j8 + ", but is '" + longValue + '\'').toString());
        }
        throw new IllegalStateException(("System property '" + str + "' has unrecognized value '" + d6 + '\'').toString());
    }

    @NotNull
    public static final String c(@NotNull String str, @NotNull String str2) {
        String d6 = v0.d(str);
        if (d6 == null) {
            return str2;
        }
        return d6;
    }

    public static final boolean d(@NotNull String str, boolean z5) {
        String d6 = v0.d(str);
        if (d6 != null) {
            return Boolean.parseBoolean(d6);
        }
        return z5;
    }
}
