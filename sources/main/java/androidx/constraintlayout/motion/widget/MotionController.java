package androidx.constraintlayout.motion.widget;

import android.graphics.RectF;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.utils.CurveFit;
import androidx.constraintlayout.motion.utils.Easing;
import androidx.constraintlayout.motion.utils.VelocityMatrix;
import androidx.constraintlayout.motion.widget.KeyCycleOscillator;
import androidx.constraintlayout.motion.widget.SplineSet;
import androidx.constraintlayout.motion.widget.TimeCycleSplineSet;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public class MotionController {
    private static final boolean DEBUG = false;
    public static final int DRAW_PATH_AS_CONFIGURED = 4;
    public static final int DRAW_PATH_BASIC = 1;
    public static final int DRAW_PATH_CARTESIAN = 3;
    public static final int DRAW_PATH_NONE = 0;
    public static final int DRAW_PATH_RECTANGLE = 5;
    public static final int DRAW_PATH_RELATIVE = 2;
    public static final int DRAW_PATH_SCREEN = 6;
    private static final boolean FAVOR_FIXED_SIZE_VIEWS = false;
    public static final int HORIZONTAL_PATH_X = 2;
    public static final int HORIZONTAL_PATH_Y = 3;
    public static final int PATH_PERCENT = 0;
    public static final int PATH_PERPENDICULAR = 1;
    private static final String TAG = "MotionController";
    public static final int VERTICAL_PATH_X = 4;
    public static final int VERTICAL_PATH_Y = 5;
    String[] attributeTable;
    private CurveFit mArcSpline;
    private int[] mAttributeInterpCount;
    private String[] mAttributeNames;
    private HashMap<String, SplineSet> mAttributesMap;
    String mConstraintTag;
    private HashMap<String, KeyCycleOscillator> mCycleMap;
    int mId;
    private double[] mInterpolateData;
    private int[] mInterpolateVariables;
    private double[] mInterpolateVelocity;
    private KeyTrigger[] mKeyTriggers;
    private CurveFit[] mSpline;
    private HashMap<String, TimeCycleSplineSet> mTimeCycleAttributesMap;
    View mView;
    private int mCurveFitType = -1;
    private MotionPaths mStartMotionPath = new MotionPaths();
    private MotionPaths mEndMotionPath = new MotionPaths();
    private MotionConstrainedPoint mStartPoint = new MotionConstrainedPoint();
    private MotionConstrainedPoint mEndPoint = new MotionConstrainedPoint();
    float mMotionStagger = Float.NaN;
    float mStaggerOffset = 0.0f;
    float mStaggerScale = 1.0f;
    private int MAX_DIMENSION = 4;
    private float[] mValuesBuff = new float[4];
    private ArrayList<MotionPaths> mMotionPaths = new ArrayList<>();
    private float[] mVelocity = new float[1];
    private ArrayList<Key> mKeyList = new ArrayList<>();
    private int mPathMotionArc = Key.UNSET;

    private float getAdjustedPosition(float f6, float[] fArr) {
        float f7 = 0.0f;
        if (fArr != null) {
            fArr[0] = 1.0f;
        } else {
            float f8 = this.mStaggerScale;
            if (f8 != 1.0d) {
                float f9 = this.mStaggerOffset;
                if (f6 < f9) {
                    f6 = 0.0f;
                }
                if (f6 > f9 && f6 < 1.0d) {
                    f6 = (f6 - f9) * f8;
                }
            }
        }
        Easing easing = this.mStartMotionPath.mKeyFrameEasing;
        Iterator<MotionPaths> it = this.mMotionPaths.iterator();
        float f10 = Float.NaN;
        while (it.hasNext()) {
            MotionPaths next = it.next();
            Easing easing2 = next.mKeyFrameEasing;
            if (easing2 != null) {
                float f11 = next.time;
                if (f11 < f6) {
                    easing = easing2;
                    f7 = f11;
                } else if (Float.isNaN(f10)) {
                    f10 = next.time;
                }
            }
        }
        if (easing != null) {
            float f12 = (Float.isNaN(f10) ? 1.0f : f10) - f7;
            double d6 = (f6 - f7) / f12;
            f6 = (((float) easing.get(d6)) * f12) + f7;
            if (fArr != null) {
                fArr[0] = (float) easing.getDiff(d6);
            }
        }
        return f6;
    }

    int buildKeyBounds(float[] fArr, int[] iArr) {
        if (fArr == null) {
            return 0;
        }
        double[] timePoints = this.mSpline[0].getTimePoints();
        if (iArr != null) {
            Iterator<MotionPaths> it = this.mMotionPaths.iterator();
            int i6 = 0;
            while (it.hasNext()) {
                iArr[i6] = it.next().mMode;
                i6++;
            }
        }
        int i7 = 0;
        for (double d6 : timePoints) {
            this.mSpline[0].getPos(d6, this.mInterpolateData);
            this.mStartMotionPath.getBounds(this.mInterpolateVariables, this.mInterpolateData, fArr, i7);
            i7 += 2;
        }
        return i7 / 2;
    }

    int buildKeyFrames(float[] fArr, int[] iArr) {
        if (fArr == null) {
            return 0;
        }
        double[] timePoints = this.mSpline[0].getTimePoints();
        if (iArr != null) {
            Iterator<MotionPaths> it = this.mMotionPaths.iterator();
            int i6 = 0;
            while (it.hasNext()) {
                iArr[i6] = it.next().mMode;
                i6++;
            }
        }
        int i7 = 0;
        for (double d6 : timePoints) {
            this.mSpline[0].getPos(d6, this.mInterpolateData);
            this.mStartMotionPath.getCenter(this.mInterpolateVariables, this.mInterpolateData, fArr, i7);
            i7 += 2;
        }
        return i7 / 2;
    }

    void buildRect(float f6, float[] fArr, int i6) {
        this.mSpline[0].getPos(getAdjustedPosition(f6, null), this.mInterpolateData);
        this.mStartMotionPath.getRect(this.mInterpolateVariables, this.mInterpolateData, fArr, i6);
    }

    public int getKeyFrameInfo(int i6, int[] iArr) {
        float[] fArr = new float[2];
        Iterator<Key> it = this.mKeyList.iterator();
        int i7 = 0;
        int i8 = 0;
        while (it.hasNext()) {
            Key next = it.next();
            int i9 = next.mType;
            if (i9 == i6 || i6 != -1) {
                iArr[i8] = 0;
                iArr[i8 + 1] = i9;
                iArr[i8 + 2] = next.mFramePosition;
                this.mSpline[0].getPos(r7 / 100.0f, this.mInterpolateData);
                this.mStartMotionPath.getCenter(this.mInterpolateVariables, this.mInterpolateData, fArr, 0);
                iArr[i8 + 3] = Float.floatToIntBits(fArr[0]);
                int i10 = i8 + 4;
                iArr[i10] = Float.floatToIntBits(fArr[1]);
                if (next instanceof KeyPosition) {
                    KeyPosition keyPosition = (KeyPosition) next;
                    iArr[i8 + 5] = keyPosition.mPositionType;
                    iArr[i8 + 6] = Float.floatToIntBits(keyPosition.mPercentX);
                    i10 = i8 + 7;
                    iArr[i10] = Float.floatToIntBits(keyPosition.mPercentY);
                }
                int i11 = i10 + 1;
                iArr[i8] = i11 - i8;
                i7++;
                i8 = i11;
            }
        }
        return i7;
    }

    private float getPreCycleDistance() {
        float[] fArr = new float[2];
        float f6 = 1.0f / 99;
        double d6 = 0.0d;
        double d7 = 0.0d;
        int i6 = 0;
        float f7 = 0.0f;
        while (i6 < 100) {
            float f8 = i6 * f6;
            double d8 = f8;
            Easing easing = this.mStartMotionPath.mKeyFrameEasing;
            Iterator<MotionPaths> it = this.mMotionPaths.iterator();
            float f9 = Float.NaN;
            float f10 = 0.0f;
            while (it.hasNext()) {
                MotionPaths next = it.next();
                Easing easing2 = next.mKeyFrameEasing;
                float f11 = f6;
                if (easing2 != null) {
                    float f12 = next.time;
                    if (f12 < f8) {
                        f10 = f12;
                        easing = easing2;
                    } else if (Float.isNaN(f9)) {
                        f9 = next.time;
                    }
                }
                f6 = f11;
            }
            float f13 = f6;
            if (easing != null) {
                if (Float.isNaN(f9)) {
                    f9 = 1.0f;
                }
                d8 = (((float) easing.get((f8 - f10) / r16)) * (f9 - f10)) + f10;
            }
            this.mSpline[0].getPos(d8, this.mInterpolateData);
            this.mStartMotionPath.getCenter(this.mInterpolateVariables, this.mInterpolateData, fArr, 0);
            if (i6 > 0) {
                f7 = (float) (f7 + Math.hypot(d7 - fArr[1], d6 - fArr[0]));
            }
            d6 = fArr[0];
            d7 = fArr[1];
            i6++;
            f6 = f13;
        }
        return f7;
    }

    private void insertKey(MotionPaths motionPaths) {
        if (Collections.binarySearch(this.mMotionPaths, motionPaths) == 0) {
            float f6 = motionPaths.position;
        }
        this.mMotionPaths.add((-r0) - 1, motionPaths);
    }

    private void readView(MotionPaths motionPaths) {
        motionPaths.setBounds((int) this.mView.getX(), (int) this.mView.getY(), this.mView.getWidth(), this.mView.getHeight());
    }

    void addKey(Key key) {
        this.mKeyList.add(key);
    }

    void addKeys(ArrayList<Key> arrayList) {
        this.mKeyList.addAll(arrayList);
    }

    void buildBounds(float[] fArr, int i6) {
        float f6 = 1.0f / (i6 - 1);
        HashMap<String, SplineSet> hashMap = this.mAttributesMap;
        if (hashMap != null) {
            hashMap.get("translationX");
        }
        HashMap<String, SplineSet> hashMap2 = this.mAttributesMap;
        if (hashMap2 != null) {
            hashMap2.get("translationY");
        }
        HashMap<String, KeyCycleOscillator> hashMap3 = this.mCycleMap;
        if (hashMap3 != null) {
            hashMap3.get("translationX");
        }
        HashMap<String, KeyCycleOscillator> hashMap4 = this.mCycleMap;
        if (hashMap4 != null) {
            hashMap4.get("translationY");
        }
        for (int i7 = 0; i7 < i6; i7++) {
            float f7 = i7 * f6;
            float f8 = this.mStaggerScale;
            float f9 = 0.0f;
            if (f8 != 1.0f) {
                float f10 = this.mStaggerOffset;
                if (f7 < f10) {
                    f7 = 0.0f;
                }
                if (f7 > f10 && f7 < 1.0d) {
                    f7 = (f7 - f10) * f8;
                }
            }
            double d6 = f7;
            Easing easing = this.mStartMotionPath.mKeyFrameEasing;
            Iterator<MotionPaths> it = this.mMotionPaths.iterator();
            float f11 = Float.NaN;
            while (it.hasNext()) {
                MotionPaths next = it.next();
                Easing easing2 = next.mKeyFrameEasing;
                if (easing2 != null) {
                    float f12 = next.time;
                    if (f12 < f7) {
                        easing = easing2;
                        f9 = f12;
                    } else if (Float.isNaN(f11)) {
                        f11 = next.time;
                    }
                }
            }
            if (easing != null) {
                if (Float.isNaN(f11)) {
                    f11 = 1.0f;
                }
                d6 = (((float) easing.get((f7 - f9) / r12)) * (f11 - f9)) + f9;
            }
            this.mSpline[0].getPos(d6, this.mInterpolateData);
            CurveFit curveFit = this.mArcSpline;
            if (curveFit != null) {
                double[] dArr = this.mInterpolateData;
                if (dArr.length > 0) {
                    curveFit.getPos(d6, dArr);
                }
            }
            this.mStartMotionPath.getBounds(this.mInterpolateVariables, this.mInterpolateData, fArr, i7 * 2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00ec  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void buildPath(float[] r22, int r23) {
        /*
            Method dump skipped, instructions count: 283
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionController.buildPath(float[], int):void");
    }

    void buildRectangles(float[] fArr, int i6) {
        float f6 = 1.0f / (i6 - 1);
        for (int i7 = 0; i7 < i6; i7++) {
            this.mSpline[0].getPos(getAdjustedPosition(i7 * f6, null), this.mInterpolateData);
            this.mStartMotionPath.getRect(this.mInterpolateVariables, this.mInterpolateData, fArr, i7 * 8);
        }
    }

    int getAttributeValues(String str, float[] fArr, int i6) {
        SplineSet splineSet = this.mAttributesMap.get(str);
        if (splineSet == null) {
            return -1;
        }
        for (int i7 = 0; i7 < fArr.length; i7++) {
            fArr[i7] = splineSet.get(i7 / (fArr.length - 1));
        }
        return fArr.length;
    }

    void getDpDt(float f6, float f7, float f8, float[] fArr) {
        double[] dArr;
        float adjustedPosition = getAdjustedPosition(f6, this.mVelocity);
        CurveFit[] curveFitArr = this.mSpline;
        int i6 = 0;
        if (curveFitArr == null) {
            MotionPaths motionPaths = this.mEndMotionPath;
            float f9 = motionPaths.f811x;
            MotionPaths motionPaths2 = this.mStartMotionPath;
            float f10 = f9 - motionPaths2.f811x;
            float f11 = motionPaths.f812y - motionPaths2.f812y;
            float f12 = (motionPaths.width - motionPaths2.width) + f10;
            float f13 = (motionPaths.height - motionPaths2.height) + f11;
            fArr[0] = (f10 * (1.0f - f7)) + (f12 * f7);
            fArr[1] = (f11 * (1.0f - f8)) + (f13 * f8);
            return;
        }
        double d6 = adjustedPosition;
        curveFitArr[0].getSlope(d6, this.mInterpolateVelocity);
        this.mSpline[0].getPos(d6, this.mInterpolateData);
        float f14 = this.mVelocity[0];
        while (true) {
            dArr = this.mInterpolateVelocity;
            if (i6 >= dArr.length) {
                break;
            }
            dArr[i6] = dArr[i6] * f14;
            i6++;
        }
        CurveFit curveFit = this.mArcSpline;
        if (curveFit == null) {
            this.mStartMotionPath.setDpDt(f7, f8, fArr, this.mInterpolateVariables, dArr, this.mInterpolateData);
            return;
        }
        double[] dArr2 = this.mInterpolateData;
        if (dArr2.length > 0) {
            curveFit.getPos(d6, dArr2);
            this.mArcSpline.getSlope(d6, this.mInterpolateVelocity);
            this.mStartMotionPath.setDpDt(f7, f8, fArr, this.mInterpolateVariables, this.mInterpolateVelocity, this.mInterpolateData);
        }
    }

    public int getDrawPath() {
        int i6 = this.mStartMotionPath.mDrawPath;
        Iterator<MotionPaths> it = this.mMotionPaths.iterator();
        while (it.hasNext()) {
            i6 = Math.max(i6, it.next().mDrawPath);
        }
        return Math.max(i6, this.mEndMotionPath.mDrawPath);
    }

    float getFinalX() {
        return this.mEndMotionPath.f811x;
    }

    float getFinalY() {
        return this.mEndMotionPath.f812y;
    }

    MotionPaths getKeyFrame(int i6) {
        return this.mMotionPaths.get(i6);
    }

    float getKeyFrameParameter(int i6, float f6, float f7) {
        MotionPaths motionPaths = this.mEndMotionPath;
        float f8 = motionPaths.f811x;
        MotionPaths motionPaths2 = this.mStartMotionPath;
        float f9 = motionPaths2.f811x;
        float f10 = f8 - f9;
        float f11 = motionPaths.f812y;
        float f12 = motionPaths2.f812y;
        float f13 = f11 - f12;
        float f14 = f9 + (motionPaths2.width / 2.0f);
        float f15 = f12 + (motionPaths2.height / 2.0f);
        float hypot = (float) Math.hypot(f10, f13);
        if (hypot < 1.0E-7d) {
            return Float.NaN;
        }
        float f16 = f6 - f14;
        float f17 = f7 - f15;
        if (((float) Math.hypot(f16, f17)) == 0.0f) {
            return 0.0f;
        }
        float f18 = (f16 * f10) + (f17 * f13);
        if (i6 == 0) {
            return f18 / hypot;
        }
        if (i6 == 1) {
            return (float) Math.sqrt((hypot * hypot) - (f18 * f18));
        }
        if (i6 == 2) {
            return f16 / f10;
        }
        if (i6 == 3) {
            return f17 / f10;
        }
        if (i6 == 4) {
            return f16 / f13;
        }
        if (i6 != 5) {
            return 0.0f;
        }
        return f17 / f13;
    }

    KeyPositionBase getPositionKeyframe(int i6, int i7, float f6, float f7) {
        int i8;
        int i9;
        float f8;
        float f9;
        RectF rectF = new RectF();
        MotionPaths motionPaths = this.mStartMotionPath;
        float f10 = motionPaths.f811x;
        rectF.left = f10;
        float f11 = motionPaths.f812y;
        rectF.top = f11;
        rectF.right = f10 + motionPaths.width;
        rectF.bottom = f11 + motionPaths.height;
        RectF rectF2 = new RectF();
        MotionPaths motionPaths2 = this.mEndMotionPath;
        float f12 = motionPaths2.f811x;
        rectF2.left = f12;
        float f13 = motionPaths2.f812y;
        rectF2.top = f13;
        rectF2.right = f12 + motionPaths2.width;
        rectF2.bottom = f13 + motionPaths2.height;
        Iterator<Key> it = this.mKeyList.iterator();
        while (it.hasNext()) {
            Key next = it.next();
            if (next instanceof KeyPositionBase) {
                KeyPositionBase keyPositionBase = (KeyPositionBase) next;
                i8 = i6;
                i9 = i7;
                f8 = f6;
                f9 = f7;
                if (keyPositionBase.intersects(i8, i9, rectF, rectF2, f8, f9)) {
                    return keyPositionBase;
                }
            } else {
                i8 = i6;
                i9 = i7;
                f8 = f6;
                f9 = f7;
            }
            i6 = i8;
            i7 = i9;
            f6 = f8;
            f7 = f9;
        }
        return null;
    }

    void getPostLayoutDvDp(float f6, int i6, int i7, float f7, float f8, float[] fArr) {
        float adjustedPosition = getAdjustedPosition(f6, this.mVelocity);
        HashMap<String, SplineSet> hashMap = this.mAttributesMap;
        SplineSet splineSet = hashMap == null ? null : hashMap.get("translationX");
        HashMap<String, SplineSet> hashMap2 = this.mAttributesMap;
        SplineSet splineSet2 = hashMap2 == null ? null : hashMap2.get("translationY");
        HashMap<String, SplineSet> hashMap3 = this.mAttributesMap;
        SplineSet splineSet3 = hashMap3 == null ? null : hashMap3.get("rotation");
        HashMap<String, SplineSet> hashMap4 = this.mAttributesMap;
        SplineSet splineSet4 = hashMap4 == null ? null : hashMap4.get("scaleX");
        HashMap<String, SplineSet> hashMap5 = this.mAttributesMap;
        SplineSet splineSet5 = hashMap5 == null ? null : hashMap5.get("scaleY");
        HashMap<String, KeyCycleOscillator> hashMap6 = this.mCycleMap;
        KeyCycleOscillator keyCycleOscillator = hashMap6 == null ? null : hashMap6.get("translationX");
        HashMap<String, KeyCycleOscillator> hashMap7 = this.mCycleMap;
        KeyCycleOscillator keyCycleOscillator2 = hashMap7 == null ? null : hashMap7.get("translationY");
        HashMap<String, KeyCycleOscillator> hashMap8 = this.mCycleMap;
        KeyCycleOscillator keyCycleOscillator3 = hashMap8 == null ? null : hashMap8.get("rotation");
        HashMap<String, KeyCycleOscillator> hashMap9 = this.mCycleMap;
        KeyCycleOscillator keyCycleOscillator4 = hashMap9 == null ? null : hashMap9.get("scaleX");
        HashMap<String, KeyCycleOscillator> hashMap10 = this.mCycleMap;
        KeyCycleOscillator keyCycleOscillator5 = hashMap10 != null ? hashMap10.get("scaleY") : null;
        VelocityMatrix velocityMatrix = new VelocityMatrix();
        velocityMatrix.clear();
        velocityMatrix.setRotationVelocity(splineSet3, adjustedPosition);
        velocityMatrix.setTranslationVelocity(splineSet, splineSet2, adjustedPosition);
        velocityMatrix.setScaleVelocity(splineSet4, splineSet5, adjustedPosition);
        velocityMatrix.setRotationVelocity(keyCycleOscillator3, adjustedPosition);
        velocityMatrix.setTranslationVelocity(keyCycleOscillator, keyCycleOscillator2, adjustedPosition);
        velocityMatrix.setScaleVelocity(keyCycleOscillator4, keyCycleOscillator5, adjustedPosition);
        CurveFit curveFit = this.mArcSpline;
        if (curveFit != null) {
            double[] dArr = this.mInterpolateData;
            if (dArr.length > 0) {
                double d6 = adjustedPosition;
                curveFit.getPos(d6, dArr);
                this.mArcSpline.getSlope(d6, this.mInterpolateVelocity);
                this.mStartMotionPath.setDpDt(f7, f8, fArr, this.mInterpolateVariables, this.mInterpolateVelocity, this.mInterpolateData);
            }
            velocityMatrix.applyTransform(f7, f8, i6, i7, fArr);
            return;
        }
        int i8 = 0;
        if (this.mSpline == null) {
            MotionPaths motionPaths = this.mEndMotionPath;
            float f9 = motionPaths.f811x;
            MotionPaths motionPaths2 = this.mStartMotionPath;
            float f10 = f9 - motionPaths2.f811x;
            float f11 = motionPaths.f812y - motionPaths2.f812y;
            float f12 = (motionPaths.width - motionPaths2.width) + f10;
            float f13 = f11 + (motionPaths.height - motionPaths2.height);
            fArr[0] = (f10 * (1.0f - f7)) + (f12 * f7);
            fArr[1] = (f11 * (1.0f - f8)) + (f13 * f8);
            velocityMatrix.clear();
            velocityMatrix.setRotationVelocity(splineSet3, adjustedPosition);
            velocityMatrix.setTranslationVelocity(splineSet, splineSet2, adjustedPosition);
            velocityMatrix.setScaleVelocity(splineSet4, splineSet5, adjustedPosition);
            velocityMatrix.setRotationVelocity(keyCycleOscillator3, adjustedPosition);
            velocityMatrix.setTranslationVelocity(keyCycleOscillator, keyCycleOscillator2, adjustedPosition);
            velocityMatrix.setScaleVelocity(keyCycleOscillator4, keyCycleOscillator5, adjustedPosition);
            velocityMatrix.applyTransform(f7, f8, i6, i7, fArr);
            return;
        }
        double adjustedPosition2 = getAdjustedPosition(adjustedPosition, this.mVelocity);
        this.mSpline[0].getSlope(adjustedPosition2, this.mInterpolateVelocity);
        this.mSpline[0].getPos(adjustedPosition2, this.mInterpolateData);
        float f14 = this.mVelocity[0];
        while (true) {
            double[] dArr2 = this.mInterpolateVelocity;
            if (i8 >= dArr2.length) {
                this.mStartMotionPath.setDpDt(f7, f8, fArr, this.mInterpolateVariables, dArr2, this.mInterpolateData);
                velocityMatrix.applyTransform(f7, f8, i6, i7, fArr);
                return;
            } else {
                dArr2[i8] = dArr2[i8] * f14;
                i8++;
            }
        }
    }

    float getStartX() {
        return this.mStartMotionPath.f811x;
    }

    float getStartY() {
        return this.mStartMotionPath.f812y;
    }

    public int getkeyFramePositions(int[] iArr, float[] fArr) {
        Iterator<Key> it = this.mKeyList.iterator();
        int i6 = 0;
        int i7 = 0;
        while (it.hasNext()) {
            Key next = it.next();
            iArr[i6] = (next.mType * 1000) + next.mFramePosition;
            this.mSpline[0].getPos(r6 / 100.0f, this.mInterpolateData);
            this.mStartMotionPath.getCenter(this.mInterpolateVariables, this.mInterpolateData, fArr, i7);
            i7 += 2;
            i6++;
        }
        return i6;
    }

    boolean interpolate(View view, float f6, long j6, KeyCache keyCache) {
        TimeCycleSplineSet.PathRotate pathRotate;
        boolean z5;
        View view2;
        float f7;
        float f8;
        View view3 = view;
        float adjustedPosition = getAdjustedPosition(f6, null);
        HashMap<String, SplineSet> hashMap = this.mAttributesMap;
        if (hashMap != null) {
            Iterator<SplineSet> it = hashMap.values().iterator();
            while (it.hasNext()) {
                it.next().setProperty(view3, adjustedPosition);
            }
        }
        HashMap<String, TimeCycleSplineSet> hashMap2 = this.mTimeCycleAttributesMap;
        if (hashMap2 != null) {
            pathRotate = null;
            boolean z6 = false;
            for (TimeCycleSplineSet timeCycleSplineSet : hashMap2.values()) {
                if (timeCycleSplineSet instanceof TimeCycleSplineSet.PathRotate) {
                    pathRotate = (TimeCycleSplineSet.PathRotate) timeCycleSplineSet;
                } else {
                    z6 |= timeCycleSplineSet.setProperty(view3, adjustedPosition, j6, keyCache);
                    view3 = view;
                }
            }
            z5 = z6;
        } else {
            pathRotate = null;
            z5 = false;
        }
        float f9 = adjustedPosition;
        CurveFit[] curveFitArr = this.mSpline;
        if (curveFitArr != null) {
            double d6 = f9;
            curveFitArr[0].getPos(d6, this.mInterpolateData);
            this.mSpline[0].getSlope(d6, this.mInterpolateVelocity);
            CurveFit curveFit = this.mArcSpline;
            if (curveFit != null) {
                double[] dArr = this.mInterpolateData;
                if (dArr.length > 0) {
                    curveFit.getPos(d6, dArr);
                    this.mArcSpline.getSlope(d6, this.mInterpolateVelocity);
                }
            }
            this.mStartMotionPath.setView(view, this.mInterpolateVariables, this.mInterpolateData, this.mInterpolateVelocity, null);
            HashMap<String, SplineSet> hashMap3 = this.mAttributesMap;
            if (hashMap3 != null) {
                for (SplineSet splineSet : hashMap3.values()) {
                    if (splineSet instanceof SplineSet.PathRotate) {
                        double[] dArr2 = this.mInterpolateVelocity;
                        f8 = f9;
                        ((SplineSet.PathRotate) splineSet).setPathRotate(view, f8, dArr2[0], dArr2[1]);
                    } else {
                        f8 = f9;
                    }
                    f9 = f8;
                }
            }
            f7 = f9;
            if (pathRotate != null) {
                double[] dArr3 = this.mInterpolateVelocity;
                view2 = view;
                boolean pathRotate2 = pathRotate.setPathRotate(view2, keyCache, f7, j6, dArr3[0], dArr3[1]);
                f7 = f7;
                z5 |= pathRotate2;
            } else {
                view2 = view;
            }
            int i6 = 1;
            while (true) {
                CurveFit[] curveFitArr2 = this.mSpline;
                if (i6 >= curveFitArr2.length) {
                    break;
                }
                curveFitArr2[i6].getPos(d6, this.mValuesBuff);
                this.mStartMotionPath.attributes.get(this.mAttributeNames[i6 - 1]).setInterpolatedValue(view2, this.mValuesBuff);
                i6++;
            }
            MotionConstrainedPoint motionConstrainedPoint = this.mStartPoint;
            if (motionConstrainedPoint.mVisibilityMode == 0) {
                if (f7 <= 0.0f) {
                    view2.setVisibility(motionConstrainedPoint.visibility);
                } else if (f7 >= 1.0f) {
                    view2.setVisibility(this.mEndPoint.visibility);
                } else if (this.mEndPoint.visibility != motionConstrainedPoint.visibility) {
                    view2.setVisibility(0);
                }
            }
            if (this.mKeyTriggers != null) {
                int i7 = 0;
                while (true) {
                    KeyTrigger[] keyTriggerArr = this.mKeyTriggers;
                    if (i7 >= keyTriggerArr.length) {
                        break;
                    }
                    keyTriggerArr[i7].conditionallyFire(f7, view2);
                    i7++;
                }
            }
        } else {
            view2 = view;
            f7 = f9;
            MotionPaths motionPaths = this.mStartMotionPath;
            float f10 = motionPaths.f811x;
            MotionPaths motionPaths2 = this.mEndMotionPath;
            float f11 = f10 + ((motionPaths2.f811x - f10) * f7);
            float f12 = motionPaths.f812y;
            float f13 = f12 + ((motionPaths2.f812y - f12) * f7);
            float f14 = motionPaths.width;
            float f15 = motionPaths2.width;
            float f16 = motionPaths.height;
            float f17 = motionPaths2.height;
            float f18 = f11 + 0.5f;
            int i8 = (int) f18;
            float f19 = f13 + 0.5f;
            int i9 = (int) f19;
            int i10 = (int) (f18 + ((f15 - f14) * f7) + f14);
            int i11 = (int) (f19 + ((f17 - f16) * f7) + f16);
            int i12 = i10 - i8;
            int i13 = i11 - i9;
            if (f15 != f14 || f17 != f16) {
                view2.measure(View.MeasureSpec.makeMeasureSpec(i12, 1073741824), View.MeasureSpec.makeMeasureSpec(i13, 1073741824));
            }
            view2.layout(i8, i9, i10, i11);
        }
        HashMap<String, KeyCycleOscillator> hashMap4 = this.mCycleMap;
        if (hashMap4 != null) {
            for (KeyCycleOscillator keyCycleOscillator : hashMap4.values()) {
                if (keyCycleOscillator instanceof KeyCycleOscillator.PathRotateSet) {
                    double[] dArr4 = this.mInterpolateVelocity;
                    ((KeyCycleOscillator.PathRotateSet) keyCycleOscillator).setPathRotate(view2, f7, dArr4[0], dArr4[1]);
                } else {
                    keyCycleOscillator.setProperty(view2, f7);
                }
            }
        }
        return z5;
    }

    String name() {
        return this.mView.getContext().getResources().getResourceEntryName(this.mView.getId());
    }

    void positionKeyframe(View view, KeyPositionBase keyPositionBase, float f6, float f7, String[] strArr, float[] fArr) {
        RectF rectF = new RectF();
        MotionPaths motionPaths = this.mStartMotionPath;
        float f8 = motionPaths.f811x;
        rectF.left = f8;
        float f9 = motionPaths.f812y;
        rectF.top = f9;
        rectF.right = f8 + motionPaths.width;
        rectF.bottom = f9 + motionPaths.height;
        RectF rectF2 = new RectF();
        MotionPaths motionPaths2 = this.mEndMotionPath;
        float f10 = motionPaths2.f811x;
        rectF2.left = f10;
        float f11 = motionPaths2.f812y;
        rectF2.top = f11;
        rectF2.right = f10 + motionPaths2.width;
        rectF2.bottom = f11 + motionPaths2.height;
        keyPositionBase.positionAttributes(view, rectF, rectF2, f6, f7, strArr, fArr);
    }

    public void setDrawPath(int i6) {
        this.mStartMotionPath.mDrawPath = i6;
    }

    void setEndState(ConstraintWidget constraintWidget, ConstraintSet constraintSet) {
        MotionPaths motionPaths = this.mEndMotionPath;
        motionPaths.time = 1.0f;
        motionPaths.position = 1.0f;
        readView(motionPaths);
        this.mEndMotionPath.setBounds(constraintWidget.getX(), constraintWidget.getY(), constraintWidget.getWidth(), constraintWidget.getHeight());
        this.mEndMotionPath.applyParameters(constraintSet.getParameters(this.mId));
        this.mEndPoint.setState(constraintWidget, constraintSet, this.mId);
    }

    public void setPathMotionArc(int i6) {
        this.mPathMotionArc = i6;
    }

    void setStartCurrentState(View view) {
        MotionPaths motionPaths = this.mStartMotionPath;
        motionPaths.time = 0.0f;
        motionPaths.position = 0.0f;
        motionPaths.setBounds(view.getX(), view.getY(), view.getWidth(), view.getHeight());
        this.mStartPoint.setState(view);
    }

    void setStartState(ConstraintWidget constraintWidget, ConstraintSet constraintSet) {
        MotionPaths motionPaths = this.mStartMotionPath;
        motionPaths.time = 0.0f;
        motionPaths.position = 0.0f;
        readView(motionPaths);
        this.mStartMotionPath.setBounds(constraintWidget.getX(), constraintWidget.getY(), constraintWidget.getWidth(), constraintWidget.getHeight());
        ConstraintSet.Constraint parameters = constraintSet.getParameters(this.mId);
        this.mStartMotionPath.applyParameters(parameters);
        this.mMotionStagger = parameters.motion.mMotionStagger;
        this.mStartPoint.setState(constraintWidget, constraintSet, this.mId);
    }

    public void setView(View view) {
        this.mView = view;
        this.mId = view.getId();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.LayoutParams) {
            this.mConstraintTag = ((ConstraintLayout.LayoutParams) layoutParams).getConstraintTag();
        }
    }

    public void setup(int i6, int i7, float f6, long j6) {
        ArrayList arrayList;
        String[] strArr;
        MotionPaths[] motionPathsArr;
        TimeCycleSplineSet makeSpline;
        ConstraintAttribute constraintAttribute;
        SplineSet makeSpline2;
        ConstraintAttribute constraintAttribute2;
        new HashSet();
        HashSet<String> hashSet = new HashSet<>();
        HashSet<String> hashSet2 = new HashSet<>();
        HashSet<String> hashSet3 = new HashSet<>();
        HashMap<String, Integer> hashMap = new HashMap<>();
        int i8 = this.mPathMotionArc;
        if (i8 != Key.UNSET) {
            this.mStartMotionPath.mPathMotionArc = i8;
        }
        this.mStartPoint.different(this.mEndPoint, hashSet2);
        ArrayList<Key> arrayList2 = this.mKeyList;
        if (arrayList2 != null) {
            Iterator<Key> it = arrayList2.iterator();
            arrayList = null;
            while (it.hasNext()) {
                Key next = it.next();
                if (next instanceof KeyPosition) {
                    KeyPosition keyPosition = (KeyPosition) next;
                    insertKey(new MotionPaths(i6, i7, keyPosition, this.mStartMotionPath, this.mEndMotionPath));
                    int i9 = keyPosition.mCurveFit;
                    if (i9 != Key.UNSET) {
                        this.mCurveFitType = i9;
                    }
                } else if (next instanceof KeyCycle) {
                    next.getAttributeNames(hashSet3);
                } else if (next instanceof KeyTimeCycle) {
                    next.getAttributeNames(hashSet);
                } else if (next instanceof KeyTrigger) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add((KeyTrigger) next);
                } else {
                    next.setInterpolation(hashMap);
                    next.getAttributeNames(hashSet2);
                }
            }
        } else {
            arrayList = null;
        }
        char c6 = 0;
        if (arrayList != null) {
            this.mKeyTriggers = (KeyTrigger[]) arrayList.toArray(new KeyTrigger[0]);
        }
        if (!hashSet2.isEmpty()) {
            this.mAttributesMap = new HashMap<>();
            Iterator<String> it2 = hashSet2.iterator();
            while (it2.hasNext()) {
                String next2 = it2.next();
                if (next2.startsWith("CUSTOM,")) {
                    SparseArray sparseArray = new SparseArray();
                    String str = next2.split(",")[1];
                    Iterator<Key> it3 = this.mKeyList.iterator();
                    while (it3.hasNext()) {
                        Key next3 = it3.next();
                        HashMap<String, ConstraintAttribute> hashMap2 = next3.mCustomConstraints;
                        if (hashMap2 != null && (constraintAttribute2 = hashMap2.get(str)) != null) {
                            sparseArray.append(next3.mFramePosition, constraintAttribute2);
                        }
                    }
                    makeSpline2 = SplineSet.makeCustomSpline(next2, sparseArray);
                } else {
                    makeSpline2 = SplineSet.makeSpline(next2);
                }
                if (makeSpline2 != null) {
                    makeSpline2.setType(next2);
                    this.mAttributesMap.put(next2, makeSpline2);
                }
            }
            ArrayList<Key> arrayList3 = this.mKeyList;
            if (arrayList3 != null) {
                Iterator<Key> it4 = arrayList3.iterator();
                while (it4.hasNext()) {
                    Key next4 = it4.next();
                    if (next4 instanceof KeyAttributes) {
                        next4.addValues(this.mAttributesMap);
                    }
                }
            }
            this.mStartPoint.addValues(this.mAttributesMap, 0);
            this.mEndPoint.addValues(this.mAttributesMap, 100);
            for (String str2 : this.mAttributesMap.keySet()) {
                this.mAttributesMap.get(str2).setup(hashMap.containsKey(str2) ? hashMap.get(str2).intValue() : 0);
            }
        }
        if (!hashSet.isEmpty()) {
            if (this.mTimeCycleAttributesMap == null) {
                this.mTimeCycleAttributesMap = new HashMap<>();
            }
            Iterator<String> it5 = hashSet.iterator();
            while (it5.hasNext()) {
                String next5 = it5.next();
                if (!this.mTimeCycleAttributesMap.containsKey(next5)) {
                    if (next5.startsWith("CUSTOM,")) {
                        SparseArray sparseArray2 = new SparseArray();
                        String str3 = next5.split(",")[1];
                        Iterator<Key> it6 = this.mKeyList.iterator();
                        while (it6.hasNext()) {
                            Key next6 = it6.next();
                            HashMap<String, ConstraintAttribute> hashMap3 = next6.mCustomConstraints;
                            if (hashMap3 != null && (constraintAttribute = hashMap3.get(str3)) != null) {
                                sparseArray2.append(next6.mFramePosition, constraintAttribute);
                            }
                        }
                        makeSpline = TimeCycleSplineSet.makeCustomSpline(next5, sparseArray2);
                    } else {
                        makeSpline = TimeCycleSplineSet.makeSpline(next5, j6);
                    }
                    if (makeSpline != null) {
                        makeSpline.setType(next5);
                        this.mTimeCycleAttributesMap.put(next5, makeSpline);
                    }
                }
            }
            ArrayList<Key> arrayList4 = this.mKeyList;
            if (arrayList4 != null) {
                Iterator<Key> it7 = arrayList4.iterator();
                while (it7.hasNext()) {
                    Key next7 = it7.next();
                    if (next7 instanceof KeyTimeCycle) {
                        ((KeyTimeCycle) next7).addTimeValues(this.mTimeCycleAttributesMap);
                    }
                }
            }
            for (String str4 : this.mTimeCycleAttributesMap.keySet()) {
                this.mTimeCycleAttributesMap.get(str4).setup(hashMap.containsKey(str4) ? hashMap.get(str4).intValue() : 0);
            }
        }
        int size = this.mMotionPaths.size();
        int i10 = size + 2;
        MotionPaths[] motionPathsArr2 = new MotionPaths[i10];
        motionPathsArr2[0] = this.mStartMotionPath;
        motionPathsArr2[size + 1] = this.mEndMotionPath;
        if (this.mMotionPaths.size() > 0 && this.mCurveFitType == -1) {
            this.mCurveFitType = 0;
        }
        Iterator<MotionPaths> it8 = this.mMotionPaths.iterator();
        int i11 = 1;
        while (it8.hasNext()) {
            motionPathsArr2[i11] = it8.next();
            i11++;
        }
        HashSet hashSet4 = new HashSet();
        for (String str5 : this.mEndMotionPath.attributes.keySet()) {
            if (this.mStartMotionPath.attributes.containsKey(str5)) {
                if (!hashSet2.contains("CUSTOM," + str5)) {
                    hashSet4.add(str5);
                }
            }
        }
        String[] strArr2 = (String[]) hashSet4.toArray(new String[0]);
        this.mAttributeNames = strArr2;
        this.mAttributeInterpCount = new int[strArr2.length];
        int i12 = 0;
        while (true) {
            strArr = this.mAttributeNames;
            if (i12 >= strArr.length) {
                break;
            }
            String str6 = strArr[i12];
            this.mAttributeInterpCount[i12] = 0;
            int i13 = 0;
            while (true) {
                if (i13 >= i10) {
                    break;
                }
                if (motionPathsArr2[i13].attributes.containsKey(str6)) {
                    int[] iArr = this.mAttributeInterpCount;
                    iArr[i12] = iArr[i12] + motionPathsArr2[i13].attributes.get(str6).noOfInterpValues();
                    break;
                }
                i13++;
            }
            i12++;
        }
        boolean z5 = motionPathsArr2[0].mPathMotionArc != Key.UNSET;
        int length = 18 + strArr.length;
        boolean[] zArr = new boolean[length];
        for (int i14 = 1; i14 < i10; i14++) {
            motionPathsArr2[i14].different(motionPathsArr2[i14 - 1], zArr, this.mAttributeNames, z5);
        }
        int i15 = 0;
        for (int i16 = 1; i16 < length; i16++) {
            if (zArr[i16]) {
                i15++;
            }
        }
        int[] iArr2 = new int[i15];
        this.mInterpolateVariables = iArr2;
        this.mInterpolateData = new double[iArr2.length];
        this.mInterpolateVelocity = new double[iArr2.length];
        int i17 = 0;
        for (int i18 = 1; i18 < length; i18++) {
            if (zArr[i18]) {
                this.mInterpolateVariables[i17] = i18;
                i17++;
            }
        }
        int i19 = 2;
        int[] iArr3 = {i10, this.mInterpolateVariables.length};
        Class cls = Double.TYPE;
        double[][] dArr = (double[][]) Array.newInstance((Class<?>) cls, iArr3);
        double[] dArr2 = new double[i10];
        for (int i20 = 0; i20 < i10; i20++) {
            motionPathsArr2[i20].fillStandard(dArr[i20], this.mInterpolateVariables);
            dArr2[i20] = motionPathsArr2[i20].time;
        }
        int i21 = 0;
        while (true) {
            int[] iArr4 = this.mInterpolateVariables;
            if (i21 >= iArr4.length) {
                break;
            }
            if (iArr4[i21] < MotionPaths.names.length) {
                String str7 = MotionPaths.names[this.mInterpolateVariables[i21]] + " [";
                for (int i22 = 0; i22 < i10; i22++) {
                    str7 = str7 + dArr[i22][i21];
                }
            }
            i21++;
        }
        this.mSpline = new CurveFit[this.mAttributeNames.length + 1];
        int i23 = 0;
        while (true) {
            String[] strArr3 = this.mAttributeNames;
            if (i23 >= strArr3.length) {
                break;
            }
            String str8 = strArr3[i23];
            int i24 = 0;
            double[] dArr3 = null;
            int i25 = 0;
            double[][] dArr4 = null;
            while (i24 < i10) {
                if (motionPathsArr2[i24].hasCustomData(str8)) {
                    if (dArr4 == null) {
                        dArr3 = new double[i10];
                        int[] iArr5 = new int[i19];
                        iArr5[1] = motionPathsArr2[i24].getCustomDataCount(str8);
                        iArr5[c6] = i10;
                        dArr4 = (double[][]) Array.newInstance((Class<?>) cls, iArr5);
                    }
                    MotionPaths motionPaths = motionPathsArr2[i24];
                    motionPathsArr = motionPathsArr2;
                    dArr3[i25] = motionPaths.time;
                    motionPaths.getCustomData(str8, dArr4[i25], 0);
                    i25++;
                } else {
                    motionPathsArr = motionPathsArr2;
                }
                i24++;
                motionPathsArr2 = motionPathsArr;
                i19 = 2;
                c6 = 0;
            }
            i23++;
            this.mSpline[i23] = CurveFit.get(this.mCurveFitType, Arrays.copyOf(dArr3, i25), (double[][]) Arrays.copyOf(dArr4, i25));
            motionPathsArr2 = motionPathsArr2;
            i19 = 2;
            c6 = 0;
        }
        MotionPaths[] motionPathsArr3 = motionPathsArr2;
        this.mSpline[0] = CurveFit.get(this.mCurveFitType, dArr2, dArr);
        if (motionPathsArr3[0].mPathMotionArc != Key.UNSET) {
            int[] iArr6 = new int[i10];
            double[] dArr5 = new double[i10];
            double[][] dArr6 = (double[][]) Array.newInstance((Class<?>) cls, i10, 2);
            for (int i26 = 0; i26 < i10; i26++) {
                iArr6[i26] = motionPathsArr3[i26].mPathMotionArc;
                dArr5[i26] = r7.time;
                double[] dArr7 = dArr6[i26];
                dArr7[0] = r7.f811x;
                dArr7[1] = r7.f812y;
            }
            this.mArcSpline = CurveFit.getArc(iArr6, dArr5, dArr6);
        }
        this.mCycleMap = new HashMap<>();
        if (this.mKeyList != null) {
            Iterator<String> it9 = hashSet3.iterator();
            float f7 = Float.NaN;
            while (it9.hasNext()) {
                String next8 = it9.next();
                KeyCycleOscillator makeSpline3 = KeyCycleOscillator.makeSpline(next8);
                if (makeSpline3 != null) {
                    if (makeSpline3.variesByPath() && Float.isNaN(f7)) {
                        f7 = getPreCycleDistance();
                    }
                    makeSpline3.setType(next8);
                    this.mCycleMap.put(next8, makeSpline3);
                }
            }
            Iterator<Key> it10 = this.mKeyList.iterator();
            while (it10.hasNext()) {
                Key next9 = it10.next();
                if (next9 instanceof KeyCycle) {
                    ((KeyCycle) next9).addCycleValues(this.mCycleMap);
                }
            }
            Iterator<KeyCycleOscillator> it11 = this.mCycleMap.values().iterator();
            while (it11.hasNext()) {
                it11.next().setup(f7);
            }
        }
    }

    public String toString() {
        return " start: x: " + this.mStartMotionPath.f811x + " y: " + this.mStartMotionPath.f812y + " end: x: " + this.mEndMotionPath.f811x + " y: " + this.mEndMotionPath.f812y;
    }

    MotionController(View view) {
        setView(view);
    }
}
