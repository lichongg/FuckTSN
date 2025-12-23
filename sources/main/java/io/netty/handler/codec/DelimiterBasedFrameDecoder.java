package io.netty.handler.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.internal.ObjectUtil;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class DelimiterBasedFrameDecoder extends ByteToMessageDecoder {
    private final ByteBuf[] delimiters;
    private boolean discardingTooLongFrame;
    private final boolean failFast;
    private final LineBasedFrameDecoder lineBasedDecoder;
    private final int maxFrameLength;
    private final boolean stripDelimiter;
    private int tooLongFrameLength;

    public DelimiterBasedFrameDecoder(int i6, ByteBuf byteBuf) {
        this(i6, true, byteBuf);
    }

    private static boolean isLineBased(ByteBuf[] byteBufArr) {
        if (byteBufArr.length != 2) {
            return false;
        }
        ByteBuf byteBuf = byteBufArr[0];
        ByteBuf byteBuf2 = byteBufArr[1];
        if (byteBuf.capacity() < byteBuf2.capacity()) {
            byteBuf = byteBufArr[1];
            byteBuf2 = byteBufArr[0];
        }
        return byteBuf.capacity() == 2 && byteBuf2.capacity() == 1 && byteBuf.getByte(0) == 13 && byteBuf.getByte(1) == 10 && byteBuf2.getByte(0) == 10;
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder
    protected final void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        Object decode = decode(channelHandlerContext, byteBuf);
        if (decode != null) {
            list.add(decode);
        }
    }

    public DelimiterBasedFrameDecoder(int i6, boolean z5, ByteBuf byteBuf) {
        this(i6, z5, true, byteBuf);
    }

    private void fail(long j6) {
        if (j6 <= 0) {
            throw new TooLongFrameException("frame length exceeds " + this.maxFrameLength + " - discarding");
        }
        throw new TooLongFrameException("frame length exceeds " + this.maxFrameLength + ": " + j6 + " - discarded");
    }

    private static void validateDelimiter(ByteBuf byteBuf) {
        if (byteBuf == null) {
            throw new NullPointerException("delimiter");
        }
        if (!byteBuf.isReadable()) {
            throw new IllegalArgumentException("empty delimiter");
        }
    }

    private static void validateMaxFrameLength(int i6) {
        ObjectUtil.checkPositive(i6, "maxFrameLength");
    }

    public DelimiterBasedFrameDecoder(int i6, boolean z5, boolean z6, ByteBuf byteBuf) {
        this(i6, z5, z6, byteBuf.slice(byteBuf.readerIndex(), byteBuf.readableBytes()));
    }

    private static int indexOf(ByteBuf byteBuf, ByteBuf byteBuf2) {
        for (int readerIndex = byteBuf.readerIndex(); readerIndex < byteBuf.writerIndex(); readerIndex++) {
            int i6 = 0;
            int i7 = readerIndex;
            while (i6 < byteBuf2.capacity() && byteBuf.getByte(i7) == byteBuf2.getByte(i6)) {
                i7++;
                if (i7 == byteBuf.writerIndex() && i6 != byteBuf2.capacity() - 1) {
                    return -1;
                }
                i6++;
            }
            if (i6 == byteBuf2.capacity()) {
                return readerIndex - byteBuf.readerIndex();
            }
        }
        return -1;
    }

    private boolean isSubclass() {
        if (getClass() != DelimiterBasedFrameDecoder.class) {
            return true;
        }
        return false;
    }

    protected Object decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) throws Exception {
        LineBasedFrameDecoder lineBasedFrameDecoder = this.lineBasedDecoder;
        if (lineBasedFrameDecoder != null) {
            return lineBasedFrameDecoder.decode(channelHandlerContext, byteBuf);
        }
        int i6 = Integer.MAX_VALUE;
        ByteBuf byteBuf2 = null;
        for (ByteBuf byteBuf3 : this.delimiters) {
            int indexOf = indexOf(byteBuf, byteBuf3);
            if (indexOf >= 0 && indexOf < i6) {
                byteBuf2 = byteBuf3;
                i6 = indexOf;
            }
        }
        if (byteBuf2 != null) {
            int capacity = byteBuf2.capacity();
            if (this.discardingTooLongFrame) {
                this.discardingTooLongFrame = false;
                byteBuf.skipBytes(i6 + capacity);
                int i7 = this.tooLongFrameLength;
                this.tooLongFrameLength = 0;
                if (!this.failFast) {
                    fail(i7);
                }
                return null;
            }
            if (i6 > this.maxFrameLength) {
                byteBuf.skipBytes(capacity + i6);
                fail(i6);
                return null;
            }
            if (this.stripDelimiter) {
                ByteBuf readRetainedSlice = byteBuf.readRetainedSlice(i6);
                byteBuf.skipBytes(capacity);
                return readRetainedSlice;
            }
            return byteBuf.readRetainedSlice(i6 + capacity);
        }
        if (!this.discardingTooLongFrame) {
            if (byteBuf.readableBytes() > this.maxFrameLength) {
                this.tooLongFrameLength = byteBuf.readableBytes();
                byteBuf.skipBytes(byteBuf.readableBytes());
                this.discardingTooLongFrame = true;
                if (this.failFast) {
                    fail(this.tooLongFrameLength);
                }
            }
        } else {
            this.tooLongFrameLength += byteBuf.readableBytes();
            byteBuf.skipBytes(byteBuf.readableBytes());
        }
        return null;
    }

    public DelimiterBasedFrameDecoder(int i6, ByteBuf... byteBufArr) {
        this(i6, true, byteBufArr);
    }

    public DelimiterBasedFrameDecoder(int i6, boolean z5, ByteBuf... byteBufArr) {
        this(i6, z5, true, byteBufArr);
    }

    public DelimiterBasedFrameDecoder(int i6, boolean z5, boolean z6, ByteBuf... byteBufArr) {
        validateMaxFrameLength(i6);
        if (byteBufArr != null) {
            if (byteBufArr.length != 0) {
                if (isLineBased(byteBufArr) && !isSubclass()) {
                    this.lineBasedDecoder = new LineBasedFrameDecoder(i6, z5, z6);
                    this.delimiters = null;
                } else {
                    this.delimiters = new ByteBuf[byteBufArr.length];
                    for (int i7 = 0; i7 < byteBufArr.length; i7++) {
                        ByteBuf byteBuf = byteBufArr[i7];
                        validateDelimiter(byteBuf);
                        this.delimiters[i7] = byteBuf.slice(byteBuf.readerIndex(), byteBuf.readableBytes());
                    }
                    this.lineBasedDecoder = null;
                }
                this.maxFrameLength = i6;
                this.stripDelimiter = z5;
                this.failFast = z6;
                return;
            }
            throw new IllegalArgumentException("empty delimiters");
        }
        throw new NullPointerException("delimiters");
    }
}
