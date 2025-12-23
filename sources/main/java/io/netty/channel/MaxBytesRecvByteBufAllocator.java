package io.netty.channel;

import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface MaxBytesRecvByteBufAllocator extends RecvByteBufAllocator {
    int maxBytesPerIndividualRead();

    MaxBytesRecvByteBufAllocator maxBytesPerIndividualRead(int i6);

    int maxBytesPerRead();

    MaxBytesRecvByteBufAllocator maxBytesPerRead(int i6);

    MaxBytesRecvByteBufAllocator maxBytesPerReadPair(int i6, int i7);

    Map.Entry<Integer, Integer> maxBytesPerReadPair();
}
