package com.google.common.math;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Booleans;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Iterator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtCompatible(emulated = true)
/* loaded from: D:\Downloads\app\classes5.dex */
public final class DoubleMath {

    @VisibleForTesting
    static final int MAX_FACTORIAL = 170;
    private static final double MAX_INT_AS_DOUBLE = 2.147483647E9d;
    private static final double MAX_LONG_AS_DOUBLE_PLUS_ONE = 9.223372036854776E18d;
    private static final double MIN_INT_AS_DOUBLE = -2.147483648E9d;
    private static final double MIN_LONG_AS_DOUBLE = -9.223372036854776E18d;
    private static final double LN_2 = Math.log(2.0d);

    @VisibleForTesting
    static final double[] everySixteenthFactorial = {1.0d, 2.0922789888E13d, 2.631308369336935E35d, 1.2413915592536073E61d, 1.2688693218588417E89d, 7.156945704626381E118d, 9.916779348709496E149d, 1.974506857221074E182d, 3.856204823625804E215d, 5.5502938327393044E249d, 4.7147236359920616E284d};

    public static double log2(double d6) {
        return Math.log(d6) / LN_2;
    }

    @GwtIncompatible
    @Deprecated
    public static double mean(double... dArr) {
        Preconditions.checkArgument(dArr.length > 0, "Cannot take mean of 0 values");
        double checkFinite = checkFinite(dArr[0]);
        long j6 = 1;
        for (int i6 = 1; i6 < dArr.length; i6++) {
            checkFinite(dArr[i6]);
            j6++;
            checkFinite += (dArr[i6] - checkFinite) / j6;
        }
        return checkFinite;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.google.common.math.DoubleMath$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$java$math$RoundingMode;

        static {
            int[] iArr = new int[RoundingMode.values().length];
            $SwitchMap$java$math$RoundingMode = iArr;
            try {
                iArr[RoundingMode.UNNECESSARY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.FLOOR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.CEILING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.DOWN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.UP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.HALF_EVEN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.HALF_UP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.HALF_DOWN.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public static double factorial(int i6) {
        MathPreconditions.checkNonNegative("n", i6);
        if (i6 > 170) {
            return Double.POSITIVE_INFINITY;
        }
        double d6 = 1.0d;
        for (int i7 = (i6 & (-16)) + 1; i7 <= i6; i7++) {
            d6 *= i7;
        }
        return d6 * everySixteenthFactorial[i6 >> 4];
    }

    public static boolean fuzzyEquals(double d6, double d7, double d8) {
        MathPreconditions.checkNonNegative("tolerance", d8);
        if (Math.copySign(d6 - d7, 1.0d) <= d8 || d6 == d7) {
            return true;
        }
        return Double.isNaN(d6) && Double.isNaN(d7);
    }

    @GwtIncompatible
    public static boolean isPowerOfTwo(double d6) {
        if (d6 > 0.0d && DoubleUtils.isFinite(d6)) {
            long significand = DoubleUtils.getSignificand(d6);
            if ((significand & (significand - 1)) == 0) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    @com.google.common.annotations.GwtIncompatible
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int log2(double r6, java.math.RoundingMode r8) {
        /*
            r0 = 0
            r2 = 0
            r3 = 1
            int r4 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r4 <= 0) goto L10
            boolean r0 = com.google.common.math.DoubleUtils.isFinite(r6)
            if (r0 == 0) goto L10
            r0 = 1
            goto L11
        L10:
            r0 = 0
        L11:
            java.lang.String r1 = "x must be positive and finite"
            com.google.common.base.Preconditions.checkArgument(r0, r1)
            int r0 = java.lang.Math.getExponent(r6)
            boolean r1 = com.google.common.math.DoubleUtils.isNormal(r6)
            if (r1 != 0) goto L2b
            r0 = 4841369599423283200(0x4330000000000000, double:4.503599627370496E15)
            double r6 = r6 * r0
            int r6 = log2(r6, r8)
            int r6 = r6 + (-52)
            return r6
        L2b:
            int[] r1 = com.google.common.math.DoubleMath.AnonymousClass1.$SwitchMap$java$math$RoundingMode
            int r8 = r8.ordinal()
            r8 = r1[r8]
            switch(r8) {
                case 1: goto L63;
                case 2: goto L6a;
                case 3: goto L5c;
                case 4: goto L54;
                case 5: goto L4a;
                case 6: goto L3c;
                case 7: goto L3c;
                case 8: goto L3c;
                default: goto L36;
            }
        L36:
            java.lang.AssertionError r6 = new java.lang.AssertionError
            r6.<init>()
            throw r6
        L3c:
            double r6 = com.google.common.math.DoubleUtils.scaleNormalize(r6)
            double r6 = r6 * r6
            r4 = 4611686018427387904(0x4000000000000000, double:2.0)
            int r8 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r8 <= 0) goto L6a
            r2 = 1
            goto L6a
        L4a:
            if (r0 < 0) goto L4d
            r2 = 1
        L4d:
            boolean r6 = isPowerOfTwo(r6)
        L51:
            r6 = r6 ^ r3
            r2 = r2 & r6
            goto L6a
        L54:
            if (r0 >= 0) goto L57
            r2 = 1
        L57:
            boolean r6 = isPowerOfTwo(r6)
            goto L51
        L5c:
            boolean r6 = isPowerOfTwo(r6)
            r2 = r6 ^ 1
            goto L6a
        L63:
            boolean r6 = isPowerOfTwo(r6)
            com.google.common.math.MathPreconditions.checkRoundingUnnecessary(r6)
        L6a:
            if (r2 == 0) goto L6d
            int r0 = r0 + r3
        L6d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.math.DoubleMath.log2(double, java.math.RoundingMode):int");
    }

    private DoubleMath() {
    }

    @CanIgnoreReturnValue
    @GwtIncompatible
    private static double checkFinite(double d6) {
        Preconditions.checkArgument(DoubleUtils.isFinite(d6));
        return d6;
    }

    public static int fuzzyCompare(double d6, double d7, double d8) {
        if (fuzzyEquals(d6, d7, d8)) {
            return 0;
        }
        if (d6 < d7) {
            return -1;
        }
        if (d6 > d7) {
            return 1;
        }
        return Booleans.compare(Double.isNaN(d6), Double.isNaN(d7));
    }

    @GwtIncompatible
    public static boolean isMathematicalInteger(double d6) {
        if (DoubleUtils.isFinite(d6)) {
            if (d6 == 0.0d || 52 - Long.numberOfTrailingZeros(DoubleUtils.getSignificand(d6)) <= Math.getExponent(d6)) {
                return true;
            }
            return false;
        }
        return false;
    }

    @GwtIncompatible
    static double roundIntermediate(double d6, RoundingMode roundingMode) {
        int i6;
        if (DoubleUtils.isFinite(d6)) {
            switch (AnonymousClass1.$SwitchMap$java$math$RoundingMode[roundingMode.ordinal()]) {
                case 1:
                    MathPreconditions.checkRoundingUnnecessary(isMathematicalInteger(d6));
                    return d6;
                case 2:
                    if (d6 < 0.0d && !isMathematicalInteger(d6)) {
                        return ((long) d6) - 1;
                    }
                    return d6;
                case 3:
                    if (d6 > 0.0d && !isMathematicalInteger(d6)) {
                        return ((long) d6) + 1;
                    }
                    return d6;
                case 4:
                    return d6;
                case 5:
                    if (!isMathematicalInteger(d6)) {
                        long j6 = (long) d6;
                        if (d6 > 0.0d) {
                            i6 = 1;
                        } else {
                            i6 = -1;
                        }
                        return j6 + i6;
                    }
                    return d6;
                case 6:
                    return Math.rint(d6);
                case 7:
                    double rint = Math.rint(d6);
                    if (Math.abs(d6 - rint) == 0.5d) {
                        return d6 + Math.copySign(0.5d, d6);
                    }
                    return rint;
                case 8:
                    double rint2 = Math.rint(d6);
                    if (Math.abs(d6 - rint2) != 0.5d) {
                        return rint2;
                    }
                    return d6;
                default:
                    throw new AssertionError();
            }
        }
        throw new ArithmeticException("input is infinite or NaN");
    }

    @GwtIncompatible
    public static BigInteger roundToBigInteger(double d6, RoundingMode roundingMode) {
        boolean z5;
        double roundIntermediate = roundIntermediate(d6, roundingMode);
        boolean z6 = false;
        if (MIN_LONG_AS_DOUBLE - roundIntermediate < 1.0d) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (roundIntermediate < MAX_LONG_AS_DOUBLE_PLUS_ONE) {
            z6 = true;
        }
        if (z6 & z5) {
            return BigInteger.valueOf((long) roundIntermediate);
        }
        BigInteger shiftLeft = BigInteger.valueOf(DoubleUtils.getSignificand(roundIntermediate)).shiftLeft(Math.getExponent(roundIntermediate) - 52);
        if (roundIntermediate < 0.0d) {
            return shiftLeft.negate();
        }
        return shiftLeft;
    }

    @GwtIncompatible
    public static int roundToInt(double d6, RoundingMode roundingMode) {
        boolean z5;
        double roundIntermediate = roundIntermediate(d6, roundingMode);
        boolean z6 = false;
        if (roundIntermediate > -2.147483649E9d) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (roundIntermediate < 2.147483648E9d) {
            z6 = true;
        }
        MathPreconditions.checkInRangeForRoundingInputs(z5 & z6, d6, roundingMode);
        return (int) roundIntermediate;
    }

    @GwtIncompatible
    public static long roundToLong(double d6, RoundingMode roundingMode) {
        boolean z5;
        double roundIntermediate = roundIntermediate(d6, roundingMode);
        boolean z6 = false;
        if (MIN_LONG_AS_DOUBLE - roundIntermediate < 1.0d) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (roundIntermediate < MAX_LONG_AS_DOUBLE_PLUS_ONE) {
            z6 = true;
        }
        MathPreconditions.checkInRangeForRoundingInputs(z5 & z6, d6, roundingMode);
        return (long) roundIntermediate;
    }

    @Deprecated
    public static double mean(int... iArr) {
        Preconditions.checkArgument(iArr.length > 0, "Cannot take mean of 0 values");
        long j6 = 0;
        for (int i6 : iArr) {
            j6 += i6;
        }
        return j6 / iArr.length;
    }

    @Deprecated
    public static double mean(long... jArr) {
        Preconditions.checkArgument(jArr.length > 0, "Cannot take mean of 0 values");
        double d6 = jArr[0];
        long j6 = 1;
        for (int i6 = 1; i6 < jArr.length; i6++) {
            j6++;
            d6 += (jArr[i6] - d6) / j6;
        }
        return d6;
    }

    @GwtIncompatible
    @Deprecated
    public static double mean(Iterable<? extends Number> iterable) {
        return mean(iterable.iterator());
    }

    @GwtIncompatible
    @Deprecated
    public static double mean(Iterator<? extends Number> it) {
        Preconditions.checkArgument(it.hasNext(), "Cannot take mean of 0 values");
        double checkFinite = checkFinite(it.next().doubleValue());
        long j6 = 1;
        while (it.hasNext()) {
            j6++;
            checkFinite += (checkFinite(it.next().doubleValue()) - checkFinite) / j6;
        }
        return checkFinite;
    }
}
