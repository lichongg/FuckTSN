package io.netty.channel.unix;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import java.nio.ByteBuffer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class IovArray implements ChannelOutboundBuffer.MessageProcessor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int ADDRESS_SIZE;
    private static final int CAPACITY;
    private static final int IOV_SIZE;
    private int count;
    private long maxBytes = Limits.SSIZE_MAX;
    private final ByteBuffer memory;
    private final long memoryAddress;
    private long size;

    public boolean add(ByteBuf byteBuf) {
        if (this.count == Limits.IOV_MAX) {
            return false;
        }
        if (byteBuf.nioBufferCount() == 1) {
            int readableBytes = byteBuf.readableBytes();
            if (readableBytes == 0) {
                return true;
            }
            if (byteBuf.hasMemoryAddress()) {
                return add(byteBuf.memoryAddress(), byteBuf.readerIndex(), readableBytes);
            }
            ByteBuffer internalNioBuffer = byteBuf.internalNioBuffer(byteBuf.readerIndex(), readableBytes);
            return add(Buffer.memoryAddress(internalNioBuffer), internalNioBuffer.position(), readableBytes);
        }
        for (ByteBuffer byteBuffer : byteBuf.nioBuffers()) {
            int remaining = byteBuffer.remaining();
            if (remaining != 0 && (!add(Buffer.memoryAddress(byteBuffer), byteBuffer.position(), remaining) || this.count == Limits.IOV_MAX)) {
                return false;
            }
        }
        return true;
    }

    public void clear() {
        this.count = 0;
        this.size = 0L;
    }

    public void maxBytes(long j6) {
        this.maxBytes = Math.min(Limits.SSIZE_MAX, ObjectUtil.checkPositive(j6, "maxBytes"));
    }

    private static int idx(int i6) {
        return IOV_SIZE * i6;
    }

    public int count() {
        return this.count;
    }

    public long maxBytes() {
        return this.maxBytes;
    }

    public long memoryAddress(int i6) {
        return this.memoryAddress + idx(i6);
    }

    @Override // io.netty.channel.ChannelOutboundBuffer.MessageProcessor
    public boolean processMessage(Object obj) throws Exception {
        return (obj instanceof ByteBuf) && add((ByteBuf) obj);
    }

    public void release() {
        Buffer.free(this.memory);
    }

    public long size() {
        return this.size;
    }

    static {
        int addressSize = Buffer.addressSize();
        ADDRESS_SIZE = addressSize;
        int i6 = addressSize * 2;
        IOV_SIZE = i6;
        CAPACITY = Limits.IOV_MAX * i6;
    }

    public IovArray() {
        ByteBuffer allocateDirectWithNativeOrder = Buffer.allocateDirectWithNativeOrder(CAPACITY);
        this.memory = allocateDirectWithNativeOrder;
        this.memoryAddress = Buffer.memoryAddress(allocateDirectWithNativeOrder);
    }

    private boolean add(long j6, int i6, int i7) {
        long j7 = i7;
        if (this.maxBytes - j7 < this.size && this.count > 0) {
            return false;
        }
        int idx = idx(this.count);
        int i8 = ADDRESS_SIZE;
        int i9 = idx + i8;
        this.size += j7;
        this.count++;
        if (i8 == 8) {
            if (PlatformDependent.hasUnsafe()) {
                PlatformDependent.putLong(idx + this.memoryAddress, j6 + i6);
                PlatformDependent.putLong(i9 + this.memoryAddress, j7);
            } else {
                this.memory.putLong(idx, j6 + i6);
                this.memory.putLong(i9, j7);
            }
        } else if (PlatformDependent.hasUnsafe()) {
            PlatformDependent.putInt(idx + this.memoryAddress, ((int) j6) + i6);
            PlatformDependent.putInt(i9 + this.memoryAddress, i7);
        } else {
            this.memory.putInt(idx, ((int) j6) + i6);
            this.memory.putInt(i9, i7);
        }
        return true;
    }
}
