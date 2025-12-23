package io.netty.handler.codec.spdy;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import java.nio.ByteOrder;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class SpdyFrameEncoder {
    private final int version;

    private void writeControlFrameHeader(ByteBuf byteBuf, int i6, byte b6, int i7) {
        byteBuf.writeShort(this.version | 32768);
        byteBuf.writeShort(i6);
        byteBuf.writeByte(b6);
        byteBuf.writeMedium(i7);
    }

    public ByteBuf encodeGoAwayFrame(ByteBufAllocator byteBufAllocator, int i6, int i7) {
        ByteBuf order = byteBufAllocator.ioBuffer(16).order(ByteOrder.BIG_ENDIAN);
        writeControlFrameHeader(order, 7, (byte) 0, 8);
        order.writeInt(i6);
        order.writeInt(i7);
        return order;
    }

    public ByteBuf encodePingFrame(ByteBufAllocator byteBufAllocator, int i6) {
        ByteBuf order = byteBufAllocator.ioBuffer(12).order(ByteOrder.BIG_ENDIAN);
        writeControlFrameHeader(order, 6, (byte) 0, 4);
        order.writeInt(i6);
        return order;
    }

    public ByteBuf encodeRstStreamFrame(ByteBufAllocator byteBufAllocator, int i6, int i7) {
        ByteBuf order = byteBufAllocator.ioBuffer(16).order(ByteOrder.BIG_ENDIAN);
        writeControlFrameHeader(order, 3, (byte) 0, 8);
        order.writeInt(i6);
        order.writeInt(i7);
        return order;
    }

    public ByteBuf encodeWindowUpdateFrame(ByteBufAllocator byteBufAllocator, int i6, int i7) {
        ByteBuf order = byteBufAllocator.ioBuffer(16).order(ByteOrder.BIG_ENDIAN);
        writeControlFrameHeader(order, 9, (byte) 0, 8);
        order.writeInt(i6);
        order.writeInt(i7);
        return order;
    }

    public SpdyFrameEncoder(SpdyVersion spdyVersion) {
        if (spdyVersion != null) {
            this.version = spdyVersion.getVersion();
            return;
        }
        throw new NullPointerException("spdyVersion");
    }

    public ByteBuf encodeDataFrame(ByteBufAllocator byteBufAllocator, int i6, boolean z5, ByteBuf byteBuf) {
        int readableBytes = byteBuf.readableBytes();
        ByteBuf order = byteBufAllocator.ioBuffer(readableBytes + 8).order(ByteOrder.BIG_ENDIAN);
        order.writeInt(i6 & Integer.MAX_VALUE);
        order.writeByte(z5 ? 1 : 0);
        order.writeMedium(readableBytes);
        order.writeBytes(byteBuf, byteBuf.readerIndex(), readableBytes);
        return order;
    }

    public ByteBuf encodeHeadersFrame(ByteBufAllocator byteBufAllocator, int i6, boolean z5, ByteBuf byteBuf) {
        int readableBytes = byteBuf.readableBytes();
        ByteBuf order = byteBufAllocator.ioBuffer(readableBytes + 12).order(ByteOrder.BIG_ENDIAN);
        writeControlFrameHeader(order, 8, z5 ? (byte) 1 : (byte) 0, readableBytes + 4);
        order.writeInt(i6);
        order.writeBytes(byteBuf, byteBuf.readerIndex(), readableBytes);
        return order;
    }

    public ByteBuf encodeSettingsFrame(ByteBufAllocator byteBufAllocator, SpdySettingsFrame spdySettingsFrame) {
        byte b6;
        Set<Integer> ids = spdySettingsFrame.ids();
        int size = ids.size();
        boolean clearPreviouslyPersistedSettings = spdySettingsFrame.clearPreviouslyPersistedSettings();
        int i6 = size * 8;
        ByteBuf order = byteBufAllocator.ioBuffer(i6 + 12).order(ByteOrder.BIG_ENDIAN);
        writeControlFrameHeader(order, 4, clearPreviouslyPersistedSettings ? (byte) 1 : (byte) 0, i6 + 4);
        order.writeInt(size);
        for (Integer num : ids) {
            if (spdySettingsFrame.isPersistValue(num.intValue())) {
                b6 = (byte) 1;
            } else {
                b6 = 0;
            }
            if (spdySettingsFrame.isPersisted(num.intValue())) {
                b6 = (byte) (b6 | 2);
            }
            order.writeByte(b6);
            order.writeMedium(num.intValue());
            order.writeInt(spdySettingsFrame.getValue(num.intValue()));
        }
        return order;
    }

    public ByteBuf encodeSynReplyFrame(ByteBufAllocator byteBufAllocator, int i6, boolean z5, ByteBuf byteBuf) {
        int readableBytes = byteBuf.readableBytes();
        ByteBuf order = byteBufAllocator.ioBuffer(readableBytes + 12).order(ByteOrder.BIG_ENDIAN);
        writeControlFrameHeader(order, 2, z5 ? (byte) 1 : (byte) 0, readableBytes + 4);
        order.writeInt(i6);
        order.writeBytes(byteBuf, byteBuf.readerIndex(), readableBytes);
        return order;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ByteBuf encodeSynStreamFrame(ByteBufAllocator byteBufAllocator, int i6, int i7, byte b6, boolean z5, boolean z6, ByteBuf byteBuf) {
        int readableBytes = byteBuf.readableBytes();
        byte b7 = z5;
        if (z6) {
            b7 = (byte) (z5 | 2);
        }
        ByteBuf order = byteBufAllocator.ioBuffer(readableBytes + 18).order(ByteOrder.BIG_ENDIAN);
        writeControlFrameHeader(order, 1, b7, readableBytes + 10);
        order.writeInt(i6);
        order.writeInt(i7);
        order.writeShort((b6 & 255) << 13);
        order.writeBytes(byteBuf, byteBuf.readerIndex(), readableBytes);
        return order;
    }
}
