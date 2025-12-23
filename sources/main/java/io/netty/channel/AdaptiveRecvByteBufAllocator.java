package io.netty.channel;

import io.netty.channel.DefaultMaxMessagesRecvByteBufAllocator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.util.internal.ObjectUtil;
import java.util.ArrayList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class AdaptiveRecvByteBufAllocator extends DefaultMaxMessagesRecvByteBufAllocator {

    @Deprecated
    public static final AdaptiveRecvByteBufAllocator DEFAULT;
    static final int DEFAULT_INITIAL = 1024;
    static final int DEFAULT_MAXIMUM = 65536;
    static final int DEFAULT_MINIMUM = 64;
    private static final int INDEX_DECREMENT = 1;
    private static final int INDEX_INCREMENT = 4;
    private static final int[] SIZE_TABLE;
    private final int initial;
    private final int maxIndex;
    private final int minIndex;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class HandleImpl extends DefaultMaxMessagesRecvByteBufAllocator.MaxMessageHandle {
        private boolean decreaseNow;
        private int index;
        private final int maxIndex;
        private final int minIndex;
        private int nextReceiveBufferSize;

        HandleImpl(int i6, int i7, int i8) {
            super();
            this.minIndex = i6;
            this.maxIndex = i7;
            this.index = AdaptiveRecvByteBufAllocator.getSizeTableIndex(i8);
            this.nextReceiveBufferSize = AdaptiveRecvByteBufAllocator.SIZE_TABLE[this.index];
        }

        @Override // io.netty.channel.RecvByteBufAllocator.Handle
        public int guess() {
            return this.nextReceiveBufferSize;
        }

        private void record(int i6) {
            if (i6 <= AdaptiveRecvByteBufAllocator.SIZE_TABLE[Math.max(0, this.index - 2)]) {
                if (this.decreaseNow) {
                    this.index = Math.max(this.index - 1, this.minIndex);
                    this.nextReceiveBufferSize = AdaptiveRecvByteBufAllocator.SIZE_TABLE[this.index];
                    this.decreaseNow = false;
                    return;
                }
                this.decreaseNow = true;
                return;
            }
            if (i6 >= this.nextReceiveBufferSize) {
                this.index = Math.min(this.index + 4, this.maxIndex);
                this.nextReceiveBufferSize = AdaptiveRecvByteBufAllocator.SIZE_TABLE[this.index];
                this.decreaseNow = false;
            }
        }

        @Override // io.netty.channel.DefaultMaxMessagesRecvByteBufAllocator.MaxMessageHandle, io.netty.channel.RecvByteBufAllocator.Handle
        public void lastBytesRead(int i6) {
            if (i6 == attemptedBytesRead()) {
                record(i6);
            }
            super.lastBytesRead(i6);
        }

        @Override // io.netty.channel.DefaultMaxMessagesRecvByteBufAllocator.MaxMessageHandle, io.netty.channel.RecvByteBufAllocator.Handle
        public void readComplete() {
            record(totalBytesRead());
        }
    }

    public AdaptiveRecvByteBufAllocator() {
        this(64, 1024, 65536);
    }

    static {
        int i6;
        ArrayList arrayList = new ArrayList();
        int i7 = 16;
        while (true) {
            if (i7 >= 512) {
                break;
            }
            arrayList.add(Integer.valueOf(i7));
            i7 += 16;
        }
        for (i6 = 512; i6 > 0; i6 <<= 1) {
            arrayList.add(Integer.valueOf(i6));
        }
        SIZE_TABLE = new int[arrayList.size()];
        int i8 = 0;
        while (true) {
            int[] iArr = SIZE_TABLE;
            if (i8 >= iArr.length) {
                DEFAULT = new AdaptiveRecvByteBufAllocator();
                return;
            } else {
                iArr[i8] = ((Integer) arrayList.get(i8)).intValue();
                i8++;
            }
        }
    }

    public AdaptiveRecvByteBufAllocator(int i6, int i7, int i8) {
        ObjectUtil.checkPositive(i6, "minimum");
        if (i7 < i6) {
            throw new IllegalArgumentException("initial: " + i7);
        }
        if (i8 < i7) {
            throw new IllegalArgumentException("maximum: " + i8);
        }
        int sizeTableIndex = getSizeTableIndex(i6);
        int[] iArr = SIZE_TABLE;
        if (iArr[sizeTableIndex] < i6) {
            this.minIndex = sizeTableIndex + 1;
        } else {
            this.minIndex = sizeTableIndex;
        }
        int sizeTableIndex2 = getSizeTableIndex(i8);
        if (iArr[sizeTableIndex2] > i8) {
            this.maxIndex = sizeTableIndex2 - 1;
        } else {
            this.maxIndex = sizeTableIndex2;
        }
        this.initial = i7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int getSizeTableIndex(int i6) {
        int length = SIZE_TABLE.length - 1;
        int i7 = 0;
        while (length >= i7) {
            if (length == i7) {
                return length;
            }
            int i8 = (i7 + length) >>> 1;
            int[] iArr = SIZE_TABLE;
            int i9 = iArr[i8];
            int i10 = i8 + 1;
            if (i6 > iArr[i10]) {
                i7 = i10;
            } else {
                if (i6 >= i9) {
                    return i6 == i9 ? i8 : i10;
                }
                length = i8 - 1;
            }
        }
        return i7;
    }

    @Override // io.netty.channel.RecvByteBufAllocator
    public RecvByteBufAllocator.Handle newHandle() {
        return new HandleImpl(this.minIndex, this.maxIndex, this.initial);
    }

    @Override // io.netty.channel.DefaultMaxMessagesRecvByteBufAllocator
    public AdaptiveRecvByteBufAllocator respectMaybeMoreData(boolean z5) {
        super.respectMaybeMoreData(z5);
        return this;
    }
}
