package androidx.constraintlayout.motion.widget;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.constraintlayout.motion.utils.Easing;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintSet;
import java.util.Arrays;
import java.util.LinkedHashMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
class MotionPaths implements Comparable<MotionPaths> {
    static final int CARTESIAN = 2;
    public static final boolean DEBUG = false;
    static final int OFF_HEIGHT = 4;
    static final int OFF_PATH_ROTATE = 5;
    static final int OFF_POSITION = 0;
    static final int OFF_WIDTH = 3;
    static final int OFF_X = 1;
    static final int OFF_Y = 2;
    public static final boolean OLD_WAY = false;
    static final int PERPENDICULAR = 1;
    static final int SCREEN = 3;
    public static final String TAG = "MotionPaths";
    static String[] names = {"position", "x", "y", "width", "height", "pathRotate"};
    LinkedHashMap<String, ConstraintAttribute> attributes;
    float height;
    int mDrawPath;
    Easing mKeyFrameEasing;
    int mMode;
    int mPathMotionArc;
    float mPathRotate;
    float mProgress;
    double[] mTempDelta;
    double[] mTempValue;
    float position;
    float time;
    float width;

    /* renamed from: x, reason: collision with root package name */
    float f811x;

    /* renamed from: y, reason: collision with root package name */
    float f812y;

    public MotionPaths() {
        this.mDrawPath = 0;
        this.mPathRotate = Float.NaN;
        this.mProgress = Float.NaN;
        this.mPathMotionArc = Key.UNSET;
        this.attributes = new LinkedHashMap<>();
        this.mMode = 0;
        this.mTempValue = new double[18];
        this.mTempDelta = new double[18];
    }

    private static final float xRotate(float f6, float f7, float f8, float f9, float f10, float f11) {
        return (((f10 - f8) * f7) - ((f11 - f9) * f6)) + f8;
    }

    private static final float yRotate(float f6, float f7, float f8, float f9, float f10, float f11) {
        return ((f10 - f8) * f6) + ((f11 - f9) * f7) + f9;
    }

    void different(MotionPaths motionPaths, boolean[] zArr, String[] strArr, boolean z5) {
        zArr[0] = zArr[0] | diff(this.position, motionPaths.position);
        zArr[1] = zArr[1] | diff(this.f811x, motionPaths.f811x) | z5;
        zArr[2] = z5 | diff(this.f812y, motionPaths.f812y) | zArr[2];
        zArr[3] = zArr[3] | diff(this.width, motionPaths.width);
        zArr[4] = diff(this.height, motionPaths.height) | zArr[4];
    }

