package com.google.common.hash;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class FarmHashFingerprint64 extends AbstractNonStreamingHashFunction {
    static final HashFunction FARMHASH_FINGERPRINT_64 = new FarmHashFingerprint64();
    private static final long K0 = -4348849565147123417L;
    private static final long K1 = -5435081209227447693L;
    private static final long K2 = -7286425919675154353L;

    private static long hashLength16(long j6, long j7, long j8) {
        long j9 = (j6 ^ j7) * j8;
        long j10 = ((j9 ^ (j9 >>> 47)) ^ j7) * j8;
        return (j10 ^ (j10 >>> 47)) * j8;
    }

    @VisibleForTesting
    static long fingerprint(byte[] bArr, int i6, int i7) {
        return i7 <= 32 ? i7 <= 16 ? hashLength0to16(bArr, i6, i7) : hashLength17to32(bArr, i6, i7) : i7 <= 64 ? hashLength33To64(bArr, i6, i7) : hashLength65Plus(bArr, i6, i7);
    }

    private static long hashLength17to32(byte[] bArr, int i6, int i7) {
        long j6 = (i7 * 2) + K2;
        long load64 = LittleEndianByteArray.load64(bArr, i6) * K1;
        long load642 = LittleEndianByteArray.load64(bArr, i6 + 8);
        int i8 = i6 + i7;
        long load643 = LittleEndianByteArray.load64(bArr, i8 - 8) * j6;
        return hashLength16(Long.rotateRight(load64 + load642, 43) + Long.rotateRight(load643, 30) + (LittleEndianByteArray.load64(bArr, i8 - 16) * K2), load64 + Long.rotateRight(load642 + K2, 18) + load643, j6);
    }

    private static long hashLength33To64(byte[] bArr, int i6, int i7) {
        long j6 = (i7 * 2) + K2;
        long load64 = LittleEndianByteArray.load64(bArr, i6) * K2;
        long load642 = LittleEndianByteArray.load64(bArr, i6 + 8);
        int i8 = i6 + i7;
        long load643 = LittleEndianByteArray.load64(bArr, i8 - 8) * j6;
        long rotateRight = Long.rotateRight(load64 + load642, 43) + Long.rotateRight(load643, 30) + (LittleEndianByteArray.load64(bArr, i8 - 16) * K2);
        long hashLength16 = hashLength16(rotateRight, load643 + Long.rotateRight(load642 + K2, 18) + load64, j6);
        long load644 = LittleEndianByteArray.load64(bArr, i6 + 16) * j6;
        long load645 = LittleEndianByteArray.load64(bArr, i6 + 24);
        long load646 = (rotateRight + LittleEndianByteArray.load64(bArr, i8 - 32)) * j6;
        return hashLength16(Long.rotateRight(load644 + load645, 43) + Long.rotateRight(load646, 30) + ((hashLength16 + LittleEndianByteArray.load64(bArr, i8 - 24)) * j6), load644 + Long.rotateRight(load64 + load645, 18) + load646, j6);
    }

    private static long hashLength65Plus(byte[] bArr, int i6, int i7) {
        byte[] bArr2 = bArr;
        long shiftMix = shiftMix(-7956866745689871395L) * K2;
        long[] jArr = new long[2];
        long[] jArr2 = new long[2];
        int i8 = i7 - 1;
        int i9 = i6 + ((i8 / 64) * 64);
        int i10 = i8 & 63;
        int i11 = i9 + i10;
        int i12 = i11 - 63;
        long j6 = 2480279821605975764L;
        long load64 = 95310865018149119L + LittleEndianByteArray.load64(bArr, i6);
        long j7 = shiftMix;
        int i13 = i6;
        while (true) {
            long rotateRight = Long.rotateRight(load64 + j6 + jArr[0] + LittleEndianByteArray.load64(bArr2, i13 + 8), 37) * K1;
            long rotateRight2 = Long.rotateRight(j6 + jArr[1] + LittleEndianByteArray.load64(bArr2, i13 + 48), 42) * K1;
            long j8 = rotateRight ^ jArr2[1];
            j6 = rotateRight2 + jArr[0] + LittleEndianByteArray.load64(bArr2, i13 + 40);
            long rotateRight3 = Long.rotateRight(j7 + jArr2[0], 33) * K1;
            weakHashLength32WithSeeds(bArr2, i13, jArr[1] * K1, j8 + jArr2[0], jArr);
            int i14 = i13;
            long[] jArr3 = jArr;
            weakHashLength32WithSeeds(bArr2, i14 + 32, rotateRight3 + jArr2[1], LittleEndianByteArray.load64(bArr2, i14 + 16) + j6, jArr2);
            i13 = i14 + 64;
            if (i13 == i9) {
                long j9 = ((j8 & 255) << 1) + K1;
                long j10 = jArr2[0] + i10;
                jArr2[0] = j10;
                long j11 = jArr3[0] + j10;
                jArr3[0] = j11;
                jArr2[0] = jArr2[0] + j11;
                long rotateRight4 = Long.rotateRight(rotateRight3 + j6 + jArr3[0] + LittleEndianByteArray.load64(bArr2, i11 - 55), 37) * j9;
                long rotateRight5 = Long.rotateRight(j6 + jArr3[1] + LittleEndianByteArray.load64(bArr2, i11 - 15), 42) * j9;
                long j12 = rotateRight4 ^ (jArr2[1] * 9);
                long load642 = rotateRight5 + (jArr3[0] * 9) + LittleEndianByteArray.load64(bArr2, i11 - 23);
                long rotateRight6 = Long.rotateRight(j8 + jArr2[0], 33) * j9;
                weakHashLength32WithSeeds(bArr2, i12, jArr3[1] * j9, jArr2[0] + j12, jArr3);
                weakHashLength32WithSeeds(bArr2, i11 - 31, rotateRight6 + jArr2[1], LittleEndianByteArray.load64(bArr2, i11 - 47) + load642, jArr2);
                return hashLength16(hashLength16(jArr3[0], jArr2[0], j9) + (shiftMix(load642) * K0) + j12, hashLength16(jArr3[1], jArr2[1], j9) + rotateRight6, j9);
            }
            bArr2 = bArr;
            j7 = j8;
            load64 = rotateRight3;
            jArr = jArr3;
        }
    }

    private static long shiftMix(long j6) {
        return j6 ^ (j6 >>> 47);
    }

    @Override // com.google.common.hash.HashFunction
    public int bits() {
        return 64;
    }

    @Override // com.google.common.hash.AbstractNonStreamingHashFunction, com.google.common.hash.AbstractHashFunction, com.google.common.hash.HashFunction
    public HashCode hashBytes(byte[] bArr, int i6, int i7) {
        Preconditions.checkPositionIndexes(i6, i6 + i7, bArr.length);
        return HashCode.fromLong(fingerprint(bArr, i6, i7));
    }

    public String toString() {
        return "Hashing.farmHashFingerprint64()";
    }

    FarmHashFingerprint64() {
    }

    private static void weakHashLength32WithSeeds(byte[] bArr, int i6, long j6, long j7, long[] jArr) {
        long load64 = LittleEndianByteArray.load64(bArr, i6);
        long load642 = LittleEndianByteArray.load64(bArr, i6 + 8);
        long load643 = LittleEndianByteArray.load64(bArr, i6 + 16);
        long load644 = LittleEndianByteArray.load64(bArr, i6 + 24);
        long j8 = j6 + load64;
        long j9 = load642 + j8 + load643;
        long rotateRight = Long.rotateRight(j7 + j8 + load644, 21) + Long.rotateRight(j9, 44);
        jArr[0] = j9 + load644;
        jArr[1] = rotateRight + j8;
    }

    private static long hashLength0to16(byte[] bArr, int i6, int i7) {
        if (i7 >= 8) {
            long j6 = (i7 * 2) + K2;
            long load64 = LittleEndianByteArray.load64(bArr, i6) + K2;
            long load642 = LittleEndianByteArray.load64(bArr, (i6 + i7) - 8);
            return hashLength16((Long.rotateRight(load642, 37) * j6) + load64, (Long.rotateRight(load64, 25) + load642) * j6, j6);
        }
        if (i7 >= 4) {
            return hashLength16(i7 + ((LittleEndianByteArray.load32(bArr, i6) & 4294967295L) << 3), LittleEndianByteArray.load32(bArr, (i6 + i7) - 4) & 4294967295L, (i7 * 2) + K2);
        }
        if (i7 <= 0) {
            return K2;
        }
        return shiftMix((((bArr[i6] & 255) + ((bArr[(i7 >> 1) + i6] & 255) << 8)) * K2) ^ ((i7 + ((bArr[i6 + (i7 - 1)] & 255) << 2)) * K0)) * K2;
    }
}
