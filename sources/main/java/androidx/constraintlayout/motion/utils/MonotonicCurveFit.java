package androidx.constraintlayout.motion.utils;

import java.lang.reflect.Array;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public class MonotonicCurveFit extends CurveFit {
    private static final String TAG = "MonotonicCurveFit";
    private double[] mT;
    private double[][] mTangent;
    private double[][] mY;

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public void getPos(double d6, double[] dArr) {
        double[] dArr2 = this.mT;
        int length = dArr2.length;
        int i6 = 0;
        int length2 = this.mY[0].length;
        if (d6 <= dArr2[0]) {
            for (int i7 = 0; i7 < length2; i7++) {
                dArr[i7] = this.mY[0][i7];
            }
            return;
        }
        int i8 = length - 1;
        if (d6 >= dArr2[i8]) {
            while (i6 < length2) {
                dArr[i6] = this.mY[i8][i6];
                i6++;
            }
            return;
        }
        int i9 = 0;
        while (i9 < i8) {
            if (d6 == this.mT[i9]) {
                for (int i10 = 0; i10 < length2; i10++) {
                    dArr[i10] = this.mY[i9][i10];
                }
            }
            double[] dArr3 = this.mT;
            int i11 = i9 + 1;
            double d7 = dArr3[i11];
            if (d6 < d7) {
                double d8 = dArr3[i9];
                double d9 = d7 - d8;
                double d10 = (d6 - d8) / d9;
                while (i6 < length2) {
                    double[][] dArr4 = this.mY;
                    double d11 = dArr4[i9][i6];
                    double d12 = dArr4[i11][i6];
                    double[][] dArr5 = this.mTangent;
                    dArr[i6] = interpolate(d9, d10, d11, d12, dArr5[i9][i6], dArr5[i11][i6]);
                    i6++;
                }
                return;
            }
            i9 = i11;
        }
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public void getSlope(double d6, double[] dArr) {
        double[] dArr2 = this.mT;
        int length = dArr2.length;
        int length2 = this.mY[0].length;
        double d7 = dArr2[0];
        if (d6 > d7) {
            d7 = dArr2[length - 1];
            if (d6 < d7) {
                d7 = d6;
            }
        }
        int i6 = 0;
        while (i6 < length - 1) {
            double[] dArr3 = this.mT;
            int i7 = i6 + 1;
            double d8 = dArr3[i7];
            if (d7 <= d8) {
                double d9 = dArr3[i6];
                double d10 = d8 - d9;
                double d11 = (d7 - d9) / d10;
                for (int i8 = 0; i8 < length2; i8++) {
                    double[][] dArr4 = this.mY;
                    double d12 = dArr4[i6][i8];
                    double d13 = dArr4[i7][i8];
                    double[][] dArr5 = this.mTangent;
                    dArr[i8] = diff(d10, d11, d12, d13, dArr5[i6][i8], dArr5[i7][i8]) / d10;
                }
                return;
            }
            i6 = i7;
        }
    }

    public MonotonicCurveFit(double[] dArr, double[][] dArr2) {
        int length = dArr.length;
        int length2 = dArr2[0].length;
        int i6 = length - 1;
        Class cls = Double.TYPE;
        double[][] dArr3 = (double[][]) Array.newInstance((Class<?>) cls, i6, length2);
        double[][] dArr4 = (double[][]) Array.newInstance((Class<?>) cls, length, length2);
        for (int i7 = 0; i7 < length2; i7++) {
            int i8 = 0;
            while (i8 < i6) {
                int i9 = i8 + 1;
                double d6 = dArr[i9] - dArr[i8];
                double[] dArr5 = dArr3[i8];
                double d7 = (dArr2[i9][i7] - dArr2[i8][i7]) / d6;
                dArr5[i7] = d7;
                if (i8 == 0) {
                    dArr4[i8][i7] = d7;
                } else {
                    dArr4[i8][i7] = (dArr3[i8 - 1][i7] + d7) * 0.5d;
                }
                i8 = i9;
            }
            dArr4[i6][i7] = dArr3[length - 2][i7];
        }
        for (int i10 = 0; i10 < i6; i10++) {
            for (int i11 = 0; i11 < length2; i11++) {
                double d8 = dArr3[i10][i11];
                if (d8 == 0.0d) {
                    dArr4[i10][i11] = 0.0d;
                    dArr4[i10 + 1][i11] = 0.0d;
                } else {
                    double d9 = dArr4[i10][i11] / d8;
                    int i12 = i10 + 1;
                    double d10 = dArr4[i12][i11] / d8;
                    double hypot = Math.hypot(d9, d10);
                    if (hypot > 9.0d) {
                        double d11 = 3.0d / hypot;
                        double[] dArr6 = dArr4[i10];
                        double[] dArr7 = dArr3[i10];
                        dArr6[i11] = d9 * d11 * dArr7[i11];
                        dArr4[i12][i11] = d11 * d10 * dArr7[i11];
                    }
                }
            }
        }
        this.mT = dArr;
        this.mY = dArr2;
        this.mTangent = dArr4;
    }

    private static double diff(double d6, double d7, double d8, double d9, double d10, double d11) {
        double d12 = d7 * d7;
        double d13 = d7 * 6.0d;
        double d14 = (((((-6.0d) * d12) * d9) + (d13 * d9)) + ((6.0d * d12) * d8)) - (d13 * d8);
        double d15 = 3.0d * d6;
        return ((((d14 + ((d15 * d11) * d12)) + ((d15 * d10) * d12)) - (((2.0d * d6) * d11) * d7)) - (((4.0d * d6) * d10) * d7)) + (d6 * d10);
    }

    private static double interpolate(double d6, double d7, double d8, double d9, double d10, double d11) {
        double d12 = d7 * d7;
        double d13 = d12 * d7;
        double d14 = 3.0d * d12;
        double d15 = ((((((-2.0d) * d13) * d9) + (d14 * d9)) + ((d13 * 2.0d) * d8)) - (d14 * d8)) + d8;
        double d16 = d6 * d11;
        double d17 = d6 * d10;
        return ((((d15 + (d16 * d13)) + (d13 * d17)) - (d16 * d12)) - (((d6 * 2.0d) * d10) * d12)) + (d17 * d7);
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public double[] getTimePoints() {
        return this.mT;
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public double getSlope(double d6, int i6) {
        double[] dArr = this.mT;
        int length = dArr.length;
        int i7 = 0;
        double d7 = dArr[0];
        if (d6 >= d7) {
            d7 = dArr[length - 1];
            if (d6 < d7) {
                d7 = d6;
            }
        }
        while (i7 < length - 1) {
            double[] dArr2 = this.mT;
            int i8 = i7 + 1;
            double d8 = dArr2[i8];
            if (d7 <= d8) {
                double d9 = dArr2[i7];
                double d10 = d8 - d9;
                double[][] dArr3 = this.mY;
                double d11 = dArr3[i7][i6];
                double d12 = dArr3[i8][i6];
                double[][] dArr4 = this.mTangent;
                return diff(d10, (d7 - d9) / d10, d11, d12, dArr4[i7][i6], dArr4[i8][i6]) / d10;
            }
            i7 = i8;
        }
        return 0.0d;
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public void getPos(double d6, float[] fArr) {
        double[] dArr = this.mT;
        int length = dArr.length;
        int i6 = 0;
        int length2 = this.mY[0].length;
        if (d6 <= dArr[0]) {
            for (int i7 = 0; i7 < length2; i7++) {
                fArr[i7] = (float) this.mY[0][i7];
            }
            return;
        }
        int i8 = length - 1;
        if (d6 >= dArr[i8]) {
            while (i6 < length2) {
                fArr[i6] = (float) this.mY[i8][i6];
                i6++;
            }
            return;
        }
        int i9 = 0;
        while (i9 < i8) {
            if (d6 == this.mT[i9]) {
                for (int i10 = 0; i10 < length2; i10++) {
                    fArr[i10] = (float) this.mY[i9][i10];
                }
            }
            double[] dArr2 = this.mT;
            int i11 = i9 + 1;
            double d7 = dArr2[i11];
            if (d6 < d7) {
                double d8 = dArr2[i9];
                double d9 = d7 - d8;
                double d10 = (d6 - d8) / d9;
                while (i6 < length2) {
                    double[][] dArr3 = this.mY;
                    double d11 = dArr3[i9][i6];
                    double d12 = dArr3[i11][i6];
                    double[][] dArr4 = this.mTangent;
                    fArr[i6] = (float) interpolate(d9, d10, d11, d12, dArr4[i9][i6], dArr4[i11][i6]);
                    i6++;
                }
                return;
            }
            i9 = i11;
        }
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public double getPos(double d6, int i6) {
        double[] dArr = this.mT;
        int length = dArr.length;
        int i7 = 0;
        if (d6 <= dArr[0]) {
            return this.mY[0][i6];
        }
        int i8 = length - 1;
        if (d6 >= dArr[i8]) {
            return this.mY[i8][i6];
        }
        while (i7 < i8) {
            double[] dArr2 = this.mT;
            double d7 = dArr2[i7];
            if (d6 == d7) {
                return this.mY[i7][i6];
            }
            int i9 = i7 + 1;
            double d8 = dArr2[i9];
            if (d6 < d8) {
                double d9 = d8 - d7;
                double d10 = (d6 - d7) / d9;
                double[][] dArr3 = this.mY;
                double d11 = dArr3[i7][i6];
                double d12 = dArr3[i9][i6];
                double[][] dArr4 = this.mTangent;
                return interpolate(d9, d10, d11, d12, dArr4[i7][i6], dArr4[i9][i6]);
            }
            i7 = i9;
        }
        return 0.0d;
    }
}
