package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.channel.CoalescingBufferQueue;
import io.netty.handler.codec.http.HttpStatusClass;
import io.netty.handler.codec.http2.Http2CodecUtil;
import io.netty.handler.codec.http2.Http2FrameWriter;
import io.netty.handler.codec.http2.Http2HeadersEncoder;
import io.netty.handler.codec.http2.Http2RemoteFlowController;
import io.netty.handler.codec.http2.Http2Stream;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.internal.ObjectUtil;
import java.util.ArrayDeque;
import java.util.Queue;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class DefaultHttp2ConnectionEncoder implements Http2ConnectionEncoder, Http2SettingsReceivedConsumer {
    private final Http2Connection connection;
    private final Http2FrameWriter frameWriter;
    private Http2LifecycleManager lifecycleManager;
    private final Queue<Http2Settings> outstandingLocalSettingsQueue = new ArrayDeque(4);
    private Queue<Http2Settings> outstandingRemoteSettingsQueue;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public abstract class FlowControlledBase implements Http2RemoteFlowController.FlowControlled, ChannelFutureListener {
        protected boolean endOfStream;
        protected int padding;
        protected ChannelPromise promise;
        protected final Http2Stream stream;

        FlowControlledBase(Http2Stream http2Stream, int i6, boolean z5, ChannelPromise channelPromise) {
            ObjectUtil.checkPositiveOrZero(i6, "padding");
            this.padding = i6;
            this.endOfStream = z5;
            this.stream = http2Stream;
            this.promise = channelPromise;
        }

        @Override // io.netty.util.concurrent.GenericFutureListener
        public void operationComplete(ChannelFuture channelFuture) throws Exception {
            if (channelFuture.isSuccess()) {
                return;
            }
            error(DefaultHttp2ConnectionEncoder.this.flowController().channelHandlerContext(), channelFuture.cause());
        }

        @Override // io.netty.handler.codec.http2.Http2RemoteFlowController.FlowControlled
        public void writeComplete() {
            if (this.endOfStream) {
                DefaultHttp2ConnectionEncoder.this.lifecycleManager.closeStreamLocal(this.stream, this.promise);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class FlowControlledData extends FlowControlledBase {
        private int dataSize;
        private final CoalescingBufferQueue queue;

        FlowControlledData(Http2Stream http2Stream, ByteBuf byteBuf, int i6, boolean z5, ChannelPromise channelPromise) {
            super(http2Stream, i6, z5, channelPromise);
            CoalescingBufferQueue coalescingBufferQueue = new CoalescingBufferQueue(channelPromise.channel());
            this.queue = coalescingBufferQueue;
            coalescingBufferQueue.add(byteBuf, channelPromise);
            this.dataSize = coalescingBufferQueue.readableBytes();
        }

        @Override // io.netty.handler.codec.http2.Http2RemoteFlowController.FlowControlled
        public void error(ChannelHandlerContext channelHandlerContext, Throwable th) {
            this.queue.releaseAndFailAll(th);
            DefaultHttp2ConnectionEncoder.this.lifecycleManager.onError(channelHandlerContext, true, th);
        }

        @Override // io.netty.handler.codec.http2.Http2RemoteFlowController.FlowControlled
        public boolean merge(ChannelHandlerContext channelHandlerContext, Http2RemoteFlowController.FlowControlled flowControlled) {
            if (FlowControlledData.class != flowControlled.getClass()) {
                return false;
            }
            FlowControlledData flowControlledData = (FlowControlledData) flowControlled;
            if (Integer.MAX_VALUE - flowControlledData.size() < size()) {
                return false;
            }
            flowControlledData.queue.copyTo(this.queue);
            this.dataSize = this.queue.readableBytes();
            this.padding = Math.max(this.padding, flowControlledData.padding);
            this.endOfStream = flowControlledData.endOfStream;
            return true;
        }

        @Override // io.netty.handler.codec.http2.Http2RemoteFlowController.FlowControlled
        public int size() {
            return this.dataSize + this.padding;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r12v11, types: [io.netty.channel.ChannelPromise] */
        /* JADX WARN: Type inference failed for: r9v0, types: [io.netty.channel.ChannelPromise] */
        @Override // io.netty.handler.codec.http2.Http2RemoteFlowController.FlowControlled
        public void write(ChannelHandlerContext channelHandlerContext, int i6) {
            int readableBytes = this.queue.readableBytes();
            if (!this.endOfStream) {
                if (readableBytes == 0) {
                    if (this.queue.isEmpty()) {
                        this.dataSize = 0;
                        this.padding = 0;
                        return;
                    } else {
                        ?? addListener = channelHandlerContext.newPromise().addListener((GenericFutureListener<? extends Future<? super Void>>) this);
                        channelHandlerContext.write(this.queue.remove(0, addListener), addListener);
                        return;
                    }
                }
                if (i6 == 0) {
                    return;
                }
            }
            int min = Math.min(readableBytes, i6);
            ?? addListener2 = channelHandlerContext.newPromise().addListener((GenericFutureListener<? extends Future<? super Void>>) this);
            ByteBuf remove = this.queue.remove(min, addListener2);
            this.dataSize = this.queue.readableBytes();
            int min2 = Math.min(i6 - min, this.padding);
            this.padding -= min2;
            DefaultHttp2ConnectionEncoder.this.frameWriter().writeData(channelHandlerContext, this.stream.id(), remove, min2, this.endOfStream && size() == 0, addListener2);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class FlowControlledHeaders extends FlowControlledBase {
        private final boolean exclusive;
        private final Http2Headers headers;
        private final int streamDependency;
        private final short weight;

        @Override // io.netty.handler.codec.http2.Http2RemoteFlowController.FlowControlled
        public boolean merge(ChannelHandlerContext channelHandlerContext, Http2RemoteFlowController.FlowControlled flowControlled) {
            return false;
        }

        @Override // io.netty.handler.codec.http2.Http2RemoteFlowController.FlowControlled
        public int size() {
            return 0;
        }

        FlowControlledHeaders(Http2Stream http2Stream, Http2Headers http2Headers, int i6, short s5, boolean z5, int i7, boolean z6, ChannelPromise channelPromise) {
            super(http2Stream, i7, z6, channelPromise.unvoid());
            this.headers = http2Headers;
            this.streamDependency = i6;
            this.weight = s5;
            this.exclusive = z5;
        }

        @Override // io.netty.handler.codec.http2.Http2RemoteFlowController.FlowControlled
        public void error(ChannelHandlerContext channelHandlerContext, Throwable th) {
            if (channelHandlerContext != null) {
                DefaultHttp2ConnectionEncoder.this.lifecycleManager.onError(channelHandlerContext, true, th);
            }
            this.promise.tryFailure(th);
        }

        @Override // io.netty.handler.codec.http2.Http2RemoteFlowController.FlowControlled
        public void write(ChannelHandlerContext channelHandlerContext, int i6) {
            boolean validateHeadersSentState = DefaultHttp2ConnectionEncoder.validateHeadersSentState(this.stream, this.headers, DefaultHttp2ConnectionEncoder.this.connection.isServer(), this.endOfStream);
            this.promise.addListener((GenericFutureListener<? extends Future<? super Void>>) this);
            if (DefaultHttp2ConnectionEncoder.this.frameWriter.writeHeaders(channelHandlerContext, this.stream.id(), this.headers, this.streamDependency, this.weight, this.exclusive, this.padding, this.endOfStream, this.promise).cause() == null) {
                this.stream.headersSent(validateHeadersSentState);
            }
        }
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeHeaders(ChannelHandlerContext channelHandlerContext, int i6, Http2Headers http2Headers, int i7, boolean z5, ChannelPromise channelPromise) {
        return writeHeaders(channelHandlerContext, i6, http2Headers, 0, (short) 16, false, i7, z5, channelPromise);
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writePushPromise(ChannelHandlerContext channelHandlerContext, int i6, int i7, Http2Headers http2Headers, int i8, ChannelPromise channelPromise) {
        ChannelPromise channelPromise2;
        try {
            if (this.connection.goAwayReceived()) {
                throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Sending PUSH_PROMISE after GO_AWAY received.", new Object[0]);
            }
            Http2Stream requireStream = requireStream(i6);
            this.connection.local().reservePushStream(i7, requireStream);
            channelPromise2 = channelPromise.unvoid();
            try {
                ChannelFuture writePushPromise = this.frameWriter.writePushPromise(channelHandlerContext, i6, i7, http2Headers, i8, channelPromise2);
                Throwable cause = writePushPromise.cause();
                if (cause != null) {
                    this.lifecycleManager.onError(channelHandlerContext, true, cause);
                    return writePushPromise;
                }
                requireStream.pushPromiseSent();
                if (writePushPromise.isSuccess()) {
                    return writePushPromise;
                }
                notifyLifecycleManagerOnError(writePushPromise, channelHandlerContext);
                return writePushPromise;
            } catch (Throwable th) {
                th = th;
                this.lifecycleManager.onError(channelHandlerContext, true, th);
                channelPromise2.tryFailure(th);
                return channelPromise2;
            }
        } catch (Throwable th2) {
            th = th2;
            channelPromise2 = channelPromise;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: io.netty.handler.codec.http2.DefaultHttp2ConnectionEncoder$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State;

        static {
            int[] iArr = new int[Http2Stream.State.values().length];
            $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State = iArr;
            try {
                iArr[Http2Stream.State.OPEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[Http2Stream.State.HALF_CLOSED_REMOTE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[Http2Stream.State.RESERVED_LOCAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private void notifyLifecycleManagerOnError(ChannelFuture channelFuture, final ChannelHandlerContext channelHandlerContext) {
        channelFuture.addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.handler.codec.http2.DefaultHttp2ConnectionEncoder.1
            @Override // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(ChannelFuture channelFuture2) throws Exception {
                Throwable cause = channelFuture2.cause();
                if (cause != null) {
                    DefaultHttp2ConnectionEncoder.this.lifecycleManager.onError(channelHandlerContext, true, cause);
                }
            }
        });
    }

    private Http2Stream requireStream(int i6) {
        String str;
        Http2Stream stream = this.connection.stream(i6);
        if (stream != null) {
            return stream;
        }
        if (this.connection.streamMayHaveExisted(i6)) {
            str = "Stream no longer exists: " + i6;
        } else {
            str = "Stream does not exist: " + i6;
        }
        throw new IllegalArgumentException(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean validateHeadersSentState(Http2Stream http2Stream, Http2Headers http2Headers, boolean z5, boolean z6) {
        boolean z7 = z5 && HttpStatusClass.valueOf(http2Headers.status()) == HttpStatusClass.INFORMATIONAL;
        if (((!z7 && z6) || !http2Stream.isHeadersSent()) && !http2Stream.isTrailersSent()) {
            return z7;
        }
        throw new IllegalStateException("Stream " + http2Stream.id() + " sent too many headers EOS: " + z6);
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.frameWriter.close();
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public Http2FrameWriter.Configuration configuration() {
        return this.frameWriter.configuration();
    }

    @Override // io.netty.handler.codec.http2.Http2ConnectionEncoder
    public Http2Connection connection() {
        return this.connection;
    }

    @Override // io.netty.handler.codec.http2.Http2SettingsReceivedConsumer
    public void consumeReceivedSettings(Http2Settings http2Settings) {
        if (this.outstandingRemoteSettingsQueue == null) {
            this.outstandingRemoteSettingsQueue = new ArrayDeque(2);
        }
        this.outstandingRemoteSettingsQueue.add(http2Settings);
    }

    @Override // io.netty.handler.codec.http2.Http2ConnectionEncoder
    public Http2FrameWriter frameWriter() {
        return this.frameWriter;
    }

    @Override // io.netty.handler.codec.http2.Http2ConnectionEncoder
    public void lifecycleManager(Http2LifecycleManager http2LifecycleManager) {
        this.lifecycleManager = (Http2LifecycleManager) ObjectUtil.checkNotNull(http2LifecycleManager, "lifecycleManager");
    }

    @Override // io.netty.handler.codec.http2.Http2ConnectionEncoder
    public Http2Settings pollSentSettings() {
        return this.outstandingLocalSettingsQueue.poll();
    }

    @Override // io.netty.handler.codec.http2.Http2ConnectionEncoder, io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeFrame(ChannelHandlerContext channelHandlerContext, byte b6, int i6, Http2Flags http2Flags, ByteBuf byteBuf, ChannelPromise channelPromise) {
        return this.frameWriter.writeFrame(channelHandlerContext, b6, i6, http2Flags, byteBuf, channelPromise);
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeGoAway(ChannelHandlerContext channelHandlerContext, int i6, long j6, ByteBuf byteBuf, ChannelPromise channelPromise) {
        return this.lifecycleManager.goAway(channelHandlerContext, i6, j6, byteBuf, channelPromise);
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeHeaders(ChannelHandlerContext channelHandlerContext, int i6, Http2Headers http2Headers, int i7, short s5, boolean z5, int i8, boolean z6, ChannelPromise channelPromise) {
        Throwable th;
        ChannelPromise channelPromise2 = channelPromise;
        try {
            Http2Stream stream = this.connection.stream(i6);
            try {
                if (stream == null) {
                    try {
                        stream = this.connection.local().createStream(i6, false);
                    } catch (Http2Exception e6) {
                        if (!this.connection.remote().mayHaveCreatedStream(i6)) {
                            throw e6;
                        }
                        channelPromise2.tryFailure(new IllegalStateException("Stream no longer exists: " + i6, e6));
                        return channelPromise2;
                    }
                } else {
                    int i9 = AnonymousClass2.$SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[stream.state().ordinal()];
                    if (i9 != 1 && i9 != 2) {
                        if (i9 != 3) {
                            throw new IllegalStateException("Stream " + stream.id() + " in unexpected state " + stream.state());
                        }
                        stream.open(z6);
                    }
                }
                Http2Stream http2Stream = stream;
                Http2RemoteFlowController flowController = flowController();
                if (z6 && flowController.hasFlowControlled(http2Stream)) {
                    flowController.addFlowControlled(http2Stream, new FlowControlledHeaders(http2Stream, http2Headers, i7, s5, z5, i8, true, channelPromise2));
                    return channelPromise;
                }
                ChannelPromise unvoid = channelPromise.unvoid();
                boolean validateHeadersSentState = validateHeadersSentState(http2Stream, http2Headers, this.connection.isServer(), z6);
                ChannelFuture writeHeaders = this.frameWriter.writeHeaders(channelHandlerContext, i6, http2Headers, i7, s5, z5, i8, z6, unvoid);
                Throwable cause = writeHeaders.cause();
                if (cause == null) {
                    http2Stream.headersSent(validateHeadersSentState);
                    if (!writeHeaders.isSuccess()) {
                        notifyLifecycleManagerOnError(writeHeaders, channelHandlerContext);
                    }
                } else {
                    this.lifecycleManager.onError(channelHandlerContext, true, cause);
                }
                if (z6) {
                    this.lifecycleManager.closeStreamLocal(http2Stream, writeHeaders);
                }
                return writeHeaders;
            } catch (Throwable th2) {
                th = th2;
                this.lifecycleManager.onError(channelHandlerContext, true, th);
                channelPromise2.tryFailure(th);
                return channelPromise2;
            }
        } catch (Throwable th3) {
            th = th3;
            channelPromise2 = channelPromise;
        }
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writePing(ChannelHandlerContext channelHandlerContext, boolean z5, long j6, ChannelPromise channelPromise) {
        return this.frameWriter.writePing(channelHandlerContext, z5, j6, channelPromise);
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writePriority(ChannelHandlerContext channelHandlerContext, int i6, int i7, short s5, boolean z5, ChannelPromise channelPromise) {
        return this.frameWriter.writePriority(channelHandlerContext, i6, i7, s5, z5, channelPromise);
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeRstStream(ChannelHandlerContext channelHandlerContext, int i6, long j6, ChannelPromise channelPromise) {
        return this.lifecycleManager.resetStream(channelHandlerContext, i6, j6, channelPromise);
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeSettings(ChannelHandlerContext channelHandlerContext, Http2Settings http2Settings, ChannelPromise channelPromise) {
        this.outstandingLocalSettingsQueue.add(http2Settings);
        try {
            if (http2Settings.pushEnabled() != null && this.connection.isServer()) {
                throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Server sending SETTINGS frame with ENABLE_PUSH specified", new Object[0]);
            }
            return this.frameWriter.writeSettings(channelHandlerContext, http2Settings, channelPromise);
        } catch (Throwable th) {
            return channelPromise.setFailure(th);
        }
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeSettingsAck(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) {
        Queue<Http2Settings> queue = this.outstandingRemoteSettingsQueue;
        if (queue == null) {
            return this.frameWriter.writeSettingsAck(channelHandlerContext, channelPromise);
        }
        Http2Settings poll = queue.poll();
        if (poll == null) {
            return channelPromise.setFailure((Throwable) new Http2Exception(Http2Error.INTERNAL_ERROR, "attempted to write a SETTINGS ACK with no  pending SETTINGS"));
        }
        Http2CodecUtil.SimpleChannelPromiseAggregator simpleChannelPromiseAggregator = new Http2CodecUtil.SimpleChannelPromiseAggregator(channelPromise, channelHandlerContext.channel(), channelHandlerContext.executor());
        this.frameWriter.writeSettingsAck(channelHandlerContext, simpleChannelPromiseAggregator.newPromise());
        ChannelPromise newPromise = simpleChannelPromiseAggregator.newPromise();
        try {
            remoteSettings(poll);
            newPromise.setSuccess();
        } catch (Throwable th) {
            newPromise.setFailure(th);
            this.lifecycleManager.onError(channelHandlerContext, true, th);
        }
        return simpleChannelPromiseAggregator.doneAllocatingPromises();
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeWindowUpdate(ChannelHandlerContext channelHandlerContext, int i6, int i7, ChannelPromise channelPromise) {
        return channelPromise.setFailure((Throwable) new UnsupportedOperationException("Use the Http2[Inbound|Outbound]FlowController objects to control window sizes"));
    }

    public DefaultHttp2ConnectionEncoder(Http2Connection http2Connection, Http2FrameWriter http2FrameWriter) {
        this.connection = (Http2Connection) ObjectUtil.checkNotNull(http2Connection, "connection");
        this.frameWriter = (Http2FrameWriter) ObjectUtil.checkNotNull(http2FrameWriter, "frameWriter");
        if (http2Connection.remote().flowController() == null) {
            http2Connection.remote().flowController(new DefaultHttp2RemoteFlowController(http2Connection));
        }
    }

    @Override // io.netty.handler.codec.http2.Http2ConnectionEncoder
    public final Http2RemoteFlowController flowController() {
        return connection().remote().flowController();
    }

    @Override // io.netty.handler.codec.http2.Http2ConnectionEncoder
    public void remoteSettings(Http2Settings http2Settings) throws Http2Exception {
        Boolean pushEnabled = http2Settings.pushEnabled();
        Http2FrameWriter.Configuration configuration = configuration();
        Http2HeadersEncoder.Configuration headersConfiguration = configuration.headersConfiguration();
        Http2FrameSizePolicy frameSizePolicy = configuration.frameSizePolicy();
        if (pushEnabled != null) {
            if (!this.connection.isServer() && pushEnabled.booleanValue()) {
                throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Client received a value of ENABLE_PUSH specified to other than 0", new Object[0]);
            }
            this.connection.remote().allowPushTo(pushEnabled.booleanValue());
        }
        Long maxConcurrentStreams = http2Settings.maxConcurrentStreams();
        if (maxConcurrentStreams != null) {
            this.connection.local().maxActiveStreams((int) Math.min(maxConcurrentStreams.longValue(), 2147483647L));
        }
        if (http2Settings.headerTableSize() != null) {
            headersConfiguration.maxHeaderTableSize((int) Math.min(r0.longValue(), 2147483647L));
        }
        Long maxHeaderListSize = http2Settings.maxHeaderListSize();
        if (maxHeaderListSize != null) {
            headersConfiguration.maxHeaderListSize(maxHeaderListSize.longValue());
        }
        Integer maxFrameSize = http2Settings.maxFrameSize();
        if (maxFrameSize != null) {
            frameSizePolicy.maxFrameSize(maxFrameSize.intValue());
        }
        Integer initialWindowSize = http2Settings.initialWindowSize();
        if (initialWindowSize != null) {
            flowController().initialWindowSize(initialWindowSize.intValue());
        }
    }

    @Override // io.netty.handler.codec.http2.Http2DataWriter
    public ChannelFuture writeData(ChannelHandlerContext channelHandlerContext, int i6, ByteBuf byteBuf, int i7, boolean z5, ChannelPromise channelPromise) {
        ByteBuf byteBuf2;
        ChannelPromise channelPromise2;
        Throwable th;
        try {
            Http2Stream requireStream = requireStream(i6);
            int i8 = AnonymousClass2.$SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[requireStream.state().ordinal()];
            if (i8 != 1 && i8 != 2) {
                try {
                    throw new IllegalStateException("Stream " + requireStream.id() + " in unexpected state " + requireStream.state());
                } catch (Throwable th2) {
                    th = th2;
                    byteBuf2 = byteBuf;
                    channelPromise2 = channelPromise;
                    byteBuf2.release();
                    return channelPromise2.setFailure(th);
                }
            }
            flowController().addFlowControlled(requireStream, new FlowControlledData(requireStream, byteBuf, i7, z5, channelPromise));
            return channelPromise;
        } catch (Throwable th3) {
            byteBuf2 = byteBuf;
            channelPromise2 = channelPromise;
            th = th3;
        }
    }
}
