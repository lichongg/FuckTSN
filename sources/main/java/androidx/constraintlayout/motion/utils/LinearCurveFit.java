package androidx.constraintlayout.motion.utils;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public class LinearCurveFit extends CurveFit {
    private static final String TAG = "LinearCurveFit";
    private double[] mT;
    private double mTotalLength;
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
                double d9 = (d6 - d8) / (d7 - d8);
                while (i6 < length2) {
                    double[][] dArr4 = this.mY;
                    dArr[i6] = (dArr4[i9][i6] * (1.0d - d9)) + (dArr4[i11][i6] * d9);
                    i6++;
                }
                return;
            }
            i9 = i11;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0017, code lost:
    
        if (r13 >= r4) goto L4;
     */
    @Override // androidx.constraintlayout.motion.utils.CurveFit
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void getSlope(double r13, double[] r15) {
        /*
            r12 = this;
            double[] r0 = r12.mT
            int r1 = r0.length
            double[][] r2 = r12.mY
            r3 = 0
            r2 = r2[r3]
            int r2 = r2.length
            r4 = r0[r3]
            int r6 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
            if (r6 > 0) goto L11
        Lf:
            r13 = r4
            goto L1a
        L11:
            int r4 = r1 + (-1)
            r4 = r0[r4]
            int r0 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
            if (r0 < 0) goto L1a
            goto Lf
        L1a:
            r0 = 0
        L1b:
            int r4 = r1 + (-1)
            if (r0 >= r4) goto L41
            double[] r4 = r12.mT
            int r5 = r0 + 1
            r6 = r4[r5]
            int r8 = (r13 > r6 ? 1 : (r13 == r6 ? 0 : -1))
            if (r8 > 0) goto L3f
            r13 = r4[r0]
            double r6 = r6 - r13
        L2c:
            if (r3 >= r2) goto L41
            double[][] r13 = r12.mY
            r14 = r13[r0]
            r8 = r14[r3]
            r13 = r13[r5]
            r10 = r13[r3]
            double r10 = r10 - r8
            double r10 = r10 / r6
            r15[r3] = r10
            int r3 = r3 + 1
            goto L2c
        L3f:
            r0 = r5
            goto L1b
        L41:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.utils.LinearCurveFit.getSlope(double, double[]):void");
    }

    private double getLength2D(double d6) {
        if (Double.isNaN(this.mTotalLength)) {
            return 0.0d;
        }
        double[] dArr = this.mT;
        int length = dArr.length;
        if (d6 <= dArr[0]) {
            return 0.0d;
        }
        int i6 = length - 1;
        if (d6 >= dArr[i6]) {
            return this.mTotalLength;
        }
        double d7 = 0.0d;
        double d8 = 0.0d;
        double d9 = 0.0d;
        int i7 = 0;
        while (i7 < i6) {
            double[] dArr2 = this.mY[i7];
            double d10 = dArr2[0];
            double d11 = dArr2[1];
            if (i7 > 0) {
                d7 += Math.hypot(d10 - d8, d11 - d9);
            }
            double[] dArr3 = this.mT;
            double d12 = dArr3[i7];
            if (d6 == d12) {
                return d7;
            }
            int i8 = i7 + 1;
            double d13 = dArr3[i8];
            if (d6 < d13) {
                double d14 = (d6 - d12) / (d13 - d12);
                double[][] dArr4 = this.mY;
                double[] dArr5 = dArr4[i7];
                double d15 = dArr5[0];
                double[] dArr6 = dArr4[i8];
                double d16 = 1.0d - d14;
                return d7 + Math.hypot(d11 - ((dArr5[1] * d16) + (dArr6[1] * d14)), d10 - ((d15 * d16) + (dArr6[0] * d14)));
            }
            i7 = i8;
            d8 = d10;
            d9 = d11;
        }
        return 0.0d;
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public double[] getTimePoints() {
        return this.mT;
    }

    public LinearCurveFit(double[] dArr, double[][] dArr2) {
        this.mTotalLength = Double.NaN;
        int length = dArr.length;
        int length2 = dArr2[0].length;
        this.mT = dArr;
        this.mY = dArr2;
        if (length2 > 2) {
            double d6 = 0.0d;
            int i6 = 0;
            while (true) {
                double d7 = d6;
                if (i6 < dArr.length) {
                    double d8 = dArr2[i6][0];
                    if (i6 > 0) {
                        Math.hypot(d8 - d6, d8 - d7);
                    }
                    i6++;
                    d6 = d8;
                } else {
                    this.mTotalLength = 0.0d;
                    return;
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0012, code lost:
    
        if (r8 >= r3) goto L4;
     */
    @Override // androidx.constraintlayout.motion.utils.CurveFit
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public double getSlope(double r8, int r10) {
        /*
            r7 = this;
            double[] r0 = r7.mT
            int r1 = r0.length
            r2 = 0
            r3 = r0[r2]
            int r5 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r5 >= 0) goto Lc
        La:
            r8 = r3
            goto L15
        Lc:
            int r3 = r1 + (-1)
            r3 = r0[r3]
            int r0 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r0 < 0) goto L15
            goto La
        L15:
            int r0 = r1 + (-1)
            if (r2 >= r0) goto L35
            double[] r0 = r7.mT
            int r3 = r2 + 1
            r4 = r0[r3]
            int r6 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r6 > 0) goto L33
            r8 = r0[r2]
            double r4 = r4 - r8
            double[][] r8 = r7.mY
            r9 = r8[r2]
            r0 = r9[r10]
            r8 = r8[r3]
            r9 = r8[r10]
            double r9 = r9 - r0
            double r9 = r9 / r4
            return r9
        L33:
            r2 = r3
            goto L15
        L35:
            r8 = 0
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.utils.LinearCurveFit.getSlope(double, int):double");
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
                double d9 = (d6 - d8) / (d7 - d8);
                while (i6 < length2) {
                    double[][] dArr3 = this.mY;
                    fArr[i6] = (float) ((dArr3[i9][i6] * (1.0d - d9)) + (dArr3[i11][i6] * d9));
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
                double d9 = (d6 - d7) / (d8 - d7);
                double[][] dArr3 = this.mY;
                return (dArr3[i7][i6] * (1.0d - d9)) + (dArr3[i9][i6] * d9);
            }
            i7 = i9;
        }
        return 0.0d;
    }
}
