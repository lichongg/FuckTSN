package androidx.constraintlayout.motion.utils;

import java.lang.reflect.Array;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public class HyperSpline {
    double[][] mCtl;
    Cubic[][] mCurve;
    double[] mCurveLength;
    int mDimensionality;
    int mPoints;
    double mTotalLength;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class Cubic {
        public static final double HALF = 0.5d;
        public static final double THIRD = 0.3333333333333333d;
        double mA;
        double mB;
        double mC;
        double mD;

        public double eval(double d6) {
            return (((((this.mD * d6) + this.mC) * d6) + this.mB) * d6) + this.mA;
        }

        public double vel(double d6) {
            return (((this.mD * 0.3333333333333333d * d6) + (this.mC * 0.5d)) * d6) + this.mB;
        }

        public Cubic(double d6, double d7, double d8, double d9) {
            this.mA = d6;
            this.mB = d7;
            this.mC = d8;
            this.mD = d9;
        }
    }

    public HyperSpline(double[][] dArr) {
        setup(dArr);
    }

    public double approxLength(Cubic[] cubicArr) {
        int i6;
        int length = cubicArr.length;
        double[] dArr = new double[cubicArr.length];
        double d6 = 0.0d;
        double d7 = 0.0d;
        double d8 = 0.0d;
        while (true) {
            i6 = 0;
            if (d7 >= 1.0d) {
                break;
            }
            double d9 = 0.0d;
            while (i6 < cubicArr.length) {
                double d10 = dArr[i6];
                double eval = cubicArr[i6].eval(d7);
                dArr[i6] = eval;
                double d11 = d10 - eval;
                d9 += d11 * d11;
                i6++;
            }
            if (d7 > 0.0d) {
                d8 += Math.sqrt(d9);
            }
            d7 += 0.1d;
        }
        while (i6 < cubicArr.length) {
            double d12 = dArr[i6];
            double eval2 = cubicArr[i6].eval(1.0d);
            dArr[i6] = eval2;
            double d13 = d12 - eval2;
            d6 += d13 * d13;
            i6++;
        }
        return d8 + Math.sqrt(d6);
    }

    public void getPos(double d6, double[] dArr) {
        double d7 = d6 * this.mTotalLength;
        int i6 = 0;
        while (true) {
            double[] dArr2 = this.mCurveLength;
            if (i6 >= dArr2.length - 1) {
                break;
            }
            double d8 = dArr2[i6];
            if (d8 >= d7) {
                break;
            }
            d7 -= d8;
            i6++;
        }
        for (int i7 = 0; i7 < dArr.length; i7++) {
            dArr[i7] = this.mCurve[i7][i6].eval(d7 / this.mCurveLength[i6]);
        }
    }

    public void setup(double[][] dArr) {
        int i6;
        int length = dArr[0].length;
        this.mDimensionality = length;
        int length2 = dArr.length;
        this.mPoints = length2;
        this.mCtl = (double[][]) Array.newInstance((Class<?>) Double.TYPE, length, length2);
        this.mCurve = new Cubic[this.mDimensionality][];
        for (int i7 = 0; i7 < this.mDimensionality; i7++) {
            for (int i8 = 0; i8 < this.mPoints; i8++) {
                this.mCtl[i7][i8] = dArr[i8][i7];
            }
        }
        int i9 = 0;
        while (true) {
            i6 = this.mDimensionality;
            if (i9 >= i6) {
                break;
            }
            Cubic[][] cubicArr = this.mCurve;
            double[] dArr2 = this.mCtl[i9];
            cubicArr[i9] = calcNaturalCubic(dArr2.length, dArr2);
            i9++;
        }
        this.mCurveLength = new double[this.mPoints - 1];
        this.mTotalLength = 0.0d;
        Cubic[] cubicArr2 = new Cubic[i6];
        for (int i10 = 0; i10 < this.mCurveLength.length; i10++) {
            for (int i11 = 0; i11 < this.mDimensionality; i11++) {
                cubicArr2[i11] = this.mCurve[i11][i10];
            }
            double d6 = this.mTotalLength;
            double[] dArr3 = this.mCurveLength;
            double approxLength = approxLength(cubicArr2);
            dArr3[i10] = approxLength;
            this.mTotalLength = d6 + approxLength;
        }
    }

    static Cubic[] calcNaturalCubic(int i6, double[] dArr) {
        double[] dArr2 = new double[i6];
        double[] dArr3 = new double[i6];
        double[] dArr4 = new double[i6];
        int i7 = i6 - 1;
        int i8 = 0;
        dArr2[0] = 0.5d;
        int i9 = 1;
        for (int i10 = 1; i10 < i7; i10++) {
            dArr2[i10] = 1.0d / (4.0d - dArr2[i10 - 1]);
        }
        int i11 = i6 - 2;
        dArr2[i7] = 1.0d / (2.0d - dArr2[i11]);
        dArr3[0] = (dArr[1] - dArr[0]) * 3.0d * dArr2[0];
        while (i9 < i7) {
            int i12 = i9 + 1;
            int i13 = i9 - 1;
            dArr3[i9] = (((dArr[i12] - dArr[i13]) * 3.0d) - dArr3[i13]) * dArr2[i9];
            i9 = i12;
        }
        double d6 = (((dArr[i7] - dArr[i11]) * 3.0d) - dArr3[i11]) * dArr2[i7];
        dArr3[i7] = d6;
        dArr4[i7] = d6;
        while (i11 >= 0) {
            dArr4[i11] = dArr3[i11] - (dArr2[i11] * dArr4[i11 + 1]);
            i11--;
        }
        Cubic[] cubicArr = new Cubic[i7];
        while (i8 < i7) {
            double d7 = dArr[i8];
            double d8 = dArr4[i8];
            int i14 = i8 + 1;
            double d9 = dArr[i14];
            double d10 = dArr4[i14];
            cubicArr[i8] = new Cubic((float) d7, d8, (((d9 - d7) * 3.0d) - (d8 * 2.0d)) - d10, ((d7 - d9) * 2.0d) + d8 + d10);
            i8 = i14;
        }
        return cubicArr;
    }

    public void getVelocity(double d6, double[] dArr) {
        double d7 = d6 * this.mTotalLength;
        int i6 = 0;
        while (true) {
            double[] dArr2 = this.mCurveLength;
            if (i6 >= dArr2.length - 1) {
                break;
            }
            double d8 = dArr2[i6];
            if (d8 >= d7) {
                break;
            }
            d7 -= d8;
            i6++;
        }
        for (int i7 = 0; i7 < dArr.length; i7++) {
            dArr[i7] = this.mCurve[i7][i6].vel(d7 / this.mCurveLength[i6]);
        }
    }

    public HyperSpline() {
    }

    public void getPos(double d6, float[] fArr) {
        double d7 = d6 * this.mTotalLength;
        int i6 = 0;
        while (true) {
            double[] dArr = this.mCurveLength;
            if (i6 >= dArr.length - 1) {
                break;
            }
            double d8 = dArr[i6];
            if (d8 >= d7) {
                break;
            }
            d7 -= d8;
            i6++;
        }
        for (int i7 = 0; i7 < fArr.length; i7++) {
            fArr[i7] = (float) this.mCurve[i7][i6].eval(d7 / this.mCurveLength[i6]);
        }
    }

    public double getPos(double d6, int i6) {
        double[] dArr;
        double d7 = d6 * this.mTotalLength;
        int i7 = 0;
        while (true) {
            dArr = this.mCurveLength;
            if (i7 >= dArr.length - 1) {
                break;
            }
            double d8 = dArr[i7];
            if (d8 >= d7) {
                break;
            }
            d7 -= d8;
            i7++;
        }
        return this.mCurve[i6][i7].eval(d7 / dArr[i7]);
    }
}
