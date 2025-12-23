package com.google.common.math;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtCompatible(emulated = true)
/* loaded from: D:\Downloads\app\classes5.dex */
public final class BigIntegerMath {

    @VisibleForTesting
    static final int SQRT2_PRECOMPUTE_THRESHOLD = 256;

    @VisibleForTesting
    static final BigInteger SQRT2_PRECOMPUTED_BITS = new BigInteger("16a09e667f3bcc908b2fb1366ea957d3e3adec17512775099da2f590b0667322a", 16);
    private static final double LN_10 = Math.log(10.0d);
    private static final double LN_2 = Math.log(2.0d);

    static BigInteger listProduct(List<BigInteger> list) {
        return listProduct(list, 0, list.size());
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.google.common.math.BigIntegerMath$1, reason: invalid class name */
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
                $SwitchMap$java$math$RoundingMode[RoundingMode.DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.FLOOR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.UP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.CEILING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.HALF_DOWN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.HALF_UP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.HALF_EVEN.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public static BigInteger binomial(int i6, int i7) {
        int i8;
        MathPreconditions.checkNonNegative("n", i6);
        MathPreconditions.checkNonNegative("k", i7);
        int i9 = 1;
        Preconditions.checkArgument(i7 <= i6, "k (%s) > n (%s)", i7, i6);
        if (i7 > (i6 >> 1)) {
            i7 = i6 - i7;
        }
        int[] iArr = LongMath.biggestBinomials;
        if (i7 < iArr.length && i6 <= iArr[i7]) {
            return BigInteger.valueOf(LongMath.binomial(i6, i7));
        }
        BigInteger bigInteger = BigInteger.ONE;
        long j6 = i6;
        int log2 = LongMath.log2(j6, RoundingMode.CEILING);
        long j7 = 1;
        while (true) {
            int i10 = log2;
            while (i9 < i7) {
                i8 = i6 - i9;
                i9++;
                i10 += log2;
                if (i10 >= 63) {
                    break;
                }
                j6 *= i8;
                j7 *= i9;
            }
            return bigInteger.multiply(BigInteger.valueOf(j6)).divide(BigInteger.valueOf(j7));
            bigInteger = bigInteger.multiply(BigInteger.valueOf(j6)).divide(BigInteger.valueOf(j7));
            j6 = i8;
            j7 = i9;
        }
    }

    @Beta
    public static BigInteger ceilingPowerOfTwo(BigInteger bigInteger) {
        return BigInteger.ZERO.setBit(log2(bigInteger, RoundingMode.CEILING));
    }

    @GwtIncompatible
    public static BigInteger divide(BigInteger bigInteger, BigInteger bigInteger2, RoundingMode roundingMode) {
        return new BigDecimal(bigInteger).divide(new BigDecimal(bigInteger2), 0, roundingMode).toBigIntegerExact();
    }

    public static BigInteger factorial(int i6) {
        MathPreconditions.checkNonNegative("n", i6);
        long[] jArr = LongMath.factorials;
        if (i6 < jArr.length) {
            return BigInteger.valueOf(jArr[i6]);
        }
        RoundingMode roundingMode = RoundingMode.CEILING;
        ArrayList arrayList = new ArrayList(IntMath.divide(IntMath.log2(i6, roundingMode) * i6, 64, roundingMode));
        int length = jArr.length;
        long j6 = jArr[length - 1];
        int numberOfTrailingZeros = Long.numberOfTrailingZeros(j6);
        long j7 = j6 >> numberOfTrailingZeros;
        RoundingMode roundingMode2 = RoundingMode.FLOOR;
        int log2 = LongMath.log2(j7, roundingMode2) + 1;
        long j8 = length;
        int log22 = LongMath.log2(j8, roundingMode2);
        int i7 = log22 + 1;
        int i8 = 1 << log22;
        while (j8 <= i6) {
            if ((i8 & j8) != 0) {
                i8 <<= 1;
                i7++;
            }
            int numberOfTrailingZeros2 = Long.numberOfTrailingZeros(j8);
            long j9 = j8 >> numberOfTrailingZeros2;
            numberOfTrailingZeros += numberOfTrailingZeros2;
            if ((i7 - numberOfTrailingZeros2) + log2 >= 64) {
                arrayList.add(BigInteger.valueOf(j7));
                j7 = 1;
            }
            j7 *= j9;
            log2 = LongMath.log2(j7, RoundingMode.FLOOR) + 1;
            j8++;
        }
        if (j7 > 1) {
            arrayList.add(BigInteger.valueOf(j7));
        }
        return listProduct(arrayList).shiftLeft(numberOfTrailingZeros);
    }

    @Beta
    public static BigInteger floorPowerOfTwo(BigInteger bigInteger) {
        return BigInteger.ZERO.setBit(log2(bigInteger, RoundingMode.FLOOR));
    }

    static BigInteger listProduct(List<BigInteger> list, int i6, int i7) {
        int i8 = i7 - i6;
        if (i8 == 0) {
            return BigInteger.ONE;
        }
        if (i8 == 1) {
            return list.get(i6);
        }
        if (i8 == 2) {
            return list.get(i6).multiply(list.get(i6 + 1));
        }
        if (i8 == 3) {
            return list.get(i6).multiply(list.get(i6 + 1)).multiply(list.get(i6 + 2));
        }
        int i9 = (i7 + i6) >>> 1;
        return listProduct(list, i6, i9).multiply(listProduct(list, i9, i7));
    }

    @GwtIncompatible
    public static int log10(BigInteger bigInteger, RoundingMode roundingMode) {
        int i6;
        int i7;
        MathPreconditions.checkPositive("x", bigInteger);
        if (fitsInLong(bigInteger)) {
            return LongMath.log10(bigInteger.longValue(), roundingMode);
        }
        int log2 = (int) ((log2(bigInteger, RoundingMode.FLOOR) * LN_2) / LN_10);
        BigInteger bigInteger2 = BigInteger.TEN;
        BigInteger pow = bigInteger2.pow(log2);
        int compareTo = pow.compareTo(bigInteger);
        if (compareTo > 0) {
            do {
                log2--;
                pow = pow.divide(BigInteger.TEN);
                i7 = pow.compareTo(bigInteger);
            } while (i7 > 0);
        } else {
            BigInteger multiply = bigInteger2.multiply(pow);
            int compareTo2 = multiply.compareTo(bigInteger);
            while (true) {
                int i8 = compareTo2;
                i6 = compareTo;
                compareTo = i8;
                if (compareTo > 0) {
                    break;
                }
                log2++;
                BigInteger multiply2 = BigInteger.TEN.multiply(multiply);
                compareTo2 = multiply2.compareTo(bigInteger);
                pow = multiply;
                multiply = multiply2;
            }
            i7 = i6;
        }
        switch (AnonymousClass1.$SwitchMap$java$math$RoundingMode[roundingMode.ordinal()]) {
            case 1:
                MathPreconditions.checkRoundingUnnecessary(i7 == 0);
                return log2;
            case 2:
            case 3:
                return log2;
            case 4:
            case 5:
                return pow.equals(bigInteger) ? log2 : log2 + 1;
            case 6:
            case 7:
            case 8:
                return bigInteger.pow(2).compareTo(pow.pow(2).multiply(BigInteger.TEN)) <= 0 ? log2 : log2 + 1;
            default:
                throw new AssertionError();
        }
    }

    @GwtIncompatible
    public static BigInteger sqrt(BigInteger bigInteger, RoundingMode roundingMode) {
        MathPreconditions.checkNonNegative("x", bigInteger);
        if (fitsInLong(bigInteger)) {
            return BigInteger.valueOf(LongMath.sqrt(bigInteger.longValue(), roundingMode));
        }
        BigInteger sqrtFloor = sqrtFloor(bigInteger);
        switch (AnonymousClass1.$SwitchMap$java$math$RoundingMode[roundingMode.ordinal()]) {
            case 1:
                MathPreconditions.checkRoundingUnnecessary(sqrtFloor.pow(2).equals(bigInteger));
                return sqrtFloor;
            case 2:
            case 3:
                return sqrtFloor;
            case 4:
            case 5:
                int intValue = sqrtFloor.intValue();
                return (intValue * intValue == bigInteger.intValue() && sqrtFloor.pow(2).equals(bigInteger)) ? sqrtFloor : sqrtFloor.add(BigInteger.ONE);
            case 6:
            case 7:
            case 8:
                return sqrtFloor.pow(2).add(sqrtFloor).compareTo(bigInteger) >= 0 ? sqrtFloor : sqrtFloor.add(BigInteger.ONE);
            default:
                throw new AssertionError();
        }
    }

    @GwtIncompatible
    private static BigInteger sqrtFloor(BigInteger bigInteger) {
        BigInteger shiftLeft;
        int log2 = log2(bigInteger, RoundingMode.FLOOR);
        if (log2 < 1023) {
            shiftLeft = sqrtApproxWithDoubles(bigInteger);
        } else {
            int i6 = (log2 - 52) & (-2);
            shiftLeft = sqrtApproxWithDoubles(bigInteger.shiftRight(i6)).shiftLeft(i6 >> 1);
        }
        BigInteger shiftRight = shiftLeft.add(bigInteger.divide(shiftLeft)).shiftRight(1);
        if (shiftLeft.equals(shiftRight)) {
            return shiftLeft;
        }
        while (true) {
            BigInteger shiftRight2 = shiftRight.add(bigInteger.divide(shiftRight)).shiftRight(1);
            if (shiftRight2.compareTo(shiftRight) >= 0) {
                return shiftRight;
            }
            shiftRight = shiftRight2;
        }
    }

    private BigIntegerMath() {
    }

    @GwtIncompatible
    static boolean fitsInLong(BigInteger bigInteger) {
        if (bigInteger.bitLength() <= 63) {
            return true;
        }
        return false;
    }

    public static boolean isPowerOfTwo(BigInteger bigInteger) {
        Preconditions.checkNotNull(bigInteger);
        if (bigInteger.signum() > 0 && bigInteger.getLowestSetBit() == bigInteger.bitLength() - 1) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0051 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int log2(java.math.BigInteger r3, java.math.RoundingMode r4) {
        /*
            java.lang.Object r0 = com.google.common.base.Preconditions.checkNotNull(r3)
            java.math.BigInteger r0 = (java.math.BigInteger) r0
            java.lang.String r1 = "x"
            com.google.common.math.MathPreconditions.checkPositive(r1, r0)
            int r0 = r3.bitLength()
            int r1 = r0 + (-1)
            int[] r2 = com.google.common.math.BigIntegerMath.AnonymousClass1.$SwitchMap$java$math$RoundingMode
            int r4 = r4.ordinal()
            r4 = r2[r4]
            switch(r4) {
                case 1: goto L52;
                case 2: goto L51;
                case 3: goto L51;
                case 4: goto L49;
                case 5: goto L49;
                case 6: goto L22;
                case 7: goto L22;
                case 8: goto L22;
                default: goto L1c;
            }
        L1c:
            java.lang.AssertionError r3 = new java.lang.AssertionError
            r3.<init>()
            throw r3
        L22:
            r4 = 256(0x100, float:3.59E-43)
            if (r1 >= r4) goto L36
            java.math.BigInteger r4 = com.google.common.math.BigIntegerMath.SQRT2_PRECOMPUTED_BITS
            int r2 = 256 - r1
            java.math.BigInteger r4 = r4.shiftRight(r2)
            int r3 = r3.compareTo(r4)
            if (r3 > 0) goto L35
            goto L51
        L35:
            return r0
        L36:
            r4 = 2
            java.math.BigInteger r3 = r3.pow(r4)
            int r3 = r3.bitLength()
            int r3 = r3 + (-1)
            int r4 = r1 * 2
            int r4 = r4 + 1
            if (r3 >= r4) goto L48
            goto L51
        L48:
            return r0
        L49:
            boolean r3 = isPowerOfTwo(r3)
            if (r3 == 0) goto L50
            goto L51
        L50:
            return r0
        L51:
            return r1
        L52:
            boolean r3 = isPowerOfTwo(r3)
            com.google.common.math.MathPreconditions.checkRoundingUnnecessary(r3)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.math.BigIntegerMath.log2(java.math.BigInteger, java.math.RoundingMode):int");
    }

    @GwtIncompatible
    private static BigInteger sqrtApproxWithDoubles(BigInteger bigInteger) {
        return DoubleMath.roundToBigInteger(Math.sqrt(DoubleUtils.bigToDouble(bigInteger)), RoundingMode.HALF_EVEN);
    }
}
