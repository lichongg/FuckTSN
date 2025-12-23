package io.netty.handler.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.internal.ObjectUtil;
import java.nio.ByteOrder;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class LengthFieldBasedFrameDecoder extends ByteToMessageDecoder {
    private final ByteOrder byteOrder;
    private long bytesToDiscard;
    private boolean discardingTooLongFrame;
    private final boolean failFast;
    private final int initialBytesToStrip;
    private final int lengthAdjustment;
    private final int lengthFieldEndOffset;
    private final int lengthFieldLength;
    private final int lengthFieldOffset;
    private final int maxFrameLength;
    private long tooLongFrameLength;

    public LengthFieldBasedFrameDecoder(int i6, int i7, int i8) {
        this(i6, i7, i8, 0, 0);
    }

    private static void failOnFrameLengthLessThanInitialBytesToStrip(ByteBuf byteBuf, long j6, int i6) {
        byteBuf.skipBytes((int) j6);
        throw new CorruptedFrameException("Adjusted frame length (" + j6 + ") is less than initialBytesToStrip: " + i6);
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder
    protected final void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        Object decode = decode(channelHandlerContext, byteBuf);
        if (decode != null) {
            list.add(decode);
        }
    }

    public LengthFieldBasedFrameDecoder(int i6, int i7, int i8, int i9, int i10) {
        this(i6, i7, i8, i9, i10, true);
    }

    private void discardingTooLongFrame(ByteBuf byteBuf) {
        long j6 = this.bytesToDiscard;
        int min = (int) Math.min(j6, byteBuf.readableBytes());
        byteBuf.skipBytes(min);
        this.bytesToDiscard = j6 - min;
        failIfNecessary(false);
    }

    private void fail(long j6) {
        if (j6 <= 0) {
            throw new TooLongFrameException("Adjusted frame length exceeds " + this.maxFrameLength + " - discarding");
        }
        throw new TooLongFrameException("Adjusted frame length exceeds " + this.maxFrameLength + ": " + j6 + " - discarded");
    }

    private void failIfNecessary(boolean z5) {
        if (this.bytesToDiscard != 0) {
            if (this.failFast && z5) {
                fail(this.tooLongFrameLength);
                return;
            }
            return;
        }
        long j6 = this.tooLongFrameLength;
        this.tooLongFrameLength = 0L;
        this.discardingTooLongFrame = false;
        if (!this.failFast || z5) {
            fail(j6);
        }
    }

    public LengthFieldBasedFrameDecoder(int i6, int i7, int i8, int i9, int i10, boolean z5) {
        this(ByteOrder.BIG_ENDIAN, i6, i7, i8, i9, i10, z5);
    }

    private void exceededFrameLength(ByteBuf byteBuf, long j6) {
        long readableBytes = j6 - byteBuf.readableBytes();
        this.tooLongFrameLength = j6;
        if (readableBytes < 0) {
            byteBuf.skipBytes((int) j6);
        } else {
            this.discardingTooLongFrame = true;
            this.bytesToDiscard = readableBytes;
            byteBuf.skipBytes(byteBuf.readableBytes());
        }
        failIfNecessary(true);
    }

    private static void failOnFrameLengthLessThanLengthFieldEndOffset(ByteBuf byteBuf, long j6, int i6) {
        byteBuf.skipBytes(i6);
        throw new CorruptedFrameException("Adjusted frame length (" + j6 + ") is less than lengthFieldEndOffset: " + i6);
    }

    private static void failOnNegativeLengthField(ByteBuf byteBuf, long j6, int i6) {
        byteBuf.skipBytes(i6);
        throw new CorruptedFrameException("negative pre-adjustment length field: " + j6);
    }

    protected Object decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) throws Exception {
        if (this.discardingTooLongFrame) {
            discardingTooLongFrame(byteBuf);
        }
        if (byteBuf.readableBytes() < this.lengthFieldEndOffset) {
            return null;
        }
        long unadjustedFrameLength = getUnadjustedFrameLength(byteBuf, byteBuf.readerIndex() + this.lengthFieldOffset, this.lengthFieldLength, this.byteOrder);
        if (unadjustedFrameLength < 0) {
            failOnNegativeLengthField(byteBuf, unadjustedFrameLength, this.lengthFieldEndOffset);
        }
        int i6 = this.lengthAdjustment;
        int i7 = this.lengthFieldEndOffset;
        long j6 = unadjustedFrameLength + i6 + i7;
        if (j6 < i7) {
            failOnFrameLengthLessThanLengthFieldEndOffset(byteBuf, j6, i7);
        }
        if (j6 > this.maxFrameLength) {
            exceededFrameLength(byteBuf, j6);
            return null;
        }
        int i8 = (int) j6;
        if (byteBuf.readableBytes() < i8) {
            return null;
        }
        int i9 = this.initialBytesToStrip;
        if (i9 > i8) {
            failOnFrameLengthLessThanInitialBytesToStrip(byteBuf, j6, i9);
        }
        byteBuf.skipBytes(this.initialBytesToStrip);
        int readerIndex = byteBuf.readerIndex();
        int i10 = i8 - this.initialBytesToStrip;
        ByteBuf extractFrame = extractFrame(channelHandlerContext, byteBuf, readerIndex, i10);
        byteBuf.readerIndex(readerIndex + i10);
        return extractFrame;
    }

    protected ByteBuf extractFrame(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, int i6, int i7) {
        return byteBuf.retainedSlice(i6, i7);
    }

    protected long getUnadjustedFrameLength(ByteBuf byteBuf, int i6, int i7, ByteOrder byteOrder) {
        int unsignedByte;
        ByteBuf order = byteBuf.order(byteOrder);
        if (i7 != 1) {
            if (i7 != 2) {
                if (i7 != 3) {
                    if (i7 != 4) {
                        if (i7 == 8) {
                            return order.getLong(i6);
                        }
                        throw new DecoderException("unsupported lengthFieldLength: " + this.lengthFieldLength + " (expected: 1, 2, 3, 4, or 8)");
                    }
                    return order.getUnsignedInt(i6);
                }
                unsignedByte = order.getUnsignedMedium(i6);
            } else {
                unsignedByte = order.getUnsignedShort(i6);
            }
        } else {
            unsignedByte = order.getUnsignedByte(i6);
        }
        return unsignedByte;
    }

    public LengthFieldBasedFrameDecoder(ByteOrder byteOrder, int i6, int i7, int i8, int i9, int i10, boolean z5) {
        if (byteOrder != null) {
            ObjectUtil.checkPositive(i6, "maxFrameLength");
            ObjectUtil.checkPositiveOrZero(i7, "lengthFieldOffset");
            ObjectUtil.checkPositiveOrZero(i10, "initialBytesToStrip");
            if (i7 <= i6 - i8) {
                this.byteOrder = byteOrder;
                this.maxFrameLength = i6;
                this.lengthFieldOffset = i7;
                this.lengthFieldLength = i8;
                this.lengthAdjustment = i9;
                this.lengthFieldEndOffset = i7 + i8;
                this.initialBytesToStrip = i10;
                this.failFast = z5;
                return;
            }
            throw new IllegalArgumentException("maxFrameLength (" + i6 + ") must be equal to or greater than lengthFieldOffset (" + i7 + ") + lengthFieldLength (" + i8 + ").");
        }
        throw new NullPointerException("byteOrder");
    }
}
