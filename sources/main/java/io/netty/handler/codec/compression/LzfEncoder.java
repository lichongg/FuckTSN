package io.netty.handler.codec.compression;

import com.ning.compress.BufferRecycler;
import com.ning.compress.lzf.ChunkEncoder;
import com.ning.compress.lzf.LZFEncoder;
import com.ning.compress.lzf.util.ChunkEncoderFactory;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class LzfEncoder extends MessageToByteEncoder<ByteBuf> {
    private static final int MIN_BLOCK_TO_COMPRESS = 16;
    private final ChunkEncoder encoder;
    private final BufferRecycler recycler;

    public LzfEncoder() {
        this(false, 65535);
    }

    public LzfEncoder(boolean z5) {
        this(z5, 65535);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.MessageToByteEncoder
    public void encode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, ByteBuf byteBuf2) throws Exception {
        byte[] allocInputBuffer;
        int i6;
        int readableBytes = byteBuf.readableBytes();
        int readerIndex = byteBuf.readerIndex();
        if (byteBuf.hasArray()) {
            allocInputBuffer = byteBuf.array();
            i6 = byteBuf.arrayOffset() + readerIndex;
        } else {
            allocInputBuffer = this.recycler.allocInputBuffer(readableBytes);
            byteBuf.getBytes(readerIndex, allocInputBuffer, 0, readableBytes);
            i6 = 0;
        }
        byte[] bArr = allocInputBuffer;
        byteBuf2.ensureWritable(LZFEncoder.estimateMaxWorkspaceSize(readableBytes));
        byte[] array = byteBuf2.array();
        int arrayOffset = byteBuf2.arrayOffset() + byteBuf2.writerIndex();
        byteBuf2.writerIndex(byteBuf2.writerIndex() + (LZFEncoder.appendEncoded(this.encoder, bArr, i6, readableBytes, array, arrayOffset) - arrayOffset));
        byteBuf.skipBytes(readableBytes);
        if (byteBuf.hasArray()) {
            return;
        }
        this.recycler.releaseInputBuffer(bArr);
    }

    public LzfEncoder(int i6) {
        this(false, i6);
    }

    public LzfEncoder(boolean z5, int i6) {
        super(false);
        ChunkEncoder optimalNonAllocatingInstance;
        if (i6 >= 16 && i6 <= 65535) {
            if (z5) {
                optimalNonAllocatingInstance = ChunkEncoderFactory.safeNonAllocatingInstance(i6);
            } else {
                optimalNonAllocatingInstance = ChunkEncoderFactory.optimalNonAllocatingInstance(i6);
            }
            this.encoder = optimalNonAllocatingInstance;
            this.recycler = BufferRecycler.instance();
            return;
        }
        throw new IllegalArgumentException("totalLength: " + i6 + " (expected: 16-65535)");
    }
}
