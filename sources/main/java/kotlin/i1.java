package kotlin;

import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JvmName(name = "UNumbersKt")
/* loaded from: D:\Downloads\app\classes8.dex */
public final class i1 {
    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final int a(byte b6) {
        return Integer.numberOfLeadingZeros(b6 & 255) - 24;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final int e(byte b6) {
        return Integer.bitCount(z0.k(b6 & 255));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final int i(byte b6) {
        return Integer.numberOfTrailingZeros(b6 | 256);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final int l(short s5) {
        return Integer.numberOfTrailingZeros(s5 | 65536);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final byte u(byte b6) {
        return v0.k((byte) Integer.highestOneBit(b6 & 255));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final byte y(byte b6) {
        return v0.k((byte) Integer.lowestOneBit(b6 & 255));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final int A(int i6) {
        return z0.k(Integer.lowestOneBit(i6));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final short B(short s5) {
        return j1.k((short) Integer.lowestOneBit(s5 & j1.f43986d));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final int b(long j6) {
        return Long.numberOfLeadingZeros(j6);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final int c(int i6) {
        return Integer.numberOfLeadingZeros(i6);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final int d(short s5) {
        return Integer.numberOfLeadingZeros(s5 & j1.f43986d) - 16;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final int f(long j6) {
        return Long.bitCount(j6);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final int g(int i6) {
        return Integer.bitCount(i6);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final int h(short s5) {
        return Integer.bitCount(z0.k(s5 & j1.f43986d));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final int j(long j6) {
        return Long.numberOfTrailingZeros(j6);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final int k(int i6) {
        return Integer.numberOfTrailingZeros(i6);
    }

    @SinceKotlin(version = cn.bluemobi.dylan.photoview.a.f1297f)
    @InlineOnly
    private static final long m(long j6, int i6) {
        return d1.k(Long.rotateLeft(j6, i6));
    }

    @SinceKotlin(version = cn.bluemobi.dylan.photoview.a.f1297f)
    @InlineOnly
    private static final byte n(byte b6, int i6) {
        return v0.k(b0.Z0(b6, i6));
    }

    @SinceKotlin(version = cn.bluemobi.dylan.photoview.a.f1297f)
    @InlineOnly
    private static final int o(int i6, int i7) {
        return z0.k(Integer.rotateLeft(i6, i7));
    }

    @SinceKotlin(version = cn.bluemobi.dylan.photoview.a.f1297f)
    @InlineOnly
    private static final short p(short s5, int i6) {
        return j1.k(b0.a1(s5, i6));
    }

    @SinceKotlin(version = cn.bluemobi.dylan.photoview.a.f1297f)
    @InlineOnly
    private static final long q(long j6, int i6) {
        return d1.k(Long.rotateRight(j6, i6));
    }

    @SinceKotlin(version = cn.bluemobi.dylan.photoview.a.f1297f)
    @InlineOnly
    private static final byte r(byte b6, int i6) {
        return v0.k(b0.b1(b6, i6));
    }

    @SinceKotlin(version = cn.bluemobi.dylan.photoview.a.f1297f)
    @InlineOnly
    private static final int s(int i6, int i7) {
        return z0.k(Integer.rotateRight(i6, i7));
    }

    @SinceKotlin(version = cn.bluemobi.dylan.photoview.a.f1297f)
    @InlineOnly
    private static final short t(short s5, int i6) {
        return j1.k(b0.c1(s5, i6));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final long v(long j6) {
        return d1.k(Long.highestOneBit(j6));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final int w(int i6) {
        return z0.k(Integer.highestOneBit(i6));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final short x(short s5) {
        return j1.k((short) Integer.highestOneBit(s5 & j1.f43986d));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final long z(long j6) {
        return d1.k(Long.lowestOneBit(j6));
    }
}
