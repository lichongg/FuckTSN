package io.netty.handler.flow;

import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.Recycler;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.ArrayDeque;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class FlowControlHandler extends ChannelDuplexHandler {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) FlowControlHandler.class);
    private ChannelConfig config;
    private RecyclableArrayDeque queue;
    private final boolean releaseMessages;
    private boolean shouldConsume;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: io.netty.handler.flow.FlowControlHandler$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class RecyclableArrayDeque extends ArrayDeque<Object> {
        private static final int DEFAULT_NUM_ELEMENTS = 2;
        private static final Recycler<RecyclableArrayDeque> RECYCLER = new Recycler<RecyclableArrayDeque>() { // from class: io.netty.handler.flow.FlowControlHandler.RecyclableArrayDeque.1
            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // io.netty.util.Recycler
            public RecyclableArrayDeque newObject(Recycler.Handle<RecyclableArrayDeque> handle) {
                return new RecyclableArrayDeque(2, handle, null);
            }
        };
        private static final long serialVersionUID = 0;
        private final Recycler.Handle<RecyclableArrayDeque> handle;

        /* synthetic */ RecyclableArrayDeque(int i6, Recycler.Handle handle, AnonymousClass1 anonymousClass1) {
            this(i6, handle);
        }

        private RecyclableArrayDeque(int i6, Recycler.Handle<RecyclableArrayDeque> handle) {
            super(i6);
            this.handle = handle;
        }

        public static RecyclableArrayDeque newInstance() {
            return RECYCLER.get();
        }

        public void recycle() {
            clear();
            this.handle.recycle(this);
        }
    }

    public FlowControlHandler() {
        this(true);
    }

    private int dequeue(ChannelHandlerContext channelHandlerContext, int i6) {
        Object poll;
        int i7 = 0;
        while (this.queue != null && ((i7 < i6 || this.config.isAutoRead()) && (poll = this.queue.poll()) != null)) {
            i7++;
            channelHandlerContext.fireChannelRead(poll);
        }
        RecyclableArrayDeque recyclableArrayDeque = this.queue;
        if (recyclableArrayDeque != null && recyclableArrayDeque.isEmpty()) {
            this.queue.recycle();
            this.queue = null;
            if (i7 > 0) {
                channelHandlerContext.fireChannelReadComplete();
            }
        }
        return i7;
    }

    @Override // io.netty.channel.ChannelDuplexHandler, io.netty.channel.ChannelOutboundHandler
    public void read(ChannelHandlerContext channelHandlerContext) throws Exception {
        if (dequeue(channelHandlerContext, 1) == 0) {
            this.shouldConsume = true;
            channelHandlerContext.read();
        }
    }

    public FlowControlHandler(boolean z5) {
        this.releaseMessages = z5;
    }

    private void destroy() {
        RecyclableArrayDeque recyclableArrayDeque = this.queue;
        if (recyclableArrayDeque != null) {
            if (!recyclableArrayDeque.isEmpty()) {
                logger.trace("Non-empty queue: {}", this.queue);
                if (this.releaseMessages) {
                    while (true) {
                        Object poll = this.queue.poll();
                        if (poll == null) {
                            break;
                        } else {
                            ReferenceCountUtil.safeRelease(poll);
                        }
                    }
                }
            }
            this.queue.recycle();
            this.queue = null;
        }
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
        if (this.queue == null) {
            this.queue = RecyclableArrayDeque.newInstance();
        }
        this.queue.offer(obj);
        boolean z5 = this.shouldConsume;
        this.shouldConsume = false;
        dequeue(channelHandlerContext, z5 ? 1 : 0);
    }

    boolean isQueueEmpty() {
        RecyclableArrayDeque recyclableArrayDeque = this.queue;
        return recyclableArrayDeque == null || recyclableArrayDeque.isEmpty();
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelInactive(ChannelHandlerContext channelHandlerContext) throws Exception {
        destroy();
        channelHandlerContext.fireChannelInactive();
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext channelHandlerContext) throws Exception {
        this.config = channelHandlerContext.channel().config();
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelReadComplete(ChannelHandlerContext channelHandlerContext) throws Exception {
    }
}
