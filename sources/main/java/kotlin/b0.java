package kotlin;

import com.daimajia.numberprogressbar.BuildConfig;
import kotlin.internal.InlineOnly;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
class b0 extends a0 {
    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final int T0(byte b6) {
        return Integer.numberOfLeadingZeros(b6 & 255) - 24;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final int V0(byte b6) {
        return Integer.bitCount(b6 & 255);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final int X0(byte b6) {
        return Integer.numberOfTrailingZeros(b6 | 256);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final int Y0(short s5) {
        return Integer.numberOfTrailingZeros(s5 | 65536);
    }

    @SinceKotlin(version = cn.bluemobi.dylan.photoview.a.f1297f)
    public static final byte Z0(byte b6, int i6) {
        int i7 = i6 & 7;
        return (byte) (((b6 & 255) >>> (8 - i7)) | (b6 << i7));
    }

    @SinceKotlin(version = cn.bluemobi.dylan.photoview.a.f1297f)
    public static final short a1(short s5, int i6) {
        int i7 = i6 & 15;
        return (short) (((s5 & 65535) >>> (16 - i7)) | (s5 << i7));
    }

    @SinceKotlin(version = cn.bluemobi.dylan.photoview.a.f1297f)
    public static final byte b1(byte b6, int i6) {
        int i7 = i6 & 7;
        return (byte) (((b6 & 255) >>> i7) | (b6 << (8 - i7)));
    }

    @SinceKotlin(version = cn.bluemobi.dylan.photoview.a.f1297f)
    public static final short c1(short s5, int i6) {
        int i7 = i6 & 15;
        return (short) (((s5 & 65535) >>> i7) | (s5 << (16 - i7)));
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final byte d1(byte b6) {
        return (byte) Integer.highestOneBit(b6 & 255);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final int U0(short s5) {
        return Integer.numberOfLeadingZeros(s5 & j1.f43986d) - 16;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final int W0(short s5) {
        return Integer.bitCount(s5 & j1.f43986d);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final short e1(short s5) {
        return (short) Integer.highestOneBit(s5 & j1.f43986d);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final byte f1(byte b6) {
        return (byte) Integer.lowestOneBit(b6);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final short g1(short s5) {
        return (short) Integer.lowestOneBit(s5);
    }
}
