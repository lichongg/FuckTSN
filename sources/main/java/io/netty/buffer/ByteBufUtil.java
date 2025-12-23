package io.netty.buffer;

import androidx.core.view.ViewCompat;
import io.netty.util.AsciiString;
import io.netty.util.ByteProcessor;
import io.netty.util.CharsetUtil;
import io.netty.util.Recycler;
import io.netty.util.concurrent.FastThreadLocal;
import io.netty.util.internal.MathUtil;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;
import java.util.Arrays;
import java.util.Locale;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class ByteBufUtil {
    private static final FastThreadLocal<byte[]> BYTE_ARRAYS;
    static final ByteBufAllocator DEFAULT_ALLOCATOR;
    private static final ByteProcessor FIND_NON_ASCII;
    private static final int MAX_BYTES_PER_CHAR_UTF8;
    private static final int MAX_CHAR_BUFFER_SIZE;
    static final int MAX_TL_ARRAY_LEN = 1024;
    private static final int THREAD_LOCAL_BUFFER_SIZE;
    static final int WRITE_CHUNK_SIZE = 8192;
    private static final byte WRITE_UTF_UNKNOWN = 63;
    private static final InternalLogger logger;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class HexUtil {
        private static final char[] BYTE2CHAR = new char[256];
        private static final char[] HEXDUMP_TABLE = new char[1024];
        private static final String[] HEXPADDING = new String[16];
        private static final String[] HEXDUMP_ROWPREFIXES = new String[4096];
        private static final String[] BYTE2HEX = new String[256];
        private static final String[] BYTEPADDING = new String[16];

        /* JADX INFO: Access modifiers changed from: private */
        public static String hexDump(ByteBuf byteBuf, int i6, int i7) {
            ObjectUtil.checkPositiveOrZero(i7, "length");
            if (i7 == 0) {
                return "";
            }
            int i8 = i6 + i7;
            char[] cArr = new char[i7 << 1];
            int i9 = 0;
            while (i6 < i8) {
                System.arraycopy(HEXDUMP_TABLE, byteBuf.getUnsignedByte(i6) << 1, cArr, i9, 2);
                i6++;
                i9 += 2;
            }
            return new String(cArr);
        }

        static {
            char[] charArray = "0123456789abcdef".toCharArray();
            int i6 = 0;
            for (int i7 = 0; i7 < 256; i7++) {
                char[] cArr = HEXDUMP_TABLE;
                int i8 = i7 << 1;
                cArr[i8] = charArray[(i7 >>> 4) & 15];
                cArr[i8 + 1] = charArray[i7 & 15];
            }
            int i9 = 0;
            while (true) {
                String[] strArr = HEXPADDING;
                if (i9 >= strArr.length) {
                    break;
                }
                int length = strArr.length - i9;
                StringBuilder sb = new StringBuilder(length * 3);
                for (int i10 = 0; i10 < length; i10++) {
                    sb.append("   ");
                }
                HEXPADDING[i9] = sb.toString();
                i9++;
            }
            int i11 = 0;
            while (true) {
                String[] strArr2 = HEXDUMP_ROWPREFIXES;
                if (i11 >= strArr2.length) {
                    break;
                }
                StringBuilder sb2 = new StringBuilder(12);
                sb2.append(StringUtil.NEWLINE);
                sb2.append(Long.toHexString(((i11 << 4) & 4294967295L) | IjkMediaMeta.AV_CH_WIDE_RIGHT));
                sb2.setCharAt(sb2.length() - 9, '|');
                sb2.append('|');
                strArr2[i11] = sb2.toString();
                i11++;
            }
            int i12 = 0;
            while (true) {
                String[] strArr3 = BYTE2HEX;
                if (i12 >= strArr3.length) {
                    break;
                }
                strArr3[i12] = ' ' + StringUtil.byteToHexStringPadded(i12);
                i12++;
            }
            int i13 = 0;
            while (true) {
                String[] strArr4 = BYTEPADDING;
                if (i13 >= strArr4.length) {
                    break;
                }
                int length2 = strArr4.length - i13;
                StringBuilder sb3 = new StringBuilder(length2);
                for (int i14 = 0; i14 < length2; i14++) {
                    sb3.append(' ');
                }
                BYTEPADDING[i13] = sb3.toString();
                i13++;
            }
            while (true) {
                char[] cArr2 = BYTE2CHAR;
                if (i6 >= cArr2.length) {
                    return;
                }
                if (i6 <= 31 || i6 >= 127) {
                    cArr2[i6] = '.';
                } else {
                    cArr2[i6] = (char) i6;
                }
                i6++;
            }
        }

        private static void appendHexDumpRowPrefix(StringBuilder sb, int i6, int i7) {
            String[] strArr = HEXDUMP_ROWPREFIXES;
            if (i6 < strArr.length) {
                sb.append(strArr[i6]);
                return;
            }
            sb.append(StringUtil.NEWLINE);
            sb.append(Long.toHexString((i7 & 4294967295L) | IjkMediaMeta.AV_CH_WIDE_RIGHT));
            sb.setCharAt(sb.length() - 9, '|');
            sb.append('|');
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static String prettyHexDump(ByteBuf byteBuf, int i6, int i7) {
            if (i7 == 0) {
                return "";
            }
            StringBuilder sb = new StringBuilder(((i7 / 16) + ((i7 & 15) == 0 ? 0 : 1) + 4) * 80);
            appendPrettyHexDump(sb, byteBuf, i6, i7);
            return sb.toString();
        }

        private HexUtil() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void appendPrettyHexDump(StringBuilder sb, ByteBuf byteBuf, int i6, int i7) {
            if (!MathUtil.isOutOfBounds(i6, i7, byteBuf.capacity())) {
                if (i7 == 0) {
                    return;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("         +-------------------------------------------------+");
                String str = StringUtil.NEWLINE;
                sb2.append(str);
                sb2.append("         |  0  1  2  3  4  5  6  7  8  9  a  b  c  d  e  f |");
                sb2.append(str);
                sb2.append("+--------+-------------------------------------------------+----------------+");
                sb.append(sb2.toString());
                int i8 = i7 >>> 4;
                int i9 = i7 & 15;
                for (int i10 = 0; i10 < i8; i10++) {
                    int i11 = (i10 << 4) + i6;
                    appendHexDumpRowPrefix(sb, i10, i11);
                    int i12 = i11 + 16;
                    for (int i13 = i11; i13 < i12; i13++) {
                        sb.append(BYTE2HEX[byteBuf.getUnsignedByte(i13)]);
                    }
                    sb.append(" |");
                    while (i11 < i12) {
                        sb.append(BYTE2CHAR[byteBuf.getUnsignedByte(i11)]);
                        i11++;
                    }
                    sb.append('|');
                }
                if (i9 != 0) {
                    int i14 = (i8 << 4) + i6;
                    appendHexDumpRowPrefix(sb, i8, i14);
                    int i15 = i14 + i9;
                    for (int i16 = i14; i16 < i15; i16++) {
                        sb.append(BYTE2HEX[byteBuf.getUnsignedByte(i16)]);
                    }
                    sb.append(HEXPADDING[i9]);
                    sb.append(" |");
                    while (i14 < i15) {
                        sb.append(BYTE2CHAR[byteBuf.getUnsignedByte(i14)]);
                        i14++;
                    }
                    sb.append(BYTEPADDING[i9]);
                    sb.append('|');
                }
                sb.append(StringUtil.NEWLINE + "+--------+-------------------------------------------------+----------------+");
                return;
            }
            throw new IndexOutOfBoundsException("expected: 0 <= offset(" + i6 + ") <= offset + length(" + i7 + ") <= buf.capacity(" + byteBuf.capacity() + ')');
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static String hexDump(byte[] bArr, int i6, int i7) {
            ObjectUtil.checkPositiveOrZero(i7, "length");
            if (i7 == 0) {
                return "";
            }
            int i8 = i6 + i7;
            char[] cArr = new char[i7 << 1];
            int i9 = 0;
            while (i6 < i8) {
                System.arraycopy(HEXDUMP_TABLE, (bArr[i6] & 255) << 1, cArr, i9, 2);
                i6++;
                i9 += 2;
            }
            return new String(cArr);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class ThreadLocalDirectByteBuf extends UnpooledDirectByteBuf {
        private static final Recycler<ThreadLocalDirectByteBuf> RECYCLER = new Recycler<ThreadLocalDirectByteBuf>() { // from class: io.netty.buffer.ByteBufUtil.ThreadLocalDirectByteBuf.1
            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // io.netty.util.Recycler
            public ThreadLocalDirectByteBuf newObject(Recycler.Handle<ThreadLocalDirectByteBuf> handle) {
                return new ThreadLocalDirectByteBuf(handle);
            }
        };
        private final Recycler.Handle<ThreadLocalDirectByteBuf> handle;

        private ThreadLocalDirectByteBuf(Recycler.Handle<ThreadLocalDirectByteBuf> handle) {
            super(UnpooledByteBufAllocator.DEFAULT, 256, Integer.MAX_VALUE);
            this.handle = handle;
        }

        static ThreadLocalDirectByteBuf newInstance() {
            ThreadLocalDirectByteBuf threadLocalDirectByteBuf = RECYCLER.get();
            threadLocalDirectByteBuf.resetRefCnt();
            return threadLocalDirectByteBuf;
        }

        @Override // io.netty.buffer.UnpooledDirectByteBuf, io.netty.buffer.AbstractReferenceCountedByteBuf
        protected void deallocate() {
            if (capacity() > ByteBufUtil.THREAD_LOCAL_BUFFER_SIZE) {
                super.deallocate();
            } else {
                clear();
                this.handle.recycle(this);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class ThreadLocalUnsafeDirectByteBuf extends UnpooledUnsafeDirectByteBuf {
        private static final Recycler<ThreadLocalUnsafeDirectByteBuf> RECYCLER = new Recycler<ThreadLocalUnsafeDirectByteBuf>() { // from class: io.netty.buffer.ByteBufUtil.ThreadLocalUnsafeDirectByteBuf.1
            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // io.netty.util.Recycler
            public ThreadLocalUnsafeDirectByteBuf newObject(Recycler.Handle<ThreadLocalUnsafeDirectByteBuf> handle) {
                return new ThreadLocalUnsafeDirectByteBuf(handle);
            }
        };
        private final Recycler.Handle<ThreadLocalUnsafeDirectByteBuf> handle;

        private ThreadLocalUnsafeDirectByteBuf(Recycler.Handle<ThreadLocalUnsafeDirectByteBuf> handle) {
            super(UnpooledByteBufAllocator.DEFAULT, 256, Integer.MAX_VALUE);
            this.handle = handle;
        }

        static ThreadLocalUnsafeDirectByteBuf newInstance() {
            ThreadLocalUnsafeDirectByteBuf threadLocalUnsafeDirectByteBuf = RECYCLER.get();
            threadLocalUnsafeDirectByteBuf.resetRefCnt();
            return threadLocalUnsafeDirectByteBuf;
        }

        @Override // io.netty.buffer.UnpooledDirectByteBuf, io.netty.buffer.AbstractReferenceCountedByteBuf
        protected void deallocate() {
            if (capacity() > ByteBufUtil.THREAD_LOCAL_BUFFER_SIZE) {
                super.deallocate();
            } else {
                clear();
                this.handle.recycle(this);
            }
        }
    }

    public static void appendPrettyHexDump(StringBuilder sb, ByteBuf byteBuf) {
        appendPrettyHexDump(sb, byteBuf, byteBuf.readerIndex(), byteBuf.readableBytes());
    }

    private static long compareUintBigEndian(ByteBuf byteBuf, ByteBuf byteBuf2, int i6, int i7, int i8) {
        int i9 = i8 + i6;
        while (i6 < i9) {
            long unsignedInt = byteBuf.getUnsignedInt(i6) - byteBuf2.getUnsignedInt(i7);
            if (unsignedInt != 0) {
                return unsignedInt;
            }
            i6 += 4;
            i7 += 4;
        }
        return 0L;
    }

    private static long compareUintBigEndianA(ByteBuf byteBuf, ByteBuf byteBuf2, int i6, int i7, int i8) {
        int i9 = i8 + i6;
        while (i6 < i9) {
            long unsignedInt = byteBuf.getUnsignedInt(i6) - byteBuf2.getUnsignedIntLE(i7);
            if (unsignedInt != 0) {
                return unsignedInt;
            }
            i6 += 4;
            i7 += 4;
        }
        return 0L;
    }

    private static long compareUintBigEndianB(ByteBuf byteBuf, ByteBuf byteBuf2, int i6, int i7, int i8) {
        int i9 = i8 + i6;
        while (i6 < i9) {
            long unsignedIntLE = byteBuf.getUnsignedIntLE(i6) - byteBuf2.getUnsignedInt(i7);
            if (unsignedIntLE != 0) {
                return unsignedIntLE;
            }
            i6 += 4;
            i7 += 4;
        }
        return 0L;
    }

    private static long compareUintLittleEndian(ByteBuf byteBuf, ByteBuf byteBuf2, int i6, int i7, int i8) {
        int i9 = i8 + i6;
        while (i6 < i9) {
            long unsignedIntLE = byteBuf.getUnsignedIntLE(i6) - byteBuf2.getUnsignedIntLE(i7);
            if (unsignedIntLE != 0) {
                return unsignedIntLE;
            }
            i6 += 4;
            i7 += 4;
        }
        return 0L;
    }

    public static void copy(AsciiString asciiString, ByteBuf byteBuf) {
        copy(asciiString, 0, byteBuf, asciiString.length());
    }

    public static byte[] decodeHexDump(CharSequence charSequence) {
        return StringUtil.decodeHexDump(charSequence, 0, charSequence.length());
    }

    public static ByteBuf encodeString(ByteBufAllocator byteBufAllocator, CharBuffer charBuffer, Charset charset) {
        return encodeString0(byteBufAllocator, false, charBuffer, charset, 0);
    }

    public static boolean equals(ByteBuf byteBuf, int i6, ByteBuf byteBuf2, int i7, int i8) {
        if (i6 < 0 || i7 < 0 || i8 < 0) {
            throw new IllegalArgumentException("All indexes and lengths must be non-negative");
        }
        if (byteBuf.writerIndex() - i8 < i6 || byteBuf2.writerIndex() - i8 < i7) {
            return false;
        }
        int i9 = i8 >>> 3;
        if (byteBuf.order() == byteBuf2.order()) {
            while (i9 > 0) {
                if (byteBuf.getLong(i6) != byteBuf2.getLong(i7)) {
                    return false;
                }
                i6 += 8;
                i7 += 8;
                i9--;
            }
        } else {
            while (i9 > 0) {
                if (byteBuf.getLong(i6) != swapLong(byteBuf2.getLong(i7))) {
                    return false;
                }
                i6 += 8;
                i7 += 8;
                i9--;
            }
        }
        for (int i10 = i8 & 7; i10 > 0; i10--) {
            if (byteBuf.getByte(i6) != byteBuf2.getByte(i7)) {
                return false;
            }
            i6++;
            i7++;
        }
        return true;
    }

    private static int firstIndexOf(ByteBuf byteBuf, int i6, int i7, byte b6) {
        int max = Math.max(i6, 0);
        if (max >= i7 || byteBuf.capacity() == 0) {
            return -1;
        }
        return byteBuf.forEachByte(max, i7 - max, new ByteProcessor.IndexOfProcessor(b6));
    }

    public static byte[] getBytes(ByteBuf byteBuf) {
        return getBytes(byteBuf, byteBuf.readerIndex(), byteBuf.readableBytes());
    }

    public static String hexDump(ByteBuf byteBuf) {
        return hexDump(byteBuf, byteBuf.readerIndex(), byteBuf.readableBytes());
    }

    public static int indexOf(ByteBuf byteBuf, ByteBuf byteBuf2) {
        int readableBytes = (byteBuf2.readableBytes() - byteBuf.readableBytes()) + 1;
        for (int i6 = 0; i6 < readableBytes; i6++) {
            if (equals(byteBuf, byteBuf.readerIndex(), byteBuf2, byteBuf2.readerIndex() + i6, byteBuf.readableBytes())) {
                return byteBuf2.readerIndex() + i6;
            }
        }
        return -1;
    }

    public static boolean isText(ByteBuf byteBuf, Charset charset) {
        return isText(byteBuf, byteBuf.readerIndex(), byteBuf.readableBytes(), charset);
    }

    private static boolean isUtf8(ByteBuf byteBuf, int i6, int i7) {
        int i8;
        int i9 = i7 + i6;
        while (i6 < i9) {
            int i10 = i6 + 1;
            byte b6 = byteBuf.getByte(i6);
            if ((b6 & 128) == 0) {
                i6 = i10;
            } else if ((b6 & 224) == 192) {
                if (i10 >= i9) {
                    return false;
                }
                i6 += 2;
                if ((byteBuf.getByte(i10) & 192) != 128 || (b6 & 255) < 194) {
                    return false;
                }
            } else {
                if ((b6 & 240) != 224) {
                    if ((b6 & 248) != 240 || i10 > i9 - 3) {
                        return false;
                    }
                    byte b7 = byteBuf.getByte(i10);
                    int i11 = i6 + 3;
                    byte b8 = byteBuf.getByte(i6 + 2);
                    i6 += 4;
                    byte b9 = byteBuf.getByte(i11);
                    if ((b7 & 192) == 128) {
                        if ((b8 & 192) == 128) {
                            if ((b9 & 192) == 128) {
                                int i12 = b6 & 255;
                                if (i12 <= 244) {
                                    if (i12 == 240) {
                                        if ((b7 & 255) < 144) {
                                        }
                                    }
                                    if (i12 == 244 && (b7 & 255) > 143) {
                                    }
                                }
                            }
                        }
                    }
                    return false;
                }
                if (i10 > i9 - 2) {
                    return false;
                }
                int i13 = i6 + 2;
                byte b10 = byteBuf.getByte(i10);
                i6 += 3;
                byte b11 = byteBuf.getByte(i13);
                if ((b10 & 192) != 128 || (b11 & 192) != 128 || ((i8 = b6 & 15) == 0 && (b10 & 255) < 160)) {
                    return false;
                }
                if (i8 == 13 && (b10 & 255) > 159) {
                    return false;
                }
            }
        }
        return true;
    }

    public static String prettyHexDump(ByteBuf byteBuf) {
        return prettyHexDump(byteBuf, byteBuf.readerIndex(), byteBuf.readableBytes());
    }

    public static ByteBuf readBytes(ByteBufAllocator byteBufAllocator, ByteBuf byteBuf, int i6) {
        ByteBuf buffer = byteBufAllocator.buffer(i6);
        try {
            byteBuf.readBytes(buffer);
            return buffer;
        } catch (Throwable th) {
            buffer.release();
            throw th;
        }
    }

    public static int reserveAndWriteUtf8(ByteBuf byteBuf, CharSequence charSequence, int i6) {
        return reserveAndWriteUtf8Seq(byteBuf, charSequence, 0, charSequence.length(), i6);
    }

    public static int utf8Bytes(CharSequence charSequence) {
        return utf8ByteCount(charSequence, 0, charSequence.length());
    }

    private static int utf8BytesNonAscii(CharSequence charSequence, int i6, int i7) {
        int i8 = 0;
        while (i6 < i7) {
            char charAt = charSequence.charAt(i6);
            if (charAt < 2048) {
                i8 += ((127 - charAt) >>> 31) + 1;
            } else if (!StringUtil.isSurrogate(charAt)) {
                i8 += 3;
            } else if (Character.isHighSurrogate(charAt)) {
                i6++;
                try {
                    i8 = !Character.isLowSurrogate(charSequence.charAt(i6)) ? i8 + 2 : i8 + 4;
                } catch (IndexOutOfBoundsException unused) {
                    return i8 + 1;
                }
            } else {
                i8++;
            }
            i6++;
        }
        return i8;
    }

    public static int utf8MaxBytes(int i6) {
        return i6 * MAX_BYTES_PER_CHAR_UTF8;
    }

    public static ByteBuf writeAscii(ByteBufAllocator byteBufAllocator, CharSequence charSequence) {
        ByteBuf buffer = byteBufAllocator.buffer(charSequence.length());
        writeAscii(buffer, charSequence);
        return buffer;
    }

    public static ByteBuf writeUtf8(ByteBufAllocator byteBufAllocator, CharSequence charSequence) {
        ByteBuf buffer = byteBufAllocator.buffer(utf8MaxBytes(charSequence));
        writeUtf8(buffer, charSequence);
        return buffer;
    }

    static {
        ByteBufAllocator byteBufAllocator;
        InternalLogger internalLoggerFactory = InternalLoggerFactory.getInstance((Class<?>) ByteBufUtil.class);
        logger = internalLoggerFactory;
        BYTE_ARRAYS = new FastThreadLocal<byte[]>() { // from class: io.netty.buffer.ByteBufUtil.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // io.netty.util.concurrent.FastThreadLocal
            public byte[] initialValue() throws Exception {
                return PlatformDependent.allocateUninitializedArray(1024);
            }
        };
        MAX_BYTES_PER_CHAR_UTF8 = (int) CharsetUtil.encoder(CharsetUtil.UTF_8).maxBytesPerChar();
        String trim = SystemPropertyUtil.get("io.netty.allocator.type", PlatformDependent.isAndroid() ? "unpooled" : "pooled").toLowerCase(Locale.US).trim();
        if ("unpooled".equals(trim)) {
            byteBufAllocator = UnpooledByteBufAllocator.DEFAULT;
            internalLoggerFactory.debug("-Dio.netty.allocator.type: {}", trim);
        } else if ("pooled".equals(trim)) {
            byteBufAllocator = PooledByteBufAllocator.DEFAULT;
            internalLoggerFactory.debug("-Dio.netty.allocator.type: {}", trim);
        } else {
            byteBufAllocator = PooledByteBufAllocator.DEFAULT;
            internalLoggerFactory.debug("-Dio.netty.allocator.type: pooled (unknown: {})", trim);
        }
        DEFAULT_ALLOCATOR = byteBufAllocator;
        int i6 = SystemPropertyUtil.getInt("io.netty.threadLocalDirectBufferSize", 0);
        THREAD_LOCAL_BUFFER_SIZE = i6;
        internalLoggerFactory.debug("-Dio.netty.threadLocalDirectBufferSize: {}", Integer.valueOf(i6));
        int i7 = SystemPropertyUtil.getInt("io.netty.maxThreadLocalCharBufferSize", 16384);
        MAX_CHAR_BUFFER_SIZE = i7;
        internalLoggerFactory.debug("-Dio.netty.maxThreadLocalCharBufferSize: {}", Integer.valueOf(i7));
        FIND_NON_ASCII = new ByteProcessor() { // from class: io.netty.buffer.ByteBufUtil.2
            @Override // io.netty.util.ByteProcessor
            public boolean process(byte b6) {
                return b6 >= 0;
            }
        };
    }

    public static void appendPrettyHexDump(StringBuilder sb, ByteBuf byteBuf, int i6, int i7) {
        HexUtil.appendPrettyHexDump(sb, byteBuf, i6, i7);
    }

    private static CharSequence checkCharSequenceBounds(CharSequence charSequence, int i6, int i7) {
        if (!MathUtil.isOutOfBounds(i6, i7 - i6, charSequence.length())) {
            return charSequence;
        }
        throw new IndexOutOfBoundsException("expected: 0 <= start(" + i6 + ") <= end (" + i7 + ") <= seq.length(" + charSequence.length() + ')');
    }

    public static void copy(AsciiString asciiString, int i6, ByteBuf byteBuf, int i7, int i8) {
        if (!MathUtil.isOutOfBounds(i6, i8, asciiString.length())) {
            ((ByteBuf) ObjectUtil.checkNotNull(byteBuf, "dst")).setBytes(i7, asciiString.array(), i6 + asciiString.arrayOffset(), i8);
            return;
        }
        throw new IndexOutOfBoundsException("expected: 0 <= srcIdx(" + i6 + ") <= srcIdx + length(" + i8 + ") <= srcLen(" + asciiString.length() + ')');
    }

    public static byte[] decodeHexDump(CharSequence charSequence, int i6, int i7) {
        return StringUtil.decodeHexDump(charSequence, i6, i7);
    }

    static String decodeString(ByteBuf byteBuf, int i6, int i7, Charset charset) {
        byte[] threadLocalTempArray;
        int i8;
        if (i7 == 0) {
            return "";
        }
        if (byteBuf.hasArray()) {
            threadLocalTempArray = byteBuf.array();
            i8 = byteBuf.arrayOffset() + i6;
        } else {
            threadLocalTempArray = threadLocalTempArray(i7);
            byteBuf.getBytes(i6, threadLocalTempArray, 0, i7);
            i8 = 0;
        }
        return CharsetUtil.US_ASCII.equals(charset) ? new String(threadLocalTempArray, 0, i8, i7) : new String(threadLocalTempArray, i8, i7, charset);
    }

    public static ByteBuf encodeString(ByteBufAllocator byteBufAllocator, CharBuffer charBuffer, Charset charset, int i6) {
        return encodeString0(byteBufAllocator, false, charBuffer, charset, i6);
    }

    public static boolean ensureWritableSuccess(int i6) {
        return i6 == 0 || i6 == 2;
    }

    public static byte[] getBytes(ByteBuf byteBuf, int i6, int i7) {
        return getBytes(byteBuf, i6, i7, true);
    }

    public static String hexDump(ByteBuf byteBuf, int i6, int i7) {
        return HexUtil.hexDump(byteBuf, i6, i7);
    }

    private static boolean isAscii(ByteBuf byteBuf, int i6, int i7) {
        return byteBuf.forEachByte(i6, i7, FIND_NON_ASCII) == -1;
    }

    public static boolean isText(ByteBuf byteBuf, int i6, int i7, Charset charset) {
        ObjectUtil.checkNotNull(byteBuf, "buf");
        ObjectUtil.checkNotNull(charset, "charset");
        int readerIndex = byteBuf.readerIndex() + byteBuf.readableBytes();
        if (i6 < 0 || i7 < 0 || i6 > readerIndex - i7) {
            throw new IndexOutOfBoundsException("index: " + i6 + " length: " + i7);
        }
        if (charset.equals(CharsetUtil.UTF_8)) {
            return isUtf8(byteBuf, i6, i7);
        }
        if (charset.equals(CharsetUtil.US_ASCII)) {
            return isAscii(byteBuf, i6, i7);
        }
        CodingErrorAction codingErrorAction = CodingErrorAction.REPORT;
        CharsetDecoder decoder = CharsetUtil.decoder(charset, codingErrorAction, codingErrorAction);
        try {
            if (byteBuf.nioBufferCount() == 1) {
                decoder.decode(byteBuf.nioBuffer(i6, i7));
            } else {
                ByteBuf heapBuffer = byteBuf.alloc().heapBuffer(i7);
                try {
                    heapBuffer.writeBytes(byteBuf, i6, i7);
                    decoder.decode(heapBuffer.internalNioBuffer(heapBuffer.readerIndex(), i7));
                } finally {
                    heapBuffer.release();
                }
            }
            return true;
        } catch (CharacterCodingException unused) {
            return false;
        }
    }

    public static String prettyHexDump(ByteBuf byteBuf, int i6, int i7) {
        return HexUtil.prettyHexDump(byteBuf, i6, i7);
    }

    public static int reserveAndWriteUtf8(ByteBuf byteBuf, CharSequence charSequence, int i6, int i7, int i8) {
        return reserveAndWriteUtf8Seq(byteBuf, checkCharSequenceBounds(charSequence, i6, i7), i6, i7, i8);
    }

    private static int reserveAndWriteUtf8Seq(ByteBuf byteBuf, CharSequence charSequence, int i6, int i7, int i8) {
        while (true) {
            if (byteBuf instanceof WrappedCompositeByteBuf) {
                byteBuf = byteBuf.unwrap();
            } else {
                if (byteBuf instanceof AbstractByteBuf) {
                    AbstractByteBuf abstractByteBuf = (AbstractByteBuf) byteBuf;
                    abstractByteBuf.ensureWritable0(i8);
                    int writeUtf8 = writeUtf8(abstractByteBuf, abstractByteBuf.writerIndex, charSequence, i6, i7);
                    abstractByteBuf.writerIndex += writeUtf8;
                    return writeUtf8;
                }
                if (!(byteBuf instanceof WrappedByteBuf)) {
                    byte[] bytes = charSequence.subSequence(i6, i7).toString().getBytes(CharsetUtil.UTF_8);
                    byteBuf.writeBytes(bytes);
                    return bytes.length;
                }
                byteBuf = byteBuf.unwrap();
            }
        }
    }

    public static int swapMedium(int i6) {
        int i7 = ((i6 >>> 16) & 255) | ((i6 << 16) & 16711680) | (65280 & i6);
        return (8388608 & i7) != 0 ? i7 | ViewCompat.MEASURED_STATE_MASK : i7;
    }

    public static ByteBuf threadLocalDirectBuffer() {
        if (THREAD_LOCAL_BUFFER_SIZE <= 0) {
            return null;
        }
        return PlatformDependent.hasUnsafe() ? ThreadLocalUnsafeDirectByteBuf.newInstance() : ThreadLocalDirectByteBuf.newInstance();
    }

    static byte[] threadLocalTempArray(int i6) {
        return i6 <= 1024 ? BYTE_ARRAYS.get() : PlatformDependent.allocateUninitializedArray(i6);
    }

    private static int utf8ByteCount(CharSequence charSequence, int i6, int i7) {
        if (charSequence instanceof AsciiString) {
            return i7 - i6;
        }
        int i8 = i6;
        while (i8 < i7 && charSequence.charAt(i8) < 128) {
            i8++;
        }
        return i8 < i7 ? (i8 - i6) + utf8BytesNonAscii(charSequence, i8, i7) : i8 - i6;
    }

    public static int utf8Bytes(CharSequence charSequence, int i6, int i7) {
        return utf8ByteCount(checkCharSequenceBounds(charSequence, i6, i7), i6, i7);
    }

    public static int utf8MaxBytes(CharSequence charSequence) {
        return utf8MaxBytes(charSequence.length());
    }

    private ByteBufUtil() {
    }

    public static int compare(ByteBuf byteBuf, ByteBuf byteBuf2) {
        boolean z5;
        long compareUintBigEndianB;
        int readableBytes = byteBuf.readableBytes();
        int readableBytes2 = byteBuf2.readableBytes();
        int min = Math.min(readableBytes, readableBytes2);
        int i6 = min >>> 2;
        int i7 = min & 3;
        int readerIndex = byteBuf.readerIndex();
        int readerIndex2 = byteBuf2.readerIndex();
        if (i6 > 0) {
            if (byteBuf.order() == ByteOrder.BIG_ENDIAN) {
                z5 = true;
            } else {
                z5 = false;
            }
            int i8 = i6 << 2;
            if (byteBuf.order() == byteBuf2.order()) {
                if (z5) {
                    compareUintBigEndianB = compareUintBigEndian(byteBuf, byteBuf2, readerIndex, readerIndex2, i8);
                } else {
                    compareUintBigEndianB = compareUintLittleEndian(byteBuf, byteBuf2, readerIndex, readerIndex2, i8);
                }
            } else if (z5) {
                compareUintBigEndianB = compareUintBigEndianA(byteBuf, byteBuf2, readerIndex, readerIndex2, i8);
            } else {
                compareUintBigEndianB = compareUintBigEndianB(byteBuf, byteBuf2, readerIndex, readerIndex2, i8);
            }
            if (compareUintBigEndianB != 0) {
                return (int) Math.min(2147483647L, Math.max(-2147483648L, compareUintBigEndianB));
            }
            readerIndex += i8;
            readerIndex2 += i8;
        }
        int i9 = i7 + readerIndex;
        while (readerIndex < i9) {
            int unsignedByte = byteBuf.getUnsignedByte(readerIndex) - byteBuf2.getUnsignedByte(readerIndex2);
            if (unsignedByte != 0) {
                return unsignedByte;
            }
            readerIndex++;
            readerIndex2++;
        }
        return readableBytes - readableBytes2;
    }

    public static byte decodeHexByte(CharSequence charSequence, int i6) {
        return StringUtil.decodeHexByte(charSequence, i6);
    }

    static ByteBuf encodeString0(ByteBufAllocator byteBufAllocator, boolean z5, CharBuffer charBuffer, Charset charset, int i6) {
        ByteBuf buffer;
        CharsetEncoder encoder = CharsetUtil.encoder(charset);
        int remaining = ((int) (charBuffer.remaining() * encoder.maxBytesPerChar())) + i6;
        if (z5) {
            buffer = byteBufAllocator.heapBuffer(remaining);
        } else {
            buffer = byteBufAllocator.buffer(remaining);
        }
        try {
            try {
                ByteBuffer internalNioBuffer = buffer.internalNioBuffer(buffer.readerIndex(), remaining);
                int position = internalNioBuffer.position();
                CoderResult encode = encoder.encode(charBuffer, internalNioBuffer, true);
                if (!encode.isUnderflow()) {
                    encode.throwException();
                }
                CoderResult flush = encoder.flush(internalNioBuffer);
                if (!flush.isUnderflow()) {
                    flush.throwException();
                }
                buffer.writerIndex((buffer.writerIndex() + internalNioBuffer.position()) - position);
                return buffer;
            } catch (CharacterCodingException e6) {
                throw new IllegalStateException(e6);
            }
        } catch (Throwable th) {
            buffer.release();
            throw th;
        }
    }

    public static byte[] getBytes(ByteBuf byteBuf, int i6, int i7, boolean z5) {
        int capacity = byteBuf.capacity();
        if (!MathUtil.isOutOfBounds(i6, i7, capacity)) {
            if (!byteBuf.hasArray()) {
                byte[] allocateUninitializedArray = PlatformDependent.allocateUninitializedArray(i7);
                byteBuf.getBytes(i6, allocateUninitializedArray);
                return allocateUninitializedArray;
            }
            if (!z5 && i6 == 0 && i7 == capacity) {
                return byteBuf.array();
            }
            int arrayOffset = byteBuf.arrayOffset() + i6;
            return Arrays.copyOfRange(byteBuf.array(), arrayOffset, i7 + arrayOffset);
        }
        throw new IndexOutOfBoundsException("expected: 0 <= start(" + i6 + ") <= start + length(" + i7 + ") <= buf.capacity(" + capacity + ')');
    }

    public static int hashCode(ByteBuf byteBuf) {
        int i6;
        int readableBytes = byteBuf.readableBytes();
        int i7 = readableBytes >>> 2;
        int i8 = readableBytes & 3;
        int readerIndex = byteBuf.readerIndex();
        if (byteBuf.order() == ByteOrder.BIG_ENDIAN) {
            i6 = 1;
            while (i7 > 0) {
                i6 = (i6 * 31) + byteBuf.getInt(readerIndex);
                readerIndex += 4;
                i7--;
            }
        } else {
            i6 = 1;
            while (i7 > 0) {
                i6 = (i6 * 31) + swapInt(byteBuf.getInt(readerIndex));
                readerIndex += 4;
                i7--;
            }
        }
        while (i8 > 0) {
            i6 = (i6 * 31) + byteBuf.getByte(readerIndex);
            i8--;
            readerIndex++;
        }
        if (i6 == 0) {
            return 1;
        }
        return i6;
    }

    public static String hexDump(byte[] bArr) {
        return hexDump(bArr, 0, bArr.length);
    }

    private static int lastIndexOf(ByteBuf byteBuf, int i6, int i7, byte b6) {
        int capacity = byteBuf.capacity();
        int min = Math.min(i6, capacity);
        if (min >= 0 && capacity != 0) {
            return byteBuf.forEachByteDesc(i7, min - i7, new ByteProcessor.IndexOfProcessor(b6));
        }
        return -1;
    }

    public static ByteBuf setShortBE(ByteBuf byteBuf, int i6, int i7) {
        if (byteBuf.order() == ByteOrder.BIG_ENDIAN) {
            return byteBuf.setShort(i6, i7);
        }
        return byteBuf.setShortLE(i6, i7);
    }

    public static int swapInt(int i6) {
        return Integer.reverseBytes(i6);
    }

    public static long swapLong(long j6) {
        return Long.reverseBytes(j6);
    }

    public static short swapShort(short s5) {
        return Short.reverseBytes(s5);
    }

    public static int writeAscii(ByteBuf byteBuf, CharSequence charSequence) {
        int length = charSequence.length();
        if (charSequence instanceof AsciiString) {
            AsciiString asciiString = (AsciiString) charSequence;
            byteBuf.writeBytes(asciiString.array(), asciiString.arrayOffset(), length);
            return length;
        }
        while (true) {
            if (byteBuf instanceof WrappedCompositeByteBuf) {
                byteBuf = byteBuf.unwrap();
            } else {
                if (byteBuf instanceof AbstractByteBuf) {
                    AbstractByteBuf abstractByteBuf = (AbstractByteBuf) byteBuf;
                    abstractByteBuf.ensureWritable0(length);
                    int writeAscii = writeAscii(abstractByteBuf, abstractByteBuf.writerIndex, charSequence, length);
                    abstractByteBuf.writerIndex += writeAscii;
                    return writeAscii;
                }
                if (byteBuf instanceof WrappedByteBuf) {
                    byteBuf = byteBuf.unwrap();
                } else {
                    byte[] bytes = charSequence.toString().getBytes(CharsetUtil.US_ASCII);
                    byteBuf.writeBytes(bytes);
                    return bytes.length;
                }
            }
        }
    }

    public static ByteBuf writeMediumBE(ByteBuf byteBuf, int i6) {
        if (byteBuf.order() == ByteOrder.BIG_ENDIAN) {
            return byteBuf.writeMedium(i6);
        }
        return byteBuf.writeMediumLE(i6);
    }

    public static ByteBuf writeShortBE(ByteBuf byteBuf, int i6) {
        if (byteBuf.order() == ByteOrder.BIG_ENDIAN) {
            return byteBuf.writeShort(i6);
        }
        return byteBuf.writeShortLE(i6);
    }

    public static int writeUtf8(ByteBuf byteBuf, CharSequence charSequence) {
        int length = charSequence.length();
        return reserveAndWriteUtf8Seq(byteBuf, charSequence, 0, length, utf8MaxBytes(length));
    }

    private static int writeUtf8Surrogate(AbstractByteBuf abstractByteBuf, int i6, char c6, char c7) {
        if (!Character.isLowSurrogate(c7)) {
            int i7 = i6 + 1;
            abstractByteBuf._setByte(i6, 63);
            int i8 = i6 + 2;
            if (Character.isHighSurrogate(c7)) {
                c7 = '?';
            }
            abstractByteBuf._setByte(i7, c7);
            return i8;
        }
        int codePoint = Character.toCodePoint(c6, c7);
        abstractByteBuf._setByte(i6, (byte) ((codePoint >> 18) | 240));
        abstractByteBuf._setByte(i6 + 1, (byte) (((codePoint >> 12) & 63) | 128));
        int i9 = i6 + 3;
        abstractByteBuf._setByte(i6 + 2, (byte) (((codePoint >> 6) & 63) | 128));
        int i10 = i6 + 4;
        abstractByteBuf._setByte(i9, (byte) ((codePoint & 63) | 128));
        return i10;
    }

    public static String hexDump(byte[] bArr, int i6, int i7) {
        return HexUtil.hexDump(bArr, i6, i7);
    }

    static void readBytes(ByteBufAllocator byteBufAllocator, ByteBuffer byteBuffer, int i6, int i7, OutputStream outputStream) throws IOException {
        if (byteBuffer.hasArray()) {
            outputStream.write(byteBuffer.array(), i6 + byteBuffer.arrayOffset(), i7);
            return;
        }
        int min = Math.min(i7, 8192);
        byteBuffer.clear().position(i6);
        if (i7 > 1024 && byteBufAllocator.isDirectBufferPooled()) {
            ByteBuf heapBuffer = byteBufAllocator.heapBuffer(min);
            try {
                getBytes(byteBuffer, heapBuffer.array(), heapBuffer.arrayOffset(), min, outputStream, i7);
                return;
            } finally {
                heapBuffer.release();
            }
        }
        getBytes(byteBuffer, threadLocalTempArray(min), 0, min, outputStream, i7);
    }

    public static int writeUtf8(ByteBuf byteBuf, CharSequence charSequence, int i6, int i7) {
        checkCharSequenceBounds(charSequence, i6, i7);
        return reserveAndWriteUtf8Seq(byteBuf, charSequence, i6, i7, utf8MaxBytes(i7 - i6));
    }

    public static void copy(AsciiString asciiString, int i6, ByteBuf byteBuf, int i7) {
        if (!MathUtil.isOutOfBounds(i6, i7, asciiString.length())) {
            ((ByteBuf) ObjectUtil.checkNotNull(byteBuf, "dst")).writeBytes(asciiString.array(), i6 + asciiString.arrayOffset(), i7);
            return;
        }
        throw new IndexOutOfBoundsException("expected: 0 <= srcIdx(" + i6 + ") <= srcIdx + length(" + i7 + ") <= srcLen(" + asciiString.length() + ')');
    }

    public static boolean equals(ByteBuf byteBuf, ByteBuf byteBuf2) {
        int readableBytes = byteBuf.readableBytes();
        if (readableBytes != byteBuf2.readableBytes()) {
            return false;
        }
        return equals(byteBuf, byteBuf.readerIndex(), byteBuf2, byteBuf2.readerIndex(), readableBytes);
    }

    public static int indexOf(ByteBuf byteBuf, int i6, int i7, byte b6) {
        if (i6 <= i7) {
            return firstIndexOf(byteBuf, i6, i7, b6);
        }
        return lastIndexOf(byteBuf, i6, i7, b6);
    }

    static int writeUtf8(AbstractByteBuf abstractByteBuf, int i6, CharSequence charSequence, int i7) {
        return writeUtf8(abstractByteBuf, i6, charSequence, 0, i7);
    }

    static int writeUtf8(AbstractByteBuf abstractByteBuf, int i6, CharSequence charSequence, int i7, int i8) {
        int i9 = i6;
        while (i7 < i8) {
            char charAt = charSequence.charAt(i7);
            if (charAt < 128) {
                abstractByteBuf._setByte(i9, (byte) charAt);
                i9++;
            } else if (charAt < 2048) {
                int i10 = i9 + 1;
                abstractByteBuf._setByte(i9, (byte) ((charAt >> 6) | 192));
                i9 += 2;
                abstractByteBuf._setByte(i10, (byte) ((charAt & '?') | 128));
            } else if (StringUtil.isSurrogate(charAt)) {
                if (!Character.isHighSurrogate(charAt)) {
                    abstractByteBuf._setByte(i9, 63);
                    i9++;
                } else {
                    i7++;
                    try {
                        i9 = writeUtf8Surrogate(abstractByteBuf, i9, charAt, charSequence.charAt(i7));
                    } catch (IndexOutOfBoundsException unused) {
                        abstractByteBuf._setByte(i9, 63);
                        i9++;
                    }
                }
            } else {
                abstractByteBuf._setByte(i9, (byte) ((charAt >> '\f') | 224));
                int i11 = i9 + 2;
                abstractByteBuf._setByte(i9 + 1, (byte) ((63 & (charAt >> 6)) | 128));
                i9 += 3;
                abstractByteBuf._setByte(i11, (byte) ((charAt & '?') | 128));
            }
            i7++;
        }
        return i9 - i6;
    }

    private static void getBytes(ByteBuffer byteBuffer, byte[] bArr, int i6, int i7, OutputStream outputStream, int i8) throws IOException {
        do {
            int min = Math.min(i7, i8);
            byteBuffer.get(bArr, i6, min);
            outputStream.write(bArr, i6, min);
            i8 -= min;
        } while (i8 > 0);
    }

    static int writeAscii(AbstractByteBuf abstractByteBuf, int i6, CharSequence charSequence, int i7) {
        int i8 = 0;
        while (i8 < i7) {
            abstractByteBuf._setByte(i6, AsciiString.c2b(charSequence.charAt(i8)));
            i8++;
            i6++;
        }
        return i7;
    }
}
