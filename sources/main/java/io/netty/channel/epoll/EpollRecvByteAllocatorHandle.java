package io.netty.channel.epoll;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.unix.PreferredDirectByteBufAllocator;
import io.netty.util.UncheckedBooleanSupplier;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
class EpollRecvByteAllocatorHandle extends RecvByteBufAllocator.DelegatingHandle implements RecvByteBufAllocator.ExtendedHandle {
    private final UncheckedBooleanSupplier defaultMaybeMoreDataSupplier;
    private boolean isEdgeTriggered;
    private final PreferredDirectByteBufAllocator preferredDirectByteBufAllocator;
    private boolean receivedRdHup;

    @Override // io.netty.channel.RecvByteBufAllocator.ExtendedHandle
    public final boolean continueReading(UncheckedBooleanSupplier uncheckedBooleanSupplier) {
        return ((RecvByteBufAllocator.ExtendedHandle) delegate()).continueReading(uncheckedBooleanSupplier);
    }

    final void receivedRdHup() {
        this.receivedRdHup = true;
    }

    @Override // io.netty.channel.RecvByteBufAllocator.DelegatingHandle, io.netty.channel.RecvByteBufAllocator.Handle
    public final ByteBuf allocate(ByteBufAllocator byteBufAllocator) {
        this.preferredDirectByteBufAllocator.updateAllocator(byteBufAllocator);
        return delegate().allocate(this.preferredDirectByteBufAllocator);
    }

    @Override // io.netty.channel.RecvByteBufAllocator.DelegatingHandle, io.netty.channel.RecvByteBufAllocator.Handle
    public final boolean continueReading() {
        return continueReading(this.defaultMaybeMoreDataSupplier);
    }

    final void edgeTriggered(boolean z5) {
        this.isEdgeTriggered = z5;
    }

    final boolean isEdgeTriggered() {
        return this.isEdgeTriggered;
    }

    final boolean isReceivedRdHup() {
        return this.receivedRdHup;
    }

    boolean maybeMoreDataToRead() {
        if (!this.isEdgeTriggered || lastBytesRead() <= 0) {
            return !this.isEdgeTriggered && lastBytesRead() == attemptedBytesRead();
        }
        return true;
    }

    EpollRecvByteAllocatorHandle(RecvByteBufAllocator.ExtendedHandle extendedHandle) {
        super(extendedHandle);
        this.preferredDirectByteBufAllocator = new PreferredDirectByteBufAllocator();
        this.defaultMaybeMoreDataSupplier = new UncheckedBooleanSupplier() { // from class: io.netty.channel.epoll.EpollRecvByteAllocatorHandle.1
            @Override // io.netty.util.UncheckedBooleanSupplier, io.netty.util.BooleanSupplier
            public boolean get() {
                return EpollRecvByteAllocatorHandle.this.maybeMoreDataToRead();
            }
        };
    }
}
