package androidx.constraintlayout.motion.utils;

import java.util.Arrays;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
class ArcCurveFit extends CurveFit {
    public static final int ARC_START_FLIP = 3;
    public static final int ARC_START_HORIZONTAL = 2;
    public static final int ARC_START_LINEAR = 0;
    public static final int ARC_START_VERTICAL = 1;
    private static final int START_HORIZONTAL = 2;
    private static final int START_LINEAR = 3;
    private static final int START_VERTICAL = 1;
    Arc[] mArcs;
    private final double[] mTime;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class Arc {
        private static final double EPSILON = 0.001d;
        private static final String TAG = "Arc";
        private static double[] ourPercent = new double[91];
        boolean linear;
        double mArcDistance;
        double mArcVelocity;
        double mEllipseA;
        double mEllipseB;
        double mEllipseCenterX;
        double mEllipseCenterY;
        double[] mLut;
        double mOneOverDeltaTime;
        double mTime1;
        double mTime2;
        double mTmpCosAngle;
        double mTmpSinAngle;
        boolean mVertical;
        double mX1;
        double mX2;
        double mY1;
        double mY2;

        Arc(int i6, double d6, double d7, double d8, double d9, double d10, double d11) {
            this.linear = false;
            this.mVertical = i6 == 1;
            this.mTime1 = d6;
            this.mTime2 = d7;
            this.mOneOverDeltaTime = 1.0d / (d7 - d6);
            if (3 == i6) {
                this.linear = true;
            }
            double d12 = d10 - d8;
            double d13 = d11 - d9;
            if (!this.linear && Math.abs(d12) >= EPSILON && Math.abs(d13) >= EPSILON) {
                this.mLut = new double[101];
                boolean z5 = this.mVertical;
                this.mEllipseA = d12 * (z5 ? -1 : 1);
                this.mEllipseB = d13 * (z5 ? 1 : -1);
                this.mEllipseCenterX = z5 ? d10 : d8;
                this.mEllipseCenterY = z5 ? d9 : d11;
                buildTable(d8, d9, d10, d11);
                this.mArcVelocity = this.mArcDistance * this.mOneOverDeltaTime;
                return;
            }
            this.linear = true;
            this.mX1 = d8;
            this.mX2 = d10;
            this.mY1 = d9;
            this.mY2 = d11;
            double hypot = Math.hypot(d13, d12);
            this.mArcDistance = hypot;
            this.mArcVelocity = hypot * this.mOneOverDeltaTime;
            double d14 = this.mTime2;
            double d15 = this.mTime1;
            this.mEllipseCenterX = d12 / (d14 - d15);
            this.mEllipseCenterY = d13 / (d14 - d15);
        }

        private void buildTable(double d6, double d7, double d8, double d9) {
            double d10 = d8 - d6;
            double d11 = d7 - d9;
            int i6 = 0;
            double d12 = 0.0d;
            double d13 = 0.0d;
            double d14 = 0.0d;
            while (true) {
                if (i6 >= ourPercent.length) {
                    break;
                }
                int i7 = i6;
                double radians = Math.toRadians((i6 * 90.0d) / (r15.length - 1));
                double sin = Math.sin(radians) * d10;
                double cos = Math.cos(radians) * d11;
                if (i7 > 0) {
                    d12 += Math.hypot(sin - d13, cos - d14);
                    ourPercent[i7] = d12;
                }
                i6 = i7 + 1;
                d13 = sin;
                d14 = cos;
            }
            this.mArcDistance = d12;
            int i8 = 0;
            while (true) {
                double[] dArr = ourPercent;
                if (i8 >= dArr.length) {
                    break;
                }
                dArr[i8] = dArr[i8] / d12;
                i8++;
            }
            int i9 = 0;
            while (true) {
                if (i9 >= this.mLut.length) {
                    return;
                }
                double length = i9 / (r1.length - 1);
                int binarySearch = Arrays.binarySearch(ourPercent, length);
                if (binarySearch >= 0) {
                    this.mLut[i9] = binarySearch / (ourPercent.length - 1);
                } else if (binarySearch == -1) {
                    this.mLut[i9] = 0.0d;
                } else {
                    int i10 = -binarySearch;
                    int i11 = i10 - 2;
                    double[] dArr2 = ourPercent;
                    double d15 = dArr2[i11];
                    this.mLut[i9] = (i11 + ((length - d15) / (dArr2[i10 - 1] - d15))) / (dArr2.length - 1);
                }
                i9++;
            }
        }

        double getDX() {
            double d6 = this.mEllipseA * this.mTmpCosAngle;
            double hypot = this.mArcVelocity / Math.hypot(d6, (-this.mEllipseB) * this.mTmpSinAngle);
            return this.mVertical ? (-d6) * hypot : d6 * hypot;
        }

        double getDY() {
            double d6 = this.mEllipseA * this.mTmpCosAngle;
            double d7 = (-this.mEllipseB) * this.mTmpSinAngle;
            double hypot = this.mArcVelocity / Math.hypot(d6, d7);
            return this.mVertical ? (-d7) * hypot : d7 * hypot;
        }

        public double getLinearDX(double d6) {
            return this.mEllipseCenterX;
        }

        public double getLinearDY(double d6) {
            return this.mEllipseCenterY;
        }

        public double getLinearX(double d6) {
            double d7 = (d6 - this.mTime1) * this.mOneOverDeltaTime;
            double d8 = this.mX1;
            return d8 + (d7 * (this.mX2 - d8));
        }

        public double getLinearY(double d6) {
            double d7 = (d6 - this.mTime1) * this.mOneOverDeltaTime;
            double d8 = this.mY1;
            return d8 + (d7 * (this.mY2 - d8));
        }

        double getX() {
            return this.mEllipseCenterX + (this.mEllipseA * this.mTmpSinAngle);
        }

        double getY() {
            return this.mEllipseCenterY + (this.mEllipseB * this.mTmpCosAngle);
        }

        double lookup(double d6) {
            if (d6 <= 0.0d) {
                return 0.0d;
            }
            if (d6 >= 1.0d) {
                return 1.0d;
            }
            double[] dArr = this.mLut;
            double length = d6 * (dArr.length - 1);
            int i6 = (int) length;
            double d7 = length - i6;
            double d8 = dArr[i6];
            return d8 + (d7 * (dArr[i6 + 1] - d8));
        }

        void setPoint(double d6) {
            double lookup = lookup((this.mVertical ? this.mTime2 - d6 : d6 - this.mTime1) * this.mOneOverDeltaTime) * 1.5707963267948966d;
            this.mTmpSinAngle = Math.sin(lookup);
            this.mTmpCosAngle = Math.cos(lookup);
        }
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public void getPos(double d6, double[] dArr) {
        Arc[] arcArr = this.mArcs;
        double d7 = arcArr[0].mTime1;
        if (d6 < d7) {
            d6 = d7;
        }
        if (d6 > arcArr[arcArr.length - 1].mTime2) {
            d6 = arcArr[arcArr.length - 1].mTime2;
        }
        int i6 = 0;
        while (true) {
            Arc[] arcArr2 = this.mArcs;
            if (i6 >= arcArr2.length) {
                return;
            }
            Arc arc = arcArr2[i6];
            if (d6 <= arc.mTime2) {
                if (arc.linear) {
                    dArr[0] = arc.getLinearX(d6);
                    dArr[1] = this.mArcs[i6].getLinearY(d6);
                    return;
                } else {
                    arc.setPoint(d6);
                    dArr[0] = this.mArcs[i6].getX();
                    dArr[1] = this.mArcs[i6].getY();
                    return;
                }
            }
            i6++;
        }
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public void getSlope(double d6, double[] dArr) {
        Arc[] arcArr = this.mArcs;
        double d7 = arcArr[0].mTime1;
        if (d6 < d7) {
            d6 = d7;
        } else if (d6 > arcArr[arcArr.length - 1].mTime2) {
            d6 = arcArr[arcArr.length - 1].mTime2;
        }
        int i6 = 0;
        while (true) {
            Arc[] arcArr2 = this.mArcs;
            if (i6 >= arcArr2.length) {
                return;
            }
            Arc arc = arcArr2[i6];
            if (d6 <= arc.mTime2) {
                if (arc.linear) {
                    dArr[0] = arc.getLinearDX(d6);
                    dArr[1] = this.mArcs[i6].getLinearDY(d6);
                    return;
                } else {
                    arc.setPoint(d6);
                    dArr[0] = this.mArcs[i6].getDX();
                    dArr[1] = this.mArcs[i6].getDY();
                    return;
                }
            }
            i6++;
        }
    }

    public ArcCurveFit(int[] iArr, double[] dArr, double[][] dArr2) {
        this.mTime = dArr;
        this.mArcs = new Arc[dArr.length - 1];
        int i6 = 0;
        int i7 = 1;
        int i8 = 1;
        while (true) {
            Arc[] arcArr = this.mArcs;
            if (i6 >= arcArr.length) {
                return;
            }
            int i9 = iArr[i6];
            int i10 = 3;
            if (i9 != 0) {
                if (i9 == 1) {
                    i7 = 1;
                    i10 = 1;
                } else if (i9 == 2) {
                    i7 = 2;
                    i10 = 2;
                } else if (i9 != 3) {
                    i10 = i8;
                } else {
                    i7 = i7 == 1 ? 2 : 1;
                    i10 = i7;
                }
            }
            double d6 = dArr[i6];
            int i11 = i6 + 1;
            double d7 = dArr[i11];
            double[] dArr3 = dArr2[i6];
            double d8 = dArr3[0];
            double d9 = dArr3[1];
            double[] dArr4 = dArr2[i11];
            arcArr[i6] = new Arc(i10, d6, d7, d8, d9, dArr4[0], dArr4[1]);
            i6 = i11;
            i8 = i10;
        }
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public double[] getTimePoints() {
        return this.mTime;
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public void getPos(double d6, float[] fArr) {
        Arc[] arcArr = this.mArcs;
        double d7 = arcArr[0].mTime1;
        if (d6 < d7) {
            d6 = d7;
        } else if (d6 > arcArr[arcArr.length - 1].mTime2) {
            d6 = arcArr[arcArr.length - 1].mTime2;
        }
        int i6 = 0;
        while (true) {
            Arc[] arcArr2 = this.mArcs;
            if (i6 >= arcArr2.length) {
                return;
            }
            Arc arc = arcArr2[i6];
            if (d6 <= arc.mTime2) {
                if (arc.linear) {
                    fArr[0] = (float) arc.getLinearX(d6);
                    fArr[1] = (float) this.mArcs[i6].getLinearY(d6);
                    return;
                } else {
                    arc.setPoint(d6);
                    fArr[0] = (float) this.mArcs[i6].getX();
                    fArr[1] = (float) this.mArcs[i6].getY();
                    return;
                }
            }
            i6++;
        }
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public double getSlope(double d6, int i6) {
        Arc[] arcArr = this.mArcs;
        int i7 = 0;
        double d7 = arcArr[0].mTime1;
        if (d6 < d7) {
            d6 = d7;
        }
        if (d6 > arcArr[arcArr.length - 1].mTime2) {
            d6 = arcArr[arcArr.length - 1].mTime2;
        }
        while (true) {
            Arc[] arcArr2 = this.mArcs;
            if (i7 >= arcArr2.length) {
                return Double.NaN;
            }
            Arc arc = arcArr2[i7];
            if (d6 <= arc.mTime2) {
                if (arc.linear) {
                    if (i6 == 0) {
                        return arc.getLinearDX(d6);
                    }
                    return arc.getLinearDY(d6);
                }
                arc.setPoint(d6);
                if (i6 == 0) {
                    return this.mArcs[i7].getDX();
                }
                return this.mArcs[i7].getDY();
            }
            i7++;
        }
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public double getPos(double d6, int i6) {
        Arc[] arcArr = this.mArcs;
        int i7 = 0;
        double d7 = arcArr[0].mTime1;
        if (d6 < d7) {
            d6 = d7;
        } else if (d6 > arcArr[arcArr.length - 1].mTime2) {
            d6 = arcArr[arcArr.length - 1].mTime2;
        }
        while (true) {
            Arc[] arcArr2 = this.mArcs;
            if (i7 >= arcArr2.length) {
                return Double.NaN;
            }
            Arc arc = arcArr2[i7];
            if (d6 <= arc.mTime2) {
                if (arc.linear) {
                    if (i6 == 0) {
                        return arc.getLinearX(d6);
                    }
                    return arc.getLinearY(d6);
                }
                arc.setPoint(d6);
                if (i6 == 0) {
                    return this.mArcs[i7].getX();
                }
                return this.mArcs[i7].getY();
            }
            i7++;
        }
    }
}
