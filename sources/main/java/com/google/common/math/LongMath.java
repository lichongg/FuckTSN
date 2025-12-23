package com.google.common.math;

import com.alibaba.fastjson.asm.Opcodes;
import com.bykv.vk.component.ttvideo.player.C;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.primitives.UnsignedLongs;
import java.math.RoundingMode;
import okhttp3.internal.connection.RealConnection;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtCompatible(emulated = true)
/* loaded from: D:\Downloads\app\classes5.dex */
public final class LongMath {

    @VisibleForTesting
    static final long FLOOR_SQRT_MAX_LONG = 3037000499L;

    @VisibleForTesting
    static final long MAX_POWER_OF_SQRT2_UNSIGNED = -5402926248376769404L;

    @VisibleForTesting
    static final long MAX_SIGNED_POWER_OF_TWO = 4611686018427387904L;
    private static final int SIEVE_30 = -545925251;

    @VisibleForTesting
    static final byte[] maxLog10ForLeadingZeros = {19, 18, 18, 18, 18, 17, 17, 17, 16, 16, 16, 15, 15, 15, 15, 14, 14, 14, 13, 13, 13, 12, 12, 12, 12, 11, 11, 11, 10, 10, 10, 9, 9, 9, 9, 8, 8, 8, 7, 7, 7, 6, 6, 6, 6, 5, 5, 5, 4, 4, 4, 3, 3, 3, 3, 2, 2, 2, 1, 1, 1, 0, 0, 0};

    @VisibleForTesting
    @GwtIncompatible
    static final long[] powersOf10 = {1, 10, 100, 1000, 10000, 100000, C.MICROS_PER_SECOND, 10000000, 100000000, C.NANOS_PER_SECOND, RealConnection.IDLE_CONNECTION_HEALTHY_NS, 100000000000L, 1000000000000L, 10000000000000L, 100000000000000L, 1000000000000000L, 10000000000000000L, 100000000000000000L, 1000000000000000000L};

