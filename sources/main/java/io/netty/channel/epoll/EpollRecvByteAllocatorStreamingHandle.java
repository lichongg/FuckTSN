package io.netty.channel.epoll;

import io.netty.channel.RecvByteBufAllocator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class EpollRecvByteAllocatorStreamingHandle extends EpollRecvByteAllocatorHandle {
    EpollRecvByteAllocatorStreamingHandle(RecvByteBufAllocator.ExtendedHandle extendedHandle) {
        super(extendedHandle);
    }

    @Override // io.netty.channel.epoll.EpollRecvByteAllocatorHandle
    boolean maybeMoreDataToRead() {
        if (lastBytesRead() != attemptedBytesRead() && !isReceivedRdHup()) {
            return false;
        }
        return true;
    }
}
