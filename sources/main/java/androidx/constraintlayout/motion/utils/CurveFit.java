package androidx.constraintlayout.motion.utils;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public abstract class CurveFit {
    public static final int CONSTANT = 2;
    public static final int LINEAR = 1;
    public static final int SPLINE = 0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class Constant extends CurveFit {
        double mTime;
        double[] mValue;

        @Override // androidx.constraintlayout.motion.utils.CurveFit
        public void getPos(double d6, double[] dArr) {
            double[] dArr2 = this.mValue;
            System.arraycopy(dArr2, 0, dArr, 0, dArr2.length);
        }

        @Override // androidx.constraintlayout.motion.utils.CurveFit
        public double getSlope(double d6, int i6) {
            return 0.0d;
        }

        @Override // androidx.constraintlayout.motion.utils.CurveFit
        public void getPos(double d6, float[] fArr) {
            int i6 = 0;
            while (true) {
                double[] dArr = this.mValue;
                if (i6 >= dArr.length) {
                    return;
                }
                fArr[i6] = (float) dArr[i6];
                i6++;
            }
        }

        @Override // androidx.constraintlayout.motion.utils.CurveFit
        public void getSlope(double d6, double[] dArr) {
            for (int i6 = 0; i6 < this.mValue.length; i6++) {
                dArr[i6] = 0.0d;
            }
        }

        @Override // androidx.constraintlayout.motion.utils.CurveFit
        public double[] getTimePoints() {
            return new double[]{this.mTime};
        }

        Constant(double d6, double[] dArr) {
            this.mTime = d6;
            this.mValue = dArr;
        }

        @Override // androidx.constraintlayout.motion.utils.CurveFit
        public double getPos(double d6, int i6) {
            return this.mValue[i6];
        }
    }

    public static CurveFit get(int i6, double[] dArr, double[][] dArr2) {
        if (dArr.length == 1) {
            i6 = 2;
        }
        return i6 != 0 ? i6 != 2 ? new LinearCurveFit(dArr, dArr2) : new Constant(dArr[0], dArr2[0]) : new MonotonicCurveFit(dArr, dArr2);
    }

    public abstract double getPos(double d6, int i6);

    public abstract void getPos(double d6, double[] dArr);

    public abstract void getPos(double d6, float[] fArr);

    public abstract double getSlope(double d6, int i6);

    public abstract void getSlope(double d6, double[] dArr);

    public abstract double[] getTimePoints();

    public static CurveFit getArc(int[] iArr, double[] dArr, double[][] dArr2) {
        return new ArcCurveFit(iArr, dArr, dArr2);
    }
}
