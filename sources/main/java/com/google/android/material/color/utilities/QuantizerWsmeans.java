package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes5.dex */
public final class QuantizerWsmeans {
    private static final int MAX_ITERATIONS = 10;
    private static final double MIN_MOVEMENT_DISTANCE = 3.0d;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class Distance implements Comparable<Distance> {
        int index = -1;
        double distance = -1.0d;

        @Override // java.lang.Comparable
        public int compareTo(Distance distance) {
            return Double.valueOf(this.distance).compareTo(Double.valueOf(distance.distance));
        }

        Distance() {
        }
    }

    public static Map<Integer, Integer> quantize(int[] iArr, int[] iArr2, int i6) {
        double[] dArr;
        double[] dArr2;
        Random random = new Random(272008L);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        double[][] dArr3 = new double[iArr.length][];
        int[] iArr3 = new int[iArr.length];
        PointProviderLab pointProviderLab = new PointProviderLab();
        int i7 = 0;
        for (int i8 : iArr) {
            Integer num = (Integer) linkedHashMap.get(Integer.valueOf(i8));
            if (num == null) {
                dArr3[i7] = pointProviderLab.fromInt(i8);
                iArr3[i7] = i8;
                i7++;
                linkedHashMap.put(Integer.valueOf(i8), 1);
            } else {
                linkedHashMap.put(Integer.valueOf(i8), Integer.valueOf(num.intValue() + 1));
            }
        }
        int[] iArr4 = new int[i7];
        for (int i9 = 0; i9 < i7; i9++) {
            iArr4[i9] = ((Integer) linkedHashMap.get(Integer.valueOf(iArr3[i9]))).intValue();
        }
        int min = Math.min(i6, i7);
        if (iArr2.length != 0) {
            min = Math.min(min, iArr2.length);
        }
        double[][] dArr4 = new double[min][];
        int i10 = 0;
        for (int i11 = 0; i11 < iArr2.length; i11++) {
            dArr4[i11] = pointProviderLab.fromInt(iArr2[i11]);
            i10++;
        }
        int i12 = min - i10;
        if (i12 > 0) {
            for (int i13 = 0; i13 < i12; i13++) {
            }
        }
        int[] iArr5 = new int[i7];
        for (int i14 = 0; i14 < i7; i14++) {
            iArr5[i14] = random.nextInt(min);
        }
        int[][] iArr6 = new int[min][];
        for (int i15 = 0; i15 < min; i15++) {
            iArr6[i15] = new int[min];
        }
        Distance[][] distanceArr = new Distance[min][];
        for (int i16 = 0; i16 < min; i16++) {
            distanceArr[i16] = new Distance[min];
            for (int i17 = 0; i17 < min; i17++) {
                distanceArr[i16][i17] = new Distance();
            }
        }
        int[] iArr7 = new int[min];
        int i18 = 0;
        while (i18 < 10) {
            int i19 = 0;
            while (i19 < min) {
                int i20 = i19 + 1;
                int i21 = i20;
                while (i21 < min) {
                    int[] iArr8 = iArr4;
                    double distance = pointProviderLab.distance(dArr4[i19], dArr4[i21]);
                    Distance distance2 = distanceArr[i21][i19];
                    distance2.distance = distance;
                    distance2.index = i19;
                    Distance distance3 = distanceArr[i19][i21];
                    distance3.distance = distance;
                    distance3.index = i21;
                    i21++;
                    iArr4 = iArr8;
                    iArr5 = iArr5;
                }
                int[] iArr9 = iArr4;
                int[] iArr10 = iArr5;
                Arrays.sort(distanceArr[i19]);
                for (int i22 = 0; i22 < min; i22++) {
                    iArr6[i19][i22] = distanceArr[i19][i22].index;
                }
                iArr4 = iArr9;
                iArr5 = iArr10;
                i19 = i20;
            }
            int[] iArr11 = iArr4;
            int[] iArr12 = iArr5;
            int i23 = 0;
            int i24 = 0;
            while (i23 < i7) {
                double[] dArr5 = dArr3[i23];
                int i25 = iArr12[i23];
                double distance4 = pointProviderLab.distance(dArr5, dArr4[i25]);
                int i26 = i23;
                double d6 = distance4;
                int i27 = -1;
                int i28 = 0;
                while (i28 < min) {
                    int i29 = i24;
                    int[][] iArr13 = iArr6;
                    if (distanceArr[i25][i28].distance < 4.0d * distance4) {
                        double distance5 = pointProviderLab.distance(dArr5, dArr4[i28]);
                        if (distance5 < d6) {
                            d6 = distance5;
                            i27 = i28;
                        }
                    }
                    i28++;
                    iArr6 = iArr13;
                    i24 = i29;
                }
                int i30 = i24;
                int[][] iArr14 = iArr6;
                if (i27 == -1 || Math.abs(Math.sqrt(d6) - Math.sqrt(distance4)) <= 3.0d) {
                    i24 = i30;
                } else {
                    i24 = i30 + 1;
                    iArr12[i26] = i27;
                }
                i23 = i26 + 1;
                iArr6 = iArr14;
            }
            int[][] iArr15 = iArr6;
            if (i24 == 0 && i18 != 0) {
                break;
            }
            double[] dArr6 = new double[min];
            double[] dArr7 = new double[min];
            double[] dArr8 = new double[min];
            Arrays.fill(iArr7, 0);
            for (int i31 = 0; i31 < i7; i31++) {
                int i32 = iArr12[i31];
                double[] dArr9 = dArr3[i31];
                int i33 = iArr11[i31];
                iArr7[i32] = iArr7[i32] + i33;
                double d7 = i33;
                dArr6[i32] = dArr6[i32] + (dArr9[0] * d7);
                dArr7[i32] = dArr7[i32] + (dArr9[1] * d7);
                dArr8[i32] = dArr8[i32] + (dArr9[2] * d7);
            }
            int i34 = 0;
            while (i34 < min) {
                int i35 = iArr7[i34];
                if (i35 == 0) {
                    dArr4[i34] = new double[]{0.0d, 0.0d, 0.0d};
                    dArr = dArr6;
                    dArr2 = dArr7;
                } else {
                    double d8 = dArr6[i34];
                    dArr = dArr6;
                    dArr2 = dArr7;
                    double d9 = i35;
                    double d10 = d8 / d9;
                    double d11 = dArr2[i34] / d9;
                    double d12 = dArr8[i34] / d9;
                    double[] dArr10 = dArr4[i34];
                    dArr10[0] = d10;
                    dArr10[1] = d11;
                    dArr10[2] = d12;
                }
                i34++;
                dArr6 = dArr;
                dArr7 = dArr2;
            }
            i18++;
            iArr4 = iArr11;
            iArr5 = iArr12;
            iArr6 = iArr15;
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (int i36 = 0; i36 < min; i36++) {
            int i37 = iArr7[i36];
            if (i37 != 0) {
                int i38 = pointProviderLab.toInt(dArr4[i36]);
                if (!linkedHashMap2.containsKey(Integer.valueOf(i38))) {
                    linkedHashMap2.put(Integer.valueOf(i38), Integer.valueOf(i37));
                }
            }
        }
        return linkedHashMap2;
    }

    private QuantizerWsmeans() {
    }
}
