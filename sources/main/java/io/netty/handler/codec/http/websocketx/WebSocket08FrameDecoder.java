package io.netty.handler.codec.http.websocketx;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.TooLongFrameException;
import io.netty.util.ReferenceCounted;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.nio.ByteOrder;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class WebSocket08FrameDecoder extends ByteToMessageDecoder implements WebSocketFrameDecoder {
    private static final byte OPCODE_BINARY = 2;
    private static final byte OPCODE_CLOSE = 8;
    private static final byte OPCODE_CONT = 0;
    private static final byte OPCODE_PING = 9;
    private static final byte OPCODE_PONG = 10;
    private static final byte OPCODE_TEXT = 1;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) WebSocket08FrameDecoder.class);
    private final WebSocketDecoderConfig config;
    private int fragmentedFramesCount;
    private boolean frameFinalFlag;
    private boolean frameMasked;
    private int frameOpcode;
    private int framePayloadLen1;
    private long framePayloadLength;
    private int frameRsv;
    private byte[] maskingKey;
    private boolean receivedClosingHandshake;
    private State state;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    enum State {
        READING_FIRST,
        READING_SECOND,
        READING_SIZE,
        MASKING_KEY,
        PAYLOAD,
        CORRUPT
    }

    public WebSocket08FrameDecoder(boolean z5, boolean z6, int i6) {
        this(z5, z6, i6, false);
    }

    private void protocolViolation(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, String str) {
        protocolViolation(channelHandlerContext, byteBuf, WebSocketCloseStatus.PROTOCOL_ERROR, str);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: io.netty.handler.codec.http.websocketx.WebSocket08FrameDecoder$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$http$websocketx$WebSocket08FrameDecoder$State;

        static {
            int[] iArr = new int[State.values().length];
            $SwitchMap$io$netty$handler$codec$http$websocketx$WebSocket08FrameDecoder$State = iArr;
            try {
                iArr[State.READING_FIRST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$websocketx$WebSocket08FrameDecoder$State[State.READING_SECOND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$websocketx$WebSocket08FrameDecoder$State[State.READING_SIZE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$websocketx$WebSocket08FrameDecoder$State[State.MASKING_KEY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$websocketx$WebSocket08FrameDecoder$State[State.PAYLOAD.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$websocketx$WebSocket08FrameDecoder$State[State.CORRUPT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public WebSocket08FrameDecoder(boolean z5, boolean z6, int i6, boolean z7) {
        this(WebSocketDecoderConfig.newBuilder().expectMaskedFrames(z5).allowExtensions(z6).maxFramePayloadLength(i6).allowMaskMismatch(z7).build());
    }

    private void protocolViolation(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, WebSocketCloseStatus webSocketCloseStatus, String str) {
        protocolViolation(channelHandlerContext, byteBuf, new CorruptedWebSocketFrameException(webSocketCloseStatus, str));
    }

    protected void checkCloseFrameBody(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) {
        if (byteBuf == null || !byteBuf.isReadable()) {
            return;
        }
        if (byteBuf.readableBytes() == 1) {
            protocolViolation(channelHandlerContext, byteBuf, WebSocketCloseStatus.INVALID_PAYLOAD_DATA, "Invalid close frame body");
        }
        int readerIndex = byteBuf.readerIndex();
        byteBuf.readerIndex(0);
        short readShort = byteBuf.readShort();
        if (!WebSocketCloseStatus.isValidStatusCode(readShort)) {
            protocolViolation(channelHandlerContext, byteBuf, "Invalid close frame getStatus code: " + ((int) readShort));
        }
        if (byteBuf.isReadable()) {
            try {
                new Utf8Validator().check(byteBuf);
            } catch (CorruptedWebSocketFrameException e6) {
                protocolViolation(channelHandlerContext, byteBuf, e6);
            }
        }
        byteBuf.readerIndex(readerIndex);
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        int i6;
        if (this.receivedClosingHandshake) {
            byteBuf.skipBytes(actualReadableBytes());
            return;
        }
        switch (AnonymousClass1.$SwitchMap$io$netty$handler$codec$http$websocketx$WebSocket08FrameDecoder$State[this.state.ordinal()]) {
            case 1:
                if (!byteBuf.isReadable()) {
                    return;
                }
                this.framePayloadLength = 0L;
                byte readByte = byteBuf.readByte();
                this.frameFinalFlag = (readByte & 128) != 0;
                this.frameRsv = (readByte & 112) >> 4;
                this.frameOpcode = readByte & 15;
                InternalLogger internalLogger = logger;
                if (internalLogger.isDebugEnabled()) {
                    internalLogger.debug("Decoding WebSocket Frame opCode={}", Integer.valueOf(this.frameOpcode));
                }
                this.state = State.READING_SECOND;
            case 2:
                if (!byteBuf.isReadable()) {
                    return;
                }
                byte readByte2 = byteBuf.readByte();
                this.frameMasked = (readByte2 & 128) != 0;
                this.framePayloadLen1 = readByte2 & Byte.MAX_VALUE;
                if (this.frameRsv != 0 && !this.config.allowExtensions()) {
                    protocolViolation(channelHandlerContext, byteBuf, "RSV != 0 and no extension negotiated, RSV:" + this.frameRsv);
                    return;
                }
                if (!this.config.allowMaskMismatch() && this.config.expectMaskedFrames() != this.frameMasked) {
                    protocolViolation(channelHandlerContext, byteBuf, "received a frame that is not masked as expected");
                    return;
                }
                int i7 = this.frameOpcode;
                if (i7 > 7) {
                    if (!this.frameFinalFlag) {
                        protocolViolation(channelHandlerContext, byteBuf, "fragmented control frame");
                        return;
                    }
                    int i8 = this.framePayloadLen1;
                    if (i8 > 125) {
                        protocolViolation(channelHandlerContext, byteBuf, "control frame with payload length > 125 octets");
                        return;
                    }
                    if (i7 != 8 && i7 != 9 && i7 != 10) {
                        protocolViolation(channelHandlerContext, byteBuf, "control frame using reserved opcode " + this.frameOpcode);
                        return;
                    }
                    if (i7 == 8 && i8 == 1) {
                        protocolViolation(channelHandlerContext, byteBuf, "received close control frame with payload len 1");
                        return;
                    }
                } else {
                    if (i7 != 0 && i7 != 1 && i7 != 2) {
                        protocolViolation(channelHandlerContext, byteBuf, "data frame using reserved opcode " + this.frameOpcode);
                        return;
                    }
                    int i9 = this.fragmentedFramesCount;
                    if (i9 == 0 && i7 == 0) {
                        protocolViolation(channelHandlerContext, byteBuf, "received continuation data frame outside fragmented message");
                        return;
                    } else if (i9 != 0 && i7 != 0 && i7 != 9) {
                        protocolViolation(channelHandlerContext, byteBuf, "received non-continuation data frame while inside fragmented message");
                        return;
                    }
                }
                this.state = State.READING_SIZE;
                break;
            case 3:
                int i10 = this.framePayloadLen1;
                if (i10 == 126) {
                    if (byteBuf.readableBytes() < 2) {
                        return;
                    }
                    long readUnsignedShort = byteBuf.readUnsignedShort();
                    this.framePayloadLength = readUnsignedShort;
                    if (readUnsignedShort < 126) {
                        protocolViolation(channelHandlerContext, byteBuf, "invalid data frame length (not using minimal length encoding)");
                        return;
                    }
                } else if (i10 != 127) {
                    this.framePayloadLength = i10;
                } else {
                    if (byteBuf.readableBytes() < 8) {
                        return;
                    }
                    long readLong = byteBuf.readLong();
                    this.framePayloadLength = readLong;
                    if (readLong < 65536) {
                        protocolViolation(channelHandlerContext, byteBuf, "invalid data frame length (not using minimal length encoding)");
                        return;
                    }
                }
                if (this.framePayloadLength > this.config.maxFramePayloadLength()) {
                    protocolViolation(channelHandlerContext, byteBuf, WebSocketCloseStatus.MESSAGE_TOO_BIG, "Max frame length of " + this.config.maxFramePayloadLength() + " has been exceeded.");
                    return;
                }
                InternalLogger internalLogger2 = logger;
                if (internalLogger2.isDebugEnabled()) {
                    internalLogger2.debug("Decoding WebSocket Frame length={}", Long.valueOf(this.framePayloadLength));
                }
                this.state = State.MASKING_KEY;
            case 4:
                if (this.frameMasked) {
                    if (byteBuf.readableBytes() < 4) {
                        return;
                    }
                    if (this.maskingKey == null) {
                        this.maskingKey = new byte[4];
                    }
                    byteBuf.readBytes(this.maskingKey);
                }
                this.state = State.PAYLOAD;
            case 5:
                if (byteBuf.readableBytes() < this.framePayloadLength) {
                    return;
                }
                ReferenceCounted referenceCounted = null;
                try {
                    ByteBuf readBytes = ByteBufUtil.readBytes(channelHandlerContext.alloc(), byteBuf, toFrameLength(this.framePayloadLength));
                    this.state = State.READING_FIRST;
                    if (this.frameMasked) {
                        unmask(readBytes);
                    }
                    int i11 = this.frameOpcode;
                    if (i11 == 9) {
                        list.add(new PingWebSocketFrame(this.frameFinalFlag, this.frameRsv, readBytes));
                        return;
                    }
                    if (i11 == 10) {
                        list.add(new PongWebSocketFrame(this.frameFinalFlag, this.frameRsv, readBytes));
                        return;
                    }
                    if (i11 == 8) {
                        this.receivedClosingHandshake = true;
                        checkCloseFrameBody(channelHandlerContext, readBytes);
                        list.add(new CloseWebSocketFrame(this.frameFinalFlag, this.frameRsv, readBytes));
                        return;
                    }
                    boolean z5 = this.frameFinalFlag;
                    if (z5) {
                        if (i11 != 9) {
                            this.fragmentedFramesCount = 0;
                        }
                        i6 = 1;
                    } else {
                        i6 = 1;
                        this.fragmentedFramesCount++;
                    }
                    if (i11 == i6) {
                        list.add(new TextWebSocketFrame(z5, this.frameRsv, readBytes));
                        return;
                    }
                    if (i11 == 2) {
                        list.add(new BinaryWebSocketFrame(z5, this.frameRsv, readBytes));
                        return;
                    } else {
                        if (i11 == 0) {
                            list.add(new ContinuationWebSocketFrame(z5, this.frameRsv, readBytes));
                            return;
                        }
                        throw new UnsupportedOperationException("Cannot decode web socket frame with opcode: " + this.frameOpcode);
                    }
                } catch (Throwable th) {
                    if (0 != 0) {
                        referenceCounted.release();
                    }
                    throw th;
                }
            case 6:
                if (byteBuf.isReadable()) {
                    byteBuf.readByte();
                    return;
                }
                return;
            default:
                throw new Error("Shouldn't reach here.");
        }
    }

    private void protocolViolation(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, CorruptedWebSocketFrameException corruptedWebSocketFrameException) {
        Object obj;
        this.state = State.CORRUPT;
        int readableBytes = byteBuf.readableBytes();
        if (readableBytes > 0) {
            byteBuf.skipBytes(readableBytes);
        }
        if (!channelHandlerContext.channel().isActive()) {
            throw corruptedWebSocketFrameException;
        }
        if (this.config.closeOnProtocolViolation()) {
            if (!this.receivedClosingHandshake) {
                WebSocketCloseStatus closeStatus = corruptedWebSocketFrameException.closeStatus();
                String message = corruptedWebSocketFrameException.getMessage();
                if (message == null) {
                    message = closeStatus.reasonText();
                }
                obj = new CloseWebSocketFrame(closeStatus, message);
            } else {
                obj = Unpooled.EMPTY_BUFFER;
            }
            channelHandlerContext.writeAndFlush(obj).addListener((GenericFutureListener<? extends Future<? super Void>>) ChannelFutureListener.CLOSE);
            throw corruptedWebSocketFrameException;
        }
        throw corruptedWebSocketFrameException;
    }

    private static int toFrameLength(long j6) {
        if (j6 <= 2147483647L) {
            return (int) j6;
        }
        throw new TooLongFrameException("Length:" + j6);
    }

    private void unmask(ByteBuf byteBuf) {
        int readerIndex = byteBuf.readerIndex();
        int writerIndex = byteBuf.writerIndex();
        ByteOrder order = byteBuf.order();
        byte[] bArr = this.maskingKey;
        int i6 = (bArr[3] & 255) | ((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8);
        if (order == ByteOrder.LITTLE_ENDIAN) {
            i6 = Integer.reverseBytes(i6);
        }
        while (readerIndex + 3 < writerIndex) {
            byteBuf.setInt(readerIndex, byteBuf.getInt(readerIndex) ^ i6);
            readerIndex += 4;
        }
        while (readerIndex < writerIndex) {
            byteBuf.setByte(readerIndex, byteBuf.getByte(readerIndex) ^ this.maskingKey[readerIndex % 4]);
            readerIndex++;
        }
    }

    public WebSocket08FrameDecoder(WebSocketDecoderConfig webSocketDecoderConfig) {
        this.state = State.READING_FIRST;
        this.config = (WebSocketDecoderConfig) ObjectUtil.checkNotNull(webSocketDecoderConfig, "decoderConfig");
    }
}
