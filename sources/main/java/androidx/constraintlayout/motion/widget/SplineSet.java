package androidx.constraintlayout.motion.widget;

import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.motion.utils.CurveFit;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.core.app.NotificationCompat;
import io.netty.util.internal.StringUtil;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.util.Arrays;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public abstract class SplineSet {
    private static final String TAG = "SplineSet";
    private int count;
    protected CurveFit mCurveFit;
    private String mType;
    protected int[] mTimePoints = new int[10];
    protected float[] mValues = new float[10];

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class CustomSet extends SplineSet {
        String mAttributeName;
        SparseArray<ConstraintAttribute> mConstraintAttributeList;
        float[] mTempValues;

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setPoint(int i6, float f6) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute)");
        }

        public void setPoint(int i6, ConstraintAttribute constraintAttribute) {
            this.mConstraintAttributeList.append(i6, constraintAttribute);
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float f6) {
            this.mCurveFit.getPos(f6, this.mTempValues);
            this.mConstraintAttributeList.valueAt(0).setInterpolatedValue(view, this.mTempValues);
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setup(int i6) {
            int size = this.mConstraintAttributeList.size();
            int noOfInterpValues = this.mConstraintAttributeList.valueAt(0).noOfInterpValues();
            double[] dArr = new double[size];
            this.mTempValues = new float[noOfInterpValues];
            double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, size, noOfInterpValues);
            for (int i7 = 0; i7 < size; i7++) {
                int keyAt = this.mConstraintAttributeList.keyAt(i7);
                ConstraintAttribute valueAt = this.mConstraintAttributeList.valueAt(i7);
                dArr[i7] = keyAt * 0.01d;
                valueAt.getValuesToInterpolate(this.mTempValues);
                int i8 = 0;
                while (true) {
                    if (i8 < this.mTempValues.length) {
                        dArr2[i7][i8] = r6[i8];
                        i8++;
                    }
                }
            }
            this.mCurveFit = CurveFit.get(i6, dArr, dArr2);
        }

        public CustomSet(String str, SparseArray<ConstraintAttribute> sparseArray) {
            this.mAttributeName = str.split(",")[1];
            this.mConstraintAttributeList = sparseArray;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class ProgressSet extends SplineSet {
        boolean mNoMethod = false;

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float f6) {
            Method method;
            if (view instanceof MotionLayout) {
                ((MotionLayout) view).setProgress(get(f6));
                return;
            }
            if (this.mNoMethod) {
                return;
            }
            try {
                method = view.getClass().getMethod("setProgress", Float.TYPE);
            } catch (NoSuchMethodException unused) {
                this.mNoMethod = true;
                method = null;
            }
            if (method != null) {
                try {
                    method.invoke(view, Float.valueOf(get(f6)));
                } catch (IllegalAccessException | InvocationTargetException unused2) {
                }
            }
        }

        ProgressSet() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class Sort {
        static void doubleQuickSort(int[] iArr, float[] fArr, int i6, int i7) {
            int[] iArr2 = new int[iArr.length + 10];
            iArr2[0] = i7;
            iArr2[1] = i6;
            int i8 = 2;
            while (i8 > 0) {
                int i9 = iArr2[i8 - 1];
                int i10 = i8 - 2;
                int i11 = iArr2[i10];
                if (i9 < i11) {
                    int partition = partition(iArr, fArr, i9, i11);
                    iArr2[i10] = partition - 1;
                    iArr2[i8 - 1] = i9;
                    int i12 = i8 + 1;
                    iArr2[i8] = i11;
                    i8 += 2;
                    iArr2[i12] = partition + 1;
                } else {
                    i8 = i10;
                }
            }
        }

        private static int partition(int[] iArr, float[] fArr, int i6, int i7) {
            int i8 = iArr[i7];
            int i9 = i6;
            while (i6 < i7) {
                if (iArr[i6] <= i8) {
                    swap(iArr, fArr, i9, i6);
                    i9++;
                }
                i6++;
            }
            swap(iArr, fArr, i9, i7);
            return i9;
        }

        private static void swap(int[] iArr, float[] fArr, int i6, int i7) {
            int i8 = iArr[i6];
            iArr[i6] = iArr[i7];
            iArr[i7] = i8;
            float f6 = fArr[i6];
            fArr[i6] = fArr[i7];
            fArr[i7] = f6;
        }

        private Sort() {
        }
    }

    public abstract void setProperty(View view, float f6);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class AlphaSet extends SplineSet {
        AlphaSet() {
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float f6) {
            view.setAlpha(get(f6));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class ElevationSet extends SplineSet {
        ElevationSet() {
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float f6) {
            view.setElevation(get(f6));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class PathRotate extends SplineSet {
        PathRotate() {
        }

        public void setPathRotate(View view, float f6, double d6, double d7) {
            view.setRotation(get(f6) + ((float) Math.toDegrees(Math.atan2(d7, d6))));
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float f6) {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class PivotXset extends SplineSet {
        PivotXset() {
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float f6) {
            view.setPivotX(get(f6));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class PivotYset extends SplineSet {
        PivotYset() {
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float f6) {
            view.setPivotY(get(f6));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class RotationSet extends SplineSet {
        RotationSet() {
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float f6) {
            view.setRotation(get(f6));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class RotationXset extends SplineSet {
        RotationXset() {
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float f6) {
            view.setRotationX(get(f6));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class RotationYset extends SplineSet {
        RotationYset() {
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float f6) {
            view.setRotationY(get(f6));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class ScaleXset extends SplineSet {
        ScaleXset() {
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float f6) {
            view.setScaleX(get(f6));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class ScaleYset extends SplineSet {
        ScaleYset() {
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float f6) {
            view.setScaleY(get(f6));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class TranslationXset extends SplineSet {
        TranslationXset() {
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float f6) {
            view.setTranslationX(get(f6));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class TranslationYset extends SplineSet {
        TranslationYset() {
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float f6) {
            view.setTranslationY(get(f6));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class TranslationZset extends SplineSet {
        TranslationZset() {
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float f6) {
            view.setTranslationZ(get(f6));
        }
    }

    static SplineSet makeCustomSpline(String str, SparseArray<ConstraintAttribute> sparseArray) {
        return new CustomSet(str, sparseArray);
    }

    public float get(float f6) {
        return (float) this.mCurveFit.getPos(f6, 0);
    }

    public CurveFit getCurveFit() {
        return this.mCurveFit;
    }

    public float getSlope(float f6) {
        return (float) this.mCurveFit.getSlope(f6, 0);
    }

    public void setPoint(int i6, float f6) {
        int[] iArr = this.mTimePoints;
        if (iArr.length < this.count + 1) {
            this.mTimePoints = Arrays.copyOf(iArr, iArr.length * 2);
            float[] fArr = this.mValues;
            this.mValues = Arrays.copyOf(fArr, fArr.length * 2);
        }
        int[] iArr2 = this.mTimePoints;
        int i7 = this.count;
        iArr2[i7] = i6;
        this.mValues[i7] = f6;
        this.count = i7 + 1;
    }

    public void setType(String str) {
        this.mType = str;
    }

    public void setup(int i6) {
        int i7;
        int i8 = this.count;
        if (i8 == 0) {
            return;
        }
        Sort.doubleQuickSort(this.mTimePoints, this.mValues, 0, i8 - 1);
        int i9 = 1;
        for (int i10 = 1; i10 < this.count; i10++) {
            int[] iArr = this.mTimePoints;
            if (iArr[i10 - 1] != iArr[i10]) {
                i9++;
            }
        }
        double[] dArr = new double[i9];
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, i9, 1);
        int i11 = 0;
        while (i7 < this.count) {
            if (i7 > 0) {
                int[] iArr2 = this.mTimePoints;
                i7 = iArr2[i7] == iArr2[i7 + (-1)] ? i7 + 1 : 0;
            }
            dArr[i11] = this.mTimePoints[i7] * 0.01d;
            dArr2[i11][0] = this.mValues[i7];
            i11++;
        }
        this.mCurveFit = CurveFit.get(i6, dArr, dArr2);
    }

    public String toString() {
        String str = this.mType;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        for (int i6 = 0; i6 < this.count; i6++) {
            str = str + "[" + this.mTimePoints[i6] + " , " + decimalFormat.format(this.mValues[i6]) + "] ";
        }
        return str;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    static SplineSet makeSpline(String str) {
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
            case -797520672:
                if (str.equals("waveVariesBy")) {
                    c6 = '\b';
                    break;
                }
                break;
            case -760884510:
                if (str.equals("transformPivotX")) {
                    c6 = '\t';
                    break;
                }
                break;
            case -760884509:
                if (str.equals("transformPivotY")) {
                    c6 = '\n';
                    break;
                }
                break;
            case -40300674:
                if (str.equals("rotation")) {
                    c6 = 11;
                    break;
                }
                break;
            case -4379043:
                if (str.equals("elevation")) {
                    c6 = '\f';
                    break;
                }
                break;
            case 37232917:
                if (str.equals("transitionPathRotate")) {
                    c6 = StringUtil.CARRIAGE_RETURN;
                    break;
                }
                break;
            case 92909918:
                if (str.equals("alpha")) {
                    c6 = 14;
                    break;
                }
                break;
            case 156108012:
                if (str.equals("waveOffset")) {
                    c6 = 15;
                    break;
                }
                break;
        }
        switch (c6) {
        }
        return new AlphaSet();
    }
}
