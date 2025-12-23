package io.netty.handler.codec.http.websocketx;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;
import io.netty.handler.codec.TooLongFrameException;
import io.netty.util.internal.ObjectUtil;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class WebSocket00FrameDecoder extends ReplayingDecoder<Void> implements WebSocketFrameDecoder {
    static final int DEFAULT_MAX_FRAME_SIZE = 16384;
    private final long maxFrameSize;
    private boolean receivedClosingHandshake;

    public WebSocket00FrameDecoder() {
        this(16384);
    }

    public WebSocket00FrameDecoder(int i6) {
        this.maxFrameSize = i6;
    }

    private WebSocketFrame decodeBinaryFrame(ChannelHandlerContext channelHandlerContext, byte b6, ByteBuf byteBuf) {
        byte readByte;
        long j6 = 0;
        int i6 = 0;
        do {
            readByte = byteBuf.readByte();
            j6 = (j6 << 7) | (readByte & Byte.MAX_VALUE);
            if (j6 > this.maxFrameSize) {
                throw new TooLongFrameException();
            }
            i6++;
            if (i6 > 8) {
                throw new TooLongFrameException();
            }
        } while ((readByte & 128) == 128);
        if (b6 != -1 || j6 != 0) {
            return new BinaryWebSocketFrame(ByteBufUtil.readBytes(channelHandlerContext.alloc(), byteBuf, (int) j6));
        }
        this.receivedClosingHandshake = true;
        return new CloseWebSocketFrame(true, 0, channelHandlerContext.alloc().buffer(0));
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        if (this.receivedClosingHandshake) {
            byteBuf.skipBytes(actualReadableBytes());
            return;
        }
        byte readByte = byteBuf.readByte();
        WebSocketFrame decodeBinaryFrame = (readByte & 128) == 128 ? decodeBinaryFrame(channelHandlerContext, readByte, byteBuf) : decodeTextFrame(channelHandlerContext, byteBuf);
        if (decodeBinaryFrame != null) {
            list.add(decodeBinaryFrame);
        }
    }

    private WebSocketFrame decodeTextFrame(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) {
        int readerIndex = byteBuf.readerIndex();
        int actualReadableBytes = actualReadableBytes();
        int indexOf = byteBuf.indexOf(readerIndex, readerIndex + actualReadableBytes, (byte) -1);
        if (indexOf == -1) {
            if (actualReadableBytes <= this.maxFrameSize) {
                return null;
            }
            throw new TooLongFrameException();
        }
        int i6 = indexOf - readerIndex;
        if (i6 <= this.maxFrameSize) {
            ByteBuf readBytes = ByteBufUtil.readBytes(channelHandlerContext.alloc(), byteBuf, i6);
            byteBuf.skipBytes(1);
            if (readBytes.indexOf(readBytes.readerIndex(), readBytes.writerIndex(), (byte) -1) < 0) {
                return new TextWebSocketFrame(readBytes);
            }
            readBytes.release();
            throw new IllegalArgumentException("a text frame should not contain 0xFF.");
        }
        throw new TooLongFrameException();
    }

    public WebSocket00FrameDecoder(WebSocketDecoderConfig webSocketDecoderConfig) {
        this.maxFrameSize = ((WebSocketDecoderConfig) ObjectUtil.checkNotNull(webSocketDecoderConfig, "decoderConfig")).maxFramePayloadLength();
    }
}
