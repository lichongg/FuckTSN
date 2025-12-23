package com.google.common.hash;

import com.google.common.base.Charsets;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import com.google.common.primitives.UnsignedBytes;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Immutable
/* loaded from: D:\Downloads\app\classes5.dex */
final class Murmur3_32HashFunction extends AbstractHashFunction implements Serializable {
    private static final int C1 = -862048943;
    private static final int C2 = 461845907;
    private static final int CHUNK_SIZE = 4;
    private static final long serialVersionUID = 0;
    private final int seed;
    static final HashFunction MURMUR3_32 = new Murmur3_32HashFunction(0);
    static final HashFunction GOOD_FAST_HASH_32 = new Murmur3_32HashFunction(Hashing.GOOD_FAST_HASH_SEED);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @CanIgnoreReturnValue
    private static final class Murmur3_32Hasher extends AbstractHasher {
        private long buffer;

        /* renamed from: h1, reason: collision with root package name */
        private int f32754h1;
        private int shift;
        private int length = 0;
        private boolean isDone = false;

        private void update(int i6, long j6) {
            long j7 = this.buffer;
            int i7 = this.shift;
            long j8 = ((j6 & 4294967295L) << i7) | j7;
            this.buffer = j8;
            int i8 = i7 + (i6 * 8);
            this.shift = i8;
            this.length += i6;
            if (i8 >= 32) {
                this.f32754h1 = Murmur3_32HashFunction.mixH1(this.f32754h1, Murmur3_32HashFunction.mixK1((int) j8));
                this.buffer >>>= 32;
                this.shift -= 32;
            }
        }

        @Override // com.google.common.hash.Hasher
        public HashCode hash() {
            Preconditions.checkState(!this.isDone);
            this.isDone = true;
            int mixK1 = this.f32754h1 ^ Murmur3_32HashFunction.mixK1((int) this.buffer);
            this.f32754h1 = mixK1;
            return Murmur3_32HashFunction.fmix(mixK1, this.length);
        }

        @Override // com.google.common.hash.PrimitiveSink
        public Hasher putByte(byte b6) {
            update(1, b6 & 255);
            return this;
        }

        @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.PrimitiveSink
        public Hasher putChar(char c6) {
            update(2, c6);
            return this;
        }

        @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.PrimitiveSink
        public Hasher putInt(int i6) {
            update(4, i6);
            return this;
        }

        @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.PrimitiveSink
        public Hasher putLong(long j6) {
            update(4, (int) j6);
            update(4, j6 >>> 32);
            return this;
        }

        @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.PrimitiveSink
        public Hasher putString(CharSequence charSequence, Charset charset) {
            if (!Charsets.UTF_8.equals(charset)) {
                return super.putString(charSequence, charset);
            }
            int length = charSequence.length();
            int i6 = 0;
            while (true) {
                int i7 = i6 + 4;
                if (i7 > length) {
                    break;
                }
                char charAt = charSequence.charAt(i6);
                char charAt2 = charSequence.charAt(i6 + 1);
                char charAt3 = charSequence.charAt(i6 + 2);
                char charAt4 = charSequence.charAt(i6 + 3);
                if (charAt >= 128 || charAt2 >= 128 || charAt3 >= 128 || charAt4 >= 128) {
                    break;
                }
                update(4, (charAt2 << '\b') | charAt | (charAt3 << 16) | (charAt4 << 24));
                i6 = i7;
            }
            while (i6 < length) {
                char charAt5 = charSequence.charAt(i6);
                if (charAt5 < 128) {
                    update(1, charAt5);
                } else if (charAt5 < 2048) {
                    update(2, Murmur3_32HashFunction.charToTwoUtf8Bytes(charAt5));
                } else if (charAt5 < 55296 || charAt5 > 57343) {
                    update(3, Murmur3_32HashFunction.charToThreeUtf8Bytes(charAt5));
                } else {
                    int codePointAt = Character.codePointAt(charSequence, i6);
                    if (codePointAt == charAt5) {
                        putBytes(charSequence.subSequence(i6, length).toString().getBytes(charset));
                        return this;
                    }
                    i6++;
                    update(4, Murmur3_32HashFunction.codePointToFourUtf8Bytes(codePointAt));
                }
                i6++;
            }
            return this;
        }

