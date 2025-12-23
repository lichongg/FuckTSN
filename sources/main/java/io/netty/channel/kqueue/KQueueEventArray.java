package io.netty.channel.kqueue;

import io.netty.channel.unix.Buffer;
import io.netty.util.internal.PlatformDependent;
import java.nio.ByteBuffer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class KQueueEventArray {
    private int capacity;
    private ByteBuffer memory;
    private long memoryAddress;
    private int size;
    private static final int KQUEUE_EVENT_SIZE = Native.sizeofKEvent();
    private static final int KQUEUE_IDENT_OFFSET = Native.offsetofKEventIdent();
    private static final int KQUEUE_FILTER_OFFSET = Native.offsetofKEventFilter();
    private static final int KQUEUE_FFLAGS_OFFSET = Native.offsetofKEventFFlags();
    private static final int KQUEUE_FLAGS_OFFSET = Native.offsetofKEventFlags();
    private static final int KQUEUE_DATA_OFFSET = Native.offsetofKeventData();

    private static native void evSet(long j6, int i6, short s5, short s6, int i7);

    void clear() {
        this.size = 0;
    }

    void evSet(AbstractKQueueChannel abstractKQueueChannel, short s5, short s6, int i6) {
        reallocIfNeeded();
        this.size = this.size + 1;
        evSet(getKEventOffset(r0) + this.memoryAddress, abstractKQueueChannel.socket.intValue(), s5, s6, i6);
    }

    private static int calculateBufferCapacity(int i6) {
        return i6 * KQUEUE_EVENT_SIZE;
    }

    private static int getKEventOffset(int i6) {
        return i6 * KQUEUE_EVENT_SIZE;
    }

    private void reallocIfNeeded() {
        if (this.size == this.capacity) {
            realloc(true);
        }
    }

    int capacity() {
        return this.capacity;
    }

    short fflags(int i6) {
        return getShort(i6, KQUEUE_FFLAGS_OFFSET);
    }

    short filter(int i6) {
        return getShort(i6, KQUEUE_FILTER_OFFSET);
    }

    short flags(int i6) {
        return getShort(i6, KQUEUE_FLAGS_OFFSET);
    }

    void free() {
        Buffer.free(this.memory);
        this.capacity = 0;
        this.size = 0;
        this.memoryAddress = 0;
    }

    long memoryAddress() {
        return this.memoryAddress;
    }

    void realloc(boolean z5) {
        int i6 = this.capacity;
        int i7 = i6 <= 65536 ? i6 << 1 : (i6 + i6) >> 1;
        try {
            ByteBuffer allocateDirectWithNativeOrder = Buffer.allocateDirectWithNativeOrder(calculateBufferCapacity(i7));
            this.memory.position(0).limit(this.size);
            allocateDirectWithNativeOrder.put(this.memory);
            allocateDirectWithNativeOrder.position(0);
            Buffer.free(this.memory);
            this.memory = allocateDirectWithNativeOrder;
            this.memoryAddress = Buffer.memoryAddress(allocateDirectWithNativeOrder);
        } catch (OutOfMemoryError e6) {
            if (z5) {
                OutOfMemoryError outOfMemoryError = new OutOfMemoryError("unable to allocate " + i7 + " new bytes! Existing capacity is: " + this.capacity);
                outOfMemoryError.initCause(e6);
                throw outOfMemoryError;
            }
        }
    }

    int size() {
        return this.size;
    }

    KQueueEventArray(int i6) {
        if (i6 >= 1) {
            ByteBuffer allocateDirectWithNativeOrder = Buffer.allocateDirectWithNativeOrder(calculateBufferCapacity(i6));
            this.memory = allocateDirectWithNativeOrder;
            this.memoryAddress = Buffer.memoryAddress(allocateDirectWithNativeOrder);
            this.capacity = i6;
            return;
        }
        throw new IllegalArgumentException("capacity must be >= 1 but was " + i6);
    }

    private long getKEventOffsetAddress(int i6) {
        return getKEventOffset(i6) + this.memoryAddress;
    }

    private short getShort(int i6, int i7) {
        if (PlatformDependent.hasUnsafe()) {
            return PlatformDependent.getShort(getKEventOffsetAddress(i6) + i7);
        }
        return this.memory.getShort(getKEventOffset(i6) + i7);
    }

    long data(int i6) {
        if (PlatformDependent.hasUnsafe()) {
            return PlatformDependent.getLong(getKEventOffsetAddress(i6) + KQUEUE_DATA_OFFSET);
        }
        return this.memory.getLong(getKEventOffset(i6) + KQUEUE_DATA_OFFSET);
    }

    int fd(int i6) {
        if (PlatformDependent.hasUnsafe()) {
            return PlatformDependent.getInt(getKEventOffsetAddress(i6) + KQUEUE_IDENT_OFFSET);
        }
        return this.memory.getInt(getKEventOffset(i6) + KQUEUE_IDENT_OFFSET);
    }
}
