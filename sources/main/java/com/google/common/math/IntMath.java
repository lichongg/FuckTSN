package com.google.common.math;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import com.jmolsmobile.landscapevideocapture.configuration.PredefinedCaptureConfigurations;
import com.qq.e.comm.constants.ErrorCode;
import com.tencent.bugly.BuglyStrategy;
import java.math.RoundingMode;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtCompatible(emulated = true)
/* loaded from: D:\Downloads\app\classes5.dex */
public final class IntMath {

    @VisibleForTesting
    static final int FLOOR_SQRT_MAX_INT = 46340;

    @VisibleForTesting
    static final int MAX_POWER_OF_SQRT2_UNSIGNED = -1257966797;

    @VisibleForTesting
    static final int MAX_SIGNED_POWER_OF_TWO = 1073741824;

    @VisibleForTesting
    static final byte[] maxLog10ForLeadingZeros = {9, 9, 9, 8, 8, 8, 7, 7, 7, 6, 6, 6, 6, 5, 5, 5, 4, 4, 4, 3, 3, 3, 3, 2, 2, 2, 1, 1, 1, 0, 0, 0, 0};

    @VisibleForTesting
    static final int[] powersOf10 = {1, 10, 100, 1000, 10000, BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH, 1000000, 10000000, 100000000, 1000000000};

    @VisibleForTesting
    static final int[] halfPowersOf10 = {3, 31, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_TCP_FAST_OPEN, 3162, 31622, 316227, 3162277, 31622776, 316227766, Integer.MAX_VALUE};
    private static final int[] factorials = {1, 1, 2, 6, 24, 120, PredefinedCaptureConfigurations.f35647n, ErrorCode.VIDEO_DURATION_ERROR, 40320, 362880, 3628800, 39916800, 479001600};

    @VisibleForTesting
    static int[] biggestBinomials = {Integer.MAX_VALUE, Integer.MAX_VALUE, 65536, 2345, 477, 193, 110, 75, 58, 49, 43, 39, 37, 35, 34, 34, 33};

    public static int checkedAdd(int i6, int i7) {
        long j6 = i6 + i7;
        int i8 = (int) j6;
        MathPreconditions.checkNoOverflow(j6 == ((long) i8), "checkedAdd", i6, i7);
        return i8;
    }

    public static int checkedMultiply(int i6, int i7) {
        long j6 = i6 * i7;
        int i8 = (int) j6;
        MathPreconditions.checkNoOverflow(j6 == ((long) i8), "checkedMultiply", i6, i7);
        return i8;
    }

    public static int checkedSubtract(int i6, int i7) {
        long j6 = i6 - i7;
        int i8 = (int) j6;
        MathPreconditions.checkNoOverflow(j6 == ((long) i8), "checkedSubtract", i6, i7);
        return i8;
    }

    public static boolean isPowerOfTwo(int i6) {
        return (i6 > 0) & ((i6 & (i6 + (-1))) == 0);
    }

    @Beta
    @GwtIncompatible
    public static boolean isPrime(int i6) {
        return LongMath.isPrime(i6);
    }

    @VisibleForTesting
    static int lessThanBranchFree(int i6, int i7) {
        return (~(~(i6 - i7))) >>> 31;
    }

    @Beta
    public static int saturatedAdd(int i6, int i7) {
        return Ints.saturatedCast(i6 + i7);
    }

    @Beta
    public static int saturatedMultiply(int i6, int i7) {
        return Ints.saturatedCast(i6 * i7);
    }

    @Beta
    public static int saturatedSubtract(int i6, int i7) {
        return Ints.saturatedCast(i6 - i7);
    }

