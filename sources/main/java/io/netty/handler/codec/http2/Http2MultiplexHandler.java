package io.netty.handler.codec.http2;

import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ServerChannel;
import io.netty.handler.codec.http2.Http2FrameCodec;
import io.netty.handler.codec.http2.Http2FrameStreamEvent;
import io.netty.handler.codec.http2.Http2Stream;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.internal.ObjectUtil;
import java.util.ArrayDeque;
import java.util.Queue;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class Http2MultiplexHandler extends Http2ChannelDuplexHandler {
    static final ChannelFutureListener CHILD_CHANNEL_REGISTRATION_LISTENER = new ChannelFutureListener() { // from class: io.netty.handler.codec.http2.Http2MultiplexHandler.1
        @Override // io.netty.util.concurrent.GenericFutureListener
        public void operationComplete(ChannelFuture channelFuture) {
            Http2MultiplexHandler.registerDone(channelFuture);
        }
    };
    private volatile ChannelHandlerContext ctx;
    private int idCount;
    private final ChannelHandler inboundStreamHandler;
    private boolean parentReadInProgress;
    private final Queue<AbstractHttp2StreamChannel> readCompletePendingQueue;
    private final ChannelHandler upgradeStreamHandler;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class Http2MultiplexHandlerStreamChannel extends AbstractHttp2StreamChannel {
        Http2MultiplexHandlerStreamChannel(Http2FrameCodec.DefaultHttp2FrameStream defaultHttp2FrameStream, ChannelHandler channelHandler) {
            super(defaultHttp2FrameStream, Http2MultiplexHandler.access$004(Http2MultiplexHandler.this), channelHandler);
        }

        @Override // io.netty.handler.codec.http2.AbstractHttp2StreamChannel
        protected void addChannelToReadCompletePendingQueue() {
            while (!Http2MultiplexHandler.this.readCompletePendingQueue.offer(this)) {
                Http2MultiplexHandler.this.processPendingReadCompleteQueue();
            }
        }

        @Override // io.netty.handler.codec.http2.AbstractHttp2StreamChannel
        protected boolean isParentReadInProgress() {
            return Http2MultiplexHandler.this.parentReadInProgress;
        }

        @Override // io.netty.handler.codec.http2.AbstractHttp2StreamChannel
        protected ChannelHandlerContext parentContext() {
            return Http2MultiplexHandler.this.ctx;
        }
    }

    public Http2MultiplexHandler(ChannelHandler channelHandler) {
        this(channelHandler, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processPendingReadCompleteQueue() {
        this.parentReadInProgress = true;
        AbstractHttp2StreamChannel poll = this.readCompletePendingQueue.poll();
        if (poll == null) {
            this.parentReadInProgress = false;
            return;
        }
        do {
            try {
                poll.fireChildReadComplete();
                poll = this.readCompletePendingQueue.poll();
            } finally {
                this.parentReadInProgress = false;
                this.readCompletePendingQueue.clear();
                this.ctx.flush();
            }
        } while (poll != null);
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
        this.parentReadInProgress = true;
        if (!(obj instanceof Http2StreamFrame)) {
            if (obj instanceof Http2GoAwayFrame) {
                onHttp2GoAwayFrame(channelHandlerContext, (Http2GoAwayFrame) obj);
            }
            channelHandlerContext.fireChannelRead(obj);
        } else {
            if (obj instanceof Http2WindowUpdateFrame) {
                return;
            }
            Http2StreamFrame http2StreamFrame = (Http2StreamFrame) obj;
            AbstractHttp2StreamChannel abstractHttp2StreamChannel = (AbstractHttp2StreamChannel) ((Http2FrameCodec.DefaultHttp2FrameStream) http2StreamFrame.stream()).attachment;
            if (obj instanceof Http2ResetFrame) {
                abstractHttp2StreamChannel.pipeline().fireUserEventTriggered(obj);
            } else {
                abstractHttp2StreamChannel.fireChildRead(http2StreamFrame);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: io.netty.handler.codec.http2.Http2MultiplexHandler$3, reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State;

        static {
            int[] iArr = new int[Http2Stream.State.values().length];
            $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State = iArr;
            try {
                iArr[Http2Stream.State.HALF_CLOSED_LOCAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[Http2Stream.State.HALF_CLOSED_REMOTE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[Http2Stream.State.OPEN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[Http2Stream.State.CLOSED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public Http2MultiplexHandler(ChannelHandler channelHandler, ChannelHandler channelHandler2) {
        this.readCompletePendingQueue = new MaxCapacityQueue(new ArrayDeque(8), 100);
        this.inboundStreamHandler = (ChannelHandler) ObjectUtil.checkNotNull(channelHandler, "inboundStreamHandler");
        this.upgradeStreamHandler = channelHandler2;
    }

    static /* synthetic */ int access$004(Http2MultiplexHandler http2MultiplexHandler) {
        int i6 = http2MultiplexHandler.idCount + 1;
        http2MultiplexHandler.idCount = i6;
        return i6;
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler, io.netty.channel.ChannelInboundHandler
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th) throws Exception {
        if (!(th instanceof Http2FrameStreamException)) {
            channelHandlerContext.fireExceptionCaught(th);
            return;
        }
        AbstractHttp2StreamChannel abstractHttp2StreamChannel = (AbstractHttp2StreamChannel) ((Http2FrameCodec.DefaultHttp2FrameStream) ((Http2FrameStreamException) th).stream()).attachment;
        try {
            abstractHttp2StreamChannel.pipeline().fireExceptionCaught(th.getCause());
        } finally {
            abstractHttp2StreamChannel.unsafe().closeForcibly();
        }
    }

    @Override // io.netty.handler.codec.http2.Http2ChannelDuplexHandler
    protected void handlerRemoved0(ChannelHandlerContext channelHandlerContext) {
        this.readCompletePendingQueue.clear();
    }

    Http2StreamChannel newOutboundStream() {
        return new Http2MultiplexHandlerStreamChannel((Http2FrameCodec.DefaultHttp2FrameStream) newStream(), null);
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void userEventTriggered(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
        Http2MultiplexHandlerStreamChannel http2MultiplexHandlerStreamChannel;
        AbstractHttp2StreamChannel abstractHttp2StreamChannel;
        if (!(obj instanceof Http2FrameStreamEvent)) {
            channelHandlerContext.fireUserEventTriggered(obj);
            return;
        }
        Http2FrameStreamEvent http2FrameStreamEvent = (Http2FrameStreamEvent) obj;
        Http2FrameCodec.DefaultHttp2FrameStream defaultHttp2FrameStream = (Http2FrameCodec.DefaultHttp2FrameStream) http2FrameStreamEvent.stream();
        if (http2FrameStreamEvent.type() == Http2FrameStreamEvent.Type.State) {
            int i6 = AnonymousClass3.$SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[defaultHttp2FrameStream.state().ordinal()];
            if (i6 != 1) {
                if (i6 != 2 && i6 != 3) {
                    if (i6 == 4 && (abstractHttp2StreamChannel = (AbstractHttp2StreamChannel) defaultHttp2FrameStream.attachment) != null) {
                        abstractHttp2StreamChannel.streamClosed();
                        return;
                    }
                    return;
                }
            } else if (defaultHttp2FrameStream.id() != 1) {
                return;
            }
            if (defaultHttp2FrameStream.attachment != null) {
                return;
            }
            if (defaultHttp2FrameStream.id() != 1 || isServer(channelHandlerContext)) {
                http2MultiplexHandlerStreamChannel = new Http2MultiplexHandlerStreamChannel(defaultHttp2FrameStream, this.inboundStreamHandler);
            } else {
                if (this.upgradeStreamHandler == null) {
                    throw Http2Exception.connectionError(Http2Error.INTERNAL_ERROR, "Client is misconfigured for upgrade requests", new Object[0]);
                }
                http2MultiplexHandlerStreamChannel = new Http2MultiplexHandlerStreamChannel(defaultHttp2FrameStream, this.upgradeStreamHandler);
                http2MultiplexHandlerStreamChannel.closeOutbound();
            }
            ChannelFuture register = channelHandlerContext.channel().eventLoop().register(http2MultiplexHandlerStreamChannel);
            if (register.isDone()) {
                registerDone(register);
            } else {
                register.addListener((GenericFutureListener<? extends Future<? super Void>>) CHILD_CHANNEL_REGISTRATION_LISTENER);
            }
        }
    }

    private static boolean isServer(ChannelHandlerContext channelHandlerContext) {
        return channelHandlerContext.channel().parent() instanceof ServerChannel;
    }

    private void onHttp2GoAwayFrame(ChannelHandlerContext channelHandlerContext, final Http2GoAwayFrame http2GoAwayFrame) {
        try {
            final boolean isServer = isServer(channelHandlerContext);
            forEachActiveStream(new Http2FrameStreamVisitor() { // from class: io.netty.handler.codec.http2.Http2MultiplexHandler.2
                @Override // io.netty.handler.codec.http2.Http2FrameStreamVisitor
                public boolean visit(Http2FrameStream http2FrameStream) {
                    int id = http2FrameStream.id();
                    if (id > http2GoAwayFrame.lastStreamId() && Http2CodecUtil.isStreamIdValid(id, isServer)) {
                        ((AbstractHttp2StreamChannel) ((Http2FrameCodec.DefaultHttp2FrameStream) http2FrameStream).attachment).pipeline().fireUserEventTriggered((Object) http2GoAwayFrame.retainedDuplicate());
                        return true;
                    }
                    return true;
                }
            });
        } catch (Http2Exception e6) {
            channelHandlerContext.fireExceptionCaught((Throwable) e6);
            channelHandlerContext.close();
        }
    }

    static void registerDone(ChannelFuture channelFuture) {
        if (!channelFuture.isSuccess()) {
            Channel channel = channelFuture.channel();
            if (channel.isRegistered()) {
                channel.close();
            } else {
                channel.unsafe().closeForcibly();
            }
        }
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelReadComplete(ChannelHandlerContext channelHandlerContext) throws Exception {
        processPendingReadCompleteQueue();
        channelHandlerContext.fireChannelReadComplete();
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelWritabilityChanged(ChannelHandlerContext channelHandlerContext) throws Exception {
        if (channelHandlerContext.channel().isWritable()) {
            forEachActiveStream(AbstractHttp2StreamChannel.WRITABLE_VISITOR);
        }
        channelHandlerContext.fireChannelWritabilityChanged();
    }

    @Override // io.netty.handler.codec.http2.Http2ChannelDuplexHandler
    protected void handlerAdded0(ChannelHandlerContext channelHandlerContext) {
        if (channelHandlerContext.executor() == channelHandlerContext.channel().eventLoop()) {
            this.ctx = channelHandlerContext;
            return;
        }
        throw new IllegalStateException("EventExecutor must be EventLoop of Channel");
    }
}
