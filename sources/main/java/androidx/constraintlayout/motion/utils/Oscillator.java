package androidx.constraintlayout.motion.utils;

import java.util.Arrays;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public class Oscillator {
    public static final int BOUNCE = 6;
    public static final int COS_WAVE = 5;
    public static final int REVERSE_SAW_WAVE = 4;
    public static final int SAW_WAVE = 3;
    public static final int SIN_WAVE = 0;
    public static final int SQUARE_WAVE = 1;
    public static String TAG = "Oscillator";
    public static final int TRIANGLE_WAVE = 2;
    double[] mArea;
    int mType;
    float[] mPeriod = new float[0];
    double[] mPosition = new double[0];
    double PI2 = 6.283185307179586d;
    private boolean mNormalized = false;

    public void addPoint(double d6, float f6) {
        int length = this.mPeriod.length + 1;
        int binarySearch = Arrays.binarySearch(this.mPosition, d6);
        if (binarySearch < 0) {
            binarySearch = (-binarySearch) - 1;
        }
        this.mPosition = Arrays.copyOf(this.mPosition, length);
        this.mPeriod = Arrays.copyOf(this.mPeriod, length);
        this.mArea = new double[length];
        double[] dArr = this.mPosition;
        System.arraycopy(dArr, binarySearch, dArr, binarySearch + 1, (length - binarySearch) - 1);
        this.mPosition[binarySearch] = d6;
        this.mPeriod[binarySearch] = f6;
        this.mNormalized = false;
    }

    double getDP(double d6) {
        if (d6 <= 0.0d) {
            d6 = 1.0E-5d;
        } else if (d6 >= 1.0d) {
            d6 = 0.999999d;
        }
        int binarySearch = Arrays.binarySearch(this.mPosition, d6);
        if (binarySearch > 0 || binarySearch == 0) {
            return 0.0d;
        }
        int i6 = -binarySearch;
        int i7 = i6 - 1;
        float[] fArr = this.mPeriod;
        float f6 = fArr[i7];
        int i8 = i6 - 2;
        float f7 = fArr[i8];
        double[] dArr = this.mPosition;
        double d7 = dArr[i7];
        double d8 = dArr[i8];
        double d9 = (f6 - f7) / (d7 - d8);
        return (d6 * d9) + (f7 - (d9 * d8));
    }

    double getP(double d6) {
        if (d6 < 0.0d) {
            d6 = 0.0d;
        } else if (d6 > 1.0d) {
            d6 = 1.0d;
        }
        int binarySearch = Arrays.binarySearch(this.mPosition, d6);
        if (binarySearch > 0) {
            return 1.0d;
        }
        if (binarySearch == 0) {
            return 0.0d;
        }
        int i6 = -binarySearch;
        int i7 = i6 - 1;
        float[] fArr = this.mPeriod;
        float f6 = fArr[i7];
        int i8 = i6 - 2;
        float f7 = fArr[i8];
        double[] dArr = this.mPosition;
        double d7 = dArr[i7];
        double d8 = dArr[i8];
        double d9 = (f6 - f7) / (d7 - d8);
        return this.mArea[i8] + ((f7 - (d9 * d8)) * (d6 - d8)) + ((d9 * ((d6 * d6) - (d8 * d8))) / 2.0d);
    }

    public double getSlope(double d6) {
        double dp;
        double signum;
        double dp2;
        double dp3;
        double sin;
        switch (this.mType) {
            case 1:
                return 0.0d;
            case 2:
                dp = getDP(d6) * 4.0d;
                signum = Math.signum((((getP(d6) * 4.0d) + 3.0d) % 4.0d) - 2.0d);
                return dp * signum;
            case 3:
                dp2 = getDP(d6);
                return dp2 * 2.0d;
            case 4:
                dp2 = -getDP(d6);
                return dp2 * 2.0d;
            case 5:
                dp3 = (-this.PI2) * getDP(d6);
                sin = Math.sin(this.PI2 * getP(d6));
                return dp3 * sin;
            case 6:
                dp = getDP(d6) * 4.0d;
                signum = (((getP(d6) * 4.0d) + 2.0d) % 4.0d) - 2.0d;
                return dp * signum;
            default:
                dp3 = this.PI2 * getDP(d6);
                sin = Math.cos(this.PI2 * getP(d6));
                return dp3 * sin;
        }
    }

    public double getValue(double d6) {
        double abs;
        switch (this.mType) {
            case 1:
                return Math.signum(0.5d - (getP(d6) % 1.0d));
            case 2:
                abs = Math.abs((((getP(d6) * 4.0d) + 1.0d) % 4.0d) - 2.0d);
                break;
            case 3:
                return (((getP(d6) * 2.0d) + 1.0d) % 2.0d) - 1.0d;
            case 4:
                abs = ((getP(d6) * 2.0d) + 1.0d) % 2.0d;
                break;
            case 5:
                return Math.cos(this.PI2 * getP(d6));
            case 6:
                double abs2 = 1.0d - Math.abs(((getP(d6) * 4.0d) % 4.0d) - 2.0d);
                abs = abs2 * abs2;
                break;
            default:
                return Math.sin(this.PI2 * getP(d6));
        }
        return 1.0d - abs;
    }

    public void normalize() {
        double d6 = 0.0d;
        int i6 = 0;
        while (true) {
            if (i6 >= this.mPeriod.length) {
                break;
            }
            d6 += r7[i6];
            i6++;
        }
        double d7 = 0.0d;
        int i7 = 1;
        while (true) {
            float[] fArr = this.mPeriod;
            if (i7 >= fArr.length) {
                break;
            }
            int i8 = i7 - 1;
            float f6 = (fArr[i8] + fArr[i7]) / 2.0f;
            double[] dArr = this.mPosition;
            d7 += (dArr[i7] - dArr[i8]) * f6;
            i7++;
        }
        int i9 = 0;
        while (true) {
            float[] fArr2 = this.mPeriod;
            if (i9 >= fArr2.length) {
                break;
            }
            fArr2[i9] = (float) (fArr2[i9] * (d6 / d7));
            i9++;
        }
        this.mArea[0] = 0.0d;
        int i10 = 1;
        while (true) {
            float[] fArr3 = this.mPeriod;
            if (i10 >= fArr3.length) {
                this.mNormalized = true;
                return;
            }
            int i11 = i10 - 1;
            float f7 = (fArr3[i11] + fArr3[i10]) / 2.0f;
            double[] dArr2 = this.mPosition;
            double d8 = dArr2[i10] - dArr2[i11];
            double[] dArr3 = this.mArea;
            dArr3[i10] = dArr3[i11] + (d8 * f7);
            i10++;
        }
    }

    public void setType(int i6) {
        this.mType = i6;
    }

    public String toString() {
        return "pos =" + Arrays.toString(this.mPosition) + " period=" + Arrays.toString(this.mPeriod);
    }
}
