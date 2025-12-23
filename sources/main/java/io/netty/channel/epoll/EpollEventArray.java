package io.netty.channel.epoll;

import io.netty.channel.unix.Buffer;
import io.netty.util.internal.PlatformDependent;
import java.nio.ByteBuffer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class EpollEventArray {
    private int length;
    private ByteBuffer memory;
    private long memoryAddress;
    private static final int EPOLL_EVENT_SIZE = Native.sizeofEpollEvent();
    private static final int EPOLL_DATA_OFFSET = Native.offsetofEpollData();

    int events(int i6) {
        return getInt(i6, 0);
    }

    private static int calculateBufferCapacity(int i6) {
        return i6 * EPOLL_EVENT_SIZE;
    }

    int fd(int i6) {
        return getInt(i6, EPOLL_DATA_OFFSET);
    }

    void free() {
        Buffer.free(this.memory);
        this.memoryAddress = 0L;
    }

    void increase() {
        int i6 = this.length << 1;
        this.length = i6;
        ByteBuffer allocateDirectWithNativeOrder = Buffer.allocateDirectWithNativeOrder(calculateBufferCapacity(i6));
        Buffer.free(this.memory);
        this.memory = allocateDirectWithNativeOrder;
        this.memoryAddress = Buffer.memoryAddress(allocateDirectWithNativeOrder);
    }

    int length() {
        return this.length;
    }

    long memoryAddress() {
        return this.memoryAddress;
    }

    EpollEventArray(int i6) {
        if (i6 >= 1) {
            this.length = i6;
            ByteBuffer allocateDirectWithNativeOrder = Buffer.allocateDirectWithNativeOrder(calculateBufferCapacity(i6));
            this.memory = allocateDirectWithNativeOrder;
            this.memoryAddress = Buffer.memoryAddress(allocateDirectWithNativeOrder);
            return;
        }
        throw new IllegalArgumentException("length must be >= 1 but was " + i6);
    }

    private int getInt(int i6, int i7) {
        if (PlatformDependent.hasUnsafe()) {
            return PlatformDependent.getInt(this.memoryAddress + (i6 * EPOLL_EVENT_SIZE) + i7);
        }
        return this.memory.getInt((i6 * EPOLL_EVENT_SIZE) + i7);
    }
}
