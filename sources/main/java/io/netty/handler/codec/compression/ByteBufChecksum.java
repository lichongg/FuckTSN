package io.netty.handler.codec.compression;

import io.netty.buffer.ByteBuf;
import io.netty.util.ByteProcessor;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.zip.Adler32;
import java.util.zip.CRC32;
import java.util.zip.Checksum;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
abstract class ByteBufChecksum implements Checksum {
    private static final Method ADLER32_UPDATE_METHOD = updateByteBuffer(new Adler32());
    private static final Method CRC32_UPDATE_METHOD = updateByteBuffer(new CRC32());
    private final ByteProcessor updateProcessor = new ByteProcessor() { // from class: io.netty.handler.codec.compression.ByteBufChecksum.1
        @Override // io.netty.util.ByteProcessor
        public boolean process(byte b6) throws Exception {
            ByteBufChecksum.this.update(b6);
            return true;
        }
    };

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class SlowByteBufChecksum extends ByteBufChecksum {
        protected final Checksum checksum;

        @Override // java.util.zip.Checksum
        public void update(int i6) {
            this.checksum.update(i6);
        }

        @Override // java.util.zip.Checksum
        public long getValue() {
            return this.checksum.getValue();
        }

        @Override // java.util.zip.Checksum
        public void reset() {
            this.checksum.reset();
        }

        @Override // java.util.zip.Checksum
        public void update(byte[] bArr, int i6, int i7) {
            this.checksum.update(bArr, i6, i7);
        }

        SlowByteBufChecksum(Checksum checksum) {
            this.checksum = checksum;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class ReflectiveByteBufChecksum extends SlowByteBufChecksum {
        private final Method method;

        ReflectiveByteBufChecksum(Checksum checksum, Method method) {
            super(checksum);
            this.method = method;
        }

        @Override // io.netty.handler.codec.compression.ByteBufChecksum
        public void update(ByteBuf byteBuf, int i6, int i7) {
            if (byteBuf.hasArray()) {
                update(byteBuf.array(), byteBuf.arrayOffset() + i6, i7);
            } else {
                this.method.invoke(this.checksum, CompressionUtil.safeNioBuffer(byteBuf, i6, i7));
            }
        }
    }

    static ByteBufChecksum wrapChecksum(Checksum checksum) {
        Method method;
        Method method2;
        ObjectUtil.checkNotNull(checksum, "checksum");
        return checksum instanceof ByteBufChecksum ? (ByteBufChecksum) checksum : (!(checksum instanceof Adler32) || (method2 = ADLER32_UPDATE_METHOD) == null) ? (!(checksum instanceof CRC32) || (method = CRC32_UPDATE_METHOD) == null) ? new SlowByteBufChecksum(checksum) : new ReflectiveByteBufChecksum(checksum, method) : new ReflectiveByteBufChecksum(checksum, method2);
    }

    ByteBufChecksum() {
    }

    private static Method updateByteBuffer(Checksum checksum) {
        if (PlatformDependent.javaVersion() >= 8) {
            try {
                Method declaredMethod = checksum.getClass().getDeclaredMethod("update", ByteBuffer.class);
                declaredMethod.invoke(checksum, ByteBuffer.allocate(1));
                return declaredMethod;
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public void update(ByteBuf byteBuf, int i6, int i7) {
        if (byteBuf.hasArray()) {
            update(byteBuf.array(), byteBuf.arrayOffset() + i6, i7);
        } else {
            byteBuf.forEachByte(i6, i7, this.updateProcessor);
        }
    }
}
