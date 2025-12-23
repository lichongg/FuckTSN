package io.netty.handler.codec.http.websocketx.extensions.compression;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.CompositeByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.CodecException;
import io.netty.handler.codec.compression.ZlibCodecFactory;
import io.netty.handler.codec.compression.ZlibWrapper;
import io.netty.handler.codec.http.websocketx.BinaryWebSocketFrame;
import io.netty.handler.codec.http.websocketx.ContinuationWebSocketFrame;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;
import io.netty.handler.codec.http.websocketx.extensions.WebSocketExtensionDecoder;
import io.netty.handler.codec.http.websocketx.extensions.WebSocketExtensionFilter;
import io.netty.util.internal.ObjectUtil;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
abstract class DeflateDecoder extends WebSocketExtensionDecoder {
    static final ByteBuf FRAME_TAIL = Unpooled.unreleasableBuffer(Unpooled.wrappedBuffer(new byte[]{0, 0, -1, -1})).asReadOnly();
    private EmbeddedChannel decoder;
    private final WebSocketExtensionFilter extensionDecoderFilter;
    private final boolean noContext;

    protected abstract boolean appendFrameTail(WebSocketFrame webSocketFrame);

    @Override // io.netty.handler.codec.MessageToMessageDecoder
    protected /* bridge */ /* synthetic */ void decode(ChannelHandlerContext channelHandlerContext, WebSocketFrame webSocketFrame, List list) throws Exception {
        decode2(channelHandlerContext, webSocketFrame, (List<Object>) list);
    }

    protected abstract int newRsv(WebSocketFrame webSocketFrame);

    private void cleanup() {
        EmbeddedChannel embeddedChannel = this.decoder;
        if (embeddedChannel != null) {
            if (embeddedChannel.finish()) {
                while (true) {
                    ByteBuf byteBuf = (ByteBuf) this.decoder.readOutbound();
                    if (byteBuf == null) {
                        break;
                    } else {
                        byteBuf.release();
                    }
                }
            }
            this.decoder = null;
        }
    }

    /* renamed from: decode, reason: avoid collision after fix types in other method */
    protected void decode2(ChannelHandlerContext channelHandlerContext, WebSocketFrame webSocketFrame, List<Object> list) throws Exception {
        Object continuationWebSocketFrame;
        if (this.decoder == null) {
            if (!(webSocketFrame instanceof TextWebSocketFrame) && !(webSocketFrame instanceof BinaryWebSocketFrame)) {
                throw new CodecException("unexpected initial frame type: " + webSocketFrame.getClass().getName());
            }
            this.decoder = new EmbeddedChannel(ZlibCodecFactory.newZlibDecoder(ZlibWrapper.NONE));
        }
        boolean isReadable = webSocketFrame.content().isReadable();
        this.decoder.writeInbound(webSocketFrame.content().retain());
        if (appendFrameTail(webSocketFrame)) {
            this.decoder.writeInbound(FRAME_TAIL.duplicate());
        }
        CompositeByteBuf compositeBuffer = channelHandlerContext.alloc().compositeBuffer();
        while (true) {
            ByteBuf byteBuf = (ByteBuf) this.decoder.readInbound();
            if (byteBuf == null) {
                break;
            } else if (byteBuf.isReadable()) {
                compositeBuffer.addComponent(true, byteBuf);
            } else {
                byteBuf.release();
            }
        }
        if (isReadable && compositeBuffer.numComponents() <= 0) {
            compositeBuffer.release();
            throw new CodecException("cannot read uncompressed buffer");
        }
        if (webSocketFrame.isFinalFragment() && this.noContext) {
            cleanup();
        }
        if (webSocketFrame instanceof TextWebSocketFrame) {
            continuationWebSocketFrame = new TextWebSocketFrame(webSocketFrame.isFinalFragment(), newRsv(webSocketFrame), compositeBuffer);
        } else if (webSocketFrame instanceof BinaryWebSocketFrame) {
            continuationWebSocketFrame = new BinaryWebSocketFrame(webSocketFrame.isFinalFragment(), newRsv(webSocketFrame), compositeBuffer);
        } else {
            if (!(webSocketFrame instanceof ContinuationWebSocketFrame)) {
                throw new CodecException("unexpected frame type: " + webSocketFrame.getClass().getName());
            }
            continuationWebSocketFrame = new ContinuationWebSocketFrame(webSocketFrame.isFinalFragment(), newRsv(webSocketFrame), compositeBuffer);
        }
        list.add(continuationWebSocketFrame);
    }

    protected WebSocketExtensionFilter extensionDecoderFilter() {
        return this.extensionDecoderFilter;
    }

    DeflateDecoder(boolean z5, WebSocketExtensionFilter webSocketExtensionFilter) {
        this.noContext = z5;
        this.extensionDecoderFilter = (WebSocketExtensionFilter) ObjectUtil.checkNotNull(webSocketExtensionFilter, "extensionDecoderFilter");
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelInactive(ChannelHandlerContext channelHandlerContext) throws Exception {
        cleanup();
        super.channelInactive(channelHandlerContext);
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerRemoved(ChannelHandlerContext channelHandlerContext) throws Exception {
        cleanup();
        super.handlerRemoved(channelHandlerContext);
    }
}