    public void applyParameters(ConstraintSet.Constraint constraint) {
        this.mKeyFrameEasing = Easing.getInterpolator(constraint.motion.mTransitionEasing);
        ConstraintSet.Motion motion = constraint.motion;
        this.mPathMotionArc = motion.mPathMotionArc;
        this.mPathRotate = motion.mPathRotate;
        this.mDrawPath = motion.mDrawPath;
        this.mProgress = constraint.propertySet.mProgress;
        for (String str : constraint.mCustomConstraints.keySet()) {
            ConstraintAttribute constraintAttribute = constraint.mCustomConstraints.get(str);
            if (constraintAttribute.getType() != ConstraintAttribute.AttributeType.STRING_TYPE) {
                this.attributes.put(str, constraintAttribute);
            }
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(@NonNull MotionPaths motionPaths) {
        return Float.compare(this.position, motionPaths.position);
    }

    void fillStandard(double[] dArr, int[] iArr) {
        float[] fArr = {this.position, this.f811x, this.f812y, this.width, this.height, this.mPathRotate};
        int i6 = 0;
        for (int i7 : iArr) {
            if (i7 < 6) {
                dArr[i6] = fArr[r1];
                i6++;
            }
        }
    }

    void getBounds(int[] iArr, double[] dArr, float[] fArr, int i6) {
        float f6 = this.width;
        float f7 = this.height;
        for (int i7 = 0; i7 < iArr.length; i7++) {
            float f8 = (float) dArr[i7];
            int i8 = iArr[i7];
            if (i8 == 3) {
                f6 = f8;
            } else if (i8 == 4) {
                f7 = f8;
            }
        }
        fArr[i6] = f6;
        fArr[i6 + 1] = f7;
    }

    void getCenter(int[] iArr, double[] dArr, float[] fArr, int i6) {
        float f6 = this.f811x;
        float f7 = this.f812y;
        float f8 = this.width;
        float f9 = this.height;
        for (int i7 = 0; i7 < iArr.length; i7++) {
            float f10 = (float) dArr[i7];
            int i8 = iArr[i7];
            if (i8 == 1) {
                f6 = f10;
            } else if (i8 == 2) {
                f7 = f10;
            } else if (i8 == 3) {
                f8 = f10;
            } else if (i8 == 4) {
                f9 = f10;
            }
        }
        fArr[i6] = f6 + (f8 / 2.0f) + 0.0f;
        fArr[i6 + 1] = f7 + (f9 / 2.0f) + 0.0f;
    }

    int getCustomData(String str, double[] dArr, int i6) {
        ConstraintAttribute constraintAttribute = this.attributes.get(str);
        if (constraintAttribute.noOfInterpValues() == 1) {
            dArr[i6] = constraintAttribute.getValueToInterpolate();
            return 1;
        }
        int noOfInterpValues = constraintAttribute.noOfInterpValues();
        constraintAttribute.getValuesToInterpolate(new float[noOfInterpValues]);
        int i7 = 0;
        while (i7 < noOfInterpValues) {
            dArr[i6] = r1[i7];
            i7++;
            i6++;
        }
        return noOfInterpValues;
    }

    int getCustomDataCount(String str) {
        return this.attributes.get(str).noOfInterpValues();
    }

    void getRect(int[] iArr, double[] dArr, float[] fArr, int i6) {
        float f6 = this.f811x;
        float f7 = this.f812y;
        float f8 = this.width;
        float f9 = this.height;
        for (int i7 = 0; i7 < iArr.length; i7++) {
            float f10 = (float) dArr[i7];
            int i8 = iArr[i7];
            if (i8 == 1) {
                f6 = f10;
            } else if (i8 == 2) {
                f7 = f10;
            } else if (i8 == 3) {
                f8 = f10;
            } else if (i8 == 4) {
                f9 = f10;
            }
        }
        float f11 = f8 + f6;
        float f12 = f9 + f7;
        Float.isNaN(Float.NaN);
        Float.isNaN(Float.NaN);
        fArr[i6] = f6 + 0.0f;
        fArr[i6 + 1] = f7 + 0.0f;
        fArr[i6 + 2] = f11 + 0.0f;
        fArr[i6 + 3] = f7 + 0.0f;
        fArr[i6 + 4] = f11 + 0.0f;
        int i9 = i6 + 6;
        fArr[i6 + 5] = f12 + 0.0f;
        fArr[i9] = f6 + 0.0f;
        fArr[i6 + 7] = f12 + 0.0f;
    }

    boolean hasCustomData(String str) {
        return this.attributes.containsKey(str);
    }

    void initCartesian(KeyPosition keyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f6 = keyPosition.mFramePosition / 100.0f;
        this.time = f6;
        this.mDrawPath = keyPosition.mDrawPath;
        float f7 = Float.isNaN(keyPosition.mPercentWidth) ? f6 : keyPosition.mPercentWidth;
        float f8 = Float.isNaN(keyPosition.mPercentHeight) ? f6 : keyPosition.mPercentHeight;
        float f9 = motionPaths2.width;
        float f10 = motionPaths.width;
        float f11 = motionPaths2.height;
        float f12 = motionPaths.height;
        this.position = this.time;
        float f13 = motionPaths.f811x;
        float f14 = motionPaths.f812y;
        float f15 = f6;
        float f16 = (motionPaths2.f811x + (f9 / 2.0f)) - ((f10 / 2.0f) + f13);
        float f17 = (motionPaths2.f812y + (f11 / 2.0f)) - (f14 + (f12 / 2.0f));
        float f18 = ((f9 - f10) * f7) / 2.0f;
        this.f811x = (int) ((f13 + (f16 * f15)) - f18);
        float f19 = ((f11 - f12) * f8) / 2.0f;
        this.f812y = (int) ((f14 + (f17 * f15)) - f19);
        this.width = (int) (f10 + r9);
        this.height = (int) (f12 + r12);
        float f20 = Float.isNaN(keyPosition.mPercentX) ? f15 : keyPosition.mPercentX;
        float f21 = Float.isNaN(keyPosition.mAltPercentY) ? 0.0f : keyPosition.mAltPercentY;
        if (!Float.isNaN(keyPosition.mPercentY)) {
            f15 = keyPosition.mPercentY;
        }
        float f22 = Float.isNaN(keyPosition.mAltPercentX) ? 0.0f : keyPosition.mAltPercentX;
        this.mMode = 2;
        this.f811x = (int) (((motionPaths.f811x + (f20 * f16)) + (f22 * f17)) - f18);
        this.f812y = (int) (((motionPaths.f812y + (f16 * f21)) + (f17 * f15)) - f19);
        this.mKeyFrameEasing = Easing.getInterpolator(keyPosition.mTransitionEasing);
        this.mPathMotionArc = keyPosition.mPathMotionArc;
    }

    void initPath(KeyPosition keyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f6 = keyPosition.mFramePosition / 100.0f;
        this.time = f6;
        this.mDrawPath = keyPosition.mDrawPath;
        float f7 = Float.isNaN(keyPosition.mPercentWidth) ? f6 : keyPosition.mPercentWidth;
        float f8 = Float.isNaN(keyPosition.mPercentHeight) ? f6 : keyPosition.mPercentHeight;
        float f9 = motionPaths2.width - motionPaths.width;
        float f10 = motionPaths2.height - motionPaths.height;
        this.position = this.time;
        if (!Float.isNaN(keyPosition.mPercentX)) {
            f6 = keyPosition.mPercentX;
        }
        float f11 = motionPaths.f811x;
        float f12 = motionPaths.width;
        float f13 = motionPaths.f812y;
        float f14 = motionPaths.height;
        float f15 = f6;
        float f16 = (motionPaths2.f811x + (motionPaths2.width / 2.0f)) - ((f12 / 2.0f) + f11);
        float f17 = (motionPaths2.f812y + (motionPaths2.height / 2.0f)) - ((f14 / 2.0f) + f13);
        float f18 = f16 * f15;
        float f19 = (f9 * f7) / 2.0f;
        this.f811x = (int) ((f11 + f18) - f19);
        float f20 = f17 * f15;
        float f21 = (f10 * f8) / 2.0f;
        this.f812y = (int) ((f13 + f20) - f21);
        this.width = (int) (f12 + r7);
        this.height = (int) (f14 + r8);
        float f22 = Float.isNaN(keyPosition.mPercentY) ? 0.0f : keyPosition.mPercentY;
        this.mMode = 1;
        float f23 = (int) ((motionPaths.f811x + f18) - f19);
        float f24 = (int) ((motionPaths.f812y + f20) - f21);
        this.f811x = f23 + ((-f17) * f22);
        this.f812y = f24 + (f16 * f22);
        this.mKeyFrameEasing = Easing.getInterpolator(keyPosition.mTransitionEasing);
        this.mPathMotionArc = keyPosition.mPathMotionArc;
    }

    void initScreen(int i6, int i7, KeyPosition keyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f6 = keyPosition.mFramePosition / 100.0f;
        this.time = f6;
        this.mDrawPath = keyPosition.mDrawPath;
        float f7 = Float.isNaN(keyPosition.mPercentWidth) ? f6 : keyPosition.mPercentWidth;
        float f8 = Float.isNaN(keyPosition.mPercentHeight) ? f6 : keyPosition.mPercentHeight;
        float f9 = motionPaths2.width;
        float f10 = motionPaths.width;
        float f11 = motionPaths2.height;
        float f12 = motionPaths.height;
        this.position = this.time;
        float f13 = motionPaths.f811x;
        float f14 = motionPaths.f812y;
        float f15 = motionPaths2.f811x + (f9 / 2.0f);
        float f16 = motionPaths2.f812y + (f11 / 2.0f);
        float f17 = (f9 - f10) * f7;
        this.f811x = (int) ((f13 + ((f15 - ((f10 / 2.0f) + f13)) * f6)) - (f17 / 2.0f));
        float f18 = (f11 - f12) * f8;
        this.f812y = (int) ((f14 + ((f16 - (f14 + (f12 / 2.0f))) * f6)) - (f18 / 2.0f));
        this.width = (int) (f10 + f17);
        this.height = (int) (f12 + f18);
        this.mMode = 3;
        if (!Float.isNaN(keyPosition.mPercentX)) {
            this.f811x = (int) (keyPosition.mPercentX * ((int) (i6 - this.width)));
        }
        if (!Float.isNaN(keyPosition.mPercentY)) {
            this.f812y = (int) (keyPosition.mPercentY * ((int) (i7 - this.height)));
        }
        this.mKeyFrameEasing = Easing.getInterpolator(keyPosition.mTransitionEasing);
        this.mPathMotionArc = keyPosition.mPathMotionArc;
    }

    void setBounds(float f6, float f7, float f8, float f9) {
        this.f811x = f6;
        this.f812y = f7;
        this.width = f8;
        this.height = f9;
    }

    void setDpDt(float f6, float f7, float[] fArr, int[] iArr, double[] dArr, double[] dArr2) {
        float f8 = 0.0f;
        float f9 = 0.0f;
        float f10 = 0.0f;
        float f11 = 0.0f;
        for (int i6 = 0; i6 < iArr.length; i6++) {
            float f12 = (float) dArr[i6];
            double d6 = dArr2[i6];
            int i7 = iArr[i6];
            if (i7 == 1) {
                f8 = f12;
            } else if (i7 == 2) {
                f10 = f12;
            } else if (i7 == 3) {
                f9 = f12;
            } else if (i7 == 4) {
                f11 = f12;
            }
        }
        float f13 = f8 - ((0.0f * f9) / 2.0f);
        float f14 = f10 - ((0.0f * f11) / 2.0f);
        fArr[0] = (f13 * (1.0f - f6)) + (((f9 * 1.0f) + f13) * f6) + 0.0f;
        fArr[1] = (f14 * (1.0f - f7)) + (((f11 * 1.0f) + f14) * f7) + 0.0f;
    }

    void setView(View view, int[] iArr, double[] dArr, double[] dArr2, double[] dArr3) {
        float f6;
        float f7;
        float f8 = this.f811x;
        float f9 = this.f812y;
        float f10 = this.width;
        float f11 = this.height;
        if (iArr.length != 0 && this.mTempValue.length <= iArr[iArr.length - 1]) {
            int i6 = iArr[iArr.length - 1] + 1;
            this.mTempValue = new double[i6];
            this.mTempDelta = new double[i6];
        }
        Arrays.fill(this.mTempValue, Double.NaN);
        int i7 = 0;
        for (int i8 = 0; i8 < iArr.length; i8++) {
            double[] dArr4 = this.mTempValue;
            int i9 = iArr[i8];
            dArr4[i9] = dArr[i8];
            this.mTempDelta[i9] = dArr2[i8];
        }
        float f12 = Float.NaN;
        float f13 = 0.0f;
        float f14 = 0.0f;
        float f15 = 0.0f;
        float f16 = 0.0f;
        while (true) {
            double[] dArr5 = this.mTempValue;
            if (i7 >= dArr5.length) {
                break;
            }
            if (Double.isNaN(dArr5[i7]) && (dArr3 == null || dArr3[i7] == 0.0d)) {
                f6 = f12;
                f7 = f8;
            } else {
                double d6 = dArr3 != null ? dArr3[i7] : 0.0d;
                if (!Double.isNaN(this.mTempValue[i7])) {
                    d6 = this.mTempValue[i7] + d6;
                }
                f6 = f12;
                float f17 = (float) d6;
                f7 = f8;
                float f18 = (float) this.mTempDelta[i7];
                if (i7 != 1) {
                    if (i7 == 2) {
                        f15 = f18;
                        f8 = f7;
                        f9 = f17;
                    } else if (i7 == 3) {
                        f14 = f18;
                        f8 = f7;
                        f10 = f17;
                    } else if (i7 == 4) {
                        f16 = f18;
                        f8 = f7;
                        f11 = f17;
                    } else if (i7 == 5) {
                        f8 = f7;
                        f12 = f17;
                    }
                    f12 = f6;
                } else {
                    f12 = f6;
                    f13 = f18;
                    f8 = f17;
                }
                i7++;
            }
            f8 = f7;
            f12 = f6;
            i7++;
        }
        float f19 = f12;
        float f20 = f8;
        if (!Float.isNaN(f19)) {
            view.setRotation((float) ((Float.isNaN(Float.NaN) ? 0.0f : Float.NaN) + f19 + Math.toDegrees(Math.atan2(f15 + (f16 / 2.0f), f13 + (f14 / 2.0f)))));
        } else if (!Float.isNaN(Float.NaN)) {
            view.setRotation(Float.NaN);
        }
        float f21 = f20 + 0.5f;
        int i10 = (int) f21;
        float f22 = f9 + 0.5f;
        int i11 = (int) f22;
        int i12 = (int) (f21 + f10);
        int i13 = (int) (f22 + f11);
        int i14 = i12 - i10;
        int i15 = i13 - i11;
        if (i14 != view.getMeasuredWidth() || i15 != view.getMeasuredHeight()) {
            view.measure(View.MeasureSpec.makeMeasureSpec(i14, 1073741824), View.MeasureSpec.makeMeasureSpec(i15, 1073741824));
        }
        view.layout(i10, i11, i12, i13);
    }

    private boolean diff(float f6, float f7) {
        if (!Float.isNaN(f6) && !Float.isNaN(f7)) {
            if (Math.abs(f6 - f7) <= 1.0E-6f) {
                return false;
            }
            return true;
        }
        if (Float.isNaN(f6) == Float.isNaN(f7)) {
            return false;
        }
        return true;
    }

    public MotionPaths(int i6, int i7, KeyPosition keyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        this.mDrawPath = 0;
        this.mPathRotate = Float.NaN;
        this.mProgress = Float.NaN;
        this.mPathMotionArc = Key.UNSET;
        this.attributes = new LinkedHashMap<>();
        this.mMode = 0;
        this.mTempValue = new double[18];
        this.mTempDelta = new double[18];
        int i8 = keyPosition.mPositionType;
        if (i8 == 1) {
            initPath(keyPosition, motionPaths, motionPaths2);
        } else if (i8 != 2) {
            initCartesian(keyPosition, motionPaths, motionPaths2);
        } else {
            initScreen(i6, i7, keyPosition, motionPaths, motionPaths2);
        }
    }
}
