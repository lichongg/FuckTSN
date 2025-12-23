package io.netty.handler.traffic;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class ChannelTrafficShapingHandler extends AbstractTrafficShapingHandler {
    private final ArrayDeque<ToSend> messagesQueue;
    private long queueSize;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class ToSend {
        final ChannelPromise promise;
        final long relativeTimeAction;
        final Object toSend;

        private ToSend(long j6, Object obj, ChannelPromise channelPromise) {
            this.relativeTimeAction = j6;
            this.toSend = obj;
            this.promise = channelPromise;
        }
    }

    public ChannelTrafficShapingHandler(long j6, long j7, long j8, long j9) {
        super(j6, j7, j8, j9);
        this.messagesQueue = new ArrayDeque<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendAllValid(ChannelHandlerContext channelHandlerContext, long j6) {
        synchronized (this) {
            try {
                ToSend pollFirst = this.messagesQueue.pollFirst();
                while (true) {
                    if (pollFirst != null) {
                        if (pollFirst.relativeTimeAction > j6) {
                            this.messagesQueue.addFirst(pollFirst);
                            break;
                        }
                        long calculateSize = calculateSize(pollFirst.toSend);
                        this.trafficCounter.bytesRealWriteFlowControl(calculateSize);
                        this.queueSize -= calculateSize;
                        channelHandlerContext.write(pollFirst.toSend, pollFirst.promise);
                        pollFirst = this.messagesQueue.pollFirst();
                    } else {
                        break;
                    }
                }
                if (this.messagesQueue.isEmpty()) {
                    releaseWriteSuspended(channelHandlerContext);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        channelHandlerContext.flush();
    }

    @Override // io.netty.handler.traffic.AbstractTrafficShapingHandler
    void submitWrite(final ChannelHandlerContext channelHandlerContext, Object obj, long j6, long j7, long j8, ChannelPromise channelPromise) {
        Throwable th;
        synchronized (this) {
            try {
                if (j7 == 0) {
                    try {
                        if (this.messagesQueue.isEmpty()) {
                            this.trafficCounter.bytesRealWriteFlowControl(j6);
                            channelHandlerContext.write(obj, channelPromise);
                            return;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        throw th;
                    }
                }
                try {
                    ToSend toSend = new ToSend(j7 + j8, obj, channelPromise);
                    this.messagesQueue.addLast(toSend);
                    long j9 = this.queueSize + j6;
                    this.queueSize = j9;
                    checkWriteSuspend(channelHandlerContext, j7, j9);
                    final long j10 = toSend.relativeTimeAction;
                    channelHandlerContext.executor().schedule(new Runnable() { // from class: io.netty.handler.traffic.ChannelTrafficShapingHandler.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ChannelTrafficShapingHandler.this.sendAllValid(channelHandlerContext, j10);
                        }
                    }, j7, TimeUnit.MILLISECONDS);
                } catch (Throwable th3) {
                    th = th3;
                    th = th;
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
            }
        }
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext channelHandlerContext) throws Exception {
        TrafficCounter trafficCounter = new TrafficCounter(this, channelHandlerContext.executor(), "ChannelTC" + channelHandlerContext.channel().hashCode(), this.checkInterval);
        setTrafficCounter(trafficCounter);
        trafficCounter.start();
        super.handlerAdded(channelHandlerContext);
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerRemoved(ChannelHandlerContext channelHandlerContext) throws Exception {
        this.trafficCounter.stop();
        synchronized (this) {
            try {
                if (channelHandlerContext.channel().isActive()) {
                    Iterator<ToSend> it = this.messagesQueue.iterator();
                    while (it.hasNext()) {
                        ToSend next = it.next();
                        long calculateSize = calculateSize(next.toSend);
                        this.trafficCounter.bytesRealWriteFlowControl(calculateSize);
                        this.queueSize -= calculateSize;
                        channelHandlerContext.write(next.toSend, next.promise);
                    }
                } else {
                    Iterator<ToSend> it2 = this.messagesQueue.iterator();
                    while (it2.hasNext()) {
                        Object obj = it2.next().toSend;
                        if (obj instanceof ByteBuf) {
                            ((ByteBuf) obj).release();
                        }
                    }
                }
                this.messagesQueue.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
        releaseWriteSuspended(channelHandlerContext);
        releaseReadSuspended(channelHandlerContext);
        super.handlerRemoved(channelHandlerContext);
    }

    public long queueSize() {
        return this.queueSize;
    }

    public ChannelTrafficShapingHandler(long j6, long j7, long j8) {
        super(j6, j7, j8);
        this.messagesQueue = new ArrayDeque<>();
    }

    public ChannelTrafficShapingHandler(long j6, long j7) {
        super(j6, j7);
        this.messagesQueue = new ArrayDeque<>();
    }

    public ChannelTrafficShapingHandler(long j6) {
        super(j6);
        this.messagesQueue = new ArrayDeque<>();
    }
}
