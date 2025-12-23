package io.netty.handler.codec.compression;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufInputStream;
import io.netty.buffer.ByteBufOutputStream;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import lzma.sdk.ICodeProgress;
import lzma.sdk.lzma.Encoder;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class LzmaFrameEncoder extends MessageToByteEncoder<ByteBuf> {
    private static final int DEFAULT_LC = 3;
    private static final int DEFAULT_LP = 0;
    private static final int DEFAULT_MATCH_FINDER = 1;
    private static final int DEFAULT_PB = 2;
    private static final int MAX_FAST_BYTES = 273;
    private static final int MEDIUM_DICTIONARY_SIZE = 65536;
    private static final int MEDIUM_FAST_BYTES = 32;
    private static final int MIN_FAST_BYTES = 5;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) LzmaFrameEncoder.class);
    private static boolean warningLogged;
    private final Encoder encoder;
    private final int littleEndianDictionarySize;
    private final byte properties;

    public LzmaFrameEncoder() {
        this(65536);
    }

    public LzmaFrameEncoder(int i6, int i7, int i8) {
        this(i6, i7, i8, 65536);
    }

    private static int maxOutputBufferLength(int i6) {
        return ((int) (i6 * (i6 < 200 ? 1.5d : i6 < 500 ? 1.2d : i6 < 1000 ? 1.1d : i6 < 10000 ? 1.05d : 1.02d))) + 13;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.MessageToByteEncoder
    public ByteBuf allocateBuffer(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, boolean z5) throws Exception {
        return channelHandlerContext.alloc().ioBuffer(maxOutputBufferLength(byteBuf.readableBytes()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.MessageToByteEncoder
    public void encode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, ByteBuf byteBuf2) throws Exception {
        Throwable th;
        ByteBufOutputStream byteBufOutputStream;
        ByteBufInputStream byteBufInputStream;
        int readableBytes = byteBuf.readableBytes();
        ByteBufInputStream byteBufInputStream2 = null;
        try {
            byteBufInputStream = new ByteBufInputStream(byteBuf);
            try {
                byteBufOutputStream = new ByteBufOutputStream(byteBuf2);
            } catch (Throwable th2) {
                th = th2;
                byteBufOutputStream = null;
            }
        } catch (Throwable th3) {
            th = th3;
            byteBufOutputStream = null;
        }
        try {
            byteBufOutputStream.writeByte(this.properties);
            byteBufOutputStream.writeInt(this.littleEndianDictionarySize);
            byteBufOutputStream.writeLong(Long.reverseBytes(readableBytes));
            this.encoder.code(byteBufInputStream, byteBufOutputStream, -1L, -1L, (ICodeProgress) null);
            byteBufInputStream.close();
            byteBufOutputStream.close();
        } catch (Throwable th4) {
            th = th4;
            byteBufInputStream2 = byteBufInputStream;
            if (byteBufInputStream2 != null) {
                byteBufInputStream2.close();
            }
            if (byteBufOutputStream == null) {
                throw th;
            }
            byteBufOutputStream.close();
            throw th;
        }
    }

    public LzmaFrameEncoder(int i6) {
        this(3, 0, 2, i6);
    }

    public LzmaFrameEncoder(int i6, int i7, int i8, int i9) {
        this(i6, i7, i8, i9, false, 32);
    }

    public LzmaFrameEncoder(int i6, int i7, int i8, int i9, boolean z5, int i10) {
        if (i6 < 0 || i6 > 8) {
            throw new IllegalArgumentException("lc: " + i6 + " (expected: 0-8)");
        }
        if (i7 < 0 || i7 > 4) {
            throw new IllegalArgumentException("lp: " + i7 + " (expected: 0-4)");
        }
        if (i8 < 0 || i8 > 4) {
            throw new IllegalArgumentException("pb: " + i8 + " (expected: 0-4)");
        }
        if (i6 + i7 > 4 && !warningLogged) {
            logger.warn("The latest versions of LZMA libraries (for example, XZ Utils) has an additional requirement: lc + lp <= 4. Data which don't follow this requirement cannot be decompressed with this libraries.");
            warningLogged = true;
        }
        if (i9 < 0) {
            throw new IllegalArgumentException("dictionarySize: " + i9 + " (expected: 0+)");
        }
        if (i10 >= 5 && i10 <= 273) {
            Encoder encoder = new Encoder();
            this.encoder = encoder;
            encoder.setDictionarySize(i9);
            encoder.setEndMarkerMode(z5);
            encoder.setMatchFinder(1);
            encoder.setNumFastBytes(i10);
            encoder.setLcLpPb(i6, i7, i8);
            this.properties = (byte) ((((i8 * 5) + i7) * 9) + i6);
            this.littleEndianDictionarySize = Integer.reverseBytes(i9);
            return;
        }
        throw new IllegalArgumentException(String.format("numFastBytes: %d (expected: %d-%d)", Integer.valueOf(i10), 5, 273));
    }
}
