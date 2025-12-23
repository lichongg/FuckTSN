package io.netty.handler.codec.http.websocketx;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;
import io.netty.handler.codec.TooLongFrameException;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class WebSocket08FrameEncoder extends MessageToMessageEncoder<WebSocketFrame> implements WebSocketFrameEncoder {
    private static final int GATHERING_WRITE_THRESHOLD = 1024;
    private static final byte OPCODE_BINARY = 2;
    private static final byte OPCODE_CLOSE = 8;
    private static final byte OPCODE_CONT = 0;
    private static final byte OPCODE_PING = 9;
    private static final byte OPCODE_PONG = 10;
    private static final byte OPCODE_TEXT = 1;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) WebSocket08FrameEncoder.class);
    private final boolean maskPayload;

    @Override // io.netty.handler.codec.MessageToMessageEncoder
    protected /* bridge */ /* synthetic */ void encode(ChannelHandlerContext channelHandlerContext, WebSocketFrame webSocketFrame, List list) throws Exception {
        encode2(channelHandlerContext, webSocketFrame, (List<Object>) list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14, types: [io.netty.util.ReferenceCounted] */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* renamed from: encode, reason: avoid collision after fix types in other method */
    protected void encode2(ChannelHandlerContext channelHandlerContext, WebSocketFrame webSocketFrame, List<Object> list) throws Exception {
        int i6;
        ?? r42;
        boolean z5;
        int i7;
        ByteBuf buffer;
        ByteBuf content = webSocketFrame.content();
        int i8 = 0;
        if (webSocketFrame instanceof TextWebSocketFrame) {
            i6 = 1;
        } else if (webSocketFrame instanceof PingWebSocketFrame) {
            i6 = 9;
        } else if (webSocketFrame instanceof PongWebSocketFrame) {
            i6 = 10;
        } else if (webSocketFrame instanceof CloseWebSocketFrame) {
            i6 = 8;
        } else if (webSocketFrame instanceof BinaryWebSocketFrame) {
            i6 = 2;
        } else {
            if (!(webSocketFrame instanceof ContinuationWebSocketFrame)) {
                throw new UnsupportedOperationException("Cannot encode frame of type: " + webSocketFrame.getClass().getName());
            }
            i6 = 0;
        }
        int readableBytes = content.readableBytes();
        InternalLogger internalLogger = logger;
        if (internalLogger.isDebugEnabled()) {
            internalLogger.debug("Encoding WebSocket Frame opCode=" + i6 + " length=" + readableBytes);
        }
        int rsv = ((webSocketFrame.rsv() % 8) << 4) | (webSocketFrame.isFinalFragment() ? 128 : 0) | (i6 % 128);
        if (i6 == 9 && readableBytes > 125) {
            throw new TooLongFrameException("invalid payload for PING (payload length must be <= 125, was " + readableBytes);
        }
        try {
            z5 = this.maskPayload;
            i7 = z5 ? 4 : 0;
            r42 = 1024;
        } catch (Throwable th) {
            th = th;
            r42 = 0;
        }
        try {
            if (readableBytes <= 125) {
                int i9 = i7 + 2;
                if (z5 || readableBytes <= 1024) {
                    i9 += readableBytes;
                }
                buffer = channelHandlerContext.alloc().buffer(i9);
                buffer.writeByte(rsv);
                buffer.writeByte((byte) (this.maskPayload ? ((byte) readableBytes) | 128 : (byte) readableBytes));
            } else if (readableBytes <= 65535) {
                int i10 = i7 + 4;
                if (z5 || readableBytes <= 1024) {
                    i10 += readableBytes;
                }
                buffer = channelHandlerContext.alloc().buffer(i10);
                buffer.writeByte(rsv);
                buffer.writeByte(this.maskPayload ? 254 : 126);
                buffer.writeByte((readableBytes >>> 8) & 255);
                buffer.writeByte(readableBytes & 255);
            } else {
                int i11 = i7 + 10;
                if (z5 || readableBytes <= 1024) {
                    i11 += readableBytes;
                }
                buffer = channelHandlerContext.alloc().buffer(i11);
                buffer.writeByte(rsv);
                buffer.writeByte(this.maskPayload ? 255 : 127);
                buffer.writeLong(readableBytes);
            }
            if (!this.maskPayload) {
                if (buffer.writableBytes() >= content.readableBytes()) {
                    buffer.writeBytes(content);
                    list.add(buffer);
                    return;
                } else {
                    list.add(buffer);
                    list.add(content.retain());
                    return;
                }
            }
            byte[] array = ByteBuffer.allocate(4).putInt((int) (Math.random() * 2.147483647E9d)).array();
            buffer.writeBytes(array);
            ByteOrder order = content.order();
            ByteOrder order2 = buffer.order();
            int readerIndex = content.readerIndex();
            int writerIndex = content.writerIndex();
            if (order == order2) {
                int i12 = (255 & array[3]) | ((array[2] & 255) << 8) | ((array[1] & 255) << 16) | ((array[0] & 255) << 24);
                if (order == ByteOrder.LITTLE_ENDIAN) {
                    i12 = Integer.reverseBytes(i12);
                }
                while (readerIndex + 3 < writerIndex) {
                    buffer.writeInt(content.getInt(readerIndex) ^ i12);
                    readerIndex += 4;
                }
            }
            while (readerIndex < writerIndex) {
                buffer.writeByte(content.getByte(readerIndex) ^ array[i8 % 4]);
                readerIndex++;
                i8++;
            }
            list.add(buffer);
        } catch (Throwable th2) {
            th = th2;
            if (r42 != 0) {
                r42.release();
            }
            throw th;
        }
    }

    public WebSocket08FrameEncoder(boolean z5) {
        this.maskPayload = z5;
    }
}
