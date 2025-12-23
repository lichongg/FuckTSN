package androidx.constraintlayout.motion.widget;

import android.view.View;
import androidx.constraintlayout.motion.utils.Easing;
import androidx.constraintlayout.motion.widget.SplineSet;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.app.NotificationCompat;
import io.netty.util.internal.StringUtil;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Objects;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
class MotionConstrainedPoint implements Comparable<MotionConstrainedPoint> {
    static final int CARTESIAN = 2;
    public static final boolean DEBUG = false;
    static final int PERPENDICULAR = 1;
    public static final String TAG = "MotionPaths";
    static String[] names = {"position", "x", "y", "width", "height", "pathRotate"};
    private float height;
    private Easing mKeyFrameEasing;
    private float position;
    int visibility;
    private float width;

    /* renamed from: x, reason: collision with root package name */
    private float f809x;

    /* renamed from: y, reason: collision with root package name */
    private float f810y;
    private float alpha = 1.0f;
    int mVisibilityMode = 0;
    private boolean applyElevation = false;
    private float elevation = 0.0f;
    private float rotation = 0.0f;
    private float rotationX = 0.0f;
    public float rotationY = 0.0f;
    private float scaleX = 1.0f;
    private float scaleY = 1.0f;
    private float mPivotX = Float.NaN;
    private float mPivotY = Float.NaN;
    private float translationX = 0.0f;
    private float translationY = 0.0f;
    private float translationZ = 0.0f;
    private int mDrawPath = 0;
    private float mPathRotate = Float.NaN;
    private float mProgress = Float.NaN;
    LinkedHashMap<String, ConstraintAttribute> attributes = new LinkedHashMap<>();
    int mMode = 0;
    double[] mTempValue = new double[18];
    double[] mTempDelta = new double[18];

    public void applyParameters(View view) {
        this.visibility = view.getVisibility();
        this.alpha = view.getVisibility() != 0 ? 0.0f : view.getAlpha();
        this.applyElevation = false;
        this.elevation = view.getElevation();
        this.rotation = view.getRotation();
        this.rotationX = view.getRotationX();
        this.rotationY = view.getRotationY();
        this.scaleX = view.getScaleX();
        this.scaleY = view.getScaleY();
        this.mPivotX = view.getPivotX();
        this.mPivotY = view.getPivotY();
        this.translationX = view.getTranslationX();
        this.translationY = view.getTranslationY();
        this.translationZ = view.getTranslationZ();
    }

