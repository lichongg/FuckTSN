package io.netty.handler.codec;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.CompositeByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.socket.ChannelInputShutdownEvent;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class ByteToMessageDecoder extends ChannelInboundHandlerAdapter {
    private static final byte STATE_CALLING_CHILD_DECODE = 1;
    private static final byte STATE_HANDLER_REMOVED_PENDING = 2;
    private static final byte STATE_INIT = 0;
    ByteBuf cumulation;
    private Cumulator cumulator = MERGE_CUMULATOR;
    private byte decodeState = 0;
    private int discardAfterReads = 16;
    private boolean firedChannelRead;
    private boolean first;
    private int numReads;
    private boolean singleDecode;
    public static final Cumulator MERGE_CUMULATOR = new Cumulator() { // from class: io.netty.handler.codec.ByteToMessageDecoder.1
        @Override // io.netty.handler.codec.ByteToMessageDecoder.Cumulator
        public ByteBuf cumulate(ByteBufAllocator byteBufAllocator, ByteBuf byteBuf, ByteBuf byteBuf2) {
            try {
                if (byteBuf.writerIndex() <= byteBuf.maxCapacity() - byteBuf2.readableBytes()) {
                    if (byteBuf.refCnt() <= 1) {
                        if (byteBuf.isReadOnly()) {
                        }
                        byteBuf.writeBytes(byteBuf2);
                        byteBuf2.release();
                        return byteBuf;
                    }
                }
                byteBuf = ByteToMessageDecoder.expandCumulation(byteBufAllocator, byteBuf, byteBuf2.readableBytes());
                byteBuf.writeBytes(byteBuf2);
                byteBuf2.release();
                return byteBuf;
            } catch (Throwable th) {
                byteBuf2.release();
                throw th;
            }
        }
    };
    public static final Cumulator COMPOSITE_CUMULATOR = new Cumulator() { // from class: io.netty.handler.codec.ByteToMessageDecoder.2
        @Override // io.netty.handler.codec.ByteToMessageDecoder.Cumulator
        public ByteBuf cumulate(ByteBufAllocator byteBufAllocator, ByteBuf byteBuf, ByteBuf byteBuf2) {
            CompositeByteBuf compositeByteBuf;
            ByteBuf byteBuf3;
            try {
                if (byteBuf.refCnt() > 1) {
                    ByteBuf expandCumulation = ByteToMessageDecoder.expandCumulation(byteBufAllocator, byteBuf, byteBuf2.readableBytes());
                    expandCumulation.writeBytes(byteBuf2);
                    byteBuf3 = expandCumulation;
                } else {
                    if (byteBuf instanceof CompositeByteBuf) {
                        compositeByteBuf = (CompositeByteBuf) byteBuf;
                    } else {
                        CompositeByteBuf compositeBuffer = byteBufAllocator.compositeBuffer(Integer.MAX_VALUE);
                        compositeBuffer.addComponent(true, byteBuf);
                        compositeByteBuf = compositeBuffer;
                    }
                    compositeByteBuf.addComponent(true, byteBuf2);
                    byteBuf2 = null;
                    byteBuf3 = compositeByteBuf;
                }
                if (byteBuf2 != null) {
                    byteBuf2.release();
                }
                return byteBuf3;
            } catch (Throwable th) {
                if (byteBuf2 != null) {
                    byteBuf2.release();
                }
                throw th;
            }
        }
    };

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface Cumulator {
        ByteBuf cumulate(ByteBufAllocator byteBufAllocator, ByteBuf byteBuf, ByteBuf byteBuf2);
    }

    private void channelInputClosed(ChannelHandlerContext channelHandlerContext, boolean z5) throws Exception {
        CodecOutputList newInstance = CodecOutputList.newInstance();
        try {
            try {
                channelInputClosed(channelHandlerContext, newInstance);
                try {
                    ByteBuf byteBuf = this.cumulation;
                    if (byteBuf != null) {
                        byteBuf.release();
                        this.cumulation = null;
                    }
                    int size = newInstance.size();
                    fireChannelRead(channelHandlerContext, newInstance, size);
                    if (size > 0) {
                        channelHandlerContext.fireChannelReadComplete();
                    }
                    if (z5) {
                        channelHandlerContext.fireChannelInactive();
                    }
                    newInstance.recycle();
                } finally {
                }
            } catch (DecoderException e6) {
                throw e6;
            } catch (Exception e7) {
                throw new DecoderException(e7);
            }
        } catch (Throwable th) {
            try {
                ByteBuf byteBuf2 = this.cumulation;
                if (byteBuf2 != null) {
                    byteBuf2.release();
                    this.cumulation = null;
                }
                int size2 = newInstance.size();
                fireChannelRead(channelHandlerContext, newInstance, size2);
                if (size2 > 0) {
                    channelHandlerContext.fireChannelReadComplete();
                }
                if (z5) {
                    channelHandlerContext.fireChannelInactive();
                }
                newInstance.recycle();
                throw th;
            } finally {
            }
        }
    }

    static void fireChannelRead(ChannelHandlerContext channelHandlerContext, List<Object> list, int i6) {
        if (list instanceof CodecOutputList) {
            fireChannelRead(channelHandlerContext, (CodecOutputList) list, i6);
            return;
        }
        for (int i7 = 0; i7 < i6; i7++) {
            channelHandlerContext.fireChannelRead(list.get(i7));
        }
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelInactive(ChannelHandlerContext channelHandlerContext) throws Exception {
        channelInputClosed(channelHandlerContext, true);
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelReadComplete(ChannelHandlerContext channelHandlerContext) throws Exception {
        this.numReads = 0;
        discardSomeReadBytes();
        if (!this.firedChannelRead && !channelHandlerContext.channel().config().isAutoRead()) {
            channelHandlerContext.read();
        }
        this.firedChannelRead = false;
        channelHandlerContext.fireChannelReadComplete();
    }

    protected abstract void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception;

    final void decodeRemovalReentryProtection(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        this.decodeState = (byte) 1;
        try {
            decode(channelHandlerContext, byteBuf, list);
        } finally {
            r0 = this.decodeState == 2;
            this.decodeState = (byte) 0;
            if (r0) {
                handlerRemoved(channelHandlerContext);
            }
        }
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
        if (!(obj instanceof ByteBuf)) {
            channelHandlerContext.fireChannelRead(obj);
            return;
        }
        CodecOutputList newInstance = CodecOutputList.newInstance();
        try {
            try {
                ByteBuf byteBuf = (ByteBuf) obj;
                boolean z5 = this.cumulation == null;
                this.first = z5;
                if (z5) {
                    this.cumulation = byteBuf;
                } else {
                    this.cumulation = this.cumulator.cumulate(channelHandlerContext.alloc(), this.cumulation, byteBuf);
                }
                callDecode(channelHandlerContext, this.cumulation, newInstance);
                ByteBuf byteBuf2 = this.cumulation;
                if (byteBuf2 == null || byteBuf2.isReadable()) {
                    int i6 = this.numReads + 1;
                    this.numReads = i6;
                    if (i6 >= this.discardAfterReads) {
                        this.numReads = 0;
                        discardSomeReadBytes();
                    }
                } else {
                    this.numReads = 0;
                    this.cumulation.release();
                    this.cumulation = null;
                }
                int size = newInstance.size();
                this.firedChannelRead |= newInstance.insertSinceRecycled();
                fireChannelRead(channelHandlerContext, newInstance, size);
                newInstance.recycle();
            } catch (DecoderException e6) {
                throw e6;
            } catch (Exception e7) {
                throw new DecoderException(e7);
            }
        } catch (Throwable th) {
            ByteBuf byteBuf3 = this.cumulation;
            if (byteBuf3 == null || byteBuf3.isReadable()) {
                int i7 = this.numReads + 1;
                this.numReads = i7;
                if (i7 >= this.discardAfterReads) {
                    this.numReads = 0;
                    discardSomeReadBytes();
                }
            } else {
                this.numReads = 0;
                this.cumulation.release();
                this.cumulation = null;
            }
            int size2 = newInstance.size();
            this.firedChannelRead |= newInstance.insertSinceRecycled();
            fireChannelRead(channelHandlerContext, newInstance, size2);
            newInstance.recycle();
            throw th;
        }
    }

    protected final void discardSomeReadBytes() {
        ByteBuf byteBuf = this.cumulation;
        if (byteBuf == null || this.first || byteBuf.refCnt() != 1) {
            return;
        }
        this.cumulation.discardSomeReadBytes();
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public final void handlerRemoved(ChannelHandlerContext channelHandlerContext) throws Exception {
        if (this.decodeState == 1) {
            this.decodeState = (byte) 2;
            return;
        }
        ByteBuf byteBuf = this.cumulation;
        if (byteBuf != null) {
            this.cumulation = null;
            this.numReads = 0;
            int readableBytes = byteBuf.readableBytes();
            if (readableBytes > 0) {
                ByteBuf readBytes = byteBuf.readBytes(readableBytes);
                byteBuf.release();
                channelHandlerContext.fireChannelRead((Object) readBytes);
                channelHandlerContext.fireChannelReadComplete();
            } else {
                byteBuf.release();
            }
        }
        handlerRemoved0(channelHandlerContext);
    }

    protected ByteBuf internalBuffer() {
        ByteBuf byteBuf = this.cumulation;
        return byteBuf != null ? byteBuf : Unpooled.EMPTY_BUFFER;
    }

    public boolean isSingleDecode() {
        return this.singleDecode;
    }

    public void setCumulator(Cumulator cumulator) {
        if (cumulator == null) {
            throw new NullPointerException("cumulator");
        }
        this.cumulator = cumulator;
    }

    public void setDiscardAfterReads(int i6) {
        ObjectUtil.checkPositive(i6, "discardAfterReads");
        this.discardAfterReads = i6;
    }

    public void setSingleDecode(boolean z5) {
        this.singleDecode = z5;
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void userEventTriggered(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
        if (obj instanceof ChannelInputShutdownEvent) {
            channelInputClosed(channelHandlerContext, false);
        }
        super.userEventTriggered(channelHandlerContext, obj);
    }

    protected ByteToMessageDecoder() {
        ensureNotSharable();
    }

    static ByteBuf expandCumulation(ByteBufAllocator byteBufAllocator, ByteBuf byteBuf, int i6) {
        ByteBuf buffer = byteBufAllocator.buffer(byteBuf.readableBytes() + i6);
        buffer.writeBytes(byteBuf);
        byteBuf.release();
        return buffer;
    }

    protected int actualReadableBytes() {
        return internalBuffer().readableBytes();
    }

    protected void callDecode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) {
        while (byteBuf.isReadable()) {
            try {
                int size = list.size();
                if (size > 0) {
                    fireChannelRead(channelHandlerContext, list, size);
                    list.clear();
                    if (!channelHandlerContext.isRemoved()) {
                        size = 0;
                    } else {
                        return;
                    }
                }
                int readableBytes = byteBuf.readableBytes();
                decodeRemovalReentryProtection(channelHandlerContext, byteBuf, list);
                if (!channelHandlerContext.isRemoved()) {
                    if (size == list.size()) {
                        if (readableBytes == byteBuf.readableBytes()) {
                            return;
                        }
                    } else if (readableBytes != byteBuf.readableBytes()) {
                        if (isSingleDecode()) {
                            return;
                        }
                    } else {
                        throw new DecoderException(StringUtil.simpleClassName(getClass()) + ".decode() did not read anything but decoded a message.");
                    }
                } else {
                    return;
                }
            } catch (DecoderException e6) {
                throw e6;
            } catch (Exception e7) {
                throw new DecoderException(e7);
            }
        }
    }

    protected void decodeLast(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        if (byteBuf.isReadable()) {
            decodeRemovalReentryProtection(channelHandlerContext, byteBuf, list);
        }
    }

    static void fireChannelRead(ChannelHandlerContext channelHandlerContext, CodecOutputList codecOutputList, int i6) {
        for (int i7 = 0; i7 < i6; i7++) {
            channelHandlerContext.fireChannelRead(codecOutputList.getUnsafe(i7));
        }
    }

    protected void handlerRemoved0(ChannelHandlerContext channelHandlerContext) throws Exception {
    }

    void channelInputClosed(ChannelHandlerContext channelHandlerContext, List<Object> list) throws Exception {
        ByteBuf byteBuf = this.cumulation;
        if (byteBuf != null) {
            callDecode(channelHandlerContext, byteBuf, list);
            decodeLast(channelHandlerContext, this.cumulation, list);
        } else {
            decodeLast(channelHandlerContext, Unpooled.EMPTY_BUFFER, list);
        }
    }
}
