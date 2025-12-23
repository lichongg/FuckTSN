package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.hash.BloomFilterStrategies;
import com.google.common.math.DoubleMath;
import com.google.common.primitives.SignedBytes;
import com.google.common.primitives.UnsignedBytes;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.math.RoundingMode;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Beta
/* loaded from: D:\Downloads\app\classes5.dex */
public final class BloomFilter<T> implements Predicate<T>, Serializable {
    private final BloomFilterStrategies.LockFreeBitArray bits;
    private final Funnel<? super T> funnel;
    private final int numHashFunctions;
    private final Strategy strategy;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.google.common.hash.BloomFilter$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class SerialForm<T> implements Serializable {
        private static final long serialVersionUID = 1;
        final long[] data;
        final Funnel<? super T> funnel;
        final int numHashFunctions;
        final Strategy strategy;

        Object readResolve() {
            return new BloomFilter(new BloomFilterStrategies.LockFreeBitArray(this.data), this.numHashFunctions, this.funnel, this.strategy, null);
        }

        SerialForm(BloomFilter<T> bloomFilter) {
            this.data = BloomFilterStrategies.LockFreeBitArray.toPlainArray(((BloomFilter) bloomFilter).bits.data);
            this.numHashFunctions = ((BloomFilter) bloomFilter).numHashFunctions;
            this.funnel = ((BloomFilter) bloomFilter).funnel;
            this.strategy = ((BloomFilter) bloomFilter).strategy;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    interface Strategy extends Serializable {
        <T> boolean mightContain(T t5, Funnel<? super T> funnel, int i6, BloomFilterStrategies.LockFreeBitArray lockFreeBitArray);

        int ordinal();

        <T> boolean put(T t5, Funnel<? super T> funnel, int i6, BloomFilterStrategies.LockFreeBitArray lockFreeBitArray);
    }

    /* synthetic */ BloomFilter(BloomFilterStrategies.LockFreeBitArray lockFreeBitArray, int i6, Funnel funnel, Strategy strategy, AnonymousClass1 anonymousClass1) {
        this(lockFreeBitArray, i6, funnel, strategy);
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> funnel, int i6, double d6) {
        return create(funnel, i6, d6);
    }

    @VisibleForTesting
    static int optimalNumOfHashFunctions(long j6, long j7) {
        return Math.max(1, (int) Math.round((j7 / j6) * Math.log(2.0d)));
    }

    @Override // com.google.common.base.Predicate
    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof BloomFilter) {
            BloomFilter bloomFilter = (BloomFilter) obj;
            if (this.numHashFunctions == bloomFilter.numHashFunctions && this.funnel.equals(bloomFilter.funnel) && this.bits.equals(bloomFilter.bits) && this.strategy.equals(bloomFilter.strategy)) {
                return true;
            }
        }
        return false;
    }

    private BloomFilter(BloomFilterStrategies.LockFreeBitArray lockFreeBitArray, int i6, Funnel<? super T> funnel, Strategy strategy) {
        Preconditions.checkArgument(i6 > 0, "numHashFunctions (%s) must be > 0", i6);
        Preconditions.checkArgument(i6 <= 255, "numHashFunctions (%s) must be <= 255", i6);
        this.bits = (BloomFilterStrategies.LockFreeBitArray) Preconditions.checkNotNull(lockFreeBitArray);
        this.numHashFunctions = i6;
        this.funnel = (Funnel) Preconditions.checkNotNull(funnel);
        this.strategy = (Strategy) Preconditions.checkNotNull(strategy);
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> funnel, long j6, double d6) {
        return create(funnel, j6, d6, BloomFilterStrategies.MURMUR128_MITZ_64);
    }

    @VisibleForTesting
    static long optimalNumOfBits(long j6, double d6) {
        if (d6 == 0.0d) {
            d6 = Double.MIN_VALUE;
        }
        return (long) (((-j6) * Math.log(d6)) / (Math.log(2.0d) * Math.log(2.0d)));
    }

    public static <T> BloomFilter<T> readFrom(InputStream inputStream, Funnel<? super T> funnel) throws IOException {
        int i6;
        int i7;
        int readInt;
        Preconditions.checkNotNull(inputStream, "InputStream");
        Preconditions.checkNotNull(funnel, "Funnel");
        byte b6 = -1;
        try {
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            byte readByte = dataInputStream.readByte();
            try {
                i7 = UnsignedBytes.toInt(dataInputStream.readByte());
                try {
                    readInt = dataInputStream.readInt();
                } catch (RuntimeException e6) {
                    e = e6;
                    b6 = readByte;
                    i6 = -1;
                    throw new IOException("Unable to deserialize BloomFilter from InputStream. strategyOrdinal: " + ((int) b6) + " numHashFunctions: " + i7 + " dataLength: " + i6, e);
                }
                try {
                    BloomFilterStrategies bloomFilterStrategies = BloomFilterStrategies.values()[readByte];
                    long[] jArr = new long[readInt];
                    for (int i8 = 0; i8 < readInt; i8++) {
                        jArr[i8] = dataInputStream.readLong();
                    }
                    return new BloomFilter<>(new BloomFilterStrategies.LockFreeBitArray(jArr), i7, funnel, bloomFilterStrategies);
                } catch (RuntimeException e7) {
                    e = e7;
                    b6 = readByte;
                    i6 = readInt;
                    throw new IOException("Unable to deserialize BloomFilter from InputStream. strategyOrdinal: " + ((int) b6) + " numHashFunctions: " + i7 + " dataLength: " + i6, e);
                }
            } catch (RuntimeException e8) {
                e = e8;
                i7 = -1;
            }
        } catch (RuntimeException e9) {
            e = e9;
            i6 = -1;
            i7 = -1;
        }
    }

