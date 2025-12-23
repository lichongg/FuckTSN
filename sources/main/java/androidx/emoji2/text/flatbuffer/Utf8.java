package androidx.emoji2.text.flatbuffer;

import com.google.common.base.Ascii;
import java.nio.ByteBuffer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public abstract class Utf8 {
    private static Utf8 DEFAULT;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class DecodeUtil {
        static void handleOneByte(byte b6, char[] cArr, int i6) {
            cArr[i6] = (char) b6;
        }

        static void handleTwoBytes(byte b6, byte b7, char[] cArr, int i6) throws IllegalArgumentException {
            if (b6 < -62) {
                throw new IllegalArgumentException("Invalid UTF-8: Illegal leading byte in 2 bytes utf");
            }
            if (isNotTrailingByte(b7)) {
                throw new IllegalArgumentException("Invalid UTF-8: Illegal trailing byte in 2 bytes utf");
            }
            cArr[i6] = (char) (((b6 & Ascii.US) << 6) | trailingByteValue(b7));
        }

        private static char highSurrogate(int i6) {
            return (char) ((i6 >>> 10) + okio.Utf8.HIGH_SURROGATE_HEADER);
        }

        private static boolean isNotTrailingByte(byte b6) {
            return b6 > -65;
        }

        static boolean isOneByte(byte b6) {
            return b6 >= 0;
        }

        static boolean isThreeBytes(byte b6) {
            return b6 < -16;
        }

        static boolean isTwoBytes(byte b6) {
            return b6 < -32;
        }

        private static char lowSurrogate(int i6) {
            return (char) ((i6 & 1023) + okio.Utf8.LOG_SURROGATE_HEADER);
        }

        private static int trailingByteValue(byte b6) {
            return b6 & okio.Utf8.REPLACEMENT_BYTE;
        }

        DecodeUtil() {
        }

        static void handleFourBytes(byte b6, byte b7, byte b8, byte b9, char[] cArr, int i6) throws IllegalArgumentException {
            if (!isNotTrailingByte(b7) && (((b6 << 28) + (b7 + 112)) >> 30) == 0 && !isNotTrailingByte(b8) && !isNotTrailingByte(b9)) {
                int trailingByteValue = ((b6 & 7) << 18) | (trailingByteValue(b7) << 12) | (trailingByteValue(b8) << 6) | trailingByteValue(b9);
                cArr[i6] = highSurrogate(trailingByteValue);
                cArr[i6 + 1] = lowSurrogate(trailingByteValue);
                return;
            }
            throw new IllegalArgumentException("Invalid UTF-8");
        }

        static void handleThreeBytes(byte b6, byte b7, byte b8, char[] cArr, int i6) throws IllegalArgumentException {
            if (!isNotTrailingByte(b7) && ((b6 != -32 || b7 >= -96) && ((b6 != -19 || b7 < -96) && !isNotTrailingByte(b8)))) {
                cArr[i6] = (char) (((b6 & 15) << 12) | (trailingByteValue(b7) << 6) | trailingByteValue(b8));
                return;
            }
            throw new IllegalArgumentException("Invalid UTF-8");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class UnpairedSurrogateException extends IllegalArgumentException {
        UnpairedSurrogateException(int i6, int i7) {
            super("Unpaired surrogate at index " + i6 + " of " + i7);
        }
    }

    public abstract String decodeUtf8(ByteBuffer byteBuffer, int i6, int i7);

    public abstract void encodeUtf8(CharSequence charSequence, ByteBuffer byteBuffer);

    public abstract int encodedLength(CharSequence charSequence);

    public static Utf8 getDefault() {
        if (DEFAULT == null) {
            DEFAULT = new Utf8Safe();
        }
        return DEFAULT;
    }

    public static void setDefault(Utf8 utf8) {
        DEFAULT = utf8;
    }
}
