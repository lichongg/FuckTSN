package io.netty.handler.codec.http2;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http2.Http2Connection;
import io.netty.handler.codec.http2.Http2RemoteFlowController;
import io.netty.handler.codec.http2.Http2Stream;
import io.netty.handler.codec.http2.StreamByteDistributor;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.ArrayDeque;
import java.util.Deque;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class DefaultHttp2RemoteFlowController implements Http2RemoteFlowController {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int MIN_WRITABLE_CHUNK = 32768;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) DefaultHttp2RemoteFlowController.class);
    private final Http2Connection connection;
    private final FlowState connectionState;
    private ChannelHandlerContext ctx;
    private int initialWindowSize;
    private WritabilityMonitor monitor;
    private final Http2Connection.PropertyKey stateKey;
    private final StreamByteDistributor streamByteDistributor;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class FlowState implements StreamByteDistributor.StreamState {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private boolean cancelled;
        private boolean markedWritable;
        private long pendingBytes;
        private final Deque<Http2RemoteFlowController.FlowControlled> pendingWriteQueue = new ArrayDeque(2);
        private final Http2Stream stream;
        private int window;
        private boolean writing;

        private void decrementFlowControlWindow(int i6) {
            int i7 = -i6;
            try {
                DefaultHttp2RemoteFlowController.this.connectionState.incrementStreamWindow(i7);
                incrementStreamWindow(i7);
            } catch (Http2Exception e6) {
                throw new IllegalStateException("Invalid window state when writing frame: " + e6.getMessage(), e6);
            }
        }

        private void decrementPendingBytes(int i6, boolean z5) {
            incrementPendingBytes(-i6, z5);
        }

        void cancel(Http2Error http2Error, Throwable th) {
            this.cancelled = true;
            if (this.writing) {
                return;
            }
            Http2RemoteFlowController.FlowControlled poll = this.pendingWriteQueue.poll();
            if (poll != null) {
                Http2Exception streamError = Http2Exception.streamError(this.stream.id(), http2Error, th, "Stream closed before write could take place", new Object[0]);
                do {
                    writeError(poll, streamError);
                    poll = this.pendingWriteQueue.poll();
                } while (poll != null);
            }
            DefaultHttp2RemoteFlowController.this.streamByteDistributor.updateStreamableBytes(this);
            DefaultHttp2RemoteFlowController.this.monitor.stateCancelled(this);
        }

        boolean markedWritability() {
            return this.markedWritable;
        }

        @Override // io.netty.handler.codec.http2.StreamByteDistributor.StreamState
        public int windowSize() {
            return this.window;
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:0x0057, code lost:
        
            r8.writing = false;
            r9 = r9 - r3;
            decrementPendingBytes(r9, false);
            decrementFlowControlWindow(r9);
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x0063, code lost:
        
            if (r8.cancelled == false) goto L30;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x0065, code lost:
        
            cancel(io.netty.handler.codec.http2.Http2Error.INTERNAL_ERROR, null);
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x006a, code lost:
        
            return -1;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        int writeAllocatedBytes(int r9) {
            /*
                r8 = this;
                r0 = 1
                r1 = 0
                r2 = 0
                r8.writing = r0     // Catch: java.lang.Throwable -> L7e
                r3 = r9
                r4 = 0
            L7:
                boolean r5 = r8.cancelled     // Catch: java.lang.Throwable -> L22
                if (r5 != 0) goto L55
                io.netty.handler.codec.http2.Http2RemoteFlowController$FlowControlled r5 = r8.peek()     // Catch: java.lang.Throwable -> L22
                if (r5 == 0) goto L55
                int r6 = r8.writableWindow()     // Catch: java.lang.Throwable -> L22
                int r6 = java.lang.Math.min(r3, r6)     // Catch: java.lang.Throwable -> L22
                if (r6 > 0) goto L24
                int r7 = r5.size()     // Catch: java.lang.Throwable -> L22
                if (r7 <= 0) goto L24
                goto L55
            L22:
                r4 = move-exception
                goto L80
            L24:
                int r4 = r5.size()     // Catch: java.lang.Throwable -> L22
                io.netty.handler.codec.http2.DefaultHttp2RemoteFlowController r7 = io.netty.handler.codec.http2.DefaultHttp2RemoteFlowController.this     // Catch: java.lang.Throwable -> L44
                io.netty.channel.ChannelHandlerContext r7 = io.netty.handler.codec.http2.DefaultHttp2RemoteFlowController.access$500(r7)     // Catch: java.lang.Throwable -> L44
                int r6 = java.lang.Math.max(r1, r6)     // Catch: java.lang.Throwable -> L44
                r5.write(r7, r6)     // Catch: java.lang.Throwable -> L44
                int r6 = r5.size()     // Catch: java.lang.Throwable -> L44
                if (r6 != 0) goto L46
                java.util.Deque<io.netty.handler.codec.http2.Http2RemoteFlowController$FlowControlled> r6 = r8.pendingWriteQueue     // Catch: java.lang.Throwable -> L44
                r6.remove()     // Catch: java.lang.Throwable -> L44
                r5.writeComplete()     // Catch: java.lang.Throwable -> L44
                goto L46
            L44:
                r6 = move-exception
                goto L4e
            L46:
                int r5 = r5.size()     // Catch: java.lang.Throwable -> L22
                int r4 = r4 - r5
                int r3 = r3 - r4
                r4 = 1
                goto L7
            L4e:
                int r5 = r5.size()     // Catch: java.lang.Throwable -> L22
                int r4 = r4 - r5
                int r3 = r3 - r4
                throw r6     // Catch: java.lang.Throwable -> L22
            L55:
                if (r4 != 0) goto L6b
                r8.writing = r1
                int r9 = r9 - r3
                r8.decrementPendingBytes(r9, r1)
                r8.decrementFlowControlWindow(r9)
                boolean r9 = r8.cancelled
                r0 = -1
                if (r9 == 0) goto L6a
                io.netty.handler.codec.http2.Http2Error r9 = io.netty.handler.codec.http2.Http2Error.INTERNAL_ERROR
                r8.cancel(r9, r2)
            L6a:
                return r0
            L6b:
                r8.writing = r1
                int r9 = r9 - r3
                r8.decrementPendingBytes(r9, r1)
                r8.decrementFlowControlWindow(r9)
                boolean r0 = r8.cancelled
                if (r0 == 0) goto L7d
                io.netty.handler.codec.http2.Http2Error r0 = io.netty.handler.codec.http2.Http2Error.INTERNAL_ERROR
                r8.cancel(r0, r2)
            L7d:
                return r9
            L7e:
                r4 = move-exception
                r3 = r9
            L80:
                r8.cancelled = r0     // Catch: java.lang.Throwable -> L95
                r8.writing = r1
                int r9 = r9 - r3
                r8.decrementPendingBytes(r9, r1)
                r8.decrementFlowControlWindow(r9)
                boolean r0 = r8.cancelled
                if (r0 == 0) goto L94
                io.netty.handler.codec.http2.Http2Error r0 = io.netty.handler.codec.http2.Http2Error.INTERNAL_ERROR
                r8.cancel(r0, r4)
            L94:
                return r9
            L95:
                r0 = move-exception
                r8.writing = r1
                int r9 = r9 - r3
                r8.decrementPendingBytes(r9, r1)
                r8.decrementFlowControlWindow(r9)
                boolean r9 = r8.cancelled
                if (r9 == 0) goto La8
                io.netty.handler.codec.http2.Http2Error r9 = io.netty.handler.codec.http2.Http2Error.INTERNAL_ERROR
                r8.cancel(r9, r2)
            La8:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.http2.DefaultHttp2RemoteFlowController.FlowState.writeAllocatedBytes(int):int");
        }

        FlowState(Http2Stream http2Stream) {
            this.stream = http2Stream;
        }

        private void enqueueFrameWithoutMerge(Http2RemoteFlowController.FlowControlled flowControlled) {
            this.pendingWriteQueue.offer(flowControlled);
            incrementPendingBytes(flowControlled.size(), true);
        }

        private void incrementPendingBytes(int i6, boolean z5) {
            this.pendingBytes += i6;
            DefaultHttp2RemoteFlowController.this.monitor.incrementPendingBytes(i6);
            if (z5) {
                DefaultHttp2RemoteFlowController.this.streamByteDistributor.updateStreamableBytes(this);
            }
        }

        private Http2RemoteFlowController.FlowControlled peek() {
            return this.pendingWriteQueue.peek();
        }

        private int writableWindow() {
            return Math.min(this.window, DefaultHttp2RemoteFlowController.this.connectionWindowSize());
        }

        void enqueueFrame(Http2RemoteFlowController.FlowControlled flowControlled) {
            Http2RemoteFlowController.FlowControlled peekLast = this.pendingWriteQueue.peekLast();
            if (peekLast == null) {
                enqueueFrameWithoutMerge(flowControlled);
                return;
            }
            int size = peekLast.size();
            if (peekLast.merge(DefaultHttp2RemoteFlowController.this.ctx, flowControlled)) {
                incrementPendingBytes(peekLast.size() - size, true);
            } else {
                enqueueFrameWithoutMerge(flowControlled);
            }
        }

        @Override // io.netty.handler.codec.http2.StreamByteDistributor.StreamState
        public boolean hasFrame() {
            return !this.pendingWriteQueue.isEmpty();
        }

        int incrementStreamWindow(int i6) throws Http2Exception {
            if (i6 > 0 && Integer.MAX_VALUE - i6 < this.window) {
                throw Http2Exception.streamError(this.stream.id(), Http2Error.FLOW_CONTROL_ERROR, "Window size overflow for stream: %d", Integer.valueOf(this.stream.id()));
            }
            this.window += i6;
            DefaultHttp2RemoteFlowController.this.streamByteDistributor.updateStreamableBytes(this);
            return this.window;
        }

        void markedWritability(boolean z5) {
            this.markedWritable = z5;
        }

        @Override // io.netty.handler.codec.http2.StreamByteDistributor.StreamState
        public long pendingBytes() {
            return this.pendingBytes;
        }

        @Override // io.netty.handler.codec.http2.StreamByteDistributor.StreamState
        public Http2Stream stream() {
            return this.stream;
        }

        void windowSize(int i6) {
            this.window = i6;
        }

        private void writeError(Http2RemoteFlowController.FlowControlled flowControlled, Http2Exception http2Exception) {
            decrementPendingBytes(flowControlled.size(), true);
            flowControlled.error(DefaultHttp2RemoteFlowController.this.ctx, http2Exception);
        }

        boolean isWritable() {
            if (windowSize() > pendingBytes() && !this.cancelled) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class ListenerWritabilityMonitor extends WritabilityMonitor implements Http2StreamVisitor {
        private final Http2RemoteFlowController.Listener listener;

        ListenerWritabilityMonitor(Http2RemoteFlowController.Listener listener) {
            super();
            this.listener = listener;
        }

        private void checkAllWritabilityChanged() throws Http2Exception {
            DefaultHttp2RemoteFlowController.this.connectionState.markedWritability(isWritableConnection());
            DefaultHttp2RemoteFlowController.this.connection.forEachActiveStream(this);
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2RemoteFlowController.WritabilityMonitor
        void channelWritabilityChange() throws Http2Exception {
            if (DefaultHttp2RemoteFlowController.this.connectionState.markedWritability() != DefaultHttp2RemoteFlowController.this.isChannelWritable()) {
                checkAllWritabilityChanged();
            }
        }

        @Override // io.netty.handler.codec.http2.Http2StreamVisitor
        public boolean visit(Http2Stream http2Stream) throws Http2Exception {
            FlowState state = DefaultHttp2RemoteFlowController.this.state(http2Stream);
            if (isWritable(state) == state.markedWritability()) {
                return true;
            }
            notifyWritabilityChanged(state);
            return true;
        }

        private void checkConnectionThenStreamWritabilityChanged(FlowState flowState) throws Http2Exception {
            if (isWritableConnection() != DefaultHttp2RemoteFlowController.this.connectionState.markedWritability()) {
                checkAllWritabilityChanged();
            } else if (isWritable(flowState) != flowState.markedWritability()) {
                notifyWritabilityChanged(flowState);
            }
        }

        private void checkStateWritability(FlowState flowState) throws Http2Exception {
            if (isWritable(flowState) != flowState.markedWritability()) {
                if (flowState == DefaultHttp2RemoteFlowController.this.connectionState) {
                    checkAllWritabilityChanged();
                } else {
                    notifyWritabilityChanged(flowState);
                }
            }
        }

        private void notifyWritabilityChanged(FlowState flowState) {
            flowState.markedWritability(!flowState.markedWritability());
            try {
                this.listener.writabilityChanged(flowState.stream);
            } catch (Throwable th) {
                DefaultHttp2RemoteFlowController.logger.error("Caught Throwable from listener.writabilityChanged", th);
            }
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2RemoteFlowController.WritabilityMonitor
        void enqueueFrame(FlowState flowState, Http2RemoteFlowController.FlowControlled flowControlled) throws Http2Exception {
            super.enqueueFrame(flowState, flowControlled);
            checkConnectionThenStreamWritabilityChanged(flowState);
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2RemoteFlowController.WritabilityMonitor
        void incrementWindowSize(FlowState flowState, int i6) throws Http2Exception {
            super.incrementWindowSize(flowState, i6);
            checkStateWritability(flowState);
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2RemoteFlowController.WritabilityMonitor
        void initialWindowSize(int i6) throws Http2Exception {
            super.initialWindowSize(i6);
            if (isWritableConnection()) {
                checkAllWritabilityChanged();
            }
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2RemoteFlowController.WritabilityMonitor
        void stateCancelled(FlowState flowState) {
            try {
                checkConnectionThenStreamWritabilityChanged(flowState);
            } catch (Http2Exception e6) {
                throw new RuntimeException("Caught unexpected exception from checkAllWritabilityChanged", e6);
            }
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2RemoteFlowController.WritabilityMonitor
        void windowSize(FlowState flowState, int i6) {
            super.windowSize(flowState, i6);
            try {
                checkStateWritability(flowState);
            } catch (Http2Exception e6) {
                throw new RuntimeException("Caught unexpected exception from window", e6);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class WritabilityMonitor implements StreamByteDistributor.Writer {
        private boolean inWritePendingBytes;
        private long totalPendingBytes;

        private WritabilityMonitor() {
        }

        final void incrementPendingBytes(int i6) {
            this.totalPendingBytes += i6;
        }

        void initialWindowSize(int i6) throws Http2Exception {
            ObjectUtil.checkPositiveOrZero(i6, "newWindowSize");
            final int i7 = i6 - DefaultHttp2RemoteFlowController.this.initialWindowSize;
            DefaultHttp2RemoteFlowController.this.initialWindowSize = i6;
            DefaultHttp2RemoteFlowController.this.connection.forEachActiveStream(new Http2StreamVisitor() { // from class: io.netty.handler.codec.http2.DefaultHttp2RemoteFlowController.WritabilityMonitor.1
                @Override // io.netty.handler.codec.http2.Http2StreamVisitor
                public boolean visit(Http2Stream http2Stream) throws Http2Exception {
                    DefaultHttp2RemoteFlowController.this.state(http2Stream).incrementStreamWindow(i7);
                    return true;
                }
            });
            if (i7 <= 0 || !DefaultHttp2RemoteFlowController.this.isChannelWritable()) {
                return;
            }
            writePendingBytes();
        }

        final boolean isWritableConnection() {
            return ((long) DefaultHttp2RemoteFlowController.this.connectionState.windowSize()) - this.totalPendingBytes > 0 && DefaultHttp2RemoteFlowController.this.isChannelWritable();
        }

        @Override // io.netty.handler.codec.http2.StreamByteDistributor.Writer
        public final void write(Http2Stream http2Stream, int i6) {
            DefaultHttp2RemoteFlowController.this.state(http2Stream).writeAllocatedBytes(i6);
        }

        final void writePendingBytes() throws Http2Exception {
            if (this.inWritePendingBytes) {
                return;
            }
            this.inWritePendingBytes = true;
            try {
                int writableBytes = DefaultHttp2RemoteFlowController.this.writableBytes();
                while (DefaultHttp2RemoteFlowController.this.streamByteDistributor.distribute(writableBytes, this) && (writableBytes = DefaultHttp2RemoteFlowController.this.writableBytes()) > 0 && DefaultHttp2RemoteFlowController.this.isChannelWritable0()) {
                }
            } finally {
                this.inWritePendingBytes = false;
            }
        }

        void enqueueFrame(FlowState flowState, Http2RemoteFlowController.FlowControlled flowControlled) throws Http2Exception {
            flowState.enqueueFrame(flowControlled);
        }

        void incrementWindowSize(FlowState flowState, int i6) throws Http2Exception {
            flowState.incrementStreamWindow(i6);
        }

        final boolean isWritable(FlowState flowState) {
            if (isWritableConnection() && flowState.isWritable()) {
                return true;
            }
            return false;
        }

        void windowSize(FlowState flowState, int i6) {
            flowState.windowSize(i6);
        }

        void channelWritabilityChange() throws Http2Exception {
        }

        void stateCancelled(FlowState flowState) {
        }
    }

    public DefaultHttp2RemoteFlowController(Http2Connection http2Connection) {
        this(http2Connection, (Http2RemoteFlowController.Listener) null);
    }

    @Override // io.netty.handler.codec.http2.Http2FlowController
    public void channelHandlerContext(ChannelHandlerContext channelHandlerContext) throws Http2Exception {
        this.ctx = (ChannelHandlerContext) ObjectUtil.checkNotNull(channelHandlerContext, "ctx");
        channelWritabilityChanged();
        if (isChannelWritable()) {
            writePendingBytes();
        }
    }

    @Override // io.netty.handler.codec.http2.Http2FlowController
    public void initialWindowSize(int i6) throws Http2Exception {
        this.monitor.initialWindowSize(i6);
    }

    public DefaultHttp2RemoteFlowController(Http2Connection http2Connection, StreamByteDistributor streamByteDistributor) {
        this(http2Connection, streamByteDistributor, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int connectionWindowSize() {
        return this.connectionState.windowSize();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isChannelWritable() {
        return this.ctx != null && isChannelWritable0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isChannelWritable0() {
        return this.ctx.channel().isWritable();
    }

    private int maxUsableChannelBytes() {
        int min = (int) Math.min(2147483647L, this.ctx.channel().bytesBeforeUnwritable());
        return Math.min(this.connectionState.windowSize(), min > 0 ? Math.max(min, minUsableChannelBytes()) : 0);
    }

    private int minUsableChannelBytes() {
        return Math.max(this.ctx.channel().config().getWriteBufferLowWaterMark(), 32768);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FlowState state(Http2Stream http2Stream) {
        return (FlowState) http2Stream.getProperty(this.stateKey);
    }

    @Override // io.netty.handler.codec.http2.Http2RemoteFlowController
    public void addFlowControlled(Http2Stream http2Stream, Http2RemoteFlowController.FlowControlled flowControlled) {
        ObjectUtil.checkNotNull(flowControlled, "frame");
        try {
            this.monitor.enqueueFrame(state(http2Stream), flowControlled);
        } catch (Throwable th) {
            flowControlled.error(this.ctx, th);
        }
    }

    @Override // io.netty.handler.codec.http2.Http2RemoteFlowController
    public void channelWritabilityChanged() throws Http2Exception {
        this.monitor.channelWritabilityChange();
    }

    @Override // io.netty.handler.codec.http2.Http2FlowController
    public void incrementWindowSize(Http2Stream http2Stream, int i6) throws Http2Exception {
        this.monitor.incrementWindowSize(state(http2Stream), i6);
    }

    @Override // io.netty.handler.codec.http2.Http2FlowController
    public int initialWindowSize() {
        return this.initialWindowSize;
    }

    @Override // io.netty.handler.codec.http2.Http2RemoteFlowController
    public boolean isWritable(Http2Stream http2Stream) {
        return this.monitor.isWritable(state(http2Stream));
    }

    @Override // io.netty.handler.codec.http2.Http2RemoteFlowController
    public void listener(Http2RemoteFlowController.Listener listener) {
        this.monitor = listener == null ? new WritabilityMonitor() : new ListenerWritabilityMonitor(listener);
    }

    @Override // io.netty.handler.codec.http2.Http2RemoteFlowController
    public void updateDependencyTree(int i6, int i7, short s5, boolean z5) {
        this.streamByteDistributor.updateDependencyTree(i6, i7, s5, z5);
    }

    @Override // io.netty.handler.codec.http2.Http2RemoteFlowController
    public void writePendingBytes() throws Http2Exception {
        this.monitor.writePendingBytes();
    }

    public DefaultHttp2RemoteFlowController(Http2Connection http2Connection, Http2RemoteFlowController.Listener listener) {
        this(http2Connection, new WeightedFairQueueByteDistributor(http2Connection), listener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int writableBytes() {
        return Math.min(connectionWindowSize(), maxUsableChannelBytes());
    }

    @Override // io.netty.handler.codec.http2.Http2RemoteFlowController
    public boolean hasFlowControlled(Http2Stream http2Stream) {
        return state(http2Stream).hasFrame();
    }

    @Override // io.netty.handler.codec.http2.Http2FlowController
    public int windowSize(Http2Stream http2Stream) {
        return state(http2Stream).windowSize();
    }

    public DefaultHttp2RemoteFlowController(Http2Connection http2Connection, StreamByteDistributor streamByteDistributor, Http2RemoteFlowController.Listener listener) {
        this.initialWindowSize = 65535;
        this.connection = (Http2Connection) ObjectUtil.checkNotNull(http2Connection, "connection");
        this.streamByteDistributor = (StreamByteDistributor) ObjectUtil.checkNotNull(streamByteDistributor, "streamWriteDistributor");
        Http2Connection.PropertyKey newKey = http2Connection.newKey();
        this.stateKey = newKey;
        FlowState flowState = new FlowState(http2Connection.connectionStream());
        this.connectionState = flowState;
        http2Connection.connectionStream().setProperty(newKey, flowState);
        listener(listener);
        this.monitor.windowSize(flowState, this.initialWindowSize);
        http2Connection.addListener(new Http2ConnectionAdapter() { // from class: io.netty.handler.codec.http2.DefaultHttp2RemoteFlowController.1
            @Override // io.netty.handler.codec.http2.Http2ConnectionAdapter, io.netty.handler.codec.http2.Http2Connection.Listener
            public void onStreamActive(Http2Stream http2Stream) {
                DefaultHttp2RemoteFlowController.this.monitor.windowSize(DefaultHttp2RemoteFlowController.this.state(http2Stream), DefaultHttp2RemoteFlowController.this.initialWindowSize);
            }

            @Override // io.netty.handler.codec.http2.Http2ConnectionAdapter, io.netty.handler.codec.http2.Http2Connection.Listener
            public void onStreamAdded(Http2Stream http2Stream) {
                http2Stream.setProperty(DefaultHttp2RemoteFlowController.this.stateKey, DefaultHttp2RemoteFlowController.this.new FlowState(http2Stream));
            }

            @Override // io.netty.handler.codec.http2.Http2ConnectionAdapter, io.netty.handler.codec.http2.Http2Connection.Listener
            public void onStreamClosed(Http2Stream http2Stream) {
                DefaultHttp2RemoteFlowController.this.state(http2Stream).cancel(Http2Error.STREAM_CLOSED, null);
            }

            @Override // io.netty.handler.codec.http2.Http2ConnectionAdapter, io.netty.handler.codec.http2.Http2Connection.Listener
            public void onStreamHalfClosed(Http2Stream http2Stream) {
                if (Http2Stream.State.HALF_CLOSED_LOCAL == http2Stream.state()) {
                    DefaultHttp2RemoteFlowController.this.state(http2Stream).cancel(Http2Error.STREAM_CLOSED, null);
                }
            }
        });
    }

    @Override // io.netty.handler.codec.http2.Http2RemoteFlowController
    public ChannelHandlerContext channelHandlerContext() {
        return this.ctx;
    }
}
