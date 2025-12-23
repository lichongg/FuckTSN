package io.netty.handler.codec;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;
import io.netty.buffer.CompositeByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPipeline;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.internal.ObjectUtil;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class MessageAggregator<I, S, C extends ByteBufHolder, O extends ByteBufHolder> extends MessageToMessageDecoder<I> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int DEFAULT_MAX_COMPOSITEBUFFER_COMPONENTS = 1024;
    private boolean aggregating;
    private ChannelFutureListener continueResponseWriteListener;
    private ChannelHandlerContext ctx;
    private O currentMessage;
    private boolean handlingOversizedMessage;
    private final int maxContentLength;
    private int maxCumulationBufferComponents;

    protected MessageAggregator(int i6) {
        this.maxCumulationBufferComponents = 1024;
        validateMaxContentLength(i6);
        this.maxContentLength = i6;
    }

    private void finishAggregation0(O o5) throws Exception {
        this.aggregating = false;
        finishAggregation(o5);
    }

    private void invokeHandleOversizedMessage(ChannelHandlerContext channelHandlerContext, S s5) throws Exception {
        this.handlingOversizedMessage = true;
        this.currentMessage = null;
        try {
            handleOversizedMessage(channelHandlerContext, s5);
        } finally {
            ReferenceCountUtil.release(s5);
        }
    }

    protected abstract O beginAggregation(S s5, ByteBuf byteBuf) throws Exception;

    protected abstract boolean closeAfterContinueResponse(Object obj) throws Exception;

    protected abstract boolean ignoreContentAfterContinueResponse(Object obj) throws Exception;

    protected abstract boolean isAggregated(I i6) throws Exception;

    protected abstract boolean isContentLengthInvalid(S s5, int i6) throws Exception;

    protected abstract boolean isContentMessage(I i6) throws Exception;

    protected abstract boolean isLastContentMessage(C c6) throws Exception;

    protected abstract boolean isStartMessage(I i6) throws Exception;

    protected abstract Object newContinueResponse(S s5, int i6, ChannelPipeline channelPipeline) throws Exception;

    public final void setMaxCumulationBufferComponents(int i6) {
        if (i6 >= 2) {
            if (this.ctx != null) {
                throw new IllegalStateException("decoder properties cannot be changed once the decoder is added to a pipeline.");
            }
            this.maxCumulationBufferComponents = i6;
        } else {
            throw new IllegalArgumentException("maxCumulationBufferComponents: " + i6 + " (expected: >= 2)");
        }
    }

    private void releaseCurrentMessage() {
        O o5 = this.currentMessage;
        if (o5 != null) {
            o5.release();
            this.currentMessage = null;
            this.handlingOversizedMessage = false;
            this.aggregating = false;
        }
    }

    private static void validateMaxContentLength(int i6) {
        ObjectUtil.checkPositiveOrZero(i6, "maxContentLength");
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelReadComplete(ChannelHandlerContext channelHandlerContext) throws Exception {
        if (this.currentMessage != null && !channelHandlerContext.channel().config().isAutoRead()) {
            channelHandlerContext.read();
        }
        channelHandlerContext.fireChannelReadComplete();
    }

    protected final ChannelHandlerContext ctx() {
        ChannelHandlerContext channelHandlerContext = this.ctx;
        if (channelHandlerContext != null) {
            return channelHandlerContext;
        }
        throw new IllegalStateException("not added to a pipeline yet");
    }

    protected void handleOversizedMessage(ChannelHandlerContext channelHandlerContext, S s5) throws Exception {
        channelHandlerContext.fireExceptionCaught((Throwable) new TooLongFrameException("content length exceeded " + maxContentLength() + " bytes."));
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext channelHandlerContext) throws Exception {
        this.ctx = channelHandlerContext;
    }

    @Deprecated
    public final boolean isHandlingOversizedMessage() {
        return this.handlingOversizedMessage;
    }

    public final int maxContentLength() {
        return this.maxContentLength;
    }

    public final int maxCumulationBufferComponents() {
        return this.maxCumulationBufferComponents;
    }

    private static void appendPartialContent(CompositeByteBuf compositeByteBuf, ByteBuf byteBuf) {
        if (byteBuf.isReadable()) {
            compositeByteBuf.addComponent(true, byteBuf.retain());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.handler.codec.MessageToMessageDecoder
    public boolean acceptInboundMessage(Object obj) throws Exception {
        if (!super.acceptInboundMessage(obj) || isAggregated(obj)) {
            return false;
        }
        if (isStartMessage(obj)) {
            this.aggregating = true;
            return true;
        }
        if (!this.aggregating || !isContentMessage(obj)) {
            return false;
        }
        return true;
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelInactive(ChannelHandlerContext channelHandlerContext) throws Exception {
        try {
            super.channelInactive(channelHandlerContext);
        } finally {
            releaseCurrentMessage();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.handler.codec.MessageToMessageDecoder
    protected void decode(final ChannelHandlerContext channelHandlerContext, I i6, List<Object> list) throws Exception {
        boolean isLastContentMessage;
        ByteBufHolder beginAggregation;
        if (isStartMessage(i6)) {
            this.handlingOversizedMessage = false;
            O o5 = this.currentMessage;
            if (o5 == null) {
                Object newContinueResponse = newContinueResponse(i6, this.maxContentLength, channelHandlerContext.pipeline());
                if (newContinueResponse != null) {
                    ChannelFutureListener channelFutureListener = this.continueResponseWriteListener;
                    if (channelFutureListener == null) {
                        channelFutureListener = new ChannelFutureListener() { // from class: io.netty.handler.codec.MessageAggregator.1
                            @Override // io.netty.util.concurrent.GenericFutureListener
                            public void operationComplete(ChannelFuture channelFuture) throws Exception {
                                if (channelFuture.isSuccess()) {
                                    return;
                                }
                                channelHandlerContext.fireExceptionCaught(channelFuture.cause());
                            }
                        };
                        this.continueResponseWriteListener = channelFutureListener;
                    }
                    boolean closeAfterContinueResponse = closeAfterContinueResponse(newContinueResponse);
                    this.handlingOversizedMessage = ignoreContentAfterContinueResponse(newContinueResponse);
                    Future<Void> addListener = channelHandlerContext.writeAndFlush(newContinueResponse).addListener((GenericFutureListener<? extends Future<? super Void>>) channelFutureListener);
                    if (closeAfterContinueResponse) {
                        addListener.addListener((GenericFutureListener<? extends Future<? super Void>>) ChannelFutureListener.CLOSE);
                        return;
                    } else if (this.handlingOversizedMessage) {
                        return;
                    }
                } else if (isContentLengthInvalid(i6, this.maxContentLength)) {
                    invokeHandleOversizedMessage(channelHandlerContext, i6);
                    return;
                }
                if ((i6 instanceof DecoderResultProvider) && !((DecoderResultProvider) i6).decoderResult().isSuccess()) {
                    if (i6 instanceof ByteBufHolder) {
                        beginAggregation = beginAggregation(i6, ((ByteBufHolder) i6).content().retain());
                    } else {
                        beginAggregation = beginAggregation(i6, Unpooled.EMPTY_BUFFER);
                    }
                    finishAggregation0(beginAggregation);
                    list.add(beginAggregation);
                    return;
                }
                CompositeByteBuf compositeBuffer = channelHandlerContext.alloc().compositeBuffer(this.maxCumulationBufferComponents);
                if (i6 instanceof ByteBufHolder) {
                    appendPartialContent(compositeBuffer, ((ByteBufHolder) i6).content());
                }
                this.currentMessage = (O) beginAggregation(i6, compositeBuffer);
                return;
            }
            o5.release();
            this.currentMessage = null;
            throw new MessageAggregationException();
        }
        if (isContentMessage(i6)) {
            O o6 = this.currentMessage;
            if (o6 != null) {
                CompositeByteBuf compositeByteBuf = (CompositeByteBuf) o6.content();
                ByteBufHolder byteBufHolder = (ByteBufHolder) i6;
                if (compositeByteBuf.readableBytes() > this.maxContentLength - byteBufHolder.content().readableBytes()) {
                    invokeHandleOversizedMessage(channelHandlerContext, this.currentMessage);
                    return;
                }
                appendPartialContent(compositeByteBuf, byteBufHolder.content());
                aggregate(this.currentMessage, byteBufHolder);
                if (byteBufHolder instanceof DecoderResultProvider) {
                    DecoderResult decoderResult = ((DecoderResultProvider) byteBufHolder).decoderResult();
                    if (!decoderResult.isSuccess()) {
                        O o7 = this.currentMessage;
                        if (o7 instanceof DecoderResultProvider) {
                            ((DecoderResultProvider) o7).setDecoderResult(DecoderResult.failure(decoderResult.cause()));
                        }
                        isLastContentMessage = true;
                    } else {
                        isLastContentMessage = isLastContentMessage(byteBufHolder);
                    }
                } else {
                    isLastContentMessage = isLastContentMessage(byteBufHolder);
                }
                if (isLastContentMessage) {
                    finishAggregation0(this.currentMessage);
                    list.add(this.currentMessage);
                    this.currentMessage = null;
                    return;
                }
                return;
            }
            return;
        }
        throw new MessageAggregationException();
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerRemoved(ChannelHandlerContext channelHandlerContext) throws Exception {
        try {
            super.handlerRemoved(channelHandlerContext);
        } finally {
            releaseCurrentMessage();
        }
    }

    protected MessageAggregator(int i6, Class<? extends I> cls) {
        super(cls);
        this.maxCumulationBufferComponents = 1024;
        validateMaxContentLength(i6);
        this.maxContentLength = i6;
    }

    protected void finishAggregation(O o5) throws Exception {
    }

    protected void aggregate(O o5, C c6) throws Exception {
    }
}
