package io.netty.handler.codec.marshalling;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;
import io.netty.handler.codec.TooLongFrameException;
import io.netty.handler.codec.marshalling.LimitingByteInput;
import java.util.List;
import org.jboss.marshalling.ByteInput;
import org.jboss.marshalling.Unmarshaller;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class CompatibleMarshallingDecoder extends ReplayingDecoder<Void> {
    private boolean discardingTooLongFrame;
    protected final int maxObjectSize;
    protected final UnmarshallerProvider provider;

    @Override // io.netty.handler.codec.ByteToMessageDecoder
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        if (this.discardingTooLongFrame) {
            byteBuf.skipBytes(actualReadableBytes());
            checkpoint();
            return;
        }
        Unmarshaller unmarshaller = this.provider.getUnmarshaller(channelHandlerContext);
        ByteInput channelBufferByteInput = new ChannelBufferByteInput(byteBuf);
        if (this.maxObjectSize != Integer.MAX_VALUE) {
            channelBufferByteInput = new LimitingByteInput(channelBufferByteInput, this.maxObjectSize);
        }
        try {
            try {
                unmarshaller.start(channelBufferByteInput);
                Object readObject = unmarshaller.readObject();
                unmarshaller.finish();
                list.add(readObject);
            } catch (LimitingByteInput.TooBigObjectException unused) {
                this.discardingTooLongFrame = true;
                throw new TooLongFrameException();
            }
        } finally {
            unmarshaller.close();
        }
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler, io.netty.channel.ChannelInboundHandler
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th) throws Exception {
        if (th instanceof TooLongFrameException) {
            channelHandlerContext.close();
        } else {
            super.exceptionCaught(channelHandlerContext, th);
        }
    }

    public CompatibleMarshallingDecoder(UnmarshallerProvider unmarshallerProvider, int i6) {
        this.provider = unmarshallerProvider;
        this.maxObjectSize = i6;
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder
    protected void decodeLast(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        int readableBytes = byteBuf.readableBytes();
        if (readableBytes != 0) {
            if (readableBytes == 1 && byteBuf.getByte(byteBuf.readerIndex()) == 121) {
                byteBuf.skipBytes(1);
            } else {
                decode(channelHandlerContext, byteBuf, list);
            }
        }
    }
}
