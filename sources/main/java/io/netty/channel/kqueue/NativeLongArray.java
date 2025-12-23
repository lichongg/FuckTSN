package io.netty.channel.kqueue;

import io.netty.channel.unix.Buffer;
import io.netty.channel.unix.Limits;
import io.netty.util.internal.PlatformDependent;
import java.nio.ByteBuffer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class NativeLongArray {
    private int capacity;
    private ByteBuffer memory;
    private long memoryAddress;
    private int size;

    void clear() {
        this.size = 0;
    }

    private static int calculateBufferCapacity(int i6) {
        return i6 * Limits.SIZEOF_JLONG;
    }

    private static int idx(int i6) {
        return i6 * Limits.SIZEOF_JLONG;
    }

    private long memoryOffset(int i6) {
        return this.memoryAddress + idx(i6);
    }

    private void reallocIfNeeded() {
        int i6 = this.size;
        int i7 = this.capacity;
        if (i6 == i7) {
            int i8 = i7 <= 65536 ? i7 << 1 : (i7 + i7) >> 1;
            ByteBuffer allocateDirectWithNativeOrder = Buffer.allocateDirectWithNativeOrder(calculateBufferCapacity(i8));
            this.memory.position(0).limit(this.size);
            allocateDirectWithNativeOrder.put(this.memory);
            allocateDirectWithNativeOrder.position(0);
            Buffer.free(this.memory);
            this.memory = allocateDirectWithNativeOrder;
            this.memoryAddress = Buffer.memoryAddress(allocateDirectWithNativeOrder);
            this.capacity = i8;
        }
    }

    void free() {
        Buffer.free(this.memory);
        this.memoryAddress = 0L;
    }

    boolean isEmpty() {
        return this.size == 0;
    }

    long memoryAddress() {
        return this.memoryAddress;
    }

    long memoryAddressEnd() {
        return memoryOffset(this.size);
    }

    int size() {
        return this.size;
    }

    public String toString() {
        return "memoryAddress: " + this.memoryAddress + " capacity: " + this.capacity + " size: " + this.size;
    }

    NativeLongArray(int i6) {
        if (i6 >= 1) {
            ByteBuffer allocateDirectWithNativeOrder = Buffer.allocateDirectWithNativeOrder(calculateBufferCapacity(i6));
            this.memory = allocateDirectWithNativeOrder;
            this.memoryAddress = Buffer.memoryAddress(allocateDirectWithNativeOrder);
            this.capacity = i6;
            return;
        }
        throw new IllegalArgumentException("capacity must be >= 1 but was " + i6);
    }

    void add(long j6) {
        reallocIfNeeded();
        if (PlatformDependent.hasUnsafe()) {
            PlatformDependent.putLong(memoryOffset(this.size), j6);
        } else {
            this.memory.putLong(idx(this.size), j6);
        }
        this.size++;
    }
}
