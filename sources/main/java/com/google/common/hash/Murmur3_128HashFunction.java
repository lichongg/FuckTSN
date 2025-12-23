package com.google.common.hash;

import com.google.common.primitives.UnsignedBytes;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Immutable
/* loaded from: D:\Downloads\app\classes5.dex */
final class Murmur3_128HashFunction extends AbstractHashFunction implements Serializable {
    private static final long serialVersionUID = 0;
    private final int seed;
    static final HashFunction MURMUR3_128 = new Murmur3_128HashFunction(0);
    static final HashFunction GOOD_FAST_HASH_128 = new Murmur3_128HashFunction(Hashing.GOOD_FAST_HASH_SEED);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class Murmur3_128Hasher extends AbstractStreamingHasher {
        private static final long C1 = -8663945395140668459L;
        private static final long C2 = 5545529020109919103L;
        private static final int CHUNK_SIZE = 16;

        /* renamed from: h1, reason: collision with root package name */
        private long f32752h1;

        /* renamed from: h2, reason: collision with root package name */
        private long f32753h2;
        private int length;

        Murmur3_128Hasher(int i6) {
            super(16);
            long j6 = i6;
            this.f32752h1 = j6;
            this.f32753h2 = j6;
            this.length = 0;
        }

        private void bmix64(long j6, long j7) {
            long mixK1 = mixK1(j6) ^ this.f32752h1;
            this.f32752h1 = mixK1;
            long rotateLeft = Long.rotateLeft(mixK1, 27);
            long j8 = this.f32753h2;
            this.f32752h1 = ((rotateLeft + j8) * 5) + 1390208809;
            long mixK2 = mixK2(j7) ^ j8;
            this.f32753h2 = mixK2;
            this.f32753h2 = ((Long.rotateLeft(mixK2, 31) + this.f32752h1) * 5) + 944331445;
        }

        private static long fmix64(long j6) {
            long j7 = (j6 ^ (j6 >>> 33)) * (-49064778989728563L);
            long j8 = (j7 ^ (j7 >>> 33)) * (-4265267296055464877L);
            return j8 ^ (j8 >>> 33);
        }

        @Override // com.google.common.hash.AbstractStreamingHasher
        public HashCode makeHash() {
            long j6 = this.f32752h1;
            int i6 = this.length;
            long j7 = this.f32753h2 ^ i6;
            long j8 = (j6 ^ i6) + j7;
            this.f32752h1 = j8;
            this.f32753h2 = j7 + j8;
            this.f32752h1 = fmix64(j8);
            long fmix64 = fmix64(this.f32753h2);
            long j9 = this.f32752h1 + fmix64;
            this.f32752h1 = j9;
            this.f32753h2 = fmix64 + j9;
            return HashCode.fromBytesNoCopy(ByteBuffer.wrap(new byte[16]).order(ByteOrder.LITTLE_ENDIAN).putLong(this.f32752h1).putLong(this.f32753h2).array());
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.google.common.hash.AbstractStreamingHasher
        protected void processRemaining(ByteBuffer byteBuffer) {
            long j6;
            long j7;
            long j8;
            long j9;
            long j10;
            long j11;
            long j12;
            this.length += byteBuffer.remaining();
            long j13 = 0;
            switch (byteBuffer.remaining()) {
                case 1:
                    j6 = 0;
                    j12 = j6 ^ UnsignedBytes.toInt(byteBuffer.get(0));
                    this.f32752h1 = mixK1(j12) ^ this.f32752h1;
                    this.f32753h2 ^= mixK2(j13);
                    return;
                case 2:
                    j7 = 0;
                    j6 = j7 ^ (UnsignedBytes.toInt(byteBuffer.get(1)) << 8);
                    j12 = j6 ^ UnsignedBytes.toInt(byteBuffer.get(0));
                    this.f32752h1 = mixK1(j12) ^ this.f32752h1;
                    this.f32753h2 ^= mixK2(j13);
                    return;
                case 3:
                    j8 = 0;
                    j7 = (UnsignedBytes.toInt(byteBuffer.get(2)) << 16) ^ j8;
                    j6 = j7 ^ (UnsignedBytes.toInt(byteBuffer.get(1)) << 8);
                    j12 = j6 ^ UnsignedBytes.toInt(byteBuffer.get(0));
                    this.f32752h1 = mixK1(j12) ^ this.f32752h1;
                    this.f32753h2 ^= mixK2(j13);
                    return;
                case 4:
                    j9 = 0;
                    j8 = (UnsignedBytes.toInt(byteBuffer.get(3)) << 24) ^ j9;
                    j7 = (UnsignedBytes.toInt(byteBuffer.get(2)) << 16) ^ j8;
                    j6 = j7 ^ (UnsignedBytes.toInt(byteBuffer.get(1)) << 8);
                    j12 = j6 ^ UnsignedBytes.toInt(byteBuffer.get(0));
                    this.f32752h1 = mixK1(j12) ^ this.f32752h1;
                    this.f32753h2 ^= mixK2(j13);
                    return;
                case 5:
                    j10 = 0;
                    j9 = j10 ^ (UnsignedBytes.toInt(byteBuffer.get(4)) << 32);
                    j8 = (UnsignedBytes.toInt(byteBuffer.get(3)) << 24) ^ j9;
                    j7 = (UnsignedBytes.toInt(byteBuffer.get(2)) << 16) ^ j8;
                    j6 = j7 ^ (UnsignedBytes.toInt(byteBuffer.get(1)) << 8);
                    j12 = j6 ^ UnsignedBytes.toInt(byteBuffer.get(0));
                    this.f32752h1 = mixK1(j12) ^ this.f32752h1;
                    this.f32753h2 ^= mixK2(j13);
                    return;
                case 6:
                    j11 = 0;
                    j10 = (UnsignedBytes.toInt(byteBuffer.get(5)) << 40) ^ j11;
                    j9 = j10 ^ (UnsignedBytes.toInt(byteBuffer.get(4)) << 32);
                    j8 = (UnsignedBytes.toInt(byteBuffer.get(3)) << 24) ^ j9;
                    j7 = (UnsignedBytes.toInt(byteBuffer.get(2)) << 16) ^ j8;
                    j6 = j7 ^ (UnsignedBytes.toInt(byteBuffer.get(1)) << 8);
                    j12 = j6 ^ UnsignedBytes.toInt(byteBuffer.get(0));
                    this.f32752h1 = mixK1(j12) ^ this.f32752h1;
                    this.f32753h2 ^= mixK2(j13);
                    return;
                case 7:
                    j11 = UnsignedBytes.toInt(byteBuffer.get(6)) << 48;
                    j10 = (UnsignedBytes.toInt(byteBuffer.get(5)) << 40) ^ j11;
                    j9 = j10 ^ (UnsignedBytes.toInt(byteBuffer.get(4)) << 32);
                    j8 = (UnsignedBytes.toInt(byteBuffer.get(3)) << 24) ^ j9;
                    j7 = (UnsignedBytes.toInt(byteBuffer.get(2)) << 16) ^ j8;
                    j6 = j7 ^ (UnsignedBytes.toInt(byteBuffer.get(1)) << 8);
                    j12 = j6 ^ UnsignedBytes.toInt(byteBuffer.get(0));
                    this.f32752h1 = mixK1(j12) ^ this.f32752h1;
                    this.f32753h2 ^= mixK2(j13);
                    return;
                case 8:
                    j12 = byteBuffer.getLong();
                    this.f32752h1 = mixK1(j12) ^ this.f32752h1;
                    this.f32753h2 ^= mixK2(j13);
                    return;
                case 9:
                    j13 ^= UnsignedBytes.toInt(byteBuffer.get(8));
                    j12 = byteBuffer.getLong();
                    this.f32752h1 = mixK1(j12) ^ this.f32752h1;
                    this.f32753h2 ^= mixK2(j13);
                    return;
                case 10:
                    j13 ^= UnsignedBytes.toInt(byteBuffer.get(9)) << 8;
                    j13 ^= UnsignedBytes.toInt(byteBuffer.get(8));
                    j12 = byteBuffer.getLong();
                    this.f32752h1 = mixK1(j12) ^ this.f32752h1;
                    this.f32753h2 ^= mixK2(j13);
                    return;
                case 11:
                    j13 ^= UnsignedBytes.toInt(byteBuffer.get(10)) << 16;
                    j13 ^= UnsignedBytes.toInt(byteBuffer.get(9)) << 8;
                    j13 ^= UnsignedBytes.toInt(byteBuffer.get(8));
                    j12 = byteBuffer.getLong();
                    this.f32752h1 = mixK1(j12) ^ this.f32752h1;
                    this.f32753h2 ^= mixK2(j13);
                    return;
                case 12:
                    j13 ^= UnsignedBytes.toInt(byteBuffer.get(11)) << 24;
                    j13 ^= UnsignedBytes.toInt(byteBuffer.get(10)) << 16;
                    j13 ^= UnsignedBytes.toInt(byteBuffer.get(9)) << 8;
                    j13 ^= UnsignedBytes.toInt(byteBuffer.get(8));
                    j12 = byteBuffer.getLong();
                    this.f32752h1 = mixK1(j12) ^ this.f32752h1;
                    this.f32753h2 ^= mixK2(j13);
                    return;
                case 13:
                    j13 ^= UnsignedBytes.toInt(byteBuffer.get(12)) << 32;
                    j13 ^= UnsignedBytes.toInt(byteBuffer.get(11)) << 24;
                    j13 ^= UnsignedBytes.toInt(byteBuffer.get(10)) << 16;
                    j13 ^= UnsignedBytes.toInt(byteBuffer.get(9)) << 8;
                    j13 ^= UnsignedBytes.toInt(byteBuffer.get(8));
                    j12 = byteBuffer.getLong();
                    this.f32752h1 = mixK1(j12) ^ this.f32752h1;
                    this.f32753h2 ^= mixK2(j13);
                    return;
                case 14:
                    j13 ^= UnsignedBytes.toInt(byteBuffer.get(13)) << 40;
                    j13 ^= UnsignedBytes.toInt(byteBuffer.get(12)) << 32;
                    j13 ^= UnsignedBytes.toInt(byteBuffer.get(11)) << 24;
                    j13 ^= UnsignedBytes.toInt(byteBuffer.get(10)) << 16;
                    j13 ^= UnsignedBytes.toInt(byteBuffer.get(9)) << 8;
                    j13 ^= UnsignedBytes.toInt(byteBuffer.get(8));
                    j12 = byteBuffer.getLong();
                    this.f32752h1 = mixK1(j12) ^ this.f32752h1;
                    this.f32753h2 ^= mixK2(j13);
                    return;
                case 15:
                    j13 = UnsignedBytes.toInt(byteBuffer.get(14)) << 48;
                    j13 ^= UnsignedBytes.toInt(byteBuffer.get(13)) << 40;
                    j13 ^= UnsignedBytes.toInt(byteBuffer.get(12)) << 32;
                    j13 ^= UnsignedBytes.toInt(byteBuffer.get(11)) << 24;
                    j13 ^= UnsignedBytes.toInt(byteBuffer.get(10)) << 16;
                    j13 ^= UnsignedBytes.toInt(byteBuffer.get(9)) << 8;
                    j13 ^= UnsignedBytes.toInt(byteBuffer.get(8));
                    j12 = byteBuffer.getLong();
                    this.f32752h1 = mixK1(j12) ^ this.f32752h1;
                    this.f32753h2 ^= mixK2(j13);
                    return;
                default:
                    throw new AssertionError("Should never get here.");
            }
        }

        @Override // com.google.common.hash.AbstractStreamingHasher
        protected void process(ByteBuffer byteBuffer) {
            bmix64(byteBuffer.getLong(), byteBuffer.getLong());
            this.length += 16;
        }

        private static long mixK1(long j6) {
            return Long.rotateLeft(j6 * C1, 31) * C2;
        }

        private static long mixK2(long j6) {
            return Long.rotateLeft(j6 * C2, 33) * C1;
        }
    }

    @Override // com.google.common.hash.HashFunction
    public int bits() {
        return 128;
    }

    public boolean equals(@NullableDecl Object obj) {
        return (obj instanceof Murmur3_128HashFunction) && this.seed == ((Murmur3_128HashFunction) obj).seed;
    }

    public int hashCode() {
        return Murmur3_128HashFunction.class.hashCode() ^ this.seed;
    }

    @Override // com.google.common.hash.HashFunction
    public Hasher newHasher() {
        return new Murmur3_128Hasher(this.seed);
    }

    public String toString() {
        return "Hashing.murmur3_128(" + this.seed + ")";
    }

    Murmur3_128HashFunction(int i6) {
        this.seed = i6;
    }
}
