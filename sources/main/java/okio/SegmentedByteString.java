package okio;

import kotlin.jvm.JvmName;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.text.u;
import okio.Buffer;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JvmName(name = "-SegmentedByteString")
@SourceDebugExtension({"SMAP\nUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Util.kt\nokio/-SegmentedByteString\n*L\n1#1,185:1\n67#1:186\n73#1:187\n*S KotlinDebug\n*F\n+ 1 Util.kt\nokio/-SegmentedByteString\n*L\n105#1:186\n106#1:187\n*E\n"})
/* renamed from: okio.-SegmentedByteString, reason: invalid class name */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class SegmentedByteString {

    @NotNull
    private static final Buffer.UnsafeCursor DEFAULT__new_UnsafeCursor = new Buffer.UnsafeCursor();
    private static final int DEFAULT__ByteString_size = -1234567890;

    public static final int and(byte b6, int i6) {
        return b6 & i6;
    }

    public static final long minOf(long j6, int i6) {
        return Math.min(j6, i6);
    }

    @NotNull
    public static final Buffer.UnsafeCursor resolveDefaultParameter(@NotNull Buffer.UnsafeCursor unsafeCursor) {
        g0.p(unsafeCursor, "unsafeCursor");
        return unsafeCursor == DEFAULT__new_UnsafeCursor ? new Buffer.UnsafeCursor() : unsafeCursor;
    }

    public static final int reverseBytes(int i6) {
        return ((i6 & 255) << 24) | (((-16777216) & i6) >>> 24) | ((16711680 & i6) >>> 8) | ((65280 & i6) << 8);
    }

    public static final int shl(byte b6, int i6) {
        return b6 << i6;
    }

    public static final int shr(byte b6, int i6) {
        return b6 >> i6;
    }

    @NotNull
    public static final String toHexString(byte b6) {
        return u.J1(new char[]{okio.internal.ByteString.getHEX_DIGIT_CHARS()[(b6 >> 4) & 15], okio.internal.ByteString.getHEX_DIGIT_CHARS()[b6 & 15]});
    }

    public static final byte xor(byte b6, byte b7) {
        return (byte) (b6 ^ b7);
    }

    public static final long and(byte b6, long j6) {
        return j6 & b6;
    }

    public static final boolean arrayRangeEquals(@NotNull byte[] a6, int i6, @NotNull byte[] b6, int i7, int i8) {
        g0.p(a6, "a");
        g0.p(b6, "b");
        for (int i9 = 0; i9 < i8; i9++) {
            if (a6[i9 + i6] != b6[i9 + i7]) {
                return false;
            }
        }
        return true;
    }

    public static final void checkOffsetAndCount(long j6, long j7, long j8) {
        if ((j7 | j8) < 0 || j7 > j6 || j6 - j7 < j8) {
            throw new ArrayIndexOutOfBoundsException("size=" + j6 + " offset=" + j7 + " byteCount=" + j8);
        }
    }

    public static final int getDEFAULT__ByteString_size() {
        return DEFAULT__ByteString_size;
    }

    @NotNull
    public static final Buffer.UnsafeCursor getDEFAULT__new_UnsafeCursor() {
        return DEFAULT__new_UnsafeCursor;
    }

    public static final int leftRotate(int i6, int i7) {
        return (i6 >>> (32 - i7)) | (i6 << i7);
    }

    public static final long minOf(int i6, long j6) {
        return Math.min(i6, j6);
    }

    public static final int resolveDefaultParameter(@NotNull ByteString byteString, int i6) {
        g0.p(byteString, "<this>");
        return i6 == DEFAULT__ByteString_size ? byteString.size() : i6;
    }

    public static final long reverseBytes(long j6) {
        return ((j6 & 255) << 56) | (((-72057594037927936L) & j6) >>> 56) | ((71776119061217280L & j6) >>> 40) | ((280375465082880L & j6) >>> 24) | ((1095216660480L & j6) >>> 8) | ((4278190080L & j6) << 8) | ((16711680 & j6) << 24) | ((65280 & j6) << 40);
    }

    public static final long rightRotate(long j6, int i6) {
        return (j6 << (64 - i6)) | (j6 >>> i6);
    }

    public static final long and(int i6, long j6) {
        return j6 & i6;
    }

    public static final int resolveDefaultParameter(@NotNull byte[] bArr, int i6) {
        g0.p(bArr, "<this>");
        return i6 == DEFAULT__ByteString_size ? bArr.length : i6;
    }

    public static final short reverseBytes(short s5) {
        return (short) (((s5 & 255) << 8) | ((65280 & s5) >>> 8));
    }

    @NotNull
    public static final String toHexString(int i6) {
        if (i6 == 0) {
            return "0";
        }
        int i7 = 0;
        char[] cArr = {okio.internal.ByteString.getHEX_DIGIT_CHARS()[(i6 >> 28) & 15], okio.internal.ByteString.getHEX_DIGIT_CHARS()[(i6 >> 24) & 15], okio.internal.ByteString.getHEX_DIGIT_CHARS()[(i6 >> 20) & 15], okio.internal.ByteString.getHEX_DIGIT_CHARS()[(i6 >> 16) & 15], okio.internal.ByteString.getHEX_DIGIT_CHARS()[(i6 >> 12) & 15], okio.internal.ByteString.getHEX_DIGIT_CHARS()[(i6 >> 8) & 15], okio.internal.ByteString.getHEX_DIGIT_CHARS()[(i6 >> 4) & 15], okio.internal.ByteString.getHEX_DIGIT_CHARS()[i6 & 15]};
        while (i7 < 8 && cArr[i7] == '0') {
            i7++;
        }
        return u.K1(cArr, i7, 8);
    }

    @NotNull
    public static final String toHexString(long j6) {
        if (j6 == 0) {
            return "0";
        }
        int i6 = 0;
        char[] cArr = {okio.internal.ByteString.getHEX_DIGIT_CHARS()[(int) ((j6 >> 60) & 15)], okio.internal.ByteString.getHEX_DIGIT_CHARS()[(int) ((j6 >> 56) & 15)], okio.internal.ByteString.getHEX_DIGIT_CHARS()[(int) ((j6 >> 52) & 15)], okio.internal.ByteString.getHEX_DIGIT_CHARS()[(int) ((j6 >> 48) & 15)], okio.internal.ByteString.getHEX_DIGIT_CHARS()[(int) ((j6 >> 44) & 15)], okio.internal.ByteString.getHEX_DIGIT_CHARS()[(int) ((j6 >> 40) & 15)], okio.internal.ByteString.getHEX_DIGIT_CHARS()[(int) ((j6 >> 36) & 15)], okio.internal.ByteString.getHEX_DIGIT_CHARS()[(int) ((j6 >> 32) & 15)], okio.internal.ByteString.getHEX_DIGIT_CHARS()[(int) ((j6 >> 28) & 15)], okio.internal.ByteString.getHEX_DIGIT_CHARS()[(int) ((j6 >> 24) & 15)], okio.internal.ByteString.getHEX_DIGIT_CHARS()[(int) ((j6 >> 20) & 15)], okio.internal.ByteString.getHEX_DIGIT_CHARS()[(int) ((j6 >> 16) & 15)], okio.internal.ByteString.getHEX_DIGIT_CHARS()[(int) ((j6 >> 12) & 15)], okio.internal.ByteString.getHEX_DIGIT_CHARS()[(int) ((j6 >> 8) & 15)], okio.internal.ByteString.getHEX_DIGIT_CHARS()[(int) ((j6 >> 4) & 15)], okio.internal.ByteString.getHEX_DIGIT_CHARS()[(int) (j6 & 15)]};
        while (i6 < 16 && cArr[i6] == '0') {
            i6++;
        }
        return u.K1(cArr, i6, 16);
    }
}
