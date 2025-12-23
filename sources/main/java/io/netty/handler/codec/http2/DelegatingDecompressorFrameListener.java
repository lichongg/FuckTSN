package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.compression.ZlibCodecFactory;
import io.netty.handler.codec.compression.ZlibWrapper;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpHeaderValues;
import io.netty.handler.codec.http2.Http2Connection;
import io.netty.util.AsciiString;
import io.netty.util.internal.ObjectUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class DelegatingDecompressorFrameListener extends Http2FrameListenerDecorator {
    private final Http2Connection connection;
    private boolean flowControllerInitialized;
    private final Http2Connection.PropertyKey propertyKey;
    private final boolean strict;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class ConsumedBytesConverter implements Http2LocalFlowController {
        private final Http2LocalFlowController flowController;

        @Override // io.netty.handler.codec.http2.Http2FlowController
        public void initialWindowSize(int i6) throws Http2Exception {
            this.flowController.initialWindowSize(i6);
        }

        ConsumedBytesConverter(Http2LocalFlowController http2LocalFlowController) {
            this.flowController = (Http2LocalFlowController) ObjectUtil.checkNotNull(http2LocalFlowController, "flowController");
        }

        @Override // io.netty.handler.codec.http2.Http2FlowController
        public void channelHandlerContext(ChannelHandlerContext channelHandlerContext) throws Http2Exception {
            this.flowController.channelHandlerContext(channelHandlerContext);
        }

        @Override // io.netty.handler.codec.http2.Http2LocalFlowController
        public boolean consumeBytes(Http2Stream http2Stream, int i6) throws Http2Exception {
            Http2Decompressor decompressor = DelegatingDecompressorFrameListener.this.decompressor(http2Stream);
            if (decompressor != null) {
                i6 = decompressor.consumeBytes(http2Stream.id(), i6);
            }
            try {
                return this.flowController.consumeBytes(http2Stream, i6);
            } catch (Http2Exception e6) {
                throw e6;
            } catch (Throwable th) {
                throw Http2Exception.streamError(http2Stream.id(), Http2Error.INTERNAL_ERROR, th, "Error while returning bytes to flow control window", new Object[0]);
            }
        }

        @Override // io.netty.handler.codec.http2.Http2LocalFlowController
        public Http2LocalFlowController frameWriter(Http2FrameWriter http2FrameWriter) {
            return this.flowController.frameWriter(http2FrameWriter);
        }

        @Override // io.netty.handler.codec.http2.Http2FlowController
        public void incrementWindowSize(Http2Stream http2Stream, int i6) throws Http2Exception {
            this.flowController.incrementWindowSize(http2Stream, i6);
        }

        @Override // io.netty.handler.codec.http2.Http2FlowController
        public int initialWindowSize() {
            return this.flowController.initialWindowSize();
        }

        @Override // io.netty.handler.codec.http2.Http2LocalFlowController
        public void receiveFlowControlledFrame(Http2Stream http2Stream, ByteBuf byteBuf, int i6, boolean z5) throws Http2Exception {
            this.flowController.receiveFlowControlledFrame(http2Stream, byteBuf, i6, z5);
        }

        @Override // io.netty.handler.codec.http2.Http2LocalFlowController
        public int unconsumedBytes(Http2Stream http2Stream) {
            return this.flowController.unconsumedBytes(http2Stream);
        }

        @Override // io.netty.handler.codec.http2.Http2FlowController
        public int windowSize(Http2Stream http2Stream) {
            return this.flowController.windowSize(http2Stream);
        }

        @Override // io.netty.handler.codec.http2.Http2LocalFlowController
        public int initialWindowSize(Http2Stream http2Stream) {
            return this.flowController.initialWindowSize(http2Stream);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class Http2Decompressor {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private int compressed;
        private int decompressed;
        private final EmbeddedChannel decompressor;

        int consumeBytes(int i6, int i7) throws Http2Exception {
            ObjectUtil.checkPositiveOrZero(i7, "decompressedBytes");
            int i8 = this.decompressed;
            if (i8 - i7 < 0) {
                throw Http2Exception.streamError(i6, Http2Error.INTERNAL_ERROR, "Attempting to return too many bytes for stream %d. decompressed: %d decompressedBytes: %d", Integer.valueOf(i6), Integer.valueOf(this.decompressed), Integer.valueOf(i7));
            }
            double d6 = i7 / i8;
            int i9 = this.compressed;
            int min = Math.min(i9, (int) Math.ceil(i9 * d6));
            int i10 = this.compressed;
            if (i10 - min < 0) {
                throw Http2Exception.streamError(i6, Http2Error.INTERNAL_ERROR, "overflow when converting decompressed bytes to compressed bytes for stream %d.decompressedBytes: %d decompressed: %d compressed: %d consumedCompressed: %d", Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(this.decompressed), Integer.valueOf(this.compressed), Integer.valueOf(min));
            }
            this.decompressed -= i7;
            this.compressed = i10 - min;
            return min;
        }

        EmbeddedChannel decompressor() {
            return this.decompressor;
        }

        void incrementCompressedBytes(int i6) {
            this.compressed += i6;
        }

        void incrementDecompressedBytes(int i6) {
            this.decompressed += i6;
        }

        Http2Decompressor(EmbeddedChannel embeddedChannel) {
            this.decompressor = embeddedChannel;
        }
    }

    public DelegatingDecompressorFrameListener(Http2Connection http2Connection, Http2FrameListener http2FrameListener) {
        this(http2Connection, http2FrameListener, true);
    }

    @Override // io.netty.handler.codec.http2.Http2FrameListenerDecorator, io.netty.handler.codec.http2.Http2FrameListener
    public void onHeadersRead(ChannelHandlerContext channelHandlerContext, int i6, Http2Headers http2Headers, int i7, boolean z5) throws Http2Exception {
        initDecompressor(channelHandlerContext, i6, http2Headers, z5);
        this.listener.onHeadersRead(channelHandlerContext, i6, http2Headers, i7, z5);
    }

    public DelegatingDecompressorFrameListener(Http2Connection http2Connection, Http2FrameListener http2FrameListener, boolean z5) {
        super(http2FrameListener);
        this.connection = http2Connection;
        this.strict = z5;
        this.propertyKey = http2Connection.newKey();
        http2Connection.addListener(new Http2ConnectionAdapter() { // from class: io.netty.handler.codec.http2.DelegatingDecompressorFrameListener.1
            @Override // io.netty.handler.codec.http2.Http2ConnectionAdapter, io.netty.handler.codec.http2.Http2Connection.Listener
            public void onStreamRemoved(Http2Stream http2Stream) {
                Http2Decompressor decompressor = DelegatingDecompressorFrameListener.this.decompressor(http2Stream);
                if (decompressor != null) {
                    DelegatingDecompressorFrameListener.cleanup(decompressor);
                }
            }
        });
    }

    private void initDecompressor(ChannelHandlerContext channelHandlerContext, int i6, Http2Headers http2Headers, boolean z5) throws Http2Exception {
        Http2Stream stream = this.connection.stream(i6);
        if (stream == null) {
            return;
        }
        Http2Decompressor decompressor = decompressor(stream);
        if (decompressor == null && !z5) {
            AsciiString asciiString = HttpHeaderNames.CONTENT_ENCODING;
            CharSequence charSequence = http2Headers.get(asciiString);
            if (charSequence == null) {
                charSequence = HttpHeaderValues.IDENTITY;
            }
            EmbeddedChannel newContentDecompressor = newContentDecompressor(channelHandlerContext, charSequence);
            if (newContentDecompressor != null) {
                decompressor = new Http2Decompressor(newContentDecompressor);
                stream.setProperty(this.propertyKey, decompressor);
                CharSequence targetContentEncoding = getTargetContentEncoding(charSequence);
                if (HttpHeaderValues.IDENTITY.contentEqualsIgnoreCase(targetContentEncoding)) {
                    http2Headers.remove(asciiString);
                } else {
                    http2Headers.set((Http2Headers) asciiString, (AsciiString) targetContentEncoding);
                }
            }
        }
        if (decompressor != null) {
            http2Headers.remove(HttpHeaderNames.CONTENT_LENGTH);
            if (this.flowControllerInitialized) {
                return;
            }
            this.flowControllerInitialized = true;
            this.connection.local().flowController(new ConsumedBytesConverter(this.connection.local().flowController()));
        }
    }

    Http2Decompressor decompressor(Http2Stream http2Stream) {
        if (http2Stream == null) {
            return null;
        }
        return (Http2Decompressor) http2Stream.getProperty(this.propertyKey);
    }

    protected CharSequence getTargetContentEncoding(CharSequence charSequence) throws Http2Exception {
        return HttpHeaderValues.IDENTITY;
    }

    protected EmbeddedChannel newContentDecompressor(ChannelHandlerContext channelHandlerContext, CharSequence charSequence) throws Http2Exception {
        if (HttpHeaderValues.GZIP.contentEqualsIgnoreCase(charSequence) || HttpHeaderValues.X_GZIP.contentEqualsIgnoreCase(charSequence)) {
            return new EmbeddedChannel(channelHandlerContext.channel().id(), channelHandlerContext.channel().metadata().hasDisconnect(), channelHandlerContext.channel().config(), ZlibCodecFactory.newZlibDecoder(ZlibWrapper.GZIP));
        }
        if (HttpHeaderValues.DEFLATE.contentEqualsIgnoreCase(charSequence) || HttpHeaderValues.X_DEFLATE.contentEqualsIgnoreCase(charSequence)) {
            return new EmbeddedChannel(channelHandlerContext.channel().id(), channelHandlerContext.channel().metadata().hasDisconnect(), channelHandlerContext.channel().config(), ZlibCodecFactory.newZlibDecoder(this.strict ? ZlibWrapper.ZLIB : ZlibWrapper.ZLIB_OR_NONE));
        }
        return null;
    }

    @Override // io.netty.handler.codec.http2.Http2FrameListenerDecorator, io.netty.handler.codec.http2.Http2FrameListener
    public int onDataRead(ChannelHandlerContext channelHandlerContext, int i6, ByteBuf byteBuf, int i7, boolean z5) throws Http2Exception {
        Throwable th;
        Http2Stream stream = this.connection.stream(i6);
        Http2Decompressor decompressor = decompressor(stream);
        if (decompressor == null) {
            return this.listener.onDataRead(channelHandlerContext, i6, byteBuf, i7, z5);
        }
        int i8 = i7;
        EmbeddedChannel decompressor2 = decompressor.decompressor();
        int readableBytes = byteBuf.readableBytes() + i8;
        decompressor.incrementCompressedBytes(readableBytes);
        try {
            decompressor2.writeInbound(byteBuf.retain());
            ByteBuf nextReadableBuf = nextReadableBuf(decompressor2);
            if (nextReadableBuf == null && z5 && decompressor2.finish()) {
                nextReadableBuf = nextReadableBuf(decompressor2);
            }
            if (nextReadableBuf == null) {
                if (z5) {
                    this.listener.onDataRead(channelHandlerContext, i6, Unpooled.EMPTY_BUFFER, i8, true);
                }
                decompressor.incrementDecompressedBytes(readableBytes);
                return readableBytes;
            }
            try {
                Http2LocalFlowController flowController = this.connection.local().flowController();
                decompressor.incrementDecompressedBytes(i8);
                ByteBuf byteBuf2 = nextReadableBuf;
                while (true) {
                    try {
                        ByteBuf nextReadableBuf2 = nextReadableBuf(decompressor2);
                        boolean z6 = nextReadableBuf2 == null && z5;
                        if (z6 && decompressor2.finish()) {
                            nextReadableBuf2 = nextReadableBuf(decompressor2);
                            z6 = nextReadableBuf2 == null;
                        }
                        ByteBuf byteBuf3 = nextReadableBuf2;
                        decompressor.incrementDecompressedBytes(byteBuf2.readableBytes());
                        flowController.consumeBytes(stream, this.listener.onDataRead(channelHandlerContext, i6, byteBuf2, i8, z6));
                        if (byteBuf3 == null) {
                            byteBuf2.release();
                            return 0;
                        }
                        byteBuf2.release();
                        byteBuf2 = byteBuf3;
                        i8 = 0;
                    } catch (Throwable th2) {
                        th = th2;
                        nextReadableBuf = byteBuf2;
                        nextReadableBuf.release();
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Http2Exception e6) {
            throw e6;
        } catch (Throwable th4) {
            throw Http2Exception.streamError(stream.id(), Http2Error.INTERNAL_ERROR, th4, "Decompressor error detected while delegating data read on streamId %d", Integer.valueOf(stream.id()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void cleanup(Http2Decompressor http2Decompressor) {
        http2Decompressor.decompressor().finishAndReleaseAll();
    }

    private static ByteBuf nextReadableBuf(EmbeddedChannel embeddedChannel) {
        while (true) {
            ByteBuf byteBuf = (ByteBuf) embeddedChannel.readInbound();
            if (byteBuf == null) {
                return null;
            }
            if (!byteBuf.isReadable()) {
                byteBuf.release();
            } else {
                return byteBuf;
            }
        }
    }

    @Override // io.netty.handler.codec.http2.Http2FrameListenerDecorator, io.netty.handler.codec.http2.Http2FrameListener
    public void onHeadersRead(ChannelHandlerContext channelHandlerContext, int i6, Http2Headers http2Headers, int i7, short s5, boolean z5, int i8, boolean z6) throws Http2Exception {
        initDecompressor(channelHandlerContext, i6, http2Headers, z6);
        this.listener.onHeadersRead(channelHandlerContext, i6, http2Headers, i7, s5, z5, i8, z6);
    }
}
