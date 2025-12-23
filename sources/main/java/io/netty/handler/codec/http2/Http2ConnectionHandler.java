package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandler;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http2.Http2Exception;
import io.netty.handler.codec.http2.Http2Stream;
import io.netty.util.AsciiString;
import io.netty.util.CharsetUtil;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.concurrent.ScheduledFuture;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.net.SocketAddress;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class Http2ConnectionHandler extends ByteToMessageDecoder implements Http2LifecycleManager, ChannelOutboundHandler {
    private BaseDecoder byteDecoder;
    private ChannelFutureListener closeListener;
    private final Http2ConnectionDecoder decoder;
    private final boolean decoupleCloseAndGoAway;
    private final Http2ConnectionEncoder encoder;
    private long gracefulShutdownTimeoutMillis;
    private final Http2Settings initialSettings;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) Http2ConnectionHandler.class);
    private static final Http2Headers HEADERS_TOO_LARGE_HEADERS = ReadOnlyHttp2Headers.serverHeaders(false, HttpResponseStatus.REQUEST_HEADER_FIELDS_TOO_LARGE.codeAsText(), new AsciiString[0]);
    private static final ByteBuf HTTP_1_X_BUF = Unpooled.unreleasableBuffer(Unpooled.wrappedBuffer(new byte[]{72, 84, 84, 80, 47, 49, 46})).asReadOnly();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private abstract class BaseDecoder {
        private BaseDecoder() {
        }

        public abstract void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception;

        public boolean prefaceSent() {
            return true;
        }

        public void channelInactive(ChannelHandlerContext channelHandlerContext) throws Exception {
            Http2ConnectionHandler.this.encoder().close();
            Http2ConnectionHandler.this.decoder().close();
            Http2ConnectionHandler.this.connection().close(channelHandlerContext.voidPromise());
        }

        public void channelActive(ChannelHandlerContext channelHandlerContext) throws Exception {
        }

        public void handlerRemoved(ChannelHandlerContext channelHandlerContext) throws Exception {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class ClosingChannelFutureListener implements ChannelFutureListener {
        private final ChannelHandlerContext ctx;
        private final ChannelPromise promise;
        private final ScheduledFuture<?> timeoutTask;

        ClosingChannelFutureListener(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) {
            this.ctx = channelHandlerContext;
            this.promise = channelPromise;
            this.timeoutTask = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void doClose() {
            ChannelPromise channelPromise = this.promise;
            if (channelPromise == null) {
                this.ctx.close();
            } else {
                this.ctx.close(channelPromise);
            }
        }

        @Override // io.netty.util.concurrent.GenericFutureListener
        public void operationComplete(ChannelFuture channelFuture) {
            ScheduledFuture<?> scheduledFuture = this.timeoutTask;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
            }
            doClose();
        }

        ClosingChannelFutureListener(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise, long j6, TimeUnit timeUnit) {
            this.ctx = channelHandlerContext;
            this.promise = channelPromise;
            this.timeoutTask = channelHandlerContext.executor().schedule(new Runnable() { // from class: io.netty.handler.codec.http2.Http2ConnectionHandler.ClosingChannelFutureListener.1
                @Override // java.lang.Runnable
                public void run() {
                    ClosingChannelFutureListener.this.doClose();
                }
            }, j6, timeUnit);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class FrameDecoder extends BaseDecoder {
        private FrameDecoder() {
            super();
        }

        @Override // io.netty.handler.codec.http2.Http2ConnectionHandler.BaseDecoder
        public void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
            try {
                Http2ConnectionHandler.this.decoder.decodeFrame(channelHandlerContext, byteBuf, list);
            } catch (Throwable th) {
                Http2ConnectionHandler.this.onError(channelHandlerContext, false, th);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class PrefaceDecoder extends BaseDecoder {
        private ByteBuf clientPrefaceString;
        private boolean prefaceSent;

        PrefaceDecoder(ChannelHandlerContext channelHandlerContext) throws Exception {
            super();
            this.clientPrefaceString = Http2ConnectionHandler.clientPrefaceString(Http2ConnectionHandler.this.encoder.connection());
            sendPreface(channelHandlerContext);
        }

        private void cleanup() {
            ByteBuf byteBuf = this.clientPrefaceString;
            if (byteBuf != null) {
                byteBuf.release();
                this.clientPrefaceString = null;
            }
        }

        private boolean readClientPrefaceString(ByteBuf byteBuf) throws Http2Exception {
            ByteBuf byteBuf2 = this.clientPrefaceString;
            if (byteBuf2 == null) {
                return true;
            }
            int min = Math.min(byteBuf.readableBytes(), byteBuf2.readableBytes());
            if (min != 0) {
                int readerIndex = byteBuf.readerIndex();
                ByteBuf byteBuf3 = this.clientPrefaceString;
                if (ByteBufUtil.equals(byteBuf, readerIndex, byteBuf3, byteBuf3.readerIndex(), min)) {
                    byteBuf.skipBytes(min);
                    this.clientPrefaceString.skipBytes(min);
                    if (this.clientPrefaceString.isReadable()) {
                        return false;
                    }
                    this.clientPrefaceString.release();
                    this.clientPrefaceString = null;
                    return true;
                }
            }
            int indexOf = ByteBufUtil.indexOf(Http2ConnectionHandler.HTTP_1_X_BUF, byteBuf.slice(byteBuf.readerIndex(), Math.min(byteBuf.readableBytes(), 1024)));
            if (indexOf != -1) {
                throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Unexpected HTTP/1.x request: %s", byteBuf.toString(byteBuf.readerIndex(), indexOf - byteBuf.readerIndex(), CharsetUtil.US_ASCII));
            }
            throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "HTTP/2 client preface string missing or corrupt. Hex dump for received bytes: %s", ByteBufUtil.hexDump(byteBuf, byteBuf.readerIndex(), Math.min(byteBuf.readableBytes(), this.clientPrefaceString.readableBytes())));
        }

        private void sendPreface(ChannelHandlerContext channelHandlerContext) throws Exception {
            if (this.prefaceSent || !channelHandlerContext.channel().isActive()) {
                return;
            }
            this.prefaceSent = true;
            boolean isServer = Http2ConnectionHandler.this.connection().isServer();
            if (!isServer) {
                channelHandlerContext.write(Http2CodecUtil.connectionPrefaceBuf()).addListener((GenericFutureListener<? extends Future<? super Void>>) ChannelFutureListener.CLOSE_ON_FAILURE);
            }
            Http2ConnectionHandler.this.encoder.writeSettings(channelHandlerContext, Http2ConnectionHandler.this.initialSettings, channelHandlerContext.newPromise()).addListener((GenericFutureListener<? extends Future<? super Void>>) ChannelFutureListener.CLOSE_ON_FAILURE);
            if (isServer) {
                return;
            }
            Http2ConnectionHandler.this.userEventTriggered(channelHandlerContext, Http2ConnectionPrefaceAndSettingsFrameWrittenEvent.INSTANCE);
        }

        @Override // io.netty.handler.codec.http2.Http2ConnectionHandler.BaseDecoder
        public boolean prefaceSent() {
            return this.prefaceSent;
        }

        private boolean verifyFirstFrameIsSettings(ByteBuf byteBuf) throws Http2Exception {
            if (byteBuf.readableBytes() < 5) {
                return false;
            }
            short unsignedByte = byteBuf.getUnsignedByte(byteBuf.readerIndex() + 3);
            short unsignedByte2 = byteBuf.getUnsignedByte(byteBuf.readerIndex() + 4);
            if (unsignedByte == 4 && (unsignedByte2 & 1) == 0) {
                return true;
            }
            throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "First received frame was not SETTINGS. Hex dump for first 5 bytes: %s", ByteBufUtil.hexDump(byteBuf, byteBuf.readerIndex(), 5));
        }

        @Override // io.netty.handler.codec.http2.Http2ConnectionHandler.BaseDecoder
        public void channelActive(ChannelHandlerContext channelHandlerContext) throws Exception {
            sendPreface(channelHandlerContext);
        }

        @Override // io.netty.handler.codec.http2.Http2ConnectionHandler.BaseDecoder
        public void channelInactive(ChannelHandlerContext channelHandlerContext) throws Exception {
            cleanup();
            super.channelInactive(channelHandlerContext);
        }

        @Override // io.netty.handler.codec.http2.Http2ConnectionHandler.BaseDecoder
        public void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
            try {
                if (channelHandlerContext.channel().isActive() && readClientPrefaceString(byteBuf) && verifyFirstFrameIsSettings(byteBuf)) {
                    Http2ConnectionHandler http2ConnectionHandler = Http2ConnectionHandler.this;
                    http2ConnectionHandler.byteDecoder = new FrameDecoder();
                    Http2ConnectionHandler.this.byteDecoder.decode(channelHandlerContext, byteBuf, list);
                }
            } catch (Throwable th) {
                Http2ConnectionHandler.this.onError(channelHandlerContext, false, th);
            }
        }

        @Override // io.netty.handler.codec.http2.Http2ConnectionHandler.BaseDecoder
        public void handlerRemoved(ChannelHandlerContext channelHandlerContext) throws Exception {
            cleanup();
        }
    }

    protected Http2ConnectionHandler(Http2ConnectionDecoder http2ConnectionDecoder, Http2ConnectionEncoder http2ConnectionEncoder, Http2Settings http2Settings) {
        this(http2ConnectionDecoder, http2ConnectionEncoder, http2Settings, false);
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public void flush(ChannelHandlerContext channelHandlerContext) {
        try {
            this.encoder.flowController().writePendingBytes();
            channelHandlerContext.flush();
        } catch (Http2Exception e6) {
            onError(channelHandlerContext, true, e6);
        } catch (Throwable th) {
            onError(channelHandlerContext, true, Http2Exception.connectionError(Http2Error.INTERNAL_ERROR, th, "Error flushing", new Object[0]));
        }
    }

    @Override // io.netty.handler.codec.http2.Http2LifecycleManager
    public ChannelFuture goAway(final ChannelHandlerContext channelHandlerContext, final int i6, final long j6, final ByteBuf byteBuf, ChannelPromise channelPromise) {
        ChannelPromise unvoid = channelPromise.unvoid();
        try {
            if (!connection().goAwaySent(i6, j6, byteBuf)) {
                byteBuf.release();
                unvoid.trySuccess();
                return unvoid;
            }
            byteBuf.retain();
            ChannelFuture writeGoAway = frameWriter().writeGoAway(channelHandlerContext, i6, j6, byteBuf, unvoid);
            if (writeGoAway.isDone()) {
                processGoAwayWriteResult(channelHandlerContext, i6, j6, byteBuf, writeGoAway);
                return writeGoAway;
            }
            writeGoAway.addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.handler.codec.http2.Http2ConnectionHandler.5
                @Override // io.netty.util.concurrent.GenericFutureListener
                public void operationComplete(ChannelFuture channelFuture) throws Exception {
                    Http2ConnectionHandler.processGoAwayWriteResult(channelHandlerContext, i6, j6, byteBuf, channelFuture);
                }
            });
            return writeGoAway;
        } catch (Throwable th) {
            byteBuf.release();
            unvoid.tryFailure(th);
            return unvoid;
        }
    }

    public long gracefulShutdownTimeoutMillis() {
        return this.gracefulShutdownTimeoutMillis;
    }

    @Override // io.netty.handler.codec.http2.Http2LifecycleManager
    public ChannelFuture resetStream(ChannelHandlerContext channelHandlerContext, int i6, long j6, ChannelPromise channelPromise) {
        Http2Stream stream = connection().stream(i6);
        return stream == null ? resetUnknownStream(channelHandlerContext, i6, j6, channelPromise.unvoid()) : resetStream(channelHandlerContext, stream, j6, channelPromise);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: io.netty.handler.codec.http2.Http2ConnectionHandler$6, reason: invalid class name */
    static /* synthetic */ class AnonymousClass6 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State;

        static {
            int[] iArr = new int[Http2Stream.State.values().length];
            $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State = iArr;
            try {
                iArr[Http2Stream.State.HALF_CLOSED_LOCAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[Http2Stream.State.OPEN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[Http2Stream.State.HALF_CLOSED_REMOTE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    protected Http2ConnectionHandler(Http2ConnectionDecoder http2ConnectionDecoder, Http2ConnectionEncoder http2ConnectionEncoder, Http2Settings http2Settings, boolean z5) {
        this.initialSettings = (Http2Settings) ObjectUtil.checkNotNull(http2Settings, "initialSettings");
        this.decoder = (Http2ConnectionDecoder) ObjectUtil.checkNotNull(http2ConnectionDecoder, "decoder");
        this.encoder = (Http2ConnectionEncoder) ObjectUtil.checkNotNull(http2ConnectionEncoder, "encoder");
        this.decoupleCloseAndGoAway = z5;
        if (http2ConnectionEncoder.connection() != http2ConnectionDecoder.connection()) {
            throw new IllegalArgumentException("Encoder and Decoder do not share the same connection object");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkCloseConnection(ChannelFuture channelFuture) {
        if (this.closeListener == null || !isGracefulShutdownComplete()) {
            return;
        }
        ChannelFutureListener channelFutureListener = this.closeListener;
        this.closeListener = null;
        try {
            channelFutureListener.operationComplete(channelFuture);
        } catch (Exception e6) {
            throw new IllegalStateException("Close listener threw an unexpected exception", e6);
        }
    }

    private ChannelFutureListener newClosingChannelFutureListener(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) {
        long j6 = this.gracefulShutdownTimeoutMillis;
        return j6 < 0 ? new ClosingChannelFutureListener(channelHandlerContext, channelPromise) : new ClosingChannelFutureListener(channelHandlerContext, channelPromise, j6, TimeUnit.MILLISECONDS);
    }

    private boolean prefaceSent() {
        BaseDecoder baseDecoder = this.byteDecoder;
        return baseDecoder != null && baseDecoder.prefaceSent();
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelActive(ChannelHandlerContext channelHandlerContext) throws Exception {
        if (this.byteDecoder == null) {
            this.byteDecoder = new PrefaceDecoder(channelHandlerContext);
        }
        this.byteDecoder.channelActive(channelHandlerContext);
        super.channelActive(channelHandlerContext);
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public void close(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) throws Exception {
        if (this.decoupleCloseAndGoAway) {
            channelHandlerContext.close(channelPromise);
            return;
        }
        ChannelPromise unvoid = channelPromise.unvoid();
        if (!channelHandlerContext.channel().isActive()) {
            channelHandlerContext.close(unvoid);
            return;
        }
        ChannelFuture write = connection().goAwaySent() ? channelHandlerContext.write(Unpooled.EMPTY_BUFFER) : goAway(channelHandlerContext, null, channelHandlerContext.newPromise());
        channelHandlerContext.flush();
        doGracefulShutdown(channelHandlerContext, write, unvoid);
    }

    @Override // io.netty.handler.codec.http2.Http2LifecycleManager
    public void closeStreamLocal(Http2Stream http2Stream, ChannelFuture channelFuture) {
        int i6 = AnonymousClass6.$SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[http2Stream.state().ordinal()];
        if (i6 == 1 || i6 == 2) {
            http2Stream.closeLocalSide();
        } else {
            closeStream(http2Stream, channelFuture);
        }
    }

    @Override // io.netty.handler.codec.http2.Http2LifecycleManager
    public void closeStreamRemote(Http2Stream http2Stream, ChannelFuture channelFuture) {
        int i6 = AnonymousClass6.$SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[http2Stream.state().ordinal()];
        if (i6 == 2 || i6 == 3) {
            http2Stream.closeRemoteSide();
        } else {
            closeStream(http2Stream, channelFuture);
        }
    }

    public Http2Connection connection() {
        return this.encoder.connection();
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        this.byteDecoder.decode(channelHandlerContext, byteBuf, list);
    }

    public Http2ConnectionDecoder decoder() {
        return this.decoder;
    }

    public Http2ConnectionEncoder encoder() {
        return this.encoder;
    }

    public void gracefulShutdownTimeoutMillis(long j6) {
        if (j6 >= -1) {
            this.gracefulShutdownTimeoutMillis = j6;
            return;
        }
        throw new IllegalArgumentException("gracefulShutdownTimeoutMillis: " + j6 + " (expected: -1 for indefinite or >= 0)");
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext channelHandlerContext) throws Exception {
        this.encoder.lifecycleManager(this);
        this.decoder.lifecycleManager(this);
        this.encoder.flowController().channelHandlerContext(channelHandlerContext);
        this.decoder.flowController().channelHandlerContext(channelHandlerContext);
        this.byteDecoder = new PrefaceDecoder(channelHandlerContext);
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder
    protected void handlerRemoved0(ChannelHandlerContext channelHandlerContext) throws Exception {
        BaseDecoder baseDecoder = this.byteDecoder;
        if (baseDecoder != null) {
            baseDecoder.handlerRemoved(channelHandlerContext);
            this.byteDecoder = null;
        }
    }

    protected void onConnectionError(ChannelHandlerContext channelHandlerContext, boolean z5, Throwable th, Http2Exception http2Exception) {
        if (http2Exception == null) {
            http2Exception = new Http2Exception(Http2Error.INTERNAL_ERROR, th.getMessage(), th);
        }
        ChannelPromise newPromise = channelHandlerContext.newPromise();
        ChannelFuture goAway = goAway(channelHandlerContext, http2Exception, channelHandlerContext.newPromise());
        if (http2Exception.shutdownHint() == Http2Exception.ShutdownHint.GRACEFUL_SHUTDOWN) {
            doGracefulShutdown(channelHandlerContext, goAway, newPromise);
        } else {
            goAway.addListener((GenericFutureListener<? extends Future<? super Void>>) newClosingChannelFutureListener(channelHandlerContext, newPromise));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ByteBuf clientPrefaceString(Http2Connection http2Connection) {
        if (http2Connection.isServer()) {
            return Http2CodecUtil.connectionPrefaceBuf();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeConnectionOnError(ChannelHandlerContext channelHandlerContext, ChannelFuture channelFuture) {
        if (!channelFuture.isSuccess()) {
            onConnectionError(channelHandlerContext, true, channelFuture.cause(), null);
        }
    }

    private void doGracefulShutdown(ChannelHandlerContext channelHandlerContext, ChannelFuture channelFuture, ChannelPromise channelPromise) {
        final ChannelFutureListener newClosingChannelFutureListener = newClosingChannelFutureListener(channelHandlerContext, channelPromise);
        if (isGracefulShutdownComplete()) {
            channelFuture.addListener((GenericFutureListener<? extends Future<? super Void>>) newClosingChannelFutureListener);
            return;
        }
        final ChannelFutureListener channelFutureListener = this.closeListener;
        if (channelFutureListener == null) {
            this.closeListener = newClosingChannelFutureListener;
        } else if (channelPromise != null) {
            this.closeListener = new ChannelFutureListener() { // from class: io.netty.handler.codec.http2.Http2ConnectionHandler.1
                @Override // io.netty.util.concurrent.GenericFutureListener
                public void operationComplete(ChannelFuture channelFuture2) throws Exception {
                    try {
                        channelFutureListener.operationComplete(channelFuture2);
                    } finally {
                        newClosingChannelFutureListener.operationComplete(channelFuture2);
                    }
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void processGoAwayWriteResult(ChannelHandlerContext channelHandlerContext, int i6, long j6, ByteBuf byteBuf, ChannelFuture channelFuture) {
        try {
            if (channelFuture.isSuccess()) {
                if (j6 != Http2Error.NO_ERROR.code()) {
                    InternalLogger internalLogger = logger;
                    if (internalLogger.isDebugEnabled()) {
                        internalLogger.debug("{} Sent GOAWAY: lastStreamId '{}', errorCode '{}', debugData '{}'. Forcing shutdown of the connection.", channelHandlerContext.channel(), Integer.valueOf(i6), Long.valueOf(j6), byteBuf.toString(CharsetUtil.UTF_8), channelFuture.cause());
                    }
                    channelHandlerContext.close();
                }
            } else {
                InternalLogger internalLogger2 = logger;
                if (internalLogger2.isDebugEnabled()) {
                    internalLogger2.debug("{} Sending GOAWAY failed: lastStreamId '{}', errorCode '{}', debugData '{}'. Forcing shutdown of the connection.", channelHandlerContext.channel(), Integer.valueOf(i6), Long.valueOf(j6), byteBuf.toString(CharsetUtil.UTF_8), channelFuture.cause());
                }
                channelHandlerContext.close();
            }
            byteBuf.release();
        } catch (Throwable th) {
            byteBuf.release();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processRstStreamWriteResult(ChannelHandlerContext channelHandlerContext, Http2Stream http2Stream, ChannelFuture channelFuture) {
        if (channelFuture.isSuccess()) {
            closeStream(http2Stream, channelFuture);
        } else {
            onConnectionError(channelHandlerContext, true, channelFuture.cause(), null);
        }
    }

    private ChannelFuture resetUnknownStream(final ChannelHandlerContext channelHandlerContext, int i6, long j6, ChannelPromise channelPromise) {
        ChannelFuture writeRstStream = frameWriter().writeRstStream(channelHandlerContext, i6, j6, channelPromise);
        if (writeRstStream.isDone()) {
            closeConnectionOnError(channelHandlerContext, writeRstStream);
            return writeRstStream;
        }
        writeRstStream.addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.handler.codec.http2.Http2ConnectionHandler.3
            @Override // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(ChannelFuture channelFuture) throws Exception {
                Http2ConnectionHandler.this.closeConnectionOnError(channelHandlerContext, channelFuture);
            }
        });
        return writeRstStream;
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public void bind(ChannelHandlerContext channelHandlerContext, SocketAddress socketAddress, ChannelPromise channelPromise) throws Exception {
        channelHandlerContext.bind(socketAddress, channelPromise);
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder, io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelInactive(ChannelHandlerContext channelHandlerContext) throws Exception {
        super.channelInactive(channelHandlerContext);
        BaseDecoder baseDecoder = this.byteDecoder;
        if (baseDecoder != null) {
            baseDecoder.channelInactive(channelHandlerContext);
            this.byteDecoder = null;
        }
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder, io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelReadComplete(ChannelHandlerContext channelHandlerContext) throws Exception {
        try {
            channelReadComplete0(channelHandlerContext);
        } finally {
            flush(channelHandlerContext);
        }
    }

    final void channelReadComplete0(ChannelHandlerContext channelHandlerContext) {
        discardSomeReadBytes();
        if (!channelHandlerContext.channel().config().isAutoRead()) {
            channelHandlerContext.read();
        }
        channelHandlerContext.fireChannelReadComplete();
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelWritabilityChanged(ChannelHandlerContext channelHandlerContext) throws Exception {
        try {
            if (channelHandlerContext.channel().isWritable()) {
                flush(channelHandlerContext);
            }
            this.encoder.flowController().channelWritabilityChanged();
            super.channelWritabilityChanged(channelHandlerContext);
        } catch (Throwable th) {
            super.channelWritabilityChanged(channelHandlerContext);
            throw th;
        }
    }

    @Override // io.netty.handler.codec.http2.Http2LifecycleManager
    public void closeStream(Http2Stream http2Stream, ChannelFuture channelFuture) {
        http2Stream.close();
        if (channelFuture.isDone()) {
            checkCloseConnection(channelFuture);
        } else {
            channelFuture.addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.handler.codec.http2.Http2ConnectionHandler.2
                @Override // io.netty.util.concurrent.GenericFutureListener
                public void operationComplete(ChannelFuture channelFuture2) throws Exception {
                    Http2ConnectionHandler.this.checkCloseConnection(channelFuture2);
                }
            });
        }
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public void connect(ChannelHandlerContext channelHandlerContext, SocketAddress socketAddress, SocketAddress socketAddress2, ChannelPromise channelPromise) throws Exception {
        channelHandlerContext.connect(socketAddress, socketAddress2, channelPromise);
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public void deregister(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) throws Exception {
        channelHandlerContext.deregister(channelPromise);
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public void disconnect(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) throws Exception {
        channelHandlerContext.disconnect(channelPromise);
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler, io.netty.channel.ChannelInboundHandler
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th) throws Exception {
        if (Http2CodecUtil.getEmbeddedHttp2Exception(th) != null) {
            onError(channelHandlerContext, false, th);
        } else {
            super.exceptionCaught(channelHandlerContext, th);
        }
    }

    protected Http2FrameWriter frameWriter() {
        return encoder().frameWriter();
    }

    protected void handleServerHeaderDecodeSizeError(ChannelHandlerContext channelHandlerContext, Http2Stream http2Stream) {
        encoder().writeHeaders(channelHandlerContext, http2Stream.id(), HEADERS_TOO_LARGE_HEADERS, 0, true, channelHandlerContext.newPromise());
    }

    protected boolean isGracefulShutdownComplete() {
        if (connection().numActiveStreams() == 0) {
            return true;
        }
        return false;
    }

    @Override // io.netty.handler.codec.http2.Http2LifecycleManager
    public void onError(ChannelHandlerContext channelHandlerContext, boolean z5, Throwable th) {
        Http2Exception embeddedHttp2Exception = Http2CodecUtil.getEmbeddedHttp2Exception(th);
        if (Http2Exception.isStreamError(embeddedHttp2Exception)) {
            onStreamError(channelHandlerContext, z5, th, (Http2Exception.StreamException) embeddedHttp2Exception);
        } else if (embeddedHttp2Exception instanceof Http2Exception.CompositeStreamException) {
            Iterator<Http2Exception.StreamException> it = ((Http2Exception.CompositeStreamException) embeddedHttp2Exception).iterator();
            while (it.hasNext()) {
                onStreamError(channelHandlerContext, z5, th, it.next());
            }
        } else {
            onConnectionError(channelHandlerContext, z5, th, embeddedHttp2Exception);
        }
        channelHandlerContext.flush();
    }

    public void onHttpClientUpgrade() throws Http2Exception {
        if (!connection().isServer()) {
            if (prefaceSent()) {
                if (!this.decoder.prefaceReceived()) {
                    connection().local().createStream(1, true);
                    return;
                }
                throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "HTTP upgrade must occur before HTTP/2 preface is received", new Object[0]);
            }
            throw Http2Exception.connectionError(Http2Error.INTERNAL_ERROR, "HTTP upgrade must occur after preface was sent", new Object[0]);
        }
        throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Client-side HTTP upgrade requested for a server", new Object[0]);
    }

    public void onHttpServerUpgrade(Http2Settings http2Settings) throws Http2Exception {
        if (connection().isServer()) {
            if (prefaceSent()) {
                if (!this.decoder.prefaceReceived()) {
                    this.encoder.remoteSettings(http2Settings);
                    connection().remote().createStream(1, true);
                    return;
                }
                throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "HTTP upgrade must occur before HTTP/2 preface is received", new Object[0]);
            }
            throw Http2Exception.connectionError(Http2Error.INTERNAL_ERROR, "HTTP upgrade must occur after preface was sent", new Object[0]);
        }
        throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Server-side HTTP upgrade requested for a client", new Object[0]);
    }

    protected void onStreamError(ChannelHandlerContext channelHandlerContext, boolean z5, Throwable th, Http2Exception.StreamException streamException) {
        int i6;
        Http2Stream createStream;
        int streamId = streamException.streamId();
        Http2Stream stream = connection().stream(streamId);
        if ((streamException instanceof Http2Exception.HeaderListSizeException) && ((Http2Exception.HeaderListSizeException) streamException).duringDecode() && connection().isServer()) {
            if (stream == null) {
                try {
                    createStream = this.encoder.connection().remote().createStream(streamId, true);
                    i6 = streamId;
                } catch (Http2Exception unused) {
                    resetUnknownStream(channelHandlerContext, streamId, streamException.error().code(), channelHandlerContext.newPromise());
                    return;
                }
            } else {
                i6 = streamId;
                createStream = stream;
            }
            if (createStream != null && !createStream.isHeadersSent()) {
                try {
                    handleServerHeaderDecodeSizeError(channelHandlerContext, createStream);
                } catch (Throwable th2) {
                    onError(channelHandlerContext, z5, Http2Exception.connectionError(Http2Error.INTERNAL_ERROR, th2, "Error DecodeSizeError", new Object[0]));
                }
            }
            stream = createStream;
        } else {
            i6 = streamId;
        }
        if (stream == null) {
            if (!z5 || connection().local().mayHaveCreatedStream(i6)) {
                resetUnknownStream(channelHandlerContext, i6, streamException.error().code(), channelHandlerContext.newPromise());
                return;
            }
            return;
        }
        resetStream(channelHandlerContext, stream, streamException.error().code(), channelHandlerContext.newPromise());
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public void read(ChannelHandlerContext channelHandlerContext) throws Exception {
        channelHandlerContext.read();
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public void write(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) throws Exception {
        channelHandlerContext.write(obj, channelPromise);
    }

    private ChannelFuture resetStream(ChannelHandlerContext channelHandlerContext, final Http2Stream http2Stream, long j6, ChannelPromise channelPromise) {
        final ChannelHandlerContext channelHandlerContext2;
        ChannelFuture success;
        ChannelPromise unvoid = channelPromise.unvoid();
        if (http2Stream.isResetSent()) {
            return unvoid.setSuccess();
        }
        if (http2Stream.state() != Http2Stream.State.IDLE && (!connection().local().created(http2Stream) || http2Stream.isHeadersSent() || http2Stream.isPushPromiseSent())) {
            channelHandlerContext2 = channelHandlerContext;
            success = frameWriter().writeRstStream(channelHandlerContext2, http2Stream.id(), j6, unvoid);
        } else {
            channelHandlerContext2 = channelHandlerContext;
            success = unvoid.setSuccess();
        }
        http2Stream.resetSent();
        if (success.isDone()) {
            processRstStreamWriteResult(channelHandlerContext2, http2Stream, success);
            return success;
        }
        success.addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.handler.codec.http2.Http2ConnectionHandler.4
            @Override // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(ChannelFuture channelFuture) throws Exception {
                Http2ConnectionHandler.this.processRstStreamWriteResult(channelHandlerContext2, http2Stream, channelFuture);
            }
        });
        return success;
    }

    private ChannelFuture goAway(ChannelHandlerContext channelHandlerContext, Http2Exception http2Exception, ChannelPromise channelPromise) {
        return goAway(channelHandlerContext, connection().remote().lastStreamCreated(), (http2Exception != null ? http2Exception.error() : Http2Error.NO_ERROR).code(), Http2CodecUtil.toByteBuf(channelHandlerContext, http2Exception), channelPromise);
    }
}
