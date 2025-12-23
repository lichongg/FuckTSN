package kotlin.collections;

import kotlin.ExperimentalUnsignedTypes;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class c2 {
    /* JADX WARN: Incorrect condition in loop: B:4:0x0012 */
    /* JADX WARN: Incorrect condition in loop: B:8:0x001f */
    @kotlin.ExperimentalUnsignedTypes
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final int a(long[] r6, int r7, int r8) {
        /*
            int r0 = r7 + r8
            int r0 = r0 / 2
            long r0 = kotlin.e1.p(r6, r0)
        L8:
            if (r7 > r8) goto L39
        La:
            long r2 = kotlin.e1.p(r6, r7)
            int r2 = androidx.collection.a.a(r2, r0)
            if (r2 >= 0) goto L17
            int r7 = r7 + 1
            goto La
        L17:
            long r2 = kotlin.e1.p(r6, r8)
            int r2 = androidx.collection.a.a(r2, r0)
            if (r2 <= 0) goto L24
            int r8 = r8 + (-1)
            goto L17
        L24:
            if (r7 > r8) goto L8
            long r2 = kotlin.e1.p(r6, r7)
            long r4 = kotlin.e1.p(r6, r8)
            kotlin.e1.x(r6, r7, r4)
            kotlin.e1.x(r6, r8, r2)
            int r7 = r7 + 1
            int r8 = r8 + (-1)
            goto L8
        L39:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.c2.a(long[], int, int):int");
    }

    @ExperimentalUnsignedTypes
    private static final int b(byte[] bArr, int i6, int i7) {
        int i8;
        byte p5 = kotlin.w0.p(bArr, (i6 + i7) / 2);
        while (i6 <= i7) {
            while (true) {
                i8 = p5 & 255;
                if (kotlin.jvm.internal.g0.t(kotlin.w0.p(bArr, i6) & 255, i8) >= 0) {
                    break;
                }
                i6++;
            }
            while (kotlin.jvm.internal.g0.t(kotlin.w0.p(bArr, i7) & 255, i8) > 0) {
                i7--;
            }
            if (i6 <= i7) {
                byte p6 = kotlin.w0.p(bArr, i6);
                kotlin.w0.x(bArr, i6, kotlin.w0.p(bArr, i7));
                kotlin.w0.x(bArr, i7, p6);
                i6++;
                i7--;
            }
        }
        return i6;
    }

    @ExperimentalUnsignedTypes
    private static final int c(short[] sArr, int i6, int i7) {
        int i8;
        short p5 = kotlin.k1.p(sArr, (i6 + i7) / 2);
        while (i6 <= i7) {
            while (true) {
                int p6 = kotlin.k1.p(sArr, i6) & kotlin.j1.f43986d;
                i8 = p5 & kotlin.j1.f43986d;
                if (kotlin.jvm.internal.g0.t(p6, i8) >= 0) {
                    break;
                }
                i6++;
            }
            while (kotlin.jvm.internal.g0.t(kotlin.k1.p(sArr, i7) & kotlin.j1.f43986d, i8) > 0) {
                i7--;
            }
            if (i6 <= i7) {
                short p7 = kotlin.k1.p(sArr, i6);
                kotlin.k1.x(sArr, i6, kotlin.k1.p(sArr, i7));
                kotlin.k1.x(sArr, i7, p7);
                i6++;
                i7--;
            }
        }
        return i6;
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x0012 */
    /* JADX WARN: Incorrect condition in loop: B:8:0x001f */
    @kotlin.ExperimentalUnsignedTypes
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final int d(int[] r3, int r4, int r5) {
        /*
            int r0 = r4 + r5
            int r0 = r0 / 2
            int r0 = kotlin.a1.p(r3, r0)
        L8:
            if (r4 > r5) goto L39
        La:
            int r1 = kotlin.a1.p(r3, r4)
            int r1 = kotlin.u0.a(r1, r0)
            if (r1 >= 0) goto L17
            int r4 = r4 + 1
            goto La
        L17:
            int r1 = kotlin.a1.p(r3, r5)
            int r1 = kotlin.u0.a(r1, r0)
            if (r1 <= 0) goto L24
            int r5 = r5 + (-1)
            goto L17
        L24:
            if (r4 > r5) goto L8
            int r1 = kotlin.a1.p(r3, r4)
            int r2 = kotlin.a1.p(r3, r5)
            kotlin.a1.x(r3, r4, r2)
            kotlin.a1.x(r3, r5, r1)
            int r4 = r4 + 1
            int r5 = r5 + (-1)
            goto L8
        L39:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.c2.d(int[], int, int):int");
    }

    @ExperimentalUnsignedTypes
    public static final void i(@NotNull long[] jArr, int i6, int i7) {
        kotlin.jvm.internal.g0.p(jArr, "$v$c$kotlin-ULongArray$-array$0");
        e(jArr, i6, i7 - 1);
    }

    @ExperimentalUnsignedTypes
    public static final void j(@NotNull byte[] bArr, int i6, int i7) {
        kotlin.jvm.internal.g0.p(bArr, "$v$c$kotlin-UByteArray$-array$0");
        f(bArr, i6, i7 - 1);
    }

    @ExperimentalUnsignedTypes
    public static final void k(@NotNull short[] sArr, int i6, int i7) {
        kotlin.jvm.internal.g0.p(sArr, "$v$c$kotlin-UShortArray$-array$0");
        g(sArr, i6, i7 - 1);
    }

    @ExperimentalUnsignedTypes
    public static final void l(@NotNull int[] iArr, int i6, int i7) {
        kotlin.jvm.internal.g0.p(iArr, "$v$c$kotlin-UIntArray$-array$0");
        h(iArr, i6, i7 - 1);
    }

    @ExperimentalUnsignedTypes
    private static final void e(long[] jArr, int i6, int i7) {
        int a6 = a(jArr, i6, i7);
        int i8 = a6 - 1;
        if (i6 < i8) {
            e(jArr, i6, i8);
        }
        if (a6 < i7) {
            e(jArr, a6, i7);
        }
    }

    @ExperimentalUnsignedTypes
    private static final void f(byte[] bArr, int i6, int i7) {
        int b6 = b(bArr, i6, i7);
        int i8 = b6 - 1;
        if (i6 < i8) {
            f(bArr, i6, i8);
        }
        if (b6 < i7) {
            f(bArr, b6, i7);
        }
    }

    @ExperimentalUnsignedTypes
    private static final void g(short[] sArr, int i6, int i7) {
        int c6 = c(sArr, i6, i7);
        int i8 = c6 - 1;
        if (i6 < i8) {
            g(sArr, i6, i8);
        }
        if (c6 < i7) {
            g(sArr, c6, i7);
        }
    }

    @ExperimentalUnsignedTypes
    private static final void h(int[] iArr, int i6, int i7) {
        int d6 = d(iArr, i6, i7);
        int i8 = d6 - 1;
        if (i6 < i8) {
            h(iArr, i6, i8);
        }
        if (d6 < i7) {
            h(iArr, d6, i7);
        }
    }
}
