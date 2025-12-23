package io.netty.channel.nio;

import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.FileRegion;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.nio.AbstractNioChannel;
import io.netty.channel.socket.ChannelInputShutdownEvent;
import io.netty.channel.socket.ChannelInputShutdownReadComplete;
import io.netty.channel.socket.SocketChannelConfig;
import io.netty.util.internal.StringUtil;
import java.io.IOException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class AbstractNioByteChannel extends AbstractNioChannel {
    private final Runnable flushTask;
    private boolean inputClosedSeenErrorOnRead;
    private static final ChannelMetadata METADATA = new ChannelMetadata(false, 16);
    private static final String EXPECTED_TYPES = " (expected: " + StringUtil.simpleClassName((Class<?>) ByteBuf.class) + ", " + StringUtil.simpleClassName((Class<?>) FileRegion.class) + ')';

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class NioByteUnsafe extends AbstractNioChannel.AbstractNioUnsafe {
        protected NioByteUnsafe() {
            super();
        }

        private void closeOnRead(ChannelPipeline channelPipeline) {
            if (AbstractNioByteChannel.this.isInputShutdown0()) {
                AbstractNioByteChannel.this.inputClosedSeenErrorOnRead = true;
                channelPipeline.fireUserEventTriggered((Object) ChannelInputShutdownReadComplete.INSTANCE);
            } else if (!AbstractNioByteChannel.isAllowHalfClosure(AbstractNioByteChannel.this.config())) {
                close(voidPromise());
            } else {
                AbstractNioByteChannel.this.shutdownInput();
                channelPipeline.fireUserEventTriggered((Object) ChannelInputShutdownEvent.INSTANCE);
            }
        }

        private void handleReadException(ChannelPipeline channelPipeline, ByteBuf byteBuf, Throwable th, boolean z5, RecvByteBufAllocator.Handle handle) {
            if (byteBuf != null) {
                if (byteBuf.isReadable()) {
                    AbstractNioByteChannel.this.readPending = false;
                    channelPipeline.fireChannelRead((Object) byteBuf);
                } else {
                    byteBuf.release();
                }
            }
            handle.readComplete();
            channelPipeline.fireChannelReadComplete();
            channelPipeline.fireExceptionCaught(th);
            if (z5 || (th instanceof IOException)) {
                closeOnRead(channelPipeline);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:0x006e, code lost:
        
            r7.readComplete();
            r3.fireChannelReadComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x0074, code lost:
        
            if (r2 == false) goto L36;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x0076, code lost:
        
            closeOnRead(r3);
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x0083, code lost:
        
            if (r9.this$0.readPending != false) goto L42;
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x0089, code lost:
        
            if (r1.isAutoRead() != false) goto L42;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x008b, code lost:
        
            removeReadOp();
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x008e, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:?, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x007a, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x007b, code lost:
        
            r5 = r0;
            r6 = r2;
            r2 = r9;
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x003b, code lost:
        
            r5.release();
         */
        /* JADX WARN: Code restructure failed: missing block: B:53:0x0042, code lost:
        
            if (r7.lastBytesRead() >= 0) goto L15;
         */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x0045, code lost:
        
            r8 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x0046, code lost:
        
            if (r8 == false) goto L21;
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x0052, code lost:
        
            r2 = r8;
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x0048, code lost:
        
            r9.this$0.readPending = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:60:0x004d, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:61:0x004e, code lost:
        
            r2 = r9;
            r5 = r0;
            r6 = r8;
         */
        /* JADX WARN: Removed duplicated region for block: B:35:0x009a A[DONT_GENERATE] */
        /* JADX WARN: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
        @Override // io.netty.channel.nio.AbstractNioChannel.NioUnsafe
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void read() {
            /*
                r9 = this;
                io.netty.channel.nio.AbstractNioByteChannel r0 = io.netty.channel.nio.AbstractNioByteChannel.this
                io.netty.channel.ChannelConfig r1 = r0.config()
                io.netty.channel.nio.AbstractNioByteChannel r0 = io.netty.channel.nio.AbstractNioByteChannel.this
                boolean r0 = r0.shouldBreakReadReady(r1)
                if (r0 == 0) goto L14
                io.netty.channel.nio.AbstractNioByteChannel r0 = io.netty.channel.nio.AbstractNioByteChannel.this
                r0.clearReadPending()
                return
            L14:
                io.netty.channel.nio.AbstractNioByteChannel r0 = io.netty.channel.nio.AbstractNioByteChannel.this
                io.netty.channel.ChannelPipeline r3 = r0.pipeline()
                io.netty.buffer.ByteBufAllocator r0 = r1.getAllocator()
                io.netty.channel.RecvByteBufAllocator$Handle r7 = r9.recvBufAllocHandle()
                r7.reset(r1)
            L25:
                r2 = 0
                r4 = 0
                io.netty.buffer.ByteBuf r5 = r7.allocate(r0)     // Catch: java.lang.Throwable -> L54
                io.netty.channel.nio.AbstractNioByteChannel r6 = io.netty.channel.nio.AbstractNioByteChannel.this     // Catch: java.lang.Throwable -> L59
                int r6 = r6.doReadBytes(r5)     // Catch: java.lang.Throwable -> L59
                r7.lastBytesRead(r6)     // Catch: java.lang.Throwable -> L59
                int r6 = r7.lastBytesRead()     // Catch: java.lang.Throwable -> L59
                r8 = 1
                if (r6 > 0) goto L5e
                r5.release()     // Catch: java.lang.Throwable -> L59
                int r0 = r7.lastBytesRead()     // Catch: java.lang.Throwable -> L54
                if (r0 >= 0) goto L45
                goto L46
            L45:
                r8 = 0
            L46:
                if (r8 == 0) goto L52
                io.netty.channel.nio.AbstractNioByteChannel r0 = io.netty.channel.nio.AbstractNioByteChannel.this     // Catch: java.lang.Throwable -> L4d
                r0.readPending = r2     // Catch: java.lang.Throwable -> L4d
                goto L52
            L4d:
                r0 = move-exception
                r2 = r9
                r5 = r0
                r6 = r8
                goto L91
            L52:
                r2 = r8
                goto L6e
            L54:
                r0 = move-exception
                r6 = 0
                r2 = r9
            L57:
                r5 = r0
                goto L91
            L59:
                r0 = move-exception
                r2 = r9
                r4 = r5
                r6 = 0
                goto L57
            L5e:
                r7.incMessagesRead(r8)     // Catch: java.lang.Throwable -> L59
                io.netty.channel.nio.AbstractNioByteChannel r6 = io.netty.channel.nio.AbstractNioByteChannel.this     // Catch: java.lang.Throwable -> L59
                r6.readPending = r2     // Catch: java.lang.Throwable -> L59
                r3.fireChannelRead(r5)     // Catch: java.lang.Throwable -> L59
                boolean r5 = r7.continueReading()     // Catch: java.lang.Throwable -> L54
                if (r5 != 0) goto L25
            L6e:
                r7.readComplete()     // Catch: java.lang.Throwable -> L7a
                r3.fireChannelReadComplete()     // Catch: java.lang.Throwable -> L7a
                if (r2 == 0) goto L7f
                r9.closeOnRead(r3)     // Catch: java.lang.Throwable -> L7a
                goto L7f
            L7a:
                r0 = move-exception
                r5 = r0
                r6 = r2
                r2 = r9
                goto L91
            L7f:
                io.netty.channel.nio.AbstractNioByteChannel r0 = io.netty.channel.nio.AbstractNioByteChannel.this
                boolean r0 = r0.readPending
                if (r0 != 0) goto L8f
                boolean r0 = r1.isAutoRead()
                if (r0 != 0) goto L8f
                r9.removeReadOp()
                return
            L8f:
                r2 = r9
                goto La3
            L91:
                r2.handleReadException(r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> La4
                io.netty.channel.nio.AbstractNioByteChannel r0 = io.netty.channel.nio.AbstractNioByteChannel.this
                boolean r0 = r0.readPending
                if (r0 != 0) goto La3
                boolean r0 = r1.isAutoRead()
                if (r0 != 0) goto La3
                r9.removeReadOp()
            La3:
                return
            La4:
                r0 = move-exception
                io.netty.channel.nio.AbstractNioByteChannel r3 = io.netty.channel.nio.AbstractNioByteChannel.this
                boolean r3 = r3.readPending
                if (r3 != 0) goto Lb4
                boolean r1 = r1.isAutoRead()
                if (r1 != 0) goto Lb4
                r9.removeReadOp()
            Lb4:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: io.netty.channel.nio.AbstractNioByteChannel.NioByteUnsafe.read():void");
        }
    }

    protected AbstractNioByteChannel(Channel channel, SelectableChannel selectableChannel) {
        super(channel, selectableChannel, 1);
        this.flushTask = new Runnable() { // from class: io.netty.channel.nio.AbstractNioByteChannel.1
            @Override // java.lang.Runnable
            public void run() {
                ((AbstractNioChannel.AbstractNioUnsafe) AbstractNioByteChannel.this.unsafe()).flush0();
            }
        };
    }

    protected abstract int doReadBytes(ByteBuf byteBuf) throws Exception;

    protected abstract int doWriteBytes(ByteBuf byteBuf) throws Exception;

    protected abstract long doWriteFileRegion(FileRegion fileRegion) throws Exception;

    protected boolean isInputShutdown0() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract ChannelFuture shutdownInput();

    private int doWriteInternal(ChannelOutboundBuffer channelOutboundBuffer, Object obj) throws Exception {
        if (obj instanceof ByteBuf) {
            ByteBuf byteBuf = (ByteBuf) obj;
            if (!byteBuf.isReadable()) {
                channelOutboundBuffer.remove();
                return 0;
            }
            int doWriteBytes = doWriteBytes(byteBuf);
            if (doWriteBytes <= 0) {
                return Integer.MAX_VALUE;
            }
            channelOutboundBuffer.progress(doWriteBytes);
            if (!byteBuf.isReadable()) {
                channelOutboundBuffer.remove();
            }
            return 1;
        }
        if (!(obj instanceof FileRegion)) {
            throw new Error();
        }
        FileRegion fileRegion = (FileRegion) obj;
        if (fileRegion.transferred() >= fileRegion.count()) {
            channelOutboundBuffer.remove();
            return 0;
        }
        long doWriteFileRegion = doWriteFileRegion(fileRegion);
        if (doWriteFileRegion <= 0) {
            return Integer.MAX_VALUE;
        }
        channelOutboundBuffer.progress(doWriteFileRegion);
        if (fileRegion.transferred() >= fileRegion.count()) {
            channelOutboundBuffer.remove();
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isAllowHalfClosure(ChannelConfig channelConfig) {
        return (channelConfig instanceof SocketChannelConfig) && ((SocketChannelConfig) channelConfig).isAllowHalfClosure();
    }

    @Override // io.netty.channel.AbstractChannel
    protected final Object filterOutboundMessage(Object obj) {
        if (obj instanceof ByteBuf) {
            ByteBuf byteBuf = (ByteBuf) obj;
            return byteBuf.isDirect() ? obj : newDirectBuffer(byteBuf);
        }
        if (obj instanceof FileRegion) {
            return obj;
        }
        throw new UnsupportedOperationException("unsupported message type: " + StringUtil.simpleClassName(obj) + EXPECTED_TYPES);
    }

    protected final void incompleteWrite(boolean z5) {
        if (z5) {
            setOpWrite();
        } else {
            clearOpWrite();
            eventLoop().execute(this.flushTask);
        }
    }

    @Override // io.netty.channel.Channel
    public ChannelMetadata metadata() {
        return METADATA;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.channel.AbstractChannel
    public AbstractNioChannel.AbstractNioUnsafe newUnsafe() {
        return new NioByteUnsafe();
    }

    protected final void clearOpWrite() {
        SelectionKey selectionKey = selectionKey();
        if (selectionKey.isValid()) {
            int interestOps = selectionKey.interestOps();
            if ((interestOps & 4) != 0) {
                selectionKey.interestOps(interestOps & (-5));
            }
        }
    }

    @Override // io.netty.channel.AbstractChannel
    protected void doWrite(ChannelOutboundBuffer channelOutboundBuffer) throws Exception {
        boolean z5;
        int writeSpinCount = config().getWriteSpinCount();
        do {
            Object current = channelOutboundBuffer.current();
            if (current == null) {
                clearOpWrite();
                return;
            }
            writeSpinCount -= doWriteInternal(channelOutboundBuffer, current);
        } while (writeSpinCount > 0);
        if (writeSpinCount < 0) {
            z5 = true;
        } else {
            z5 = false;
        }
        incompleteWrite(z5);
    }

    protected final int doWrite0(ChannelOutboundBuffer channelOutboundBuffer) throws Exception {
        if (channelOutboundBuffer.current() == null) {
            return 0;
        }
        return doWriteInternal(channelOutboundBuffer, channelOutboundBuffer.current());
    }

    protected final void setOpWrite() {
        SelectionKey selectionKey = selectionKey();
        if (selectionKey.isValid()) {
            int interestOps = selectionKey.interestOps();
            if ((interestOps & 4) == 0) {
                selectionKey.interestOps(interestOps | 4);
            }
        }
    }

    final boolean shouldBreakReadReady(ChannelConfig channelConfig) {
        if (isInputShutdown0()) {
            if (this.inputClosedSeenErrorOnRead || !isAllowHalfClosure(channelConfig)) {
                return true;
            }
            return false;
        }
        return false;
    }
}
