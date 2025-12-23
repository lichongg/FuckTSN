package io.netty.handler.flush;

import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import java.util.concurrent.Future;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class FlushConsolidationHandler extends ChannelDuplexHandler {
    public static final int DEFAULT_EXPLICIT_FLUSH_AFTER_FLUSHES = 256;
    private final boolean consolidateWhenNoReadInProgress;
    private ChannelHandlerContext ctx;
    private final int explicitFlushAfterFlushes;
    private int flushPendingCount;
    private final Runnable flushTask;
    private Future<?> nextScheduledFlush;
    private boolean readInProgress;

    public FlushConsolidationHandler() {
        this(256, false);
    }

    private void resetReadAndFlushIfNeeded(ChannelHandlerContext channelHandlerContext) {
        this.readInProgress = false;
        flushIfNeeded(channelHandlerContext);
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
        this.readInProgress = true;
        channelHandlerContext.fireChannelRead(obj);
    }

    public FlushConsolidationHandler(int i6) {
        this(i6, false);
    }

    private void cancelScheduledFlush() {
        Future<?> future = this.nextScheduledFlush;
        if (future != null) {
            future.cancel(false);
            this.nextScheduledFlush = null;
        }
    }

    private void flushIfNeeded(ChannelHandlerContext channelHandlerContext) {
        if (this.flushPendingCount > 0) {
            flushNow(channelHandlerContext);
        }
    }

    private void scheduleFlush(ChannelHandlerContext channelHandlerContext) {
        if (this.nextScheduledFlush == null) {
            this.nextScheduledFlush = channelHandlerContext.channel().eventLoop().submit(this.flushTask);
        }
    }

    @Override // io.netty.channel.ChannelDuplexHandler, io.netty.channel.ChannelOutboundHandler
    public void flush(ChannelHandlerContext channelHandlerContext) throws Exception {
        if (this.readInProgress) {
            int i6 = this.flushPendingCount + 1;
            this.flushPendingCount = i6;
            if (i6 == this.explicitFlushAfterFlushes) {
                flushNow(channelHandlerContext);
                return;
            }
            return;
        }
        if (!this.consolidateWhenNoReadInProgress) {
            flushNow(channelHandlerContext);
            return;
        }
        int i7 = this.flushPendingCount + 1;
        this.flushPendingCount = i7;
        if (i7 == this.explicitFlushAfterFlushes) {
            flushNow(channelHandlerContext);
        } else {
            scheduleFlush(channelHandlerContext);
        }
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext channelHandlerContext) throws Exception {
        this.ctx = channelHandlerContext;
    }

    public FlushConsolidationHandler(int i6, boolean z5) {
        if (i6 > 0) {
            this.explicitFlushAfterFlushes = i6;
            this.consolidateWhenNoReadInProgress = z5;
            this.flushTask = z5 ? new Runnable() { // from class: io.netty.handler.flush.FlushConsolidationHandler.1
                @Override // java.lang.Runnable
                public void run() {
                    if (FlushConsolidationHandler.this.flushPendingCount <= 0 || FlushConsolidationHandler.this.readInProgress) {
                        return;
                    }
                    FlushConsolidationHandler.this.flushPendingCount = 0;
                    FlushConsolidationHandler.this.ctx.flush();
                    FlushConsolidationHandler.this.nextScheduledFlush = null;
                }
            } : null;
        } else {
            throw new IllegalArgumentException("explicitFlushAfterFlushes: " + i6 + " (expected: > 0)");
        }
    }

    private void flushNow(ChannelHandlerContext channelHandlerContext) {
        cancelScheduledFlush();
        this.flushPendingCount = 0;
        channelHandlerContext.flush();
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelReadComplete(ChannelHandlerContext channelHandlerContext) throws Exception {
        resetReadAndFlushIfNeeded(channelHandlerContext);
        channelHandlerContext.fireChannelReadComplete();
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelWritabilityChanged(ChannelHandlerContext channelHandlerContext) throws Exception {
        if (!channelHandlerContext.channel().isWritable()) {
            flushIfNeeded(channelHandlerContext);
        }
        channelHandlerContext.fireChannelWritabilityChanged();
    }

    @Override // io.netty.channel.ChannelDuplexHandler, io.netty.channel.ChannelOutboundHandler
    public void close(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) throws Exception {
        resetReadAndFlushIfNeeded(channelHandlerContext);
        channelHandlerContext.close(channelPromise);
    }

    @Override // io.netty.channel.ChannelDuplexHandler, io.netty.channel.ChannelOutboundHandler
    public void disconnect(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) throws Exception {
        resetReadAndFlushIfNeeded(channelHandlerContext);
        channelHandlerContext.disconnect(channelPromise);
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler, io.netty.channel.ChannelInboundHandler
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th) throws Exception {
        resetReadAndFlushIfNeeded(channelHandlerContext);
        channelHandlerContext.fireExceptionCaught(th);
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerRemoved(ChannelHandlerContext channelHandlerContext) throws Exception {
        flushIfNeeded(channelHandlerContext);
    }
}