    @VisibleForTesting
    @GwtIncompatible
    static final long[] halfPowersOf10 = {3, 31, 316, 3162, 31622, 316227, 3162277, 31622776, 316227766, 3162277660L, 31622776601L, 316227766016L, 3162277660168L, 31622776601683L, 316227766016837L, 3162277660168379L, 31622776601683793L, 316227766016837933L, 3162277660168379331L};
    static final long[] factorials = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600, 6227020800L, 87178291200L, 1307674368000L, 20922789888000L, 355687428096000L, 6402373705728000L, 121645100408832000L, 2432902008176640000L};
    static final int[] biggestBinomials = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 3810779, 121977, 16175, 4337, 1733, 887, 534, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DECODER_STALL, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_TRAN_CONNECT_TIME, 206, Opcodes.RET, 143, 125, 111, 101, 94, 88, 83, 79, 76, 74, 72, 70, 69, 68, 67, 67, 66, 66, 66, 66};

    @VisibleForTesting
    static final int[] biggestSimpleBinomials = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 2642246, 86251, 11724, 3218, 1313, 684, 419, MediaPlayer.MEDIA_PLAYER_OPTION_HANDLE_AUDIO_EXTRADATA, 214, Opcodes.RET, MediaPlayer.MEDIA_PLAYER_OPTION_RENDER_DEVICE, 119, 105, 95, 87, 81, 76, 73, 70, 68, 66, 64, 63, 62, 62, 61, 61, 61};
    private static final long[][] millerRabinBaseSets = {new long[]{291830, 126401071349994536L}, new long[]{885594168, 725270293939359937L, 3569819667048198375L}, new long[]{273919523040L, 15, 7363882082L, 992620450144556L}, new long[]{47636622961200L, 2, 2570940, 211991001, 3749873356L}, new long[]{7999252175582850L, 2, 4130806001517L, 149795463772692060L, 186635894390467037L, 3967304179347715805L}, new long[]{585226005592931976L, 2, 123635709730000L, 9233062284813009L, 43835965440333360L, 761179012939631437L, 1263739024124850375L}, new long[]{Long.MAX_VALUE, 2, 325, 9375, 28178, 450775, 9780504, 1795265022}};

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private enum MillerRabinTester {
        SMALL { // from class: com.google.common.math.LongMath.MillerRabinTester.1
            @Override // com.google.common.math.LongMath.MillerRabinTester
            long mulMod(long j6, long j7, long j8) {
                return (j6 * j7) % j8;
            }

            @Override // com.google.common.math.LongMath.MillerRabinTester
            long squareMod(long j6, long j7) {
                return (j6 * j6) % j7;
            }
        },
        LARGE { // from class: com.google.common.math.LongMath.MillerRabinTester.2
            private long plusMod(long j6, long j7, long j8) {
                long j9 = j6 + j7;
                return j6 >= j8 - j7 ? j9 - j8 : j9;
            }

            private long times2ToThe32Mod(long j6, long j7) {
                int i6 = 32;
                do {
                    int min = Math.min(i6, Long.numberOfLeadingZeros(j6));
                    j6 = UnsignedLongs.remainder(j6 << min, j7);
                    i6 -= min;
                } while (i6 > 0);
                return j6;
            }

            @Override // com.google.common.math.LongMath.MillerRabinTester
            long mulMod(long j6, long j7, long j8) {
                long j9 = j6 >>> 32;
                long j10 = j7 >>> 32;
                long j11 = j6 & 4294967295L;
                long j12 = j7 & 4294967295L;
                long times2ToThe32Mod = times2ToThe32Mod(j9 * j10, j8) + (j9 * j12);
                if (times2ToThe32Mod < 0) {
                    times2ToThe32Mod = UnsignedLongs.remainder(times2ToThe32Mod, j8);
                }
                Long.signum(j11);
                return plusMod(times2ToThe32Mod(times2ToThe32Mod + (j10 * j11), j8), UnsignedLongs.remainder(j11 * j12, j8), j8);
            }

            @Override // com.google.common.math.LongMath.MillerRabinTester
            long squareMod(long j6, long j7) {
                long j8 = j6 >>> 32;
                long j9 = j6 & 4294967295L;
                long times2ToThe32Mod = times2ToThe32Mod(j8 * j8, j7);
                long j10 = j8 * j9 * 2;
                if (j10 < 0) {
                    j10 = UnsignedLongs.remainder(j10, j7);
                }
                return plusMod(times2ToThe32Mod(times2ToThe32Mod + j10, j7), UnsignedLongs.remainder(j9 * j9, j7), j7);
            }
        };

        abstract long mulMod(long j6, long j7, long j8);

        abstract long squareMod(long j6, long j7);

        /* synthetic */ MillerRabinTester(AnonymousClass1 anonymousClass1) {
            this();
        }

        private long powMod(long j6, long j7, long j8) {
            long j9;
            long j10 = j6;
            long j11 = 1;
            while (j7 != 0) {
                if ((j7 & 1) != 0) {
                    j9 = j8;
                    j11 = mulMod(j11, j10, j9);
                } else {
                    j9 = j8;
                }
                j10 = squareMod(j10, j9);
                j7 >>= 1;
                j8 = j9;
            }
            return j11;
        }

        private boolean testWitness(long j6, long j7) {
            long j8 = j7 - 1;
            int numberOfTrailingZeros = Long.numberOfTrailingZeros(j8);
            long j9 = j8 >> numberOfTrailingZeros;
            long j10 = j6 % j7;
            if (j10 == 0) {
                return true;
            }
            long powMod = powMod(j10, j9, j7);
            if (powMod == 1) {
                return true;
            }
            int i6 = 0;
            while (powMod != j8) {
                i6++;
                if (i6 == numberOfTrailingZeros) {
                    return false;
                }
                powMod = squareMod(powMod, j7);
            }
            return true;
        }

        static boolean test(long j6, long j7) {
            MillerRabinTester millerRabinTester;
            if (j7 <= LongMath.FLOOR_SQRT_MAX_LONG) {
                millerRabinTester = SMALL;
            } else {
                millerRabinTester = LARGE;
            }
            return millerRabinTester.testWitness(j6, j7);
        }
    }

    @GwtIncompatible
    public static long checkedPow(long j6, int i6) {
        int i7 = i6;
        MathPreconditions.checkNonNegative("exponent", i7);
        long j7 = 1;
        if (!(j6 >= -2) || !(j6 <= 2)) {
            long j8 = j6;
            while (i7 != 0) {
                if (i7 == 1) {
                    return checkedMultiply(j7, j8);
                }
                if ((i7 & 1) != 0) {
                    j7 = checkedMultiply(j7, j8);
                }
                i7 >>= 1;
                if (i7 > 0) {
                    MathPreconditions.checkNoOverflow(-3037000499L <= j8 && j8 <= FLOOR_SQRT_MAX_LONG, "checkedPow", j8, i7);
                    j8 *= j8;
                }
            }
            return j7;
        }
        int i8 = (int) j6;
        if (i8 == -2) {
            MathPreconditions.checkNoOverflow(i7 < 64, "checkedPow", j6, i7);
            return (i7 & 1) == 0 ? 1 << i7 : (-1) << i7;
        }
        if (i8 == -1) {
            return (i7 & 1) == 0 ? 1L : -1L;
        }
        if (i8 == 0) {
            return i7 == 0 ? 1L : 0L;
        }
        if (i8 == 1) {
            return 1L;
        }
        if (i8 != 2) {
            throw new AssertionError();
        }
        MathPreconditions.checkNoOverflow(i7 < 63, "checkedPow", j6, i7);
        return 1 << i7;
    }

    static boolean fitsInInt(long j6) {
        return ((long) ((int) j6)) == j6;
    }

    public static boolean isPowerOfTwo(long j6) {
        return (j6 > 0) & ((j6 & (j6 - 1)) == 0);
    }

    @VisibleForTesting
    static int lessThanBranchFree(long j6, long j7) {
        return (int) ((~(~(j6 - j7))) >>> 63);
    }

    @GwtIncompatible
    public static int mod(long j6, int i6) {
        return (int) mod(j6, i6);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.google.common.math.LongMath$1, reason: invalid class name */
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

    public static long binomial(int i6, int i7) {
        MathPreconditions.checkNonNegative("n", i6);
        MathPreconditions.checkNonNegative("k", i7);
        Preconditions.checkArgument(i7 <= i6, "k (%s) > n (%s)", i7, i6);
        if (i7 > (i6 >> 1)) {
            i7 = i6 - i7;
        }
        long j6 = 1;
        if (i7 == 0) {
            return 1L;
        }
        if (i7 == 1) {
            return i6;
        }
        long[] jArr = factorials;
        if (i6 < jArr.length) {
            return jArr[i6] / (jArr[i7] * jArr[i6 - i7]);
        }
        int[] iArr = biggestBinomials;
        if (i7 >= iArr.length || i6 > iArr[i7]) {
            return Long.MAX_VALUE;
        }
        int[] iArr2 = biggestSimpleBinomials;
        if (i7 < iArr2.length && i6 <= iArr2[i7]) {
            int i8 = i6 - 1;
            long j7 = i6;
            for (int i9 = 2; i9 <= i7; i9++) {
                j7 = (j7 * i8) / i9;
                i8--;
            }
            return j7;
        }
        long j8 = i6;
        int log2 = log2(j8, RoundingMode.CEILING);
        int i10 = i6 - 1;
        int i11 = log2;
        long j9 = j8;
        int i12 = 2;
        long j10 = 1;
        while (i12 <= i7) {
            i11 += log2;
            if (i11 < 63) {
                j9 *= i10;
                j10 *= i12;
            } else {
                j6 = multiplyFraction(j6, j9, j10);
                j9 = i10;
                j10 = i12;
                i11 = log2;
            }
            i12++;
            i10--;
        }
        return multiplyFraction(j6, j9, j10);
    }

    @Beta
    public static long ceilingPowerOfTwo(long j6) {
        MathPreconditions.checkPositive("x", j6);
        if (j6 <= 4611686018427387904L) {
            return 1 << (-Long.numberOfLeadingZeros(j6 - 1));
        }
        throw new ArithmeticException("ceilingPowerOfTwo(" + j6 + ") is not representable as a long");
    }

    @GwtIncompatible
    public static long checkedAdd(long j6, long j7) {
        long j8 = j6 + j7;
        MathPreconditions.checkNoOverflow(((j6 ^ j7) < 0) | ((j6 ^ j8) >= 0), "checkedAdd", j6, j7);
        return j8;
    }

    @GwtIncompatible
    public static long checkedSubtract(long j6, long j7) {
        long j8 = j6 - j7;
        MathPreconditions.checkNoOverflow(((j6 ^ j7) >= 0) | ((j6 ^ j8) >= 0), "checkedSubtract", j6, j7);
        return j8;
    }

    @GwtIncompatible
    public static long factorial(int i6) {
        MathPreconditions.checkNonNegative("n", i6);
        long[] jArr = factorials;
        if (i6 < jArr.length) {
            return jArr[i6];
        }
        return Long.MAX_VALUE;
    }

    @Beta
    public static long floorPowerOfTwo(long j6) {
        MathPreconditions.checkPositive("x", j6);
        return 1 << (63 - Long.numberOfLeadingZeros(j6));
    }

    public static long gcd(long j6, long j7) {
        MathPreconditions.checkNonNegative("a", j6);
        MathPreconditions.checkNonNegative("b", j7);
        if (j6 == 0) {
            return j7;
        }
        if (j7 == 0) {
            return j6;
        }
        int numberOfTrailingZeros = Long.numberOfTrailingZeros(j6);
        long j8 = j6 >> numberOfTrailingZeros;
        int numberOfTrailingZeros2 = Long.numberOfTrailingZeros(j7);
        long j9 = j7 >> numberOfTrailingZeros2;
        while (j8 != j9) {
            long j10 = j8 - j9;
            long j11 = (j10 >> 63) & j10;
            long j12 = (j10 - j11) - j11;
            j9 += j11;
            j8 = j12 >> Long.numberOfTrailingZeros(j12);
        }
        return j8 << Math.min(numberOfTrailingZeros, numberOfTrailingZeros2);
    }

    @Beta
    @GwtIncompatible
    public static boolean isPrime(long j6) {
        if (j6 < 2) {
            MathPreconditions.checkNonNegative("n", j6);
            return false;
        }
        if (j6 == 2 || j6 == 3 || j6 == 5 || j6 == 7 || j6 == 11 || j6 == 13) {
            return true;
        }
        if (((1 << ((int) (j6 % 30))) & SIEVE_30) != 0 || j6 % 7 == 0 || j6 % 11 == 0 || j6 % 13 == 0) {
            return false;
        }
        if (j6 < 289) {
            return true;
        }
        for (long[] jArr : millerRabinBaseSets) {
            if (j6 <= jArr[0]) {
                for (int i6 = 1; i6 < jArr.length; i6++) {
                    if (!MillerRabinTester.test(jArr[i6], j6)) {
                        return false;
                    }
                }
                return true;
            }
        }
        throw new AssertionError();
    }

    @GwtIncompatible
    public static int log10(long j6, RoundingMode roundingMode) {
        int lessThanBranchFree;
        MathPreconditions.checkPositive("x", j6);
        int log10Floor = log10Floor(j6);
        long j7 = powersOf10[log10Floor];
        switch (AnonymousClass1.$SwitchMap$java$math$RoundingMode[roundingMode.ordinal()]) {
            case 1:
                MathPreconditions.checkRoundingUnnecessary(j6 == j7);
                return log10Floor;
            case 2:
            case 3:
                return log10Floor;
            case 4:
            case 5:
                lessThanBranchFree = lessThanBranchFree(j7, j6);
                break;
            case 6:
            case 7:
            case 8:
                lessThanBranchFree = lessThanBranchFree(halfPowersOf10[log10Floor], j6);
                break;
            default:
                throw new AssertionError();
        }
        return log10Floor + lessThanBranchFree;
    }

    @GwtIncompatible
    static int log10Floor(long j6) {
        byte b6 = maxLog10ForLeadingZeros[Long.numberOfLeadingZeros(j6)];
        return b6 - lessThanBranchFree(j6, powersOf10[b6]);
    }

    public static int log2(long j6, RoundingMode roundingMode) {
        MathPreconditions.checkPositive("x", j6);
        switch (AnonymousClass1.$SwitchMap$java$math$RoundingMode[roundingMode.ordinal()]) {
            case 1:
                MathPreconditions.checkRoundingUnnecessary(isPowerOfTwo(j6));
                break;
            case 2:
            case 3:
                break;
            case 4:
            case 5:
                return 64 - Long.numberOfLeadingZeros(j6 - 1);
            case 6:
            case 7:
            case 8:
                int numberOfLeadingZeros = Long.numberOfLeadingZeros(j6);
                return (63 - numberOfLeadingZeros) + lessThanBranchFree(MAX_POWER_OF_SQRT2_UNSIGNED >>> numberOfLeadingZeros, j6);
            default:
                throw new AssertionError("impossible");
        }
        return 63 - Long.numberOfLeadingZeros(j6);
    }

    public static long mean(long j6, long j7) {
        return (j6 & j7) + ((j6 ^ j7) >> 1);
    }

    @GwtIncompatible
    public static long mod(long j6, long j7) {
        if (j7 <= 0) {
            throw new ArithmeticException("Modulus must be positive");
        }
        long j8 = j6 % j7;
        return j8 >= 0 ? j8 : j8 + j7;
    }

    static long multiplyFraction(long j6, long j7, long j8) {
        if (j6 == 1) {
            return j7 / j8;
        }
        long gcd = gcd(j6, j8);
        return (j6 / gcd) * (j7 / (j8 / gcd));
    }

    @GwtIncompatible
    public static long pow(long j6, int i6) {
        MathPreconditions.checkNonNegative("exponent", i6);
        if (-2 > j6 || j6 > 2) {
            long j7 = 1;
            while (i6 != 0) {
                if (i6 == 1) {
                    return j7 * j6;
                }
                j7 *= (i6 & 1) == 0 ? 1L : j6;
                j6 *= j6;
                i6 >>= 1;
            }
            return j7;
        }
        int i7 = (int) j6;
        if (i7 == -2) {
            if (i6 < 64) {
                return (i6 & 1) == 0 ? 1 << i6 : -(1 << i6);
            }
            return 0L;
        }
        if (i7 == -1) {
            return (i6 & 1) == 0 ? 1L : -1L;
        }
        if (i7 == 0) {
            return i6 == 0 ? 1L : 0L;
        }
        if (i7 == 1) {
            return 1L;
        }
        if (i7 != 2) {
            throw new AssertionError();
        }
        if (i6 < 64) {
            return 1 << i6;
        }
        return 0L;
    }

    @Beta
    public static long saturatedAdd(long j6, long j7) {
        long j8 = j6 + j7;
        return (((j7 ^ j6) > 0L ? 1 : ((j7 ^ j6) == 0L ? 0 : -1)) < 0) | ((j6 ^ j8) >= 0) ? j8 : ((j8 >>> 63) ^ 1) + Long.MAX_VALUE;
    }

    @Beta
    public static long saturatedPow(long j6, int i6) {
        MathPreconditions.checkNonNegative("exponent", i6);
        long j7 = 1;
        if (!(j6 >= -2) || !(j6 <= 2)) {
            long j8 = ((j6 >>> 63) & i6 & 1) + Long.MAX_VALUE;
            while (i6 != 0) {
                if (i6 == 1) {
                    return saturatedMultiply(j7, j6);
                }
                if ((i6 & 1) != 0) {
                    j7 = saturatedMultiply(j7, j6);
                }
                i6 >>= 1;
                if (i6 > 0) {
                    if ((-3037000499L > j6) || (j6 > FLOOR_SQRT_MAX_LONG)) {
                        return j8;
                    }
                    j6 *= j6;
                }
            }
            return j7;
        }
        int i7 = (int) j6;
        if (i7 == -2) {
            return i6 >= 64 ? (i6 & 1) + Long.MAX_VALUE : (i6 & 1) == 0 ? 1 << i6 : (-1) << i6;
        }
        if (i7 == -1) {
            return (i6 & 1) == 0 ? 1L : -1L;
        }
        if (i7 == 0) {
            return i6 == 0 ? 1L : 0L;
        }
        if (i7 == 1) {
            return 1L;
        }
        if (i7 != 2) {
            throw new AssertionError();
        }
        if (i6 >= 63) {
            return Long.MAX_VALUE;
        }
        return 1 << i6;
    }

    @Beta
    public static long saturatedSubtract(long j6, long j7) {
        long j8 = j6 - j7;
        return (((j7 ^ j6) > 0L ? 1 : ((j7 ^ j6) == 0L ? 0 : -1)) >= 0) | ((j6 ^ j8) >= 0) ? j8 : ((j8 >>> 63) ^ 1) + Long.MAX_VALUE;
    }

    @GwtIncompatible
    public static long sqrt(long j6, RoundingMode roundingMode) {
        MathPreconditions.checkNonNegative("x", j6);
        if (fitsInInt(j6)) {
            return IntMath.sqrt((int) j6, roundingMode);
        }
        long sqrt = (long) Math.sqrt(j6);
        long j7 = sqrt * sqrt;
        switch (AnonymousClass1.$SwitchMap$java$math$RoundingMode[roundingMode.ordinal()]) {
            case 1:
                MathPreconditions.checkRoundingUnnecessary(j7 == j6);
                return sqrt;
            case 2:
            case 3:
                return j6 < j7 ? sqrt - 1 : sqrt;
            case 4:
            case 5:
                return j6 > j7 ? sqrt + 1 : sqrt;
            case 6:
            case 7:
            case 8:
                return (sqrt - (j6 < j7 ? 1 : 0)) + lessThanBranchFree((r0 * r0) + r0, j6);
            default:
                throw new AssertionError();
        }
    }

    private LongMath() {
    }

    public static long checkedMultiply(long j6, long j7) {
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        int numberOfLeadingZeros = Long.numberOfLeadingZeros(j6) + Long.numberOfLeadingZeros(~j6) + Long.numberOfLeadingZeros(j7) + Long.numberOfLeadingZeros(~j7);
        if (numberOfLeadingZeros > 65) {
            return j6 * j7;
        }
        if (numberOfLeadingZeros >= 64) {
            z5 = true;
        } else {
            z5 = false;
        }
        MathPreconditions.checkNoOverflow(z5, "checkedMultiply", j6, j7);
        if (j6 >= 0) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (j7 != Long.MIN_VALUE) {
            z7 = true;
        } else {
            z7 = false;
        }
        MathPreconditions.checkNoOverflow(z6 | z7, "checkedMultiply", j6, j7);
        long j8 = j6 * j7;
        if (j6 != 0 && j8 / j6 != j7) {
            z8 = false;
        } else {
            z8 = true;
        }
        MathPreconditions.checkNoOverflow(z8, "checkedMultiply", j6, j7);
        return j8;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0051, code lost:
    
        if (r2 > 0) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0054, code lost:
    
        if (r10 > 0) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0057, code lost:
    
        if (r10 < 0) goto L35;
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    @com.google.common.annotations.GwtIncompatible
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static long divide(long r9, long r11, java.math.RoundingMode r13) {
        /*
            com.google.common.base.Preconditions.checkNotNull(r13)
            long r0 = r9 / r11
            long r2 = r11 * r0
            long r2 = r9 - r2
            r4 = 0
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 != 0) goto L10
            goto L66
        L10:
            long r9 = r9 ^ r11
            r7 = 63
            long r9 = r9 >> r7
            int r10 = (int) r9
            r9 = 1
            r10 = r10 | r9
            int[] r7 = com.google.common.math.LongMath.AnonymousClass1.$SwitchMap$java$math$RoundingMode
            int r8 = r13.ordinal()
            r7 = r7[r8]
            r8 = 0
            switch(r7) {
                case 1: goto L5a;
                case 2: goto L61;
                case 3: goto L57;
                case 4: goto L62;
                case 5: goto L54;
                case 6: goto L29;
                case 7: goto L29;
                case 8: goto L29;
                default: goto L23;
            }
        L23:
            java.lang.AssertionError r9 = new java.lang.AssertionError
            r9.<init>()
            throw r9
        L29:
            long r2 = java.lang.Math.abs(r2)
            long r11 = java.lang.Math.abs(r11)
            long r11 = r11 - r2
            long r2 = r2 - r11
            int r11 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r11 != 0) goto L51
            java.math.RoundingMode r11 = java.math.RoundingMode.HALF_UP
            if (r13 != r11) goto L3d
            r11 = 1
            goto L3e
        L3d:
            r11 = 0
        L3e:
            java.math.RoundingMode r12 = java.math.RoundingMode.HALF_EVEN
            if (r13 != r12) goto L44
            r12 = 1
            goto L45
        L44:
            r12 = 0
        L45:
            r2 = 1
            long r2 = r2 & r0
            int r13 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r13 == 0) goto L4d
            goto L4e
        L4d:
            r9 = 0
        L4e:
            r9 = r9 & r12
            r9 = r9 | r11
            goto L62
        L51:
            if (r11 <= 0) goto L61
            goto L62
        L54:
            if (r10 <= 0) goto L61
            goto L62
        L57:
            if (r10 >= 0) goto L61
            goto L62
        L5a:
            if (r6 != 0) goto L5d
            goto L5e
        L5d:
            r9 = 0
        L5e:
            com.google.common.math.MathPreconditions.checkRoundingUnnecessary(r9)
        L61:
            r9 = 0
        L62:
            if (r9 == 0) goto L66
            long r9 = (long) r10
            long r0 = r0 + r9
        L66:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.math.LongMath.divide(long, long, java.math.RoundingMode):long");
    }

    @Beta
    public static long saturatedMultiply(long j6, long j7) {
        boolean z5;
        boolean z6;
        int numberOfLeadingZeros = Long.numberOfLeadingZeros(j6) + Long.numberOfLeadingZeros(~j6) + Long.numberOfLeadingZeros(j7) + Long.numberOfLeadingZeros(~j7);
        if (numberOfLeadingZeros > 65) {
            return j6 * j7;
        }
        long j8 = ((j6 ^ j7) >>> 63) + Long.MAX_VALUE;
        boolean z7 = false;
        if (numberOfLeadingZeros < 64) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (j6 < 0) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (j7 == Long.MIN_VALUE) {
            z7 = true;
        }
        if (!(z5 | (z7 & z6))) {
            long j9 = j6 * j7;
            if (j6 == 0 || j9 / j6 == j7) {
                return j9;
            }
        }
        return j8;
    }
}
