package com.google.common.math;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.math.BigInteger;
import java.math.RoundingMode;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@CanIgnoreReturnValue
@GwtCompatible
/* loaded from: D:\Downloads\app\classes5.dex */
final class MathPreconditions {
    static void checkNoOverflow(boolean z5, String str, int i6, int i7) {
        if (z5) {
            return;
        }
        throw new ArithmeticException("overflow: " + str + "(" + i6 + ", " + i7 + ")");
    }

    static int checkNonNegative(@NullableDecl String str, int i6) {
        if (i6 >= 0) {
            return i6;
        }
        throw new IllegalArgumentException(str + " (" + i6 + ") must be >= 0");
    }

    static int checkPositive(@NullableDecl String str, int i6) {
        if (i6 > 0) {
            return i6;
        }
        throw new IllegalArgumentException(str + " (" + i6 + ") must be > 0");
    }

    static void checkInRangeForRoundingInputs(boolean z5, double d6, RoundingMode roundingMode) {
        if (z5) {
            return;
        }
        throw new ArithmeticException("rounded value is out of range for input " + d6 + " and rounding mode " + roundingMode);
    }

    static void checkNoOverflow(boolean z5, String str, long j6, long j7) {
        if (z5) {
            return;
        }
        throw new ArithmeticException("overflow: " + str + "(" + j6 + ", " + j7 + ")");
    }

    static long checkNonNegative(@NullableDecl String str, long j6) {
        if (j6 >= 0) {
            return j6;
        }
        throw new IllegalArgumentException(str + " (" + j6 + ") must be >= 0");
    }

    static long checkPositive(@NullableDecl String str, long j6) {
        if (j6 > 0) {
            return j6;
        }
        throw new IllegalArgumentException(str + " (" + j6 + ") must be > 0");
    }

    static void checkRoundingUnnecessary(boolean z5) {
        if (!z5) {
            throw new ArithmeticException("mode was UNNECESSARY, but rounding was necessary");
        }
    }

    private MathPreconditions() {
    }

    static BigInteger checkNonNegative(@NullableDecl String str, BigInteger bigInteger) {
        if (bigInteger.signum() >= 0) {
            return bigInteger;
        }
        throw new IllegalArgumentException(str + " (" + bigInteger + ") must be >= 0");
    }

    static BigInteger checkPositive(@NullableDecl String str, BigInteger bigInteger) {
        if (bigInteger.signum() > 0) {
            return bigInteger;
        }
        throw new IllegalArgumentException(str + " (" + bigInteger + ") must be > 0");
    }

    static double checkNonNegative(@NullableDecl String str, double d6) {
        if (d6 >= 0.0d) {
            return d6;
        }
        throw new IllegalArgumentException(str + " (" + d6 + ") must be >= 0");
    }
}
