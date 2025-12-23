package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http2.Http2FrameReader;
import io.netty.handler.codec.http2.Http2HeadersDecoder;
import io.netty.util.internal.PlatformDependent;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class DefaultHttp2FrameReader implements Http2FrameReader, Http2FrameSizePolicy, Http2FrameReader.Configuration {
    private Http2Flags flags;
    private byte frameType;
    private HeadersContinuation headersContinuation;
    private final Http2HeadersDecoder headersDecoder;
    private int maxFrameSize;
    private int payloadLength;
    private boolean readError;
    private boolean readingHeaders;
    private int streamId;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    protected class HeadersBlockBuilder {
        private ByteBuf headerBlock;

        protected HeadersBlockBuilder() {
        }

        final void addFragment(ByteBuf byteBuf, int i6, ByteBufAllocator byteBufAllocator, boolean z5) throws Http2Exception {
            if (this.headerBlock == null) {
                if (i6 > DefaultHttp2FrameReader.this.headersDecoder.configuration().maxHeaderListSizeGoAway()) {
                    headerSizeExceeded();
                }
                if (z5) {
                    this.headerBlock = byteBuf.readRetainedSlice(i6);
                    return;
                } else {
                    this.headerBlock = byteBufAllocator.buffer(i6).writeBytes(byteBuf, i6);
                    return;
                }
            }
            if (DefaultHttp2FrameReader.this.headersDecoder.configuration().maxHeaderListSizeGoAway() - i6 < this.headerBlock.readableBytes()) {
                headerSizeExceeded();
            }
            if (this.headerBlock.isWritable(i6)) {
                this.headerBlock.writeBytes(byteBuf, i6);
                return;
            }
            ByteBuf buffer = byteBufAllocator.buffer(this.headerBlock.readableBytes() + i6);
            buffer.writeBytes(this.headerBlock).writeBytes(byteBuf, i6);
            this.headerBlock.release();
            this.headerBlock = buffer;
        }

        void close() {
            ByteBuf byteBuf = this.headerBlock;
            if (byteBuf != null) {
                byteBuf.release();
                this.headerBlock = null;
            }
            DefaultHttp2FrameReader.this.headersContinuation = null;
        }

        Http2Headers headers() throws Http2Exception {
            try {
                return DefaultHttp2FrameReader.this.headersDecoder.decodeHeaders(DefaultHttp2FrameReader.this.streamId, this.headerBlock);
            } finally {
                close();
            }
        }

        private void headerSizeExceeded() throws Http2Exception {
            close();
            Http2CodecUtil.headerListSizeExceeded(DefaultHttp2FrameReader.this.headersDecoder.configuration().maxHeaderListSizeGoAway());
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private abstract class HeadersContinuation {
        private final HeadersBlockBuilder builder;

        private HeadersContinuation() {
            this.builder = DefaultHttp2FrameReader.this.new HeadersBlockBuilder();
        }

        abstract int getStreamId();

        abstract void processFragment(boolean z5, ByteBuf byteBuf, int i6, Http2FrameListener http2FrameListener) throws Http2Exception;

        final void close() {
            this.builder.close();
        }

        final HeadersBlockBuilder headersBlockBuilder() {
            return this.builder;
        }
    }

    public DefaultHttp2FrameReader() {
        this(true);
    }

    @Override // io.netty.handler.codec.http2.Http2FrameSizePolicy
    public void maxFrameSize(int i6) throws Http2Exception {
        if (!Http2CodecUtil.isMaxFrameSizeValid(i6)) {
            throw Http2Exception.streamError(this.streamId, Http2Error.FRAME_SIZE_ERROR, "Invalid MAX_FRAME_SIZE specified in sent settings: %d", Integer.valueOf(i6));
        }
        this.maxFrameSize = i6;
    }

    public DefaultHttp2FrameReader(boolean z5) {
        this(new DefaultHttp2HeadersDecoder(z5));
    }

    private void closeHeadersContinuation() {
        HeadersContinuation headersContinuation = this.headersContinuation;
        if (headersContinuation != null) {
            headersContinuation.close();
            this.headersContinuation = null;
        }
    }

    private static int lengthWithoutTrailingPadding(int i6, int i7) {
        return i7 == 0 ? i6 : i6 - (i7 - 1);
    }

    private void readContinuationFrame(ByteBuf byteBuf, int i6, Http2FrameListener http2FrameListener) throws Http2Exception {
        this.headersContinuation.processFragment(this.flags.endOfHeaders(), byteBuf, i6 - byteBuf.readerIndex(), http2FrameListener);
        resetHeadersContinuationIfEnd(this.flags.endOfHeaders());
    }

    private void readHeadersFrame(final ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, int i6, Http2FrameListener http2FrameListener) throws Http2Exception {
        final int i7 = this.streamId;
        final Http2Flags http2Flags = this.flags;
        final int readPadding = readPadding(byteBuf);
        verifyPadding(readPadding);
        if (!this.flags.priorityPresent()) {
            this.headersContinuation = new HeadersContinuation() { // from class: io.netty.handler.codec.http2.DefaultHttp2FrameReader.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super();
                }

                @Override // io.netty.handler.codec.http2.DefaultHttp2FrameReader.HeadersContinuation
                public int getStreamId() {
                    return i7;
                }

                @Override // io.netty.handler.codec.http2.DefaultHttp2FrameReader.HeadersContinuation
                public void processFragment(boolean z5, ByteBuf byteBuf2, int i8, Http2FrameListener http2FrameListener2) throws Http2Exception {
                    HeadersBlockBuilder headersBlockBuilder = headersBlockBuilder();
                    headersBlockBuilder.addFragment(byteBuf2, i8, channelHandlerContext.alloc(), z5);
                    if (z5) {
                        http2FrameListener2.onHeadersRead(channelHandlerContext, i7, headersBlockBuilder.headers(), readPadding, http2Flags.endOfStream());
                    }
                }
            };
            this.headersContinuation.processFragment(this.flags.endOfHeaders(), byteBuf, lengthWithoutTrailingPadding(i6 - byteBuf.readerIndex(), readPadding), http2FrameListener);
            resetHeadersContinuationIfEnd(this.flags.endOfHeaders());
            return;
        }
        long readUnsignedInt = byteBuf.readUnsignedInt();
        final boolean z5 = (IjkMediaMeta.AV_CH_WIDE_LEFT & readUnsignedInt) != 0;
        final int i8 = (int) (readUnsignedInt & 2147483647L);
        int i9 = this.streamId;
        if (i8 == i9) {
            throw Http2Exception.streamError(i9, Http2Error.PROTOCOL_ERROR, "A stream cannot depend on itself.", new Object[0]);
        }
        final short readUnsignedByte = (short) (byteBuf.readUnsignedByte() + 1);
        int lengthWithoutTrailingPadding = lengthWithoutTrailingPadding(i6 - byteBuf.readerIndex(), readPadding);
        HeadersContinuation headersContinuation = new HeadersContinuation() { // from class: io.netty.handler.codec.http2.DefaultHttp2FrameReader.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // io.netty.handler.codec.http2.DefaultHttp2FrameReader.HeadersContinuation
            public int getStreamId() {
                return i7;
            }

            @Override // io.netty.handler.codec.http2.DefaultHttp2FrameReader.HeadersContinuation
            public void processFragment(boolean z6, ByteBuf byteBuf2, int i10, Http2FrameListener http2FrameListener2) throws Http2Exception {
                HeadersBlockBuilder headersBlockBuilder = headersBlockBuilder();
                headersBlockBuilder.addFragment(byteBuf2, i10, channelHandlerContext.alloc(), z6);
                if (z6) {
                    http2FrameListener2.onHeadersRead(channelHandlerContext, i7, headersBlockBuilder.headers(), i8, readUnsignedByte, z5, readPadding, http2Flags.endOfStream());
                }
            }
        };
        this.headersContinuation = headersContinuation;
        headersContinuation.processFragment(this.flags.endOfHeaders(), byteBuf, lengthWithoutTrailingPadding, http2FrameListener);
        resetHeadersContinuationIfEnd(this.flags.endOfHeaders());
    }

    private int readPadding(ByteBuf byteBuf) {
        if (this.flags.paddingPresent()) {
            return byteBuf.readUnsignedByte() + 1;
        }
        return 0;
    }

    private void readPingFrame(ChannelHandlerContext channelHandlerContext, long j6, Http2FrameListener http2FrameListener) throws Http2Exception {
        if (this.flags.ack()) {
            http2FrameListener.onPingAckRead(channelHandlerContext, j6);
        } else {
            http2FrameListener.onPingRead(channelHandlerContext, j6);
        }
    }

    private void readPriorityFrame(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, Http2FrameListener http2FrameListener) throws Http2Exception {
        long readUnsignedInt = byteBuf.readUnsignedInt();
        boolean z5 = (IjkMediaMeta.AV_CH_WIDE_LEFT & readUnsignedInt) != 0;
        int i6 = (int) (readUnsignedInt & 2147483647L);
        int i7 = this.streamId;
        if (i6 == i7) {
            throw Http2Exception.streamError(i7, Http2Error.PROTOCOL_ERROR, "A stream cannot depend on itself.", new Object[0]);
        }
        http2FrameListener.onPriorityRead(channelHandlerContext, this.streamId, i6, (short) (byteBuf.readUnsignedByte() + 1), z5);
    }

    private void readPushPromiseFrame(final ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, int i6, Http2FrameListener http2FrameListener) throws Http2Exception {
        final int i7 = this.streamId;
        final int readPadding = readPadding(byteBuf);
        verifyPadding(readPadding);
        final int readUnsignedInt = Http2CodecUtil.readUnsignedInt(byteBuf);
        this.headersContinuation = new HeadersContinuation() { // from class: io.netty.handler.codec.http2.DefaultHttp2FrameReader.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // io.netty.handler.codec.http2.DefaultHttp2FrameReader.HeadersContinuation
            public int getStreamId() {
                return i7;
            }

            @Override // io.netty.handler.codec.http2.DefaultHttp2FrameReader.HeadersContinuation
            public void processFragment(boolean z5, ByteBuf byteBuf2, int i8, Http2FrameListener http2FrameListener2) throws Http2Exception {
                headersBlockBuilder().addFragment(byteBuf2, i8, channelHandlerContext.alloc(), z5);
                if (z5) {
                    http2FrameListener2.onPushPromiseRead(channelHandlerContext, i7, readUnsignedInt, headersBlockBuilder().headers(), readPadding);
                }
            }
        };
        this.headersContinuation.processFragment(this.flags.endOfHeaders(), byteBuf, lengthWithoutTrailingPadding(i6 - byteBuf.readerIndex(), readPadding), http2FrameListener);
        resetHeadersContinuationIfEnd(this.flags.endOfHeaders());
    }

    private void readSettingsFrame(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, Http2FrameListener http2FrameListener) throws Http2Exception {
        if (this.flags.ack()) {
            http2FrameListener.onSettingsAckRead(channelHandlerContext);
            return;
        }
        int i6 = this.payloadLength / 6;
        Http2Settings http2Settings = new Http2Settings();
        for (int i7 = 0; i7 < i6; i7++) {
            char readUnsignedShort = (char) byteBuf.readUnsignedShort();
            try {
                http2Settings.put(readUnsignedShort, Long.valueOf(byteBuf.readUnsignedInt()));
            } catch (IllegalArgumentException e6) {
                if (readUnsignedShort == 4) {
                    throw Http2Exception.connectionError(Http2Error.FLOW_CONTROL_ERROR, e6, e6.getMessage(), new Object[0]);
                }
                if (readUnsignedShort == 5) {
                    throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, e6, e6.getMessage(), new Object[0]);
                }
                throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, e6, e6.getMessage(), new Object[0]);
            }
        }
        http2FrameListener.onSettingsRead(channelHandlerContext, http2Settings);
    }

    private void resetHeadersContinuationIfEnd(boolean z5) {
        if (z5) {
            closeHeadersContinuation();
        }
    }

    private void verifyAssociatedWithAStream() throws Http2Exception {
        if (this.streamId == 0) {
            throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Frame of type %s must be associated with a stream.", Byte.valueOf(this.frameType));
        }
    }

    private void verifyNotProcessingHeaders() throws Http2Exception {
        if (this.headersContinuation != null) {
            throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Received frame of type %s while processing headers on stream %d.", Byte.valueOf(this.frameType), Integer.valueOf(this.headersContinuation.getStreamId()));
        }
    }

    private void verifyPadding(int i6) throws Http2Exception {
        if (lengthWithoutTrailingPadding(this.payloadLength, i6) < 0) {
            throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Frame payload too small for padding.", new Object[0]);
        }
    }

    private void verifyPayloadLength(int i6) throws Http2Exception {
        if (i6 > this.maxFrameSize) {
            throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Total payload length %d exceeds max frame length.", Integer.valueOf(i6));
        }
    }

    private static void verifyStreamOrConnectionId(int i6, String str) throws Http2Exception {
        if (i6 < 0) {
            throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "%s must be >= 0", str);
        }
    }

    @Override // io.netty.handler.codec.http2.Http2FrameReader.Configuration
    public Http2HeadersDecoder.Configuration headersConfiguration() {
        return this.headersDecoder.configuration();
    }

    @Override // io.netty.handler.codec.http2.Http2FrameReader
    public void readFrame(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, Http2FrameListener http2FrameListener) throws Http2Exception {
        if (this.readError) {
            byteBuf.skipBytes(byteBuf.readableBytes());
            return;
        }
        do {
            try {
                if (this.readingHeaders) {
                    processHeaderState(byteBuf);
                    if (this.readingHeaders) {
                        return;
                    }
                }
                processPayloadState(channelHandlerContext, byteBuf, http2FrameListener);
                if (!this.readingHeaders) {
                    return;
                }
            } catch (Http2Exception e6) {
                this.readError = !Http2Exception.isStreamError(e6);
                throw e6;
            } catch (RuntimeException e7) {
                this.readError = true;
                throw e7;
            } catch (Throwable th) {
                this.readError = true;
                PlatformDependent.throwException(th);
                return;
            }
        } while (byteBuf.isReadable());
    }

    public DefaultHttp2FrameReader(Http2HeadersDecoder http2HeadersDecoder) {
        this.readingHeaders = true;
        this.headersDecoder = http2HeadersDecoder;
        this.maxFrameSize = 16384;
    }

    private void processHeaderState(ByteBuf byteBuf) throws Http2Exception {
        if (byteBuf.readableBytes() < 9) {
            return;
        }
        int readUnsignedMedium = byteBuf.readUnsignedMedium();
        this.payloadLength = readUnsignedMedium;
        if (readUnsignedMedium <= this.maxFrameSize) {
            this.frameType = byteBuf.readByte();
            this.flags = new Http2Flags(byteBuf.readUnsignedByte());
            this.streamId = Http2CodecUtil.readUnsignedInt(byteBuf);
            this.readingHeaders = false;
            switch (this.frameType) {
                case 0:
                    verifyDataFrame();
                    return;
                case 1:
                    verifyHeadersFrame();
                    return;
                case 2:
                    verifyPriorityFrame();
                    return;
                case 3:
                    verifyRstStreamFrame();
                    return;
                case 4:
                    verifySettingsFrame();
                    return;
                case 5:
                    verifyPushPromiseFrame();
                    return;
                case 6:
                    verifyPingFrame();
                    return;
                case 7:
                    verifyGoAwayFrame();
                    return;
                case 8:
                    verifyWindowUpdateFrame();
                    return;
                case 9:
                    verifyContinuationFrame();
                    return;
                default:
                    verifyUnknownFrame();
                    return;
            }
        }
        throw Http2Exception.connectionError(Http2Error.FRAME_SIZE_ERROR, "Frame length: %d exceeds maximum: %d", Integer.valueOf(readUnsignedMedium), Integer.valueOf(this.maxFrameSize));
    }

    private void processPayloadState(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, Http2FrameListener http2FrameListener) throws Http2Exception {
        if (byteBuf.readableBytes() < this.payloadLength) {
            return;
        }
        int readerIndex = byteBuf.readerIndex() + this.payloadLength;
        this.readingHeaders = true;
        switch (this.frameType) {
            case 0:
                readDataFrame(channelHandlerContext, byteBuf, readerIndex, http2FrameListener);
                break;
            case 1:
                readHeadersFrame(channelHandlerContext, byteBuf, readerIndex, http2FrameListener);
                break;
            case 2:
                readPriorityFrame(channelHandlerContext, byteBuf, http2FrameListener);
                break;
            case 3:
                readRstStreamFrame(channelHandlerContext, byteBuf, http2FrameListener);
                break;
            case 4:
                readSettingsFrame(channelHandlerContext, byteBuf, http2FrameListener);
                break;
            case 5:
                readPushPromiseFrame(channelHandlerContext, byteBuf, readerIndex, http2FrameListener);
                break;
            case 6:
                readPingFrame(channelHandlerContext, byteBuf.readLong(), http2FrameListener);
                break;
            case 7:
                readGoAwayFrame(channelHandlerContext, byteBuf, readerIndex, http2FrameListener);
                break;
            case 8:
                readWindowUpdateFrame(channelHandlerContext, byteBuf, http2FrameListener);
                break;
            case 9:
                readContinuationFrame(byteBuf, readerIndex, http2FrameListener);
                break;
            default:
                readUnknownFrame(channelHandlerContext, byteBuf, readerIndex, http2FrameListener);
                break;
        }
        byteBuf.readerIndex(readerIndex);
    }

    private void readDataFrame(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, int i6, Http2FrameListener http2FrameListener) throws Http2Exception {
        int readPadding = readPadding(byteBuf);
        verifyPadding(readPadding);
        http2FrameListener.onDataRead(channelHandlerContext, this.streamId, byteBuf.readSlice(lengthWithoutTrailingPadding(i6 - byteBuf.readerIndex(), readPadding)), readPadding, this.flags.endOfStream());
    }

    private static void readGoAwayFrame(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, int i6, Http2FrameListener http2FrameListener) throws Http2Exception {
        http2FrameListener.onGoAwayRead(channelHandlerContext, Http2CodecUtil.readUnsignedInt(byteBuf), byteBuf.readUnsignedInt(), byteBuf.readSlice(i6 - byteBuf.readerIndex()));
    }

    private void readRstStreamFrame(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, Http2FrameListener http2FrameListener) throws Http2Exception {
        http2FrameListener.onRstStreamRead(channelHandlerContext, this.streamId, byteBuf.readUnsignedInt());
    }

    private void readUnknownFrame(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, int i6, Http2FrameListener http2FrameListener) throws Http2Exception {
        http2FrameListener.onUnknownFrame(channelHandlerContext, this.frameType, this.streamId, this.flags, byteBuf.readSlice(i6 - byteBuf.readerIndex()));
    }

    private void readWindowUpdateFrame(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, Http2FrameListener http2FrameListener) throws Http2Exception {
        int readUnsignedInt = Http2CodecUtil.readUnsignedInt(byteBuf);
        if (readUnsignedInt != 0) {
            http2FrameListener.onWindowUpdateRead(channelHandlerContext, this.streamId, readUnsignedInt);
        } else {
            int i6 = this.streamId;
            throw Http2Exception.streamError(i6, Http2Error.PROTOCOL_ERROR, "Received WINDOW_UPDATE with delta 0 for stream: %d", Integer.valueOf(i6));
        }
    }

    private void verifyContinuationFrame() throws Http2Exception {
        verifyAssociatedWithAStream();
        verifyPayloadLength(this.payloadLength);
        HeadersContinuation headersContinuation = this.headersContinuation;
        if (headersContinuation != null) {
            if (this.streamId == headersContinuation.getStreamId()) {
                if (this.payloadLength >= this.flags.getPaddingPresenceFieldLength()) {
                    return;
                } else {
                    throw Http2Exception.streamError(this.streamId, Http2Error.FRAME_SIZE_ERROR, "Frame length %d too small for padding.", Integer.valueOf(this.payloadLength));
                }
            }
            throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Continuation stream ID does not match pending headers. Expected %d, but received %d.", Integer.valueOf(this.headersContinuation.getStreamId()), Integer.valueOf(this.streamId));
        }
        throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Received %s frame but not currently processing headers.", Byte.valueOf(this.frameType));
    }

    private void verifyDataFrame() throws Http2Exception {
        verifyAssociatedWithAStream();
        verifyNotProcessingHeaders();
        verifyPayloadLength(this.payloadLength);
        if (this.payloadLength >= this.flags.getPaddingPresenceFieldLength()) {
        } else {
            throw Http2Exception.streamError(this.streamId, Http2Error.FRAME_SIZE_ERROR, "Frame length %d too small.", Integer.valueOf(this.payloadLength));
        }
    }

    private void verifyGoAwayFrame() throws Http2Exception {
        verifyNotProcessingHeaders();
        verifyPayloadLength(this.payloadLength);
        if (this.streamId == 0) {
            int i6 = this.payloadLength;
            if (i6 >= 8) {
                return;
            } else {
                throw Http2Exception.connectionError(Http2Error.FRAME_SIZE_ERROR, "Frame length %d too small.", Integer.valueOf(i6));
            }
        }
        throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "A stream ID must be zero.", new Object[0]);
    }

    private void verifyHeadersFrame() throws Http2Exception {
        verifyAssociatedWithAStream();
        verifyNotProcessingHeaders();
        verifyPayloadLength(this.payloadLength);
        if (this.payloadLength >= this.flags.getPaddingPresenceFieldLength() + this.flags.getNumPriorityBytes()) {
            return;
        }
        throw Http2Exception.streamError(this.streamId, Http2Error.FRAME_SIZE_ERROR, "Frame length too small." + this.payloadLength, new Object[0]);
    }

    private void verifyPingFrame() throws Http2Exception {
        verifyNotProcessingHeaders();
        if (this.streamId == 0) {
            int i6 = this.payloadLength;
            if (i6 == 8) {
                return;
            } else {
                throw Http2Exception.connectionError(Http2Error.FRAME_SIZE_ERROR, "Frame length %d incorrect size for ping.", Integer.valueOf(i6));
            }
        }
        throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "A stream ID must be zero.", new Object[0]);
    }

    private void verifyPriorityFrame() throws Http2Exception {
        verifyAssociatedWithAStream();
        verifyNotProcessingHeaders();
        int i6 = this.payloadLength;
        if (i6 == 5) {
        } else {
            throw Http2Exception.streamError(this.streamId, Http2Error.FRAME_SIZE_ERROR, "Invalid frame length %d.", Integer.valueOf(i6));
        }
    }

    private void verifyPushPromiseFrame() throws Http2Exception {
        verifyNotProcessingHeaders();
        verifyPayloadLength(this.payloadLength);
        int paddingPresenceFieldLength = this.flags.getPaddingPresenceFieldLength() + 4;
        int i6 = this.payloadLength;
        if (i6 >= paddingPresenceFieldLength) {
        } else {
            throw Http2Exception.streamError(this.streamId, Http2Error.FRAME_SIZE_ERROR, "Frame length %d too small.", Integer.valueOf(i6));
        }
    }

    private void verifyRstStreamFrame() throws Http2Exception {
        verifyAssociatedWithAStream();
        verifyNotProcessingHeaders();
        int i6 = this.payloadLength;
        if (i6 == 4) {
        } else {
            throw Http2Exception.connectionError(Http2Error.FRAME_SIZE_ERROR, "Invalid frame length %d.", Integer.valueOf(i6));
        }
    }

    private void verifySettingsFrame() throws Http2Exception {
        verifyNotProcessingHeaders();
        verifyPayloadLength(this.payloadLength);
        if (this.streamId == 0) {
            if (this.flags.ack() && this.payloadLength > 0) {
                throw Http2Exception.connectionError(Http2Error.FRAME_SIZE_ERROR, "Ack settings frame must have an empty payload.", new Object[0]);
            }
            int i6 = this.payloadLength;
            if (i6 % 6 <= 0) {
                return;
            } else {
                throw Http2Exception.connectionError(Http2Error.FRAME_SIZE_ERROR, "Frame length %d invalid.", Integer.valueOf(i6));
            }
        }
        throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "A stream ID must be zero.", new Object[0]);
    }

    private void verifyUnknownFrame() throws Http2Exception {
        verifyNotProcessingHeaders();
    }

    private void verifyWindowUpdateFrame() throws Http2Exception {
        verifyNotProcessingHeaders();
        verifyStreamOrConnectionId(this.streamId, "Stream ID");
        int i6 = this.payloadLength;
        if (i6 == 4) {
        } else {
            throw Http2Exception.connectionError(Http2Error.FRAME_SIZE_ERROR, "Invalid frame length %d.", Integer.valueOf(i6));
        }
    }

    @Override // io.netty.handler.codec.http2.Http2FrameReader, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        closeHeadersContinuation();
    }

    @Override // io.netty.handler.codec.http2.Http2FrameSizePolicy
    public int maxFrameSize() {
        return this.maxFrameSize;
    }

    @Override // io.netty.handler.codec.http2.Http2FrameReader
    public Http2FrameReader.Configuration configuration() {
        return this;
    }

    @Override // io.netty.handler.codec.http2.Http2FrameReader.Configuration
    public Http2FrameSizePolicy frameSizePolicy() {
        return this;
    }
}
