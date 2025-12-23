package io.netty.handler.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.internal.ObjectUtil;
import java.nio.ByteOrder;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@ChannelHandler.Sharable
/* loaded from: D:\Downloads\app\classes7.dex */
public class LengthFieldPrepender extends MessageToMessageEncoder<ByteBuf> {
    private final ByteOrder byteOrder;
    private final int lengthAdjustment;
    private final int lengthFieldLength;
    private final boolean lengthIncludesLengthFieldLength;

    public LengthFieldPrepender(int i6) {
        this(i6, false);
    }

    @Override // io.netty.handler.codec.MessageToMessageEncoder
    protected /* bridge */ /* synthetic */ void encode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List list) throws Exception {
        encode2(channelHandlerContext, byteBuf, (List<Object>) list);
    }

    public LengthFieldPrepender(int i6, boolean z5) {
        this(i6, 0, z5);
    }

    /* renamed from: encode, reason: avoid collision after fix types in other method */
    protected void encode2(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        int readableBytes = byteBuf.readableBytes() + this.lengthAdjustment;
        if (this.lengthIncludesLengthFieldLength) {
            readableBytes += this.lengthFieldLength;
        }
        ObjectUtil.checkPositiveOrZero(readableBytes, "length");
        int i6 = this.lengthFieldLength;
        if (i6 != 1) {
            if (i6 != 2) {
                if (i6 != 3) {
                    if (i6 == 4) {
                        list.add(channelHandlerContext.alloc().buffer(4).order(this.byteOrder).writeInt(readableBytes));
                    } else {
                        if (i6 != 8) {
                            throw new Error("should not reach here");
                        }
                        list.add(channelHandlerContext.alloc().buffer(8).order(this.byteOrder).writeLong(readableBytes));
                    }
                } else {
                    if (readableBytes >= 16777216) {
                        throw new IllegalArgumentException("length does not fit into a medium integer: " + readableBytes);
                    }
                    list.add(channelHandlerContext.alloc().buffer(3).order(this.byteOrder).writeMedium(readableBytes));
                }
            } else {
                if (readableBytes >= 65536) {
                    throw new IllegalArgumentException("length does not fit into a short integer: " + readableBytes);
                }
                list.add(channelHandlerContext.alloc().buffer(2).order(this.byteOrder).writeShort((short) readableBytes));
            }
        } else {
            if (readableBytes >= 256) {
                throw new IllegalArgumentException("length does not fit into a byte: " + readableBytes);
            }
            list.add(channelHandlerContext.alloc().buffer(1).order(this.byteOrder).writeByte((byte) readableBytes));
        }
        list.add(byteBuf.retain());
    }

    public LengthFieldPrepender(int i6, int i7) {
        this(i6, i7, false);
    }

    public LengthFieldPrepender(int i6, int i7, boolean z5) {
        this(ByteOrder.BIG_ENDIAN, i6, i7, z5);
    }

    public LengthFieldPrepender(ByteOrder byteOrder, int i6, int i7, boolean z5) {
        if (i6 != 1 && i6 != 2 && i6 != 3 && i6 != 4 && i6 != 8) {
            throw new IllegalArgumentException("lengthFieldLength must be either 1, 2, 3, 4, or 8: " + i6);
        }
        ObjectUtil.checkNotNull(byteOrder, "byteOrder");
        this.byteOrder = byteOrder;
        this.lengthFieldLength = i6;
        this.lengthIncludesLengthFieldLength = z5;
        this.lengthAdjustment = i7;
    }
}
