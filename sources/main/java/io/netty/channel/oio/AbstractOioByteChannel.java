package io.netty.channel.oio;

import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.FileRegion;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.socket.ChannelInputShutdownEvent;
import io.netty.channel.socket.ChannelInputShutdownReadComplete;
import io.netty.util.internal.StringUtil;
import java.io.IOException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class AbstractOioByteChannel extends AbstractOioChannel {
    private static final ChannelMetadata METADATA = new ChannelMetadata(false);
    private static final String EXPECTED_TYPES = " (expected: " + StringUtil.simpleClassName((Class<?>) ByteBuf.class) + ", " + StringUtil.simpleClassName((Class<?>) FileRegion.class) + ')';

    protected abstract int available();

    protected abstract int doReadBytes(ByteBuf byteBuf) throws Exception;

    protected abstract void doWriteBytes(ByteBuf byteBuf) throws Exception;

    protected abstract void doWriteFileRegion(FileRegion fileRegion) throws Exception;

    protected abstract boolean isInputShutdown();

    protected abstract ChannelFuture shutdownInput();

    private void handleReadException(ChannelPipeline channelPipeline, ByteBuf byteBuf, Throwable th, boolean z5, RecvByteBufAllocator.Handle handle) {
        if (byteBuf != null) {
            if (byteBuf.isReadable()) {
                this.readPending = false;
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

    @Override // io.netty.channel.AbstractChannel
    protected final Object filterOutboundMessage(Object obj) throws Exception {
        if (obj instanceof ByteBuf) {
            return obj;
        }
        if (obj instanceof FileRegion) {
            return obj;
        }
        throw new UnsupportedOperationException("unsupported message type: " + StringUtil.simpleClassName(obj) + EXPECTED_TYPES);
    }

    @Override // io.netty.channel.Channel
    public ChannelMetadata metadata() {
        return METADATA;
    }

    protected AbstractOioByteChannel(Channel channel) {
        super(channel);
    }

    private void closeOnRead(ChannelPipeline channelPipeline) {
        if (isOpen()) {
            if (Boolean.TRUE.equals(config().getOption(ChannelOption.ALLOW_HALF_CLOSURE))) {
                shutdownInput();
                channelPipeline.fireUserEventTriggered((Object) ChannelInputShutdownEvent.INSTANCE);
            } else {
                unsafe().close(unsafe().voidPromise());
            }
            channelPipeline.fireUserEventTriggered((Object) ChannelInputShutdownReadComplete.INSTANCE);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:101:0x004e, code lost:
    
        r11.readPending = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x005b, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x005c, code lost:
    
        r5 = null;
        r2 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x006d, code lost:
    
        r6 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0065, code lost:
    
        r9 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0051, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0052, code lost:
    
        r5 = r3;
        r2 = r6;
        r7 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x003f, code lost:
    
        if (r5.isReadable() != false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0041, code lost:
    
        r5.release();
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0048, code lost:
    
        if (r8.lastBytesRead() >= 0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x004b, code lost:
    
        r9 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x004c, code lost:
    
        if (r9 == false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0059, code lost:
    
        r5 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00ee A[DONT_GENERATE] */
    @Override // io.netty.channel.oio.AbstractOioChannel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void doRead() {
        /*
            Method dump skipped, instructions count: 280
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.channel.oio.AbstractOioByteChannel.doRead():void");
    }

    @Override // io.netty.channel.AbstractChannel
    protected void doWrite(ChannelOutboundBuffer channelOutboundBuffer) throws Exception {
        while (true) {
            Object current = channelOutboundBuffer.current();
            if (current == null) {
                return;
            }
            if (current instanceof ByteBuf) {
                ByteBuf byteBuf = (ByteBuf) current;
                int readableBytes = byteBuf.readableBytes();
                while (readableBytes > 0) {
                    doWriteBytes(byteBuf);
                    int readableBytes2 = byteBuf.readableBytes();
                    channelOutboundBuffer.progress(readableBytes - readableBytes2);
                    readableBytes = readableBytes2;
                }
                channelOutboundBuffer.remove();
            } else if (current instanceof FileRegion) {
                FileRegion fileRegion = (FileRegion) current;
                long transferred = fileRegion.transferred();
                doWriteFileRegion(fileRegion);
                channelOutboundBuffer.progress(fileRegion.transferred() - transferred);
                channelOutboundBuffer.remove();
            } else {
                channelOutboundBuffer.remove(new UnsupportedOperationException("unsupported message type: " + StringUtil.simpleClassName(current)));
            }
        }
    }
}
