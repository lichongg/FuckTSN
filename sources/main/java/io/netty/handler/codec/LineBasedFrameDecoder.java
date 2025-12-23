package io.netty.handler.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.ByteProcessor;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class LineBasedFrameDecoder extends ByteToMessageDecoder {
    private int discardedBytes;
    private boolean discarding;
    private final boolean failFast;
    private final int maxLength;
    private int offset;
    private final boolean stripDelimiter;

    public LineBasedFrameDecoder(int i6) {
        this(i6, true, false);
    }

    private void fail(ChannelHandlerContext channelHandlerContext, int i6) {
        fail(channelHandlerContext, String.valueOf(i6));
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder
    protected final void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        Object decode = decode(channelHandlerContext, byteBuf);
        if (decode != null) {
            list.add(decode);
        }
    }

    public LineBasedFrameDecoder(int i6, boolean z5, boolean z6) {
        this.maxLength = i6;
        this.failFast = z6;
        this.stripDelimiter = z5;
    }

    private void fail(ChannelHandlerContext channelHandlerContext, String str) {
        channelHandlerContext.fireExceptionCaught((Throwable) new TooLongFrameException("frame length (" + str + ") exceeds the allowed maximum (" + this.maxLength + ')'));
    }

    private int findEndOfLine(ByteBuf byteBuf) {
        int readableBytes = byteBuf.readableBytes();
        int readerIndex = byteBuf.readerIndex();
        int i6 = this.offset;
        int forEachByte = byteBuf.forEachByte(readerIndex + i6, readableBytes - i6, ByteProcessor.FIND_LF);
        if (forEachByte >= 0) {
            this.offset = 0;
            if (forEachByte > 0 && byteBuf.getByte(forEachByte - 1) == 13) {
                return forEachByte - 1;
            }
            return forEachByte;
        }
        this.offset = readableBytes;
        return forEachByte;
    }

    protected Object decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) throws Exception {
        int findEndOfLine = findEndOfLine(byteBuf);
        if (this.discarding) {
            if (findEndOfLine >= 0) {
                int readerIndex = (this.discardedBytes + findEndOfLine) - byteBuf.readerIndex();
                byteBuf.readerIndex(findEndOfLine + (byteBuf.getByte(findEndOfLine) != 13 ? 1 : 2));
                this.discardedBytes = 0;
                this.discarding = false;
                if (!this.failFast) {
                    fail(channelHandlerContext, readerIndex);
                }
            } else {
                this.discardedBytes += byteBuf.readableBytes();
                byteBuf.readerIndex(byteBuf.writerIndex());
                this.offset = 0;
            }
            return null;
        }
        if (findEndOfLine >= 0) {
            int readerIndex2 = findEndOfLine - byteBuf.readerIndex();
            int i6 = byteBuf.getByte(findEndOfLine) != 13 ? 1 : 2;
            if (readerIndex2 > this.maxLength) {
                byteBuf.readerIndex(findEndOfLine + i6);
                fail(channelHandlerContext, readerIndex2);
                return null;
            }
            if (this.stripDelimiter) {
                ByteBuf readRetainedSlice = byteBuf.readRetainedSlice(readerIndex2);
                byteBuf.skipBytes(i6);
                return readRetainedSlice;
            }
            return byteBuf.readRetainedSlice(readerIndex2 + i6);
        }
        int readableBytes = byteBuf.readableBytes();
        if (readableBytes > this.maxLength) {
            this.discardedBytes = readableBytes;
            byteBuf.readerIndex(byteBuf.writerIndex());
            this.discarding = true;
            this.offset = 0;
            if (this.failFast) {
                fail(channelHandlerContext, "over " + this.discardedBytes);
            }
        }
        return null;
    }
}
