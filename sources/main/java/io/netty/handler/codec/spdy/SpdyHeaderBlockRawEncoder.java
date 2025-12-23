package io.netty.handler.codec.spdy;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class SpdyHeaderBlockRawEncoder extends SpdyHeaderBlockEncoder {
    private final int version;

    public SpdyHeaderBlockRawEncoder(SpdyVersion spdyVersion) {
        if (spdyVersion != null) {
            this.version = spdyVersion.getVersion();
            return;
        }
        throw new NullPointerException("version");
    }

    private static void setLengthField(ByteBuf byteBuf, int i6, int i7) {
        byteBuf.setInt(i6, i7);
    }

    private static void writeLengthField(ByteBuf byteBuf, int i6) {
        byteBuf.writeInt(i6);
    }

    @Override // io.netty.handler.codec.spdy.SpdyHeaderBlockEncoder
    public ByteBuf encode(ByteBufAllocator byteBufAllocator, SpdyHeadersFrame spdyHeadersFrame) throws Exception {
        Set<CharSequence> names = spdyHeadersFrame.headers().names();
        int size = names.size();
        if (size == 0) {
            return Unpooled.EMPTY_BUFFER;
        }
        if (size <= 65535) {
            ByteBuf heapBuffer = byteBufAllocator.heapBuffer();
            writeLengthField(heapBuffer, size);
            for (CharSequence charSequence : names) {
                writeLengthField(heapBuffer, charSequence.length());
                ByteBufUtil.writeAscii(heapBuffer, charSequence);
                int writerIndex = heapBuffer.writerIndex();
                writeLengthField(heapBuffer, 0);
                int i6 = 0;
                for (CharSequence charSequence2 : spdyHeadersFrame.headers().getAll(charSequence)) {
                    int length = charSequence2.length();
                    if (length > 0) {
                        ByteBufUtil.writeAscii(heapBuffer, charSequence2);
                        heapBuffer.writeByte(0);
                        i6 += length + 1;
                    }
                }
                if (i6 != 0) {
                    i6--;
                }
                if (i6 <= 65535) {
                    if (i6 > 0) {
                        setLengthField(heapBuffer, writerIndex, i6);
                        heapBuffer.writerIndex(heapBuffer.writerIndex() - 1);
                    }
                } else {
                    throw new IllegalArgumentException("header exceeds allowable length: " + ((Object) charSequence));
                }
            }
            return heapBuffer;
        }
        throw new IllegalArgumentException("header block contains too many headers");
    }

    @Override // io.netty.handler.codec.spdy.SpdyHeaderBlockEncoder
    void end() {
    }
}
