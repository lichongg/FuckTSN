package kotlin;

import com.daimajia.numberprogressbar.BuildConfig;
import kotlin.internal.InlineOnly;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
class a0 extends z {
    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float A0(kotlin.jvm.internal.z zVar, int i6) {
        kotlin.jvm.internal.g0.p(zVar, "<this>");
        return Float.intBitsToFloat(i6);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double z0(kotlin.jvm.internal.w wVar, long j6) {
        kotlin.jvm.internal.g0.p(wVar, "<this>");
        return Double.longBitsToDouble(j6);
    }

    @InlineOnly
    private static final boolean B0(double d6) {
        if (Math.abs(d6) <= Double.MAX_VALUE) {
            return true;
        }
        return false;
    }

    @InlineOnly
    private static final boolean C0(float f6) {
        if (Math.abs(f6) <= Float.MAX_VALUE) {
            return true;
        }
        return false;
    }

    @InlineOnly
    private static final boolean D0(double d6) {
        return Double.isInfinite(d6);
    }

    @InlineOnly
    private static final boolean E0(float f6) {
        return Float.isInfinite(f6);
    }

    @InlineOnly
    private static final boolean F0(double d6) {
        return Double.isNaN(d6);
    }

    @InlineOnly
    private static final boolean G0(float f6) {
        return Float.isNaN(f6);
    }

    @SinceKotlin(version = cn.bluemobi.dylan.photoview.a.f1297f)
    @InlineOnly
    private static final int H0(int i6, int i7) {
        return Integer.rotateLeft(i6, i7);
    }

    @SinceKotlin(version = cn.bluemobi.dylan.photoview.a.f1297f)
    @InlineOnly
    private static final long I0(long j6, int i6) {
        return Long.rotateLeft(j6, i6);
    }

    @SinceKotlin(version = cn.bluemobi.dylan.photoview.a.f1297f)
    @InlineOnly
    private static final int J0(int i6, int i7) {
        return Integer.rotateRight(i6, i7);
    }

    @SinceKotlin(version = cn.bluemobi.dylan.photoview.a.f1297f)
    @InlineOnly
    private static final long K0(long j6, int i6) {
        return Long.rotateRight(j6, i6);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final int L0(int i6) {
        return Integer.highestOneBit(i6);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final long M0(long j6) {
        return Long.highestOneBit(j6);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final int N0(int i6) {
        return Integer.lowestOneBit(i6);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final long O0(long j6) {
        return Long.lowestOneBit(j6);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final int P0(float f6) {
        return Float.floatToIntBits(f6);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final long Q0(double d6) {
        return Double.doubleToLongBits(d6);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final int R0(float f6) {
        return Float.floatToRawIntBits(f6);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final long S0(double d6) {
        return Double.doubleToRawLongBits(d6);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final int t0(int i6) {
        return Integer.numberOfLeadingZeros(i6);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final int u0(long j6) {
        return Long.numberOfLeadingZeros(j6);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final int v0(int i6) {
        return Integer.bitCount(i6);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final int w0(long j6) {
        return Long.bitCount(j6);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final int x0(int i6) {
        return Integer.numberOfTrailingZeros(i6);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final int y0(long j6) {
        return Long.numberOfTrailingZeros(j6);
    }
}
