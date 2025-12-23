package io.netty.buffer;

import io.netty.util.internal.MathUtil;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ReadOnlyBufferException;
import kotlin.j1;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class UnsafeByteBufUtil {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final boolean UNALIGNED = PlatformDependent.isUnaligned();
    private static final byte ZERO = 0;

    static byte getByte(long j6) {
        return PlatformDependent.getByte(j6);
    }

    static void getBytes(AbstractByteBuf abstractByteBuf, long j6, int i6, ByteBuf byteBuf, int i7, int i8) {
        abstractByteBuf.checkIndex(i6, i8);
        ObjectUtil.checkNotNull(byteBuf, "dst");
        if (MathUtil.isOutOfBounds(i7, i8, byteBuf.capacity())) {
            throw new IndexOutOfBoundsException("dstIndex: " + i7);
        }
        if (byteBuf.hasMemoryAddress()) {
            PlatformDependent.copyMemory(j6, byteBuf.memoryAddress() + i7, i8);
        } else if (byteBuf.hasArray()) {
            PlatformDependent.copyMemory(j6, byteBuf.array(), byteBuf.arrayOffset() + i7, i8);
        } else {
            byteBuf.setBytes(i7, abstractByteBuf, i6, i8);
        }
    }

    static int getInt(long j6) {
        if (!UNALIGNED) {
            return (PlatformDependent.getByte(j6 + 3) & 255) | (PlatformDependent.getByte(j6) << 24) | ((PlatformDependent.getByte(1 + j6) & 255) << 16) | ((PlatformDependent.getByte(2 + j6) & 255) << 8);
        }
        int i6 = PlatformDependent.getInt(j6);
        return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? i6 : Integer.reverseBytes(i6);
    }

    static int getIntLE(long j6) {
        if (!UNALIGNED) {
            return (PlatformDependent.getByte(j6 + 3) << 24) | (PlatformDependent.getByte(j6) & 255) | ((PlatformDependent.getByte(1 + j6) & 255) << 8) | ((PlatformDependent.getByte(2 + j6) & 255) << 16);
        }
        int i6 = PlatformDependent.getInt(j6);
        return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? Integer.reverseBytes(i6) : i6;
    }

    static long getLong(long j6) {
        if (!UNALIGNED) {
            return (PlatformDependent.getByte(j6 + 7) & 255) | (PlatformDependent.getByte(j6) << 56) | ((PlatformDependent.getByte(1 + j6) & 255) << 48) | ((PlatformDependent.getByte(2 + j6) & 255) << 40) | ((PlatformDependent.getByte(3 + j6) & 255) << 32) | ((PlatformDependent.getByte(4 + j6) & 255) << 24) | ((PlatformDependent.getByte(5 + j6) & 255) << 16) | ((PlatformDependent.getByte(6 + j6) & 255) << 8);
        }
        long j7 = PlatformDependent.getLong(j6);
        return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? j7 : Long.reverseBytes(j7);
    }

    static long getLongLE(long j6) {
        if (!UNALIGNED) {
            return (PlatformDependent.getByte(j6 + 7) << 56) | (PlatformDependent.getByte(j6) & 255) | ((PlatformDependent.getByte(1 + j6) & 255) << 8) | ((PlatformDependent.getByte(2 + j6) & 255) << 16) | ((PlatformDependent.getByte(3 + j6) & 255) << 24) | ((PlatformDependent.getByte(4 + j6) & 255) << 32) | ((PlatformDependent.getByte(5 + j6) & 255) << 40) | ((255 & PlatformDependent.getByte(6 + j6)) << 48);
        }
        long j7 = PlatformDependent.getLong(j6);
        return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? Long.reverseBytes(j7) : j7;
    }

    static short getShort(long j6) {
        if (!UNALIGNED) {
            return (short) ((PlatformDependent.getByte(j6 + 1) & 255) | (PlatformDependent.getByte(j6) << 8));
        }
        short s5 = PlatformDependent.getShort(j6);
        return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? s5 : Short.reverseBytes(s5);
    }

    static short getShortLE(long j6) {
        if (!UNALIGNED) {
            return (short) ((PlatformDependent.getByte(j6 + 1) << 8) | (PlatformDependent.getByte(j6) & 255));
        }
        short s5 = PlatformDependent.getShort(j6);
        return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? Short.reverseBytes(s5) : s5;
    }

    static int getUnsignedMedium(long j6) {
        int i6;
        int i7;
        if (UNALIGNED) {
            i6 = (PlatformDependent.getByte(j6) & 255) << 16;
            i7 = (PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? PlatformDependent.getShort(j6 + 1) : Short.reverseBytes(PlatformDependent.getShort(j6 + 1))) & j1.f43986d;
        } else {
            i6 = ((PlatformDependent.getByte(j6) & 255) << 16) | ((PlatformDependent.getByte(1 + j6) & 255) << 8);
            i7 = PlatformDependent.getByte(j6 + 2) & 255;
        }
        return i7 | i6;
    }

    static int getUnsignedMediumLE(long j6) {
        int i6;
        int i7;
        if (UNALIGNED) {
            i6 = PlatformDependent.getByte(j6) & 255;
            i7 = ((PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? Short.reverseBytes(PlatformDependent.getShort(j6 + 1)) : PlatformDependent.getShort(j6 + 1)) & j1.f43986d) << 8;
        } else {
            i6 = (PlatformDependent.getByte(j6) & 255) | ((PlatformDependent.getByte(1 + j6) & 255) << 8);
            i7 = (PlatformDependent.getByte(j6 + 2) & 255) << 16;
        }
        return i7 | i6;
    }

    static void setByte(long j6, int i6) {
        PlatformDependent.putByte(j6, (byte) i6);
    }

    static int setBytes(AbstractByteBuf abstractByteBuf, long j6, int i6, InputStream inputStream, int i7) throws IOException {
        abstractByteBuf.checkIndex(i6, i7);
        ByteBuf heapBuffer = abstractByteBuf.alloc().heapBuffer(i7);
        try {
            byte[] array = heapBuffer.array();
            int arrayOffset = heapBuffer.arrayOffset();
            int read = inputStream.read(array, arrayOffset, i7);
            if (read > 0) {
                PlatformDependent.copyMemory(array, arrayOffset, j6, read);
            }
            heapBuffer.release();
            return read;
        } catch (Throwable th) {
            heapBuffer.release();
            throw th;
        }
    }

    static void setInt(long j6, int i6) {
        if (UNALIGNED) {
            if (!PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                i6 = Integer.reverseBytes(i6);
            }
            PlatformDependent.putInt(j6, i6);
        } else {
            PlatformDependent.putByte(j6, (byte) (i6 >>> 24));
            PlatformDependent.putByte(1 + j6, (byte) (i6 >>> 16));
            PlatformDependent.putByte(2 + j6, (byte) (i6 >>> 8));
            PlatformDependent.putByte(j6 + 3, (byte) i6);
        }
    }

    static void setIntLE(long j6, int i6) {
        if (UNALIGNED) {
            if (PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                i6 = Integer.reverseBytes(i6);
            }
            PlatformDependent.putInt(j6, i6);
        } else {
            PlatformDependent.putByte(j6, (byte) i6);
            PlatformDependent.putByte(1 + j6, (byte) (i6 >>> 8));
            PlatformDependent.putByte(2 + j6, (byte) (i6 >>> 16));
            PlatformDependent.putByte(j6 + 3, (byte) (i6 >>> 24));
        }
    }

    static void setLong(long j6, long j7) {
        if (UNALIGNED) {
            if (!PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                j7 = Long.reverseBytes(j7);
            }
            PlatformDependent.putLong(j6, j7);
            return;
        }
        PlatformDependent.putByte(j6, (byte) (j7 >>> 56));
        PlatformDependent.putByte(1 + j6, (byte) (j7 >>> 48));
        PlatformDependent.putByte(2 + j6, (byte) (j7 >>> 40));
        PlatformDependent.putByte(3 + j6, (byte) (j7 >>> 32));
        PlatformDependent.putByte(4 + j6, (byte) (j7 >>> 24));
        PlatformDependent.putByte(5 + j6, (byte) (j7 >>> 16));
        PlatformDependent.putByte(6 + j6, (byte) (j7 >>> 8));
        PlatformDependent.putByte(j6 + 7, (byte) j7);
    }

    static void setLongLE(long j6, long j7) {
        if (UNALIGNED) {
            if (PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                j7 = Long.reverseBytes(j7);
            }
            PlatformDependent.putLong(j6, j7);
            return;
        }
        PlatformDependent.putByte(j6, (byte) j7);
        PlatformDependent.putByte(1 + j6, (byte) (j7 >>> 8));
        PlatformDependent.putByte(2 + j6, (byte) (j7 >>> 16));
        PlatformDependent.putByte(3 + j6, (byte) (j7 >>> 24));
        PlatformDependent.putByte(4 + j6, (byte) (j7 >>> 32));
        PlatformDependent.putByte(5 + j6, (byte) (j7 >>> 40));
        PlatformDependent.putByte(6 + j6, (byte) (j7 >>> 48));
        PlatformDependent.putByte(j6 + 7, (byte) (j7 >>> 56));
    }

    static void setMedium(long j6, int i6) {
        PlatformDependent.putByte(j6, (byte) (i6 >>> 16));
        if (!UNALIGNED) {
            PlatformDependent.putByte(1 + j6, (byte) (i6 >>> 8));
            PlatformDependent.putByte(j6 + 2, (byte) i6);
            return;
        }
        long j7 = j6 + 1;
        short s5 = (short) i6;
        if (!PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
            s5 = Short.reverseBytes(s5);
        }
        PlatformDependent.putShort(j7, s5);
    }

    static void setMediumLE(long j6, int i6) {
        PlatformDependent.putByte(j6, (byte) i6);
        if (!UNALIGNED) {
            PlatformDependent.putByte(1 + j6, (byte) (i6 >>> 8));
            PlatformDependent.putByte(j6 + 2, (byte) (i6 >>> 16));
            return;
        }
        long j7 = j6 + 1;
        short s5 = (short) (i6 >>> 8);
        if (PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
            s5 = Short.reverseBytes(s5);
        }
        PlatformDependent.putShort(j7, s5);
    }

    static void setShort(long j6, int i6) {
        if (!UNALIGNED) {
            PlatformDependent.putByte(j6, (byte) (i6 >>> 8));
            PlatformDependent.putByte(j6 + 1, (byte) i6);
        } else {
            short s5 = (short) i6;
            if (!PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                s5 = Short.reverseBytes(s5);
            }
            PlatformDependent.putShort(j6, s5);
        }
    }

    static void setShortLE(long j6, int i6) {
        if (UNALIGNED) {
            PlatformDependent.putShort(j6, PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? Short.reverseBytes((short) i6) : (short) i6);
        } else {
            PlatformDependent.putByte(j6, (byte) i6);
            PlatformDependent.putByte(j6 + 1, (byte) (i6 >>> 8));
        }
    }

    static void setZero(byte[] bArr, int i6, int i7) {
        if (i7 == 0) {
            return;
        }
        PlatformDependent.setMemory(bArr, i6, i7, (byte) 0);
    }

    static byte getByte(byte[] bArr, int i6) {
        return PlatformDependent.getByte(bArr, i6);
    }

    static void setByte(byte[] bArr, int i6, int i7) {
        PlatformDependent.putByte(bArr, i6, (byte) i7);
    }

    static void setZero(long j6, int i6) {
        if (i6 == 0) {
            return;
        }
        PlatformDependent.setMemory(j6, i6, (byte) 0);
    }

    private UnsafeByteBufUtil() {
    }

    static ByteBuf copy(AbstractByteBuf abstractByteBuf, long j6, int i6, int i7) {
        abstractByteBuf.checkIndex(i6, i7);
        ByteBuf directBuffer = abstractByteBuf.alloc().directBuffer(i7, abstractByteBuf.maxCapacity());
        if (i7 != 0) {
            if (directBuffer.hasMemoryAddress()) {
                PlatformDependent.copyMemory(j6, directBuffer.memoryAddress(), i7);
                directBuffer.setIndex(0, i7);
                return directBuffer;
            }
            directBuffer.writeBytes(abstractByteBuf, i6, i7);
        }
        return directBuffer;
    }

    static UnpooledUnsafeDirectByteBuf newUnsafeDirectByteBuf(ByteBufAllocator byteBufAllocator, int i6, int i7) {
        if (PlatformDependent.useDirectBufferNoCleaner()) {
            return new UnpooledUnsafeNoCleanerDirectByteBuf(byteBufAllocator, i6, i7);
        }
        return new UnpooledUnsafeDirectByteBuf(byteBufAllocator, i6, i7);
    }

    private static void setSingleBytes(AbstractByteBuf abstractByteBuf, long j6, int i6, ByteBuffer byteBuffer, int i7) {
        abstractByteBuf.checkIndex(i6, i7);
        int limit = byteBuffer.limit();
        for (int position = byteBuffer.position(); position < limit; position++) {
            PlatformDependent.putByte(j6, byteBuffer.get(position));
            j6++;
        }
        byteBuffer.position(limit);
    }

    static short getShort(byte[] bArr, int i6) {
        if (UNALIGNED) {
            short s5 = PlatformDependent.getShort(bArr, i6);
            return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? s5 : Short.reverseBytes(s5);
        }
        return (short) ((PlatformDependent.getByte(bArr, i6 + 1) & 255) | (PlatformDependent.getByte(bArr, i6) << 8));
    }

    static short getShortLE(byte[] bArr, int i6) {
        if (UNALIGNED) {
            short s5 = PlatformDependent.getShort(bArr, i6);
            return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? Short.reverseBytes(s5) : s5;
        }
        return (short) ((PlatformDependent.getByte(bArr, i6 + 1) << 8) | (PlatformDependent.getByte(bArr, i6) & 255));
    }

    static void setMediumLE(byte[] bArr, int i6, int i7) {
        PlatformDependent.putByte(bArr, i6, (byte) i7);
        if (UNALIGNED) {
            PlatformDependent.putShort(bArr, i6 + 1, PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? Short.reverseBytes((short) (i7 >>> 8)) : (short) (i7 >>> 8));
        } else {
            PlatformDependent.putByte(bArr, i6 + 1, (byte) (i7 >>> 8));
            PlatformDependent.putByte(bArr, i6 + 2, (byte) (i7 >>> 16));
        }
    }

    static void setInt(byte[] bArr, int i6, int i7) {
        if (UNALIGNED) {
            if (!PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                i7 = Integer.reverseBytes(i7);
            }
            PlatformDependent.putInt(bArr, i6, i7);
        } else {
            PlatformDependent.putByte(bArr, i6, (byte) (i7 >>> 24));
            PlatformDependent.putByte(bArr, i6 + 1, (byte) (i7 >>> 16));
            PlatformDependent.putByte(bArr, i6 + 2, (byte) (i7 >>> 8));
            PlatformDependent.putByte(bArr, i6 + 3, (byte) i7);
        }
    }

    static void setIntLE(byte[] bArr, int i6, int i7) {
        if (UNALIGNED) {
            if (PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                i7 = Integer.reverseBytes(i7);
            }
            PlatformDependent.putInt(bArr, i6, i7);
        } else {
            PlatformDependent.putByte(bArr, i6, (byte) i7);
            PlatformDependent.putByte(bArr, i6 + 1, (byte) (i7 >>> 8));
            PlatformDependent.putByte(bArr, i6 + 2, (byte) (i7 >>> 16));
            PlatformDependent.putByte(bArr, i6 + 3, (byte) (i7 >>> 24));
        }
    }

    static void setShort(byte[] bArr, int i6, int i7) {
        if (UNALIGNED) {
            short s5 = (short) i7;
            if (!PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                s5 = Short.reverseBytes(s5);
            }
            PlatformDependent.putShort(bArr, i6, s5);
            return;
        }
        PlatformDependent.putByte(bArr, i6, (byte) (i7 >>> 8));
        PlatformDependent.putByte(bArr, i6 + 1, (byte) i7);
    }

    static void setShortLE(byte[] bArr, int i6, int i7) {
        if (UNALIGNED) {
            PlatformDependent.putShort(bArr, i6, PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? Short.reverseBytes((short) i7) : (short) i7);
        } else {
            PlatformDependent.putByte(bArr, i6, (byte) i7);
            PlatformDependent.putByte(bArr, i6 + 1, (byte) (i7 >>> 8));
        }
    }

    static int getInt(byte[] bArr, int i6) {
        if (UNALIGNED) {
            int i7 = PlatformDependent.getInt(bArr, i6);
            return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? i7 : Integer.reverseBytes(i7);
        }
        return (PlatformDependent.getByte(bArr, i6 + 3) & 255) | (PlatformDependent.getByte(bArr, i6) << 24) | ((PlatformDependent.getByte(bArr, i6 + 1) & 255) << 16) | ((PlatformDependent.getByte(bArr, i6 + 2) & 255) << 8);
    }

    static int getIntLE(byte[] bArr, int i6) {
        if (UNALIGNED) {
            int i7 = PlatformDependent.getInt(bArr, i6);
            return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? Integer.reverseBytes(i7) : i7;
        }
        return (PlatformDependent.getByte(bArr, i6 + 3) << 24) | (PlatformDependent.getByte(bArr, i6) & 255) | ((PlatformDependent.getByte(bArr, i6 + 1) & 255) << 8) | ((PlatformDependent.getByte(bArr, i6 + 2) & 255) << 16);
    }

    static int getUnsignedMedium(byte[] bArr, int i6) {
        int i7;
        int i8;
        short reverseBytes;
        if (UNALIGNED) {
            i7 = (PlatformDependent.getByte(bArr, i6) & 255) << 16;
            if (PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                reverseBytes = PlatformDependent.getShort(bArr, i6 + 1);
            } else {
                reverseBytes = Short.reverseBytes(PlatformDependent.getShort(bArr, i6 + 1));
            }
            i8 = reverseBytes & j1.f43986d;
        } else {
            i7 = ((PlatformDependent.getByte(bArr, i6) & 255) << 16) | ((PlatformDependent.getByte(bArr, i6 + 1) & 255) << 8);
            i8 = PlatformDependent.getByte(bArr, i6 + 2) & 255;
        }
        return i8 | i7;
    }

    static int getUnsignedMediumLE(byte[] bArr, int i6) {
        int i7;
        int i8;
        short s5;
        if (UNALIGNED) {
            i7 = PlatformDependent.getByte(bArr, i6) & 255;
            if (PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                s5 = Short.reverseBytes(PlatformDependent.getShort(bArr, i6 + 1));
            } else {
                s5 = PlatformDependent.getShort(bArr, i6 + 1);
            }
            i8 = (s5 & j1.f43986d) << 8;
        } else {
            i7 = (PlatformDependent.getByte(bArr, i6) & 255) | ((PlatformDependent.getByte(bArr, i6 + 1) & 255) << 8);
            i8 = (PlatformDependent.getByte(bArr, i6 + 2) & 255) << 16;
        }
        return i8 | i7;
    }

    static void setMedium(byte[] bArr, int i6, int i7) {
        PlatformDependent.putByte(bArr, i6, (byte) (i7 >>> 16));
        if (UNALIGNED) {
            int i8 = i6 + 1;
            short s5 = (short) i7;
            if (!PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                s5 = Short.reverseBytes(s5);
            }
            PlatformDependent.putShort(bArr, i8, s5);
            return;
        }
        PlatformDependent.putByte(bArr, i6 + 1, (byte) (i7 >>> 8));
        PlatformDependent.putByte(bArr, i6 + 2, (byte) i7);
    }

    static void setBytes(AbstractByteBuf abstractByteBuf, long j6, int i6, ByteBuf byteBuf, int i7, int i8) {
        abstractByteBuf.checkIndex(i6, i8);
        ObjectUtil.checkNotNull(byteBuf, "src");
        if (MathUtil.isOutOfBounds(i7, i8, byteBuf.capacity())) {
            throw new IndexOutOfBoundsException("srcIndex: " + i7);
        }
        if (i8 != 0) {
            if (byteBuf.hasMemoryAddress()) {
                PlatformDependent.copyMemory(byteBuf.memoryAddress() + i7, j6, i8);
            } else if (byteBuf.hasArray()) {
                PlatformDependent.copyMemory(byteBuf.array(), byteBuf.arrayOffset() + i7, j6, i8);
            } else {
                byteBuf.getBytes(i7, abstractByteBuf, i6, i8);
            }
        }
    }

    static void getBytes(AbstractByteBuf abstractByteBuf, long j6, int i6, byte[] bArr, int i7, int i8) {
        abstractByteBuf.checkIndex(i6, i8);
        ObjectUtil.checkNotNull(bArr, "dst");
        if (MathUtil.isOutOfBounds(i7, i8, bArr.length)) {
            throw new IndexOutOfBoundsException("dstIndex: " + i7);
        }
        if (i8 != 0) {
            PlatformDependent.copyMemory(j6, bArr, i7, i8);
        }
    }

    static void setLong(byte[] bArr, int i6, long j6) {
        if (UNALIGNED) {
            if (!PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                j6 = Long.reverseBytes(j6);
            }
            PlatformDependent.putLong(bArr, i6, j6);
            return;
        }
        PlatformDependent.putByte(bArr, i6, (byte) (j6 >>> 56));
        PlatformDependent.putByte(bArr, i6 + 1, (byte) (j6 >>> 48));
        PlatformDependent.putByte(bArr, i6 + 2, (byte) (j6 >>> 40));
        PlatformDependent.putByte(bArr, i6 + 3, (byte) (j6 >>> 32));
        PlatformDependent.putByte(bArr, i6 + 4, (byte) (j6 >>> 24));
        PlatformDependent.putByte(bArr, i6 + 5, (byte) (j6 >>> 16));
        PlatformDependent.putByte(bArr, i6 + 6, (byte) (j6 >>> 8));
        PlatformDependent.putByte(bArr, i6 + 7, (byte) j6);
    }

    static void setLongLE(byte[] bArr, int i6, long j6) {
        if (UNALIGNED) {
            if (PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                j6 = Long.reverseBytes(j6);
            }
            PlatformDependent.putLong(bArr, i6, j6);
            return;
        }
        PlatformDependent.putByte(bArr, i6, (byte) j6);
        PlatformDependent.putByte(bArr, i6 + 1, (byte) (j6 >>> 8));
        PlatformDependent.putByte(bArr, i6 + 2, (byte) (j6 >>> 16));
        PlatformDependent.putByte(bArr, i6 + 3, (byte) (j6 >>> 24));
        PlatformDependent.putByte(bArr, i6 + 4, (byte) (j6 >>> 32));
        PlatformDependent.putByte(bArr, i6 + 5, (byte) (j6 >>> 40));
        PlatformDependent.putByte(bArr, i6 + 6, (byte) (j6 >>> 48));
        PlatformDependent.putByte(bArr, i6 + 7, (byte) (j6 >>> 56));
    }

    static long getLong(byte[] bArr, int i6) {
        if (UNALIGNED) {
            long j6 = PlatformDependent.getLong(bArr, i6);
            return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? j6 : Long.reverseBytes(j6);
        }
        return (PlatformDependent.getByte(bArr, i6 + 7) & 255) | (PlatformDependent.getByte(bArr, i6) << 56) | ((PlatformDependent.getByte(bArr, i6 + 1) & 255) << 48) | ((PlatformDependent.getByte(bArr, i6 + 2) & 255) << 40) | ((PlatformDependent.getByte(bArr, i6 + 3) & 255) << 32) | ((PlatformDependent.getByte(bArr, i6 + 4) & 255) << 24) | ((PlatformDependent.getByte(bArr, i6 + 5) & 255) << 16) | ((PlatformDependent.getByte(bArr, i6 + 6) & 255) << 8);
    }

    static long getLongLE(byte[] bArr, int i6) {
        if (UNALIGNED) {
            long j6 = PlatformDependent.getLong(bArr, i6);
            return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? Long.reverseBytes(j6) : j6;
        }
        return (PlatformDependent.getByte(bArr, i6 + 7) << 56) | (PlatformDependent.getByte(bArr, i6) & 255) | ((PlatformDependent.getByte(bArr, i6 + 1) & 255) << 8) | ((PlatformDependent.getByte(bArr, i6 + 2) & 255) << 16) | ((PlatformDependent.getByte(bArr, i6 + 3) & 255) << 24) | ((PlatformDependent.getByte(bArr, i6 + 4) & 255) << 32) | ((PlatformDependent.getByte(bArr, i6 + 5) & 255) << 40) | ((255 & PlatformDependent.getByte(bArr, i6 + 6)) << 48);
    }

    static void getBytes(AbstractByteBuf abstractByteBuf, long j6, int i6, ByteBuffer byteBuffer) {
        abstractByteBuf.checkIndex(i6, byteBuffer.remaining());
        if (byteBuffer.remaining() == 0) {
            return;
        }
        if (byteBuffer.isDirect()) {
            if (!byteBuffer.isReadOnly()) {
                PlatformDependent.copyMemory(j6, PlatformDependent.directBufferAddress(byteBuffer) + byteBuffer.position(), byteBuffer.remaining());
                byteBuffer.position(byteBuffer.position() + byteBuffer.remaining());
                return;
            }
            throw new ReadOnlyBufferException();
        }
        if (byteBuffer.hasArray()) {
            PlatformDependent.copyMemory(j6, byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
            byteBuffer.position(byteBuffer.position() + byteBuffer.remaining());
        } else {
            byteBuffer.put(abstractByteBuf.nioBuffer());
        }
    }

    static void setBytes(AbstractByteBuf abstractByteBuf, long j6, int i6, byte[] bArr, int i7, int i8) {
        abstractByteBuf.checkIndex(i6, i8);
        if (i8 != 0) {
            PlatformDependent.copyMemory(bArr, i7, j6, i8);
        }
    }

    static void setBytes(AbstractByteBuf abstractByteBuf, long j6, int i6, ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        if (remaining == 0) {
            return;
        }
        if (byteBuffer.isDirect()) {
            abstractByteBuf.checkIndex(i6, remaining);
            PlatformDependent.copyMemory(PlatformDependent.directBufferAddress(byteBuffer) + byteBuffer.position(), j6, remaining);
            byteBuffer.position(byteBuffer.position() + remaining);
        } else if (byteBuffer.hasArray()) {
            abstractByteBuf.checkIndex(i6, remaining);
            PlatformDependent.copyMemory(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), j6, remaining);
            byteBuffer.position(byteBuffer.position() + remaining);
        } else if (remaining < 8) {
            setSingleBytes(abstractByteBuf, j6, i6, byteBuffer, remaining);
        } else {
            abstractByteBuf.internalNioBuffer(i6, remaining).put(byteBuffer);
        }
    }

    static void getBytes(AbstractByteBuf abstractByteBuf, long j6, int i6, OutputStream outputStream, int i7) throws IOException {
        abstractByteBuf.checkIndex(i6, i7);
        if (i7 != 0) {
            int min = Math.min(i7, 8192);
            if (min > 1024 && abstractByteBuf.alloc().isDirectBufferPooled()) {
                ByteBuf heapBuffer = abstractByteBuf.alloc().heapBuffer(min);
                try {
                    getBytes(j6, heapBuffer.array(), heapBuffer.arrayOffset(), min, outputStream, i7);
                    return;
                } finally {
                    heapBuffer.release();
                }
            }
            getBytes(j6, ByteBufUtil.threadLocalTempArray(min), 0, min, outputStream, i7);
        }
    }

    private static void getBytes(long j6, byte[] bArr, int i6, int i7, OutputStream outputStream, int i8) throws IOException {
        long j7 = j6;
        while (true) {
            int min = Math.min(i7, i8);
            long j8 = min;
            byte[] bArr2 = bArr;
            int i9 = i6;
            PlatformDependent.copyMemory(j7, bArr2, i9, j8);
            outputStream.write(bArr2, i9, min);
            i8 -= min;
            j7 += j8;
            if (i8 <= 0) {
                return;
            }
            bArr = bArr2;
            i6 = i9;
        }
    }
}
