package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.Channel;
import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelId;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.ChannelProgressivePromise;
import io.netty.channel.ChannelPromise;
import io.netty.channel.DefaultChannelConfig;
import io.netty.channel.DefaultChannelPipeline;
import io.netty.channel.EventLoop;
import io.netty.channel.MessageSizeEstimator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.VoidChannelPromise;
import io.netty.handler.codec.http2.Http2FrameCodec;
import io.netty.util.DefaultAttributeMap;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.IOException;
import java.net.SocketAddress;
import java.nio.channels.ClosedChannelException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
abstract class AbstractHttp2StreamChannel extends DefaultAttributeMap implements Http2StreamChannel {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int MIN_HTTP2_FRAME_SIZE = 9;
    private final ChannelId channelId;
    private final ChannelPromise closePromise;
    private Runnable fireChannelWritabilityChangedTask;
    private boolean firstFrameWritten;
    private int flowControlledBytes;
    private Queue<Object> inboundBuffer;
    private boolean outboundClosed;
    private final ChannelPipeline pipeline;
    private boolean readCompletePending;
    private volatile boolean registered;
    private final Http2FrameCodec.DefaultHttp2FrameStream stream;
    private volatile long totalPendingSize;
    private volatile int unwritable;
    static final Http2FrameStreamVisitor WRITABLE_VISITOR = new Http2FrameStreamVisitor() { // from class: io.netty.handler.codec.http2.AbstractHttp2StreamChannel.1
        @Override // io.netty.handler.codec.http2.Http2FrameStreamVisitor
        public boolean visit(Http2FrameStream http2FrameStream) {
            ((AbstractHttp2StreamChannel) ((Http2FrameCodec.DefaultHttp2FrameStream) http2FrameStream).attachment).trySetWritable();
            return true;
        }
    };
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) AbstractHttp2StreamChannel.class);
    private static final ChannelMetadata METADATA = new ChannelMetadata(false, 16);
    private static final AtomicLongFieldUpdater<AbstractHttp2StreamChannel> TOTAL_PENDING_SIZE_UPDATER = AtomicLongFieldUpdater.newUpdater(AbstractHttp2StreamChannel.class, "totalPendingSize");
    private static final AtomicIntegerFieldUpdater<AbstractHttp2StreamChannel> UNWRITABLE_UPDATER = AtomicIntegerFieldUpdater.newUpdater(AbstractHttp2StreamChannel.class, "unwritable");
    private final Http2StreamChannelConfig config = new Http2StreamChannelConfig(this);
    private final Http2ChannelUnsafe unsafe = new Http2ChannelUnsafe();
    private ReadStatus readStatus = ReadStatus.IDLE;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class FlowControlledFrameSizeEstimator implements MessageSizeEstimator {
        static final FlowControlledFrameSizeEstimator INSTANCE = new FlowControlledFrameSizeEstimator();
        private static final MessageSizeEstimator.Handle HANDLE_INSTANCE = new MessageSizeEstimator.Handle() { // from class: io.netty.handler.codec.http2.AbstractHttp2StreamChannel.FlowControlledFrameSizeEstimator.1
            @Override // io.netty.channel.MessageSizeEstimator.Handle
            public int size(Object obj) {
                if (obj instanceof Http2DataFrame) {
                    return (int) Math.min(2147483647L, ((Http2DataFrame) obj).initialFlowControlledBytes() + 9);
                }
                return 9;
            }
        };

        @Override // io.netty.channel.MessageSizeEstimator
        public MessageSizeEstimator.Handle newHandle() {
            return HANDLE_INSTANCE;
        }

        private FlowControlledFrameSizeEstimator() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class Http2ChannelUnsafe implements Channel.Unsafe {
        private boolean closeInitiated;
        private boolean readEOS;
        private RecvByteBufAllocator.Handle recvHandle;
        private final VoidChannelPromise unsafeVoidPromise;
        private boolean writeDoneAndNoFlush;

        private Http2ChannelUnsafe() {
            this.unsafeVoidPromise = new VoidChannelPromise(AbstractHttp2StreamChannel.this, false);
        }

        @Override // io.netty.channel.Channel.Unsafe
        public void deregister(ChannelPromise channelPromise) {
            fireChannelInactiveAndDeregister(channelPromise, false);
        }

        @Override // io.netty.channel.Channel.Unsafe
        public ChannelOutboundBuffer outboundBuffer() {
            return null;
        }

        void readEOS() {
            this.readEOS = true;
        }

        private void invokeLater(Runnable runnable) {
            try {
                AbstractHttp2StreamChannel.this.eventLoop().execute(runnable);
            } catch (RejectedExecutionException e6) {
                AbstractHttp2StreamChannel.logger.warn("Can't invoke task later as EventLoop rejected it", (Throwable) e6);
            }
        }

        private Object pollQueuedMessage() {
            if (AbstractHttp2StreamChannel.this.inboundBuffer == null) {
                return null;
            }
            return AbstractHttp2StreamChannel.this.inboundBuffer.poll();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void safeSetSuccess(ChannelPromise channelPromise) {
            if ((channelPromise instanceof VoidChannelPromise) || channelPromise.trySuccess()) {
                return;
            }
            AbstractHttp2StreamChannel.logger.warn("Failed to mark a promise as success because it is done already: {}", channelPromise);
        }

        private void updateLocalWindowIfNeeded() {
            if (AbstractHttp2StreamChannel.this.flowControlledBytes != 0) {
                int i6 = AbstractHttp2StreamChannel.this.flowControlledBytes;
                AbstractHttp2StreamChannel.this.flowControlledBytes = 0;
                AbstractHttp2StreamChannel abstractHttp2StreamChannel = AbstractHttp2StreamChannel.this;
                abstractHttp2StreamChannel.write0(abstractHttp2StreamChannel.parentContext(), new DefaultHttp2WindowUpdateFrame(i6).stream((Http2FrameStream) AbstractHttp2StreamChannel.this.stream));
                this.writeDoneAndNoFlush = true;
            }
        }

        private Throwable wrapStreamClosedError(Throwable th) {
            return ((th instanceof Http2Exception) && ((Http2Exception) th).error() == Http2Error.STREAM_CLOSED) ? new ClosedChannelException().initCause(th) : th;
        }

        @Override // io.netty.channel.Channel.Unsafe
        public void beginRead() {
            if (AbstractHttp2StreamChannel.this.isActive()) {
                int i6 = AnonymousClass4.$SwitchMap$io$netty$handler$codec$http2$AbstractHttp2StreamChannel$ReadStatus[AbstractHttp2StreamChannel.this.readStatus.ordinal()];
                if (i6 == 1) {
                    AbstractHttp2StreamChannel.this.readStatus = ReadStatus.IN_PROGRESS;
                    doBeginRead();
                } else {
                    if (i6 != 2) {
                        return;
                    }
                    AbstractHttp2StreamChannel.this.readStatus = ReadStatus.REQUESTED;
                }
            }
        }

        @Override // io.netty.channel.Channel.Unsafe
        public void closeForcibly() {
            close(AbstractHttp2StreamChannel.this.unsafe().voidPromise());
        }

        void doBeginRead() {
            boolean z5;
            while (AbstractHttp2StreamChannel.this.readStatus != ReadStatus.IDLE) {
                Object pollQueuedMessage = pollQueuedMessage();
                if (pollQueuedMessage == null) {
                    if (this.readEOS) {
                        AbstractHttp2StreamChannel.this.unsafe.closeForcibly();
                        return;
                    }
                    return;
                }
                RecvByteBufAllocator.Handle recvBufAllocHandle = recvBufAllocHandle();
                recvBufAllocHandle.reset(AbstractHttp2StreamChannel.this.config());
                boolean z6 = false;
                while (true) {
                    AbstractHttp2StreamChannel.this.flowControlledBytes += doRead0((Http2Frame) pollQueuedMessage, recvBufAllocHandle);
                    if (!this.readEOS) {
                        z5 = recvBufAllocHandle.continueReading();
                        if (!z5) {
                            break;
                        } else {
                            z6 = z5;
                        }
                    }
                    pollQueuedMessage = pollQueuedMessage();
                    if (pollQueuedMessage == null) {
                        z5 = z6;
                        break;
                    }
                }
                if (!z5 || !AbstractHttp2StreamChannel.this.isParentReadInProgress() || this.readEOS) {
                    notifyReadComplete(recvBufAllocHandle, true);
                } else if (!AbstractHttp2StreamChannel.this.readCompletePending) {
                    AbstractHttp2StreamChannel.this.readCompletePending = true;
                    AbstractHttp2StreamChannel.this.addChannelToReadCompletePendingQueue();
                }
            }
        }

        int doRead0(Http2Frame http2Frame, RecvByteBufAllocator.Handle handle) {
            AbstractHttp2StreamChannel.this.pipeline().fireChannelRead((Object) http2Frame);
            handle.incMessagesRead(1);
            if (!(http2Frame instanceof Http2DataFrame)) {
                handle.attemptedBytesRead(9);
                handle.lastBytesRead(9);
                return 0;
            }
            int initialFlowControlledBytes = ((Http2DataFrame) http2Frame).initialFlowControlledBytes();
            handle.attemptedBytesRead(initialFlowControlledBytes);
            handle.lastBytesRead(initialFlowControlledBytes);
            return initialFlowControlledBytes;
        }

        @Override // io.netty.channel.Channel.Unsafe
        public void flush() {
            if (!this.writeDoneAndNoFlush || AbstractHttp2StreamChannel.this.isParentReadInProgress()) {
                return;
            }
            try {
                AbstractHttp2StreamChannel abstractHttp2StreamChannel = AbstractHttp2StreamChannel.this;
                abstractHttp2StreamChannel.flush0(abstractHttp2StreamChannel.parentContext());
            } finally {
                this.writeDoneAndNoFlush = false;
            }
        }

        @Override // io.netty.channel.Channel.Unsafe
        public SocketAddress localAddress() {
            return AbstractHttp2StreamChannel.this.parent().unsafe().localAddress();
        }

        void notifyReadComplete(RecvByteBufAllocator.Handle handle, boolean z5) {
            if (AbstractHttp2StreamChannel.this.readCompletePending || z5) {
                AbstractHttp2StreamChannel.this.readCompletePending = false;
                if (AbstractHttp2StreamChannel.this.readStatus == ReadStatus.REQUESTED) {
                    AbstractHttp2StreamChannel.this.readStatus = ReadStatus.IN_PROGRESS;
                } else {
                    AbstractHttp2StreamChannel.this.readStatus = ReadStatus.IDLE;
                }
                updateLocalWindowIfNeeded();
                handle.readComplete();
                AbstractHttp2StreamChannel.this.pipeline().fireChannelReadComplete();
                flush();
                if (this.readEOS) {
                    AbstractHttp2StreamChannel.this.unsafe.closeForcibly();
                }
            }
        }

        @Override // io.netty.channel.Channel.Unsafe
        public RecvByteBufAllocator.Handle recvBufAllocHandle() {
            if (this.recvHandle == null) {
                RecvByteBufAllocator.Handle newHandle = AbstractHttp2StreamChannel.this.config().getRecvByteBufAllocator().newHandle();
                this.recvHandle = newHandle;
                newHandle.reset(AbstractHttp2StreamChannel.this.config());
            }
            return this.recvHandle;
        }

        @Override // io.netty.channel.Channel.Unsafe
        public SocketAddress remoteAddress() {
            return AbstractHttp2StreamChannel.this.parent().unsafe().remoteAddress();
        }

        @Override // io.netty.channel.Channel.Unsafe
        public ChannelPromise voidPromise() {
            return this.unsafeVoidPromise;
        }

        private void fireChannelInactiveAndDeregister(final ChannelPromise channelPromise, final boolean z5) {
            if (!channelPromise.setUncancellable()) {
                return;
            }
            if (!AbstractHttp2StreamChannel.this.registered) {
                channelPromise.setSuccess();
            } else {
                invokeLater(new Runnable() { // from class: io.netty.handler.codec.http2.AbstractHttp2StreamChannel.Http2ChannelUnsafe.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (z5) {
                            AbstractHttp2StreamChannel.this.pipeline.fireChannelInactive();
                        }
                        if (AbstractHttp2StreamChannel.this.registered) {
                            AbstractHttp2StreamChannel.this.registered = false;
                            AbstractHttp2StreamChannel.this.pipeline.fireChannelUnregistered();
                        }
                        Http2ChannelUnsafe.this.safeSetSuccess(channelPromise);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void firstWriteComplete(ChannelFuture channelFuture, ChannelPromise channelPromise) {
            Throwable cause = channelFuture.cause();
            if (cause == null) {
                channelPromise.setSuccess();
            } else {
                closeForcibly();
                channelPromise.setFailure(wrapStreamClosedError(cause));
            }
        }

        private Http2StreamFrame validateStreamFrame(Http2StreamFrame http2StreamFrame) {
            if (http2StreamFrame.stream() != null && http2StreamFrame.stream() != AbstractHttp2StreamChannel.this.stream) {
                String obj = http2StreamFrame.toString();
                ReferenceCountUtil.release(http2StreamFrame);
                throw new IllegalArgumentException("Stream " + http2StreamFrame.stream() + " must not be set on the frame: " + obj);
            }
            return http2StreamFrame;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void writeComplete(ChannelFuture channelFuture, ChannelPromise channelPromise) {
            Throwable cause = channelFuture.cause();
            if (cause == null) {
                channelPromise.setSuccess();
                return;
            }
            Throwable wrapStreamClosedError = wrapStreamClosedError(cause);
            if (wrapStreamClosedError instanceof IOException) {
                if (!AbstractHttp2StreamChannel.this.config.isAutoClose()) {
                    AbstractHttp2StreamChannel.this.outboundClosed = true;
                } else {
                    closeForcibly();
                }
            }
            channelPromise.setFailure(wrapStreamClosedError);
        }

        @Override // io.netty.channel.Channel.Unsafe
        public void bind(SocketAddress socketAddress, ChannelPromise channelPromise) {
            if (!channelPromise.setUncancellable()) {
                return;
            }
            channelPromise.setFailure((Throwable) new UnsupportedOperationException());
        }

        @Override // io.netty.channel.Channel.Unsafe
        public void close(final ChannelPromise channelPromise) {
            if (!channelPromise.setUncancellable()) {
                return;
            }
            if (this.closeInitiated) {
                if (AbstractHttp2StreamChannel.this.closePromise.isDone()) {
                    channelPromise.setSuccess();
                    return;
                } else {
                    if (!(channelPromise instanceof VoidChannelPromise)) {
                        AbstractHttp2StreamChannel.this.closePromise.addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.handler.codec.http2.AbstractHttp2StreamChannel.Http2ChannelUnsafe.1
                            @Override // io.netty.util.concurrent.GenericFutureListener
                            public void operationComplete(ChannelFuture channelFuture) {
                                channelPromise.setSuccess();
                            }
                        });
                        return;
                    }
                    return;
                }
            }
            this.closeInitiated = true;
            AbstractHttp2StreamChannel.this.readCompletePending = false;
            boolean isActive = AbstractHttp2StreamChannel.this.isActive();
            updateLocalWindowIfNeeded();
            if (AbstractHttp2StreamChannel.this.parent().isActive() && !this.readEOS && Http2CodecUtil.isStreamIdValid(AbstractHttp2StreamChannel.this.stream.id())) {
                write(new DefaultHttp2ResetFrame(Http2Error.CANCEL).stream(AbstractHttp2StreamChannel.this.stream()), AbstractHttp2StreamChannel.this.unsafe().voidPromise());
                flush();
            }
            if (AbstractHttp2StreamChannel.this.inboundBuffer != null) {
                while (true) {
                    Object poll = AbstractHttp2StreamChannel.this.inboundBuffer.poll();
                    if (poll == null) {
                        break;
                    } else {
                        ReferenceCountUtil.release(poll);
                    }
                }
                AbstractHttp2StreamChannel.this.inboundBuffer = null;
            }
            AbstractHttp2StreamChannel.this.outboundClosed = true;
            AbstractHttp2StreamChannel.this.closePromise.setSuccess();
            channelPromise.setSuccess();
            fireChannelInactiveAndDeregister(voidPromise(), isActive);
        }

        @Override // io.netty.channel.Channel.Unsafe
        public void connect(SocketAddress socketAddress, SocketAddress socketAddress2, ChannelPromise channelPromise) {
            if (!channelPromise.setUncancellable()) {
                return;
            }
            channelPromise.setFailure((Throwable) new UnsupportedOperationException());
        }

        @Override // io.netty.channel.Channel.Unsafe
        public void disconnect(ChannelPromise channelPromise) {
            close(channelPromise);
        }

        @Override // io.netty.channel.Channel.Unsafe
        public void register(EventLoop eventLoop, ChannelPromise channelPromise) {
            if (channelPromise.setUncancellable()) {
                if (!AbstractHttp2StreamChannel.this.registered) {
                    AbstractHttp2StreamChannel.this.registered = true;
                    channelPromise.setSuccess();
                    AbstractHttp2StreamChannel.this.pipeline().fireChannelRegistered();
                    if (AbstractHttp2StreamChannel.this.isActive()) {
                        AbstractHttp2StreamChannel.this.pipeline().fireChannelActive();
                        return;
                    }
                    return;
                }
                channelPromise.setFailure((Throwable) new UnsupportedOperationException("Re-register is not supported"));
            }
        }

        @Override // io.netty.channel.Channel.Unsafe
        public void write(Object obj, final ChannelPromise channelPromise) {
            if (!channelPromise.setUncancellable()) {
                ReferenceCountUtil.release(obj);
                return;
            }
            if (AbstractHttp2StreamChannel.this.isActive() && (!AbstractHttp2StreamChannel.this.outboundClosed || (!(obj instanceof Http2HeadersFrame) && !(obj instanceof Http2DataFrame)))) {
                try {
                    if (obj instanceof Http2StreamFrame) {
                        Http2StreamFrame stream = validateStreamFrame((Http2StreamFrame) obj).stream(AbstractHttp2StreamChannel.this.stream());
                        if (!AbstractHttp2StreamChannel.this.firstFrameWritten && !Http2CodecUtil.isStreamIdValid(AbstractHttp2StreamChannel.this.stream().id())) {
                            if (stream instanceof Http2HeadersFrame) {
                                AbstractHttp2StreamChannel.this.firstFrameWritten = true;
                                AbstractHttp2StreamChannel abstractHttp2StreamChannel = AbstractHttp2StreamChannel.this;
                                ChannelFuture write0 = abstractHttp2StreamChannel.write0(abstractHttp2StreamChannel.parentContext(), stream);
                                if (write0.isDone()) {
                                    firstWriteComplete(write0, channelPromise);
                                    return;
                                }
                                final long size = FlowControlledFrameSizeEstimator.HANDLE_INSTANCE.size(obj);
                                AbstractHttp2StreamChannel.this.incrementPendingOutboundBytes(size, false);
                                write0.addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.handler.codec.http2.AbstractHttp2StreamChannel.Http2ChannelUnsafe.3
                                    @Override // io.netty.util.concurrent.GenericFutureListener
                                    public void operationComplete(ChannelFuture channelFuture) {
                                        Http2ChannelUnsafe.this.firstWriteComplete(channelFuture, channelPromise);
                                        AbstractHttp2StreamChannel.this.decrementPendingOutboundBytes(size, false);
                                    }
                                });
                                this.writeDoneAndNoFlush = true;
                                return;
                            }
                            ReferenceCountUtil.release(stream);
                            channelPromise.setFailure((Throwable) new IllegalArgumentException("The first frame must be a headers frame. Was: " + stream.name()));
                            return;
                        }
                        AbstractHttp2StreamChannel abstractHttp2StreamChannel2 = AbstractHttp2StreamChannel.this;
                        ChannelFuture write02 = abstractHttp2StreamChannel2.write0(abstractHttp2StreamChannel2.parentContext(), obj);
                        if (write02.isDone()) {
                            writeComplete(write02, channelPromise);
                            return;
                        }
                        final long size2 = FlowControlledFrameSizeEstimator.HANDLE_INSTANCE.size(obj);
                        AbstractHttp2StreamChannel.this.incrementPendingOutboundBytes(size2, false);
                        write02.addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.handler.codec.http2.AbstractHttp2StreamChannel.Http2ChannelUnsafe.4
                            @Override // io.netty.util.concurrent.GenericFutureListener
                            public void operationComplete(ChannelFuture channelFuture) {
                                Http2ChannelUnsafe.this.writeComplete(channelFuture, channelPromise);
                                AbstractHttp2StreamChannel.this.decrementPendingOutboundBytes(size2, false);
                            }
                        });
                        this.writeDoneAndNoFlush = true;
                        return;
                    }
                    String obj2 = obj.toString();
                    ReferenceCountUtil.release(obj);
                    channelPromise.setFailure((Throwable) new IllegalArgumentException("Message must be an " + StringUtil.simpleClassName((Class<?>) Http2StreamFrame.class) + ": " + obj2));
                    return;
                } catch (Throwable th) {
                    channelPromise.tryFailure(th);
                    return;
                }
            }
            ReferenceCountUtil.release(obj);
            channelPromise.setFailure((Throwable) new ClosedChannelException());
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class Http2StreamChannelConfig extends DefaultChannelConfig {
        Http2StreamChannelConfig(Channel channel) {
            super(channel);
        }

        @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
        public MessageSizeEstimator getMessageSizeEstimator() {
            return FlowControlledFrameSizeEstimator.INSTANCE;
        }

        @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
        public ChannelConfig setMessageSizeEstimator(MessageSizeEstimator messageSizeEstimator) {
            throw new UnsupportedOperationException();
        }

        @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
        public ChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator recvByteBufAllocator) {
            if (recvByteBufAllocator.newHandle() instanceof RecvByteBufAllocator.ExtendedHandle) {
                super.setRecvByteBufAllocator(recvByteBufAllocator);
                return this;
            }
            throw new IllegalArgumentException("allocator.newHandle() must return an object of type: " + RecvByteBufAllocator.ExtendedHandle.class);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private enum ReadStatus {
        IDLE,
        IN_PROGRESS,
        REQUESTED
    }

    protected abstract void addChannelToReadCompletePendingQueue();

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture bind(SocketAddress socketAddress) {
        return pipeline().bind(socketAddress);
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture close() {
        return pipeline().close();
    }

    void closeOutbound() {
        this.outboundClosed = true;
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture connect(SocketAddress socketAddress) {
        return pipeline().connect(socketAddress);
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture deregister() {
        return pipeline().deregister();
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture disconnect() {
        return pipeline().disconnect();
    }

    protected abstract boolean isParentReadInProgress();

    protected abstract ChannelHandlerContext parentContext();

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture write(Object obj) {
        return pipeline().write(obj);
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture writeAndFlush(Object obj, ChannelPromise channelPromise) {
        return pipeline().writeAndFlush(obj, channelPromise);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: io.netty.handler.codec.http2.AbstractHttp2StreamChannel$4, reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$http2$AbstractHttp2StreamChannel$ReadStatus;

        static {
            int[] iArr = new int[ReadStatus.values().length];
            $SwitchMap$io$netty$handler$codec$http2$AbstractHttp2StreamChannel$ReadStatus = iArr;
            try {
                iArr[ReadStatus.IDLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http2$AbstractHttp2StreamChannel$ReadStatus[ReadStatus.IN_PROGRESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void decrementPendingOutboundBytes(long j6, boolean z5) {
        if (j6 != 0 && TOTAL_PENDING_SIZE_UPDATER.addAndGet(this, -j6) < config().getWriteBufferLowWaterMark() && parent().isWritable()) {
            setWritable(z5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void incrementPendingOutboundBytes(long j6, boolean z5) {
        if (j6 != 0 && TOTAL_PENDING_SIZE_UPDATER.addAndGet(this, j6) > config().getWriteBufferHighWaterMark()) {
            setUnwritable(z5);
        }
    }

    private void setUnwritable(boolean z5) {
        int i6;
        int i7;
        do {
            i6 = this.unwritable;
            i7 = i6 | 1;
        } while (!UNWRITABLE_UPDATER.compareAndSet(this, i6, i7));
        if (i6 != 0 || i7 == 0) {
            return;
        }
        fireChannelWritabilityChanged(z5);
    }

    private void setWritable(boolean z5) {
        int i6;
        int i7;
        do {
            i6 = this.unwritable;
            i7 = i6 & (-2);
        } while (!UNWRITABLE_UPDATER.compareAndSet(this, i6, i7));
        if (i6 == 0 || i7 != 0) {
            return;
        }
        fireChannelWritabilityChanged(z5);
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture bind(SocketAddress socketAddress, ChannelPromise channelPromise) {
        return pipeline().bind(socketAddress, channelPromise);
    }

    @Override // io.netty.channel.Channel
    public long bytesBeforeWritable() {
        long writeBufferLowWaterMark = this.totalPendingSize - config().getWriteBufferLowWaterMark();
        if (writeBufferLowWaterMark <= 0 || isWritable()) {
            return 0L;
        }
        return writeBufferLowWaterMark;
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture close(ChannelPromise channelPromise) {
        return pipeline().close(channelPromise);
    }

    @Override // io.netty.channel.Channel
    public ChannelFuture closeFuture() {
        return this.closePromise;
    }

    @Override // java.lang.Comparable
    public int compareTo(Channel channel) {
        if (this == channel) {
            return 0;
        }
        return id().compareTo(channel.id());
    }

    @Override // io.netty.channel.Channel
    public ChannelConfig config() {
        return this.config;
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture connect(SocketAddress socketAddress, SocketAddress socketAddress2) {
        return pipeline().connect(socketAddress, socketAddress2);
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture deregister(ChannelPromise channelPromise) {
        return pipeline().deregister(channelPromise);
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture disconnect(ChannelPromise channelPromise) {
        return pipeline().disconnect(channelPromise);
    }

    public boolean equals(Object obj) {
        return this == obj;
    }

    void fireChildReadComplete() {
        Http2ChannelUnsafe http2ChannelUnsafe = this.unsafe;
        http2ChannelUnsafe.notifyReadComplete(http2ChannelUnsafe.recvBufAllocHandle(), false);
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public Channel flush() {
        pipeline().flush();
        return this;
    }

    @Override // io.netty.channel.Channel
    public ChannelId id() {
        return this.channelId;
    }

    @Override // io.netty.channel.Channel
    public boolean isOpen() {
        return !this.closePromise.isDone();
    }

    @Override // io.netty.channel.Channel
    public boolean isRegistered() {
        return this.registered;
    }

    @Override // io.netty.channel.Channel
    public boolean isWritable() {
        return this.unwritable == 0;
    }

    @Override // io.netty.channel.Channel
    public ChannelMetadata metadata() {
        return METADATA;
    }

    @Override // io.netty.channel.Channel
    public ChannelPipeline pipeline() {
        return this.pipeline;
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public Channel read() {
        pipeline().read();
        return this;
    }

    @Override // io.netty.handler.codec.http2.Http2StreamChannel
    public Http2FrameStream stream() {
        return this.stream;
    }

    void streamClosed() {
        this.unsafe.readEOS();
        this.unsafe.doBeginRead();
    }

    public String toString() {
        return parent().toString() + "(H2 - " + this.stream + ')';
    }

    final void trySetWritable() {
        if (this.totalPendingSize < config().getWriteBufferLowWaterMark()) {
            setWritable(false);
        }
    }

    @Override // io.netty.channel.Channel
    public Channel.Unsafe unsafe() {
        return this.unsafe;
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture write(Object obj, ChannelPromise channelPromise) {
        return pipeline().write(obj, channelPromise);
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture writeAndFlush(Object obj) {
        return pipeline().writeAndFlush(obj);
    }

    AbstractHttp2StreamChannel(Http2FrameCodec.DefaultHttp2FrameStream defaultHttp2FrameStream, int i6, ChannelHandler channelHandler) {
        this.stream = defaultHttp2FrameStream;
        defaultHttp2FrameStream.attachment = this;
        DefaultChannelPipeline defaultChannelPipeline = new DefaultChannelPipeline(this) { // from class: io.netty.handler.codec.http2.AbstractHttp2StreamChannel.2
            @Override // io.netty.channel.DefaultChannelPipeline
            protected void decrementPendingOutboundBytes(long j6) {
                AbstractHttp2StreamChannel.this.decrementPendingOutboundBytes(j6, true);
            }

            @Override // io.netty.channel.DefaultChannelPipeline
            protected void incrementPendingOutboundBytes(long j6) {
                AbstractHttp2StreamChannel.this.incrementPendingOutboundBytes(j6, true);
            }
        };
        this.pipeline = defaultChannelPipeline;
        this.closePromise = defaultChannelPipeline.newPromise();
        this.channelId = new Http2StreamChannelId(parent().id(), i6);
        if (channelHandler != null) {
            defaultChannelPipeline.addLast(channelHandler);
        }
    }

    private void fireChannelWritabilityChanged(boolean z5) {
        final ChannelPipeline pipeline = pipeline();
        if (z5) {
            Runnable runnable = this.fireChannelWritabilityChangedTask;
            if (runnable == null) {
                runnable = new Runnable() { // from class: io.netty.handler.codec.http2.AbstractHttp2StreamChannel.3
                    @Override // java.lang.Runnable
                    public void run() {
                        pipeline.fireChannelWritabilityChanged();
                    }
                };
                this.fireChannelWritabilityChangedTask = runnable;
            }
            eventLoop().execute(runnable);
            return;
        }
        pipeline.fireChannelWritabilityChanged();
    }

    @Override // io.netty.channel.Channel
    public ByteBufAllocator alloc() {
        return config().getAllocator();
    }

    @Override // io.netty.channel.Channel
    public long bytesBeforeUnwritable() {
        long writeBufferHighWaterMark = config().getWriteBufferHighWaterMark() - this.totalPendingSize;
        if (writeBufferHighWaterMark <= 0 || !isWritable()) {
            return 0L;
        }
        return writeBufferHighWaterMark;
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture connect(SocketAddress socketAddress, ChannelPromise channelPromise) {
        return pipeline().connect(socketAddress, channelPromise);
    }

    @Override // io.netty.channel.Channel
    public EventLoop eventLoop() {
        return parent().eventLoop();
    }

    void fireChildRead(Http2Frame http2Frame) {
        if (!isActive()) {
            ReferenceCountUtil.release(http2Frame);
            return;
        }
        if (this.readStatus != ReadStatus.IDLE) {
            RecvByteBufAllocator.Handle recvBufAllocHandle = this.unsafe.recvBufAllocHandle();
            this.flowControlledBytes += this.unsafe.doRead0(http2Frame, recvBufAllocHandle);
            if (recvBufAllocHandle.continueReading()) {
                if (!this.readCompletePending) {
                    this.readCompletePending = true;
                    addChannelToReadCompletePendingQueue();
                    return;
                }
                return;
            }
            this.unsafe.notifyReadComplete(recvBufAllocHandle, true);
            return;
        }
        if (this.inboundBuffer == null) {
            this.inboundBuffer = new ArrayDeque(4);
        }
        this.inboundBuffer.add(http2Frame);
    }

    protected void flush0(ChannelHandlerContext channelHandlerContext) {
        channelHandlerContext.flush();
    }

    public int hashCode() {
        return id().hashCode();
    }

    @Override // io.netty.channel.Channel
    public boolean isActive() {
        return isOpen();
    }

    @Override // io.netty.channel.Channel
    public SocketAddress localAddress() {
        return parent().localAddress();
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture newFailedFuture(Throwable th) {
        return pipeline().newFailedFuture(th);
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelProgressivePromise newProgressivePromise() {
        return pipeline().newProgressivePromise();
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelPromise newPromise() {
        return pipeline().newPromise();
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture newSucceededFuture() {
        return pipeline().newSucceededFuture();
    }

    @Override // io.netty.channel.Channel
    public Channel parent() {
        return parentContext().channel();
    }

    @Override // io.netty.channel.Channel
    public SocketAddress remoteAddress() {
        return parent().remoteAddress();
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelPromise voidPromise() {
        return pipeline().voidPromise();
    }

    protected ChannelFuture write0(ChannelHandlerContext channelHandlerContext, Object obj) {
        ChannelPromise newPromise = channelHandlerContext.newPromise();
        channelHandlerContext.write(obj, newPromise);
        return newPromise;
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture connect(SocketAddress socketAddress, SocketAddress socketAddress2, ChannelPromise channelPromise) {
        return pipeline().connect(socketAddress, socketAddress2, channelPromise);
    }
}
