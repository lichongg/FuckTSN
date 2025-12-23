package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http2.Http2Connection;
import io.netty.handler.codec.http2.Http2Exception;
import io.netty.handler.codec.http2.Http2Stream;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class DefaultHttp2LocalFlowController implements Http2LocalFlowController {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final float DEFAULT_WINDOW_UPDATE_RATIO = 0.5f;
    private static final FlowState REDUCED_FLOW_STATE = new FlowState() { // from class: io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.2
        @Override // io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.FlowState
        public boolean consumeBytes(int i6) throws Http2Exception {
            return false;
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.FlowState
        public int initialWindowSize() {
            return 0;
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.FlowState
        public int unconsumedBytes() {
            return 0;
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.FlowState
        public int windowSize() {
            return 0;
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.FlowState
        public float windowUpdateRatio() {
            throw new UnsupportedOperationException();
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.FlowState
        public void endOfStream(boolean z5) {
            throw new UnsupportedOperationException();
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.FlowState
        public void receiveFlowControlledFrame(int i6) throws Http2Exception {
            throw new UnsupportedOperationException();
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.FlowState
        public void window(int i6) {
            throw new UnsupportedOperationException();
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.FlowState
        public void windowUpdateRatio(float f6) {
            throw new UnsupportedOperationException();
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.FlowState
        public boolean writeWindowUpdateIfNeeded() throws Http2Exception {
            throw new UnsupportedOperationException();
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.FlowState
        public void incrementFlowControlWindows(int i6) throws Http2Exception {
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.FlowState
        public void incrementInitialStreamWindow(int i6) {
        }
    };
    private final Http2Connection connection;
    private ChannelHandlerContext ctx;
    private Http2FrameWriter frameWriter;
    private int initialWindowSize;
    private final Http2Connection.PropertyKey stateKey;
    private float windowUpdateRatio;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class AutoRefillState extends DefaultState {
        @Override // io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.DefaultState, io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.FlowState
        public boolean consumeBytes(int i6) throws Http2Exception {
            return false;
        }

        AutoRefillState(Http2Stream http2Stream, int i6) {
            super(http2Stream, i6);
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.DefaultState, io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.FlowState
        public void receiveFlowControlledFrame(int i6) throws Http2Exception {
            super.receiveFlowControlledFrame(i6);
            super.consumeBytes(i6);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class DefaultState implements FlowState {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private boolean endOfStream;
        private int initialStreamWindowSize;
        private int lowerBound;
        private int processedWindow;
        private final Http2Stream stream;
        private float streamWindowUpdateRatio;
        private int window;

        @Override // io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.FlowState
        public void incrementFlowControlWindows(int i6) throws Http2Exception {
            if (i6 > 0 && this.window > Integer.MAX_VALUE - i6) {
                throw Http2Exception.streamError(this.stream.id(), Http2Error.FLOW_CONTROL_ERROR, "Flow control window overflowed for stream: %d", Integer.valueOf(this.stream.id()));
            }
            this.window += i6;
            this.processedWindow += i6;
            if (i6 >= 0) {
                i6 = 0;
            }
            this.lowerBound = i6;
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.FlowState
        public float windowUpdateRatio() {
            return this.streamWindowUpdateRatio;
        }

        DefaultState(Http2Stream http2Stream, int i6) {
            this.stream = http2Stream;
            window(i6);
            this.streamWindowUpdateRatio = DefaultHttp2LocalFlowController.this.windowUpdateRatio;
        }

        private void returnProcessedBytes(int i6) throws Http2Exception {
            int i7 = this.processedWindow;
            if (i7 - i6 < this.window) {
                throw Http2Exception.streamError(this.stream.id(), Http2Error.INTERNAL_ERROR, "Attempting to return too many bytes for stream %d", Integer.valueOf(this.stream.id()));
            }
            this.processedWindow = i7 - i6;
        }

        private void writeWindowUpdate() throws Http2Exception {
            int i6 = this.initialStreamWindowSize - this.processedWindow;
            try {
                incrementFlowControlWindows(i6);
                DefaultHttp2LocalFlowController.this.frameWriter.writeWindowUpdate(DefaultHttp2LocalFlowController.this.ctx, this.stream.id(), i6, DefaultHttp2LocalFlowController.this.ctx.newPromise());
            } catch (Throwable th) {
                throw Http2Exception.connectionError(Http2Error.INTERNAL_ERROR, th, "Attempting to return too many bytes for stream %d", Integer.valueOf(this.stream.id()));
            }
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.FlowState
        public void endOfStream(boolean z5) {
            this.endOfStream = z5;
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.FlowState
        public void incrementInitialStreamWindow(int i6) {
            int min = (int) Math.min(2147483647L, Math.max(0L, this.initialStreamWindowSize + i6));
            int i7 = this.initialStreamWindowSize;
            this.initialStreamWindowSize = i7 + (min - i7);
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.FlowState
        public int initialWindowSize() {
            return this.initialStreamWindowSize;
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.FlowState
        public void receiveFlowControlledFrame(int i6) throws Http2Exception {
            int i7 = this.window - i6;
            this.window = i7;
            if (i7 < this.lowerBound) {
                throw Http2Exception.streamError(this.stream.id(), Http2Error.FLOW_CONTROL_ERROR, "Flow control window exceeded for stream: %d", Integer.valueOf(this.stream.id()));
            }
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.FlowState
        public int unconsumedBytes() {
            return this.processedWindow - this.window;
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.FlowState
        public void window(int i6) {
            this.initialStreamWindowSize = i6;
            this.processedWindow = i6;
            this.window = i6;
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.FlowState
        public int windowSize() {
            return this.window;
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.FlowState
        public void windowUpdateRatio(float f6) {
            this.streamWindowUpdateRatio = f6;
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.FlowState
        public boolean writeWindowUpdateIfNeeded() throws Http2Exception {
            int i6;
            if (!this.endOfStream && (i6 = this.initialStreamWindowSize) > 0) {
                if (this.processedWindow <= ((int) (i6 * this.streamWindowUpdateRatio))) {
                    writeWindowUpdate();
                    return true;
                }
            }
            return false;
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.FlowState
        public boolean consumeBytes(int i6) throws Http2Exception {
            returnProcessedBytes(i6);
            return writeWindowUpdateIfNeeded();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private interface FlowState {
        boolean consumeBytes(int i6) throws Http2Exception;

        void endOfStream(boolean z5);

        void incrementFlowControlWindows(int i6) throws Http2Exception;

        void incrementInitialStreamWindow(int i6);

        int initialWindowSize();

        void receiveFlowControlledFrame(int i6) throws Http2Exception;

        int unconsumedBytes();

        void window(int i6);

        int windowSize();

        float windowUpdateRatio();

        void windowUpdateRatio(float f6);

        boolean writeWindowUpdateIfNeeded() throws Http2Exception;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class WindowUpdateVisitor implements Http2StreamVisitor {
        private Http2Exception.CompositeStreamException compositeException;
        private final int delta;

        WindowUpdateVisitor(int i6) {
            this.delta = i6;
        }

        public void throwIfError() throws Http2Exception.CompositeStreamException {
            Http2Exception.CompositeStreamException compositeStreamException = this.compositeException;
            if (compositeStreamException != null) {
                throw compositeStreamException;
            }
        }

        @Override // io.netty.handler.codec.http2.Http2StreamVisitor
        public boolean visit(Http2Stream http2Stream) throws Http2Exception {
            try {
                FlowState state = DefaultHttp2LocalFlowController.this.state(http2Stream);
                state.incrementFlowControlWindows(this.delta);
                state.incrementInitialStreamWindow(this.delta);
                return true;
            } catch (Http2Exception.StreamException e6) {
                if (this.compositeException == null) {
                    this.compositeException = new Http2Exception.CompositeStreamException(e6.error(), 4);
                }
                this.compositeException.add(e6);
                return true;
            }
        }
    }

    public DefaultHttp2LocalFlowController(Http2Connection http2Connection) {
        this(http2Connection, 0.5f, false);
    }

    private static void checkValidRatio(float f6) {
        double d6 = f6;
        if (Double.compare(d6, 0.0d) <= 0 || Double.compare(d6, 1.0d) >= 0) {
            throw new IllegalArgumentException("Invalid ratio: " + f6);
        }
    }

    @Override // io.netty.handler.codec.http2.Http2FlowController
    public void initialWindowSize(int i6) throws Http2Exception {
        int i7 = i6 - this.initialWindowSize;
        this.initialWindowSize = i6;
        WindowUpdateVisitor windowUpdateVisitor = new WindowUpdateVisitor(i7);
        this.connection.forEachActiveStream(windowUpdateVisitor);
        windowUpdateVisitor.throwIfError();
    }

    public void windowUpdateRatio(float f6) {
        checkValidRatio(f6);
        this.windowUpdateRatio = f6;
    }

    public DefaultHttp2LocalFlowController(Http2Connection http2Connection, float f6, boolean z5) {
        this.initialWindowSize = 65535;
        this.connection = (Http2Connection) ObjectUtil.checkNotNull(http2Connection, "connection");
        windowUpdateRatio(f6);
        Http2Connection.PropertyKey newKey = http2Connection.newKey();
        this.stateKey = newKey;
        http2Connection.connectionStream().setProperty(newKey, z5 ? new AutoRefillState(http2Connection.connectionStream(), this.initialWindowSize) : new DefaultState(http2Connection.connectionStream(), this.initialWindowSize));
        http2Connection.addListener(new Http2ConnectionAdapter() { // from class: io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.1
            @Override // io.netty.handler.codec.http2.Http2ConnectionAdapter, io.netty.handler.codec.http2.Http2Connection.Listener
            public void onStreamActive(Http2Stream http2Stream) {
                Http2Connection.PropertyKey propertyKey = DefaultHttp2LocalFlowController.this.stateKey;
                DefaultHttp2LocalFlowController defaultHttp2LocalFlowController = DefaultHttp2LocalFlowController.this;
                http2Stream.setProperty(propertyKey, defaultHttp2LocalFlowController.new DefaultState(http2Stream, defaultHttp2LocalFlowController.initialWindowSize));
            }

            @Override // io.netty.handler.codec.http2.Http2ConnectionAdapter, io.netty.handler.codec.http2.Http2Connection.Listener
            public void onStreamAdded(Http2Stream http2Stream) {
                http2Stream.setProperty(DefaultHttp2LocalFlowController.this.stateKey, DefaultHttp2LocalFlowController.REDUCED_FLOW_STATE);
            }

            @Override // io.netty.handler.codec.http2.Http2ConnectionAdapter, io.netty.handler.codec.http2.Http2Connection.Listener
            public void onStreamClosed(Http2Stream http2Stream) {
                try {
                    try {
                        FlowState state = DefaultHttp2LocalFlowController.this.state(http2Stream);
                        int unconsumedBytes = state.unconsumedBytes();
                        if (DefaultHttp2LocalFlowController.this.ctx != null && unconsumedBytes > 0) {
                            DefaultHttp2LocalFlowController.this.connectionState().consumeBytes(unconsumedBytes);
                            state.consumeBytes(unconsumedBytes);
                        }
                    } catch (Http2Exception e6) {
                        PlatformDependent.throwException(e6);
                    }
                } finally {
                    http2Stream.setProperty(DefaultHttp2LocalFlowController.this.stateKey, DefaultHttp2LocalFlowController.REDUCED_FLOW_STATE);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FlowState connectionState() {
        return (FlowState) this.connection.connectionStream().getProperty(this.stateKey);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FlowState state(Http2Stream http2Stream) {
        return (FlowState) http2Stream.getProperty(this.stateKey);
    }

    @Override // io.netty.handler.codec.http2.Http2FlowController
    public void channelHandlerContext(ChannelHandlerContext channelHandlerContext) {
        this.ctx = (ChannelHandlerContext) ObjectUtil.checkNotNull(channelHandlerContext, "ctx");
    }

    @Override // io.netty.handler.codec.http2.Http2LocalFlowController
    public boolean consumeBytes(Http2Stream http2Stream, int i6) throws Http2Exception {
        ObjectUtil.checkPositiveOrZero(i6, "numBytes");
        if (i6 == 0 || http2Stream == null || isClosed(http2Stream)) {
            return false;
        }
        if (http2Stream.id() == 0) {
            throw new UnsupportedOperationException("Returning bytes for the connection window is not supported");
        }
        return state(http2Stream).consumeBytes(i6) | connectionState().consumeBytes(i6);
    }

    @Override // io.netty.handler.codec.http2.Http2LocalFlowController
    public DefaultHttp2LocalFlowController frameWriter(Http2FrameWriter http2FrameWriter) {
        this.frameWriter = (Http2FrameWriter) ObjectUtil.checkNotNull(http2FrameWriter, "frameWriter");
        return this;
    }

    private static boolean isClosed(Http2Stream http2Stream) {
        if (http2Stream.state() == Http2Stream.State.CLOSED) {
            return true;
        }
        return false;
    }

    @Override // io.netty.handler.codec.http2.Http2FlowController
    public void incrementWindowSize(Http2Stream http2Stream, int i6) throws Http2Exception {
        FlowState state = state(http2Stream);
        state.incrementInitialStreamWindow(i6);
        state.writeWindowUpdateIfNeeded();
    }

    @Override // io.netty.handler.codec.http2.Http2LocalFlowController
    public void receiveFlowControlledFrame(Http2Stream http2Stream, ByteBuf byteBuf, int i6, boolean z5) throws Http2Exception {
        int readableBytes = byteBuf.readableBytes() + i6;
        FlowState connectionState = connectionState();
        connectionState.receiveFlowControlledFrame(readableBytes);
        if (http2Stream != null && !isClosed(http2Stream)) {
            FlowState state = state(http2Stream);
            state.endOfStream(z5);
            state.receiveFlowControlledFrame(readableBytes);
        } else if (readableBytes > 0) {
            connectionState.consumeBytes(readableBytes);
        }
    }

    @Override // io.netty.handler.codec.http2.Http2LocalFlowController
    public int unconsumedBytes(Http2Stream http2Stream) {
        return state(http2Stream).unconsumedBytes();
    }

    @Override // io.netty.handler.codec.http2.Http2FlowController
    public int windowSize(Http2Stream http2Stream) {
        return state(http2Stream).windowSize();
    }

    public float windowUpdateRatio() {
        return this.windowUpdateRatio;
    }

    public void windowUpdateRatio(Http2Stream http2Stream, float f6) throws Http2Exception {
        checkValidRatio(f6);
        FlowState state = state(http2Stream);
        state.windowUpdateRatio(f6);
        state.writeWindowUpdateIfNeeded();
    }

    @Override // io.netty.handler.codec.http2.Http2FlowController
    public int initialWindowSize() {
        return this.initialWindowSize;
    }

    @Override // io.netty.handler.codec.http2.Http2LocalFlowController
    public int initialWindowSize(Http2Stream http2Stream) {
        return state(http2Stream).initialWindowSize();
    }

    public float windowUpdateRatio(Http2Stream http2Stream) throws Http2Exception {
        return state(http2Stream).windowUpdateRatio();
    }
}
