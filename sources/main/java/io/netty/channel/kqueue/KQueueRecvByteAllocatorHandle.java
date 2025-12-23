package io.netty.channel.kqueue;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelConfig;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.unix.PreferredDirectByteBufAllocator;
import io.netty.util.UncheckedBooleanSupplier;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class KQueueRecvByteAllocatorHandle extends RecvByteBufAllocator.DelegatingHandle implements RecvByteBufAllocator.ExtendedHandle {
    private final UncheckedBooleanSupplier defaultMaybeMoreDataSupplier;
    private long numberBytesPending;
    private boolean overrideGuess;
    private final PreferredDirectByteBufAllocator preferredDirectByteBufAllocator;
    private boolean readEOF;

    @Override // io.netty.channel.RecvByteBufAllocator.ExtendedHandle
    public boolean continueReading(UncheckedBooleanSupplier uncheckedBooleanSupplier) {
        return ((RecvByteBufAllocator.ExtendedHandle) delegate()).continueReading(uncheckedBooleanSupplier);
    }

    void readEOF() {
        this.readEOF = true;
    }

    @Override // io.netty.channel.RecvByteBufAllocator.DelegatingHandle, io.netty.channel.RecvByteBufAllocator.Handle
    public void reset(ChannelConfig channelConfig) {
        this.overrideGuess = ((KQueueChannelConfig) channelConfig).getRcvAllocTransportProvidesGuess();
        delegate().reset(channelConfig);
    }

    private int guess0() {
        return (int) Math.min(this.numberBytesPending, 2147483647L);
    }

    @Override // io.netty.channel.RecvByteBufAllocator.DelegatingHandle, io.netty.channel.RecvByteBufAllocator.Handle
    public ByteBuf allocate(ByteBufAllocator byteBufAllocator) {
        this.preferredDirectByteBufAllocator.updateAllocator(byteBufAllocator);
        return this.overrideGuess ? this.preferredDirectByteBufAllocator.ioBuffer(guess0()) : delegate().allocate(this.preferredDirectByteBufAllocator);
    }

    @Override // io.netty.channel.RecvByteBufAllocator.DelegatingHandle, io.netty.channel.RecvByteBufAllocator.Handle
    public boolean continueReading() {
        return continueReading(this.defaultMaybeMoreDataSupplier);
    }

    @Override // io.netty.channel.RecvByteBufAllocator.DelegatingHandle, io.netty.channel.RecvByteBufAllocator.Handle
    public int guess() {
        return this.overrideGuess ? guess0() : delegate().guess();
    }

    boolean isReadEOF() {
        return this.readEOF;
    }

    @Override // io.netty.channel.RecvByteBufAllocator.DelegatingHandle, io.netty.channel.RecvByteBufAllocator.Handle
    public void lastBytesRead(int i6) {
        this.numberBytesPending = i6 >= 0 ? Math.max(0L, this.numberBytesPending - i6) : 0L;
        delegate().lastBytesRead(i6);
    }

    boolean maybeMoreDataToRead() {
        return this.numberBytesPending != 0;
    }

    void numberBytesPending(long j6) {
        this.numberBytesPending = j6;
    }

    KQueueRecvByteAllocatorHandle(RecvByteBufAllocator.ExtendedHandle extendedHandle) {
        super(extendedHandle);
        this.preferredDirectByteBufAllocator = new PreferredDirectByteBufAllocator();
        this.defaultMaybeMoreDataSupplier = new UncheckedBooleanSupplier() { // from class: io.netty.channel.kqueue.KQueueRecvByteAllocatorHandle.1
            @Override // io.netty.util.UncheckedBooleanSupplier, io.netty.util.BooleanSupplier
            public boolean get() {
                return KQueueRecvByteAllocatorHandle.this.maybeMoreDataToRead();
            }
        };
    }
}