    private static int sqrtFloor(int i6) {
        return (int) Math.sqrt(i6);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.google.common.math.IntMath$1, reason: invalid class name */
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

    public static int binomial(int i6, int i7) {
        MathPreconditions.checkNonNegative("n", i6);
        MathPreconditions.checkNonNegative("k", i7);
        int i8 = 0;
        Preconditions.checkArgument(i7 <= i6, "k (%s) > n (%s)", i7, i6);
        if (i7 > (i6 >> 1)) {
            i7 = i6 - i7;
        }
        int[] iArr = biggestBinomials;
        if (i7 >= iArr.length || i6 > iArr[i7]) {
            return Integer.MAX_VALUE;
        }
        if (i7 == 0) {
            return 1;
        }
        if (i7 == 1) {
            return i6;
        }
        long j6 = 1;
        while (i8 < i7) {
            long j7 = j6 * (i6 - i8);
            i8++;
            j6 = j7 / i8;
        }
        return (int) j6;
    }

    @Beta
    public static int ceilingPowerOfTwo(int i6) {
        MathPreconditions.checkPositive("x", i6);
        if (i6 <= 1073741824) {
            return 1 << (-Integer.numberOfLeadingZeros(i6 - 1));
        }
        throw new ArithmeticException("ceilingPowerOfTwo(" + i6 + ") not representable as an int");
    }

    public static int checkedPow(int i6, int i7) {
        MathPreconditions.checkNonNegative("exponent", i7);
        if (i6 == -2) {
            MathPreconditions.checkNoOverflow(i7 < 32, "checkedPow", i6, i7);
            return (i7 & 1) == 0 ? 1 << i7 : (-1) << i7;
        }
        if (i6 == -1) {
            return (i7 & 1) == 0 ? 1 : -1;
        }
        if (i6 == 0) {
            return i7 == 0 ? 1 : 0;
        }
        if (i6 == 1) {
            return 1;
        }
        if (i6 == 2) {
            MathPreconditions.checkNoOverflow(i7 < 31, "checkedPow", i6, i7);
            return 1 << i7;
        }
        int i8 = 1;
        while (i7 != 0) {
            if (i7 == 1) {
                return checkedMultiply(i8, i6);
            }
            if ((i7 & 1) != 0) {
                i8 = checkedMultiply(i8, i6);
            }
            i7 >>= 1;
            if (i7 > 0) {
                MathPreconditions.checkNoOverflow((-46340 <= i6) & (i6 <= FLOOR_SQRT_MAX_INT), "checkedPow", i6, i7);
                i6 *= i6;
            }
        }
        return i8;
    }

    public static int factorial(int i6) {
        MathPreconditions.checkNonNegative("n", i6);
        int[] iArr = factorials;
        if (i6 < iArr.length) {
            return iArr[i6];
        }
        return Integer.MAX_VALUE;
    }

    @Beta
    public static int floorPowerOfTwo(int i6) {
        MathPreconditions.checkPositive("x", i6);
        return Integer.highestOneBit(i6);
    }

    public static int gcd(int i6, int i7) {
        MathPreconditions.checkNonNegative("a", i6);
        MathPreconditions.checkNonNegative("b", i7);
        if (i6 == 0) {
            return i7;
        }
        if (i7 == 0) {
            return i6;
        }
        int numberOfTrailingZeros = Integer.numberOfTrailingZeros(i6);
        int i8 = i6 >> numberOfTrailingZeros;
        int numberOfTrailingZeros2 = Integer.numberOfTrailingZeros(i7);
        int i9 = i7 >> numberOfTrailingZeros2;
        while (i8 != i9) {
            int i10 = i8 - i9;
            int i11 = (i10 >> 31) & i10;
            int i12 = (i10 - i11) - i11;
            i9 += i11;
            i8 = i12 >> Integer.numberOfTrailingZeros(i12);
        }
        return i8 << Math.min(numberOfTrailingZeros, numberOfTrailingZeros2);
    }

    @GwtIncompatible
    public static int log10(int i6, RoundingMode roundingMode) {
        int lessThanBranchFree;
        MathPreconditions.checkPositive("x", i6);
        int log10Floor = log10Floor(i6);
        int i7 = powersOf10[log10Floor];
        switch (AnonymousClass1.$SwitchMap$java$math$RoundingMode[roundingMode.ordinal()]) {
            case 1:
                MathPreconditions.checkRoundingUnnecessary(i6 == i7);
                return log10Floor;
            case 2:
            case 3:
                return log10Floor;
            case 4:
            case 5:
                lessThanBranchFree = lessThanBranchFree(i7, i6);
                break;
            case 6:
            case 7:
            case 8:
                lessThanBranchFree = lessThanBranchFree(halfPowersOf10[log10Floor], i6);
                break;
            default:
                throw new AssertionError();
        }
        return log10Floor + lessThanBranchFree;
    }

    private static int log10Floor(int i6) {
        byte b6 = maxLog10ForLeadingZeros[Integer.numberOfLeadingZeros(i6)];
        return b6 - lessThanBranchFree(i6, powersOf10[b6]);
    }

    public static int log2(int i6, RoundingMode roundingMode) {
        MathPreconditions.checkPositive("x", i6);
        switch (AnonymousClass1.$SwitchMap$java$math$RoundingMode[roundingMode.ordinal()]) {
            case 1:
                MathPreconditions.checkRoundingUnnecessary(isPowerOfTwo(i6));
                break;
            case 2:
            case 3:
                break;
            case 4:
            case 5:
                return 32 - Integer.numberOfLeadingZeros(i6 - 1);
            case 6:
            case 7:
            case 8:
                int numberOfLeadingZeros = Integer.numberOfLeadingZeros(i6);
                return (31 - numberOfLeadingZeros) + lessThanBranchFree(MAX_POWER_OF_SQRT2_UNSIGNED >>> numberOfLeadingZeros, i6);
            default:
                throw new AssertionError();
        }
        return 31 - Integer.numberOfLeadingZeros(i6);
    }

    public static int mean(int i6, int i7) {
        return (i6 & i7) + ((i6 ^ i7) >> 1);
    }

    public static int mod(int i6, int i7) {
        if (i7 > 0) {
            int i8 = i6 % i7;
            return i8 >= 0 ? i8 : i8 + i7;
        }
        throw new ArithmeticException("Modulus " + i7 + " must be > 0");
    }

    @GwtIncompatible
    public static int pow(int i6, int i7) {
        MathPreconditions.checkNonNegative("exponent", i7);
        if (i6 == -2) {
            if (i7 < 32) {
                return (i7 & 1) == 0 ? 1 << i7 : -(1 << i7);
            }
            return 0;
        }
        if (i6 == -1) {
            return (i7 & 1) == 0 ? 1 : -1;
        }
        if (i6 == 0) {
            return i7 == 0 ? 1 : 0;
        }
        if (i6 == 1) {
            return 1;
        }
        if (i6 == 2) {
            if (i7 < 32) {
                return 1 << i7;
            }
            return 0;
        }
        int i8 = 1;
        while (i7 != 0) {
            if (i7 == 1) {
                return i6 * i8;
            }
            i8 *= (i7 & 1) == 0 ? 1 : i6;
            i6 *= i6;
            i7 >>= 1;
        }
        return i8;
    }

    @Beta
    public static int saturatedPow(int i6, int i7) {
        MathPreconditions.checkNonNegative("exponent", i7);
        if (i6 == -2) {
            return i7 >= 32 ? (i7 & 1) + Integer.MAX_VALUE : (i7 & 1) == 0 ? 1 << i7 : (-1) << i7;
        }
        if (i6 == -1) {
            return (i7 & 1) == 0 ? 1 : -1;
        }
        if (i6 == 0) {
            return i7 == 0 ? 1 : 0;
        }
        if (i6 == 1) {
            return 1;
        }
        if (i6 == 2) {
            if (i7 >= 31) {
                return Integer.MAX_VALUE;
            }
            return 1 << i7;
        }
        int i8 = ((i6 >>> 31) & i7 & 1) + Integer.MAX_VALUE;
        int i9 = 1;
        while (i7 != 0) {
            if (i7 == 1) {
                return saturatedMultiply(i9, i6);
            }
            if ((i7 & 1) != 0) {
                i9 = saturatedMultiply(i9, i6);
            }
            i7 >>= 1;
            if (i7 > 0) {
                if ((-46340 > i6) || (i6 > FLOOR_SQRT_MAX_INT)) {
                    return i8;
                }
                i6 *= i6;
            }
        }
        return i9;
    }

    @GwtIncompatible
    public static int sqrt(int i6, RoundingMode roundingMode) {
        int lessThanBranchFree;
        MathPreconditions.checkNonNegative("x", i6);
        int sqrtFloor = sqrtFloor(i6);
        switch (AnonymousClass1.$SwitchMap$java$math$RoundingMode[roundingMode.ordinal()]) {
            case 1:
                MathPreconditions.checkRoundingUnnecessary(sqrtFloor * sqrtFloor == i6);
                return sqrtFloor;
            case 2:
            case 3:
                return sqrtFloor;
            case 4:
            case 5:
                lessThanBranchFree = lessThanBranchFree(sqrtFloor * sqrtFloor, i6);
                break;
            case 6:
            case 7:
            case 8:
                lessThanBranchFree = lessThanBranchFree((sqrtFloor * sqrtFloor) + sqrtFloor, i6);
                break;
            default:
                throw new AssertionError();
        }
        return sqrtFloor + lessThanBranchFree;
    }

    private IntMath() {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int divide(int i6, int i7, RoundingMode roundingMode) {
        boolean z5;
        Preconditions.checkNotNull(roundingMode);
        if (i7 != 0) {
            int i8 = i6 / i7;
            int i9 = i6 - (i7 * i8);
            if (i9 == 0) {
                return i8;
            }
            boolean z6 = true;
            int i10 = ((i6 ^ i7) >> 31) | 1;
            switch (AnonymousClass1.$SwitchMap$java$math$RoundingMode[roundingMode.ordinal()]) {
                case 1:
                    if (i9 != 0) {
                        z6 = false;
                    }
                    MathPreconditions.checkRoundingUnnecessary(z6);
                    return i8;
                case 2:
                    return i8;
                case 3:
                    if (i10 >= 0) {
                        return i8;
                    }
                    return i8 + i10;
                case 4:
                    return i8 + i10;
                case 5:
                    if (i10 <= 0) {
                        return i8;
                    }
                    return i8 + i10;
                case 6:
                case 7:
                case 8:
                    int abs = Math.abs(i9);
                    int abs2 = abs - (Math.abs(i7) - abs);
                    if (abs2 == 0) {
                        if (roundingMode != RoundingMode.HALF_UP) {
                            if (roundingMode == RoundingMode.HALF_EVEN) {
                                z5 = true;
                            } else {
                                z5 = false;
                            }
                            if ((i8 & 1) == 0) {
                                z6 = false;
                            }
                            if (!(z5 & z6)) {
                                return i8;
                            }
                        }
                    } else if (abs2 <= 0) {
                        return i8;
                    }
                    return i8 + i10;
                default:
                    throw new AssertionError();
            }
        }
        throw new ArithmeticException("/ by zero");
    }
}
