package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import com.google.common.primitives.UnsignedInts;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Beta
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class HashCode {
    private static final char[] hexDigits = "0123456789abcdef".toCharArray();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class BytesHashCode extends HashCode implements Serializable {
        private static final long serialVersionUID = 0;
        final byte[] bytes;

        @Override // com.google.common.hash.HashCode
        public byte[] asBytes() {
            return (byte[]) this.bytes.clone();
        }

        @Override // com.google.common.hash.HashCode
        public int asInt() {
            byte[] bArr = this.bytes;
            Preconditions.checkState(bArr.length >= 4, "HashCode#asInt() requires >= 4 bytes (it only has %s bytes).", bArr.length);
            byte[] bArr2 = this.bytes;
            return ((bArr2[3] & 255) << 24) | (bArr2[0] & 255) | ((bArr2[1] & 255) << 8) | ((bArr2[2] & 255) << 16);
        }

        @Override // com.google.common.hash.HashCode
        public long asLong() {
            byte[] bArr = this.bytes;
            Preconditions.checkState(bArr.length >= 8, "HashCode#asLong() requires >= 8 bytes (it only has %s bytes).", bArr.length);
            return padToLong();
        }

        @Override // com.google.common.hash.HashCode
        public int bits() {
            return this.bytes.length * 8;
        }

        @Override // com.google.common.hash.HashCode
        boolean equalsSameBits(HashCode hashCode) {
            if (this.bytes.length != hashCode.getBytesInternal().length) {
                return false;
            }
            int i6 = 0;
            boolean z5 = true;
            while (true) {
                byte[] bArr = this.bytes;
                if (i6 >= bArr.length) {
                    return z5;
                }
                z5 &= bArr[i6] == hashCode.getBytesInternal()[i6];
                i6++;
            }
        }

        @Override // com.google.common.hash.HashCode
        byte[] getBytesInternal() {
            return this.bytes;
        }

        @Override // com.google.common.hash.HashCode
        public long padToLong() {
            long j6 = this.bytes[0] & 255;
            for (int i6 = 1; i6 < Math.min(this.bytes.length, 8); i6++) {
                j6 |= (this.bytes[i6] & 255) << (i6 * 8);
            }
            return j6;
        }

        @Override // com.google.common.hash.HashCode
        void writeBytesToImpl(byte[] bArr, int i6, int i7) {
            System.arraycopy(this.bytes, 0, bArr, i6, i7);
        }

        BytesHashCode(byte[] bArr) {
            this.bytes = (byte[]) Preconditions.checkNotNull(bArr);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class IntHashCode extends HashCode implements Serializable {
        private static final long serialVersionUID = 0;
        final int hash;

        @Override // com.google.common.hash.HashCode
        void writeBytesToImpl(byte[] bArr, int i6, int i7) {
            for (int i8 = 0; i8 < i7; i8++) {
                bArr[i6 + i8] = (byte) (this.hash >> (i8 * 8));
            }
        }

        @Override // com.google.common.hash.HashCode
        public byte[] asBytes() {
            int i6 = this.hash;
            return new byte[]{(byte) i6, (byte) (i6 >> 8), (byte) (i6 >> 16), (byte) (i6 >> 24)};
        }

        @Override // com.google.common.hash.HashCode
        public int asInt() {
            return this.hash;
        }

        @Override // com.google.common.hash.HashCode
        public long asLong() {
            throw new IllegalStateException("this HashCode only has 32 bits; cannot create a long");
        }

        @Override // com.google.common.hash.HashCode
        public int bits() {
            return 32;
        }

        @Override // com.google.common.hash.HashCode
        boolean equalsSameBits(HashCode hashCode) {
            return this.hash == hashCode.asInt();
        }

        @Override // com.google.common.hash.HashCode
        public long padToLong() {
            return UnsignedInts.toLong(this.hash);
        }

        IntHashCode(int i6) {
            this.hash = i6;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class LongHashCode extends HashCode implements Serializable {
        private static final long serialVersionUID = 0;
        final long hash;

        @Override // com.google.common.hash.HashCode
        void writeBytesToImpl(byte[] bArr, int i6, int i7) {
            for (int i8 = 0; i8 < i7; i8++) {
                bArr[i6 + i8] = (byte) (this.hash >> (i8 * 8));
            }
        }

        @Override // com.google.common.hash.HashCode
        public byte[] asBytes() {
            return new byte[]{(byte) this.hash, (byte) (r0 >> 8), (byte) (r0 >> 16), (byte) (r0 >> 24), (byte) (r0 >> 32), (byte) (r0 >> 40), (byte) (r0 >> 48), (byte) (r0 >> 56)};
        }

        @Override // com.google.common.hash.HashCode
        public int asInt() {
            return (int) this.hash;
        }

        @Override // com.google.common.hash.HashCode
        public long asLong() {
            return this.hash;
        }

        @Override // com.google.common.hash.HashCode
        public int bits() {
            return 64;
        }

        @Override // com.google.common.hash.HashCode
        boolean equalsSameBits(HashCode hashCode) {
            return this.hash == hashCode.asLong();
        }

        @Override // com.google.common.hash.HashCode
        public long padToLong() {
            return this.hash;
        }

        LongHashCode(long j6) {
            this.hash = j6;
        }
    }

    public static HashCode fromBytes(byte[] bArr) {
        Preconditions.checkArgument(bArr.length >= 1, "A HashCode must contain at least 1 byte.");
        return fromBytesNoCopy((byte[]) bArr.clone());
    }

    public abstract byte[] asBytes();

    public abstract int asInt();

    public abstract long asLong();

    public abstract int bits();

    abstract boolean equalsSameBits(HashCode hashCode);

    public abstract long padToLong();

    abstract void writeBytesToImpl(byte[] bArr, int i6, int i7);

    private static int decode(char c6) {
        if (c6 >= '0' && c6 <= '9') {
            return c6 - '0';
        }
        if (c6 >= 'a' && c6 <= 'f') {
            return c6 - 'W';
        }
        throw new IllegalArgumentException("Illegal hexadecimal character: " + c6);
    }

    static HashCode fromBytesNoCopy(byte[] bArr) {
        return new BytesHashCode(bArr);
    }

    public static HashCode fromInt(int i6) {
        return new IntHashCode(i6);
    }

    public static HashCode fromLong(long j6) {
        return new LongHashCode(j6);
    }

    public final boolean equals(@NullableDecl Object obj) {
        if (obj instanceof HashCode) {
            HashCode hashCode = (HashCode) obj;
            if (bits() == hashCode.bits() && equalsSameBits(hashCode)) {
                return true;
            }
        }
        return false;
    }

    HashCode() {
    }

    public static HashCode fromString(String str) {
        boolean z5;
        boolean z6 = true;
        if (str.length() >= 2) {
            z5 = true;
        } else {
            z5 = false;
        }
        Preconditions.checkArgument(z5, "input string (%s) must have at least 2 characters", str);
        if (str.length() % 2 != 0) {
            z6 = false;
        }
        Preconditions.checkArgument(z6, "input string (%s) must have an even number of characters", str);
        byte[] bArr = new byte[str.length() / 2];
        for (int i6 = 0; i6 < str.length(); i6 += 2) {
            bArr[i6 / 2] = (byte) ((decode(str.charAt(i6)) << 4) + decode(str.charAt(i6 + 1)));
        }
        return fromBytesNoCopy(bArr);
    }

    byte[] getBytesInternal() {
        return asBytes();
    }

    public final int hashCode() {
        if (bits() >= 32) {
            return asInt();
        }
        byte[] bytesInternal = getBytesInternal();
        int i6 = bytesInternal[0] & 255;
        for (int i7 = 1; i7 < bytesInternal.length; i7++) {
            i6 |= (bytesInternal[i7] & 255) << (i7 * 8);
        }
        return i6;
    }

    public final String toString() {
        byte[] bytesInternal = getBytesInternal();
        StringBuilder sb = new StringBuilder(bytesInternal.length * 2);
        for (byte b6 : bytesInternal) {
            char[] cArr = hexDigits;
            sb.append(cArr[(b6 >> 4) & 15]);
            sb.append(cArr[b6 & 15]);
        }
        return sb.toString();
    }

    @CanIgnoreReturnValue
    public int writeBytesTo(byte[] bArr, int i6, int i7) {
        int min = Ints.min(i7, bits() / 8);
        Preconditions.checkPositionIndexes(i6, i6 + min, bArr.length);
        writeBytesToImpl(bArr, i6, min);
        return min;
    }
}