    private Object writeReplace() {
        return new SerialForm(this);
    }

    public long approximateElementCount() {
        double bitSize = this.bits.bitSize();
        return DoubleMath.roundToLong(((-Math.log1p(-(this.bits.bitCount() / bitSize))) * bitSize) / this.numHashFunctions, RoundingMode.HALF_UP);
    }

    @VisibleForTesting
    long bitSize() {
        return this.bits.bitSize();
    }

    public BloomFilter<T> copy() {
        return new BloomFilter<>(this.bits.copy(), this.numHashFunctions, this.funnel, this.strategy);
    }

    public double expectedFpp() {
        return Math.pow(this.bits.bitCount() / bitSize(), this.numHashFunctions);
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.numHashFunctions), this.funnel, this.strategy, this.bits);
    }

    public boolean mightContain(T t5) {
        return this.strategy.mightContain(t5, this.funnel, this.numHashFunctions, this.bits);
    }

    @CanIgnoreReturnValue
    public boolean put(T t5) {
        return this.strategy.put(t5, this.funnel, this.numHashFunctions, this.bits);
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        dataOutputStream.writeByte(SignedBytes.checkedCast(this.strategy.ordinal()));
        dataOutputStream.writeByte(UnsignedBytes.checkedCast(this.numHashFunctions));
        dataOutputStream.writeInt(this.bits.data.length());
        for (int i6 = 0; i6 < this.bits.data.length(); i6++) {
            dataOutputStream.writeLong(this.bits.data.get(i6));
        }
    }

    @VisibleForTesting
    static <T> BloomFilter<T> create(Funnel<? super T> funnel, long j6, double d6, Strategy strategy) {
        Preconditions.checkNotNull(funnel);
        Preconditions.checkArgument(j6 >= 0, "Expected insertions (%s) must be >= 0", j6);
        Preconditions.checkArgument(d6 > 0.0d, "False positive probability (%s) must be > 0.0", Double.valueOf(d6));
        Preconditions.checkArgument(d6 < 1.0d, "False positive probability (%s) must be < 1.0", Double.valueOf(d6));
        Preconditions.checkNotNull(strategy);
        if (j6 == 0) {
            j6 = 1;
        }
        long optimalNumOfBits = optimalNumOfBits(j6, d6);
        try {
            return new BloomFilter<>(new BloomFilterStrategies.LockFreeBitArray(optimalNumOfBits), optimalNumOfHashFunctions(j6, optimalNumOfBits), funnel, strategy);
        } catch (IllegalArgumentException e6) {
            throw new IllegalArgumentException("Could not create BloomFilter of " + optimalNumOfBits + " bits", e6);
        }
    }

    @Override // com.google.common.base.Predicate
    @Deprecated
    public boolean apply(T t5) {
        return mightContain(t5);
    }

    public boolean isCompatible(BloomFilter<T> bloomFilter) {
        Preconditions.checkNotNull(bloomFilter);
        if (this != bloomFilter && this.numHashFunctions == bloomFilter.numHashFunctions && bitSize() == bloomFilter.bitSize() && this.strategy.equals(bloomFilter.strategy) && this.funnel.equals(bloomFilter.funnel)) {
            return true;
        }
        return false;
    }

    public void putAll(BloomFilter<T> bloomFilter) {
        boolean z5;
        boolean z6;
        boolean z7;
        Preconditions.checkNotNull(bloomFilter);
        if (this != bloomFilter) {
            z5 = true;
        } else {
            z5 = false;
        }
        Preconditions.checkArgument(z5, "Cannot combine a BloomFilter with itself.");
        int i6 = this.numHashFunctions;
        int i7 = bloomFilter.numHashFunctions;
        if (i6 == i7) {
            z6 = true;
        } else {
            z6 = false;
        }
        Preconditions.checkArgument(z6, "BloomFilters must have the same number of hash functions (%s != %s)", i6, i7);
        if (bitSize() == bloomFilter.bitSize()) {
            z7 = true;
        } else {
            z7 = false;
        }
        Preconditions.checkArgument(z7, "BloomFilters must have the same size underlying bit arrays (%s != %s)", bitSize(), bloomFilter.bitSize());
        Preconditions.checkArgument(this.strategy.equals(bloomFilter.strategy), "BloomFilters must have equal strategies (%s != %s)", this.strategy, bloomFilter.strategy);
        Preconditions.checkArgument(this.funnel.equals(bloomFilter.funnel), "BloomFilters must have equal funnels (%s != %s)", this.funnel, bloomFilter.funnel);
        this.bits.putAll(bloomFilter.bits);
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> funnel, int i6) {
        return create(funnel, i6);
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> funnel, long j6) {
        return create(funnel, j6, 0.03d);
    }
}
