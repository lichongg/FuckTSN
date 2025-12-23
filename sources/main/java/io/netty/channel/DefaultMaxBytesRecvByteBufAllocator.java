package io.netty.channel;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.util.UncheckedBooleanSupplier;
import io.netty.util.internal.ObjectUtil;
import java.util.AbstractMap;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class DefaultMaxBytesRecvByteBufAllocator implements MaxBytesRecvByteBufAllocator {
    private volatile int maxBytesPerIndividualRead;
    private volatile int maxBytesPerRead;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: io.netty.channel.DefaultMaxBytesRecvByteBufAllocator$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class HandleImpl implements RecvByteBufAllocator.ExtendedHandle {
        private int attemptBytesRead;
        private int bytesToRead;
        private final UncheckedBooleanSupplier defaultMaybeMoreSupplier;
        private int individualReadMax;
        private int lastBytesRead;

        private HandleImpl() {
            this.defaultMaybeMoreSupplier = new UncheckedBooleanSupplier() { // from class: io.netty.channel.DefaultMaxBytesRecvByteBufAllocator.HandleImpl.1
                @Override // io.netty.util.UncheckedBooleanSupplier, io.netty.util.BooleanSupplier
                public boolean get() {
                    return HandleImpl.this.attemptBytesRead == HandleImpl.this.lastBytesRead;
                }
            };
        }

        @Override // io.netty.channel.RecvByteBufAllocator.Handle
        public void attemptedBytesRead(int i6) {
            this.attemptBytesRead = i6;
        }

        @Override // io.netty.channel.RecvByteBufAllocator.Handle
        public boolean continueReading() {
            return continueReading(this.defaultMaybeMoreSupplier);
        }

        @Override // io.netty.channel.RecvByteBufAllocator.Handle
        public void lastBytesRead(int i6) {
            this.lastBytesRead = i6;
            this.bytesToRead -= i6;
        }

        @Override // io.netty.channel.RecvByteBufAllocator.Handle
        public int attemptedBytesRead() {
            return this.attemptBytesRead;
        }

        @Override // io.netty.channel.RecvByteBufAllocator.ExtendedHandle
        public boolean continueReading(UncheckedBooleanSupplier uncheckedBooleanSupplier) {
            return this.bytesToRead > 0 && uncheckedBooleanSupplier.get();
        }

        @Override // io.netty.channel.RecvByteBufAllocator.Handle
        public int guess() {
            return Math.min(this.individualReadMax, this.bytesToRead);
        }

        @Override // io.netty.channel.RecvByteBufAllocator.Handle
        public void reset(ChannelConfig channelConfig) {
            this.bytesToRead = DefaultMaxBytesRecvByteBufAllocator.this.maxBytesPerRead();
            this.individualReadMax = DefaultMaxBytesRecvByteBufAllocator.this.maxBytesPerIndividualRead();
        }

        /* synthetic */ HandleImpl(DefaultMaxBytesRecvByteBufAllocator defaultMaxBytesRecvByteBufAllocator, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // io.netty.channel.RecvByteBufAllocator.Handle
        public ByteBuf allocate(ByteBufAllocator byteBufAllocator) {
            return byteBufAllocator.ioBuffer(guess());
        }

        @Override // io.netty.channel.RecvByteBufAllocator.Handle
        public int lastBytesRead() {
            return this.lastBytesRead;
        }

        @Override // io.netty.channel.RecvByteBufAllocator.Handle
        public void readComplete() {
        }

        @Override // io.netty.channel.RecvByteBufAllocator.Handle
        public void incMessagesRead(int i6) {
        }
    }

    public DefaultMaxBytesRecvByteBufAllocator() {
        this(65536, 65536);
    }

    public DefaultMaxBytesRecvByteBufAllocator(int i6, int i7) {
        checkMaxBytesPerReadPair(i6, i7);
        this.maxBytesPerRead = i6;
        this.maxBytesPerIndividualRead = i7;
    }

    private static void checkMaxBytesPerReadPair(int i6, int i7) {
        ObjectUtil.checkPositive(i6, "maxBytesPerRead");
        ObjectUtil.checkPositive(i7, "maxBytesPerIndividualRead");
        if (i6 >= i7) {
            return;
        }
        throw new IllegalArgumentException("maxBytesPerRead cannot be less than maxBytesPerIndividualRead (" + i7 + "): " + i6);
    }

    @Override // io.netty.channel.MaxBytesRecvByteBufAllocator
    public int maxBytesPerIndividualRead() {
        return this.maxBytesPerIndividualRead;
    }

    @Override // io.netty.channel.MaxBytesRecvByteBufAllocator
    public int maxBytesPerRead() {
        return this.maxBytesPerRead;
    }

    @Override // io.netty.channel.MaxBytesRecvByteBufAllocator
    public synchronized Map.Entry<Integer, Integer> maxBytesPerReadPair() {
        return new AbstractMap.SimpleEntry(Integer.valueOf(this.maxBytesPerRead), Integer.valueOf(this.maxBytesPerIndividualRead));
    }

    @Override // io.netty.channel.RecvByteBufAllocator
    public RecvByteBufAllocator.Handle newHandle() {
        return new HandleImpl(this, null);
    }

    @Override // io.netty.channel.MaxBytesRecvByteBufAllocator
    public DefaultMaxBytesRecvByteBufAllocator maxBytesPerIndividualRead(int i6) {
        ObjectUtil.checkPositive(i6, "maxBytesPerIndividualRead");
        synchronized (this) {
            try {
                int maxBytesPerRead = maxBytesPerRead();
                if (i6 <= maxBytesPerRead) {
                    this.maxBytesPerIndividualRead = i6;
                } else {
                    throw new IllegalArgumentException("maxBytesPerIndividualRead cannot be greater than maxBytesPerRead (" + maxBytesPerRead + "): " + i6);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return this;
    }

    @Override // io.netty.channel.MaxBytesRecvByteBufAllocator
    public DefaultMaxBytesRecvByteBufAllocator maxBytesPerRead(int i6) {
        ObjectUtil.checkPositive(i6, "maxBytesPerRead");
        synchronized (this) {
            try {
                int maxBytesPerIndividualRead = maxBytesPerIndividualRead();
                if (i6 >= maxBytesPerIndividualRead) {
                    this.maxBytesPerRead = i6;
                } else {
                    throw new IllegalArgumentException("maxBytesPerRead cannot be less than maxBytesPerIndividualRead (" + maxBytesPerIndividualRead + "): " + i6);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return this;
    }

    @Override // io.netty.channel.MaxBytesRecvByteBufAllocator
    public DefaultMaxBytesRecvByteBufAllocator maxBytesPerReadPair(int i6, int i7) {
        checkMaxBytesPerReadPair(i6, i7);
        synchronized (this) {
            this.maxBytesPerRead = i6;
            this.maxBytesPerIndividualRead = i7;
        }
        return this;
    }
}
