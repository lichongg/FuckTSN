package io.netty.handler.codec.http2;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http2.Http2Connection;
import io.netty.handler.codec.http2.Http2FrameReader;
import io.netty.handler.codec.http2.Http2HeadersDecoder;
import io.netty.handler.codec.http2.Http2Stream;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class DefaultHttp2ConnectionDecoder implements Http2ConnectionDecoder {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) DefaultHttp2ConnectionDecoder.class);
    private final boolean autoAckPing;
    private final Http2Connection connection;
    private final Http2ConnectionEncoder encoder;
    private final Http2FrameReader frameReader;
    private Http2FrameListener internalFrameListener;
    private Http2LifecycleManager lifecycleManager;
    private Http2FrameListener listener;
    private final Http2PromisedRequestVerifier requestVerifier;
    private final Http2SettingsReceivedConsumer settingsReceivedConsumer;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class FrameReadListener implements Http2FrameListener {
        private FrameReadListener() {
        }

        private boolean shouldIgnoreHeadersOrDataFrame(ChannelHandlerContext channelHandlerContext, int i6, Http2Stream http2Stream, String str) throws Http2Exception {
            String str2;
            if (http2Stream == null) {
                if (!streamCreatedAfterGoAwaySent(i6)) {
                    throw Http2Exception.streamError(i6, Http2Error.STREAM_CLOSED, "Received %s frame for an unknown stream %d", str, Integer.valueOf(i6));
                }
                DefaultHttp2ConnectionDecoder.logger.info("{} ignoring {} frame for stream {}. Stream sent after GOAWAY sent", channelHandlerContext.channel(), str, Integer.valueOf(i6));
                return true;
            }
            if (!http2Stream.isResetSent() && !streamCreatedAfterGoAwaySent(i6)) {
                return false;
            }
            if (DefaultHttp2ConnectionDecoder.logger.isInfoEnabled()) {
                InternalLogger internalLogger = DefaultHttp2ConnectionDecoder.logger;
                Channel channel = channelHandlerContext.channel();
                if (http2Stream.isResetSent()) {
                    str2 = "RST_STREAM sent.";
                } else {
                    str2 = "Stream created after GOAWAY sent. Last known stream by peer " + DefaultHttp2ConnectionDecoder.this.connection.remote().lastStreamKnownByPeer();
                }
                internalLogger.info("{} ignoring {} frame for stream {}", channel, str, str2);
            }
            return true;
        }

        @Override // io.netty.handler.codec.http2.Http2FrameListener
        public void onHeadersRead(ChannelHandlerContext channelHandlerContext, int i6, Http2Headers http2Headers, int i7, boolean z5) throws Http2Exception {
            onHeadersRead(channelHandlerContext, i6, http2Headers, 0, (short) 16, false, i7, z5);
        }

        /* synthetic */ FrameReadListener(DefaultHttp2ConnectionDecoder defaultHttp2ConnectionDecoder, AnonymousClass1 anonymousClass1) {
            this();
        }

        private boolean streamCreatedAfterGoAwaySent(int i6) {
            Http2Connection.Endpoint<Http2RemoteFlowController> remote = DefaultHttp2ConnectionDecoder.this.connection.remote();
            return DefaultHttp2ConnectionDecoder.this.connection.goAwaySent() && remote.isValidStreamId(i6) && i6 > remote.lastStreamKnownByPeer();
        }

        private void verifyStreamMayHaveExisted(int i6) throws Http2Exception {
            if (!DefaultHttp2ConnectionDecoder.this.connection.streamMayHaveExisted(i6)) {
                throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Stream %d does not exist", Integer.valueOf(i6));
            }
        }

        /* JADX WARN: Finally extract failed */
        @Override // io.netty.handler.codec.http2.Http2FrameListener
        public int onDataRead(ChannelHandlerContext channelHandlerContext, int i6, ByteBuf byteBuf, int i7, boolean z5) throws Http2Exception {
            Http2Stream stream = DefaultHttp2ConnectionDecoder.this.connection.stream(i6);
            Http2LocalFlowController flowController = DefaultHttp2ConnectionDecoder.this.flowController();
            int readableBytes = byteBuf.readableBytes() + i7;
            try {
                if (shouldIgnoreHeadersOrDataFrame(channelHandlerContext, i6, stream, "DATA")) {
                    flowController.receiveFlowControlledFrame(stream, byteBuf, i7, z5);
                    flowController.consumeBytes(stream, readableBytes);
                    verifyStreamMayHaveExisted(i6);
                    return readableBytes;
                }
                int i8 = AnonymousClass1.$SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[stream.state().ordinal()];
                Http2Exception streamError = (i8 == 1 || i8 == 2) ? null : (i8 == 3 || i8 == 4) ? Http2Exception.streamError(stream.id(), Http2Error.STREAM_CLOSED, "Stream %d in unexpected state: %s", Integer.valueOf(stream.id()), stream.state()) : Http2Exception.streamError(stream.id(), Http2Error.PROTOCOL_ERROR, "Stream %d in unexpected state: %s", Integer.valueOf(stream.id()), stream.state());
                int unconsumedBytes = DefaultHttp2ConnectionDecoder.this.unconsumedBytes(stream);
                try {
                    try {
                        flowController.receiveFlowControlledFrame(stream, byteBuf, i7, z5);
                        int unconsumedBytes2 = DefaultHttp2ConnectionDecoder.this.unconsumedBytes(stream);
                        try {
                            if (streamError != null) {
                                throw streamError;
                            }
                            int onDataRead = DefaultHttp2ConnectionDecoder.this.listener.onDataRead(channelHandlerContext, i6, byteBuf, i7, z5);
                            flowController.consumeBytes(stream, onDataRead);
                            if (z5) {
                                DefaultHttp2ConnectionDecoder.this.lifecycleManager.closeStreamRemote(stream, channelHandlerContext.newSucceededFuture());
                            }
                            return onDataRead;
                        } catch (Http2Exception e6) {
                            e = e6;
                            unconsumedBytes = unconsumedBytes2;
                            int unconsumedBytes3 = readableBytes - (unconsumedBytes - DefaultHttp2ConnectionDecoder.this.unconsumedBytes(stream));
                            throw e;
                        } catch (RuntimeException e7) {
                            e = e7;
                            unconsumedBytes = unconsumedBytes2;
                            int unconsumedBytes4 = readableBytes - (unconsumedBytes - DefaultHttp2ConnectionDecoder.this.unconsumedBytes(stream));
                            throw e;
                        }
                    } catch (Http2Exception e8) {
                        e = e8;
                    } catch (RuntimeException e9) {
                        e = e9;
                    }
                } catch (Throwable th) {
                    flowController.consumeBytes(stream, readableBytes);
                    if (z5) {
                        DefaultHttp2ConnectionDecoder.this.lifecycleManager.closeStreamRemote(stream, channelHandlerContext.newSucceededFuture());
                    }
                    throw th;
                }
            } catch (Http2Exception e10) {
                flowController.receiveFlowControlledFrame(stream, byteBuf, i7, z5);
                flowController.consumeBytes(stream, readableBytes);
                throw e10;
            } catch (Throwable th2) {
                throw Http2Exception.connectionError(Http2Error.INTERNAL_ERROR, th2, "Unhandled error on data stream id %d", Integer.valueOf(i6));
            }
        }

        @Override // io.netty.handler.codec.http2.Http2FrameListener
        public void onGoAwayRead(ChannelHandlerContext channelHandlerContext, int i6, long j6, ByteBuf byteBuf) throws Http2Exception {
            DefaultHttp2ConnectionDecoder.this.onGoAwayRead0(channelHandlerContext, i6, j6, byteBuf);
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0041  */
        /* JADX WARN: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
        @Override // io.netty.handler.codec.http2.Http2FrameListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onHeadersRead(io.netty.channel.ChannelHandlerContext r11, int r12, io.netty.handler.codec.http2.Http2Headers r13, int r14, short r15, boolean r16, int r17, boolean r18) throws io.netty.handler.codec.http2.Http2Exception {
            /*
                Method dump skipped, instructions count: 305
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.http2.DefaultHttp2ConnectionDecoder.FrameReadListener.onHeadersRead(io.netty.channel.ChannelHandlerContext, int, io.netty.handler.codec.http2.Http2Headers, int, short, boolean, int, boolean):void");
        }

        @Override // io.netty.handler.codec.http2.Http2FrameListener
        public void onPingAckRead(ChannelHandlerContext channelHandlerContext, long j6) throws Http2Exception {
            DefaultHttp2ConnectionDecoder.this.listener.onPingAckRead(channelHandlerContext, j6);
        }

        @Override // io.netty.handler.codec.http2.Http2FrameListener
        public void onPingRead(ChannelHandlerContext channelHandlerContext, long j6) throws Http2Exception {
            ChannelHandlerContext channelHandlerContext2;
            long j7;
            if (DefaultHttp2ConnectionDecoder.this.autoAckPing) {
                channelHandlerContext2 = channelHandlerContext;
                j7 = j6;
                DefaultHttp2ConnectionDecoder.this.encoder.writePing(channelHandlerContext2, true, j7, channelHandlerContext.newPromise());
            } else {
                channelHandlerContext2 = channelHandlerContext;
                j7 = j6;
            }
            DefaultHttp2ConnectionDecoder.this.listener.onPingRead(channelHandlerContext2, j7);
        }

        @Override // io.netty.handler.codec.http2.Http2FrameListener
        public void onPriorityRead(ChannelHandlerContext channelHandlerContext, int i6, int i7, short s5, boolean z5) throws Http2Exception {
            DefaultHttp2ConnectionDecoder.this.encoder.flowController().updateDependencyTree(i6, i7, s5, z5);
            DefaultHttp2ConnectionDecoder.this.listener.onPriorityRead(channelHandlerContext, i6, i7, s5, z5);
        }

        @Override // io.netty.handler.codec.http2.Http2FrameListener
        public void onPushPromiseRead(ChannelHandlerContext channelHandlerContext, int i6, int i7, Http2Headers http2Headers, int i8) throws Http2Exception {
            if (DefaultHttp2ConnectionDecoder.this.connection().isServer()) {
                throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "A client cannot push.", new Object[0]);
            }
            Http2Stream stream = DefaultHttp2ConnectionDecoder.this.connection.stream(i6);
            if (shouldIgnoreHeadersOrDataFrame(channelHandlerContext, i6, stream, "PUSH_PROMISE")) {
                return;
            }
            if (stream == null) {
                throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Stream %d does not exist", Integer.valueOf(i6));
            }
            int i9 = AnonymousClass1.$SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[stream.state().ordinal()];
            if (i9 != 1 && i9 != 2) {
                throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Stream %d in unexpected state for receiving push promise: %s", Integer.valueOf(stream.id()), stream.state());
            }
            if (!DefaultHttp2ConnectionDecoder.this.requestVerifier.isAuthoritative(channelHandlerContext, http2Headers)) {
                throw Http2Exception.streamError(i7, Http2Error.PROTOCOL_ERROR, "Promised request on stream %d for promised stream %d is not authoritative", Integer.valueOf(i6), Integer.valueOf(i7));
            }
            if (!DefaultHttp2ConnectionDecoder.this.requestVerifier.isCacheable(http2Headers)) {
                throw Http2Exception.streamError(i7, Http2Error.PROTOCOL_ERROR, "Promised request on stream %d for promised stream %d is not known to be cacheable", Integer.valueOf(i6), Integer.valueOf(i7));
            }
            if (!DefaultHttp2ConnectionDecoder.this.requestVerifier.isSafe(http2Headers)) {
                throw Http2Exception.streamError(i7, Http2Error.PROTOCOL_ERROR, "Promised request on stream %d for promised stream %d is not known to be safe", Integer.valueOf(i6), Integer.valueOf(i7));
            }
            DefaultHttp2ConnectionDecoder.this.connection.remote().reservePushStream(i7, stream);
            DefaultHttp2ConnectionDecoder.this.listener.onPushPromiseRead(channelHandlerContext, i6, i7, http2Headers, i8);
        }

        @Override // io.netty.handler.codec.http2.Http2FrameListener
        public void onRstStreamRead(ChannelHandlerContext channelHandlerContext, int i6, long j6) throws Http2Exception {
            Http2Stream stream = DefaultHttp2ConnectionDecoder.this.connection.stream(i6);
            if (stream == null) {
                verifyStreamMayHaveExisted(i6);
                return;
            }
            int i7 = AnonymousClass1.$SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[stream.state().ordinal()];
            if (i7 != 4) {
                if (i7 == 6) {
                    throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "RST_STREAM received for IDLE stream %d", Integer.valueOf(i6));
                }
                DefaultHttp2ConnectionDecoder.this.listener.onRstStreamRead(channelHandlerContext, i6, j6);
                DefaultHttp2ConnectionDecoder.this.lifecycleManager.closeStream(stream, channelHandlerContext.newSucceededFuture());
            }
        }

        @Override // io.netty.handler.codec.http2.Http2FrameListener
        public void onSettingsAckRead(ChannelHandlerContext channelHandlerContext) throws Http2Exception {
            Http2Settings pollSentSettings = DefaultHttp2ConnectionDecoder.this.encoder.pollSentSettings();
            if (pollSentSettings != null) {
                applyLocalSettings(pollSentSettings);
            }
            DefaultHttp2ConnectionDecoder.this.listener.onSettingsAckRead(channelHandlerContext);
        }

        @Override // io.netty.handler.codec.http2.Http2FrameListener
        public void onSettingsRead(ChannelHandlerContext channelHandlerContext, Http2Settings http2Settings) throws Http2Exception {
            if (DefaultHttp2ConnectionDecoder.this.settingsReceivedConsumer == null) {
                DefaultHttp2ConnectionDecoder.this.encoder.writeSettingsAck(channelHandlerContext, channelHandlerContext.newPromise());
                DefaultHttp2ConnectionDecoder.this.encoder.remoteSettings(http2Settings);
            } else {
                DefaultHttp2ConnectionDecoder.this.settingsReceivedConsumer.consumeReceivedSettings(http2Settings);
            }
            DefaultHttp2ConnectionDecoder.this.listener.onSettingsRead(channelHandlerContext, http2Settings);
        }

        @Override // io.netty.handler.codec.http2.Http2FrameListener
        public void onUnknownFrame(ChannelHandlerContext channelHandlerContext, byte b6, int i6, Http2Flags http2Flags, ByteBuf byteBuf) throws Http2Exception {
            DefaultHttp2ConnectionDecoder.this.onUnknownFrame0(channelHandlerContext, b6, i6, http2Flags, byteBuf);
        }

        @Override // io.netty.handler.codec.http2.Http2FrameListener
        public void onWindowUpdateRead(ChannelHandlerContext channelHandlerContext, int i6, int i7) throws Http2Exception {
            Http2Stream stream = DefaultHttp2ConnectionDecoder.this.connection.stream(i6);
            if (stream == null || stream.state() == Http2Stream.State.CLOSED || streamCreatedAfterGoAwaySent(i6)) {
                verifyStreamMayHaveExisted(i6);
            } else {
                DefaultHttp2ConnectionDecoder.this.encoder.flowController().incrementWindowSize(stream, i7);
                DefaultHttp2ConnectionDecoder.this.listener.onWindowUpdateRead(channelHandlerContext, i6, i7);
            }
        }

        private void applyLocalSettings(Http2Settings http2Settings) throws Http2Exception {
            Boolean pushEnabled = http2Settings.pushEnabled();
            Http2FrameReader.Configuration configuration = DefaultHttp2ConnectionDecoder.this.frameReader.configuration();
            Http2HeadersDecoder.Configuration headersConfiguration = configuration.headersConfiguration();
            Http2FrameSizePolicy frameSizePolicy = configuration.frameSizePolicy();
            if (pushEnabled != null) {
                if (!DefaultHttp2ConnectionDecoder.this.connection.isServer()) {
                    DefaultHttp2ConnectionDecoder.this.connection.local().allowPushTo(pushEnabled.booleanValue());
                } else {
                    throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Server sending SETTINGS frame with ENABLE_PUSH specified", new Object[0]);
                }
            }
            Long maxConcurrentStreams = http2Settings.maxConcurrentStreams();
            if (maxConcurrentStreams != null) {
                DefaultHttp2ConnectionDecoder.this.connection.remote().maxActiveStreams((int) Math.min(maxConcurrentStreams.longValue(), 2147483647L));
            }
            Long headerTableSize = http2Settings.headerTableSize();
            if (headerTableSize != null) {
                headersConfiguration.maxHeaderTableSize(headerTableSize.longValue());
            }
            Long maxHeaderListSize = http2Settings.maxHeaderListSize();
            if (maxHeaderListSize != null) {
                headersConfiguration.maxHeaderListSize(maxHeaderListSize.longValue(), DefaultHttp2ConnectionDecoder.this.calculateMaxHeaderListSizeGoAway(maxHeaderListSize.longValue()));
            }
            Integer maxFrameSize = http2Settings.maxFrameSize();
            if (maxFrameSize != null) {
                frameSizePolicy.maxFrameSize(maxFrameSize.intValue());
            }
            Integer initialWindowSize = http2Settings.initialWindowSize();
            if (initialWindowSize != null) {
                DefaultHttp2ConnectionDecoder.this.flowController().initialWindowSize(initialWindowSize.intValue());
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class PrefaceFrameListener implements Http2FrameListener {
        private PrefaceFrameListener() {
        }

        @Override // io.netty.handler.codec.http2.Http2FrameListener
        public void onHeadersRead(ChannelHandlerContext channelHandlerContext, int i6, Http2Headers http2Headers, int i7, boolean z5) throws Http2Exception {
            verifyPrefaceReceived();
            DefaultHttp2ConnectionDecoder.this.internalFrameListener.onHeadersRead(channelHandlerContext, i6, http2Headers, i7, z5);
        }

        /* synthetic */ PrefaceFrameListener(DefaultHttp2ConnectionDecoder defaultHttp2ConnectionDecoder, AnonymousClass1 anonymousClass1) {
            this();
        }

        private void verifyPrefaceReceived() throws Http2Exception {
            if (!DefaultHttp2ConnectionDecoder.this.prefaceReceived()) {
                throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Received non-SETTINGS as first frame.", new Object[0]);
            }
        }

        @Override // io.netty.handler.codec.http2.Http2FrameListener
        public void onGoAwayRead(ChannelHandlerContext channelHandlerContext, int i6, long j6, ByteBuf byteBuf) throws Http2Exception {
            DefaultHttp2ConnectionDecoder.this.onGoAwayRead0(channelHandlerContext, i6, j6, byteBuf);
        }

        @Override // io.netty.handler.codec.http2.Http2FrameListener
        public void onSettingsRead(ChannelHandlerContext channelHandlerContext, Http2Settings http2Settings) throws Http2Exception {
            if (!DefaultHttp2ConnectionDecoder.this.prefaceReceived()) {
                DefaultHttp2ConnectionDecoder defaultHttp2ConnectionDecoder = DefaultHttp2ConnectionDecoder.this;
                defaultHttp2ConnectionDecoder.internalFrameListener = new FrameReadListener(defaultHttp2ConnectionDecoder, null);
            }
            DefaultHttp2ConnectionDecoder.this.internalFrameListener.onSettingsRead(channelHandlerContext, http2Settings);
        }

        @Override // io.netty.handler.codec.http2.Http2FrameListener
        public void onUnknownFrame(ChannelHandlerContext channelHandlerContext, byte b6, int i6, Http2Flags http2Flags, ByteBuf byteBuf) throws Http2Exception {
            DefaultHttp2ConnectionDecoder.this.onUnknownFrame0(channelHandlerContext, b6, i6, http2Flags, byteBuf);
        }

        @Override // io.netty.handler.codec.http2.Http2FrameListener
        public int onDataRead(ChannelHandlerContext channelHandlerContext, int i6, ByteBuf byteBuf, int i7, boolean z5) throws Http2Exception {
            verifyPrefaceReceived();
            return DefaultHttp2ConnectionDecoder.this.internalFrameListener.onDataRead(channelHandlerContext, i6, byteBuf, i7, z5);
        }

        @Override // io.netty.handler.codec.http2.Http2FrameListener
        public void onHeadersRead(ChannelHandlerContext channelHandlerContext, int i6, Http2Headers http2Headers, int i7, short s5, boolean z5, int i8, boolean z6) throws Http2Exception {
            verifyPrefaceReceived();
            DefaultHttp2ConnectionDecoder.this.internalFrameListener.onHeadersRead(channelHandlerContext, i6, http2Headers, i7, s5, z5, i8, z6);
        }

        @Override // io.netty.handler.codec.http2.Http2FrameListener
        public void onPingAckRead(ChannelHandlerContext channelHandlerContext, long j6) throws Http2Exception {
            verifyPrefaceReceived();
            DefaultHttp2ConnectionDecoder.this.internalFrameListener.onPingAckRead(channelHandlerContext, j6);
        }

        @Override // io.netty.handler.codec.http2.Http2FrameListener
        public void onPingRead(ChannelHandlerContext channelHandlerContext, long j6) throws Http2Exception {
            verifyPrefaceReceived();
            DefaultHttp2ConnectionDecoder.this.internalFrameListener.onPingRead(channelHandlerContext, j6);
        }

        @Override // io.netty.handler.codec.http2.Http2FrameListener
        public void onPriorityRead(ChannelHandlerContext channelHandlerContext, int i6, int i7, short s5, boolean z5) throws Http2Exception {
            verifyPrefaceReceived();
            DefaultHttp2ConnectionDecoder.this.internalFrameListener.onPriorityRead(channelHandlerContext, i6, i7, s5, z5);
        }

        @Override // io.netty.handler.codec.http2.Http2FrameListener
        public void onPushPromiseRead(ChannelHandlerContext channelHandlerContext, int i6, int i7, Http2Headers http2Headers, int i8) throws Http2Exception {
            verifyPrefaceReceived();
            DefaultHttp2ConnectionDecoder.this.internalFrameListener.onPushPromiseRead(channelHandlerContext, i6, i7, http2Headers, i8);
        }

        @Override // io.netty.handler.codec.http2.Http2FrameListener
        public void onRstStreamRead(ChannelHandlerContext channelHandlerContext, int i6, long j6) throws Http2Exception {
            verifyPrefaceReceived();
            DefaultHttp2ConnectionDecoder.this.internalFrameListener.onRstStreamRead(channelHandlerContext, i6, j6);
        }

        @Override // io.netty.handler.codec.http2.Http2FrameListener
        public void onSettingsAckRead(ChannelHandlerContext channelHandlerContext) throws Http2Exception {
            verifyPrefaceReceived();
            DefaultHttp2ConnectionDecoder.this.internalFrameListener.onSettingsAckRead(channelHandlerContext);
        }

        @Override // io.netty.handler.codec.http2.Http2FrameListener
        public void onWindowUpdateRead(ChannelHandlerContext channelHandlerContext, int i6, int i7) throws Http2Exception {
            verifyPrefaceReceived();
            DefaultHttp2ConnectionDecoder.this.internalFrameListener.onWindowUpdateRead(channelHandlerContext, i6, i7);
        }
    }

    public DefaultHttp2ConnectionDecoder(Http2Connection http2Connection, Http2ConnectionEncoder http2ConnectionEncoder, Http2FrameReader http2FrameReader) {
        this(http2Connection, http2ConnectionEncoder, http2FrameReader, Http2PromisedRequestVerifier.ALWAYS_VERIFY);
    }

    @Override // io.netty.handler.codec.http2.Http2ConnectionDecoder
    public void frameListener(Http2FrameListener http2FrameListener) {
        this.listener = (Http2FrameListener) ObjectUtil.checkNotNull(http2FrameListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: io.netty.handler.codec.http2.DefaultHttp2ConnectionDecoder$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State;

        static {
            int[] iArr = new int[Http2Stream.State.values().length];
            $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State = iArr;
            try {
                iArr[Http2Stream.State.OPEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[Http2Stream.State.HALF_CLOSED_LOCAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[Http2Stream.State.HALF_CLOSED_REMOTE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[Http2Stream.State.CLOSED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[Http2Stream.State.RESERVED_REMOTE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[Http2Stream.State.IDLE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public DefaultHttp2ConnectionDecoder(Http2Connection http2Connection, Http2ConnectionEncoder http2ConnectionEncoder, Http2FrameReader http2FrameReader, Http2PromisedRequestVerifier http2PromisedRequestVerifier) {
        this(http2Connection, http2ConnectionEncoder, http2FrameReader, http2PromisedRequestVerifier, true);
    }

    @Override // io.netty.handler.codec.http2.Http2ConnectionDecoder, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.frameReader.close();
    }

    @Override // io.netty.handler.codec.http2.Http2ConnectionDecoder
    public Http2Connection connection() {
        return this.connection;
    }

    @Override // io.netty.handler.codec.http2.Http2ConnectionDecoder
    public void decodeFrame(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Http2Exception {
        this.frameReader.readFrame(channelHandlerContext, byteBuf, this.internalFrameListener);
    }

    @Override // io.netty.handler.codec.http2.Http2ConnectionDecoder
    public final Http2LocalFlowController flowController() {
        return this.connection.local().flowController();
    }

    @Override // io.netty.handler.codec.http2.Http2ConnectionDecoder
    public Http2FrameListener frameListener() {
        return this.listener;
    }

    Http2FrameListener internalFrameListener() {
        return this.internalFrameListener;
    }

    @Override // io.netty.handler.codec.http2.Http2ConnectionDecoder
    public void lifecycleManager(Http2LifecycleManager http2LifecycleManager) {
        this.lifecycleManager = (Http2LifecycleManager) ObjectUtil.checkNotNull(http2LifecycleManager, "lifecycleManager");
    }

    @Override // io.netty.handler.codec.http2.Http2ConnectionDecoder
    public Http2Settings localSettings() {
        Http2Settings http2Settings = new Http2Settings();
        Http2FrameReader.Configuration configuration = this.frameReader.configuration();
        Http2HeadersDecoder.Configuration headersConfiguration = configuration.headersConfiguration();
        Http2FrameSizePolicy frameSizePolicy = configuration.frameSizePolicy();
        http2Settings.initialWindowSize(flowController().initialWindowSize());
        http2Settings.maxConcurrentStreams(this.connection.remote().maxActiveStreams());
        http2Settings.headerTableSize(headersConfiguration.maxHeaderTableSize());
        http2Settings.maxFrameSize(frameSizePolicy.maxFrameSize());
        http2Settings.maxHeaderListSize(headersConfiguration.maxHeaderListSize());
        if (!this.connection.isServer()) {
            http2Settings.pushEnabled(this.connection.local().allowPushTo());
        }
        return http2Settings;
    }

    void onGoAwayRead0(ChannelHandlerContext channelHandlerContext, int i6, long j6, ByteBuf byteBuf) throws Http2Exception {
        this.connection.goAwayReceived(i6, j6, byteBuf);
        this.listener.onGoAwayRead(channelHandlerContext, i6, j6, byteBuf);
    }

    void onUnknownFrame0(ChannelHandlerContext channelHandlerContext, byte b6, int i6, Http2Flags http2Flags, ByteBuf byteBuf) throws Http2Exception {
        this.listener.onUnknownFrame(channelHandlerContext, b6, i6, http2Flags, byteBuf);
    }

    @Override // io.netty.handler.codec.http2.Http2ConnectionDecoder
    public boolean prefaceReceived() {
        return FrameReadListener.class == this.internalFrameListener.getClass();
    }

    public DefaultHttp2ConnectionDecoder(Http2Connection http2Connection, Http2ConnectionEncoder http2ConnectionEncoder, Http2FrameReader http2FrameReader, Http2PromisedRequestVerifier http2PromisedRequestVerifier, boolean z5) {
        this(http2Connection, http2ConnectionEncoder, http2FrameReader, http2PromisedRequestVerifier, z5, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int unconsumedBytes(Http2Stream http2Stream) {
        return flowController().unconsumedBytes(http2Stream);
    }

    protected long calculateMaxHeaderListSizeGoAway(long j6) {
        return Http2CodecUtil.calculateMaxHeaderListSizeGoAway(j6);
    }

    public DefaultHttp2ConnectionDecoder(Http2Connection http2Connection, Http2ConnectionEncoder http2ConnectionEncoder, Http2FrameReader http2FrameReader, Http2PromisedRequestVerifier http2PromisedRequestVerifier, boolean z5, boolean z6) {
        this.internalFrameListener = new PrefaceFrameListener(this, null);
        this.autoAckPing = z6;
        if (z5) {
            this.settingsReceivedConsumer = null;
        } else if (http2ConnectionEncoder instanceof Http2SettingsReceivedConsumer) {
            this.settingsReceivedConsumer = (Http2SettingsReceivedConsumer) http2ConnectionEncoder;
        } else {
            throw new IllegalArgumentException("disabling autoAckSettings requires the encoder to be a " + Http2SettingsReceivedConsumer.class);
        }
        this.connection = (Http2Connection) ObjectUtil.checkNotNull(http2Connection, "connection");
        this.frameReader = (Http2FrameReader) ObjectUtil.checkNotNull(http2FrameReader, "frameReader");
        this.encoder = (Http2ConnectionEncoder) ObjectUtil.checkNotNull(http2ConnectionEncoder, "encoder");
        this.requestVerifier = (Http2PromisedRequestVerifier) ObjectUtil.checkNotNull(http2PromisedRequestVerifier, "requestVerifier");
        if (http2Connection.local().flowController() == null) {
            http2Connection.local().flowController(new DefaultHttp2LocalFlowController(http2Connection));
        }
        http2Connection.local().flowController().frameWriter(http2ConnectionEncoder.frameWriter());
    }
}
