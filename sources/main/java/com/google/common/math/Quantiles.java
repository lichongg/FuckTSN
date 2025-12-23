package com.google.common.math;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Doubles;
import com.google.common.primitives.Ints;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Beta
@GwtIncompatible
/* loaded from: D:\Downloads\app\classes5.dex */
public final class Quantiles {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.google.common.math.Quantiles$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Scale {
        private final int scale;

        /* synthetic */ Scale(int i6, AnonymousClass1 anonymousClass1) {
            this(i6);
        }

        public ScaleAndIndexes indexes(int... iArr) {
            return new ScaleAndIndexes(this.scale, (int[]) iArr.clone(), null);
        }

        private Scale(int i6) {
            Preconditions.checkArgument(i6 > 0, "Quantile scale must be positive");
            this.scale = i6;
        }

        public ScaleAndIndex index(int i6) {
            return new ScaleAndIndex(this.scale, i6, null);
        }

        public ScaleAndIndexes indexes(Collection<Integer> collection) {
            return new ScaleAndIndexes(this.scale, Ints.toArray(collection), null);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class ScaleAndIndex {
        private final int index;
        private final int scale;

        /* synthetic */ ScaleAndIndex(int i6, int i7, AnonymousClass1 anonymousClass1) {
            this(i6, i7);
        }

        public double compute(Collection<? extends Number> collection) {
            return computeInPlace(Doubles.toArray(collection));
        }

        public double computeInPlace(double... dArr) {
            Preconditions.checkArgument(dArr.length > 0, "Cannot calculate quantiles of an empty dataset");
            if (Quantiles.containsNaN(dArr)) {
                return Double.NaN;
            }
            long length = this.index * (dArr.length - 1);
            int divide = (int) LongMath.divide(length, this.scale, RoundingMode.DOWN);
            int i6 = (int) (length - (divide * this.scale));
            Quantiles.selectInPlace(divide, dArr, 0, dArr.length - 1);
            if (i6 == 0) {
                return dArr[divide];
            }
            int i7 = divide + 1;
            Quantiles.selectInPlace(i7, dArr, i7, dArr.length - 1);
            return Quantiles.interpolate(dArr[divide], dArr[i7], i6, this.scale);
        }

        private ScaleAndIndex(int i6, int i7) {
            Quantiles.checkIndex(i7, i6);
            this.scale = i6;
            this.index = i7;
        }

        public double compute(double... dArr) {
            return computeInPlace((double[]) dArr.clone());
        }

        public double compute(long... jArr) {
            return computeInPlace(Quantiles.longsToDoubles(jArr));
        }

        public double compute(int... iArr) {
            return computeInPlace(Quantiles.intsToDoubles(iArr));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class ScaleAndIndexes {
        private final int[] indexes;
        private final int scale;

        /* synthetic */ ScaleAndIndexes(int i6, int[] iArr, AnonymousClass1 anonymousClass1) {
            this(i6, iArr);
        }

        public Map<Integer, Double> compute(Collection<? extends Number> collection) {
            return computeInPlace(Doubles.toArray(collection));
        }

        private ScaleAndIndexes(int i6, int[] iArr) {
            for (int i7 : iArr) {
                Quantiles.checkIndex(i7, i6);
            }
            this.scale = i6;
            this.indexes = iArr;
        }

        public Map<Integer, Double> compute(double... dArr) {
            return computeInPlace((double[]) dArr.clone());
        }

        public Map<Integer, Double> computeInPlace(double... dArr) {
            int i6 = 0;
            Preconditions.checkArgument(dArr.length > 0, "Cannot calculate quantiles of an empty dataset");
            if (Quantiles.containsNaN(dArr)) {
                HashMap hashMap = new HashMap();
                int[] iArr = this.indexes;
                int length = iArr.length;
                while (i6 < length) {
                    hashMap.put(Integer.valueOf(iArr[i6]), Double.valueOf(Double.NaN));
                    i6++;
                }
                return Collections.unmodifiableMap(hashMap);
            }
            int[] iArr2 = this.indexes;
            int[] iArr3 = new int[iArr2.length];
            int[] iArr4 = new int[iArr2.length];
            int[] iArr5 = new int[iArr2.length * 2];
            int i7 = 0;
            int i8 = 0;
            while (true) {
                if (i7 >= this.indexes.length) {
                    break;
                }
                long length2 = r6[i7] * (dArr.length - 1);
                int divide = (int) LongMath.divide(length2, this.scale, RoundingMode.DOWN);
                int i9 = (int) (length2 - (divide * this.scale));
                iArr3[i7] = divide;
                iArr4[i7] = i9;
                iArr5[i8] = divide;
                int i10 = i8 + 1;
                if (i9 != 0) {
                    iArr5[i10] = divide + 1;
                    i8 += 2;
                } else {
                    i8 = i10;
                }
                i7++;
            }
            Arrays.sort(iArr5, 0, i8);
            Quantiles.selectAllInPlace(iArr5, 0, i8 - 1, dArr, 0, dArr.length - 1);
            HashMap hashMap2 = new HashMap();
            while (true) {
                int[] iArr6 = this.indexes;
                if (i6 >= iArr6.length) {
                    return Collections.unmodifiableMap(hashMap2);
                }
                int i11 = iArr3[i6];
                int i12 = iArr4[i6];
                if (i12 == 0) {
                    hashMap2.put(Integer.valueOf(iArr6[i6]), Double.valueOf(dArr[i11]));
                } else {
                    hashMap2.put(Integer.valueOf(iArr6[i6]), Double.valueOf(Quantiles.interpolate(dArr[i11], dArr[i11 + 1], i12, this.scale)));
                }
                i6++;
            }
        }

        public Map<Integer, Double> compute(long... jArr) {
            return computeInPlace(Quantiles.longsToDoubles(jArr));
        }

        public Map<Integer, Double> compute(int... iArr) {
            return computeInPlace(Quantiles.intsToDoubles(iArr));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean containsNaN(double... dArr) {
        for (double d6 : dArr) {
            if (Double.isNaN(d6)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static double[] intsToDoubles(int[] iArr) {
        int length = iArr.length;
        double[] dArr = new double[length];
        for (int i6 = 0; i6 < length; i6++) {
            dArr[i6] = iArr[i6];
        }
        return dArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static double[] longsToDoubles(long[] jArr) {
        int length = jArr.length;
        double[] dArr = new double[length];
        for (int i6 = 0; i6 < length; i6++) {
            dArr[i6] = jArr[i6];
        }
        return dArr;
    }

    public static ScaleAndIndex median() {
        return scale(2).index(1);
    }

    public static Scale quartiles() {
        return scale(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void checkIndex(int i6, int i7) {
        if (i6 < 0 || i6 > i7) {
            throw new IllegalArgumentException("Quantile indexes must be between 0 and the scale, which is " + i7);
        }
    }

    private static int chooseNextSelection(int[] iArr, int i6, int i7, int i8, int i9) {
        if (i6 == i7) {
            return i6;
        }
        int i10 = i8 + i9;
        int i11 = i10 >>> 1;
        while (i7 > i6 + 1) {
            int i12 = (i6 + i7) >>> 1;
            int i13 = iArr[i12];
            if (i13 > i11) {
                i7 = i12;
            } else {
                if (i13 >= i11) {
                    return i12;
                }
                i6 = i12;
            }
        }
        return (i10 - iArr[i6]) - iArr[i7] > 0 ? i7 : i6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static double interpolate(double d6, double d7, double d8, double d9) {
        if (d6 == Double.NEGATIVE_INFINITY) {
            return d7 == Double.POSITIVE_INFINITY ? Double.NaN : Double.NEGATIVE_INFINITY;
        }
        if (d7 == Double.POSITIVE_INFINITY) {
            return Double.POSITIVE_INFINITY;
        }
        return d6 + (((d7 - d6) * d8) / d9);
    }

    private static void movePivotToStartOfSlice(double[] dArr, int i6, int i7) {
        int i8 = (i6 + i7) >>> 1;
        double d6 = dArr[i7];
        double d7 = dArr[i8];
        boolean z5 = d6 < d7;
        double d8 = dArr[i6];
        boolean z6 = d7 < d8;
        boolean z7 = d6 < d8;
        if (z5 == z6) {
            swap(dArr, i8, i6);
        } else if (z5 != z7) {
            swap(dArr, i6, i7);
        }
    }

    public static Scale percentiles() {
        return scale(100);
    }

    public static Scale scale(int i6) {
        return new Scale(i6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void selectInPlace(int i6, double[] dArr, int i7, int i8) {
        if (i6 != i7) {
            while (i8 > i7) {
                int partition = partition(dArr, i7, i8);
                if (partition >= i6) {
                    i8 = partition - 1;
                }
                if (partition <= i6) {
                    i7 = partition + 1;
                }
            }
            return;
        }
        int i9 = i7;
        for (int i10 = i7 + 1; i10 <= i8; i10++) {
            if (dArr[i9] > dArr[i10]) {
                i9 = i10;
            }
        }
        if (i9 != i7) {
            swap(dArr, i9, i7);
        }
    }

    private static void swap(double[] dArr, int i6, int i7) {
        double d6 = dArr[i6];
        dArr[i6] = dArr[i7];
        dArr[i7] = d6;
    }

    private static int partition(double[] dArr, int i6, int i7) {
        movePivotToStartOfSlice(dArr, i6, i7);
        double d6 = dArr[i6];
        int i8 = i7;
        while (i7 > i6) {
            if (dArr[i7] > d6) {
                swap(dArr, i8, i7);
                i8--;
            }
            i7--;
        }
        swap(dArr, i6, i8);
        return i8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void selectAllInPlace(int[] iArr, int i6, int i7, double[] dArr, int i8, int i9) {
        int chooseNextSelection = chooseNextSelection(iArr, i6, i7, i8, i9);
        int i10 = iArr[chooseNextSelection];
        selectInPlace(i10, dArr, i8, i9);
        int i11 = chooseNextSelection - 1;
        while (i11 >= i6 && iArr[i11] == i10) {
            i11--;
        }
        if (i11 >= i6) {
            selectAllInPlace(iArr, i6, i11, dArr, i8, i10 - 1);
        }
        int i12 = chooseNextSelection + 1;
        while (i12 <= i7 && iArr[i12] == i10) {
            i12++;
        }
        if (i12 <= i7) {
            selectAllInPlace(iArr, i12, i7, dArr, i10 + 1, i9);
        }
    }
}
