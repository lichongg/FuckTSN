package io.netty.handler.codec.protobuf;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.CorruptedFrameException;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class ProtobufVarint32FrameDecoder extends ByteToMessageDecoder {
    private static int readRawVarint32(ByteBuf byteBuf) {
        int i6;
        if (!byteBuf.isReadable()) {
            return 0;
        }
        byteBuf.markReaderIndex();
        byte readByte = byteBuf.readByte();
        if (readByte >= 0) {
            return readByte;
        }
        int i7 = readByte & Byte.MAX_VALUE;
        if (!byteBuf.isReadable()) {
            byteBuf.resetReaderIndex();
            return 0;
        }
        byte readByte2 = byteBuf.readByte();
        if (readByte2 >= 0) {
            i6 = readByte2 << 7;
        } else {
            i7 |= (readByte2 & Byte.MAX_VALUE) << 7;
            if (!byteBuf.isReadable()) {
                byteBuf.resetReaderIndex();
                return 0;
            }
            byte readByte3 = byteBuf.readByte();
            if (readByte3 >= 0) {
                i6 = readByte3 << 14;
            } else {
                i7 |= (readByte3 & Byte.MAX_VALUE) << 14;
                if (!byteBuf.isReadable()) {
                    byteBuf.resetReaderIndex();
                    return 0;
                }
                byte readByte4 = byteBuf.readByte();
                if (readByte4 >= 0) {
                    i6 = readByte4 << 21;
                } else {
                    int i8 = i7 | ((readByte4 & Byte.MAX_VALUE) << 21);
                    if (!byteBuf.isReadable()) {
                        byteBuf.resetReaderIndex();
                        return 0;
                    }
                    byte readByte5 = byteBuf.readByte();
                    int i9 = i8 | (readByte5 << 28);
                    if (readByte5 >= 0) {
                        return i9;
                    }
                    throw new CorruptedFrameException("malformed varint.");
                }
            }
        }
        return i6 | i7;
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        byteBuf.markReaderIndex();
        int readerIndex = byteBuf.readerIndex();
        int readRawVarint32 = readRawVarint32(byteBuf);
        if (readerIndex == byteBuf.readerIndex()) {
            return;
        }
        if (readRawVarint32 >= 0) {
            if (byteBuf.readableBytes() < readRawVarint32) {
                byteBuf.resetReaderIndex();
                return;
            } else {
                list.add(byteBuf.readRetainedSlice(readRawVarint32));
                return;
            }
        }
        throw new CorruptedFrameException("negative length: " + readRawVarint32);
    }
}
