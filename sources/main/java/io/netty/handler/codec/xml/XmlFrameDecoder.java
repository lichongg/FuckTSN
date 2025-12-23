package io.netty.handler.codec.xml;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.CorruptedFrameException;
import io.netty.handler.codec.TooLongFrameException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class XmlFrameDecoder extends ByteToMessageDecoder {
    private final int maxFrameLength;

    private void fail(long j6) {
        if (j6 <= 0) {
            throw new TooLongFrameException("frame length exceeds " + this.maxFrameLength + " - discarding");
        }
        throw new TooLongFrameException("frame length exceeds " + this.maxFrameLength + ": " + j6 + " - discarded");
    }

    private static boolean isValidStartCharForXmlElement(byte b6) {
        if (b6 < 97 || b6 > 122) {
            return (b6 >= 65 && b6 <= 90) || b6 == 58 || b6 == 95;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x0094, code lost:
    
        if (r15 == 63) goto L38;
     */
    @Override // io.netty.handler.codec.ByteToMessageDecoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void decode(io.netty.channel.ChannelHandlerContext r21, io.netty.buffer.ByteBuf r22, java.util.List<java.lang.Object> r23) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 272
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.xml.XmlFrameDecoder.decode(io.netty.channel.ChannelHandlerContext, io.netty.buffer.ByteBuf, java.util.List):void");
    }

    public XmlFrameDecoder(int i6) {
        if (i6 >= 1) {
            this.maxFrameLength = i6;
            return;
        }
        throw new IllegalArgumentException("maxFrameLength must be a positive int");
    }

    private static ByteBuf extractFrame(ByteBuf byteBuf, int i6, int i7) {
        return byteBuf.copy(i6, i7);
    }

    private static boolean isCDATABlockStart(ByteBuf byteBuf, int i6) {
        if (i6 < byteBuf.writerIndex() - 8 && byteBuf.getByte(i6 + 2) == 91 && byteBuf.getByte(i6 + 3) == 67 && byteBuf.getByte(i6 + 4) == 68 && byteBuf.getByte(i6 + 5) == 65 && byteBuf.getByte(i6 + 6) == 84 && byteBuf.getByte(i6 + 7) == 65 && byteBuf.getByte(i6 + 8) == 91) {
            return true;
        }
        return false;
    }

    private static boolean isCommentBlockStart(ByteBuf byteBuf, int i6) {
        if (i6 < byteBuf.writerIndex() - 3 && byteBuf.getByte(i6 + 2) == 45 && byteBuf.getByte(i6 + 3) == 45) {
            return true;
        }
        return false;
    }

    private static void fail(ChannelHandlerContext channelHandlerContext) {
        channelHandlerContext.fireExceptionCaught((Throwable) new CorruptedFrameException("frame contains content before the xml starts"));
    }
}