        Murmur3_32Hasher(int i6) {
            this.f32754h1 = i6;
        }

        @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.PrimitiveSink
        public Hasher putBytes(byte[] bArr, int i6, int i7) {
            Preconditions.checkPositionIndexes(i6, i6 + i7, bArr.length);
            int i8 = 0;
            while (true) {
                int i9 = i8 + 4;
                if (i9 > i7) {
                    break;
                }
                update(4, Murmur3_32HashFunction.getIntLittleEndian(bArr, i8 + i6));
                i8 = i9;
            }
            while (i8 < i7) {
                putByte(bArr[i6 + i8]);
                i8++;
            }
            return this;
        }

        @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.PrimitiveSink
        public Hasher putBytes(ByteBuffer byteBuffer) {
            ByteOrder order = byteBuffer.order();
            byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
            while (byteBuffer.remaining() >= 4) {
                putInt(byteBuffer.getInt());
            }
            while (byteBuffer.hasRemaining()) {
                putByte(byteBuffer.get());
            }
            byteBuffer.order(order);
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static HashCode fmix(int i6, int i7) {
        int i8 = i6 ^ i7;
        int i9 = (i8 ^ (i8 >>> 16)) * (-2048144789);
        int i10 = (i9 ^ (i9 >>> 13)) * (-1028477387);
        return HashCode.fromInt(i10 ^ (i10 >>> 16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int mixH1(int i6, int i7) {
        return (Integer.rotateLeft(i6 ^ i7, 13) * 5) - 430675100;
    }

    @Override // com.google.common.hash.AbstractHashFunction, com.google.common.hash.HashFunction
    public HashCode hashLong(long j6) {
        int i6 = (int) (j6 >>> 32);
        return fmix(mixH1(mixH1(this.seed, mixK1((int) j6)), mixK1(i6)), 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long charToThreeUtf8Bytes(char c6) {
        return (((c6 & '?') | 128) << 16) | (((c6 >>> '\f') | 480) & 255) | ((((c6 >>> 6) & 63) | 128) << 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long charToTwoUtf8Bytes(char c6) {
        return (((c6 & '?') | 128) << 8) | (((c6 >>> 6) | 960) & 255);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long codePointToFourUtf8Bytes(int i6) {
        return (((i6 >>> 18) | 240) & 255) | ((((i6 >>> 12) & 63) | 128) << 8) | ((((i6 >>> 6) & 63) | 128) << 16) | (((i6 & 63) | 128) << 24);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int getIntLittleEndian(byte[] bArr, int i6) {
        return Ints.fromBytes(bArr[i6 + 3], bArr[i6 + 2], bArr[i6 + 1], bArr[i6]);
    }

    @Override // com.google.common.hash.HashFunction
    public int bits() {
        return 32;
    }

    public boolean equals(@NullableDecl Object obj) {
        return (obj instanceof Murmur3_32HashFunction) && this.seed == ((Murmur3_32HashFunction) obj).seed;
    }

    @Override // com.google.common.hash.AbstractHashFunction, com.google.common.hash.HashFunction
    public HashCode hashBytes(byte[] bArr, int i6, int i7) {
        Preconditions.checkPositionIndexes(i6, i6 + i7, bArr.length);
        int i8 = this.seed;
        int i9 = 0;
        int i10 = 0;
        while (true) {
            int i11 = i10 + 4;
            if (i11 > i7) {
                break;
            }
            i8 = mixH1(i8, mixK1(getIntLittleEndian(bArr, i10 + i6)));
            i10 = i11;
        }
        int i12 = i10;
        int i13 = 0;
        while (i12 < i7) {
            i9 ^= UnsignedBytes.toInt(bArr[i6 + i12]) << i13;
            i12++;
            i13 += 8;
        }
        return fmix(mixK1(i9) ^ i8, i7);
    }

    public int hashCode() {
        return Murmur3_32HashFunction.class.hashCode() ^ this.seed;
    }

    @Override // com.google.common.hash.AbstractHashFunction, com.google.common.hash.HashFunction
    public HashCode hashString(CharSequence charSequence, Charset charset) {
        if (!Charsets.UTF_8.equals(charset)) {
            return hashBytes(charSequence.toString().getBytes(charset));
        }
        int length = charSequence.length();
        int i6 = this.seed;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (true) {
            int i10 = i8 + 4;
            if (i10 > length) {
                break;
            }
            char charAt = charSequence.charAt(i8);
            char charAt2 = charSequence.charAt(i8 + 1);
            char charAt3 = charSequence.charAt(i8 + 2);
            char charAt4 = charSequence.charAt(i8 + 3);
            if (charAt >= 128 || charAt2 >= 128 || charAt3 >= 128 || charAt4 >= 128) {
                break;
            }
            i6 = mixH1(i6, mixK1((charAt2 << '\b') | charAt | (charAt3 << 16) | (charAt4 << 24)));
            i9 += 4;
            i8 = i10;
        }
        long j6 = 0;
        while (i8 < length) {
            char charAt5 = charSequence.charAt(i8);
            if (charAt5 < 128) {
                j6 |= charAt5 << i7;
                i7 += 8;
                i9++;
            } else if (charAt5 < 2048) {
                j6 |= charToTwoUtf8Bytes(charAt5) << i7;
                i7 += 16;
                i9 += 2;
            } else if (charAt5 < 55296 || charAt5 > 57343) {
                j6 |= charToThreeUtf8Bytes(charAt5) << i7;
                i7 += 24;
                i9 += 3;
            } else {
                int codePointAt = Character.codePointAt(charSequence, i8);
                if (codePointAt == charAt5) {
                    return hashBytes(charSequence.toString().getBytes(charset));
                }
                i8++;
                j6 |= codePointToFourUtf8Bytes(codePointAt) << i7;
                i9 += 4;
            }
            if (i7 >= 32) {
                i6 = mixH1(i6, mixK1((int) j6));
                j6 >>>= 32;
                i7 -= 32;
            }
            i8++;
        }
        return fmix(mixK1((int) j6) ^ i6, i9);
    }

    @Override // com.google.common.hash.AbstractHashFunction, com.google.common.hash.HashFunction
    public HashCode hashUnencodedChars(CharSequence charSequence) {
        int i6 = this.seed;
        for (int i7 = 1; i7 < charSequence.length(); i7 += 2) {
            i6 = mixH1(i6, mixK1(charSequence.charAt(i7 - 1) | (charSequence.charAt(i7) << 16)));
        }
        if ((charSequence.length() & 1) == 1) {
            i6 ^= mixK1(charSequence.charAt(charSequence.length() - 1));
        }
        return fmix(i6, charSequence.length() * 2);
    }

    @Override // com.google.common.hash.HashFunction
    public Hasher newHasher() {
        return new Murmur3_32Hasher(this.seed);
    }

    public String toString() {
        return "Hashing.murmur3_32(" + this.seed + ")";
    }

    Murmur3_32HashFunction(int i6) {
        this.seed = i6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int mixK1(int i6) {
        return Integer.rotateLeft(i6 * (-862048943), 15) * C2;
    }

    @Override // com.google.common.hash.AbstractHashFunction, com.google.common.hash.HashFunction
    public HashCode hashInt(int i6) {
        return fmix(mixH1(this.seed, mixK1(i6)), 4);
    }
}