    void different(MotionConstrainedPoint motionConstrainedPoint, HashSet<String> hashSet) {
        if (diff(this.alpha, motionConstrainedPoint.alpha)) {
            hashSet.add("alpha");
        }
        if (diff(this.elevation, motionConstrainedPoint.elevation)) {
            hashSet.add("elevation");
        }
        int i6 = this.visibility;
        int i7 = motionConstrainedPoint.visibility;
        if (i6 != i7 && this.mVisibilityMode == 0 && (i6 == 0 || i7 == 0)) {
            hashSet.add("alpha");
        }
        if (diff(this.rotation, motionConstrainedPoint.rotation)) {
            hashSet.add("rotation");
        }
        if (!Float.isNaN(this.mPathRotate) || !Float.isNaN(motionConstrainedPoint.mPathRotate)) {
            hashSet.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.mProgress) || !Float.isNaN(motionConstrainedPoint.mProgress)) {
            hashSet.add(NotificationCompat.CATEGORY_PROGRESS);
        }
        if (diff(this.rotationX, motionConstrainedPoint.rotationX)) {
            hashSet.add("rotationX");
        }
        if (diff(this.rotationY, motionConstrainedPoint.rotationY)) {
            hashSet.add("rotationY");
        }
        if (diff(this.mPivotX, motionConstrainedPoint.mPivotX)) {
            hashSet.add("transformPivotX");
        }
        if (diff(this.mPivotY, motionConstrainedPoint.mPivotY)) {
            hashSet.add("transformPivotY");
        }
        if (diff(this.scaleX, motionConstrainedPoint.scaleX)) {
            hashSet.add("scaleX");
        }
        if (diff(this.scaleY, motionConstrainedPoint.scaleY)) {
            hashSet.add("scaleY");
        }
        if (diff(this.translationX, motionConstrainedPoint.translationX)) {
            hashSet.add("translationX");
        }
        if (diff(this.translationY, motionConstrainedPoint.translationY)) {
            hashSet.add("translationY");
        }
        if (diff(this.translationZ, motionConstrainedPoint.translationZ)) {
            hashSet.add("translationZ");
        }
    }

    public void setState(View view) {
        setBounds(view.getX(), view.getY(), view.getWidth(), view.getHeight());
        applyParameters(view);
    }

    @Override // java.lang.Comparable
    public int compareTo(MotionConstrainedPoint motionConstrainedPoint) {
        return Float.compare(this.position, motionConstrainedPoint.position);
    }

    void fillStandard(double[] dArr, int[] iArr) {
        int i6 = 0;
        float[] fArr = {this.position, this.f809x, this.f810y, this.width, this.height, this.alpha, this.elevation, this.rotation, this.rotationX, this.rotationY, this.scaleX, this.scaleY, this.mPivotX, this.mPivotY, this.translationX, this.translationY, this.translationZ, this.mPathRotate};
        for (int i7 : iArr) {
            if (i7 < 18) {
                dArr[i6] = fArr[r4];
                i6++;
            }
        }
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

    boolean hasCustomData(String str) {
        return this.attributes.containsKey(str);
    }

    void setBounds(float f6, float f7, float f8, float f9) {
        this.f809x = f6;
        this.f810y = f7;
        this.width = f8;
        this.height = f9;
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

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public void addValues(HashMap<String, SplineSet> hashMap, int i6) {
        for (String str : hashMap.keySet()) {
            SplineSet splineSet = hashMap.get(str);
            str.getClass();
            char c6 = 65535;
            switch (str.hashCode()) {
                case -1249320806:
                    if (str.equals("rotationX")) {
                        c6 = 0;
                        break;
                    }
                    break;
                case -1249320805:
                    if (str.equals("rotationY")) {
                        c6 = 1;
                        break;
                    }
                    break;
                case -1225497657:
                    if (str.equals("translationX")) {
                        c6 = 2;
                        break;
                    }
                    break;
                case -1225497656:
                    if (str.equals("translationY")) {
                        c6 = 3;
                        break;
                    }
                    break;
                case -1225497655:
                    if (str.equals("translationZ")) {
                        c6 = 4;
                        break;
                    }
                    break;
                case -1001078227:
                    if (str.equals(NotificationCompat.CATEGORY_PROGRESS)) {
                        c6 = 5;
                        break;
                    }
                    break;
                case -908189618:
                    if (str.equals("scaleX")) {
                        c6 = 6;
                        break;
                    }
                    break;
                case -908189617:
                    if (str.equals("scaleY")) {
                        c6 = 7;
                        break;
                    }
                    break;
                case -760884510:
                    if (str.equals("transformPivotX")) {
                        c6 = '\b';
                        break;
                    }
                    break;
                case -760884509:
                    if (str.equals("transformPivotY")) {
                        c6 = '\t';
                        break;
                    }
                    break;
                case -40300674:
                    if (str.equals("rotation")) {
                        c6 = '\n';
                        break;
                    }
                    break;
                case -4379043:
                    if (str.equals("elevation")) {
                        c6 = 11;
                        break;
                    }
                    break;
                case 37232917:
                    if (str.equals("transitionPathRotate")) {
                        c6 = '\f';
                        break;
                    }
                    break;
                case 92909918:
                    if (str.equals("alpha")) {
                        c6 = StringUtil.CARRIAGE_RETURN;
                        break;
                    }
                    break;
            }
            float f6 = 1.0f;
            float f7 = 0.0f;
            switch (c6) {
                case 0:
                    if (!Float.isNaN(this.rotationX)) {
                        f7 = this.rotationX;
                    }
                    splineSet.setPoint(i6, f7);
                    break;
                case 1:
                    if (!Float.isNaN(this.rotationY)) {
                        f7 = this.rotationY;
                    }
                    splineSet.setPoint(i6, f7);
                    break;
                case 2:
                    if (!Float.isNaN(this.translationX)) {
                        f7 = this.translationX;
                    }
                    splineSet.setPoint(i6, f7);
                    break;
                case 3:
                    if (!Float.isNaN(this.translationY)) {
                        f7 = this.translationY;
                    }
                    splineSet.setPoint(i6, f7);
                    break;
                case 4:
                    if (!Float.isNaN(this.translationZ)) {
                        f7 = this.translationZ;
                    }
                    splineSet.setPoint(i6, f7);
                    break;
                case 5:
                    if (!Float.isNaN(this.mProgress)) {
                        f7 = this.mProgress;
                    }
                    splineSet.setPoint(i6, f7);
                    break;
                case 6:
                    if (!Float.isNaN(this.scaleX)) {
                        f6 = this.scaleX;
                    }
                    splineSet.setPoint(i6, f6);
                    break;
                case 7:
                    if (!Float.isNaN(this.scaleY)) {
                        f6 = this.scaleY;
                    }
                    splineSet.setPoint(i6, f6);
                    break;
                case '\b':
                    if (!Float.isNaN(this.mPivotX)) {
                        f7 = this.mPivotX;
                    }
                    splineSet.setPoint(i6, f7);
                    break;
                case '\t':
                    if (!Float.isNaN(this.mPivotY)) {
                        f7 = this.mPivotY;
                    }
                    splineSet.setPoint(i6, f7);
                    break;
                case '\n':
                    if (!Float.isNaN(this.rotation)) {
                        f7 = this.rotation;
                    }
                    splineSet.setPoint(i6, f7);
                    break;
                case 11:
                    if (!Float.isNaN(this.elevation)) {
                        f7 = this.elevation;
                    }
                    splineSet.setPoint(i6, f7);
                    break;
                case '\f':
                    if (!Float.isNaN(this.mPathRotate)) {
                        f7 = this.mPathRotate;
                    }
                    splineSet.setPoint(i6, f7);
                    break;
                case '\r':
                    if (!Float.isNaN(this.alpha)) {
                        f6 = this.alpha;
                    }
                    splineSet.setPoint(i6, f6);
                    break;
                default:
                    if (str.startsWith("CUSTOM")) {
                        String str2 = str.split(",")[1];
                        if (this.attributes.containsKey(str2)) {
                            ConstraintAttribute constraintAttribute = this.attributes.get(str2);
                            if (splineSet instanceof SplineSet.CustomSet) {
                                ((SplineSet.CustomSet) splineSet).setPoint(i6, constraintAttribute);
                                break;
                            } else {
                                constraintAttribute.getValueToInterpolate();
                                Objects.toString(splineSet);
                                break;
                            }
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
            }
        }
    }

    public void setState(ConstraintWidget constraintWidget, ConstraintSet constraintSet, int i6) {
        setBounds(constraintWidget.getX(), constraintWidget.getY(), constraintWidget.getWidth(), constraintWidget.getHeight());
        applyParameters(constraintSet.getParameters(i6));
    }

    public void applyParameters(ConstraintSet.Constraint constraint) {
        ConstraintSet.PropertySet propertySet = constraint.propertySet;
        int i6 = propertySet.mVisibilityMode;
        this.mVisibilityMode = i6;
        int i7 = propertySet.visibility;
        this.visibility = i7;
        this.alpha = (i7 == 0 || i6 != 0) ? propertySet.alpha : 0.0f;
        ConstraintSet.Transform transform = constraint.transform;
        this.applyElevation = transform.applyElevation;
        this.elevation = transform.elevation;
        this.rotation = transform.rotation;
        this.rotationX = transform.rotationX;
        this.rotationY = transform.rotationY;
        this.scaleX = transform.scaleX;
        this.scaleY = transform.scaleY;
        this.mPivotX = transform.transformPivotX;
        this.mPivotY = transform.transformPivotY;
        this.translationX = transform.translationX;
        this.translationY = transform.translationY;
        this.translationZ = transform.translationZ;
        this.mKeyFrameEasing = Easing.getInterpolator(constraint.motion.mTransitionEasing);
        ConstraintSet.Motion motion = constraint.motion;
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

    void different(MotionConstrainedPoint motionConstrainedPoint, boolean[] zArr, String[] strArr) {
        zArr[0] = zArr[0] | diff(this.position, motionConstrainedPoint.position);
        zArr[1] = zArr[1] | diff(this.f809x, motionConstrainedPoint.f809x);
        zArr[2] = zArr[2] | diff(this.f810y, motionConstrainedPoint.f810y);
        zArr[3] = zArr[3] | diff(this.width, motionConstrainedPoint.width);
        zArr[4] = diff(this.height, motionConstrainedPoint.height) | zArr[4];
    }
}
