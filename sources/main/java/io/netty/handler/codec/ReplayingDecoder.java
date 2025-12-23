package io.netty.handler.codec;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.Signal;
import io.netty.util.internal.StringUtil;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class ReplayingDecoder<S> extends ByteToMessageDecoder {
    static final Signal REPLAY = Signal.valueOf(ReplayingDecoder.class, "REPLAY");
    private int checkpoint;
    private final ReplayingDecoderByteBuf replayable;
    private S state;

    protected ReplayingDecoder() {
        this(null);
    }

    protected void checkpoint() {
        this.checkpoint = internalBuffer().readerIndex();
    }

    protected S state() {
        return this.state;
    }

    protected ReplayingDecoder(S s5) {
        this.replayable = new ReplayingDecoderByteBuf();
        this.checkpoint = -1;
        this.state = s5;
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder
    protected void callDecode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) {
        int i6;
        this.replayable.setCumulation(byteBuf);
        while (byteBuf.isReadable()) {
            try {
                int readerIndex = byteBuf.readerIndex();
                this.checkpoint = readerIndex;
                int size = list.size();
                if (size > 0) {
                    ByteToMessageDecoder.fireChannelRead(channelHandlerContext, list, size);
                    list.clear();
                    if (channelHandlerContext.isRemoved()) {
                        return;
                    } else {
                        size = 0;
                    }
                }
                S s5 = this.state;
                int readableBytes = byteBuf.readableBytes();
                try {
                    decodeRemovalReentryProtection(channelHandlerContext, this.replayable, list);
                    if (channelHandlerContext.isRemoved()) {
                        return;
                    }
                    if (size != list.size()) {
                        if (readerIndex == byteBuf.readerIndex() && s5 == this.state) {
                            throw new DecoderException(StringUtil.simpleClassName(getClass()) + ".decode() method must consume the inbound data or change its state if it decoded something.");
                        }
                        if (isSingleDecode()) {
                            return;
                        }
                    } else if (readableBytes == byteBuf.readableBytes() && s5 == this.state) {
                        throw new DecoderException(StringUtil.simpleClassName(getClass()) + ".decode() must consume the inbound data or change its state if it did not decode anything.");
                    }
                } catch (Signal e6) {
                    e6.expect(REPLAY);
                    if (!channelHandlerContext.isRemoved() && (i6 = this.checkpoint) >= 0) {
                        byteBuf.readerIndex(i6);
                        return;
                    }
                    return;
                }
            } catch (DecoderException e7) {
                throw e7;
            } catch (Exception e8) {
                throw new DecoderException(e8);
            }
        }
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder
    final void channelInputClosed(ChannelHandlerContext channelHandlerContext, List<Object> list) throws Exception {
        try {
            this.replayable.terminate();
            if (this.cumulation != null) {
                callDecode(channelHandlerContext, internalBuffer(), list);
            } else {
                this.replayable.setCumulation(Unpooled.EMPTY_BUFFER);
            }
            decodeLast(channelHandlerContext, this.replayable, list);
        } catch (Signal e6) {
            e6.expect(REPLAY);
        }
    }

    protected void checkpoint(S s5) {
        checkpoint();
        state(s5);
    }

    protected S state(S s5) {
        S s6 = this.state;
        this.state = s5;
        return s6;
    }
}
