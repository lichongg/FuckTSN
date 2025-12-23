package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.common.hash.BloomFilter;
import com.google.common.math.LongMath;
import com.google.common.primitives.Ints;
import com.google.common.primitives.Longs;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLongArray;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
enum BloomFilterStrategies implements BloomFilter.Strategy {
    MURMUR128_MITZ_32 { // from class: com.google.common.hash.BloomFilterStrategies.1
        @Override // com.google.common.hash.BloomFilter.Strategy
        public <T> boolean mightContain(T t5, Funnel<? super T> funnel, int i6, LockFreeBitArray lockFreeBitArray) {
            long bitSize = lockFreeBitArray.bitSize();
            long asLong = Hashing.murmur3_128().hashObject(t5, funnel).asLong();
            int i7 = (int) asLong;
            int i8 = (int) (asLong >>> 32);
            for (int i9 = 1; i9 <= i6; i9++) {
                int i10 = (i9 * i8) + i7;
                if (i10 < 0) {
                    i10 = ~i10;
                }
                if (!lockFreeBitArray.get(i10 % bitSize)) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.common.hash.BloomFilter.Strategy
        public <T> boolean put(T t5, Funnel<? super T> funnel, int i6, LockFreeBitArray lockFreeBitArray) {
            long bitSize = lockFreeBitArray.bitSize();
            long asLong = Hashing.murmur3_128().hashObject(t5, funnel).asLong();
            int i7 = (int) asLong;
            int i8 = (int) (asLong >>> 32);
            boolean z5 = false;
            for (int i9 = 1; i9 <= i6; i9++) {
                int i10 = (i9 * i8) + i7;
                if (i10 < 0) {
                    i10 = ~i10;
                }
                z5 |= lockFreeBitArray.set(i10 % bitSize);
            }
            return z5;
        }
    },
    MURMUR128_MITZ_64 { // from class: com.google.common.hash.BloomFilterStrategies.2
        private long lowerEight(byte[] bArr) {
            return Longs.fromBytes(bArr[7], bArr[6], bArr[5], bArr[4], bArr[3], bArr[2], bArr[1], bArr[0]);
        }

        private long upperEight(byte[] bArr) {
            return Longs.fromBytes(bArr[15], bArr[14], bArr[13], bArr[12], bArr[11], bArr[10], bArr[9], bArr[8]);
        }

        @Override // com.google.common.hash.BloomFilter.Strategy
        public <T> boolean mightContain(T t5, Funnel<? super T> funnel, int i6, LockFreeBitArray lockFreeBitArray) {
            long bitSize = lockFreeBitArray.bitSize();
            byte[] bytesInternal = Hashing.murmur3_128().hashObject(t5, funnel).getBytesInternal();
            long lowerEight = lowerEight(bytesInternal);
            long upperEight = upperEight(bytesInternal);
            for (int i7 = 0; i7 < i6; i7++) {
                if (!lockFreeBitArray.get((Long.MAX_VALUE & lowerEight) % bitSize)) {
                    return false;
                }
                lowerEight += upperEight;
            }
            return true;
        }

        @Override // com.google.common.hash.BloomFilter.Strategy
        public <T> boolean put(T t5, Funnel<? super T> funnel, int i6, LockFreeBitArray lockFreeBitArray) {
            long bitSize = lockFreeBitArray.bitSize();
            byte[] bytesInternal = Hashing.murmur3_128().hashObject(t5, funnel).getBytesInternal();
            long lowerEight = lowerEight(bytesInternal);
            long upperEight = upperEight(bytesInternal);
            boolean z5 = false;
            for (int i7 = 0; i7 < i6; i7++) {
                z5 |= lockFreeBitArray.set((Long.MAX_VALUE & lowerEight) % bitSize);
                lowerEight += upperEight;
            }
            return z5;
        }
    };

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class LockFreeBitArray {
        private static final int LONG_ADDRESSABLE_BITS = 6;
        private final LongAddable bitCount;
        final AtomicLongArray data;

        LockFreeBitArray(long j6) {
            this(new long[Ints.checkedCast(LongMath.divide(j6, 64L, RoundingMode.CEILING))]);
        }

        LockFreeBitArray(long[] jArr) {
            Preconditions.checkArgument(jArr.length > 0, "data length is zero!");
            this.data = new AtomicLongArray(jArr);
            this.bitCount = LongAddables.create();
            long j6 = 0;
            for (long j7 : jArr) {
                j6 += Long.bitCount(j7);
            }
            this.bitCount.add(j6);
        }

        long bitCount() {
            return this.bitCount.sum();
        }

        long bitSize() {
            return this.data.length() * 64;
        }

        LockFreeBitArray copy() {
            return new LockFreeBitArray(toPlainArray(this.data));
        }

        public boolean equals(@NullableDecl Object obj) {
            if (obj instanceof LockFreeBitArray) {
                return Arrays.equals(toPlainArray(this.data), toPlainArray(((LockFreeBitArray) obj).data));
            }
            return false;
        }

        boolean get(long j6) {
            return ((1 << ((int) j6)) & this.data.get((int) (j6 >>> 6))) != 0;
        }

        public int hashCode() {
            return Arrays.hashCode(toPlainArray(this.data));
        }

        void putAll(LockFreeBitArray lockFreeBitArray) {
            Preconditions.checkArgument(this.data.length() == lockFreeBitArray.data.length(), "BitArrays must be of equal length (%s != %s)", this.data.length(), lockFreeBitArray.data.length());
            for (int i6 = 0; i6 < this.data.length(); i6++) {
                long j6 = lockFreeBitArray.data.get(i6);
                while (true) {
                    long j7 = this.data.get(i6);
                    long j8 = j7 | j6;
                    if (j7 != j8) {
                        if (this.data.compareAndSet(i6, j7, j8)) {
                            this.bitCount.add(Long.bitCount(j8) - Long.bitCount(j7));
                            break;
                        }
                    }
                }
            }
        }

        public static long[] toPlainArray(AtomicLongArray atomicLongArray) {
            int length = atomicLongArray.length();
            long[] jArr = new long[length];
            for (int i6 = 0; i6 < length; i6++) {
                jArr[i6] = atomicLongArray.get(i6);
            }
            return jArr;
        }

        boolean set(long j6) {
            long j7;
            long j8;
            if (get(j6)) {
                return false;
            }
            int i6 = (int) (j6 >>> 6);
            long j9 = 1 << ((int) j6);
            do {
                j7 = this.data.get(i6);
                j8 = j7 | j9;
                if (j7 == j8) {
                    return false;
                }
            } while (!this.data.compareAndSet(i6, j7, j8));
            this.bitCount.increment();
            return true;
        }
    }
}
