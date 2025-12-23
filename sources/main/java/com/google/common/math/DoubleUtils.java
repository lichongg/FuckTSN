package com.google.common.math;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import java.math.BigInteger;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtIncompatible
/* loaded from: D:\Downloads\app\classes5.dex */
final class DoubleUtils {
    static final int EXPONENT_BIAS = 1023;
    static final long EXPONENT_MASK = 9218868437227405312L;
    static final long IMPLICIT_BIT = 4503599627370496L;

    @VisibleForTesting
    static final long ONE_BITS = 4607182418800017408L;
    static final int SIGNIFICAND_BITS = 52;
    static final long SIGNIFICAND_MASK = 4503599627370495L;
    static final long SIGN_MASK = Long.MIN_VALUE;

    static double nextDown(double d6) {
        return -Math.nextUp(-d6);
    }

    private DoubleUtils() {
    }

    static double bigToDouble(BigInteger bigInteger) {
        BigInteger abs = bigInteger.abs();
        int bitLength = abs.bitLength();
        int i6 = bitLength - 1;
        if (i6 < 63) {
            return bigInteger.longValue();
        }
        if (i6 > 1023) {
            return bigInteger.signum() * Double.POSITIVE_INFINITY;
        }
        int i7 = bitLength - 54;
        long longValue = abs.shiftRight(i7).longValue();
        long j6 = longValue >> 1;
        long j7 = SIGNIFICAND_MASK & j6;
        if ((longValue & 1) != 0 && ((j6 & 1) != 0 || abs.getLowestSetBit() < i7)) {
            j7++;
        }
        return Double.longBitsToDouble((((bitLength + 1022) << 52) + j7) | (bigInteger.signum() & Long.MIN_VALUE));
    }

    static double ensureNonNegative(double d6) {
        Preconditions.checkArgument(!Double.isNaN(d6));
        if (d6 <= 0.0d) {
            return 0.0d;
        }
        return d6;
    }

    static long getSignificand(double d6) {
        Preconditions.checkArgument(isFinite(d6), "not a normal value");
        int exponent = Math.getExponent(d6);
        long doubleToRawLongBits = Double.doubleToRawLongBits(d6) & SIGNIFICAND_MASK;
        if (exponent == -1023) {
            return doubleToRawLongBits << 1;
        }
        return doubleToRawLongBits | IMPLICIT_BIT;
    }

    static boolean isFinite(double d6) {
        if (Math.getExponent(d6) <= 1023) {
            return true;
        }
        return false;
    }

    static boolean isNormal(double d6) {
        if (Math.getExponent(d6) >= -1022) {
            return true;
        }
        return false;
    }

    static double scaleNormalize(double d6) {
        return Double.longBitsToDouble((Double.doubleToRawLongBits(d6) & SIGNIFICAND_MASK) | ONE_BITS);
    }
}
